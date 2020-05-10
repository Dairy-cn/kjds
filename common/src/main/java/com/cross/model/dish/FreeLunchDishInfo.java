package com.cross.model.dish;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author hcy
 * @descrption 霸王餐商品信息
 * @date 2019-8-19.
 */
@Data
public class FreeLunchDishInfo implements Serializable {

    private String picture;

    private Float price;

    private Long skuId;

    private Long dishId;

    private Long merchantId;

    private String dishName;

    private String spec;

    private Integer productType;

    @ApiModelProperty(value = "原价（虚拟价格）")
    private Double originalPrice;

    @ApiModelProperty(value = "商品售卖开始时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant useStartTime;

    @ApiModelProperty(value = "商品售卖结束时间")

       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant useEndTime;

}
