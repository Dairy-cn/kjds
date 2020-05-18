package com.cross.merchants.service;

import com.cross.merchants.service.dto.StoreOperatingRecordDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.StoreOperatingRecord}.
 */
public interface StoreOperatingRecordService {

    /**
     * Save a storeOperatingRecord.
     *
     * @param storeOperatingRecordDTO the entity to save.
     * @return the persisted entity.
     */
    StoreOperatingRecordDTO save(StoreOperatingRecordDTO storeOperatingRecordDTO);

    /**
     * Get all the storeOperatingRecords.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<StoreOperatingRecordDTO> findAll(Pageable pageable);

    /**
     * Get the "id" storeOperatingRecord.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<StoreOperatingRecordDTO> findOne(Long id);

    /**
     * Delete the "id" storeOperatingRecord.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);


    Page<StoreOperatingRecordDTO> findAllAndStoreId(Pageable pageable,Long storeId);
}
