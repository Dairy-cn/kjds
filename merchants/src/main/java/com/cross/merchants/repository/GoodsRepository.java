package com.cross.merchants.repository;

import com.cross.merchants.domain.Goods;

import com.cross.merchants.domain.GoodsCategory;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

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

}
