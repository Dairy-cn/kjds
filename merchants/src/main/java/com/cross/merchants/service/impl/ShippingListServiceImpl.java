package com.cross.merchants.service.impl;

import com.cross.merchants.service.ShippingListService;
import com.cross.merchants.domain.ShippingList;
import com.cross.merchants.repository.ShippingListRepository;
import com.cross.merchants.service.dto.ShippingListDTO;
import com.cross.merchants.service.mapper.ShippingListMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link ShippingList}.
 */
@Service
@Transactional
public class ShippingListServiceImpl implements ShippingListService {

    private final Logger log = LoggerFactory.getLogger(ShippingListServiceImpl.class);

    private final ShippingListRepository shippingListRepository;

    private final ShippingListMapper shippingListMapper;

    public ShippingListServiceImpl(ShippingListRepository shippingListRepository, ShippingListMapper shippingListMapper) {
        this.shippingListRepository = shippingListRepository;
        this.shippingListMapper = shippingListMapper;
    }

    /**
     * Save a shippingList.
     *
     * @param shippingListDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ShippingListDTO save(ShippingListDTO shippingListDTO) {
        log.debug("Request to save ShippingList : {}", shippingListDTO);
        ShippingList shippingList = shippingListMapper.toEntity(shippingListDTO);
        shippingList = shippingListRepository.save(shippingList);
        return shippingListMapper.toDto(shippingList);
    }

    /**
     * Get all the shippingLists.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ShippingListDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ShippingLists");
        return shippingListRepository.findAll(pageable)
            .map(shippingListMapper::toDto);
    }

    /**
     * Get one shippingList by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ShippingListDTO> findOne(Long id) {
        log.debug("Request to get ShippingList : {}", id);
        return shippingListRepository.findById(id)
            .map(shippingListMapper::toDto);
    }

    /**
     * Delete the shippingList by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ShippingList : {}", id);
        shippingListRepository.deleteById(id);
    }

    @Override
    public List<ShippingListDTO> findAll() {
        return shippingListMapper.toDto(shippingListRepository.findAll());
    }

    @Override
    public List<ShippingListDTO> findAllByIdIn(List<Long> ids) {
        return shippingListMapper.toDto(shippingListRepository.findAllByIdIn((ids)));
    }
}
