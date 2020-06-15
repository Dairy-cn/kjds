package com.cross.merchants.service.impl;

import com.cross.merchants.domain.StoreInfo;
import com.cross.merchants.exception.MerchantsException;
import com.cross.merchants.redis.CartPrefix;
import com.cross.merchants.redis.RedisService;
import com.cross.merchants.service.BrandService;
import com.cross.merchants.service.GoodsService;
import com.cross.merchants.service.StoreInfoService;
import com.cross.merchants.service.UserFollowService;
import com.cross.merchants.service.dto.BrandDTO;
import com.cross.merchants.service.dto.GoodsDTO;
import com.cross.merchants.service.dto.StoreInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*************************************************************
 * Description:
 * Author: Dair
 * CreateTime: 2020/5/26

 ************************************************************/
@Service
@Transactional
public class UserFollowServiceImpl implements UserFollowService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private StoreInfoService storeInfoService;


    @Override
    public int addBrandFollow(Long userId, Long storeId) {
        StoreInfoDTO one = storeInfoService.getOne(storeId);
        if (one == null) {
            throw new MerchantsException(400, "店铺信息不存在");
        }

        redisService.zAdd(CartPrefix.getFollowList, userId + "", storeId + "");
        return 1;
    }

    @Override
    public int deleteBrandFollow(Long userId, Long storeId) {
        redisService.zDelet(CartPrefix.getFollowList, userId + "", storeId + "");
        return 1;
    }

    @Override
    public List<StoreInfoDTO> getList(Long userId, Pageable pageable) {
        int pageNumber = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        Set<String> strings = redisService.zGetList(CartPrefix.getFollowList, userId + "", pageNumber * pageSize, pageSize);

        if (!CollectionUtils.isEmpty(strings)) {
            List<Long> storeIds = strings.stream().map(Long::valueOf).collect(Collectors.toList());
            List<StoreInfoDTO> storeDTOS = storeInfoService.findAllByIdIn(storeIds);
            if (!CollectionUtils.isEmpty(storeDTOS)) {
                List<Long> dbStoreIds = storeDTOS.stream().map(StoreInfoDTO::getId).collect(Collectors.toList());
                storeIds = storeIds.stream().filter(e -> !dbStoreIds.contains(e)).collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(storeIds)) {
                    storeIds.stream().forEach(e -> {
                        deleteBrandFollow(userId, e);
                    });
                }
                List<GoodsDTO> goodsDTO = goodsService.findAllByStoreIdIn(dbStoreIds);
                Map<Long, List<GoodsDTO>> storeGoodsMap = new HashMap<>();
                if (!CollectionUtils.isEmpty(goodsDTO)) {
                    storeGoodsMap = goodsDTO.stream().collect(Collectors.groupingBy(GoodsDTO::getStoreId));
                }
                Map<Long, List<GoodsDTO>> finalBrandGoodsMap = storeGoodsMap;
                storeDTOS.stream().forEach(e -> {
                    e.setGoodsDTOList(finalBrandGoodsMap.get(e.getId()));
                });
            }
            return storeDTOS;
        }
        return null;
    }

    @Override
    public long countByUserId(Long userId) {
        return redisService.zCount(CartPrefix.getFollowList, userId + "");
    }


    @Override
    public boolean isFollowBrand(Long userId, Long storeId) {
        Long indexHset = redisService.getIndexHset(CartPrefix.getFollowList, userId + "", storeId+"");
        if (indexHset == null) {
            return false;
        } else {
            return true;
        }
    }
}
