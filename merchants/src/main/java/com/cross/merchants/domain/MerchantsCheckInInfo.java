package com.cross.merchants.domain;


import com.cross.merchants.service.dto.CommitmentLetterOfDomesticEnterprise;
import com.cross.merchants.service.dto.CustomsRegistrationAndImportAndExportRecordReceipt;
import com.cross.merchants.service.dto.DomesticEntrustedEnterpriseInfo;
import io.swagger.annotations.ApiModelProperty;
import liquibase.pro.packaged.S;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.Instant;

/**
 * 商户入住审核相关
 */
@Entity
@Table(name = "merchants_check_in_info")
public class MerchantsCheckInInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 公司名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 营业执照
     */
    @Column(name = "business_license",length = 2000)
    private String businessLicense;

    /**
     * 营业执照注册地址
     */
    @Column(name = "business_license_registered_address")
    private String businessLicenseRegisteredAddress;

    /**
     * 营业执照编号
     */
    @Column(name = "business_license_no")
    private String businessLicenseNo;

    /**
     * 营业执照有效期(为空则永久)
     */
    @Column(name = "business_license_valid_time")
    private String businessLicenseValidTime;

    /**
     * 店铺贸易模式(1 一般贸易 2 跨境贸易)
     */
    @Column(name = "trade_mode")
    private Integer tradeMode;

    /**
     * 申请人
     */
    @Column(name = "proposer")
    private Long proposer;

    /**
     * 申请时间
     */
    @Column(name = "application_time")
    private Instant applicationTime;

    /**
     * 主营类目
     */
    @Column(name = "category_id")
    private Long categoryId;

    /**
     * 省
     */
    @Column(name = "province")
    private String province;

    /**
     * 市
     */
    @Column(name = "city")
    private String city;

    /**
     * 国家
     */
    @Column(name = "country")
    private String country;

    /**
     * 详细地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 官网地址
     */
    @Column(name = "web_add")
    private String webAdd;

    /**
     * 手机
     */
    @Column(name = "tel_phone")
    private String telPhone;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 职位
     */
    @Column(name = "position")
    private String position;

    /**
     * 联系人
     */
    @Column(name = "link_man")
    private String linkMan;

    /**
     * 审核状态 -1 未审核 0 未通过  1 通过
     */
    @Column(name = "check_status")
    private Integer checkStatus;

    /**
     * 审核失败原因
     */
    @Column(name = "check_failure_reasons")
    private String checkFailureReasons;

    /**
     * 审核时间
     */
    @Column(name = "check_time")
    private Instant checkTime;


    /**
     * 省
     */
    @ApiModelProperty(value = "省id")
    @Column(name = "province_id")
    private Long provinceId;

    /**
     * 市
     */
    @ApiModelProperty(value = "市Id")
    @Column(name = "city_id")
    private Long cityId;

    /**
     * 国家
     */
    @ApiModelProperty(value = "国家Id")
    @Column(name = "country_id")
    private Long countryId;

    /**
     * 注册国家表id
     */
    @ApiModelProperty(value = "注册国家表id")
    @Column(name = "register_country_id")
    private Long registerCountryId;

    /**
     * 注册国家表id
     */
    @ApiModelProperty(value = "公司注册文件类型 1 business registration 2 certificate of incorporation 3 other company registration")
    @Column(name = "register_file_type")
    private Integer registerFileType;


    /**
     * 社会统一信用代码
     */
    @ApiModelProperty(value = "社会统一信用代码")
    @Column(name = "social_uniform_credit_code")
    private String socialUniformCreditCode;


    @ApiModelProperty(value = "境内委托企业相关信息")
    @Column(name = "domestic_entrusted_enterprise_info",length = 2000)
    private String domesticEntrustedEnterpriseInfo;

    @ApiModelProperty(value = "境内企业承诺书")
    @Column(name = "commitment_letter_of_domestic_enterprise",length = 2000)
    private String commitmentLetterOfDomesticEnterprise;


    @ApiModelProperty(value = "海关登记书/进出口备案回执")
    @Column(name = "customs_registration_and_import_and_export_record_receipt" ,length = 2000)
    private String customsRegistrationAndImportAndExportRecordReceipt;


    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove


    public String getDomesticEntrustedEnterpriseInfo() {
        return domesticEntrustedEnterpriseInfo;
    }

    public void setDomesticEntrustedEnterpriseInfo(String domesticEntrustedEnterpriseInfo) {
        this.domesticEntrustedEnterpriseInfo = domesticEntrustedEnterpriseInfo;
    }

    public String getCommitmentLetterOfDomesticEnterprise() {
        return commitmentLetterOfDomesticEnterprise;
    }

    public void setCommitmentLetterOfDomesticEnterprise(String commitmentLetterOfDomesticEnterprise) {
        this.commitmentLetterOfDomesticEnterprise = commitmentLetterOfDomesticEnterprise;
    }

    public String getCustomsRegistrationAndImportAndExportRecordReceipt() {
        return customsRegistrationAndImportAndExportRecordReceipt;
    }

    public void setCustomsRegistrationAndImportAndExportRecordReceipt(String customsRegistrationAndImportAndExportRecordReceipt) {
        this.customsRegistrationAndImportAndExportRecordReceipt = customsRegistrationAndImportAndExportRecordReceipt;
    }

    public Long getProvinceId() {
        return provinceId;
    }
    public MerchantsCheckInInfo provinceId(Long provinceId) {
        this.provinceId = provinceId;
        return this;
    }
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }
    public MerchantsCheckInInfo cityId(Long cityId) {
        this.cityId = cityId;
        return this;
    }
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getCountryId() {
        return countryId;
    }
    public MerchantsCheckInInfo countryId(Long countryId) {
        this.countryId = countryId;
        return this;
    }
    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getRegisterCountryId() {
        return registerCountryId;
    }
    public MerchantsCheckInInfo registerCountryId(Long registerCountryId) {
        this.registerCountryId = registerCountryId;
        return this;
    }
    public void setRegisterCountryId(Long registerCountryId) {
        this.registerCountryId = registerCountryId;
    }

    public Integer getRegisterFileType() {
        return registerFileType;
    }
    public MerchantsCheckInInfo registerFileType(Integer registerFileType) {
        this.registerFileType = registerFileType;
        return this;
    }
    public void setRegisterFileType(Integer registerFileType) {
        this.registerFileType = registerFileType;
    }

    public String getSocialUniformCreditCode() {
        return socialUniformCreditCode;
    }
    public MerchantsCheckInInfo socialUniformCreditCode(String socialUniformCreditCode) {
        this.socialUniformCreditCode = socialUniformCreditCode;
        return this;
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

    public MerchantsCheckInInfo companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public MerchantsCheckInInfo businessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
        return this;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getBusinessLicenseRegisteredAddress() {
        return businessLicenseRegisteredAddress;
    }

    public MerchantsCheckInInfo businessLicenseRegisteredAddress(String businessLicenseRegisteredAddress) {
        this.businessLicenseRegisteredAddress = businessLicenseRegisteredAddress;
        return this;
    }

    public void setBusinessLicenseRegisteredAddress(String businessLicenseRegisteredAddress) {
        this.businessLicenseRegisteredAddress = businessLicenseRegisteredAddress;
    }

    public String getBusinessLicenseNo() {
        return businessLicenseNo;
    }

    public MerchantsCheckInInfo businessLicenseNo(String businessLicenseNo) {
        this.businessLicenseNo = businessLicenseNo;
        return this;
    }

    public void setBusinessLicenseNo(String businessLicenseNo) {
        this.businessLicenseNo = businessLicenseNo;
    }

    public String getBusinessLicenseValidTime() {
        return businessLicenseValidTime;
    }

    public MerchantsCheckInInfo businessLicenseValidTime(String businessLicenseValidTime) {
        this.businessLicenseValidTime = businessLicenseValidTime;
        return this;
    }

    public void setBusinessLicenseValidTime(String businessLicenseValidTime) {
        this.businessLicenseValidTime = businessLicenseValidTime;
    }

    public Integer getTradeMode() {
        return tradeMode;
    }

    public MerchantsCheckInInfo tradeMode(Integer tradeMode) {
        this.tradeMode = tradeMode;
        return this;
    }

    public void setTradeMode(Integer tradeMode) {
        this.tradeMode = tradeMode;
    }

    public Long getProposer() {
        return proposer;
    }

    public MerchantsCheckInInfo proposer(Long proposer) {
        this.proposer = proposer;
        return this;
    }

    public void setProposer(Long proposer) {
        this.proposer = proposer;
    }

    public Instant getApplicationTime() {
        return applicationTime;
    }

    public MerchantsCheckInInfo applicationTime(Instant applicationTime) {
        this.applicationTime = applicationTime;
        return this;
    }

    public void setApplicationTime(Instant applicationTime) {
        this.applicationTime = applicationTime;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public MerchantsCheckInInfo categoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getProvince() {
        return province;
    }

    public MerchantsCheckInInfo province(String province) {
        this.province = province;
        return this;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public MerchantsCheckInInfo city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public MerchantsCheckInInfo country(String country) {
        this.country = country;
        return this;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public MerchantsCheckInInfo address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebAdd() {
        return webAdd;
    }

    public MerchantsCheckInInfo webAdd(String webAdd) {
        this.webAdd = webAdd;
        return this;
    }

    public void setWebAdd(String webAdd) {
        this.webAdd = webAdd;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public MerchantsCheckInInfo telPhone(String telPhone) {
        this.telPhone = telPhone;
        return this;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getEmail() {
        return email;
    }

    public MerchantsCheckInInfo email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public MerchantsCheckInInfo position(String position) {
        this.position = position;
        return this;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public MerchantsCheckInInfo linkMan(String linkMan) {
        this.linkMan = linkMan;
        return this;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public MerchantsCheckInInfo checkStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
        return this;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getCheckFailureReasons() {
        return checkFailureReasons;
    }

    public MerchantsCheckInInfo checkFailureReasons(String checkFailureReasons) {
        this.checkFailureReasons = checkFailureReasons;
        return this;
    }

    public void setCheckFailureReasons(String checkFailureReasons) {
        this.checkFailureReasons = checkFailureReasons;
    }

    public Instant getCheckTime() {
        return checkTime;
    }

    public MerchantsCheckInInfo checkTime(Instant checkTime) {
        this.checkTime = checkTime;
        return this;
    }

    public void setCheckTime(Instant checkTime) {
        this.checkTime = checkTime;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MerchantsCheckInInfo)) {
            return false;
        }
        return id != null && id.equals(((MerchantsCheckInInfo) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "MerchantsCheckInInfo{" +
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
