package com.cross.model;

import com.cross.model.enumeration.*;
import com.cross.utils.JsonUtil;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * 订单
 */
public class ShopOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 订单编号
     */
    @NotNull
    @Size(max = 32)
    @ApiModelProperty(value = "订单编号", required = true)
    @Column(name = "order_sn", length = 32, nullable = false)
    private String orderSn;

    /**
     * 消费者编号
     */
    @NotNull
    @ApiModelProperty(value = "消费者编号", required = true)
    @Column(name = "consumer_id", nullable = false)
    private Long consumerId;

    /**
     * 商户编号
     */
    @NotNull
    @ApiModelProperty(value = "商户编号", required = true)
    @Column(name = "merchant_id", nullable = false)
    private Long merchantId;

    /**
     * 商户编号
     */
    @ApiModelProperty(value = "商户编号", required = true)
    @Column(name = "merchant_no", nullable = false)
    private Long merchantNo;

    /**
     * 商户用户编号
     */
    @NotNull
    @ApiModelProperty(value = "商户用户编号", required = true)
    @Column(name = "merchant_user_id", nullable = false)
    private Long merchantUserId;

    /**
     * 产品金额
     */
    @ApiModelProperty(value = "产品金额")
    @Column(name = "product_fee")
    private Double productFee;

    /**
     * 优惠金额
     */
    @ApiModelProperty(value = "优惠金额")
    @Column(name = "discount_fee")
    private Double discountFee;

    /**
     * 红包金额
     */
    @ApiModelProperty(value = "红包金额")
    @Column(name = "coupon_fee")
    private Double couponFee = 0d;

    /**
     * 红包id
     */
    @ApiModelProperty(value = "红包id")
    @Column(name = "coupon_id")
    private Long couponId;
    /**
     * 满减金额
     */
    @ApiModelProperty(value = "满减金额")
    @Column(name = "full_reduction")
    private Double fullReduction;

    /**
     * 打包费用
     */
    @ApiModelProperty(value = "打包费用")
    @Column(name = "pack_fee")
    private Double packFee;

    /**
     * 配送费用
     */
    @ApiModelProperty(value = "配送费用")
    @Column(name = "shipping_fee")
    private Double shippingFee;

    /**
     * 实际付款金额
     */
    @ApiModelProperty(value = "实际付款金额")
    @Column(name = "amount")
    private Double amount;

    /**
     * 订单状态
     */
    @ApiModelProperty(value = "订单状态")
    @Enumerated(EnumType.STRING)
    @Column(name = "order_state")
    private OrderState orderState;

    /**
     * 支付状态
     */
    @ApiModelProperty(value = "支付状态")
    @Enumerated(EnumType.STRING)
    @Column(name = "pay_state")
    private PayState payState = PayState.UNPAY;

    /**
     * 支付方式 1 支付宝 2| 0 微信 3 银行卡 4余额支付  5.免支付
     */
    @ApiModelProperty(value = "支付方式")
    @Column(name = "pay_way")
    private Integer payWay;

    /**
     * 支付时间
     */
    @ApiModelProperty(value = "支付时间")
    @Column(name = "pay_time")
    private Integer payTime;

    /**
     * 支付地址
     */
    @ApiModelProperty(value = "支付时间")
    @Column(name = "pay_url")
    private String payUrl;

    /**
     * 打印状态
     */
    @ApiModelProperty(value = "打印状态")
    @Enumerated(EnumType.STRING)
    @Column(name = "print_state")
    private PrintState printState = PrintState.UNPRINT;

    /**
     * 打印时间
     */
    @ApiModelProperty(value = "打印时间")
    @Column(name = "print_time")
    private Integer printTime;

    /**
     * 分发状态
     */
    @ApiModelProperty(value = "分发状态")
    @Enumerated(EnumType.STRING)
    @Column(name = "send_delivery_state")
    private SendDeliveryState sendDeliveryState = SendDeliveryState.UNSEND;

    /**
     * 分发时间
     */
    @ApiModelProperty(value = "分发时间")
    @Column(name = "send_delivery_time")
    private Integer sendDeliveryTime;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @Column(name = "add_time")
    private Integer addTime;

    /**
     * 创建ip
     */
    @ApiModelProperty(value = "创建ip")
    @Column(name = "add_ip")
    private String addIp;

    /**
     * 未完成订单原因
     */
    @Size(max = 1000)
    @ApiModelProperty(value = "未完成订单原因")
    @Column(name = "unfinished_reason", length = 1000)
    private String unfinishedReason;

    /**
     * 催单次数
     */
    @ApiModelProperty(value = "催单次数")
    @Column(name = "reminders_count")
    private Integer remindersCount;

    /**
     * 商户确认催单 0未催单  1 催单中  2 商户已确认
     */
    @ApiModelProperty(value = "商户确认催单")
    @Column(name = "reminders_flag")
    private Integer remindersFlag = 0;

    /**
     * 商户撤单
     */
    @ApiModelProperty(value = "商户撤单")
    @Column(name = "merchant_revoked")
    private Boolean merchantRevoked = false;

    /**
     * 是否收货
     */
    @ApiModelProperty(value = "是否收货")
    @Column(name = "receipt")
    private Boolean receipt = false;

    /**
     * 是否申请退款
     */
    @ApiModelProperty(value = "是否申请退款")
    @Column(name = "request_refunds")
    private Boolean requestRefunds;

    /**
     * 是否退款成功
     */
    @ApiModelProperty(value = "是否退款成功")
    @Column(name = "refunds_success")
    private Boolean refundsSuccess;

    /**
     * 申请退款原因
     */
    @Size(max = 1000)
    @ApiModelProperty(value = "申请退款原因")
    @Column(name = "request_refunds_reason")
    private String requestRefundsReason;

    /**
     * 商户确认退款
     */
    @ApiModelProperty(value = "商户确认退款")
    @Column(name = "merchant_refunds")
    private Boolean merchantRefunds;

    /**
     * 商户拒绝退款原因
     */
    @Size(max = 1000)
    @ApiModelProperty(value = "商户拒绝退款原因")
    @Column(name = "merchant_refunds_reason")
    private String merchantRefundsReason;

    /**
     * 是否申请退款标志  通过此标志查询数据  当为false时  不用判断requestRefunds  当为true时  判断requestRefunds为false
     */
    @ApiModelProperty(value = "是否申请退款标志")
    @Column(name = "request_refunds_flag")
    private Boolean requestRefundsFlag = false;

    /**
     * 订单类型
     */
    @ApiModelProperty(value = "订单类型")
    @Enumerated(EnumType.STRING)
    @Column(name = "order_type")
    private OrderType orderType;

    /**
     * 配送员名称
     */
    @ApiModelProperty(value = "配送员名称")
    @Column(name = "person_name")
    private String personName;

    /**
     * 配送员电话
     */
    @ApiModelProperty(value = "配送员电话")
    @Column(name = "person_phone")
    private String personPhone;

    /**
     * 用户电话
     */
    @ApiModelProperty(value = "用户电话")
    @Column(name = "consumer_phone")
    private String consumerPhone;

    /**
     * 商户电话
     */
    @ApiModelProperty(value = "商户电话")
    @Column(name = "merchant_phone")
    private String merchantPhone;

    /**
     * 平台用户ID
     */
    @ApiModelProperty(value = "平台用户ID")
    @Column(name = "platform_user_id")
    private Long platformUserId;

    /**
     * 平台ID
     */
    @ApiModelProperty(value = "平台ID")
    @Column(name = "platform_id")
    private Long platformId;

    /**
     * 平台ID
     */
    @ApiModelProperty(value = "平台ID")
    @Column(name = "brand_id")
    private Long brandId;

    /**
     * 佣金比例
     */
    @ApiModelProperty(value = "佣金比例")
    @Column(name = "brokerage")
    private Double brokerage;

    /**
     * 佣金
     */
    @ApiModelProperty(value = "佣金")
    @Column(name = "brokerage_amount")
    private Double brokerageAmount;

    @ApiModelProperty(value = "是否统计")
    @Column(name = "count_flag")
    private Boolean countFlag;

    @ApiModelProperty(value = "是否评论")
    @Column(name = "comment_flag")
    private Boolean commentFlag = false;

    /**
     * 操作时间
     */
    @ApiModelProperty(value = "操作时间")
    @Column(name = "operate_time")
    private Integer operateTime;

    /**
     * 订单每日排序号码
     */
    @ApiModelProperty(value = "订单每日排序号码")
    @Column(name = "day_count")
    private Integer dayCount;

    /**
     * 合伙人编号
     */
    @ApiModelProperty(value = "合伙人编号")
    @Column(name = "code")
    private Long code;

    /**
     * 分享用户ID
     */
    @ApiModelProperty(value = "分享用户ID")
    @Column(name = "share_user_id")
    private Long shareUserId;

    @ApiModelProperty(value = "扩展信息")
    @Lob
    @Column(name = "extended_info")
    private ShopOrderExtendedInfoDTO shopOrderExtendedInfoDTO;

    @ApiModelProperty(value = "产品信息")
    @Lob
    private List<ShopOrderProductInfoDTO> shopOrderProductInfoDTOS;

    @ApiModelProperty(value = "优惠详情")
    private String discountDetail;

    @ApiModelProperty(value = "订单活动")
    private List<OrderActivity> orderActivityList;

    @ApiModelProperty(value = "满减活动")
    private ShopFullReductionActivityDTO fullReductionActivity;

    /**
     * 外部门店编码：将外部门店和我们的店铺进行关联
     */
    @ApiModelProperty(value = "外部门店编码")
    @Column(name = "external_merchant_no")
    private String externalMerchantNo;

    /**
     * 外部商户编码：关联外部品牌
     */
    @ApiModelProperty(value = "外部商户编码")
    @Column(name = "external_brand_no")
    private String externalBrandNo;

    /**
     * 外部商户编码：关联外部品牌
     */
    @ApiModelProperty(value = "外部商户编码")
    @Column(name = "third_party_type")
    private ThirdPartyType thirdPartyType;

    @ApiModelProperty(value = "霸王餐活动id")
    @Column(name = "island_free_lunch_id")
    private Long islandFreeLunchId;

    @ApiModelProperty(value = "霸王餐中奖纪录id")
    @Column(name = "info_id")
    private Long infoId;

    /**卡券有效期 */
    @ApiModelProperty(value = "卡券有效期兑换后 有效天数")
    @Column(name = "product_effective_days")
    private Integer productEffectiveDays;

    @ApiModelProperty(value = "使用规则")
    @Column(name = "use_rules")
    private String useRules;


    public ShopOrder() {

    }

    public ShopOrder(ShopOrderDTO shopOrderDTO) {
        this(shopOrderDTO.getId(), shopOrderDTO.getOrderSn(), shopOrderDTO.getConsumerId(), shopOrderDTO.getMerchantId(), shopOrderDTO.getMerchantUserId(),
            shopOrderDTO.getProductFee(), shopOrderDTO.getDiscountFee(), shopOrderDTO.getPackFee(), shopOrderDTO.getShippingFee(), shopOrderDTO.getAmount(),
            shopOrderDTO.getOrderState(), shopOrderDTO.getPayState(), shopOrderDTO.getPayTime(), shopOrderDTO.getPayWay(), shopOrderDTO.getPrintState(),
            shopOrderDTO.getPrintTime(), shopOrderDTO.getSendDeliveryTime(), shopOrderDTO.getAddTime(), shopOrderDTO.getAddIp(),
            shopOrderDTO.getUnfinishedReason(), shopOrderDTO.getRemindersCount(), shopOrderDTO.isMerchantRevoked(), shopOrderDTO.getOrderType(),
            shopOrderDTO.getPersonName(), shopOrderDTO.getPersonPhone(), shopOrderDTO.isReceipt(), shopOrderDTO.isRequestRefunds(), shopOrderDTO.isRefundsSuccess(),
            shopOrderDTO.getRequestRefundsReason(), shopOrderDTO.isMerchantRefunds(), shopOrderDTO.getMerchantRefundsReason(), shopOrderDTO.isRequestRefundsFlag(),
            shopOrderDTO.getPlatformUserId(), shopOrderDTO.getPlatformId(), shopOrderDTO.getBrokerage(), shopOrderDTO.getBrokerageAmount(), shopOrderDTO.isCountFlag(),
            shopOrderDTO.getPayUrl(), shopOrderDTO.getMerchantNo(), shopOrderDTO.isCommentFlag(), shopOrderDTO.getOperateTime(), shopOrderDTO.getDayCount(), shopOrderDTO.getMerchantPhone(),
            shopOrderDTO.getDiscountDetail(), shopOrderDTO.getRemindersFlag(), shopOrderDTO.getBrandId(),shopOrderDTO.getCouponFee(),shopOrderDTO.getCouponId(),shopOrderDTO.getFullReduction(),
            shopOrderDTO.getCode(), shopOrderDTO.getShareUserId(),shopOrderDTO.getExternalBrandNo(),shopOrderDTO.getExternalMerchantNo(),shopOrderDTO.getThirdPartyType(),
            shopOrderDTO.getIslandFreeLunchId(),shopOrderDTO.getInfoId(),shopOrderDTO.getProductEffectiveDays(), JsonUtil.objectToJson(shopOrderDTO.getUseRules()));

    }

    public ShopOrder(Long id, String orderSn, Long consumerId, Long merchantId, Long merchantUserId, Double productFee, Double discountFee, Double packFee,
                     Double shippingFee, Double amount, OrderState orderState, PayState payState, Integer payTime, Integer payWay, PrintState printState, Integer printTime, Integer sendDeliveryTime, Integer addTime, String addIp, String unfinishedReason,
                     Integer remindersCount, Boolean merchantRevoked, OrderType orderType, String personName, String personPhone, Boolean receipt, Boolean requestRefunds,
                     Boolean refundsSuccess, String requestRefundsReason, Boolean merchantRefunds, String merchantRefundsReason, Boolean requestRefundsFlag,
                     Long platformUserId, Long platformId, Double brokerage, Double brokerageAmount, Boolean countFlag, String payUrl, Long merchantNo,
                     Boolean commentFlag, Integer operateTime, Integer dayCount, String merchantPhone, String discountDetail,
                     Integer remindersFlag, Long brandId, Double couponFee, Long couponId, Double fullReduction, Long code, Long shareUserId,String externalBrandNo,String externalMerchantNo,
                     ThirdPartyType thirdPartyType,Long islandFreeLunchId,Long infoId,Integer productEffectiveDays,String useRules) {
        this.id = id;
        this.orderSn = orderSn;
        this.thirdPartyType = thirdPartyType;
        this.islandFreeLunchId = islandFreeLunchId;
        this.infoId = infoId;
        this.productEffectiveDays = productEffectiveDays;
        this.useRules = useRules;
        this.consumerId = consumerId;
        this.merchantId = merchantId;
        this.merchantUserId = merchantUserId;
        this.productFee = productFee;
        this.discountFee = discountFee;
        this.packFee = packFee;
        this.shippingFee = shippingFee;
        this.amount = amount;
        this.orderState = orderState;
        this.payState = payState;
        this.payTime = payTime;
        this.payWay = payWay;
        this.printState = printState;
        this.printTime = printTime;
        this.sendDeliveryState = sendDeliveryState;
        this.sendDeliveryTime = sendDeliveryTime;
        this.addTime = addTime;
        this.addIp = addIp;
        this.unfinishedReason = unfinishedReason;
        this.remindersCount = remindersCount;
        this.merchantRevoked = merchantRevoked;
        this.orderType = orderType;
        this.personName = personName;
        this.personPhone = personPhone;
        this.receipt = receipt;
        this.requestRefunds = requestRefunds;
        this.refundsSuccess = refundsSuccess;
        this.requestRefundsReason = requestRefundsReason;
        this.merchantRefunds = merchantRefunds;
        this.merchantRefundsReason = merchantRefundsReason;
        this.requestRefundsFlag = requestRefundsFlag;
        this.platformUserId = platformUserId;
        this.platformId = platformId;
        this.brokerage = brokerage;
        this.brokerageAmount = brokerageAmount;
        this.countFlag = countFlag;
        this.payUrl = payUrl;
        this.merchantNo = merchantNo;
        this.commentFlag = commentFlag;
        this.operateTime = operateTime;
        this.dayCount = dayCount;
        this.consumerPhone = consumerPhone;
        this.merchantPhone = merchantPhone;
        this.discountDetail = discountDetail;
        this.remindersFlag = remindersFlag;
        this.brandId = brandId;
        this.couponFee = couponFee;
        this.couponId = couponId;
        this.fullReduction = fullReduction;
        this.shareUserId = shareUserId;
        this.code = code;
        this.externalBrandNo = externalBrandNo;
        this.externalMerchantNo = externalMerchantNo;
    }
    public ShopOrder dayCount(Integer dayCount) {
        this.dayCount = dayCount;
        return this;
    }

    public Long getIslandFreeLunchId() {
        return islandFreeLunchId;
    }

    public void setIslandFreeLunchId(Long islandFreeLunchId) {
        this.islandFreeLunchId = islandFreeLunchId;
    }

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public Integer getProductEffectiveDays() {
        return productEffectiveDays;
    }

    public void setProductEffectiveDays(Integer productEffectiveDays) {
        this.productEffectiveDays = productEffectiveDays;
    }

    public String getExternalMerchantNo() {
        return externalMerchantNo;
    }

    public void setExternalMerchantNo(String externalMerchantNo) {
        this.externalMerchantNo = externalMerchantNo;
    }

    public String getExternalBrandNo() {
        return externalBrandNo;
    }

    public void setExternalBrandNo(String externalBrandNo) {
        this.externalBrandNo = externalBrandNo;
    }

    public Double getCouponFee() {
        return couponFee;
    }

    public void setCouponFee(Double couponFee) {
        this.couponFee = couponFee;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Double getFullReduction() {
        return fullReduction;
    }

    public void setFullReduction(Double fullReduction) {
        this.fullReduction = fullReduction;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Integer getRemindersFlag() {
        return remindersFlag;
    }

    public void setRemindersFlag(Integer remindersFlag) {
        this.remindersFlag = remindersFlag;
    }

    public String getConsumerPhone() {
        return consumerPhone;
    }

    public void setConsumerPhone(String consumerPhone) {
        this.consumerPhone = consumerPhone;
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

    public Integer getDayCount() {
        return dayCount;
    }

    public void setDayCount(Integer dayCount) {
        this.dayCount = dayCount;
    }

    public Boolean isCommentFlag() {
        return commentFlag;
    }

    public ShopOrder commentFlag(Boolean commentFlag) {
        this.commentFlag = commentFlag;
        return this;
    }

    public void setCommentFlag(Boolean commentFlag) {
        this.commentFlag = commentFlag;
    }

    public Integer getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Integer operateTime) {
        this.operateTime = operateTime;
    }

    public ShopOrder operateTime(Integer operateTime) {
        this.operateTime = operateTime;
        return this;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public ShopOrder orderSn(String orderSn) {
        this.orderSn = orderSn;
        return this;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public ShopOrder consumerId(Long consumerId) {
        this.consumerId = consumerId;
        return this;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public ShopOrder merchantId(Long merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    public Long getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(Long merchantNo) {
        this.merchantNo = merchantNo;
    }

    public ShopOrder merchantNo(Long merchantNo) {
        this.merchantNo = merchantNo;
        return this;
    }

    public Long getMerchantUserId() {
        return merchantUserId;
    }

    public void setMerchantUserId(Long merchantUserId) {
        this.merchantUserId = merchantUserId;
    }

    public ShopOrder merchantUserId(Long merchantUserId) {
        this.merchantUserId = merchantUserId;
        return this;
    }

    public Double getProductFee() {
        return productFee;
    }

    public void setProductFee(Double productFee) {
        this.productFee = productFee;
    }

    public ShopOrder productFee(Double productFee) {
        this.productFee = productFee;
        return this;
    }

    public Double getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(Double discountFee) {
        this.discountFee = discountFee;
    }

    public ShopOrder discountFee(Double discountFee) {
        this.discountFee = discountFee;
        return this;
    }

    public Double getPackFee() {
        return packFee;
    }

    public void setPackFee(Double packFee) {
        this.packFee = packFee;
    }

    public ShopOrder packFee(Double packFee) {
        this.packFee = packFee;
        return this;
    }

    public Double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public ShopOrder shippingFee(Double shippingFee) {
        this.shippingFee = shippingFee;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public ShopOrder amount(Double amount) {
        this.amount = amount;
        return this;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public ShopOrder orderState(OrderState orderState) {
        this.orderState = orderState;
        return this;
    }

    public PayState getPayState() {
        return payState;
    }

    public void setPayState(PayState payState) {
        this.payState = payState;
    }

    public ShopOrder payState(PayState payState) {
        this.payState = payState;
        return this;
    }

    public Integer getPayTime() {
        return payTime;
    }

    public void setPayTime(Integer payTime) {
        this.payTime = payTime;
    }

    public ShopOrder payTime(Integer payTime) {
        this.payTime = payTime;
        return this;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public ShopOrder payWay(Integer payWay) {
        this.payWay = payWay;
        return this;
    }

    public PrintState getPrintState() {
        return printState;
    }

    public void setPrintState(PrintState printState) {
        this.printState = printState;
    }

    public ShopOrder printState(PrintState printState) {
        this.printState = printState;
        return this;
    }

    public Integer getPrintTime() {
        return printTime;
    }

    public void setPrintTime(Integer printTime) {
        this.printTime = printTime;
    }

    public ShopOrder printTime(Integer printTime) {
        this.printTime = printTime;
        return this;
    }

    public SendDeliveryState getSendDeliveryState() {
        return sendDeliveryState;
    }

    public void setSendDeliveryState(SendDeliveryState sendDeliveryState) {
        this.sendDeliveryState = sendDeliveryState;
    }

    public ShopOrder sendDeliveryState(SendDeliveryState sendDeliveryState) {
        this.sendDeliveryState = sendDeliveryState;
        return this;
    }

    public Integer getSendDeliveryTime() {
        return sendDeliveryTime;
    }

    public void setSendDeliveryTime(Integer sendDeliveryTime) {
        this.sendDeliveryTime = sendDeliveryTime;
    }

    public ShopOrder sendDeliveryTime(Integer sendDeliveryTime) {
        this.sendDeliveryTime = sendDeliveryTime;
        return this;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public ShopOrder addTime(Integer addTime) {
        this.addTime = addTime;
        return this;
    }

    public String getAddIp() {
        return addIp;
    }

    public void setAddIp(String addIp) {
        this.addIp = addIp;
    }

    public ShopOrder addIp(String addIp) {
        this.addIp = addIp;
        return this;
    }

    public String getUnfinishedReason() {
        return unfinishedReason;
    }

    public void setUnfinishedReason(String unfinishedReason) {
        this.unfinishedReason = unfinishedReason;
    }

    public ShopOrder unfinishedReason(String unfinishedReason) {
        this.unfinishedReason = unfinishedReason;
        return this;
    }

    public Integer getRemindersCount() {
        return remindersCount;
    }

    public void setRemindersCount(Integer remindersCount) {
        this.remindersCount = remindersCount;
    }

    public ShopOrder remindersCount(Integer remindersCount) {
        this.remindersCount = remindersCount;
        return this;
    }

    public Boolean isMerchantRevoked() {
        return merchantRevoked;
    }

    public ShopOrder merchantRevoked(Boolean merchantRevoked) {
        this.merchantRevoked = merchantRevoked;
        return this;
    }

    public void setMerchantRevoked(Boolean merchantRevoked) {
        this.merchantRevoked = merchantRevoked;
    }

    public Boolean isReceipt() {
        return receipt;
    }

    public ShopOrder receipt(Boolean receipt) {
        this.receipt = receipt;
        return this;
    }

    public void setReceipt(Boolean receipt) {
        this.receipt = receipt;
    }

    public Boolean isRequestRefunds() {
        return requestRefunds;
    }

    public ShopOrder requestRefunds(Boolean requestRefunds) {
        this.requestRefunds = requestRefunds;
        return this;
    }

    public void setRequestRefunds(Boolean requestRefunds) {
        this.requestRefunds = requestRefunds;
    }

    public Boolean isRefundsSuccess() {
        return refundsSuccess;
    }

    public ShopOrder refundsSuccess(Boolean refundsSuccess) {
        this.refundsSuccess = refundsSuccess;
        return this;
    }

    public void setRefundsSuccess(Boolean refundsSuccess) {
        this.refundsSuccess = refundsSuccess;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public ShopOrder orderType(OrderType orderType) {
        this.orderType = orderType;
        return this;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public ShopOrder personName(String personName) {
        this.personName = personName;
        return this;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public ShopOrder personPhone(String personPhone) {
        this.personPhone = personPhone;
        return this;
    }

    public String getRequestRefundsReason() {
        return requestRefundsReason;
    }

    public void setRequestRefundsReason(String requestRefundsReason) {
        this.requestRefundsReason = requestRefundsReason;
    }

    public ShopOrder requestRefundsReason(String requestRefundsReason) {
        this.requestRefundsReason = requestRefundsReason;
        return this;
    }

    public Boolean isMerchantRefunds() {
        return merchantRefunds;
    }

    public ShopOrder merchantRefunds(Boolean merchantRefunds) {
        this.merchantRefunds = merchantRefunds;
        return this;
    }

    public void setMerchantRefunds(Boolean merchantRefunds) {
        this.merchantRefunds = merchantRefunds;
    }

    public String getMerchantRefundsReason() {
        return merchantRefundsReason;
    }

    public void setMerchantRefundsReason(String merchantRefundsReason) {
        this.merchantRefundsReason = merchantRefundsReason;
    }

    public ShopOrder merchantRefundsReason(String merchantRefundsReason) {
        this.merchantRefundsReason = merchantRefundsReason;
        return this;
    }

    public Boolean isRequestRefundsFlag() {
        return requestRefundsFlag;
    }

    public ShopOrder requestRefundsFlag(Boolean requestRefundsFlag) {
        this.requestRefundsFlag = requestRefundsFlag;
        return this;
    }

    public ThirdPartyType getThirdPartyType() {
        return thirdPartyType;
    }

    public void setThirdPartyType(ThirdPartyType thirdPartyType) {
        this.thirdPartyType = thirdPartyType;
    }
    public ShopOrder thirdPartyType(ThirdPartyType thirdPartyType) {
        this.thirdPartyType = thirdPartyType;
        return this;
    }

    public void setRequestRefundsFlag(Boolean requestRefundsFlag) {
        this.requestRefundsFlag = requestRefundsFlag;
    }

    public Long getPlatformUserId() {
        return platformUserId;
    }

    public void setPlatformUserId(Long platformUserId) {
        this.platformUserId = platformUserId;
    }

    public ShopOrder platformUserId(Long platformUserId) {
        this.platformUserId = platformUserId;
        return this;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public ShopOrder platformId(Long platformId) {
        this.platformId = platformId;
        return this;
    }

    public Double getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(Double brokerage) {
        this.brokerage = brokerage;
    }

    public ShopOrder brokerage(Double brokerage) {
        this.brokerage = brokerage;
        return this;
    }

    public Double getBrokerageAmount() {
        return brokerageAmount;
    }

    public void setBrokerageAmount(Double brokerageAmount) {
        this.brokerageAmount = brokerageAmount;
    }

    public ShopOrder brokerageAmount(Double brokerageAmount) {
        this.brokerageAmount = brokerageAmount;
        return this;
    }

    public Boolean isCountFlag() {
        return countFlag;
    }

    public ShopOrder countFlag(Boolean countFlag) {
        this.countFlag = countFlag;
        return this;
    }

    public void setCountFlag(Boolean countFlag) {
        this.countFlag = countFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShopOrder shopOrder = (ShopOrder) o;
        if (shopOrder.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), shopOrder.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ShopOrder{" +
            "id=" + id +
            ", orderSn='" + orderSn + '\'' +
            ", consumerId=" + consumerId +
            ", merchantId=" + merchantId +
            ", merchantNo=" + merchantNo +
            ", merchantUserId=" + merchantUserId +
            ", productFee=" + productFee +
            ", discountFee=" + discountFee +
            ", couponFee=" + couponFee +
            ", couponId=" + couponId +
            ", fullReduction=" + fullReduction +
            ", packFee=" + packFee +
            ", shippingFee=" + shippingFee +
            ", amount=" + amount +
            ", orderState=" + orderState +
            ", payState=" + payState +
            ", payWay=" + payWay +
            ", payTime=" + payTime +
            ", payUrl='" + payUrl + '\'' +
            ", printState=" + printState +
            ", printTime=" + printTime +
            ", sendDeliveryState=" + sendDeliveryState +
            ", sendDeliveryTime=" + sendDeliveryTime +
            ", addTime=" + addTime +
            ", addIp='" + addIp + '\'' +
            ", unfinishedReason='" + unfinishedReason + '\'' +
            ", remindersCount=" + remindersCount +
            ", remindersFlag=" + remindersFlag +
            ", merchantRevoked=" + merchantRevoked +
            ", receipt=" + receipt +
            ", requestRefunds=" + requestRefunds +
            ", refundsSuccess=" + refundsSuccess +
            ", requestRefundsReason='" + requestRefundsReason + '\'' +
            ", merchantRefunds=" + merchantRefunds +
            ", merchantRefundsReason='" + merchantRefundsReason + '\'' +
            ", requestRefundsFlag=" + requestRefundsFlag +
            ", orderType=" + orderType +
            ", personName='" + personName + '\'' +
            ", personPhone='" + personPhone + '\'' +
            ", consumerPhone='" + consumerPhone + '\'' +
            ", merchantPhone='" + merchantPhone + '\'' +
            ", platformUserId=" + platformUserId +
            ", platformId=" + platformId +
            ", brandId=" + brandId +
            ", brokerage=" + brokerage +
            ", brokerageAmount=" + brokerageAmount +
            ", countFlag=" + countFlag +
            ", commentFlag=" + commentFlag +
            ", operateTime=" + operateTime +
            ", dayCount=" + dayCount +
            ", code=" + code +
            ", shareUserId=" + shareUserId +
            ", shopOrderExtendedInfoDTO=" + shopOrderExtendedInfoDTO +
            ", shopOrderProductInfoDTOS=" + shopOrderProductInfoDTOS +
            ", discountDetail='" + discountDetail + '\'' +
            ", orderActivityList=" + orderActivityList +
            ", fullReductionActivity=" + fullReductionActivity +
            ", externalMerchantNo='" + externalMerchantNo + '\'' +
            ", externalBrandNo='" + externalBrandNo + '\'' +
            ", thirdPartyType=" + thirdPartyType +
            ", islandFreeLunchId=" + islandFreeLunchId +
            ", infoId=" + infoId +
            ", productEffectiveDays=" + productEffectiveDays +
            ", useRules='" + useRules + '\'' +
            '}';
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    public String getDiscountDetail() {
        return discountDetail;
    }

    public void setDiscountDetail(String discountDetail) {
        this.discountDetail = discountDetail;
    }

    public Long getShareUserId() {
        return shareUserId;
    }

    public void setShareUserId(Long shareUserId) {
        this.shareUserId = shareUserId;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public ShopFullReductionActivityDTO getFullReductionActivity() {
        return fullReductionActivity;
    }

    public void setFullReductionActivity(ShopFullReductionActivityDTO fullReductionActivity) {
        this.fullReductionActivity = fullReductionActivity;
    }

    public List<OrderActivity> getOrderActivityList() {
        return orderActivityList;
    }

    public void setOrderActivityList(List<OrderActivity> orderActivityList) {
        this.orderActivityList = orderActivityList;
    }

    public List<ShopOrderProductInfoDTO> getShopOrderProductInfoDTOS() {
        return shopOrderProductInfoDTOS;
    }

    public void setShopOrderProductInfoDTOS(List<ShopOrderProductInfoDTO> shopOrderProductInfoDTOS) {
        this.shopOrderProductInfoDTOS = shopOrderProductInfoDTOS;
    }

    public ShopOrderExtendedInfoDTO getShopOrderExtendedInfoDTO() {
        return shopOrderExtendedInfoDTO;
    }

    public void setShopOrderExtendedInfoDTO(ShopOrderExtendedInfoDTO shopOrderExtendedInfoDTO) {
        this.shopOrderExtendedInfoDTO = shopOrderExtendedInfoDTO;
    }

    public String getUseRules() {
        return useRules;
    }

    public ShopOrder useRules(String infoId) {
        this.useRules = useRules;
        return this;
    }
    public void setUseRules(String useRules) {
        this.useRules = useRules;
    }
}
