package com.cross.model.enumeration;

/**
 * The BillingRoules enumeration.
 */
public enum RefundStateType {
    REFUND_ING(0, "退款中"), REFUND_SUCCESS(1, "退款成功"), REFUND_FAIL(2, "退款失败");

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    RefundStateType(Integer id, String name){
        this.id = id;
        this.name = name;
    }
}
