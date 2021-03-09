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
 * Jun 18, 2019
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SpinHistoryGetLuckyResponse {
    
    private String date;
    
    private String UserName;
    
    private String itemName;
    
    private String description;
    
}
