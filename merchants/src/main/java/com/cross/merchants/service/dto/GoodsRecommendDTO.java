package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchants.domain.GoodsRecommend} entity.
 */
@ApiModel(description = "商品推荐")
public class GoodsRecommendDTO implements Serializable {

    private Long id;

    /**
     * 是否置顶
     */
    @ApiModelProperty(value = "是否置顶")
    private Boolean top;

    /**
     * 商品id
     */
    @NotNull
    @ApiModelProperty(value = "商品id", required = true)
    private Long goodsId;

    /**
     * 广告位置
     */
    @NotNull
    @ApiModelProperty(value = "广告位置   7 C1 8 C2 9 C3 10 C4 11 C5 12 C6", required = true)
    private Integer banner;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Instant createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Instant updateTime;

    @ApiModelProperty(value = "商品信息",hidden = true)
    private GoodsDTO goodsDTO;

    public GoodsDTO getGoodsDTO() {
        return goodsDTO;
    }

    public void setGoodsDTO(GoodsDTO goodsDTO) {
        this.goodsDTO = goodsDTO;
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

    public void setTop(Boolean top) {
        this.top = top;
    }

    public Long getGoodsId() {
        return goodsId;
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

    public void setBanner(Integer banner) {
        this.banner = banner;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Instant getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GoodsRecommendDTO goodsRecommendDTO = (GoodsRecommendDTO) o;
        if (goodsRecommendDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), goodsRecommendDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "GoodsRecommendDTO{" +
            "id=" + getId() +
            ", top='" + isTop() + "'" +
            ", goodsId=" + getGoodsId() +
            ", bannerId=" + getBanner() +
            ", createTime='" + getCreateTime() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            "}";
    }
}
