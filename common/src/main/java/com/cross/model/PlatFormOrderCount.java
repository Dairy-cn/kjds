package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.cross.utils.NumberUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * 平台订单统计
 */
@ApiModel(description = "平台订单统计")
public class PlatFormOrderCount implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 结算时间
     */
    @ApiModelProperty(value = "结算时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant startTime = Instant.now();

    /**
     * 平台ID
     */
    @ApiModelProperty(value = "平台ID")
    private Long platformUserId;

    /**
     * 商户ID
     */
    @ApiModelProperty(value = "商户ID")
    private Long merchantId;

    /**
     * 订单价格
     */
    @ApiModelProperty(value = "订单价格")
    private Double orderAmount = 0d;

    /**
     * 合计
     */
    @ApiModelProperty(value = "合计")
    private Double productFee = 0d;

    /**
     * 优惠金额
     */
    @ApiModelProperty(value = "优惠金额")
    private Double discountFee = 0d;

    /**
     * 打包费用
     */
    @ApiModelProperty(value = "打包费用")
    private Double packFee = 0d;

    /**
     * 配送费用
     */
    @ApiModelProperty(value = "配送费用")
    private Double shippingFee = 0d;

    /**
     * 佣金
     */
    @ApiModelProperty(value = "佣金")
    private Double brokerageAmount = 0d;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public PlatFormOrderCount startTime(Instant startTime) {
        this.startTime = startTime;
        return this;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Long getPlatformUserId() {
        return platformUserId;
    }

    public PlatFormOrderCount platformUserId(Long platformUserId) {
        this.platformUserId = platformUserId;
        return this;
    }

    public void setPlatformUserId(Long platformUserId) {
        this.platformUserId = platformUserId;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public PlatFormOrderCount orderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
        return this;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Double getProductFee() {
        return productFee;
    }

    public PlatFormOrderCount productFee(Double productFee) {
        this.productFee = productFee;
        return this;
    }

    public void setProductFee(Double productFee) {
        this.productFee = productFee;
    }

    public Double getDiscountFee() {
        return discountFee;
    }

    public PlatFormOrderCount discountFee(Double discountFee) {
        this.discountFee = discountFee;
        return this;
    }

    public void setDiscountFee(Double discountFee) {
        this.discountFee = discountFee;
    }

    public Double getPackFee() {
        return packFee;
    }

    public PlatFormOrderCount packFee(Double packFee) {
        this.packFee = packFee;
        return this;
    }

    public void setPackFee(Double packFee) {
        this.packFee = packFee;
    }

    public Double getShippingFee() {
        return shippingFee;
    }

    public PlatFormOrderCount shippingFee(Double shippingFee) {
        this.shippingFee = shippingFee;
        return this;
    }

    public void setShippingFee(Double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public Double getBrokerageAmount() {
        return brokerageAmount;
    }

    public PlatFormOrderCount brokerageAmount(Double brokerageAmount) {
        this.brokerageAmount = brokerageAmount;
        return this;
    }

    public void setBrokerageAmount(Double brokerageAmount) {
        this.brokerageAmount = brokerageAmount;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlatFormOrderCount platFormOrderCount = (PlatFormOrderCount) o;
        if (platFormOrderCount.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), platFormOrderCount.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PlatFormOrderCount{" +
            "id=" + getId() +
            ", startTime='" + getStartTime() + "'" +
            ", platformUserId='" + getPlatformUserId() + "'" +
            ", orderAmount='" + getOrderAmount() + "'" +
            ", productFee='" + getProductFee() + "'" +
            ", discountFee='" + getDiscountFee() + "'" +
            ", packFee='" + getPackFee() + "'" +
            ", shippingFee='" + getShippingFee() + "'" +
            ", brokerageAmount='" + getBrokerageAmount() + "'" +
            "}";
    }

    public PlatFormOrderCount(){

    }

    public PlatFormOrderCount(Long platformUserId, Long merchantId, Double orderAmount, Double productFee, Double discountFee, Double packFee, Double shippingFee, Double brokerageAmount){
        this.merchantId = merchantId;
        this.platformUserId = platformUserId;
        this.orderAmount = NumberUtil.setDoubleTwo(null == orderAmount ? 0d : orderAmount);
        this.productFee = NumberUtil.setDoubleTwo(null == productFee ? 0d : productFee);
        this.discountFee = NumberUtil.setDoubleTwo(null == discountFee ? 0d : discountFee);
        this.packFee = NumberUtil.setDoubleTwo(null == packFee ? 0d : packFee);
        this.shippingFee = NumberUtil.setDoubleTwo(null == shippingFee ? 0d : shippingFee);
        this.brokerageAmount = NumberUtil.setDoubleTwo(null == brokerageAmount ? 0d : brokerageAmount);
    }
}
