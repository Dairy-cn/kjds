package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.cross.model.enumeration.BrandAndMerchantType;
import com.cross.model.enumeration.ThirdPartyType;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.Instant;
import java.util.List;

public class MerchantDTO {

    private Long id;

    private String merchant_name;

    private Long merchantNo;

    private String currency;

    private Integer deal_type;

    private Integer channel_pay_auth;

    private Integer state;

    private Integer reg_time;

    private Integer modify_time;

    private Integer last_login;

    private Long userId;

    private String secret;

    private String merchantAvatar;

    private Long receiveAccountId;

    private Long merchantBankAccountId;

    private Long productGroupId;

    private String merchantQr;

    private String merchantShopQr;

    @ApiModelProperty("外部订单模式 1堂吃 2外卖 4:物流")
    private String outerOrderMod;

    private String shippingRange;

    private String shippingRangeMod;

    private String startPrice;

    private Double shippingPrice;

    private String autoReceiveOrderMod;

    private String orderNotify;

    private String shopHours;

    private String shopNotice;

    private String shopBrief;

    private String banner;

    private String printer;

    /**
     * 增加门店下的满减活动配置
     */
    private ShopFullReductionActivityDTO shopFullReductionActivityDTO;
    private Integer status;

    /**
     * 店铺模式 1外卖到家 2到店自取 4堂食预定
     */
    private Integer shopMod;

    /**
     * 自动关闭
     */
    private Boolean closeManually;

    private Integer dayCount;

    /**
     * 设备类型 安卓或ios
     */
    private Integer deviceType;

    /**
     * 设备号
     */
    private String deviceNo;

    /**
     * 备注自定义显示
     */
    private String remarkPlaceholder;

    /**
     * 备注自定义(用_分割)
     */
    private String remarkList;

    /**
     * 是否必须填写
     */
    private Boolean remarkRequired = false;

    /**
     * 餐柜费
     */
    private Double cabinetFee = 0d;

    /**
     * 所属品牌
     */
    private Long brand;

    /**
     * 达达商户ID
     */
    private Long dadaShopId;

    /**
     * 是否只回复空内容
     */
    private Boolean onlyEmpty = Boolean.TRUE;

    /**
     *
     */
    private String meiTuanId;

    /**
     * 饿了么店铺id
     */
    private Long eleMeId;

    private MerchantDetailsDTO merchantDetails;

    /**
     * 是否自动回复评论
     */
    private Boolean autoReply = Boolean.FALSE;
    /**
     * 两点之间的距离
     */
    private Double distance;

    /**
     * 是否开启预定日期
     */
    private Boolean useReserve;

    /**
     * 门店模式：0：外卖模式  1：电商模式
     */
    private Integer merchantModel;

    /**
     * 外部门店编码：将外部门店和我们的店铺进行关联
     */
    @ApiModelProperty(value = "外部门店编码")
    private String externalMerchantNo;

    /**
    * 平均送达时间
     */
    private Double readyTime;

    @ApiModelProperty(value = "门店别名")
    private List<String> merchantAliasList;

    @ApiModelProperty("门店活动")
    private List<MerchantActivityVM> merchantActivityList;

    private String appId;

    @ApiModelProperty(value = "是否开启配送")
    private Boolean openShipping = Boolean.FALSE;


    /**
     * 1:周一  2：周二  4：周三   8：周四  16：周五   32：周六  64：周日
     */
    @ApiModelProperty(value = "营业时间 周一到周末")
    private Integer businessHours;

    private String brandName;

    @ApiModelProperty(value = "店铺第三方类型")
    private ThirdPartyType thirdPartyType;

    @ApiModelProperty(value = "营业执照url")
    private String businessLicenseUrl;

    @ApiModelProperty(value = "入驻通吃岛平台情况：1 未入驻  2 审核中 3 入驻成功 4 入驻失败 5 关闭营业  6关店")
    private Integer enteringInfo = 1;

    @ApiModelProperty(value = "申请入驻时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant enteringDate;

    @ApiModelProperty(value = "审核时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant reviewDate;

    @ApiModelProperty(value = "入驻失败原因或者关闭营业的原因")
    private String reason;

    @ApiModelProperty(value = "门店类型")
    @Enumerated(EnumType.STRING)
    private BrandAndMerchantType brandAndMerchantType;

    @ApiModelProperty(value = "关闭营业记录")
    private List<TcdCloseShopRecodeDTO> closeRecodeList;

    @ApiModelProperty(value = "关店时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant closeDate;

    @ApiModelProperty(value = "门店编号:品牌编码 + 三位数")
    private String merchantCoding;


    @ApiModelProperty(value = "平台门店信息")
    private PlatFormMerchantDTO platFormMerchantDTO;

    @ApiModelProperty("是否开启满减活动 true：开启 false：关闭")
    private Boolean openActivity=false;

    @ApiModelProperty(value = "若是使用掌控者系统由此值 表示再对方系统中的id值")
    private String thirdNo;

    public String getThirdNo() {
        return thirdNo;
    }

    public void setThirdNo(String thirdNo) {
        this.thirdNo = thirdNo;
    }
    public PlatFormMerchantDTO getPlatFormMerchantDTO() {
        return platFormMerchantDTO;
    }

    public void setPlatFormMerchantDTO(PlatFormMerchantDTO platFormMerchantDTO) {
        this.platFormMerchantDTO = platFormMerchantDTO;
    }

    public Boolean getOpenActivity() {
        return openActivity;
    }

    public void setOpenActivity(Boolean openActivity) {
        this.openActivity = openActivity;
    }

    public ShopFullReductionActivityDTO getShopFullReductionActivityDTO() {
        return shopFullReductionActivityDTO;
    }

    public void setShopFullReductionActivityDTO(ShopFullReductionActivityDTO shopFullReductionActivityDTO) {
        this.shopFullReductionActivityDTO = shopFullReductionActivityDTO;
    }

    public String getMerchantCoding() {
        return merchantCoding;
    }

    public void setMerchantCoding(String merchantCoding) {
        this.merchantCoding = merchantCoding;
    }

    public Instant getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Instant closeDate) {
        this.closeDate = closeDate;
    }

    public List<TcdCloseShopRecodeDTO> getCloseRecodeList() {
        return closeRecodeList;
    }

    public void setCloseRecodeList(List<TcdCloseShopRecodeDTO> closeRecodeList) {
        this.closeRecodeList = closeRecodeList;
    }

    public BrandAndMerchantType getBrandAndMerchantType() {
        return brandAndMerchantType;
    }

    public void setBrandAndMerchantType(BrandAndMerchantType brandAndMerchantType) {
        this.brandAndMerchantType = brandAndMerchantType;
    }

    public String getBusinessLicenseUrl() {
        return businessLicenseUrl;
    }

    public void setBusinessLicenseUrl(String businessLicenseUrl) {
        this.businessLicenseUrl = businessLicenseUrl;
    }

    public Integer getEnteringInfo() {
        return enteringInfo;
    }

    public void setEnteringInfo(Integer enteringInfo) {
        this.enteringInfo = enteringInfo;
    }

    public Instant getEnteringDate() {
        return enteringDate;
    }

    public void setEnteringDate(Instant enteringDate) {
        this.enteringDate = enteringDate;
    }

    public Instant getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Instant reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ThirdPartyType getThirdPartyType() {
        return thirdPartyType;
    }

    public void setThirdPartyType(ThirdPartyType thirdPartyType) {
        this.thirdPartyType = thirdPartyType;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(Integer businessHours) {
        this.businessHours = businessHours;
    }

    public Boolean getOpenShipping() {
        return openShipping;
    }

    public void setOpenShipping(Boolean openShipping) {
        this.openShipping = openShipping;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public List<MerchantActivityVM> getMerchantActivityList() {
        return merchantActivityList;
    }
    public List<String> getMerchantAliasList() {
        return merchantAliasList;
    }

    public String getExternalMerchantNo() {
        return externalMerchantNo;
    }

    public void setExternalMerchantNo(String externalMerchantNo) {
        this.externalMerchantNo = externalMerchantNo;
    }

    public void setMerchantActivityList(List<MerchantActivityVM> merchantActivityList) {
        this.merchantActivityList = merchantActivityList;
    }

    public void setMerchantAliasList(List<String> merchantAliasList) {
        this.merchantAliasList = merchantAliasList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMerchant_name() {
        return merchant_name;
    }

    public void setMerchant_name(String merchant_name) {
        this.merchant_name = merchant_name;
    }

    public Long getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(Long merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getDeal_type() {
        return deal_type;
    }

    public void setDeal_type(Integer deal_type) {
        this.deal_type = deal_type;
    }

    public Integer getChannel_pay_auth() {
        return channel_pay_auth;
    }

    public void setChannel_pay_auth(Integer channel_pay_auth) {
        this.channel_pay_auth = channel_pay_auth;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getReg_time() {
        return reg_time;
    }

    public void setReg_time(Integer reg_time) {
        this.reg_time = reg_time;
    }

    public Integer getModify_time() {
        return modify_time;
    }

    public void setModify_time(Integer modify_time) {
        this.modify_time = modify_time;
    }

    public Integer getLast_login() {
        return last_login;
    }

    public void setLast_login(Integer last_login) {
        this.last_login = last_login;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getMerchantAvatar() {
        return merchantAvatar;
    }

    public void setMerchantAvatar(String merchantAvatar) {
        this.merchantAvatar = merchantAvatar;
    }

    public Long getReceiveAccountId() {
        return receiveAccountId;
    }

    public void setReceiveAccountId(Long receiveAccountId) {
        this.receiveAccountId = receiveAccountId;
    }

    public Long getMerchantBankAccountId() {
        return merchantBankAccountId;
    }

    public void setMerchantBankAccountId(Long merchantBankAccountId) {
        this.merchantBankAccountId = merchantBankAccountId;
    }

    public Long getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(Long productGroupId) {
        this.productGroupId = productGroupId;
    }

    public String getMerchantQr() {
        return merchantQr;
    }

    public void setMerchantQr(String merchantQr) {
        this.merchantQr = merchantQr;
    }

    public String getMerchantShopQr() {
        return merchantShopQr;
    }

    public void setMerchantShopQr(String merchantShopQr) {
        this.merchantShopQr = merchantShopQr;
    }

    public String getOuterOrderMod() {
        return outerOrderMod;
    }

    public void setOuterOrderMod(String outerOrderMod) {
        this.outerOrderMod = outerOrderMod;
    }

    public String getShippingRange() {
        return shippingRange;
    }

    public void setShippingRange(String shippingRange) {
        this.shippingRange = shippingRange;
    }

    public String getShippingRangeMod() {
        return shippingRangeMod;
    }

    public void setShippingRangeMod(String shippingRangeMod) {
        this.shippingRangeMod = shippingRangeMod;
    }

    public String getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(String startPrice) {
        this.startPrice = startPrice;
    }

    public Double getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(Double shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public String getAutoReceiveOrderMod() {
        return autoReceiveOrderMod;
    }

    public void setAutoReceiveOrderMod(String autoReceiveOrderMod) {
        this.autoReceiveOrderMod = autoReceiveOrderMod;
    }

    public String getOrderNotify() {
        return orderNotify;
    }

    public void setOrderNotify(String orderNotify) {
        this.orderNotify = orderNotify;
    }

    public String getShopHours() {
        return shopHours;
    }

    public void setShopHours(String shopHours) {
        this.shopHours = shopHours;
    }

    public String getShopNotice() {
        return shopNotice;
    }

    public void setShopNotice(String shopNotice) {
        this.shopNotice = shopNotice;
    }

    public String getShopBrief() {
        return shopBrief;
    }

    public void setShopBrief(String shopBrief) {
        this.shopBrief = shopBrief;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getPrinter() {
        return printer;
    }

    public void setPrinter(String printer) {
        this.printer = printer;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getShopMod() {
        return shopMod;
    }

    public void setShopMod(Integer shopMod) {
        this.shopMod = shopMod;
    }

    public Boolean getCloseManually() {
        return closeManually;
    }

    public void setCloseManually(Boolean closeManually) {
        this.closeManually = closeManually;
    }

    public Integer getDayCount() {
        return dayCount;
    }

    public void setDayCount(Integer dayCount) {
        this.dayCount = dayCount;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getRemarkPlaceholder() {
        return remarkPlaceholder;
    }

    public void setRemarkPlaceholder(String remarkPlaceholder) {
        this.remarkPlaceholder = remarkPlaceholder;
    }

    public String getRemarkList() {
        return remarkList;
    }

    public void setRemarkList(String remarkList) {
        this.remarkList = remarkList;
    }

    public Boolean getRemarkRequired() {
        return remarkRequired;
    }

    public void setRemarkRequired(Boolean remarkRequired) {
        this.remarkRequired = remarkRequired;
    }

    public Double getCabinetFee() {
        return cabinetFee;
    }

    public void setCabinetFee(Double cabinetFee) {
        this.cabinetFee = cabinetFee;
    }

    public Long getBrand() {
        return brand;
    }

    public void setBrand(Long brand) {
        this.brand = brand;
    }

    public Long getDadaShopId() {
        return dadaShopId;
    }

    public void setDadaShopId(Long dadaShopId) {
        this.dadaShopId = dadaShopId;
    }

    public Boolean getOnlyEmpty() {
        return onlyEmpty;
    }

    public void setOnlyEmpty(Boolean onlyEmpty) {
        this.onlyEmpty = onlyEmpty;
    }

    public String getMeiTuanId() {
        return meiTuanId;
    }

    public void setMeiTuanId(String meiTuanId) {
        this.meiTuanId = meiTuanId;
    }

    public Long getEleMeId() {
        return eleMeId;
    }

    public void setEleMeId(Long eleMeId) {
        this.eleMeId = eleMeId;
    }

    public MerchantDetailsDTO getMerchantDetails() {
        return merchantDetails;
    }

    public void setMerchantDetails(MerchantDetailsDTO merchantDetails) {
        this.merchantDetails = merchantDetails;
    }

    public Boolean getAutoReply() {
        return autoReply;
    }

    public void setAutoReply(Boolean autoReply) {
        this.autoReply = autoReply;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Boolean getUseReserve() {
        return useReserve;
    }

    public void setUseReserve(Boolean useReserve) {
        this.useReserve = useReserve;
    }

    public Integer getMerchantModel() {
        return merchantModel;
    }

    public void setMerchantModel(Integer merchantModel) {
        this.merchantModel = merchantModel;
    }

    public Double getReadyTime() {
        return readyTime;
    }

    public void setReadyTime(Double readyTime) {
        this.readyTime = readyTime;
    }

}
