/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jul 15, 2019
 */
@Setter
@Getter
@NoArgsConstructor
public class ScoinBalanceScoinDataResponse {

    @JsonProperty("GameBalance")
    private Long gameBalance;

    @JsonProperty("ResponseStatus")
    private Long responseStatus;

    @JsonProperty("TotalGameBalance")
    private Long totalGameBalance;

    @JsonProperty("Vcoin")
    private Long vcoin;

    @JsonProperty("VcoinBalance")
    private Long vcoinBalance;

}
