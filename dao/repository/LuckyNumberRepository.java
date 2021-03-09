/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dao.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vtc.gateway.scoinv2api.common.dao.entity.LuckyNumber;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jul 15, 2019
 */
@Repository
public interface LuckyNumberRepository extends JpaRepository<LuckyNumber, Long> {
    
    LuckyNumber findFirstByOrderByIdDesc();
    
    List<LuckyNumber> findByScoinIdAndUsed(Long ScoinId, boolean used, Pageable pageable);
    
    @Query(value ="SELECT * FROM tblLuckyNumber WHERE luckyCode NOT IN (?1)", nativeQuery = true)
    List<LuckyNumber> findByLuckyCodes(List<String> luckyCodes);

}
