package com.cross.merchants.service;


import com.cross.merchants.service.dto.GoodsRecommendBannerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.GoodsRecommendBanner}.
 */
public interface GoodsRecommendBannerService {

    /**
     * Save a goodsRecommendBrand.
     *
     * @param goodsRecommendBrandDTO the entity to save.
     * @return the persisted entity.
     */
    GoodsRecommendBannerDTO save(GoodsRecommendBannerDTO goodsRecommendBrandDTO);

    /**
     * Get all the goodsRecommendBrands.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<GoodsRecommendBannerDTO> findAll(Pageable pageable);

    Page<GoodsRecommendBannerDTO> findAllByC(Pageable pageable);


    List<GoodsRecommendBannerDTO> findAll();

    /**
     * Get the "id" goodsRecommendBrand.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<GoodsRecommendBannerDTO> findOne(Long id);

    /**
     * Delete the "id" goodsRecommendBrand.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);


    GoodsRecommendBannerDTO getOne(Long id);

    boolean updateGoodsBannerInfoTopState(Long id);


    Map<Long, GoodsRecommendBannerDTO> finAllMapInfo(List<Long> ids);

    List<GoodsRecommendBannerDTO> finAllListInfo(List<Long> ids);

}
