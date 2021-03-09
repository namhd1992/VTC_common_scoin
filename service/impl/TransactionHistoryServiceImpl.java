/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.service.impl;

import org.springframework.stereotype.Service;

import com.vtc.common.constant.Constant;
import com.vtc.common.dto.request.TransactionHistoryCreateRequest;
import com.vtc.gateway.scoinv2api.common.dao.entity.TransactionHistory;
import com.vtc.gateway.scoinv2api.common.dao.repository.TransactionHistoryRepository;
import com.vtc.gateway.scoinv2api.common.exception.ScoinFailedToExecuteException;
import com.vtc.gateway.scoinv2api.common.service.AbstractService;
import com.vtc.gateway.scoinv2api.common.service.TransactionHistoryService;
import com.vtc.gateway.scoinv2api.common.utils.StringUtils;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jun 5, 2019
 */
@Service("transactionHistoryService")
public class TransactionHistoryServiceImpl
        extends AbstractService<TransactionHistory, Long, TransactionHistoryRepository>
        implements TransactionHistoryService {

    @Override
    public TransactionHistory createTransactionHistory(TransactionHistoryCreateRequest request) {
        TransactionHistory transactionHistory = new TransactionHistory();
        transactionHistory.setSender(request.getUserInfo());
        transactionHistory.setReceiver(null);
        transactionHistory.setServiceType(request.getServiceType());
        transactionHistory.setSourceType(request.getSourceType());
        transactionHistory.setInputAmount(request.getAmount());
        transactionHistory.setAmount(request.getAmount());
        transactionHistory.setFee(0);
        transactionHistory.setPromotion(0);
        transactionHistory.setTotalAmount(request.getAmount());
        transactionHistory.setCurrency(Constant.LEAGUE_CURRENCY);
        transactionHistory.setDataRequest(request.getDataRequest());
        transactionHistory.setBalanceBefore(request.getBalanceBefore());
        transactionHistory.setBalanceAfter(request.getBalanceAfter());
        String status = StringUtils.isEmpty(request.getStatus()) 
                ? Constant.STATUS_SUCCESS
                : request.getStatus();
        transactionHistory.setStatus(status);

        TransactionHistory createTrans = save(transactionHistory).orElseThrow(
                () -> new ScoinFailedToExecuteException("Don't create transaction history"));

        return createTrans;
    }
    

}
