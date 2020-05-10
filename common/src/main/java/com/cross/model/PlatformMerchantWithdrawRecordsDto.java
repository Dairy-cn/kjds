package com.cross.model;

import com.cross.enumtype.PlatformWithdrawState;
import com.cross.enumtype.ReceiveAccountType;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;

public class PlatformMerchantWithdrawRecordsDto implements Serializable {
    
    @ApiModelProperty("序号")
    private Long id;
    
    @ApiModelProperty("审核状态")
    private Integer checkState;
    
    @ApiModelProperty("具体审核状态")
    private PlatformWithdrawState platformWithdrawState;
    
    /**
     * 添加时间
     */
    @ApiModelProperty(value = "申请时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)
    private Instant addDate;
    
    @ApiModelProperty(value = "交易单号")
    private String orderSn;
    
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;
    
    /**
     * 提现商户
     */
    @ApiModelProperty(value = "提现商户")
    private String merchantName;
    
    /**
     * 提现商户账号
     */
    @ApiModelProperty(value = "提现商户账号")
    private String merchantAccount;
    
    /**
     * 累计总收益
     */
    @ApiModelProperty(value = "累计总收益")
    private BigDecimal totalProfit;
    
    /**
     * 已提现金额
     */
    @ApiModelProperty(value = "已提现金额")
    private BigDecimal totalWithdraw;
    
    /**
     * 待提现金额
     */
    @ApiModelProperty(value = "待提现金额")
    private BigDecimal waitForWithdraw;
    
    /**
     * 本次提现金额
     */
    @ApiModelProperty(value = "本次提现金额")
    private BigDecimal thisWithdraw;
    
    /**
     * 实际提现额
     */
    @ApiModelProperty(value = "实际提现额")
    private BigDecimal realWithdraw;
    
    @ApiModelProperty("账户余额")
    private BigDecimal accountBalance;
    
    /**
     * 打款方式   ALIPAY 支付宝, WECHAT 微信, BANK_CARD 银行卡
     */
    @ApiModelProperty(value = "提现方式")
    private ReceiveAccountType receiveAccountType;
    
    /**
     * 收款账号
     */
    @ApiModelProperty(value = "提现账户")
    private String receiveAccount;
    
    /**
     * 所属银行
     */
    @ApiModelProperty(value = "所属银行")
    private String bank;
    
    /**
     * 开户行
     */
    @ApiModelProperty(value = "开户行")
    private String openingBank;
    
    /**
     * 开户人
     */
    @ApiModelProperty(value = "开户人")
    private String accountHolder;
    
    /**
     * 状态修改时间
     */
    @ApiModelProperty(value = "审核时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)
    private Instant stateChangeDate;
    
    
    /**
     * 商户平台Id
     */
    @ApiModelProperty(value = "商户平台Id")
    private Long platformId;
    
    @ApiModelProperty(value = "总金额")
    private BigDecimal totalAmount;
    
    public Long getPlatformId() {
        return platformId;
    }
    
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }
    
    public PlatformWithdrawState getPlatformWithdrawState() {
        return platformWithdrawState;
    }
    
    public void setPlatformWithdrawState(PlatformWithdrawState platformWithdrawState) {
        this.platformWithdrawState = platformWithdrawState;
    }
    
    public BigDecimal getAccountBalance() {
        return accountBalance;
    }
    
    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getCheckState() {
        return checkState;
    }
    
    public void setCheckState(Integer checkState) {
        this.checkState = checkState;
    }
    
    public Instant getAddDate() {
        return addDate;
    }
    
    public void setAddDate(Instant addDate) {
        this.addDate = addDate;
    }
    
    public String getOrderSn() {
        return orderSn;
    }
    
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getMerchantName() {
        return merchantName;
    }
    
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
    
    public String getMerchantAccount() {
        return merchantAccount;
    }
    
    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }
    
    public BigDecimal getTotalProfit() {
        return totalProfit;
    }
    
    public void setTotalProfit(BigDecimal totalProfit) {
        this.totalProfit = totalProfit;
    }
    
    public BigDecimal getTotalWithdraw() {
        return totalWithdraw;
    }
    
    public void setTotalWithdraw(BigDecimal totalWithdraw) {
        this.totalWithdraw = totalWithdraw;
    }
    
    public BigDecimal getWaitForWithdraw() {
        return waitForWithdraw;
    }
    
    public void setWaitForWithdraw(BigDecimal waitForWithdraw) {
        this.waitForWithdraw = waitForWithdraw;
    }
    
    public BigDecimal getThisWithdraw() {
        return thisWithdraw;
    }
    
    public void setThisWithdraw(BigDecimal thisWithdraw) {
        this.thisWithdraw = thisWithdraw;
    }
    
    public BigDecimal getRealWithdraw() {
        return realWithdraw;
    }
    
    public void setRealWithdraw(BigDecimal realWithdraw) {
        this.realWithdraw = realWithdraw;
    }
    
    public ReceiveAccountType getReceiveAccountType() {
        return receiveAccountType;
    }
    
    public void setReceiveAccountType(ReceiveAccountType receiveAccountType) {
        this.receiveAccountType = receiveAccountType;
    }
    
    public String getReceiveAccount() {
        return receiveAccount;
    }
    
    public void setReceiveAccount(String receiveAccount) {
        this.receiveAccount = receiveAccount;
    }
    
    public Instant getStateChangeDate() {
        return stateChangeDate;
    }
    
    public void setStateChangeDate(Instant stateChangeDate) {
        this.stateChangeDate = stateChangeDate;
    }
    
    public String getBank() {
        return bank;
    }
    
    public void setBank(String bank) {
        this.bank = bank;
    }
    
    public String getOpeningBank() {
        return openingBank;
    }
    
    public void setOpeningBank(String openingBank) {
        this.openingBank = openingBank;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }
    
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    @Override
    public String toString() {
        return "PlatformMerchantWithdrawRecordsDto{" +
            "addDate=" + addDate +
            ", orderSn='" + orderSn + '\'' +
            ", userId=" + userId +
            ", merchantName='" + merchantName + '\'' +
            ", merchantAccount='" + merchantAccount + '\'' +
            ", totalProfit=" + totalProfit +
            ", totalWithdraw=" + totalWithdraw +
            ", waitForWithdraw=" + waitForWithdraw +
            ", thisWithdraw=" + thisWithdraw +
            ", realWithdraw=" + realWithdraw +
            ", receiveAccountType=" + receiveAccountType +
            ", receiveAccount='" + receiveAccount + '\'' +
            ", stateChangeDate=" + stateChangeDate +
            '}';
    }
}
