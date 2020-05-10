package com.cross.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A UserReceiveAccount.
 */
@Entity
@Table(name = "user_receive_account")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UserReceiveAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 交易id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 支付用户编号
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 平台编号（自身系统平台）
     */
    @Column(name = "platform_app_id")
    private Long platformAppId;

    /**
     * 支付通道 1威富通 2微信
     */
    @Column(name = "channel", nullable = false)
    private Integer channel;

    /**
     * 平台商户编号
     */
    @NotNull
    @Size(max = 32)
    @Column(name = "plat_merchant_id", length = 32, nullable = false)
    private String platMerchantId;

    /**
     * 平台商户密钥
     */
    @NotNull
    @Size(max = 256)
    @Column(name = "plat_merchant_secret", length = 256, nullable = false)
    private String platMerchantSecret;

    /**
     * 平台大商户编号
     */
    @Size(max = 32)
    @Column(name = "plat_merchant_parent_id", length = 32, nullable = false)
    private String platMerchantParentId;

    /**
     * 平台大商户密钥
     */
    @Column(name = "plat_merchant_parent_secret", length = 45, nullable = false)
    private String platMerchantParentSecret;

    /**
     * 平台应用编号
     */
    @Column(name = "plat_app_id")
    private String platAppId;

    /**
     * 平台应用密钥
     */
    @Column(name = "plat_app_secret")
    private String platAppSecret;

    /**
     * 平台应用键
     */
    @Column(name = "plat_app_key")
    private String platAppKey;

    /**
     * 支付费率
     */
    @Column(name = "plat_fee_rate", precision=10, scale=2)
    private BigDecimal platFeeRate;

    /**
     * 支付状态 0 未支付 1 已支付
     */
    @Column(name = "state")
    private Integer state;

    /**
     * 启用信用卡
     */
    @Column(name = "enable_credit")
    private Integer enableCredit;

    /**
     * 异步通知地址
     */
    @Size(max = 210)
    @Column(name = "notify_url", length = 210)
    private String notifyUrl;

    /**
     * 创建时间
     */
    @Column(name = "add_time")
    private Integer addTime;

    /**
     * 创建IP
     */
    @Size(max = 32)
    @Column(name = "add_ip", length = 32)
    private String addIp;

    /**
     * 支付完成返回地址
     */
    @Column(name="callback_url", length = 210)
    private String callbackUrl;

    /**
     * 账户标记
     */
    @Column(name="account_tag", length = 90)
    private String accountTag;

    /**
     * 微信app编号
     */
    @Column(name="we_app_id", length = 255)
    private String weAppId;

    /**
     * 微信密钥
     */
    @Column(name="we_app_secret", length = 255)
    private String weAppSecret;

    /**
     * 原生支付地址
     */
    @Column(name="native_call_pay", length = 255)
    private Boolean nativeCallPay;

    /**
     * 支付地址
     */
    @Column(name="pay_url", length = 255)
    private String payUrl;

    /**
     * 证书内容
     */
    @Column(name="cert_data", length = 1024)
    private String certData;

    /**
     * 退款结果通知地址
     */
    @Column(name="refund_notify_url", length = 255)
    private String refundNotifyUrl;

    /**
     * platformId 平台id
     */
    @Column(name="platform_id")
    private Long platformId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public UserReceiveAccount mobile(Long userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getChannel() {
        return channel;
    }

    public UserReceiveAccount channel(Integer channel) {
        this.channel = channel;
        return this;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserReceiveAccount userReceiveAccount = (UserReceiveAccount) o;
        if (userReceiveAccount.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), userReceiveAccount.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UserReceiveAccount{" +
            "id=" + id +
            ", userId=" + userId +
            ", platformAppId=" + platformAppId +
            ", channel=" + channel +
            ", platMerchantId='" + platMerchantId + '\'' +
            ", platMerchantSecret='" + platMerchantSecret + '\'' +
            ", platMerchantParentId='" + platMerchantParentId + '\'' +
            ", platMerchantParentSecret='" + platMerchantParentSecret + '\'' +
            ", platAppId='" + platAppId + '\'' +
            ", platAppSecret='" + platAppSecret + '\'' +
            ", platAppKey='" + platAppKey + '\'' +
            ", platFeeRate=" + platFeeRate +
            ", state=" + state +
            ", enableCredit=" + enableCredit +
            ", notifyUrl='" + notifyUrl + '\'' +
            ", addTime=" + addTime +
            ", addIp='" + addIp + '\'' +
            ", callbackUrl='" + callbackUrl + '\'' +
            ", accountTag='" + accountTag + '\'' +
            ", weAppId='" + weAppId + '\'' +
            ", weAppSecret='" + weAppSecret + '\'' +
            ", nativeCallPay=" + nativeCallPay +
            ", payUrl='" + payUrl + '\'' +
            ", certData='" + certData + '\'' +
            ", refundNotifyUrl='" + refundNotifyUrl + '\'' +
            ", platformId=" + platformId +
            '}';
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

    public String getAccountTag() {
        return accountTag;
    }

    public void setAccountTag(String accountTag) {
        this.accountTag = accountTag;
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

    public String getWeAppSecret() {
        return weAppSecret;
    }

    public void setWeAppSecret(String weAppSecret) {
        this.weAppSecret = weAppSecret;
    }

    public String getWeAppId() {
        return weAppId;
    }

    public void setWeAppId(String weAppId) {
        this.weAppId = weAppId;
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

    public Long getPlatformAppId() {
        return platformAppId;
    }

    public void setPlatformAppId(Long platformAppId) {
        this.platformAppId = platformAppId;
    }
}
