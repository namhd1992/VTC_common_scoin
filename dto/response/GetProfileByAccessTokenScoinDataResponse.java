/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jul 14, 2019
 */
@Getter
@Setter
@NoArgsConstructor
public class GetProfileByAccessTokenScoinDataResponse {
    
    private String accountFullname;

    private Long   accountId;

    private String accountJoined;

    private String accountName;

    private String address;

    private String email;

    private String facebookEmail;

    private String facebookGender;

    private Long   facebookId;

    private String facebookName;

    private String fbUserName;

    private int    gender;

    private String googleEmail;

    private int    googleGender;

    private String googleId;

    private String googleName;

    private Long   locationID;

    private String mobile;

    private int    status;

    private String vtcAccountName;

    private Long   vtcId;

    private String yahooEmail;

    private int    yahooGender;

    private String yahooId;

    private String yahooName;

}
