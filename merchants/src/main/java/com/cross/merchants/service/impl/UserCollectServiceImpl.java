package com.cross.merchants.service.impl;

import com.cross.merchants.exception.MerchantsException;
import com.cross.merchants.redis.CartPrefix;
import com.cross.merchants.redis.KeyPrefix;
import com.cross.merchants.redis.RedisService;
import com.cross.merchants.service.GoodsService;
import com.cross.merchants.service.UserCollectService;
import com.cross.merchants.service.dto.GoodsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/*************************************************************
 * Description:
 * Author: Dair
 * CreateTime: 2020/5/26
 ************************************************************/
@Service
@Transactional
public class UserCollectServiceImpl implements UserCollectService {


    @Autowired
    private RedisService redisService;

    @Autowired
    private GoodsService goodsService;


    @Override
    public int addCollect(Long userId, Long goodsId) {
        GoodsDTO one = goodsService.getOne(goodsId);
        if (one == null) {
            throw new MerchantsException(400, "商品信息不存在");
        }
        redisService.zAdd(CartPrefix.getCollectList, userId + "", goodsId + "");
        return 1;
    }


    @Override
    public int deleteCollect(Long userId, Long goodsId) {
        redisService.zDelet(CartPrefix.getCollectList, userId + "", goodsId + "");
        return 1;
    }

    @Override
    public List<GoodsDTO> getList(Long userId, Pageable pageable) {
        int pageNumber = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        Set<String> strings = redisService.zGetList(CartPrefix.getCollectList, userId + "", pageNumber * pageSize, pageSize);
        if (!CollectionUtils.isEmpty(strings)) {
            List<Long> goodsIds = strings.stream().map(Long::valueOf).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(goodsIds)) {

                List<GoodsDTO> goodsDto = goodsService.findAllById(goodsIds);
                if (!CollectionUtils.isEmpty(goodsDto)) {
                    List<Long> finalGoodsIds = goodsIds;
                    goodsIds = goodsDto.stream().filter(e -> !finalGoodsIds.contains(e.getId())).map(GoodsDTO::getId).collect(Collectors.toList());
                    if (!CollectionUtils.isEmpty(goodsIds)) {
                        //删除
                        goodsIds.stream().forEach(e -> {
                            redisService.zDelet(CartPrefix.getCollectList, userId + "", e + "");
                        });
                    }
                }
                return goodsDto;
            }
        }
        return null;
    }

    @Override
    public long countByUserId(Long userId) {
        return redisService.zCount(CartPrefix.getCollectList, userId + "");
    }

    @Override
    public boolean isCollectGoods(Long userId, Long goodsId) {
        Long indexHset = redisService.getIndexHset(CartPrefix.getCollectList, userId + "", goodsId+"");

        if (indexHset == null || indexHset == 0) {
            return false;
        } else {
            return true;
        }
    }
}
