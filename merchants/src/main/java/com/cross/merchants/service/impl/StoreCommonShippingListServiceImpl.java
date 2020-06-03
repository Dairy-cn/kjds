package com.cross.merchants.service.impl;

import com.cross.merchants.exception.MerchantsException;
import com.cross.merchants.service.StoreCommonShippingListService;
import com.cross.merchants.domain.StoreCommonShippingList;
import com.cross.merchants.repository.StoreCommonShippingListRepository;
import com.cross.merchants.service.dto.StoreCommonShippingListDTO;
import com.cross.merchants.service.mapper.StoreCommonShippingListMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link StoreCommonShippingList}.
 */
@Service
@Transactional
public class StoreCommonShippingListServiceImpl implements StoreCommonShippingListService {

    private final Logger log = LoggerFactory.getLogger(StoreCommonShippingListServiceImpl.class);

    private final StoreCommonShippingListRepository storeCommonShippingListRepository;

    private final StoreCommonShippingListMapper storeCommonShippingListMapper;

    public StoreCommonShippingListServiceImpl(StoreCommonShippingListRepository storeCommonShippingListRepository, StoreCommonShippingListMapper storeCommonShippingListMapper) {
        this.storeCommonShippingListRepository = storeCommonShippingListRepository;
        this.storeCommonShippingListMapper = storeCommonShippingListMapper;
    }

    /**
     * Save a storeCommonShippingList.
     *
     * @param storeCommonShippingListDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public StoreCommonShippingListDTO save(StoreCommonShippingListDTO storeCommonShippingListDTO) {
        log.debug("Request to save StoreCommonShippingList : {}", storeCommonShippingListDTO);
        StoreCommonShippingList shippingId = storeCommonShippingListRepository.findFirstByStoreIdAndShippingId(storeCommonShippingListDTO.getStoreId(), storeCommonShippingListDTO.getShippingId());
        if (shippingId != null) {
            if (storeCommonShippingListDTO.getId() == null) {
                throw new MerchantsException(400, "记录已添加，不要重复添加");
            } else {
                if (!shippingId.getId().equals(storeCommonShippingListDTO.getShippingId())) {
                    throw new MerchantsException(400, "记录已添加，不要重复添加");
                }
            }
        }
        StoreCommonShippingList storeCommonShippingList = storeCommonShippingListMapper.toEntity(storeCommonShippingListDTO);
        storeCommonShippingList = storeCommonShippingListRepository.save(storeCommonShippingList);
        return storeCommonShippingListMapper.toDto(storeCommonShippingList);
    }

    /**
     * Get all the storeCommonShippingLists.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<StoreCommonShippingListDTO> findAll(Pageable pageable) {
        log.debug("Request to get all StoreCommonShippingLists");
        return storeCommonShippingListRepository.findAll(pageable)
            .map(storeCommonShippingListMapper::toDto);
    }

    /**
     * Get one storeCommonShippingList by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<StoreCommonShippingListDTO> findOne(Long id) {
        log.debug("Request to get StoreCommonShippingList : {}", id);
        return storeCommonShippingListRepository.findById(id)
            .map(storeCommonShippingListMapper::toDto);
    }

    /**
     * Delete the storeCommonShippingList by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete StoreCommonShippingList : {}", id);
        storeCommonShippingListRepository.deleteById(id);
    }

    @Override
    public List<StoreCommonShippingListDTO> getStoreCommonShippingAllList(Long storeId) {
        return storeCommonShippingListMapper.toDto(storeCommonShippingListRepository.findAllByStoreId(storeId));
    }

    @Override
    public List<StoreCommonShippingListDTO> batchSave(Long storeId, List<Long> shippingIds) {
        List<StoreCommonShippingList> allByStoreId = storeCommonShippingListRepository.findAllByStoreId(storeId);
        if (!CollectionUtils.isEmpty(shippingIds)) {
            if (!CollectionUtils.isEmpty(allByStoreId)) {
                List<Long> longList = allByStoreId.stream().map(StoreCommonShippingList::getId).collect(Collectors.toList());
                longList = longList.stream().filter(e -> !shippingIds.contains(e)).collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(longList)) {
                    longList.stream().forEach(e -> {
                        storeCommonShippingListRepository.deleteById(e);
                    });
                }
            }
            List<StoreCommonShippingList> storeCommonShippingLists = new ArrayList<>();
            shippingIds.stream().forEach(e -> {
                StoreCommonShippingList storeCommonShippingList = new StoreCommonShippingList();
                storeCommonShippingList.setShippingId(e);
                storeCommonShippingList.setStoreId(storeId);
                storeCommonShippingLists.add(storeCommonShippingList);
            });
            List<StoreCommonShippingList> shippingLists = storeCommonShippingListRepository.saveAll(storeCommonShippingLists);
            return storeCommonShippingListMapper.toDto(shippingLists);
        }
        return null;
    }
}
