package com.cross.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.island.domain.IslandPromotionExpertAuth} entity.
 */
@ApiModel(description = "达人认证表")
public class IslandPromotionExpertAuthDTO implements Serializable {

    private Long id;

    /**
     * 平台id
     */
    @ApiModelProperty(value = "平台id", required = true)
    @NotNull
    private Long platformId;

    /**
     * 达人id
     */
    @ApiModelProperty(value = "达人id")
    private Long expertId;

    /**
     * 渠道id
     */
    @NotNull
    @ApiModelProperty(value = "渠道id", required = true)
    private Long placeId;

    /**
     * 渠道名称
     */
    @ApiModelProperty(value = "渠道名称")
    private String placeName;

    /**
     * 渠道logo
     */
    @ApiModelProperty(value = "渠道logo")
    private String placeLogo;

    /**
     * 认证信息
     */
    @ApiModelProperty(value = "认证信息")
    private String authInfo;

    /**
     * 认证图片
     */
    @ApiModelProperty(value = "认证图片")
    private String authPic;

    /**
     * 认证昵称
     */
    @ApiModelProperty(value = "认证昵称")
    private String placeUserName;

    /**
     * 认证账号id
     */
    @ApiModelProperty(value = "认证账号id")
    private String placeUserId;

    /**
     * 认证粉丝数
     */
    @ApiModelProperty(value = "认证粉丝数")
    private Integer fansNum;

    /**
     * 大众点评 等级
     */
    @ApiModelProperty(value = "大众点评 等级")
    private Integer grade;


    /**
     * 审核等级
     */
    @ApiModelProperty(value = "审核等级")
    private Integer checkGrade;

    /**
     * 审核时间
     */
    @ApiModelProperty(value = "审核时间")
    private LocalDateTime checkTime;

    /**
     * 审核结果 1 通过  0 未通过 -1未审核
     */
    @ApiModelProperty(value = "审核结果 1 通过  0 未通过 -1未审核")
    private Integer checkResult;

    /**
     * 审核结果失败说明
     */
    @ApiModelProperty(value = "审核结果失败说明")
    private String checkFailReason;

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


    @ApiModelProperty(value = "审核人")
    private String checkUser;

    @ApiModelProperty(value = "达人信息")
    private IslandUserDTO islandUserDTO;


    @ApiModelProperty(value = "渠道信息")
    private IslandPromotionPlaceDTO islandPromotionPlaceDTO;

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

    public Long getExpertId() {
        return expertId;
    }

    public void setExpertId(Long expertId) {
        this.expertId = expertId;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo;
    }

    public String getAuthPic() {
        return authPic;
    }

    public void setAuthPic(String authPic) {
        this.authPic = authPic;
    }

    public String getPlaceUserName() {
        return placeUserName;
    }

    public void setPlaceUserName(String placeUserName) {
        this.placeUserName = placeUserName;
    }

    public String getPlaceUserId() {
        return placeUserId;
    }

    public void setPlaceUserId(String placeUserId) {
        this.placeUserId = placeUserId;
    }

    public Integer getFansNum() {
        return fansNum;
    }

    public void setFansNum(Integer fansNum) {
        this.fansNum = fansNum;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public LocalDateTime getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(LocalDateTime checkTime) {
        this.checkTime = checkTime;
    }

    public Integer isCheckResult() {
        return checkResult;
    }

    public void setCheckResult(Integer checkResult) {
        this.checkResult = checkResult;
    }

    public String getCheckFailReason() {
        return checkFailReason;
    }

    public void setCheckFailReason(String checkFailReason) {
        this.checkFailReason = checkFailReason;
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


    public Integer getCheckResult() {
        return checkResult;
    }

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }

    public IslandUserDTO getIslandUserDTO() {
        return islandUserDTO;
    }

    public void setIslandUserDTO(IslandUserDTO islandUserDTO) {
        this.islandUserDTO = islandUserDTO;
    }

    public Integer getCheckGrade() {
        return checkGrade;
    }

    public void setCheckGrade(Integer checkGrade) {
        this.checkGrade = checkGrade;
    }

    public String getPlaceLogo() {
        return placeLogo;
    }

    public void setPlaceLogo(String placeLogo) {
        this.placeLogo = placeLogo;
    }

    public IslandPromotionPlaceDTO getIslandPromotionPlaceDTO() {
        return islandPromotionPlaceDTO;
    }

    public void setIslandPromotionPlaceDTO(IslandPromotionPlaceDTO islandPromotionPlaceDTO) {
        this.islandPromotionPlaceDTO = islandPromotionPlaceDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IslandPromotionExpertAuthDTO islandPromotionExpertAuthDTO = (IslandPromotionExpertAuthDTO) o;
        if (islandPromotionExpertAuthDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), islandPromotionExpertAuthDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "IslandPromotionExpertAuthDTO{" +
            "id=" + id +
            ", expertId=" + expertId +
            ", placeId=" + placeId +
            ", placeName='" + placeName + '\'' +
            ", placeLogo='" + placeLogo + '\'' +
            ", authInfo='" + authInfo + '\'' +
            ", authPic='" + authPic + '\'' +
            ", placeUserName='" + placeUserName + '\'' +
            ", placeUserId='" + placeUserId + '\'' +
            ", fansNum=" + fansNum +
            ", grade=" + grade +
            ", checkGrade=" + checkGrade +
            ", checkTime=" + checkTime +
            ", checkResult=" + checkResult +
            ", checkFailReason='" + checkFailReason + '\'' +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", checkUser='" + checkUser + '\'' +
            ", islandUserDTO=" + islandUserDTO +
            ", islandPromotionPlaceDTO=" + islandPromotionPlaceDTO +
            '}';
    }
}
