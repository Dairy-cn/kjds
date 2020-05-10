package com.cross.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the DistributorMerchantConfig entity.
 */
public class DistributorMerchantConfigVM implements Serializable {

    private Long id;

    private Long brandId;

    private Long supplierId;

    private Long merchantId;

    private Integer customPrivilege;

    private Boolean enableDistributor;

    private Boolean enableMerchantRule;

    private List<Long> foods;

    /**
     * 海报
     */
    @Size(max = 2000)
    private String posts;

    /**
     * 分享图片
     */
    @Size(max = 2000)
    private String pushImages;

    /**
     * 分享标题
     */
    @Size(max = 2000)
    private String pushTitle;

    /**
     * 分享概要
     */
    @Size(max = 2000)
    private String pushBrief;

    /**
     * 允许分销商改变
     */
    private Boolean allowChange;
    
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

    public Integer getCustomPrivilege() {
        return customPrivilege;
    }

    public void setCustomPrivilege(Integer customPrivilege) {
        this.customPrivilege = customPrivilege;
    }

    public Boolean isEnableDistributor() {
        return enableDistributor;
    }

    public void setEnableDistributor(Boolean enableDistributor) {
        this.enableDistributor = enableDistributor;
    }

    public Boolean isEnableMerchantRule() {
        return enableMerchantRule;
    }

    public void setEnableMerchantRule(Boolean enableMerchantRule) {
        this.enableMerchantRule = enableMerchantRule;
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

        DistributorMerchantConfigVM distributorMerchantConfigDTO = (DistributorMerchantConfigVM) o;
        if (distributorMerchantConfigDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), distributorMerchantConfigDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DistributorMerchantConfigVM{" +
            "id=" + getId() +
            ", brandId=" + getBrandId() +
            ", supplierId=" + getSupplierId() +
            ", merchantId=" + getMerchantId() +
            ", customPrivilege=" + getCustomPrivilege() +
            ", enableDistributor='" + isEnableDistributor() + "'" +
            ", enableMerchantRule='" + isEnableMerchantRule() + "'" +
            ", addDate='" + getAddDate() + "'" +
            "}";
    }

    public List<Long> getFoods() {
        return foods;
    }

    public void setFoods(List<Long> foods) {
        this.foods = foods;
    }

    public String getPosts() {
        return posts;
    }

    public void setPosts(String posts) {
        this.posts = posts;
    }

    public String getPushImages() {
        return pushImages;
    }

    public void setPushImages(String pushImages) {
        this.pushImages = pushImages;
    }

    public String getPushTitle() {
        return pushTitle;
    }

    public void setPushTitle(String pushTitle) {
        this.pushTitle = pushTitle;
    }

    public String getPushBrief() {
        return pushBrief;
    }

    public void setPushBrief(String pushBrief) {
        this.pushBrief = pushBrief;
    }

    public Boolean getAllowChange() {
        return allowChange;
    }

    public void setAllowChange(Boolean allowChange) {
        this.allowChange = allowChange;
    }
}
