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
@AllArgsConstructor
@NoArgsConstructor
public class ScoinBasicResponse<R> {
    
    @JsonProperty("_code")
    private int                                      code;

    @JsonProperty("_data")
    private R data;

    @JsonProperty("_message")
    private String                                   message;

}
