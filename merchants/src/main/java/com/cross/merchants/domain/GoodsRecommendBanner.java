package com.cross.merchants.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * 推荐商品广告
 */
@Entity
@Table(name = "goods_recommend_banner")
public class GoodsRecommendBanner implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 广告上传位置一
     */
    @Column(name = "position_one")
    private String positionOne;

    /**
     * 广告上传位置二
     */
    @Column(name = "position_two")
    private String positionTwo;

    /**
     * 广告上传位置三
     */
    @Column(name = "position_three")
    private String positionThree;

    /**
     * 专区名称
     */
    @NotNull
    @Column(name = "division_name", nullable = false)
    private String divisionName;

    /**
     * 是否置顶
     */
    @Column(name = "top")
    private Boolean top;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPositionOne() {
        return positionOne;
    }

    public GoodsRecommendBanner positionOne(String positionOne) {
        this.positionOne = positionOne;
        return this;
    }

    public void setPositionOne(String positionOne) {
        this.positionOne = positionOne;
    }

    public String getPositionTwo() {
        return positionTwo;
    }

    public GoodsRecommendBanner positionTwo(String positionTwo) {
        this.positionTwo = positionTwo;
        return this;
    }

    public void setPositionTwo(String positionTwo) {
        this.positionTwo = positionTwo;
    }

    public String getPositionThree() {
        return positionThree;
    }

    public GoodsRecommendBanner positionThree(String positionThree) {
        this.positionThree = positionThree;
        return this;
    }

    public void setPositionThree(String positionThree) {
        this.positionThree = positionThree;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public GoodsRecommendBanner divisionName(String divisionName) {
        this.divisionName = divisionName;
        return this;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public Boolean isTop() {
        return top;
    }

    public GoodsRecommendBanner top(Boolean top) {
        this.top = top;
        return this;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GoodsRecommendBanner)) {
            return false;
        }
        return id != null && id.equals(((GoodsRecommendBanner) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "GoodsRecommendBrand{" +
            "id=" + getId() +
            ", positionOne='" + getPositionOne() + "'" +
            ", positionTwo='" + getPositionTwo() + "'" +
            ", positionThree='" + getPositionThree() + "'" +
            ", divisionName='" + getDivisionName() + "'" +
            ", top='" + isTop() + "'" +
            "}";
    }
}
