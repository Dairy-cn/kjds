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
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * Created by DuYuLiang on 2017/6/26.
 */
public class MerchantVM implements Serializable {
    @ApiModelProperty("编号")
    private Long id;
    @ApiModelProperty("商户名称")
    private String merchant_name;
    @ApiModelProperty("商户编号")
    private Long merchantNo;
    @ApiModelProperty("使用货币")
    private String currency;
    @ApiModelProperty("经营类型")
    private Integer deal_type;
    @ApiModelProperty("支付通道")
    private Integer channel_pay_auth;
    @ApiModelProperty("状态")
    private Integer state;
    @ApiModelProperty("注册时间")
    private Integer reg_time;
    @ApiModelProperty("修改时间")
    private Integer modify_time;
    @ApiModelProperty("最后登录")
    private Integer last_login;
    @ApiModelProperty("用户编号")
    private Long userId;
    @ApiModelProperty("简短名称")
    private String short_name;
    @ApiModelProperty("经营行业")
    private Integer industry;
    @ApiModelProperty("省")
    private Integer province;
    @ApiModelProperty("市")
    private Integer city;
    @ApiModelProperty("区县")
    private Integer county;
    @ApiModelProperty("实际地址")
    private String address;
    @ApiModelProperty("电话")
    private String tel;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("法人")
    private String legal_person;
    @ApiModelProperty("客服电话")
    private String service_phone;
    @ApiModelProperty("联系人")
    private String principal;
    @ApiModelProperty("联系人电话")
    private String principal_mobile;
    @ApiModelProperty("身份证号码")
    private Long identity_code;
    @ApiModelProperty("身份证正面")
    private String identity_ago;
    @ApiModelProperty("身份证背面")
    private String identity_after;
    @ApiModelProperty("营业执照")
    private String license_photo;
    @ApiModelProperty("协议照")
    private String protocol_photo;
    @ApiModelProperty("组织机构代码")
    private String org_photo;
    @ApiModelProperty("统一社会信用编码")
    private String business_code;
    @ApiModelProperty("商户形象LOGO")
    private String merchantAvatar;
    @ApiModelProperty("收款账户编号")
    private Long receiveAccountId;
    @ApiModelProperty("绑定银行编号")
    private Long merchantBankAccountId;
    @ApiModelProperty("商户二维码")
    private String merchantQr;
    @ApiModelProperty("地址坐标")
    private String position;
    @ApiModelProperty("商户收款URL")
    private String shopReceiveUrl;
    @ApiModelProperty("商户商城URL")
    private String shopUrl;
    @ApiModelProperty("店铺门头照")
    private String shopImages;
    @ApiModelProperty("店内真实环境")
    private String shopRealImages;
    @ApiModelProperty("外部订单模式1堂吃2外卖3堂吃+外卖")
    private String outerOrderMod;
    @ApiModelProperty("配送范围")
    private String shippingRange;
    @ApiModelProperty("配送范围模式1：提示2强制")
    private String shippingRangeMod;
    @ApiModelProperty("起送价")
    private String startPrice;
    @ApiModelProperty("配送费")
    private Double shippingPrice;
    @ApiModelProperty("自动收单模式 0不自动收单 1自动收单 2自动打印 3自动分发")
    private Integer autoReceiveOrderMod;
    @ApiModelProperty("订单通知 1开启 0不开启")
    private String orderNotify;
    @ApiModelProperty("营业时间段 多个时间段逗号隔开")
    private String shopHours;
    @ApiModelProperty("店铺公告")
    private String shopNotice;
    @ApiModelProperty("店铺简介")
    private String shopBrief;
    @ApiModelProperty("店铺轮播图片")
    private String banner;
    @ApiModelProperty("店铺使用打印机，多个逗号隔开")
    private String printer;
    @ApiModelProperty("店铺状态 0休息 1营业 2打烊 3忙碌")
    private Integer status;
    @ApiModelProperty("经营行业字段")
    private String industryStr;
    @ApiModelProperty("餐柜费")
    private Double cabinetFee = 0d;
    @ApiModelProperty("所属品牌")
    private Long brand;
    @ApiModelProperty(value = "达达商户ID")
    private Long dadaShopId;
    @ApiModelProperty(value = "是否自动回复评论")
    private Boolean isAutoReply = Boolean.FALSE;
    @ApiModelProperty(value = "美团店铺ID")
    private String meiTuanId;
    @ApiModelProperty(value = "饿了么店铺ID")
    private Long eleMeId;

    @ApiModelProperty(value = "启用用户可填预定日期")
    private Boolean useReserve;

    /**
     * 门店模式：0：外卖模式  1：电商模式
     *
     */
    private Integer merchantModel;

    /**
     * 是否开启自动回复
     */
    private Boolean autoReply = Boolean.FALSE;

    /**
     * 是否只回复空内容
     */
    private Boolean onlyEmpty = Boolean.TRUE;

    private Boolean closeManually;

    private String secret;

    @ApiModelProperty("镇/乡/村")
    private String town;

    /**
     * 外部门店编码：将外部门店和我们的店铺进行关联
     */
    @ApiModelProperty(value = "外部门店编码")
    private String externalMerchantNo;

    private String appId;

    @ApiModelProperty(value = "是否开启配送")
    private Boolean openShipping;

    @ApiModelProperty(value = "平台id")
    private Long platformId;

    @ApiModelProperty(value = "服务说明")
    private List<ServiceDescriptionVM> serviceDescription;

    /**
     * 1:周一  2：周二  4：周三   8：周四  16：周五   32：周六  64：周日
     */
    @ApiModelProperty(value = "营业时间 周一到周末")
    private Integer businessHours;

    @ApiModelProperty(value = "店鋪分类id")
    private Long platformShopCategoryId;

    @ApiModelProperty(value = "店铺第三方类型")
    private ThirdPartyType thirdPartyType;

    @ApiModelProperty(value = "通吃岛平台id")
    private Long tcdPlatformId;

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


    @ApiModelProperty(value = "门店分类id")
    private List<Long> catId;
    
    
    @ApiModelProperty(value = "是否是后台添加")
    private Boolean back;
    
    
    @ApiModelProperty(value = "平台门店信息")
    private PlatFormMerchantDTO platFormMerchantDTO;
    
    /**
     * 图片展示 1 菜品 2 门店
     */
    @ApiModelProperty(value = "图片展示 1 菜品 2 门店")
    private Integer picShowType;
    
    @ApiModelProperty(value = "门店logo")
    private String merchantLogo;
    
    @ApiModelProperty(value = "门店环境图")
    private String merchantAroundPic;
    
    @ApiModelProperty(value = "门店宣传图")
    private String merchantPropagandaPic;

    @ApiModelProperty(value = "mdm的third_no")
    private String thirdNo;
    
    
    public MerchantVM() {
    }

    public String getThirdNo() {
        return thirdNo;
    }

    public void setThirdNo(String thirdNo) {
        this.thirdNo = thirdNo;
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
    
    public PlatFormMerchantDTO getPlatFormMerchantDTO() {
        return platFormMerchantDTO;
    }
    
    public void setPlatFormMerchantDTO(PlatFormMerchantDTO platFormMerchantDTO) {
        this.platFormMerchantDTO = platFormMerchantDTO;
    }
    
    public Boolean isBack() {
        return back;
    }
    
    public Boolean getBack() {
        return back;
    }
    
    public void setBack(Boolean back) {
        this.back = back;
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

    public Long getTcdPlatformId() {
        return tcdPlatformId;
    }

    public void setTcdPlatformId(Long tcdPlatformId) {
        this.tcdPlatformId = tcdPlatformId;
    }

    public ThirdPartyType getThirdPartyType() {
        return thirdPartyType;
    }

    public void setThirdPartyType(ThirdPartyType thirdPartyType) {
        this.thirdPartyType = thirdPartyType;
    }

    public Long getPlatformShopCategoryId() {
        return platformShopCategoryId;
    }

    public void setPlatformShopCategoryId(Long platformShopCategoryId) {
        this.platformShopCategoryId = platformShopCategoryId;
    }

    public List<ServiceDescriptionVM> getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(List<ServiceDescriptionVM> serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public Integer getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(Integer businessHours) {
        this.businessHours = businessHours;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
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

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Boolean isCloseManually() {
        return closeManually;
    }

    public void setCloseManually(Boolean closeManually) {
        this.closeManually = closeManually;
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

    public String getIndustryStr() {
        return industryStr;
    }

    public void setIndustryStr(String industryStr) {
        this.industryStr = industryStr;
    }

    public Double getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(Double shippingPrice) {
        this.shippingPrice = shippingPrice;
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

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public Integer getIndustry() {
        return industry;
    }

    public void setIndustry(Integer industry) {
        this.industry = industry;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getCounty() {
        return county;
    }

    public void setCounty(Integer county) {
        this.county = county;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLegal_person() {
        return legal_person;
    }

    public void setLegal_person(String legal_person) {
        this.legal_person = legal_person;
    }

    public String getService_phone() {
        return service_phone;
    }

    public void setService_phone(String service_phone) {
        this.service_phone = service_phone;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getPrincipal_mobile() {
        return principal_mobile;
    }

    public void setPrincipal_mobile(String principal_mobile) {
        this.principal_mobile = principal_mobile;
    }

    public Long getIdentity_code() {
        return identity_code;
    }

    public void setIdentity_code(Long identity_code) {
        this.identity_code = identity_code;
    }

    public String getIdentity_ago() {
        return identity_ago;
    }

    public void setIdentity_ago(String identity_ago) {
        this.identity_ago = identity_ago;
    }

    public String getIdentity_after() {
        return identity_after;
    }

    public void setIdentity_after(String identity_after) {
        this.identity_after = identity_after;
    }

    public String getLicense_photo() {
        return license_photo;
    }

    public void setLicense_photo(String license_photo) {
        this.license_photo = license_photo;
    }

    public String getProtocol_photo() {
        return protocol_photo;
    }

    public void setProtocol_photo(String protocol_photo) {
        this.protocol_photo = protocol_photo;
    }

    public String getOrg_photo() {
        return org_photo;
    }

    public void setOrg_photo(String org_photo) {
        this.org_photo = org_photo;
    }

    public String getBusiness_code() {
        return business_code;
    }

    public void setBusiness_code(String business_code) {
        this.business_code = business_code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMerchantQr() {
        return merchantQr;
    }

    public void setMerchantQr(String merchantQr) {
        this.merchantQr = merchantQr;
    }

    public String getShopReceiveUrl() {
        return shopReceiveUrl;
    }

    public void setShopReceiveUrl(String shopReceiveUrl) {
        this.shopReceiveUrl = shopReceiveUrl;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getShopImages() {
        return shopImages;
    }

    public void setShopImages(String shopImages) {
        this.shopImages = shopImages;
    }

    public String getShopRealImages() {
        return shopRealImages;
    }

    public void setShopRealImages(String shopRealImages) {
        this.shopRealImages = shopRealImages;
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

    public Integer getAutoReceiveOrderMod() {
        return autoReceiveOrderMod;
    }

    public void setAutoReceiveOrderMod(Integer autoReceiveOrderMod) {
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

    public Long getBrand() {
        return brand;
    }

    public void setBrand(Long brand) {
        this.brand = brand;
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

    public String getExternalMerchantNo() {
        return externalMerchantNo;
    }

    public void setExternalMerchantNo(String externalMerchantNo) {
        this.externalMerchantNo = externalMerchantNo;
    }

    public Boolean getAutoReply() {
        return isAutoReply;
    }

    public Boolean getOnlyEmpty() {
        return onlyEmpty;
    }

    public Boolean getCloseManually() {
        return closeManually;
    }

    public List<Long> getCatId() {
        return catId;
    }

    public void setCatId(List<Long> catId) {
        this.catId = catId;
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
}
