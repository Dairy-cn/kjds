package com.cross.model.enumeration;

/**
 * The BillingRoules enumeration.
 */
public enum BillingRoules {
    BEELINE("1", "直线"), CAR("2", "汽车"), WALK("3", "步行");

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    BillingRoules(String id, String name){
        this.id = id;
        this.name = name;
    }
}
