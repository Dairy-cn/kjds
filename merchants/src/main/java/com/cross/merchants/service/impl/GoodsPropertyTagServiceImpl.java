package com.cross.merchants.service.impl;

import com.cross.merchants.service.GoodsPropertyTagService;
import com.cross.merchants.domain.GoodsPropertyTag;
import com.cross.merchants.repository.GoodsPropertyTagRepository;
import com.cross.merchants.service.dto.GoodsPropertyTagDTO;
import com.cross.merchants.service.mapper.GoodsPropertyTagMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link GoodsPropertyTag}.
 */
@Service
@Transactional
public class GoodsPropertyTagServiceImpl implements GoodsPropertyTagService {

    private final Logger log = LoggerFactory.getLogger(GoodsPropertyTagServiceImpl.class);

    private final GoodsPropertyTagRepository goodsPropertyTagRepository;

    private final GoodsPropertyTagMapper goodsPropertyTagMapper;

    public GoodsPropertyTagServiceImpl(GoodsPropertyTagRepository goodsPropertyTagRepository, GoodsPropertyTagMapper goodsPropertyTagMapper) {
        this.goodsPropertyTagRepository = goodsPropertyTagRepository;
        this.goodsPropertyTagMapper = goodsPropertyTagMapper;
    }

    /**
     * Save a goodsPropertyTag.
     *
     * @param goodsPropertyTagDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public GoodsPropertyTagDTO save(GoodsPropertyTagDTO goodsPropertyTagDTO) {
        log.debug("Request to save GoodsPropertyTag : {}", goodsPropertyTagDTO);
        GoodsPropertyTag goodsPropertyTag = goodsPropertyTagMapper.toEntity(goodsPropertyTagDTO);
        goodsPropertyTag = goodsPropertyTagRepository.save(goodsPropertyTag);
        return goodsPropertyTagMapper.toDto(goodsPropertyTag);
    }

    /**
     * Get all the goodsPropertyTags.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<GoodsPropertyTagDTO> findAll(Pageable pageable) {
        log.debug("Request to get all GoodsPropertyTags");
        return goodsPropertyTagRepository.findAll(pageable)
            .map(goodsPropertyTagMapper::toDto);
    }

    /**
     * Get one goodsPropertyTag by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<GoodsPropertyTagDTO> findOne(Long id) {
        log.debug("Request to get GoodsPropertyTag : {}", id);
        return goodsPropertyTagRepository.findById(id)
            .map(goodsPropertyTagMapper::toDto);
    }

    /**
     * Delete the goodsPropertyTag by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete GoodsPropertyTag : {}", id);
        goodsPropertyTagRepository.deleteById(id);
    }
}
