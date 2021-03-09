/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dao.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtc.gateway.scoinv2api.common.dao.entity.CheckinHistory;
import com.vtc.gateway.scoinv2api.common.dao.entity.UserInfo;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * May 30, 2019
 */
@Repository
public interface CheckinHistoryRepository extends JpaRepository<CheckinHistory, Long> {
    
    List<CheckinHistory> findByUserInfoOrderByCreateOnDesc(UserInfo userInfo);
    
    Optional<CheckinHistory> findByUserInfoAndCreateOnBetween(UserInfo userInfo, 
                                                              Date startDate, 
                                                              Date endDate);  
    
}
