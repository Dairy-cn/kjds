package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.time.Instant;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchants.domain.StoreInfo} entity.
 */
@ApiModel(description = "店铺信息")
public class StoreInfoDTO implements Serializable {

    private Long id;

    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    private String companyName;

    /**
     * 店铺名称
     */
    @ApiModelProperty(value = "店铺名称")
    private String storeName;

    /**
     * 店铺logo
     */
    @ApiModelProperty(value = "店铺logo")
    private String storeLogo;

    /**
     * 商户审核记录id
     */
    @ApiModelProperty(value = "商户审核记录id")
    private Long merchantsCheckInInfoId;

    /**
     * 营业状态  1 正常 0 休息中
     */
    @ApiModelProperty(value = "营业状态  1 正常 0 休息中")
    private Integer operatingStatus;

    /**
     * 关闭方  1 自己  2 平台
     */
    @ApiModelProperty(value = "关闭方  1 自己  2 平台")
    private Integer closeOfParty;

    /**
     * 关闭原因
     */
    @ApiModelProperty(value = "关闭原因")
    private String closeReason;

    /**
     * 关闭时间
     */
    @ApiModelProperty(value = "关闭时间")
    private Instant closeTime;

    /**
     * 开启时间
     */
    @ApiModelProperty(value = "开启时间")
    private Instant openTime;

    /**
     * 关闭人id
     */
    @ApiModelProperty(value = "关闭人id")
    private Long closeOfWho;

    /**
     * 开启人id
     */
    @ApiModelProperty(value = "开启人id")
    private Long openOfWho;

    /**
     * 主营类目
     */
    @ApiModelProperty(value = "主营类目")
    private Long categoryId;



    /**
     * 创建人id
     */
    @ApiModelProperty(value = "创建人id")
    private Long createUserId;

    @ApiModelProperty(value = "商户审核信息")
    private MerchantsCheckInInfoDTO merchantsCheckInInfoDTO;

    @ApiModelProperty(value = "商户类目信息",hidden = true)
    private MerchantsCategoryDTO merchantsCategoryDTO;


    public MerchantsCategoryDTO getMerchantsCategoryDTO() {
        return merchantsCategoryDTO;
    }

    public void setMerchantsCategoryDTO(MerchantsCategoryDTO merchantsCategoryDTO) {
        this.merchantsCategoryDTO = merchantsCategoryDTO;
    }

    public MerchantsCheckInInfoDTO getMerchantsCheckInInfoDTO() {
        return merchantsCheckInInfoDTO;
    }

    public void setMerchantsCheckInInfoDTO(MerchantsCheckInInfoDTO merchantsCheckInInfoDTO) {
        this.merchantsCheckInInfoDTO = merchantsCheckInInfoDTO;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(String storeLogo) {
        this.storeLogo = storeLogo;
    }

    public Long getMerchantsCheckInInfoId() {
        return merchantsCheckInInfoId;
    }

    public void setMerchantsCheckInInfoId(Long merchantsCheckInInfoId) {
        this.merchantsCheckInInfoId = merchantsCheckInInfoId;
    }

    public Integer getOperatingStatus() {
        return operatingStatus;
    }

    public void setOperatingStatus(Integer operatingStatus) {
        this.operatingStatus = operatingStatus;
    }

    public Integer getCloseOfParty() {
        return closeOfParty;
    }

    public void setCloseOfParty(Integer closeOfParty) {
        this.closeOfParty = closeOfParty;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    public Instant getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Instant closeTime) {
        this.closeTime = closeTime;
    }

    public Instant getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Instant openTime) {
        this.openTime = openTime;
    }

    public Long getCloseOfWho() {
        return closeOfWho;
    }

    public void setCloseOfWho(Long closeOfWho) {
        this.closeOfWho = closeOfWho;
    }

    public Long getOpenOfWho() {
        return openOfWho;
    }

    public void setOpenOfWho(Long openOfWho) {
        this.openOfWho = openOfWho;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StoreInfoDTO storeInfoDTO = (StoreInfoDTO) o;
        if (storeInfoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), storeInfoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "StoreInfoDTO{" +
            "id=" + getId() +
            ", companyName='" + getCompanyName() + "'" +
            ", storeName='" + getStoreName() + "'" +
            ", storeLogo='" + getStoreLogo() + "'" +
            ", merchantsCheckInInfoId=" + getMerchantsCheckInInfoId() +
            ", operatingStatus=" + getOperatingStatus() +
            ", closeOfParty=" + getCloseOfParty() +
            ", closeReason='" + getCloseReason() + "'" +
            ", closeTime='" + getCloseTime() + "'" +
            ", openTime='" + getOpenTime() + "'" +
            ", closeOfWho=" + getCloseOfWho() +
            ", openOfWho=" + getOpenOfWho() +
            ", categoryId=" + getCategoryId() +
            "}";
    }
}
