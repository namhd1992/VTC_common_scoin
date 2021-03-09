/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vtc.gateway.scoinv2api.common.dao.entity.GameTag;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jun 9, 2019
 */
public interface GameTagRepository extends JpaRepository<GameTag, Long> {
    
    List<GameTag> findAllByIdIn(List<Long> ids);

}
