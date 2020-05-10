package com.cross.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the ShopOrderShipping entity.
 */
public class ShopOrderShippingDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 32)
    private String orderId;

    @NotNull
    private ShippingType shippingType;

    @NotNull
    private String deliveryId;

    @Size(max = 32)
    private String shippingId;

    private ShippingStatus status;

    private String courierName;

    private String courierPhone;

    private Integer cancelReasonId;

    @Size(max = 255)
    private String cancelReason;

    @NotNull
    private String shopId;

    @NotNull
    private Integer deliveryServiceCode;

    @NotNull
    @Size(max = 255)
    private String receiverName;

    @NotNull
    @Size(max = 512)
    private String receiverAddress;

    @NotNull
    @Size(max = 64)
    private String receiverPhone;

    @NotNull
    private Integer receiverLng;

    @NotNull
    private Integer receiverLat;

    private Integer coordinateType;

    private Double goodsValue;

    private Double goodsHeight;

    private Double goodsWidth;

    private Double goodsLength;

    @NotNull
    private Double goodsWeight;

    @Size(max = 10240)
    private String goodsDetail;

    private String goodsPickupInfo;

    private String goodsDeliveryInfo;

    private Long expectedPickupTime;

    private Long expectedDeliveryTime;

    private String orderType;

    private String poiSeq;

    private String note;

    private String cashOnDelivery;

    private String cashOnPickup;

    private String invoiceTitle;

    private Integer exceptionState;

    private String exceptionInfo;

    private Long exceptionId;

    private Long exceptionTime;

    @ApiModelProperty(value = "发送配送是否成功")
    private Boolean sendResult;

    @ApiModelProperty(value = "发送配送时间")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)
    private Instant sendShippingTime;

    public Instant getSendShippingTime() {
        return sendShippingTime;
    }

    public void setSendShippingTime(Instant sendShippingTime) {
        this.sendShippingTime = sendShippingTime;
    }

    public Boolean getSendResult() {
        return sendResult;
    }

    public void setSendResult(Boolean sendResult) {
        this.sendResult = sendResult;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public ShippingType getShippingType() {
        return shippingType;
    }

    public void setShippingType(ShippingType shippingType) {
        this.shippingType = shippingType;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getShippingId() {
        return shippingId;
    }

    public void setShippingId(String shippingId) {
        this.shippingId = shippingId;
    }

    public ShippingStatus getStatus() {
        return status;
    }

    public void setStatus(ShippingStatus status) {
        this.status = status;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    public String getCourierPhone() {
        return courierPhone;
    }

    public void setCourierPhone(String courierPhone) {
        this.courierPhone = courierPhone;
    }

    public Integer getCancelReasonId() {
        return cancelReasonId;
    }

    public void setCancelReasonId(Integer cancelReasonId) {
        this.cancelReasonId = cancelReasonId;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public Integer getDeliveryServiceCode() {
        return deliveryServiceCode;
    }

    public void setDeliveryServiceCode(Integer deliveryServiceCode) {
        this.deliveryServiceCode = deliveryServiceCode;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public Integer getReceiverLng() {
        return receiverLng;
    }

    public void setReceiverLng(Integer receiverLng) {
        this.receiverLng = receiverLng;
    }

    public Integer getReceiverLat() {
        return receiverLat;
    }

    public void setReceiverLat(Integer receiverLat) {
        this.receiverLat = receiverLat;
    }

    public Integer getCoordinateType() {
        return coordinateType;
    }

    public void setCoordinateType(Integer coordinateType) {
        this.coordinateType = coordinateType;
    }

    public Double getGoodsValue() {
        return goodsValue;
    }

    public void setGoodsValue(Double goodsValue) {
        this.goodsValue = goodsValue;
    }

    public Double getGoodsHeight() {
        return goodsHeight;
    }

    public void setGoodsHeight(Double goodsHeight) {
        this.goodsHeight = goodsHeight;
    }

    public Double getGoodsWidth() {
        return goodsWidth;
    }

    public void setGoodsWidth(Double goodsWidth) {
        this.goodsWidth = goodsWidth;
    }

    public Double getGoodsLength() {
        return goodsLength;
    }

    public void setGoodsLength(Double goodsLength) {
        this.goodsLength = goodsLength;
    }

    public Double getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(Double goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public String getGoodsPickupInfo() {
        return goodsPickupInfo;
    }

    public void setGoodsPickupInfo(String goodsPickupInfo) {
        this.goodsPickupInfo = goodsPickupInfo;
    }

    public String getGoodsDeliveryInfo() {
        return goodsDeliveryInfo;
    }

    public void setGoodsDeliveryInfo(String goodsDeliveryInfo) {
        this.goodsDeliveryInfo = goodsDeliveryInfo;
    }

    public Long getExpectedPickupTime() {
        return expectedPickupTime;
    }

    public void setExpectedPickupTime(Long expectedPickupTime) {
        this.expectedPickupTime = expectedPickupTime;
    }

    public Long getExpectedDeliveryTime() {
        return expectedDeliveryTime;
    }

    public void setExpectedDeliveryTime(Long expectedDeliveryTime) {
        this.expectedDeliveryTime = expectedDeliveryTime;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getPoiSeq() {
        return poiSeq;
    }

    public void setPoiSeq(String poiSeq) {
        this.poiSeq = poiSeq;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCashOnDelivery() {
        return cashOnDelivery;
    }

    public void setCashOnDelivery(String cashOnDelivery) {
        this.cashOnDelivery = cashOnDelivery;
    }

    public String getCashOnPickup() {
        return cashOnPickup;
    }

    public void setCashOnPickup(String cashOnPickup) {
        this.cashOnPickup = cashOnPickup;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public Integer getExceptionState() {
        return exceptionState;
    }

    public void setExceptionState(Integer exceptionState) {
        this.exceptionState = exceptionState;
    }

    public String getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }

    public Long getExceptionId() {
        return exceptionId;
    }

    public void setExceptionId(Long exceptionId) {
        this.exceptionId = exceptionId;
    }

    public Long getExceptionTime() {
        return exceptionTime;
    }

    public void setExceptionTime(Long exceptionTime) {
        this.exceptionTime = exceptionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ShopOrderShippingDTO shopOrderShippingDTO = (ShopOrderShippingDTO) o;
        if(shopOrderShippingDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), shopOrderShippingDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ShopOrderShippingDTO{" +
            "id=" + getId() +
            ", orderId='" + getOrderId() + "'" +
            ", shippingType='" + getShippingType() + "'" +
            ", deliveryId='" + getDeliveryId() + "'" +
            ", shippingId='" + getShippingId() + "'" +
            ", status='" + getStatus() + "'" +
            ", courierName='" + getCourierName() + "'" +
            ", courierPhone='" + getCourierPhone() + "'" +
            ", cancelReasonId=" + getCancelReasonId() +
            ", cancelReason='" + getCancelReason() + "'" +
            ", shopId='" + getShopId() + "'" +
            ", deliveryServiceCode=" + getDeliveryServiceCode() +
            ", receiverName='" + getReceiverName() + "'" +
            ", receiverAddress='" + getReceiverAddress() + "'" +
            ", receiverPhone='" + getReceiverPhone() + "'" +
            ", receiverLng=" + getReceiverLng() +
            ", receiverLat=" + getReceiverLat() +
            ", coordinateType=" + getCoordinateType() +
            ", goodsValue=" + getGoodsValue() +
            ", goodsHeight=" + getGoodsHeight() +
            ", goodsWidth=" + getGoodsWidth() +
            ", goodsLength=" + getGoodsLength() +
            ", goodsWeight=" + getGoodsWeight() +
            ", goodsDetail='" + getGoodsDetail() + "'" +
            ", goodsPickupInfo='" + getGoodsPickupInfo() + "'" +
            ", goodsDeliveryInfo='" + getGoodsDeliveryInfo() + "'" +
            ", expectedPickupTime=" + getExpectedPickupTime() +
            ", expectedDeliveryTime=" + getExpectedDeliveryTime() +
            ", orderType='" + getOrderType() + "'" +
            ", poiSeq='" + getPoiSeq() + "'" +
            ", note='" + getNote() + "'" +
            ", cashOnDelivery='" + getCashOnDelivery() + "'" +
            ", cashOnPickup='" + getCashOnPickup() + "'" +
            ", invoiceTitle='" + getInvoiceTitle() + "'" +
            ", exceptionState=" + getExceptionState() +
            ", exceptionInfo='" + getExceptionInfo() + "'" +
            ", exceptionId=" + getExceptionId() +
            ", exceptionTime=" + getExceptionTime() +
            "}";
    }
}
