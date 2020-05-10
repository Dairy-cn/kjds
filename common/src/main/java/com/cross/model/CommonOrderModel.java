package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the CommonOrder entity.
 */
public class CommonOrderModel implements Serializable {

    private Long id;

    private Long masterUserId;

    private Long platformId;

    private Long merchantId;

    @Size(max = 200)
    private String address;

    @Size(max = 20)
    private String phone;
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant createdAt;
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant activeAt;

    private Double deliverFee = 0d;
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant deliverTime;

    private String description;

    @Size(max = 160)
    private String invoice;

    private Boolean book;

    private Boolean onlinePaid;

    @Size(max = 64)
    private String eleMeId;

    private Long shopId;

    @Size(max = 64)
    private String openId;

    @Size(max = 90)
    private String shopName;

    private Long userId;

    @Size(max = 60)
    private String consignee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMasterUserId() {
        return masterUserId;
    }

    public void setMasterUserId(Long masterUserId) {
        this.masterUserId = masterUserId;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getActiveAt() {
        return activeAt;
    }

    public void setActiveAt(Instant activeAt) {
        this.activeAt = activeAt;
    }

    public Double getDeliverFee() {
        return deliverFee;
    }

    public void setDeliverFee(Double deliverFee) {
        this.deliverFee = deliverFee;
    }


    public Instant getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Instant deliverTime) {
        this.deliverTime = deliverTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public Boolean getBook() {
        return book;
    }

    public void setBook(Boolean book) {
        this.book = book;
    }

    public Boolean getOnlinePaid() {
        return onlinePaid;
    }

    public void setOnlinePaid(Boolean onlinePaid) {
        this.onlinePaid = onlinePaid;
    }

    public String getEleMeId() {
        return eleMeId;
    }

    public void setEleMeId(String eleMeId) {
        this.eleMeId = eleMeId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    @Override
    public String toString() {
        return "CommonOrderModel{" +
            "id=" + id +
            ", masterUserId=" + masterUserId +
            ", platformId=" + platformId +
            ", merchantId=" + merchantId +
            ", address='" + address + '\'' +
            ", phone='" + phone + '\'' +
            ", createdAt=" + createdAt +
            ", activeAt=" + activeAt +
            ", deliverFee=" + deliverFee +
            ", deliverTime=" + deliverTime +
            ", description='" + description + '\'' +
            ", invoice='" + invoice + '\'' +
            ", book=" + book +
            ", onlinePaid=" + onlinePaid +
            ", eleMeId='" + eleMeId + '\'' +
            ", shopId=" + shopId +
            ", openId='" + openId + '\'' +
            ", shopName='" + shopName + '\'' +
            ", userId=" + userId +
            ", consignee='" + consignee + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommonOrderModel that = (CommonOrderModel) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
