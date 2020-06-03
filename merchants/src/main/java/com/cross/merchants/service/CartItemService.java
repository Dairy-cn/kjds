package com.cross.merchants.service;

import com.cross.merchants.domain.Goods;
import com.cross.merchants.service.dto.CartItemDTO;
import com.cross.merchants.service.dto.GoodsSkuDTO;
import com.cross.merchants.web.rest.DTO.UserCartItemDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*************************************************************
 * Description:
 * Author: Dairy
 * CreateTime: 2020/5/23
 ************************************************************/
public interface CartItemService {

    /**
     * 查询购物车中是否包含该商品，有增加数量，无添加到购物车
     */
    @Transactional
    int add(UserCartItemDTO cartItem);

    /**
     * 根据会员编号获取购物车列表
     */
    List<CartItemDTO> list(Long memberId);

    List<CartItemDTO> listPromotion(Long userId, List<String> ids);

    /**
     * 修改某个购物车商品的数量
     */
    int updateQuantity(String id, Long memberId, Integer quantity);

    /**
     * 批量删除购物车中的商品
     */
    int delete(Long memberId, List<String> ids);

    /**
     * 获取购物车中用于选择商品规格的商品信息
     */
    List<GoodsSkuDTO> getCartProduct(Long productId);

    /**
     * 修改购物车中商品的规格
     */
    @Transactional
    int updateAttr(UserCartItemDTO cartItem);

    /**
     * 清空购物车
     */
    int clear(Long memberId);

}
