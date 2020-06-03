package com.cross.merchants.repository;

import com.cross.merchants.domain.Goods;
import com.cross.merchants.domain.MerchantsCheckInInfo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the MerchantsCheckInInfo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MerchantsCheckInInfoRepository extends JpaRepository<MerchantsCheckInInfo, Long> , JpaSpecificationExecutor<MerchantsCheckInInfo> {


    MerchantsCheckInInfo findFirstByProposer(Long id);

    MerchantsCheckInInfo findFirstByProposerAndCheckStatus(Long id, Integer state);


    Page<MerchantsCheckInInfo> findAllByCheckStatus(Pageable pageable, Integer checkStatus);

    List<MerchantsCheckInInfo> findAllByIdIn(List<Long> ids);

    long countAllByCategoryId(Long categoryId);

}
