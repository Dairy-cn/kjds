package com.cross.model.dish;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.enumtype.TaoQuanProductType;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.cross.model.DishMerchantInfoVM;
import com.cross.model.enumeration.ShopLimitType;
import com.cross.model.enumeration.ThirdPartyType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * 商品
 */

@Data
public class ShopDish implements Serializable {
    
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
     * 餐盒数量
     */
    private Integer boxNum;
    
    /**
     * 打包盒单价
     */
    private Float boxPrice;
    
    /**
     * 描述
     */
    private String description;
    
    /**
     * 菜品名
     */
    private String dishName;
    
    /**
     * 是否售完    0-未售完，1-售完，创建时请设置为0，否则C端不显示。当isSoldOut=0,而且库存>0时,菜品才可以售卖。
     */
    private Integer isSoldOut;
    
    /**
     * 最小购买数量
     */
    private Integer minOrderCount;
    
    /**
     * 图片id或地址 -非必须
     */
    private String picture;
    
    /**
     * 排序 -非必须
     */
    private Integer sequence;
    
    /**
     * 价格
     */
    private Float price;
    
    /**
     * 单位/规格
     */
    private String unit;
    
    /**
     * 所属类型 1、品牌 2、商户
     */
    private Integer type;
    
    /**
     * 饿了么商品编号
     */
    private Long eleMeDishId;
    
    /**
     * 美团商品编号
     */
    private Long meiTuanDishId;
    
    /**
     * 是否删除
     */
    private Boolean isDelete = Boolean.FALSE;
    
    /**
     * 添加日期
     */
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)
    private Instant addDate;
    
    /**
     * 源编号
     */
    private Long oldDishId;
    
    /**
     * 状态
     */
    private Boolean onSale;
    
    private Set<ShopDishSku> shopDishSkus = new HashSet<>();
    
    private Set<ShopDishAttribute> shopDishAttributes = new HashSet<>();
    
    private ShopDishProductCat shopDishProductCat;
    
    private Long shopDishProductId;
    
    /**
     * 销量
     */
    private Integer saleNum = 0;
    
    /**
     * 销量
     */
    private Integer stock = 0;
    
    /**
     * 菜品的详细信息
     */
    private String content;
    /**
     * 首页图片
     */
    private String homeImage;
    
    /**
     * 活动名称
     */
    private String activityName;
    
    @ApiModelProperty(value = "商品类型 1快递(物流)到家 2外卖配送 4到店消费 8外卖自提 16外卖套餐 32.线上兑换 64扫码点单")
    private Integer productType;
    
    @ApiModelProperty(value = "到店消费使用开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)
    private Instant useStartTime;
    
    @ApiModelProperty(value = "到店消费使用结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)
    private Instant useEndTime;
    
    /**
     * 特惠平台菜品详情的轮播图,多张图片使用逗号分隔
     */
    @ApiModelProperty(value = "特惠平台菜品详情的轮播图")
    private String dishImageUrl;
    
    @ApiModelProperty(value = "自定义分享内容")
    private String shareContent;
    
    @ApiModelProperty(value = "菜品绑定的门店信息")
    private List<DishMerchantInfoVM> dishMerchantInfoVMS;
    
    /**
     * 限购份数
     */
    @ApiModelProperty(value = "限购份数")
    private Integer limitBuyNum;
    
    @ApiModelProperty(value = "产品限购方针：1限购；2不限购")
    private Integer numLimitType;
    
    @ApiModelProperty(value = "商品限购类型：用户限购，订单限购，每日限购")
    private ShopLimitType shopLimitType;
    
    @ApiModelProperty(value = "必选条件 1：根据用餐人数 2：至少1分")
    private Integer mustCondition;
    
    @ApiModelProperty(value = "每人多少份")
    private Integer oneNum;
    
    @ApiModelProperty(value = "置顶时间")
    private Integer topTime;
    
    @ApiModelProperty(value = "入驻通吃岛平台情况：1 未入驻  2 审核中 3 入驻成功 4 入驻失败 5 关闭营业  6关店")
    private Integer enteringInfo;
    
    @ApiModelProperty(value = "申请入驻时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)
    private Instant enteringDate;
    
    @ApiModelProperty(value = "审核时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)
    private Instant reviewDate;
    
    @ApiModelProperty(value = "入驻失败原因")
    private String reason;
    
    @ApiModelProperty(value = "扩展编号")
    private Long linkedNo;
    
    /**
     * 使用须知
     */
    @ApiModelProperty(value = "使用须知")
    private List<String> productDetail;
    
    /**
     * 卡券有效期
     */
    @ApiModelProperty(value = "卡券有效期兑换后 有效天数")
    private Integer productEffectiveDays;
    /**
     * 质保期至
     */
    @ApiModelProperty(value = "质保期至")
    private String productEffectiveInfo;
    
    /**
     * 分销奖励
     */
    @ApiModelProperty(value = "分销奖励")
    private Double reward;
    
    /**
     * 权益商品类型
     */
    @ApiModelProperty(value = "权益商品类型")
    private TaoQuanProductType taoQuanProductType;
    
    /**
     * 第三方类型
     */
    @ApiModelProperty(value = "第三方类型")
    private ThirdPartyType thirdPartyType;
    
    /** 商品上架后不让编辑，添加是否上架字段并设置值 added by wy at 20190906 start*/
    /**
     * 是否已上架
     */
    @ApiModelProperty(value = "是否已上架")
    private Boolean isExist = Boolean.FALSE;
    /**
     * 商品上架后不让编辑，添加是否上架字段并设置值 added by wy at 20190906 end
     */
    
    @ApiModelProperty(value = "菜品编号")
    private String dishCoding;
    
    /**
     * 平台id
     */
    private Long platformId;
    
    
    @ApiModelProperty(value = "若是使用掌控者系统由此值 表示再对方系统中的id值")
    private String thirdNo;
    
    
    /**
     * 运费(单位：元)
     */
    @ApiModelProperty(value = "运费(单位：元)")
    private BigDecimal deliverFee;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShopDish shopDish = (ShopDish) o;
        if (shopDish.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), shopDish.getId());
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
    
    @Override
    public String toString() {
        return "ShopDish{" +
            "id=" + id +
            ", merchantId=" + merchantId +
            ", brandId=" + brandId +
            ", boxNum=" + boxNum +
            ", boxPrice=" + boxPrice +
            ", description='" + description + '\'' +
            ", dishName='" + dishName + '\'' +
            ", isSoldOut=" + isSoldOut +
            ", minOrderCount=" + minOrderCount +
            ", picture='" + picture + '\'' +
            ", sequence=" + sequence +
            ", price=" + price +
            ", unit='" + unit + '\'' +
            ", type=" + type +
            ", shopDishSkus=" + shopDishSkus +
            ", shopDishAttributes=" + shopDishAttributes +
//            ", shopDishProductCat=" + shopDishProductCat +
            ", shopDishProductId=" + shopDishProductId +
            '}';
    }
    
    public Double getReward() {
        return reward;
    }
    
    public void setReward(Double reward) {
        this.reward = reward;
    }
    
    public String getDishCoding() {
        return dishCoding;
    }
    
    public void setDishCoding(String dishCoding) {
        this.dishCoding = dishCoding;
    }
    
    public BigDecimal getDeliverFee() {
        return deliverFee;
    }
    
    public void setDeliverFee(BigDecimal deliverFee) {
        this.deliverFee = deliverFee;
    }
    
    public Long getEleMeDishId() {
        return eleMeDishId;
    }
    
    public void setEleMeDishId(Long eleMeDishId) {
        this.eleMeDishId = eleMeDishId;
    }
    
    public Long getMeiTuanDishId() {
        return meiTuanDishId;
    }
    
    public void setMeiTuanDishId(Long meiTuanDishId) {
        this.meiTuanDishId = meiTuanDishId;
    }
    
    public String getThirdNo() {
        return thirdNo;
    }
    
    public void setThirdNo(String thirdNo) {
        this.thirdNo = thirdNo;
    }
    
    
    public Boolean getIsDelete() {
        return isDelete;
    }
    
    public void setIsDelete(Boolean delete) {
        isDelete = delete;
    }
    
    public Instant getAddDate() {
        return addDate;
    }
    
    public void setAddDate(Instant addDate) {
        this.addDate = addDate;
    }
    
    public Long getOldDishId() {
        return oldDishId;
    }
    
    public void setOldDishId(Long oldDishId) {
        this.oldDishId = oldDishId;
    }
    
    public Boolean getOnSale() {
        return onSale;
    }
    
    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }
    
    public String getShareContent() {
        return shareContent;
    }
    
    public void setShareContent(String shareContent) {
        this.shareContent = shareContent;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getMerchantId() {
        return merchantId;
    }
    
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }
    
    public Long getBrandId() {
        return brandId;
    }
    
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
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
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getDishName() {
        return dishName;
    }
    
    public void setDishName(String dishName) {
        this.dishName = dishName;
    }
    
    public Integer getIsSoldOut() {
        return isSoldOut;
    }
    
    public void setIsSoldOut(Integer isSoldOut) {
        this.isSoldOut = isSoldOut;
    }
    
    public Integer getMinOrderCount() {
        return minOrderCount;
    }
    
    public void setMinOrderCount(Integer minOrderCount) {
        this.minOrderCount = minOrderCount;
    }
    
    public String getPicture() {
        return picture;
    }
    
    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    public Integer getSequence() {
        return sequence;
    }
    
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
    
    public Float getPrice() {
        return price;
    }
    
    public void setPrice(Float price) {
        this.price = price;
    }
    
    public String getUnit() {
        return unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    public Integer getType() {
        return type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }
    
    public Boolean getDelete() {
        return isDelete;
    }
    
    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
    
    public Set<ShopDishSku> getShopDishSkus() {
        return shopDishSkus;
    }
    
    public void setShopDishSkus(Set<ShopDishSku> shopDishSkus) {
        this.shopDishSkus = shopDishSkus;
    }
    
    public Set<ShopDishAttribute> getShopDishAttributes() {
        return shopDishAttributes;
    }
    
    public void setShopDishAttributes(Set<ShopDishAttribute> shopDishAttributes) {
        this.shopDishAttributes = shopDishAttributes;
    }
    
    public ShopDishProductCat getShopDishProductCat() {
        return shopDishProductCat;
    }
    
    public void setShopDishProductCat(ShopDishProductCat shopDishProductCat) {
        this.shopDishProductCat = shopDishProductCat;
    }
    
    public Long getShopDishProductId() {
        return shopDishProductId;
    }
    
    public void setShopDishProductId(Long shopDishProductId) {
        this.shopDishProductId = shopDishProductId;
    }
    
    public Integer getSaleNum() {
        return saleNum;
    }
    
    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }
    
    public Integer getStock() {
        return stock;
    }
    
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getHomeImage() {
        return homeImage;
    }
    
    public void setHomeImage(String homeImage) {
        this.homeImage = homeImage;
    }
    
    public String getActivityName() {
        return activityName;
    }
    
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
    
    public Integer getProductType() {
        return productType;
    }
    
    public void setProductType(Integer productType) {
        this.productType = productType;
    }
    
    public Instant getUseStartTime() {
        return useStartTime;
    }
    
    public void setUseStartTime(Instant useStartTime) {
        this.useStartTime = useStartTime;
    }
    
    public Instant getUseEndTime() {
        return useEndTime;
    }
    
    public void setUseEndTime(Instant useEndTime) {
        this.useEndTime = useEndTime;
    }
    
    public String getDishImageUrl() {
        return dishImageUrl;
    }
    
    public void setDishImageUrl(String dishImageUrl) {
        this.dishImageUrl = dishImageUrl;
    }
    
    public List<DishMerchantInfoVM> getDishMerchantInfoVMS() {
        return dishMerchantInfoVMS;
    }
    
    public void setDishMerchantInfoVMS(List<DishMerchantInfoVM> dishMerchantInfoVMS) {
        this.dishMerchantInfoVMS = dishMerchantInfoVMS;
    }
    
    public Integer getLimitBuyNum() {
        return limitBuyNum;
    }
    
    public void setLimitBuyNum(Integer limitBuyNum) {
        this.limitBuyNum = limitBuyNum;
    }
    
    public Integer getNumLimitType() {
        return numLimitType;
    }
    
    public void setNumLimitType(Integer numLimitType) {
        this.numLimitType = numLimitType;
    }
    
    public ShopLimitType getShopLimitType() {
        return shopLimitType;
    }
    
    public void setShopLimitType(ShopLimitType shopLimitType) {
        this.shopLimitType = shopLimitType;
    }
    
    public Integer getMustCondition() {
        return mustCondition;
    }
    
    public void setMustCondition(Integer mustCondition) {
        this.mustCondition = mustCondition;
    }
    
    public Integer getOneNum() {
        return oneNum;
    }
    
    public void setOneNum(Integer oneNum) {
        this.oneNum = oneNum;
    }
    
    public Integer getTopTime() {
        return topTime;
    }
    
    public void setTopTime(Integer topTime) {
        this.topTime = topTime;
    }
    
    public Integer getEnteringInfo() {
        return enteringInfo;
    }
    
    public void setEnteringInfo(Integer enteringInfo) {
        this.enteringInfo = enteringInfo;
    }
    
    public Instant getEnteringDate() {
        return enteringDate;
    }
    
    public void setEnteringDate(Instant enteringDate) {
        this.enteringDate = enteringDate;
    }
    
    public Instant getReviewDate() {
        return reviewDate;
    }
    
    public void setReviewDate(Instant reviewDate) {
        this.reviewDate = reviewDate;
    }
    
    public String getReason() {
        return reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    public Long getLinkedNo() {
        return linkedNo;
    }
    
    public void setLinkedNo(Long linkedNo) {
        this.linkedNo = linkedNo;
    }
    
    public List<String> getProductDetail() {
        return productDetail;
    }
    
    public void setProductDetail(List<String> productDetail) {
        this.productDetail = productDetail;
    }
    
    public Integer getProductEffectiveDays() {
        return productEffectiveDays;
    }
    
    public void setProductEffectiveDays(Integer productEffectiveDays) {
        this.productEffectiveDays = productEffectiveDays;
    }
    
    public String getProductEffectiveInfo() {
        return productEffectiveInfo;
    }
    
    public void setProductEffectiveInfo(String productEffectiveInfo) {
        this.productEffectiveInfo = productEffectiveInfo;
    }
    
    public TaoQuanProductType getTaoQuanProductType() {
        return taoQuanProductType;
    }
    
    public void setTaoQuanProductType(TaoQuanProductType taoQuanProductType) {
        this.taoQuanProductType = taoQuanProductType;
    }
    
    public ThirdPartyType getThirdPartyType() {
        return thirdPartyType;
    }
    
    public void setThirdPartyType(ThirdPartyType thirdPartyType) {
        this.thirdPartyType = thirdPartyType;
    }
    
    public Boolean getExist() {
        return isExist;
    }
    
    public void setExist(Boolean exist) {
        isExist = exist;
    }
    
    public Long getPlatformId() {
        return platformId;
    }
    
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }
}
