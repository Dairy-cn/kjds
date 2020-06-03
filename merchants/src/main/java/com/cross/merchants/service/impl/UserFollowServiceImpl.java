package com.cross.merchants.service.impl;

import com.cross.merchants.exception.MerchantsException;
import com.cross.merchants.redis.CartPrefix;
import com.cross.merchants.redis.RedisService;
import com.cross.merchants.service.BrandService;
import com.cross.merchants.service.GoodsService;
import com.cross.merchants.service.UserFollowService;
import com.cross.merchants.service.dto.BrandDTO;
import com.cross.merchants.service.dto.GoodsDTO;
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
    private BrandService brandService;


    @Override
    public int addBrandFollow(Long userId, Long brandId) {
        BrandDTO one = brandService.findOne(brandId);
        if (one == null) {
            throw new MerchantsException(400, "品牌信息不存在");
        }
        if (one.getCheckStatus() == null || one.getCheckStatus() != 1) {
            throw new MerchantsException(400, "品牌未审核");
        }
        redisService.zAdd(CartPrefix.getFollowList, userId + "", brandId + "");
        return 1;
    }

    @Override
    public int deleteBrandFollow(Long userId, Long brandId) {
        redisService.zDelet(CartPrefix.getFollowList, userId + "", brandId + "");
        return 1;
    }

    @Override
    public List<BrandDTO> getList(Long userId, Pageable pageable) {
        int pageNumber = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        Set<String> strings = redisService.zGetList(CartPrefix.getFollowList, userId + "", pageNumber * pageSize, pageSize);

        if (!CollectionUtils.isEmpty(strings)) {
            List<Long> brandIds = strings.stream().map(Long::valueOf).collect(Collectors.toList());
            List<BrandDTO> brandDTOS = brandService.findAllByIdInAndCheckState(brandIds, 1);
            if (!CollectionUtils.isEmpty(brandDTOS)) {
                List<Long> dbBrandIds = brandDTOS.stream().map(BrandDTO::getId).collect(Collectors.toList());
                brandIds = brandIds.stream().filter(e -> !dbBrandIds.contains(e)).collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(brandIds)) {
                    brandIds.stream().forEach(e -> {
                        deleteBrandFollow(userId, e);
                    });
                }
                List<GoodsDTO> goodsDTO = goodsService.findAllByBrandIdIn(dbBrandIds);
                Map<Long, List<GoodsDTO>> brandGoodsMap = new HashMap<>();
                if (!CollectionUtils.isEmpty(goodsDTO)) {
                    brandGoodsMap = goodsDTO.stream().collect(Collectors.groupingBy(GoodsDTO::getBrandId));
                }
                Map<Long, List<GoodsDTO>> finalBrandGoodsMap = brandGoodsMap;
                brandDTOS.stream().forEach(e -> {
                    e.setGoodsDTOS(finalBrandGoodsMap.get(e.getId()));
                });
            }
            return brandDTOS;
        }
        return null;
    }

    @Override
    public long countByUserId(Long userId) {
        return redisService.zCount(CartPrefix.getFollowList, userId + "");
    }


    @Override
    public boolean isFollowBrand(Long userId, Long brandId) {
        Long indexHset = redisService.getIndexHset(CartPrefix.getFollowList, userId + "", brandId+"");
        if (indexHset == null || indexHset == 0) {
            return false;
        } else {
            return true;
        }
    }
}
