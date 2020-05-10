package com.cross.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("优惠买单其他优惠活动")
public class FavorableDTO {

    @ApiModelProperty("其他活动编号 1：优惠券 2：会员折扣")
    private Integer activityCode;

    @ApiModelProperty("对应折扣")
    private Double discount;

    @ApiModelProperty("对应优惠金额")
    private Double DisMoney;

    public Integer getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(Integer activityCode) {
        this.activityCode = activityCode;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getDisMoney() {
        return DisMoney;
    }

    public void setDisMoney(Double disMoney) {
        DisMoney = disMoney;
    }

    @Override
    public String toString() {
        return "FavorableDTO{" +
            "activityCode=" + activityCode +
            ", discount=" + discount +
            ", DisMoney=" + DisMoney +
            '}';
    }
}
