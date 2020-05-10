package com.cross.client;

import com.cross.config.AuthorizedFeignClient;
import com.cross.enumtype.CatSourceType;
import com.cross.model.*;
import com.cross.model.dish.*;
import com.cross.model.enumeration.OrderState;
import com.cross.model.enumeration.OrderType;
import com.cross.model.enumeration.ShopLimitType;
import com.cross.utils.RestPage;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


/**
 * Created by LY on 2017-9-21 09:13:09
 */
@AuthorizedFeignClient(name = "shop")
public interface ShopService {

    @PutMapping("api/shop-orders/person-accept")
    void updateShopOrderWhenPersonAccept(@RequestParam(value = "orderSn") String orderSn, @RequestParam(value = "personName") String personName,
                                         @RequestParam(value = "personPhone") String personPhone);

    @PutMapping("api/shop-orders/person-take")
    void updateShopOrderWhenPersonTake(@RequestParam(value = "orderSn") String orderSn, @RequestParam(value = "personName") String personName,
                                       @RequestParam(value = "personPhone") String personPhone);

    @PutMapping("api/shop-orders/person-change")
    void updateShopOrderWhenPersonChange(@RequestParam(value = "orderSn") String orderSn, @RequestParam(value = "personName") String personName,
                                         @RequestParam(value = "personPhone") String personPhone);

    @PutMapping("api/shop-orders/finish")
    void updateShopOrderWhenFinish(@RequestParam(value = "orderSn") String orderSn, @RequestParam(value = "personName") String personName,
                                   @RequestParam(value = "personPhone") String personPhone);

    @PutMapping("api/shop-orders/person-take-shipping")
    void updateShopOrderWhenPersonTakeShipping(@RequestParam(value = "orderSn") String orderSn, @RequestParam(value = "personName") String personName,
                                               @RequestParam(value = "personPhone") String personPhone);

    /**
     * 批量添加产品池产品分类
     *
     * @param shopDishProductCatList
     * @return
     */
    @PostMapping("api/shop-dish-product-cats/batch")
    List<ShopDishProductCat> createShopDishProductCatBatch(@RequestBody List<ShopDishProductCat> shopDishProductCatList);

    /**
     * 更新产品池产品分类
     *
     * @param shopDishProductCat
     * @return
     */
    @PutMapping("api/shop-dish-product-cats")
    ShopDishProductCat updateShopDishProductCat(@RequestBody ShopDishProductCat shopDishProductCat);

    /**
     * 添加产品池产品
     *
     * @param shopDish
     * @return
     */
    @PostMapping("api/shop-dishes")
    ShopDish createShopDish(@RequestBody ShopDish shopDish);

    /**
     * 修改产品池产品
     *
     * @param shopDish
     * @return
     */
    @PutMapping("api/shop-dishes")
    ShopDish updateShopDish(@RequestBody ShopDish shopDish);

    /**
     * 获取产品池产品
     *
     * @param id
     * @return
     */
    @GetMapping("api/shop-dishes/{id}")
    ShopDish getShopDish(@PathVariable("id") Long id);

    /**
     * 获取产品池产品包
     *
     * @param id
     * @return
     */
    @GetMapping("api/shop-dish-products/{id}")
    ShopDishProduct getShopDishProduct(@PathVariable("id") Long id);

    /**
     * 获取产品池产品包下分类
     *
     * @param packId
     * @return
     */
    @GetMapping("api/shop-dish-product-cats-by-pack/{packId}")
    List<ShopDishProductCat> getAllShopDishProductCats(@PathVariable("packId") Long packId);

    /**
     * 获取产品池 产品包 产品
     *
     * @param productId
     * @return
     */
    @GetMapping("api/shop-dishes-by-pack-id/{productId}")
    List<ShopDish> getAllShopDishesByPackId(@PathVariable("productId") Long productId);

    /**
     * 获取产品池产品根据ids
     *
     * @param ids
     * @return
     */
    @GetMapping("api/shop-dishes-by-ids")
    List<ShopDish> getShopDishByIds(@RequestParam("ids") String ids);

    @PutMapping("api/self/merchant-reply")
    CommonCommentModel addSelfOrderReply(@RequestBody CommonCommentModel commonCommentModel);

    /**
     * 根据订单编号批量获取订单 注意：这里数据是不全的 不了解结构请不要使用该接口
     *
     * @param orderSns
     * @return
     */
    @PostMapping("api/get-order-by-order-nos")
    List<ShopOrderDTO> getOrdersByOrderNos(@RequestBody List<Long> orderSns);

    /**
     * 修改
     *
     * @param orderSn
     * @return
     */
    @GetMapping("api/shop-orders/print")
    ShopOrderDTO updateShopOrderPrint(@RequestParam("orderSn") String orderSn);

    /**
     * 获取自营产品表 根据IDS
     *
     * @param idList
     * @return
     */
    @GetMapping("api/find-all-by-ids")
    List<ShopDish> getAllByDishIdList(@RequestParam("idList") List<Long> idList);

    /**
     * 通过订单号查找订单
     *
     * @param orderSn
     * @return
     */
    @GetMapping("api/shop-order-by-order-no/{orderId}")
    ShopOrderDTO getShopOrderByOrderSn(@PathVariable("orderId") Long orderSn);

    /**
     * 通过门店查找菜品信息
     *
     * @param merchantId
     * @return
     */
    @GetMapping("api/self-support-dish-list")
    List<ShopDish> getSelfSupportDishList(@RequestParam("merchantId") Long merchantId);

    /**
     * 通过门店查找菜品的规格信息
     *
     * @param merchantId
     * @return
     */
    @GetMapping("api/find-shop-dish-sku-by-merchantId")
    List<ShopDishSku> findAllDishSkuByMerchantId(@RequestParam("merchantId") Long merchantId);

    /**
     * 获取菜品SKU - 通过ids查找
     *
     * @param ids
     * @return
     */
    @GetMapping("api/find-all-sku-by-ids")
    List<ShopDishSku> findAllByIds(@RequestParam("ids") List<Long> ids);

    /**
     * 获取菜品SKU - 通过id查找
     *
     * @param id 规格id
     * @return 规格
     */
    @GetMapping("/api/self-support-dish-skus/{id}")
    SelfSupportDishSkuDTO getSelfSupportDishSku(@PathVariable("id") Long id);

    //创建分类，自定义排序
    @PostMapping("api/create-self-support-dish-cats")
    ShopDishProductCat createSelfSupportDishCatAndSequence(@RequestBody ShopDishProductCat shopDishProductCat);

    //更新分类，自定义排序
    @PutMapping("api/update-self-support-dish-cats")
    ShopDishProductCat updateSelfSupportDishCatAndSequence(@RequestBody ShopDishProductCat shopDishProductCat);

    @PutMapping("api/update-self-support-dish-syn-cats")
    void updateSelfSupportDishCatSyn(@RequestBody List<SelfSupportDishCatDTO> shopDishProductCat);

    @GetMapping("api/get-one-by-id-and-user-id")
    ShopDishProductCat getOneByIdAndUserId(@RequestParam("id") Long id, @RequestParam("userId") Long userId);

    @DeleteMapping("api/self-support-dish-cats/{id}")
    Void deleteSelfSupportDishCat(@PathVariable("id") Long id);

    @GetMapping("api/get-all-dish-category-by-user-id")
    Map<String, Object> getAllByUserId(@RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam("direction") Sort.Direction direction, @RequestParam("sortStr") String sortStr, @RequestParam("userId") Long userId, @RequestParam("merchantId") Long merchantId);

    @PostMapping("api/create-all-self-support-dish")
    SelfSupportDish createAllSelfSupportDish(@RequestBody SelfSupportDish selfSupportDish);

    @GetMapping("api/get-self-dish-by-id-and-user-id")
    SelfSupportDish getOneSelfSupportDishById(@RequestParam("id") Long id, @RequestParam("userId") Long userId);

    @GetMapping("api/get-one-self-dish-and-property-and-sku")
    SelfSupportDish getOneSelfSupportDishAndSkuById(@RequestParam("id") Long id, @RequestParam("userId") Long userId);

    @GetMapping("api/get-all-self-dish-by-user-id")
    Map<String, Object> getAllSelfDish(@RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam("direction") Sort.Direction direction, @RequestParam("sortStr") String sortStr, @RequestParam("userId") Long userId, @RequestParam("merchantId") Long merchantId);

    @DeleteMapping("api/self-support-dishes/{id}")
    Void deleteSelfSupportDish(@PathVariable("id") Long id);

    @PutMapping("api/shop-orders/accept")
    ShopOrderDTO updateShopOrderAccept(@RequestParam("id") Long id);

    @PutMapping("api/shop-orders/reminder/confirm")
    ShopOrderDTO updateShopOrderReminderConfirm(@RequestParam("id") Long id);

    @PutMapping("api/shop-orders/refunds")
    ShopOrderDTO updateShopOrderWhenRefunds(@RequestParam("id") Long id, @RequestParam("merchantRefunds") Boolean merchantRefunds, @RequestParam(value = "merchantRefundsReason", required = false) String merchantRefundsReason);

    @GetMapping("api/get-order-by-id")
    ShopOrderDTO getOneById(@RequestParam("id") Long id, @RequestParam("merchantUserId") Long merchantUserId);

    @GetMapping("api/get-all-shop-order-by-user-id")
    Map<String, Object> getAllShopOrderByUserId(@RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam("direction") Sort.Direction direction, @RequestParam("sortStr") String sortStr);

    @GetMapping("api/get-merchant-activity")
    Map<Long, List<MerchantActivityVM>> getMerchantAllActivity(@RequestParam("merchantIdList") List<Long> merchantIdList);


    @GetMapping("api/get-merchant-activity-with-platform")
    Map<Long, List<MerchantActivityVM>> getMerchantAllActivityWithPlatformId(@RequestParam("platformId") Long platformId, @RequestParam("merchantIdList") List<Long> merchantIdList);


    @GetMapping("api/get-self-dish-sku-by-dish-ids")
    List<ShopDishSku> findAllSkuByDishIdList(@RequestParam("dishIdList") List<Long> dishIdList);

    @PutMapping("api/shop-orders/merchant-cancelled")
    ShopOrderDTO updateShopOrderWhenMerchantCancelled(@RequestParam("id") Long id, @RequestParam(value = "cancelReason", required = false) String cancelReason);

    @GetMapping("api/self-dish-property-by-dish-id")
    List<SelfSupportDishProperty> getAllDishPropertyByDishIdList(@RequestParam("dishId") Long dishId);

    @PostMapping("api/save-shop-order")
    ShopOrderDTO saveShopOrder(@RequestBody ShopOrderDTO shopOrderDTO);

    @GetMapping("api/create-order-state-change-info")
    void saveOrderStateChangeInfo(@RequestParam("orderSn") String orderSn, @RequestParam("orderState") OrderState orderState);

    /**
     * 通过菜品id查询菜品
     *
     * @param id
     * @return
     */
    @GetMapping("api/self-support-dishes/{id}")
    ShopDish getSelfSupportDish(@PathVariable("id") Long id);

    /**
     * 海普核销对接接口
     *
     * @param writeOffCode       核销码编号
     * @param useCount           核销张数
     * @param externalMerchantNo 外部门店编码
     * @param externalSkuNoList  外部菜品编码
     * @return
     */
    @PutMapping("api/hai-pu-write-off")
    Map<String, Object> haiPuWriteOffByCode(@RequestParam("writeOffCode") String writeOffCode, @RequestParam(value = "useCount", required = false) Integer useCount,
                                            @RequestParam("externalMerchantNo") String externalMerchantNo, @RequestParam("externalSkuNoList") List<String> externalSkuNoList,
                                            @RequestParam("salesOrderGUID") String salesOrderGUID);

    /**
     * 创建门店下的必选分类
     *
     * @param brandId
     * @param merchantId
     * @param userId
     */
    @PutMapping("api/create-must-cat")
    void createMustCat(@RequestParam("brandId") Long brandId, @RequestParam("merchantId") Long merchantId, @RequestParam("userId") Long userId);

    /**
     * 通过条件获取菜品信息
     *
     * @param dishIdList
     * @param brandId
     * @param merchantId
     * @param dishName
     * @param type
     * @param source     1:赚餐自营  2：通吃岛（当前平台绑定的门店入驻了通吃岛就可以看见当前门店下入驻通吃岛的商品，与平台的套餐商品没有关系）
     * @param isEntering 是否入驻成功
     * @param platformId 平台编号(获取分销收益必传)
     * @return
     */
    @GetMapping("api/get-dish-info-by-condition")
    List<ShopDish> getShopDishByPlatformCondition(@RequestParam("dishIdList") List<Long> dishIdList,
                                                  @RequestParam(required = false, value = "brandId") Long brandId,
                                                  @RequestParam(required = false, value = "merchantId") Long merchantId,
                                                  @RequestParam(required = false, value = "dishName") String dishName,
                                                  @RequestParam(required = false, value = "type") Integer type,
                                                  @RequestParam(required = false, value = "source") Integer source,
                                                  @RequestParam(required = false, value = "isEntering") Boolean isEntering,
                                                  @RequestParam(required = false, value = "platformId") Long platformId,
                                                  @RequestParam(required = false, value = "bindDishIds") List<Long> bindDishIds);


    /**
     * 通过平台id和门店id获取开启的满减活动
     *
     * @param platformId
     * @param merchantIdList
     * @return
     */
    @GetMapping("api/get-platform/merchant-open-full-activity")
    List<ShopFullReductionActivityDTO> getPlatformMerchantOpenFullActivity(@RequestParam("platformId") Long platformId, @RequestParam("merchantIdList") List<Long> merchantIdList, @RequestParam("buissnessType") Integer buissnessType);

    /**
     * 通过dishName查询dishIdList
     *
     * @param dishName
     * @return
     */
    @GetMapping("api/get-dish-id-by-dish-name")
    List<Long> findDishInfoByDishName(@RequestParam("dishName") String dishName);

    /**
     * 查找待处理的业务订单 1.未接单的订单  2.接单之后需要发快寄和发配送的订单
     *
     * @param platformId
     * @return
     */
    @GetMapping("api/get-business-order-pending-event/{platformId}")
    Long getBusinessOrderCountByPending(@PathVariable("platformId") Long platformId);

    /**
     * 查找待处理的售后订单数量:申请退款后需要处理的订单
     *
     * @param platformId
     * @return
     */
    @GetMapping("api/get-after-sale-order-pending-event/{platformId}")
    Long getAfterSaleOrderCountByPending(@PathVariable("platformId") Long platformId);

    /**
     * 查找待处理的业务订单 1.未接单的订单  2.接单之后需要发快寄和发配送的订单
     *
     * @param merchantIds
     * @return
     */
    @GetMapping("api/get-business-order-pending-event/merchant")
    Long getBusinessOrderCountByPendingAndMerchantId(@RequestParam("merchantIds") List<Long> merchantIds);

    /**
     * 查找待处理的售后订单数量:申请退款后需要处理的订单
     *
     * @param merchantIds
     * @return
     */
    @GetMapping("api/get-after-sale-order-pending-event/merchant")
    Long getAfterSaleOrderCountByPendingAndMerchantId(@RequestParam("merchantIds") List<Long> merchantIds);

    /**
     * 通过skuId修改商品销量
     *
     * @param skuId
     * @param saleNum
     */
    @GetMapping("api/update-sale-num/sku-id")
    void updateSaleNumById(@RequestParam("skuId") Long skuId, @RequestParam("saleNum") Integer saleNum);

    /**
     * 创建客户信息
     *
     * @param shopOrderDTO
     */
    @PostMapping("api/create-client-info")
    void createClientInfo(@RequestBody ShopOrderDTO shopOrderDTO);

    /**
     * 获取分销订单列表
     *
     * @param page
     * @param size
     * @param sort
     * @param keyword
     * @param pattern
     * @param startTime
     * @param endTime
     * @param status
     * @param orderType
     * @param platformId
     * @return
     */
    @GetMapping("api/find/distributor-orders")
    RestPage<ShopOrderDTO> findDistributorOrder(@RequestParam("page") Integer page,
                                                @RequestParam("size") Integer size,
                                                @RequestParam("sort") List<String> sort,
                                                @RequestParam("keyword") String keyword,
                                                @RequestParam("pattern") String pattern,
                                                @RequestParam("startTime") String startTime,
                                                @RequestParam("endTime") String endTime,
                                                @RequestParam("status") Integer status,
                                                @RequestParam("orderType") OrderType orderType,
                                                @RequestParam("platformId") Long platformId);

    /**
     * 获取通吃岛分销订单
     *
     * @param
     * @param keyword
     * @param pattern
     * @param startTime
     * @param endTime
     * @param status
     * @param orderType
     * @param platformId
     * @param brandIds
     * @param dishIds
     * @return
     */
    @GetMapping("api/find/distributor-orders-tcd")
    RestPage<ShopOrderDTO> findDistributorOrderWithTcd(@RequestParam("page") Integer page,
                                                       @RequestParam("size") Integer size,
                                                       @RequestParam("sort") List<String> sort,
                                                       @RequestParam("keyword") String keyword,
                                                       @RequestParam("pattern") String pattern,
                                                       @RequestParam("startTime") String startTime,
                                                       @RequestParam("endTime") String endTime,
                                                       @RequestParam("status") Integer status,
                                                       @RequestParam("orderType") OrderType orderType,
                                                       @RequestParam("platformId") Long platformId,
                                                       @RequestParam("brandIds") List<Long> brandIds,
                                                       @RequestParam("merchantIds") List<Long> merchantIds,
                                                       @RequestParam("dishIds") Long dishIds,
                                                       @RequestParam("weappUserId") Long weappUserId);

    /**
     * 通过id和入驻状态批量查找菜品信息
     *
     * @param ids
     * @param enteringInfo
     * @param dishName
     * @return
     */
    @GetMapping("api/get-self-dish/entering-tcd")
    List<ShopDish> getDishByIdsAndEnteringInfo(@RequestParam("ids") List<Long> ids, @RequestParam("enteringInfo") Integer enteringInfo, @RequestParam(value = "dishName", required = false) String dishName);

    /**
     * 通过id和入驻状态批量查找菜品信息
     *
     * @param ids
     * @param enteringInfo
     * @return
     */
    @GetMapping("api/get-self-dish/id-and-entering-info")
    List<ShopDish> getDishByEnteringInfo(@RequestParam("ids") List<Long> ids, @RequestParam("enteringInfo") Integer enteringInfo);


    /**
     * 通过菜品id获取菜品详情
     *
     * @param dishId
     * @return
     */
    @GetMapping("api/gei-dish-detail/{dishId}")
    SelfDishDetails findDishDetailByDishId(@PathVariable("dishId") Long dishId);

    /**
     * 修改平台下顾客的分销状态为true
     *
     * @param platformId
     * @param consumerId
     * @return
     */
    @GetMapping("api/update-client-distributor-state/platform-id")
    Integer updateClientDistributorState(@RequestParam("platformId") Long platformId, @RequestParam("consumerId") Long consumerId);


    /**
     * 根据订单id修改分销订单类型
     *
     * @param id
     * @param codeSign
     * @return
     */
    @PutMapping("api/update-shop-order-code-sign/{id}/{codeSign}")
    Boolean updateShopOrderCodeSign(@PathVariable("id") Long id, @PathVariable("codeSign") Integer codeSign);

    /**
     * 更新平台菜品状态
     *
     * @param platformId
     * @param dishId
     * @param isShow
     * @return
     */
    @PutMapping("api/update-platform-dish/state")
    Integer updatePlatformDishState(@RequestParam("platformId") Long platformId, @RequestParam("dishId") Long dishId, @RequestParam("isShow") Boolean isShow);

    /**
     * 更新平台菜品状态
     *
     * @param platformId
     * @param dishId
     * @return
     */
    @PutMapping("api/delete-platform-dish")
    Integer deletePlatformDish(@RequestParam("platformId") Long platformId, @RequestParam("dishId") Long dishId);

    /**
     * 更新平台菜品置顶时间
     *
     * @param platformId
     * @param dishId
     * @return
     */
    @PutMapping("api/synchronize-dish-top-time")
    Integer synchronizeDishTopTime(@RequestParam("platformId") Long platformId, @RequestParam("dishId") Long dishId);


    @GetMapping("api/shipping-lists-ids")
    List<ShippingListModel> getAllShippingListsByIds(@RequestParam("ids") List<Long> ids);

    @PostMapping("api/find/findByBrandIds")
    List<Object> getBusinessAccountModels(@RequestBody Object brandIds);

    /**
     * 通过商户id查询桌号信息
     *
     * @param MerchantId 商户号
     * @return 返回该商户下的所有桌号信息
     */
    @GetMapping("api/find-table-by-merchantId")
    List<MerchantTableDTO> getMerchantTables(@RequestParam("MerchantId") Long MerchantId);

    /**
     * 查找商户必选商品
     */
    @GetMapping("api/c-merchant-must-choose")
    List<ShopDishProductCat> getMustChoose(@RequestParam("merchantId") Long merchantId);

    @GetMapping("api/get-shoporder-by-platformidanduserid")
    List<ShopOrderDTO> getShopOrdersByPlatformIdAndUserid(@RequestParam("platformId") Long platformId, @RequestParam("userIds") List<Long> userIds);


    @RequestMapping("api/get-shop-order-with-state/{tcdId}/{platformId}")
    BigDecimal getShopOrderFinishAmountWithOrderState(@PathVariable("tcdId") Long tcdId, @PathVariable("platformId") Long platformId, @RequestParam("state") Integer state);

    @GetMapping("api/_search/qr-code-order-promotions-all")
    ShopFullReductionActivityDTO searchPromotions(@RequestParam("platForm") Long platForm, @RequestParam("merchant") Long merchant, @RequestParam("type") Integer type);

    @GetMapping("api/shop-orders/merchant")
    List<ShopOrderDTO> getAllShopOrdersByMerchant(@RequestParam("merchantId") Long merchantId);

    @PostMapping("api/update-activity-status")
    void updateStatus(@RequestParam("ids") List<Long> ids, @RequestParam("businessType") Integer businessType, @RequestParam("openActivity") Boolean openActivity);

    /**
     * 根据平台和门店列表获取销量最高的商品
     *
     * @param platformId
     * @param merchantIds
     * @return
     */
    @GetMapping("api/get-sale-max-amount-dish-platform-with-merchants")
    Map<Long, List<Long>> getMaxSaleAmountByPlatformIdAndMerchantIdIn(@RequestParam("platformId") Long platformId, @RequestParam("merchantIds") List<Long> merchantIds, @RequestParam("limit") Integer limit);


    @GetMapping("api/get-all-by-odersn-in")
    List<ShopOrderDTO> getAllByOderSnIn(@RequestParam("oderSnList") List<String> oderSnList);


    /**
     * 根据平台id和门店ids获取销量排行
     *
     * @param platformId
     * @param merchantIds
     * @param sort
     * @return
     */
    @GetMapping("api/find-merchant-ids-with-merchant-ids-and-sale-value")
    List<Long> findMerchantIdByMerchantIdInAndSaleValueAndSort(@RequestParam("platformId") Long platformId,
                                                               @RequestParam("merchantIds") List<Long> merchantIds,
                                                               @RequestParam("sort") Integer sort);


    /**
     * 根据平台id和菜品模糊搜索门店和商品id
     *
     * @param name
     * @param platformId
     * @return
     */
    @GetMapping("api/find-list-with-platform-dish-name")
    Map<Long, Long> findDishInfoByDishNameAndPlatformId(@RequestParam("name") String name, @RequestParam("platformId") Long platformId);


    /**
     * 根据平台id和商品ids获取销量排行
     *
     * @param platformId
     * @param dishIds
     * @return
     */
    @GetMapping("api/sale-order-dish-with-platform-dishs")
    List<Long> getSaleOrderWithPlatformIdAndDishIds(@RequestParam("platformId") Long platformId, @RequestParam("dishIds") List<Long> dishIds);

    /**
     * 旅划算 现金卡信息查询接口
     *
     * @return
     */
    @GetMapping("api/queryPrestoreCard")
    @ApiOperation("旅划算 现金卡信息查询接口")
    Map<String, Object> queryPrestoreCard(@RequestParam(name = "thirdPartyInfoModelStrs") String thirdPartyInfoModels);

    /**
     * 根据商品id 获取商品列表
     *
     * @param ids
     * @return
     */
    @GetMapping("api/find/by/ids")
    List<SelfSupportDish> getDishByids(@RequestParam("ids") List<Long> ids);


    /**
     * 根据分类id获取分类列表
     *
     * @param catIds
     * @return
     */
    @GetMapping("api/get-supportDishCat-byIds")
    List<SelfSupportDishCatDTO> getSupportDishCat(@RequestParam("catIds") List<Long> catIds);


    @GetMapping("api/shopOrder/search/time")
    Long get4HourCount(@RequestParam("platId") Long platId, @RequestParam("merId") Long merId, @RequestParam("userId") Long userId, @RequestParam("tableId") Long tableId, @RequestParam("time") Long time);

    @GetMapping("api/shopOrder/limit/search")
    Long limitSearch(@RequestParam("paltFormId") Long paltFormId, @RequestParam("userId") Long userId, @RequestParam("shopLimitType") ShopLimitType shopLimitType, @RequestParam("dishId") Long dishId,@RequestParam("bool") Boolean bool);

    @GetMapping("api/self-support-dishes-by-dishId")
    List<ShopDish> getSelfSupportDishesById(@RequestParam("dishIds") List<Long> dishIds);

    @PostMapping("api/self-support-dish-skus")
    SelfSupportDishSkuDTO createSelfSupportDishSku(@RequestBody SelfSupportDishSkuDTO selfSupportDishSkuDTO);

    @PostMapping("api/self-support-dishes")
    SelfSupportDishDTO createSelfSupportDish(@RequestBody SelfSupportDishDTO selfSupportDishDTO);

    @GetMapping("api/get-shop-dish-by-thirdNo")
    List<SelfSupportDishDTO> getShopDishByThirdNo(@RequestParam("thirdNo") List<String> thirdNo, @RequestParam("catId") List<Long> catId);


    @GetMapping("api/get-all-orderwriteoffcode-by-ordersnlist")
    List<OrderWriteOffCodeDTO> getAllOrderWriteOffCodeByOrderSnList(@RequestParam("snList") List<String> snList);

    @PostMapping("api/find-by-third-no")
    List<SelfSupportDishCatDTO> findByThirdNo(@RequestParam("strings") List<String> strings, @RequestBody CatSourceType catSourceType, @RequestParam("merchantId") Long merchantId);

    @PostMapping("api/find-by-cat-source-type")
    List<SelfSupportDishCatDTO> findByCatSourceType(@RequestBody CatSourceType catSourceType, @RequestParam("merchantId") Long merchantId);

    @PostMapping("api/find-by-cat-source-types")
    List<SelfSupportDishCatDTO> findByCatSourceTypes(@RequestBody List<CatSourceType> catSourceType, @RequestParam("merchantId") List<Long> merchantId);

    @PutMapping("api/update-mdm-support-dish-cats")
    Boolean updateSelfSupportDishCatMdm(@RequestBody List<SelfSupportDishCatDTO> selfSupportDishCatDTO);

    @DeleteMapping("api/delete-mdm-support-dish-cats")
    Boolean deleteSelfSupportDishCatMdm(@RequestParam("thirdNo") List<String> thirdNo);


    @DeleteMapping("api/delete-mdm-support-sku-cats")
    Boolean deleteMdmSkuBythirdNo(@RequestParam("collect") List<String> collect);

    @PutMapping("api/update-mdm-support-sku-cats")
    Boolean updateMdmSkuBythirdNo(@RequestBody List<SelfSupportDishSkuDTO> toLocal);

    @PostMapping("api/add-mdm-support-sku-cats")
    Boolean addMdmSkuBythirdNo(@RequestBody List<ItemSkuDTO> itemSku);

    @PutMapping("api/update-mdm-support-dish")
    Boolean updateMdmDishs(@RequestBody List<SelfSupportDishDTO> toLocal);

    @DeleteMapping("api/delete-mdm-support-dish")
    Boolean deleteMdmDishsByThirdNo(@RequestParam("collect")List<String> collect);
}
