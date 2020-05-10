package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.cross.model.dish.ShopDishSku;
import com.cross.model.enumeration.FunctionType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@ApiModel(description = "平台商品推荐")
@Data
public class PlatformDishRecommendDTO implements Serializable {

    private Long id;

    /**
     * 平台id
     */
    @ApiModelProperty(value = "平台id", required = true)
    private Long platformId;

    /**
     * 商户(门店)id
     */
    @ApiModelProperty(value = "商户(门店)id", required = true)
    private Long merchantId;

    /**
     * 平台商品id
     */
    @ApiModelProperty(value = "平台商品id", required = true)
    private Long dishId;

    /**
     * 是否置顶
     */
    @ApiModelProperty(value = "是否置顶")
    private Boolean isStick;

    /**
     * 商品推荐类型{@link com.cross.enumtype.PlatFormDishRecommendTypeEnum}
     */
    @ApiModelProperty(value = "商品推荐类型{@link com.hpkj.platform.enums.PlatFormDishRecommendTypeEnum}")
    private Integer type;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant createTime;


    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant updateTime;


    /**
     * 4
     * 商品名
     *
     * @return
     */
    @ApiModelProperty(hidden = true)
    private String dishName;

    /**
     * 状态
     */
    @ApiModelProperty(hidden = true)
    private Integer dishState;


    /**
     * 商品类型 1快递到家 2外卖配送 4到店消费 8外卖自提 16外卖套餐 32.线上兑换"
     */
    @ApiModelProperty(hidden = true)
    private Integer productType;

    @ApiModelProperty(hidden = true)
    private Long dishNo;

    /**
     * 门店名
     */
    @ApiModelProperty(hidden = true)
    private String merchantName;


    /**
     * 图片id或地址 -非必须
     */
    @ApiModelProperty(hidden = true)
    private String picture;


    /**
     * 开始时间
     */
    @ApiModelProperty(hidden = true)
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant useStartTime;
    /**
     * 结束时间
     */
    @ApiModelProperty(hidden = true)
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant useEndTime;


    @ApiModelProperty(hidden = true)
    private List<ShopDishSku> dishSkus;

    /** 广告商品添加 添加类型字段 added by wy at 20190816 start */
    /**
     * 推荐商品类型
     */
    @ApiModelProperty(value = "推荐商品类型")
    private FunctionType functionType;
    /** 广告商品添加 添加类型字段 added by wy at 20190816 end */

    @ApiModelProperty(value = "置顶时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant topTime;
    

    
    
}
