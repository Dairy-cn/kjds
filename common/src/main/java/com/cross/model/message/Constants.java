package com.cross.model.message;

public final class Constants {
    /** 模板消息类别  msgCategory start*/
    public static final String MSG_CATEGORY_ORDER_INFO = "订单消息";
    public static final String MSG_CATEGORY_ORDER_NOTICE = "订单通知";
    public static final String MSG_CATEGORY_USER_INFO = "用户信息";
    public static final String MSG_CATEGORY_ACCOUNT_INFO = "账户余额";
    public static final String MSG_CATEGORY_ACTIVITY_NOTICE = "活动通知";
    public static final String MSG_CATEGORY_PARTNER_NOTICE = "合伙人通知";
    public static final String MSG_CATEGORY_AUDIT_NOTICE = "审核通知";
    public static final String MSG_CATEGORY_TIXIAN_AUDIT_NOTICE = "提现审核";
    public static final String MSG_CATEGORY_TASK_NOTICE = "任务通知";
    public static final String MSG_CATEGORY_JOIN_NOTICE = "入驻通知";
    /** 模板消息类别  msgCategory end*/

    /** 模板消息标题  msgTitle start*/
    public static final String MSG_TITLE_ORDER_PAY_SUCCESS_NOTICE = "订单支付成功通知";
    public static final String MSG_TITLE_ORDER_COMPLETE_NOTICE = "订单完成通知";
    public static final String MSG_TITLE_ORDER_NOT_COMPLETE_NOTICE = "订单未完成提醒";
    public static final String MSG_TITLE_USER_LEVEL_CHANGE = "会员等级变更通知";
    public static final String MSG_TITLE_ACCOUNT_CHANGE = "账户余额变动通知";
    public static final String MSG_TITLE_TIXIAN_AUDIT_RESULT_NOTICE = "提现审核结果通知";
    public static final String MSG_TITLE_ACTIVITY_JOIN_SUCCESS_NOTICE = "报名成功通知";
    public static final String MSG_TITLE_ACTIVITY_JOIN_RESULT_NOTICE = "抽奖结果通知";
    public static final String MSG_TITLE_USER_PARTNER_JOIN_NOTICE = "成员加入提醒";
    public static final String MSG_TITLE_MERCHANT_REGISTER_AUDIT_NOTICE = "商户入驻审核通知";
    public static final String MSG_TITLE_TIXIAN_RESULT_NOTICE = "提现结果通知";
    public static final String MSG_TITLE_TIXIAN__APPLY_AUDIT_NOTICE = "提现申请受理通知";
    public static final String MSG_TITLE_USER_OPEN_CARD_NOTICE = "会员开通成功提醒";
    public static final String MSG_TITLE_ORDER_HAD_SENT = "订单发货通知";
    public static final String MSG_TITLE_NEW_ORDER_NOTICE = "新订单通知";
    public static final String MSG_TITLE_TCD_WILL_OUTOFDATE_NOTICE = "通吃卡即将到期";
    public static final String MSG_TITLE_CANCEL_ORDER_NOTICE = "订单取消通知";
    public static final String MSG_TITLE_TASK_FINISH_NOTICE = "任务完成通知";
    public static final String MSG_TITLE_APPLICATION_JOIN_NOTICE = "入驻申请通知";
    /** 模板消息标题  msgTitle end*/

    /** 短信消息发送事件  event start*/
    public static final String SMS_EVENT_GOODS = "成功购买到店商品";
    public static final String SMS_EVENT_DELIVERY_TO_HOME_HAD_SENT = "物流商品商品已发货";
    public static final String SMS_EVENT_OPEN_CARD = "开通通吃卡";
    public static final String SMS_EVENT_XUFEI_CARD = "续费通吃卡";
    public static final String SMS_EVENT_CARD_WILL_OUT_OF_DATE = "通吃卡即将到期";
    public static final String SMS_EVENT_MERCHANT_REGISTER_TO_TCD = "商户成功入驻通吃岛";
    /** 短信消息发送事件  event end*/

//    1. 套餐订单详情：pages/orderDetail/orderDetail；参数：orderSn
//    2. 优惠买单、外卖：package/multiStore/orderDetail/orderDetail；参数：orderSn
//    3. 扫码点餐：package/multiStore/scanningOrder/scanningOrder；参数：orderSn
//    4. 淘券:pages/equityDetail/equityDetail
//    套餐订单：TO_THE_STORE，DELIVERY_TO_HOME
//    优惠买单、外卖:OFFER_TO_PAY,NETWORK,PICK_UP
//    扫码点餐:SCAN_CODE
//    淘券：TAO_QUAN
    public static final String PATH_OF_PACKAGE = "pages/orderDetail/orderDetail?orderSn=%s&id=%s";
    public static final String PATH_OF_OFFER_TO_PAY = "package/multiStore/orderDetail/orderDetail?orderSn=%s&id=%s";
    public static final String PATH_OF_SCAN = "package/multiStore/scanningOrder/scanningOrder?orderSn=%s&id=%s";
    public static final String PATH_OF_TAO_QUAN = "pages/equityDetail/equityDetail?orderSn=%s&id=%s";

    //通吃岛公众号得appId
    public static final String PUBLIC_APP_ID_OF_TCD = "wx49b72696409fd41b";

}
