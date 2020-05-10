package com.cross.model;

/*************************************************************
 * Description:  合伙人加入方式 OPEN_USER_MEMBER_CARD开通会员卡；BUY_PACKAGES购买套餐；ACHIEVING_LEVEL达到等级；ACHIEVING_GOALS完成目标
 * Author: Dair
 * CreateTime: 2019/8/10
 ************************************************************/
public enum DistributorJoinType {

    /**
     * 开通会员卡
     */
    OPEN_USER_MEMBER_CARD,
    /**
     * 购买套餐
     */
    BUY_PACKAGES,

    /**
     * 达到等级
     */

    ACHIEVING_LEVEL,

    /**
     * 完成目标
     */
    ACHIEVING_GOALS,

    FREE_JOIN
}
