package com.cross.merchants.service;

import com.cross.merchants.service.dto.GoodsCategoryDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.GoodsCategory}.
 */
public interface GoodsCategoryService {

    /**
     * Save a goodsCategory.
     *
     * @param goodsCategoryDTO the entity to save.
     * @return the persisted entity.
     */
    GoodsCategoryDTO save(GoodsCategoryDTO goodsCategoryDTO);

    /**
     * Get all the goodsCategories.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<GoodsCategoryDTO> findAll(Pageable pageable);

    List<GoodsCategoryDTO> findAll();

    List<GoodsCategoryDTO> findAllByLevel(Integer level);

    List<GoodsCategoryDTO> findAllByPidIn(List<Long> pids);


    List<GoodsCategoryDTO> findAllByPid(Long pid);

    /**
     * Get the "id" goodsCategory.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<GoodsCategoryDTO> findOne(Long id);

    /**
     * Delete the "id" goodsCategory.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);


    boolean stickGoodsCategory(Long id);


    Map<Long,GoodsCategoryDTO> findAllByInInWithParentInfo(List<Long> ids);
}
