package com.cross.model.enumeration;

/**
 * @author hcy
 * @descrption 品牌入驻来源
 * @date 2019-8-2.
 */
public enum BrandSourceType {

    /**
     * 以游客身份登录入驻到通吃岛的品牌: 官网
     */
    OFFICIAL_WEBSITE,
    /**
     * 购买平台中的品牌入驻通吃岛：赚餐
     */
    ZHUAN_CAN,
    /**
     * 从通吃岛小程序进入入驻通吃岛：小程序
     */
    APPLETS,
    /**
     * 从通吃岛后台添加并注入：通吃岛后台入驻
     */
    TCD,
    /**
     * 通吃岛自营品牌的入驻：自营入驻
     */
    SELF_OPERATED,

    /**
     * mdm同步
     */
    MDM
}
