package com.cross.merchants.repository;

import com.cross.merchants.domain.Goods;

import com.cross.merchants.domain.GoodsCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * Spring Data  repository for the Goods entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long>, JpaSpecificationExecutor<Goods> {


    Goods findFirstByStoreIdAndBrandIdAndGoodsNameAndDeleteFlag(Long StoreId, Long brandId, String goodsName, Boolean flage);


    List<Goods> findAllByIdInAndDeleteFlag(List<Long> ids, Boolean flage);

    List<Goods> findAllByIdIn(List<Long> ids);


    Goods getByIdAndDeleteFlag(Long id, Boolean flage);


    @Query(value = "SELECT id FROM goods a WHERE (SELECT COUNT(1) FROM goods b WHERE a.`brand_id`=b.`brand_id` AND b.id >=a.`id`) <=4 AND a.`delete_flag` !=TRUE AND a.`brand_id` IN :brandIds", nativeQuery = true)
    List<Object[]> findAllByBrandIdInAndDeleteFlag(@Param("brandIds") List<Long> brandIds);


    Page<Goods> findAllByStoreIdAndDeleteFlag(Pageable pageable, Long id, Boolean flage);


    List<Goods> findAllByGoodsNameLikeAndDeleteFlag(String name,Boolean flag);

    List<Goods> findAllByGoodsNameLikeAndStoreIdAndDeleteFlag(String name,Long storeId,Boolean flag);


    @Query(value = "UPDATE `goods` SET sale_volume=IFNULL(sale_volume,0)+ :saleVolume WHERE id = :id", nativeQuery = true)
    @Modifying
    int updateGoodsSaleVolume(@Param("id") Long id, @Param("saleVolume") BigInteger saleVolume);


    int countAllByCategoryIdInAndDeleteFlag(List<Long> categoryIds,Boolean deleteFlag);

}
