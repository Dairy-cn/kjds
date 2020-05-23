package com.cross.merchants.service;

import com.cross.merchants.service.dto.SystemInfoDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.SystemInfo}.
 */
public interface SystemInfoService {

    /**
     * Save a systemInfo.
     *
     * @param systemInfoDTO the entity to save.
     * @return the persisted entity.
     */
    SystemInfoDTO save(SystemInfoDTO systemInfoDTO);

    /**
     * Get all the systemInfos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SystemInfoDTO> findAll(Pageable pageable);

    /**
     * Get the "id" systemInfo.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SystemInfoDTO> findOne(Long id);

    /**
     * Delete the "id" systemInfo.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
