package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.cross.enumtype.ShowGradeType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@ApiModel(description = "媒体宣传渠道（不可重命名；若配置相关的宣传类型和达人等级 则不可删除）")
public class IslandPromotionPlaceDTO implements Serializable {

    private Long id;

    /**
     * 平台id
     */
    @ApiModelProperty(value = "平台id", required = true)
    @NotNull
    private Long platformId;

    /**
     * 宣传渠道名称
     */
    @Size(max = 32)
    @ApiModelProperty(value = "宣传渠道名称")
    private String name;

    /**
     * 宣传渠道logo
     */
    @ApiModelProperty(value = "宣传渠道logo")
    private String logo;

    /**
     * FANS,
     * <p>
     * FRIENDS,
     * <p>
     * GRADES 显示等级/粉丝数/好友数量
     */
    @ApiModelProperty(value = "FANS, FRIENDS, GRADES 显示等级/粉丝数/好友数量")
    private ShowGradeType showGradeType;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "查考图")
    private String referencePic;

    private List<IslandPromotionExpertGradeDTO> islandPromotionExpertGradeDTOS;


    private List<IslandPromotionExpertAuthDTO> islandPromotionExpertAuthDTOS;


    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public ShowGradeType getShowGradeType() {
        return showGradeType;
    }

    public void setShowGradeType(ShowGradeType showGradeType) {
        this.showGradeType = showGradeType;
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


    public List<IslandPromotionExpertGradeDTO> getIslandPromotionExpertGradeDTOS() {
        return islandPromotionExpertGradeDTOS;
    }

    public void setIslandPromotionExpertGradeDTOS(List<IslandPromotionExpertGradeDTO> islandPromotionExpertGradeDTOS) {
        this.islandPromotionExpertGradeDTOS = islandPromotionExpertGradeDTOS;
    }




    public List<IslandPromotionExpertAuthDTO> getIslandPromotionExpertAuthDTOS() {
        return islandPromotionExpertAuthDTOS;
    }

    public void setIslandPromotionExpertAuthDTOS(List<IslandPromotionExpertAuthDTO> islandPromotionExpertAuthDTOS) {
        this.islandPromotionExpertAuthDTOS = islandPromotionExpertAuthDTOS;
    }

    public String getReferencePic() {
        return referencePic;
    }

    public void setReferencePic(String referencePic) {
        this.referencePic = referencePic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IslandPromotionPlaceDTO islandPromotionPlaceDTO = (IslandPromotionPlaceDTO) o;
        if (islandPromotionPlaceDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), islandPromotionPlaceDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "IslandPromotionPlaceDTO{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", logo='" + logo + '\'' +
            ", showGradeType=" + showGradeType +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", referencePic='" + referencePic + '\'' +
            ", islandPromotionExpertGradeDTOS=" + islandPromotionExpertGradeDTOS +
            ", islandPromotionExpertAuthDTOS=" + islandPromotionExpertAuthDTOS +
            '}';
    }
}
