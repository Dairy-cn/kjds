package com.cross.model.island.freelunch;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * 霸王餐活动中奖概率配置信息
 */
@ApiModel(description = "霸王餐活动中奖概率配置信息")
public class IslandFreeLunchWinRatioConfigVM {
    /**
     * 对应等级id
     */
    @ApiModelProperty(value = "对应等级id")
    private Long gradeId;
    /**
     * 等级
     */
    @ApiModelProperty(value = "等级")
    private Integer grade;
    /**
     * 对应报名门槛的中奖概率(正整数)
     */
    @ApiModelProperty(value = "对应报名门槛的中奖概率(正整数)")
    private Integer winRatio;

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getWinRatio() {
        return winRatio;
    }

    public void setWinRatio(Integer winRatio) {
        this.winRatio = winRatio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IslandFreeLunchWinRatioConfigVM that = (IslandFreeLunchWinRatioConfigVM) o;
        return Objects.equals(gradeId, that.gradeId) &&
            Objects.equals(winRatio, that.winRatio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gradeId, winRatio);
    }

    @Override
    public String toString() {
        return "IslandFreeLunchWinRatioConfigVM{" +
            "gradeId=" + gradeId +
            ", grade=" + grade +
            ", winRatio=" + winRatio +
            '}';
    }
}
