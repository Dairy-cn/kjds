package com.cross.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.cross.model.enumeration.ShopShelfState;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * 砍价活动
 */
public class BargainModel implements Serializable {

    private Long id;

    /**
     * 平台id
     */
    private Long platformId;

    /**
     * 品牌编号
     */
    private Long brandId;

    /**
     * 商户编号
     */
    private Long merchantId;

    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 开始日期
     */
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant startDate;
    /**
     * 产品SKU编号
     */
    private Long productSkuId;

    /**
     * 砍价成功价
     */
    private Double bargainPrice;

    /**
     * 添加日期
     */
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant addDate;

    /**
     * 帮砍用户商品砍价区间
     */
    private List<BargainIntervalVM> bargainInterval;

    /**
     * 自己砍价的上限
     */
    private Double  selfBargainUpperLimit;
    /**
     * 自己砍价的下限
     */
    private Double selfBargainLowerLimit;

    /**
     * 半径
     */
    private Double radius;

    /**
     * 购买人数
     */
    private Integer buyNumber;

    /**
     * 活动类型
     */
    private Integer activityType;

    /**
     * 商品上架状态：未上架：UNSHELF,上架：SHELF ,下架：OBTAINED
     */
    private ShopShelfState shelfState;

    /**
     * 活动名称
     */
    private String bargainName;
    /**
     * 图片url
     */
    private String imageUrl;
    /**
     * 商品数量
     */
    private Integer shopNumber;

    /**
     * 置顶：0 ：未置顶   1：置顶
     */
    private Integer topNum;
    /**
     * 置顶时间
     */
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant topDate;

    public Integer getTopNum() {
        return topNum;
    }

    public void setTopNum(Integer topNum) {
        this.topNum = topNum;
    }

    public Instant getTopDate() {
        return topDate;
    }

    public void setTopDate(Instant topDate) {
        this.topDate = topDate;
    }

    public String getBargainName() {
        return bargainName;
    }

    public void setBargainName(String bargainName) {
        this.bargainName = bargainName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getShopNumber() {
        return shopNumber;
    }

    public void setShopNumber(Integer shopNumber) {
        this.shopNumber = shopNumber;
    }

    public ShopShelfState getShelfState() {
        return shelfState;
    }

    public void setShelfState(ShopShelfState shelfState) {
        this.shelfState = shelfState;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
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

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Long getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    public Double getBargainPrice() {
        return bargainPrice;
    }

    public void setBargainPrice(Double bargainPrice) {
        this.bargainPrice = bargainPrice;
    }

    public Instant getAddDate() {
        return addDate;
    }

    public void setAddDate(Instant addDate) {
        this.addDate = addDate;
    }

    public List<BargainIntervalVM> getBargainInterval() {
        return bargainInterval;
    }

    public void setBargainInterval(List<BargainIntervalVM> bargainInterval) {
        this.bargainInterval = bargainInterval;
    }

    public Double getSelfBargainUpperLimit() {
        return selfBargainUpperLimit;
    }

    public void setSelfBargainUpperLimit(Double selfBargainUpperLimit) {
        this.selfBargainUpperLimit = selfBargainUpperLimit;
    }

    public Double getSelfBargainLowerLimit() {
        return selfBargainLowerLimit;
    }

    public void setSelfBargainLowerLimit(Double selfBargainLowerLimit) {
        this.selfBargainLowerLimit = selfBargainLowerLimit;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Integer getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BargainModel that = (BargainModel) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BargainModel{" +
            "id=" + id +
            ", platformId=" + platformId +
            ", brandId=" + brandId +
            ", merchantId=" + merchantId +
            ", userId=" + userId +
            ", startDate=" + startDate +
            ", productSkuId=" + productSkuId +
            ", bargainPrice=" + bargainPrice +
            ", addDate=" + addDate +
            ", bargainInterval='" + bargainInterval + '\'' +
            ", selfBargainUpperLimit=" + selfBargainUpperLimit +
            ", selfBargainLowerLimit=" + selfBargainLowerLimit +
            ", radius=" + radius +
            ", buyNumber=" + buyNumber +
            ", activityType=" + activityType +
            ", shelfState=" + shelfState +
            ", bargainName='" + bargainName + '\'' +
            ", imageUrl='" + imageUrl + '\'' +
            ", shopNumber=" + shopNumber +
            '}';
    }
}
