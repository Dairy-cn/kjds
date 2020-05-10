package com.cross.model.dish;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * 商品规格
 */
public class ShopDishSku implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 商户ID
     */
    private Long merchantId;

    /**
     * 品牌ID
     */
    private Long brandId;

    /**
     * 价格
     */
    private Float price;

    /**
     * 规格
     */
    private String spec;

    /**
     * 商品规格图片
     */
    @ApiModelProperty(value = "商品规格图片")
    private String specImageUrl;

    /**
     * 库存
     */
    private Double stock;

    /**
     * 餐盒数量
     */
    private Integer boxNum;

    /**
     * 打包盒单价
     */
    private Float boxPrice;

    /**
     * 所属类型 1、品牌 2、商户
     */
    private Integer type;

    private ShopDish shopDish;

    /**
     * 商品包ID
     */
    private Long shopDishProductId;

    /**
     * 商品包ID
     */
    private Long shopDishProductCatId;

    /**
     * 饿了么商品规格编号
     */
    private Long eleMeSpecId;

    /**
     * 美团商品规格编号
     */
    private Long meiTuanSpecId;

    /**
     * 成本
     */
    private Double cost;

    /**
     * 是否删除
     */
    private Boolean isDelete;

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
     * 菜品id
     */
    private Long dishId;

    @ApiModelProperty(value = "原价（虚拟价格）")
    private BigDecimal originalPrice;

    /**
     * 销量
     */
    @ApiModelProperty(value = "销量")
    private Integer saleNum;

    /**
     * 虚拟销量
     */
    @ApiModelProperty(value = "虚拟销量")
    private Integer initNum;

    /**
     * 三方扩展编号
     */
    @ApiModelProperty(value = "三方扩展编号")
    private String externaSkuNo;
    
    /**
     * 是否上架
     * */
    @ApiModelProperty(value = "是否上架")
    private Boolean isExist = Boolean.TRUE;

    
    /**
     * 是否仅以会员价购买
     * */
    @ApiModelProperty(value = "是否仅以会员价购买 ")
    private Boolean limitMemberPrice ;
    
    
    /**
     * 会员价
     * */
    @ApiModelProperty(value = "会员价")
    private BigDecimal memberPrice;
    

    @ApiModelProperty(value = "规格套餐信息")
    private List<DishSkuPackageInfoVM> skuPackageInfoList;

    @ApiModelProperty(value = "若是使用掌控者系统由此值 表示再对方系统中的id值")
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
    
    public Boolean getExist() {
        return isExist;
    }
    
    public void setExist(Boolean exist) {
        isExist = exist;
    }
    
    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
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

    public Double getActivityPrice() {
        return activityPrice;
    }

    public void setActivityPrice(Double activityPrice) {
        this.activityPrice = activityPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopDishProductId() {
        return shopDishProductId;
    }

    public void setShopDishProductId(Long shopDishProductId) {
        this.shopDishProductId = shopDishProductId;
    }

    public ShopDishSku shopDishProductId(Long shopDishProductId) {
        this.shopDishProductId = shopDishProductId;
        return this;
    }

    public Long getShopDishProductCatId() {
        return shopDishProductCatId;
    }

    public void setShopDishProductCatId(Long shopDishProductCatId) {
        this.shopDishProductCatId = shopDishProductCatId;
    }

    public ShopDishSku shopDishProductCatId(Long shopDishProductCatId) {
        this.shopDishProductCatId = shopDishProductCatId;
        return this;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public ShopDishSku merchantId(Long merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public ShopDishSku brandId(Long brandId) {
        this.brandId = brandId;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public ShopDishSku price(Float price) {
        this.price = price;
        return this;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public ShopDishSku spec(String spec) {
        this.spec = spec;
        return this;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public ShopDishSku stock(Double stock) {
        this.stock = stock;
        return this;
    }

    public Integer getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(Integer boxNum) {
        this.boxNum = boxNum;
    }

    public ShopDishSku boxNum(Integer boxNum) {
        this.boxNum = boxNum;
        return this;
    }

    public Float getBoxPrice() {
        return boxPrice;
    }

    public void setBoxPrice(Float boxPrice) {
        this.boxPrice = boxPrice;
    }

    public ShopDishSku boxPrice(Float boxPrice) {
        this.boxPrice = boxPrice;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public ShopDishSku type(Integer type) {
        this.type = type;
        return this;
    }

    public ShopDish getShopDish() {
        return shopDish;
    }

    public void setShopDish(ShopDish shopDish) {
        this.shopDish = shopDish;
    }

    public ShopDishSku shopDish(ShopDish shopDish) {
        this.shopDish = shopDish;
        return this;
    }

    public String getSpecImageUrl() {
        return specImageUrl;
    }
    public ShopDishSku specImageUrl(String specImageUrl) {
        this.specImageUrl = specImageUrl;
        return this;
    }

    public void setSpecImageUrl(String specImageUrl) {
        this.specImageUrl = specImageUrl;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
    
    public Boolean getLimitMemberPrice() {
        return limitMemberPrice;
    }
    
    public void setLimitMemberPrice(Boolean limitMemberPrice) {
        this.limitMemberPrice = limitMemberPrice;
    }
    
    public BigDecimal getMemberPrice() {
        return memberPrice;
    }
    
    public void setMemberPrice(BigDecimal memberPrice) {
        this.memberPrice = memberPrice;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShopDishSku shopDishSku = (ShopDishSku) o;
        if (shopDishSku.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), shopDishSku.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ShopDishSku{" +
            "id=" + getId() +
            ", merchantId='" + getMerchantId() + "'" +
            ", brandId='" + getBrandId() + "'" +
            ", price='" + getPrice() + "'" +
            ", spec='" + getSpec() + "'" +
            ", stock='" + getStock() + "'" +
            ", boxNum='" + getBoxNum() + "'" +
            ", boxPrice='" + getBoxPrice() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }

    public Long getEleMeSpecId() {
        return eleMeSpecId;
    }

    public void setEleMeSpecId(Long eleMeSpecId) {
        this.eleMeSpecId = eleMeSpecId;
    }

    public Long getMeiTuanSpecId() {
        return meiTuanSpecId;
    }

    public void setMeiTuanSpecId(Long meiTuanSpecId) {
        this.meiTuanSpecId = meiTuanSpecId;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean delete) {
        isDelete = delete;
    }

    public Integer getInitNum() {
        return initNum;
    }

    public void setInitNum(Integer initNum) {
        this.initNum = initNum;
    }

    public String getExternaSkuNo() {
        return externaSkuNo;
    }

    public void setExternaSkuNo(String externaSkuNo) {
        this.externaSkuNo = externaSkuNo;
    }
}
