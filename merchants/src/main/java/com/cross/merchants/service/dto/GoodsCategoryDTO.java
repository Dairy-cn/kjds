package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchants.domain.GoodsCategory} entity.
 */
@ApiModel(description = "商品品类信息")
public class GoodsCategoryDTO implements Serializable {

    private Long id;

    /**
     * 父ID
     */
    @ApiModelProperty(value = "父ID")
    private Long pid;

    /**
     * 品类名称
     */
    @ApiModelProperty(value = "品类名称",required = true)
    @NotNull(message = "品类名称不能为空")
    private String name;

    /**
     * 分类图标
     */
    @ApiModelProperty(value = "分类图标")
    private String pic;

    /**
     * 级数 1 一级 2 二级 3 三级
     */
    @ApiModelProperty(value = "级数 1 一级 2 二级 3 三级",required = true)
    @NotNull(message = "分类级数不能为空")
    private Integer level;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Instant createTime;

    /**
     * 是否置顶
     */
    @ApiModelProperty(value = "是否置顶")
    private Boolean stick;


    /**
     * 子类
     */
    @ApiModelProperty(value = "子类")
    private List<GoodsCategoryDTO> childNode;



    /**
     * 父类
     */
    @ApiModelProperty(value = "父类")
    private GoodsCategoryDTO parentNode;

    public Boolean getStick() {
        return stick;
    }

    public GoodsCategoryDTO getParentNode() {
        return parentNode;
    }

    public void setParentNode(GoodsCategoryDTO parentNode) {
        this.parentNode = parentNode;
    }

    public List<GoodsCategoryDTO> getChildNode() {
        return childNode;
    }

    public void setChildNode(List<GoodsCategoryDTO> childNode) {
        this.childNode = childNode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Boolean isStick() {
        return stick;
    }

    public void setStick(Boolean stick) {
        this.stick = stick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GoodsCategoryDTO goodsCategoryDTO = (GoodsCategoryDTO) o;
        if (goodsCategoryDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), goodsCategoryDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "GoodsCategoryDTO{" +
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
