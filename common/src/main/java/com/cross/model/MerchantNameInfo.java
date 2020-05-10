package com.cross.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MerchantNameInfo {

    @ApiModelProperty(value = "门店名称")
    private String merchantName;

    @ApiModelProperty(value = "门店id")
    private Long merchantId;

    @ApiModelProperty(value = "门店编码")
    private Long merchantNo;

}
