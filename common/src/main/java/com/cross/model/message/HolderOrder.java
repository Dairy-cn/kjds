package com.cross.model.message;


import com.cross.model.ShopFullReductionActivityDTO;
import com.cross.model.ShopOrderExtendedInfoDTO;
import com.cross.model.ShopOrderProductInfoDTO;
import com.cross.model.enumeration.OrderState;
import com.cross.model.enumeration.OrderType;
import com.cross.model.enumeration.SendDeliveryState;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author maxiaolin
 * @date 2020/3/3
 */
public class HolderOrder {

    private String enterpriseGuid;
    private String enterpriseName;
    private String storeGuid;
    private String storeName;

    /**
     * 商户ID
     */
    @ApiModelProperty(value = "商户ID", required = true)
    private Long merchantId;

    /**
     * 商户编号
     */
    @ApiModelProperty(value = "商户编号", required = true)
    private Long merchantNo;
    /**
     * 实际付款金额
     */
    @ApiModelProperty(value = "实际付款金额")
    private BigDecimal amount;
    private Long brandId;
    /**
     * 订单每日排序号码
     */
    @ApiModelProperty(value = "订单每日排序号码")
    private Integer dayCount;
    /**
     * 红包金额
     */
    private BigDecimal couponFee = new BigDecimal(0);

    /**
     * 红包id
     */
    private Long couponId;


    /**
     * 优惠金额
     */
    @ApiModelProperty(value = "优惠金额")
    private BigDecimal discountFee = new BigDecimal(0);
    /**
     * 满减金额
     */
    private BigDecimal fullReduction = new BigDecimal(0);
    /**
     * 参加的满减活动
     */
    private ShopFullReductionActivityDTO fullReductionActivity;

    /**
     * 商户用户编号
     */
    @ApiModelProperty(value = "商户用户编号", required = true)
    private Long merchantUserId;

    /**
     * 订单编号
     */
    @Size(max = 32)
    @ApiModelProperty(value = "订单编号", required = true)
    private String orderSn;
    /**
     * 订单状态
     */
    @ApiModelProperty(value = "订单状态")
    @Enumerated(EnumType.STRING)
    private OrderState orderState;
    /**
     * 订单类型
     */
    @ApiModelProperty(value = "订单类型")
    @Enumerated(EnumType.STRING)
    private OrderType orderType;
    /**
     * 打包费用
     */
    @ApiModelProperty(value = "打包费用")
    private BigDecimal packFee = new BigDecimal(0);


    /**
     * 支付方式 1 支付宝 2 微信 3 银行卡 4余额支付  5.免支付 6 掌控者会员卡支付 10.掌控者聚合支付
     */
    @ApiModelProperty(value = "支付方式")
    private Integer payWay;

    /**
     * 配送员名称
     */
    @ApiModelProperty(value = "配送员名称")
    private String personName;

    /**
     * 配送员电话
     */
    @ApiModelProperty(value = "配送员电话")
    private String personPhone;

    /**
     * 平台ID
     */
    @ApiModelProperty(value = "平台ID")
    private Long platformId;
    /**
     * 产品金额
     */
    @ApiModelProperty(value = "产品金额")
    private BigDecimal productFee = new BigDecimal(0);

    @ApiModelProperty(value = "配送费用，在自配送时需传入该字段")
    private BigDecimal sendPrice;

    @ApiModelProperty(value = "配送区域，在自配送时需传入该字段")
    private Integer rangeCode;
    /**
     * 申请退款原因
     */
    @Size(max = 1000)
    @ApiModelProperty(value = "申请退款原因")
    private String requestRefundsReason;
    /**
     * 分发状态
     */
    @ApiModelProperty(value = "分发状态")
    @Enumerated(EnumType.STRING)
    private SendDeliveryState sendDeliveryState = SendDeliveryState.UNSEND;
    /**
     * 分发时间
     */
    @ApiModelProperty(value = "分发时间")
    private Integer sendDeliveryTime;
    /**
     * 配送费用  在储值时 该值为赠送金额
     */
    @ApiModelProperty(value = "配送费用")
    private BigDecimal shippingFee = new BigDecimal(0);
    /**
     * 配送员电话
     */
    @ApiModelProperty(value = "订单扩展信息")
    private ShopOrderExtendedInfoDTO shopOrderExtendedInfoDTO;
    private List<ShopOrderProductInfoDTO> shopOrderProductInfoDTOS;
    /**
     * 订单未使用优惠前总价
     */
    @ApiModelProperty(value = "订单总价")
    private BigDecimal totalAmount;
    /**
     * 1:用户发起退款    2：商家发起的退款
     */
    @ApiModelProperty(value = "哪一端发起的退款")
    private Integer whoRefunds;

    public String getEnterpriseGuid() {
        return enterpriseGuid;
    }

    public void setEnterpriseGuid(String enterpriseGuid) {
        this.enterpriseGuid = enterpriseGuid;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public Integer getDayCount() {
        return dayCount;
    }

    public void setDayCount(Integer dayCount) {
        this.dayCount = dayCount;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getStoreGuid() {
        return storeGuid;
    }

    public void setStoreGuid(String storeGuid) {
        this.storeGuid = storeGuid;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(Long merchantNo) {
        this.merchantNo = merchantNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public BigDecimal getCouponFee() {
        return couponFee;
    }

    public void setCouponFee(BigDecimal couponFee) {
        this.couponFee = couponFee;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public BigDecimal getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(BigDecimal discountFee) {
        this.discountFee = discountFee;
    }

    public BigDecimal getFullReduction() {
        return fullReduction;
    }

    public void setFullReduction(BigDecimal fullReduction) {
        this.fullReduction = fullReduction;
    }

    public ShopFullReductionActivityDTO getFullReductionActivity() {
        return fullReductionActivity;
    }

    public void setFullReductionActivity(ShopFullReductionActivityDTO fullReductionActivity) {
        this.fullReductionActivity = fullReductionActivity;
    }

    public Long getMerchantUserId() {
        return merchantUserId;
    }

    public void setMerchantUserId(Long merchantUserId) {
        this.merchantUserId = merchantUserId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public BigDecimal getPackFee() {
        return packFee;
    }

    public void setPackFee(BigDecimal packFee) {
        this.packFee = packFee;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public BigDecimal getProductFee() {
        return productFee;
    }

    public void setProductFee(BigDecimal productFee) {
        this.productFee = productFee;
    }

    public BigDecimal getSendPrice() {
        return sendPrice;
    }

    public void setSendPrice(BigDecimal sendPrice) {
        this.sendPrice = sendPrice;
    }

    public Integer getRangeCode() {
        return rangeCode;
    }

    public void setRangeCode(Integer rangeCode) {
        this.rangeCode = rangeCode;
    }

    public String getRequestRefundsReason() {
        return requestRefundsReason;
    }

    public void setRequestRefundsReason(String requestRefundsReason) {
        this.requestRefundsReason = requestRefundsReason;
    }

    public SendDeliveryState getSendDeliveryState() {
        return sendDeliveryState;
    }

    public void setSendDeliveryState(SendDeliveryState sendDeliveryState) {
        this.sendDeliveryState = sendDeliveryState;
    }

    public Integer getSendDeliveryTime() {
        return sendDeliveryTime;
    }

    public void setSendDeliveryTime(Integer sendDeliveryTime) {
        this.sendDeliveryTime = sendDeliveryTime;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    public ShopOrderExtendedInfoDTO getShopOrderExtendedInfoDTO() {
        return shopOrderExtendedInfoDTO;
    }

    public void setShopOrderExtendedInfoDTO(ShopOrderExtendedInfoDTO shopOrderExtendedInfoDTO) {
        this.shopOrderExtendedInfoDTO = shopOrderExtendedInfoDTO;
    }

    public List<ShopOrderProductInfoDTO> getShopOrderProductInfoDTOS() {
        return shopOrderProductInfoDTOS;
    }

    public void setShopOrderProductInfoDTOS(List<ShopOrderProductInfoDTO> shopOrderProductInfoDTOS) {
        this.shopOrderProductInfoDTOS = shopOrderProductInfoDTOS;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getWhoRefunds() {
        return whoRefunds;
    }

    public void setWhoRefunds(Integer whoRefunds) {
        this.whoRefunds = whoRefunds;
    }
}
