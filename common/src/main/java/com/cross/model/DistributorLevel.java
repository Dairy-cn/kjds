package com.cross.model;

/**
 * @Author DuYuLiang on 2018/5/30.
 */
public enum DistributorLevel {
    LEVEL_ONE("ONE", 1),
    LEVEL_TWO("TWO", 2),
    LEVEL_THREE("THREE", 3);

    private String name;
    private Integer value;

    DistributorLevel(String name, Integer value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
