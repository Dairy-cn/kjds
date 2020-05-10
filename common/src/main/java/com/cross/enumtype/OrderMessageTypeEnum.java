package com.cross.enumtype;

/**
 * @author hcy
 * @descrption 订单消息类型
 * @date 2019-7-2.
 */
public enum OrderMessageTypeEnum {

    /**物流订单**/
     LOGISTICS_ORDER,
    /**外卖待接单的订单**/
    TAKEAWAY_NEW_ORDER,
    /**外卖待发配送的订单**/
    TAKEAWAY_SHIPPING_ORDER,
    /**到店使用订单**/
    TO_SHOP_ORDER,
    /**退款订单**/
    REFUND_ORDER
}
