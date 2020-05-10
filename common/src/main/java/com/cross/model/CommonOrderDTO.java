package com.cross.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.cross.model.enumeration.*;
import com.cross.utils.NumberUtil;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the CommonOrder entity.
 */
public class CommonOrderDTO implements Serializable {

    private Long id;

    private Long masterUserId;

    private Long platformId;

    private Long merchantId;

    @Size(max = 200)
    private String address;

    @Size(max = 20)
    private String phone;

    private OrderChannel orderFrom;
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant createdAt;
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant activeAt;

    private Double deliverFee = 0d;

    private Double vipDeliveryFeeDiscount = 0d;
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant deliverTime;

    private String description;

    @Size(max = 160)
    private String invoice;

    private Boolean book;

    private Boolean onlinePaid;

    @Size(max = 64)
    private String eleMeId;

    private Long shopId;

    @Size(max = 64)
    private String openId;

    @Size(max = 90)
    private String shopName;

    private Integer daySn;

    private OrderStatus status;

    private OrderRefundStatus refundStatus;

    private Long userId;

    private Double totalPrice = 0d;

    private Double originalPrice = 0d;

    @Size(max = 60)
    private String consignee;

    @Size(max = 90)
    private String deliveryGeo;

    @Size(max = 180)
    private String deliveryPoiAddress;

    private Boolean invoiced;

    private Double income = 0d;

    private Double serviceRate = 0d;

    private Double serviceFee = 0d;

    private Double hongbao = 0d;

    private Double packageFee = 0d;

    private Double activityTotal = 0d;

    private Double shopPart = 0d;

    private Double elemePart = 0d;

    private Boolean downgraded;
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant secretPhoneExpireTime;

    private InvoiceType invoiceType;

    @Size(max = 80)
    private String taxpayerId;

    private Double coldBoxFee = 0d;

    private String cancelOrderDescription;
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant cancelOrderCreatedAt;

    /**
     * 门店城市
     */
    private String shopCity;

    /**
     * 配送员电话
     */
    private String shipperPhone;

    /**
     * 配送员名称
     */
    private String shipperName;

    /**
     * 配送状态 待接单＝1 待取货＝2 配送中＝3 已完成＝4 已取消＝5 已过期＝7 指派单=8 妥投异常之物品返回中=9 妥投异常之物品返回完成=10 创建达达运单失败=1000 可参考文末的状态说明
     */
    private Integer shippingStatus;

    /**
     * 配送员id
     */
    private Long shipperId;

    /**
     * 配送类型 1 达达 2 点我达
     */
    private Integer shippingType;

    /**
     * 接收订单时间
     */
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant acceptAt;

    /**
     * 发送订单时间
     */
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant sendShippingAt;

    /**
     * 配送取单订单时间
     */
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant takeShippingAt;

    /**
     * 配送送达订单时间
     */
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant finishShippingAt;
    
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant nowTime = Instant.now();

    /**
     * 参与活动
     */
    private String orderActivity;

    /**
     * 订单商品
     */
    private String orderGoods;

    private Long dayCount;

    private String createAtStr;

    // 无效
    private Long invalidNum;

    // 有效
    private Long settledNum;
    //订单类型
    private OrderType orderType;

    private List<ShopSalesDTO> salesDTOList;

    private String tableFee;

    private Integer peopleNum;

    private String mealNumber;
    private String tableName;
    /**
     * 支付方式 1 支付宝 2 微信 3 银行卡 4余额支付  5.免支付
     */
    private Integer payWay;
    private String paymentOrderCode;
    /**
     * 消费者编号
     */
    private Long consumerId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public String getPaymentOrderCode() {
        return paymentOrderCode;
    }

    public void setPaymentOrderCode(String paymentOrderCode) {
        this.paymentOrderCode = paymentOrderCode;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }
    public CommonOrderDTO() {
    }

    public CommonOrderDTO(Double totalPrice, Long platformId, Long dayCount) {
        this.totalPrice = null != totalPrice ? NumberUtil.setDoubleTwo(totalPrice) : 0d;
        this.platformId = platformId;
        this.dayCount = dayCount;
    }

    public CommonOrderDTO(Long merchantId, Long dayCount, Double totalPrice) {
        this.merchantId = merchantId;
        this.dayCount = dayCount;
        this.totalPrice = null != totalPrice ? NumberUtil.setDoubleTwo(totalPrice) : 0d;

    }

    public CommonOrderDTO(Long dayCount, Double totalPrice, Long phone) {
        this.dayCount = dayCount;
        this.totalPrice = null != totalPrice ? NumberUtil.setDoubleTwo(totalPrice) : 0d;
        this.phone = String.valueOf(phone);
    }

    public CommonOrderDTO(Double totalPrice, Long phone) {
        this.totalPrice = null != totalPrice ? NumberUtil.setDoubleTwo(totalPrice) : 0d;
        this.phone = String.valueOf(phone);
    }

    public CommonOrderDTO(Long merchantId, String createAtStr, OrderChannel orderFrom, Double serviceRate, Long dayCount,
                          Double totalPrice, Double originalPrice, Double packageFee, Double shopPart, Double elemePart,
                          Double deliverFee, Double income, Long invalidNum, Long settledNum) {
        this.merchantId = merchantId;
        this.createAtStr = createAtStr;
        this.orderFrom = orderFrom;
        this.dayCount = dayCount;
        this.serviceRate = null != serviceRate ? NumberUtil.setDoubleTwo(serviceRate) : 0D;
        this.totalPrice = null != totalPrice ? NumberUtil.setDoubleTwo(totalPrice) : 0D;
        this.originalPrice = null != originalPrice ? NumberUtil.setDoubleTwo(originalPrice) : 0D;
        this.packageFee = null != packageFee ? NumberUtil.setDoubleTwo(packageFee) : 0D;
        this.shopPart = null != shopPart ? NumberUtil.setDoubleTwo(shopPart) : 0D;
        this.elemePart = null != elemePart ? NumberUtil.setDoubleTwo(elemePart) : 0D;
        this.deliverFee = null != deliverFee ? NumberUtil.setDoubleTwo(deliverFee) : 0D;
        this.income = null != income ? NumberUtil.setDoubleTwo(income) : 0D;
        this.invalidNum = invalidNum;
        this.settledNum = settledNum;
    }

    public CommonOrderDTO(Object[] objects) {
        this.merchantId = Long.parseLong(objects[0].toString());
        this.createAtStr = objects[1].toString();
        if (objects[2].toString().toUpperCase().equals("ELEME")) {
            this.orderFrom = OrderChannel.ELEME;
        } else {
            this.orderFrom = OrderChannel.MEITUAN;
        }
        this.serviceRate = null != serviceRate ? NumberUtil.setDoubleTwo(objects[3]) : 0D;
        this.dayCount = Long.parseLong(objects[4].toString());
        this.totalPrice = null != totalPrice ? NumberUtil.setDoubleTwo(objects[5]) : 0D;
        this.originalPrice = null != originalPrice ? NumberUtil.setDoubleTwo(objects[6]) : 0D;
        this.packageFee = null != packageFee ? NumberUtil.setDoubleTwo(objects[7]) : 0D;
        this.shopPart = null != shopPart ? NumberUtil.setDoubleTwo(objects[8]) : 0D;
        this.elemePart = null != elemePart ? NumberUtil.setDoubleTwo(objects[9]) : 0D;
        this.deliverFee = null != deliverFee ? NumberUtil.setDoubleTwo(objects[10]) : 0D;
        this.income = null != income ? NumberUtil.setDoubleTwo(objects[11]) : 0D;
        this.settledNum = Long.parseLong(objects[12].toString());
        this.invalidNum = Long.parseLong(objects[13].toString());
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public List<ShopSalesDTO> getSalesDTOList() {
        return salesDTOList;
    }

    public void setSalesDTOList(List<ShopSalesDTO> salesDTOList) {
        this.salesDTOList = salesDTOList;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getInvalidNum() {
        return invalidNum;
    }

    public String getTableFee() {
        return tableFee;
    }

    public void setTableFee(String tableFee) {
        this.tableFee = tableFee;
    }

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getMealNumber() {
        return mealNumber;
    }

    public void setMealNumber(String mealNumber) {
        this.mealNumber = mealNumber;
    }

    public void setInvalidNum(Long invalidNum) {
        this.invalidNum = invalidNum;
    }

    public Long getSettledNum() {
        return settledNum;
    }

    public void setSettledNum(Long settledNum) {
        this.settledNum = settledNum;
    }

    public String getCreateAtStr() {
        return createAtStr;
    }

    public void setCreateAtStr(String createAtStr) {
        this.createAtStr = createAtStr;
    }

    public Long getDayCount() {
        return dayCount;
    }

    public void setDayCount(Long dayCount) {
        this.dayCount = dayCount;
    }

    public String getOrderActivity() {
        return orderActivity;
    }

    public void setOrderActivity(String orderActivity) {
        this.orderActivity = orderActivity;
    }

    public String getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(String orderGoods) {
        this.orderGoods = orderGoods;
    }

    public Instant getNowTime() {
        return nowTime;
    }

    public void setNowTime(Instant nowTime) {
        this.nowTime = nowTime;
    }

    public Instant getAcceptAt() {
        return acceptAt;
    }

    public void setAcceptAt(Instant acceptAt) {
        this.acceptAt = acceptAt;
    }

    public Instant getSendShippingAt() {
        return sendShippingAt;
    }

    public void setSendShippingAt(Instant sendShippingAt) {
        this.sendShippingAt = sendShippingAt;
    }

    public Instant getTakeShippingAt() {
        return takeShippingAt;
    }

    public void setTakeShippingAt(Instant takeShippingAt) {
        this.takeShippingAt = takeShippingAt;
    }

    public Instant getFinishShippingAt() {
        return finishShippingAt;
    }

    public void setFinishShippingAt(Instant finishShippingAt) {
        this.finishShippingAt = finishShippingAt;
    }

    public Integer getShippingType() {
        return shippingType;
    }

    public void setShippingType(Integer shippingType) {
        this.shippingType = shippingType;
    }

    public Long getShipperId() {
        return shipperId;
    }

    public void setShipperId(Long shipperId) {
        this.shipperId = shipperId;
    }

    public String getShipperPhone() {
        return shipperPhone;
    }

    public void setShipperPhone(String shipperPhone) {
        this.shipperPhone = shipperPhone;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public Integer getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(Integer shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopCity() {
        return shopCity;
    }

    public void setShopCity(String shopCity) {
        this.shopCity = shopCity;
    }

    public Long getMasterUserId() {
        return masterUserId;
    }

    public void setMasterUserId(Long masterUserId) {
        this.masterUserId = masterUserId;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public OrderChannel getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(OrderChannel orderFrom) {
        this.orderFrom = orderFrom;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getActiveAt() {
        return activeAt;
    }

    public void setActiveAt(Instant activeAt) {
        this.activeAt = activeAt;
    }

    public Double getDeliverFee() {
        return deliverFee;
    }

    public void setDeliverFee(Double deliverFee) {
        this.deliverFee = deliverFee;
    }

    public Double getVipDeliveryFeeDiscount() {
        return vipDeliveryFeeDiscount;
    }

    public void setVipDeliveryFeeDiscount(Double vipDeliveryFeeDiscount) {
        this.vipDeliveryFeeDiscount = vipDeliveryFeeDiscount;
    }

    public Instant getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Instant deliverTime) {
        this.deliverTime = deliverTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public Boolean isBook() {
        return book;
    }

    public void setBook(Boolean book) {
        this.book = book;
    }

    public Boolean isOnlinePaid() {
        return onlinePaid;
    }

    public void setOnlinePaid(Boolean onlinePaid) {
        this.onlinePaid = onlinePaid;
    }

    public String getEleMeId() {
        return eleMeId;
    }

    public void setEleMeId(String eleMeId) {
        this.eleMeId = eleMeId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getDaySn() {
        return daySn;
    }

    public void setDaySn(Integer daySn) {
        this.daySn = daySn;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderRefundStatus getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(OrderRefundStatus refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getDeliveryGeo() {
        return deliveryGeo;
    }

    public void setDeliveryGeo(String deliveryGeo) {
        this.deliveryGeo = deliveryGeo;
    }

    public String getDeliveryPoiAddress() {
        return deliveryPoiAddress;
    }

    public void setDeliveryPoiAddress(String deliveryPoiAddress) {
        this.deliveryPoiAddress = deliveryPoiAddress;
    }

    public Boolean isInvoiced() {
        return invoiced;
    }

    public void setInvoiced(Boolean invoiced) {
        this.invoiced = invoiced;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getServiceRate() {
        return serviceRate;
    }

    public void setServiceRate(Double serviceRate) {
        this.serviceRate = serviceRate;
    }

    public Double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Double getHongbao() {
        return hongbao;
    }

    public void setHongbao(Double hongbao) {
        this.hongbao = hongbao;
    }

    public Double getPackageFee() {
        return packageFee;
    }

    public void setPackageFee(Double packageFee) {
        this.packageFee = packageFee;
    }

    public Double getActivityTotal() {
        return activityTotal;
    }

    public void setActivityTotal(Double activityTotal) {
        this.activityTotal = activityTotal;
    }

    public Double getShopPart() {
        return shopPart;
    }

    public void setShopPart(Double shopPart) {
        this.shopPart = shopPart;
    }

    public Double getElemePart() {
        return elemePart;
    }

    public void setElemePart(Double elemePart) {
        this.elemePart = elemePart;
    }

    public Boolean isDowngraded() {
        return downgraded;
    }

    public void setDowngraded(Boolean downgraded) {
        this.downgraded = downgraded;
    }

    public Instant getSecretPhoneExpireTime() {
        return secretPhoneExpireTime;
    }

    public void setSecretPhoneExpireTime(Instant secretPhoneExpireTime) {
        this.secretPhoneExpireTime = secretPhoneExpireTime;
    }

    public InvoiceType getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(InvoiceType invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getTaxpayerId() {
        return taxpayerId;
    }

    public void setTaxpayerId(String taxpayerId) {
        this.taxpayerId = taxpayerId;
    }

    public Double getColdBoxFee() {
        return coldBoxFee;
    }

    public void setColdBoxFee(Double coldBoxFee) {
        this.coldBoxFee = coldBoxFee;
    }

    public String getCancelOrderDescription() {
        return cancelOrderDescription;
    }

    public void setCancelOrderDescription(String cancelOrderDescription) {
        this.cancelOrderDescription = cancelOrderDescription;
    }

    public Instant getCancelOrderCreatedAt() {
        return cancelOrderCreatedAt;
    }

    public void setCancelOrderCreatedAt(Instant cancelOrderCreatedAt) {
        this.cancelOrderCreatedAt = cancelOrderCreatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CommonOrderDTO commonOrderDTO = (CommonOrderDTO) o;
        if (commonOrderDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), commonOrderDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CommonOrderDTO{" +
            "id=" + getId() +
            ", masterUserId=" + getMasterUserId() +
            ", platformId=" + getPlatformId() +
            ", merchantId=" + getMerchantId() +
            ", address='" + getAddress() + "'" +
            ", orderFrom='" + getOrderFrom() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", activeAt='" + getActiveAt() + "'" +
            ", deliverFee=" + getDeliverFee() +
            ", vipDeliveryFeeDiscount=" + getVipDeliveryFeeDiscount() +
            ", deliverTime='" + getDeliverTime() + "'" +
            ", description='" + getDescription() + "'" +
            ", invoice='" + getInvoice() + "'" +
            ", book='" + isBook() + "'" +
            ", onlinePaid='" + isOnlinePaid() + "'" +
            ", eleMeId='" + getEleMeId() + "'" +
            ", shopId=" + getShopId() +
            ", openId='" + getOpenId() + "'" +
            ", shopName='" + getShopName() + "'" +
            ", daySn=" + getDaySn() +
            ", status='" + getStatus() + "'" +
            ", refundStatus='" + getRefundStatus() + "'" +
            ", userId=" + getUserId() +
            ", totalPrice=" + getTotalPrice() +
            ", originalPrice=" + getOriginalPrice() +
            ", consignee='" + getConsignee() + "'" +
            ", deliveryGeo='" + getDeliveryGeo() + "'" +
            ", deliveryPoiAddress='" + getDeliveryPoiAddress() + "'" +
            ", invoiced='" + isInvoiced() + "'" +
            ", income=" + getIncome() +
            ", serviceRate=" + getServiceRate() +
            ", serviceFee=" + getServiceFee() +
            ", hongbao=" + getHongbao() +
            ", packageFee=" + getPackageFee() +
            ", activityTotal=" + getActivityTotal() +
            ", shopPart=" + getShopPart() +
            ", elemePart=" + getElemePart() +
            ", downgraded='" + isDowngraded() + "'" +
            ", secretPhoneExpireTime='" + getSecretPhoneExpireTime() + "'" +
            ", invoiceType='" + getInvoiceType() + "'" +
            ", taxpayerId='" + getTaxpayerId() + "'" +
            ", coldBoxFee=" + getColdBoxFee() +
            ", cancelOrderDescription='" + getCancelOrderDescription() + "'" +
            ", cancelOrderCreatedAt='" + getCancelOrderCreatedAt() + "'" +
            "}";
    }
}
