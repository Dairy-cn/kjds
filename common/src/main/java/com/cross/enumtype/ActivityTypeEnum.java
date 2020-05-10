package com.cross.enumtype;

/**
 * @Author DuYuLiang on 2018/5/31.
 */
public enum ActivityTypeEnum {
    ACITIVITY_BONUS("红包", 1),
    ACITIVITY_FULL_SUB("满减", 2),
    ACCTIVITY_SPIKE("秒杀",3),
    ACCTIVITY_SHARE("分享",4),
    ACCTIVITY_OFFER("优惠",5),
    ACCTIVITY_BARGAIN("砍价",6);

    private String name;
    private Integer value;

    ActivityTypeEnum(String name, Integer value){
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
