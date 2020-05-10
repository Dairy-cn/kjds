package com.cross.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the ShopSales entity.
 */
public class ShopSalesModel implements Serializable {

    private Long id;

    private Long merchantId;

    private Long brandId;

    private String shopName;

    private Integer salesVolume;

    private Float sellFee;

    private Long specId;
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant addDate;
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant createdAt;

    private String channel;

    private Float price;

    private Long userId;

    private Long volume;

    private Long count;

    private Long commonOrderId;

    public ShopSalesModel() {

    }

    public ShopSalesModel(Long volume, Double sellFee, Long count) {
        this.volume = null != volume ? volume : 0L;
        this.sellFee = null != sellFee ? sellFee.floatValue() : 0F;
        this.count = null != count ? count : 0L;
    }

    public ShopSalesModel(String shopName, Float price, Long salesVolume, Double sellFee, Long count) {
        this.shopName = shopName;
        this.price = null != price ? price : 0f;
        this.salesVolume = null != salesVolume ? salesVolume.intValue() : 0;
        this.sellFee = null != sellFee ? sellFee.floatValue() : 0f;
        this.count = null != count ? count : 0L;
    }

    public ShopSalesModel(Long salesVolume) {
        this.salesVolume = null != salesVolume ? salesVolume.intValue() : 0;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCommonOrderId() {
        return commonOrderId;
    }

    public void setCommonOrderId(Long commonOrderId) {
        this.commonOrderId = commonOrderId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    public Float getSellFee() {
        return sellFee;
    }

    public void setSellFee(Float sellFee) {
        this.sellFee = sellFee;
    }

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public Instant getAddDate() {
        return addDate;
    }

    public void setAddDate(Instant addDate) {
        this.addDate = addDate;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopSalesModel that = (ShopSalesModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (volume != null ? !volume.equals(that.volume) : that.volume != null) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        return commonOrderId != null ? commonOrderId.equals(that.commonOrderId) : that.commonOrderId == null;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ShopSalesDTO{" +
            "id=" + id +
            ", merchantId=" + merchantId +
            ", brandId=" + brandId +
            ", shopName='" + shopName + '\'' +
            ", salesVolume=" + salesVolume +
            ", sellFee=" + sellFee +
            ", specId=" + specId +
            ", addDate=" + addDate +
            ", createdAt=" + createdAt +
            ", channel='" + channel + '\'' +
            ", price=" + price +
            ", userId=" + userId +
            ", volume=" + volume +
            ", count=" + count +
            ", commonOrderId=" + commonOrderId +
            '}';
    }
}
