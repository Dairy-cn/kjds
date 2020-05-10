package com.cross.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author hcy
 * @descrption 乐玩商家信息
 * @date 2019-5-28.
 */
@Data
public class LeWanMerchantInfoVm {

    @ApiModelProperty("商家名")
    private String merchant_name;

    @ApiModelProperty("商家ID")
    private Integer merchant_id;

    @ApiModelProperty("商家前台电话")
    private String merchant_tel;

    @ApiModelProperty("商家所在省地址")
    private String province;

    @ApiModelProperty("商家所在城市")
    private String city;

    @ApiModelProperty("商家所在区县")
    private String area;

    @ApiModelProperty("商家地址")
    private String merchant_address;

    @ApiModelProperty("商家地址维度")
    private String merchant_lat;

    @ApiModelProperty("商家地址经度")
    private String merchant_lng;

    @ApiModelProperty(value = "是否在我们系统存在")
    private Boolean isExist = Boolean.FALSE;

    @ApiModelProperty(value = "是否是菜品所在的门店")
    private Boolean isDishMerchant = Boolean.FALSE;
}
