package com.cross.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

public class MerchantDetailsDTO implements Serializable{

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long merchantId;

    private String short_name;

    /**
     * 行业编号
     */
    private Integer industry;

    /**
     * 行业标签
     */
    private String industryStr;

    private String province;

    private String city;

    private String county;

    private String address;

    private String tel;

    private String email;

    private String legal_person;

    private String service_phone;

    private String principal;

    private String principal_mobile;

    private Long identity_code;

    private String identity_ago;

    private String identity_after;

    private String license_photo;

    private String protocol_photo;

    private String org_photo;

    private String business_code;

    private String shopImage;

    private String shopRealImages;

    /**
     * 第一个是经度  第二个是纬度
     */
    private String position;

    /**
     * 所有总分
     */
    private Double allFraction = 0d;

    /**
     * 评价分
     */
    private Double averageFraction = 0d;

    /**
     * 评论总次数
     */
    private Integer commentCount = 0;

    /**
     * 月销量
     */
    private Integer monthCount = 0;

    /**
     * 商户分数
     */
    @ApiModelProperty(value = "商户分数")
    private Double merchantFraction = 0d;

    /**
     * 配送分数
     */
    @ApiModelProperty(value = "配送分数")
    private Double shippingFraction = 0d;

    /**
     * 配送分数
     */
    @ApiModelProperty(value = "配送分数")
    private Double productFraction = 0d;

    @ApiModelProperty("镇/乡/村")
    private String town;

    @ApiModelProperty(value = "服务说明")
    private List<ServiceDescriptionVM> serviceDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
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

    public String getIndustryStr() {
        return industryStr;
    }

    public void setIndustryStr(String industryStr) {
        this.industryStr = industryStr;
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

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
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

    public String getShopImage() {
        return shopImage;
    }

    public void setShopImage(String shopImage) {
        this.shopImage = shopImage;
    }

    public String getShopRealImages() {
        return shopRealImages;
    }

    public void setShopRealImages(String shopRealImages) {
        this.shopRealImages = shopRealImages;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getAllFraction() {
        return allFraction;
    }

    public void setAllFraction(Double allFraction) {
        this.allFraction = allFraction;
    }

    public Double getAverageFraction() {
        return averageFraction;
    }

    public void setAverageFraction(Double averageFraction) {
        this.averageFraction = averageFraction;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getMonthCount() {
        return monthCount;
    }

    public void setMonthCount(Integer monthCount) {
        this.monthCount = monthCount;
    }

    public Double getMerchantFraction() {
        return merchantFraction;
    }

    public void setMerchantFraction(Double merchantFraction) {
        this.merchantFraction = merchantFraction;
    }

    public Double getShippingFraction() {
        return shippingFraction;
    }

    public void setShippingFraction(Double shippingFraction) {
        this.shippingFraction = shippingFraction;
    }

    public Double getProductFraction() {
        return productFraction;
    }

    public void setProductFraction(Double productFraction) {
        this.productFraction = productFraction;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public List<ServiceDescriptionVM> getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(List<ServiceDescriptionVM> serviceDescription) {
        this.serviceDescription = serviceDescription;
    }
}
