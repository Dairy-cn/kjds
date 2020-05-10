package com.cross.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.cross.model.enumeration.PlatFormFunctionType;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the PlatFormShopCategory entity.
 */
public class PlatFormShopCategoryDTO implements Serializable {

    private Long id;

    @ApiModelProperty(value = "分类名称")
    private String categoryName;

    @ApiModelProperty(value = "分类图标")
    private String categoryImageUrl;

    @ApiModelProperty(value = "分类地址")
    private String categoryUrl;

    @ApiModelProperty(value = "分类数量")
    private Integer categoryNum;

    @ApiModelProperty(value = "显示状态 1显示 0隐藏")
    private Integer showStatus;

    @ApiModelProperty(value = "排序")
    private Integer index;

    private Long platFormUserId;

    private Long parentId;

    private String parentName;

    @ApiModelProperty(value = "小程序分类链接")
    private String categoryAppUrl;

    /**
     * 颜色
     */
    @ApiModelProperty(value = "颜色")
    private String color;

    /**
     * 分享话术
     */
    @ApiModelProperty(value = "分享话术")
    private String shareContent;

    /**
     * 是否删除
     */
    private Boolean isDelete = false;

    @ApiModelProperty(value = "功能类型")
    private PlatFormFunctionType functionType;

    @ApiModelProperty(value = "创建时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant createTime;

    @ApiModelProperty(value = "置顶时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant topTime;

    @ApiModelProperty(value = "菜品总数")
    private Long dishCount;



    @ApiModelProperty(value = "上架总数")
    private Long showCount;


    @ApiModelProperty(value = "门店总数")
    private Long merchantCount;



    @ApiModelProperty(value = "门店正常总数")
    private Long showMerchantCount;

    @ApiModelProperty(value = "品牌id")
    private Long brandId;

    @ApiModelProperty(value = "品牌ids")
    private List<Long> brandIds;

    @ApiModelProperty(value = "门店Ids")
    private List<PlatformMerchantInfo> merchantIds;

    @ApiModelProperty(value = "分类类型 1:门店分类  2.套餐分类")
    private Integer categoryType;

    public Long getDishCount() {
        return dishCount;
    }

    public void setDishCount(Long dishCount) {
        this.dishCount = dishCount;
    }

    public Long getShowCount() {
        return showCount;
    }

    public void setShowCount(Long showCount) {
        this.showCount = showCount;
    }

    public Instant getTopTime() {
        return topTime;
    }

    public void setTopTime(Instant topTime) {
        this.topTime = topTime;
    }

    public PlatFormFunctionType getFunctionType() {
        return functionType;
    }

    public void setFunctionType(PlatFormFunctionType functionType) {
        this.functionType = functionType;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImageUrl() {
        return categoryImageUrl;
    }

    public void setCategoryImageUrl(String categoryImageUrl) {
        this.categoryImageUrl = categoryImageUrl;
    }

    public Integer getCategoryNum() {
        return categoryNum;
    }

    public void setCategoryNum(Integer categoryNum) {
        this.categoryNum = categoryNum;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Long getPlatFormUserId() {
        return platFormUserId;
    }

    public void setPlatFormUserId(Long platFormUserId) {
        this.platFormUserId = platFormUserId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public List<PlatformMerchantInfo> getMerchantIds() {
        return merchantIds;
    }

    public void setMerchantIds(List<PlatformMerchantInfo> merchantIds) {
        this.merchantIds = merchantIds;
    }

    public Long getMerchantCount() {
        return merchantCount;
    }

    public void setMerchantCount(Long merchantCount) {
        this.merchantCount = merchantCount;
    }

    public Long getShowMerchantCount() {
        return showMerchantCount;
    }

    public void setShowMerchantCount(Long showMerchantCount) {
        this.showMerchantCount = showMerchantCount;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public List<Long> getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(List<Long> brandIds) {
        this.brandIds = brandIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PlatFormShopCategoryDTO platFormShopCategoryDTO = (PlatFormShopCategoryDTO) o;
        if(platFormShopCategoryDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), platFormShopCategoryDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PlatFormShopCategoryDTO{" +
            "id=" + id +
            ", categoryName='" + categoryName + '\'' +
            ", categoryImageUrl='" + categoryImageUrl + '\'' +
            ", categoryUrl='" + categoryUrl + '\'' +
            ", categoryNum=" + categoryNum +
            ", showStatus=" + showStatus +
            ", index=" + index +
            ", platFormUserId=" + platFormUserId +
            ", parentId=" + parentId +
            ", parentName='" + parentName + '\'' +
            ", categoryAppUrl='" + categoryAppUrl + '\'' +
            ", color='" + color + '\'' +
            ", shareContent='" + shareContent + '\'' +
            ", isDelete=" + isDelete +
            ", functionType=" + functionType +
            ", createTime=" + createTime +
            ", topTime=" + topTime +
            ", dishCount=" + dishCount +
            ", showCount=" + showCount +
            ", merchantCount=" + merchantCount +
            ", showMerchantCount=" + showMerchantCount +
            ", brandId=" + brandId +
            ", brandIds=" + brandIds +
            ", merchantIds=" + merchantIds +
            ", categoryType=" + categoryType +
            '}';
    }

    public PlatFormShopCategoryDTO(){

    }

    public String getCategoryAppUrl() {
        return categoryAppUrl;
    }

    public void setCategoryAppUrl(String categoryAppUrl) {
        this.categoryAppUrl = categoryAppUrl;
    }

    public String getShareContent() {
        return shareContent;
    }

    public void setShareContent(String shareContent) {
        this.shareContent = shareContent;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
