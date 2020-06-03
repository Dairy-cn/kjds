package com.cross.merchants.service;

import com.cross.merchants.service.dto.ShippingListDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.ShippingList}.
 */
public interface ShippingListService {

    /**
     * Save a shippingList.
     *
     * @param shippingListDTO the entity to save.
     * @return the persisted entity.
     */
    ShippingListDTO save(ShippingListDTO shippingListDTO);

    /**
     * Get all the shippingLists.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ShippingListDTO> findAll(Pageable pageable);

    /**
     * Get the "id" shippingList.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ShippingListDTO> findOne(Long id);

    /**
     * Delete the "id" shippingList.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    List<ShippingListDTO> findAll();

    List<ShippingListDTO> findAllByIdIn(List<Long> ids);
}
