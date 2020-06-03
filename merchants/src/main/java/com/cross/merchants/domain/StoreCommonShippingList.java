package com.cross.merchants.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * 商户常用快寄公司
 */
@Entity
@Table(name = "store_common_shipping_list")
public class StoreCommonShippingList implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 快寄公司名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 商户id
     */
    @Column(name = "store_id")
    private Long storeId;

    /**
     * 快递公司记录id
     */
    @Column(name = "shipping_id")
    private Long shippingId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public StoreCommonShippingList name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStoreId() {
        return storeId;
    }

    public StoreCommonShippingList storeId(Long storeId) {
        this.storeId = storeId;
        return this;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getShippingId() {
        return shippingId;
    }

    public StoreCommonShippingList shippingId(Long shippingId) {
        this.shippingId = shippingId;
        return this;
    }

    public void setShippingId(Long shippingId) {
        this.shippingId = shippingId;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StoreCommonShippingList)) {
            return false;
        }
        return id != null && id.equals(((StoreCommonShippingList) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "StoreCommonShippingList{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", storeId=" + getStoreId() +
            ", shippingId=" + getShippingId() +
            "}";
    }
}
