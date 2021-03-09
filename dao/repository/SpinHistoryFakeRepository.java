/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtc.gateway.scoinv2api.common.dao.entity.SpinHistoryFake;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jul 26, 2019
 */
@Repository
public interface SpinHistoryFakeRepository extends JpaRepository<SpinHistoryFake, Long> {

}
