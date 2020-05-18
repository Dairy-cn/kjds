package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.time.Instant;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchants.domain.StoreOperatingRecord} entity.
 */
@ApiModel(description = "店铺开关闭信息记录")
public class StoreOperatingRecordDTO implements Serializable {

    private Long id;

    /**
     * 店铺Id
     */
    @ApiModelProperty(value = "店铺Id")
    private Long storeId;

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
     * 营业状态  1 正常 0 休息中
     */
    @ApiModelProperty(value = "营业状态  1 正常 0 休息中")
    private Integer operatingStatus;


    public Integer getOperatingStatus() {
        return operatingStatus;
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

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StoreOperatingRecordDTO storeOperatingRecordDTO = (StoreOperatingRecordDTO) o;
        if (storeOperatingRecordDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), storeOperatingRecordDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "StoreOperatingRecordDTO{" +
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
