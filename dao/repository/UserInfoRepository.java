/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vtc.gateway.scoinv2api.common.dao.entity.UserInfo;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * May 6, 2019
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    
    UserInfo findByFullName(String name);
    
    @Query(value = "select u from UserInfo u where u.userVTC.scoinId = ?1")
    UserInfo getByScoinId(Long scoinId);

}
