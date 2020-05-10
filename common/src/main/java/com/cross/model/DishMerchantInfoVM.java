package com.cross.model;

import com.cross.model.enumeration.BrandAndMerchantType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class DishMerchantInfoVM {

    private Long id;
    
    @ApiModelProperty(value = "平台id")
    private Long platformId;

    @ApiModelProperty(value = "菜品id")
    private Long dishId;

    @ApiModelProperty(value = "门店id")
    private Long merchantId;

    @ApiModelProperty(value = "门店编码")
    private Long merchantNo;

    /**
     * 第一个是经度  第二个是纬度
     */
    @ApiModelProperty(value = "门店位置")
    private String position;

    @ApiModelProperty(value = "门店配送范围")
    private List<List<String>> shippingRange;

    @ApiModelProperty(value = "门店名称")
    private String merchantName;

    @ApiModelProperty(value = "门店电话")
    private String merchantTel;

    @ApiModelProperty(value = "服务说明")
    private List<ServiceDescriptionVM> serviceDescription;

    @ApiModelProperty("省")
    private String province;

    @ApiModelProperty("市")
    private String city;

    @ApiModelProperty("区县")
    private String county;

    @ApiModelProperty("实际地址")
    private String address;

    @ApiModelProperty("是否是菜品所在门店")
    private Boolean dishMerchant = Boolean.FALSE;

    @ApiModelProperty("品牌和门店类型")
    private BrandAndMerchantType brandAndMerchantType;

    @ApiModelProperty("品牌名称")
    private String brandName;

    @ApiModelProperty(value = "店铺状态 0休息 1营业 2打烊 3忙碌")
    private Integer status;

    @ApiModelProperty(value = "营业时间段")
    private String shopHours;

    /**
     * 1:周一  2：周二  4：周三   8：周四  16：周五   32：周六  64：周日
     */
    @ApiModelProperty(value = "营业时间 周一到周末")
    private Integer businessHours;

    @ApiModelProperty(value = "门店logo")
    private String merchantAvatar;

}
