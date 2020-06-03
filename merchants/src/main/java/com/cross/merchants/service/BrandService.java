package com.cross.merchants.service;

import com.cross.merchants.service.dto.BrandDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.Brand}.
 */
public interface BrandService {

    /**
     * Save a brand.
     *
     * @param brandDTO the entity to save.
     * @return the persisted entity.
     */
    BrandDTO save(BrandDTO brandDTO);

    /**
     * Get all the brands.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<BrandDTO> findAll(Pageable pageable);

    /**
     * Get the "id" brand.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    BrandDTO findOne(Long id);

    /**
     * Delete the "id" brand.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    BrandDTO brandCheckInInfo(BrandDTO brandDTO);


    Page<BrandDTO> findAllWithWaitCheckIn(Pageable pageable);


    Page<BrandDTO> findAllByStatusAndStoreId(Pageable pageable, Integer status, Long storeId);

    List<BrandDTO> findAllByStatusAndStoreId(Integer status, Long storeId);

    Page<BrandDTO> getAllBrandsByCondition(Pageable pageable, Integer brandAuthType, Integer checkState, Instant startTime, Instant endTime, Instant startCheckTime, Instant endCheckTime, String keyWord);


    List<BrandDTO> findAllByIdInAndCheckState(List<Long> ids, Integer checkState);


    Page<BrandDTO> getAllBrandListByConditionByC(Pageable pageable, Long oneCategoryId, Long twoCategoryId, Long thirdCategoryId);

}
