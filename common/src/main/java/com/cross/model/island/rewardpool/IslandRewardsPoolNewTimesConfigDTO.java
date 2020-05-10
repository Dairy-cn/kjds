package com.cross.model.island.rewardpool;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.cross.enumtype.CycleType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 */
@ApiModel(description = "新一期奖金池配置")
public class IslandRewardsPoolNewTimesConfigDTO implements Serializable {

    private Long id;
    /**
     *平台编号
     */
    @ApiModelProperty(value = "平台编号")
    private Long platFormId;

    /**
     * 奖金池基础配置ID
     */
    @ApiModelProperty(value = "奖金池基础配置ID")
    private Long islandRewardsPoolBasicConfigId;

    /**
     * 下期是否启动开关
     */
    @ApiModelProperty(value = "下期是否启动开关")
    private Boolean startSwitch;

    /**
     * 是否滚动
     */
    @ApiModelProperty(value = "是否滚动")
    private Boolean ifScroll;

    /**
     * 是否滚动 为是时,滚动周期不能为空
     */
    @ApiModelProperty(value = "是否滚动 为是时,滚动周期不能为空")
    private CycleType scrollPeriod;

    /**
     * 周期次数 若已经开始滚动，次数按周期递减
     */
    @ApiModelProperty(value = "周期次数 若已经开始滚动，次数按周期递减")
    private Integer periodTimes;

    /**
     * 期数 第几期
     */
    @ApiModelProperty(value = "期数 第几期")
    private Integer times;

    /**
     * 活动报名开始时间
     */
    @ApiModelProperty(value = "活动报名开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime startTime;

    /**
     * 活动报名结束时间
     */
    @ApiModelProperty(value = "活动报名结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime endTime;

    /**
     * 活动开榜时间
     */
    @ApiModelProperty(value = "活动开榜时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime lotteryTime;

    /**
     * 参与用户等级id
     */
    @ApiModelProperty(value = "参与用户等级id")
    private Long gradeId;

    /**
     * 参与用户等级展示
     */
    @ApiModelProperty(value = "参与用户等级展示")
    private String gradeName;

    /**
     * 基础金额
     */
    @ApiModelProperty(value = "基础金额")
    private Float basicMoney;

    /**
     * 中奖比例配置
     */
    @ApiModelProperty(value = "中奖比例配置")
    private List<IslandRewardPoolWinRatioConfigVM> winRatioConfig;

    /**
     * 增加新用户数量
     */
    @ApiModelProperty(value = "增加新用户数量")
    private Long newUserNum;

    /**
     * 新用户奖励金额
     */
    @ApiModelProperty(value = "新用户奖励金额")
    private Float newUserRewards;

    /**
     * 奖励金额合计(增加新用户数量*新用户奖励金额)
     */
    @ApiModelProperty(value = "奖励金额合计(增加新用户数量*新用户奖励金额)")
    private Float newUserTotalRewards;

    /**
     * 总计金额(奖励金额合计+基础金额)
     */
    @ApiModelProperty(value = "总计金额(奖励金额合计+基础金额)")
    private Float totalMoney;

    /**
     * 配置用户ID
     */
    @ApiModelProperty(value = "配置用户ID")
    private Long updateUserId;

    /**
     * 配置创建时间
     */
    @ApiModelProperty(value = "配置创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;

    /**
     * 活动列表中用户参与门槛展示
     */
    @ApiModelProperty(value = "活动列表中用户参与门槛展示")
    private String gradeNames;

    /**
     * 通吃卡返现金额
     */
    @ApiModelProperty(value = "通吃卡返现")
    private List<String> tcCardCashBack;

    /**
     * 奖励总金额
     */
    @ApiModelProperty(value = "奖励总金额")
    private BigDecimal total;

    /**
     * 开奖状态
     */
    @ApiModelProperty(value = "0 未开奖, 1:已开奖")
    private Integer status;

    /**
     * 额外投入金额
     */
    @ApiModelProperty(value = "额外投入金额")
    private BigDecimal extraMoney;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlatFormId() {
        return platFormId;
    }

    public void setPlatFormId(Long platFormId) {
        this.platFormId = platFormId;
    }

    public Boolean getStartSwitch() {
        return startSwitch;
    }

    public Boolean getIfScroll() {
        return ifScroll;
    }

    public Long getIslandRewardsPoolBasicConfigId() {
        return islandRewardsPoolBasicConfigId;
    }

    public void setIslandRewardsPoolBasicConfigId(Long islandRewardsPoolBasicConfigId) {
        this.islandRewardsPoolBasicConfigId = islandRewardsPoolBasicConfigId;
    }

    public Boolean isStartSwitch() {
        return startSwitch;
    }

    public void setStartSwitch(Boolean startSwitch) {
        this.startSwitch = startSwitch;
    }

    public Boolean isIfScroll() {
        return ifScroll;
    }

    public void setIfScroll(Boolean ifScroll) {
        this.ifScroll = ifScroll;
    }

    public CycleType getScrollPeriod() {
        return scrollPeriod;
    }

    public void setScrollPeriod(CycleType scrollPeriod) {
        this.scrollPeriod = scrollPeriod;
    }

    public Integer getPeriodTimes() {
        return periodTimes;
    }

    public void setPeriodTimes(Integer periodTimes) {
        this.periodTimes = periodTimes;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
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

    public LocalDateTime getLotteryTime() {
        return lotteryTime;
    }

    public void setLotteryTime(LocalDateTime lotteryTime) {
        this.lotteryTime = lotteryTime;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getGradeNames() {
        return gradeNames;
    }

    public void setGradeNames(String gradeNames) {
        this.gradeNames = gradeNames;
    }

    public Float getBasicMoney() {
        return basicMoney;
    }

    public void setBasicMoney(Float basicMoney) {
        this.basicMoney = basicMoney;
    }

    public List<IslandRewardPoolWinRatioConfigVM> getWinRatioConfig() {
        return winRatioConfig;
    }

    public void setWinRatioConfig(List<IslandRewardPoolWinRatioConfigVM> winRatioConfig) {
        this.winRatioConfig = winRatioConfig;
    }

    public Long getNewUserNum() {
        return newUserNum;
    }

    public void setNewUserNum(Long newUserNum) {
        this.newUserNum = newUserNum;
    }

    public Float getNewUserRewards() {
        return newUserRewards;
    }

    public void setNewUserRewards(Float newUserRewards) {
        this.newUserRewards = newUserRewards;
    }

    public Float getNewUserTotalRewards() {
        return newUserTotalRewards;
    }

    public void setNewUserTotalRewards(Float newUserTotalRewards) {
        this.newUserTotalRewards = newUserTotalRewards;
    }

    public Float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public List<String>  getTcCardCashBack() {
        return tcCardCashBack;
    }

    public void setTcCardCashBack(List<String>  tcCardCashBack) {
        this.tcCardCashBack = tcCardCashBack;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getExtraMoney() {
        return extraMoney;
    }

    public void setExtraMoney(BigDecimal extraMoney) {
        this.extraMoney = extraMoney;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IslandRewardsPoolNewTimesConfigDTO islandRewardsPoolNewTimesConfigDTO = (IslandRewardsPoolNewTimesConfigDTO) o;
        if (islandRewardsPoolNewTimesConfigDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), islandRewardsPoolNewTimesConfigDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "IslandRewardsPoolNewTimesConfigDTO{" +
            "id=" + id +
            ", platFormId=" + platFormId +
            ", islandRewardsPoolBasicConfigId=" + islandRewardsPoolBasicConfigId +
            ", startSwitch=" + startSwitch +
            ", ifScroll=" + ifScroll +
            ", scrollPeriod=" + scrollPeriod +
            ", periodTimes=" + periodTimes +
            ", times=" + times +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            ", lotteryTime=" + lotteryTime +
            ", gradeId=" + gradeId +
            ", gradeName='" + gradeName + '\'' +
            ", basicMoney=" + basicMoney +
            ", winRatioConfig=" + winRatioConfig +
            ", newUserNum=" + newUserNum +
            ", newUserRewards=" + newUserRewards +
            ", newUserTotalRewards=" + newUserTotalRewards +
            ", totalMoney=" + totalMoney +
            ", updateUserId=" + updateUserId +
            ", createTime=" + createTime +
            ", gradeNames='" + gradeNames + '\'' +
            ", tcCardCashBack=" + tcCardCashBack +
            ", total=" + total +
            ", status=" + status +
            ", extraMoney=" + extraMoney +
            '}';
    }
}
