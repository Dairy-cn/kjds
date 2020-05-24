package com.cross.uaa.service;

import com.cross.uaa.service.dto.UserAddressDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.uaa.domain.UserAddress}.
 */
public interface UserAddressService {

    /**
     * Save a userAddress.
     *
     * @param userAddressDTO the entity to save.
     * @return the persisted entity.
     */
    UserAddressDTO save(UserAddressDTO userAddressDTO);

    /**
     * Get all the userAddresses.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<UserAddressDTO> findAll(Pageable pageable, Long userId);

    /**
     * Get the "id" userAddress.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<UserAddressDTO> findOne(Long id);

    /**
     * Delete the "id" userAddress.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);


    void updateDefaultUserAddress(Long id);
}
