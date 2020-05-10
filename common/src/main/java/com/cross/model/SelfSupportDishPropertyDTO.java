package com.cross.model;


import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the SelfSupportDishProperty entity.
 */
public class SelfSupportDishPropertyDTO implements Serializable {

    private Long id;

    private Long dishId;

    private String propertyName;

    private String values;

    private Long merchantId;

    private Long catId;

    private Boolean deleteFlag = Boolean.FALSE;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
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

        SelfSupportDishPropertyDTO selfSupportDishPropertyDTO = (SelfSupportDishPropertyDTO) o;
        if(selfSupportDishPropertyDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), selfSupportDishPropertyDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SelfSupportDishPropertyDTO{" +
            "id=" + getId() +
            ", dishId='" + getDishId() + "'" +
            ", propertyName='" + getPropertyName() + "'" +
            ", values='" + getValues() + "'" +
            ", merchantId='" + getMerchantId() + "'" +
            ", catId='" + getCatId() + "'" +
            ", deleteFlag='" + isDeleteFlag() + "'" +
            "}";
    }
}
