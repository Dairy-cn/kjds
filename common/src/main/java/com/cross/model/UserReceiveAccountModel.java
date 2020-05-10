package com.cross.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A UserReceiveAccountVM.
 */
public class UserReceiveAccountModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String mobile;

    private Integer channel;

    private String platMerchantId;

    private String platMerchantSecret;

    private String platMerchantParentId;

    private String platAppId;

    private String platAppSecret;

    private String platAppKey;

    private BigDecimal platFeeRate;

    private Integer state;

    private Integer enableCredit;

    private String notifyUrl;

    private Integer addTime;

    private String addIp;

    private String callbackUrl;

    private Long merchantNo;

    private String platMerchantParentSecret;

    private Boolean nativeCallPay;

    private String payUrl;

    private String certData;

    private String refundNotifyUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public UserReceiveAccountModel mobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getChannel() {
        return channel;
    }

    public UserReceiveAccountModel channel(Integer channel) {
        this.channel = channel;
        return this;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }


    public String getPlatMerchantId() {
        return platMerchantId;
    }

    public void setPlatMerchantId(String platMerchantId) {
        this.platMerchantId = platMerchantId;
    }

    public String getPlatMerchantSecret() {
        return platMerchantSecret;
    }

    public void setPlatMerchantSecret(String platMerchantSecret) {
        this.platMerchantSecret = platMerchantSecret;
    }

    public String getPlatMerchantParentId() {
        return platMerchantParentId;
    }

    public void setPlatMerchantParentId(String platMerchantParentId) {
        this.platMerchantParentId = platMerchantParentId;
    }

    public String getPlatAppId() {
        return platAppId;
    }

    public void setPlatAppId(String platAppId) {
        this.platAppId = platAppId;
    }

    public String getPlatAppSecret() {
        return platAppSecret;
    }

    public void setPlatAppSecret(String platAppSecret) {
        this.platAppSecret = platAppSecret;
    }

    public String getPlatAppKey() {
        return platAppKey;
    }

    public void setPlatAppKey(String platAppKey) {
        this.platAppKey = platAppKey;
    }

    public BigDecimal getPlatFeeRate() {
        return platFeeRate;
    }

    public void setPlatFeeRate(BigDecimal platFeeRate) {
        this.platFeeRate = platFeeRate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getEnableCredit() {
        return enableCredit;
    }

    public void setEnableCredit(Integer enableCredit) {
        this.enableCredit = enableCredit;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public String getAddIp() {
        return addIp;
    }

    public void setAddIp(String addIp) {
        this.addIp = addIp;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public Long getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(Long merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getPlatMerchantParentSecret() {
        return platMerchantParentSecret;
    }

    public void setPlatMerchantParentSecret(String platMerchantParentSecret) {
        this.platMerchantParentSecret = platMerchantParentSecret;
    }

    public Boolean getNativeCallPay() {
        return nativeCallPay;
    }

    public void setNativeCallPay(Boolean nativeCallPay) {
        this.nativeCallPay = nativeCallPay;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    public String getCertData() {
        return certData;
    }

    public void setCertData(String certData) {
        this.certData = certData;
    }

    public String getRefundNotifyUrl() {
        return refundNotifyUrl;
    }

    public void setRefundNotifyUrl(String refundNotifyUrl) {
        this.refundNotifyUrl = refundNotifyUrl;
    }
}
