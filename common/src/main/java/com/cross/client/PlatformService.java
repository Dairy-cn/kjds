package com.cross.client;

import com.cross.config.AuthorizedFeignClient;
import com.cross.enumtype.OrderMessageTypeEnum;
import com.cross.enumtype.PlatformMessageRemindTypeEnum;
import com.cross.model.*;
import com.cross.model.dish.PlatDishIdInfo;
import com.cross.model.enumeration.ShopShelfState;
import com.cross.model.enumeration.ThirdPartyType;
import com.cross.utils.RestPage;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;


/**
 * Created by LY on 2017-9-21 09:13:09
 */
@AuthorizedFeignClient(name = "platform")
public interface PlatformService {
    
    @GetMapping("api/plat-form-merchants/user-merchant")
    PlatFormMerchantDTO getPlatFormMerchantByUserAndMerchant(@RequestParam("platFormUserId") Long platFormUserId, @RequestParam("merchantId") Long merchantId);
    
    @PostMapping("api/plat-form-order-counts/batch")
    void createPlatFormOrderCountBatch(@RequestBody List<PlatFormOrderCount> platFormOrderCounts);
    
    @GetMapping("api/system-settings/platFormUser/{id}")
    List<SystemSettingDTO> findOneByPlatFormUser(@PathVariable("id") Long id);
    
    @PutMapping("api/system-settings/merchant/businessHours")
    void updateMerchantBusinessHours(@RequestParam("merchantNo") Long merchantNo, @RequestParam("businessHours") String businessHours);
    
    @PutMapping("api/system-settings/merchant/status")
    void updateMerchantStatus(@RequestParam("merchantNo") Long merchantNo, @RequestParam("status") Integer status, @RequestParam("closeManually") Boolean closeManually);
    
    @GetMapping("api/system-settings/platform/status")
    Boolean getPlatFormStatus(@RequestParam("merchantNo") Long merchantNo);
    
    @GetMapping("api/system-settings/platform/merchants")
    List<Long> getPlatFormMerchant(@RequestParam("platformId") Long platformId);
    
    @PostMapping("api/plat-form-users")
    PlatFormUserDTO createPlatFormUser(@RequestBody PlatFormUserDTO platFormUserDTO);
    
    @GetMapping("api/plat-form-users/user")
    List<PlatFormUserDTO> getAllPlatFormUsersByUserId(@RequestParam("userId") Long userId);
    
    @GetMapping("api/create-tcd-platform")
    PlatFormUserDTO createTcdPlatform(@RequestParam("tcdName") String tcdName, @RequestParam(required = false, value = "userId") Long userId);
    
    @PostMapping("api/plat-form-merchants/merchant")
    void createPlatFormMerchantInMerchant(@RequestParam("merchantId") Long merchantId, @RequestParam("platFormUserId") Long platFormUserId);
    
    @GetMapping("api/home-dish-model-info")
    List<HomeDishCatModel> getCatDishInfo(@RequestParam("platFormId") Long platFormId);
    
    @GetMapping("api/home-dish-cats/{id}")
    HomeDishCatModel getHomeDishCat(@PathVariable("id") Long id);
    
    /**
     * 通过品牌查找正在进行中的活动
     *
     * @param platformId
     * @return
     */
    @GetMapping("api/find-bargain-by-time")
    List<BargainModel> findAllByPlatformIdAndTime(@RequestParam("platformId") Long platformId);
    
    /**
     * 通过品牌和状态查找砍价活动
     *
     * @param platformId
     * @param stateList
     * @return
     */
    @GetMapping("api/get-bargain-by-platformId-and-state")
    List<BargainModel> findBargainByPlatformIdAndShelfStateIn(@RequestParam("platformId") Long platformId, @RequestParam("stateList") List<ShopShelfState> stateList);
    
    /**
     * 通过id查找砍价活动
     *
     * @param id
     * @return
     */
    @GetMapping("api/bargains/{id}")
    BargainModel getBargain(@PathVariable("id") Long id);
    
    /**
     * 通过userId和bargainId查找砍价用户
     *
     * @param bargainId
     * @return
     */
    @GetMapping("api/find-one-by-bargainId")
    BargainUserModel getBargainUserByUserIdAndBargainId(@RequestParam("bargainId") Long bargainId);
    
    @PostMapping("api/update-bargain-user")
    BargainUserModel updateBargainUserMadel(@RequestBody BargainUserModel bargainUserDTO);
    
    @PostMapping("api/update-bargain")
    BargainModel updateBargainModel(@RequestBody BargainModel bargainDTO);
    
    @GetMapping("api/plat-form-merchants-by-platform-id/{platformId}")
    List<PlatFormMerchantDTO> getPlatformMerchantsByPlatformId(@PathVariable("platformId") Long platformId);
    
    @GetMapping("api/plat-form-users/{id}")
    PlatFormUserDTO getPlatformUserByPlatId(@PathVariable("id") Long id);
    
    /**
     * 通过绑定门店的管理员id查找平台下的门店
     *
     * @param platformId
     * @return
     */
    @GetMapping("api/get-platform-merchant-by-manager-id")
    List<Long> getMerchantNoByManagerUserId(@RequestParam("platformId") Long platformId);
    
    /**
     * 通过等级id等到等级信息
     *
     * @param id
     * @return
     */
    @GetMapping("api/partner-levels/{id}")
    PartnerLevelModel getPartnerLevel(@PathVariable("id") Long id);
    
    @GetMapping("api/get-partner-by-platform-and-level")
    PartnerLevelModel getPartnerByPlatformIdAndLevel(@RequestParam("platformId") Long platformId, @RequestParam("level") Integer level);
    
    /**
     * 获取平台下菜品
     *
     * @param platId
     * @param dishId
     * @return
     */
    @GetMapping("api/plat-dish-by-dish-id/plat-id")
    PlatDishDTO getPlatDishByPlatformIdAndDishId(@RequestParam("platId") Long platId, @RequestParam("dishId") Long dishId);
    
    /**
     * 查看该平台的解绑品牌下是否存在绑定门店
     *
     * @param platformId
     * @param brandId
     * @return
     */
    @GetMapping("api/is-exist-bind-merchant")
    Boolean bindMerchantByBrand(@RequestParam("platformId") Long platformId, @RequestParam("brandId") Long brandId);
    
    /**
     * 通过平台id和平拍id查找绑定门店
     *
     * @param platformId
     * @param brandId
     * @return
     */
    @GetMapping("api/platform-bind-merchant-by-condition")
    List<PlatFormMerchantDTO> platformBindMerchantByBrand(@RequestParam("platformId") Long platformId, @RequestParam(required = false, value = "brandId") Long brandId);
    
    
    /**
     * 通过平台id和品牌id和状态查找绑定门店
     *
     * @param platformId
     * @param brandId
     * @return
     */
    @GetMapping("api/platform-bind-merchant-by-condition-with-type")
    List<PlatFormMerchantDTO> platformBindMerchantByBrandWithType(@RequestParam("platformId") Long platformId,
                                                                  @RequestParam(required = false, value = "brandId") Long brandId,
                                                                  @RequestParam(required = false, value = "type") Integer type,
                                                                  @RequestParam(required = false, value = "typeIsOpen") Boolean typeIsOpen);
    
    
    /**
     * 通过id获取第三方信息
     *
     * @param id
     * @return
     */
    @GetMapping("api/third-party-infos/{id}")
    ThirdPartyInfoModel getThirdPartyInfo(@PathVariable("id") Long id);
    
    /**
     * 创建平台菜品
     *
     * @param platDishDTO
     * @return
     */
    @PostMapping("api/plat-dishes")
    PlatDishDTO createPlatDish(@RequestBody PlatDishDTO platDishDTO);
    
    @PostMapping("api/update-plat-dishes")
    void updatePlatDish(@RequestParam("dishId") Long dishId, @RequestParam("useRules") String useRules);
    
    /**
     * 通过平台id和类型查找第三方信息
     *
     * @param platformId
     * @param thirdPartyType
     * @return
     */
    @GetMapping("api/get-third-party-info-by-platform-and-type")
    ThirdPartyInfoModel getOneByPlatformIdAndType(@RequestParam("platformId") Long platformId, @RequestParam("thirdPartyType") ThirdPartyType thirdPartyType);
    
    /**
     * 通过平台id，查找平台设置
     *
     * @param platformId
     * @return
     */
    @GetMapping("api/system-setting/{platformId}")
    SystemSettingDTO findOneByPlatformId(@PathVariable("platformId") Long platformId);
    
    /**
     * 保存平台信息
     *
     * @param platFormUserDTO
     */
    @PostMapping("api/save-platform-info")
    void savePlatform(@RequestBody PlatFormUserDTO platFormUserDTO);
    
    /**
     * 保存系统设置的信息
     *
     * @param systemSettingDTO
     */
    @PostMapping("api/save-system-setting-info")
    void saveSystemSettingInfo(@RequestBody SystemSettingDTO systemSettingDTO);
    
    /**
     * 通过id获取平台信息
     *
     * @param id
     * @return
     */
    @GetMapping("api/plat-dishes/{id}")
    PlatDishDTO getPlatDish(@PathVariable("id") Long id);
    
    /**
     * 通过平台id和门店id获取当前平台绑定的菜品id
     *
     * @param platformId
     * @param merchantId
     * @return
     */
    @GetMapping("api/get-platform-dish-id")
    List<Long> getDishIdListByPlatformIdAndMerchantId(@RequestParam("platformId") Long platformId, @RequestParam("merchantId") Long merchantId);
    
    
    /**
     * 通过平台id/商品状态/商品ids获取商品信息
     *
     * @param platformId
     * @param dishListId
     * @param status
     * @return
     */
    
    @GetMapping("api/platform-distributor/find-platform-and-dish-list-and-status/{platformId}")
    List<PlatDishDTO> findAllByPlatIdAndDishIdInAndStatus(@PathVariable("platformId") Long platformId,
                                                          @RequestParam(value = "dishListId") List<Long> dishListId,
                                                          @RequestParam(value = "status") Boolean status);
    
    /**
     * 通过平台id查找当前登陆者账号绑定的门店
     *
     * @return
     */
    @GetMapping("api/get-merchant-no-by-login")
    List<Long> findBindMerchantNoByLogin();
    
    /**
     * 菜品是否存在于套餐商品中
     *
     * @param dishId
     * @return
     */
    @GetMapping("api/is-exist-dish/{dishId}")
    Boolean isExistPlatDish(@PathVariable("dishId") Long dishId);
    
    /**
     * 创建平台消息记录
     *
     * @param platformId
     * @param eventId
     * @param messageRemindType
     * @param orderMessageType
     */
    @GetMapping("api/create-platform-message/type")
    void createPlatformMessageByType(@RequestParam("platformId") Long platformId, @RequestParam("eventId") Long eventId,
                                     @RequestParam("messageRemindType") PlatformMessageRemindTypeEnum messageRemindType,
                                     @RequestParam(required = false, value = "orderMessageType") OrderMessageTypeEnum orderMessageType);
    
    
    /**
     * 获取通吃岛平台List
     *
     * @return
     */
    @GetMapping("api/get-tcd-platform-id")
    List<PlatFormUserDTO> getTcdPlatformId();
    
    /**
     * 通过通吃岛平台id获取入驻通吃岛的门店id
     *
     * @param tcdPlatformId
     * @return
     */
    @GetMapping("api/get-merchant-id/{tcdPlatformId}")
    List<Long> getTcdMerchantIdByTcdPlatformId(@PathVariable("tcdPlatformId") Long tcdPlatformId);
    
    /**
     * 为登陆者创建一个平台
     *
     * @return
     */
    @PostMapping("api/create-platform/visitor")
    Long createVisitorPlatform(@RequestParam(required = false, value = "userId") Long userId);
    
    /**
     * 修改平台入驻通吃岛的状态
     *
     * @param platformId
     * @param state
     */
    @PutMapping("api/update-platform-entering-state")
    void updatePlatformEnteringInfoState(@RequestParam("platformId") Long platformId, @RequestParam("state") Integer state);
    
    /**
     * 获取平台下绑定的门店
     *
     * @param platformId
     * @param merchantList
     * @return
     */
    @GetMapping("api/find-platform-merchant")
    List<PlatFormMerchantDTO> getPlatformMerchant(@RequestParam("platformId") Long platformId, @RequestParam("merchantList") List<Long> merchantList);
    
    
    /**
     * 获取平台下绑定的门店
     *
     * @param platformId
     * @param
     * @return
     */
    @GetMapping("api/find-platform-merchant-nos")
    List<PlatFormMerchantDTO> getPlatformMerchantNos(@RequestParam("platformId") Long platformId, @RequestParam("merchantNosList") List<Long> merchantNosList);
    
    /**
     * 统计用户拥有的平台数量
     *
     * @param userId
     * @return
     */
    @GetMapping("api/count-platform-num/{userId}")
    Long countPlatformNumByUserId(@PathVariable("userId") Long userId);
    
    
    /**
     * 获取平台下的菜品信息
     *
     * @param tcdPlatformId
     * @param brandId
     * @param merchantId
     * @return
     */
    @GetMapping("api/tcd-platform-dish")
    List<PlatDishDTO> getTcdDishInfo(@RequestParam("tcdPlatformId") Long tcdPlatformId, @RequestParam(value = "brandId", required = false) Long brandId,
                                     @RequestParam(value = "merchantId", required = false) Long merchantId, @RequestParam(value = "isShow", required = false) Boolean isShow);
    
    /**
     * 通过门店坐标修改菜品地理位置
     *
     * @param merchantId
     * @param position
     * @return
     */
    @PutMapping("api/update-dish-position/merchant")
    Integer updateDishPositionByMerchantPosition(@RequestParam("merchantId") Long merchantId, @RequestParam("position") String position);
    
    /**
     * 根据门店id和平台id批量更新状态
     *
     * @param merchantIds
     * @param isShow
     * @param tcdPlatformId
     * @return
     */
    @PutMapping("api/update-dish-state/merchant/platform")
    Integer updateDishStateByMerchantIdIn(@RequestParam("merchantIds") List<Long> merchantIds, @RequestParam("isShow") Boolean isShow, @RequestParam("tcdPlatformId") Long tcdPlatformId);

//     /**
//      * 获取权益淘券列表
//     * @param  pageable 列表对应页码
//     * @param  thirdPartyId 第三方平台id
//     * @return
//     * */
//    @GetMapping("api/get-tao-quan-product-list")
//    Map<String, Object> getTaoQuanProductList(Pageable pageable, @RequestParam("thirdPartyId")  Long thirdPartyId);
    
    /**
     * 认购权益淘券
     *
     * @param taoQuanMyProduct 商品认购信息
     * @return
     */
    @GetMapping("api/copy-dish-from-tao-quan")
    SelfSupportDishDTO copyDishFromTaoQuan(@RequestBody TaoQuanMyProduct taoQuanMyProduct);
    
    /**
     * 通过平台等到合伙人等级信息
     *
     * @param platformId
     * @return
     */
    
    @GetMapping("api/get-all-partner-level-by-platform-id")
    List<PartnerLevelModel> getAllByPartnerLevelPlatformId(@RequestParam("platformId") Long platformId);
    
    /**
     * 根据平台id和类型获取list
     *
     * @param platformId
     * @param type
     * @return
     */
    @GetMapping("api/_search/platform-dish-recommends/list")
    List<PlatformDishRecommendDTO> getListByPlatformAndType(@RequestParam("platformId") Long platformId, @RequestParam("type") Integer type);
    
    
    /**
     * 通过菜品id查询对应商品标签
     *
     * @param dishIds
     * @return
     */
    @GetMapping("api/get-tao-quan-product-tags-by-dishId")
    List<SelfDishOfTaoQuanInfoVm> findAllDishTagStrByIds(@RequestParam("dishIds") List<Long> dishIds, @RequestParam("platformId") Long platformId);
    
    
    /**
     * 创建入住通吃岛账户信息
     *
     * @param platformAccountDTO
     * @return
     */
    @PostMapping("api/platform-accounts")
    PlatformAccountDTO createPlatformAccount(@RequestBody PlatformAccountDTO platformAccountDTO);
    
    /**
     * 通过平台id获取平台账号 * @return
     *
     * @param tcdId
     * @param platformId
     * @return
     */
    @GetMapping("api/find-one-platform-account/{tcdId}/{platformId}")
    PlatformAccountDTO findOnePlatformAccountByPlatformId(@PathVariable("tcdId") Long tcdId, @PathVariable("platformId") Long platformId);
    
    @GetMapping("api/get-category-name/ids")
    Map<Long, String> categoryNameMap(@RequestParam("ids") List<Long> ids);
    
    @GetMapping("api/get-platform-id/{merchantId}")
    List<Long> findAllPlatformIdByMerchantId(@PathVariable("merchantId") Long merchantId);
    
    @GetMapping("api/get-platform-by-merchant-id/{platformId}")
    List<PlatFormMerchantDTO> findAllPlatformIdByPlatformIdAndMerchantId(@PathVariable("platformId") Long platformId, @RequestParam("merchantIds") List<Long> merchantIds);
    
    
    /**
     * 通过菜品id和平台id查询对应商品上架信息
     *
     * @param dishIds
     * @param platId
     * @return
     */
    @GetMapping("api/get-plat-dish-by-dishIds-and-platId")
    List<PlatDishDTO> findPlatDishByDishIdsAndPlatId(@RequestParam("dishIds") List<Long> dishIds, @RequestParam("platId") Long platId);
    
    /**
     * 通过平台类型获取通吃岛平台
     *
     * @param id 平台id
     * @return
     */
    @GetMapping("api/plat-form-users/{id}")
    PlatFormUserDTO getPlatFormUser(@PathVariable("id") Long id);
    
    @GetMapping("api/find-dish-id/{platformId}")
    List<Long> countDishIdByPlatformId(@PathVariable("platformId") Long platformId);
    
    
    /**
     * 通过类型查找第三方信息
     *
     * @param thirdPartyType
     * @return
     */
    @GetMapping("api/get-third-party-info-by-type")
    ThirdPartyInfoModel getOneByThirdPartyType(@RequestParam("thirdPartyType") ThirdPartyType thirdPartyType);
    
    /**
     * 获取平台菜品id信息
     *
     * @param platformId
     * @return
     */
    @GetMapping("api/platform-dish-id/{platformId}")
    List<PlatDishIdInfo> findPlatformIdInfoByPlatformId(@PathVariable("platformId") Long platformId);
    
    /**
     * 批量获取合伙人等级信息
     *
     * @param ids
     * @return
     */
    @PostMapping("api/get-partner-by-ids")
    List<PartnerLevelModel> getAllInfoByIds(@RequestParam("ids") List<Long> ids);
    
    /**
     * 获取用户的第一个平台id
     *
     * @return
     */
    @GetMapping("api/find-one-platform-id/login")
    Long findOnePlatformIdByLogin();
    
    /**
     * 通吃岛货架商品：三方权益淘券数据同步时，将对端下架数据下架
     */
    @PostMapping("api/tcd-package-dish/update-tao-quan-dish")
    void updateIsShowStateByDishIds(@RequestParam("dishIds") List<Long> dishIds, @RequestParam("isShow") Boolean isShow);
    
    
    /**
     * 获取已添加的推荐门店信息
     *
     * @param platformId
     * @param type
     * @return
     */
    @GetMapping("api/find-recommend-merchant-ids-platform-type/{platformId}/{type}")
    List<BigInteger> findMerchantIdsByPlatformIdAndType(@PathVariable("platformId") Long platformId,
                                                        @PathVariable("type") Integer type);
    
    
    /**
     * 平台商户推荐设置-根据平台id和类型获取list
     *
     * @param platformId
     * @param type
     * @return
     * @ApiParam(value = "类型 1 首页 2 闲时约饭 3  外卖到家 4  到店特惠", required = true)
     */
    @GetMapping("api/platform-merchat-recommends-info/list")
    RestPage<PlatFormMerchantDTO> getListAndMerchantInfoByPlatformAndType(@RequestParam("page") Integer page,
                                                                          @RequestParam("size") Integer size,
                                                                          @RequestParam("sort") List<String> sort,
                                                                          @RequestParam("platformId") Long platformId,
                                                                          @RequestParam("type") Integer type);
    
    
    /**
     * 根据门店分类获取平台门店列表
     *
     * @param page
     * @param size
     * @param sort
     * @param categoryId
     * @return
     */
    @GetMapping("api/plat-form-merchants-page/category")
    RestPage<PlatFormMerchantDTO> getAllPlatFormMerchantsByCategoryWithPage(@RequestParam("page") Integer page,
                                                                            @RequestParam("size") Integer size,
                                                                            @RequestParam("sort") List<String> sort,
                                                                            @RequestParam("categoryId") Long categoryId);
    
    
    /**
     * 根据门店分类获取平台门店列表
     *
     * @param categoryId
     * @return
     */
    @GetMapping("api/plat-form-merchants-not-page/category")
    List<PlatFormMerchantDTO> getAllPlatFormMerchantsByCategoryNoPage(@RequestParam("categoryId") Long categoryId);
    
    /**
     * 根据门店分类获取平台门店列表 -多店
     *
     * @param categoryId
     * @return
     */
    @GetMapping("api/plat-form-merchants-not-page/category-new")
    List<PlatFormMerchantDTO> getAllPlatFormMerchantsByCategoryNoPageNew(@RequestParam("platformId") Long platformId, @RequestParam("categoryId") Long categoryId);
    
    
    /**
     * 通过平台和品牌获取平台绑定的门店
     *
     * @return
     */
    @GetMapping("api/get-platform-bind-merchants-by-brands")
    Map<Long, List<PlatformMerchantInfo>> getPlatformMerchantsByBrandIds(@RequestParam("platformId") Long platformId, @RequestParam("brandIds") List<Long> brandIds);
    
    @PostMapping("api/update-platform-create-merchant")
    void updateMerchant(@RequestBody MerchantVM merchantVM);
    
    @PostMapping("api/get-merchant-category-info")
    List<PlatFormShopCategoryDTO> getPlatFormShopCategoriesByIds(@RequestParam("ids") List<Long> ids);
    
    
    /**
     * 创建平台流水记录
     *
     * @param platformBalanceRecordDTO
     * @return
     */
    @PostMapping("api/platform-balance-records")
    PlatformBalanceRecordDTO createPlatformBalanceRecord(@RequestBody PlatformBalanceRecordDTO platformBalanceRecordDTO);
    
    
    /**
     * 添加平台收益记录
     *
     * @param platformProfitRecordDTO
     * @return
     */
    @PostMapping("api/platform-profit-records")
    PlatformProfitRecordModel createPlatformProfitRecord(@RequestBody PlatformProfitRecordModel platformProfitRecordDTO);
    
    @PutMapping("api/plat-form-users")
    PlatFormUserDTO updatePlatFormUser(@RequestBody PlatFormUserDTO platFormUserDTO);
    
    /**
     * 根据门店id和品牌id获取门店所属分类
     *
     * @return
     */
    @GetMapping("api/get-catagorys-by-merchantids")
    List<MerchantAndCatagorys> getCatagorysByMerchantIds(@RequestParam("merchantIds") List<Long> merchantIds);
    
    
    /**
     * 根据商品id修改商品上下架情况
     *
     * @param dishId
     * @param isShow
     * @return
     */
    @GetMapping("api/update-is-show-state-with-dish-id/{dishId}")
    Integer updateIsShowStateWithDishId(@PathVariable(value = "dishId") Long dishId, @RequestParam(value = "isShow") Boolean isShow);
    
    @GetMapping("api/get-platform-bind-merchant-ids-by-brands")
    List<Long> getMerchantByByBrandIds(@RequestParam("platformId") Long platformId, @RequestParam("brandIds") List<Long> brandIds);
    
    @GetMapping("api/get-merchnt-num-in-brand")
    Long getMerchntNumInBrand(@RequestParam("platformId") Long platformId, @RequestParam("brandId") Long brandId);
    
    
    @GetMapping("api/platform-bind-merchant-info-by-condition-with-type")
    List<PlatFormMerchantDTO> platformBindMerchantInfoByBrandWithType(@RequestParam("platformId") Long platformId,
                                                                      @RequestParam(required = false, value = "brandIds") List<Long> brandIds,
                                                                      @RequestParam(required = false, value = "type") Integer type);
    
    @PutMapping("api/update-out-order-mod")
    Integer updateOutOrderMod(@RequestParam("platformId") Long platformId,
                              @RequestParam("merchantId") Long merchantId,
                              @RequestParam("orderType") Integer orderType,
                              @RequestParam("flag") Integer flag);
    
    
    @PostMapping("api/platform-profit-records-with-distributor")
    Boolean createPlatformProfitRecordWithDistributor(@RequestBody DistributorOrderCommissionDTO distributorOrderCommissionDTO);
    
    
    @PostMapping("api/platform-profit-records-with-distributor-refunds")
    Boolean createPlatformProfitRecordWithDistributorOrderRefunds(@RequestBody DistributorOrderCommissionDTO distributorOrderCommissionDTO);
    
    @GetMapping("api/get-tcd-package-dish/by-dishIds")
    List<PlatDishDTO> getPlatDishesByDishIds(@RequestParam("dishIds") List<Long> dishIds, @RequestParam("ifDelete") Boolean ifDelete);
    
    /**
     * 获取可以添加的推荐商品的门店
     *
     * @param platformId
     * @param merchantIds
     * @param type
     * @param source
     * @param categoryId
     * @return
     */
    @GetMapping("api/platform/get-recommend-dish-info-with-merchants")
    List<Long> recommendDishInfoWithMerchants(@RequestParam("platformId") Long platformId,
                                              @RequestParam(value = "merchantIds", required = true) List<Long> merchantIds,
                                              @RequestParam(value = "type", required = false) Integer type,
                                              @RequestParam(value = "source", required = false) Integer source,
                                              @RequestParam(value = "categoryId", required = false) Long categoryId);
    
    
    /**
     * 修改门店扫码点餐宣传图
     *
     * @param platformId
     * @param merchantId
     * @param merchantScanCodePropagandaPic
     * @return
     */
    @PutMapping("api/update-propaganda-pic-plat-form-merchant-with-scan-code")
    PlatFormMerchantDTO updatePlatFormMerchantPropagandaPicWithScanCode(@RequestParam("platformId") Long platformId,
                                                                        @RequestParam("merchantId") Long merchantId,
                                                                        @RequestParam("merchantScanCodePropagandaPic") String merchantScanCodePropagandaPic);
    
    
    /**
     * 根据平台id和门店id（不是门店编号）获取平台门店
     *
     * @param platformId
     * @param merchantId
     * @return
     */
    @GetMapping("api/get-platform-merchant-with-platform-merchant-id")
    PlatFormMerchantDTO findFirstByPlatFormUserIdAndMerchant(@RequestParam("platformId") Long platformId,
                                                             @RequestParam("merchantId") Long merchantId);
    
    
    /**
     * 根据平台id和门店id（不是门店编号）获取平台门店列表
     *
     * @param platformId
     * @param merchantIds
     * @return
     */
    @GetMapping("api/get-platform-merchant-with-platform-merchant-ids")
    List<PlatFormMerchantDTO> findAllByPlatFormUserIdAndMerchants(@RequestParam("platformId") Long platformId,
                                                                  @RequestParam("merchantIds") List<Long> merchantIds);
    
    
    /**
     * 获取当前登陆者通吃岛平台id
     * @param weUserId
     * @return
     */
    @GetMapping("api/get-tcd-platform-id/login")
    List<PlatFormUserDTO>  getTcdPlatformIdByLogin(@RequestParam(value = "weUserId",required = false) Long weUserId);
}
