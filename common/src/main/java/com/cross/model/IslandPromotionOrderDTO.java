package com.cross.model;

import com.cross.model.enumeration.PromotionOrderState;
import com.cross.model.enumeration.SceneType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@ApiModel(description = "宣发订单")
public class IslandPromotionOrderDTO implements Serializable {

    private Long id;

    /**
     * 平台id
     */
    @NotNull
    @ApiModelProperty(value = "平台id", required = true)
    private Long platformId;


    @NotNull
    @ApiModelProperty(value = "通吃岛Id", required = true)
    private Long tcdId;

    /**
     * 发布品牌id
     */
    @NotNull(message = "发布品牌id不能为空")
    @ApiModelProperty(value = "发布品牌id", required = true)
    private Long brandId;

    /**
     * 发布平台名
     */
    @ApiModelProperty(value = "发布平台名")
    private String platformName;

    /**
     * 订单sn
     */
    @NotNull
    @ApiModelProperty(value = "订单sn", required = true)
    private String orderSn;

    /**
     * 宣发任务id
     */
    @NotNull
    @ApiModelProperty(value = "宣发任务id", required = true)
    private Long promoteId;
    
    
    /**
     * 宣发任务编号
     */
    @ApiModelProperty(value = "宣发任务编号")
    private String promoteSn;

    /**
     * 推广大vId
     */
    @ApiModelProperty(value = "推广大vId", required = true)
    private Long expertId;


    @ApiModelProperty(value = "推广大v昵称")
    private String expertNickName;

    @ApiModelProperty(value = "推广大v电话号码")
    private String expertPhone;

    /**
     * 推广大v与渠道的认证信息id
     */
    @NotNull
    @ApiModelProperty(value = "推广大v与渠道的认证信息id", required = true)
    private Long expertPlaceId;

    /**
     * 推广订单状态
     */
    @ApiModelProperty(value = "推广订单状态  PROMOTEING 推广中, CHECKING 审核中, FINISH 已完成, DISABLE 已取消,OVERTIME 超时")
    private PromotionOrderState orderState;

    /**
     * 接单时间island-right-and-interest-settings
     */
    @ApiModelProperty(value = "接单时间")
    private LocalDateTime takeOrderTime;

    /**
     * 撤回时间（上传审核信息后撤回）
     */
    @ApiModelProperty(value = "撤回时间（上传审核信息后撤回）")
    private LocalDateTime withdrawTime;

    /**
     * 取消时间
     */
    @ApiModelProperty(value = "取消时间")
    private LocalDateTime cancelTime;

    /**
     * 手动关闭任务
     */
    @ApiModelProperty(value = "手动关闭任务")
    private Boolean closeTask;

    /**
     * 任务说明
     */
    @ApiModelProperty(value = "任务说明")
    private String taskDescription;

    /**
     * 达人宣传图片
     */
    @ApiModelProperty(value = "达人宣传图片")
    private String promotePic;

    /**
     * 订单赏金
     */
    @ApiModelProperty(value = "订单赏金")
    private BigDecimal reward;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 订单有效时间
     */
    @ApiModelProperty(value = "订单有效时间")
    private LocalDateTime closeTime;

    /**
     * 订单提交审核时间
     */
    @ApiModelProperty(value = "订单提交审核时间")
    private LocalDateTime submitTime;

    /**
     * 审核时间
     */
    @ApiModelProperty(value = "审核时间")
    private LocalDateTime checkTime;

    /**
     * 审核结果  -1正在审核中 0 审核失败 1 审核通过
     */
    @ApiModelProperty(value = "审核结果  -1正在审核中 0 审核失败 1 审核通过")
    private Integer checkResult;

    /**
     * 审核结果失败说明
     */
    @ApiModelProperty(value = "审核结果失败说明")
    private String checkFailReason;


    @ApiModelProperty(value = "推广时限")
    private Integer limitDay;



    /**
     * 平台抽成比
     */
    @ApiModelProperty(value = "平台抽成比")
    private Double platformCommission;



    /**
     * 任务开始时间
     */
    @ApiModelProperty(value = "任务开始时间")
    private LocalDateTime startTime;

    /**
     * 任务结束时间
     */
    @ApiModelProperty(value = "任务结束时间")
    private LocalDateTime endTime;


    /**
     * 审核人
     */
    @ApiModelProperty(value = "审核人")
    private String  checkUser;



    @ApiModelProperty(value = "渠道id")
    private Long placeId;


    @ApiModelProperty(value = "渠道类型id")
    private Long placeTypeId;

    @ApiModelProperty(value = "渠道类型")
    private String placeType;
    
    @ApiModelProperty(value = "渠道信息")
    private IslandPromotionPlaceDTO islandPromotionPlaceDTO;


    @ApiModelProperty(value = "宣发任务信息")
    private IslandPromotionDTO islandPromotionDTO;


    @ApiModelProperty(value = "达人信息")
    private IslandUserDTO islandUserDTO;



    /**
     * 渠道名称
     */
    @ApiModelProperty(value = "渠道名称")
    private String placeName;


    /**
     * 宣发类型
     */
    @ApiModelProperty(value = "宣发类型")
    private String promoteTypeName;


    /**
     * 达人等级
     */
    @ApiModelProperty(value = "达人等级")
    private Integer expertGrade;


    /**
     * 达人等级粉丝数
     */
    @ApiModelProperty(value = "达人等级粉丝数")
    private String expertGradeFansNumbers;


    @ApiModelProperty(value = "场景类型")
    private SceneType sceneType;

    @ApiModelProperty(value = "达人认证信息")
    private IslandPromotionExpertAuthDTO islandPromotionExpertAuthDTO;
    
    
    @ApiModelProperty(value = "是否可以接单")
    private Boolean havePermissionTakeOrder;
    
    
    public Boolean getHavePermissionTakeOrder() {
        return havePermissionTakeOrder;
    }
    
    public void setHavePermissionTakeOrder(Boolean havePermissionTakeOrder) {
        this.havePermissionTakeOrder = havePermissionTakeOrder;
    }
    
    
    public String getPromoteSn() {
        return promoteSn;
    }
    
    public void setPromoteSn(String promoteSn) {
        this.promoteSn = promoteSn;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Long getPromoteId() {
        return promoteId;
    }

    public void setPromoteId(Long promoteId) {
        this.promoteId = promoteId;
    }

    public Long getExpertPlaceId() {
        return expertPlaceId;
    }

    public void setExpertPlaceId(Long expertPlaceId) {
        this.expertPlaceId = expertPlaceId;
    }

    public PromotionOrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(PromotionOrderState orderState) {
        this.orderState = orderState;
    }

    public LocalDateTime getTakeOrderTime() {
        return takeOrderTime;
    }

    public void setTakeOrderTime(LocalDateTime takeOrderTime) {
        this.takeOrderTime = takeOrderTime;
    }

    public LocalDateTime getWithdrawTime() {
        return withdrawTime;
    }

    public void setWithdrawTime(LocalDateTime withdrawTime) {
        this.withdrawTime = withdrawTime;
    }

    public LocalDateTime getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(LocalDateTime cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Boolean isCloseTask() {
        return closeTask;
    }

    public void setCloseTask(Boolean closeTask) {
        this.closeTask = closeTask;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getPromotePic() {
        return promotePic;
    }

    public void setPromotePic(String promotePic) {
        this.promotePic = promotePic;
    }

    public BigDecimal getReward() {
        return reward;
    }

    public void setReward(BigDecimal reward) {
        this.reward = reward;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalDateTime closeTime) {
        this.closeTime = closeTime;
    }

    public LocalDateTime getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(LocalDateTime submitTime) {
        this.submitTime = submitTime;
    }

    public LocalDateTime getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(LocalDateTime checkTime) {
        this.checkTime = checkTime;
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


    public Long getExpertId() {
        return expertId;
    }

    public void setExpertId(Long expertId) {
        this.expertId = expertId;
    }

    public Boolean getCloseTask() {
        return closeTask;
    }

    public Integer getCheckResult() {
        return checkResult;
    }


    public Integer getLimitDay() {
        return limitDay;
    }

    public void setLimitDay(Integer limitDay) {
        this.limitDay = limitDay;
    }

    public Double getPlatformCommission() {
        return platformCommission;
    }

    public void setPlatformCommission(Double platformCommission) {
        this.platformCommission = platformCommission;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }


    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }

    public IslandPromotionPlaceDTO getIslandPromotionPlaceDTO() {
        return islandPromotionPlaceDTO;
    }

    public void setIslandPromotionPlaceDTO(IslandPromotionPlaceDTO islandPromotionPlaceDTO) {
        this.islandPromotionPlaceDTO = islandPromotionPlaceDTO;
    }

    public IslandPromotionDTO getIslandPromotionDTO() {
        return islandPromotionDTO;
    }

    public void setIslandPromotionDTO(IslandPromotionDTO islandPromotionDTO) {
        this.islandPromotionDTO = islandPromotionDTO;
    }





    public IslandPromotionExpertAuthDTO getIslandPromotionExpertAuthDTO() {
        return islandPromotionExpertAuthDTO;
    }

    public void setIslandPromotionExpertAuthDTO(IslandPromotionExpertAuthDTO islandPromotionExpertAuthDTO) {
        this.islandPromotionExpertAuthDTO = islandPromotionExpertAuthDTO;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public Long getPlaceTypeId() {
        return placeTypeId;
    }

    public void setPlaceTypeId(Long placeTypeId) {
        this.placeTypeId = placeTypeId;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    public IslandUserDTO getIslandUserDTO() {
        return islandUserDTO;
    }

    public void setIslandUserDTO(IslandUserDTO islandUserDTO) {
        this.islandUserDTO = islandUserDTO;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPromoteTypeName() {
        return promoteTypeName;
    }

    public void setPromoteTypeName(String promoteTypeName) {
        this.promoteTypeName = promoteTypeName;
    }

    public Integer getExpertGrade() {
        return expertGrade;
    }

    public void setExpertGrade(Integer expertGrade) {
        this.expertGrade = expertGrade;
    }

    public String getExpertGradeFansNumbers() {
        return expertGradeFansNumbers;
    }

    public void setExpertGradeFansNumbers(String expertGradeFansNumbers) {
        this.expertGradeFansNumbers = expertGradeFansNumbers;
    }

    public SceneType getSceneType() {
        return sceneType;
    }

    public void setSceneType(SceneType sceneType) {
        this.sceneType = sceneType;
    }

    public String getExpertNickName() {
        return expertNickName;
    }

    public void setExpertNickName(String expertNickName) {
        this.expertNickName = expertNickName;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getTcdId() {
        return tcdId;
    }

    public void setTcdId(Long tcdId) {
        this.tcdId = tcdId;
    }

    public String getExpertPhone() {
        return expertPhone;
    }

    public void setExpertPhone(String expertPhone) {
        this.expertPhone = expertPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IslandPromotionOrderDTO islandPromotionOrderDTO = (IslandPromotionOrderDTO) o;
        if (islandPromotionOrderDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), islandPromotionOrderDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
    
    @Override
    public String toString() {
        return "IslandPromotionOrderDTO{" +
            "id=" + id +
            ", platformId=" + platformId +
            ", tcdId=" + tcdId +
            ", brandId=" + brandId +
            ", platformName='" + platformName + '\'' +
            ", orderSn='" + orderSn + '\'' +
            ", promoteId=" + promoteId +
            ", promoteSn='" + promoteSn + '\'' +
            ", expertId=" + expertId +
            ", expertNickName='" + expertNickName + '\'' +
            ", expertPhone='" + expertPhone + '\'' +
            ", expertPlaceId=" + expertPlaceId +
            ", orderState=" + orderState +
            ", takeOrderTime=" + takeOrderTime +
            ", withdrawTime=" + withdrawTime +
            ", cancelTime=" + cancelTime +
            ", closeTask=" + closeTask +
            ", taskDescription='" + taskDescription + '\'' +
            ", promotePic='" + promotePic + '\'' +
            ", reward=" + reward +
            ", createTime=" + createTime +
            ", closeTime=" + closeTime +
            ", submitTime=" + submitTime +
            ", checkTime=" + checkTime +
            ", checkResult=" + checkResult +
            ", checkFailReason='" + checkFailReason + '\'' +
            ", limitDay=" + limitDay +
            ", platformCommission=" + platformCommission +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            ", checkUser='" + checkUser + '\'' +
            ", placeId=" + placeId +
            ", placeTypeId=" + placeTypeId +
            ", placeType='" + placeType + '\'' +
            ", islandPromotionPlaceDTO=" + islandPromotionPlaceDTO +
            ", islandPromotionDTO=" + islandPromotionDTO +
            ", islandUserDTO=" + islandUserDTO +
            ", placeName='" + placeName + '\'' +
            ", promoteTypeName='" + promoteTypeName + '\'' +
            ", expertGrade=" + expertGrade +
            ", expertGradeFansNumbers='" + expertGradeFansNumbers + '\'' +
            ", sceneType=" + sceneType +
            ", islandPromotionExpertAuthDTO=" + islandPromotionExpertAuthDTO +
            ", havePermissionTakeOrder=" + havePermissionTakeOrder +
            '}';
    }
}
