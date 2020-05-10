package com.cross.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the DistributorMerchant entity.
 */
@ApiModel(description = "分销门店")
public class DistributorMerchantDTO implements Serializable {

    private Long id;

    /**
     * 平台id
     */
    @ApiModelProperty(value = "平台id")
    private Long platformId;

    /**
     * 品牌id
     */
    @ApiModelProperty(value = "品牌id")
    private Long brandId;

    /**
     * 门店id
     */
    @ApiModelProperty(value = "门店id")
    private Long merchantId;

    /**
     * 是否开启分销
     */
    @ApiModelProperty(value = "是否开启分销 true:开启")
    private Boolean openDistribution;

    /**
     * 分销类别设置
     */
    @ApiModelProperty(value = "分销类别设置")
    private List<DistributorTypeDetails> distributorMerchantDetail;

    @ApiModelProperty(value = "创建时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant createTime;

    @ApiModelProperty(value = "门店logo")
    private String logo;
    
    
    /**
     * 分销者的分销比例
     */
    @ApiModelProperty(value = "分销者的分销比例")
    private Double distributorProportion;
    /**
     * 一级分销比例
     */
    @ApiModelProperty(value = "分销者的分销比例")
    private Double oneLevelProportion;
    /**
     * 二级分销比例
     */
    @ApiModelProperty(value = "分销者的分销比例")
    private Double twoLevelProportion;
    
    
    @ApiModelProperty("分享海报")
    private String distributorPoster;
    
    
    @ApiModelProperty("分享话术")
    private String distributorWords;
    
    @ApiModelProperty("显示金额")
    private Double displayMoney;

   /* @ApiModelProperty("是否删除 true：未删除 false：已删除")
    private Boolean state;*/
    
    
    public String getDistributorWords() {
        return distributorWords;
    }
    
    public void setDistributorWords(String distributorWords) {
        this.distributorWords = distributorWords;
    }
    
    public Double getDisplayMoney() {
        return displayMoney;
    }
    
    public void setDisplayMoney(Double displayMoney) {
        this.displayMoney = displayMoney;
    }
    
    public String getDistributorPoster() {
        return distributorPoster;
    }
    
    public void setDistributorPoster(String distributorPoster) {
        this.distributorPoster = distributorPoster;
    }
    
    public Double getDistributorProportion() {
        return distributorProportion;
    }
    
    public void setDistributorProportion(Double distributorProportion) {
        this.distributorProportion = distributorProportion;
    }
    
    public Double getOneLevelProportion() {
        return oneLevelProportion;
    }
    
    public void setOneLevelProportion(Double oneLevelProportion) {
        this.oneLevelProportion = oneLevelProportion;
    }
    
    public Double getTwoLevelProportion() {
        return twoLevelProportion;
    }
    
    public void setTwoLevelProportion(Double twoLevelProportion) {
        this.twoLevelProportion = twoLevelProportion;
    }
    
    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public List<DistributorTypeDetails> getDistributorMerchantDetail() {
        return distributorMerchantDetail;
    }

    public void setDistributorMerchantDetail(List<DistributorTypeDetails> distributorMerchantDetail) {
        this.distributorMerchantDetail = distributorMerchantDetail;
    }

    public Boolean getOpenDistribution() {
        return openDistribution;
    }

    public void setOpenDistribution(Boolean openDistribution) {
        this.openDistribution = openDistribution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DistributorMerchantDTO distributorMerchantDTO = (DistributorMerchantDTO) o;
        if (distributorMerchantDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), distributorMerchantDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DistributorMerchantDTO{" +
            "id=" + getId() +
            ", platformId=" + getPlatformId() +
            ", brandId=" + getBrandId() +
            ", merchantId=" + getMerchantId() +
            ", distributorMerchantDetail='" + getDistributorMerchantDetail() + "'" +
            "}";
    }
}
