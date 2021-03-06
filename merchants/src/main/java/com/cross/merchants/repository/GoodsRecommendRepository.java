package com.cross.merchants.repository;

import com.cross.merchants.domain.GoodsRecommend;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the GoodsRecommend entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GoodsRecommendRepository extends JpaRepository<GoodsRecommend, Long> {

    int countAllByGoodsRecommendType(Integer type);

    int countAllByGoodsRecommendTypeAndGoodsRecommendBannerId(Integer type,Long bannerId);

    int countAllByGoodsId(Long goodsId);


    @Query(value = "update   goods_recommend set top =false where top=true", nativeQuery = true)
    @Modifying
    int updateTopStateFalse();


    @Query(value = "update   goods_recommend set top =true  where id = :id", nativeQuery = true)
    @Modifying
    int updateTopStateTrueById(@Param("id") Long id);


    Page<GoodsRecommend> findAllByGoodsRecommendTypeOrderByTopDescIdDesc(Pageable pageable, Integer type);


    List<GoodsRecommend> findAllByGoodsRecommendTypeOrderByTopDescIdDesc( Integer type);
}
