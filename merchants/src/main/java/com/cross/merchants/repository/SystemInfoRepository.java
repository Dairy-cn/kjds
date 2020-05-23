package com.cross.merchants.repository;

import com.cross.merchants.domain.SystemInfo;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SystemInfo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SystemInfoRepository extends JpaRepository<SystemInfo, Long> {

}
