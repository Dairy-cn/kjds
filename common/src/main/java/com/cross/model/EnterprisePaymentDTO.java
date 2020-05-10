package com.cross.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the EnterprisePayment entity.
 */
@ApiModel(description = "企业付款给微信用户")
public class EnterprisePaymentDTO implements Serializable {

    private Long id;

    /**
     * 商户账号appid
     */
    @Size(max = 128)
    @ApiModelProperty(value = "商户账号appid")
    private String mch_appid;

    /**
     * 商户号
     */
    @Size(max = 32)
    @ApiModelProperty(value = "商户号")
    private String mchid;

    /**
     * 设备号
     */
    @Size(max = 32)
    @ApiModelProperty(value = "设备号")
    private String device_info;

    /**
     * 随机字符串
     */
    @Size(max = 32)
    @ApiModelProperty(value = "随机字符串")
    private String nonce_str;

    /**
     * 签名
     */
    @Size(max = 32)
    @ApiModelProperty(value = "签名")
    private String sign;

    /**
     * 商户订单号
     */
    @Size(max = 32)
    @ApiModelProperty(value = "商户订单号")
    private String partner_trade_no;

    /**
     * 用户openid
     */
    @Size(max = 32)
    @ApiModelProperty(value = "用户openid")
    private String openid;

    /**
     * 校验用户姓名选项
     */
    @Size(max = 16)
    @ApiModelProperty(value = "校验用户姓名选项(NO_CHECK：不校验真实姓名 " +
        "FORCE_CHECK：强校验真实姓名)")
    private String check_name;

    /**
     * 收款用户姓名
     */
    @Size(max = 64)
    @ApiModelProperty(value = "收款用户姓名")
    private String re_user_name;

    /**
     * 金额
     */
    @ApiModelProperty(value = "金额")
    private Integer amount;

    /**
     * 企业付款备注
     */
    @Size(max = 100)
    @ApiModelProperty(value = "企业付款备注")
    private String desc;

    /**
     * Ip地址
     */
    @Size(max = 32)
    @ApiModelProperty(value = "Ip地址")
    private String spbill_create_ip;

    /**
     * 付款结果
     */
    @ApiModelProperty(value = "付款结果")
    private String result;

    /**
     * 成功标识
     */
    @ApiModelProperty(value = "成功标识（true标识支付成功）")
    private Boolean successFlag;

    @ApiModelProperty("微信付款单号(企业付款成功，返回的微信付款单号)")
    private String payment_no;

    @ApiModelProperty("付款成功时间")
    private String payment_time;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMch_appid() {
        return mch_appid;
    }

    public void setMch_appid(String mch_appid) {
        this.mch_appid = mch_appid;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPartner_trade_no() {
        return partner_trade_no;
    }

    public void setPartner_trade_no(String partner_trande_no) {
        this.partner_trade_no = partner_trande_no;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getCheck_name() {
        return check_name;
    }

    public void setCheck_name(String check_name) {
        this.check_name = check_name;
    }

    public String getRe_user_name() {
        return re_user_name;
    }

    public void setRe_user_name(String re_user_name) {
        this.re_user_name = re_user_name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Boolean getSuccessFlag() {
        return successFlag;
    }

    public void setSuccessFlag(Boolean successFlag) {
        this.successFlag = successFlag;
    }

    public String getPayment_no() {
        return payment_no;
    }

    public void setPayment_no(String payment_no) {
        this.payment_no = payment_no;
    }

    public String getPayment_time() {
        return payment_time;
    }

    public void setPayment_time(String payment_time) {
        this.payment_time = payment_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EnterprisePaymentDTO enterprisePaymentDTO = (EnterprisePaymentDTO) o;
        if (enterprisePaymentDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), enterprisePaymentDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EnterprisePaymentDTO{" +
            "id=" + id +
            ", mch_appid='" + mch_appid + '\'' +
            ", mchid='" + mchid + '\'' +
            ", device_info='" + device_info + '\'' +
            ", nonce_str='" + nonce_str + '\'' +
            ", sign='" + sign + '\'' +
            ", partner_trande_no='" + partner_trade_no + '\'' +
            ", openid='" + openid + '\'' +
            ", check_name='" + check_name + '\'' +
            ", re_user_name='" + re_user_name + '\'' +
            ", amount=" + amount +
            ", desc='" + desc + '\'' +
            ", spbill_create_ip='" + spbill_create_ip + '\'' +
            ", result='" + result + '\'' +
            '}';
    }
}
