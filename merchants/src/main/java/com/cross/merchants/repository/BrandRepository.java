package com.cross.merchants.repository;

import com.cross.merchants.domain.Brand;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Brand entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    Brand findFirstByStoreIdAndBrandName(Long storeId, String brandName);


    Page<Brand> findAllByCheckStatus(Pageable pageable, Integer status);

    Page<Brand> findAllByCheckStatusAndStoreId(Pageable pageable, Integer status,Long storeId);

    Page<Brand> findAllByStoreId(Pageable pageable,Long storeId);


    List<Brand> findAllByCheckStatusAndStoreId(Integer status, Long storeId);

    List<Brand> findAllByStoreId(Long storeId);

}
