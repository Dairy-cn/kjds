package com.cross.merchants.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * 银行信息
 */
@Entity
@Table(name = "bank_info")
public class BankInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 银行名称
     */
    @Column(name = "name")
    private String name;

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

    public BankInfo name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BankInfo)) {
            return false;
        }
        return id != null && id.equals(((BankInfo) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "BankInfo{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
