package com.cross.merchants.repository;

import com.cross.merchants.domain.GoodsPropertyTag;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the GoodsPropertyTag entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GoodsPropertyTagRepository extends JpaRepository<GoodsPropertyTag, Long> {

    List<GoodsPropertyTag> findAllByGoodsPropertyIdAndDeleteFlag(Long propertyId, Boolean flage);

    List<GoodsPropertyTag> findAllByGoodsPropertyIdInAndDeleteFlag(List<Long> propertyId, Boolean flage);


    @Query(value = "UPDATE `goods_property_tag` SET delete_flag= true WHERE id in :ids", nativeQuery = true)
    @Modifying
    int deleteByIdIn(@Param("ids") List<Long> ids);

    List<GoodsPropertyTag> findAllByIdInAndDeleteFlag(List<Long> ids, Boolean flage);

}
