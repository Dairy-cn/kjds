package com.cross.merchants.service;

import com.cross.merchants.service.dto.MerchantsCheckInInfoDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.MerchantsCheckInInfo}.
 */
public interface MerchantsCheckInInfoService {

    /**
     * Save a merchantsCheckInInfo.
     *
     * @param merchantsCheckInInfoDTO the entity to save.
     * @return the persisted entity.
     */
    MerchantsCheckInInfoDTO save(MerchantsCheckInInfoDTO merchantsCheckInInfoDTO);

    /**
     * Get all the merchantsCheckInInfos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<MerchantsCheckInInfoDTO> findAll(Pageable pageable);

    Page<MerchantsCheckInInfoDTO> findAllWithWaitCheckIn(Pageable pageable);

    /**
     * Get the "id" merchantsCheckInInfo.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<MerchantsCheckInInfoDTO> findOne(Long id);

    /**
     * Delete the "id" merchantsCheckInInfo.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);


    Map<Long, Integer> countMerchantsWithCategoryIds(List<Long> categoryIds);


    MerchantsCheckInInfoDTO findOneWithSelf(Long submitId);


    MerchantsCheckInInfoDTO merchantsCheckInInfo(MerchantsCheckInInfoDTO merchantsCheckInInfoDTO);

    List<MerchantsCheckInInfoDTO> findAllByIdIn(List<Long> ids);

    long countByCategoryId(Long categoryId);

}
