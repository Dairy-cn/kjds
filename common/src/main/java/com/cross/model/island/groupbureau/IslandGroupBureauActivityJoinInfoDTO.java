package com.cross.model.island.groupbureau;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.cross.model.enumeration.IslandActivityModeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 */
@ApiModel(description = "组局 活动报名信息")
public class IslandGroupBureauActivityJoinInfoDTO implements Serializable {

    private Long id;

    /**
     * 创建平台编号
     */
    @ApiModelProperty(value = "创建平台编号")
    private Long platformId;

    /**
     * 通吃岛平台编号
     */
    @ApiModelProperty(value = "通吃岛平台编号")
    private Long tcdPlatformId;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String orderSn;

    /**
     * 活动活动id
     */
    @ApiModelProperty(value = "活动活动id")
    private Long activityId;

    /**
     * 活动名称
     */
    @ApiModelProperty(value = "活动名称")
    private String activityName;

    /**
     * 活动类型名称
     */
    @ApiModelProperty(value = "活动类型名称")
    private String activityTypeName;

    /**
     * 组局活动门槛渠道id
     */
    @ApiModelProperty(value = "组局活动门槛渠道id")
    private Long channelId;

    /**
     * 组局活动门槛渠道名称
     */
    @ApiModelProperty(value = "组局活动门槛渠道名称")
    private String channelName;

    /**
     * 组局活动方式  FREE 免费  PAY 付费
     */
    @NotNull
    @ApiModelProperty(value = "组局活动方式 必传  FREE 免费  PAY 付费")
    private IslandActivityModeEnum islandActivityModeEnum;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 小程序用户id
     */
    @ApiModelProperty(value = "小程序用户id")
    private Long weAppUserId;

    /**
     * 用户OpenId
     */
    @ApiModelProperty(value = "用户OpenId")
    private String userOpenId;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称")
    private String userName;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 报名时间
     */
    @ApiModelProperty(value = "报名时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant joinTime;

    /**
     * 订单核销时间
     */
    @ApiModelProperty(value = "订单核销时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant useTime;

    /**
     * 活动品牌id
     */
    @ApiModelProperty(value = "活动品牌id")
    private Long brandId;

    /**
     * 活动品牌名称
     */
    @ApiModelProperty(value = "活动品牌名称")
    private String brandName;

    /**
     * 活动门店id
     */
    @ApiModelProperty(value = "活动门店id")
    private Long merchantId;

    /**
     * 活动门店名称
     */
    @ApiModelProperty(value = "活动门店名称")
    private String merchantName;


    /**
     * 到店消费开始时间
     */
    @ApiModelProperty(value = "到店消费开始时间 必传")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant useStartTime;

    /**
     * 到店消费截至时间
     */
    @ApiModelProperty(value = "到店消费截至时间 必传")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant useEndTime;

    /**
     * 是否开启晒图返现任务
     */
    @ApiModelProperty(value = "是否开启晒图返现任务")
    private Boolean ifPrintReturnCash;

    /**
     * 返现金额
     */
    @ApiModelProperty(value = "返现金额")
    private BigDecimal returnAmount;

    /**
     * 晒图开始时间
     */
    @ApiModelProperty(value = "晒图开始时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant printStartTime;

    /**
     * 晒图截至时间
     */
    @ApiModelProperty(value = "晒图截至时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant printEndTime;

    /**
     * 晒图提交时间
     */
    @ApiModelProperty(value = "晒图提交时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant printSubmitTime;

    /**
     * 晒图描述（最多100字）
     */
    @ApiModelProperty(value = "晒图描述（最多100字）")
    private String printSubmitDescription;

    /**
     * 晒图图片(6张,多张以逗号分隔)
     */
    @ApiModelProperty(value = "晒图图片(6张,多张以逗号分隔)")
    private String printSubmitPicture;

    /**
     * 是否到店
     */
    @ApiModelProperty(value = "是否到店")
    private Boolean ifConsumed;

    /**
     * 审核状态 -2(草稿) -1(审核不通过) 0(待审核) 1(打款中)  2(已完成)
     */
    @ApiModelProperty(value = "审核状态 -2(草稿) -1(审核不通过) 0(待审核) 1(打款中)  2(已完成)")
    private Integer auditStatus;

    /**
     * 审核时间
     */
    @ApiModelProperty(value = "审核时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant auditTime;

    /**
     * 审核不通过原因(最多30字)
     */
    @ApiModelProperty(value = "审核不通过原因(最多30字)")
    private String reason;

    /**
     * 上下架状态
     */
    @ApiModelProperty(value = "上下架状态")
    private Boolean isShow;

    @ApiModelProperty(value = "任务状态 0：待核销  1：晒图返现 2：待审核 3：已完成 4：已失效")
    private Integer taskState;

    /**
     * 组局活动信息
     * */
    private IslandGroupBureauActivityInfoDTO islandGroupBureauActivityInfoDTO;

    /**
     * 组局活动待审核记录 总数
     */
    @ApiModelProperty(value = "组局活动待审核记录 总数")
    private Long waitAuditTotalNum;

    /**
     * 组局活动审核不通过记录 总数
     */
    @ApiModelProperty(value = "组局活动审核不通过记录 总数")
    private Long failedTotalNum;

    /**
     * 组局活动审核通过记录 总数
     */
    @ApiModelProperty(value = "组局活动审核通过记录 总数")
    private Long succeedTotalNum;

    public IslandGroupBureauActivityJoinInfoDTO() {
    }

    public IslandGroupBureauActivityJoinInfoDTO(Long waitAuditTotalNum, Long failedTotalNum, Long succeedTotalNum) {
        this.waitAuditTotalNum = waitAuditTotalNum;
        this.failedTotalNum = failedTotalNum;
        this.succeedTotalNum = succeedTotalNum;
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

    public Long getTcdPlatformId() {
        return tcdPlatformId;
    }

    public void setTcdPlatformId(Long tcdPlatformId) {
        this.tcdPlatformId = tcdPlatformId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }


    public String getActivityTypeName() {
        return activityTypeName;
    }

    public void setActivityTypeName(String activityTypeName) {
        this.activityTypeName = activityTypeName;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public IslandActivityModeEnum getIslandActivityModeEnum() {
        return islandActivityModeEnum;
    }

    public void setIslandActivityModeEnum(IslandActivityModeEnum islandActivityModeEnum) {
        this.islandActivityModeEnum = islandActivityModeEnum;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getWeAppUserId() {
        return weAppUserId;
    }

    public void setWeAppUserId(Long weAppUserId) {
        this.weAppUserId = weAppUserId;
    }

    public String getUserOpenId() {
        return userOpenId;
    }

    public void setUserOpenId(String userOpenId) {
        this.userOpenId = userOpenId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Instant getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Instant joinTime) {
        this.joinTime = joinTime;
    }

    public Instant getUseTime() {
        return useTime;
    }

    public void setUseTime(Instant useTime) {
        this.useTime = useTime;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Instant getUseStartTime() {
        return useStartTime;
    }

    public void setUseStartTime(Instant useStartTime) {
        this.useStartTime = useStartTime;
    }

    public Instant getUseEndTime() {
        return useEndTime;
    }

    public void setUseEndTime(Instant useEndTime) {
        this.useEndTime = useEndTime;
    }

    public Boolean getIfPrintReturnCash() {
        return ifPrintReturnCash;
    }

    public void setIfPrintReturnCash(Boolean ifPrintReturnCash) {
        this.ifPrintReturnCash = ifPrintReturnCash;
    }

    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }

    public Instant getPrintStartTime() {
        return printStartTime;
    }

    public void setPrintStartTime(Instant printStartTime) {
        this.printStartTime = printStartTime;
    }

    public Instant getPrintEndTime() {
        return printEndTime;
    }

    public void setPrintEndTime(Instant printEndTime) {
        this.printEndTime = printEndTime;
    }

    public Instant getPrintSubmitTime() {
        return printSubmitTime;
    }

    public void setPrintSubmitTime(Instant printSubmitTime) {
        this.printSubmitTime = printSubmitTime;
    }

    public String getPrintSubmitDescription() {
        return printSubmitDescription;
    }

    public void setPrintSubmitDescription(String printSubmitDescription) {
        this.printSubmitDescription = printSubmitDescription;
    }

    public String getPrintSubmitPicture() {
        return printSubmitPicture;
    }

    public void setPrintSubmitPicture(String printSubmitPicture) {
        this.printSubmitPicture = printSubmitPicture;
    }

    public Boolean getIfConsumed() {
        return ifConsumed;
    }

    public void setIfConsumed(Boolean ifConsumed) {
        this.ifConsumed = ifConsumed;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Instant getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Instant auditTime) {
        this.auditTime = auditTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean show) {
        isShow = show;
    }

    public Integer getTaskState() {
        return taskState;
    }

    public void setTaskState(Integer taskState) {
        this.taskState = taskState;
    }

    public IslandGroupBureauActivityInfoDTO getIslandGroupBureauActivityInfoDTO() {
        return islandGroupBureauActivityInfoDTO;
    }

    public void setIslandGroupBureauActivityInfoDTO() {
        setIslandGroupBureauActivityInfoDTO();
    }

    public void setIslandGroupBureauActivityInfoDTO(IslandGroupBureauActivityInfoDTO islandGroupBureauActivityInfoDTO) {
        this.islandGroupBureauActivityInfoDTO = islandGroupBureauActivityInfoDTO;
    }

    public Long getWaitAuditTotalNum() {
        return waitAuditTotalNum;
    }

    public void setWaitAuditTotalNum(Long waitAuditTotalNum) {
        this.waitAuditTotalNum = waitAuditTotalNum;
    }

    public Long getFailedTotalNum() {
        return failedTotalNum;
    }

    public void setFailedTotalNum(Long failedTotalNum) {
        this.failedTotalNum = failedTotalNum;
    }

    public Long getSucceedTotalNum() {
        return succeedTotalNum;
    }

    public void setSucceedTotalNum(Long succeedTotalNum) {
        this.succeedTotalNum = succeedTotalNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IslandGroupBureauActivityJoinInfoDTO islandGroupBureauActivityJoinInfoDTO = (IslandGroupBureauActivityJoinInfoDTO) o;
        if (islandGroupBureauActivityJoinInfoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), islandGroupBureauActivityJoinInfoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "IslandGroupBureauActivityJoinInfoDTO{" +
            "id=" + id +
            ", platformId=" + platformId +
            ", tcdPlatformId=" + tcdPlatformId +
            ", orderSn='" + orderSn + '\'' +
            ", activityId=" + activityId +
            ", activityName='" + activityName + '\'' +
            ", channelId=" + channelId +
            ", islandActivityModeEnum=" + islandActivityModeEnum +
            ", userId=" + userId +
            ", weAppUserId=" + weAppUserId +
            ", userName='" + userName + '\'' +
            ", phone='" + phone + '\'' +
            ", joinTime=" + joinTime +
            ", useTime=" + useTime +
            ", brandId=" + brandId +
            ", brandName='" + brandName + '\'' +
            ", merchantId=" + merchantId +
            ", merchantName='" + merchantName + '\'' +
            ", useStartTime=" + useStartTime +
            ", useEndTime=" + useEndTime +
            ", ifPrintReturnCash=" + ifPrintReturnCash +
            ", returnAmount=" + returnAmount +
            ", printStartTime=" + printStartTime +
            ", printEndTime=" + printEndTime +
            ", printSubmitTime=" + printSubmitTime +
            ", printSubmitDescription='" + printSubmitDescription + '\'' +
            ", printSubmitPicture='" + printSubmitPicture + '\'' +
            ", ifConsumed=" + ifConsumed +
            ", auditStatus=" + auditStatus +
            ", auditTime=" + auditTime +
            ", reason='" + reason + '\'' +
            ", isShow=" + isShow +
            ", taskState=" + taskState +
            ", islandGroupBureauActivityInfoDTO=" + islandGroupBureauActivityInfoDTO +
            ", waitAuditTotalNum=" + waitAuditTotalNum +
            ", failedTotalNum=" + failedTotalNum +
            ", succeedTotalNum=" + succeedTotalNum +
            '}';
    }
}
