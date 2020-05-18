package com.cross.merchants.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * 国内区域
 */
@Entity
@Table(name = "global_region")
public class GlobalRegion implements Serializable {

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
     * 路径
     */
    @Column(name = "path")
    private String path;

    /**
     * 中文名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 英文名称
     */
    @Column(name = "name_en")
    private String nameEn;

    /**
     * 中文拼音
     */
    @Column(name = "name_pinyin")
    private String namePinyin;

    /**
     * 层级
     */
    @Column(name = "level")
    private Integer level;

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

    public GlobalRegion pid(Long pid) {
        this.pid = pid;
        return this;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPath() {
        return path;
    }

    public GlobalRegion path(String path) {
        this.path = path;
        return this;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public GlobalRegion name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public GlobalRegion nameEn(String nameEn) {
        this.nameEn = nameEn;
        return this;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNamePinyin() {
        return namePinyin;
    }

    public GlobalRegion namePinyin(String namePinyin) {
        this.namePinyin = namePinyin;
        return this;
    }

    public void setNamePinyin(String namePinyin) {
        this.namePinyin = namePinyin;
    }

    public Integer getLevel() {
        return level;
    }

    public GlobalRegion level(Integer level) {
        this.level = level;
        return this;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GlobalRegion)) {
            return false;
        }
        return id != null && id.equals(((GlobalRegion) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "GlobalRegion{" +
            "id=" + getId() +
            ", pid=" + getPid() +
            ", path='" + getPath() + "'" +
            ", name='" + getName() + "'" +
            ", nameEn='" + getNameEn() + "'" +
            ", namePinyin='" + getNamePinyin() + "'" +
            ", level=" + getLevel() +
            "}";
    }
}
