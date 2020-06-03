package com.cross.merchants.service;

import com.cross.merchants.service.dto.EnterpriseInfoDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.EnterpriseInfo}.
 */
public interface EnterpriseInfoService {

    /**
     * Save a enterpriseInfo.
     *
     * @param enterpriseInfoDTO the entity to save.
     * @return the persisted entity.
     */
    EnterpriseInfoDTO save(EnterpriseInfoDTO enterpriseInfoDTO);

    /**
     * Get all the enterpriseInfos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<EnterpriseInfoDTO> findAll(Pageable pageable);

    /**
     * Get the "id" enterpriseInfo.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<EnterpriseInfoDTO> findOne(Long id);

    /**
     * Delete the "id" enterpriseInfo.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    EnterpriseInfoDTO findFristByMerchantId(Long merchantId);

    List<EnterpriseInfoDTO> findAllByMerchantIdIn(List<Long> merchantIds);
}
