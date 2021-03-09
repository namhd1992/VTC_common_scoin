/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.gateway.scoinv2api.common.dao.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vtc.gateway.scoinv2api.common.dao.entity.ShopingItem;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Apr 23, 2019
 */
@Repository
public interface ShopingItemRepository extends JpaRepository<ShopingItem, Long>{
    
    @Query(value = "SELECT * FROM tblShopingItem WHERE status <> 'deleted'"
            + " AND (id = ?1 or ?1 < 1)"
            + " AND (name like ?2 or ?2 is null)"
            + " AND (firstType REGEXP ?3 or secondType REGEXP ?3 or ?3 is null)"
            + " AND (shopId = ?4 or ?4  < 1)"
            + " AND (itemType = ?5 or ?5  < 1)"
            + " ORDER BY createOn DESC", nativeQuery = true)
    List<ShopingItem> getShopingItem(@Param(":id") long id, 
                                     @Param(":searchValue") String searchValue,
                                     @Param(":filter") List<String> filter, 
                                     @Param(":shopId") long shopId,
                                     @Param(":itemType") int itemType,
                                     Pageable pageable);
    
    @Query(value = "SELECT COUNT(*) FROM tblShopingItem WHERE status <> 'deleted'"
            + " AND (id = ?1 or ?1 < 1)"
            + " AND (name like ?2 or ?2 is null)"
            + " AND (firstType REGEXP ?3 or secondType REGEXP ?3 or ?3 is null)"
            + " AND (shopId = ?4 or ?4  < 1)"
            + " AND (itemType = ?5 or ?5  < 1)"
            + " ORDER BY createOn DESC", nativeQuery = true)
    int countGetShopingItem(@Param(":id") long id,
                                          @Param(":searchValue") String searchValue,
                                          @Param(":filter") List<String> filter,
                                          @Param(":shopId") long shopId,
                                          @Param(":itemType") int itemType);

}
