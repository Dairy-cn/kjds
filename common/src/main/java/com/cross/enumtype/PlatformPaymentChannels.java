package com.cross.enumtype;

/**
 * The PlatformPaymentChannels enumeration.
 */
public enum PlatformPaymentChannels {
    ALIPAY(1, "支付宝"),
    WECHAT(2, "微信"),
    BANK_CARD(3, "银行卡"),
    PLATFORM_BALANCE(4, "平台账户"),
    PROMOTION_BALANCE(5, "营销余额"),
    USER_BALANCE(6, "用户账户"),
    MERCHANT_BALANCE(7, "商户账户"),
    
    //兼容之前数据
    BALANCE(8, "平台账户"),
    USER(9, "用户账户"),
    
    //新增数据
    ADMIN_DIRECT_INPUT(10,"直接输入")
    ;
    
    
    private Integer code;
    private String msg;
    
    PlatformPaymentChannels(Integer code, String msg) {
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
