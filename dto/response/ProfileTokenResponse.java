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
@Setter
@Getter
@NoArgsConstructor
public class ProfileTokenResponse {

    private Long   userInfoId;

    private Long   scoinId;

    private String userName;

    private String email;

    private String phoneNumber;
    
    private String role;

}
