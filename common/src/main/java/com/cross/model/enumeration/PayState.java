package com.cross.model.enumeration;

/**
 * The PayState enumeration.
 */
public enum PayState {
    UNPAY("UNPAY", 0), PAYED("PAYED", 1);

    private String name;
    private Integer value;

    PayState(String name, Integer value){
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
