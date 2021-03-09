/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * May 16, 2019
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LuckySpinAdminItemRequest {
    
    private Long itemId;

    private int  quantity;

    private int  position;

}
