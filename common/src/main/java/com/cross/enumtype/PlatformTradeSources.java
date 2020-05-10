package com.cross.enumtype;

/**
 * The PlatformTradeSources enumeration.
 */
public enum PlatformTradeSources {
    PUBLISH_PROMOTION(1, "发布赏单"),
    RECALL_PROMOTION(2, "赏单营销金回收 撤回宣发"),
    CANCEL_PROMOTION(3, "赏单营销金回收 取消宣发"),
    CHECK_FAIL_PROMOTION(4, "宣发审核未通过"),
    CHECK_ORDER_PROMOTION(5, "宣发订单审核通过"),
    CHECK_ORDER_FAIL_PROMOTION(6, "宣发订单审核未通过"),
    NO_ORDER_REFUND_PROMOITON(7, "宣发订单未完成"),
    PROMOTION_BALANCE_RECHARGE(8, "推广余额充值"),
    BALANCE_RECHARGE(9, "余额充值"),
    WITHDRAWAL(10, "提现"),
    SELL_GOODS(11, "售卖商品"),
    PUBLISH_REWARDS_POOL_BASIC(12, "奖金池基础金额"),
    REFUND_REWARDS_POOL_BASIC(13, "奖金池营销金回收"),
    PUBLISH_REWARDS_POOL_INITIAL(14, "奖金池初始金额"),
    PULL_JOIN_USER_MEMBER(15, "奖金池新成员投入金额"),
    REFUND_SELL_GOODS(16, "售卖商品退款"),
    BUY_CARD_CASH_BACK(17, "通吃卡返现"),
    DISTRIBUTOE_GOODS_CASH_BACK(18, "用户分销商品返现扣除余额"),
    PROMOTION_COMMISSION_PROFIT(19, "媒体宣发抽成"),
    USER_WITHDRAW_COMMISSION_PROFIT(20, "用户提现抽成"),
    MERCHANT_WITHDRAWAL_PROFIT(31, "商户提现抽成"),
    NOT_DISTRIBUTOR_USER_BACK_TCD_PLATFORM_PROFIT(22, "分销提成未分配收益"),
    USER_BUY_TC_CARD_PROFIT(23, "通吃卡会员"),
    USER_WITHDRAWAL(24, "用户提现"),
    MERCHANT_WITHDRAWAL(25, "商户提现"),
    MERCHANT_RECHARGE(26, "商户充值"),
    USER_RECHARGE(27, "用户充值"),
    PUBLISH_REWARDS_POOL_EXT(28, "奖金池额外投入金额"),
    REFUND_SELL_TC_CARD(29, "售卖通吃卡退款"),
    DISTRIBUTOE_GOODS_CASH_BACK_REFUNDS(33, "用户分销商品返现退回增加余额"),
    NOT_DISTRIBUTOR_USER_BACK_TCD_PLATFORM_PROFIT_REFUNDS(34, "分销提成未分配收益退回"),
    DISTRIBUTOR_GOODS_CASH_BACK_TO_USER_PROFIT(35, "分销商品返现金额给用户"),
    MERCHANT_SHOP_ORDER_TO_THE_STORE_NOT_FINISH(36, "商家商品订单未核销,扣除商家金额"),
    GROUP_BUREAU_RETURN_MONEY(37, "组局晒图返现"),
    DELIVERY_FEE_RECHARGE(38, "配送余额充值"),
    MERCHANT_DELIVERY_FEE_RECHARGE(38, "商户配送费用充值"),
    //兼容之前数据
    RECHARGE(32, "充值"),
    
    
    ;
    
    private Integer code;
    private String msg;
    
    PlatformTradeSources(Integer code, String msg) {
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
