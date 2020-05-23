package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchants.domain.StoreRecommend} entity.
 */
@ApiModel(description = "商户推荐")
public class StoreRecommendDTO implements Serializable {

    private Long id;

    /**
     * 商户id
     */
    @NotNull
    @ApiModelProperty(value = "商户id", required = true)
    private Long storeId;

    /**
     * 是否置顶
     */
    @ApiModelProperty(value = "是否置顶")
    private Boolean top;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Instant createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Instant updateTime;

    @ApiModelProperty(value = "商户信息",hidden = true)
    private StoreInfoDTO storeInfoDTO;

    public Boolean getTop() {
        return top;
    }

    public StoreInfoDTO getStoreInfoDTO() {
        return storeInfoDTO;
    }

    public void setStoreInfoDTO(StoreInfoDTO storeInfoDTO) {
        this.storeInfoDTO = storeInfoDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Boolean isTop() {
        return top;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Instant getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StoreRecommendDTO storeRecommendDTO = (StoreRecommendDTO) o;
        if (storeRecommendDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), storeRecommendDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "StoreRecommendDTO{" +
            "id=" + getId() +
            ", storeId='" + getStoreId() + "'" +
            ", top='" + isTop() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            "}";
    }
}
