package com.cross.enumtype;

/*************************************************************
 * Description:  平台收益类型
 * Author: Dairy
 * CreateTime: 2019/8/22
 ************************************************************/
public enum PlatformProfitType {
    
    /**
     * 媒体宣发抽成收益
     */
    PROMOTION_PROFIT,
    /**
     * 用户提现抽成收益
     */
    USER_WITHDRAW_PROFIT,
    /**
     * 平台提现抽成收益
     */
    PLATFORM_WITHDRAW_PROFIT,
    /**
     * 分销商品未分配收益
     */
    UNDISTRIBUTED_PROFIT,
    /**
     * 用户购买通吃卡收益
     */
    USER_BUY_TC_CARD_PROFIT,
    /**
     * 用户购买商品收益
     */
    USER_BUY_GOODS_PROFIT,
    
    /**
     * 商家推广余额充值
     */
    MERCHANT_PROMOTION_BALANCE_RECHARGE,
    /**
     * 用户充值余额收益
     */
    USER_BALANCE_RECHARGE,
    /**
     * 分销商品收益退回
     */
    DISTRIBUTED_PROFIT_REFUNDS,
    
    
    /**
     * 商家配送费余额充值
     */
    MERCHANT_DELIVERY_FEE_RECHARGE,
    ;
    
}
