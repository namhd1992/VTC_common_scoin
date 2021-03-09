/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dto.response;

import lombok.NoArgsConstructor;

import lombok.Setter;

import lombok.Getter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jul 14, 2019
 */
@Getter
@Setter
@NoArgsConstructor
public class SigninScoinResponse {

    private String  access_token;

    private String  scoinAccessToken;

    private boolean firstLogin;

    private String  fullName;

    private Long    id;

    private String  token_type;

    private String  urlAvatar;

    private String  email;

    private String  username;

}
