package com.cross.model.dish;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * 菜品规格套餐信息
 */
public class DishSkuPackageInfoVM implements Serializable {

    @ApiModelProperty(value = "菜品名称")
    private String dishName;

    @ApiModelProperty(value = "套餐菜品数量")
    private Integer dishNum;

    @ApiModelProperty(value = "菜品单价")
    private Double dishPrice;

    /**
     * 和自营渠道的菜品规格进行关联
     */
    @ApiModelProperty(value = "外部菜品编码")
    private String externalSkuNo;

    public String getExternalSkuNo() {
        return externalSkuNo;
    }

    public void setExternalSkuNo(String externalSkuNo) {
        this.externalSkuNo = externalSkuNo;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Integer getDishNum() {
        return dishNum;
    }

    public void setDishNum(Integer dishNum) {
        this.dishNum = dishNum;
    }

    public Double getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(Double dishPrice) {
        this.dishPrice = dishPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishSkuPackageInfoVM that = (DishSkuPackageInfoVM) o;
        return Objects.equals(dishName, that.dishName) &&
            Objects.equals(dishNum, that.dishNum) &&
            Objects.equals(dishPrice, that.dishPrice) &&
            Objects.equals(externalSkuNo, that.externalSkuNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishName, dishNum, dishPrice, externalSkuNo);
    }
}
