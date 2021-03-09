/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtc.gateway.scoinv2api.common.dao.entity.Game;
import com.vtc.gateway.scoinv2api.common.dao.entity.GameTag;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * May 31, 2019
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    
    List<Game> findByStatus(String status);
    
    Optional<Game> findByScoinGameIdAndStatus(Long serviceId, String status);

    List<Game> findAllByTagsListIn(List<GameTag> gameTags);

    List<Game> findByTagsList(GameTag gameTag);

}
