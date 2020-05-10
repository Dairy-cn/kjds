package com.cross.model;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class Spec {
    @ApiModelProperty(value = "规格名称")
    private String name;

    @ApiModelProperty(value = "规格价格")
    private BigDecimal price;

    @ApiModelProperty(value = "打包盒数量")
    private Integer packNum;

    @ApiModelProperty(value = "打包盒价格")
    private BigDecimal packPrice;
    private String skuGuid;

    private String unit;

    public String getSkuGuid() {
        return skuGuid;
    }

    public void setSkuGuid(String skuGuid) {
        this.skuGuid = skuGuid;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getPackNum() {
        return packNum;
    }

    public void setPackNum(Integer packNum) {
        this.packNum = packNum;
    }

    public BigDecimal getPackPrice() {
        return packPrice;
    }

    public void setPackPrice(BigDecimal packPrice) {
        this.packPrice = packPrice;
    }

    @Override
    public String toString() {
        return "Spec{" +
            "name='" + name + '\'' +
            ", price=" + price +
            ", packNum=" + packNum +
            ", packPrice=" + packPrice +
            '}';
    }
}
