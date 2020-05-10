package com.cross.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

public class ShopOrderExtendedInfoDTO {

    private Long id;

    /**
     * 客户姓名
     */
    @ApiModelProperty(value = "客户姓名")
    private String customerName;
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
     * 订单内容
     */
    @Size(max = 1000)
    @ApiModelProperty(value = "订单内容")
    private String orderContent;

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
     * 订单备注
     */
    @ApiModelProperty(value = "订单备注")
    private String orderMark;

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
     * 商户电话
     */
    @ApiModelProperty(value = "商户电话")
    private String merchantPhone;

    /**
     * 商户名称
     */
    @ApiModelProperty(value = "商户名称")
    private String merchantName;

    /**
     * 商户距离
     */
    @ApiModelProperty(value = "商户距离")
    private Double merchantDistance;

    @ApiModelProperty(value = "收款账户编号")
    private Long receiveId;

    private Long shopOrderId;
    /**
     * 系统当前时间戳
     */
    private Integer nowTime;
    /**
     * 预约到店的时间戳
     */
    private Long orderSendTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
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

    public String getMerchantPhone() {
        return merchantPhone;
    }

    public void setMerchantPhone(String merchantPhone) {
        this.merchantPhone = merchantPhone;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Double getMerchantDistance() {
        return merchantDistance;
    }

    public void setMerchantDistance(Double merchantDistance) {
        this.merchantDistance = merchantDistance;
    }

    public Long getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Long receiveId) {
        this.receiveId = receiveId;
    }

    public Long getShopOrderId() {
        return shopOrderId;
    }

    public void setShopOrderId(Long shopOrderId) {
        this.shopOrderId = shopOrderId;
    }

    public Integer getNowTime() {
        return nowTime;
    }

    public void setNowTime(Integer nowTime) {
        this.nowTime = nowTime;
    }

    public Long getOrderSendTime() {
        return orderSendTime;
    }

    public void setOrderSendTime(Long orderSendTime) {
        this.orderSendTime = orderSendTime;
    }
}
