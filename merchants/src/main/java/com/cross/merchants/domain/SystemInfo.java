package com.cross.merchants.domain;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * 系统信息
 */
@Entity
@Table(name = "system_info")
public class SystemInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 平台名称
     */
    @Column(name = "platform_name")
    private String platformName;

    /**
     * 平台Logo
     */
    @Column(name = "platform_logo")
    private String platformLogo;

    /**
     * 微信平台应用编号
     */
    @Column(name = "plat_app_id")
    private String platAppId;

    /**
     * 平台应用密钥
     */
    @Column(name = "plat_app_secret")
    private String platAppSecret;

    /**
     * 支付宝appId
     */
    @Column(name = "ali_app_id")
    private String aliAppId;

    /**
     * 支付宝私钥
     */
    @Column(name = "ali_app_privte_key")
    private String aliAppPrivteKey;

    /**
     * 支付宝公钥
     */
    @Column(name = "ali_app_public_key")
    private String aliAppPublicKey;


    /**
     * 平台应用密钥
     */
    @ApiModelProperty(value = "微信平台商户号")
    @Column(name = "plat_app_no")
    private String platAppNo;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove


    public String getPlatAppNo() {
        return platAppNo;
    }
    public SystemInfo platAppNo(String platAppNo) {
        this.platAppNo = platAppNo;
        return this;
    }
    public void setPlatAppNo(String platAppNo) {
        this.platAppNo = platAppNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlatformName() {
        return platformName;
    }

    public SystemInfo platformName(String platformName) {
        this.platformName = platformName;
        return this;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformLogo() {
        return platformLogo;
    }

    public SystemInfo platformLogo(String platformLogo) {
        this.platformLogo = platformLogo;
        return this;
    }

    public void setPlatformLogo(String platformLogo) {
        this.platformLogo = platformLogo;
    }

    public String getPlatAppId() {
        return platAppId;
    }

    public SystemInfo platAppId(String platAppId) {
        this.platAppId = platAppId;
        return this;
    }

    public void setPlatAppId(String platAppId) {
        this.platAppId = platAppId;
    }

    public String getPlatAppSecret() {
        return platAppSecret;
    }

    public SystemInfo platAppSecret(String platAppSecret) {
        this.platAppSecret = platAppSecret;
        return this;
    }

    public void setPlatAppSecret(String platAppSecret) {
        this.platAppSecret = platAppSecret;
    }

    public String getAliAppId() {
        return aliAppId;
    }

    public SystemInfo aliAppId(String aliAppId) {
        this.aliAppId = aliAppId;
        return this;
    }

    public void setAliAppId(String aliAppId) {
        this.aliAppId = aliAppId;
    }

    public String getAliAppPrivteKey() {
        return aliAppPrivteKey;
    }

    public SystemInfo aliAppPrivteKey(String aliAppPrivteKey) {
        this.aliAppPrivteKey = aliAppPrivteKey;
        return this;
    }

    public void setAliAppPrivteKey(String aliAppPrivteKey) {
        this.aliAppPrivteKey = aliAppPrivteKey;
    }

    public String getAliAppPublicKey() {
        return aliAppPublicKey;
    }

    public SystemInfo aliAppPublicKey(String aliAppPublicKey) {
        this.aliAppPublicKey = aliAppPublicKey;
        return this;
    }

    public void setAliAppPublicKey(String aliAppPublicKey) {
        this.aliAppPublicKey = aliAppPublicKey;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SystemInfo)) {
            return false;
        }
        return id != null && id.equals(((SystemInfo) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "SystemInfo{" +
            "id=" + getId() +
            ", platformName='" + getPlatformName() + "'" +
            ", platformLogo='" + getPlatformLogo() + "'" +
            ", platAppId='" + getPlatAppId() + "'" +
            ", platAppSecret='" + getPlatAppSecret() + "'" +
            ", aliAppId='" + getAliAppId() + "'" +
            ", aliAppPrivteKey='" + getAliAppPrivteKey() + "'" +
            ", aliAppPublicKey='" + getAliAppPublicKey() + "'" +
            "}";
    }
}
