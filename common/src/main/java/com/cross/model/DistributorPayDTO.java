package com.cross.model;


import java.math.BigDecimal;
import java.time.Instant;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.enumtype.DistributorPayOrderSource;
import com.cross.enumtype.DistributorPayState;
import com.cross.enumtype.PaymentChannels;
import com.cross.enumtype.UserMemberType;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A DTO for the DistributorPay entity.
 */
@ApiModel("通吃卡支付订单信息")
public class DistributorPayDTO implements Serializable {

    private Long id;
    @ApiModelProperty(value = "支付编号")
    private Long payNo;

    @ApiModelProperty(value = "orderSn")
    private String orderSn;


    @ApiModelProperty(value = "供应商用户编号")
    private Long supplierId;
    @ApiModelProperty(value = "品牌编号")
    private Long brandId;
    @ApiModelProperty(value = "平台id")
    private Long platformId;
    @ApiModelProperty(name = "用户id")
    private Long userId;
    
    
    
    @ApiModelProperty(name = "小程序用户表id")
    private Long weappUserId;

    @ApiModelProperty(name = "订单金额")
    private Double amount;

    @ApiModelProperty(name = "分销者code")
    private Long code;

    @ApiModelProperty(value = "支付状态")
    private DistributorPayState state;

    @ApiModelProperty(value = "创建日期")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant addDate;
    
    
    @ApiModelProperty(value = "有效期截止日期")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant limitDate;

    @ApiModelProperty(value = "pay_date 支付时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant payDate;


    @ApiModelProperty(value = "商户编号")
    private Long merchantNo;


    @ApiModelProperty(value = "支付信息")
    private String payUrl;


    @ApiModelProperty(value = "支付通知状态 1 成功 0失败")
    private Integer notifyState;

    @ApiModelProperty(value = "支付通知失败说明")
    private String failInfo;

    @ApiModelProperty(value = "有效年限")
    private Integer limitYear;


    @ApiModelProperty(value = "合伙人等级id")
    private Long partnerLevelId;

    @ApiModelProperty(value = "订单来源  SELF_PAY 自购,DISTRIBUTOR 推荐, RENEWALS 续费,")
    private DistributorPayOrderSource distributorPayOrderSource;


    @ApiModelProperty(value = "会员类型 TC_CARD 通吃卡 TC_CLUB")
    private UserMemberType userMemberType;

    @ApiModelProperty(name = "用户名字")
    private String userName;
    
    @ApiModelProperty(name = "用户电话号码")
    private String userPhone;

    @ApiModelProperty(name = "原价")
    private BigDecimal price;

    @ApiModelProperty(name = "活动")
    private String activity;

    /**
     * 收支渠道 ALIPAY支付宝支付, WECHAT 微信, BANK_CARD 银行卡,BALANCE 余额支付
     */
    @ApiModelProperty(value = "收支渠道 ALIPAY支付宝支付, WECHAT 微信, BANK_CARD 银行卡,BALANCE 余额支付")
    private PaymentChannels paymentChannels;

    @ApiModelProperty(value = "购买类型 1和商品一起购买 ")
    private Integer buyType;
    
    
    /**
     * 交易订单号
     */
    @ApiModelProperty(value = "交易订单号")
    private String paymentOrderCode;

    public Long getWeappUserId() {
        return weappUserId;
    }

    public void setWeappUserId(Long weappUserId) {
        this.weappUserId = weappUserId;
    }
    
    public Instant getLimitDate() {
        return limitDate;
    }
    
    public void setLimitDate(Instant limitDate) {
        this.limitDate = limitDate;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPayNo() {
        return payNo;
    }

    public void setPayNo(Long payNo) {
        this.payNo = payNo;
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

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public DistributorPayState getState() {
        return state;
    }

    public void setState(DistributorPayState state) {
        this.state = state;
    }

    public Instant getAddDate() {
        return addDate;
    }

    public void setAddDate(Instant addDate) {
        this.addDate = addDate;
    }

    public Instant getPayDate() {
        return payDate;
    }

    public void setPayDate(Instant payDate) {
        this.payDate = payDate;
    }

    public Long getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(Long merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    public Integer getNotifyState() {
        return notifyState;
    }

    public void setNotifyState(Integer notifyState) {
        this.notifyState = notifyState;
    }

    public String getFailInfo() {
        return failInfo;
    }

    public void setFailInfo(String failInfo) {
        this.failInfo = failInfo;
    }

    public Integer getLimitYear() {
        return limitYear;
    }

    public void setLimitYear(Integer limitYear) {
        this.limitYear = limitYear;
    }

    public Long getPartnerLevelId() {
        return partnerLevelId;
    }

    public void setPartnerLevelId(Long partnerLevelId) {
        this.partnerLevelId = partnerLevelId;
    }

    public PaymentChannels getPaymentChannels() {
        return paymentChannels;
    }

    public void setPaymentChannels(PaymentChannels paymentChannels) {
        this.paymentChannels = paymentChannels;
    }

    public DistributorPayOrderSource getDistributorPayOrderSource() {
        return distributorPayOrderSource;
    }

    public void setDistributorPayOrderSource(DistributorPayOrderSource distributorPayOrderSource) {
        this.distributorPayOrderSource = distributorPayOrderSource;
    }

    public UserMemberType getUserMemberType() {
        return userMemberType;
    }

    public void setUserMemberType(UserMemberType userMemberType) {
        this.userMemberType = userMemberType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Integer getBuyType() {
        return buyType;
    }

    public void setBuyType(Integer buyType) {
        this.buyType = buyType;
    }
    
    public String getUserPhone() {
        return userPhone;
    }
    
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    
    public String getPaymentOrderCode() {
        return paymentOrderCode;
    }
    
    public void setPaymentOrderCode(String paymentOrderCode) {
        this.paymentOrderCode = paymentOrderCode;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DistributorPayDTO that = (DistributorPayDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (payNo != null ? !payNo.equals(that.payNo) : that.payNo != null) return false;
        if (supplierId != null ? !supplierId.equals(that.supplierId) : that.supplierId != null) return false;
        if (brandId != null ? !brandId.equals(that.brandId) : that.brandId != null) return false;
        if (platformId != null ? !platformId.equals(that.platformId) : that.platformId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (weappUserId != null ? !weappUserId.equals(that.weappUserId) : that.weappUserId != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (state != that.state) return false;
        if (addDate != null ? !addDate.equals(that.addDate) : that.addDate != null) return false;
        if (payDate != null ? !payDate.equals(that.payDate) : that.payDate != null) return false;
        if (merchantNo != null ? !merchantNo.equals(that.merchantNo) : that.merchantNo != null) return false;
        if (payUrl != null ? !payUrl.equals(that.payUrl) : that.payUrl != null) return false;
        if (notifyState != null ? !notifyState.equals(that.notifyState) : that.notifyState != null) return false;
        if (failInfo != null ? !failInfo.equals(that.failInfo) : that.failInfo != null) return false;
        if (limitYear != null ? !limitYear.equals(that.limitYear) : that.limitYear != null) return false;
        if (partnerLevelId != null ? !partnerLevelId.equals(that.partnerLevelId) : that.partnerLevelId != null)
            return false;
        if (distributorPayOrderSource != that.distributorPayOrderSource) return false;
        if (userMemberType != that.userMemberType) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (activity != null ? !activity.equals(that.activity) : that.activity != null) return false;
        return paymentChannels == that.paymentChannels;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (payNo != null ? payNo.hashCode() : 0);
        result = 31 * result + (supplierId != null ? supplierId.hashCode() : 0);
        result = 31 * result + (brandId != null ? brandId.hashCode() : 0);
        result = 31 * result + (platformId != null ? platformId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (weappUserId != null ? weappUserId.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (addDate != null ? addDate.hashCode() : 0);
        result = 31 * result + (payDate != null ? payDate.hashCode() : 0);
        result = 31 * result + (merchantNo != null ? merchantNo.hashCode() : 0);
        result = 31 * result + (payUrl != null ? payUrl.hashCode() : 0);
        result = 31 * result + (notifyState != null ? notifyState.hashCode() : 0);
        result = 31 * result + (failInfo != null ? failInfo.hashCode() : 0);
        result = 31 * result + (limitYear != null ? limitYear.hashCode() : 0);
        result = 31 * result + (partnerLevelId != null ? partnerLevelId.hashCode() : 0);
        result = 31 * result + (distributorPayOrderSource != null ? distributorPayOrderSource.hashCode() : 0);
        result = 31 * result + (userMemberType != null ? userMemberType.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (activity != null ? activity.hashCode() : 0);
        result = 31 * result + (paymentChannels != null ? paymentChannels.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "DistributorPayDTO{" +
            "id=" + id +
            ", payNo=" + payNo +
            ", orderSn='" + orderSn + '\'' +
            ", supplierId=" + supplierId +
            ", brandId=" + brandId +
            ", platformId=" + platformId +
            ", userId=" + userId +
            ", weappUserId=" + weappUserId +
            ", amount=" + amount +
            ", code=" + code +
            ", state=" + state +
            ", addDate=" + addDate +
            ", limitDate=" + limitDate +
            ", payDate=" + payDate +
            ", merchantNo=" + merchantNo +
            ", payUrl='" + payUrl + '\'' +
            ", notifyState=" + notifyState +
            ", failInfo='" + failInfo + '\'' +
            ", limitYear=" + limitYear +
            ", partnerLevelId=" + partnerLevelId +
            ", distributorPayOrderSource=" + distributorPayOrderSource +
            ", userMemberType=" + userMemberType +
            ", userName='" + userName + '\'' +
            ", userPhone='" + userPhone + '\'' +
            ", price=" + price +
            ", activity='" + activity + '\'' +
            ", paymentChannels=" + paymentChannels +
            ", buyType=" + buyType +
            ", paymentOrderCode='" + paymentOrderCode + '\'' +
            '}';
    }
}
