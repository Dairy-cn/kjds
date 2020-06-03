package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchants.domain.ShippingList} entity.
 */
@ApiModel(description = "快寄公司编码表")
public class ShippingListDTO implements Serializable {
    
    private Long id;

    /**
     * 快寄公司名称
     */
    @ApiModelProperty(value = "快寄公司名称")
    private String name;

    /**
     * 编码
     */
    @ApiModelProperty(value = "编码")
    private String code;

    
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ShippingListDTO shippingListDTO = (ShippingListDTO) o;
        if (shippingListDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), shippingListDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ShippingListDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", code='" + getCode() + "'" +
            "}";
    }
}
