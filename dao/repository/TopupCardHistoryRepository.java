/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtc.gateway.scoinv2api.common.dao.entity.TopupCardHistory;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jul 16, 2019
 */
@Repository
public interface TopupCardHistoryRepository extends JpaRepository<TopupCardHistory, Long> {
    
    List<TopupCardHistory> findByCreateOnAfter(Date date);
    
    List<TopupCardHistory> findByLuckyWheelUsedIsFalseAndScoinIdAndCardTypeAndCreateOnAfter(Long scoinId,
                                                                                            String soinCardType,
                                                                                            Date createOn);

    TopupCardHistory findByScoinTransId(long scoinTransId);
    
}
