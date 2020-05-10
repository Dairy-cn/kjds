package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchant.domain.MdmOrganization} entity.
 */
public class MdmOrganizationDTO implements Serializable {

    private Long id;

    /**
     * 第三方唯一标识 我方数据库唯一id
     */
    @ApiModelProperty(value = "第三方唯一标识 我方数据库唯一id")
    private Long thirdNo;

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String code;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 营业时间(yyyy-MM-dd HH:mm:ss)
     */
    @ApiModelProperty(value = "营业时间(yyyy-MM-dd HH:mm:ss)")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)
    private Instant businessTime;

    /**
     * 所属品牌（type=2时，必填）
     */
    @ApiModelProperty(value = "所属品牌（type=2时，必填）")
    private String brandGuid;

    /**
     * 所属组织（默认为企业,type=0时，不填）
     */
    @ApiModelProperty(value = "所属组织（默认为企业,type=0时，不填）")
    private String fid;

    /**
     * 联系人
     */
    @ApiModelProperty(value = "联系人")
    private String contactName;

    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    private String contactTel;

    /**
     * 省
     */
    @ApiModelProperty(value = "省")
    private Integer province;

    /**
     * 市
     */
    @ApiModelProperty(value = "市")
    private Integer city;

    /**
     * 区
     */
    @ApiModelProperty(value = "区")
    private Integer district;

    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String address;

    /**
     * 0：企业，1：组织，2：门店
     */
    @ApiModelProperty(value = "0：企业，1：组织，2：门店")
    private String type;

    /**
     * 组织描述
     */
    @ApiModelProperty(value = "组织描述")
    private String remark;


    @ApiModelProperty(value = "启禁用状态：0：禁用，1：启用")
    private Integer enabled=1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Long getThirdNo() {
        return thirdNo;
    }

    public void setThirdNo(Long thirdNo) {
        this.thirdNo = thirdNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(Instant businessTime) {
        this.businessTime = businessTime;
    }

    public String getBrandGuid() {
        return brandGuid;
    }

    public void setBrandGuid(String brandGuid) {
        this.brandGuid = brandGuid;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
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

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MdmOrganizationDTO mdmOrganizationDTO = (MdmOrganizationDTO) o;
        if (mdmOrganizationDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), mdmOrganizationDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MdmOrganizationDTO{" +
            "id=" + getId() +
            ", thirdNo=" + getThirdNo() +
            ", code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            ", businessTime='" + getBusinessTime() + "'" +
            ", brandGuid='" + getBrandGuid() + "'" +
            ", fid='" + getFid() + "'" +
            ", contactName='" + getContactName() + "'" +
            ", contactTel='" + getContactTel() + "'" +
            ", province=" + getProvince() +
            ", city=" + getCity() +
            ", district=" + getDistrict() +
            ", address='" + getAddress() + "'" +
            ", type='" + getType() + "'" +
            ", remark='" + getRemark() + "'" +
            "}";
    }
}
