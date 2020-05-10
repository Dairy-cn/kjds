package com.cross.model;


import com.cross.model.dish.DishSkuPackageInfoVM;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

public class ShopOrderProductInfoDTO {
    private Long id;

    private String itemGuid;
    private String itemName;
    /**
     * 产品ID
     */
    @ApiModelProperty(value = "产品ID")
    private Long productId;

    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
    private String productName;

    /**
     * 产品数量
     */
    @ApiModelProperty(value = "产品数量")
    private String productNum;

    /**
     * 产品价格
     */
    @ApiModelProperty(value = "产品价格")
    private Double productPrice;

    /**
     * 产品原价
     */
    @ApiModelProperty(value = "产品原价")
    private BigDecimal marketPrice;

    /**
     * 打包费
     */
    @ApiModelProperty(value = "打包费")
    private Double packFee;

    /**
     * 小计
     */
    @ApiModelProperty(value = "小计")
    private Double subtotal;

    private Long shopOrderId;

    /**
     * 产品标准
     */
    @ApiModelProperty(value = "产品标准")
    private Spec spec;

    private Long skuId;

    /**
     * 菜品图片
     */
    @ApiModelProperty(value = "菜品图片")
    private String imageUrl;

    private List<SelfSupportDishPropertyModel> selfSupportDishPropertyTempList;

    private String externalSkuNo;

    public String getItemGuid() {
        return itemGuid;
    }

    public void setItemGuid(String itemGuid) {
        this.itemGuid = itemGuid;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @ApiModelProperty(value = "规格描述--套餐信息")
    private List<DishSkuPackageInfoVM> packageInfoList;

    public List<DishSkuPackageInfoVM> getPackageInfoList() {
        return packageInfoList;
    }

    public void setPackageInfoList(List<DishSkuPackageInfoVM> packageInfoList) {
        this.packageInfoList = packageInfoList;
    }

    public String getExternalSkuNo() {
        return externalSkuNo;
    }

    public void setExternalSkuNo(String externalSkuNo) {
        this.externalSkuNo = externalSkuNo;
    }

    public List<SelfSupportDishPropertyModel> getSelfSupportDishPropertyTempList() {
        return selfSupportDishPropertyTempList;
    }

    public void setSelfSupportDishPropertyTempList(List<SelfSupportDishPropertyModel> selfSupportDishPropertyTempList) {
        this.selfSupportDishPropertyTempList = selfSupportDishPropertyTempList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getPackFee() {
        return packFee;
    }

    public void setPackFee(Double packFee) {
        this.packFee = packFee;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Long getShopOrderId() {
        return shopOrderId;
    }

    public void setShopOrderId(Long shopOrderId) {
        this.shopOrderId = shopOrderId;
    }

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
