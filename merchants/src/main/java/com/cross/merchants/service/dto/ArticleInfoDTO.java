package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchants.domain.ArticleInfo} entity.
 */
@ApiModel(description = "文章管理")
public class ArticleInfoDTO implements Serializable {
    
    private Long id;

    /**
     * 标题
     */
    @NotNull
    @ApiModelProperty(value = "标题", required = true)
    private String title;

    /**
     * 文字编号
     */
    @ApiModelProperty(value = "文字编号")
    private String titleNo;

    /**
     * 文字封面
     */
    @ApiModelProperty(value = "文字封面")
    private String cover;

    /**
     * 浏览人数
     */
    @ApiModelProperty(value = "浏览人数")
    private Integer pageview;

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

    /**
     * 上架状态  true 上架  false 下架
     */
    @ApiModelProperty(value = "上架状态  true 上架  false 下架")
    private Boolean showState;

    /**
     * 置顶状态
     */
    @ApiModelProperty(value = "置顶状态")
    private Boolean top;

    /**
     * 文章内容
     */
    @ApiModelProperty(value = "文章内容")
    private String content;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleNo() {
        return titleNo;
    }

    public void setTitleNo(String titleNo) {
        this.titleNo = titleNo;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getPageview() {
        return pageview;
    }

    public void setPageview(Integer pageview) {
        this.pageview = pageview;
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

    public Boolean isShowState() {
        return showState;
    }

    public void setShowState(Boolean showState) {
        this.showState = showState;
    }

    public Boolean isTop() {
        return top;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ArticleInfoDTO articleInfoDTO = (ArticleInfoDTO) o;
        if (articleInfoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), articleInfoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ArticleInfoDTO{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", titleNo='" + getTitleNo() + "'" +
            ", cover='" + getCover() + "'" +
            ", pageview=" + getPageview() +
            ", createTime='" + getCreateTime() + "'" +
            ", updateTime='" + getUpdateTime() + "'" +
            ", showState='" + isShowState() + "'" +
            ", top='" + isTop() + "'" +
            ", content='" + getContent() + "'" +
            "}";
    }
}
