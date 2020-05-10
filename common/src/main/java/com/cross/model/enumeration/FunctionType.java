package com.cross.model.enumeration;

/**
 *
 */
public enum FunctionType {

    /**
     * 套餐
     */
    PACKAGE("套餐",1),
    /**
     * 权益淘券
     */
    TAO_QUAN("权益淘券",2);

    private String name;
    private Integer value;

    FunctionType(String name, Integer value){
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
