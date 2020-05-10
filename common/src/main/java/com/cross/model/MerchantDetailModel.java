package com.cross.model;

import java.io.Serializable;

/**
 * Created by DuYuLiang on 2017/7/11.
 */
public class MerchantDetailModel implements Serializable {
    private static final long serialVersionUID = 1905122041950251208L;

    private Long id;
    private Long merchantId;
    private String short_name;
    private Integer industry;
    private Integer province;
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
    private String position;
    private String town;

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

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

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
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
}
