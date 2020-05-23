package com.cross.merchants.service.impl;

import com.cross.merchants.exception.MerchantsException;
import com.cross.merchants.service.StoreRecommendService;
import com.cross.merchants.domain.StoreRecommend;
import com.cross.merchants.repository.StoreRecommendRepository;
import com.cross.merchants.service.dto.StoreRecommendDTO;
import com.cross.merchants.service.mapper.StoreRecommendMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link StoreRecommend}.
 */
@Service
@Transactional
public class StoreRecommendServiceImpl implements StoreRecommendService {

    private final Logger log = LoggerFactory.getLogger(StoreRecommendServiceImpl.class);

    private final StoreRecommendRepository storeRecommendRepository;

    private final StoreRecommendMapper storeRecommendMapper;

    public StoreRecommendServiceImpl(StoreRecommendRepository storeRecommendRepository, StoreRecommendMapper storeRecommendMapper) {
        this.storeRecommendRepository = storeRecommendRepository;
        this.storeRecommendMapper = storeRecommendMapper;
    }

    /**
     * Save a storeRecommend.
     *
     * @param storeRecommendDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public StoreRecommendDTO save(StoreRecommendDTO storeRecommendDTO) {
        log.debug("Request to save StoreRecommend : {}", storeRecommendDTO);
        checkParam(storeRecommendDTO);
        StoreRecommend storeRecommend = storeRecommendMapper.toEntity(storeRecommendDTO);
        storeRecommend = storeRecommendRepository.save(storeRecommend);
        return storeRecommendMapper.toDto(storeRecommend);
    }

    private boolean checkParam(StoreRecommendDTO storeRecommendDTO) {
        int count = storeRecommendRepository.countAllByStoreId(storeRecommendDTO.getStoreId());
        if (storeRecommendDTO.getId() == null && count > 0) {
            throw new MerchantsException(400, "该商户已添加到商户推荐,请勿重复添加");
        }
        long allCount = storeRecommendRepository.count();
        if (allCount >= 4) {
            throw new MerchantsException(400, "商户推荐最多可添加4条");
        }
        return true;
    }

    /**
     * Get all the storeRecommends.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<StoreRecommendDTO> findAll(Pageable pageable) {
        log.debug("Request to get all StoreRecommends");
        return storeRecommendRepository.findAll(pageable)
            .map(storeRecommendMapper::toDto);
    }

    /**
     * Get one storeRecommend by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<StoreRecommendDTO> findOne(Long id) {
        log.debug("Request to get StoreRecommend : {}", id);
        return storeRecommendRepository.findById(id)
            .map(storeRecommendMapper::toDto);
    }

    /**
     * Delete the storeRecommend by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete StoreRecommend : {}", id);
        storeRecommendRepository.deleteById(id);
    }

    @Override
    public List<StoreRecommendDTO> findAllList() {
        return storeRecommendMapper.toDto(storeRecommendRepository.findAllByOrderByTopDescIdDesc());
    }

    @Override
    public boolean topStoreRecommend(Long id) {
        storeRecommendRepository.updateTopStateFalse();
        storeRecommendRepository.updateTopStateTrueById(id);
        return true;
    }
}
