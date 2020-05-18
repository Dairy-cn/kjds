package com.cross.merchants.repository;

import com.cross.merchants.domain.GoodsSku;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Spring Data  repository for the GoodsSku entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GoodsSkuRepository extends JpaRepository<GoodsSku, Long> {

    List<GoodsSku> findAllByGoodsIdInAndDeleteFlag(List<Long> goodsIds, Boolean delete);


    List<GoodsSku> findAllByGoodsIdAndDeleteFlag(Long goodsId, Boolean delete);


    @Query(value = "UPDATE `goods_sku` SET delete_flag= true WHERE id in :ids", nativeQuery = true)
    @Modifying
    int deleteByIdIn(@Param("ids") List<Long> ids);

}
