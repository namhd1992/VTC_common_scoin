/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dto.response;

import com.vtc.common.dto.response.UserXuInfoResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * May 14, 2019
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServerXUScoinResponse {
    
    private Boolean            status;

    private Long               error_code;

    private String             error_desc;

    private UserXuInfoResponse data;

}
