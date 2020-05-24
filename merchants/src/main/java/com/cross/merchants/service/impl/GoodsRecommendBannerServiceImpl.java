package com.cross.merchants.service.impl;

import com.cross.merchants.domain.*;
import com.cross.merchants.exception.MerchantsException;
import com.cross.merchants.repository.*;
import com.cross.merchants.service.GoodsRecommendBannerService;
import com.cross.merchants.service.dto.BannerInfoDTO;
import com.cross.merchants.service.dto.GoodsRecommendBannerDTO;
import com.cross.merchants.service.dto.GoodsRecommendBannerPositionDTO;
import com.cross.merchants.service.mapper.GoodsRecommendBannerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link GoodsRecommendBanner}.
 */
@Service
@Transactional
public class GoodsRecommendBannerServiceImpl implements GoodsRecommendBannerService {

    private final Logger log = LoggerFactory.getLogger(GoodsRecommendBannerServiceImpl.class);

    private final GoodsRecommendBannerRepository goodsRecommendBannerRepository;

    private final GoodsRecommendBannerMapper goodsRecommendBannerMapper;

    private final StoreInfoRepository storeInfoRepository;

    private final MerchantsCategoryRepository merchantsCategoryRepository;

    private final GoodsRepository goodsRepository;

    private final GoodsCategoryRepository goodsCategoryRepository;

    public GoodsRecommendBannerServiceImpl(GoodsRecommendBannerRepository goodsRecommendBannerRepository, GoodsRecommendBannerMapper goodsRecommendBannerMapper, StoreInfoRepository storeInfoRepository, MerchantsCategoryRepository merchantsCategoryRepository, GoodsRepository goodsRepository, GoodsCategoryRepository goodsCategoryRepository) {
        this.goodsRecommendBannerRepository = goodsRecommendBannerRepository;
        this.goodsRecommendBannerMapper = goodsRecommendBannerMapper;
        this.storeInfoRepository = storeInfoRepository;
        this.merchantsCategoryRepository = merchantsCategoryRepository;
        this.goodsRepository = goodsRepository;
        this.goodsCategoryRepository = goodsCategoryRepository;
    }

    /**
     * Save a goodsRecommendBanner.
     *
     * @param goodsRecommendBannerDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public GoodsRecommendBannerDTO save(GoodsRecommendBannerDTO goodsRecommendBannerDTO) {
        log.debug("Request to save GoodsRecommendBanner : {}", goodsRecommendBannerDTO);
        this.checkParam(goodsRecommendBannerDTO);
        GoodsRecommendBanner goodsRecommendBanner = goodsRecommendBannerMapper.toEntity(goodsRecommendBannerDTO);
        goodsRecommendBanner = goodsRecommendBannerRepository.save(goodsRecommendBanner);
        return goodsRecommendBannerMapper.toDto(goodsRecommendBanner);
    }

    private boolean checkParam(GoodsRecommendBannerDTO goodsRecommendBannerDTO) {
        GoodsRecommendBanner goodsRecommendBanner = goodsRecommendBannerRepository.findFirstByDivisionName(goodsRecommendBannerDTO.getDivisionName());
        if (goodsRecommendBannerDTO.getId() == null) {
            if (goodsRecommendBanner != null) {
                throw new MerchantsException(400, "专区名称已存在");
            }
            long count = goodsRecommendBannerRepository.count();
            if (count > 6) {
                throw new MerchantsException(400, "商品推荐最多添加6个专区");
            }
        } else {
            if (goodsRecommendBanner != null && !goodsRecommendBanner.getId().equals(goodsRecommendBannerDTO.getId())) {
                throw new MerchantsException(400, "专区名称已存在");
            }
        }
        return true;
    }

    /**
     * Get all the goodsRecommendBanners.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<GoodsRecommendBannerDTO> findAll(Pageable pageable) {
        log.debug("Request to get all GoodsRecommendBanners");
        Page<GoodsRecommendBannerDTO> page = goodsRecommendBannerRepository.findAll(pageable).map(goodsRecommendBannerMapper::toDto);
        if (!CollectionUtils.isEmpty(page.getContent())) {
            return new PageImpl<GoodsRecommendBannerDTO>(this.setParam(page.getContent()), page.getPageable(), page.getTotalElements());
        }
        return page;
    }

    @Override
    public List<GoodsRecommendBannerDTO> findAll() {
        return goodsRecommendBannerMapper.toDto(goodsRecommendBannerRepository.findAll());
    }

    /**
     * Get one goodsRecommendBanner by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<GoodsRecommendBannerDTO> findOne(Long id) {
        log.debug("Request to get GoodsRecommendBanner : {}", id);
        return goodsRecommendBannerRepository.findById(id)
            .map(goodsRecommendBannerMapper::toDto);
    }

    /**
     * Delete the goodsRecommendBanner by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete GoodsRecommendBanner : {}", id);
        goodsRecommendBannerRepository.deleteById(id);
    }

    @Override
    public GoodsRecommendBannerDTO getOne(Long id) {
        return goodsRecommendBannerMapper.toDto(goodsRecommendBannerRepository.getOne(id));
    }

    @Override
    public boolean updateGoodsBannerInfoTopState(Long id) {
        goodsRecommendBannerRepository.updateTopStateFalse();
        return goodsRecommendBannerRepository.updateTopStateById(id) > 0;
    }

    @Override
    public Map<Long, GoodsRecommendBannerDTO> finAllMapInfo(List<Long> ids) {
        List<GoodsRecommendBannerDTO> goodsRecommendBannerDTOS = goodsRecommendBannerMapper.toDto(goodsRecommendBannerRepository.findAllByIdIn(ids));
        return goodsRecommendBannerDTOS.stream().collect(Collectors.toMap(GoodsRecommendBannerDTO::getId, e -> e));
    }


    private List<GoodsRecommendBannerDTO> setParam(List<GoodsRecommendBannerDTO> goodsRecommendBannerDTOS) {
        List<Long> storeList = new ArrayList<>();
        List<Long> merchantCategoryList = new ArrayList<>();
        List<Long> goodsCategoryList = new ArrayList<>();
        List<Long> goodsList = new ArrayList<>();


        Map<Long, StoreInfo> storeMap = new HashMap<>();
        Map<Long, MerchantsCategory> merchantCategoryMap = new HashMap<>();
        Map<Long, GoodsCategory> goodsCategoryMap = new HashMap<>();
        Map<Long, Goods> goodsMap = new HashMap<>();

        if (!CollectionUtils.isEmpty(goodsRecommendBannerDTOS)) {
            List<GoodsRecommendBannerPositionDTO> list = new ArrayList<>();
            goodsRecommendBannerDTOS.stream().forEach(e -> {
                if (e.getPositionOne() != null) {
                    list.add(e.getPositionOne());
                }
                if (e.getPositionTwo() != null) {
                    list.add(e.getPositionTwo());
                }
                if (e.getPositionThree() != null) {
                    list.add(e.getPositionThree());
                }
            });
            storeList = list.stream().filter(e -> 1 == e.getLinkType()).map(GoodsRecommendBannerPositionDTO::getBusinessId).collect(Collectors.toList());
            merchantCategoryList = list.stream().filter(e -> 2 == e.getLinkType()).map(GoodsRecommendBannerPositionDTO::getBusinessId).collect(Collectors.toList());
            goodsList = list.stream().filter(e -> 3 == e.getLinkType()).map(GoodsRecommendBannerPositionDTO::getBusinessId).collect(Collectors.toList());
            goodsCategoryList = list.stream().filter(e -> 4 == e.getLinkType()).map(GoodsRecommendBannerPositionDTO::getBusinessId).collect(Collectors.toList());

            if (!CollectionUtils.isEmpty(storeList)) {
                List<StoreInfo> storeInfos = storeInfoRepository.findAllByIdIn(storeList);
                storeMap = storeInfos.stream().collect(Collectors.toMap(e -> e.getId(), e -> e));
            }
            if (!CollectionUtils.isEmpty(merchantCategoryList)) {
                List<MerchantsCategory> merchantsCategories = merchantsCategoryRepository.findAllByIdIn(merchantCategoryList);
                merchantCategoryMap = merchantsCategories.stream().collect(Collectors.toMap(e -> e.getId(), e -> e));
            }
            if (!CollectionUtils.isEmpty(goodsList)) {
                List<Goods> goods = goodsRepository.findAllByIdInAndDeleteFlag(goodsList, false);
                goodsMap = goods.stream().collect(Collectors.toMap(e -> e.getId(), e -> e));
            }

            if (!CollectionUtils.isEmpty(goodsCategoryList)) {
                List<GoodsCategory> goodsCategories = goodsCategoryRepository.findAllByIdIn(goodsCategoryList);
                goodsCategoryMap = goodsCategories.stream().collect(Collectors.toMap(e -> e.getId(), e -> e));
            }
            Map<Long, StoreInfo> finalStoreMap = storeMap;
            Map<Long, MerchantsCategory> finalMerchantCategoryMap = merchantCategoryMap;
            Map<Long, Goods> finalGoodsMap = goodsMap;
            Map<Long, GoodsCategory> finalGoodsCategoryMap = goodsCategoryMap;

            goodsRecommendBannerDTOS.stream().forEach(e -> {

                GoodsRecommendBannerPositionDTO positionOne = e.getPositionOne();
                if (positionOne != null) {
                    if (1 == positionOne.getLinkType()) {
                        StoreInfo storeInfo = finalStoreMap.get(positionOne.getBusinessId());
                        if (storeInfo != null) {
                            if (storeInfo.getOperatingStatus() == null || 0 == storeInfo.getOperatingStatus()) {
                                positionOne.setBannerState(false);
                            } else {
                                positionOne.setBannerState(true);
                                positionOne.setBusinessName(storeInfo.getStoreName());
                            }
                        } else {
                            positionOne.setBannerState(false);
                        }
                    }
                    if (2 == positionOne.getLinkType()) {
                        MerchantsCategory merchantsCategory = finalMerchantCategoryMap.get(positionOne.getBusinessId());
                        if (merchantsCategory != null) {
                            positionOne.setBannerState(true);
                            positionOne.setBusinessName(merchantsCategory.getName());
                        } else {
                            positionOne.setBannerState(false);
                        }
                    }
                    if (3 == positionOne.getLinkType()) {
                        Goods goods = finalGoodsMap.get(positionOne.getBusinessId());
                        if (goods != null) {
                            if (goods.getSaleState() != null && goods.getSaleState()) {
                                positionOne.setBannerState(true);
                                positionOne.setBusinessName(goods.getGoodsName());
                            } else {
                                positionOne.setBannerState(false);
                            }
                        } else {
                            positionOne.setBannerState(false);
                        }

                    }
                    if (4 == positionOne.getLinkType()) {
                        GoodsCategory goodsCategory = finalGoodsCategoryMap.get(positionOne.getBusinessId());
                        if (goodsCategory != null) {
                            positionOne.setBannerState(true);
                            positionOne.setBusinessName(goodsCategory.getName());
                        } else {
                            positionOne.setBannerState(false);
                        }

                    }
                    e.setPositionOne(positionOne);
                }
                //第二块

                GoodsRecommendBannerPositionDTO positionTwo = e.getPositionTwo();
                if (positionTwo != null) {
                    if (1 == positionTwo.getLinkType()) {
                        StoreInfo storeInfo = finalStoreMap.get(positionTwo.getBusinessId());
                        if (storeInfo != null) {
                            if (storeInfo.getOperatingStatus() == null || 0 == storeInfo.getOperatingStatus()) {
                                positionTwo.setBannerState(false);
                            } else {
                                positionTwo.setBannerState(true);
                                positionTwo.setBusinessName(storeInfo.getStoreName());
                            }
                        } else {
                            positionTwo.setBannerState(false);
                        }
                    }
                    if (2 == positionTwo.getLinkType()) {
                        MerchantsCategory merchantsCategory = finalMerchantCategoryMap.get(positionTwo.getBusinessId());
                        if (merchantsCategory != null) {
                            positionTwo.setBannerState(true);
                            positionTwo.setBusinessName(merchantsCategory.getName());
                        } else {
                            positionTwo.setBannerState(false);
                        }
                    }
                    if (3 == positionTwo.getLinkType()) {
                        Goods goods = finalGoodsMap.get(positionTwo.getBusinessId());
                        if (goods != null) {
                            if (goods.getSaleState() != null && goods.getSaleState()) {
                                positionTwo.setBannerState(true);
                                positionTwo.setBusinessName(goods.getGoodsName());
                            } else {
                                positionTwo.setBannerState(false);
                            }
                        } else {
                            positionTwo.setBannerState(false);
                        }

                    }
                    if (4 == positionTwo.getLinkType()) {
                        GoodsCategory goodsCategory = finalGoodsCategoryMap.get(positionTwo.getBusinessId());
                        if (goodsCategory != null) {
                            positionTwo.setBannerState(true);
                            positionTwo.setBusinessName(goodsCategory.getName());
                        } else {
                            positionTwo.setBannerState(false);
                        }

                    }
                    e.setPositionTwo(positionTwo);
                }


                GoodsRecommendBannerPositionDTO positionThree = e.getPositionThree();
                if (positionThree != null) {
                    if (1 == positionThree.getLinkType()) {
                        StoreInfo storeInfo = finalStoreMap.get(positionThree.getBusinessId());
                        if (storeInfo != null) {
                            if (storeInfo.getOperatingStatus() == null || 0 == storeInfo.getOperatingStatus()) {
                                positionThree.setBannerState(false);
                            } else {
                                positionThree.setBannerState(true);
                                positionThree.setBusinessName(storeInfo.getStoreName());
                            }
                        } else {
                            positionThree.setBannerState(false);
                        }
                    }
                    if (2 == positionThree.getLinkType()) {
                        MerchantsCategory merchantsCategory = finalMerchantCategoryMap.get(positionThree.getBusinessId());
                        if (merchantsCategory != null) {
                            positionThree.setBannerState(true);
                            positionThree.setBusinessName(merchantsCategory.getName());
                        } else {
                            positionThree.setBannerState(false);
                        }
                    }
                    if (3 == positionThree.getLinkType()) {
                        Goods goods = finalGoodsMap.get(positionThree.getBusinessId());
                        if (goods != null) {
                            if (goods.getSaleState() != null && goods.getSaleState()) {
                                positionThree.setBannerState(true);
                                positionThree.setBusinessName(goods.getGoodsName());
                            } else {
                                positionThree.setBannerState(false);
                            }
                        } else {
                            positionThree.setBannerState(false);
                        }

                    }
                    if (4 == positionThree.getLinkType()) {
                        GoodsCategory goodsCategory = finalGoodsCategoryMap.get(positionThree.getBusinessId());
                        if (goodsCategory != null) {
                            positionThree.setBannerState(true);
                            positionThree.setBusinessName(goodsCategory.getName());
                        } else {
                            positionThree.setBannerState(false);
                        }

                    }
                    e.setPositionTwo(positionThree);
                }

            });

        }
        return goodsRecommendBannerDTOS;
    }


}
