package com.cross.model.dish;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 商品包
 */
public class ShopDishProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 包名称
     */
    private String name;

    /**
     * 商户ID
     */
    private Long merchantId;

    /**
     * 品牌ID
     */
    private Long brandId;

    /**
     * 所属类型 1、品牌 2、商户
     */
    private Integer type;

    /**
     * 初始化渠道 1.美团 2.饿了么 ...
     */
    private Integer source;

    private Set<ShopDishProductCat> shopDishProductCats = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShopDishProduct name(String name) {
        this.name = name;
        return this;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public ShopDishProduct merchantId(Long merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public ShopDishProduct brandId(Long brandId) {
        this.brandId = brandId;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public ShopDishProduct type(Integer type) {
        this.type = type;
        return this;
    }

    public Set<ShopDishProductCat> getShopDishProductCats() {
        return shopDishProductCats;
    }

    public void setShopDishProductCats(Set<ShopDishProductCat> shopDishProductCats) {
        this.shopDishProductCats = shopDishProductCats;
    }

    public ShopDishProduct shopDishProductCats(Set<ShopDishProductCat> shopDishProductCats) {
        this.shopDishProductCats = shopDishProductCats;
        return this;
    }

    public ShopDishProduct addShopDishProductCat(ShopDishProductCat shopDishProductCat) {
        this.shopDishProductCats.add(shopDishProductCat);
        shopDishProductCat.setShopDishProduct(this);
        return this;
    }

    public ShopDishProduct removeShopDishProductCat(ShopDishProductCat shopDishProductCat) {
        this.shopDishProductCats.remove(shopDishProductCat);
        shopDishProductCat.setShopDishProduct(null);
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
        ShopDishProduct shopDishProduct = (ShopDishProduct) o;
        if (shopDishProduct.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), shopDishProduct.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ShopDishProduct{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", merchantId='" + getMerchantId() + "'" +
            ", brandId='" + getBrandId() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }
}
