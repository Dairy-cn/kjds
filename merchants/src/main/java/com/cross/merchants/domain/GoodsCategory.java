package com.cross.merchants.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.Instant;

/**
 * 商品品类信息
 */
@Entity
@Table(name = "goods_category")
public class GoodsCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 父ID
     */
    @Column(name = "pid")
    private Long pid;

    /**
     * 品类名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 分类图标
     */
    @Column(name = "pic")
    private String pic;

    /**
     * 级数 1 一级 2 二级 3 三级
     */
    @Column(name = "level")
    private Integer level;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Instant createTime;

    /**
     * 是否置顶
     */
    @Column(name = "stick")
    private Boolean stick;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public GoodsCategory pid(Long pid) {
        this.pid = pid;
        return this;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public GoodsCategory name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public GoodsCategory pic(String pic) {
        this.pic = pic;
        return this;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getLevel() {
        return level;
    }

    public GoodsCategory level(Integer level) {
        this.level = level;
        return this;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public GoodsCategory createTime(Instant createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Boolean isStick() {
        return stick;
    }

    public GoodsCategory stick(Boolean stick) {
        this.stick = stick;
        return this;
    }

    public void setStick(Boolean stick) {
        this.stick = stick;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GoodsCategory)) {
            return false;
        }
        return id != null && id.equals(((GoodsCategory) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "GoodsCategory{" +
            "id=" + getId() +
            ", pid=" + getPid() +
            ", name='" + getName() + "'" +
            ", pic='" + getPic() + "'" +
            ", level=" + getLevel() +
            ", createTime='" + getCreateTime() + "'" +
            ", stick='" + isStick() + "'" +
            "}";
    }
}
