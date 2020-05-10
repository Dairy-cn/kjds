package com.cross.model.enumeration;

/**
 * The OrderChannel enumeration.
 *
 * pending :未生效订单
 * unprocessed: 未处理订单
 * refunding:退单处理中
 * valid : 已处理的有效订单
 * invalid : 无效订单
 * settled : 已完成订单
 */
public enum OrderStatus {
    pending("pending"),
    unprocessed("unprocessed"),
    refunding("refunding"),
    valid("valid"),
    invalid("invalid"),
    settled("settled");

    private String orderDesc;

    private OrderStatus(String orderDesc) {
        this.orderDesc = orderDesc;
    }

}
