package com.cross.merchants.web.rest.DTO;

import com.cross.interfaces.JodaInstant2DateJsonDeserializer;
import com.cross.interfaces.JodaInstant2DateJsonSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

/*************************************************************
 * Description:
 * Author: Dair
 * CreateTime: 2020/5/25

 ************************************************************/
@ApiModel(description = "购物车")
public class UserCartItemDTO implements Serializable {



    @ApiModelProperty(value = "购物车Id")
    private String id;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "商品id")
    private Long productId;
    @ApiModelProperty(value = "商品规格id")
    private Long productSkuId;

    @ApiModelProperty(value = "购买数量")
    private Integer quantity;

    @ApiModelProperty(value = "商品销售属性标签ID")
    private List<Long> goodsPropertyTagIds;




    public List<Long> getGoodsPropertyTagIds() {
        return goodsPropertyTagIds;
    }

    public void setGoodsPropertyTagIds(List<Long> goodsPropertyTagIds) {
        this.goodsPropertyTagIds = goodsPropertyTagIds;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
