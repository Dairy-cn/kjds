package com.cross.merchants.repository;

import com.cross.merchants.domain.GoodsProperty;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the GoodsProperty entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GoodsPropertyRepository extends JpaRepository<GoodsProperty, Long> {


    List<GoodsProperty> findAllByGoodsIdAndDeleteFlag(Long goodsId, Boolean delete);

    List<GoodsProperty> findAllByGoodsIdInAndDeleteFlag(List<Long> goodsId, Boolean delete);


    @Query(value = "UPDATE `goods_property` SET delete_flag= true WHERE id in :ids", nativeQuery = true)
    @Modifying
    int deleteByIdIn(@Param("ids") List<Long> ids);

}
