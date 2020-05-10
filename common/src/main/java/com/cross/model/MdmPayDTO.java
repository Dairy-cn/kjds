package com.cross.model;

import com.cross.enumtype.MdmPayStateEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the MdmPay entity.
 */
@ApiModel(description = "mdm支付",discriminator = "非预下单请求参数不能再获取参数map之前传入")
public class MdmPayDTO implements Serializable {

    private Long id;

    @ApiModelProperty(value = "平台id")
    private Long platformId;

    /**
     * 商户唯一标识
     */
    @ApiModelProperty(value = "商户唯一标识")
    private String appId;

    /**
     * 发起请求的时间
     */
    @ApiModelProperty(value = "发起请求的时间")
    private Long timestamp;

    /**
     * 订单金额(最小为1分)
     */
    @ApiModelProperty(value = "订单金额(最小为1分)")
    private Integer amount;

    /**
     * 签名
     */
    @ApiModelProperty(value = "签名")
    private String signature;

    /**
     * 商户订单号
     */
    @ApiModelProperty(value = "商户订单号")
    private String orderGUID;

    /**
     * 支付唯一标识
     */
    @ApiModelProperty(value = "支付唯一标识")
    private String payGUID;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    /**
     * 订单的描述
     */
    @ApiModelProperty(value = "订单的描述")
    private String body;

    /**
     * 门店名
     */
    @ApiModelProperty(value = "门店名")
    private String storeName;

    /**
     * 商户名
     */
    @ApiModelProperty(value = "商户名")
    private String enterpriseName;

    /**
     * 响应码
     */
    @ApiModelProperty(value = "响应码")
    private String code;

    /**
     * 响应信息
     */
    @ApiModelProperty(value = "响应信息")
    private String msg;

    /**
     * 响应json串
     */
    @ApiModelProperty(value = "响应json串")
    private String response;

    /**
     * 是否退款
     */
    @ApiModelProperty(value = "是否退款")
    private Boolean refund;

    @ApiModelProperty(value = "币种")
    private String currency="RMB";

    @ApiModelProperty(value = "设备终端号,微信、支付宝条码支付时候，此参数必")
    private String terminalId;

    @ApiModelProperty(value = "条码支付的授权码(当微信、支付宝条码支付时候，必填)")
    private String authCode;

    @ApiModelProperty(value = "支付方式(不传为条码支付，\n" +
        "31：银联(支付宝)扫码支付\n" +
        "51：银联(微信)扫码支付（线下）\n" +
        "52：银联(微信)公众号支付（线下）\n" +
        "53：银联(微信)小程序支付（线下）\n" +
        "72：翼支付扫码支付)")
    private String payPowerId;

    @ApiModelProperty(value = "订单附加描述")
    private String description;

    @ApiModelProperty(value = "订单附加数据")
    private String extra;

    @ApiModelProperty(value = "商户公众号APPID")
    private String subAppId;

    @ApiModelProperty(value = "唯一标识")
    private String subOpenId;

    @ApiModelProperty(value = "额外数据")
    private String attachData;

    @ApiModelProperty(value = "外部通知的回调地址")
    private String outNotifyUrl;

    @ApiModelProperty(value = "是否指定服务商分账，限微信直连商户使用")
    private String profitSharing;

    @ApiModelProperty(value = "支付状态")
    private MdmPayStateEnum payState;

    @ApiModelProperty(value = "平台订单号")
    private String orderHolderNo;

    @ApiModelProperty(value = "银行订单编号")
    private String orderNo;

    @ApiModelProperty(value = "成功支付时间")
    private Instant payTime;

    @ApiModelProperty(value = "退款是否成功")
    private Boolean refundFlag;

    @ApiModelProperty(value = "退款成功时间")
    private Instant refundTime;

    @ApiModelProperty(value = "平台退款号")
    private String refOrderNo;

    @ApiModelProperty(value = "退款消息是否成功推送")
    private Boolean refMsg;

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

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getOrderGUID() {
        return orderGUID;
    }

    public void setOrderGUID(String orderGUID) {
        this.orderGUID = orderGUID;
    }

    public String getPayGUID() {
        return payGUID;
    }

    public void setPayGUID(String payGUID) {
        this.payGUID = payGUID;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean isRefund() {
        return refund;
    }

    public void setRefund(Boolean refund) {
        this.refund = refund;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getPayPowerId() {
        return payPowerId;
    }

    public void setPayPowerId(String payPowerId) {
        this.payPowerId = payPowerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getSubAppId() {
        return subAppId;
    }

    public void setSubAppId(String subAppId) {
        this.subAppId = subAppId;
    }

    public String getSubOpenId() {
        return subOpenId;
    }

    public void setSubOpenId(String subOpenId) {
        this.subOpenId = subOpenId;
    }

    public String getAttachData() {
        return attachData;
    }

    public void setAttachData(String attachData) {
        this.attachData = attachData;
    }

    public String getOutNotifyUrl() {
        return outNotifyUrl;
    }

    public void setOutNotifyUrl(String outNotifyUrl) {
        this.outNotifyUrl = outNotifyUrl;
    }

    public String getProfitSharing() {
        return profitSharing;
    }

    public void setProfitSharing(String profitSharing) {
        this.profitSharing = profitSharing;
    }

    public MdmPayStateEnum getPayState() {
        return payState;
    }

    public void setPayState(MdmPayStateEnum payState) {
        this.payState = payState;
    }

    public String getOrderHolderNo() {
        return orderHolderNo;
    }

    public void setOrderHolderNo(String orderHolderNo) {
        this.orderHolderNo = orderHolderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Instant getPayTime() {
        return payTime;
    }

    public void setPayTime(Instant payTime) {
        this.payTime = payTime;
    }

    public Boolean getRefundFlag() {
        return refundFlag;
    }

    public void setRefundFlag(Boolean refundFlag) {
        this.refundFlag = refundFlag;
    }

    public Instant getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Instant refundTime) {
        this.refundTime = refundTime;
    }

    public String getRefOrderNo() {
        return refOrderNo;
    }

    public void setRefOrderNo(String refOrderNo) {
        this.refOrderNo = refOrderNo;
    }

    public Boolean getRefMsg() {
        return refMsg;
    }

    public void setRefMsg(Boolean refMsg) {
        this.refMsg = refMsg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MdmPayDTO mdmPayDTO = (MdmPayDTO) o;
        if (mdmPayDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), mdmPayDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MdmPayDTO{" +
            "id=" + id +
            ", appId='" + appId + '\'' +
            ", timestamp=" + timestamp +
            ", amount=" + amount +
            ", signature='" + signature + '\'' +
            ", orderGUID='" + orderGUID + '\'' +
            ", payGUID='" + payGUID + '\'' +
            ", goodsName='" + goodsName + '\'' +
            ", body='" + body + '\'' +
            ", storeName='" + storeName + '\'' +
            ", enterpriseName='" + enterpriseName + '\'' +
            ", code='" + code + '\'' +
            ", msg='" + msg + '\'' +
            ", response='" + response + '\'' +
            ", refund=" + refund +
            ", currency='" + currency + '\'' +
            ", terminalId='" + terminalId + '\'' +
            ", authCode='" + authCode + '\'' +
            ", payPowerId='" + payPowerId + '\'' +
            ", description='" + description + '\'' +
            ", extra='" + extra + '\'' +
            ", subAppId='" + subAppId + '\'' +
            ", subOpenId='" + subOpenId + '\'' +
            ", attachData='" + attachData + '\'' +
            ", outNotifyUrl='" + outNotifyUrl + '\'' +
            ", profitSharing='" + profitSharing + '\'' +
            '}';
    }
}
