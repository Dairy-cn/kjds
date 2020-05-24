package com.cross.merchants.service.dto;

import com.cross.interfaces.JodaInstant2DateJsonDeserializer;
import com.cross.interfaces.JodaInstant2DateJsonSerializer;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/*************************************************************
 * Description:
 * Author: Dairy
 * CreateTime: 2020/5/23
 * Copyright © 成都通吃岛信息技术有限公司 All right reserved
 ************************************************************/
@ApiModel(description = "购物车")
public class CartItemDTO implements Serializable {

    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "商品id")
    private Long productId;
    @ApiModelProperty(value = "商品规格id")
    private Long productSkuId;
    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "购买数量")
    private Integer quantity;

    @ApiModelProperty(value = "添加到购物车的价格")
    private BigDecimal price;

    @ApiModelProperty(value = "商品主图")
    private String productPic;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "商品副标题（卖点）")
    private String productSubTitle;

    @ApiModelProperty(value = "商品sku条码")
    private String productSkuCode;

    @ApiModelProperty(value = "会员昵称")
    private String memberNickname;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstant2DateJsonDeserializer.class)
    @JsonSerialize(using = JodaInstant2DateJsonSerializer.class)
    private Instant createDate;

    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstant2DateJsonDeserializer.class)
    @JsonSerialize(using = JodaInstant2DateJsonSerializer.class)
    private Instant modifyDate;


    @ApiModelProperty(value = "商品分类")
    private Long productCategoryId;

    @ApiModelProperty(value = "商品状态 true 为过期")
    private Boolean goodsState;

    @ApiModelProperty(value = "商品销售属性:[{'key':'颜色','value':'颜色'},{'key':'容量','value':'4G'}]")
    private String productAttr;

    public Boolean getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(Boolean goodsState) {
        this.goodsState = goodsState;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSubTitle() {
        return productSubTitle;
    }

    public void setProductSubTitle(String productSubTitle) {
        this.productSubTitle = productSubTitle;
    }

    public String getProductSkuCode() {
        return productSkuCode;
    }

    public void setProductSkuCode(String productSkuCode) {
        this.productSkuCode = productSkuCode;
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Instant getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Instant modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getProductAttr() {
        return productAttr;
    }

    public void setProductAttr(String productAttr) {
        this.productAttr = productAttr;
    }
}
