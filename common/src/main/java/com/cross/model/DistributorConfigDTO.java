package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the DistributorConfig entity.
 */
@Data
public class DistributorConfigDTO implements Serializable {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("品牌id")
    private Long brandId;


    @ApiModelProperty("供应商用户编号")
    private Long supplierId;

    @NotNull(message = "平台id不能为空")
    @ApiModelProperty("平台id")
    private Long platformId;

    @NotNull
    @ApiModelProperty(value = "供应获利类型", required = true)
    private SupplierType supplierType;

    @ApiModelProperty(value = "供应获利配置")
    private SupplierRateVM supplierRates;

    @ApiModelProperty(value = "成为分销商的条件类型    BUY, CHARGE, CONSUM, FREE")
    private DistributorType distributorType = DistributorType.BUY;

    @ApiModelProperty(value = "成为分销商的条件")
    private DistributorRuleVM distributorRules;

    @Size(max = 1000)
    @ApiModelProperty(value = "海报模版")
    private String poster;

    @Size(max = 64)
    @ApiModelProperty(value = "自主微信编号")
    private String wxAppId;

    @Size(max = 64)
    @ApiModelProperty(value = "自主微信KEY")
    private String wxAppKey;

    @Size(max = 64)
    @ApiModelProperty(value = "自主微信密钥")
    private String wxAppSecret;

    @ApiModelProperty(value = "到期日期")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant expiresDate;

    @ApiModelProperty(value = "更新日期")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant updateDate;


    @ApiModelProperty(value = "状态 0关闭 1开启")
    private Boolean state;


    @ApiModelProperty(value = "合伙人收益发放方式 合伙人收益发放方式：null或者1：合伙人主动提现（需要商户审核） 2.系统通过微信发放（无需审核，即时到账）")
    private Integer rewardSendType;

    /**
     * 海报宣传语
     */
    @ApiModelProperty("海报宣传语")
    private String imageSlogan;

    /**
     * 宣传海报
     */

    @ApiModelProperty("宣传海报")
    private String imageUrl;

    /**
     * 平台信息
     */
    @ApiModelProperty(value = "平台信息",hidden = true)
    private SystemSettingDTO systemSettingDTO;


    @ApiModelProperty(value = "分销商品供应获利配置")
    private SupplierRateVM shopSupplierRates;

    @ApiModelProperty(value = "分销门店供应获利配置")
    private SupplierRateVM merchantSupplierRates;

    @ApiModelProperty(value = "分销品牌供应获利配置")
    private SupplierRateVM brandSupplierRates;

    public String getImageSlogan() {
        return imageSlogan;
    }

    public void setImageSlogan(String imageSlogan) {
        this.imageSlogan = imageSlogan;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getRewardSendType() {
        return rewardSendType;
    }

    public void setRewardSendType(Integer rewardSendType) {
        this.rewardSendType = rewardSendType;
    }

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

    public SupplierType getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(SupplierType supplierType) {
        this.supplierType = supplierType;
    }

    public SupplierRateVM getSupplierRates() {
        return supplierRates;
    }

    public void setSupplierRates(SupplierRateVM supplierRates) {
        this.supplierRates = supplierRates;
    }

    public DistributorType getDistributorType() {
        return distributorType;
    }

    public void setDistributorType(DistributorType distributorType) {
        this.distributorType = distributorType;
    }

    public DistributorRuleVM getDistributorRules() {
        return distributorRules;
    }

    public void setDistributorRules(DistributorRuleVM distributorRules) {
        this.distributorRules = distributorRules;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getWxAppId() {
        return wxAppId;
    }

    public void setWxAppId(String wxAppId) {
        this.wxAppId = wxAppId;
    }

    public String getWxAppKey() {
        return wxAppKey;
    }

    public void setWxAppKey(String wxAppKey) {
        this.wxAppKey = wxAppKey;
    }

    public String getWxAppSecret() {
        return wxAppSecret;
    }

    public void setWxAppSecret(String wxAppSecret) {
        this.wxAppSecret = wxAppSecret;
    }

    public Instant getExpiresDate() {
        return expiresDate;
    }

    public void setExpiresDate(Instant expiresDate) {
        this.expiresDate = expiresDate;
    }

    public Instant getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Instant updateDate) {
        this.updateDate = updateDate;
    }

    public SystemSettingDTO getSystemSettingDTO() {
        return systemSettingDTO;
    }

    public void setSystemSettingDTO(SystemSettingDTO systemSettingDTO) {
        this.systemSettingDTO = systemSettingDTO;
    }

    public SupplierRateVM getShopSupplierRates() {
        return shopSupplierRates;
    }

    public void setShopSupplierRates(SupplierRateVM shopSupplierRates) {
        this.shopSupplierRates = shopSupplierRates;
    }

    public SupplierRateVM getMerchantSupplierRates() {
        return merchantSupplierRates;
    }

    public void setMerchantSupplierRates(SupplierRateVM merchantSupplierRates) {
        this.merchantSupplierRates = merchantSupplierRates;
    }

    public SupplierRateVM getBrandSupplierRates() {
        return brandSupplierRates;
    }

    public void setBrandSupplierRates(SupplierRateVM brandSupplierRates) {
        this.brandSupplierRates = brandSupplierRates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DistributorConfigDTO distributorConfigDTO = (DistributorConfigDTO) o;
        if(distributorConfigDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), distributorConfigDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DistributorConfigDTO{" +
            "id=" + id +
            ", brandId=" + brandId +
            ", supplierId=" + supplierId +
            ", platformId=" + platformId +
            ", supplierType=" + supplierType +
            ", supplierRates=" + supplierRates +
            ", distributorType=" + distributorType +
            ", distributorRules=" + distributorRules +
            ", poster='" + poster + '\'' +
            ", wxAppId='" + wxAppId + '\'' +
            ", wxAppKey='" + wxAppKey + '\'' +
            ", wxAppSecret='" + wxAppSecret + '\'' +
            ", expiresDate=" + expiresDate +
            ", updateDate=" + updateDate +
            ", state=" + state +
            ", rewardSendType=" + rewardSendType +
            ", imageSlogan='" + imageSlogan + '\'' +
            ", imageUrl='" + imageUrl + '\'' +
            ", systemSettingDTO=" + systemSettingDTO +
            ", shopSupplierRates=" + shopSupplierRates +
            ", merchantSupplierRates=" + merchantSupplierRates +
            ", brandSupplierRates=" + brandSupplierRates +
            '}';
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }
}
