package com.cross.enumtype;

public enum AccountPlatTypeEnum{
    PLAT_WE_CHAT("微信", 1),
    PLAT_ALI_PAY("支付宝", 2),
    PLAT_QQ("QQ", 4);

    private String name;
    private Integer value;

    AccountPlatTypeEnum(String name, Integer value){
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
