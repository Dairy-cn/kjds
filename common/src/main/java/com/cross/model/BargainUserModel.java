package com.cross.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.enumtype.BargainUserStateEnum;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;

import java.io.Serializable;
import java.time.Instant;


/**
 * A DTO for the BargainUser entity.
 */
public class BargainUserModel implements Serializable {

    private Long id;

    private Long bargainId;

    private Long userId;

    private BargainUserStateEnum state;

    private Integer helpNun = 0;

    private Double bargainPrice = 0d;

    private String orderSn;
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant addDate;
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant lastChangeDate;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 平台id
     */
    private Long platformId;
    /**
     * 活动结束时间
     */
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant endDate;

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBargainId() {
        return bargainId;
    }

    public void setBargainId(Long bargainId) {
        this.bargainId = bargainId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BargainUserStateEnum getState() {
        return state;
    }

    public void setState(BargainUserStateEnum state) {
        this.state = state;
    }

    public Integer getHelpNun() {
        return helpNun;
    }

    public void setHelpNun(Integer helpNun) {
        this.helpNun = helpNun;
    }

    public Double getBargainPrice() {
        return bargainPrice;
    }

    public void setBargainPrice(Double bargainPrice) {
        this.bargainPrice = bargainPrice;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Instant getAddDate() {
        return addDate;
    }

    public void setAddDate(Instant addDate) {
        this.addDate = addDate;
    }

    public Instant getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Instant lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BargainUserModel that = (BargainUserModel) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BargainUserDTO{" +
            "id=" + getId() +
            ", bargainId=" + getBargainId() +
            ", userId=" + getUserId() +
            ", state='" + getState() + "'" +
            ", helpNun=" + getHelpNun() +
            ", bargainPrice=" + getBargainPrice() +
            ", orderSn=" + getOrderSn() +
            ", addDate='" + getAddDate() + "'" +
            ", lastChangeDate='" + getLastChangeDate() + "'" +
            "}";
    }
}
