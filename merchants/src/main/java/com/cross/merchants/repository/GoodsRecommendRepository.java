package com.cross.merchants.repository;

import com.cross.merchants.domain.GoodsRecommend;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the GoodsRecommend entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GoodsRecommendRepository extends JpaRepository<GoodsRecommend, Long> {

    int countAllByBanner(Integer banner);


    int countAllByGoodsId(Long goodsId);


    @Query(value = "update   goods_recommend set top =false ", nativeQuery = true)
    @Modifying
    int updateTopStateFalse();


    @Query(value = "update   goods_recommend set top =false  where id = :id", nativeQuery = true)
    @Modifying
    int updateTopStateTrueById(@Param("id") Long id);
}
