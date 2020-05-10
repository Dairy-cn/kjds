package com.cross.model.dish;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class SelfSupportDishSku implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    /**
     * sku规格
     */
    @ApiModelProperty(value = "sku规格")
    private String spec;

    /**
     * 商品规格图片
     */
    @ApiModelProperty(value = "商品规格图片")
    private String specImageUrl;
    /**
     * 菜品ID
     */
    @ApiModelProperty(value = "菜品ID")
    private Long dishId;

    /**
     * 餐盒数量
     */
    @ApiModelProperty(value = "餐盒数量")
    private Integer boxNum;

    /**
     * 打包盒单价
     */
    @ApiModelProperty(value = "打包盒单价")
    private Float boxPrice;

    /**
     * 商户ID
     */
    @ApiModelProperty(value = "商户ID")
    private Long merchantId;

    /**
     * 价格
     */
    @ApiModelProperty(value = "价格")
    private Float price;

    /**
     * 库存
     */
    @ApiModelProperty(value = "库存")
    private Integer stock;

    /**
     * 配送时间, 默认门店营业时间
     */
    @ApiModelProperty(value = "配送时间, 默认门店营业时间")
    private String availableTimes;

    /**
     * 分类编号
     */
    @ApiModelProperty(value = "分类编号")
    private Long catId;

    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Boolean deleteFlag = Boolean.FALSE;

    /**
     * 最大库存
     */
    @ApiModelProperty(value = "最大库存")
    private Integer maxStock;

    /**
     * 虚拟销量
     */
    @ApiModelProperty(value = "虚拟销量")
    private Integer initNum;

    /**
     * 成本
     */
    private Double cost;

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public Integer getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(Integer boxNum) {
        this.boxNum = boxNum;
    }

    public Float getBoxPrice() {
        return boxPrice;
    }

    public void setBoxPrice(Float boxPrice) {
        this.boxPrice = boxPrice;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getAvailableTimes() {
        return availableTimes;
    }

    public void setAvailableTimes(String availableTimes) {
        this.availableTimes = availableTimes;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Integer maxStock) {
        this.maxStock = maxStock;
    }

    public Integer getInitNum() {
        return initNum;
    }

    public void setInitNum(Integer initNum) {
        this.initNum = initNum;
    }

    public String getSpecImageUrl() {
        return specImageUrl;
    }

    public void setSpecImageUrl(String specImageUrl) {
        this.specImageUrl = specImageUrl;
    }
}
