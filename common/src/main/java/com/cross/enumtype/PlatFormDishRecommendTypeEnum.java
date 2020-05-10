package com.cross.enumtype;

import lombok.Getter;

/*************************************************************
 * Description: 商品推荐类型枚举
 * Author: Dairy
 * CreateTime: 2019/6/10
 ************************************************************/
@Getter
public enum PlatFormDishRecommendTypeEnum {

    /**
     * 非通吃岛平台推荐商品
     */
    OTHER_PLATFORM(0,"非通吃岛平台推荐商品"),
    /**
     * 首页
     */
    INDEX(1, "首页"),

    /**
     * 闲时约饭
     */
    DINNERAPPOINTMENT(2, "闲时约饭"),

    /**
     * 外卖到家
     */
    HOMEDELIVERY(3, "外卖到家"),

    /**
     * 到店特惠
     */
    STOREPREFERENTIAL(4,"到店特惠"),

    CHANNEL_PAGE(5,"套餐商品频道页"),

    FREE_LUNCH(6,"霸王餐弹窗"),

    INTRODUCTION_PAGE_TCK(7,"通吃卡权益介绍页"),

    CHANNEL_TAO_QUAN(8,"权益淘券频道页")
    ;

    private Integer code;
    private String type;

    PlatFormDishRecommendTypeEnum() {
    }



    PlatFormDishRecommendTypeEnum(Integer code, String type) {
        this.code = code;
        this.type = type;
    }

    public static PlatFormDishRecommendTypeEnum findOne(int code) {

        for (PlatFormDishRecommendTypeEnum value : PlatFormDishRecommendTypeEnum.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return null;
    }

    public static PlatFormDishRecommendTypeEnum findOne(String type) {

        for (PlatFormDishRecommendTypeEnum value : PlatFormDishRecommendTypeEnum.values()) {
            if (value.getType().equals(type)) {
                return value;
            }
        }
        return null;
    }
}
