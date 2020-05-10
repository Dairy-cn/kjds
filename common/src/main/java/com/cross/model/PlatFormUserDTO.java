package com.cross.model;


import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the PlatFormUser entity.
 */
public class PlatFormUserDTO implements Serializable {

    private Long id;

    private String userName;

    private String phone;

    private String imageUrl;

    private Integer age;

    @Size(max = 18)
    private String identityNumber;

    private String identityAgoHand;

    private String identityAgo;

    private String identityAfter;

    private Integer auditStatus;

    private String province;

    private String city;

    private String county;

    private String address;

    private Integer status;

    private Long createdBy;

    private String coordinate;

    private String schoolName;

    private String contactName;

    /**
     * 创建时间
     */
    private Integer createdDate;

    /**
     * 最后修改者
     */
    private Long lastModifiedBy;

    /**
     * 最后修改时间
     */
    private Integer lastModifiedDate;

    private Long brandId;

    @ApiModelProperty(value = "入驻通吃岛平台情况：1 未入驻  2 审核中 3 入驻成功 4 入驻失败")
    private Integer enteringInfo;

    /**
     * 之前创建的平台来源为null
     */
    @ApiModelProperty(value = "平台来源 1(或者null) 购买 2 未购买（游客） 3 通吃岛（特有平台）")
    private Integer platformSource;
    
    @ApiModelProperty(value = "通吃岛平台")
    private Long tcdId;

    @ApiModelProperty(value = "收款账号Id")
    private Long platformMerchantNoId;

    @ApiModelProperty(value = "小程序收款账号Id")
    private Long platformWeAppMerchantNoId;

    /**
     * 当该平台存在此id时表明该平台与掌控者打通
     */
    @ApiModelProperty(value = "mdm对应的enterpriseGuid")
    private String enterpriseGuid;

    public String getEnterpriseGuid() {
        return enterpriseGuid;
    }

    public void setEnterpriseGuid(String enterpriseGuid) {
        this.enterpriseGuid = enterpriseGuid;
    }
    
    public Long getTcdId() {
        return tcdId;
    }
    
    public void setTcdId(Long tcdId) {
        this.tcdId = tcdId;
    }
    
    public Integer getEnteringInfo() {
        return enteringInfo;
    }

    public void setEnteringInfo(Integer enteringInfo) {
        this.enteringInfo = enteringInfo;
    }

    public Integer getPlatformSource() {
        return platformSource;
    }

    public void setPlatformSource(Integer platformSource) {
        this.platformSource = platformSource;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getIdentityAgoHand() {
        return identityAgoHand;
    }

    public void setIdentityAgoHand(String identityAgoHand) {
        this.identityAgoHand = identityAgoHand;
    }

    public String getIdentityAgo() {
        return identityAgo;
    }

    public void setIdentityAgo(String identityAgo) {
        this.identityAgo = identityAgo;
    }

    public String getIdentityAfter() {
        return identityAfter;
    }

    public void setIdentityAfter(String identityAfter) {
        this.identityAfter = identityAfter;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Integer createdDate) {
        this.createdDate = createdDate;
    }

    public Long getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Integer getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Integer lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getPlatformMerchantNoId() {
        return platformMerchantNoId;
    }

    public void setPlatformMerchantNoId(Long platformMerchantNoId) {
        this.platformMerchantNoId = platformMerchantNoId;
    }

    public Long getPlatformWeAppMerchantNoId() {
        return platformWeAppMerchantNoId;
    }

    public void setPlatformWeAppMerchantNoId(Long platformWeAppMerchantNoId) {
        this.platformWeAppMerchantNoId = platformWeAppMerchantNoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PlatFormUserDTO platFormUserDTO = (PlatFormUserDTO) o;
        if(platFormUserDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), platFormUserDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PlatFormUserDTO{" +
            "id=" + id +
            ", userName='" + userName + '\'' +
            ", phone='" + phone + '\'' +
            ", imageUrl='" + imageUrl + '\'' +
            ", age=" + age +
            ", identityNumber='" + identityNumber + '\'' +
            ", identityAgoHand='" + identityAgoHand + '\'' +
            ", identityAgo='" + identityAgo + '\'' +
            ", identityAfter='" + identityAfter + '\'' +
            ", auditStatus=" + auditStatus +
            ", province='" + province + '\'' +
            ", city='" + city + '\'' +
            ", county='" + county + '\'' +
            ", address='" + address + '\'' +
            ", status=" + status +
            ", createdBy=" + createdBy +
            ", coordinate='" + coordinate + '\'' +
            ", schoolName='" + schoolName + '\'' +
            ", contactName='" + contactName + '\'' +
            ", createdDate=" + createdDate +
            ", lastModifiedBy=" + lastModifiedBy +
            ", lastModifiedDate=" + lastModifiedDate +
            ", brandId=" + brandId +
            ", enteringInfo=" + enteringInfo +
            ", platformSource=" + platformSource +
            ", platformMerchantNoId=" + platformMerchantNoId +
            ", platformWeAppMerchantNoId=" + platformWeAppMerchantNoId +
            '}';
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
}
