package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * @descrption TODO
 * @date 2019-8-19.
 */
public class SelfDishOfTaoQuanInfoVm implements Serializable {

    @ApiModelProperty(value = "规格id")
    private Long id;

    @ApiModelProperty(value = "商品名称")
    private String dishName;

    @ApiModelProperty(value = "商品标签（多个使用,分隔）")
    private String tagStr;

    @ApiModelProperty(value = "商品图片")
    private String picture;

    @ApiModelProperty(value = "特惠平台菜品详情的轮播图")
    private String dishImageUrl;

    @ApiModelProperty(value = "商品售价")
    private Float price;

    @ApiModelProperty(value = "商品原价")
    private BigDecimal originalPrice;

    private Long dishId;

    /**
     * sku规格
     */
    @ApiModelProperty(value = "sku规格")
    private String spec;

    /**
     * 库存
     */
    @ApiModelProperty(value = "库存")
    private Integer stock;

    /**
     * 分类编号
     */
    @ApiModelProperty(value = "分类编号")
    private Long categoryId;

    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称")
    private String categoryName;
    /**
     * 置顶时间：用于排序
     */
    @ApiModelProperty(value = "置顶时间：用于排序")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant topTime;

    public SelfDishOfTaoQuanInfoVm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getTagStr() {
        return tagStr;
    }

    public void setTagStr(String tagStr) {
        this.tagStr = tagStr;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getDishImageUrl() {
        return dishImageUrl;
    }

    public void setDishImageUrl(String dishImageUrl) {
        this.dishImageUrl = dishImageUrl;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Instant getTopTime() {
        return topTime;
    }

    public void setTopTime(Instant topTime) {
        this.topTime = topTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelfDishOfTaoQuanInfoVm that = (SelfDishOfTaoQuanInfoVm) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(dishName, that.dishName) &&
            Objects.equals(tagStr, that.tagStr) &&
            Objects.equals(picture, that.picture) &&
            Objects.equals(dishImageUrl, that.dishImageUrl) &&
            Objects.equals(price, that.price) &&
            Objects.equals(originalPrice, that.originalPrice) &&
            Objects.equals(dishId, that.dishId) &&
            Objects.equals(spec, that.spec) &&
            Objects.equals(stock, that.stock) &&
            Objects.equals(categoryId, that.categoryId) &&
            Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dishName, tagStr, picture, dishImageUrl, price, originalPrice, dishId, spec, stock, categoryId, categoryName);
    }

    @Override
    public String toString() {
        return "SelfDishOfTaoQuanInfoVm{" +
            "id=" + id +
            ", dishName='" + dishName + '\'' +
            ", tagStr='" + tagStr + '\'' +
            ", picture='" + picture + '\'' +
            ", dishImageUrl='" + dishImageUrl + '\'' +
            ", price=" + price +
            ", originalPrice=" + originalPrice +
            ", dishId=" + dishId +
            ", spec='" + spec + '\'' +
            ", stock=" + stock +
            ", categoryId=" + categoryId +
            ", categoryName='" + categoryName + '\'' +
            ", topTime=" + topTime +
            '}';
    }
}
