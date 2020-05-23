package com.cross.merchants.service;

import com.cross.merchants.service.dto.WarehouseInfoDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.WarehouseInfo}.
 */
public interface WarehouseInfoService {

    /**
     * Save a warehouseInfo.
     *
     * @param warehouseInfoDTO the entity to save.
     * @return the persisted entity.
     */
    WarehouseInfoDTO save(WarehouseInfoDTO warehouseInfoDTO);

    /**
     * Get all the warehouseInfos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<WarehouseInfoDTO> findAll(Pageable pageable);

    /**
     * Get the "id" warehouseInfo.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<WarehouseInfoDTO> findOne(Long id);

    /**
     * Delete the "id" warehouseInfo.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    WarehouseInfoDTO findFristByMerchantId(Long merchantId);
}
