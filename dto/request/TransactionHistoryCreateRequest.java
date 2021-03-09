/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dto.request;

import com.vtc.gateway.scoinv2api.common.dao.entity.UserInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jun 5, 2019
 */
@Setter
@Getter
@NoArgsConstructor
public class TransactionHistoryCreateRequest {
    
    private UserInfo userInfo;

    private long     amount;

    private String   dataRequest;

    private long     balanceBefore;

    private long     balanceAfter;

    private String   serviceType;

    private String   sourceType;

    private String   status;

}
