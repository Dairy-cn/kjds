package com.cross.merchants.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.Instant;

/**
 * 文章管理
 */
@Entity
@Table(name = "article_info")
public class ArticleInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 标题
     */
    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    /**
     * 文字编号
     */
    @Column(name = "title_no")
    private String titleNo;

    /**
     * 文字封面
     */
    @Column(name = "cover")
    private String cover;

    /**
     * 浏览人数
     */
    @Column(name = "pageview")
    private Integer pageview;

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

    /**
     * 上架状态  true 上架  false 下架
     */
    @Column(name = "show_state")
    private Boolean showState;

    /**
     * 置顶状态
     */
    @Column(name = "top")
    private Boolean top;

    /**
     * 文章内容
     */
    @Column(name = "content")
    private String content;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public ArticleInfo title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleNo() {
        return titleNo;
    }

    public ArticleInfo titleNo(String titleNo) {
        this.titleNo = titleNo;
        return this;
    }

    public void setTitleNo(String titleNo) {
        this.titleNo = titleNo;
    }

    public String getCover() {
        return cover;
    }

    public ArticleInfo cover(String cover) {
        this.cover = cover;
        return this;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getPageview() {
        return pageview;
    }

    public ArticleInfo pageview(Integer pageview) {
        this.pageview = pageview;
        return this;
    }

    public void setPageview(Integer pageview) {
        this.pageview = pageview;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public ArticleInfo createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Instant getUpdateTime() {
        return updateTime;
    }

    public ArticleInfo updateTime(Instant updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean isShowState() {
        return showState;
    }

    public ArticleInfo showState(Boolean showState) {
        this.showState = showState;
        return this;
    }

    public void setShowState(Boolean showState) {
        this.showState = showState;
    }

    public Boolean isTop() {
        return top;
    }

    public ArticleInfo top(Boolean top) {
        this.top = top;
        return this;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }

    public String getContent() {
        return content;
    }

    public ArticleInfo content(String content) {
        this.content = content;
        return this;
    }

    public void setContent(String content) {
        this.content = content;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ArticleInfo)) {
            return false;
        }
        return id != null && id.equals(((ArticleInfo) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ArticleInfo{" +
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
