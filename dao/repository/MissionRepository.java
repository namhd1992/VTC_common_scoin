/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtc.gateway.scoinv2api.common.dao.entity.Mission;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Apr 18, 2019
 */
@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {

    List<Mission> findByFromDateBeforeAndToDateAfterAndStatus(Date now, 
                                                     Date dayDisplayMission,
                                                     String status,
                                                     Pageable pageable);
    
    Integer countByFromDateBeforeAndToDateAfterAndStatus(Date now, 
                                                Date dayDisplayMission,
                                                String status);

}
