package com.cross.model;

public class OrderActivity {
    /**
     * 活动编号
     */
    private Long activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动类型
     */
    private Integer activityType;

    /**
     * 活动价值 : 活动总优惠
     */
    private Double activityPrice;
    /**
     * 菜品规格编码
     */
    private Long skuId;

    /**
     * 是否免配送
     */
    private Boolean freeSipping = Boolean.FALSE;

    /**
     * 是否免餐盒费
     */
    private Boolean freeBoxPrice = Boolean.FALSE;

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

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public Double getActivityPrice() {
        return activityPrice;
    }

    public void setActivityPrice(Double activityPrice) {
        this.activityPrice = activityPrice;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Boolean getFreeSipping() {
        return freeSipping;
    }

    public void setFreeSipping(Boolean freeSipping) {
        this.freeSipping = freeSipping;
    }

    public Boolean getFreeBoxPrice() {
        return freeBoxPrice;
    }

    public void setFreeBoxPrice(Boolean freeBoxPrice) {
        this.freeBoxPrice = freeBoxPrice;
    }
}
