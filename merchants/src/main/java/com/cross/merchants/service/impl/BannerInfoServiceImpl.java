package com.cross.merchants.service.impl;

import com.cross.enumtype.PlatformSystemBannerPopSettingVM;
import com.cross.merchants.domain.*;
import com.cross.merchants.exception.MerchantsException;
import com.cross.merchants.redis.CartPrefix;
import com.cross.merchants.redis.RedisService;
import com.cross.merchants.repository.*;
import com.cross.merchants.service.BannerInfoService;
import com.cross.merchants.service.dto.BannerInfoDTO;
import com.cross.merchants.service.mapper.BannerInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link BannerInfo}.
 */
@Service
@Transactional
public class BannerInfoServiceImpl implements BannerInfoService {

    private final Logger log = LoggerFactory.getLogger(BannerInfoServiceImpl.class);

    private final BannerInfoRepository bannerInfoRepository;

    private final BannerInfoMapper bannerInfoMapper;

    private final StoreInfoRepository storeInfoRepository;

    private final MerchantsCategoryRepository merchantsCategoryRepository;

    private final GoodsCategoryRepository goodsCategoryRepository;

    private final GoodsRepository goodsRepository;

    @Autowired
    private RedisService redisService;

    public BannerInfoServiceImpl(BannerInfoRepository bannerInfoRepository, BannerInfoMapper bannerInfoMapper, StoreInfoRepository storeInfoRepository, MerchantsCategoryRepository merchantsCategoryRepository, GoodsCategoryRepository goodsCategoryRepository, GoodsRepository goodsRepository) {
        this.bannerInfoRepository = bannerInfoRepository;
        this.bannerInfoMapper = bannerInfoMapper;
        this.storeInfoRepository = storeInfoRepository;
        this.merchantsCategoryRepository = merchantsCategoryRepository;
        this.goodsCategoryRepository = goodsCategoryRepository;
        this.goodsRepository = goodsRepository;
    }

    /**
     * Save a bannerInfo.
     *
     * @param bannerInfoDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public BannerInfoDTO save(BannerInfoDTO bannerInfoDTO) {
        log.debug("Request to save BannerInfo : {}", bannerInfoDTO);
        this.checkParam(bannerInfoDTO);
        if(bannerInfoDTO.getId()!=null){
            BannerInfo one = bannerInfoRepository.getOne(bannerInfoDTO.getId());
            bannerInfoDTO.setShowState(one.getShowState());
            bannerInfoDTO.setTop(one.getTop());
        }
        BannerInfo bannerInfo = bannerInfoMapper.toEntity(bannerInfoDTO);
        bannerInfo = bannerInfoRepository.save(bannerInfo);
        return bannerInfoMapper.toDto(bannerInfo);
    }

    private boolean checkParam(BannerInfoDTO bannerInfoDTO) {
        if (bannerInfoDTO.getId() == null) {
            if (1 == bannerInfoDTO.getBannerType()) {
                if (bannerInfoDTO.getStoreId() == null) {
                    throw new MerchantsException(400, "商户端广告,商户id不能为空");
                }
                int count = bannerInfoRepository.countAllByBannerTypeAndStoreId(bannerInfoDTO.getBannerType(), bannerInfoDTO.getStoreId());
                if (count >= 10) {
                    throw new MerchantsException(400, "最多可以添加10个轮播图");
                }
            } else if (2 == bannerInfoDTO.getBannerType()) {
                int count = bannerInfoRepository.countAllByBannerTypeAndPositionType(bannerInfoDTO.getBannerType(), bannerInfoDTO.getPositionType());
                switch (bannerInfoDTO.getPositionType()) {
                    case 1:
                        if (count >= 10) {
                            throw new MerchantsException(400, "最多可添加10条广告图");
                        }
                        break;
                    case 2:
                        if (count >= 1) {
                            throw new MerchantsException(400, "最多可添加1条弹窗");
                        }
                        break;
                    case 3:
                        if (count >= 3) {
                            throw new MerchantsException(400, "A区最多可添加3条广告");
                        } else {
                            int countByCode = bannerInfoRepository.countAllByBannerTypeAndPositionTypeAndPositionCode(bannerInfoDTO.getBannerType(), bannerInfoDTO.getPositionType(), bannerInfoDTO.getPositionCode());
                            if (countByCode >= 1) {
                                throw new MerchantsException(400, "A区各区域最多可分别添加1条广告");
                            }
                        }
                        break;
                }
            } else if (3 == bannerInfoDTO.getBannerType()) {
                int count = bannerInfoRepository.countAllByBannerType(bannerInfoDTO.getBannerType());
                if (count > 0) {
                    throw new MerchantsException(400, "商户推荐广告只能添加一条");

                }
            } else if (4 == bannerInfoDTO.getBannerType()) {
                int count = bannerInfoRepository.countAllByBannerTypeAndPositionType(bannerInfoDTO.getBannerType(), bannerInfoDTO.getPositionType());
                if (count > 16) {
                    throw new MerchantsException(400, "商品推荐广告只能添加16条");
                }
            }
        }
        if ((bannerInfoDTO.getLinkType() == 1 || bannerInfoDTO.getLinkType() == 2 || bannerInfoDTO.getLinkType() == 3 || bannerInfoDTO.getLinkType() == 4) && bannerInfoDTO.getBusinessId() == null) {
            throw new MerchantsException(400, "业务id不能为空");
        }
        if (bannerInfoDTO.getLinkType() == 6 && StringUtils.isBlank(bannerInfoDTO.getLinkAddress())) {
            throw new MerchantsException(400, "链接地址不能为空");
        }
        if (2 == bannerInfoDTO.getPositionType() && CollectionUtils.isEmpty(bannerInfoDTO.getBannerPopSetting())) {
            throw new MerchantsException(400, "弹窗展示频率不能为空");
        }
        return true;
    }

    /**
     * Get all the bannerInfos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BannerInfoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all BannerInfos");
        return bannerInfoRepository.findAll(pageable)
            .map(bannerInfoMapper::toDto);
    }

    /**
     * Get one bannerInfo by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BannerInfoDTO> findOne(Long id) {
        log.debug("Request to get BannerInfo : {}", id);
        return bannerInfoRepository.findById(id)
            .map(bannerInfoMapper::toDto);
    }

    /**
     * Delete the bannerInfo by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BannerInfo : {}", id);
        bannerInfoRepository.deleteById(id);
    }

    @Override
    public List<BannerInfoDTO> findAllByCondition(Integer positionType) {

        List<BannerInfoDTO> list = bannerInfoMapper.toDto(bannerInfoRepository.findAllByBannerTypeAndPositionTypeOrderByTopDescIdDesc(2, positionType));
        list = this.setParam(list);
        return list;
    }

    @Override
    public List<BannerInfoDTO> findAllByConditionByC(Integer positionType) {

        List<BannerInfoDTO> list = bannerInfoMapper.toDto(bannerInfoRepository.findAllByBannerTypeAndPositionTypeAndShowStateOrderByTopDescIdDesc(2, positionType,true));
        list = this.setParam(list);
        return list;
    }
    @Override
    public List<BannerInfoDTO> findAllByBannerType(Integer bannerType) {
        List<BannerInfoDTO> list = bannerInfoMapper.toDto(bannerInfoRepository.findAllByBannerTypeOrderByTopDescIdDesc(bannerType));
        list = this.setParam(list);
        return list;
    }


    @Override
    public List<BannerInfoDTO> findAllByStoreId(Long storeId) {
        List<BannerInfoDTO> list = bannerInfoMapper.toDto(bannerInfoRepository.findAllByBannerTypeAndStoreIdOrderByTopDescIdDesc(2, storeId));
        list = this.setParam(list);
        return list;

    }

    @Override
    public BannerInfoDTO getOne(Long id) {
        BannerInfoDTO bannerInfoDTO = bannerInfoMapper.toDto(bannerInfoRepository.getOne(id));
        if (bannerInfoDTO != null) {
            List<BannerInfoDTO> list = new ArrayList<>();
            list.add(bannerInfoDTO);
            this.setParam(list);
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean updateBannerInfoTopStateByPlatform(Long id) {
        bannerInfoRepository.updateTopStateFalseByPlatform();
        bannerInfoRepository.updateTopStateById(id);
        return true;
    }

    @Override
    public boolean updateBannerInfoTopStateByMerchant(Long id) {
        BannerInfo one = bannerInfoRepository.getOne(id);
        if (one == null) {
            return false;
        }
        if (one.getBannerType() != 1) {
            throw new MerchantsException(400, "无权操作");
        }
        if (one.getStoreId() != null) {
            bannerInfoRepository.updateTopStateFalseByStoreId(one.getStoreId());
            bannerInfoRepository.updateTopStateById(id);
        }
        return true;
    }

    @Override
    public Map<String, Object> getPopInfo(Long userId) {
        Map<String, Object> map = new HashMap<>();
        boolean exists = redisService.exists(CartPrefix.getPopAdList, userId + "");
        BannerInfo bannerInfo = bannerInfoRepository.findFirstByBannerTypeAndPositionTypeAndPositionCode(2, 2, 2);
        if (bannerInfo == null) {
            map.put("showState", false);
        } else {
            BannerInfoDTO bannerInfoDTO = bannerInfoMapper.toDto(bannerInfo);

            if (exists) {
                int popCount = redisService.get(CartPrefix.getPopAdList, userId + "", Integer.class);
                List<PlatformSystemBannerPopSettingVM> popSetting = bannerInfoDTO.getBannerPopSetting();
                if (!CollectionUtils.isEmpty(popSetting)) {
                    for (PlatformSystemBannerPopSettingVM e : popSetting) {

                        switch (e.getCycleType()) {
                            case DAY:
                                int popNumber = e.getPopNumber();
                                if (popCount >= popNumber) {
                                    map.put("showState", false);
                                    map.put("popInfo", "已经弹出限制次数了");
                                    return map;
                                }
                                break;
                            //TODO  之后要兼容星期等需要改
                            default:
                                break;
                        }
                    }
                }
            }
            map.put("showState", true);
            map.put("popInfo", bannerInfoDTO);
        }
        return map;
    }

    @Override
    public void updatePopRecord(Long userId) {
        boolean exists = redisService.exists(CartPrefix.getPopAdList, userId + "");
        if(exists){
            redisService.incr(CartPrefix.getPopAdList, userId + "");
        }else {
            redisService.incr(CartPrefix.getPopAdList, userId + "");
            redisService.expire(CartPrefix.getPopAdList, userId + "");
        }
    }


    private List<BannerInfoDTO> setParam(List<BannerInfoDTO> bannerInfoDTOS) {
        List<Long> storeList = new ArrayList<>();
        List<Long> merchantCategoryList = new ArrayList<>();
        List<Long> goodsCategoryList = new ArrayList<>();
        List<Long> goodsList = new ArrayList<>();


        Map<Long, StoreInfo> storeMap = new HashMap<>();
        Map<Long, MerchantsCategory> merchantCategoryMap = new HashMap<>();
        Map<Long, GoodsCategory> goodsCategoryMap = new HashMap<>();
        Map<Long, Goods> goodsMap = new HashMap<>();

        if (!CollectionUtils.isEmpty(bannerInfoDTOS)) {
            storeList = bannerInfoDTOS.stream().filter(e -> 1 == e.getLinkType()).map(BannerInfoDTO::getBusinessId).collect(Collectors.toList());
            merchantCategoryList = bannerInfoDTOS.stream().filter(e -> 2 == e.getLinkType()).map(BannerInfoDTO::getBusinessId).collect(Collectors.toList());
            goodsList = bannerInfoDTOS.stream().filter(e -> 3 == e.getLinkType()).map(BannerInfoDTO::getBusinessId).collect(Collectors.toList());
            goodsCategoryList = bannerInfoDTOS.stream().filter(e -> 4 == e.getLinkType()).map(BannerInfoDTO::getBusinessId).collect(Collectors.toList());

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
            bannerInfoDTOS.stream().filter(e -> 1 == e.getLinkType()).forEach(e -> {
                StoreInfo storeInfo = finalStoreMap.get(e.getBusinessId());
                if (storeInfo != null) {
                    if (storeInfo.getOperatingStatus() == null || 0 == storeInfo.getOperatingStatus()) {
                        e.setBannerState(false);
                    } else {
                        e.setBannerState(true);
                        e.setBusinessName(storeInfo.getStoreName());
                    }
                } else {
                    e.setBannerState(false);
                }


            });

            Map<Long, MerchantsCategory> finalMerchantCategoryMap = merchantCategoryMap;
            bannerInfoDTOS.stream().filter(e -> 2 == e.getLinkType()).forEach(e -> {
                MerchantsCategory merchantsCategory = finalMerchantCategoryMap.get(e.getBusinessId());
                if (merchantsCategory != null) {
                    e.setBannerState(true);
                    e.setBusinessName(merchantsCategory.getName());
                } else {
                    e.setBannerState(false);
                }

            });
            Map<Long, GoodsCategory> finalGoodsCategoryMap = goodsCategoryMap;
            bannerInfoDTOS.stream().filter(e -> 4 == e.getLinkType()).forEach(e -> {
                GoodsCategory goodsCategory = finalGoodsCategoryMap.get(e.getBusinessId());
                if (goodsCategory != null) {
                    e.setBannerState(true);
                    e.setBusinessName(goodsCategory.getName());
                } else {
                    e.setBannerState(false);
                }

            });

            Map<Long, Goods> finalGoodsMap = goodsMap;
            bannerInfoDTOS.stream().filter(e -> 3 == e.getLinkType()).forEach(e -> {
                Goods goods = finalGoodsMap.get(e.getBusinessId());
                if (goods != null) {
                    if (goods.getSaleState() != null && goods.getSaleState()) {
                        e.setBannerState(true);
                        e.setBusinessName(goods.getGoodsName());
                    } else {
                        e.setBannerState(false);
                    }
                } else {
                    e.setBannerState(false);
                }

            });
        }
        return bannerInfoDTOS;
    }
}
