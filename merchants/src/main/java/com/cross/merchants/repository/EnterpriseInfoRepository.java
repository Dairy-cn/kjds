package com.cross.merchants.repository;

import com.cross.merchants.domain.EnterpriseInfo;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the EnterpriseInfo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EnterpriseInfoRepository extends JpaRepository<EnterpriseInfo, Long> {


    EnterpriseInfo findFirstByMerchantId(Long merchantId);
}
