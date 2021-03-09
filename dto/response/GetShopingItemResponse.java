/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dto.response;

import com.vtc.gateway.scoinv2api.common.dao.entity.ShopItemPro;
import com.vtc.gateway.scoinv2api.common.dao.entity.ShopingItem;

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
public class GetShopingItemResponse {

    private ShopingItem shopingItem;

    private ShopItemPro promotion;

}
