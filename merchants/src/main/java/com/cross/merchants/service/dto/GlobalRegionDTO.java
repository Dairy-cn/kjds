package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchants.domain.GlobalRegion} entity.
 */
@ApiModel(description = "国内区域")
public class GlobalRegionDTO implements Serializable {
    
    private Long id;

    /**
     * 父ID
     */
    @ApiModelProperty(value = "父ID")
    private Long pid;

    /**
     * 路径
     */
    @ApiModelProperty(value = "路径")
    private String path;

    /**
     * 中文名称
     */
    @ApiModelProperty(value = "中文名称")
    private String name;

    /**
     * 英文名称
     */
    @ApiModelProperty(value = "英文名称")
    private String nameEn;

    /**
     * 中文拼音
     */
    @ApiModelProperty(value = "中文拼音")
    private String namePinyin;

    /**
     * 层级
     */
    @ApiModelProperty(value = "层级")
    private Integer level;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNamePinyin() {
        return namePinyin;
    }

    public void setNamePinyin(String namePinyin) {
        this.namePinyin = namePinyin;
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

        GlobalRegionDTO globalRegionDTO = (GlobalRegionDTO) o;
        if (globalRegionDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), globalRegionDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "GlobalRegionDTO{" +
            "id=" + getId() +
            ", pid=" + getPid() +
            ", path='" + getPath() + "'" +
            ", name='" + getName() + "'" +
            ", nameEn='" + getNameEn() + "'" +
            ", namePinyin='" + getNamePinyin() + "'" +
            ", level=" + getLevel() +
            "}";
    }
}
