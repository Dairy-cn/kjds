package com.cross.merchants.service;

import com.cross.merchants.service.dto.UserAddressDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.UserAddress}.
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

    List<UserAddressDTO> findAllByUserId(Long userId);


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
