package com.cross.model.dish;

import java.io.Serializable;
import java.util.Objects;

/**
 * 商品属性
 */
public class ShopDishAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 商户ID
     */
    private Long merchantId;

    /**
     * 品牌ID
     */
    private Long brandId;

    /**
     * 品牌ID
     */
    private String name;

    /**
     * 值
     */
    private String details;

    /**
     * 所属类型 1、品牌 2、商户
     */
    private Integer type;

    private ShopDish shopDish;

    /**
     * 商品包ID
     */
    private Long shopDishProductId;

    /**
     * 商品包ID
     */
    private Long shopDishProductCatId;

    /**
     * 是否删除
     */
    private Boolean isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopDishProductId() {
        return shopDishProductId;
    }

    public void setShopDishProductId(Long shopDishProductId) {
        this.shopDishProductId = shopDishProductId;
    }

    public ShopDishAttribute shopDishProductId(Long shopDishProductId) {
        this.shopDishProductId = shopDishProductId;
        return this;
    }

    public Long getShopDishProductCatId() {
        return shopDishProductCatId;
    }

    public void setShopDishProductCatId(Long shopDishProductCatId) {
        this.shopDishProductCatId = shopDishProductCatId;
    }

    public ShopDishAttribute shopDishProductCatId(Long shopDishProductCatId) {
        this.shopDishProductCatId = shopDishProductCatId;
        return this;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public ShopDishAttribute merchantId(Long merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public ShopDishAttribute brandId(Long brandId) {
        this.brandId = brandId;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShopDishAttribute name(String name) {
        this.name = name;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public ShopDishAttribute details(String details) {
        this.details = details;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public ShopDishAttribute type(Integer type) {
        this.type = type;
        return this;
    }

    public ShopDish getShopDish() {
        return shopDish;
    }

    public void setShopDish(ShopDish shopDish) {
        this.shopDish = shopDish;
    }

    public ShopDishAttribute shopDish(ShopDish shopDish) {
        this.shopDish = shopDish;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShopDishAttribute shopDishAttribute = (ShopDishAttribute) o;
        if (shopDishAttribute.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), shopDishAttribute.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ShopDishAttribute{" +
            "id=" + getId() +
            ", merchantId='" + getMerchantId() + "'" +
            ", brandId='" + getBrandId() + "'" +
            ", name='" + getName() + "'" +
            ", details='" + getDetails() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean delete) {
        isDelete = delete;
    }
}
