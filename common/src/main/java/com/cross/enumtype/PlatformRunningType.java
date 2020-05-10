package com.cross.enumtype;

/**
 * The PlatformRunningType enumeration.
 */
public enum PlatformRunningType {
    INCOME(1, "收益"),
    SPENDING(2, "支出"),
    BALANCE_RECHARGE(3,"余额充值"),
    CHECK_PROMOTION_ORDER(4,"宣发订单");
    ;
    private Integer code;
    private String msg;
    
    PlatformRunningType(Integer code, String msg) {
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
