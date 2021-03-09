/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dao.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vtc.gateway.scoinv2api.common.dao.entity.LuckySpin;
import com.vtc.gateway.scoinv2api.common.dao.entity.SpinHistory;
import com.vtc.gateway.scoinv2api.common.dao.entity.UserInfo;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * May 7, 2019
 */
@Repository
public interface SpinHistoryRepository extends JpaRepository<SpinHistory, Long>{
    
    
    Optional<SpinHistory> findByUserInfoAndSpinEventAndCreateOnBetween(UserInfo userInfo, 
                                                                       LuckySpin luckySpin,
                                                                       Date fromDate,
                                                                       Date toDate);
    
    @Query(value ="select s from SpinHistory s where spinEvent = ?1 "
            + " and (s.userInfo = ?2 or ?2 is null) "
            + " and s.createOn > ?3 "
            + " and (s.item.type = ?4 or ?4 is null) "
            + " order by s.createOn desc")
    List<SpinHistory> getBySpinEventAndUserInfoAndTypeGift(LuckySpin luckySpin,
                                                          UserInfo userInfo,
                                                          Date limitDate,
                                                          String type);
    
    @Query(value ="select count(s) from SpinHistory s where spinEvent = ?1 "
            + " and (s.userInfo = ?2 or ?2 is null) "
            + " and s.createOn > ?3 "
            + " and (s.item.type = ?4 or ?4 is null) ")
    int countBySpinEventAndUserInfoAndTypeGift(LuckySpin luckySpin,
                                              UserInfo userInfo,
                                              Date limitDate,
                                              String type);
    @Query(value = "select count(s.id) from SpinHistory s where spinEvent = ?1 "
            + " and s.item.type = ?2"
            + " and (s.item.value = ?3 or ?3 = null )")
    int countByItemType(LuckySpin luckySpin, String itemType, Long value);

}
