/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtc.gateway.scoinv2api.common.dao.entity.ItemOfSpin;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * May 7, 2019
 */
@Repository
public interface ItemOfSpinRepository extends JpaRepository<ItemOfSpin, Long> {

}
