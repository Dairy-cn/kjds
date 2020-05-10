package com.cross.model;

import com.cross.enumtype.ShowGradeType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.island.domain.IslandPromotionExpertGrade} entity.
 */
@ApiModel(description = "宣传渠道--达人等级信息表")
public class IslandPromotionExpertGradeDTO implements Serializable {
    
    private Long id;
    
    /**
     * 平台id
     */
    @ApiModelProperty(value = "平台id", required = true)
    @NotNull
    private Long platformId;
    
    /**
     * 等级
     */
    @ApiModelProperty(value = "等级")
    private Integer placeGrade;
    
    /**
     * 大众点评等级 或 粉丝数量范围 [] 或（）[]表示大于等于或小于等于 （）表示大于或小于
     */
    @ApiModelProperty(value = "大众点评等级 或 粉丝数量范围 [] 或（）[]表示大于等于或小于等于 （）表示大于或小于")
    private String fansNumOrGrade;
    
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
    
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;
    
    
    @ApiModelProperty(value = "FANS, FRIENDS, GRADES 显示等级/粉丝数/好友数量", hidden = true)
    private ShowGradeType showGradeType;
    
    
    public Long getPlatformId() {
        return platformId;
    }
    
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }
    
    private Long islandPromotionPlaceId;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Integer getPlaceGrade() {
        return placeGrade;
    }
    
    public void setPlaceGrade(Integer placeGrade) {
        this.placeGrade = placeGrade;
    }
    
    public String getFansNumOrGrade() {
        return fansNumOrGrade;
    }
    
    public void setFansNumOrGrade(String fansNumOrGrade) {
        this.fansNumOrGrade = fansNumOrGrade;
    }
    
    public LocalDateTime getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    
    public Long getIslandPromotionPlaceId() {
        return islandPromotionPlaceId;
    }
    
    public void setIslandPromotionPlaceId(Long islandPromotionPlaceId) {
        this.islandPromotionPlaceId = islandPromotionPlaceId;
    }
    
    public ShowGradeType getShowGradeType() {
        return showGradeType;
    }
    
    public void setShowGradeType(ShowGradeType showGradeType) {
        this.showGradeType = showGradeType;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        IslandPromotionExpertGradeDTO islandPromotionExpertGradeDTO = (IslandPromotionExpertGradeDTO) o;
        if (islandPromotionExpertGradeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), islandPromotionExpertGradeDTO.getId());
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
    
    @Override
    public String toString() {
        return "IslandPromotionExpertGradeDTO{" +
            "id=" + id +
            ", platformId=" + platformId +
            ", placeGrade=" + placeGrade +
            ", fansNumOrGrade='" + fansNumOrGrade + '\'' +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", showGradeType=" + showGradeType +
            ", islandPromotionPlaceId=" + islandPromotionPlaceId +
            '}';
    }
}
