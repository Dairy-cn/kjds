package com.cross.model;


import com.cross.enumtype.CatSourceType;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the SelfSupportDishCat entity.
 */
public class SelfSupportDishCatDTO implements Serializable {

    private Long id;

    @ApiModelProperty(value = "分类名称")
    private String name;

    @ApiModelProperty(value = "门店id")
    private Long merchantId;

    private Integer sequence;

    private Boolean deleteFlag = Boolean.FALSE;

    List<SelfSupportDishDTO> dishList;

    @ApiModelProperty(value = "品牌名称")
    private Long brandId;

    /**
     * 描述
     *
     */
    private String description;

    @ApiModelProperty("商户（用户）id")
    private Long userId;

    @ApiModelProperty(value = "是否在C端显示")
    private Boolean display = Boolean.TRUE;

    @ApiModelProperty(value = "分类类型 1：必选  2：营销类别  3：普通类别 4：商家推荐 99 默认的展示名称")
    private Integer catType;

    @ApiModelProperty(value = "营销类别：1：热销 2：优惠")
    private Integer saleType;

    @ApiModelProperty(value = "分类来源")
    @Enumerated(EnumType.STRING)
    private CatSourceType catSourceType;

    private String thirdNo;

    public String getThirdNo() {
        return thirdNo;
    }

    public void setThirdNo(String thirdNo) {
        this.thirdNo = thirdNo;
    }

    public CatSourceType getCatSourceType() {
        return catSourceType;
    }

    public void setCatSourceType(CatSourceType catSourceType) {
        this.catSourceType = catSourceType;
    }

    public Boolean getDisplay() {
        return display;
    }

    public void setDisplay(Boolean display) {
        this.display = display;
    }

    public Integer getCatType() {
        return catType;
    }

    public void setCatType(Integer catType) {
        this.catType = catType;
    }

    public Integer getSaleType() {
        return saleType;
    }

    public void setSaleType(Integer saleType) {
        this.saleType = saleType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public List<SelfSupportDishDTO> getDishList() {
        return dishList;
    }

    public void setDishList(List<SelfSupportDishDTO> dishList) {
        this.dishList = dishList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SelfSupportDishCatDTO selfSupportDishCatDTO = (SelfSupportDishCatDTO) o;
        if(selfSupportDishCatDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), selfSupportDishCatDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SelfSupportDishCatDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", merchantId='" + getMerchantId() + "'" +
            ", sequence='" + getSequence() + "'" +
            ", deleteFlag='" + isDeleteFlag() + "'" +
            "}";
    }
}
