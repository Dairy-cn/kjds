package com.cross.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author DuYuLiang on 2018/5/23.
 */
public class SupplierRateVM implements Serializable {
    /**
     * 自身购买获得收益
     */
    @ApiModelProperty("自身购买获得收益")
    private Double selfReceiveReward;

    /**
     * 师傅获取报酬
     */
    @ApiModelProperty("师傅获取报酬")
    private Double parentReceiveReward;

    /**
     * 师爷获取报酬
     */
    @ApiModelProperty("师爷获取报酬")
    private Double parentParentReceiveReward;

    /**
     * 奖励类型 1 或 null 比例 2 固定
     */
    @ApiModelProperty(" 奖励类型 1 或 null 比例 2 固定")
    private Integer rewardType;

    public Double getParentReceiveReward() {
        return parentReceiveReward;
    }

    public void setParentReceiveReward(Double parentReceiveReward) {
        this.parentReceiveReward = parentReceiveReward;
    }

    public Double getParentParentReceiveReward() {
        return parentParentReceiveReward;
    }

    public void setParentParentReceiveReward(Double parentParentReceiveReward) {
        this.parentParentReceiveReward = parentParentReceiveReward;
    }

    public Double getSelfReceiveReward() {
        return selfReceiveReward;
    }

    public void setSelfReceiveReward(Double selfReceiveReward) {
        this.selfReceiveReward = selfReceiveReward;
    }

    public Integer getRewardType() {
        return rewardType;
    }

    public void setRewardType(Integer rewardType) {
        this.rewardType = rewardType;
    }
}
