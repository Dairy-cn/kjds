package com.cross.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the DistributorOrder entity.
 */
public class DistributorOrderDTO implements Serializable {

    private Long id;

    @NotNull
    private Long supplierId;
    @NotNull
    private Long platformId;

    @NotNull
    private Long brandId;

    @NotNull
    private Long merchantId;

    @NotNull
    private Long distributorUserId;

    @NotNull
    private Long orderId;

    private String orderSn;

    private Long distributorGoodsId;

    private Boolean balance;
    
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant balanceDate;
    
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant addDate;

    /**
     * 获取收益
     */
    private Double profit;

    /**
     * 实际支付
     */
    @NotNull
    private Double actualPayment;

    /**
     * 级数
     */
    private Integer level;

    /**
     * 利益贡献者编号
     */
    private Long distributorTargetUserId;

    /**
     * 分销商品模式
     */
    private Integer pattern;

    /**
     * 分销者电话
     */
    private String distributorPhone;

    /**
     * 分销者名字
     */
    private String distributorName;

    /**
     * 分销者佣金
     */
    private Double selfMoney;
    /**
     * 一级佣金
     */
    private Double oneLevelMoney;
    /**
     * 二级佣金
     */
    private Double twoLevelMoney;
    /**
     * 总佣金
     */
    private Double totalMoney;
    
    @ApiModelProperty("入住前的平台Id")
    private Long oldPlatformId;
    
    
    @ApiModelProperty("分销人")
    private Long distributorId;
    
    /**
     * 分销商品
     */
    @ApiModelProperty(value = "分销商品")
    private String distributorGoodsName;
    
    public Long getDistributorId() {
        return distributorId;
    }
    
    public void setDistributorId(Long distributorId) {
        this.distributorId = distributorId;
    }
    
    public String getDistributorGoodsName() {
        return distributorGoodsName;
    }
    
    public void setDistributorGoodsName(String distributorGoodsName) {
        this.distributorGoodsName = distributorGoodsName;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getDistributorUserId() {
        return distributorUserId;
    }

    public void setDistributorUserId(Long distributorUserId) {
        this.distributorUserId = distributorUserId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Boolean isBalance() {
        return balance;
    }

    public void setBalance(Boolean balance) {
        this.balance = balance;
    }

    public Instant getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(Instant balanceDate) {
        this.balanceDate = balanceDate;
    }

    public Instant getAddDate() {
        return addDate;
    }

    public void setAddDate(Instant addDate) {
        this.addDate = addDate;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public Boolean getBalance() {
        return balance;
    }
    
    public Long getOldPlatformId() {
        return oldPlatformId;
    }
    
    public void setOldPlatformId(Long oldPlatformId) {
        this.oldPlatformId = oldPlatformId;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DistributorOrderDTO distributorOrderDTO = (DistributorOrderDTO) o;
        if(distributorOrderDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), distributorOrderDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
    
    @Override
    public String toString() {
        return "DistributorOrderDTO{" +
            "id=" + id +
            ", supplierId=" + supplierId +
            ", platformId=" + platformId +
            ", brandId=" + brandId +
            ", merchantId=" + merchantId +
            ", distributorUserId=" + distributorUserId +
            ", orderId=" + orderId +
            ", orderSn=" + orderSn +
            ", distributorGoodsId=" + distributorGoodsId +
            ", balance=" + balance +
            ", balanceDate=" + balanceDate +
            ", addDate=" + addDate +
            ", profit=" + profit +
            ", actualPayment=" + actualPayment +
            ", level=" + level +
            ", distributorTargetUserId=" + distributorTargetUserId +
            ", pattern=" + pattern +
            ", distributorPhone='" + distributorPhone + '\'' +
            ", distributorName='" + distributorName + '\'' +
            ", selfMoney=" + selfMoney +
            ", oneLevelMoney=" + oneLevelMoney +
            ", twoLevelMoney=" + twoLevelMoney +
            ", totalMoney=" + totalMoney +
            ", oldPlatformId=" + oldPlatformId +
            '}';
    }
    
    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getActualPayment() {
        return actualPayment;
    }

    public void setActualPayment(Double actualPayment) {
        this.actualPayment = actualPayment;
    }

    public Long getDistributorTargetUserId() {
        return distributorTargetUserId;
    }

    public void setDistributorTargetUserId(Long distributorTargetUserId) {
        this.distributorTargetUserId = distributorTargetUserId;
    }

    public Long getDistributorGoodsId() {
        return distributorGoodsId;
    }

    public void setDistributorGoodsId(Long distributorGoodsId) {
        this.distributorGoodsId = distributorGoodsId;
    }

    public Integer getPattern() {
        return pattern;
    }

    public void setPattern(Integer pattern) {
        this.pattern = pattern;
    }

    public String getDistributorPhone() {
        return distributorPhone;
    }

    public void setDistributorPhone(String distributorPhone) {
        this.distributorPhone = distributorPhone;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName;
    }

    public Double getSelfMoney() {
        return selfMoney;
    }

    public void setSelfMoney(Double selfMoney) {
        this.selfMoney = selfMoney;
    }

    public Double getOneLevelMoney() {
        return oneLevelMoney;
    }

    public void setOneLevelMoney(Double oneLevelMoney) {
        this.oneLevelMoney = oneLevelMoney;
    }

    public Double getTwoLevelMoney() {
        return twoLevelMoney;
    }

    public void setTwoLevelMoney(Double twoLevelMoney) {
        this.twoLevelMoney = twoLevelMoney;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }
}
