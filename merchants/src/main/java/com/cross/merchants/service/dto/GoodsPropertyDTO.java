package com.cross.merchants.service.dto;

import com.cross.merchants.domain.GoodsProperty;
import com.cross.merchants.domain.GoodsPropertyTag;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchants.domain.GoodsProperty} entity.
 */
@ApiModel(description = "商品属性")
public class GoodsPropertyDTO implements Serializable {

    private Long id;

    /**
     * 属性名称
     */
    @NotNull
    @Size(max = 20)
    @ApiModelProperty(value = "属性名称", required = true)
    private String name;

    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Boolean deleteFlag;


    /**
     * 商品id
     */
    @NotNull
    @ApiModelProperty(value = "商品id", required = true)
    private Long goodsId;

    @ApiModelProperty(value = "商品属性标签")
    private List<GoodsPropertyTagDTO> goodsPropertyTagDTOS;

    public List<GoodsPropertyTagDTO> getGoodsPropertyTagDTOS() {
        return goodsPropertyTagDTOS;
    }

    public void setGoodsPropertyTagDTOS(List<GoodsPropertyTagDTO> goodsPropertyTagDTOS) {
        this.goodsPropertyTagDTOS = goodsPropertyTagDTOS;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
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

        GoodsPropertyDTO goodsPropertyDTO = (GoodsPropertyDTO) o;
        if (goodsPropertyDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), goodsPropertyDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "GoodsPropertyDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", deleteFlag='" + isDeleteFlag() + "'" +
            "}";
    }
}
