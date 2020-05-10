package com.cross.model;


import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the EleMeGoods entity.
 */
public class EleMeGoodsDTO implements Serializable {

    private Long id;

    private String description;

    @Size(max = 120)
    private String name;

    private Integer isValid;

    private Integer recentPopularity;

    private Long categoryId;

    private Long shopId;

    @Size(max = 60)
    private String shopName;

    @Size(max = 120)
    private String imageUrl;

    @Size(max = 500)
    private String sellingTime;

    @Size(max = 240)
    private String attributes;

    private Long backCategoryId;

    private Integer minPurchaseQuantity;

    @Size(max = 10)
    private String unit;

    private Integer setMeal;

    private String labels;

    /**
     * 超级用户编号
     */
    @ApiModelProperty(value = "超级用户编号")
    private Long masterUserId;

    /**
     * 平台或品牌方编号
     */
    @ApiModelProperty(value = "平台或品牌方编号")
    private Long platformId;

    /**
     * 本地店铺编号
     */
    @ApiModelProperty(value = "本地店铺编号")
    private Long merchantId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Integer getRecentPopularity() {
        return recentPopularity;
    }

    public void setRecentPopularity(Integer recentPopularity) {
        this.recentPopularity = recentPopularity;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSellingTime() {
        return sellingTime;
    }

    public void setSellingTime(String sellingTime) {
        this.sellingTime = sellingTime;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public Long getBackCategoryId() {
        return backCategoryId;
    }

    public void setBackCategoryId(Long backCategoryId) {
        this.backCategoryId = backCategoryId;
    }

    public Integer getMinPurchaseQuantity() {
        return minPurchaseQuantity;
    }

    public void setMinPurchaseQuantity(Integer minPurchaseQuantity) {
        this.minPurchaseQuantity = minPurchaseQuantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getSetMeal() {
        return setMeal;
    }

    public void setSetMeal(Integer setMeal) {
        this.setMeal = setMeal;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String eleMeGoodsLabel) {
        this.labels = eleMeGoodsLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EleMeGoodsDTO eleMeGoodsDTO = (EleMeGoodsDTO) o;
        if(eleMeGoodsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), eleMeGoodsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EleMeGoodsDTO{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", name='" + getName() + "'" +
            ", isValid=" + getIsValid() +
            ", recentPopularity=" + getRecentPopularity() +
            ", categoryId=" + getCategoryId() +
            ", shopId=" + getShopId() +
            ", shopName='" + getShopName() + "'" +
            ", imageUrl='" + getImageUrl() + "'" +
            ", sellingTime='" + getSellingTime() + "'" +
            ", attributes='" + getAttributes() + "'" +
            ", backCategoryId=" + getBackCategoryId() +
            ", minPurchaseQuantity=" + getMinPurchaseQuantity() +
            ", unit='" + getUnit() + "'" +
            ", setMeal=" + getSetMeal() +
            "}";
    }

    public Long getMasterUserId() {
        return masterUserId;
    }

    public void setMasterUserId(Long masterUserId) {
        this.masterUserId = masterUserId;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }
}
