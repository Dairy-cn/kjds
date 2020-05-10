package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the App entity.
 */
public class AppModel implements Serializable {

    private Long id;

    @Size(max = 128)
    private String appId;

    @Size(max = 128)
    private String appSecret;

    @ApiModelProperty(value = "公众号AppId")
    private String publicAccountAppId;

    @ApiModelProperty(value = "公众号密钥")
    private String publicAccountAppSecret;

    private Long masterUserId;
    
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant addTime;

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

        AppModel appDTO = (AppModel) o;
        if (appDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), appDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, appId, appSecret, publicAccountAppId, publicAccountAppSecret, masterUserId, addTime);
    }

    @Override
    public String toString() {
        return "AppModel{" +
            "id=" + id +
            ", appId='" + appId + '\'' +
            ", appSecret='" + appSecret + '\'' +
            ", publicAccountAppId='" + publicAccountAppId + '\'' +
            ", publicAccountAppSecret='" + publicAccountAppSecret + '\'' +
            ", masterUserId=" + masterUserId +
            ", addTime=" + addTime +
            '}';
    }
}
