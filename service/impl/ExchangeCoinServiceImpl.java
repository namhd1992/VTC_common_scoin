/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.vtc.common.constant.Constant;
import com.vtc.common.constant.ExceptionConstant;
import com.vtc.common.constant.MessageConstant;
import com.vtc.common.dto.request.XuExchangeRequest;
import com.vtc.common.dto.response.ServerXUScoinResponse;
import com.vtc.common.dto.response.TopupCardHistoryResponse;
import com.vtc.common.dto.response.UserXuInfoResponse;
import com.vtc.gateway.scoinv2api.common.EnvironmentKey;
import com.vtc.gateway.scoinv2api.common.dao.entity.TransactionHistory;
import com.vtc.gateway.scoinv2api.common.dao.repository.TransactionHistoryRepository;
import com.vtc.gateway.scoinv2api.common.exception.ScoinBusinessException;
import com.vtc.gateway.scoinv2api.common.exception.ScoinFailedToExecuteException;
import com.vtc.gateway.scoinv2api.common.exception.ScoinInvalidDataRequestException;
import com.vtc.gateway.scoinv2api.common.service.AbstractService;
import com.vtc.gateway.scoinv2api.common.service.ExchangeCoinService;
import com.vtc.gateway.scoinv2api.common.utils.ApiExchangeServiceUtil;
import com.vtc.gateway.scoinv2api.common.utils.DateUtils;
import com.vtc.gateway.scoinv2api.common.utils.StringUtils;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * May 14, 2019
 */
@Service("exchangeMoneyScoinService")
public class ExchangeCoinServiceImpl
        extends AbstractService<TransactionHistory, Long, TransactionHistoryRepository>
        implements ExchangeCoinService {
    
  private static String SANDBOX_XU_API_URL;
  private static String SANDBOX_XU_API_KEY;
  private static String SANDBOX_XU_SECRET_KEY;
  private static String TOPUP_CARD_HISTORY_API_URL;
  private static String TOPUP_CARD_HISTORY_API_KEY;
  
//  private static String              LIVE_XU_API_URL;
//  private static String              LIVE_XU_API_KEY;
//  private static String              LIVE_XU_SECRET_KEY;
    
  public ExchangeCoinServiceImpl(Environment env) {
      SANDBOX_XU_API_URL = env.getProperty(EnvironmentKey.SANDBOX_XU_API_URL.getKey());
      SANDBOX_XU_API_KEY = env.getProperty(EnvironmentKey.SANDBOX_XU_API_KEY.getKey());
      SANDBOX_XU_SECRET_KEY = env.getProperty(EnvironmentKey.SANDBOX_XU_SECRET_KEY.getKey());
      TOPUP_CARD_HISTORY_API_URL = env.getProperty(EnvironmentKey.TOPUP_CARD_HISTORY_API_URL.getKey());
      TOPUP_CARD_HISTORY_API_KEY = env.getProperty(EnvironmentKey.TOPUP_CARD_HISTORY_API_KEY.getKey());
    
    
//        LIVE_XU_API_URL = env.getProperty(EnvironmentKey.LIVE_XU_API_URL.getKey());
//        LIVE_XU_API_KEY = env.getProperty(EnvironmentKey.LIVE_XU_API_KEY.getKey());
//        LIVE_XU_SECRET_KEY = env.getProperty(EnvironmentKey.LIVE_XU_SECRET_KEY.getKey());
  }

    @Override
    public UserXuInfoResponse getBalanceXu(Long scoinId) throws ScoinBusinessException {
        if (ObjectUtils.isEmpty(scoinId)) throw new ScoinInvalidDataRequestException();
        
        Long unixTime = new Date().getTime();
        String sign = StringUtils.toMD5(SANDBOX_XU_SECRET_KEY + scoinId + unixTime);
        String url = SANDBOX_XU_API_URL + "GetBalanceDt"
                     + "?api_key=" + SANDBOX_XU_API_KEY 
                     + "&scoin_id=" + scoinId 
                     + "&time=" + unixTime
                     + "&sign=" + sign;
        
        ServerXUScoinResponse response = ApiExchangeServiceUtil.get(url,
                new TypeReference<ServerXUScoinResponse>() {});
        if (ObjectUtils.isEmpty(response)
                || response.getError_code() < ExceptionConstant.STATUS_CODE_SUCCESSFUL_XU) {
          throw new ScoinFailedToExecuteException(response.getError_desc());
        }
        return response.getData();
    }

    @Override
    public UserXuInfoResponse exchangeXu(XuExchangeRequest request, String type)
            throws ScoinBusinessException {
        if (StringUtils.isEmpty(type)
                || ObjectUtils.isEmpty(request)
                || ObjectUtils.isEmpty(request.getScoin_id())
                || ObjectUtils.isEmpty(request.getAmount())
                || StringUtils.isEmpty(request.getContent())
                || ObjectUtils.isEmpty(request.getTransid())) {
            return null;
        }

        Long unixTime = new Date().getTime();
        String token = request.getScoin_id() +"@" + unixTime.toString();
        String sign = StringUtils.toMD5(SANDBOX_XU_SECRET_KEY 
                                        + request.getScoin_id()
                                        + request.getTransid()
                                        + request.getAmount()
                                        + token
                                        + unixTime);
        
        request.setApi_key(SANDBOX_XU_API_KEY);
        request.setToken(token);
        request.setTime(unixTime);
        request.setSign(sign);
        String url = null;
        if (type.equals(Constant.XU_TOPUP)) url = SANDBOX_XU_API_URL + "CDt";
        if (type.equals(Constant.XU_DEDUCT)) {
            UserXuInfoResponse balanceXU = getBalanceXu(request.getScoin_id());
            if (ObjectUtils.isEmpty(balanceXU)
                    && request.getAmount() > balanceXU.getTotalBalance()) {
                throw new ScoinInvalidDataRequestException(MessageConstant.INVALID_PARKAGE_XU);
            }
            url = SANDBOX_XU_API_URL + "TDt";
        }
        
        if (StringUtils.isEmpty(type)) return new UserXuInfoResponse();
        
        ServerXUScoinResponse response = ApiExchangeServiceUtil
            .post(url, request, new TypeReference<ServerXUScoinResponse>() {});
        if (ObjectUtils.isEmpty(response)
                || response.getError_code() < ExceptionConstant.STATUS_CODE_SUCCESSFUL_XU) {
          throw new ScoinFailedToExecuteException(response.getError_desc());
        }
        return response.getData();
    }

    @Override
    public List<TopupCardHistoryResponse> getTopupCardHistory(String scoinToken, Date topupDate, Long serviceId) {
        if (StringUtils.isEmpty(scoinToken)
                || ObjectUtils.isEmpty(topupDate)) {
            throw new ScoinInvalidDataRequestException();
        }
        
        String url = TOPUP_CARD_HISTORY_API_URL
                + "?api_key=" + TOPUP_CARD_HISTORY_API_KEY
                + "&access_token=" + scoinToken
                + "&service_id=" + serviceId.toString()
                + "&date=" + DateUtils.toStringFormDate(topupDate, DateUtils.DATE_DEFAULT_SCOIN);
        List<TopupCardHistoryResponse> response = ApiExchangeServiceUtil.get(url,
                new TypeReference<List<TopupCardHistoryResponse>>() {});
        return response;
    }

}
