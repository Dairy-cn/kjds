package com.cross.merchants.service;

import com.cross.merchants.service.dto.GoodsDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.Goods}.
 */
public interface GoodsService {

    /**
     * Save a goods.
     *
     * @param goodsDTO the entity to save.
     * @return the persisted entity.
     */
    GoodsDTO save(GoodsDTO goodsDTO);

    /**
     * Get all the goods.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<GoodsDTO> findAll(Pageable pageable);


    Page<GoodsDTO> getAllGoodsByCondition(Pageable pageable, Long storeId, Long brandId, Boolean saleState, Integer checkState, Instant startTime, Instant endTime, String keyWord, Integer goodsType);



    /**
     * Get the "id" goods.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<GoodsDTO> findOne(Long id);

    /**
     * Delete the "id" goods.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}