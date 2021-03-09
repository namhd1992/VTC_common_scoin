/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.service;

import com.vtc.common.dto.request.TransactionHistoryCreateRequest;
import com.vtc.gateway.scoinv2api.common.dao.entity.TransactionHistory;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jun 5, 2019
 */
public interface TransactionHistoryService
        extends AbstractInterfaceService<TransactionHistory, Long> {
    
    TransactionHistory createTransactionHistory(TransactionHistoryCreateRequest request);

}
