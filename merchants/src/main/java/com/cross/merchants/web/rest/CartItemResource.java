package com.cross.merchants.web.rest;

import com.cross.merchants.domain.GoodsSku;
import com.cross.merchants.service.*;
import com.cross.merchants.service.dto.*;
import com.cross.merchants.web.rest.DTO.UserCartItemDTO;
import com.cross.merchants.web.rest.VO.StoreInfoVO;
import com.cross.utils.CommonUtil;
import com.cross.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for managing {@link com.cross.merchants.domain.ArticleInfo}.
 */
@RestController
@RequestMapping("/api/cart-item")
@Api(tags = "购物车管理")
public class CartItemResource {

    private final Logger log = LoggerFactory.getLogger(CartItemResource.class);


    @Value("${jhipster.clientApp.name}")
    private String applicationName;


    @Autowired
    private CartItemService cartItemService;


    @Autowired
    private GoodsSkuService goodsSkuService;

    @Autowired
    private GoodsPropertyService goodsPropertyService;

    @Autowired
    private StoreInfoService storeInfoService;


    @ApiOperation("添加商品到购物车")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public R add(@RequestBody UserCartItemDTO cartItem) {
        if (cartItem.getProductId() == null || cartItem.getProductSkuId() == null || cartItem.getQuantity() == null) {
            return R.error("购物车数据错误");
        }
        int count = cartItemService.add(cartItem);
        if (count > 0) {
            return R.ok(count);
        }
        return R.error();
    }

    @ApiOperation("获取某个会员的购物车列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R<List<StoreInfoVO>> list() {
        List<CartItemDTO> cartItemList = cartItemService.list(CommonUtil.getCurrentLoginUser().getId());
        List<StoreInfoVO> storeInfoVOList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(cartItemList)) {
            Map<Long, List<CartItemDTO>> cartMap = cartItemList.stream().collect(Collectors.groupingBy(CartItemDTO::getStoreId));
            List<Long> storeIds = cartItemList.stream().map(CartItemDTO::getStoreId).distinct().collect(Collectors.toList());
            List<StoreInfoDTO> storeInfoDTOList = storeInfoService.findAllByIdIn(storeIds);
            storeInfoDTOList.stream().forEach(e -> {
                StoreInfoVO storeInfoVO = new StoreInfoVO();
                BeanUtils.copyProperties(e, storeInfoVO);
                storeInfoVOList.add(storeInfoVO);
            });
            storeInfoVOList.stream().forEach(e->{
                e.setCartItemDTOS(cartMap.get(e.getId()));
            });
        }
        return R.ok(storeInfoVOList);
    }

    @ApiOperation("获取某个会员的购物车列表")
    @RequestMapping(value = "/list/promotion", method = RequestMethod.GET)
    @ResponseBody
    public R<List<CartItemDTO>> listPromotion(@RequestParam(required = false) List<String> cartIds) {
        List<CartItemDTO> cartPromotionItemList = cartItemService.listPromotion(CommonUtil.getCurrentLoginUser().getId(), cartIds);
        return R.ok(cartPromotionItemList);
    }

    @ApiOperation("修改购物车中某个商品的数量")
    @RequestMapping(value = "/update/quantity", method = RequestMethod.GET)
    @ResponseBody
    public R updateQuantity(@RequestParam String id,
                            @RequestParam Integer quantity) {
        int count = cartItemService.updateQuantity(id, CommonUtil.getCurrentLoginUser().getId(), quantity);
        if (count > 0) {
            return R.ok(count);
        }
        return R.ok();
    }

    @ApiOperation("获取购物车中某个商品的规格,用于重选规格")
    @RequestMapping(value = "/getProduct/{productId}", method = RequestMethod.GET)
    @ResponseBody
    public R<List<GoodsSkuDTO>> getCartProduct(@PathVariable Long productId) {
        List<GoodsSkuDTO> cartProduct = goodsSkuService.findAllByGoodsId(productId);
        return R.ok(cartProduct);
    }

    @ApiOperation("获取购物车中某个商品的属性,用于重选属性")
    @RequestMapping(value = "/getProductProperty/{productId}", method = RequestMethod.GET)
    @ResponseBody
    public R<List<GoodsPropertyDTO>> getCartProductProperty(@PathVariable Long productId) {
        List<GoodsPropertyDTO> goodsPropertyDTOList = goodsPropertyService.findAllByIdGoods(productId);
        return R.ok(goodsPropertyDTOList);
    }


    @ApiOperation("修改购物车中商品的规格")
    @RequestMapping(value = "/update/attr", method = RequestMethod.POST)
    @ResponseBody
    public R updateAttr(@RequestBody UserCartItemDTO cartItem) {
        if (cartItem.getId() == null || cartItem.getProductId() == null || cartItem.getProductSkuId() == null || cartItem.getQuantity() == null) {
            return R.error("购物车数据错误");
        }
        int count = cartItemService.updateAttr(cartItem);
        if (count > 0) {
            return R.ok(count);
        }
        return R.error();
    }

    @ApiOperation("删除购物车中的某个商品")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public R delete(@ApiParam("购物车id") @RequestParam("ids") List<String> ids) {
        int count = cartItemService.delete(CommonUtil.getCurrentLoginUser().getId(), ids);
        if (count > 0) {
            return R.ok(count);
        }
        return R.error();
    }

    @ApiOperation("清空购物车")
    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    @ResponseBody
    public R clear() {
        int count = cartItemService.clear(CommonUtil.getCurrentLoginUser().getId());
        if (count > 0) {
            return R.ok(count);
        }
        return R.error();
    }
}
