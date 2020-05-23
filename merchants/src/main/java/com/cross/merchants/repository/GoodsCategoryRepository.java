package com.cross.merchants.repository;

import com.cross.merchants.domain.GoodsCategory;

import com.cross.merchants.domain.MerchantsCategory;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the GoodsCategory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GoodsCategoryRepository extends JpaRepository<GoodsCategory, Long> {


    int countAllByLevel(Integer level);

    List<GoodsCategory> findAllByPid(Long pid);

    List<GoodsCategory> findAllByPidIn(List<Long> pid);


    List<GoodsCategory> findAllByLevelOrderByStickDescIdDesc(Integer level);

    GoodsCategory findFirstByPidAndName(Long pid, String name);

    @Query(value = "UPDATE `goods_category` SET stick= :stick WHERE id= :id", nativeQuery = true)
    @Modifying
    int updateStickStatus(@Param("id") Long id, @Param("stick") Boolean stick);

    @Query(value = "UPDATE `goods_category` SET stick= false WHERE stick=true", nativeQuery = true)
    @Modifying
    int setStickStatusFalse();


    @Query(value = "delete from `goods_category` WHERE id in :ids", nativeQuery = true)
    @Modifying
    int deleteByIdIn(@Param("ids") List<Long> ids);


    List<GoodsCategory> findByIdIn(List<Long> pid);


    List<GoodsCategory> findAllByIdIn(List<Long> ids);

}
