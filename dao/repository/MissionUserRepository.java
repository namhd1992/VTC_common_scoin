/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dao.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vtc.gateway.scoinv2api.common.dao.entity.Mission;
import com.vtc.gateway.scoinv2api.common.dao.entity.MissionUser;
import com.vtc.gateway.scoinv2api.common.dao.entity.UserInfo;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * May 30, 2019
 */
@Repository
public interface MissionUserRepository extends JpaRepository<MissionUser, Long> {
    
    Optional<MissionUser> findByMissionAndUserInfoAndCreateOnBetween(Mission mission, 
                                                          UserInfo userInfo, 
                                                          Date startDate, 
                                                          Date endDate);

    @Query(value = "select count(id) from MissionUser where mission = :mission and isReceived = 1"
            + " and (date(createOn) = :createOn or :createOn is null)")
    Long countUserReceivedByDate(@Param(value = "mission") Mission mission,
                                 @Param(value = "createOn") Date date);

}
