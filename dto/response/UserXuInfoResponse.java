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
 * May 14, 2019
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserXuInfoResponse {
    
    private long TotalBalance;

    private long PaymentBalance;

    private long PromoBalance;

}
