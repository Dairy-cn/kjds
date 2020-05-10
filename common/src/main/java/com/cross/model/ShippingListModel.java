package com.cross.model;


import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the ShippingList entity.
 */
public class ShippingListModel implements Serializable {

    private Long id;

    private String name;

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
    
    
    public ShippingListModel() {
    }
    
    public ShippingListModel(Long id, String name, String code) {
        this.id = id;
        this.name = name;
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
    
        ShippingListModel shippingListDTO = (ShippingListModel) o;
        if(shippingListDTO.getId() == null || getId() == null) {
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
