package com.cross.model;

/**
 * 帮砍用户商品砍价区间设置
 */
public class BargainIntervalVM {

    /**
     * 价格下限
     */
    private Double priceLowerLimit = 0d;
    /**
     * 砍价的上限
     */
    private Double bargainUpperLimit = 0d;
    /**
     * 砍价的下限
     */
    private Double bargainLowerLimit = 0d;

    public Double getPriceLowerLimit() {
        return priceLowerLimit;
    }

    public void setPriceLowerLimit(Double priceLowerLimit) {
        this.priceLowerLimit = priceLowerLimit;
    }

    public Double getBargainUpperLimit() {
        return bargainUpperLimit;
    }

    public void setBargainUpperLimit(Double bargainUpperLimit) {
        this.bargainUpperLimit = bargainUpperLimit;
    }

    public Double getBargainLowerLimit() {
        return bargainLowerLimit;
    }

    public void setBargainLowerLimit(Double bargainLowerLimit) {
        this.bargainLowerLimit = bargainLowerLimit;
    }
}
