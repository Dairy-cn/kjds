package com.cross.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.cross.model.enumeration.BrandAndMerchantType;
import com.cross.model.enumeration.BrandSourceType;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the Brand entity.
 */
public class BrandDTO implements Serializable {


    private static final long serialVersionUID = 1839675938399825381L;
    private Long id;

    private String brandName;

    @Size(max = 255)
    private String details;

    @Size(max = 120)
    private String brandLogo;

    private Long userId;
    
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant addDate;

    private Boolean isDelete;

    private Integer merchantNum = 0;

    private Long platFormId;

    /**
     * 是否开启自动回复
     */
    private Boolean autoReply = Boolean.FALSE;

    /**
     * 是否只回复空内容
     */
    private Boolean onlyEmpty = Boolean.TRUE;

    /**
     * 绑定收款账户
     */
    private Long receiveAccountId;

    /**
     * 服务费费率
     */
    private List<BrandServiceModeVM> serviceRates;

    /**
     * 服务费率类型
     */
    private Integer serviceRateType;

    /**
     * 外部商户编码：关联外部品牌
     */
    @ApiModelProperty(value = "外部商户编码")
    private String externalBrandNo;

    /**
     * 收款账户开户姓名
     */
    @ApiModelProperty(value = "收款账户开户姓名")
    private String accountName;

    /**
     * 交易账号
     */
    @ApiModelProperty(value = "交易账号")
    private String accountNum;

    /**
     * 开户行
     */
    @ApiModelProperty(value = "开户行")
    private String back;

    @ApiModelProperty(value = "联系人姓名")
    private String contactName;

    @ApiModelProperty(value = "联系人电话")
    private String contactPhone;

    @ApiModelProperty(value = "品牌来源：官网  赚餐 小程序,通吃岛，自营")
    private BrandSourceType brandSourceType;

    @ApiModelProperty(value = "公司规模 1 连锁  2 单店")
    private Integer brandScale;

    @ApiModelProperty(value = "品牌编码：入驻通吃岛成功时品牌名的首字母加6个随机数")
    private String brandNo;

    @ApiModelProperty(value = "创建者电话")
    private String createPhone;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "营业执照url")
    private String businessLicenseUrl;

    @ApiModelProperty(value = "营业执照编码")
    private String businessLicenseNo;

    @ApiModelProperty(value = "入驻通吃岛平台情况：1 未入驻  2 审核中 3 入驻成功 4 入驻失败")
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

    @ApiModelProperty(value = "入驻失败原因")
    private String reason;

    @ApiModelProperty(value = "所属行业")
    private String business;


    @ApiModelProperty(value = "所属行业Id")
    private Long businessId;

    @ApiModelProperty(value = "入驻通吃岛门店的数量")
    private Integer enteringMerchantNum = 0;

    @ApiModelProperty(value = "品牌类型")
    private BrandAndMerchantType brandAndMerchantType;
    
    
    @ApiModelProperty(value = "品牌标签")
    private String  brandTag;
    
    
    @ApiModelProperty(value = "品牌详情图")
    private String  brandDetailPic;

    public BrandDTO() {
    }
    
    public String getBrandDetailPic() {
        return brandDetailPic;
    }
    
    public void setBrandDetailPic(String brandDetailPic) {
        this.brandDetailPic = brandDetailPic;
    }
    
    public String getBrandTag() {
        return brandTag;
    }
    
    public void setBrandTag(String brandTag) {
        this.brandTag = brandTag;
    }
    
    public Integer getEnteringMerchantNum() {
        return enteringMerchantNum;
    }

    public void setEnteringMerchantNum(Integer enteringMerchantNum) {
        this.enteringMerchantNum = enteringMerchantNum;
    }

    public BrandAndMerchantType getBrandAndMerchantType() {
        return brandAndMerchantType;
    }

    public void setBrandAndMerchantType(BrandAndMerchantType brandAndMerchantType) {
        this.brandAndMerchantType = brandAndMerchantType;
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

    public BrandSourceType getBrandSourceType() {
        return brandSourceType;
    }

    public void setBrandSourceType(BrandSourceType brandSourceType) {
        this.brandSourceType = brandSourceType;
    }

    public Integer getBrandScale() {
        return brandScale;
    }

    public void setBrandScale(Integer brandScale) {
        this.brandScale = brandScale;
    }

    public String getBrandNo() {
        return brandNo;
    }

    public void setBrandNo(String brandNo) {
        this.brandNo = brandNo;
    }

    public String getCreatePhone() {
        return createPhone;
    }

    public void setCreatePhone(String createPhone) {
        this.createPhone = createPhone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBusinessLicenseUrl() {
        return businessLicenseUrl;
    }

    public void setBusinessLicenseUrl(String businessLicenseUrl) {
        this.businessLicenseUrl = businessLicenseUrl;
    }

    public String getBusinessLicenseNo() {
        return businessLicenseNo;
    }

    public void setBusinessLicenseNo(String businessLicenseNo) {
        this.businessLicenseNo = businessLicenseNo;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public Integer getMerchantNum() {
        return merchantNum;
    }

    public void setMerchantNum(Integer merchantNum) {
        this.merchantNum = merchantNum;
    }

    public Long getPlatFormId() {
        return platFormId;
    }

    public void setPlatFormId(Long platFormId) {
        this.platFormId = platFormId;
    }

    public Boolean getAutoReply() {
        return autoReply;
    }

    public Boolean getOnlyEmpty() {
        return onlyEmpty;
    }

    public Long getReceiveAccountId() {
        return receiveAccountId;
    }

    public void setReceiveAccountId(Long receiveAccountId) {
        this.receiveAccountId = receiveAccountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public List<BrandServiceModeVM> getServiceRates() {
        return serviceRates;
    }

    public void setServiceRates(List<BrandServiceModeVM> serviceRates) {
        this.serviceRates = serviceRates;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Instant getAddDate() {
        return addDate;
    }

    public void setAddDate(Instant addDate) {
        this.addDate = addDate;
    }

    public Boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BrandDTO brandDTO = (BrandDTO) o;
        if(brandDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), brandDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BrandDTO{" +
            "id=" + getId() +
            ", brandName='" + getBrandName() + "'" +
            ", userId='" + getUserId() + "'" +
            ", addDate='" + getAddDate() + "'" +
            ", isDelete='" + isIsDelete() + "'" +
            "}";
    }

    public Integer getServiceRateType() {
        return serviceRateType;
    }

    public void setServiceRateType(Integer serviceRateType) {
        this.serviceRateType = serviceRateType;
    }

    public String getExternalBrandNo() {
        return externalBrandNo;
    }

    public void setExternalBrandNo(String externalBrandNo) {
        this.externalBrandNo = externalBrandNo;
    }
}
