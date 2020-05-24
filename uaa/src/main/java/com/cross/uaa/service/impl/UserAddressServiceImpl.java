package com.cross.uaa.service.impl;

import com.cross.uaa.service.UserAddressService;
import com.cross.uaa.domain.UserAddress;
import com.cross.uaa.repository.UserAddressRepository;
import com.cross.uaa.service.dto.UserAddressDTO;
import com.cross.uaa.service.mapper.UserAddressMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link UserAddress}.
 */
@Service
@Transactional
public class UserAddressServiceImpl implements UserAddressService {

    private final Logger log = LoggerFactory.getLogger(UserAddressServiceImpl.class);

    private final UserAddressRepository userAddressRepository;

    private final UserAddressMapper userAddressMapper;

    public UserAddressServiceImpl(UserAddressRepository userAddressRepository, UserAddressMapper userAddressMapper) {
        this.userAddressRepository = userAddressRepository;
        this.userAddressMapper = userAddressMapper;
    }

    /**
     * Save a userAddress.
     *
     * @param userAddressDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    @Transactional
    public UserAddressDTO save(UserAddressDTO userAddressDTO) {
        log.debug("Request to save UserAddress : {}", userAddressDTO);
        if (userAddressDTO.getDefaultFlag() == null) {
            userAddressDTO.setDefaultFlag(false);

        }
        if(userAddressDTO.getId()==null){
            userAddressDTO.setDeleteFlag(false);
        }
        if (userAddressDTO.getDefaultFlag()) {
            userAddressRepository.setDefaultFlagById(userAddressDTO.getUserId());
        }
        UserAddress userAddress = userAddressMapper.toEntity(userAddressDTO);
        userAddress = userAddressRepository.save(userAddress);
        return userAddressMapper.toDto(userAddress);
    }

    @Override
    public Page<UserAddressDTO> findAll(Pageable pageable, Long userId) {
        return userAddressRepository.findAllByUserIdAndDeleteFlagNotOrderByDefaultFlagDescIdDesc(pageable, userId, true)
            .map(userAddressMapper::toDto);
    }


    /**
     * Get one userAddress by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<UserAddressDTO> findOne(Long id) {
        log.debug("Request to get UserAddress : {}", id);
        return userAddressRepository.findById(id)
            .map(userAddressMapper::toDto);
    }

    /**
     * Delete the userAddress by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete UserAddress : {}", id);
        userAddressRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateDefaultUserAddress(Long id) {
        UserAddress one = userAddressRepository.getOne(id);
        if (one != null) {
            userAddressRepository.setDefaultFlagById(one.getUserId());
            userAddressRepository.updateDefaultState(id);
        }
    }
}
