package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.cross.enumtype.PromotionState;
import com.cross.enumtype.SceneType;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 */
@ApiModel(description = "宣发任务")
public class IslandPromotionDTO implements Serializable {

    private static final long serialVersionUID = 92555377887759528L;



    private Long id;


    /**
     * 通吃岛Id
     */
    @NotNull(message = "通吃岛Id不能为空")
    @ApiModelProperty(value = "通吃岛Id", required = true)
    private Long tcdId;

    /**
     * 平台id
     */
    @NotNull(message = "平台id不能为空")
    @ApiModelProperty(value = "平台id", required = true)
    private Long platformId;

    /**
     * 发布品牌id
     */
    @NotNull(message = "发布品牌id不能为空")
    @ApiModelProperty(value = "发布品牌id", required = true)
    private Long brandId;




    /**
     * 发布平台
     */
    @ApiModelProperty(value = "发布平台")
    private String platformName;

    /**
     * 渠道id
     */
    @NotNull(message = "渠道id不能为空")
    @ApiModelProperty(value = "渠道id", required = true)
    private Long placeId;

    /**
     * 渠道名称
     */
    @ApiModelProperty(value = "渠道名称")
    private String placeName;

    /**
     * 宣发类型id
     */
    @NotNull(message = "宣发类型id不能为空")
    @ApiModelProperty(value = "宣发类型id", required = true)
    private Long promoteTypeId;

    /**
     * 宣发类型
     */
    @ApiModelProperty(value = "宣发类型")
    private String promoteTypeName;

    /**
     * 参考价
     */
    @ApiModelProperty(value = "参考价")
    private BigDecimal referencePrice;

    /**
     * 要求达人等级id
     */
    @NotNull(message = "达人等级id不能为空")
    @ApiModelProperty(value = "要求达人等级id", required = true)
    private Long expertGradeId;






    @NotNull(message = "场景类型不能为空")
    @ApiModelProperty(value = "场景类型 新店开业： NEWSTORE；节日促销 HOLIDATSALE ；日常促销 PROMOTION； 其他 OTHER")
    private SceneType sceneType;
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

    /**
     * 赏金 每单
     */
    @NotNull(message = "赏金不能为空")
    @ApiModelProperty(value = "赏金 每单")
    private BigDecimal reward;

    /**
     * 需要人数
     */
    @NotNull(message = "需要人数不能为空")
    @ApiModelProperty(value = "需要人数")
    private Integer numberPeople;

    /**
     * 总赏金
     */
    @ApiModelProperty(value = "总赏金")
    private BigDecimal totalMomey;

    /**
     * 任务开始时间
     */
    @NotNull(message = "任务开始时间不能为空")
    @ApiModelProperty(value = "任务开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime startTime;

    /**
     * 任务结束时间
     */
    @NotNull(message = "任务结束时间不能为空")
    @ApiModelProperty(value = "任务结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime endTime;

    /**
     * 推广目标要求
     */
    @NotNull(message = "推广目标要求不能为空")
    @ApiModelProperty(value = "推广目标要求")
    @Size(max = 100,message = "推广目标要求不能超过100个字")
    private String requirementDescription;

    /**
     * 推广场景
     */
    @NotNull(message = "推广场景不能为空")
    @ApiModelProperty(value = "推广场景")
    @Size(max = 10,message = "推广场景不能超过10个字")
    private String event;

    /**
     * 推广说明
     */
    @NotNull(message = "推广说明不能为空")
    @ApiModelProperty(value = "推广说明")
    @Size(max = 600,message = "推广说明不能超过600个字")
    private String promoteDescription;

    /**
     * 推广图片
     */
    @NotNull(message = "推广图片不能为空")
    @ApiModelProperty(value = "推广图片")
    private String promotePic;

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

    /**
     * 审核时间
     */
    @ApiModelProperty(value = "审核时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime checkTime;

    /**
     * 审核结果 1 通过  0 未通过 -1审核中
     */
    @ApiModelProperty(value = "审核结果 1 通过  0 未通过 -1审核中")
    private Integer checkResult;

    /**
     * 审核结果失败说明
     */
    @ApiModelProperty(value = "审核结果失败说明")
    private String checkFailReason;

    /**
     * 宣发任务状态
     */
    @ApiModelProperty(value = "宣发任务状态  CHECKING 审核中,WAITPROMOTE 待推广, PROMOTEING 推广中, CLOSED 已关闭, FINISH 已结束,WAITSUBMIT 草稿,  DISABLE 无效")
    private PromotionState promotionState;

    /**
     * 查看数
     */
    @ApiModelProperty(value = "查看数")
    private Integer readerCount;

    /**
     * 是否关闭
     */
    @ApiModelProperty(value = "是否关闭")
    private Boolean close;

    /**
     * 关闭时间
     */
    @ApiModelProperty(value = "关闭时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime closeTime;


    /**
     * 状态
     */
    @ApiModelProperty(value = "-1 已结束  0 未开始  1 推广中 2 草稿 3 审核中 4 未通过审核 -2未知状态")
    private Integer state;

    /**
     * 审核人
     */
    @ApiModelProperty(value = "审核人")
    private String  checkUser;






    @ApiModelProperty(value = "推广时限")
    private Integer limitDay;

    /**
     * 平台抽成比
     */
    @ApiModelProperty(value = "平台抽成比")
    private Double platformCommission;


    @ApiModelProperty(value = "已完成单数")
    private Integer finishCount;

    @ApiModelProperty(value = "未发放金额")
    private BigDecimal unPaidAmount;


    @ApiModelProperty(value = "已完成订单ids")
    private List<Long>  takeLists;

    @ApiModelProperty("未完成订单ids")
    private List<Long>  promotionsLists;

    @ApiModelProperty(value = "已接单数")
    private Integer takeCount;

    /**
     * 提交审核时间
     */
    @ApiModelProperty(value = "提交审核时间")
     @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime submitTime;
    
   

    @ApiModelProperty(value = "是否显示门店信息")
    private Boolean showMerchantInfo;
    @ApiModelProperty(value = "行业")
    private String merchantBusiness;
    @ApiModelProperty(value = "品牌描述")
    private String merchantDetails;

    @ApiModelProperty(value = "门店地址")
    private String merchantAddress;

    @ApiModelProperty(value = "门店头像")
    private String merchantHeadPic;

    @ApiModelProperty(value = "置顶时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant topTime;

    @ApiModelProperty(value = "渠道类型宣传图片")
    private String placeTypePromotePic;
    
    @ApiModelProperty(value = "当前用户能不能再接单")
    private Boolean havePermissionTakeOrder;
    
    
    private List<IslandUserModel> islandUserModels;

    public Boolean getClose() {
        return close;
    }

    public SceneType getSceneType() {
        return sceneType;
    }

    public void setSceneType(SceneType sceneType) {
        this.sceneType = sceneType;
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

    public Long getPromoteTypeId() {
        return promoteTypeId;
    }

    public void setPromoteTypeId(Long promoteTypeId) {
        this.promoteTypeId = promoteTypeId;
    }

    public String getPromoteTypeName() {
        return promoteTypeName;
    }

    public void setPromoteTypeName(String promoteTypeName) {
        this.promoteTypeName = promoteTypeName;
    }

    public BigDecimal getReferencePrice() {
        return referencePrice;
    }

    public void setReferencePrice(BigDecimal referencePrice) {
        this.referencePrice = referencePrice;
    }

    public Long getExpertGradeId() {
        return expertGradeId;
    }

    public void setExpertGradeId(Long expertGradeId) {
        this.expertGradeId = expertGradeId;
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

    public BigDecimal getReward() {
        return reward;
    }

    public void setReward(BigDecimal reward) {
        this.reward = reward;
    }

    public Integer getNumberPeople() {
        return numberPeople;
    }

    public void setNumberPeople(Integer numberPeople) {
        this.numberPeople = numberPeople;
    }

    public BigDecimal getTotalMomey() {
        return totalMomey;
    }

    public void setTotalMomey(BigDecimal totalMomey) {
        this.totalMomey = totalMomey;
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

    public String getRequirementDescription() {
        return requirementDescription;
    }

    public void setRequirementDescription(String requirementDescription) {
        this.requirementDescription = requirementDescription;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getPromoteDescription() {
        return promoteDescription;
    }

    public void setPromoteDescription(String promoteDescription) {
        this.promoteDescription = promoteDescription;
    }

    public String getPromotePic() {
        return promotePic;
    }

    public void setPromotePic(String promotePic) {
        this.promotePic = promotePic;
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

    public LocalDateTime getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(LocalDateTime checkTime) {
        this.checkTime = checkTime;
    }

    public Integer getCheckResult() {
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

    public PromotionState getPromotionState() {
        return promotionState;
    }

    public void setPromotionState(PromotionState promotionState) {
        this.promotionState = promotionState;
    }

    public Integer getReaderCount() {
        return readerCount;
    }

    public void setReaderCount(Integer readerCount) {
        this.readerCount = readerCount;
    }

    public Boolean isClose() {
        return close;
    }

    public void setClose(Boolean close) {
        this.close = close;
    }

    public LocalDateTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalDateTime closeTime) {
        this.closeTime = closeTime;
    }

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }



    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public Integer getFinishCount() {
        return finishCount;
    }

    public void setFinishCount(Integer finishCount) {
        this.finishCount = finishCount;
    }

    public List<Long> getTakeLists() {
        return takeLists;
    }

    public void setTakeLists(List<Long> takeLists) {
        this.takeLists = takeLists;
    }

    public List<Long> getPromotionsLists() {
        return promotionsLists;
    }

    public void setPromotionsLists(List<Long> promotionsLists) {
        this.promotionsLists = promotionsLists;
    }


    public BigDecimal getUnPaidAmount() {
        return unPaidAmount;
    }

    public void setUnPaidAmount(BigDecimal unPaidAmount) {
        this.unPaidAmount = unPaidAmount;
    }

    public Integer getTakeCount() {
        return takeCount;
    }

    public void setTakeCount(Integer takeCount) {
        this.takeCount = takeCount;
    }

    public LocalDateTime getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(LocalDateTime submitTime) {
        this.submitTime = submitTime;
    }



    public Boolean getShowMerchantInfo() {
        return showMerchantInfo;
    }

    public void setShowMerchantInfo(Boolean showMerchantInfo) {
        this.showMerchantInfo = showMerchantInfo;
    }

    public String getMerchantBusiness() {
        return merchantBusiness;
    }

    public void setMerchantBusiness(String merchantBusiness) {
        this.merchantBusiness = merchantBusiness;
    }

    public String getMerchantDetails() {
        return merchantDetails;
    }

    public void setMerchantDetails(String merchantDetails) {
        this.merchantDetails = merchantDetails;
    }

    public String getMerchantAddress() {
        return merchantAddress;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }

    public String getMerchantHeadPic() {
        return merchantHeadPic;
    }

    public void setMerchantHeadPic(String merchantHeadPic) {
        this.merchantHeadPic = merchantHeadPic;
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
    
    public Instant getTopTime() {
        return topTime;
    }
    
    public void setTopTime(Instant topTime) {
        this.topTime = topTime;
    }
    
    public String getPlaceTypePromotePic() {
        return placeTypePromotePic;
    }

    public void setPlaceTypePromotePic(String placeTypePromotePic) {
        this.placeTypePromotePic = placeTypePromotePic;
    }

    public List<IslandUserModel> getIslandUserModels() {
        return islandUserModels;
    }

    public void setIslandUserModels(List<IslandUserModel> islandUserModels) {
        this.islandUserModels = islandUserModels;
    }
    
    public Boolean getHavePermissionTakeOrder() {
        return havePermissionTakeOrder;
    }
    
    public void setHavePermissionTakeOrder(Boolean havePermissionTakeOrder) {
        this.havePermissionTakeOrder = havePermissionTakeOrder;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IslandPromotionDTO islandPromotionDTO = (IslandPromotionDTO) o;
        if (islandPromotionDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), islandPromotionDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
    
    @Override
    public String toString() {
        return "IslandPromotionDTO{" +
            "id=" + id +
            ", tcdId=" + tcdId +
            ", platformId=" + platformId +
            ", brandId=" + brandId +
            ", platformName='" + platformName + '\'' +
            ", placeId=" + placeId +
            ", placeName='" + placeName + '\'' +
            ", promoteTypeId=" + promoteTypeId +
            ", promoteTypeName='" + promoteTypeName + '\'' +
            ", referencePrice=" + referencePrice +
            ", expertGradeId=" + expertGradeId +
            ", sceneType=" + sceneType +
            ", expertGrade=" + expertGrade +
            ", expertGradeFansNumbers='" + expertGradeFansNumbers + '\'' +
            ", reward=" + reward +
            ", numberPeople=" + numberPeople +
            ", totalMomey=" + totalMomey +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            ", requirementDescription='" + requirementDescription + '\'' +
            ", event='" + event + '\'' +
            ", promoteDescription='" + promoteDescription + '\'' +
            ", promotePic='" + promotePic + '\'' +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", checkTime=" + checkTime +
            ", checkResult=" + checkResult +
            ", checkFailReason='" + checkFailReason + '\'' +
            ", promotionState=" + promotionState +
            ", readerCount=" + readerCount +
            ", close=" + close +
            ", closeTime=" + closeTime +
            ", state=" + state +
            ", checkUser='" + checkUser + '\'' +
            ", limitDay=" + limitDay +
            ", platformCommission=" + platformCommission +
            ", finishCount=" + finishCount +
            ", unPaidAmount=" + unPaidAmount +
            ", takeLists=" + takeLists +
            ", promotionsLists=" + promotionsLists +
            ", takeCount=" + takeCount +
            ", submitTime=" + submitTime +
            ", showMerchantInfo=" + showMerchantInfo +
            ", merchantBusiness='" + merchantBusiness + '\'' +
            ", merchantDetails='" + merchantDetails + '\'' +
            ", merchantAddress='" + merchantAddress + '\'' +
            ", merchantHeadPic='" + merchantHeadPic + '\'' +
            ", placeTypePromotePic='" + placeTypePromotePic + '\'' +
            ", havePermissionTakeOrder=" + havePermissionTakeOrder +
            ", islandUserModels=" + islandUserModels +
            '}';
    }
}
