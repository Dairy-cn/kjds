package com.cross.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A DTO for the DistributorOrderCommission entity.
 */
public class DistributorOrderCommissionDTO implements Serializable {
    
    
    private static final long serialVersionUID = -7937579549535490091L;
    
    private Long id;
    
    private Long brandId;
    
    
    /**
     * 平台id
     */
    private Long merchantId;
    
    private Long platformId;
    
    private String orderSn;
    
    private BigDecimal commission;
    
    /**
     * 是否是通吃岛
     */
    private Boolean isTcd;
    
    /**
     * 结算状态
     */
    private Boolean status;
    
    /**
     * 通吃岛收益
     */
    private BigDecimal platformProfit;
    
    /**
     * 商户累计支出
     */
    private BigDecimal platformTotalSpending;
    /**
     * 入住前平台id
     */
    private Long oldPlatformId;
    
    
    private ShopOrderDTO shopOrderDTO;
    
    /**
     * 修改时间
     */
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant changeTime;
    
    
    
    @ApiModelProperty(value = "退款标识")
    private Boolean refunsFlag;
    
    
    public Boolean getRefunsFlag() {
        return refunsFlag;
    }
    
    public void setRefunsFlag(Boolean refunsFlag) {
        this.refunsFlag = refunsFlag;
    }
    
    public Instant getChangeTime() {
        return changeTime;
    }
    
    public void setChangeTime(Instant changeTime) {
        this.changeTime = changeTime;
    }
    
    public ShopOrderDTO getShopOrderDTO() {
        return shopOrderDTO;
    }
    
    public void setShopOrderDTO(ShopOrderDTO shopOrderDTO) {
        this.shopOrderDTO = shopOrderDTO;
    }
    
    public Long getOldPlatformId() {
        return oldPlatformId;
    }
    
    public void setOldPlatformId(Long oldPlatformId) {
        this.oldPlatformId = oldPlatformId;
    }
    
    public Boolean getStatus() {
        return status;
    }
    public Boolean isStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    public BigDecimal getPlatformTotalSpending() {
        return platformTotalSpending;
    }
    
    public void setPlatformTotalSpending(BigDecimal platformTotalSpending) {
        this.platformTotalSpending = platformTotalSpending;
    }
    
    public BigDecimal getPlatformProfit() {
        return platformProfit;
    }
    
    public void setPlatformProfit(BigDecimal platformProfit) {
        this.platformProfit = platformProfit;
    }
    
    public Boolean getTcd() {
        return isTcd;
    }
    public Boolean isTcd() {
        return isTcd;
    }
    public void setTcd(Boolean tcd) {
        isTcd = tcd;
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
    
    public Long getMerchantId() {
        return merchantId;
    }
    
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }
    
    public Long getPlatformId() {
        return platformId;
    }
    
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }
    
    public String getOrderSn() {
        return orderSn;
    }
    
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }
    
    public BigDecimal getCommission() {
        return commission;
    }
    
    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        DistributorOrderCommissionDTO that = (DistributorOrderCommissionDTO) o;
        
        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        if (brandId != null ? !brandId.equals(that.brandId) : that.brandId != null) {
            return false;
        }
        if (merchantId != null ? !merchantId.equals(that.merchantId) : that.merchantId != null) {
            return false;
        }
        if (platformId != null ? !platformId.equals(that.platformId) : that.platformId != null) {
            return false;
        }
        if (orderSn != null ? !orderSn.equals(that.orderSn) : that.orderSn != null) {
            return false;
        }
        return commission != null ? commission.equals(that.commission) : that.commission == null;
        
    }
    
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (brandId != null ? brandId.hashCode() : 0);
        result = 31 * result + (merchantId != null ? merchantId.hashCode() : 0);
        result = 31 * result + (platformId != null ? platformId.hashCode() : 0);
        result = 31 * result + (orderSn != null ? orderSn.hashCode() : 0);
        result = 31 * result + (commission != null ? commission.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "DistributorOrderCommissionDTO{" +
            "id=" + id +
            ", brandId=" + brandId +
            ", merchantId=" + merchantId +
            ", platformId=" + platformId +
            ", orderSn='" + orderSn + '\'' +
            ", commission=" + commission +
            '}';
    }
}
