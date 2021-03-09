/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class GetAccessTokenScoinResponse {

    @JsonProperty("access_token")
    private String accessToken;

    private String code;

    @JsonProperty("User")
    private String user;

    @JsonProperty("UserId")
    private String userId;

    private String expires;

}
