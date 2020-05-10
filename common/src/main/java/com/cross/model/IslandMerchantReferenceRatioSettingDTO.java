package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;


@ApiModel(description = "通吃岛商户参考比例配置")
public class IslandMerchantReferenceRatioSettingDTO implements Serializable {

    private Long id;

    /**
     * 通吃岛id
     */
    @ApiModelProperty(value = "通吃岛id")
    private Long platformId;

    /**
     * 商品首页比例
     */
    @ApiModelProperty(value = "商品首页比例")
    private Double dishIndexRatio;

    /**
     * 门店首页比例
     */
    @ApiModelProperty(value = "门店首页比例")
    private Double merchantIndexRatio;

    /**
     * 品牌首页比较
     */
    @ApiModelProperty(value = "品牌首页比较")
    private Double platformIndexRatio;

    /**
     * 操作人
     */
    @ApiModelProperty(value = "操作人")
    private String operUserName;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public Double getDishIndexRatio() {
        return dishIndexRatio;
    }

    public void setDishIndexRatio(Double dishIndexRatio) {
        this.dishIndexRatio = dishIndexRatio;
    }

    public Double getMerchantIndexRatio() {
        return merchantIndexRatio;
    }

    public void setMerchantIndexRatio(Double merchantIndexRatio) {
        this.merchantIndexRatio = merchantIndexRatio;
    }

    public Double getPlatformIndexRatio() {
        return platformIndexRatio;
    }

    public void setPlatformIndexRatio(Double platformIndexRatio) {
        this.platformIndexRatio = platformIndexRatio;
    }

    public String getOperUserName() {
        return operUserName;
    }

    public void setOperUserName(String operUserName) {
        this.operUserName = operUserName;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IslandMerchantReferenceRatioSettingDTO islandMerchantReferenceRatioSettingDTO = (IslandMerchantReferenceRatioSettingDTO) o;
        if (islandMerchantReferenceRatioSettingDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), islandMerchantReferenceRatioSettingDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "IslandMerchantReferenceRatioSettingDTO{" +
            "id=" + getId() +
            ", platformId=" + getPlatformId() +
            ", dishIndexRatio=" + getDishIndexRatio() +
            ", merchantIndexRatio=" + getMerchantIndexRatio() +
            ", platformIndexRatio=" + getPlatformIndexRatio() +
            ", operUserName='" + getOperUserName() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            "}";
    }
}
