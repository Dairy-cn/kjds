package com.cross.merchants.utils.alipay;

import lombok.Getter;


@Getter
public enum AlipayTradeStatus {


    /**
     * 支付失败
     */
    CLOSED(0, "TRADE_CLOSED"),
    /**
     * 支付成功
     */

    SUCCESS(1, "TRADE_SUCCESS"),

    FINISHED(2, "TRADE_FINISHED");


    private Integer code;
    private String msg;

    AlipayTradeStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
