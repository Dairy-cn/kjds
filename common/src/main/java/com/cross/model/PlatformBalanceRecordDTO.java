package com.cross.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.enumtype.*;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.cross.model.enumeration.PlatformBalanceTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;


@ApiModel(description = "商户余额支付和收入记录")
public class PlatformBalanceRecordDTO implements Serializable {
    
    private Long id;
    
    /**
     * 通吃岛Id
     */
    @NotNull
    @ApiModelProperty(value = "通吃岛Id", required = true)
    private Long tcd;
    
    /**
     * 商户平台id
     */
    @NotNull
    @ApiModelProperty(value = "商户平台id", required = true)
    private Long platformId;
    
    @ApiModelProperty(value = "品牌Id")
    private Long brandId;
    
    /**
     * 交易金额
     */
    @ApiModelProperty(value = "交易金额")
    private BigDecimal changeAmount;
    
    /**
     * 流水类型 INCOME 收入 ,SPENDING 支出 NEITHER 不是支出也不是收入
     */
    @ApiModelProperty(value = "流水类型 INCOME 收入 ,SPENDING 支出 NEITHER 不是支出也不是收入")
    private PlatformRunningType runningType;
    
    /**
     * 交易时间
     */
    @ApiModelProperty(value = "交易时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant addDate;
    
    /**
     * 状态修改时间
     */
    @ApiModelProperty(value = "状态修改时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant stateChangeDate;
    
    /**
     * 账户余额
     */
    @ApiModelProperty(value = "账户余额")
    private BigDecimal accountAmount;
    
    /**
     * 收支渠道 ALIPAY支付宝支付, WECHAT 微信, BANK_CARD 银行卡,BALANCE 余额支付; PROMOTION_BALANCE宣发余额支付
     */
    @ApiModelProperty(value = "收支渠道 ALIPAY支付宝支付, WECHAT 微信, BANK_CARD 银行卡,BALANCE 余额支付; PROMOTION_BALANCE宣发余额支付,USER 用户")
    private PlatformPaymentChannels paymentChannels;
    
    /**
     * 订单Id
     */
    @ApiModelProperty(value = "订单Id")
    private Long orderId;
    
    /**
     * 交易编号
     */
    @ApiModelProperty(value = "交易编号")
    private String orderSn;
    
    /**
     * 交易订单号
     */
    @ApiModelProperty(value = "交易订单号")
    private String paymentOrderCode;
    
    /**
     * PUBLISH_PROMOTION 发布宣发 扣除宣发金额到待使用的宣发金额中,RECALL_PROMOTION 撤回宣发，回退宣发金额,CANCEL_PROMOTION 取消宣发，回退宣发金额,CHECK_ORDER_PROMOTION宣发订单审核通过，扣除相应的待使用宣发金,NO_ORDER_REFUND_PROMOITON 宣发订单未完成，回退宣发金额,,RECHARGE 充值,WITHDRAWAL 提现
     */
    @ApiModelProperty(value = "PUBLISH_PROMOTION 发布宣发 扣除宣发金额到待使用的宣发金额中,RECALL_PROMOTION 撤回宣发，回退宣发金额,CANCEL_PROMOTION 取消宣发，回退宣发金额,CHECK_ORDER_PROMOTION宣发订单审核通过，扣除相应的待使用宣发金,NO_ORDER_REFUND_PROMOITON 宣发订单未完成，回退宣发金额,,RECHARGE 充值,WITHDRAWAL 提现")
    private PlatformTradeSources tradeSources;
    
    
    /**
     * 交易金额(如订单的金额)
     */
    @ApiModelProperty(value = "交易金额(如订单的金额)")
    private BigDecimal transactionAmount;
    
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
    
    /**
     * 收款方
     * 平台账户 Platform
     * 商户账户 MERCHANT
     */
    @ApiModelProperty(value = "平台账户 Platform  商户账户 MERCHANT")
    private PayeeTypeEnum payeeType;
    
    /**
     * 付款方
     * 用户 USER
     * 商户 MERCHANT
     */
    @ApiModelProperty(value = "用户 USER  商户 MERCHANT")
    private PayerTypeEnum payerType;
    
    /**
     * 支出金额
     */
    @ApiModelProperty(value = "支出金额")
    private BigDecimal spendingAmount;
    
    /**
     * 收入金额
     */
    @ApiModelProperty(value = "收入金额")
    private BigDecimal incomeAmount;
    
    /**
     * 平台额外收支金额
     */
    @ApiModelProperty(value = "平台额外收支金额")
    private BigDecimal platformExtAmount;
    
    
    
    @ApiModelProperty(value = "平台余额记录类型")
    private PlatformBalanceTypeEnum platformBalanceTypeEnum;
    
    
    
    public PlatformBalanceTypeEnum getPlatformBalanceTypeEnum() {
        return platformBalanceTypeEnum;
    }
    
    public void setPlatformBalanceTypeEnum(PlatformBalanceTypeEnum platformBalanceTypeEnum) {
        this.platformBalanceTypeEnum = platformBalanceTypeEnum;
    }
    
    public Long getBrandId() {
        return brandId;
    }
    
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getTcd() {
        return tcd;
    }
    
    public void setTcd(Long tcd) {
        this.tcd = tcd;
    }
    
    public Long getPlatformId() {
        return platformId;
    }
    
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }
    
    public BigDecimal getChangeAmount() {
        return changeAmount;
    }
    
    public void setChangeAmount(BigDecimal changeAmount) {
        this.changeAmount = changeAmount;
    }
    
    public PlatformRunningType getRunningType() {
        return runningType;
    }
    
    public void setRunningType(PlatformRunningType runningType) {
        this.runningType = runningType;
    }
    
    public Instant getAddDate() {
        return addDate;
    }
    
    public void setAddDate(Instant addDate) {
        this.addDate = addDate;
    }
    
    public Instant getStateChangeDate() {
        return stateChangeDate;
    }
    
    public void setStateChangeDate(Instant stateChangeDate) {
        this.stateChangeDate = stateChangeDate;
    }
    
    public BigDecimal getAccountAmount() {
        return accountAmount;
    }
    
    public void setAccountAmount(BigDecimal accountAmount) {
        this.accountAmount = accountAmount;
    }
    
    public PlatformPaymentChannels getPaymentChannels() {
        return paymentChannels;
    }
    
    public void setPaymentChannels(PlatformPaymentChannels paymentChannels) {
        this.paymentChannels = paymentChannels;
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
    
    public PlatformTradeSources getTradeSources() {
        return tradeSources;
    }
    
    public void setTradeSources(PlatformTradeSources tradeSources) {
        this.tradeSources = tradeSources;
    }
    
    public String getPaymentOrderCode() {
        return paymentOrderCode;
    }
    
    public void setPaymentOrderCode(String paymentOrderCode) {
        this.paymentOrderCode = paymentOrderCode;
    }
    
    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }
    
    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
    
    public PlatformPaymentChannels getPayChannels() {
        return payChannels;
    }
    
    public void setPayChannels(PlatformPaymentChannels payChannels) {
        this.payChannels = payChannels;
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
    
    public BigDecimal getSpendingAmount() {
        return spendingAmount;
    }
    
    public void setSpendingAmount(BigDecimal spendingAmount) {
        this.spendingAmount = spendingAmount;
    }
    
    public BigDecimal getIncomeAmount() {
        return incomeAmount;
    }
    
    public void setIncomeAmount(BigDecimal incomeAmount) {
        this.incomeAmount = incomeAmount;
    }
    
    public BigDecimal getPlatformExtAmount() {
        return platformExtAmount;
    }
    
    public void setPlatformExtAmount(BigDecimal platformExtAmount) {
        this.platformExtAmount = platformExtAmount;
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
        
        PlatformBalanceRecordDTO platformBalanceRecordDTO = (PlatformBalanceRecordDTO) o;
        if (platformBalanceRecordDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), platformBalanceRecordDTO.getId());
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
    
    @Override
    public String toString() {
        return "PlatformBalanceRecordDTO{" +
            "id=" + id +
            ", tcd=" + tcd +
            ", platformId=" + platformId +
            ", brandId=" + brandId +
            ", changeAmount=" + changeAmount +
            ", runningType=" + runningType +
            ", addDate=" + addDate +
            ", stateChangeDate=" + stateChangeDate +
            ", accountAmount=" + accountAmount +
            ", paymentChannels=" + paymentChannels +
            ", orderId=" + orderId +
            ", orderSn='" + orderSn + '\'' +
            ", paymentOrderCode='" + paymentOrderCode + '\'' +
            ", tradeSources=" + tradeSources +
            ", transactionAmount=" + transactionAmount +
            ", payChannels=" + payChannels +
            ", incomeChannels=" + incomeChannels +
            ", payeeType=" + payeeType +
            ", payerType=" + payerType +
            ", spendingAmount=" + spendingAmount +
            ", incomeAmount=" + incomeAmount +
            ", platformExtAmount=" + platformExtAmount +
            ", platformBalanceTypeEnum=" + platformBalanceTypeEnum +
            '}';
    }
}
