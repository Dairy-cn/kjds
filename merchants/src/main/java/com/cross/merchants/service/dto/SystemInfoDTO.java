package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchants.domain.SystemInfo} entity.
 */
@ApiModel(description = "系统信息")
public class SystemInfoDTO implements Serializable {

    private Long id;

    /**
     * 平台名称
     */
    @ApiModelProperty(value = "平台名称")
    private String platformName;

    /**
     * 平台Logo
     */
    @ApiModelProperty(value = "平台Logo")
    private String platformLogo;

    /**
     * 微信平台应用编号
     */
    @ApiModelProperty(value = "微信平台应用编号")
    private String platAppId;

    /**
     * 微信平台商户密钥
     */
    @ApiModelProperty(value = "微信平台商户密钥")
    private String platAppSecret;

    /**
     * 平台应用密钥
     */
    @ApiModelProperty(value = "微信平台商户号")
    private String platAppNo;

    /**
     * 支付宝appId
     */
    @ApiModelProperty(value = "支付宝appId")
    private String aliAppId;

    /**
     * 支付宝私钥
     */
    @ApiModelProperty(value = "支付宝私钥")
    private String aliAppPrivteKey;

    /**
     * 支付宝公钥
     */
    @ApiModelProperty(value = "支付宝公钥")
    private String aliAppPublicKey;

    public String getPlatAppNo() {
        return platAppNo;
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

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformLogo() {
        return platformLogo;
    }

    public void setPlatformLogo(String platformLogo) {
        this.platformLogo = platformLogo;
    }

    public String getPlatAppId() {
        return platAppId;
    }

    public void setPlatAppId(String platAppId) {
        this.platAppId = platAppId;
    }

    public String getPlatAppSecret() {
        return platAppSecret;
    }

    public void setPlatAppSecret(String platAppSecret) {
        this.platAppSecret = platAppSecret;
    }

    public String getAliAppId() {
        return aliAppId;
    }

    public void setAliAppId(String aliAppId) {
        this.aliAppId = aliAppId;
    }

    public String getAliAppPrivteKey() {
        return aliAppPrivteKey;
    }

    public void setAliAppPrivteKey(String aliAppPrivteKey) {
        this.aliAppPrivteKey = aliAppPrivteKey;
    }

    public String getAliAppPublicKey() {
        return aliAppPublicKey;
    }

    public void setAliAppPublicKey(String aliAppPublicKey) {
        this.aliAppPublicKey = aliAppPublicKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SystemInfoDTO systemInfoDTO = (SystemInfoDTO) o;
        if (systemInfoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), systemInfoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SystemInfoDTO{" +
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
