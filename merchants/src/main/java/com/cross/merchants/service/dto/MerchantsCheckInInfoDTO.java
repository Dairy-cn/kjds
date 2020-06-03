package com.cross.merchants.service.dto;

import com.cross.interfaces.JodaInstant2DateJsonDeserializer;
import com.cross.interfaces.JodaInstant2DateJsonSerializer;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import liquibase.pro.packaged.S;

import java.time.Instant;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchants.domain.MerchantsCheckInInfo} entity.
 */
@ApiModel(description = "商户入住审核相关")
public class MerchantsCheckInInfoDTO implements Serializable {

    private Long id;

    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    private String companyName;

    /**
     * 营业执照
     */
    @ApiModelProperty(value = "营业执照")
    private List<String> businessLicense;

    /**
     * 营业执照注册地址
     */
    @ApiModelProperty(value = "营业执照注册地址")
    private String businessLicenseRegisteredAddress;

    /**
     * 营业执照编号
     */
    @ApiModelProperty(value = "营业执照编号")
    private String businessLicenseNo;

    /**
     * 营业执照有效期(为空则永久)
     */
    @ApiModelProperty(value = "营业执照有效期(为空则永久) yyyy-mm-dd")
    private String businessLicenseValidTime;

    /**
     * 店铺贸易模式(1 一般贸易 2 跨境贸易)
     */
    @ApiModelProperty(value = "店铺贸易模式(1 一般贸易 2 跨境贸易)")
    private Integer tradeMode;

    /**
     * 申请人
     */
    @ApiModelProperty(value = "申请人")
    private Long proposer;

    /**
     * 申请时间
     */
    @ApiModelProperty(value = "申请时间")
    private Instant applicationTime;

    /**
     * 主营类目
     */
    @ApiModelProperty(value = "主营类目")
    private Long categoryId;



    /**
     * 省
     */
    @ApiModelProperty(value = "省")
    private String province;

    /**
     * 市
     */
    @ApiModelProperty(value = "市")
    private String city;

    /**
     * 国家
     */
    @ApiModelProperty(value = "国家")
    private String country;

    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String address;

    /**
     * 官网地址
     */
    @ApiModelProperty(value = "官网地址")
    private String webAdd;

    /**
     * 手机
     */
    @ApiModelProperty(value = "手机")
    private String telPhone;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 职位
     */
    @ApiModelProperty(value = "职位")
    private String position;

    /**
     * 联系人
     */
    @ApiModelProperty(value = "联系人")
    private String linkMan;

    /**
     * 审核状态 -1 未审核 0 未通过  1 通过
     */
    @ApiModelProperty(value = "审核状态 -1 未审核 0 未通过  1 通过")
    private Integer checkStatus;

    /**
     * 审核失败原因
     */
    @ApiModelProperty(value = "审核失败原因")
    private String checkFailureReasons;

    /**
     * 审核时间
     */
    @ApiModelProperty(value = "审核时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)
    private Instant checkTime;

    /**
     * 省
     */
    @ApiModelProperty(value = "省id")
    private Long provinceId;

    /**
     * 市
     */
    @ApiModelProperty(value = "市Id")
    private Long cityId;

    /**
     * 国家
     */
    @ApiModelProperty(value = "国家Id")
    private Long countryId;

    /**
     * 注册国家表id
     */
    @ApiModelProperty(value = "注册国家表id")
    private Long registerCountryId;

    /**
     * 注册国家表id
     */
    @ApiModelProperty(value = "公司注册文件类型 1 business registration 2 certificate of incorporation 3 other company registration")
    private Integer registerFileType;


    /**
     * 社会统一信用代码
     */
    @ApiModelProperty(value = "社会统一信用代码")
    private String socialUniformCreditCode;

    @ApiModelProperty(value = "境内委托企业相关信息")
    private DomesticEntrustedEnterpriseInfo domesticEntrustedEnterpriseInfo;

    @ApiModelProperty(value = "境内企业承诺书")
    private CommitmentLetterOfDomesticEnterprise commitmentLetterOfDomesticEnterprise;


    @ApiModelProperty(value = "海关登记书/进出口备案回执")
    private CustomsRegistrationAndImportAndExportRecordReceipt customsRegistrationAndImportAndExportRecordReceipt;

    /**
     * 注册账号
     */
    @ApiModelProperty(value = "注册账号")
    private String registerUserName ;

    @ApiModelProperty(value = "企业信息",hidden = true)
    private EnterpriseInfoDTO enterpriseInfoDTO;


    @ApiModelProperty(value = "仓库信息",hidden = true)
    private WarehouseInfoDTO warehouseInfoDTO;

    /**
     * 商户编号
     */
    @ApiModelProperty(value = "商户编号")
    private String merchantNo;

    @ApiModelProperty(value = "商户类别",hidden = true)
    private  MerchantsCategoryDTO merchantsCategoryDTO;


    public MerchantsCategoryDTO getMerchantsCategoryDTO() {
        return merchantsCategoryDTO;
    }

    public void setMerchantsCategoryDTO(MerchantsCategoryDTO merchantsCategoryDTO) {
        this.merchantsCategoryDTO = merchantsCategoryDTO;
    }

    public WarehouseInfoDTO getWarehouseInfoDTO() {
        return warehouseInfoDTO;
    }

    public void setWarehouseInfoDTO(WarehouseInfoDTO warehouseInfoDTO) {
        this.warehouseInfoDTO = warehouseInfoDTO;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getRegisterUserName() {
        return registerUserName;
    }

    public void setRegisterUserName(String registerUserName) {
        this.registerUserName = registerUserName;
    }

    public EnterpriseInfoDTO getEnterpriseInfoDTO() {
        return enterpriseInfoDTO;
    }

    public void setEnterpriseInfoDTO(EnterpriseInfoDTO enterpriseInfoDTO) {
        this.enterpriseInfoDTO = enterpriseInfoDTO;
    }

    public List<String> getBusinessLicense() {
        return businessLicense;
    }

    public CommitmentLetterOfDomesticEnterprise getCommitmentLetterOfDomesticEnterprise() {
        return commitmentLetterOfDomesticEnterprise;
    }

    public void setCommitmentLetterOfDomesticEnterprise(CommitmentLetterOfDomesticEnterprise commitmentLetterOfDomesticEnterprise) {
        this.commitmentLetterOfDomesticEnterprise = commitmentLetterOfDomesticEnterprise;
    }

    public CustomsRegistrationAndImportAndExportRecordReceipt getCustomsRegistrationAndImportAndExportRecordReceipt() {
        return customsRegistrationAndImportAndExportRecordReceipt;
    }

    public void setCustomsRegistrationAndImportAndExportRecordReceipt(CustomsRegistrationAndImportAndExportRecordReceipt customsRegistrationAndImportAndExportRecordReceipt) {
        this.customsRegistrationAndImportAndExportRecordReceipt = customsRegistrationAndImportAndExportRecordReceipt;
    }

    public void setBusinessLicense(List<String> businessLicense) {
        this.businessLicense = businessLicense;
    }

    public DomesticEntrustedEnterpriseInfo getDomesticEntrustedEnterpriseInfo() {
        return domesticEntrustedEnterpriseInfo;
    }

    public void setDomesticEntrustedEnterpriseInfo(DomesticEntrustedEnterpriseInfo domesticEntrustedEnterpriseInfo) {
        this.domesticEntrustedEnterpriseInfo = domesticEntrustedEnterpriseInfo;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getRegisterCountryId() {
        return registerCountryId;
    }

    public void setRegisterCountryId(Long registerCountryId) {
        this.registerCountryId = registerCountryId;
    }

    public Integer getRegisterFileType() {
        return registerFileType;
    }

    public void setRegisterFileType(Integer registerFileType) {
        this.registerFileType = registerFileType;
    }

    public String getSocialUniformCreditCode() {
        return socialUniformCreditCode;
    }

    public void setSocialUniformCreditCode(String socialUniformCreditCode) {
        this.socialUniformCreditCode = socialUniformCreditCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBusinessLicenseRegisteredAddress() {
        return businessLicenseRegisteredAddress;
    }

    public void setBusinessLicenseRegisteredAddress(String businessLicenseRegisteredAddress) {
        this.businessLicenseRegisteredAddress = businessLicenseRegisteredAddress;
    }

    public String getBusinessLicenseNo() {
        return businessLicenseNo;
    }

    public void setBusinessLicenseNo(String businessLicenseNo) {
        this.businessLicenseNo = businessLicenseNo;
    }

    public String getBusinessLicenseValidTime() {
        return businessLicenseValidTime;
    }

    public void setBusinessLicenseValidTime(String businessLicenseValidTime) {
        this.businessLicenseValidTime = businessLicenseValidTime;
    }

    public Integer getTradeMode() {
        return tradeMode;
    }

    public void setTradeMode(Integer tradeMode) {
        this.tradeMode = tradeMode;
    }

    public Long getProposer() {
        return proposer;
    }

    public void setProposer(Long proposer) {
        this.proposer = proposer;
    }

    public Instant getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Instant applicationTime) {
        this.applicationTime = applicationTime;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebAdd() {
        return webAdd;
    }

    public void setWebAdd(String webAdd) {
        this.webAdd = webAdd;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getCheckFailureReasons() {
        return checkFailureReasons;
    }

    public void setCheckFailureReasons(String checkFailureReasons) {
        this.checkFailureReasons = checkFailureReasons;
    }

    public Instant getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Instant checkTime) {
        this.checkTime = checkTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MerchantsCheckInInfoDTO merchantsCheckInInfoDTO = (MerchantsCheckInInfoDTO) o;
        if (merchantsCheckInInfoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), merchantsCheckInInfoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MerchantsCheckInInfoDTO{" +
            "id=" + getId() +
            ", companyName='" + getCompanyName() + "'" +
            ", businessLicense='" + getBusinessLicense() + "'" +
            ", businessLicenseRegisteredAddress='" + getBusinessLicenseRegisteredAddress() + "'" +
            ", businessLicenseNo='" + getBusinessLicenseNo() + "'" +
            ", businessLicenseValidTime='" + getBusinessLicenseValidTime() + "'" +
            ", tradeMode=" + getTradeMode() +
            ", proposer=" + getProposer() +
            ", applicationTime='" + getApplicationTime() + "'" +
            ", categoryId=" + getCategoryId() +
            ", province='" + getProvince() + "'" +
            ", city='" + getCity() + "'" +
            ", country='" + getCountry() + "'" +
            ", address='" + getAddress() + "'" +
            ", webAdd='" + getWebAdd() + "'" +
            ", telPhone='" + getTelPhone() + "'" +
            ", email='" + getEmail() + "'" +
            ", position='" + getPosition() + "'" +
            ", linkMan='" + getLinkMan() + "'" +
            ", checkStatus='" + getCheckStatus() + "'" +
            ", checkFailureReasons='" + getCheckFailureReasons() + "'" +
            ", checkTime='" + getCheckTime() + "'" +
            "}";
    }
}
