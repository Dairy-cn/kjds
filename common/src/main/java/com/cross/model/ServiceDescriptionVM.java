package com.cross.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author hcy
 * @descrption 门店服务说明
 * @date 2019-5-5.
 */
public class ServiceDescriptionVM {

    @ApiModelProperty(value = "服务说明的标签")
    private String serviceTag;

    @ApiModelProperty(value = "标签描述")
    private String serviceTagDescription;

    public String getServiceTag() {
        return serviceTag;
    }

    public void setServiceTag(String serviceTag) {
        this.serviceTag = serviceTag;
    }

    public String getServiceTagDescription() {
        return serviceTagDescription;
    }

    public void setServiceTagDescription(String serviceTagDescription) {
        this.serviceTagDescription = serviceTagDescription;
    }
}
