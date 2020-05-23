package com.cross.merchants.service;

import com.cross.merchants.domain.StoreRecommend;
import com.cross.merchants.service.dto.StoreRecommendDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.StoreRecommend}.
 */
public interface StoreRecommendService {

    /**
     * Save a storeRecommend.
     *
     * @param storeRecommendDTO the entity to save.
     * @return the persisted entity.
     */
    StoreRecommendDTO save(StoreRecommendDTO storeRecommendDTO);

    /**
     * Get all the storeRecommends.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<StoreRecommendDTO> findAll(Pageable pageable);

    /**
     * Get the "id" storeRecommend.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<StoreRecommendDTO> findOne(Long id);

    /**
     * Delete the "id" storeRecommend.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);


    List<StoreRecommendDTO> findAllList();


    boolean topStoreRecommend(Long id);
}
