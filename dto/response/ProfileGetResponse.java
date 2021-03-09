/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dto.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jul 14, 2019
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileGetResponse {
  
    private Long     userId;

    private String  fullName;

    private String  urlAvatar;

    private int     balance;

    private long    accountNumber;

    private Date    birthday;

    private String  phoneNumber;

    private long     scoinBalance;

    private long    balanceXU;

    private long    splayPoint;

    private int     vipLevel;

    private long    numberInboxUnread;

    private long    numberMissionUnFinish;

    private boolean checkinToday;

    private String  email;

    private int     numberInboxShop = 0;

}
