package com.cross.model.enumeration;

/**
 * The PayState enumeration.
 */
public enum PlatformUseState {
    UNUSE("UNUSE", 0), USED("USED", 1);

    private String name;
    private Integer value;

    PlatformUseState(String name, Integer value){
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
