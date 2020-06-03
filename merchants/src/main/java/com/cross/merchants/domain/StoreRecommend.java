package com.cross.merchants.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.Instant;

/**
 * 商户推荐
 */
@Entity
@Table(name = "store_recommend")
public class StoreRecommend implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商户id
     */
    @NotNull
    @Column(name = "store_id", nullable = false)
    private Long storeId;

    /**
     * 是否置顶
     */
    @Column(name = "top")
    private Boolean top;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Instant createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Instant updateTime;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public StoreRecommend storeId(Long storeId) {
        this.storeId = storeId;
        return this;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Boolean isTop() {
        return top;
    }

    public Boolean getTop() {
        return top;
    }

    public StoreRecommend top(Boolean top) {
        this.top = top;
        return this;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public StoreRecommend createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Instant getUpdateTime() {
        return updateTime;
    }

    public StoreRecommend updateTime(Instant updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StoreRecommend)) {
            return false;
        }
        return id != null && id.equals(((StoreRecommend) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "StoreRecommend{" +
            "id=" + getId() +
            ", storeId='" + getStoreId() + "'" +
            ", top='" + isTop() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            "}";
    }
}
