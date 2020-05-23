package com.cross.merchants.service;

import com.cross.merchants.service.dto.BankInfoDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.BankInfo}.
 */
public interface BankInfoService {

    /**
     * Save a bankInfo.
     *
     * @param bankInfoDTO the entity to save.
     * @return the persisted entity.
     */
    BankInfoDTO save(BankInfoDTO bankInfoDTO);

    /**
     * Get all the bankInfos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<BankInfoDTO> findAll(Pageable pageable);

    /**
     * Get the "id" bankInfo.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BankInfoDTO> findOne(Long id);

    /**
     * Delete the "id" bankInfo.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);


    List<BankInfoDTO> findAll();

}
