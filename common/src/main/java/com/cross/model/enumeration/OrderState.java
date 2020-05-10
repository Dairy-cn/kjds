package com.cross.model.enumeration;

/**
 * 订单状态 PENDING 待处理、 COOKING 出餐中、 TAKE_A_SINGLE 取单中、DISTRIBUTION 配送中、FINISH 已完成、CANCELLED 已取消、PERSON_PENDING 配送员待接单. INVALID 失效
 */
public enum OrderState {
    PENDING(1), COOKING(2), PERSON_PENDING(3), TAKE_A_SINGLE(4), DISTRIBUTION(5), FINISH(6), CANCELLED(7),INVALID(8);

    private Integer index;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    OrderState(Integer index){
        this.index = index;
    }
}
