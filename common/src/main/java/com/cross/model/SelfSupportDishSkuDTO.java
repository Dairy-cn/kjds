package com.cross.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.cross.model.dish.DishSkuPackageInfoVM;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the SelfSupportDishSku entity.
 */
public class SelfSupportDishSkuDTO implements Serializable {

    private Long id;

    private Long dishId;

    private Integer boxNum;

    private Float boxPrice;

    private Long merchantId;

    private Float price;

    private Integer stock;

    private String availableTimes;

    private Long catId;

    private String spec;

    private Boolean deleteFlag = Boolean.FALSE;

    /**
     * 商品规格图片
     */
    @ApiModelProperty(value = "商品规格图片")
    private String specImageUrl;

    /**
     * 最大库存
     */
    private Integer maxStock;

    /**
     * 是否每日重置
     */
    private Boolean dayReset = Boolean.FALSE;

    private Integer saleNum;

    /**
     * 活动价
     */
    private Double activityPrice;
    /**
     * 活动id
     */
    private Long activityId;
    /**
     * 活动类型
     */
    private Integer activityType;

    /**
     * 是否免配送
     */
    private Boolean freeSipping;

    /**
     * 是否免餐盒费
     */
    private Boolean freeBoxPrice;
    /**
     * 秒杀活动每天开始时间
     */
    private String dayStartTime;

    /**
     * 每日人均限购
     */
    private Integer peopleRestriction = 0;

    /**
     * 每单限购
     */
    private Integer orderRestriction = 0;

    /**
     * 每日限购
     */
    private Integer dayCount = 0;

    /**
     * 每日销售的分数
     */
    private Integer saleCount = 0;

    /**
     * 每天活动开始时的时间戳
     */
    private Long dayStartTimeStr;
    /**
     * 折扣率
     */
    private Double rebate;
    /**
     * 活动结束时间
     */
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant activityEndTime;

    /**
     * 和自营渠道的菜品规格进行关联
     */
    @ApiModelProperty(value = "外部菜品编码")
    private String externaSkuNo;

    @ApiModelProperty(value = "原价（虚拟价格）")
    private BigDecimal originalPrice;

    @ApiModelProperty(value = "虚拟销售数量")
    private Integer initNum;

    /**
     * 是否仅以会员价购买
     */
    @ApiModelProperty(value = "是否仅以会员价购买 ")
    private Boolean limitMemberPrice;


    /**
     * 会员价
     */
    @ApiModelProperty(value = "会员价")
    private BigDecimal memberPice;

    /**
     * 成本
     */
    private Double cost;

    @ApiModelProperty(value = "规格描述--规格套餐信息")
    private List<DishSkuPackageInfoVM> skuPackageInfoList;

    private String thirdNo;

    public String getThirdNo() {
        return thirdNo;
    }

    public void setThirdNo(String thirdNo) {
        this.thirdNo = thirdNo;
    }

    public List<DishSkuPackageInfoVM> getSkuPackageInfoList() {
        return skuPackageInfoList;
    }

    public void setSkuPackageInfoList(List<DishSkuPackageInfoVM> skuPackageInfoList) {
        this.skuPackageInfoList = skuPackageInfoList;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getExternaSkuNo() {
        return externaSkuNo;
    }

    public void setExternaSkuNo(String externaSkuNo) {
        this.externaSkuNo = externaSkuNo;
    }

    public Instant getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(Instant activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    public Double getRebate() {
        return rebate;
    }

    public void setRebate(Double rebate) {
        this.rebate = rebate;
    }

    public Long getDayStartTimeStr() {
        return dayStartTimeStr;
    }

    public void setDayStartTimeStr(Long dayStartTimeStr) {
        this.dayStartTimeStr = dayStartTimeStr;
    }

    public Integer getPeopleRestriction() {
        return peopleRestriction;
    }

    public void setPeopleRestriction(Integer peopleRestriction) {
        this.peopleRestriction = peopleRestriction;
    }

    public Integer getOrderRestriction() {
        return orderRestriction;
    }

    public void setOrderRestriction(Integer orderRestriction) {
        this.orderRestriction = orderRestriction;
    }

    public Integer getDayCount() {
        return dayCount;
    }

    public void setDayCount(Integer dayCount) {
        this.dayCount = dayCount;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public String getDayStartTime() {
        return dayStartTime;
    }

    public void setDayStartTime(String dayStartTime) {
        this.dayStartTime = dayStartTime;
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

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
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

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public Integer getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Integer maxStock) {
        this.maxStock = maxStock;
    }

    public Boolean getDayReset() {
        return dayReset;
    }

    public void setDayReset(Boolean dayReset) {
        this.dayReset = dayReset;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public Integer getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(Integer boxNum) {
        this.boxNum = boxNum;
    }

    public Float getBoxPrice() {
        return boxPrice;
    }

    public void setBoxPrice(Float boxPrice) {
        this.boxPrice = boxPrice;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getAvailableTimes() {
        return availableTimes;
    }

    public void setAvailableTimes(String availableTimes) {
        this.availableTimes = availableTimes;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public Boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public String getSpecImageUrl() {
        return specImageUrl;
    }

    public void setSpecImageUrl(String specImageUrl) {
        this.specImageUrl = specImageUrl;
    }

    public Boolean getLimitMemberPrice() {
        return limitMemberPrice;
    }

    public void setLimitMemberPrice(Boolean limitMemberPrice) {
        this.limitMemberPrice = limitMemberPrice;
    }

    public BigDecimal getMemberPice() {
        return memberPice;
    }

    public void setMemberPice(BigDecimal memberPice) {
        this.memberPice = memberPice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SelfSupportDishSkuDTO selfSupportDishSkuDTO = (SelfSupportDishSkuDTO) o;
        if (selfSupportDishSkuDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), selfSupportDishSkuDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SelfSupportDishSkuDTO{" +
            "id=" + id +
            ", dishId=" + dishId +
            ", boxNum=" + boxNum +
            ", boxPrice=" + boxPrice +
            ", merchantId=" + merchantId +
            ", price=" + price +
            ", stock=" + stock +
            ", availableTimes='" + availableTimes + '\'' +
            ", catId=" + catId +
            ", spec='" + spec + '\'' +
            ", deleteFlag=" + deleteFlag +
            ", specImageUrl='" + specImageUrl + '\'' +
            ", maxStock=" + maxStock +
            ", dayReset=" + dayReset +
            ", saleNum=" + saleNum +
            ", activityPrice=" + activityPrice +
            ", activityId=" + activityId +
            ", activityType=" + activityType +
            ", freeSipping=" + freeSipping +
            ", freeBoxPrice=" + freeBoxPrice +
            ", dayStartTime='" + dayStartTime + '\'' +
            ", peopleRestriction=" + peopleRestriction +
            ", orderRestriction=" + orderRestriction +
            ", dayCount=" + dayCount +
            ", saleCount=" + saleCount +
            ", dayStartTimeStr=" + dayStartTimeStr +
            ", rebate=" + rebate +
            ", activityEndTime=" + activityEndTime +
            ", externaSkuNo='" + externaSkuNo + '\'' +
            ", originalPrice=" + originalPrice +
            ", initNum=" + initNum +
            ", cost=" + cost +
            ", skuPackageInfoList=" + skuPackageInfoList +
            '}';
    }

    public Integer getInitNum() {
        return initNum;
    }

    public void setInitNum(Integer initNum) {
        this.initNum = initNum;
    }
}
