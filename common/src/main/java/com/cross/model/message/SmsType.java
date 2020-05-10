package com.cross.model.message;

/**
 * The MsgCategory enumeration.
 */
/** 短信消息类别 **/
public enum SmsType {
    /**购买商品 */
    SMS_TYPE_BUY_GOOS,
    /**订单已发货 */
    SMS_TYPE_ORDER_HAD_SENT,
    /**开通通吃卡 */
    SMS_TYPE_OPEN_CARD,
    /**通吃卡即将到期 */
    SMS_TYPE_CARD_WILL_OUT_OF_DATE,
    /**入驻通吃岛 */
    SMS_TYPE_REGISTER_TO_TCD
}
