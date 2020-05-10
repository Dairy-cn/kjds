package com.cross.model;

import com.cross.model.enumeration.BillStyle;
import com.cross.model.enumeration.Gender;
import com.cross.model.enumeration.OrderPaymentStatus;
import com.cross.model.enumeration.SendStyle;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * A DistributionOrder.
 */
public class DistributionOrderTemp implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;


    /**
     * 原配送费
     */
    @ApiModelProperty(value = "原配送费")
    private Double deliveryFee;

    /**
     * 发入单方式
     */
    @ApiModelProperty(value = "发入单方式")
    private BillStyle billStyle;

    /**
     * 派单方式
     */
    @ApiModelProperty(value = "派单方式")
    private SendStyle sendStyle;

    @ApiModelProperty(value = "团队ID")
    private Long teamId;

    @ApiModelProperty(value = "抢单群ID")
    private Long groupId;

    @ApiModelProperty(value = "配送员ID")
    private Long personId;

    @ApiModelProperty(value = "商户ID")
    private Long merchantId;

    /**
     * 客户姓名
     */
    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    /**
     * 客户性别
     */
    @ApiModelProperty(value = "客户性别")
    private Gender customerGender;

    /**
     * 客户电话
     */
    @ApiModelProperty(value = "客户电话")
    private String customerPhone;

    /**
     * 客户地址
     */
    @ApiModelProperty(value = "客户地址")
    private String customerAddress;

    /**
     * 客户坐标
     */
    @ApiModelProperty(value = "客户坐标")
    private String customerCoordinate;

    /**
     * 订单总价
     */
    @ApiModelProperty(value = "订单总价")
    private Double orderPrice;

    /**
     * 订单支付状态
     */
    @ApiModelProperty(value = "订单支付状态")
    private OrderPaymentStatus orderPaymentStatus;

    /**
     * 订单内容
     */
    @ApiModelProperty(value = "订单内容")
    private String orderContent;

    /**
     * 订单单号
     */
    @ApiModelProperty(value = "订单单号")
    private String orderNo;

    /**
     * 订单来源
     */
    @ApiModelProperty(value = "订单来源")
    private String orderSource;

    /**
     * 订单标识
     */
    @ApiModelProperty(value = "订单标识")
    private String orderRemark;

    /**
     * 订单送达
     */
    @ApiModelProperty(value = "订单送达")
    private String orderSend;

    /**
     * 订单标识
     */
    @ApiModelProperty(value = "订单标识")
    private String orderMark;

    /**
     * 商户名称
     */
    @ApiModelProperty(value = "商户名称")
    private String merchantName;

    /**
     * 商户电话
     */
    @ApiModelProperty(value = "商户电话")
    private String merchantPhone;

    /**
     * 商户坐标
     */
    @ApiModelProperty(value = "商户坐标")
    private String merchantCoordinate;

    /**
     * 商户地址
     */
    @ApiModelProperty(value = "商户地址")
    private String merchantAddress;

    /**
     * 商户距离
     */
    @ApiModelProperty(value = "商户距离")
    private Double merchantDistance;

    @ApiModelProperty(value = "商户用户ID")
    private Long merchantUserId;

    public Long getMerchantUserId() {
        return merchantUserId;
    }

    public void setMerchantUserId(Long merchantUserId) {
        this.merchantUserId = merchantUserId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantPhone() {
        return merchantPhone;
    }

    public void setMerchantPhone(String merchantPhone) {
        this.merchantPhone = merchantPhone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(Double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public BillStyle getBillStyle() {
        return billStyle;
    }

    public void setBillStyle(BillStyle billStyle) {
        this.billStyle = billStyle;
    }

    public SendStyle getSendStyle() {
        return sendStyle;
    }

    public void setSendStyle(SendStyle sendStyle) {
        this.sendStyle = sendStyle;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Gender getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Gender customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerCoordinate() {
        return customerCoordinate;
    }

    public void setCustomerCoordinate(String customerCoordinate) {
        this.customerCoordinate = customerCoordinate;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public OrderPaymentStatus getOrderPaymentStatus() {
        return orderPaymentStatus;
    }

    public void setOrderPaymentStatus(OrderPaymentStatus orderPaymentStatus) {
        this.orderPaymentStatus = orderPaymentStatus;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public String getOrderSend() {
        return orderSend;
    }

    public void setOrderSend(String orderSend) {
        this.orderSend = orderSend;
    }

    public String getOrderMark() {
        return orderMark;
    }

    public void setOrderMark(String orderMark) {
        this.orderMark = orderMark;
    }

    public String getMerchantCoordinate() {
        return merchantCoordinate;
    }

    public void setMerchantCoordinate(String merchantCoordinate) {
        this.merchantCoordinate = merchantCoordinate;
    }

    public String getMerchantAddress() {
        return merchantAddress;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }

    public Double getMerchantDistance() {
        return merchantDistance;
    }

    public void setMerchantDistance(Double merchantDistance) {
        this.merchantDistance = merchantDistance;
    }
}
