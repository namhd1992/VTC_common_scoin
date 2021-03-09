/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vtc.gateway.scoinv2api.common.dao.entity.LuckySpin;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * May 7, 2019
 */
@Repository
public interface LuckySpinRepository extends JpaRepository<LuckySpin, Long> {
    
    @Query(value = "SELECT * FROM tblLuckySpin where (id = :spinId or :spinId is null)"
            + " AND NOW() between startDate and endDate"
            + " AND status = :status"
            + " ORDER BY createOn desc", nativeQuery = true)
    List<LuckySpin> findLuckySpin(@Param("spinId") Long spinId,
                                     @Param("status") String status,
                                     Pageable pageable);
    
    @Query(value = "SELECT COUNT(*) FROM tblLuckySpin where (id = :spinId or :spinId is null)"
            + " AND NOW() between startDate and endDate"
            + " AND status = :status"
            + " ORDER BY createOn desc", nativeQuery = true)
    int countLuckySpinGet(@Param("spinId") Long spinId,
                                     @Param("status") String status);
    
    @Query(value = "SELECT * FROM tblLuckySpin where (createBy = :userInfoId or :userInfoId is null)"
            + " AND (keyName = :searchValue or :searchValue is null)"
            + " AND (NOW() between startDate and endDate or :dateActive is null)"
            + " AND status <> :status "
            + " ORDER BY createOn desc", nativeQuery = true)
    List<LuckySpin> adminFindLuckySpin(@Param("userInfoId") Long userInfoId,
                                       @Param("searchValue") String searchValue,
                                       @Param("dateActive") Date dateActive,
                                       @Param("status") String status, 
                                       Pageable pageable);
    
    @Query(value = "SELECT COUNT(*) FROM tblLuckySpin where (createBy = :userInfoId or :userInfoId is null)"
            + " AND (keyName = :searchValue or :searchValue is null)"
            + " AND (NOW() between startDate and endDate or :dateActive is null)"
            + " AND status <> :status"
            + " ORDER BY createOn desc", nativeQuery = true)
    int countAdminFindLuckySpin(@Param("userInfoId") Long userInfoId,
                                @Param("searchValue") String searchValue,
                                @Param("dateActive") Date dateActive,
                                @Param("status") String status);

}
