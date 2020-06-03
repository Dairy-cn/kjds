package com.cross.merchants.repository;

import com.cross.merchants.domain.BankInfo;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the BankInfo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BankInfoRepository extends JpaRepository<BankInfo, Long> {


    List<BankInfo> findAllByIdIn(List<Long> ids);
}
