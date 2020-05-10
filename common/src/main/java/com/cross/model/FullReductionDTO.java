package com.cross.model;

import java.io.Serializable;

public class FullReductionDTO implements Serializable {

    /**
     * 满多少钱
     */
    private Double fullMoney = 0d;

    /**
     * 减多少钱
     */
    private double cutMoney = 0d;

    public Double getFullMoney() {
        return fullMoney;
    }

    public void setFullMoney(Double fullMoney) {
        this.fullMoney = fullMoney;
    }

    public double getCutMoney() {
        return cutMoney;
    }

    public void setCutMoney(double cutMoney) {
        this.cutMoney = cutMoney;
    }
}
