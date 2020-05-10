package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.enumtype.PaymentChannels;
import com.cross.enumtype.RunningType;
import com.cross.enumtype.TradeSources;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.island.domain.IslandUserBalanceRecordDTO} entity.
 */
@ApiModel(description = "小程序用户余额记录")
public class IslandUserBalanceRecordDTO implements Serializable {

    private Long id;

    /**
     * 通吃岛Id
     */
    @NotNull
    @ApiModelProperty(value = "通吃岛Id", required = true)
    private Long tcdId;

    /**
     * 用户id
     */
    @NotNull
    @ApiModelProperty(value = "用户id", required = true)
    private Long userId;

    /**
     * 小程序记录Id
     */
    @NotNull
    @ApiModelProperty(value = "小程序记录Id", required = true)
    private Long weappId;

    /**
     * 交易金额
     */
    @ApiModelProperty(value = "交易金额")
    private BigDecimal amount;

    /**
     * 流水类型 INCOME 收入 ,SPENDING 支出
     */
    @ApiModelProperty(value = "流水类型 INCOME 收入 ,SPENDING 支出")
    private RunningType runningType;

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
     * 收支渠道 ALIPAY支付宝支付, WECHAT 微信, BANK_CARD 银行卡,BALANCE 余额支付
     */
    @ApiModelProperty(value = "收支渠道 ALIPAY支付宝支付, WECHAT 微信, BANK_CARD 银行卡,BALANCE 余额支付")
    private PaymentChannels paymentChannels;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private Long orderId;

    /**
     * 交易单号
     */
    @ApiModelProperty(value = "交易单号")
    private String orderSn;

    /**
     * BUY_GOODS 购买商品,
     * DISTRIBUTION_CASHBACK 分销返现,
     * RECHARGE 充值,
     * PromotionPrice 推广悬赏,
     * BUY_TC_CARD 购买通吃卡,
     * WITHDRAWAL 提现
     */
    @ApiModelProperty(value = "BUY_GOODS 购买商品, DISTRIBUTION_CASHBACK 分销返现, RECHARGE 充值, PromotionPrice 推广悬赏, BUY_TC_CARD 购买通吃卡, WITHDRAWAL 提现")
    private TradeSources tradeSources;


    @ApiModelProperty(value = " 商品名")
    private String shopName;



    @ApiModelProperty(value = " 商品数量")
    private Integer shopNum;

    @ApiModelProperty(value = " 商品门店Id")
    private Long shopMerchantId;

    @ApiModelProperty(value = " 商品品牌Id")
    private Long shopBrandId;
    
    /**
     * 交易订单号
     */
    @ApiModelProperty(value = "交易订单号")
    private String paymentOrderCode;
    
    /**
     * 交易金额
     */
    @ApiModelProperty(value = "交易金额(订单交易金额)")
    private BigDecimal transactionAmount;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTcdId() {
        return tcdId;
    }

    public void setTcdId(Long tcdId) {
        this.tcdId = tcdId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getWeappId() {
        return weappId;
    }

    public void setWeappId(Long weappId) {
        this.weappId = weappId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public RunningType getRunningType() {
        return runningType;
    }

    public void setRunningType(RunningType runningType) {
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

    public PaymentChannels getPaymentChannels() {
        return paymentChannels;
    }

    public void setPaymentChannels(PaymentChannels paymentChannels) {
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

    public TradeSources getTradeSources() {
        return tradeSources;
    }

    public void setTradeSources(TradeSources tradeSources) {
        this.tradeSources = tradeSources;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getShopNum() {
        return shopNum;
    }

    public void setShopNum(Integer shopNum) {
        this.shopNum = shopNum;
    }

    public Long getShopMerchantId() {
        return shopMerchantId;
    }

    public void setShopMerchantId(Long shopMerchantId) {
        this.shopMerchantId = shopMerchantId;
    }

    public Long getShopBrandId() {
        return shopBrandId;
    }

    public void setShopBrandId(Long shopBrandId) {
        this.shopBrandId = shopBrandId;
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IslandUserBalanceRecordDTO islandUserBalanceRecordDTO = (IslandUserBalanceRecordDTO) o;
        if (islandUserBalanceRecordDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), islandUserBalanceRecordDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
    
    @Override
    public String toString() {
        return "IslandUserBalanceRecordDTO{" +
            "id=" + id +
            ", tcdId=" + tcdId +
            ", userId=" + userId +
            ", weappId=" + weappId +
            ", amount=" + amount +
            ", runningType=" + runningType +
            ", addDate=" + addDate +
            ", stateChangeDate=" + stateChangeDate +
            ", accountAmount=" + accountAmount +
            ", paymentChannels=" + paymentChannels +
            ", orderId=" + orderId +
            ", orderSn='" + orderSn + '\'' +
            ", tradeSources=" + tradeSources +
            ", shopName='" + shopName + '\'' +
            ", shopNum=" + shopNum +
            ", shopMerchantId=" + shopMerchantId +
            ", shopBrandId=" + shopBrandId +
            ", paymentOrderCode='" + paymentOrderCode + '\'' +
            ", transactionAmount=" + transactionAmount +
            '}';
    }
}
