/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Nov 14, 2018
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class XuExchangeRequest {

    private String api_key;

    private Long   scoin_id;

    private Long   amount;

    private String content;

    private Long   transid;

    private String token;

    private Long   time;

    private String sign;

}
