package com.cross.client;

import com.cross.config.AuthorizedFeignClient;
import com.cross.model.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by DuYuLiang on 2017/7/7.
 */
@Component
@AuthorizedFeignClient(name = "gateway")
public interface UserService {
    /**
     * 获取当前登录用户
     *
     * @return
     */
    @GetMapping("api/account/{login}")
    UserModel getCurrentLoginAccount(@PathVariable("login") String login);

    /**
     * 根据ID获取用户
     *
     * @param id
     * @return
     */
    @GetMapping("api/user/{id}")
    UserModel getUserById(@PathVariable("id") Long id);

    /**
     * 获取用户的外部平台ID
     *
     * @param merchantNo
     * @param userId
     * @param platType
     * @return
     */
    @GetMapping("api/userPlatAccount/{merchantNo}/{userId}/{platType}/")
    UserPlatAccountModel getUserPlatAccountByUserIdAndMerchantNoAndPlatType(@PathVariable("merchantNo") Long merchantNo,
                                                                            @PathVariable("userId") Long userId,
                                                                            @PathVariable("platType") Integer platType);


    @PostMapping(path = "api/register/platform")
    Long registerAccountPlatForm(@Valid @RequestBody ManagedUserVM managedUserVM);

    /**
     * 添加外部平台用户
     *
     * @param userPlatAccount
     * @return
     */
    @PostMapping("api/user-plat-accounts")
    UserPlatAccountModel addUserPlatAccount(@Valid @RequestBody UserPlatAccountModel userPlatAccount);

    /**
     * 修改外部平台用户
     *
     * @param userPlatAccount
     * @return
     */
    @PutMapping("api/user-plat-accounts")
    UserPlatAccountModel updateUserPlatAccount(@Valid @RequestBody UserPlatAccountModel userPlatAccount);

    /**
     * 获取外部平台用户
     *
     * @param id
     * @return
     */
    @GetMapping("api/user-plat-accounts/{id}")
    UserPlatAccountModel getUserPlatAccount(@PathVariable("id") Long id);

    /**
     * 根据identity获取外部平台用户
     *
     * @param identity
     * @return
     */
    @GetMapping("api/get-user-by-identity")
    UserPlatAccountModel getUserPlatAccountByIdentity(@RequestParam("identity")
                                                          String identity);

    /**
     * 绑定外部平台用户
     *
     * @param identity
     * @return
     */
    @GetMapping("api/bind-user-identity/{userId}")
    UserPlatAccountModel bindPlatAccountByIdentity(@RequestParam("identity") String identity, @PathVariable("userId") Long userId);

    /**
     * 添加外部微信用户详细信息
     *
     * @param userWeixinModel
     * @return
     */
    @PutMapping("api/user-wei-xins")
    UserPlatAccountModel updateUserWeiXin(@Valid @RequestBody UserWeixinModel userWeixinModel);

    /**
     * 添加外部支付宝用户详细信息
     *
     * @param userAlipayModel
     * @return
     */
    @PutMapping("api/user-alipays")
    UserPlatAccountModel updateUserAliPay(@Valid @RequestBody UserAlipayModel userAlipayModel);

    /**
     * 保存用户登录信息
     *
     * @param userLoginLogModel
     * @return
     */
    @PostMapping("api/user-login-logs")
    UserLoginLogModel saveUserLoginLog(@RequestBody UserLoginLogModel userLoginLogModel);

    /**
     * 缓存验证码
     *
     * @param mobile
     * @param code
     */
    @GetMapping("api/sms/sendValidateCode")
    void saveValidateCode(@RequestParam("mobile") String mobile, @RequestParam("code") String code);

    /**
     * 获取用户信息
     *
     * @param ids
     * @return
     */
    @GetMapping("api/users/login")
    Map<Long, String> getUser(@RequestParam("ids") Set<Long> ids);

    @PostMapping("api/user-wei-xins")
    UserWeixinModel createUserWeiXin(@RequestBody UserWeixinModel userWeiXin);

    @GetMapping("api/get-plat-account-by-user-id/{userId}")
    UserPlatAccountModel getUserAccountByUserId(@PathVariable("userId") Long userId);

    @PostMapping("api/users")
    ManagedUserVM createUser(@Valid @RequestBody ManagedUserVM managedUserVM);

    @GetMapping("api/get-open-id-by-code/{code}")
    WeAppResponseVM getOpenIdByCode(@PathVariable("code") String code, @RequestParam("appId") Long appId);

    @GetMapping("api/apps/{id}")
    AppModel getApp(@PathVariable("id") Long id);

    /**
     * 根据平台id 查询平台会员信息
     *
     * @param platformMemberQueryDTO 平台会员信息查询条件DTO
     * @return 会员信息
     */
    @PostMapping("api/platform-members/info")
    PlatformMemberPageDTO getPlatformMemberPageDTO(@RequestBody PlatformMemberQueryDTO platformMemberQueryDTO);


    @GetMapping("api/get-plat-account-by-user-id-and-platformId/{userId}")
    UserPlatAccountModel getUserAccountByUserIdAndPlatformId(@PathVariable("userId") Long userId,
                                                             @RequestParam("platformId") Long platformId,
                                                             @RequestParam(value = "platType" , required =  false) Integer platType);


    /**
     * 根据平台id和用户电话号码获取平台账号信息
     */
    @GetMapping("api/get-plat-account-by-user-id-and-platformId")
    UserPlatAccountModel getUserAccountByLoginAndPlatformId(@RequestParam("login") String login,
                                                                              @RequestParam("platformId") Long platformId,
                                                                              @RequestParam("platType") Integer platType);

    /**
     * 根据用户id获取用户信息
     * @param userId
     * @return
     */
    @GetMapping("api/users-by-user-id/{userId}")
    UserModel getUserByUserId(@PathVariable("userId") Long userId);

    /**
     *查找当前平台下微信小程序的用户数量
     * @param platformId
     * @return
     */
    @GetMapping("api/wei-xin-user-account/{platformId}")
    Long platformUserAccount(@PathVariable("platformId") Long platformId,@RequestParam(value = "startTime",required = false) Integer startTime,
                             @RequestParam(value = "endTime",required = false) Integer endTime);

    @GetMapping("api/apps-by-platform-and-type/{platformId}")
    AppModel getAppByPlatformAndType(@PathVariable("platformId") Long platformId,@RequestParam("appType") Integer appType);


    /**
     * 通过login模糊查询用户信息
     * @param login
     * @return
     */
    @GetMapping("api/get-user-list-by-login")
    List<BigInteger> getUserListByLogin(@RequestParam("login") String login);


    /**
     * 通过login查询用户信息
     * @param phone
     * @return
     */
    @GetMapping("api/get-user-by-login")
    UserModel getUserByLogin(@RequestParam("phone") String phone);

    /**
     * 根据分销码（推荐者）统计其推荐用户数
     * @param codes
     * @return
     */
    @GetMapping("api/count-by-codes")
    Map<Long,Integer> countByCodes(@RequestParam("codes") List<Long> codes);

    /**
     * 根据分销码（推荐者）获得其推荐用户列表
     * @param code
     * @return
     */
    @GetMapping("api//get-All-by-code")
    List<UserModel> getAllBycode(@RequestParam("code") Long code);

    /**
     * 根据平台id和用户编号获取平台账号信息
     * @param paltformId
     * @param userId
     * @return
     */
    @GetMapping("api/get-plat-account-by-user-ids-and-platformId")
    List<UserPlatAccount> getUserAccountByUserIdsAndPlatformId(@RequestParam("paltformId") Long paltformId,
                                                               @RequestParam("userId") List<Long> userId);


    @GetMapping("api/get-wechat-apps-by-platform-id")
    List<AppDTO> getAppsByPlatformId(@RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam("platformId") Long platformId, @RequestParam("name") String name, @RequestParam("appType") Integer appType);
}
