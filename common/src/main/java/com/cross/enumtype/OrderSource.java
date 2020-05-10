package com.cross.enumtype;

/**
 * @author hcy
 * @descrption 订单来源
 * @date 2019-6-29.
 */
public enum OrderSource {
    /**
     * 套餐 到店消费
     */
    PACKAGE,
    /**
     * 外卖点餐
     */
    TAKEAWAY_MEAL,
    /**
     * 霸王餐
     */
    FREE_LUNCH,
    /**
     * 扫码点餐
     */
    QR_ORDER,
    /**
     * 优惠买单
     */
    OFFER_TO_PAY,
    
    /**
     * 外卖到店
     */
    PICK_UP,
    
    
    /**
     * 物流到家
     */
    DELIVERY_TO_HOME,

    /**
     * 掌控者会员卡充值
     */
    HOLDER_CARD_RECHARGE,
    



}
