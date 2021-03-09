/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtc.gateway.scoinv2api.common.dao.entity.LuckySpin;
import com.vtc.gateway.scoinv2api.common.dao.entity.LuckySpinSetting;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * May 7, 2019
 */
@Repository
public interface LuckySpinSettingRepository extends JpaRepository<LuckySpinSetting, Long>{
    
    List<LuckySpinSetting> findAllByStatusAndType(String status, String type);
    
    LuckySpinSetting findByLuckySpinAndKeyNameAndStatus(LuckySpin luckySpin, String keyName, String status);
    
    LuckySpinSetting findByKeyNameAndStatus(String keyName, String status);
    
}
