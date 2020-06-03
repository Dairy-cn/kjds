package com.cross.merchants.service;

import com.cross.merchants.service.dto.StoreCommonShippingListDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.StoreCommonShippingList}.
 */
public interface StoreCommonShippingListService {

    /**
     * Save a storeCommonShippingList.
     *
     * @param storeCommonShippingListDTO the entity to save.
     * @return the persisted entity.
     */
    StoreCommonShippingListDTO save(StoreCommonShippingListDTO storeCommonShippingListDTO);

    /**
     * Get all the storeCommonShippingLists.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<StoreCommonShippingListDTO> findAll(Pageable pageable);

    /**
     * Get the "id" storeCommonShippingList.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<StoreCommonShippingListDTO> findOne(Long id);

    /**
     * Delete the "id" storeCommonShippingList.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    List<StoreCommonShippingListDTO> getStoreCommonShippingAllList(Long storeId);

    List<StoreCommonShippingListDTO> batchSave(Long storeId,List<Long> shippingIds);
}
