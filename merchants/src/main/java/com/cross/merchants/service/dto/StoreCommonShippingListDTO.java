package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchants.domain.StoreCommonShippingList} entity.
 */
@ApiModel(description = "商户常用快寄公司")
public class StoreCommonShippingListDTO implements Serializable {

    private Long id;

    /**
     * 快寄公司名称
     */
    @ApiModelProperty(value = "快寄公司名称")
    private String name;

    /**
     * 商户id
     */
    @ApiModelProperty(value = "商户id",required = true)
    private Long storeId;

    /**
     * 快递公司记录id
     */
    @ApiModelProperty(value = "快递公司记录id",required = true)
    private Long shippingId;


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

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getShippingId() {
        return shippingId;
    }

    public void setShippingId(Long shippingId) {
        this.shippingId = shippingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StoreCommonShippingListDTO storeCommonShippingListDTO = (StoreCommonShippingListDTO) o;
        if (storeCommonShippingListDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), storeCommonShippingListDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "StoreCommonShippingListDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", storeId=" + getStoreId() +
            ", shippingId=" + getShippingId() +
            "}";
    }
}
