package com.cross.merchants.service.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 推荐商品广告
 */
@ApiModel(description = "推荐商品广告")
public class GoodsRecommendBannerDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    /**
     * 广告上传位置一
     */
    @ApiModelProperty(value = "广告上传位置一")
    private GoodsRecommendBannerPositionDTO positionOne;

    /**
     * 广告上传位置二
     */
    @ApiModelProperty(value = "广告上传位置二")
    private GoodsRecommendBannerPositionDTO positionTwo;

    /**
     * 广告上传位置三
     */
    @ApiModelProperty(value = "广告上传位置三")
    private GoodsRecommendBannerPositionDTO positionThree;

    /**
     * 专区名称
     */
    @NotNull
    @ApiModelProperty(value = "专区名称",required = true)
    private String divisionName;

    /**
     * 是否置顶
     */
    @ApiModelProperty(value = "是否置顶")
    private Boolean top;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GoodsRecommendBannerPositionDTO getPositionOne() {
        return positionOne;
    }

    public void setPositionOne(GoodsRecommendBannerPositionDTO positionOne) {
        this.positionOne = positionOne;
    }

    public GoodsRecommendBannerPositionDTO getPositionTwo() {
        return positionTwo;
    }

    public void setPositionTwo(GoodsRecommendBannerPositionDTO positionTwo) {
        this.positionTwo = positionTwo;
    }

    public GoodsRecommendBannerPositionDTO getPositionThree() {
        return positionThree;
    }

    public void setPositionThree(GoodsRecommendBannerPositionDTO positionThree) {
        this.positionThree = positionThree;
    }

    public Boolean getTop() {
        return top;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public GoodsRecommendBannerDTO divisionName(String divisionName) {
        this.divisionName = divisionName;
        return this;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public Boolean isTop() {
        return top;
    }

    public GoodsRecommendBannerDTO top(Boolean top) {
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
        if (!(o instanceof GoodsRecommendBannerDTO)) {
            return false;
        }
        return id != null && id.equals(((GoodsRecommendBannerDTO) o).id);
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
