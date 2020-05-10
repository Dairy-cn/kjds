package com.cross.model;

import java.io.Serializable;

/**
 * @Author DuYuLiang on 2018/5/23.
 */
public class DistributorRuleVM implements Serializable {
    /**
     * 入伙费
     */
    private Double joinFee;

    /**
     * 加入口号
     */
    private String slogan;

    public Double getJoinFee() {
        return joinFee;
    }

    public void setJoinFee(Double joinFee) {
        this.joinFee = joinFee;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }
}
