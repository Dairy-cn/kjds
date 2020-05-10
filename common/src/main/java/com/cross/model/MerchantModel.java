package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.cross.model.dish.ShopDish;
import com.cross.model.enumeration.BrandAndMerchantType;
import com.cross.model.enumeration.ThirdPartyType;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * A Merchant.
 */
public class MerchantModel implements Serializable {

    private static final long serialVersionUID = 1L;

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

    private Integer seq;

    private String secret;

    private MerchantDetailModel merchantDetails;

    private String merchantAvatar;

    private Long receiveAccountId;

    private Long merchantBankAccountId;

    private String merchantQr;

    private Integer shopMode;


    private  String outerOrderMod;

    /**
     * 外卖自动接单模式
     */
    private Integer autoReceiveOrderMod;

    /**
     * 堂食自动接单模式  仅/get-account-merchant-by-platform 该接口有此值
     */
    private Integer autoReceiveOrderOR;

    /**
     * 设备类型 安卓或ios
     */
    private Integer deviceType;

    /**
     * 设备号
     */
    private String deviceNo;

    private String shopHours;

    private Integer status;

    private Boolean closeManually;

    private Integer dayCount;

    @ApiModelProperty("配送费")
    private Double shippingPrice;

    private String tel;

    private Double cabinetFee;

    private Long dadaShopId;

    private String meiTuanId;

    private Long eleMeId;

    private Long brand;

    /**
     * 是否开启自动回复
     */
    private Boolean autoReply = Boolean.FALSE;

    /**
     * 是否只回复空内容
     */
    private Boolean onlyEmpty = Boolean.TRUE;

    /**
     * 门店模式：0：外卖模式  1：电商模式
     */
    private Integer merchantModel;

    /**
     * 第三方APP 编号
     */
    private String appId;

    //菜品信息
    private List<ShopDish> shopDishList;

    //满减活动
    private ShopFullReductionActivityDTO shopFullReductionActivityDTO;

    /**
     * 外部门店编码：将外部门店和我们的店铺进行关联
     */
    @ApiModelProperty(value = "外部门店编码")
    private String externalMerchantNo;

    @ApiModelProperty(value = "是否开启配送")
    private Boolean openShipping;

    /**
     *平均送达时间
     */
    private Double readyTime;
    /**
     * 1:周一  2：周二  4：周三   8：周四  16：周五   32：周六  64：周日
     */
    @ApiModelProperty(value = "营业时间 周一到周末")
    private Integer businessHours;

    @ApiModelProperty(value = "店铺第三方类型")
    private ThirdPartyType thirdPartyType;

    @ApiModelProperty(value = "门店配送信息设置")
    private MerchantShippingInfoModel shippingInfoModel;

    @ApiModelProperty(value = "(新)门店配送信息（查询包括美团和自配送）")
    private NewMerchantShippingInfoToUseDto newShippingInfoModel;

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

    @ApiModelProperty(value = "门店编号:品牌编码 + 三位数")
    private String merchantCoding;
    
    
    @ApiModelProperty("店铺门头照")
    private String shopImages;
    
    
    @ApiModelProperty(value = "店铺banner图片")
    private String banner;
    
    @ApiModelProperty(value = "服务说明")
    private List<ServiceDescriptionVM> serviceDescription;
    
    @ApiModelProperty(value = "门店环境图")
    private String merchantAroundPic;
    
    @ApiModelProperty(value = "门店宣传图")
    private String merchantPropagandaPic;
    
    
    @ApiModelProperty(value = "门店logo")
    private String merchantLogo;
    /**
     * 图片展示 1 菜品 2 门店
     */
    @ApiModelProperty(value = "图片展示 1 菜品 2 门店")
    private Integer picShowType;

    /**
     * mdmThirdNo
     */
    @ApiModelProperty(value = "mdmThirdNo")
    private String thirdNo;


    public String getThirdNo() {
        return thirdNo;
    }

    public void setThirdNo(String thirdNo) {
        this.thirdNo = thirdNo;
    }

    public String getMerchantLogo() {
        return merchantLogo;
    }
    
    public void setMerchantLogo(String merchantLogo) {
        this.merchantLogo = merchantLogo;
    }
    
    public Integer getPicShowType() {
        return picShowType;
    }
    
    public void setPicShowType(Integer picShowType) {
        this.picShowType = picShowType;
    }
    
    public String getMerchantAroundPic() {
        return merchantAroundPic;
    }
    
    public void setMerchantAroundPic(String merchantAroundPic) {
        this.merchantAroundPic = merchantAroundPic;
    }
    
    public String getMerchantPropagandaPic() {
        return merchantPropagandaPic;
    }
    
    public void setMerchantPropagandaPic(String merchantPropagandaPic) {
        this.merchantPropagandaPic = merchantPropagandaPic;
    }

    public Integer getAutoReceiveOrderOR() {
        return autoReceiveOrderOR;
    }

    public void setAutoReceiveOrderOR(Integer autoReceiveOrderOR) {
        this.autoReceiveOrderOR = autoReceiveOrderOR;
    }

    public List<ServiceDescriptionVM> getServiceDescription() {
        return serviceDescription;
    }
    
    public void setServiceDescription(List<ServiceDescriptionVM> serviceDescription) {
        this.serviceDescription = serviceDescription;
    }
    
    public String getMerchantCoding() {
        return merchantCoding;
    }

    public void setMerchantCoding(String merchantCoding) {
        this.merchantCoding = merchantCoding;
    }

    public BrandAndMerchantType getBrandAndMerchantType() {
        return brandAndMerchantType;
    }

    public void setBrandAndMerchantType(BrandAndMerchantType brandAndMerchantType) {
        this.brandAndMerchantType = brandAndMerchantType;
    }

    public NewMerchantShippingInfoToUseDto getNewShippingInfoModel() {
        return newShippingInfoModel;
    }

    public void setNewShippingInfoModel(NewMerchantShippingInfoToUseDto newShippingInfoModel) {
        this.newShippingInfoModel = newShippingInfoModel;
    }

    public Double getReadyTime() {
        return readyTime;
    }

    public void setReadyTime(Double readyTime) {
        this.readyTime = readyTime;
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

    public MerchantShippingInfoModel getShippingInfoModel() {
        return shippingInfoModel;
    }

    public void setShippingInfoModel(MerchantShippingInfoModel shippingInfoModel) {
        this.shippingInfoModel = shippingInfoModel;
    }

    public ThirdPartyType getThirdPartyType() {
        return thirdPartyType;
    }

    public void setThirdPartyType(ThirdPartyType thirdPartyType) {
        this.thirdPartyType = thirdPartyType;
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

    public String getExternalMerchantNo() {
        return externalMerchantNo;
    }

    public void setExternalMerchantNo(String externalMerchantNo) {
        this.externalMerchantNo = externalMerchantNo;
    }

    public ShopFullReductionActivityDTO getShopFullReductionActivityDTO() {
        return shopFullReductionActivityDTO;
    }

    public void setShopFullReductionActivityDTO(ShopFullReductionActivityDTO shopFullReductionActivityDTO) {
        this.shopFullReductionActivityDTO = shopFullReductionActivityDTO;
    }

    public List<ShopDish> getShopDishList() {
        return shopDishList;
    }

    public void setShopDishList(List<ShopDish> shopDishList) {
        this.shopDishList = shopDishList;
    }

    public Integer getMerchantModel() {
        return merchantModel;
    }

    public void setMerchantModel(Integer merchantModel) {
        this.merchantModel = merchantModel;
    }

    public Boolean isAutoReply() {
        return autoReply;
    }

    public void setAutoReply(Boolean autoReply) {
        this.autoReply = autoReply;
    }

    public Boolean isOnlyEmpty() {
        return onlyEmpty;
    }

    public void setOnlyEmpty(Boolean onlyEmpty) {
        this.onlyEmpty = onlyEmpty;
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

    public Double getCabinetFee() {
        return cabinetFee;
    }

    public void setCabinetFee(Double cabinetFee) {
        this.cabinetFee = cabinetFee;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Double getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(Double shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public Integer getDayCount() {
        return dayCount;
    }

    public void setDayCount(Integer dayCount) {
        this.dayCount = dayCount;
    }

    public Boolean isCloseManually() {
        return closeManually;
    }

    public void setCloseManually(Boolean closeManually) {
        this.closeManually = closeManually;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getShopHours() {
        return shopHours;
    }

    public void setShopHours(String shopHours) {
        this.shopHours = shopHours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMerchant_name() {
        return merchant_name;
    }

    public void setMerchant_name(String merchant_name) {
        this.merchant_name = merchant_name;
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

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Long getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(Long merchantNo) {
        this.merchantNo = merchantNo;
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

    public MerchantDetailModel getMerchantDetails() {
        return merchantDetails;
    }

    public void setMerchantDetails(MerchantDetailModel merchantDetails) {
        this.merchantDetails = merchantDetails;
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

    public String getMerchantQr() {
        return merchantQr;
    }

    public void setMerchantQr(String merchantQr) {
        this.merchantQr = merchantQr;
    }
    
    public String getShopImages() {
        return shopImages;
    }
    
    public void setShopImages(String shopImages) {
        this.shopImages = shopImages;
    }
    
    public String getBanner() {
        return banner;
    }
    
    public void setBanner(String banner) {
        this.banner = banner;
    }
    
    @Override
    public String toString() {
        return "MerchantModel{" +
            "id=" + id +
            ", merchant_name='" + merchant_name + '\'' +
            ", merchantNo=" + merchantNo +
            ", currency='" + currency + '\'' +
            ", deal_type=" + deal_type +
            ", channel_pay_auth=" + channel_pay_auth +
            ", state=" + state +
            ", reg_time=" + reg_time +
            ", modify_time=" + modify_time +
            ", last_login=" + last_login +
            ", userId=" + userId +
            ", seq=" + seq +
            ", secret='" + secret + '\'' +
            ", merchantDetails=" + merchantDetails +
            ", merchantAvatar='" + merchantAvatar + '\'' +
            ", receiveAccountId=" + receiveAccountId +
            ", merchantBankAccountId=" + merchantBankAccountId +
            ", merchantQr='" + merchantQr + '\'' +
            ", shopMode=" + shopMode +
            ", outerOrderMod='" + outerOrderMod + '\'' +
            ", autoReceiveOrderMod=" + autoReceiveOrderMod +
            ", deviceType=" + deviceType +
            ", deviceNo='" + deviceNo + '\'' +
            ", shopHours='" + shopHours + '\'' +
            ", status=" + status +
            ", closeManually=" + closeManually +
            ", dayCount=" + dayCount +
            ", shippingPrice=" + shippingPrice +
            ", tel='" + tel + '\'' +
            ", cabinetFee=" + cabinetFee +
            ", dadaShopId=" + dadaShopId +
            ", meiTuanId='" + meiTuanId + '\'' +
            ", eleMeId=" + eleMeId +
            ", brand=" + brand +
            ", autoReply=" + autoReply +
            ", onlyEmpty=" + onlyEmpty +
            ", merchantModel=" + merchantModel +
            ", appId='" + appId + '\'' +
            ", shopDishList=" + shopDishList +
            ", shopFullReductionActivityDTO=" + shopFullReductionActivityDTO +
            ", externalMerchantNo='" + externalMerchantNo + '\'' +
            ", openShipping=" + openShipping +
            ", readyTime=" + readyTime +
            ", businessHours=" + businessHours +
            ", thirdPartyType=" + thirdPartyType +
            ", shippingInfoModel=" + shippingInfoModel +
            ", businessLicenseUrl='" + businessLicenseUrl + '\'' +
            ", enteringInfo=" + enteringInfo +
            ", enteringDate=" + enteringDate +
            ", reviewDate=" + reviewDate +
            ", reason='" + reason + '\'' +
            ", brandAndMerchantType=" + brandAndMerchantType +
            ", merchantCoding='" + merchantCoding + '\'' +
            ", shopImages='" + shopImages + '\'' +
            ", banner='" + banner + '\'' +
            ", serviceDescription=" + serviceDescription +
            '}';
    }
    
    public Integer getAutoReceiveOrderMod() {
        return autoReceiveOrderMod;
    }

    public void setAutoReceiveOrderMod(Integer autoReceiveOrderMod) {
        this.autoReceiveOrderMod = autoReceiveOrderMod;
    }

    public Integer getShopMode() {
        return shopMode;
    }

    public void setShopMode(Integer shopMode) {
        this.shopMode = shopMode;
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

    public String getOuterOrderMod() {
        return outerOrderMod;
    }

    public void setOuterOrderMod(String outerOrderMod) {
        this.outerOrderMod = outerOrderMod;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
