package com.cross.merchants.domain;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.Instant;

/**
 * 店铺信息
 */
@Entity
@Table(name = "store_info")
public class StoreInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 公司名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 店铺名称
     */
    @Column(name = "store_name")
    private String storeName;

    /**
     * 店铺logo
     */
    @Column(name = "store_logo")
    private String storeLogo;

    /**
     * 商户审核记录id
     */
    @Column(name = "merchants_check_in_info_id")
    private Long merchantsCheckInInfoId;

    /**
     * 营业状态  1 正常 0 休息中
     */
    @Column(name = "operating_status")
    private Integer operatingStatus;

    /**
     * 关闭方  1 自己  2 平台
     */
    @Column(name = "close_of_party")
    private Integer closeOfParty;

    /**
     * 关闭原因
     */
    @Column(name = "close_reason")
    private String closeReason;

    /**
     * 关闭时间
     */
    @Column(name = "close_time")
    private Instant closeTime;

    /**
     * 开启时间
     */
    @Column(name = "open_time")
    private Instant openTime;

    /**
     * 关闭人id
     */
    @Column(name = "close_of_who")
    private Long closeOfWho;

    /**
     * 开启人id
     */
    @Column(name = "open_of_who")
    private Long openOfWho;

    /**
     * 主营类目
     */
    @Column(name = "category_id")
    private Long categoryId;

    /**
     * 创建人id
     */
    @Column(name = "create_user_id")
    private Long createUserId;


    /**
     * 创建时间
     */
    @Column(name = "create_ime")
    private Instant creatTime;

    /**
     * 店铺编号
     */
    @ApiModelProperty(value = "店铺编号")
    @Column(name = "store_no")
    private String storeNo;

    /**
     * 注册账号
     */
    @Column(name = "register_user_name")
    private String registerUserName;
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove


    public String getRegisterUserName() {
        return registerUserName;
    }
    public StoreInfo registerUserName(String registerUserName) {
        this.registerUserName = registerUserName;
        return this;
    }
    public void setRegisterUserName(String registerUserName) {
        this.registerUserName = registerUserName;
    }

    public String getStoreNo() {
        return storeNo;
    }
    public StoreInfo storeNo(String storeNo) {
        this.storeNo = storeNo;
        return this;
    }
    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    public Instant getCreatTime() {
        return creatTime;
    }
    public StoreInfo creatTime(Instant creatTime) {
        this.creatTime = creatTime;
        return this;
    }
    public void setCreatTime(Instant creatTime) {
        this.creatTime = creatTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }
    public StoreInfo createUserId(Long createUserId) {
        this.createUserId = createUserId;
        return this;
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

    public StoreInfo companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStoreName() {
        return storeName;
    }

    public StoreInfo storeName(String storeName) {
        this.storeName = storeName;
        return this;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreLogo() {
        return storeLogo;
    }

    public StoreInfo storeLogo(String storeLogo) {
        this.storeLogo = storeLogo;
        return this;
    }

    public void setStoreLogo(String storeLogo) {
        this.storeLogo = storeLogo;
    }

    public Long getMerchantsCheckInInfoId() {
        return merchantsCheckInInfoId;
    }

    public StoreInfo merchantsCheckInInfoId(Long merchantsCheckInInfoId) {
        this.merchantsCheckInInfoId = merchantsCheckInInfoId;
        return this;
    }

    public void setMerchantsCheckInInfoId(Long merchantsCheckInInfoId) {
        this.merchantsCheckInInfoId = merchantsCheckInInfoId;
    }

    public Integer getOperatingStatus() {
        return operatingStatus;
    }

    public StoreInfo operatingStatus(Integer operatingStatus) {
        this.operatingStatus = operatingStatus;
        return this;
    }

    public void setOperatingStatus(Integer operatingStatus) {
        this.operatingStatus = operatingStatus;
    }

    public Integer getCloseOfParty() {
        return closeOfParty;
    }

    public StoreInfo closeOfParty(Integer closeOfParty) {
        this.closeOfParty = closeOfParty;
        return this;
    }

    public void setCloseOfParty(Integer closeOfParty) {
        this.closeOfParty = closeOfParty;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public StoreInfo closeReason(String closeReason) {
        this.closeReason = closeReason;
        return this;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    public Instant getCloseTime() {
        return closeTime;
    }

    public StoreInfo closeTime(Instant closeTime) {
        this.closeTime = closeTime;
        return this;
    }

    public void setCloseTime(Instant closeTime) {
        this.closeTime = closeTime;
    }

    public Instant getOpenTime() {
        return openTime;
    }

    public StoreInfo openTime(Instant openTime) {
        this.openTime = openTime;
        return this;
    }

    public void setOpenTime(Instant openTime) {
        this.openTime = openTime;
    }

    public Long getCloseOfWho() {
        return closeOfWho;
    }

    public StoreInfo closeOfWho(Long closeOfWho) {
        this.closeOfWho = closeOfWho;
        return this;
    }

    public void setCloseOfWho(Long closeOfWho) {
        this.closeOfWho = closeOfWho;
    }

    public Long getOpenOfWho() {
        return openOfWho;
    }

    public StoreInfo openOfWho(Long openOfWho) {
        this.openOfWho = openOfWho;
        return this;
    }

    public void setOpenOfWho(Long openOfWho) {
        this.openOfWho = openOfWho;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public StoreInfo categoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StoreInfo)) {
            return false;
        }
        return id != null && id.equals(((StoreInfo) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "StoreInfo{" +
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
