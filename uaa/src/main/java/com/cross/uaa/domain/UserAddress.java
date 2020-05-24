package com.cross.uaa.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * 用户收货地址
 */
@Entity
@Table(name = "user_address")
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 收货人
     */
    @NotNull
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Size(max = 18)
    @Column(name = "user_name", length = 18)
    private String userName;

    /**
     * 地址详情
     */
    @Size(max = 120)
    @Column(name = "address", length = 120)
    private String address;

    /**
     * 手机号
     */
    @Size(max = 12)
    @Column(name = "phone", length = 12)
    private String phone;

    /**
     * 状态1正常-0删除
     */
    @Column(name = "delete_flag")
    private Boolean deleteFlag;

    /**
     * 排序
     */
    @Column(name = "sort")
    private Integer sort;

    /**
     * 性别 1 男 2 女  0 未知
     */
    @Column(name = "sex")
    private Integer sex;

    /**
     * 市
     */
    @Column(name = "city")
    private String city;

    /**
     * 省
     */
    @Column(name = "province")
    private String province;

    /**
     * 县
     */
    @Column(name = "county")
    private String county;

    /**
     * 是否是默认地址
     */
    @Column(name = "default_flag")
    private Boolean defaultFlag;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public UserAddress userId(Long userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public UserAddress userName(String userName) {
        this.userName = userName;
        return this;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public UserAddress address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public UserAddress phone(String phone) {
        this.phone = phone;
        return this;
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


    public UserAddress deleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
        return this;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getSort() {
        return sort;
    }

    public UserAddress sort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSex() {
        return sex;
    }

    public UserAddress sex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public UserAddress city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public UserAddress province(String province) {
        this.province = province;
        return this;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCounty() {
        return county;
    }

    public UserAddress county(String county) {
        this.county = county;
        return this;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Boolean isDefaultFlag() {
        return defaultFlag;
    }

    public UserAddress defaultFlag(Boolean defaultFlag) {
        this.defaultFlag = defaultFlag;
        return this;
    }

    public void setDefaultFlag(Boolean defaultFlag) {
        this.defaultFlag = defaultFlag;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserAddress)) {
            return false;
        }
        return id != null && id.equals(((UserAddress) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
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
