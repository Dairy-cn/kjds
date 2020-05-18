package com.cross.merchants.domain;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;
import java.time.Instant;

/**
 * 店铺品牌信息
 */
@Entity
@Table(name = "brand")
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 品牌名称
     */
    @Column(name = "brand_name")
    private String brandName;

    /**
     * 副品牌名称
     */
    @Column(name = "brand_name_second")
    private String brandNameSecond;

    /**
     * 品牌国家地区id
     */
    @Column(name = "brand_country_id")
    private Long brandCountryId;

    /**
     * logo
     */
    @Column(name = "brand_logo")
    private String brandLogo;

    /**
     * 商标注册证
     */
    @Column(name = "trade_mark_registration_pic",length = 2000)
    private String tradeMarkRegistrationPic;

    /**
     * 资质有效期开始时间
     */
    @ApiModelProperty(value = "资质有效期开始时间 yyyy-mm-dd")
    @Column(name = "certificate_valid_start_time")
    private String certificateValidStartTime;

    /**
     * 资质有效期结束时间
     */
    @ApiModelProperty(value = "资质有效期结束时间 yyyy-mm-dd")
    @Column(name = "certificate_valid_end_time")
    private String certificateValidEndTime;
    /**
     * 品牌描述
     */
    @Column(name = "brand_desc")
    private String brandDesc;

    /**
     * 品牌授权类型  0 品牌方 1 一级代理 2 二级代理 3  三级代理
     */
    @Column(name = "brand_auth_type")
    private Integer brandAuthType;

    /**
     * 授权书信息
     */
    @Column(name = "ower_of_attorney")
    private String owerOfAttorney;

    /**
     * 审核状态 -1 未审核 0 未通过  1 通过
     */
    @Column(name = "check_status")
    private Integer checkStatus;

    /**
     * 审核失败原因
     */
    @Column(name = "check_failure_reasons")
    private String checkFailureReasons;

    /**
     * 审核时间
     */
    @Column(name = "check_time")
    private Instant checkTime;


    @ApiModelProperty(value = "店铺id")
    @Column(name = "store_id")
    @NotNull(message = "店铺id不能为空")
    private Long storeId;


    /**
     * 申请人
     */
    @ApiModelProperty(value = "申请人")
    @Column(name = "proposer")
    private Long proposer;

    /**
     * 申请时间
     */
    @ApiModelProperty(value = "申请时间")
    @Column(name = "application_time")
    private Instant applicationTime;
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove


    public Long getProposer() {
        return proposer;
    }

    public void setProposer(Long proposer) {
        this.proposer = proposer;
    }

    public Instant getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Instant applicationTime) {
        this.applicationTime = applicationTime;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public Brand brandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandNameSecond() {
        return brandNameSecond;
    }

    public Brand brandNameSecond(String brandNameSecond) {
        this.brandNameSecond = brandNameSecond;
        return this;
    }

    public void setBrandNameSecond(String brandNameSecond) {
        this.brandNameSecond = brandNameSecond;
    }

    public Long getBrandCountryId() {
        return brandCountryId;
    }

    public Brand brandCountryId(Long brandCountryId) {
        this.brandCountryId = brandCountryId;
        return this;
    }

    public void setBrandCountryId(Long brandCountryId) {
        this.brandCountryId = brandCountryId;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public Brand brandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
        return this;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public String getTradeMarkRegistrationPic() {
        return tradeMarkRegistrationPic;
    }

    public Brand tradeMarkRegistrationPic(String tradeMarkRegistrationPic) {
        this.tradeMarkRegistrationPic = tradeMarkRegistrationPic;
        return this;
    }

    public void setTradeMarkRegistrationPic(String tradeMarkRegistrationPic) {
        this.tradeMarkRegistrationPic = tradeMarkRegistrationPic;
    }

    public String getCertificateValidStartTime() {
        return certificateValidStartTime;
    }

    public void setCertificateValidStartTime(String certificateValidStartTime) {
        this.certificateValidStartTime = certificateValidStartTime;
    }

    public String getCertificateValidEndTime() {
        return certificateValidEndTime;
    }

    public void setCertificateValidEndTime(String certificateValidEndTime) {
        this.certificateValidEndTime = certificateValidEndTime;
    }

    public String getBrandDesc() {
        return brandDesc;
    }

    public Brand brandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
        return this;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
    }

    public Integer getBrandAuthType() {
        return brandAuthType;
    }

    public Brand brandAuthType(Integer brandAuthType) {
        this.brandAuthType = brandAuthType;
        return this;
    }

    public void setBrandAuthType(Integer brandAuthType) {
        this.brandAuthType = brandAuthType;
    }

    public String getOwerOfAttorney() {
        return owerOfAttorney;
    }

    public Brand owerOfAttorney(String owerOfAttorney) {
        this.owerOfAttorney = owerOfAttorney;
        return this;
    }

    public void setOwerOfAttorney(String owerOfAttorney) {
        this.owerOfAttorney = owerOfAttorney;
    }


    public Brand checkStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
        return this;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getCheckFailureReasons() {
        return checkFailureReasons;
    }

    public Brand checkFailureReasons(String checkFailureReasons) {
        this.checkFailureReasons = checkFailureReasons;
        return this;
    }

    public void setCheckFailureReasons(String checkFailureReasons) {
        this.checkFailureReasons = checkFailureReasons;
    }

    public Instant getCheckTime() {
        return checkTime;
    }

    public Brand checkTime(Instant checkTime) {
        this.checkTime = checkTime;
        return this;
    }

    public void setCheckTime(Instant checkTime) {
        this.checkTime = checkTime;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Brand)) {
            return false;
        }
        return id != null && id.equals(((Brand) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Brand{" +
            "id=" + id +
            ", brandName='" + brandName + '\'' +
            ", brandNameSecond='" + brandNameSecond + '\'' +
            ", brandCountryId=" + brandCountryId +
            ", brandLogo='" + brandLogo + '\'' +
            ", tradeMarkRegistrationPic='" + tradeMarkRegistrationPic + '\'' +
            ", certificateValidStartTime='" + certificateValidStartTime + '\'' +
            ", certificateValidEndTime='" + certificateValidEndTime + '\'' +
            ", brandDesc='" + brandDesc + '\'' +
            ", brandAuthType=" + brandAuthType +
            ", owerOfAttorney='" + owerOfAttorney + '\'' +
            ", checkStatus=" + checkStatus +
            ", checkFailureReasons='" + checkFailureReasons + '\'' +
            ", checkTime=" + checkTime +
            ", storeId=" + storeId +
            ", proposer=" + proposer +
            ", applicationTime=" + applicationTime +
            '}';
    }
}
