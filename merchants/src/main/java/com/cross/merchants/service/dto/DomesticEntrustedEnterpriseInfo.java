package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/*************************************************************
 * Description: 境内委托企业相关信息
 * Author: Dair
 * CreateTime: 2020/5/15
 ************************************************************/
@ApiModel(description = "境内委托企业相关信息")
public class DomesticEntrustedEnterpriseInfo implements Serializable {


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
     * 社会统一信用代码
     */
    @ApiModelProperty(value = "社会统一信用代码")
    private String socialUniformCreditCode;


    /**
     * 营业执照编号
     */
    @ApiModelProperty(value = "营业执照编号")
    private String businessLicenseNo;

    /**
     * 有效期(为空则永久)
     */
    @ApiModelProperty(value = "有效期(为空则永久) yyyy-mm-dd")
    private String validTime;



    /**
     * 境内企业委托联系人姓名
     */
    @ApiModelProperty(value = "境内企业委托联系人姓名")
    private String contacts;

    /**
     * 境内企业委托联系人手机
     */
    @ApiModelProperty(value = "境内企业委托联系人手机")
    private String contactsOfPhone;

    /**
     * 境内企业委托联系人邮箱
     */
    @ApiModelProperty(value = "境内企业委托联系人邮箱")
    private String contactsOfEmail;

    /**
     * 境内企业委托联系人地址
     */
    @ApiModelProperty(value = "境内企业委托联系人地址")
    private String contactsOfAddress;


    public String getContactsOfEmail() {
        return contactsOfEmail;
    }

    public void setContactsOfEmail(String contactsOfEmail) {
        this.contactsOfEmail = contactsOfEmail;
    }

    public String getSocialUniformCreditCode() {
        return socialUniformCreditCode;
    }

    public void setSocialUniformCreditCode(String socialUniformCreditCode) {
        this.socialUniformCreditCode = socialUniformCreditCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<String> getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(List<String> businessLicense) {
        this.businessLicense = businessLicense;
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

    public String getValidTime() {
        return validTime;
    }

    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContactsOfPhone() {
        return contactsOfPhone;
    }

    public void setContactsOfPhone(String contactsOfPhone) {
        this.contactsOfPhone = contactsOfPhone;
    }



    public String getContactsOfAddress() {
        return contactsOfAddress;
    }

    public void setContactsOfAddress(String contactsOfAddress) {
        this.contactsOfAddress = contactsOfAddress;
    }
}
