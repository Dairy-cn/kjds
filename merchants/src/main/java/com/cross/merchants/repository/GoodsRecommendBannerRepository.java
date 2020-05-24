package com.cross.merchants.repository;


import com.cross.merchants.domain.GoodsRecommendBanner;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the GoodsRecommendBrand entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GoodsRecommendBannerRepository extends JpaRepository<GoodsRecommendBanner, Long> {


    @Query(value = "update   goods_recommend_banner set top =false  where top=true", nativeQuery = true)
    @Modifying
    int updateTopStateFalse();


    @Query(value = "update   goods_recommend_banner set top =true  where id= :id", nativeQuery = true)
    @Modifying
    int updateTopStateById(@Param("id") Long id);


    GoodsRecommendBanner findFirstByDivisionName(String name);


    List<GoodsRecommendBanner> findAllByIdIn(List<Long> ids);


}
