package com.cross.enumtype;

/**
 * Created by DuYuLiang on 2017/6/19.
 */
public enum QueueMessageTypeEnum {
    QUEUE_MESSAGE_PAY_NOTIFY("支付通知队列", 1),
    QUEUE_MESSAGE_PAY_QUERY("支付查询队列", 2),
    QUEUE_MESSAGE_NEW_ORDER_NOTIFY("订单通知队列", 101),
    QUEUE_MESSAGE_REMIND_ORDER_NOTIFY("订单催单消息", 103),
    QUEUE_MESSAGE_REFUND_ORDER_NOTIFY("订单申请退款", 104),
    QUEUE_MESSAGE_APPLY_ORDER_NOTIFY("订单骑手已接单", 105),
    QUEUE_MESSAGE_RECEIVE_ORDER_NOTIFY("订单骑手已取单", 106),
    QUEUE_MESSAGE_FINISHED_ORDER_NOTIFY("订单已送达", 107),
    QUEUE_MESSAGE_CANCEL_ORDER_NOTIFY("订单取消", 102),
    QUEUE_MESSAGE_REFUNDS_ORDER_NOTIFY("订单退款", 108),
    QUEUE_MESSAGE_SYN_HOLDER("外卖订单同步掌控者", 201),
    QUEUE_MESSAGE_MDMPAY_POLLING("聚合支付查询队列", 1001),
    QUEUE_MESSAGW_MDMREFUND_POLLING("聚合支付退款轮询",1002);
    private String name;
    private Integer value;

    QueueMessageTypeEnum(String name, Integer value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
