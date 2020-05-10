package com.cross.client;

import com.cross.config.AuthorizedFeignClient;
import com.cross.model.*;
import com.cross.model.message.MsgContentVM;
import com.cross.model.message.MsgType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author DuYuLiang on 2017/9/20.
 */
@Component
@AuthorizedFeignClient(name = "sys")
public interface SysService {
    @PostMapping("/api/validation-codes")
    ValidationCodeModel saveValidationCode(ValidationCodeModel validationCodeModel);

    @PostMapping("/api/push-message")
    void pushMessage(PushMessageDTO pushMessageDTO);

    @GetMapping("/api/consumer-available-activity/{userId}")
    List<ActivityMainModel> getAllActivityMains(
        @PathVariable("userId") Long userId,
        @RequestParam("orderCount") Integer orderCount,
        @RequestParam("orderAmount") Double orderAmount,
        @RequestParam("couponSn") String couponSn
    );

    @PostMapping("/api/activity-use-details")
    ActivityUseDetailsModel createActivityUseDetails(@RequestBody ActivityUseDetailsModel activityUseDetailsModel);

    @PutMapping("/api/coupons")
    CouponModel updateCoupon(@RequestBody CouponModel couponModel);

    @GetMapping("/api/coupons-by-sn/{sn}")
    CouponModel getCouponBySn(@PathVariable("sn") String sn);

    @PostMapping("/api/send/sms")
    Integer sendSms(@RequestParam("sms") String sms, @RequestParam("phone") String phone);

    @PostMapping("/api/we-chat-messages")
    WeChatMessageDTO sendWeChatMessage(@RequestBody WeChatMessageDTO weChatMessageDTO);

    @PostMapping("api/get-wx-request")
    String getWeather(@RequestBody RequestDataVM requestData);


    @PostMapping("api/socket/push/{cid}")
    Boolean pushMessageToWeb(@PathVariable("cid") String cid, @RequestBody() WebSocketResponseModel webSocketResponse);

    /**
     *获取发送参数调用 -- 根据平台id，消息类型，消息类别，消息标题获取开启的模板信息
     */
    @GetMapping("api/messages-config/by-conditions")
    MsgContentVM getMessagesConfigByConditions(@RequestParam("platformId") Long platformId, @RequestParam("msgType") MsgType msgType, @RequestParam("msgCategory") String msgCategory, @RequestParam("msgTitle") String msgTitle);

    /**
     *根据消息类型，消息类别，消息标题和推送规则获取开启的模板信息
     */
    @GetMapping("api/messages-config/by-conditions-not-contain-platformid")
    List<MsgContentVM>  findAllByMsgTypeAndMsgCategoryAndMsgTitleAndPushRule(@RequestParam("msgType") MsgType msgType, @RequestParam("msgCategory") String msgCategory, @RequestParam("msgTitle") String msgTitle);

    /**
     * 根据模板字段新增公众号消息
    */
    @PostMapping("api/create-we-chat-public-message-by-template")
    WeChatMessageDTO createWeChatPublicMessageByTemplate(@RequestBody MsgContentVM msgContentVM);

    /**
     * 根据模板字段批量新增公众号消息
     */
    @PostMapping("api/create-we-chat-public-messages-by-template")
    void createWeChatPublicMessagesByTemplate(@RequestBody List<MsgContentVM> msgContentVM);

    @PostMapping("api/socket/person/push")
    void pushMessageToMiniProgram(@RequestParam("tid") Long tid, @RequestParam("pid") Long pid, @RequestParam("message") String message);

    /**
     * 获取发送参数调用 -- 根据消息类型，消息类别，消息标题获取开启的短信模板信息
     */
    @GetMapping("api/sms-config")
    MsgContentVM findAllByMsgTypeAndMsgCategoryAndMsgTitle(@RequestParam(name = "platformId", required = true) Long platformId,@RequestParam("msgType") MsgType msgType, @RequestParam("msgCategory") String msgCategory, @RequestParam("msgTitle") String msgTitle);

    /**
     * 根据模板发送短信
     * */
    @PostMapping("api/send-sms-by-template")
    void  sendSmsToUserByTemplate(@RequestBody MsgContentVM msgContentVM);
}
