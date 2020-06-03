package com.cross.merchants.service.impl;

import com.cross.merchants.domain.GoodsCategory;
import com.cross.merchants.domain.GoodsProperty;
import com.cross.merchants.domain.GoodsSku;
import com.cross.merchants.exception.MerchantsException;
import com.cross.merchants.repository.GoodsCategoryRepository;
import com.cross.merchants.repository.GoodsPropertyRepository;
import com.cross.merchants.repository.GoodsSkuRepository;
import com.cross.merchants.service.*;
import com.cross.merchants.domain.Goods;
import com.cross.merchants.repository.GoodsRepository;
import com.cross.merchants.service.dto.*;
import com.cross.merchants.service.mapper.GoodsCategoryMapper;
import com.cross.merchants.service.mapper.GoodsMapper;
import com.cross.merchants.service.mapper.GoodsSkuMapper;
import com.cross.merchants.web.rest.DTO.GoodEntity;
import com.cross.merchants.web.rest.vm.MerchantsCategoryCountVM;
import com.cross.utils.JpaSelectCastEntity;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.math.BigInteger;
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

    private final GoodsCategoryService goodsCategoryService;

    private final GoodsCategoryRepository goodsCategoryRepository;

    private final StoreInfoService storeInfoService;

    @Autowired
    private GoodsSkuMapper goodsSkuMapper;

    @PersistenceContext
    EntityManager entityManager;


    public GoodsServiceImpl(GoodsRepository goodsRepository, GoodsMapper goodsMapper, GoodsSkuService goodsSkuService, GoodsSkuRepository goodsSkuRepository, GoodsPropertyRepository goodsPropertyRepository, GoodsPropertyService goodsPropertyService, GoodsCategoryService goodsCategoryService, GoodsCategoryRepository goodsCategoryRepository, StoreInfoService storeInfoService) {
        this.goodsRepository = goodsRepository;
        this.goodsMapper = goodsMapper;
        this.goodsSkuService = goodsSkuService;
        this.goodsSkuRepository = goodsSkuRepository;
        this.goodsPropertyRepository = goodsPropertyRepository;
        this.goodsPropertyService = goodsPropertyService;
        this.goodsCategoryService = goodsCategoryService;
        this.goodsCategoryRepository = goodsCategoryRepository;
        this.storeInfoService = storeInfoService;
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
        if (goods.getId() != null) {
            Goods dbGoods = goodsRepository.getOne(goods.getId());
            goods.setSaleVolume(dbGoods.getSaleVolume());
            goods.setDeleteFlag(dbGoods.getDeleteFlag());
            goods.setGoodsNo(dbGoods.getGoodsNo());
            goods.setApplicationTime(dbGoods.getApplicationTime());
            goods.setCreateTime(dbGoods.getCreateTime());
            goods.setSaleState(dbGoods.getSaleState());
            goods.setCheckTime(dbGoods.getCheckTime());
            goods.setCheckStatus(dbGoods.getCheckStatus());
            goods.setCheckFailureReasons(dbGoods.getCheckFailureReasons());
            goods.setProposer(dbGoods.getProposer());
        } else {
            goods.setSaleVolume(0);
            goods.setDeleteFlag(false);
            goods.setApplicationTime(Instant.now());
            goods.setCreateTime(Instant.now());
        }
        goods = goodsRepository.save(goods);
        if (goodsDTO.getId() == null) {
            goodsDTO.setDeleteFlag(false);
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
                dbIds = dbIds.stream().filter(e -> !updateIds.contains(e)).collect(Collectors.toList());
            }
            if (!CollectionUtils.isEmpty(dbIds)) {
                goodsSkuRepository.deleteByIdIn(dbIds);
            }
            if (!CollectionUtils.isEmpty(goodsDTO.getGoodsSkuDTOS())) {
                Goods finalGoods1 = goods;
                goodsDTO.getGoodsSkuDTOS().stream().forEach(e -> {
                    e.setGoodsId(finalGoods1.getId());
                    e.setDeleteFlag(false);
                    if (e.getId() == null) {
                        e.setSaleVolume(0);
                        e.setLockStock(0);
                    }
                });
                goodsSkuService.saveAll(goodsDTO.getGoodsSkuDTOS());
            }

            //更新属性信息
            List<GoodsProperty> goodsProperties = goodsPropertyRepository.findAllByGoodsIdAndDeleteFlag(goodsDTO.getId(), false);
            List<Long> dbGoodsPropertiesIds = goodsProperties.stream().map(e -> e.getId()).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(goodsDTO.getGoodsPropertyDTOS())) {
                List<Long> updatePropertiesIds = goodsDTO.getGoodsPropertyDTOS().stream().filter(e -> e.getId() != null).map(GoodsPropertyDTO::getId).collect(Collectors.toList());
                dbGoodsPropertiesIds = dbGoodsPropertiesIds.stream().filter(e -> !updatePropertiesIds.contains(e)).collect(Collectors.toList());
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

    @Override
    public GoodsDTO reCheckGoods(GoodsDTO goodsDTO) {
        log.debug("Request to save Goods : {}", goodsDTO);
        checkParam(goodsDTO);
        Goods goods = goodsMapper.toEntity(goodsDTO);
        if (goods.getId() != null) {
            Goods dbGoods = goodsRepository.getOne(goods.getId());
            goods.setSaleVolume(dbGoods.getSaleVolume());
            goods.setGoodsNo(dbGoods.getGoodsNo());
            goods.setCreateTime(dbGoods.getCreateTime());
        } else {
            goods.setSaleVolume(0);
            goods.setDeleteFlag(false);
            goods.setApplicationTime(Instant.now());
            goods.setCreateTime(Instant.now());
        }
        goods = goodsRepository.save(goods);
        if (goodsDTO.getId() == null) {
            goodsDTO.setDeleteFlag(false);
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
                dbIds = dbIds.stream().filter(e -> !updateIds.contains(e)).collect(Collectors.toList());
            }
            if (!CollectionUtils.isEmpty(dbIds)) {
                goodsSkuRepository.deleteByIdIn(dbIds);
            }
            if (!CollectionUtils.isEmpty(goodsDTO.getGoodsSkuDTOS())) {
                Goods finalGoods1 = goods;
                goodsDTO.getGoodsSkuDTOS().stream().forEach(e -> {
                    e.setGoodsId(finalGoods1.getId());
                    e.setDeleteFlag(false);
                    if (e.getId() == null) {
                        e.setSaleVolume(0);
                        e.setLockStock(0);
                    }
                });
                goodsSkuService.saveAll(goodsDTO.getGoodsSkuDTOS());
            }

            //更新属性信息
            List<GoodsProperty> goodsProperties = goodsPropertyRepository.findAllByGoodsIdAndDeleteFlag(goodsDTO.getId(), false);
            List<Long> dbGoodsPropertiesIds = goodsProperties.stream().map(e -> e.getId()).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(goodsDTO.getGoodsPropertyDTOS())) {
                List<Long> updatePropertiesIds = goodsDTO.getGoodsPropertyDTOS().stream().filter(e -> e.getId() != null).map(GoodsPropertyDTO::getId).collect(Collectors.toList());
                dbGoodsPropertiesIds = dbGoodsPropertiesIds.stream().filter(e -> !updatePropertiesIds.contains(e)).collect(Collectors.toList());
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

    private boolean checkParam(GoodsDTO goodsDTO) {
        Goods dbGoods = goodsRepository.findFirstByStoreIdAndBrandIdAndGoodsNameAndDeleteFlag(goodsDTO.getStoreId(), goodsDTO.getBrandId(), goodsDTO.getGoodsName(), false);
        if (dbGoods != null) {
            if (goodsDTO.getId() == null || (goodsDTO.getId() != null && goodsDTO.getId() != dbGoods.getId())) {
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
            listPredicates.add(b.notEqual(r.get("deleteFlag").as(Boolean.class), true));
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
            thirdList.add(thirdCategoryId);
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
            listPredicates.add(b.notEqual(r.get("deleteFlag").as(Boolean.class), true));
            if (checkState != null) {
                listPredicates.add(b.equal(r.get("checkStatus").as(Integer.class), checkState));
            }
            if (!CollectionUtils.isEmpty(finalThirdList)) {
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



    @Override
    public List<GoodsDTO> getAllGoodsByConditionNoPage(Long storeId, Long brandId, Integer checkState, Instant startTime, Instant endTime, String keyWord, Instant startCheckTime, Instant endCheckTime, Long oneCategoryId, Long twoCategoryId, Long thirdCategoryId) {
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
            thirdList.add(thirdCategoryId);
        }
        if (!CollectionUtils.isEmpty(thirdList)) {
            thirdList = thirdList.stream().distinct().collect(Collectors.toList());
        }
        List<Long> finalThirdList = thirdList;

        List<Goods> page = goodsRepository.findAll((r, q, b) -> {
            List<Predicate> listPredicates = new ArrayList<>();
            if (storeId != null) {
                listPredicates.add(b.equal(r.get("storeId").as(Long.class), storeId));
            }
            if (brandId != null) {
                listPredicates.add(b.equal(r.get("brandId").as(Long.class), brandId));
            }
            listPredicates.add(b.notEqual(r.get("deleteFlag").as(Boolean.class), true));
            if (checkState != null) {
                listPredicates.add(b.equal(r.get("checkStatus").as(Integer.class), checkState));
            }
            if (!CollectionUtils.isEmpty(finalThirdList)) {
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
        });
        return goodsMapper.toDto(page);
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

    @Override
    public Map<Long, GoodsDTO> finAllMapInfo(List<Long> ids) {
        Map<Long, GoodsDTO> map = new HashMap<>();
        if (!CollectionUtils.isEmpty(ids)) {
            List<Goods> allByIdIn = goodsRepository.findAllByIdIn(ids);
            List<Long> categoryIds = allByIdIn.stream().filter(e -> e.getCategoryId() != null).map(Goods::getCategoryId).collect(Collectors.toList());
            List<Long> storeIds = allByIdIn.stream().filter(e -> e.getStoreId() != null).map(Goods::getStoreId).collect(Collectors.toList());

            Map<Long, GoodsCategoryDTO> goodsCategoryDTOMap = new HashMap<>();
            if (!CollectionUtils.isEmpty(categoryIds)) {
                goodsCategoryDTOMap = goodsCategoryService.findAllByInInWithParentInfo(categoryIds);
            }
            List<GoodsDTO> goodsDTOS = goodsMapper.toDto(allByIdIn);
            Map<Long, GoodsCategoryDTO> finalGoodsCategoryDTOMap = goodsCategoryDTOMap;
            goodsDTOS.stream().filter(e -> e.getCategoryId() != null).forEach(e -> {
                e.setGoodsCategoryDTO(finalGoodsCategoryDTOMap.get(e.getCategoryId()));
            });
            Map<Long, StoreInfoDTO> storeInfoDTOMap = new HashMap<>();

            if (!CollectionUtils.isEmpty(storeIds)) {
                List<StoreInfoDTO> storeInfoDTOS = storeInfoService.findAllByIdIn(storeIds);
                storeInfoDTOMap = storeInfoDTOS.stream().collect(Collectors.toMap(StoreInfoDTO::getId, e -> e));
            }
            Map<Long, StoreInfoDTO> finalStoreInfoDTOMap = storeInfoDTOMap;
            goodsDTOS.stream().filter(e -> e.getStoreId() != null).forEach(e -> {
                e.setStoreInfoDTO(finalStoreInfoDTOMap.get(e.getStoreId()));
            });
            return goodsDTOS.stream().collect(Collectors.toMap(GoodsDTO::getId, e -> e));
        }
        return map;
    }

    @Override
    public List<GoodsDTO> findAllByCategoryIdAndKeywordAndCheckStateAndSaleState(Long storeId, Long categoryId, String keyword, Boolean saleState, Integer checkState) {
        List<Goods> list = goodsRepository.findAll((r, q, b) -> {
            List<Predicate> listPredicates = new ArrayList<>();

            if (storeId != null) {
                listPredicates.add(b.equal(r.get("storeId").as(Long.class), storeId));
            }
            if (categoryId != null) {
                listPredicates.add(b.equal(r.get("categoryId").as(Long.class), categoryId));
            }
            if (saleState != null) {
                listPredicates.add(b.equal(r.get("saleState").as(Boolean.class), saleState));
            }
            listPredicates.add(b.notEqual(r.get("deleteFlag").as(Boolean.class), true));
            if (checkState != null) {
                listPredicates.add(b.equal(r.get("checkStatus").as(Integer.class), checkState));
            }

            if (!StringUtils.isBlank(keyword)) {
                List<Predicate> listPermission = new ArrayList<>();
                listPermission.add(b.like(r.get("goodsNo").as(String.class), "%" + keyword.trim() + "%"));
                listPermission.add(b.like(r.get("goodsName").as(String.class), "%" + keyword.trim() + "%"));
                Predicate[] predicatesPermissionArr = new Predicate[listPermission.size()];
                listPredicates.add(b.or(listPermission.toArray(predicatesPermissionArr)));
            }
            Predicate[] arrayPredicates = new Predicate[listPredicates.size()];
            return b.and(listPredicates.toArray(arrayPredicates));
        });
        return goodsMapper.toDto(list);
    }

    @Override
    public List<GoodsDTO> findAllById(List<Long> ids) {
        List<GoodsDTO> goodsDTOS = goodsMapper.toDto(goodsRepository.findAllByIdInAndDeleteFlag(ids, false));
        if (!CollectionUtils.isEmpty(goodsDTOS)) {
            List<Long> goodsIds = goodsDTOS.stream().map(GoodsDTO::getId).collect(Collectors.toList());
            List<GoodsSku> goodsSkus = goodsSkuRepository.findAllByGoodsIdInAndDeleteFlag(goodsIds, false);
            List<GoodsSkuDTO> goodsSkuDTOS = goodsSkuMapper.toDto(goodsSkus);
            Map<Long, List<GoodsSkuDTO>> goodsSkuMap = goodsSkuDTOS.stream().collect(Collectors.groupingBy(GoodsSkuDTO::getGoodsId));
            goodsDTOS.stream().forEach(e -> {
                e.setGoodsSkuDTOS(goodsSkuMap.get(e.getId()));
            });
            return goodsDTOS;
        }
        return null;
    }

    @Override
    public GoodsDTO getOne(Long id) {
        return goodsMapper.toDto(goodsRepository.getByIdAndDeleteFlag(id, false));
    }

    @Override
    public List<GoodsDTO> findAllByBrandIdIn(List<Long> ids) {

        List<Object[]> objects = goodsRepository.findAllByBrandIdInAndDeleteFlag(ids);
        List<GoodEntity> bigIntegers = new ArrayList<>();
        try {
            bigIntegers = JpaSelectCastEntity.castEntity(objects, GoodEntity.class);
        } catch (Exception e1) {
            log.error("类转化失败" + e1.getMessage());
            e1.printStackTrace();
        }
        List<Long> idList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(bigIntegers)) {
            idList = bigIntegers.stream().map(GoodEntity::getId).map(BigInteger::longValue).collect(Collectors.toList());
        }
        List<GoodsDTO> goodsDTOS = goodsMapper.toDto(goodsRepository.findAllByIdIn(idList));
        if (!CollectionUtils.isEmpty(goodsDTOS)) {
            List<Long> goodsIds = goodsDTOS.stream().map(GoodsDTO::getId).collect(Collectors.toList());
            List<GoodsSku> goodsSkus = goodsSkuRepository.findAllByGoodsIdInAndDeleteFlag(goodsIds, false);
            List<GoodsSkuDTO> goodsSkuDTOS = goodsSkuMapper.toDto(goodsSkus);
            Map<Long, List<GoodsSkuDTO>> goodsSkuMap = goodsSkuDTOS.stream().collect(Collectors.groupingBy(GoodsSkuDTO::getGoodsId));
            goodsDTOS.stream().forEach(e -> {
                e.setGoodsSkuDTOS(goodsSkuMap.get(e.getId()));
            });
            return goodsDTOS;
        }
        return null;
    }

    @Override
    public Page<GoodsDTO> findAllByStoreId(Pageable pageable, Long storeId) {
        Page<Goods> goodsList = goodsRepository.findAllByStoreIdAndDeleteFlag(pageable, storeId, false);
        if (!CollectionUtils.isEmpty(goodsList.getContent())) {
            List<Long> longList = goodsList.getContent().stream().map(Goods::getId).collect(Collectors.toList());
            List<Object[]> objects = goodsSkuRepository.findAllByGoodsIdInAndDeleteFlag(longList);
            List<GoodEntity> bigIntegers = new ArrayList<>();
            try {
                bigIntegers = JpaSelectCastEntity.castEntity(objects, GoodEntity.class);
            } catch (Exception e1) {
                log.error("类转化失败" + e1.getMessage());
                e1.printStackTrace();
            }
            List<Long> idList = new ArrayList<>();
            if (!CollectionUtils.isEmpty(bigIntegers)) {
                idList = bigIntegers.stream().map(GoodEntity::getId).map(BigInteger::longValue).collect(Collectors.toList());
            }
            List<GoodsSku> goodsSkus = goodsSkuRepository.findAllByIdInAndDeleteFlag(idList, false);
            List<GoodsSkuDTO> goodsSkuDTOS = goodsSkuMapper.toDto(goodsSkus);
            Map<Long, List<GoodsSkuDTO>> listMap = new HashMap<>(16);
            if (!CollectionUtils.isEmpty(goodsSkus)) {
                listMap = goodsSkuDTOS.stream().collect(Collectors.groupingBy(e -> e.getGoodsId()));
            }
            Page<GoodsDTO> dtoPage = goodsList.map(goodsMapper::toDto);
            Map<Long, List<GoodsSkuDTO>> finalListMap = listMap;
            dtoPage.getContent().stream().forEach(e -> {
                e.setGoodsSkuDTOS(finalListMap.get(e.getId()));
            });
            return dtoPage;
        }
        return new PageImpl<GoodsDTO>(new ArrayList<GoodsDTO>(), pageable, 0);
    }

    @Override
    public List<GoodsDTO> queryGoodsList(String keyword, Long storeId) {
        if (StringUtils.isBlank(keyword)) {
            return null;
        }
        List<Goods> list = new ArrayList<>();
        if (storeId == null) {
            list = goodsRepository.findAllByGoodsNameLikeAndDeleteFlag("%" + keyword.trim() + "", false);
        } else {
            list = goodsRepository.findAllByGoodsNameLikeAndStoreIdAndDeleteFlag("%" + keyword.trim() + "", storeId, false);
        }
        List<GoodsDTO> goodsDTOS = goodsMapper.toDto(list);


        List<Long> longList = goodsDTOS.stream().map(GoodsDTO::getId).collect(Collectors.toList());
        List<Object[]> objects = goodsSkuRepository.findAllByGoodsIdInAndDeleteFlag(longList);
        List<GoodEntity> bigIntegers = new ArrayList<>();
        try {
            bigIntegers = JpaSelectCastEntity.castEntity(objects, GoodEntity.class);
        } catch (Exception e1) {
            log.error("类转化失败" + e1.getMessage());
            e1.printStackTrace();
        }
        List<Long> idList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(bigIntegers)) {
            idList = bigIntegers.stream().map(GoodEntity::getId).map(BigInteger::longValue).collect(Collectors.toList());
        }
        List<GoodsSku> goodsSkus = goodsSkuRepository.findAllByIdInAndDeleteFlag(idList, false);
        List<GoodsSkuDTO> goodsSkuDTOS = goodsSkuMapper.toDto(goodsSkus);
        Map<Long, List<GoodsSkuDTO>> listMap = new HashMap<>(16);
        if (!CollectionUtils.isEmpty(goodsSkus)) {
            listMap = goodsSkuDTOS.stream().collect(Collectors.groupingBy(e -> e.getGoodsId()));
        }
        Map<Long, List<GoodsSkuDTO>> finalListMap = listMap;
        goodsDTOS.stream().forEach(e -> {
            e.setGoodsSkuDTOS(finalListMap.get(e.getId()));
        });
        return goodsDTOS;
    }

    @Override
    public Page<GoodsDTO> getAllGoodsByConditionByC(Pageable pageable, Long oneCategoryId, Long twoCategoryId, Long thirdCategoryId, BigDecimal minPrice, BigDecimal maxPrice, Integer sortType, Integer order) {
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
            thirdList.add(thirdCategoryId);
        }
        if (!CollectionUtils.isEmpty(thirdList)) {
            thirdList = thirdList.stream().distinct().collect(Collectors.toList());
        }
        List<Long> finalThirdList = thirdList;

        StringBuffer countSb = new StringBuffer(" select count(a.id) ");
        StringBuffer sb = new StringBuffer("   from Goods a LEFT JOIN GoodsSku gs ON gs.goodsId =a.id  WHERE gs.deleteFlag !=TRUE AND a.deleteFlag !=TRUE AND a.checkStatus=1 AND a.saleState=1 ");
        Map<String, Object> paramMap = new HashMap<>();

        if (minPrice != null) {
            paramMap.put("minPrice", minPrice);
            sb.append("  and gs.salePrice >= :minPrice ");
        }
        if (maxPrice != null) {
            paramMap.put("maxPrice", maxPrice);
            sb.append("  and gs.salePrice <= :maxPrice ");
        }
        if (!CollectionUtils.isEmpty(finalThirdList)) {
            paramMap.put("finalThirdList", finalThirdList);
            sb.append(" and a.categoryId in :finalThirdList ");
        }

        //1 综合 2 销量 3 新品 4 价格
        if (sortType == null || sortType == 1 || sortType == 3) {
            sb.append(" order by a.id ");
        } else if (sortType != null && sortType == 2) {
            sb.append(" order by a.saleVolume ");
        }else if (sortType != null && sortType == 4) {
            sb.append(" order by b.salePrice ");
        }
        if (order == null || order == 2) {
            sb.append(" DESC ");
        } else {
            sb.append(" ASC ");
        }
        countSb.append(sb);
        Query countQuery = entityManager.createQuery(countSb.toString());
        paramMap.forEach((key, value) -> countQuery.setParameter(key, value));
        Long count = (Long) countQuery.getSingleResult();

        Query query = entityManager.createQuery(sb.toString());
        paramMap.forEach((key, value) -> query.setParameter(key, value));
        query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());
        List list = query.getResultList();
        List<GoodsDTO> goodsDTOS = new ArrayList<>();

        list.forEach(e->{
            Object[] o = (Object[]) e;
            Goods goods = (Goods) o[0];
            GoodsDTO goodsDTO = goodsMapper.toDto(goods);
            goodsDTOS.add(goodsDTO);
        });
        if(!CollectionUtils.isEmpty(goodsDTOS)){

            List<Long> longList = goodsDTOS.stream().map(GoodsDTO::getId).collect(Collectors.toList());
            List<Object[]> objects = goodsSkuRepository.findAllByGoodsIdInAndDeleteFlag(longList);
            List<GoodEntity> bigIntegers = new ArrayList<>();
            try {
                bigIntegers = JpaSelectCastEntity.castEntity(objects, GoodEntity.class);
            } catch (Exception e1) {
                log.error("类转化失败" + e1.getMessage());
                e1.printStackTrace();
            }
            List<Long> idList = new ArrayList<>();
            if (!CollectionUtils.isEmpty(bigIntegers)) {
                idList = bigIntegers.stream().map(GoodEntity::getId).map(BigInteger::longValue).collect(Collectors.toList());
            }
            List<GoodsSku> goodsSkus = goodsSkuRepository.findAllByIdInAndDeleteFlag(idList, false);
            List<GoodsSkuDTO> goodsSkuDTOS = goodsSkuMapper.toDto(goodsSkus);
            Map<Long, List<GoodsSkuDTO>> listMap = new HashMap<>(16);
            if (!CollectionUtils.isEmpty(goodsSkus)) {
                listMap = goodsSkuDTOS.stream().collect(Collectors.groupingBy(e -> e.getGoodsId()));
            }
            Map<Long, List<GoodsSkuDTO>> finalListMap = listMap;
            goodsDTOS.stream().forEach(e -> {
                e.setGoodsSkuDTOS(finalListMap.get(e.getId()));
            });
        }
        Page<GoodsDTO> page = new PageImpl<>(goodsDTOS, pageable, count);
        return page;
    }
}
