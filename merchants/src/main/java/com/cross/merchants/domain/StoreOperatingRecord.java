package com.cross.merchants.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.Instant;

/**
 * 店铺开关闭信息记录
 */
@Entity
@Table(name = "store_operating_record")
public class StoreOperatingRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 店铺Id
     */
    @Column(name = "store_id")
    private Long storeId;

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
     * 营业状态  1 正常 0 休息中
     */
    @Column(name = "operating_status")
    private Integer operatingStatus;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove


    public Integer getOperatingStatus() {
        return operatingStatus;
    }
    public StoreOperatingRecord operatingStatus(Integer operatingStatus) {
        this.operatingStatus = operatingStatus;
        return this;
    }
    public void setOperatingStatus(Integer operatingStatus) {
        this.operatingStatus = operatingStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public StoreOperatingRecord storeId(Long storeId) {
        this.storeId = storeId;
        return this;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Integer getCloseOfParty() {
        return closeOfParty;
    }

    public StoreOperatingRecord closeOfParty(Integer closeOfParty) {
        this.closeOfParty = closeOfParty;
        return this;
    }

    public void setCloseOfParty(Integer closeOfParty) {
        this.closeOfParty = closeOfParty;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public StoreOperatingRecord closeReason(String closeReason) {
        this.closeReason = closeReason;
        return this;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    public Instant getCloseTime() {
        return closeTime;
    }

    public StoreOperatingRecord closeTime(Instant closeTime) {
        this.closeTime = closeTime;
        return this;
    }

    public void setCloseTime(Instant closeTime) {
        this.closeTime = closeTime;
    }

    public Instant getOpenTime() {
        return openTime;
    }

    public StoreOperatingRecord openTime(Instant openTime) {
        this.openTime = openTime;
        return this;
    }

    public void setOpenTime(Instant openTime) {
        this.openTime = openTime;
    }

    public Long getCloseOfWho() {
        return closeOfWho;
    }

    public StoreOperatingRecord closeOfWho(Long closeOfWho) {
        this.closeOfWho = closeOfWho;
        return this;
    }

    public void setCloseOfWho(Long closeOfWho) {
        this.closeOfWho = closeOfWho;
    }

    public Long getOpenOfWho() {
        return openOfWho;
    }

    public StoreOperatingRecord openOfWho(Long openOfWho) {
        this.openOfWho = openOfWho;
        return this;
    }

    public void setOpenOfWho(Long openOfWho) {
        this.openOfWho = openOfWho;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StoreOperatingRecord)) {
            return false;
        }
        return id != null && id.equals(((StoreOperatingRecord) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "StoreOperatingRecord{" +
            "id=" + getId() +
            ", storeId=" + getStoreId() +
            ", closeOfParty=" + getCloseOfParty() +
            ", closeReason='" + getCloseReason() + "'" +
            ", closeTime='" + getCloseTime() + "'" +
            ", openTime='" + getOpenTime() + "'" +
            ", closeOfWho=" + getCloseOfWho() +
            ", openOfWho=" + getOpenOfWho() +
            "}";
    }
}
