package com.cross.client;

import com.cross.bean.HolderCard.MemberCardPayParam;
import com.cross.config.AuthorizedFeignClient;
import com.cross.model.*;
import com.cross.model.enumeration.BrandAndMerchantType;
import com.cross.model.enumeration.ThirdPartyType;
import com.cross.utils.RestPage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by DuYuLiang on 2017/7/3.
 */
@Component
@AuthorizedFeignClient(name = "merchant") //, configuration = OAuth2UserClientFeignConfiguration.class
public interface MerchantService {
    
    @GetMapping("api/find-one-by-id")
    MerchantDTO findOne(@RequestParam("id") Long id);
    
    @GetMapping("api/merchantsByMerchantNo/{merchantNo}")
    MerchantModel getMerchantByMerchantNo(@PathVariable("merchantNo") Long merchantNo);
    
    @GetMapping("api/find-merchantsByMerchantNo")
    MerchantVM findMerchantByMerchantNo(@RequestParam("merchantNo") Long merchantNo);
    
    @PutMapping("api/merchants")
    MerchantVM updateMerchant(@Valid @RequestBody MerchantVM merchantVM);
    
    @GetMapping("api/merchants/position/{id}")
    String getMerchantPosition(@PathVariable("id") Long id);
    
    @GetMapping("api/merchants/{id}")
    MerchantVM getMerchantById(@PathVariable("id") Long id);
    
    @PutMapping("api/save-dada-shopId")
    MerchantVM updateDadaShopId(@RequestParam("dadaShopId") Long dadaShopId, @RequestParam("merchantId") Long merchantId);
    
    @GetMapping("api/merchant-details/{id}")
    MerchantDetailModel getMerchantDetails(@PathVariable("id") Long id);
    
    @GetMapping("api/brands/{id}")
    BrandDTO getBrandById(@PathVariable("id") Long id);
    
    @GetMapping("api/brands-list/auto-reply")
    List<BrandDTO> getBrandByIdInAndAutoReply(@RequestParam("idList") List<Long> idList);
    
    @GetMapping("api/brands-list")
    List<BrandDTO> getBrandByIdIn(@RequestParam("idList") List<Long> idList);
    
    @PutMapping("api/merchants/fraction")
    void updateMerchantFraction(@RequestParam("merchantId") Long merchantId, @RequestParam("fraction") Double fraction, @RequestParam("merchantFraction") Double merchantFraction,
                                @RequestParam("shippingFraction") Double shippingFraction, @RequestParam("productFraction") Double productFraction);
    
    @PutMapping("api/merchants/month-count")
    void updateMerchantMonthCount(@RequestParam("merchantId") Long merchantId);
    
    @GetMapping("api/merchants-by-merchant-no/{merchantNos}")
    List<MerchantModel> getMerchantFromPlatForm(@PathVariable("merchantNos") String merchantNo);
    
    @GetMapping("api/merchants-by-merchant-idList")
    List<MerchantModel> getMerchantByIdIn(@RequestParam("merchantIdList") List<Long> merchantIdList);
    
    @GetMapping("api/merchants-by-merchant-idList/auto-reply")
    List<MerchantModel> getMerchantByIdListAutoReply(@RequestParam("merchantIdList") List<Long> merchantIdList);
    
    @GetMapping("api/merchants-operation")
    List<MerchantModel> getMerchantByOperation(@RequestParam(name = "brandId", required = false) Long brandId, @RequestParam(name = "merchantId", required = false) Long merchantId,
                                               @RequestParam(name = "userId", required = false) Long userId, @RequestParam(name = "merchantIdList", required = false) List<Long> merchantIdList);
    
    @PutMapping("api/merchants/status")
    void updateMerchantStatus(@RequestParam("merchantNos") List<Long> merchantNos, @RequestParam("status") Integer status);
    
    @GetMapping("api/merchants/all")
    List<MerchantModel> getAllMerchant();
    
    @PutMapping("api/merchants/day-count")
    void updateMerchantDayCount(@RequestParam("merchantNo") Long merchantNos);
    
    /**
     * 获取店铺下设置的打印机列表
     *
     * @param merchantId
     * @return
     */
    @GetMapping("api/merchant-printers-by-merchant-id/{merchantId}")
    List<MerchantPrinterModel> getMerchantPrinterByMerchantId(@PathVariable("merchantId") Long merchantId);
    
    @PostMapping("api/merchants/platform")
    MerchantModel addMerchantPlatform(@RequestParam("userId") Long userId, @RequestParam("merchantName") String merchantName, @RequestParam("phone") String phone, @RequestParam(value = "brandId", required = false) Long brandId);
    
    @PostMapping("api/merchants/platform")
    MerchantModel addMerchantPlatform(@RequestParam("userId") Long userId, @RequestParam("merchantName") String merchantName, @RequestParam("phone") String phone);
    
    @GetMapping("api/regions/merchant/{merchantId}")
    String getCityNameByMerchantId(@PathVariable("merchantId") Long merchantId);
    
    @PutMapping("api/merchants/auto-reply")
    void updateMerchantAutoReply(@RequestParam("merchantId") Long merchantId, @RequestParam("autoReply") Boolean autoReply, @RequestParam("onlyEmpty") Boolean onlyEmpty);
    
    @PutMapping("api/brands/auto-reply")
    void updateBrandAutoReply(@RequestParam("brandId") Long brandId, @RequestParam("autoReply") Boolean autoReply, @RequestParam("onlyEmpty") Boolean onlyEmpty);
    
    /**
     * 通过userId查询所有的品牌数量
     *
     * @param userId
     * @return
     */
    @GetMapping("api/brand-count")
    Long findAllBrandCount(@RequestParam(name = "userId", required = false) Long userId);
    
    /**
     * 通过userId查找所有商户数量
     *
     * @param userId
     * @return
     */
    @GetMapping("api/find-merchant-count")
    Long findMerchantCount(@RequestParam(name = "userId", required = false) Long userId);
    
    /**
     * 根据品牌获取商户列表
     *
     * @param brandId
     * @return
     */
    @GetMapping("api/merchants/by-brand/{brandId}")
    List<MerchantModel> getMerchantsByBrandId(@PathVariable("brandId") Long brandId);
    
    /**
     * 绑定美团店铺
     *
     * @param merchantId
     * @param meiTuanShopId
     */
    @GetMapping("api/merchants/bind-mei-tuan")
    void merchantBindMeiTuanShop(@RequestParam("merchantId") Long merchantId, @RequestParam("meiTuanShopId") String meiTuanShopId);
    
    /**
     * 绑定饿了么店铺
     *
     * @param merchantId
     * @param eleMeShopId
     */
    @GetMapping("api/merchants/bind-ele-me")
    void merchantBindEleMeShop(@RequestParam("merchantId") Long merchantId, @RequestParam("eleMeShopId") Long eleMeShopId);
    
    @GetMapping("api/findOneByRegionId/{region_id}")
    RegionModel findOneByRegionId(@PathVariable("region_id") String region_id);
    
    /**
     * 根据收款账户ID获取商户账户
     *
     * @param receiveAccountIds
     * @return
     */
    @GetMapping("api/receive-accounts-by-user-id/account")
    Map<Long, String> getAllReceiveAccountsByReceiveAccountIds(@RequestParam("receiveAccountIds") Set<Long> receiveAccountIds);
    
    /**
     * 创建合伙人订单
     *
     * @param distributorOrderDTO
     * @return
     */
    @PostMapping("api/distributor-orders")
    DistributorOrderDTO createDistributorOrder(@RequestBody DistributorOrderDTO distributorOrderDTO);
    
    /**
     * 根据合伙人编号获取合伙人
     *
     * @param code
     * @return
     */
    @GetMapping("api/distributors-by-code/{code}")
    DistributorDTO getDistributorByCode(@PathVariable("code") Long code);
    
    /**
     * 根据合伙人编号获取合伙人
     *
     * @param merchantId
     * @return
     */
    @GetMapping("api/distributor-merchant-configs-by-merchant/{merchantId}")
    DistributorMerchantConfigVM getDistributorMerchantConfigByMerchantId(@PathVariable("merchantId") Long merchantId);
    
    @GetMapping("api/distributor-merchant-shops-by-merchant-no-page/{merchantId}")
    List<DistributorMerchantShopVM> getDistributorMerchantShopByMerchantNoPage(@PathVariable("merchantId") Long merchantId);
    
    @GetMapping("api/get-merchant-info-by-id")
    MerchantModel getMerchantByMerchantId(@RequestParam("merchantId") Long merchantId);
    
    @PutMapping("api/brands")
    BrandDTO saveBrand(@RequestBody BrandDTO brandDTO);
    
    @GetMapping("api/get-merchant-by-brand-id")
    List<MerchantModel> getMerchantByBrandId(@RequestParam("brandId") Long brandId);
    
    @GetMapping("api/get-merchant-alias-by-brand-id")
    List<MerchantAliasInfoModel> getAliasInfoByBrandId(@RequestParam("brandId") Long brandId);
    
    @GetMapping("api/regionsByParentId/{parentId}")
    List<RegionModel> getAllRegionByParent(@PathVariable("parentId") String parentId);
    
    @PostMapping("api/brands")
    BrandDTO createBrand(@Valid @RequestBody BrandDTO brandDTO);
    
    @GetMapping("api/get-all-brand-by-user-id")
    Map<String, Object> getAllByPageAndUserId(@RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam("direction") Sort.Direction direction, @RequestParam("sortStr") String sortStr, @RequestParam("userId") Long userId);
    
    @GetMapping("api/get-one-by-id-and-user-id")
    BrandDTO getOneByIdAndUserId(@RequestParam("id") Long id, @RequestParam("userId") Long userId);
    
    @PostMapping("api/merchants")
    MerchantVM createMerchant(@Valid @RequestBody MerchantVM merchantVm);
    
    @PutMapping("api/update-status-by-id")
    MerchantVM updateMerchantStatusById(@RequestParam("id") Long id, @RequestParam("status") Integer status, @RequestParam("userId") Long userId);
    
    @GetMapping("api/get-merchant-by-id-and-user-id")
    MerchantVM getMerchantByMerchantIdAndUserId(@RequestParam("merchantId") Long merchantId, @RequestParam("userId") Long userId);
    
    @GetMapping("api/get-all-by-user-id")
    Map<String, Object> getAllMerchantByUserId(@RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam("direction") Sort.Direction direction, @RequestParam("sortStr") String sortStr, @RequestParam("userId") Long userId, @RequestParam("brandId") Long brandId);
    
    @PutMapping("api/create-brands")
    BrandDTO createOneBrand(@RequestBody BrandDTO brandDTO);
    
    @PutMapping("api/update-merchant")
    MerchantVM updateMerchantAndDetails(@RequestBody MerchantVM merchantVM);
    
    @PutMapping("api/update-merchant-with-tcd")
    MerchantVM updateMerchantAndDetailsWithTcd(@RequestBody MerchantVM merchantVM);
    
    @GetMapping("api/get-user-brands")
    List<BrandDTO> getAllBrandsByLoginUser();
    
    @PutMapping("api/update-user-id-by-brand-ids")
    void updateBrandUserId(@RequestParam("brandIdList") List<Long> brandIdList, @RequestParam("userId") Long userId);
    
    @PutMapping("api/update-merchant-user-id-by-brand")
    void updateMerchantUserIdByBrand(@RequestParam("brandIdList") List<Long> brandIdList, @RequestParam("userId") Long userId);
    
    @GetMapping("api/count-distributor-by-rank")
    Integer getCountByRank(@RequestParam("rank") Long rank);
    
    @GetMapping("api/distributors-free-join")
    Boolean joinDistributorByFree(@RequestParam("platformId") Long platformId, @RequestParam(value = "code", required = false) Long code,
                                  @RequestParam("level") Integer level, @RequestParam("partnerId") Long partnerId);
    
    @GetMapping("api/distributors-buy-join")
    Boolean joinDistributorByBuy(@RequestParam("platfomId") Long platfomId, @RequestParam(value = "code", required = false) Long code,
                                 @RequestParam("partnerId") Long partnerId, @RequestParam("consumerId") Long consumerId);
    
    @GetMapping("api/get-distributor-order-commission-by-order-sn-list")
    List<DistributorOrderCommissionModel> getAllByOderSnList(@RequestParam("orderSnList") List<String> orderSnList);
    
    @GetMapping("api/get-merchant-shipping-info-by-merchant-no")
    MerchantShippingInfoModel getOneByMerchantNo(@RequestParam("merchantNo") Long merchantNo);
    
    @GetMapping("api/get-merchant-details-by-merchant")
    List<MerchantDetailModel> getAllByMerchantIdList(@RequestParam("merchantIdList") List<Long> merchantIdList);
    
    @GetMapping("api/get-merchant-shipping-info-by-merchant-no-list")
    List<MerchantShippingInfoModel> getAllByMerchantNoList(@RequestParam("merchantNoList") List<Long> merchantNoList);
    
    @GetMapping("api/get-merchant-shipping-info-by-dish")
    Map<Long, List<DishMerchantInfoVM>> getAllDishBindMerchantShippingInfo(@RequestParam("dishIdList") List<Long> dishIdList, @RequestParam("dishMap") String dishMap, @RequestParam("platformId") Long platformId);
    
    @PostMapping("api/create-merchants-by-platform")
    MerchantModel createMerchantByPlatform(@Valid @RequestBody MerchantVM merchantVm, @RequestParam(value = "type", required = false) Integer type);
    
    /**
     * 菜品绑定门店
     *
     * @param list
     * @return
     */
    @PostMapping("api/create-dish-and-merchant-bind")
    List<DishMerchantInfoVM> createDishAndMerchantBindList(@RequestBody List<DishMerchantInfoVM> list, @RequestParam("dishId") Long dishId);
    
    @PostMapping("api/create-dish-and-merchant-bind-platform")
    @ApiOperation("菜品绑定门店")
    List<DishMerchantInfoVM> createDishAndMerchantBindListAndPlatformId(@RequestParam("platformId") Long platformId,
                                                                        @RequestBody List<DishMerchantInfoVM> list,
                                                                        @RequestParam("dishId") Long dishId);
    
    /**
     * 通过菜品id查找绑定门店
     *
     * @param dishIdList
     * @return
     */
    @GetMapping("api/dish-bind-merchant-by-dish-id-in")
    List<DishMerchantInfoVM> getDishBindMerchantByDishIdList(@RequestParam("dishIdList") List<Long> dishIdList);
    
    /**
     * 通过外部编码查找门店信息
     *
     * @param externalMerchantNo
     * @return
     */
    @GetMapping("api/get-merchant-by-external-merchant-no")
    MerchantModel getMerchantByExternalMerchantNo(@RequestParam("externalMerchantNo") String externalMerchantNo);
    
    /**
     * 为第三方创建品牌
     *
     * @param platformId
     * @param thirdPartyType
     */
    @GetMapping("api/create-third-partner-brand")
    void createThirdPartnerBrand(@RequestParam("platformId") Long platformId, @RequestParam("thirdPartyType") ThirdPartyType thirdPartyType);
    
    /**
     * 通过类型获取第三方品牌
     *
     * @param thirdPartyType
     * @return
     */
    @GetMapping("api/get-third-party-brand")
    BrandDTO getThirdPartyBrand(@RequestParam("thirdPartyType") ThirdPartyType thirdPartyType);
    
    /**
     * 通过品牌和外部编码批量查询
     *
     * @param externalMerchantNoLis
     * @param brandId
     * @return
     */
    @GetMapping("api/get-merchant-by-brand-and-external-in")
    List<MerchantModel> getMerchantByBrandAndExternalMerchantNoIn(@RequestParam("brandId") Long brandId, @RequestParam("externalMerchantNoLis") List<String> externalMerchantNoLis);
    
    
    /**
     * 通过门店名称和品牌查找门店信息
     *
     * @param brandId
     * @param merchantName
     * @return
     */
    @GetMapping("api/get-merchant-by-brand-and-name")
    List<MerchantModel> getAllByBrandAndMerchantName(@RequestParam("brandId") Long brandId, @RequestParam("merchantName") String merchantName);
    
    /**
     * 通过平台id和门店id查询
     *
     * @param platformId
     * @param merchantId
     * @return
     */
    @GetMapping("api/distributor-merchant-shops-by-platform-or-platform-merchant/{platformId}")
    List<DistributorMerchantShopDTO> getDistributorMerchantShopByPlatformId(@PathVariable("platformId") Long platformId,
                                                                            @RequestParam("merchantId") Long merchantId);
    
    
    /**
     * 通过平台id和门店id查询
     *
     * @param platformId
     * @param merchantId
     * @return
     */
    @GetMapping("api/distributor-merchant-shops-by-platform-or-platform-merchant/page-info/{platformId}")
    RestPage<DistributorMerchantShopDTO> getDistributorMerchantShopByPlatformIdAndPageInfo(@RequestParam("page") Integer page,
                                                                                           @RequestParam("size") Integer size,
                                                                                           @RequestParam("sort") List<String> sort, @PathVariable("platformId") Long platformId,
                                                                                           @RequestParam("merchantId") Long merchantId);
    
    /**
     * 通过平台id和门店ids查询
     *
     * @param platformId
     * @param merchantIds sx
     * @return
     */
    @GetMapping("api/distributor-merchant-shops-by-platform-or-platform-merchants-check-state")
    RestPage<DistributorMerchantShopDTO> getDistributorMerchantShopByPlatformIdAndMerchantIdsAndCheckStateIn(@RequestParam("page") Integer page,
                                                                                                             @RequestParam("size") Integer size,
                                                                                                             @RequestParam("sort") List<String> sort, @RequestParam("platformId") Long platformId,
                                                                                                             @RequestParam("merchantIds") List<Long> merchantIds,
                                                                                                             @RequestParam("checkState") List<Integer> checkState,
                                                                                                             @RequestParam("brandIds") List<Long> brandIds,
                                                                                                             @RequestParam("shopIndexRatio") Boolean shopIndexRatio);
    
    /**
     * 通过平台id和门店id查找分销菜品id
     *
     * @param platformId
     * @param merchantId
     * @return
     */
    @GetMapping("api/distributor-merchant-dish-id/platform-and-merchant")
    List<Long> findDishIdByPlatformIdAndMerchantId(@RequestParam("platformId") Long platformId, @RequestParam("merchantId") Long merchantId);
    
    /**
     * 根据平台id、商品id查询和门店id查询分销商品的记录数
     *
     * @param platformId
     * @param merchantId
     * @param dishId
     * @return
     */
    @GetMapping("api/distributor-merchant-shops-by-platform-merchant-dishId/{platformId}/{merchantId}/{dishId}")
    Integer getCountDistributorMerchantShopByMerchantAndPlatformIdAndDishId(@PathVariable("platformId") Long platformId,
                                                                            @PathVariable("merchantId") Long merchantId,
                                                                            @PathVariable("dishId") Long dishId);
    
    
    /**
     * 通过平台id、商品id、门店id查找分销记录id
     *
     * @param platformId
     * @param merchantId
     * @return
     */
    @GetMapping("api/distributor-merchant/platform-and-merchant-and-dishId")
    List<DistributorMerchantShopDTO> getDistributorMerchantShopByPlatformIdAndDishIdList(@RequestParam("platformId") Long platformId, @RequestParam(value = "merchantId", required = false) Long merchantId, @RequestParam("dishIds") List<Long> dishIds);
    
    
    /**
     * 通过平台id、商品id、门店id查找分销记录id  分页
     *
     * @param platformId
     * @param merchantId
     * @return
     */
    @GetMapping("api/distributor-merchant/platform-and-merchant-and-dishId/page-info")
    RestPage<DistributorMerchantShopDTO> getDistributorMerchantShopByPlatformIdAndDishIdListAndPageInfo(@RequestParam("page") Integer page,
                                                                                                        @RequestParam("size") Integer size,
                                                                                                        @RequestParam("sort") List<String> sort,
                                                                                                        @RequestParam("platformId") Long platformId,
                                                                                                        @RequestParam(value = "merchantId", required = false) Long merchantId,
                                                                                                        @RequestParam("dishIds") List<Long> dishIds);
    
    /**
     * 通过平台id、商品ids、门店ids查找分销记录id
     *
     * @param platformId
     * @param merchantIds sss
     * @return
     */
    @GetMapping("api/distributor-merchant/platform-and-merchantIds-and-dishId-check-state")
    RestPage<DistributorMerchantShopDTO> getDistributorMerchantShopByPlatformIdAndMerchantIdsAndDishIdListAndCheckStateIn(@RequestParam("page") Integer page,
                                                                                                                          @RequestParam("size") Integer size,
                                                                                                                          @RequestParam("sort") List<String> sort,
                                                                                                                          @RequestParam("platformId") Long platformId,
                                                                                                                          @RequestParam("merchantIds") List<Long> merchantIds,
                                                                                                                          @RequestParam("dishIds") List<Long> dishIds,
                                                                                                                          @RequestParam("checkState") List<Integer> checkState,
                                                                                                                          @RequestParam("brandIds") List<Long> brandIds,
                                                                                                                          @RequestParam("shopIndexRatio") Boolean shopIndexRatio
    
    );
    
    
    /**
     * 根据平台id和dishid获取订单数
     *
     * @param dishId
     * @param platformId
     * @return
     */
    @GetMapping("api/distributor-orders-count/{dishId}")
    Long countDistributorOrderByPlatformIdAndDishId(@PathVariable("dishId") Long dishId,
                                                    @RequestParam("platformId") Long platformId);
    
    /**
     * 获取平台下未审核的提现记录数
     *
     * @param platformId
     * @return
     */
    @GetMapping("api/count-wait-verify-distributor-withdraws/{platformId}")
    Integer countWaitVerifyDistributorByPlatformId(@PathVariable("platformId") Long platformId);
    
    /**
     * 获取平台下未打款的提现记录数
     *
     * @param platformId
     * @return
     */
    @GetMapping("api/count-wait-pay-distributor-withdraws/{platformId}")
    Integer countWaitPayDistributorByPlatformId(@PathVariable("platformId") Long platformId);
    
    /**
     * 统计平台分销者数量
     *
     * @param platformId
     * @return
     */
    @GetMapping("api/count-distributor/{platformId}")
    Long countCodeNumByPlatformId(@PathVariable("platformId") Long platformId);
    
    /**
     * 通过菜品id查找菜品绑定的门店编码
     *
     * @param dishId
     * @return
     */
    @GetMapping("api/find-bind-merchant-id/{dishId}")
    List<Long> findMerchantIdByDishId(@PathVariable("dishId") Long dishId);
    
    /**
     * 查看平台下是否存在品牌
     *
     * @param platformId 平台id
     * @return
     */
    @GetMapping("api/is-exist-brand/{platformId}")
    Integer isExitBrandByPlatformId(@PathVariable("platformId") Long platformId);
    
    /**
     * 修改门店加入通吃岛信息
     *
     * @param merchant
     * @return
     */
    @PostMapping("api/update-merchant-info/entering-tcd")
    MerchantModel updateMerchantEnteringTcdInfo(@RequestBody MerchantModel merchant);
    
    @GetMapping("api/merchant-id/{brandId}")
    List<Long> getMerchantIdByBrandId(@PathVariable("brandId") Long brandId);
    
    /**
     * 判断当前用户id是否是该平台的分销者
     *
     * @param platformId
     * @param distributorUserId
     * @return
     */
    @GetMapping("api/consumer-is-distributor/platform")
    Boolean isDistributor(@RequestParam("platformId") Long platformId, @RequestParam("distributorUserId") Long distributorUserId);
    
    /**
     * 通过id修改门店的入驻状态
     *
     * @param merchantId
     * @param enteringInfo
     * @return
     */
    @PutMapping("api/update-merchant-entering-info/id")
    Integer updateMerchantEnteringInfo(@RequestParam("merchantId") Long merchantId, @RequestParam("enteringInfo") Integer enteringInfo);
    
    /**
     * 获取入驻通吃岛成功的门店id
     *
     * @param platformId
     * @return
     */
    @GetMapping("api/entering-tcd-merchant-id/{platformId}")
    List<Long> enteringTcdSuccessMerchantId(@PathVariable("platformId") Long platformId);
    
    /**
     * 获取入驻通吃岛成功的门店id
     *
     * @param platformId
     * @return
     */
    @GetMapping("api/entering-tcd-merchant-no/{platformId}")
    List<Long> enteringTcdSuccessMerchantNo(@PathVariable("platformId") Long platformId);
    
    @PutMapping("api/update-entering-merchant-num/id")
    Integer updateEnteringMerchantNum(@RequestParam("id") Long id, @RequestParam("num") Integer num);
    
    @GetMapping("api/get-merchant-type")
    Map<Long, BrandAndMerchantType> findBrandAndMerchantType(@RequestParam("merchantIds") List<Long> merchantIds);
    
    /**
     * 获取入驻通吃岛的状态为：成功、关闭营业的门店
     *
     * @param merchantIds
     * @return
     */
    @GetMapping("api/get-merchant-to-tcd-pass/ids")
    List<ChooseMerchantInfo> findAllTcdSuccessMerchantByIds(@RequestParam("merchantIds") List<Long> merchantIds);
    
    
    /**
     * 购买、续费通吃卡
     *
     * @param distributorPayDTO
     * @return
     */
    @PostMapping("api/distributor-pays")
    DistributorPayDTO createDistributorPay(@RequestBody DistributorPayDTO distributorPayDTO);
    
    
    /**
     * 获取平台下合伙人数据
     *
     * @param platformId
     * @param weappUserId
     * @return
     */
    @GetMapping("api/distributors-by-platform-userId/{platformId}/{weappUserId}")
    DistributorDTO getAllDistributorsProfitByPlatformIdAndWeappUserId(@PathVariable("platformId") Long platformId, @PathVariable("weappUserId") Long weappUserId);
    
    /**
     * 获取平台合伙人配置
     *
     * @param platformId
     * @return
     */
    @GetMapping("api/platform-distribution-config/{platformId}")
    DistributorConfigDTO getDistributorConfigDTOByPlatformId(@PathVariable("platformId") Long platformId);
    
    /**
     * 获取商品合伙人返现配置（单次获取长度不要超过100）
     *
     * @param ids
     * @return
     */
    @GetMapping("api/distributor-merchant-shops-by-ids/{platformId}")
    List<DistributorMerchantShopDTO> getDistributorMerchantShopDTOsByIds(@PathVariable("platformId") Long platformId, @RequestParam("ids") List<Long> ids);
    
    /**
     * 获取平台下当前用户合伙人等级
     *
     * @param platformId
     * @return
     */
    @GetMapping("api/get-partner-rank-by-platform-id/{platformId}")
    DistributorRankDTO getCurrentUserDistributorRank(@PathVariable("platformId") Long platformId);
    
    /**
     * 通过门店id自营渠道的门店
     *
     * @param merchantIds
     * @return
     */
    @GetMapping("api/tcd-merchant/self-by-ids")
    List<ChooseMerchantInfo> findSelfMerchantByIds(@RequestParam("merchantIds") List<Long> merchantIds);
    
    
    /**
     * 通过门店名称查找门店信息
     *
     * @param merchantName
     * @return
     */
    @GetMapping("api/get-merchant-by-name")
    List<MerchantModel> getAllByMerchantName(@RequestParam("merchantName") String merchantName);
    
    @GetMapping("api/get-brandids-by-platformid/{platformId}")
    List<Long> getBrandIdsByPlatformId(@PathVariable("platformId") Long platformId);
    
    /**
     * 查询堂食业务是否开启
     *
     * @param merchantId
     * @return
     */
    @GetMapping("api/_search/business-open")
    Boolean checkOpen(@RequestParam("merchantId") Long merchantId);
    
    @GetMapping("api/merchants-get-bind-merchant-by-platform")
    List<MerchantDTO> getMerchantByBindPlatformWithState(@RequestParam(required = false, value = "page") Integer page, @RequestParam(required = false, value = "size") Integer size, @RequestParam("platformId") Long platformId,
                                                         @RequestParam(required = false, value = "merchantName") String merchantName,
                                                         @RequestParam(required = false, value = "brandId") Long brandId,
                                                         @RequestParam(required = false, value = "type") Integer type,
                                                         @RequestParam(required = false, value = "typeIsOpen") Boolean typeIsOpen);
    
    
    @GetMapping("api/new-merchant-get-shippinginfo-use-state")
    NewMerchantShippingInfoToUseDto getNewMerchantShippingInfoToUseDtoState(@RequestParam("merchantNo") Long merchantNo);
    
    @GetMapping("api/new-merchant-getall-by-merchantno-list")
    List<NewMerchantShippingInfoToUseDto> getAllNewMerchantShippingInfoByno(@RequestParam("merchantNoList") List<Long> merchantNoList);
    
    @GetMapping("api/offer-to-pay-get-by-merchantid")
    OfferToPayDTO getOfferToPayByMerchantId(@RequestParam("merchantId") Long merchantId);
    
    
    @PostMapping("api/send-order-info")
    void sendOrderInfo(@RequestParam("merchant") Long merchant,
                       @RequestParam("brandId") Long brandId,
                       @RequestParam("merchantTable") Long merchantTable,
                       @RequestParam("uid") String uid,
                       @RequestParam("orderSn") String orderSn);
    
    
    @GetMapping("api/update-shopping-trolley")
    void updateShoppingTrolley(@RequestParam("merchant") Long merchant,
                               @RequestParam("brandId") Long brandId,
                               @RequestParam("merchantTable") Long merchantTable,
                               @RequestParam("orderSn") String orderSn,
                               @RequestParam("uid") String uid);
    
    @GetMapping("api/qr-code-orders/{merchantId}")
    QRCodeOrderDTO getQRCodeOrder(@PathVariable("merchantId") Long merchantId);

    @GetMapping("api/qr-code-orders-one")
    QRCodeOrderDTO getQRCodeOrderOne(@RequestParam("merchantId") Long merchantId);

    @GetMapping("api/qr-code-orders-open")
    List<QRCodeOrderDTO> getQRCodeOrders(@RequestParam("platFormId") Long platFormId,@RequestParam("merchantId") List<Long> merchantId);
    
    
    /**
     * 根据平台id获取平台下的品牌
     *
     * @param platformId
     * @return
     */
    
    @GetMapping("api/list-brand-id-entering-success/{platformId}")
    List<Long> getSuccessBrandList(@PathVariable("platformId") Long platformId);
    
    
    @GetMapping("api/get-all-by-platformid-and-userids")
    List<DistributorDTO> getAllByPlatformIdAndUserIds(@RequestParam("platformId") Long platformId,
                                                      @RequestParam("userIds") List<Long> userIds);
    
    @PostMapping("api/put-promotion")
    void putPromotion(@RequestParam("merchant") Long merchant,
                      @RequestParam("platForm") Long platForm,
                      @RequestBody ShopFullReductionActivityDTO shopFullReductionActivityDTO);
    
    @GetMapping("api/select/syn/mdm-items")
    List<MdmItemDTO> selectMdmItems(@RequestParam("merchantId") String merchantId);
    
    @GetMapping("api/search/syn/item-types")
    List<ItemTypeDTO> searchItemType(@RequestParam("merchantId") String merchantId);
    
    /**
     * 根据平台查询分销门店信息
     *
     * @param platformId
     * @return
     */
    @GetMapping("api/get-all-by-platform-id")
    List<DistributorMerchantDTO> getAlDistributorMerchantDTOlByMerchantIdList(@RequestParam("platformId") Long platformId);
    
    
    /**
     * 分销订单退款
     *
     * @param orderSn
     * @return
     */
    @GetMapping("api/distributor-order-refunds")
    Boolean distributorOrderRefunds(@RequestParam("orderSn") String orderSn);
    
    
    /**
     * 根据平台id和时间获取分销订单数据
     *
     * @param platformId
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("api/statistical-distributor-pay-order-info")
    DistributorPayOrderVM statisticalDistributorPayOrderInfo(@RequestParam("platformId") Long platformId,
                                                             @ApiParam(required = false, value = "YYYY-MM-DD 格式") @RequestParam(required = false, value = "startTime") String startTime,
                                                             @ApiParam(required = false, value = "YYYY-MM-DD 格式") @RequestParam(required = false, value = "endTime") String endTime);
    
    @GetMapping("api/find/mdm-merchant")
    MdmOrganizationDTO findMdmOrganization(@RequestParam("merchantId") Long merchantId, @RequestParam("platFormId") Long platFormId, @RequestParam("isDB") Integer isDB);
    
    @PostMapping("api/create/mdm-member")
    Boolean createMembers(@RequestBody IslandUserDTO islandUserDTO, @RequestParam("enterpriseGuid") String enterpriseGuid);
    
    @GetMapping("api/find/mdm-member/phone")
    MdmSynMemberDTO findMembers(@RequestParam("enterpriseGuid") String enterpriseGuid, @RequestParam("phone") String phone);
    
    @PostMapping("api/recharge_card")
    String rechargeHolderCard(@RequestParam("platformId") Long platformId, @RequestParam("memberInfoCardGuid") String memberInfoCardGuid, @RequestParam("rechargeMoney") String rechargeMoney, @RequestParam(required = false, value = "orderGuid") String orderGuid, @RequestParam(required = false, value = "orderSource") String orderSource,
                              @RequestParam(required = false, value = "orderTime") String orderTime, @RequestParam(required = false, value = "payCode") String payCode, @RequestParam(required = false, value = "payName") String payName, @RequestParam(required = false, value = "payWay") String payWay, @RequestParam(required = false, value = "payWayDesc") String payWayDesc,
                              @RequestParam(required = false, value = "enterpriseGuid") String enterpriseGuid, @RequestParam(required = false, value = "brandGuid") String brandGuid);
    
    @PostMapping("api/use_card")
    String useHolderCard(@RequestBody MemberCardPayParam memberCardPayParam, @RequestParam(required = false, value = "enterpriseGuid") String enterpriseGuid,
                         @RequestParam(required = false, value = "brandGuid") String brandGuid, @RequestParam(required = false, value = "merchantUid") String merchantUid, @RequestParam("platformId") Long platformId);
    
    @PostMapping("api/card_cancelPay")
    String cardCancelPay(@RequestParam("isSettlement") Boolean isSettlement, @RequestParam("enterpriseGuid") String enterpriseGuid, @RequestParam("memberConsumptionGuid") String memberConsumptionGuid, @RequestParam("orderNumber") String orderNumber);
    
    @GetMapping("api/get-all-order-by-platformId")
    List<DistributorOrderDTO> getAllOrderByPlatformId(@RequestParam("platformId") Long platformId);
    
    
    @GetMapping("api/find-bind-dish-id-with-platform-merchant/{platformId}/{merchantId}")
    @ApiOperation("通过平台id和门店获取绑定商品")
    List<Long> findAllBindDishIdInfoByPlatformIdAndMerchantId(@PathVariable(value = "platformId") Long platformId, @PathVariable(value = "merchantId") Long merchantId);
}
