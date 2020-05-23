package com.cross.merchants.repository;

import com.cross.merchants.domain.WarehouseInfo;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the WarehouseInfo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WarehouseInfoRepository extends JpaRepository<WarehouseInfo, Long> {


    WarehouseInfo findFirstByMerchantId(Long merchantId);
}
