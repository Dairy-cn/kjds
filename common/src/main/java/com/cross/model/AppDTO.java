package com.cross.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the App entity.
 */
public class AppDTO implements Serializable {

    private Long id;

    @Size(max = 128)
    private String appId;

    @Size(max = 128)
    private String appSecret;

    private Long masterUserId;

    private Instant addTime;

    @NotNull(message = "平台id不能为空")
    private Long platformId;

    /**
     * 1 微信小程序
     * 2 支付宝小程序
     * 3 今日头条小程序
     * 4 抖音小程序
     * 5 百度小程序
     * 6 微信公众号
     */
    @NotNull(message = "小程序类型不能为空")
    private Integer appType;


    private String appLogo;

    private String appName;
    
    @ApiModelProperty(value = "公众号AppId")
    private String publicAccountAppId;
    
    @ApiModelProperty(value = "公众号密钥")
    private String publicAccountAppSecret;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public Long getMasterUserId() {
        return masterUserId;
    }

    public void setMasterUserId(Long masterUserId) {
        this.masterUserId = masterUserId;
    }

    public Instant getAddTime() {
        return addTime;
    }

    public void setAddTime(Instant addTime) {
        this.addTime = addTime;
    }

    public String getAppLogo() {
        return appLogo;
    }

    public void setAppLogo(String appLogo) {
        this.appLogo = appLogo;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
    
    public String getPublicAccountAppId() {
        return publicAccountAppId;
    }
    
    public void setPublicAccountAppId(String publicAccountAppId) {
        this.publicAccountAppId = publicAccountAppId;
    }
    
    public String getPublicAccountAppSecret() {
        return publicAccountAppSecret;
    }
    
    public void setPublicAccountAppSecret(String publicAccountAppSecret) {
        this.publicAccountAppSecret = publicAccountAppSecret;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AppDTO appDTO = (AppDTO) o;
        if (appDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), appDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AppDTO{" +
            "id=" + id +
            ", appId='" + appId + '\'' +
            ", appSecret='" + appSecret + '\'' +
            ", masterUserId=" + masterUserId +
            ", addTime=" + addTime +
            ", platformId=" + platformId +
            ", appType=" + appType +
            ", appLogo='" + appLogo + '\'' +
            ", appName='" + appName + '\'' +
            '}';
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public Integer getAppType() {
        return appType;
    }

    public void setAppType(Integer appType) {
        this.appType = appType;
    }
}
