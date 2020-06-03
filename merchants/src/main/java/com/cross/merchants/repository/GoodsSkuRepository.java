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

    List<GoodsSku> findAllByIdInAndDeleteFlag(List<Long> ids, Boolean delete);


    List<GoodsSku> findAllByGoodsIdAndDeleteFlag(Long goodsId, Boolean delete);


    @Query(value = "UPDATE `goods_sku` SET delete_flag= true WHERE id in :ids", nativeQuery = true)
    @Modifying
    int deleteByIdIn(@Param("ids") List<Long> ids);

    @Query(value = "UPDATE `goods_sku` SET lock_stock= lock_stock - :lockStock WHERE id = :id", nativeQuery = true)
    @Modifying
    int releaseSkuStockLock(@Param("id") Long id, @Param("lockStock") Integer lockStock);

    @Query(value = "UPDATE `goods_sku` SET stock= stock - :lockStock, lock_stock= lock_stock - :lockStock,sale_volume=sale_volume+ :lockStock WHERE id = :id", nativeQuery = true)
    @Modifying
    int updateSkuStock(@Param("id") Long id, @Param("lockStock") Integer lockStock);

    GoodsSku getByIdAndDeleteFlag(Long id, Boolean flag);


    @Query(value = "SELECT id FROM goods_sku a WHERE (SELECT COUNT(1) FROM goods_sku b WHERE a.`goods_id`=b.`goods_id` AND b.sale_price <= a.`sale_price`) <=1 AND a.`delete_flag` !=TRUE AND a.`goods_id` IN :goodsIds", nativeQuery = true)
    List<Object[]> findAllByGoodsIdInAndDeleteFlag(@Param("goodsIds") List<Long> goodsIds);

}
