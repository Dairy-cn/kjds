package com.cross.merchants.service.impl;

import com.cross.merchants.domain.GoodsCategory;
import com.cross.merchants.domain.GoodsProperty;
import com.cross.merchants.domain.GoodsSku;
import com.cross.merchants.exception.MerchantsException;
import com.cross.merchants.repository.GoodsCategoryRepository;
import com.cross.merchants.repository.GoodsPropertyRepository;
import com.cross.merchants.repository.GoodsSkuRepository;
import com.cross.merchants.service.GoodsPropertyService;
import com.cross.merchants.service.GoodsService;
import com.cross.merchants.domain.Goods;
import com.cross.merchants.repository.GoodsRepository;
import com.cross.merchants.service.GoodsSkuService;
import com.cross.merchants.service.dto.GoodsDTO;
import com.cross.merchants.service.dto.GoodsPropertyDTO;
import com.cross.merchants.service.dto.GoodsPropertyTagDTO;
import com.cross.merchants.service.dto.GoodsSkuDTO;
import com.cross.merchants.service.mapper.GoodsMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Goods}.
 */
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

    private final Logger log = LoggerFactory.getLogger(GoodsServiceImpl.class);

    private final GoodsRepository goodsRepository;

    private final GoodsMapper goodsMapper;

    private final GoodsSkuService goodsSkuService;

    private final GoodsSkuRepository goodsSkuRepository;

    private final GoodsPropertyRepository goodsPropertyRepository;


    private final GoodsPropertyService goodsPropertyService;

    private final GoodsCategoryRepository goodsCategoryRepository;

    public GoodsServiceImpl(GoodsRepository goodsRepository, GoodsMapper goodsMapper, GoodsSkuService goodsSkuService, GoodsSkuRepository goodsSkuRepository, GoodsPropertyRepository goodsPropertyRepository, GoodsPropertyService goodsPropertyService, GoodsCategoryRepository goodsCategoryRepository) {
        this.goodsRepository = goodsRepository;
        this.goodsMapper = goodsMapper;
        this.goodsSkuService = goodsSkuService;
        this.goodsSkuRepository = goodsSkuRepository;
        this.goodsPropertyRepository = goodsPropertyRepository;
        this.goodsPropertyService = goodsPropertyService;
        this.goodsCategoryRepository = goodsCategoryRepository;
    }

    /**
     * Save a goods.
     *
     * @param goodsDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    @Transactional
    public GoodsDTO save(GoodsDTO goodsDTO) {
        log.debug("Request to save Goods : {}", goodsDTO);
        checkParam(goodsDTO);
        Goods goods = goodsMapper.toEntity(goodsDTO);
        goods = goodsRepository.save(goods);
        if (goodsDTO.getId() == null) {
            //添加sku
            if (!CollectionUtils.isEmpty(goodsDTO.getGoodsSkuDTOS())) {
                Goods finalGoods = goods;

                goodsDTO.getGoodsSkuDTOS().stream().forEach(e -> {
                    e.setGoodsId(finalGoods.getId());
                    e.setDeleteFlag(false);
                });
                goodsSkuService.saveAll(goodsDTO.getGoodsSkuDTOS());
            }
            //添加属性
            if (!CollectionUtils.isEmpty(goodsDTO.getGoodsPropertyDTOS())) {
                Goods finalGoods = goods;
                goodsDTO.getGoodsPropertyDTOS().stream().forEach(e -> {
                    e.setGoodsId(finalGoods.getId());
                    e.setDeleteFlag(false);
                });
                goodsPropertyService.saveAll(goodsDTO.getGoodsPropertyDTOS());
            }

        } else {
            //更新sku信息
            List<GoodsSku> dbGoodsSku = goodsSkuRepository.findAllByGoodsIdAndDeleteFlag(goodsDTO.getId(), false);
            List<Long> dbIds = dbGoodsSku.stream().map(e -> e.getId()).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(goodsDTO.getGoodsSkuDTOS())) {
                List<Long> updateIds = goodsDTO.getGoodsSkuDTOS().stream().filter(e -> e.getId() != null).map(GoodsSkuDTO::getId).collect(Collectors.toList());
                dbIds = dbIds.stream().filter(e -> updateIds.contains(e)).collect(Collectors.toList());
            }
            if (!CollectionUtils.isEmpty(dbIds)) {
                goodsSkuRepository.deleteByIdIn(dbIds);
            }
            if (!CollectionUtils.isEmpty(goodsDTO.getGoodsSkuDTOS())) {
                Goods finalGoods1 = goods;
                goodsDTO.getGoodsSkuDTOS().stream().forEach(e -> {
                    e.setGoodsId(finalGoods1.getId());
                    e.setDeleteFlag(false);
                });
                goodsSkuService.saveAll(goodsDTO.getGoodsSkuDTOS());
            }

            //更新属性信息
            List<GoodsProperty> goodsProperties = goodsPropertyRepository.findAllByGoodsIdAndDeleteFlag(goodsDTO.getId(), false);
            List<Long> dbGoodsPropertiesIds = goodsProperties.stream().map(e -> e.getId()).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(goodsDTO.getGoodsPropertyDTOS())) {
                List<Long> updatePropertiesIds = goodsDTO.getGoodsPropertyDTOS().stream().filter(e -> e.getId() != null).map(GoodsPropertyDTO::getId).collect(Collectors.toList());
                dbGoodsPropertiesIds = dbGoodsPropertiesIds.stream().filter(e -> updatePropertiesIds.contains(e)).collect(Collectors.toList());
            }
            if (!CollectionUtils.isEmpty(dbGoodsPropertiesIds)) {
                goodsPropertyRepository.deleteByIdIn(dbGoodsPropertiesIds);
            }
            if (!CollectionUtils.isEmpty(goodsDTO.getGoodsPropertyDTOS())) {
                Goods finalGoods1 = goods;
                goodsDTO.getGoodsPropertyDTOS().stream().forEach(e -> {
                    e.setGoodsId(finalGoods1.getId());
                    e.setDeleteFlag(false);
                });
                goodsPropertyService.saveAll(goodsDTO.getGoodsPropertyDTOS());
            }
        }
        return goodsMapper.toDto(goods);
    }

    @Override
    public GoodsDTO saveOnly(GoodsDTO goodsDTO) {
        return goodsMapper.toDto(goodsRepository.save(goodsMapper.toEntity(goodsDTO)));
    }

    private boolean checkParam(GoodsDTO goodsDTO) {
        Goods dbGoods = goodsRepository.findFirstByStoreIdAndBrandIdAndGoodsNameAndDeleteFlag(goodsDTO.getStoreId(), goodsDTO.getBrandId(), goodsDTO.getGoodsName(), false);
        if (dbGoods != null) {
            if (goodsDTO.getId() != null || goodsDTO.getId() != dbGoods.getId()) {
                throw new MerchantsException(400, "该店铺下已存在相同名称的商品");
            }
        }
        if (goodsDTO.getGoodsSkuDTOS() != null) {
            Set<String> nameSet = goodsDTO.getGoodsSkuDTOS().stream().map(GoodsSkuDTO::getName).collect(Collectors.toSet());
            if (nameSet.size() != goodsDTO.getGoodsSkuDTOS().size()) {
                throw new MerchantsException(400, "商品规格名称不能重复");
            }
        }
        if (goodsDTO.getGoodsPropertyDTOS() != null) {
            Set<String> nameSet = goodsDTO.getGoodsPropertyDTOS().stream().map(GoodsPropertyDTO::getName).collect(Collectors.toSet());
            if (nameSet.size() != goodsDTO.getGoodsPropertyDTOS().size()) {
                throw new MerchantsException(400, "商品属性名称不能重复");
            }
            goodsDTO.getGoodsPropertyDTOS().stream().forEach(e -> {
                List<GoodsPropertyTagDTO> tagDTOS = e.getGoodsPropertyTagDTOS();
                if (!CollectionUtils.isEmpty(tagDTOS)) {
                    Set<String> tagSet = tagDTOS.stream().map(GoodsPropertyTagDTO::getName).collect(Collectors.toSet());
                    if (tagSet.size() != tagDTOS.size()) {
                        throw new MerchantsException(400, "商品属性标签不能重复");
                    }
                }
            });
        }
        return true;
    }

    /**
     * Get all the goods.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<GoodsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Goods");
        return goodsRepository.findAll(pageable)
            .map(goodsMapper::toDto);
    }

    @Override
    public Page<GoodsDTO> getAllGoodsByCondition(Pageable pageable, Long storeId, Long brandId, Boolean saleState, Integer checkState, Instant startTime, Instant endTime, String keyWord, Integer goodsType) {


        Page<Goods> page = goodsRepository.findAll((r, q, b) -> {
            List<Predicate> listPredicates = new ArrayList<>();
            if (storeId != null) {
                listPredicates.add(b.equal(r.get("storeId").as(Long.class), storeId));
            }
            if (brandId != null) {
                listPredicates.add(b.equal(r.get("brandId").as(Long.class), brandId));
            }
            if (saleState != null) {
                listPredicates.add(b.equal(r.get("saleState").as(Boolean.class), saleState));
            }
            if (checkState != null) {
                listPredicates.add(b.equal(r.get("checkStatus").as(Integer.class), checkState));
            }
            if (goodsType != null && 1 == goodsType) {
                listPredicates.add(b.equal(r.get("checkStatus").as(Integer.class), 1));
            } else if (goodsType != null && 2 == goodsType) {
                listPredicates.add(b.notEqual(r.get("checkStatus").as(Integer.class), 1));
            }

            if (!StringUtils.isBlank(keyWord)) {
                List<Predicate> listPermission = new ArrayList<>();
                listPermission.add(b.like(r.get("goodsNo").as(String.class), "%" + keyWord.trim() + "%"));
                listPermission.add(b.like(r.get("goodsName").as(String.class), "%" + keyWord.trim() + "%"));
                Predicate[] predicatesPermissionArr = new Predicate[listPermission.size()];
                listPredicates.add(b.or(listPermission.toArray(predicatesPermissionArr)));
            }
            if (startTime != null) {
                listPredicates.add(b.greaterThanOrEqualTo(r.get("applicationTime").as(Instant.class), startTime));
            }
            if (endTime != null) {
                listPredicates.add(b.lessThanOrEqualTo(r.get("applicationTime").as(Instant.class), endTime));
            }

            Predicate[] arrayPredicates = new Predicate[listPredicates.size()];
            return b.and(listPredicates.toArray(arrayPredicates));
        }, pageable);
        return page.map(goodsMapper::toDto);
    }

    @Override
    public Page<GoodsDTO> getAllGoodsByCondition(Pageable pageable, Long storeId, Long brandId, Integer checkState, Instant startTime, Instant endTime, String keyWord, Instant startCheckTime, Instant endCheckTime, Long oneCategoryId, Long twoCategoryId, Long thirdCategoryId) {
        List<Long> twoList = new ArrayList<>();
        List<Long> thirdList = new ArrayList<>();
        if (oneCategoryId != null) {
            twoList = goodsCategoryRepository.findAllByPid(oneCategoryId).stream().map(GoodsCategory::getId).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(twoList)) {
                if (twoCategoryId != null) {
                    twoList = twoList.stream().filter(e -> e == twoCategoryId).collect(Collectors.toList());
                }
            }
        }
        if (twoCategoryId != null) {
            twoList.add(twoCategoryId);
        }
        if (!CollectionUtils.isEmpty(twoList)) {
            twoList = twoList.stream().distinct().collect(Collectors.toList());
            thirdList = goodsCategoryRepository.findAllByPidIn(twoList).stream().map(GoodsCategory::getId).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(thirdList)) {
                if (thirdCategoryId != null) {
                    thirdList = thirdList.stream().filter(e -> e == thirdCategoryId).collect(Collectors.toList());
                }
            }
        }
        if (thirdCategoryId != null) {
            thirdList.add(twoCategoryId);
        }
        if (!CollectionUtils.isEmpty(thirdList)) {
            thirdList = thirdList.stream().distinct().collect(Collectors.toList());
        }
        List<Long> finalThirdList = thirdList;

        Page<Goods> page = goodsRepository.findAll((r, q, b) -> {
            List<Predicate> listPredicates = new ArrayList<>();
            if (storeId != null) {
                listPredicates.add(b.equal(r.get("storeId").as(Long.class), storeId));
            }
            if (brandId != null) {
                listPredicates.add(b.equal(r.get("brandId").as(Long.class), brandId));
            }

            if (checkState != null) {
                listPredicates.add(b.equal(r.get("checkStatus").as(Integer.class), checkState));
            }
            if (!CollectionUtils.isEmpty(finalThirdList)){
                CriteriaBuilder.In<Long> in = b.in(r.get("categoryId"));
                for (Long categoryId : finalThirdList) {
                    in.value(categoryId);
                }
                listPredicates.add(in);
            }
            if (!StringUtils.isBlank(keyWord)) {
                List<Predicate> listPermission = new ArrayList<>();
                listPermission.add(b.like(r.get("spuNo").as(String.class), "%" + keyWord.trim() + "%"));
                listPermission.add(b.like(r.get("goodsName").as(String.class), "%" + keyWord.trim() + "%"));
                Predicate[] predicatesPermissionArr = new Predicate[listPermission.size()];
                listPredicates.add(b.or(listPermission.toArray(predicatesPermissionArr)));
            }
            if (startTime != null) {
                listPredicates.add(b.greaterThanOrEqualTo(r.get("applicationTime").as(Instant.class), startTime));
            }
            if (endTime != null) {
                listPredicates.add(b.lessThanOrEqualTo(r.get("applicationTime").as(Instant.class), endTime));
            }

            if (startCheckTime != null) {
                listPredicates.add(b.greaterThanOrEqualTo(r.get("checkTime").as(Instant.class), startCheckTime));
            }
            if (endCheckTime != null) {
                listPredicates.add(b.lessThanOrEqualTo(r.get("checkTime").as(Instant.class), endCheckTime));
            }
            Predicate[] arrayPredicates = new Predicate[listPredicates.size()];
            return b.and(listPredicates.toArray(arrayPredicates));
        }, pageable);
        return page.map(goodsMapper::toDto);
    }

    /**
     * Get one goods by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<GoodsDTO> findOne(Long id) {
        log.debug("Request to get Goods : {}", id);
        return goodsRepository.findById(id)
            .map(goodsMapper::toDto);
    }

    /**
     * Delete the goods by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Goods : {}", id);
        goodsRepository.deleteById(id);
    }
}
