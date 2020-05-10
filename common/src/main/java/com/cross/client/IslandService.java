package com.cross.client;

import com.cross.config.AuthorizedFeignClient;
import com.cross.enumtype.IslandTask;
import com.cross.enumtype.UserProfitType;
import com.cross.enumtype.UserRightAndInterest;
import com.cross.model.*;
import com.cross.model.enumeration.SourceType;
import com.cross.model.island.IslandBasicInfoDTO;
import com.cross.model.island.IslandUserNameInfoVm;
import com.cross.model.island.groupbureau.IslandGroupBureauActivityJoinInfoDTO;
import com.cross.model.island.rewardpool.IslandRewardsPoolNewTimesConfigDTO;
import com.cross.model.island.rewardpool.IslandRewardsPoolParticipantsInfoDTO;
import com.cross.model.island.rewardspool.IslandCouponUseHistoryDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;


@Component
@AuthorizedFeignClient(name = "island")
public interface IslandService {
    
    
    /**
     * 查询--根据通吃岛Id获取--商户参考比例
     *
     * @param platformId
     * @return
     */
    @GetMapping("api/island-merchant-reference-ratio-settings-platform/{platformId}")
    IslandMerchantReferenceRatioSettingDTO getIslandMerchantReferenceRatioSettingByPlatformId(@PathVariable("platformId") Long platformId);
    
    /**
     * 判断当前用户开通会员需要多少钱
     *
     * @param platformId
     * @return
     */
    
    @GetMapping("api/get-price-member/{platformId}")
    BigDecimal getPriceWithOpenMember(@PathVariable("platformId") Long platformId);
    
    
    @GetMapping("api/get-price-member/{platformId}/{weappUserId}")
    BigDecimal getPriceWithOpenMemberByWeappUserId(@PathVariable("platformId") Long platformId, @PathVariable("weappUserId") Long weappUserId);
    
    /**
     * 根据用户Id获取会员信息
     *
     * @param platformId-user-members-user/{platformId}/{userId}
     * @param userId
     * @return
     */
    @GetMapping("api/island-user-members-user/{platformId}/{userId}")
    IslandUserMemberDTO getIslandUserMemberByUserId(@PathVariable("platformId") Long platformId, @PathVariable("userId") Long userId);
    
    /**
     * 添加会员信息
     *
     * @param islandUserMemberDTO
     * @return
     */
    @PostMapping("api/island-user-members")
    IslandUserMemberDTO createIslandUserMember(@RequestBody IslandUserMemberDTO islandUserMemberDTO);
    
    /**
     * 修改会员信息
     *
     * @param islandUserMemberDTO
     * @return
     */
    @PutMapping("api/island-user-members")
    IslandUserMemberDTO updateIslandUserMember(@RequestBody IslandUserMemberDTO islandUserMemberDTO);
    
    
    /**
     * 获取通吃卡信息
     *
     * @param platformId
     * @return
     */
    @GetMapping("api/island-right-and-interest-settings-with-platform-id/{platformId}")
    IslandRightAndInterestSettingDTO getIslandRightAndInterestSettingsWithTcCardByPlatfromId(@PathVariable("platformId") Long platformId);
    
    
    /**
     * 查询---宣发达人信息
     *
     * @param id
     * @return
     */
    @GetMapping("api/island-user/{id}")
    IslandUserDTO getIslandUser(@PathVariable("id") Long id);
    
    /**
     * 根据平台id和小程序账号id获取用户信息
     *
     * @param platformId
     * @param weixinUserId
     * @return
     */
    @GetMapping("api/island-user/{platformId}/{weixinUserId}")
    IslandUserDTO getIslandUserByWeappUserId(@PathVariable("platformId") Long platformId, @PathVariable("weixinUserId") Long weixinUserId);
    
    
    /**
     * 根据完成动作完成用户升级
     *
     * @param platformId
     * @param islandTaskInfo
     * @return
     */
    @PostMapping("api/island-user-upgrade-records")
    Boolean createIslandUserUpgradeRecord(@RequestParam("platformId") Long platformId, @RequestParam("weappUserId") Long weappUserId, @RequestParam("islandTaskInfo") IslandTask islandTaskInfo);
    
    
    /**
     * 根据宣发ids获取信息
     *
     * @param ids
     * @return
     */
    @GetMapping("api/island-promotion-ids")
    List<IslandPromotionDTO> getIslandPromotionByIds(@RequestParam("ids") List<Long> ids);
    
    /**
     * 创建用户流水记录
     *
     * @param islandUserBalanceRecordDTO
     * @return
     */
    @PostMapping("api/island-user-balance-records")
    IslandUserBalanceRecordDTO createIslandUserBalanceRecord(@RequestBody IslandUserBalanceRecordDTO islandUserBalanceRecordDTO);
    
    /**
     * 创建用户收益信息
     *
     * @param userProfitDTO
     * @return
     */
    @PostMapping("api/user-profits")
    UserProfitDTO createUserProfit(@RequestBody UserProfitDTO userProfitDTO);
    
    /**
     * 获取已选择商品信息
     *
     * @param platformId 通吃岛平台编号
     * @return
     */
    @GetMapping("api/get-island-free-lunch-choosed-dishes-info")
    List<IslandFreeLunchDTO> getIslandFreeLunchChoosedDishesInfo(@RequestParam("platformId") Long platformId, @RequestParam("startTime") String startTime, @RequestParam("endTime") String endTime);
    
    
    /**
     * 更改霸王餐中奖纪录使用状态
     *
     * @return
     */
    @GetMapping("api/update-island-free-lunch-win-info")
    void updateIslandFreeLunchWinInfo(@RequestParam("infoId") Long infoId);
    
    
    @GetMapping("api/island-user-phone/{platformId}/{phone}")
    List<IslandUserDTO> getIslandUserByPlatformIdAndPhone(@PathVariable("platformId") Long platformId, @PathVariable("phone") String phone);
    
    
    @GetMapping("api/island-user-phone-like/{platformId}/{phone}")
    List<IslandUserDTO> getIslandUserByPlatformIdAndPhoneLike(@PathVariable("platformId") Long platformId, @PathVariable("phone") String phone);
    
    @GetMapping("api/island-user-pid/{platformId}")
    List<IslandUserDTO> getIslandUserByPlatformId(@PathVariable("platformId") Long platformId);
    
    @GetMapping("api/island-user-userId")
    IslandUserDTO findByWeAppUserId(@RequestParam("platformId") Long platformId, @RequestParam("userId") Long userId);
    
    /**
     * 根据活动id获取霸王餐活动
     *
     * @return the entity.
     */
    @GetMapping("api/get-all-island-free-lunch-by-ids")
    List<IslandFreeLunchDTO> getAllFreeLunchByIds(@RequestParam("ids") List<Long> ids);
    
    /**
     * 根据活动id获取已开奖的霸王餐活动
     *
     * @return the entity.
     */
    @GetMapping("api/get-all-island-free-lunch-by-ids-have-result")
    List<IslandFreeLunchDTO> getAllFreeLunchByIdsAndStatus(@RequestParam("ids") List<Long> ids);
    
    /**
     * 根据记录id获取霸王餐活动参与人员信息
     *
     * @return the entity.
     */
    @GetMapping("api/get-all-island-free-lunch-user-info-by-ids")
    List<IslandFreeLunchUserInfoDTO> getAllIslandFreeLunchUserInfoDTOByIds(@RequestParam("ids") List<Long> ids);
    
    
    /**
     * 根据平台id获取人数
     *
     * @param platformId
     * @param startTime
     * @return
     */
    
    @GetMapping("api/count-island-user/{platformId}")
    Long countByPlatformId(@PathVariable("platformId") Long platformId,
                           @RequestParam(value = "startTime", required = false) String startTime);
    
    
    @GetMapping("api/island-basic-infos/{platformId}")
    IslandBasicInfoDTO getIslandBasicInfoByPlatformId(@PathVariable("platformId") Long platformId);
    
    
    /**
     * 新增奖金池报名人员信息
     */
    @PostMapping("api/create-island-rewards-pool-participants-info")
    IslandRewardsPoolParticipantsInfoDTO createIslandRewardsPoolParticipantsInfo(@RequestBody IslandRewardsPoolParticipantsInfoDTO islandRewardsPoolParticipantsInfoDTO);
    
    /**
     * 更新参加奖金池活动用户的拉入人员数量信息
     */
    @PostMapping("api/update-invite-num-info")
    void updateInvitedNumInfo(@RequestParam("platformId") Long platformId, @RequestParam("islandRewardsPoolNewTimesConfigId") Long islandRewardsPoolNewTimesConfigId, @RequestParam(value = "parentId", required = false) Long parentId);
    
    /**
     * 本期期奖金池配置获取
     */
    @GetMapping("api/get-island-rewards-pool-now-config")
    IslandRewardsPoolNewTimesConfigDTO getIslandRewardsPoolNowConfig(@RequestParam("platFormId") Long platFormId);
    
    
    /**
     * 根据小程序用户id获取未完成数
     *
     * @param tcdId
     * @param weappUserId
     * @return
     */
    @GetMapping("api/count-promotion-order-no-take/{tcdId}")
    Long countPromotionOrderNoTake(@PathVariable("tcdId") Long tcdId, @RequestParam(value = "weappUserId", required = false) Long weappUserId);
    
    
    /**
     * 获取红包信息
     *
     * @param id
     * @param platFormId
     * @return
     */
    
    @GetMapping("api/get-island-coupon-use-history-detail")
    IslandCouponUseHistoryDTO getIslandCouponUseHistory(@RequestParam("id") Long id, @RequestParam("platFormId") Long platFormId);
    
    /**
     * 更改红包使用状态
     *
     * @param islandCouponUseHistoryDTO
     * @return
     */
    @PostMapping("api/update-island-coupon-use-histories")
    IslandCouponUseHistoryDTO updateIslandCouponUseHistory(@RequestBody IslandCouponUseHistoryDTO islandCouponUseHistoryDTO);
    
    
    @GetMapping("api/find-user-list-by-platform-weapp-user-ids")
    List<IslandUserDTO> findAllByPlatformIdAndWeappUserIds(@RequestParam("platformId") Long platformId, @RequestParam("weappUserIds") List<Long> weappUserIds);
    
    /**
     * 通过菜品id和平台id统计还没有发货完成的霸王餐活动数量
     *
     * @param dishId
     * @param platformId
     * @return
     */
    @GetMapping("api/count-by-dish-id/platform-id")
    Long countByDishIdAndTime(@RequestParam("dishId") Long dishId, @RequestParam("platformId") Long platformId);
    
    
    /**
     * 根据用户id判断和类型判断是否有相应权限
     *
     * @param platformId
     * @param userId
     * @param weappUserId
     * @param userRightAndInterest
     * @return
     */
    @GetMapping("api/check-user-right-and-interest-setting/{platformId}")
    Boolean checkUserRightAndInterestSetting(@PathVariable("platformId") Long platformId, @RequestParam(value = "userId", required = false) Long userId, @RequestParam(value = "weappUserId", required = false) Long weappUserId, @RequestParam("userRightAndInterest") UserRightAndInterest userRightAndInterest);
    
    /**
     * 根据小程序id获取达人的赏金单数
     *
     * @param platformId
     * @param weappUserId
     * @param userProfitTypes
     * @return
     */
    @GetMapping("api/user-profits-platform-weapp-type/{platformId}/{weappUserId}")
    Long countUserProfitByPlatformIdAndWeappUserIdAndType(@PathVariable("platformId") Long platformId,
                                                          @PathVariable("weappUserId") Long weappUserId,
                                                          @RequestParam("userProfitTypes") List<UserProfitType> userProfitTypes);
    
    
    /**
     * 根据小程序id获取达人的赏金
     *
     * @param platformId
     * @param weappUserId
     * @param userProfitTypes
     * @return
     */
    @GetMapping("api/sum-user-profits-platform-weapp-type/{platformId}/{weappUserId}")
    BigDecimal sumUserProfitByPlatformIdAndWeappUserIdAndType(@PathVariable("platformId") Long platformId,
                                                              @PathVariable("weappUserId") Long weappUserId,
                                                              @RequestParam("userProfitTypes") List<UserProfitType> userProfitTypes);
    
    
    /**
     * 根据小程序ids获取达人的赏金数
     *
     * @param platformId
     * @param weappUserIds
     * @param userProfitTypes
     * @return
     */
    @GetMapping("api/map-user-profits-platform-weapp-type")
    Map<Long, Long> getMapUserProfitByPlatformIdAndWeappUserIdAndType(@RequestParam("platformId") Long platformId,
                                                                      @RequestParam("weappUserIds") List<Long> weappUserIds,
                                                                      @RequestParam("userProfitTypes") List<UserProfitType> userProfitTypes);
    
    
    /**
     * 根据小程序ids获取达人的通吃卡收益赏金数
     *
     * @param platformId
     * @param weappUserId
     * @param targeWeappUserIds
     * @return
     */
    @GetMapping("api/sum-card-user-profits-platform-weapp-type/{platformId}/{weappUserId}")
    Map<Long, BigDecimal> getTcCardProfitUserProfitByPlatformIdAndWeappUserIdAndOpenWeappUserId(@PathVariable("platformId") Long platformId,
                                                                                                @PathVariable("weappUserId") Long weappUserId, @RequestParam("targeWeappUserIds") List<Long> targeWeappUserIds);
    
    /**
     * 创建通吃岛用户
     *
     * @param platformId
     * @param headPic
     * @param nickName
     * @param sourceType
     * @return
     */
    @PostMapping("api/island-user")
    IslandUserDTO createIslandUser(@RequestParam(required = true, value = "platformId") Long platformId,
                                   @RequestParam(required = false, value = "headPic") String headPic,
                                   @RequestParam(required = false, value = "nickName") String nickName,
                                   @RequestParam(required = true, value = "sourceType") SourceType sourceType,
                                   @RequestParam(required = false, value = "userId") Long userId);
    
    
    /**
     * 创建通吃岛管理员用户
     *
     * @param platformId
     * @param headPic
     * @param nickName
     * @param sourceType
     * @return
     */
    @PostMapping("api/island-user-admin")
    IslandUserDTO createIslandUserAdmin(@RequestParam(required = true, value = "platformId") Long platformId,
                                        @RequestParam(required = false, value = "headPic") String headPic,
                                        @RequestParam(required = false, value = "nickName") String nickName,
                                        @RequestParam(required = true, value = "sourceType") SourceType sourceType,
                                        @RequestParam(required = false, value = "userId") Long userId);
    
    
    /**
     * 获取平台商户抽佣比例
     *
     * @return
     */
    @GetMapping("api/island-merchantdistributor-ratio/{tcdid}")
    Double getMerchantDistributorRatioVMS(@PathVariable("tcdid") Long tcdId);
    
    
    /**
     * 查看用户是否有权接单
     *
     * @param tcdId
     * @param weappUserId
     * @param promotionIds
     * @return
     */
    @GetMapping("api/hava-permission-by-weapp-user-id")
    List<Long> havePermissionTakeOrder(@RequestParam("tcdId") Long tcdId,
                                       @RequestParam("weappUserId") Long weappUserId,
                                       @RequestParam("promotionIds") List<Long> promotionIds);
    
    
    /**
     * 判断用户是否是会员,是否是达人
     *
     * @param weappUserId
     * @return 1 是否是会员 2 是否是达人
     */
    @GetMapping("api/check-user-type/{platformId}")
    Map<Integer, Boolean> checkIsUserType(@PathVariable("platformId") Long platformId,
                                          @RequestParam(value = "userId", required = true) Long weappUserId);
    
    
    @PutMapping("api/island-user/upd")
    ResponseEntity<IslandUserDTO> updateIslandUser(@RequestBody IslandUserDTO islandUserDTO);
    
    /**
     * 获取随机用户信息
     *
     * @param limitNum
     * @return
     */
    @GetMapping("api/find-user-list-by-random/{limitNum}")
    List<IslandUserNameInfoVm> findAllWithRandom(@PathVariable("limitNum") Integer limitNum);
    
    /**
     * 根据小程序id查询用户信息
     *
     * @param weappUserId 小程序ID
     * @return 查询结果
     */
    @GetMapping("api/find-users-weappid/{weappUserId}")
    public List<IslandUserDTO> findUsersByWeappUserId(@PathVariable("weappUserId") Long weappUserId);
    
    /**
     * 更新用户角色
     *
     * @param id    用户id
     * @param roles 用户角色
     * @return null
     * @throws URISyntaxException 异常
     */
    @PutMapping("api/island-role/upd-user-roles")
    @ApiOperation(value = "update role", notes = "更新用户角色")
    public ResponseEntity<Void> updateIslandUserRoles(@RequestParam("id") Long id, @RequestParam("roles") String roles);
    
    /**
     * 用戶刪除
     *
     * @param weAppId     小程序ID
     * @param plantformId 平台ID
     * @return >0成功
     */
    @DeleteMapping("api/del-user")
    public ResponseEntity<Integer> deleteUserByWeAppUserId(@RequestParam("weAppId") Long weAppId, @RequestParam("plantformId") Long plantformId);
    
    
    /**
     * 根据用户id获取会员信息
     *
     * @param platformId
     * @param weappUserId
     * @return
     */
    @GetMapping("api/island-user-members-user-with-weapp-user-id/{platformId}/{weappUserId}")
    IslandUserMemberDTO getIslandUserMemberByWeappUserId(@PathVariable("platformId") Long platformId, @PathVariable("weappUserId") Long weappUserId);
    
    /**
     * 更新用户状态
     *
     * @param id    id
     * @param state 状态
     * @return 大于零成功
     */
    @DeleteMapping("api/upd-user-state")
    public ResponseEntity<Integer> updateUserState(@RequestParam("id") Long id, @RequestParam("state") Boolean state);
    
    /**
     * 根据平台id和用户电话查询
     *
     * @param page
     * @param size
     * @param platformId
     * @param phone
     * @return
     */
    @GetMapping("api/get-user-by-platformid-and-phone")
    Map<String, Object> getUserByPlatformIdAndPhone(@RequestParam(value = "page", required = false) Integer page,
                                                    @RequestParam(value = "size", required = false) Integer size,
                                                    @RequestParam("platformId") Long platformId,
                                                    @RequestParam(value = "phone", required = false) String phone);
    
    /**
     * 获取平台下所有审核通过，等待打款的提现申请记录
     *
     * @param platformIds
     * @return
     */
    @GetMapping("api/get-all-wait-pay-records")
    List<IslandUserWithdrawDTO> getAllWaitPayRecords(@RequestParam("platformIds") List<Long> platformIds);
    
    /**
     * 根据记录id修改状态为已打款
     *
     * @param id
     * @return
     */
    @PutMapping("api/island-user-withdraws/pay/{id}")
    IslandUserWithdrawDTO updateIslandUserWithdrawPay(@PathVariable("id") Long id);
    
    /**
     * 根据id集合查询
     *
     * @param idList
     * @return
     */
    @GetMapping("api/get-all-user-by-ids")
    List<IslandUserDTO> getAllUserByIds(@RequestParam("idList") List<Long> idList);
    
    /**
     * 更新订单消费状态
     *
     * @return
     */
    @PostMapping("api/island-group-bureau-activity-join-info-update-consume-status")
    void updateIfConsumed(@RequestParam("tcdPlatformId") Long tcdPlatformId, @RequestParam("orderSn") String orderSn);
    
    @PostMapping("api/island-group-bureau-activity-infos-update-merchant-info")
    void updateIslandGroupBureauActivityInfoMerchantInfo(@RequestParam("merchantId") Long merchantId, @RequestParam("position") String position);
    
    @ApiOperation("后端 组局 获取应返现的记录")
    @GetMapping("api/island-group-bureau-activity-join-infos/return-info")
    List<IslandGroupBureauActivityJoinInfoDTO> getIslandGroupBureauActivityInfoReturnInfo();
    
    @ApiOperation("后端 组局 更新返现完成状态")
    @PostMapping("api/island-group-bureau-activity-join-infos/return-status")
    void updateIslandGroupBureauActivityInfoReturnInfoReturnStatus(@RequestParam("idList") List<Long> idList);
    
    @GetMapping("api/get-all-promote-cords-by-platformid-and-sn")
    List<IslandPromotionOrderDTO> getAllPromoteCordsByPlatformIdAndSn(@RequestParam("platformId") Long platformId,
                                                                      @RequestParam("snList") List<String> snList);
    
    @GetMapping("api/island-role/get-user-role-with-wepp-user-id")
    List<IslandUserDTO> findUsersAndRoleByWeappUserId(@RequestParam("weappUserId") Long weappUserId);
    
}
