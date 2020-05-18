package com.cross.merchants.repository;

import com.cross.merchants.domain.Goods;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Goods entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long>, JpaSpecificationExecutor<Goods> {


    Goods findFirstByStoreIdAndBrandIdAndGoodsNameAndDeleteFlag(Long StoreId, Long brandId, String goodsName, Boolean flage);
}
