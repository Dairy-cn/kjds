package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchants.domain.Region} entity.
 */
@ApiModel(description = "国内区域")
public class RegionDTO implements Serializable {
    
    private Long id;

    /**
     * 区域编号
     */
    @ApiModelProperty(value = "区域编号")
    private String regionId;

    /**
     * 地区名称
     */
    @ApiModelProperty(value = "地区名称")
    private String regionName;

    /**
     * 父区域编号
     */
    @ApiModelProperty(value = "父区域编号")
    private Long parentId;

    /**
     * 等级
     */
    @ApiModelProperty(value = "等级")
    private Integer level;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RegionDTO regionDTO = (RegionDTO) o;
        if (regionDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), regionDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RegionDTO{" +
            "id=" + getId() +
            ", regionId='" + getRegionId() + "'" +
            ", regionName='" + getRegionName() + "'" +
            ", parentId=" + getParentId() +
            ", level=" + getLevel() +
            "}";
    }
}
