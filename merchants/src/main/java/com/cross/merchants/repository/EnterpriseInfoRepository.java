package com.cross.merchants.repository;

import com.cross.merchants.domain.EnterpriseInfo;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the EnterpriseInfo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EnterpriseInfoRepository extends JpaRepository<EnterpriseInfo, Long> {


    EnterpriseInfo findFirstByMerchantId(Long merchantId);

    List<EnterpriseInfo> findAllByMerchantIdIn(List<Long> merchantIds);
}
