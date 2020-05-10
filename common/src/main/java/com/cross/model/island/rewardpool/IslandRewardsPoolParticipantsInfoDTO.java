package com.cross.model.island.rewardpool;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@ApiModel(description = "奖金池报名人员信息")
public class IslandRewardsPoolParticipantsInfoDTO implements Serializable {

    private Long id;
    /**
     *平台编号
     */
    @ApiModelProperty(value = "平台编号")
    private Long platFormId;

    /**
     * 奖金池配置ID
     */
    @ApiModelProperty(value = "奖金池配置ID")
    private Long islandRewardsPoolNewTimesConfigId;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 用户ID用户展示
     */
    @ApiModelProperty(value = "用户ID用户展示")
    private String userIdStr;

    /**
     * 小程序用户表id
     */
    @ApiModelProperty(value = "小程序用户表id")
    private Long weappUserId;


    /**
     * 用户头像
     */
    @ApiModelProperty(value = "用户头像")
    private String headPic;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 用户等级
     */
    @ApiModelProperty(value = "用户等级")
    private String userLevel;

    /**
     * 报名时间
     */
    @ApiModelProperty(value = "报名时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime joinTime;

    /**
     * 活动开榜时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime lotteryTime;

    /**
     * 拉入人员数量
     */
    @ApiModelProperty(value = "拉入人员数量")
    private Long invitedNum;

    /**
     * 拉入人员数量排名
     */
    @ApiModelProperty(value = "拉入人员数量排名")
    private Integer rank;

    /**
     * 瓜分金额
     */
    @ApiModelProperty(value = "瓜分金额")
    private Float rewards;

    /**
     * 赏金池活动参加总人数
     */
    @ApiModelProperty(value = "赏金池活动参加总人数")
    private Long totalJoinNum;

    /**
     * 分销总金额
     */
    @ApiModelProperty(value = "分销总金额")
    private Float totalRewards;

    /**
     * 奖励总金额(瓜分金额+分销总金额)
     */
    @ApiModelProperty(value = "奖励总金额(瓜分金额+分销总金额)")
    private Double totalMoney;

    /**
     * 奖励等级
     */
    private Integer level;

    public IslandRewardsPoolParticipantsInfoDTO() {
    }

    public IslandRewardsPoolParticipantsInfoDTO(Long totalJoinNum, Double totalMoney) {
        this.totalJoinNum = totalJoinNum;
        this.totalMoney = totalMoney;
    }

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

    public Long getIslandRewardsPoolNewTimesConfigId() {
        return islandRewardsPoolNewTimesConfigId;
    }

    public void setIslandRewardsPoolNewTimesConfigId(Long islandRewardsPoolNewTimesConfigId) {
        this.islandRewardsPoolNewTimesConfigId = islandRewardsPoolNewTimesConfigId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(LocalDateTime joinTime) {
        this.joinTime = joinTime;
    }

    public LocalDateTime getLotteryTime() {
        return lotteryTime;
    }

    public void setLotteryTime(LocalDateTime lotteryTime) {
        this.lotteryTime = lotteryTime;
    }

    public Long getInvitedNum() {
        return invitedNum;
    }

    public void setInvitedNum(Long invitedNum) {
        this.invitedNum = invitedNum;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Float getRewards() {
        return rewards;
    }

    public void setRewards(Float rewards) {
        this.rewards = rewards;
    }

    public Long getTotalJoinNum() {
        return totalJoinNum;
    }

    public void setTotalJoinNum(Long totalJoinNum) {
        this.totalJoinNum = totalJoinNum;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Long getWeappUserId() {
        return weappUserId;
    }

    public void setWeappUserId(Long weappUserId) {
        this.weappUserId = weappUserId;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public Float getTotalRewards() {
        return totalRewards;
    }

    public void setTotalRewards(Float totalRewards) {
        this.totalRewards = totalRewards;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getUserIdStr() {
        return userIdStr;
    }

    public void setUserIdStr(String userIdStr) {
        this.userIdStr = userIdStr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IslandRewardsPoolParticipantsInfoDTO islandRewardsPoolParticipantsInfoDTO = (IslandRewardsPoolParticipantsInfoDTO) o;
        if (islandRewardsPoolParticipantsInfoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), islandRewardsPoolParticipantsInfoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "IslandRewardsPoolParticipantsInfoDTO{" +
            "id=" + id +
            ", platFormId=" + platFormId +
            ", islandRewardsPoolNewTimesConfigId=" + islandRewardsPoolNewTimesConfigId +
            ", userId=" + userId +
            ", userIdStr='" + userIdStr + '\'' +
            ", weappUserId=" + weappUserId +
            ", headPic='" + headPic + '\'' +
            ", nickName='" + nickName + '\'' +
            ", phone='" + phone + '\'' +
            ", userLevel='" + userLevel + '\'' +
            ", joinTime=" + joinTime +
            ", lotteryTime=" + lotteryTime +
            ", invitedNum=" + invitedNum +
            ", rank=" + rank +
            ", rewards=" + rewards +
            ", totalJoinNum=" + totalJoinNum +
            ", totalRewards=" + totalRewards +
            ", totalMoney=" + totalMoney +
            ", level=" + level +
            '}';
    }
}
