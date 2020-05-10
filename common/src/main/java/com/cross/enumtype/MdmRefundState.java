package com.cross.enumtype;

public enum MdmRefundState {
    REFUND_FAILED(1,"退款失败"),
    REFUNDING(2,"退款中"),
    REFUND_SUCCESS(3,"退款成功");
    private Integer code;
    private String msg;

    MdmRefundState(Integer code, String msg) {
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
