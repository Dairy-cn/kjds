package com.cross.model.enumeration;

/**
 * The DistributionStatus enumeration.
 */
public enum DistributionStatus {
    TOBEISSUED("1", "待发单"), TOBESINGLE("2", "待抢单"), TOBEORDERS("3", "待接单"), TAKEASINGLE("4", "取单中"), DISTRIBUTION("5", "配送中"), SERVICE("6", "已送达"), REVOKED("7", "已撤销");

    private String id;
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    DistributionStatus(String id, String value){
        this.id = id;
        this.value = value;
    }
}
