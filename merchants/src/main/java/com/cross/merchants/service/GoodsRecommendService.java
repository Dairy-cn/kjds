package com.cross.merchants.service;

import com.cross.merchants.service.dto.GoodsRecommendDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.GoodsRecommend}.
 */
public interface GoodsRecommendService {

    /**
     * Save a goodsRecommend.
     *
     * @param goodsRecommendDTO the entity to save.
     * @return the persisted entity.
     */
    GoodsRecommendDTO save(GoodsRecommendDTO goodsRecommendDTO);

    /**
     * Get all the goodsRecommends.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<GoodsRecommendDTO> findAll(Pageable pageable);

    /**
     * Get the "id" goodsRecommend.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<GoodsRecommendDTO> findOne(Long id);

    /**
     * Delete the "id" goodsRecommend.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);


    boolean topGoodsRecommend(Long id);

    GoodsRecommendDTO getOne(Long id);

    Page<GoodsRecommendDTO> findAllByType(Pageable pageable,Integer type);



}
