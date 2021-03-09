/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtc.gateway.scoinv2api.common.dao.entity.ShopItemPro;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Apr 25, 2019
 */
@Repository
public interface ShopItemProRepository extends JpaRepository<ShopItemPro, Long> {

    Optional<ShopItemPro> findByShopItem(long ShopingItemId);

}
