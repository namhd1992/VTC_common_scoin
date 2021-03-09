/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jul 8, 2019
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuyCardScoinResponse {

    private String responseCode;

    private String orgTransId;
    
    private String VTCTransId;

    private String partnerBalance;

    private String dataSign;

}
