package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.cross.model.enumeration.ReceiveAccountType;
import com.cross.model.enumeration.UserWithdrawState;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

@ApiModel(description = "小程序用户提现明细")
public class IslandUserWithdrawDTO implements Serializable {

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
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 用户OpenId
     */
    @ApiModelProperty(value = "用户OpenId")
    private String userOpenId;

    /**
     * 小程序用户Id
     */
    @ApiModelProperty(value = "小程序记录Id")
    private Long weappId;

    @ApiModelProperty(value = "提现编号")
    private String orderSn;

    /**
     * 交易订单号
     */
    @ApiModelProperty(value = "交易订单号")
    private String paymentOrderCode;

    /**
     * 提现金额
     */
    @ApiModelProperty(value = "提现金额")
    private BigDecimal withdraw;

    /**
     * 提现状态 WAIT_VERIFY 待审核, WAIT_PAY 待打款, PAYED 已打款, INVALID 无效
     */
    @ApiModelProperty(value = "提现状态 WAIT_VERIFY 待审核, WAIT_PAY 待打款, PAYED 已打款, INVALID 无效")
    private UserWithdrawState state;

    /**
     * 添加时间
     */
    @ApiModelProperty(value = "添加时间")
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
     * 备注信息
     */
    @ApiModelProperty(value = "备注信息")
    private String notices;

    /**
     * 收款账号
     */
    @ApiModelProperty(value = "收款账号")
    private String receiveAccount;

    /**
     * 打款方式   ALIPAY 支付宝, WECHAT 微信, BANK_CARD 银行卡
     */
    @ApiModelProperty(value = "打款方式   ALIPAY 支付宝, WECHAT 微信, BANK_CARD 银行卡")
    private ReceiveAccountType receiveAccountType;

    /**
     * 审核是否通过  true通过
     */
    @ApiModelProperty("审核是否通过  true通过")
    private Boolean allowFlag;


    /**
     * 账户余额
     */
    @ApiModelProperty(value = "账户余额")
    private BigDecimal accountBalance;

    /**
     * 已提现金额
     */
    @ApiModelProperty("已提现金额")
    private BigDecimal totalWithdraw;


    /**
     * 申请人姓名
     */
    @ApiModelProperty(value = "申请人姓名", hidden = true)
    private String realName;

    /**
     * 申请人手机号
     */
    @ApiModelProperty(value = "申请人手机号", hidden = true)
    private String mobile;

    @ApiModelProperty(value = "申请人", hidden = true)
    private IslandUserDTO islandUserDTO;

    /**
     * 实际提现额
     */
    @ApiModelProperty(value = "实际提现额")
    private BigDecimal realWithdraw;
    
    
    /**
     * 用户余额
     */
    @ApiModelProperty(value = "用户余额")
    private BigDecimal userAmount;
    
    
    
    public BigDecimal getUserAmount() {
        return userAmount;
    }
    
    public void setUserAmount(BigDecimal userAmount) {
        this.userAmount = userAmount;
    }
    
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

    public BigDecimal getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(BigDecimal withdraw) {
        this.withdraw = withdraw;
    }

    public UserWithdrawState getState() {
        return state;
    }

    public void setState(UserWithdrawState state) {
        this.state = state;
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

    public String getNotices() {
        return notices;
    }

    public void setNotices(String notices) {
        this.notices = notices;
    }

    public String getReceiveAccount() {
        return receiveAccount;
    }

    public void setReceiveAccount(String receiveAccount) {
        this.receiveAccount = receiveAccount;
    }

    public ReceiveAccountType getReceiveAccountType() {
        return receiveAccountType;
    }

    public void setReceiveAccountType(ReceiveAccountType receiveAccountType) {
        this.receiveAccountType = receiveAccountType;
    }

    public Boolean getAllowFlag() {
        return allowFlag;
    }

    public Boolean isAllowFlag() {
        return allowFlag;
    }

    public void setAllowFlag(Boolean allowFlag) {
        this.allowFlag = allowFlag;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public BigDecimal getTotalWithdraw() {
        return totalWithdraw;
    }

    public void setTotalWithdraw(BigDecimal totalWithdraw) {
        this.totalWithdraw = totalWithdraw;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public IslandUserDTO getIslandUserDTO() {
        return islandUserDTO;
    }

    public void setIslandUserDTO(IslandUserDTO islandUserDTO) {
        this.islandUserDTO = islandUserDTO;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getUserOpenId() {
        return userOpenId;
    }

    public void setUserOpenId(String userOpenId) {
        this.userOpenId = userOpenId;
    }

    public BigDecimal getRealWithdraw() {
        return realWithdraw;
    }

    public void setRealWithdraw(BigDecimal realWithdraw) {
        this.realWithdraw = realWithdraw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IslandUserWithdrawDTO islandUserWithdrawDTO = (IslandUserWithdrawDTO) o;
        if (islandUserWithdrawDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), islandUserWithdrawDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "IslandUserWithdrawDTO{" +
            "id=" + id +
            ", tcdId=" + tcdId +
            ", userId=" + userId +
            ", userOpenId='" + userOpenId + '\'' +
            ", weappId=" + weappId +
            ", orderSn='" + orderSn + '\'' +
            ", withdraw=" + withdraw +
            ", state=" + state +
            ", addDate=" + addDate +
            ", stateChangeDate=" + stateChangeDate +
            ", notices='" + notices + '\'' +
            ", receiveAccount='" + receiveAccount + '\'' +
            ", receiveAccountType=" + receiveAccountType +
            ", allowFlag=" + allowFlag +
            ", accountBalance=" + accountBalance +
            ", totalWithdraw=" + totalWithdraw +
            ", realName='" + realName + '\'' +
            ", mobile='" + mobile + '\'' +
            ", islandUserDTO=" + islandUserDTO +
            ", realWithdraw=" + realWithdraw +
            '}';
    }
}
