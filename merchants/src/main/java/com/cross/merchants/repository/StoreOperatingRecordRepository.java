package com.cross.merchants.repository;

import com.cross.merchants.domain.StoreOperatingRecord;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the StoreOperatingRecord entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StoreOperatingRecordRepository extends JpaRepository<StoreOperatingRecord, Long> {

    Page<StoreOperatingRecord> findAllByStoreId(Pageable pageable, Long storeId);

}
