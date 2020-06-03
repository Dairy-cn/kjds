package com.cross.merchants.web.rest.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/*************************************************************
 * Description:
 * Author: Dair
 * CreateTime: 2020/5/25

 ************************************************************/
@ApiModel(description = "购物车")
public class GoodsPropertyVO {

    @ApiModelProperty(value = "属性")
    private String key;


    @ApiModelProperty(value = "属性值")
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
