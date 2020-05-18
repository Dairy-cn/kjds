package com.cross.merchants.service;

import com.cross.merchants.domain.GoodsSku;
import com.cross.merchants.service.dto.GoodsSkuDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.GoodsSku}.
 */
public interface GoodsSkuService {

    /**
     * Save a goodsSku.
     *
     * @param goodsSkuDTO the entity to save.
     * @return the persisted entity.
     */
    GoodsSkuDTO save(GoodsSkuDTO goodsSkuDTO);

    /**
     * Get all the goodsSkus.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<GoodsSkuDTO> findAll(Pageable pageable);

    /**
     * Get the "id" goodsSku.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<GoodsSkuDTO> findOne(Long id);

    /**
     * Delete the "id" goodsSku.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);


    Map<Long, List<GoodsSkuDTO>> findAllByIdGoodsInGroupById(List<Long> goodsIds);

    List<GoodsSkuDTO> findAllByGoodsId(Long goodsId);

    List<GoodsSku> saveAll(List<GoodsSkuDTO> goodsSkuDTOs);
}
