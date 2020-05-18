package com.cross.merchants.domain;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * 商品属性标签
 */
@Entity
@Table(name = "goods_property_tag")
public class GoodsPropertyTag implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 属性标签
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

    @ApiModelProperty(value = "商品属性id", required = true)
    @NotNull
    @Column(name = "goods_property_id",  nullable = false)
    private Long goodsPropertyId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove


    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public Long getGoodsPropertyId() {
        return goodsPropertyId;
    }
    public GoodsPropertyTag goodsPropertyId(Long goodsPropertyId) {
        this.goodsPropertyId = goodsPropertyId;
        return this;
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

    public GoodsPropertyTag name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isDeleteFlag() {
        return deleteFlag;
    }

    public GoodsPropertyTag deleteFlag(Boolean deleteFlag) {
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
        if (!(o instanceof GoodsPropertyTag)) {
            return false;
        }
        return id != null && id.equals(((GoodsPropertyTag) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "GoodsPropertyTag{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", deleteFlag='" + isDeleteFlag() + "'" +
            "}";
    }
}
