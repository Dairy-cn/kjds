package com.cross.merchants.service;

import com.cross.merchants.domain.GoodsProperty;
import com.cross.merchants.service.dto.GoodsPropertyDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.GoodsProperty}.
 */
public interface GoodsPropertyService {

    /**
     * Save a goodsProperty.
     *
     * @param goodsPropertyDTO the entity to save.
     * @return the persisted entity.
     */
    GoodsPropertyDTO save(GoodsPropertyDTO goodsPropertyDTO);

    /**
     * Get all the goodsProperties.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<GoodsPropertyDTO> findAll(Pageable pageable);

    /**
     * Get the "id" goodsProperty.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<GoodsPropertyDTO> findOne(Long id);

    /**
     * Delete the "id" goodsProperty.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    boolean saveAll(List<GoodsPropertyDTO> dtos);

    Map<Long, List<GoodsPropertyDTO>> findAllByIdGoodsInGroupById(List<Long> ids);

    List<GoodsPropertyDTO> findAllByIdGoods(Long id);

}
