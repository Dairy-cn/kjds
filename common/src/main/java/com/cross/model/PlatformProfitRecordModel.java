package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.cross.enumtype.PayeeTypeEnum;
import com.cross.enumtype.PayerTypeEnum;
import com.cross.enumtype.PlatformPaymentChannels;
import com.cross.enumtype.PlatformProfitType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.model.PlatformProfitRecordModel} entity.
 */
@ApiModel(description = "平台收益明细")
public class PlatformProfitRecordModel implements Serializable {

    private Long id;

    /**
     * 平台id
     */
    @NotNull
    @ApiModelProperty(value = "平台id", required = true)
    private Long platformId;

    /**
     * 通吃岛id
     */
    @NotNull
    @ApiModelProperty(value = "通吃岛id", required = true)
    private Long tcdId;
    
    /**
     * 品牌Id
     */
    @ApiModelProperty(value = "品牌Id")
    private Long brandId;

    /**
     * 订单Id
     */
    @ApiModelProperty(value = "订单Id")
    private Long orderId;

    /**
     * 订单Sn
     */
    @ApiModelProperty(value = "订单Sn")
    private String orderSn;

    /**
     * 交易单号
     */
    @ApiModelProperty(value = "交易单号")
    private String paymentOrderCode;

    /**
     * 变动金额
     */
    @ApiModelProperty(value = "变动金额")
    private BigDecimal changeAmount;
    
    
    /**
     * 交易金额
     */
    @ApiModelProperty(value = "交易金额")
    private BigDecimal transactionAmount;
    

    /**
     * 变动后金额
     */
    @ApiModelProperty(value = "变动后金额")
    private BigDecimal profit;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;

    /**
     * 变动日期
     */
    @ApiModelProperty(value = "变动日期")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime changeDate;

    /**
     * 变动IP
     */
    @Size(max = 60)
    @ApiModelProperty(value = "变动IP")
    private String changeIp;
    
    
    @ApiModelProperty(value = "  PROMOTION_PROFIT 宣发收益, USER_WITHDRAW_PROFIT 用户提现抽成收益,PLATFORM_WITHDRAW_PROFIT 平台提现抽成收益,  UNDISTRIBUTED_PROFIT 分销未分配收益,")
    private PlatformProfitType platformProfitType;
    
    /**
     * 收款方
     * 用户 USER
     * 平台账户 Platform
     * 商户账户 MERCHANT
     */
    @ApiModelProperty(value = "用户 USER 平台账户 Platform  商户账户 MERCHANT")
    private PayeeTypeEnum payeeType;
    
    /**
     * 付款方
     * 用户 USER
     * 商户 MERCHANT
     * 平台账户 Platform
     */
    @ApiModelProperty(value = "用户 USER  商户 MERCHANT 平台账户 Platform")
    private PayerTypeEnum payerType;
    
    
    /**
     * 支付渠道 ALIPAY支付宝支付, WECHAT 微信, BANK_CARD 银行卡,BALANCE 余额支付; PROMOTION_BALANCE宣发余额支付
     */
    @ApiModelProperty(value = "支付渠道 ALIPAY支付宝支付, WECHAT 微信, BANK_CARD 银行卡,BALANCE 余额支付; PROMOTION_BALANCE宣发余额支付")
    private PlatformPaymentChannels payChannels;
    
    
    
    /**
     * 收入渠道 ALIPAY支付宝支付, WECHAT 微信, BANK_CARD 银行卡,BALANCE 余额支付; PROMOTION_BALANCE宣发余额支付
     */
    @ApiModelProperty(value = "收入渠道 ALIPAY支付宝支付, WECHAT 微信, BANK_CARD 银行卡,BALANCE 余额支付; PROMOTION_BALANCE宣发余额支付")
    private PlatformPaymentChannels incomeChannels;
    
    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }
    
    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public Long getTcdId() {
        return tcdId;
    }

    public void setTcdId(Long tcdId) {
        this.tcdId = tcdId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getPaymentOrderCode() {
        return paymentOrderCode;
    }

    public void setPaymentOrderCode(String makePayOrderCodeNo) {
        this.paymentOrderCode = paymentOrderCode;
    }

    public BigDecimal getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(BigDecimal changeAmount) {
        this.changeAmount = changeAmount;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDateTime changeDate) {
        this.changeDate = changeDate;
    }

    public String getChangeIp() {
        return changeIp;
    }

    public void setChangeIp(String changeIp) {
        this.changeIp = changeIp;
    }
    
    
    public PlatformProfitType getPlatformProfitType() {
        return platformProfitType;
    }
    
    public void setPlatformProfitType(PlatformProfitType platformProfitType) {
        this.platformProfitType = platformProfitType;
    }
    
    public Long getBrandId() {
        return brandId;
    }
    
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
    
    public PayeeTypeEnum getPayeeType() {
        return payeeType;
    }
    
    public void setPayeeType(PayeeTypeEnum payeeType) {
        this.payeeType = payeeType;
    }
    
    public PayerTypeEnum getPayerType() {
        return payerType;
    }
    
    public void setPayerType(PayerTypeEnum payerType) {
        this.payerType = payerType;
    }
    
    public PlatformPaymentChannels getPayChannels() {
        return payChannels;
    }
    
    public void setPayChannels(PlatformPaymentChannels payChannels) {
        this.payChannels = payChannels;
    }
    
    public PlatformPaymentChannels getIncomeChannels() {
        return incomeChannels;
    }
    
    public void setIncomeChannels(PlatformPaymentChannels incomeChannels) {
        this.incomeChannels = incomeChannels;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
    
        PlatformProfitRecordModel platformProfitRecordDTO = (PlatformProfitRecordModel) o;
        if (platformProfitRecordDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), platformProfitRecordDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
    
    @Override
    public String toString() {
        return "PlatformProfitRecordModel{" +
            "id=" + id +
            ", platformId=" + platformId +
            ", tcdId=" + tcdId +
            ", brandId=" + brandId +
            ", orderId=" + orderId +
            ", orderSn='" + orderSn + '\'' +
            ", paymentOrderCode='" + paymentOrderCode + '\'' +
            ", changeAmount=" + changeAmount +
            ", transactionAmount=" + transactionAmount +
            ", profit=" + profit +
            ", createTime=" + createTime +
            ", changeDate=" + changeDate +
            ", changeIp='" + changeIp + '\'' +
            ", platformProfitType=" + platformProfitType +
            ", payeeType=" + payeeType +
            ", payerType=" + payerType +
            ", payChannels=" + payChannels +
            ", incomeChannels=" + incomeChannels +
            '}';
    }
}
