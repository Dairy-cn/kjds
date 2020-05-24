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
     * 商品推荐类型
     */
    @NotNull
    @Column(name = "goods_recommend_type", nullable = false)
    @ApiModelProperty(value = "商品推荐类型 1 单品推荐 2 专区商品推荐", required = true)
    private Integer goodsRecommendType;


    /**
     *推荐专区 专区id(商品推荐广告id)
     */
    @ApiModelProperty(value = "推荐专区 专区id(商品推荐广告id)")
    @Column(name = "goods_recommend_banner_id")
    private Long goodsRecommendBannerId;

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


    public Integer getGoodsRecommendType() {
        return goodsRecommendType;
    }

    public GoodsRecommend goodsRecommendType(Integer goodsRecommendType) {
        this.goodsRecommendType = goodsRecommendType;
        return this;
    }
    public void setGoodsRecommendType(Integer goodsRecommendType) {
        this.goodsRecommendType = goodsRecommendType;
    }

    public Long getGoodsRecommendBannerId() {
        return goodsRecommendBannerId;
    }
    public GoodsRecommend goodsRecommendBannerId(Long goodsRecommendBannerId) {
        this.goodsRecommendBannerId = goodsRecommendBannerId;
        return this;
    }
    public void setGoodsRecommendBannerId(Long goodsRecommendBannerId) {
        this.goodsRecommendBannerId = goodsRecommendBannerId;
    }

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
            "id=" + id +
            ", top=" + top +
            ", goodsId=" + goodsId +
            ", goodsRecommendType=" + goodsRecommendType +
            ", goodsRecommendBannerId=" + goodsRecommendBannerId +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
    }
}
