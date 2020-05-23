package com.cross.merchants.service;

import com.cross.merchants.domain.StoreInfo;
import com.cross.merchants.service.dto.StoreInfoDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.StoreInfo}.
 */
public interface StoreInfoService {

    /**
     * Save a storeInfo.
     *
     * @param storeInfoDTO the entity to save.
     * @return the persisted entity.
     */
    StoreInfoDTO save(StoreInfoDTO storeInfoDTO);

    /**
     * Get all the storeInfos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<StoreInfoDTO> findAll(Pageable pageable);

    /**
     * Get the "id" storeInfo.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<StoreInfoDTO> findOne(Long id);

    /**
     * Delete the "id" storeInfo.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    List<StoreInfoDTO> findAllByCategoryId(Long categoryId);


    StoreInfoDTO updateStoreOperatingStatusInfoWithMerchants(Long id, Integer status);

    StoreInfoDTO updateStoreOperatingStatusInfoWithPlatform(Long id, Integer status, String closeReason);

    StoreInfoDTO findByCreateUserId(Long userId);


    StoreInfoDTO findFirstByMerchantId(Long merchantId);


    List<StoreInfoDTO> findAllByIdIn(List<Long> ids);


    StoreInfoDTO getOne(Long id);

}
