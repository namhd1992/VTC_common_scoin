/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jul 12, 2019
 */
@Getter
@Setter
@NoArgsConstructor
public class AddItemTuDoRequest {

    @JsonProperty("api_key")
    private String    apiKey;

    @JsonProperty("accountid")
    private Long      scoinId;

    @JsonProperty("itemid")
    private int       itemId;

    private String    description;

    private Long      time;

    private String    sign;

}
