package com.cross.merchants.repository;

import com.cross.merchants.domain.MerchantsCategory;

import com.cross.merchants.domain.StoreInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the MerchantsCategory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MerchantsCategoryRepository extends JpaRepository<MerchantsCategory, Long> {


    @Query(value="SELECT mc.* FROM `merchants_category`  mc LEFT JOIN (SELECT category_id,COUNT(category_id) AS COUNT FROM store_info     GROUP BY category_id ) AS ms ON mc.id=ms.category_id ORDER BY ms.COUNT desc LIMIT :pageNum,:pageSize",nativeQuery=true)
    List<MerchantsCategory> findAllInfoWithOrderDesc(@Param("pageNum")Integer pageNum,
                                                 @Param("pageSize")Integer pageSize);

    @Query(value="SELECT mc.* FROM `merchants_category`  mc LEFT JOIN (SELECT category_id,COUNT(category_id) AS COUNT FROM store_info     GROUP BY category_id ) AS ms ON mc.id=ms.category_id ORDER BY ms.COUNT ASC LIMIT :pageNum,:pageSize",nativeQuery=true)
    List<MerchantsCategory> findAllInfoWithOrderAsc(@Param("pageNum")Integer pageNum,
                                                 @Param("pageSize")Integer pageSize);

    List<MerchantsCategory> findAllByIdIn(List<Long> ids);

}
