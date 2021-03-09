/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.service;

import com.vtc.common.dto.response.GetCardScoinResponse;
import com.vtc.gateway.scoinv2api.common.dao.entity.FundsCardScoin;
import com.vtc.gateway.scoinv2api.common.dto.request.TopupCardUserHistoryGet;
import com.vtc.gateway.scoinv2api.common.exception.ScoinBusinessException;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jul 9, 2019
 */
public interface CardScoinService extends AbstractInterfaceService<FundsCardScoin, Long> {
    
    public FundsCardScoin buyCard(String valueCard, Integer quantity) throws ScoinBusinessException;
    
    public GetCardScoinResponse getCard(String valueCard, String VTCTranID) throws ScoinBusinessException;
    
    public String saveTopupCardUserHistory(TopupCardUserHistoryGet request);
    
}
