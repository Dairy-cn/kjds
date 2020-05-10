package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.enumtype.OrderSource;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.cross.model.enumeration.*;
import com.cross.utils.CommonUtil;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the ShopOrder entity.
 */
public class ShopOrderDTO implements Serializable {

    private Long id;

    /**
     * 订单编号
     */
    @Size(max = 32)
    @ApiModelProperty(value = "订单编号", required = true)
    private String orderSn;

    /**
     * 消费者编号
     */
    @ApiModelProperty(value = "消费者编号", required = true)
    private Long consumerId;

    /**
     * 商户ID
     */
    @NotNull
    @ApiModelProperty(value = "商户ID", required = true)
    private Long merchantId;

    /**
     * 商户编号
     */
    @ApiModelProperty(value = "商户编号", required = true)
    private Long merchantNo;

    /**
     * 商户用户编号
     */
    @NotNull
    @ApiModelProperty(value = "商户用户编号", required = true)
    private Long merchantUserId;

    /**
     * 产品金额
     */
    @ApiModelProperty(value = "产品金额")
    private Double productFee = 0d;

    /**
     * 优惠金额
     */
    @ApiModelProperty(value = "优惠金额")
    private Double discountFee = 0d;

    /**
     * 红包金额
     */
    private Double couponFee = 0d;

    /**
     * 红包id
     */
    private Long couponId;
    /**
     * 满减金额
     */
    private Double fullReduction;

    /**
     * 首单减金额
     */
    private Double firstOrderSub = 0d;

    /**
     * 优惠详情
     */
    private String discountDetail = "{}";

    /**
     * 打包费用
     */
    @ApiModelProperty(value = "打包费用")
    private Double packFee = 0d;

    /**
     * 配送费用
     */
    @ApiModelProperty(value = "配送费用")
    private Double shippingFee = 0d;

    /**
     * 实际付款金额
     */
    @ApiModelProperty(value = "实际付款金额")
    private Double amount = 0d;

    /**
     * 订单状态
     */
    @ApiModelProperty(value = "订单状态")
    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    /**
     * 支付状态
     */
    @ApiModelProperty(value = "支付状态")
    @Enumerated(EnumType.STRING)
    private PayState payState;

    /**
     * 支付时间
     */
    @ApiModelProperty(value = "支付时间")
    private Integer payTime;

    /**
     * 支付方式 1 支付宝 2 微信 3 银行卡 4余额支付  5.免支付
     */
    @ApiModelProperty(value = "支付方式")
    private Integer payWay;

    /**
     * 打印状态
     */
    @ApiModelProperty(value = "打印状态")
    @Enumerated(EnumType.STRING)
    private PrintState printState = PrintState.UNPRINT;

    /**
     * 打印时间
     */
    @ApiModelProperty(value = "打印时间")
    private Integer printTime;

    /**
     * 分发时间
     */
    @ApiModelProperty(value = "分发时间")
    private Integer sendDeliveryTime;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Integer addTime;

    /**
     * 创建ip
     */
    @ApiModelProperty(value = "创建ip")
    private String addIp;

    /**
     * 未完成订单原因
     */
    @Size(max = 1000)
    @ApiModelProperty(value = "未完成订单原因")
    private String unfinishedReason;

    /**
     * 催单次数
     */
    @ApiModelProperty(value = "催单次数")
    private Integer remindersCount = 0;

    /**
     * 催单状态   0未催单  1 催单中  2 商户已确认
     */
    @ApiModelProperty(value = "商户确认催单")
    private Integer remindersFlag = 0;

    /**
     * 商户撤单
     */
    @ApiModelProperty(value = "商户撤单")
    private Boolean merchantRevoked = false;

    @ApiModelProperty(value = "是否收货")
    private Boolean receipt = false;

    /**
     * 是否申请退款
     */
    @ApiModelProperty(value = "是否申请退款")
    private Boolean requestRefunds;

    /**
     * 申请退款原因
     */
    @Size(max = 1000)
    @ApiModelProperty(value = "申请退款原因")
    private String requestRefundsReason;

    /**
     * 商户确认退款
     */
    @ApiModelProperty(value = "商户确认退款")
    private Boolean merchantRefunds;

    /**
     * 商户拒绝退款原因
     */
    @Size(max = 1000)
    @ApiModelProperty(value = "商户拒绝退款原因")
    private String merchantRefundsReason;

    /**
     * 是否申请退款标志  通过此标志查询数据  当为false时  不用判断requestRefunds  当为true时  判断requestRefunds为false
     */
    @ApiModelProperty(value = "是否申请退款标志")
    private Boolean requestRefundsFlag = false;

    /**
     * 是否退款成功
     */
    @ApiModelProperty(value = "是否退款成功")
    private Boolean refundsSuccess;

    /**
     * 订单类型
     */
    @ApiModelProperty(value = " 订单类型 NETWORK 网络外卖,EATNOW 堂吃订单, PICK_UP 自取,TAO_QUAN：权益淘券,DELIVERY_TO_HOME物流,TO_THE_STORE:到店,SCAN_CODE 扫码点餐,OFFER_TO_PAY 优惠买单")
    @Enumerated(EnumType.STRING)
    private OrderType orderType;

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
     * 用户电话
     */
    @ApiModelProperty(value = "用户电话")
    private String consumerPhone;

    /**
     * 商户电话
     */
    @ApiModelProperty(value = "商户电话")
    private String merchantPhone;

    /**
     * 平台用户ID
     */
    @ApiModelProperty(value = "平台用户ID")
    private Long platformUserId;

    /**
     * 平台ID
     */
    @ApiModelProperty(value = "平台ID")
    private Long platformId;

    /**
     * 佣金比例
     */
    @ApiModelProperty(value = "佣金比例")
    private Double brokerage;

    /**
     * 佣金
     */
    @ApiModelProperty(value = "佣金")
    private Double brokerageAmount;

    /**
     * 支付地址
     */
    @ApiModelProperty(value = "支付地址")
    private String payUrl;

    @ApiModelProperty(value = "是否统计")
    private Boolean countFlag;

    @ApiModelProperty(value = "是否评论")
    private Boolean commentFlag = false;

    /**
     * 操作时间
     */
    @ApiModelProperty(value = "操作时间")
    private Integer operateTime;

    /**
     * 订单每日排序号码
     */
    @ApiModelProperty(value = "订单每日排序号码")
    private Integer dayCount;

    /**
     * 红包序号
     */
    @ApiModelProperty(value = "红包序号")
    private String couponSn;

    private Long brandId;

    /**
     * 合伙人编号
     */
    private Long code;

    /**
     * 分享用户ID
     */
    private Long shareUserId;
    
    
    @ApiModelProperty(value = "门店信息")
    private MerchantModel merchantModel;

    /**
     * 配送员电话
     */
    @ApiModelProperty(value = "订单扩展信息")
    private ShopOrderExtendedInfoDTO shopOrderExtendedInfoDTO;

    private List<ShopOrderProductInfoDTO> shopOrderProductInfoDTOS;

    /**
     * 订单参加的活动
     */
    private List<OrderActivity> orderActivityList;

    /**
     * 参加的满减活动
     */
    private ShopFullReductionActivityDTO fullReductionActivity;

    /**
     * 外部门店编码：将外部门店和我们的店铺进行关联
     */
    @ApiModelProperty(value = "外部门店编码")
    private String externalMerchantNo;

    /**
     * 外部商户编码：关联外部品牌
     */
    @ApiModelProperty(value = "外部商户编码")
    private String externalBrandNo;

    @ApiModelProperty(value = "快寄公司")
    private String fastMailCompany;

    @ApiModelProperty(value = "快寄单号")
    private String fastMailSn;

    /**
     * 分发状态
     */
    @ApiModelProperty(value = "分发状态")
    @Enumerated(EnumType.STRING)
    private SendDeliveryState sendDeliveryState = SendDeliveryState.UNSEND;

    @ApiModelProperty(value = "到店消费使用的开始时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant useStartTime;

    @ApiModelProperty(value = "到店消费使用的结束时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant useEndTime;

    @ApiModelProperty(value = "快寄公司编码")
    private String fastMailCompanyCode;


    @ApiModelProperty(value = "订单来源")
    private OrderSource orderSource;

    @ApiModelProperty("配送单号")
    private String deliveryId;


    @ApiModelProperty(value = "第三方来源")
    private ThirdPartyType thirdPartyType;



    @ApiModelProperty(value = "霸王餐活动id")
    private Long islandFreeLunchId;

    @ApiModelProperty(value = "霸王餐中奖纪录id")
    private Long infoId;

    @ApiModelProperty(value = "霸王餐活动信息")
    private IslandFreeLunchDTO islandFreeLunchDTO;

    /**卡券有效期 */
    @ApiModelProperty(value = "卡券有效期兑换后 有效天数")
    private Integer productEffectiveDays;

    @ApiModelProperty(value = "使用规则")
    private List<String> useRules;


    @ApiModelProperty("活动类型 1  优惠券 2  满减  4 霸王餐  8 优惠买单")
    private Integer activityType;

    @ApiModelProperty(value = "交易单号")
    private String paymentOrderCode;

    @ApiModelProperty(value = "优惠买单详情")
    private OfferDiscountDetailsDTO offerDiscountDetailsDTO;
    
    
    ///ss
    
 
    
    /**
     * 通吃岛小程序收款商户编号
     */
    @ApiModelProperty(value = "通吃岛小程序收款商户编号", required = true)
    private Long tcdMerchantNo;
    

    
    /**
     * 订单未使用优惠前总价
     */
    @ApiModelProperty(value = "订单总价")
    private BigDecimal totalAmount;
    
  

   

   
    
    /**
     * 用户申请退款时间或者商户取消订单时间
     */
    @ApiModelProperty(value = "用户申请退款时间或者商户取消订单时间")
    private Integer requestRefundsTime;
   
    
    /**
     * 1:用户发起退款    2：商家发起的退款
     */
    @ApiModelProperty(value = "哪一端发起的退款")
    private Integer whoRefunds;
    
    
    /**
     * 入住前的平台Id
     */
    @ApiModelProperty(value = "入住前的平台Id")
    private Long oldPlatformId;
    
   
    
    private String brandName;
    
    /**
     * 合伙人佣金
     */
    private Double partnerCommission;
    
   
    
    //秒杀是否免配送 : 为true时，不免配送
    private Boolean freeShipping = Boolean.FALSE;
    //是否只有秒杀活动  为true时：有其他活动
    private Boolean spikeActivity = Boolean.FALSE;
    
    //订单总数
    private Long orderCount;
   
    
    @ApiModelProperty(value = "核销码信息")
    private List<OrderWriteOffCodeDTO> orderWriteOffCodeDTOS;
    
    /**
     * false:未过期  true：已过期
     */
    @ApiModelProperty(value = "到店使用的券是否过期")
    private Boolean expired = Boolean.FALSE;
    
    @ApiModelProperty(value = "到店消费订单可使用券的数量")
    private Integer canUseCount = 0;
    
    
    @ApiModelProperty(value = "到店消费订单未核销券的数量")
    private Integer notUseCount = 0;
    
    @ApiModelProperty(value = "合伙人等级id")
    private Long partnerLevelId;
    
    /**
     * true :成功   false：失败
     */
    @ApiModelProperty(value = "购买套餐后是否加入成功")
    private Boolean joinResult;
    
    @ApiModelProperty(value = "合伙人返佣")
    private Double commission;

    
    @ApiModelProperty(value = "是否结算")
    private Boolean settlement = Boolean.FALSE;
    
    @ApiModelProperty(value = "结算日期")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)
    private Instant settlementDate;
    
    @ApiModelProperty(value = "到店消费订单可使用门店")
    private Set<String> useMerchantList;
    
    @ApiModelProperty(value = "向第三方推送订单状态 1：失败  2：成功且获取详情失败  3：成功并且获取详情成功")
    private Integer orderToThirdParty;
    
    @ApiModelProperty(value = "乐玩订单编号")
    private String leWanOrderNo;
    


    
    @ApiModelProperty("退款编号")
    private String outRefundNo;

    
    @ApiModelProperty("code标识 1 表示平台 2 表示分销商品 5 分销门店")
    private Integer codeSign;
    
    @ApiModelProperty("是否和通吃卡绑定购买")
    private Boolean bindingBuy;
    
    /**
     * 通吃卡付款金额
     */
    @ApiModelProperty(value = "通吃卡付款金额")
    private Double tcCardAmount = 0d;
    

    
    
    @ApiModelProperty(value = "霸王餐活动参与人员记录信息")
    private IslandFreeLunchUserInfoDTO islandFreeLunchUserInfoDTO;
    
    
    
    @ApiModelProperty(value = "品牌和门店类型")
    private BrandAndMerchantType brandAndMerchantType;
    
    
    
    @ApiModelProperty(value = "配送费用，在自配送时需传入该字段")
    private Double sendPrice;
    
    @ApiModelProperty(value = "配送区域，在自配送时需传入该字段")
    private Integer rangeCode;
    
    @ApiModelProperty(value = "所属门店")
    private String merchantName;
    

    
    @ApiModelProperty(value = "优惠买单不参与打折的费用")
    private Double noDiscountFee;
    

    
    @ApiModelProperty("就餐人数")
    private Integer peopleNum;
    @ApiModelProperty("桌号")
    private Long tableNum;
    @ApiModelProperty("桌名")
    private String tableName;
    @ApiModelProperty("就餐号")
    private String mealNumber;
    
    @ApiModelProperty("购物车uid")
    private String shoppingCartUid;
    
    @ApiModelProperty("桌台费")
    private TableFee tableFee;

    
    
    @ApiModelProperty("退款金额")
    private BigDecimal refundsFee;
    
    @ApiModelProperty("会员价")
    private BigDecimal memberAmount;
    
    @ApiModelProperty(value = "支付密码（余额支付时毕传）")
    private String payPassword;
    
    @ApiModelProperty(value = "会员GUID")
    private String memberInfoGuid;
    
    @ApiModelProperty(value = "会员持卡GUID")
    private String memberInfoCardGuid;
    
    /**
     * 是否包含原价商品标识
     */
    private Boolean haveOriginalProduct = false;
    
    
    @ApiModelProperty(value = "快递公司列表")
    private List<ShippingListModel> shippingListModels;
    
    
    @ApiModelProperty("到店订单 商家退款标识")
    @Column(name = "toTheStoreRefundsFlag")
    private Boolean toTheStoreRefundsFlag;
    
    @ApiModelProperty("掌控者聚合支付时传入，当前发起下单请求的小程序AppId")
    private String appId;
    
    @ApiModelProperty("掌控者会员卡支付返回的记录id")
    private String memberConsumptionGuid;
    
    @ApiModelProperty("是否使用掌控者聚合支付（如果使用需要前端在拿到预下单成功后调用轮询获取payinfo）")
    private Boolean useMdmPay = false;
    
    
    /**
     * 运费(单位：元)
     */
    @ApiModelProperty(value = "运费(单位：元)")
    private BigDecimal deliverFee;
    
    
    public Long getTcdMerchantNo() {
        return tcdMerchantNo;
    }
    
    public void setTcdMerchantNo(Long tcdMerchantNo) {
        this.tcdMerchantNo = tcdMerchantNo;
    }
    
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public Integer getRequestRefundsTime() {
        return requestRefundsTime;
    }
    
    public void setRequestRefundsTime(Integer requestRefundsTime) {
        this.requestRefundsTime = requestRefundsTime;
    }
    
    public Integer getWhoRefunds() {
        return whoRefunds;
    }
    
    public void setWhoRefunds(Integer whoRefunds) {
        this.whoRefunds = whoRefunds;
    }
    
    public Long getOldPlatformId() {
        return oldPlatformId;
    }
    
    public void setOldPlatformId(Long oldPlatformId) {
        this.oldPlatformId = oldPlatformId;
    }
    
    public String getBrandName() {
        return brandName;
    }
    
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    
    public Double getPartnerCommission() {
        return partnerCommission;
    }
    
    public void setPartnerCommission(Double partnerCommission) {
        this.partnerCommission = partnerCommission;
    }
    
    public Boolean getFreeShipping() {
        return freeShipping;
    }
    
    public void setFreeShipping(Boolean freeShipping) {
        this.freeShipping = freeShipping;
    }
    
    public Boolean getSpikeActivity() {
        return spikeActivity;
    }
    
    public void setSpikeActivity(Boolean spikeActivity) {
        this.spikeActivity = spikeActivity;
    }
    
    public Long getOrderCount() {
        return orderCount;
    }
    
    public void setOrderCount(Long orderCount) {
        this.orderCount = orderCount;
    }
    
    public List<OrderWriteOffCodeDTO> getOrderWriteOffCodeDTOS() {
        return orderWriteOffCodeDTOS;
    }
    
    public void setOrderWriteOffCodeDTOS(List<OrderWriteOffCodeDTO> orderWriteOffCodeDTOS) {
        this.orderWriteOffCodeDTOS = orderWriteOffCodeDTOS;
    }
    
    public Boolean getExpired() {
        return expired;
    }
    
    public void setExpired(Boolean expired) {
        this.expired = expired;
    }
    
    public Integer getCanUseCount() {
        return canUseCount;
    }
    
    public void setCanUseCount(Integer canUseCount) {
        this.canUseCount = canUseCount;
    }
    
    public Integer getNotUseCount() {
        return notUseCount;
    }
    
    public void setNotUseCount(Integer notUseCount) {
        this.notUseCount = notUseCount;
    }
    
    public Long getPartnerLevelId() {
        return partnerLevelId;
    }
    
    public void setPartnerLevelId(Long partnerLevelId) {
        this.partnerLevelId = partnerLevelId;
    }
    
    public Boolean getJoinResult() {
        return joinResult;
    }
    
    public void setJoinResult(Boolean joinResult) {
        this.joinResult = joinResult;
    }
    
    public Double getCommission() {
        return commission;
    }
    
    public void setCommission(Double commission) {
        this.commission = commission;
    }
    
    public Boolean getSettlement() {
        return settlement;
    }
    
    public void setSettlement(Boolean settlement) {
        this.settlement = settlement;
    }
    
    public Instant getSettlementDate() {
        return settlementDate;
    }
    
    public void setSettlementDate(Instant settlementDate) {
        this.settlementDate = settlementDate;
    }
    
    public Set<String> getUseMerchantList() {
        return useMerchantList;
    }
    
    public void setUseMerchantList(Set<String> useMerchantList) {
        this.useMerchantList = useMerchantList;
    }
    
    public Integer getOrderToThirdParty() {
        return orderToThirdParty;
    }
    
    public void setOrderToThirdParty(Integer orderToThirdParty) {
        this.orderToThirdParty = orderToThirdParty;
    }
    
    public String getLeWanOrderNo() {
        return leWanOrderNo;
    }
    
    public void setLeWanOrderNo(String leWanOrderNo) {
        this.leWanOrderNo = leWanOrderNo;
    }
    
    public String getOutRefundNo() {
        return outRefundNo;
    }
    
    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }
    
    public Integer getCodeSign() {
        return codeSign;
    }
    
    public void setCodeSign(Integer codeSign) {
        this.codeSign = codeSign;
    }
    
    public Boolean getBindingBuy() {
        return bindingBuy;
    }
    
    public void setBindingBuy(Boolean bindingBuy) {
        this.bindingBuy = bindingBuy;
    }
    
    public Double getTcCardAmount() {
        return tcCardAmount;
    }
    
    public void setTcCardAmount(Double tcCardAmount) {
        this.tcCardAmount = tcCardAmount;
    }
    
    public IslandFreeLunchUserInfoDTO getIslandFreeLunchUserInfoDTO() {
        return islandFreeLunchUserInfoDTO;
    }
    
    public void setIslandFreeLunchUserInfoDTO(IslandFreeLunchUserInfoDTO islandFreeLunchUserInfoDTO) {
        this.islandFreeLunchUserInfoDTO = islandFreeLunchUserInfoDTO;
    }
    
    public BrandAndMerchantType getBrandAndMerchantType() {
        return brandAndMerchantType;
    }
    
    public void setBrandAndMerchantType(BrandAndMerchantType brandAndMerchantType) {
        this.brandAndMerchantType = brandAndMerchantType;
    }
    
    public Double getSendPrice() {
        return sendPrice;
    }
    
    public void setSendPrice(Double sendPrice) {
        this.sendPrice = sendPrice;
    }
    
    public Integer getRangeCode() {
        return rangeCode;
    }
    
    public void setRangeCode(Integer rangeCode) {
        this.rangeCode = rangeCode;
    }
    
    public String getMerchantName() {
        return merchantName;
    }
    
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
    
    public Double getNoDiscountFee() {
        return noDiscountFee;
    }
    
    public void setNoDiscountFee(Double noDiscountFee) {
        this.noDiscountFee = noDiscountFee;
    }
    
    public Integer getPeopleNum() {
        return peopleNum;
    }
    
    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }
    
    public Long getTableNum() {
        return tableNum;
    }
    
    public void setTableNum(Long tableNum) {
        this.tableNum = tableNum;
    }
    
    public String getTableName() {
        return tableName;
    }
    
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    
    public String getMealNumber() {
        return mealNumber;
    }
    
    public void setMealNumber(String mealNumber) {
        this.mealNumber = mealNumber;
    }
    
    public String getShoppingCartUid() {
        return shoppingCartUid;
    }
    
    public void setShoppingCartUid(String shoppingCartUid) {
        this.shoppingCartUid = shoppingCartUid;
    }
    
    public TableFee getTableFee() {
        return tableFee;
    }
    
    public void setTableFee(TableFee tableFee) {
        this.tableFee = tableFee;
    }
    
    public BigDecimal getRefundsFee() {
        return refundsFee;
    }
    
    public void setRefundsFee(BigDecimal refundsFee) {
        this.refundsFee = refundsFee;
    }
    
    public BigDecimal getMemberAmount() {
        return memberAmount;
    }
    
    public void setMemberAmount(BigDecimal memberAmount) {
        this.memberAmount = memberAmount;
    }
    
    public String getPayPassword() {
        return payPassword;
    }
    
    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }
    
    public String getMemberInfoGuid() {
        return memberInfoGuid;
    }
    
    public void setMemberInfoGuid(String memberInfoGuid) {
        this.memberInfoGuid = memberInfoGuid;
    }
    
    public String getMemberInfoCardGuid() {
        return memberInfoCardGuid;
    }
    
    public void setMemberInfoCardGuid(String memberInfoCardGuid) {
        this.memberInfoCardGuid = memberInfoCardGuid;
    }
    
    public Boolean getHaveOriginalProduct() {
        return haveOriginalProduct;
    }
    
    public void setHaveOriginalProduct(Boolean haveOriginalProduct) {
        this.haveOriginalProduct = haveOriginalProduct;
    }
    
    public List<ShippingListModel> getShippingListModels() {
        return shippingListModels;
    }
    
    public void setShippingListModels(List<ShippingListModel> shippingListModels) {
        this.shippingListModels = shippingListModels;
    }
    
    public Boolean getToTheStoreRefundsFlag() {
        return toTheStoreRefundsFlag;
    }
    
    public void setToTheStoreRefundsFlag(Boolean toTheStoreRefundsFlag) {
        this.toTheStoreRefundsFlag = toTheStoreRefundsFlag;
    }
    
    public String getAppId() {
        return appId;
    }
    
    public void setAppId(String appId) {
        this.appId = appId;
    }
    
    public String getMemberConsumptionGuid() {
        return memberConsumptionGuid;
    }
    
    public void setMemberConsumptionGuid(String memberConsumptionGuid) {
        this.memberConsumptionGuid = memberConsumptionGuid;
    }
    
    public Boolean getUseMdmPay() {
        return useMdmPay;
    }
    
    public void setUseMdmPay(Boolean useMdmPay) {
        this.useMdmPay = useMdmPay;
    }
    
    public BigDecimal getDeliverFee() {
        return deliverFee;
    }
    
    public void setDeliverFee(BigDecimal deliverFee) {
        this.deliverFee = deliverFee;
    }
    
    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public String getPaymentOrderCode() {
        return paymentOrderCode;
    }

    public void setPaymentOrderCode(String paymentOrderCode) {
        this.paymentOrderCode = paymentOrderCode;
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

    public IslandFreeLunchDTO getIslandFreeLunchDTO() {
        return islandFreeLunchDTO;
    }

    public void setIslandFreeLunchDTO(IslandFreeLunchDTO islandFreeLunchDTO) {
        this.islandFreeLunchDTO = islandFreeLunchDTO;
    }

    public Integer getProductEffectiveDays() {
        return productEffectiveDays;
    }

    public void setProductEffectiveDays(Integer productEffectiveDays) {
        this.productEffectiveDays = productEffectiveDays;
    }

    public String getFastMailCompanyCode() {
        return fastMailCompanyCode;
    }

    public void setFastMailCompanyCode(String fastMailCompanyCode) {
        this.fastMailCompanyCode = fastMailCompanyCode;
    }

    public Instant getUseStartTime() {
        return useStartTime;
    }

    public void setUseStartTime(Instant useStartTime) {
        this.useStartTime = useStartTime;
    }

    public Instant getUseEndTime() {
        return useEndTime;
    }

    public void setUseEndTime(Instant useEndTime) {
        this.useEndTime = useEndTime;
    }

    public String getFastMailCompany() {
        return fastMailCompany;
    }

    public void setFastMailCompany(String fastMailCompany) {
        this.fastMailCompany = fastMailCompany;
    }

    public String getFastMailSn() {
        return fastMailSn;
    }

    public void setFastMailSn(String fastMailSn) {
        this.fastMailSn = fastMailSn;
    }

    public SendDeliveryState getSendDeliveryState() {
        return sendDeliveryState;
    }

    public void setSendDeliveryState(SendDeliveryState sendDeliveryState) {
        this.sendDeliveryState = sendDeliveryState;
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

    public Boolean getMerchantRevoked() {
        return merchantRevoked;
    }

    public Boolean getReceipt() {
        return receipt;
    }

    public Boolean getRequestRefunds() {
        return requestRefunds;
    }

    public Boolean getMerchantRefunds() {
        return merchantRefunds;
    }

    public Boolean getRequestRefundsFlag() {
        return requestRefundsFlag;
    }

    public Boolean getRefundsSuccess() {
        return refundsSuccess;
    }

    public Boolean getCountFlag() {
        return countFlag;
    }

    public Boolean getCommentFlag() {
        return commentFlag;
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

    public List<OrderActivity> getOrderActivityList() {
        return orderActivityList;
    }

    public void setOrderActivityList(List<OrderActivity> orderActivityList) {
        this.orderActivityList = orderActivityList;
    }

    public ShopFullReductionActivityDTO getFullReductionActivity() {
        return fullReductionActivity;
    }

    public void setFullReductionActivity(ShopFullReductionActivityDTO fullReductionActivity) {
        this.fullReductionActivity = fullReductionActivity;
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

    public void setCommentFlag(Boolean commentFlag) {
        this.commentFlag = commentFlag;
    }

    public Integer getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Integer operateTime) {
        this.operateTime = operateTime;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
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

    public Long getMerchantUserId() {
        return merchantUserId;
    }

    public void setMerchantUserId(Long merchantUserId) {
        this.merchantUserId = merchantUserId;
    }

    public Double getProductFee() {
        return productFee;
    }

    public void setProductFee(Double productFee) {
        this.productFee = productFee;
    }

    public Double getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(Double discountFee) {
        this.discountFee = discountFee;
    }

    public Double getPackFee() {
        return packFee;
    }

    public void setPackFee(Double packFee) {
        this.packFee = packFee;
    }

    public Double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public PayState getPayState() {
        return payState;
    }

    public void setPayState(PayState payState) {
        this.payState = payState;
    }

    public Integer getPayTime() {
        return payTime;
    }

    public void setPayTime(Integer payTime) {
        this.payTime = payTime;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public PrintState getPrintState() {
        return printState;
    }

    public void setPrintState(PrintState printState) {
        this.printState = printState;
    }

    public Integer getPrintTime() {
        return printTime;
    }

    public void setPrintTime(Integer printTime) {
        this.printTime = printTime;
    }

    public Integer getSendDeliveryTime() {
        return sendDeliveryTime;
    }

    public void setSendDeliveryTime(Integer sendDeliveryTime) {
        this.sendDeliveryTime = sendDeliveryTime;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public String getAddIp() {
        return addIp;
    }

    public void setAddIp(String addIp) {
        this.addIp = addIp;
    }

    public String getUnfinishedReason() {
        return unfinishedReason;
    }

    public void setUnfinishedReason(String unfinishedReason) {
        this.unfinishedReason = unfinishedReason;
    }

    public Integer getRemindersCount() {
        return remindersCount;
    }

    public void setRemindersCount(Integer remindersCount) {
        this.remindersCount = remindersCount;
    }

    public Boolean isMerchantRevoked() {
        return merchantRevoked;
    }

    public void setMerchantRevoked(Boolean merchantRevoked) {
        this.merchantRevoked = merchantRevoked;
    }

    public Boolean isReceipt() {
        return receipt;
    }

    public void setReceipt(Boolean receipt) {
        this.receipt = receipt;
    }

    public Boolean isRequestRefunds() {
        return requestRefunds;
    }

    public void setRequestRefunds(Boolean requestRefunds) {
        this.requestRefunds = requestRefunds;
    }

    public Boolean isRefundsSuccess() {
        return refundsSuccess;
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

    public String getRequestRefundsReason() {
        return requestRefundsReason;
    }

    public void setRequestRefundsReason(String requestRefundsReason) {
        this.requestRefundsReason = requestRefundsReason;
    }

    public Boolean isMerchantRefunds() {
        return merchantRefunds;
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

    public Boolean isRequestRefundsFlag() {
        return requestRefundsFlag;
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

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public Double getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(Double brokerage) {
        this.brokerage = brokerage;
    }

    public Double getBrokerageAmount() {
        return brokerageAmount;
    }

    public void setBrokerageAmount(Double brokerageAmount) {
        this.brokerageAmount = brokerageAmount;
    }

    public Boolean isCountFlag() {
        return countFlag;
    }

    public void setCountFlag(Boolean countFlag) {
        this.countFlag = countFlag;
    }

    public OrderSource getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(OrderSource orderSource) {
        this.orderSource = orderSource;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public ThirdPartyType getThirdPartyType() {
        return thirdPartyType;
    }

    public void setThirdPartyType(ThirdPartyType thirdPartyType) {
        this.thirdPartyType = thirdPartyType;
    }

    public OfferDiscountDetailsDTO getOfferDiscountDetailsDTO() {
        return offerDiscountDetailsDTO;
    }

    public void setOfferDiscountDetailsDTO(OfferDiscountDetailsDTO offerDiscountDetailsDTO) {
        this.offerDiscountDetailsDTO = offerDiscountDetailsDTO;
    }
    
    public MerchantModel getMerchantModel() {
        return merchantModel;
    }
    
    public void setMerchantModel(MerchantModel merchantModel) {
        this.merchantModel = merchantModel;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ShopOrderDTO shopOrderDTO = (ShopOrderDTO) o;
        if (shopOrderDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), shopOrderDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ShopOrderDTO{" +
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
            ", firstOrderSub=" + firstOrderSub +
            ", discountDetail='" + discountDetail + '\'' +
            ", packFee=" + packFee +
            ", shippingFee=" + shippingFee +
            ", amount=" + amount +
            ", orderState=" + orderState +
            ", payState=" + payState +
            ", payTime=" + payTime +
            ", payWay=" + payWay +
            ", printState=" + printState +
            ", printTime=" + printTime +
            ", sendDeliveryTime=" + sendDeliveryTime +
            ", addTime=" + addTime +
            ", addIp='" + addIp + '\'' +
            ", unfinishedReason='" + unfinishedReason + '\'' +
            ", remindersCount=" + remindersCount +
            ", remindersFlag=" + remindersFlag +
            ", merchantRevoked=" + merchantRevoked +
            ", receipt=" + receipt +
            ", requestRefunds=" + requestRefunds +
            ", requestRefundsReason='" + requestRefundsReason + '\'' +
            ", merchantRefunds=" + merchantRefunds +
            ", merchantRefundsReason='" + merchantRefundsReason + '\'' +
            ", requestRefundsFlag=" + requestRefundsFlag +
            ", refundsSuccess=" + refundsSuccess +
            ", orderType=" + orderType +
            ", personName='" + personName + '\'' +
            ", personPhone='" + personPhone + '\'' +
            ", consumerPhone='" + consumerPhone + '\'' +
            ", merchantPhone='" + merchantPhone + '\'' +
            ", platformUserId=" + platformUserId +
            ", platformId=" + platformId +
            ", brokerage=" + brokerage +
            ", brokerageAmount=" + brokerageAmount +
            ", payUrl='" + payUrl + '\'' +
            ", countFlag=" + countFlag +
            ", commentFlag=" + commentFlag +
            ", operateTime=" + operateTime +
            ", dayCount=" + dayCount +
            ", couponSn='" + couponSn + '\'' +
            ", brandId=" + brandId +
            ", code=" + code +
            ", shareUserId=" + shareUserId +
            ", shopOrderExtendedInfoDTO=" + shopOrderExtendedInfoDTO +
            ", shopOrderProductInfoDTOS=" + shopOrderProductInfoDTOS +
            ", orderActivityList=" + orderActivityList +
            ", fullReductionActivity=" + fullReductionActivity +
            ", externalMerchantNo='" + externalMerchantNo + '\'' +
            ", externalBrandNo='" + externalBrandNo + '\'' +
            ", fastMailCompany='" + fastMailCompany + '\'' +
            ", fastMailSn='" + fastMailSn + '\'' +
            ", sendDeliveryState=" + sendDeliveryState +
            ", useStartTime=" + useStartTime +
            ", useEndTime=" + useEndTime +
            ", fastMailCompanyCode='" + fastMailCompanyCode + '\'' +
            ", orderSource=" + orderSource +
            ", deliveryId='" + deliveryId + '\'' +
            ", thirdPartyType=" + thirdPartyType +
            '}';
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    public String getCouponSn() {
        return couponSn;
    }

    public void setCouponSn(String couponSn) {
        this.couponSn = couponSn;
    }

    public Double getCouponFee() {
        return couponFee;
    }

    public void setCouponFee(Double couponFee) {
        this.couponFee = couponFee;
    }

    public Double getFirstOrderSub() {
        return firstOrderSub;
    }

    public void setFirstOrderSub(Double firstOrderSub) {
        this.firstOrderSub = firstOrderSub;
    }

    public String getDiscountDetail() {
        return discountDetail;
    }

    public void setDiscountDetail(String discountDetail) {
        this.discountDetail = discountDetail;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getShareUserId() {
        return shareUserId;
    }

    public void setShareUserId(Long shareUserId) {
        this.shareUserId = shareUserId;
    }

    public List<String> getUseRules() {
        return useRules;
    }

    public void setUseRules(List<String> useRules) {
        this.useRules = useRules;
    }

    public ShopOrderDTO() {

    }

    public ShopOrderDTO(ShopOrder shopOrder) {
        this(shopOrder.getId(), shopOrder.getOrderSn(), shopOrder.getConsumerId(), shopOrder.getMerchantId(), shopOrder.getMerchantUserId(),
            shopOrder.getProductFee(), shopOrder.getDiscountFee(), shopOrder.getPackFee(), shopOrder.getShippingFee(), shopOrder.getAmount(),
            shopOrder.getOrderState(), shopOrder.getPayState(), shopOrder.getPayTime(), shopOrder.getPayWay(), shopOrder.getPrintState(), shopOrder.getSendDeliveryTime(), shopOrder.getAddTime(), shopOrder.getAddIp(), shopOrder.getUnfinishedReason(),
            shopOrder.getRemindersCount(), shopOrder.isMerchantRevoked(), shopOrder.getOrderType(), shopOrder.getPersonName(), shopOrder.getPersonPhone(), shopOrder.getRequestRefundsReason(), shopOrder.isMerchantRefunds(), shopOrder.getMerchantRefundsReason(),
            shopOrder.isRequestRefundsFlag(), shopOrder.getPlatformUserId(), shopOrder.getPlatformId(), shopOrder.getBrokerage(), shopOrder.getBrokerageAmount(), shopOrder.isCountFlag(),
            shopOrder.getPayUrl(), shopOrder.getMerchantNo(), shopOrder.isCommentFlag(), shopOrder.getOperateTime(), shopOrder.getDayCount(),
            shopOrder.getConsumerPhone(), shopOrder.getMerchantPhone(), shopOrder.getDiscountDetail(), shopOrder.getRemindersFlag(), shopOrder.getBrandId(),
            shopOrder.getCouponFee(),shopOrder.getCouponId(),shopOrder.getFullReduction(), shopOrder.getCode(), shopOrder.getShareUserId(),shopOrder.getThirdPartyType(),
            shopOrder.getIslandFreeLunchId(),shopOrder.getInfoId(),shopOrder.getProductEffectiveDays(),CommonUtil.jsonStringConvertToList(shopOrder.getUseRules(), String[].class));
    }

    public ShopOrderDTO(Long id, String orderSn, Long consumerId, Long merchantId, Long merchantUserId, Double productFee, Double discountFee, Double packFee,
                        Double shippingFee, Double amount, OrderState orderState, PayState payState, Integer payTime, Integer payWay, PrintState printState, Integer sendDeliveryTime, Integer addTime, String addIp, String unfinishedReason,
                        Integer remindersCount, Boolean merchantRevoked, OrderType orderType, String personName, String personPhone, String requestRefundsReason,
                        Boolean merchantRefunds, String merchantRefundsReason, Boolean requestRefundsFlag, Long platformUserId,
                        Long platformId, Double brokerage, Double brokerageAmount, Boolean countFlag, String payUrl, Long merchantNo,
                        Boolean commentFlag, Integer operateTime, Integer dayCount, String consumerPhone, String merchantPhone,
                        String discountDetail, Integer remindersFlag, Long brandId,Double couponFee,Long couponId,Double fullReduction, Long code, Long shareUserId,
                        ThirdPartyType thirdPartyType,Long islandFreeLunchId,Long infoId,Integer productEffectiveDays,List<String> useRules) {
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
        this.sendDeliveryTime = sendDeliveryTime;
        this.addTime = addTime;
        this.addIp = addIp;
        this.unfinishedReason = unfinishedReason;
        this.remindersCount = remindersCount;
        this.merchantRevoked = merchantRevoked;
        this.orderType = orderType;
        this.personName = personName;
        this.personPhone = personPhone;
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
        this.code = code;
        this.shareUserId = shareUserId;
    }

    public ShopOrderDTO(Long id, String orderSn, Long consumerId, Long merchantId, Long merchantUserId, Double productFee, Double discountFee, Double packFee,
                        Double shippingFee, Double amount, OrderState orderState, PayState payState, Integer payTime, PrintState printState, Integer printTime, Integer sendDeliveryTime, Integer addTime, String addIp, String unfinishedReason,
                        Integer remindersCount, Boolean merchantRevoked, OrderType orderType, String personName, String personPhone,
                        byte[] shopOrderExtendedInfo, byte[] shopOrderProductInfo, String requestRefundsReason,
                        Boolean merchantRefunds, String merchantRefundsReason, Boolean requestRefundsFlag, String payUrl, Long merchantNo,
                        Boolean commentFlag, Integer operateTime, Integer dayCount, String consumerPhone, String merchantPhone, Integer remindersFlag) {
        this.id = id;
        this.orderSn = orderSn;
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
        this.printState = printState;
        this.printTime = printTime;
        this.sendDeliveryTime = sendDeliveryTime;
        this.addTime = addTime;
        this.addIp = addIp;
        this.unfinishedReason = unfinishedReason;
        this.remindersCount = remindersCount;
        this.merchantRevoked = merchantRevoked;
        this.orderType = orderType;
        this.personName = personName;
        this.personPhone = personPhone;
        this.requestRefundsReason = requestRefundsReason;
        this.merchantRefunds = merchantRefunds;
        this.merchantRefundsReason = merchantRefundsReason;
        this.requestRefundsFlag = requestRefundsFlag;
        this.payUrl = payUrl;
        this.merchantNo = merchantNo;
        this.commentFlag = commentFlag;
        this.operateTime = operateTime;
        this.dayCount = dayCount;
        this.consumerPhone = consumerPhone;
        this.merchantPhone = merchantPhone;
        this.remindersFlag = remindersFlag;
    }
}
