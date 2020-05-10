package com.cross.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author DuYuLiang on 2018/5/10.
 */
public class BrandServiceModeVM {
    @ApiModelProperty(value = "目标")
    private Integer target;

    @ApiModelProperty(value = "费率")
    private Double serviceRates;

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public Double getServiceRates() {
        return serviceRates;
    }

    public void setServiceRates(Double serviceRates) {
        this.serviceRates = serviceRates;
    }
}
