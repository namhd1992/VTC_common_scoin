/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtc.gateway.scoinv2api.common.dao.entity.ItemOfSpin;
import com.vtc.gateway.scoinv2api.common.dao.entity.LuckySpin;
import com.vtc.gateway.scoinv2api.common.dao.entity.SpinItem;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * May 7, 2019
 */
@Repository
public interface SpinItemRepository extends JpaRepository<SpinItem, Long> {
    
    Optional<SpinItem> findBySpintAndItem(LuckySpin luckySpin, ItemOfSpin itemOfSpin);

}
