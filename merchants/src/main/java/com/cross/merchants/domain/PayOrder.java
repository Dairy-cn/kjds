package com.cross.merchants.domain;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * 支付支付订单
 */
@Entity
@Table(name = "pay_order")
public class PayOrder implements Serializable {

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
     * 订单来源：0->PC订单；1->app订单
     */
    @Column(name = "source_type")
    private Integer sourceType;

    /**
     * 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
     */
    @Column(name = "status")
    private Integer status;

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

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Instant modifyTime;

    @Column(name = "promotion_amount")
    private BigDecimal promotionAmount;



    @ApiModelProperty("微信或支付宝方支付编号")
    @Column(name = "transaction_id")
    private String transactionId;

    public String getTransactionId() {
        return transactionId;
    }
    public PayOrder transactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getPromotionAmount() {
        return promotionAmount;
    }
    public PayOrder promotionAmount(BigDecimal promotionAmount) {
        this.promotionAmount = promotionAmount;
        return this;
    }
    public void setPromotionAmount(BigDecimal promotionAmount) {
        this.promotionAmount = promotionAmount;
    }

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public PayOrder memberId(Long memberId) {
        this.memberId = memberId;
        return this;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public PayOrder orderSn(String orderSn) {
        this.orderSn = orderSn;
        return this;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public PayOrder createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public String getMemberUsername() {
        return memberUsername;
    }

    public PayOrder memberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
        return this;
    }

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public PayOrder totalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public PayOrder payAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
        return this;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getFreightAmount() {
        return freightAmount;
    }

    public PayOrder freightAmount(BigDecimal freightAmount) {
        this.freightAmount = freightAmount;
        return this;
    }

    public void setFreightAmount(BigDecimal freightAmount) {
        this.freightAmount = freightAmount;
    }

    public Integer getPayType() {
        return payType;
    }

    public PayOrder payType(Integer payType) {
        this.payType = payType;
        return this;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public PayOrder sourceType(Integer sourceType) {
        this.sourceType = sourceType;
        return this;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getStatus() {
        return status;
    }

    public PayOrder status(Integer status) {
        this.status = status;
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public PayOrder deliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
        return this;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public String getDeliverySn() {
        return deliverySn;
    }

    public PayOrder deliverySn(String deliverySn) {
        this.deliverySn = deliverySn;
        return this;
    }

    public void setDeliverySn(String deliverySn) {
        this.deliverySn = deliverySn;
    }

    public Integer getAutoConfirmDay() {
        return autoConfirmDay;
    }

    public PayOrder autoConfirmDay(Integer autoConfirmDay) {
        this.autoConfirmDay = autoConfirmDay;
        return this;
    }

    public void setAutoConfirmDay(Integer autoConfirmDay) {
        this.autoConfirmDay = autoConfirmDay;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public PayOrder receiverName(String receiverName) {
        this.receiverName = receiverName;
        return this;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public PayOrder receiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
        return this;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverPostCode() {
        return receiverPostCode;
    }

    public PayOrder receiverPostCode(String receiverPostCode) {
        this.receiverPostCode = receiverPostCode;
        return this;
    }

    public void setReceiverPostCode(String receiverPostCode) {
        this.receiverPostCode = receiverPostCode;
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public PayOrder receiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
        return this;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public PayOrder receiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
        return this;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverRegion() {
        return receiverRegion;
    }

    public PayOrder receiverRegion(String receiverRegion) {
        this.receiverRegion = receiverRegion;
        return this;
    }

    public void setReceiverRegion(String receiverRegion) {
        this.receiverRegion = receiverRegion;
    }

    public String getReceiverDetailAddress() {
        return receiverDetailAddress;
    }

    public PayOrder receiverDetailAddress(String receiverDetailAddress) {
        this.receiverDetailAddress = receiverDetailAddress;
        return this;
    }

    public void setReceiverDetailAddress(String receiverDetailAddress) {
        this.receiverDetailAddress = receiverDetailAddress;
    }

    public String getNote() {
        return note;
    }

    public PayOrder note(String note) {
        this.note = note;
        return this;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getConfirmStatus() {
        return confirmStatus;
    }

    public PayOrder confirmStatus(Integer confirmStatus) {
        this.confirmStatus = confirmStatus;
        return this;
    }

    public void setConfirmStatus(Integer confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public PayOrder deleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
        return this;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Instant getPaymentTime() {
        return paymentTime;
    }

    public PayOrder paymentTime(Instant paymentTime) {
        this.paymentTime = paymentTime;
        return this;
    }

    public void setPaymentTime(Instant paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Instant getDeliveryTime() {
        return deliveryTime;
    }

    public PayOrder deliveryTime(Instant deliveryTime) {
        this.deliveryTime = deliveryTime;
        return this;
    }

    public void setDeliveryTime(Instant deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Instant getReceiveTime() {
        return receiveTime;
    }

    public PayOrder receiveTime(Instant receiveTime) {
        this.receiveTime = receiveTime;
        return this;
    }

    public void setReceiveTime(Instant receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Instant getCommentTime() {
        return commentTime;
    }

    public PayOrder commentTime(Instant commentTime) {
        this.commentTime = commentTime;
        return this;
    }

    public void setCommentTime(Instant commentTime) {
        this.commentTime = commentTime;
    }

    public Instant getModifyTime() {
        return modifyTime;
    }

    public PayOrder modifyTime(Instant modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public void setModifyTime(Instant modifyTime) {
        this.modifyTime = modifyTime;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PayOrder)) {
            return false;
        }
        return id != null && id.equals(((PayOrder) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "PayOrder{" +
            "id=" + getId() +
            ", memberId=" + getMemberId() +
            ", orderSn='" + getOrderSn() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", memberUsername='" + getMemberUsername() + "'" +
            ", totalAmount=" + getTotalAmount() +
            ", payAmount=" + getPayAmount() +
            ", freightAmount=" + getFreightAmount() +
            ", payType=" + getPayType() +
            ", sourceType=" + getSourceType() +
            ", status=" + getStatus() +
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
            ", modifyTime='" + getModifyTime() + "'" +
            "}";
    }
}
