package com.cross.model.enumeration;

/**
 *
 */
public enum PlatFormFunctionType {

    /**
     * 套餐
     */
    PACKAGE("套餐", 1),
    /**
     * 权益淘券
     */
    TAO_QUAN("权益淘券", 2),

    /**
     * 宣发
     */
    PROMOTION("宣发", 3),

    /**
     * 电商商品
     */
    GOODS("电商商品", 4),
    /**
     * 门店
     */
    MERCHANT("门店", 5);

    private String name;
    private Integer value;

    PlatFormFunctionType(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

}
