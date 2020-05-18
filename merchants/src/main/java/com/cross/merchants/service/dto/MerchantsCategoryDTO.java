package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchants.domain.MerchantsCategory} entity.
 */
@ApiModel(description = "商户类目")
public class MerchantsCategoryDTO implements Serializable {

    private Long id;

    /**
     * 类目名称
     */
    @ApiModelProperty(value = "类目名称")
    private String name;

    @ApiModelProperty(value = "商户数量")
    private Integer count;

    @ApiModelProperty(value = "商户信息")
    private List<StoreInfoDTO> storeInfoDTO;


    public List<StoreInfoDTO> getStoreInfoDTO() {
        return storeInfoDTO;
    }

    public void setStoreInfoDTO(List<StoreInfoDTO> storeInfoDTO) {
        this.storeInfoDTO = storeInfoDTO;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MerchantsCategoryDTO merchantsCategoryDTO = (MerchantsCategoryDTO) o;
        if (merchantsCategoryDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), merchantsCategoryDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "MerchantsCategoryDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
