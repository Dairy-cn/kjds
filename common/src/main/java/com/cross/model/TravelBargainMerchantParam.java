package com.cross.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wy
 * @descrption  旅划算门店信息请求参数
 * @date 2019-11-29.
 */
@Data
public class TravelBargainMerchantParam {

    @ApiModelProperty("品牌id")
    private Long brandId;

    @ApiModelProperty("商家名 business")
    private String merchant_name;

    @ApiModelProperty("商家ID")
    private Long merchant_id;

    @ApiModelProperty("商家所在省地址")
    private String province;

    @ApiModelProperty("商家所在城市")
    private String city;

    @ApiModelProperty("商家地址 product_addr")
    private String merchant_address;

    @ApiModelProperty(value = "是否在我们系统存在")
    private Boolean isExist = Boolean.FALSE;
}
