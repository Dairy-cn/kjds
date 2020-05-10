package com.cross.model.enumeration;

/**
 * 订单类型 NETWORK 网络外卖,EATNOW 堂吃订单, PICK_UP 自取,TAO_QUAN：权益淘券,DELIVERY_TO_HOME物流,TO_THE_STORE:到店,SCAN_CODE 扫码点餐,OFFER_TO_PAY 优惠买单
 */
public enum OrderType {
    NETWORK(1, "网络外卖"),
    EATNOW(2, "堂吃订单"),
    PICK_UP(3, "自取"),
    DELIVERY_TO_HOME(4, "物流到家"),
    TO_THE_STORE(5, "到店"),
    TAO_QUAN(6, "权益淘券"),
    SCAN_CODE(7, "扫码点餐"),
    OFFER_TO_PAY(8, "优惠买单"),
    NETWORK_MEAL(9, ""),
    HOLDER_CARD_RECHARGE(10, "掌控者会员卡充值"),
    SCAN_CODE_PAY_LATER(11, "扫码点餐后付"),
    ;
    private Integer code;
    private String msg;

    OrderType(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
