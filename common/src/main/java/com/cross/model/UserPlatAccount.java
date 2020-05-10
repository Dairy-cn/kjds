package com.cross.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A UserPlatAccount.
 */
@Entity
@Table(name = "user_plat_account")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UserPlatAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户编号
     */
    @Column(name = "user_id", nullable = false)
    private Long userId;

    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 身份标志
     */
    @NotNull
    @Size(max = 64)
    @Column(name = "jhi_identity", length = 64, nullable = false)
    private String identity;

    /**
     * 平台类型   2 支付宝 3 微信小程序 4 微信公众号
     */
    @Column(name = "plat_type")
    private Integer platType;

    /**
     * 商户编号
     */
    @Column(name = "merchant_no")
    private Long merchantNo;

    /**
     * 身份编号 不唯一
     */
    @Column(name = "union_id")
    private String unionId;

    /**
     * 平台编号
     */
    @Column(name = "platform_id")
    private Long platformId;

    /**
     * 用户对应电话号码
     */
    @Column(name = "login")
    private String login;

    /**
     * 创建时间
     */
    @Column(name = "add_time")
    private Integer addTime;

    /**
     * 终端应用编号
     */
    @Column(name = "app_id")
    private Long appId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public UserPlatAccount userId(Long userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public UserPlatAccount nickName(String nickName) {
        this.nickName = nickName;
        return this;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIdentity() {
        return identity;
    }

    public UserPlatAccount identity(String identity) {
        this.identity = identity;
        return this;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getLogin() {
        return login;
    }

    public UserPlatAccount login(String login) {
        this.login = login;
        return this;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getPlatType() {
        return platType;
    }

    public UserPlatAccount platType(Integer platType) {
        this.platType = platType;
        return this;
    }

    public void setPlatType(Integer platType) {
        this.platType = platType;
    }

    public Long getMerchantNo() {
        return merchantNo;
    }

    public UserPlatAccount merchantNo(Long merchantNo) {
        this.merchantNo = merchantNo;
        return this;
    }

    public void setMerchantNo(Long merchantNo) {
        this.merchantNo = merchantNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserPlatAccount userPlatAccount = (UserPlatAccount) o;
        if (userPlatAccount.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), userPlatAccount.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UserPlatAccount{" +
            "id=" + id +
            ", userId=" + userId +
            ", nickName='" + nickName + '\'' +
            ", identity='" + identity + '\'' +
            ", platType=" + platType +
            ", merchantNo=" + merchantNo +
            ", unionId='" + unionId + '\'' +
            ", platformId=" + platformId +
            ", login='" + login + '\'' +
            ", addTime=" + addTime +
            ", appId=" + appId +
            '}';
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }
}
