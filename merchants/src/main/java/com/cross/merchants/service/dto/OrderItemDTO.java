package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.time.Instant;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchants.domain.OrderItem} entity.
 */
@ApiModel(description = "订单")
public class OrderItemDTO implements Serializable {

    private Long id;

    /**
     * 用户Id
     */
    @ApiModelProperty(value = "用户Id")
    private Long memberId;

    /**
     * 用户名称
     */
    @ApiModelProperty(value = "用户名称")
    private String memberName;

    /**
     * 用户手机号码
     */
    @ApiModelProperty(value = "用户手机号码")
    private String memberPhone;

    /**
     * 支付Id
     */
    @ApiModelProperty(value = "支付Id")
    private Long payOrderId;

    /**
     * 支付交易单号
     */
    @ApiModelProperty(value = "支付交易单号")
    private String payOrderPaymentCode;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String orderSn;

    /**
     * 提交时间
     */
    @ApiModelProperty(value = "提交时间")
    private Instant createTime;

    /**
     * 用户帐号
     */
    @ApiModelProperty(value = "用户帐号")
    private String memberUsername;

    /**
     * 订单总金额
     */
    @ApiModelProperty(value = "订单总金额")
    private BigDecimal totalAmount;

    /**
     * 应付金额（实际支付金额）
     */
    @ApiModelProperty(value = "应付金额（实际支付金额）")
    private BigDecimal payAmount;

    /**
     * 运费金额
     */
    @ApiModelProperty(value = "运费金额")
    private BigDecimal freightAmount;

    /**
     * 支付方式：0->未支付；1->支付宝；2->微信
     */
    @ApiModelProperty(value = "支付方式：0->未支付；1->支付宝；2->微信")
    private Integer payType;

    /**
     * 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
     */
    @ApiModelProperty(value = "订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单")
    private Integer status;

    private Integer orderType;

    /**
     * 物流公司(配送方式)
     */
    @ApiModelProperty(value = "物流公司(配送方式)")
    private String deliveryCompany;


    /**
     * 物流公司Code
     */
    @ApiModelProperty(value = "物流公司Code")
    private String deliveryCode;

    /**
     * 物流单号
     */
    @ApiModelProperty(value = "物流单号")
    private String deliverySn;

    /**
     * 自动确认时间（天）
     */
    @ApiModelProperty(value = "自动确认时间（天）")
    private Integer autoConfirmDay;

    /**
     * 收货人姓名
     */
    @ApiModelProperty(value = "收货人姓名")
    private String receiverName;

    /**
     * 收货人电话
     */
    @ApiModelProperty(value = "收货人电话")
    private String receiverPhone;

    /**
     * 收货人邮编
     */
    @ApiModelProperty(value = "收货人邮编")
    private String receiverPostCode;

    /**
     * 省份/直辖市
     */
    @ApiModelProperty(value = "省份/直辖市")
    private String receiverProvince;

    /**
     * 城市
     */
    @ApiModelProperty(value = "城市")
    private String receiverCity;

    /**
     * 区
     */
    @ApiModelProperty(value = "区")
    private String receiverRegion;

    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String receiverDetailAddress;

    /**
     * 订单备注
     */
    @ApiModelProperty(value = "订单备注")
    private String note;

    /**
     * 确认收货状态：0->未确认；1->已确认
     */
    @ApiModelProperty(value = "确认收货状态：0->未确认；1->已确认")
    private Integer confirmStatus;

    /**
     * 删除状态：0->未删除；1->已删除
     */
    @ApiModelProperty(value = "删除状态：0->未删除；1->已删除")
    private Integer deleteStatus;

    /**
     * 支付时间
     */
    @ApiModelProperty(value = "支付时间")
    private Instant paymentTime;

    /**
     * 发货时间
     */
    @ApiModelProperty(value = "发货时间")
    private Instant deliveryTime;

    /**
     * 确认收货时间
     */
    @ApiModelProperty(value = "确认收货时间")
    private Instant receiveTime;

    /**
     * 修评价时间改时间
     */
    @ApiModelProperty(value = "修评价时间改时间")
    private Instant commentTime;

    private Instant processingTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Instant modifyTime;


    /**
     * 产品店铺id
     */
    @ApiModelProperty(value = "产品店铺id")
    private Long productStoreId;

    /**
     * 产品店铺
     */
    @ApiModelProperty(value = "产品店铺")
    private String storeName;





    /**
     * 产品店铺编号
     */
    @ApiModelProperty(value = "产品店铺编号")
    private Long storeNo;



    /**
     * 促销优惠金额
     */
    @ApiModelProperty(value = "促销优惠金额")
    private BigDecimal promotionAmount;

    /**
     * 税费
     */
    @ApiModelProperty(value = "税费")
    private BigDecimal taxesFees;

    @ApiModelProperty(value = "产品信息")
    private List<GoodsDTO> productInfo;

    @ApiModelProperty(value = "发货状态 0 未发货 1 已发货")
    private Integer deliveryState;


    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称(集合拼接 用于查询)")
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

    public List<GoodsDTO> getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(List<GoodsDTO> productInfo) {
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

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public Long getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(Long payOrderId) {
        this.payOrderId = payOrderId;
    }

    public String getPayOrderPaymentCode() {
        return payOrderPaymentCode;
    }

    public void setPayOrderPaymentCode(String payOrderPaymentCode) {
        this.payOrderPaymentCode = payOrderPaymentCode;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public String getMemberUsername() {
        return memberUsername;
    }

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(BigDecimal freightAmount) {
        this.freightAmount = freightAmount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public String getDeliverySn() {
        return deliverySn;
    }

    public void setDeliverySn(String deliverySn) {
        this.deliverySn = deliverySn;
    }

    public Integer getAutoConfirmDay() {
        return autoConfirmDay;
    }

    public void setAutoConfirmDay(Integer autoConfirmDay) {
        this.autoConfirmDay = autoConfirmDay;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverPostCode() {
        return receiverPostCode;
    }

    public void setReceiverPostCode(String receiverPostCode) {
        this.receiverPostCode = receiverPostCode;
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverRegion() {
        return receiverRegion;
    }

    public void setReceiverRegion(String receiverRegion) {
        this.receiverRegion = receiverRegion;
    }

    public String getReceiverDetailAddress() {
        return receiverDetailAddress;
    }

    public void setReceiverDetailAddress(String receiverDetailAddress) {
        this.receiverDetailAddress = receiverDetailAddress;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(Integer confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Instant getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Instant paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Instant getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Instant deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Instant getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Instant receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Instant getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Instant commentTime) {
        this.commentTime = commentTime;
    }

    public Instant getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(Instant processingTime) {
        this.processingTime = processingTime;
    }

    public Instant getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Instant modifyTime) {
        this.modifyTime = modifyTime;
    }



    public Long getProductStoreId() {
        return productStoreId;
    }

    public void setProductStoreId(Long productStoreId) {
        this.productStoreId = productStoreId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(Long storeNo) {
        this.storeNo = storeNo;
    }


    public BigDecimal getPromotionAmount() {
        return promotionAmount;
    }

    public void setPromotionAmount(BigDecimal promotionAmount) {
        this.promotionAmount = promotionAmount;
    }

    public BigDecimal getTaxesFees() {
        return taxesFees;
    }

    public void setTaxesFees(BigDecimal taxesFees) {
        this.taxesFees = taxesFees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OrderItemDTO orderItemDTO = (OrderItemDTO) o;
        if (orderItemDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), orderItemDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "OrderItemDTO{" +
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
