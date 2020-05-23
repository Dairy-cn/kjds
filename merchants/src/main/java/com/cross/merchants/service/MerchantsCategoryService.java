package com.cross.merchants.service;

import com.cross.merchants.service.dto.MerchantsCategoryDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.MerchantsCategory}.
 */
public interface MerchantsCategoryService {

    /**
     * Save a merchantsCategory.
     *
     * @param merchantsCategoryDTO the entity to save.
     * @return the persisted entity.
     */
    MerchantsCategoryDTO save(MerchantsCategoryDTO merchantsCategoryDTO);

    /**
     * Get all the merchantsCategories.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<MerchantsCategoryDTO> findAll(Pageable pageable);

    List<MerchantsCategoryDTO> findAllWithOrder(Pageable pageable, Boolean isDesc);

    List<MerchantsCategoryDTO> findAll();


    List<MerchantsCategoryDTO> findAllByIdIn(List<Long> ids);

    /**
     * Get the "id" merchantsCategory.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<MerchantsCategoryDTO> findOne(Long id);

    /**
     * Delete the "id" merchantsCategory.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    long count();
}
