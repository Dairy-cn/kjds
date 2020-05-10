package com.cross.model.island.groupbureau;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.cross.model.DishMerchantInfoVM;
import com.cross.model.dish.ShopDish;
import com.cross.model.enumeration.ActivityThresholdEnum;
import com.cross.model.enumeration.IslandActivityModeEnum;
import com.cross.model.enumeration.ShowGradeType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 */
@ApiModel(description = "组局 活动信息")
public class IslandGroupBureauActivityInfoDTO implements Serializable {

    private Long id;

    /**
     * 创建平台编号
     */
    @NotNull
    @ApiModelProperty(value = "创建平台编号 必传")
    private Long platformId;

    /**
     * 通吃岛平台编号
     */
    @NotNull
    @ApiModelProperty(value = "通吃岛平台编号  必传")
    private Long tcdPlatformId;

    /**
     * 商品id
     */
    @NotNull
    @ApiModelProperty(value = "商品id 必传")
    private Long dishId;

    /**
     * 活动类型id
     */
    @NotNull
    @ApiModelProperty(value = "活动类型id 必传")
    private Long activityTypeId;

    /**
     * 活动类型名称
     */
    @ApiModelProperty(value = "活动类型名称")
    private String activityTypeName;

    /**
     * 组局活动方式  FREE 免费  PAY 付费
     */
    @NotNull
    @ApiModelProperty(value = "组局活动方式 必传  FREE 免费  PAY 付费")
    private IslandActivityModeEnum islandActivityModeEnum;

    /**
     * 活动名称
     */
    @ApiModelProperty(value = "活动名称")
    private String activityName;

    /**
     * 是否开启晒图返现任务
     */
    @NotNull
    @ApiModelProperty(value = "是否开启晒图返现任务 必传")
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
     * 活动品牌id
     */
    @NotNull
    @ApiModelProperty(value = "活动品牌id 必传")
    private Long brandId;

    /**
     * 活动品牌名称
     */
    @ApiModelProperty(value = "活动品牌名称")
    private String brandName;

    /**
     * 活动门店id
     */
    @NotNull
    @ApiModelProperty(value = "活动门店id 必传")
    private Long merchantId;

    @ApiModelProperty(value = "门店经度")
    private Double lng;

    @ApiModelProperty(value = "门店纬度")
    private Double lat;

    /**
     * 活动门店名称
     */
    @ApiModelProperty(value = "活动门店名称")
    private String merchantName;

    @ApiModelProperty(value = "门店地址对应省份编码")
    private Integer province;

    @ApiModelProperty(value = "门店地址对应地市编码")
    private String city;

    @ApiModelProperty(value = "门店地址对应区县编码")
    private String county;

    @ApiModelProperty(value = "门店地址经纬度")
    private String position;

    /**
     * 活动门店地址
     */
    @ApiModelProperty(value = "活动门店地址")
    private String address;

    /**
     * 活动所需人数
     */
    @NotNull
    @ApiModelProperty(value = "活动所需人数 必传")
    private Integer userNum;

    /**
     * 报名人数
     */
    @ApiModelProperty(value = "报名人数")
    private Integer joinedUserNum;

    /**
     * 剩余名额
     */
    @ApiModelProperty(value = "剩余名额")
    private Integer leftUserNum;

    /**
     * 活动总金额 免费时，金额为0，且不可编辑
     */
    @NotNull
    @ApiModelProperty(value = "活动总金额 必传 免费时，金额为0，且不可编辑")
    private BigDecimal totalMoney;

    /**
     * 每人所需支付金额
     */
    @NotNull
    @ApiModelProperty(value = "每人所需支付金额")
    private BigDecimal averageMoney;

    /**
     * 报名开始时间
     */
    @NotNull
    @ApiModelProperty(value = "报名开始时间 必传")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant signStartTime;

    /**
     * 报名截至时间
     */
    @NotNull
    @ApiModelProperty(value = "报名截至时间 必传")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant signEndTime;

    /**
     * 到店消费开始时间
     */
    @NotNull
    @ApiModelProperty(value = "到店消费开始时间 必传")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant useStartTime;

    /**
     * 到店消费截至时间
     */
    @NotNull
    @ApiModelProperty(value = "到店消费截至时间 必传")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant useEndTime;

    /**
     * 组局活动门槛
     */
    @NotNull
    @ApiModelProperty(value = "组局活动门槛 必传 CHANNEL(渠道) USER(用户等级) TCD_CARD(通吃卡)")
    private List<ActivityThresholdEnum> activityThresholdEnums;

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
     * 组局活动门槛渠道等级
     */
    @ApiModelProperty(value = "组局活动门槛渠道等级")
    private Integer channelGrade;

    /**
     * 显示等级/粉丝数/好友数
     */
    @ApiModelProperty(value = "显示等级/粉丝数/好友数")
    private ShowGradeType showGradeType;

    /**
     * 显示等级/粉丝数/好友数量
     */
    @ApiModelProperty(value = "显示等级/粉丝数/好友数量")
    private String fansNumOrGrade;

    /**
     * 要求最低用户等级id
     */
    @ApiModelProperty(value = "要求最低用户等级id")
    private Long userGradeId;

    /**
     * 要求最低用户等级
     */
    @ApiModelProperty(value = "要求最低用户等级")
    private Integer userGrade;

    /**
     * 要求最低用户等级名称
     */
    @ApiModelProperty(value = "要求最低用户等级名称")
    private String userGradeName;

    @NotNull
    @ApiModelProperty(value = "列表图 必传 1张")
    private String imagePath;

    /**
     * 活动图片
     */
    @NotNull
    @ApiModelProperty(value = "活动图片 必传 最多上传5张")
    private String dishImageUrl;

    /**
     * 活动说明
     */
    @NotNull
    @ApiModelProperty(value = "活动说明 必传 最多200字")
    private String description;

    /**
     * 距离
     */
    @NotNull
    @ApiModelProperty(value = "距离")
    private Double distance;

    /**
     * 审核状态 -2(草稿) -1(审核不通过) 0(待审核) 1(审核通过) （后台创建默认传1:审核通过，中台为0:待审核）
     */
    @ApiModelProperty(value = "审核状态 必传 -2(草稿) -1(审核不通过) 0(待审核) 1(审核通过) （后台创建默认传1:审核通过，中台为0:待审核）")
    private Integer auditStatus;

    /**
     * 提交时间
     */
    @ApiModelProperty(value = "提交时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant createTime;

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
    @ApiModelProperty(value = "上下架状态 默认为上架状态")
    private Boolean isShow;

    /**
     * 记录所处位置，用于排序
     */
    @ApiModelProperty(value = "记录所处位置，用于排序")
    private Long location;

    /**
     * 组局活动访问量(UV/PV) UV
     */
    @ApiModelProperty(value = "组局活动访问量(UV/PV) PV")
    private Integer pagViewNum;

    /**
     * 组局活动访问量(UV/PV) PV
     */
    @ApiModelProperty(value = "组局活动访问量(UV/PV) UV")
    private Integer uniqueVisitorNum;

    @ApiModelProperty(value = "菜品信息")
    private ShopDish shopDish;

    /**
     * 菜品绑定的门店信息
     */
    @ApiModelProperty(value = "门店位置坐标")
    private List<DishMerchantInfoVM> dishMerchantShippingInfo;

    @ApiModelProperty(value = "菜品状态 0：已满员  1：未开始  2：进行中 3：已结束 4:已报名")
    private Integer dishState;

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

    public IslandGroupBureauActivityInfoDTO() {
    }

    public IslandGroupBureauActivityInfoDTO(Long waitAuditTotalNum, Long failedTotalNum, Long succeedTotalNum) {
        this.waitAuditTotalNum = waitAuditTotalNum;
        this.failedTotalNum = failedTotalNum;
        this.succeedTotalNum = succeedTotalNum;
    }

    public IslandGroupBureauActivityInfoDTO(Long id, Long tcdPlatformId, Long dishId, String activityTypeName, IslandActivityModeEnum islandActivityModeEnum,
                                            String activityName, Boolean ifPrintReturnCash, BigDecimal returnAmount, Instant printStartTime, Instant printEndTime,
                                            Long brandId, Long merchantId, Integer userNum, Integer joinedUserNum, Integer leftUserNum,
                                            BigDecimal averageMoney, Instant signStartTime, Instant signEndTime, Instant useStartTime,
                                            Instant useEndTime, List<ActivityThresholdEnum> activityThresholdEnums, Long channelId,
                                            Integer channelGrade, ShowGradeType showGradeType, String fansNumOrGrade, Long userGradeId,
                                            String imagePath, String dishImageUrl, String description, Long location, Double distance) {
        this.id = id;
        this.tcdPlatformId = tcdPlatformId;
        this.dishId = dishId;
        this.activityTypeName = activityTypeName;
        this.islandActivityModeEnum = islandActivityModeEnum;
        this.activityName = activityName;
        this.ifPrintReturnCash = ifPrintReturnCash;
        this.returnAmount = returnAmount;
        this.printStartTime = printStartTime;
        this.printEndTime = printEndTime;
        this.brandId = brandId;
        this.merchantId = merchantId;
        this.userNum = userNum;
        this.joinedUserNum = joinedUserNum;
        this.leftUserNum = leftUserNum;
        this.averageMoney = averageMoney;
        this.signStartTime = signStartTime;
        this.signEndTime = signEndTime;
        this.useStartTime = useStartTime;
        this.useEndTime = useEndTime;
        this.activityThresholdEnums = activityThresholdEnums;
        this.channelId = channelId;
        this.channelGrade = channelGrade;
        this.showGradeType = showGradeType;
        this.fansNumOrGrade = fansNumOrGrade;
        this.userGradeId = userGradeId;
        this.imagePath = imagePath;
        this.dishImageUrl = dishImageUrl;
        this.description = description;
        this.location = location;
        this.distance = distance;
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

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public Long getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(Long activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public String getActivityTypeName() {
        return activityTypeName;
    }

    public void setActivityTypeName(String activityTypeName) {
        this.activityTypeName = activityTypeName;
    }

    public IslandActivityModeEnum getIslandActivityModeEnum() {
        return islandActivityModeEnum;
    }

    public void setIslandActivityModeEnum(IslandActivityModeEnum islandActivityModeEnum) {
        this.islandActivityModeEnum = islandActivityModeEnum;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
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

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    public Integer getJoinedUserNum() {        return joinedUserNum;    }

    public void setJoinedUserNum(Integer joinedUserNum) {        this.joinedUserNum = joinedUserNum;    }

    public Integer getLeftUserNum() {
        return leftUserNum;
    }

    public void setLeftUserNum(Integer leftUserNum) {
        this.leftUserNum = leftUserNum;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getAverageMoney() {
        return averageMoney;
    }

    public void setAverageMoney(BigDecimal averageMoney) {
        this.averageMoney = averageMoney;
    }

    public Instant getSignStartTime() {
        return signStartTime;
    }

    public void setSignStartTime(Instant signStartTime) {
        this.signStartTime = signStartTime;
    }

    public Instant getSignEndTime() {
        return signEndTime;
    }

    public void setSignEndTime(Instant signEndTime) {
        this.signEndTime = signEndTime;
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

    public List<ActivityThresholdEnum> getActivityThresholdEnums() {
        return activityThresholdEnums;
    }

    public void setActivityThresholdEnums(List<ActivityThresholdEnum> activityThresholdEnums) {
        this.activityThresholdEnums = activityThresholdEnums;
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

    public Integer getChannelGrade() {
        return channelGrade;
    }

    public void setChannelGrade(Integer channelGrade) {
        this.channelGrade = channelGrade;
    }

    public ShowGradeType getShowGradeType() {
        return showGradeType;
    }

    public void setShowGradeType(ShowGradeType showGradeType) {
        this.showGradeType = showGradeType;
    }

    public String getFansNumOrGrade() {return fansNumOrGrade; }

    public void setFansNumOrGrade(String fansNumOrGrade) { this.fansNumOrGrade = fansNumOrGrade; }

    public Long getUserGradeId() {
        return userGradeId;
    }

    public void setUserGradeId(Long userGradeId) {
        this.userGradeId = userGradeId;
    }

    public Integer getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(Integer userGrade) {
        this.userGrade = userGrade;
    }

    public String getUserGradeName() {
        return userGradeName;
    }

    public void setUserGradeName(String userGradeName) {
        this.userGradeName = userGradeName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDishImageUrl() {
        return dishImageUrl;
    }

    public void setDishImageUrl(String dishImageUrl) {
        this.dishImageUrl = dishImageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
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

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean show) {
        isShow = show;
    }

    public Long getLocation() {
        return location;
    }

    public void setLocation(Long location) {
        this.location = location;
    }

    public Integer getPagViewNum() {
        return pagViewNum;
    }

    public void setPagViewNum(Integer pagViewNum) {
        this.pagViewNum = pagViewNum;
    }

    public Integer getUniqueVisitorNum() {
        return uniqueVisitorNum;
    }

    public void setUniqueVisitorNum(Integer uniqueVisitorNum) {
        this.uniqueVisitorNum = uniqueVisitorNum;
    }

    public ShopDish getShopDish() {
        return shopDish;
    }

    public void setShopDish(ShopDish shopDish) {
        this.shopDish = shopDish;
    }

    public List<DishMerchantInfoVM> getDishMerchantShippingInfo() {
        return dishMerchantShippingInfo;
    }

    public void setDishMerchantShippingInfo(List<DishMerchantInfoVM> dishMerchantShippingInfo) {
        this.dishMerchantShippingInfo = dishMerchantShippingInfo;
    }

    public Integer getDishState() {
        return dishState;
    }

    public void setDishState(Integer dishState) {
        this.dishState = dishState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IslandGroupBureauActivityInfoDTO islandGroupBureauActivityInfoDTO = (IslandGroupBureauActivityInfoDTO) o;
        if (islandGroupBureauActivityInfoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), islandGroupBureauActivityInfoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "IslandGroupBureauActivityInfoDTO{" +
            "id=" + getId() +
            ", platformId=" + getPlatformId() +
            ", tcdPlatformId=" + getTcdPlatformId() +
            ", activityTypeId=" + getActivityTypeId() +
            ", activityTypeName=" + getActivityTypeName() +
            ", islandActivityModeEnum='" + getIslandActivityModeEnum() + "'" +
            ", activityName='" + getActivityName() + "'" +
            ", ifPrintReturnCash='" + getIfPrintReturnCash() + "'" +
            ", returnAmount=" + getReturnAmount() +
            ", printStartTime='" + getPrintStartTime() + "'" +
            ", printEndTime='" + getPrintEndTime() + "'" +
            ", brandId=" + getBrandId() +
            ", brandName='" + getBrandName() + "'" +
            ", merchantId=" + getMerchantId() +
            ", merchantName='" + getMerchantName() + "'" +
            ", userNum=" + getUserNum() +
            ", totalMoney=" + getTotalMoney() +
            ", signStartTime='" + getSignStartTime() + "'" +
            ", signEndTime='" + getSignEndTime() + "'" +
            ", useStartTime='" + getUseStartTime() + "'" +
            ", useEndTime='" + getUseEndTime() + "'" +
            ", activityThresholdEnums='" + getActivityThresholdEnums() + "'" +
            ", channelId=" + getChannelId() +
            ", channelName='" + getChannelName() + "'" +
            ", channelGrade=" + getChannelGrade() +
            ", showGradeType='" + getShowGradeType() + "'" +
            ", fansNumOrGrade=" + getFansNumOrGrade() +
            ", userGradeId=" + getUserGradeId() +
            ", userGrade=" + getUserGrade() +
            ", userGradeName='" + getUserGradeName() + "'" +
            ", dishImageUrl='" + getDishImageUrl() + "'" +
            ", description='" + getDescription() + "'" +
            ", auditStatus=" + getAuditStatus() +
            ", createTime='" + getCreateTime() + "'" +
            ", auditTime='" + getAuditTime() + "'" +
            ", reason='" + getReason() + "'" +
            "}";
    }
}
