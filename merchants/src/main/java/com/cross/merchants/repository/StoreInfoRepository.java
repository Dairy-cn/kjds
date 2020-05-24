package com.cross.merchants.repository;

import com.cross.merchants.domain.ArticleInfo;
import com.cross.merchants.domain.StoreInfo;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the StoreInfo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StoreInfoRepository extends JpaRepository<StoreInfo, Long> , JpaSpecificationExecutor<StoreInfo>{

    @Query(value = "SELECT category_id,COUNT(category_id) AS COUNT FROM store_info    WHERE `category_id` IN :ids GROUP BY category_id ", nativeQuery = true)
    List<Object[]> countMerchantsWithCategoryIds(@Param("ids") List<Long> ids);

    List<StoreInfo> findAllByCategoryId(Long categoryId);


    StoreInfo findFirstByCreateUserId(Long userId);

    List<StoreInfo> findAllByIdIn(List<Long> ids);


    StoreInfo findFirstByMerchantsCheckInInfoId(Long merchantId);


}
