package com.cross.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.enumtype.TaoQuanProductType;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.cross.model.enumeration.ShopLimitType;
import com.cross.model.enumeration.ThirdPartyType;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the SelfSupportDish entity.
 */
public class SelfSupportDishDTO implements Serializable {

    private Long id;

    private Integer boxNum;

    private Float boxPrice;

    private String categoryName;

    private String description;

    private String dishName;

    private Integer isSoldOut = 0;

    private Integer minOrderCount;

    @ApiModelProperty(value = "菜品图片")
    private String picture;

    private Integer sequence;

    private Float price;

    private Long catId;

    private Boolean deleteFlag = Boolean.FALSE;

    private Long merchantId;

    private Long brandId;

    @ApiModelProperty(value = "用户(商户)id")
    private Long userId;

    List<SelfSupportDishPropertyDTO> propertyList;

    List<SelfSupportDishSkuDTO> skuBasesList;

    private String content;
    /**
     * 首页图片
     */
    private String homeImage;
    /**
     * 活动名称
     */
    private String activityName;

    @ApiModelProperty(value = "商品类型 1快递(物流)到家 2外卖配送(点餐包含自提) 4到店消费(特惠) 8外卖自提 16外卖套餐 32.线上兑换")
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

   /* @ApiModelProperty(value = "品牌菜品分类id，商品池分类id")
    private Long brandDishCatId;*/

   @ApiModelProperty(value = "菜品绑定的门店信息")
    private List<DishMerchantInfoVM> dishMerchantInfoVMS;

    @ApiModelProperty(value = "第三方类型")
    private ThirdPartyType thirdPartyType;

    @ApiModelProperty(value = "乐玩商品海报图")
    private String productPoster;

    @ApiModelProperty(value = "乐玩爆款组合图片(多图逗号分隔)")
    private String productCompic;

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
    private Integer enteringInfo = 1;

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

    /**使用须知 */
    @ApiModelProperty(value = "使用须知")
    private List<String> productDetail;

    /**卡券有效期 */
    @ApiModelProperty(value = "卡券有效期兑换后 有效天数")
    private Integer productEffectiveDays;

    /**
     * 质保期至
     * */
    @ApiModelProperty(value = "质保期至")
    private String productEffectiveInfo;

    /**
     * 权益商品类型
     * */
    @ApiModelProperty(value = "权益商品类型")
    private TaoQuanProductType taoQuanProductType;

    @ApiModelProperty(value = "分销奖励")
    private Double reward;

    @ApiModelProperty(value = "商品售卖开始时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant saleStartTime;

    @ApiModelProperty(value = "商品售卖结束时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant saleEndTime;

    @ApiModelProperty(value = "若是使用掌控者系统由此值 表示再对方系统中的id值")
    private String  thirdNo;

    public String getThirdNo() {
        return thirdNo;
    }

    public void setThirdNo(String thirdNo) {
        this.thirdNo = thirdNo;
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

    public Integer getTopTime() {
        return topTime;
    }

    public void setTopTime(Integer topTime) {
        this.topTime = topTime;
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

    public String getProductPoster() {
        return productPoster;
    }

    public void setProductPoster(String productPoster) {
        this.productPoster = productPoster;
    }

    public String getProductCompic() {
        return productCompic;
    }

    public void setProductCompic(String productCompic) {
        this.productCompic = productCompic;
    }

    public ThirdPartyType getThirdPartyType() {
        return thirdPartyType;
    }

    public void setThirdPartyType(ThirdPartyType thirdPartyType) {
        this.thirdPartyType = thirdPartyType;
    }

    public List<DishMerchantInfoVM> getDishMerchantInfoVMS() {
        return dishMerchantInfoVMS;
    }

    public void setDishMerchantInfoVMS(List<DishMerchantInfoVM> dishMerchantInfoVMS) {
        this.dishMerchantInfoVMS = dishMerchantInfoVMS;
    }

    public String getDishImageUrl() {
        return dishImageUrl;
    }

    public void setDishImageUrl(String dishImageUrl) {
        this.dishImageUrl = dishImageUrl;
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

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getHomeImage() {
        return homeImage;
    }

    public void setHomeImage(String homeImage) {
        this.homeImage = homeImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public List<SelfSupportDishPropertyDTO> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<SelfSupportDishPropertyDTO> propertyList) {
        this.propertyList = propertyList;
    }

    public List<SelfSupportDishSkuDTO> getSkuBasesList() {
        return skuBasesList;
    }

    public void setSkuBasesList(List<SelfSupportDishSkuDTO> skuBasesList) {
        this.skuBasesList = skuBasesList;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public Integer getProductEffectiveDays() {
        return productEffectiveDays;
    }

    public void setProductEffectiveDays(Integer productEffectiveDays) {
        this.productEffectiveDays = productEffectiveDays;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public List<String> getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(List<String> productDetail) {
        this.productDetail = productDetail;
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

    public Instant getSaleStartTime() {
        return saleStartTime;
    }

    public void setSaleStartTime(Instant saleStartTime) {
        this.saleStartTime = saleStartTime;
    }

    public Instant getSaleEndTime() {
        return saleEndTime;
    }

    public void setSaleEndTime(Instant saleEndTime) {
        this.saleEndTime = saleEndTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SelfSupportDishDTO selfSupportDishDTO = (SelfSupportDishDTO) o;
        if(selfSupportDishDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), selfSupportDishDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SelfSupportDishDTO{" +
            "id=" + id +
            ", boxNum=" + boxNum +
            ", boxPrice=" + boxPrice +
            ", categoryName='" + categoryName + '\'' +
            ", description='" + description + '\'' +
            ", dishName='" + dishName + '\'' +
            ", isSoldOut=" + isSoldOut +
            ", minOrderCount=" + minOrderCount +
            ", picture='" + picture + '\'' +
            ", sequence=" + sequence +
            ", price=" + price +
            ", catId=" + catId +
            ", deleteFlag=" + deleteFlag +
            ", merchantId=" + merchantId +
            ", brandId=" + brandId +
            ", userId=" + userId +
            ", propertyList=" + propertyList +
            ", skuBasesList=" + skuBasesList +
            ", content='" + content + '\'' +
            ", homeImage='" + homeImage + '\'' +
            ", activityName='" + activityName + '\'' +
            ", productType=" + productType +
            ", useStartTime=" + useStartTime +
            ", useEndTime=" + useEndTime +
            ", dishImageUrl='" + dishImageUrl + '\'' +
            ", shareContent='" + shareContent + '\'' +
            ", dishMerchantInfoVMS=" + dishMerchantInfoVMS +
            ", thirdPartyType=" + thirdPartyType +
            ", productPoster='" + productPoster + '\'' +
            ", productCompic='" + productCompic + '\'' +
            ", limitBuyNum=" + limitBuyNum +
            ", numLimitType=" + numLimitType +
            ", shopLimitType=" + shopLimitType +
            ", mustCondition=" + mustCondition +
            ", oneNum=" + oneNum +
            ", topTime=" + topTime +
            ", enteringInfo=" + enteringInfo +
            ", enteringDate=" + enteringDate +
            ", reviewDate=" + reviewDate +
            ", reason='" + reason + '\'' +
            ", productDetail='" + productDetail + '\'' +
            ", productEffectiveDays=" + productEffectiveDays +
            '}';
    }

    public String getShareContent() {
        return shareContent;
    }

    public void setShareContent(String shareContent) {
        this.shareContent = shareContent;
    }

    public Double getReward() {
        return reward;
    }

    public void setReward(Double reward) {
        this.reward = reward;
    }

}
