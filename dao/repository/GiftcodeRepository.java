/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtc.gateway.scoinv2api.common.dao.entity.Giftcode;
import com.vtc.gateway.scoinv2api.common.dao.entity.ItemOfSpin;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * May 28, 2019
 */
@Repository
public interface GiftcodeRepository extends JpaRepository<Giftcode, Long> {
    
    List<Giftcode> findByItemSpinAndUserLostIsNullAndDeviceIDIsNull(ItemOfSpin itemSpin);

}
