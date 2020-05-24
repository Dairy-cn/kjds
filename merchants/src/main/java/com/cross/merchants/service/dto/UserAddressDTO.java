package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.uaa.domain.UserAddress} entity.
 */
@ApiModel(description = "用户收货地址")
public class UserAddressDTO implements Serializable {

    private Long id;

    /**
     * 收货人
     */
    @ApiModelProperty(value = "收货人Id")
    private Long userId;

    @Size(max = 18)
    @ApiModelProperty(value = "收货人")
    private String userName;

    /**
     * 地址详情
     */
    @Size(max = 120)
    @ApiModelProperty(value = "地址详情")
    private String address;

    /**
     * 手机号
     */
    @Size(max = 12)
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 状态1正常-0删除
     */
    @ApiModelProperty(value = "状态1正常-0删除")
    private Boolean deleteFlag;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 性别 1 男 2 女  0 未知
     */
    @ApiModelProperty(value = "性别 1 男 2 女  0 未知")
    private Integer sex;

    /**
     * 市
     */
    @ApiModelProperty(value = "市")
    private String city;

    /**
     * 省
     */
    @ApiModelProperty(value = "省")
    private String province;

    /**
     * 县
     */
    @ApiModelProperty(value = "县")
    private String county;

    /**
     * 是否是默认地址
     */
    @ApiModelProperty(value = "是否是默认地址")
    private Boolean defaultFlag;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public Boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Boolean getDefaultFlag() {
        return defaultFlag;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Boolean isDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(Boolean defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserAddressDTO userAddressDTO = (UserAddressDTO) o;
        if (userAddressDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), userAddressDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UserAddressDTO{" +
            "id=" + getId() +
            ", userId=" + getUserId() +
            ", userName='" + getUserName() + "'" +
            ", address='" + getAddress() + "'" +
            ", phone='" + getPhone() + "'" +
            ", deleteFlag=" + getDeleteFlag() +
            ", sort=" + getSort() +
            ", sex=" + getSex() +
            ", city='" + getCity() + "'" +
            ", province='" + getProvince() + "'" +
            ", county='" + getCounty() + "'" +
            ", defaultFlag='" + isDefaultFlag() + "'" +
            "}";
    }
}
