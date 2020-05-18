package com.cross.merchants.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * 商品属性
 */
@Entity
@Table(name = "goods_property")
public class GoodsProperty implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 属性名称
     */
    @NotNull
    @Size(max = 20)
    @Column(name = "name", length = 20, nullable = false)
    private String name;

    /**
     * 是否删除
     */
    @Column(name = "delete_flag")
    private Boolean deleteFlag;

    /**
     * 商品id
     */
    @NotNull
    @Column(name = "goods_id",  nullable = false)
    private Long goodsId;

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public Long getGoodsId() {
        return goodsId;
    }
    public GoodsProperty goodsId(Long goodsId) {
        this.goodsId = goodsId;
        return this;
    }
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

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

    public GoodsProperty name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isDeleteFlag() {
        return deleteFlag;
    }

    public GoodsProperty deleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
        return this;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GoodsProperty)) {
            return false;
        }
        return id != null && id.equals(((GoodsProperty) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "GoodsProperty{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", deleteFlag='" + isDeleteFlag() + "'" +
            "}";
    }
}
