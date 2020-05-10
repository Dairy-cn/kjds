package com.cross.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the DistributorMerchantShop entity.
 */
public class DistributorMerchantShopVM implements Serializable {

    private Long id;

    private Long brandId;

    private Long supplierId;

    private Long merchantId;

    private Long goodsId;

    private Boolean enableMerchantRule;

    private Double allowChange;

    @Size(max = 255)
    private String shareName;

    @Size(max = 500)
    private String shareImages;

    @Size(max = 255)
    private String shareBrief;

    @Size(max = 500)
    private String posts;
    
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant addDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Boolean isEnableMerchantRule() {
        return enableMerchantRule;
    }

    public void setEnableMerchantRule(Boolean enableMerchantRule) {
        this.enableMerchantRule = enableMerchantRule;
    }

    public Double getAllowChange() {
        return allowChange;
    }

    public void setAllowChange(Double allowChange) {
        this.allowChange = allowChange;
    }

    public String getShareName() {
        return shareName;
    }

    public void setShareName(String shareName) {
        this.shareName = shareName;
    }

    public String getShareImages() {
        return shareImages;
    }

    public void setShareImages(String shareImages) {
        this.shareImages = shareImages;
    }

    public String getShareBrief() {
        return shareBrief;
    }

    public void setShareBrief(String shareBrief) {
        this.shareBrief = shareBrief;
    }

    public String getPosts() {
        return posts;
    }

    public void setPosts(String posts) {
        this.posts = posts;
    }

    public Instant getAddDate() {
        return addDate;
    }

    public void setAddDate(Instant addDate) {
        this.addDate = addDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DistributorMerchantShopVM distributorMerchantShopDTO = (DistributorMerchantShopVM) o;
        if(distributorMerchantShopDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), distributorMerchantShopDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DistributorMerchantShopVM{" +
            "id=" + getId() +
            ", brandId=" + getBrandId() +
            ", supplierId=" + getSupplierId() +
            ", merchantId=" + getMerchantId() +
            ", goodsId=" + getGoodsId() +
            ", enableMerchantRule='" + isEnableMerchantRule() + "'" +
            ", allowChange=" + getAllowChange() +
            ", shareName='" + getShareName() + "'" +
            ", shareImages='" + getShareImages() + "'" +
            ", shareBrief='" + getShareBrief() + "'" +
            ", posts='" + getPosts() + "'" +
            ", addDate='" + getAddDate() + "'" +
            "}";
    }
}
