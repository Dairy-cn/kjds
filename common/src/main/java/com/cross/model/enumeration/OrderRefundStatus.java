package com.cross.model.enumeration;

/**
 * The OrderChannel enumeration.
 */
public enum OrderRefundStatus {
    noRefund("noRefund"),
    applied("applied"),
    rejected("rejected"),
    arbitrating("arbitrating"),
    failed("failed"),
    successful("successful");

    private String orderDesc;

    private OrderRefundStatus(String orderDesc) {
        this.orderDesc = orderDesc;
    }

}
