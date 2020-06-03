package com.cross.merchants.domain;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * 订单
 */
@Entity
@Table(name = "order_item")
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户Id
     */
    @Column(name = "member_id")
    private Long memberId;

    /**
     * 用户名称
     */
    @Column(name = "member_name")
    private String memberName;

    /**
     * 用户手机号码
     */
    @Column(name = "member_phone")
    private String memberPhone;

    /**
     * 支付Id
     */
    @Column(name = "pay_order_id")
    private Long payOrderId;

    /**
     * 支付交易单号
     */
    @Column(name = "pay_order_payment_code")
    private String payOrderPaymentCode;

    /**
     * 订单编号
     */
    @Column(name = "order_sn")
    private String orderSn;

    /**
     * 提交时间
     */
    @Column(name = "create_time")
    private Instant createTime;

    /**
     * 用户帐号
     */
    @Column(name = "member_username")
    private String memberUsername;

    /**
     * 订单总金额
     */
    @Column(name = "total_amount", precision = 21, scale = 2)
    private BigDecimal totalAmount;

    /**
     * 应付金额（实际支付金额）
     */
    @Column(name = "pay_amount", precision = 21, scale = 2)
    private BigDecimal payAmount;

    /**
     * 运费金额
     */
    @Column(name = "freight_amount", precision = 21, scale = 2)
    private BigDecimal freightAmount;

    /**
     * 支付方式：0->未支付；1->支付宝；2->微信
     */
    @Column(name = "pay_type")
    private Integer payType;

    /**
     * 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
     */
    @Column(name = "status")
    private Integer status;

    @Column(name = "order_type")
    private Integer orderType;

    /**
     * 物流公司(配送方式)
     */
    @Column(name = "delivery_company")
    private String deliveryCompany;

    /**
     * 物流单号
     */
    @Column(name = "delivery_sn")
    private String deliverySn;

    /**
     * 自动确认时间（天）
     */
    @Column(name = "auto_confirm_day")
    private Integer autoConfirmDay;

    /**
     * 收货人姓名
     */
    @Column(name = "receiver_name")
    private String receiverName;

    /**
     * 收货人电话
     */
    @Column(name = "receiver_phone")
    private String receiverPhone;

    /**
     * 收货人邮编
     */
    @Column(name = "receiver_post_code")
    private String receiverPostCode;

    /**
     * 省份/直辖市
     */
    @Column(name = "receiver_province")
    private String receiverProvince;

    /**
     * 城市
     */
    @Column(name = "receiver_city")
    private String receiverCity;

    /**
     * 区
     */
    @Column(name = "receiver_region")
    private String receiverRegion;

    /**
     * 详细地址
     */
    @Column(name = "receiver_detail_address")
    private String receiverDetailAddress;

    /**
     * 订单备注
     */
    @Column(name = "note")
    private String note;

    /**
     * 确认收货状态：0->未确认；1->已确认
     */
    @Column(name = "confirm_status")
    private Integer confirmStatus;

    /**
     * 删除状态：0->未删除；1->已删除
     */
    @Column(name = "delete_status")
    private Integer deleteStatus;

    /**
     * 支付时间
     */
    @Column(name = "payment_time")
    private Instant paymentTime;

    /**
     * 发货时间
     */
    @Column(name = "delivery_time")
    private Instant deliveryTime;

    /**
     * 确认收货时间
     */
    @Column(name = "receive_time")
    private Instant receiveTime;

    /**
     * 修评价时间改时间
     */
    @Column(name = "comment_time")
    private Instant commentTime;

    @Column(name = "processing_time")
    private Instant processingTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Instant modifyTime;


    /**
     * 产品店铺id
     */
    @Column(name = "product_store_id")
    private Long productStoreId;

    /**
     * 产品店铺
     */
    @Column(name = "store_name")
    private String storeName;

    /**
     * 产品店铺编号
     */
    @Column(name = "store_no")
    private Long storeNo;


    /**
     * 促销优化金额
     */
    @Column(name = "promotion_amount", precision = 21, scale = 2)
    private BigDecimal promotionAmount;

    /**
     * 税费
     */
    @Column(name = "taxes_fees", precision = 21, scale = 2)
    private BigDecimal taxesFees;

    /**
     * 产品信息
     */
    @Column(name = "product_info")
    private String productInfo;


    /**
     * 物流公司Code
     */
    @ApiModelProperty(value = "物流公司Code")
    @Column(name = "delivery_code")
    private String deliveryCode;
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove

    @ApiModelProperty(value = "发货状态 0 未发货 1 已发货")
    @Column(name = "delivery_state")
    private Integer deliveryState;


    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    @Column(name = "goods_name")
    private String goodsName;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(Integer deliveryState) {
        this.deliveryState = deliveryState;
    }

    public String getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public OrderItem memberId(Long memberId) {
        this.memberId = memberId;
        return this;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public OrderItem memberName(String memberName) {
        this.memberName = memberName;
        return this;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public OrderItem memberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
        return this;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public Long getPayOrderId() {
        return payOrderId;
    }

    public OrderItem payOrderId(Long payOrderId) {
        this.payOrderId = payOrderId;
        return this;
    }

    public void setPayOrderId(Long payOrderId) {
        this.payOrderId = payOrderId;
    }

    public String getPayOrderPaymentCode() {
        return payOrderPaymentCode;
    }

    public OrderItem payOrderPaymentCode(String payOrderPaymentCode) {
        this.payOrderPaymentCode = payOrderPaymentCode;
        return this;
    }

    public void setPayOrderPaymentCode(String payOrderPaymentCode) {
        this.payOrderPaymentCode = payOrderPaymentCode;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public OrderItem orderSn(String orderSn) {
        this.orderSn = orderSn;
        return this;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public OrderItem createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public String getMemberUsername() {
        return memberUsername;
    }

    public OrderItem memberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
        return this;
    }

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public OrderItem totalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public OrderItem payAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
        return this;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getFreightAmount() {
        return freightAmount;
    }

    public OrderItem freightAmount(BigDecimal freightAmount) {
        this.freightAmount = freightAmount;
        return this;
    }

    public void setFreightAmount(BigDecimal freightAmount) {
        this.freightAmount = freightAmount;
    }

    public Integer getPayType() {
        return payType;
    }

    public OrderItem payType(Integer payType) {
        this.payType = payType;
        return this;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getStatus() {
        return status;
    }

    public OrderItem status(Integer status) {
        this.status = status;
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public OrderItem orderType(Integer orderType) {
        this.orderType = orderType;
        return this;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public OrderItem deliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
        return this;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public String getDeliverySn() {
        return deliverySn;
    }

    public OrderItem deliverySn(String deliverySn) {
        this.deliverySn = deliverySn;
        return this;
    }

    public void setDeliverySn(String deliverySn) {
        this.deliverySn = deliverySn;
    }

    public Integer getAutoConfirmDay() {
        return autoConfirmDay;
    }

    public OrderItem autoConfirmDay(Integer autoConfirmDay) {
        this.autoConfirmDay = autoConfirmDay;
        return this;
    }

    public void setAutoConfirmDay(Integer autoConfirmDay) {
        this.autoConfirmDay = autoConfirmDay;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public OrderItem receiverName(String receiverName) {
        this.receiverName = receiverName;
        return this;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public OrderItem receiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
        return this;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverPostCode() {
        return receiverPostCode;
    }

    public OrderItem receiverPostCode(String receiverPostCode) {
        this.receiverPostCode = receiverPostCode;
        return this;
    }

    public void setReceiverPostCode(String receiverPostCode) {
        this.receiverPostCode = receiverPostCode;
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public OrderItem receiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
        return this;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public OrderItem receiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
        return this;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverRegion() {
        return receiverRegion;
    }

    public OrderItem receiverRegion(String receiverRegion) {
        this.receiverRegion = receiverRegion;
        return this;
    }

    public void setReceiverRegion(String receiverRegion) {
        this.receiverRegion = receiverRegion;
    }

    public String getReceiverDetailAddress() {
        return receiverDetailAddress;
    }

    public OrderItem receiverDetailAddress(String receiverDetailAddress) {
        this.receiverDetailAddress = receiverDetailAddress;
        return this;
    }

    public void setReceiverDetailAddress(String receiverDetailAddress) {
        this.receiverDetailAddress = receiverDetailAddress;
    }

    public String getNote() {
        return note;
    }

    public OrderItem note(String note) {
        this.note = note;
        return this;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getConfirmStatus() {
        return confirmStatus;
    }

    public OrderItem confirmStatus(Integer confirmStatus) {
        this.confirmStatus = confirmStatus;
        return this;
    }

    public void setConfirmStatus(Integer confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public OrderItem deleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
        return this;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Instant getPaymentTime() {
        return paymentTime;
    }

    public OrderItem paymentTime(Instant paymentTime) {
        this.paymentTime = paymentTime;
        return this;
    }

    public void setPaymentTime(Instant paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Instant getDeliveryTime() {
        return deliveryTime;
    }

    public OrderItem deliveryTime(Instant deliveryTime) {
        this.deliveryTime = deliveryTime;
        return this;
    }

    public void setDeliveryTime(Instant deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Instant getReceiveTime() {
        return receiveTime;
    }

    public OrderItem receiveTime(Instant receiveTime) {
        this.receiveTime = receiveTime;
        return this;
    }

    public void setReceiveTime(Instant receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Instant getCommentTime() {
        return commentTime;
    }

    public OrderItem commentTime(Instant commentTime) {
        this.commentTime = commentTime;
        return this;
    }

    public void setCommentTime(Instant commentTime) {
        this.commentTime = commentTime;
    }

    public Instant getProcessingTime() {
        return processingTime;
    }

    public OrderItem processingTime(Instant processingTime) {
        this.processingTime = processingTime;
        return this;
    }

    public void setProcessingTime(Instant processingTime) {
        this.processingTime = processingTime;
    }

    public Instant getModifyTime() {
        return modifyTime;
    }

    public OrderItem modifyTime(Instant modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public void setModifyTime(Instant modifyTime) {
        this.modifyTime = modifyTime;
    }


    public Long getProductStoreId() {
        return productStoreId;
    }

    public OrderItem productStoreId(Long productStoreId) {
        this.productStoreId = productStoreId;
        return this;
    }

    public void setProductStoreId(Long productStoreId) {
        this.productStoreId = productStoreId;
    }

    public String getStoreName() {
        return storeName;
    }

    public OrderItem storeName(String storeName) {
        this.storeName = storeName;
        return this;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getStoreNo() {
        return storeNo;
    }

    public OrderItem storeNo(Long storeNo) {
        this.storeNo = storeNo;
        return this;
    }

    public void setStoreNo(Long storeNo) {
        this.storeNo = storeNo;
    }


    public BigDecimal getPromotionAmount() {
        return promotionAmount;
    }

    public OrderItem promotionAmount(BigDecimal promotionAmount) {
        this.promotionAmount = promotionAmount;
        return this;
    }

    public void setPromotionAmount(BigDecimal promotionAmount) {
        this.promotionAmount = promotionAmount;
    }

    public BigDecimal getTaxesFees() {
        return taxesFees;
    }

    public OrderItem taxesFees(BigDecimal taxesFees) {
        this.taxesFees = taxesFees;
        return this;
    }

    public void setTaxesFees(BigDecimal taxesFees) {
        this.taxesFees = taxesFees;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OrderItem)) {
            return false;
        }
        return id != null && id.equals(((OrderItem) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
            "id=" + getId() +
            ", memberId=" + getMemberId() +
            ", memberName='" + getMemberName() + "'" +
            ", memberPhone='" + getMemberPhone() + "'" +
            ", payOrderId=" + getPayOrderId() +
            ", payOrderPaymentCode=" + getPayOrderPaymentCode() +
            ", orderSn='" + getOrderSn() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", memberUsername='" + getMemberUsername() + "'" +
            ", totalAmount=" + getTotalAmount() +
            ", payAmount=" + getPayAmount() +
            ", freightAmount=" + getFreightAmount() +
            ", payType=" + getPayType() +
            ", status=" + getStatus() +
            ", orderType=" + getOrderType() +
            ", deliveryCompany='" + getDeliveryCompany() + "'" +
            ", deliverySn='" + getDeliverySn() + "'" +
            ", autoConfirmDay=" + getAutoConfirmDay() +
            ", receiverName='" + getReceiverName() + "'" +
            ", receiverPhone='" + getReceiverPhone() + "'" +
            ", receiverPostCode='" + getReceiverPostCode() + "'" +
            ", receiverProvince='" + getReceiverProvince() + "'" +
            ", receiverCity='" + getReceiverCity() + "'" +
            ", receiverRegion='" + getReceiverRegion() + "'" +
            ", receiverDetailAddress='" + getReceiverDetailAddress() + "'" +
            ", note='" + getNote() + "'" +
            ", confirmStatus=" + getConfirmStatus() +
            ", deleteStatus=" + getDeleteStatus() +
            ", paymentTime='" + getPaymentTime() + "'" +
            ", deliveryTime='" + getDeliveryTime() + "'" +
            ", receiveTime='" + getReceiveTime() + "'" +
            ", commentTime='" + getCommentTime() + "'" +
            ", processingTime='" + getProcessingTime() + "'" +
            ", modifyTime='" + getModifyTime() + "'" +
            ", productStoreId=" + getProductStoreId() +
            ", storeName=" + getStoreName() +
            ", storeNo=" + getStoreNo() +
            ", promotionAmount=" + getPromotionAmount() +
            ", taxesFees=" + getTaxesFees() +
            "}";
    }
}
