/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dto.request;

import java.util.List;

import com.vtc.common.dto.request.AbstractResquest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Apr 25, 2019
 */
@Getter
@Setter
@NoArgsConstructor
public class ShopingItemGetRequest extends AbstractResquest {

    private long         shopId;

    private long         promotionId;

    private long         itemId;

    private List<String> filter;

    private String       filterType;

    private int          itemType;

    private String       searchValue;

}
