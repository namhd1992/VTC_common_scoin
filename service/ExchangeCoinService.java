/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.service;

import java.util.Date;
import java.util.List;

import com.vtc.common.dto.request.XuExchangeRequest;
import com.vtc.common.dto.response.TopupCardHistoryResponse;
import com.vtc.common.dto.response.UserXuInfoResponse;
import com.vtc.gateway.scoinv2api.common.exception.ScoinBusinessException;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * May 14, 2019
 */
public interface ExchangeCoinService {

    UserXuInfoResponse getBalanceXu(Long scoinId) throws ScoinBusinessException;
    
    UserXuInfoResponse exchangeXu(XuExchangeRequest request, String type)
            throws ScoinBusinessException;
    
    List<TopupCardHistoryResponse> getTopupCardHistory(String scoinToken, Date topupDate, Long serviceId);

}
