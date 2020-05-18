package com.cross.merchants.service;

import com.cross.merchants.service.dto.GoodsPropertyTagDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.GoodsPropertyTag}.
 */
public interface GoodsPropertyTagService {

    /**
     * Save a goodsPropertyTag.
     *
     * @param goodsPropertyTagDTO the entity to save.
     * @return the persisted entity.
     */
    GoodsPropertyTagDTO save(GoodsPropertyTagDTO goodsPropertyTagDTO);

    /**
     * Get all the goodsPropertyTags.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<GoodsPropertyTagDTO> findAll(Pageable pageable);

    /**
     * Get the "id" goodsPropertyTag.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<GoodsPropertyTagDTO> findOne(Long id);

    /**
     * Delete the "id" goodsPropertyTag.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
