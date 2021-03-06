package com.cross.merchants.service;

import com.cross.merchants.service.dto.GoodsDTO;

import com.cross.merchants.service.dto.GoodsRecommendDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
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

    GoodsDTO saveOnly(GoodsDTO goodsDTO);

    GoodsDTO reCheckGoods(GoodsDTO goodsDTO);

    /**
     * Get all the goods.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<GoodsDTO> findAll(Pageable pageable);


    Page<GoodsDTO> getAllGoodsByCondition(Pageable pageable, Long storeId, Long brandId, Boolean saleState, Integer checkState, Instant startTime, Instant endTime, String keyWord, Integer goodsType);


    Page<GoodsDTO> getAllGoodsByCondition(Pageable pageable, Long storeId, Long brandId, Integer checkState, Instant startTime, Instant endTime, String keyWord, Instant startCheckTime, Instant endCheckTime, Long oneCategoryId, Long twoCategoryId, Long thirdCategoryId);

    List<GoodsDTO> getAllGoodsByConditionNoPage(Long storeId, Long brandId, Integer checkState, Instant startTime, Instant endTime, String keyWord, Instant startCheckTime, Instant endCheckTime, Long oneCategoryId, Long twoCategoryId, Long thirdCategoryId);

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

    Map<Long, GoodsDTO> finAllMapInfo(List<Long> ids);

    List<GoodsDTO> findAllByCategoryIdAndKeywordAndCheckStateAndSaleState(Long storeId, Long categoryId, String keyword, Boolean saleState, Integer checkState);

    List<GoodsDTO> findAllById(List<Long> ids);

    GoodsDTO getOne(Long id);


    List<GoodsDTO> findAllByBrandIdIn(List<Long> ids);


    List<GoodsDTO> findAllByStoreIdIn(List<Long> ids);

    Page<GoodsDTO> findAllByStoreId(Pageable pageable, Long storeId);


    List<GoodsDTO> queryGoodsList(String keyword, Long storeId);

    List<GoodsDTO> guessYouWillLike();

    Page<GoodsDTO> getAllGoodsByConditionByC(Pageable pageable, Long oneCategoryId, Long twoCategoryId, Long thirdCategoryId, BigDecimal minPrice, BigDecimal maxPrice, Integer sortType, Integer order,Long brandId);
}
