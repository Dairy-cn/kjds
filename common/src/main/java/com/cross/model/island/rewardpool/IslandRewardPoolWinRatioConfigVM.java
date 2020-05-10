package com.cross.model.island.rewardpool;
import io.swagger.annotations.ApiModel;

import java.util.Objects;

/**
 * 霸王餐活动中奖概率配置信息
 */
@ApiModel(description = "霸王餐活动中奖概率配置信息")
public class IslandRewardPoolWinRatioConfigVM {
    /**
     * 奖励等级
     */
    private Integer level;
    /**
     * 奖励等级对应开始名次
     */
    private Integer startRank;
    /**
     * 奖励等级对应结束名次
     */
    private Integer endRank;

    /**
     * 获得奖励比例 最多为两位小数
     */
    private Float rewardRatio;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStartRank() {
        return startRank;
    }

    public void setStartRank(Integer startRank) {
        this.startRank = startRank;
    }

    public Integer getEndRank() {
        return endRank;
    }

    public void setEndRank(Integer endRank) {
        this.endRank = endRank;
    }

    public Float getRewardRatio() {
        return rewardRatio;
    }

    public void setRewardRatio(Float rewardRatio) {
        this.rewardRatio = rewardRatio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IslandRewardPoolWinRatioConfigVM that = (IslandRewardPoolWinRatioConfigVM) o;
        return Objects.equals(level, that.level) &&
            Objects.equals(startRank, that.startRank) &&
            Objects.equals(endRank, that.endRank) &&
            Objects.equals(rewardRatio, that.rewardRatio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, startRank, endRank, rewardRatio);
    }

    @Override
    public String toString() {
        return "IslandRewardPoolWinRatioConfigVM{" +
            "level=" + level +
            ", startRank=" + startRank +
            ", endRank=" + endRank +
            ", rewardRatio=" + rewardRatio +
            '}';
    }
}
