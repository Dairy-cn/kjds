package com.cross.merchants.domain;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.Instant;

/**
 * 商品推荐
 */
@Entity
@Table(name = "goods_recommend")
public class GoodsRecommend implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 是否置顶
     */
    @Column(name = "top")
    private Boolean top;

    /**
     * 商品id
     */
    @NotNull
    @Column(name = "goods_id", nullable = false)
    private Long goodsId;

    /**
     * 广告位置
     */
    @NotNull
    @ApiModelProperty(value = "广告位置   7 C1 8 C2 9 C3 10 C4 11 C5 12 C6", required = true)
    @Column(name = "banner")
    private Integer banner;

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

    public Boolean isTop() {
        return top;
    }

    public GoodsRecommend top(Boolean top) {
        this.top = top;
        return this;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public GoodsRecommend goodsId(Long goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Boolean getTop() {
        return top;
    }

    public Integer getBanner() {
        return banner;
    }
    public GoodsRecommend banner(Integer banner) {
        this.banner = banner;
        return this;
    }
    public void setBanner(Integer banner) {
        this.banner = banner;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public GoodsRecommend createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Instant getUpdateTime() {
        return updateTime;
    }

    public GoodsRecommend updateTime(Instant updateTime) {
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
        if (!(o instanceof GoodsRecommend)) {
            return false;
        }
        return id != null && id.equals(((GoodsRecommend) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "GoodsRecommend{" +
            "id=" + getId() +
            ", top='" + isTop() + "'" +
            ", goodsId=" + getGoodsId() +
            ", bannerId=" + getBanner() +
            ", createTime='" + getCreateTime() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            "}";
    }
}
