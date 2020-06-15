package com.cross.merchants.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cross.merchants.domain.Goods;
import com.cross.merchants.domain.GoodsProperty;
import com.cross.merchants.domain.GoodsPropertyTag;
import com.cross.merchants.domain.GoodsSku;
import com.cross.merchants.exception.MerchantsException;
import com.cross.merchants.redis.CartPrefix;
import com.cross.merchants.redis.RedisService;
import com.cross.merchants.repository.GoodsPropertyRepository;
import com.cross.merchants.repository.GoodsPropertyTagRepository;
import com.cross.merchants.repository.GoodsRepository;
import com.cross.merchants.repository.GoodsSkuRepository;
import com.cross.merchants.service.CartItemService;
import com.cross.merchants.service.dto.CartItemDTO;
import com.cross.merchants.service.dto.GoodsSkuDTO;
import com.cross.merchants.service.mapper.GoodsSkuMapper;
import com.cross.merchants.web.rest.DTO.GoodsPropertyVO;
import com.cross.merchants.web.rest.DTO.UserCartItemDTO;
import com.cross.model.LoginUserModel;
import com.cross.utils.CommonUtil;
import com.cross.utils.JsonUtil;
import net.sf.json.util.JSONUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*************************************************************
 * Description:
 * Author: Dairy
 * CreateTime: 2020/5/23
 ************************************************************/
@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {


    @Autowired
    private RedisService redisService;

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private GoodsSkuRepository goodsSkuRepository;

    @Autowired
    private GoodsSkuMapper goodsSkuMapper;


    @Autowired
    private GoodsPropertyRepository goodsPropertyRepository;


    @Autowired
    private GoodsPropertyTagRepository goodsPropertyTagRepository;

    @Override
    public int add(UserCartItemDTO userCartItemDTO) {
        LoginUserModel currentLoginUser = CommonUtil.getCurrentLoginUser();
        CartItemDTO cartItem = new CartItemDTO();
        cartItem.setProductId(userCartItemDTO.getProductId());
        cartItem.setProductSkuId(userCartItemDTO.getProductSkuId());
        cartItem.setQuantity(userCartItemDTO.getQuantity());
        cartItem.setGoodsPropertyTagIds(userCartItemDTO.getGoodsPropertyTagIds());
        cartItem.setUserId(currentLoginUser.getId());
        cartItem.setMemberNickname(currentLoginUser.getUser_name());
        StringBuilder tagString = new StringBuilder("_");
        if (!CollectionUtils.isEmpty(userCartItemDTO.getGoodsPropertyTagIds())) {
            List<Long> goodsPropertyTagIds = userCartItemDTO.getGoodsPropertyTagIds();
            List<GoodsPropertyTag> goodsPropertyTagList = goodsPropertyTagRepository.findAllByIdInAndDeleteFlag(goodsPropertyTagIds, false);
            List<Long> propertyIds = goodsPropertyTagList.stream().map(GoodsPropertyTag::getGoodsPropertyId).distinct().collect(Collectors.toList());
            Map<Long, GoodsPropertyTag> propertyTagMap = goodsPropertyTagList.stream().collect(Collectors.toMap(GoodsPropertyTag::getId, e -> e));
            Map<Long, GoodsProperty> goodsPropertyMap = new HashMap<>(16);
            if (!CollectionUtils.isEmpty(propertyIds)) {
                if (propertyIds.size() != goodsPropertyTagList.size()) {
                    throw new MerchantsException(400, "同一属性只能选择一个标签");
                }
                List<GoodsProperty> goodsPropertyList = goodsPropertyRepository.findAllByIdInAndGoodsIdAndDeleteFlag(propertyIds,userCartItemDTO.getProductId(), false);

                goodsPropertyMap = goodsPropertyList.stream().collect(Collectors.toMap(GoodsProperty::getId, e -> e));
            }
            List<GoodsPropertyVO> list = new ArrayList<>();
            Map<Long, GoodsProperty> finalGoodsPropertyMap = goodsPropertyMap;
            goodsPropertyTagIds.stream().forEach(e -> {
                GoodsPropertyVO goodsPropertyVO = new GoodsPropertyVO();
                GoodsPropertyTag goodsPropertyTag = propertyTagMap.get(e);
                if (goodsPropertyTag == null) {
                    throw new MerchantsException(400, "找不到属性标签ID为" + e + "的数据");
                }
                GoodsProperty goodsProperty = finalGoodsPropertyMap.get(goodsPropertyTag.getGoodsPropertyId());
                if (goodsProperty == null) {
                    throw new MerchantsException(400, "找不到属性标签ID为" + e + "的属性数据");
                }
                goodsPropertyVO.setKey(goodsProperty.getName());
                goodsPropertyVO.setValue(goodsPropertyTag.getName());
                list.add(goodsPropertyVO);

            });
            cartItem.setProductAttr(JsonUtil.objectToJson(list));
            goodsPropertyTagIds=goodsPropertyTagIds.stream().sorted(Comparator.comparing(e -> e)).collect(Collectors.toList());
            StringBuilder finalTagString = tagString;
            goodsPropertyTagIds.stream().forEach(e -> {
                finalTagString.append(e + ",");
            });
            tagString = finalTagString.delete(finalTagString.lastIndexOf(","),finalTagString.length());
        } else {
            cartItem.setProductAttr(null);
        }
        cartItem.setId(cartItem.getUserId() + "_" + cartItem.getProductId() + "_" + cartItem.getProductSkuId() + tagString);
        Boolean exists = redisService.existsValue(CartPrefix.getCartList, cartItem.getUserId().toString(), cartItem.getId());
        if (exists) {
            //获取现有的购物车中的数据
            String json = redisService.hget(CartPrefix.getCartList, cartItem.getUserId().toString(), cartItem.getId());
            if (json != null) {
                //转换为java实体类
                CartItemDTO cartDto = (CartItemDTO) JsonUtil.jsonToBean(json, CartItemDTO.class);
                cartDto.setQuantity(cartDto.getQuantity() + cartItem.getQuantity());
                cartDto.setModifyDate(Instant.now());
                redisService.hset(CartPrefix.getCartList, cartItem.getUserId().toString(), cartItem.getId(), JsonUtil.objectToJson(cartDto));
            } else {
                return 0;
            }
            return 1;
        } else {
            Goods goods = goodsRepository.getByIdAndDeleteFlag(cartItem.getProductId(), false);
            GoodsSku goodsSku = goodsSkuRepository.getByIdAndDeleteFlag(cartItem.getProductSkuId(), false);
            if (goods == null || goodsSku == null || !goodsSku.getGoodsId().equals(goods.getId())) {
                return 0;
            } else {
                cartItem.setProductName(goods.getGoodsName());
                cartItem.setProductPic(goods.getGoodsPic());
                cartItem.setPrice(goodsSku.getSalePrice());
                cartItem.setCreateDate(Instant.now());
                cartItem.setProductSubTitle(goods.getGoodsDesc());
                cartItem.setStoreId(goods.getStoreId());
                redisService.hset(CartPrefix.getCartList, cartItem.getUserId().toString(), cartItem.getId(), JsonUtil.objectToJson(cartItem));
                return 1;
            }
        }
    }

    private void checkGoods(Long userId, List<CartItemDTO> cartItemDTO) {
        List<Long> skuIds = cartItemDTO.stream().map(CartItemDTO::getProductSkuId).collect(Collectors.toList());
        List<Long> goodIds = cartItemDTO.stream().map(CartItemDTO::getProductId).collect(Collectors.toList());

        List<GoodsSku> goodsSkus = goodsSkuRepository.findAllByIdInAndDeleteFlag(skuIds, false);
        List<Goods> goods = goodsRepository.findAllByIdInAndDeleteFlag(goodIds, false);
        Map<Long, GoodsSku> goodsSkuMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(goodsSkus)) {
            goodsSkuMap = goodsSkus.stream().collect(Collectors.toMap(GoodsSku::getId, e -> e));
        }
        Map<Long, Goods> goodsMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(goods)) {
            goodsMap = goods.stream().collect(Collectors.toMap(Goods::getId, e -> e));
        }
        Map<Long, GoodsSku> finalGoodsSkuMap = goodsSkuMap;
        Map<Long, Goods> finalGoodsMap = goodsMap;
        cartItemDTO.stream().forEach(e -> {
            Goods dbGoods = finalGoodsMap.get(e.getProductId());
            GoodsSku dbGoodsSku = finalGoodsSkuMap.get(e.getProductSkuId());
            List<Long> propertyTagIds = e.getGoodsPropertyTagIds();
            boolean flag = true;
            if (!CollectionUtils.isEmpty(propertyTagIds)) {
                List<GoodsPropertyTag> goodsPropertyTagList = goodsPropertyTagRepository.findAllByIdInAndDeleteFlag(propertyTagIds, false);
                if (goodsPropertyTagList.size() != propertyTagIds.size()) {
                    flag = false;
                }
                List<Long> goodsPropertyIds = goodsPropertyTagList.stream().map(GoodsPropertyTag::getGoodsPropertyId).distinct().collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(goodsPropertyIds)) {
                    List<GoodsProperty> goodsPropertyList = goodsPropertyRepository.findAllByIdInAndGoodsIdAndDeleteFlag(goodsPropertyIds, e.getProductId(),false);
                    if (goodsPropertyList.size() != goodsPropertyIds.size()) {
                        flag = false;
                    }
                }
            }
            if (dbGoods == null || dbGoodsSku == null || (!dbGoods.getId().equals(dbGoodsSku.getGoodsId())) || !flag) {
                if (!(e.getGoodsDeleteState() != null && e.getGoodsDeleteState())) {
                    e.setGoodsDeleteState(true);
                    redisService.hset(CartPrefix.getCartList, userId + "", e.getId(), JsonUtil.objectToJson(e));
                }
            } else {
                if (!e.getProductName().equals(dbGoods.getGoodsName()) || e.getPrice().compareTo(dbGoodsSku.getSalePrice()) != 0) {
                    e.setProductName(dbGoods.getGoodsName());
                    e.setProductPic(dbGoods.getGoodsPic());
                    e.setPrice(dbGoodsSku.getSalePrice());
                    e.setModifyDate(Instant.now());
                    e.setProductSubTitle(dbGoods.getGoodsDesc());
                    redisService.hset(CartPrefix.getCartList, userId + "", e.getId(), JsonUtil.objectToJson(e));
                }
            }

        });
    }

    @Override
    public List<CartItemDTO> list(Long memberId) {
        List<String> jsonList = redisService.hvals(CartPrefix.getCartList, memberId + "");
        List<CartItemDTO> cartDtoList = new LinkedList<>();
        for (String json : jsonList) {
            CartItemDTO cartDto = (CartItemDTO) JsonUtil.jsonToBean(json, CartItemDTO.class);
            cartDtoList.add(cartDto);
        }
        checkGoods(memberId, cartDtoList);
        return cartDtoList;
    }


    @Override
    public List<CartItemDTO> listPromotion(Long memberId, List<String> cartIds) {
        List<CartItemDTO> cartItemList = list(memberId);
        if (CollectionUtils.isNotEmpty(cartIds)) {
            cartItemList = cartItemList.stream().filter(item -> cartIds.contains(item.getId())).collect(Collectors.toList());
        }
        return cartItemList;
    }

    @Override
    public int updateQuantity(String id, Long memberId, Integer quantity) {
        String json = redisService.hget(CartPrefix.getCartList, memberId + "", id);
        if (json == null) {
            return 0;
        }
        CartItemDTO cartDto = (CartItemDTO) JsonUtil.jsonToBean(json, CartItemDTO.class);
        cartDto.setQuantity(quantity);
        redisService.hset(CartPrefix.getCartList, memberId + "", id, JsonUtil.objectToJson(cartDto));
        return 1;
    }

    @Override
    public int delete(Long memberId, List<String> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            ids.stream().forEach(e -> {
                redisService.hdel(CartPrefix.getCartList, memberId + "", e + "");

            });
        }
        return 1;
    }

    @Override
    public List<GoodsSkuDTO> getCartProduct(Long productId) {
        List<GoodsSku> goodsSkus = goodsSkuRepository.findAllByGoodsIdAndDeleteFlag(productId, false);
        return goodsSkuMapper.toDto(goodsSkus);
    }

    @Override
    public int updateAttr(UserCartItemDTO cartItem) {
        //删除原购物车信息
        CartItemDTO updateCart = new CartItemDTO();
        redisService.hdel(CartPrefix.getCartList, CommonUtil.getCurrentLoginUser().getId() + "", cartItem.getId() + "");
        cartItem.setId(null);
        add(cartItem);
        return 1;
    }

    @Override
    public int clear(Long memberId) {
        redisService.delete(CartPrefix.getCartList, memberId + "");
        return 1;
    }

}
