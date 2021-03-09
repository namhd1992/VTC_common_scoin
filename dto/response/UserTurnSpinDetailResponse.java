/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dto.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * May 9, 2019
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserTurnSpinDetailResponse implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long               userId;

    private Long              spinId;

    private int               turnsBuy;

    private long               turnsFree;

    private Long               balanceLP;

    private String            currName;

    private Long              rewardPoint;
    
}
