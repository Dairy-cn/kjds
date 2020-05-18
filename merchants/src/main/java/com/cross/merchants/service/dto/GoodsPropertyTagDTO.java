package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchants.domain.GoodsPropertyTag} entity.
 */
@ApiModel(description = "商品属性标签")
public class GoodsPropertyTagDTO implements Serializable {

    private Long id;

    /**
     * 属性标签
     */
    @NotNull
    @Size(max = 20)
    @ApiModelProperty(value = "属性标签", required = true)
    private String name;

    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Boolean deleteFlag;

    @ApiModelProperty(value = "商品属性id", required = true)
    @NotNull
    private Long goodsPropertyId;

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public Long getGoodsPropertyId() {
        return goodsPropertyId;
    }

    public void setGoodsPropertyId(Long goodsPropertyId) {
        this.goodsPropertyId = goodsPropertyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GoodsPropertyTagDTO goodsPropertyTagDTO = (GoodsPropertyTagDTO) o;
        if (goodsPropertyTagDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), goodsPropertyTagDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "GoodsPropertyTagDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", deleteFlag='" + isDeleteFlag() + "'" +
            "}";
    }
}
