package com.cross.enumtype;

public enum DistributorOrderType {
    SCAN_CODE("SCAN_CODE"),OFFER_TO_PAY("OFFER_TO_PAY"),NETWORK("NETWORK");

    private String msg;

    DistributorOrderType(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
