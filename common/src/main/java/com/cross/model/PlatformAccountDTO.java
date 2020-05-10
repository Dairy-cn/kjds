package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.platform.domain.PlatformAccount} entity.
 */
@ApiModel(description = "入住通吃岛的平台账号信息")
public class PlatformAccountDTO implements Serializable {

    private Long id;

    /**
     * 通吃岛id
     */
    @ApiModelProperty(value = "通吃岛id")
    private Long tcdId;

    /**
     * 入住平台id
     */
    @ApiModelProperty(value = "入住平台id")
    private Long platformId;

    /**
     * 入住平台name
     */
    @ApiModelProperty(value = "入住平台name")
    private String platformName;

    /**
     * 入住平台余额
     */
    @ApiModelProperty(value = "入住平台余额")
    private BigDecimal amount;

    /**
     * 入住平台推广余额
     */
    @ApiModelProperty(value = "入住平台推广余额")
    private BigDecimal promotionAmount;

    /**
     * 加入时间
     */
    @ApiModelProperty(value = "加入时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant joinTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTcdId() {
        return tcdId;
    }

    public void setTcdId(Long tcdId) {
        this.tcdId = tcdId;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPromotionAmount() {
        return promotionAmount;
    }

    public void setPromotionAmount(BigDecimal promotionAmount) {
        this.promotionAmount = promotionAmount;
    }

    public Instant getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Instant joinTime) {
        this.joinTime = joinTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PlatformAccountDTO platformAccountDTO = (PlatformAccountDTO) o;
        if (platformAccountDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), platformAccountDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PlatformAccountDTO{" +
            "id=" + getId() +
            ", tcdId=" + getTcdId() +
            ", platformId=" + getPlatformId() +
            ", platformName='" + getPlatformName() + "'" +
            ", amount=" + getAmount() +
            ", promotionAmount=" + getPromotionAmount() +
            ", joinTime='" + getJoinTime() + "'" +
            "}";
    }
}
