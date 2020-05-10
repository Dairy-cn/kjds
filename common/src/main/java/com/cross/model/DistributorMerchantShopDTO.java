package com.cross.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.cross.model.dish.ShopDish;
import com.cross.model.dish.ShopDishSku;
import com.cross.model.enumeration.BrandAndMerchantType;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * A DTO for the DistributorMerchantShop entity.
 */
public class DistributorMerchantShopDTO implements Serializable {

    private Long id;

    private Long brandId;

    private Long supplierId;

    private Long merchantId;

    private Long goodsId;

    private Boolean enableMerchantRule;

    private Double allowChange;

    @Size(max = 255)
    private String shareName;

    @Size(max = 500)
    private String shareImages;

    @Size(max = 100, message = "分销话述不能超过100个字")
    private String shareBrief;

    @Size(max = 500)
    private String posts;
    
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant addDate;

    /**
     * 商品模式
     */
    @ApiModelProperty(value = "商品模式")
    private String pattern;

    /**
     * 分销数量
     */
    @ApiModelProperty(value = "分销数量")
    private Long distributionNum;

    /**
     * 所属平台标识
     */
    @ApiModelProperty(value = "所属平台标识")
    private Long platformId;

    /**
     * 分销者的分销比例
     */
    @ApiModelProperty(value = "分销者的分销比例")
    private Double distributorProportion;
    /**
     * 一级分销比例
     */
    @ApiModelProperty(value = "分销者的分销比例")
    private Double oneLevelProportion;
    /**
     * 二级分销比例
     */
    @ApiModelProperty(value = "分销者的分销比例")
    private Double twoLevelProportion;

    /**
     * 销售状态
     */
    @ApiModelProperty(value = "销售状态")
    private String saleStatus;

    /**
     * 品牌名字
     */
    @ApiModelProperty(value = "品牌名字")
    private String brandName;




    /**
     * 售卖价格
     */
    @ApiModelProperty(value = "售卖价格")
    private Double price;

    /**
     * 商品名
     */
    @ApiModelProperty(hidden = true)
    private String dishName;


    /**
     * 商品编号
     */
    @ApiModelProperty(hidden = true)
    private String dishNo;


    /**
     * 门店名
     */
    @ApiModelProperty(hidden = true,value = "门店名")
    private String merchantName;


    /**
     * 商品状态
     */
    @ApiModelProperty(hidden = true,value = "0：已售罄  1：未开始  2：进行中 3：已结束")
    private Integer dishState;

    @ApiModelProperty(hidden = true)
    private List<ShopDishSku> dishSkus;

    @ApiModelProperty(value = "分销订单数")
    private Long distributionOrderNum;

    @ApiModelProperty("通吃岛---分销比例")
    private Double tcdDistributorProportion;

    @ApiModelProperty(value = "商品信息")
    private ShopDish shopDish;



    @ApiModelProperty("是否是通吃岛")
    private Boolean tcd;

    @ApiModelProperty(value = "审核时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant checkDate;

    @ApiModelProperty(value = "审核人")
    private String checkUserName;

    @ApiModelProperty(value = "审核人Id")
    private String checkUserNameId;

    @ApiModelProperty("审核状态 -1 未审核 0 审核失败 1 审核成功")
    private Integer checkState;

    /**
     * 审核结果失败说明
     */
    @ApiModelProperty(value = "审核结果失败说明")
    private String checkFailReason;

    @ApiModelProperty("是否是通吃岛后台添加")
    private Boolean tcdBack;

    @ApiModelProperty(value = "图片路径")
    private String imagePath;

    @ApiModelProperty(value = "售卖开始时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant saleStartTime;

    @ApiModelProperty(value = "售卖结束时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant saleEndTime;
    
    
    @ApiModelProperty(value = "门店类型")
    @Enumerated(EnumType.STRING)
    private BrandAndMerchantType brandAndMerchantType;
    
    
    public BrandAndMerchantType getBrandAndMerchantType() {
        return brandAndMerchantType;
    }
    
    public void setBrandAndMerchantType(BrandAndMerchantType brandAndMerchantType) {
        this.brandAndMerchantType = brandAndMerchantType;
    }
    
    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Boolean getEnableMerchantRule() {
        return enableMerchantRule;
    }

    public void setEnableMerchantRule(Boolean enableMerchantRule) {
        this.enableMerchantRule = enableMerchantRule;
    }

    public Double getAllowChange() {
        return allowChange;
    }

    public void setAllowChange(Double allowChange) {
        this.allowChange = allowChange;
    }

    public String getShareName() {
        return shareName;
    }

    public void setShareName(String shareName) {
        this.shareName = shareName;
    }

    public String getShareImages() {
        return shareImages;
    }

    public void setShareImages(String shareImages) {
        this.shareImages = shareImages;
    }

    public String getShareBrief() {
        return shareBrief;
    }

    public void setShareBrief(String shareBrief) {
        this.shareBrief = shareBrief;
    }

    public String getPosts() {
        return posts;
    }

    public void setPosts(String posts) {
        this.posts = posts;
    }

    public Instant getAddDate() {
        return addDate;
    }

    public void setAddDate(Instant addDate) {
        this.addDate = addDate;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public Long getDistributionNum() {
        return distributionNum;
    }

    public void setDistributionNum(Long distributionNum) {
        this.distributionNum = distributionNum;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public Double getDistributorProportion() {
        return distributorProportion;
    }

    public void setDistributorProportion(Double distributorProportion) {
        this.distributorProportion = distributorProportion;
    }

    public Double getOneLevelProportion() {
        return oneLevelProportion;
    }

    public void setOneLevelProportion(Double oneLevelProportion) {
        this.oneLevelProportion = oneLevelProportion;
    }

    public Double getTwoLevelProportion() {
        return twoLevelProportion;
    }

    public void setTwoLevelProportion(Double twoLevelProportion) {
        this.twoLevelProportion = twoLevelProportion;
    }

    public String getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(String saleStatus) {
        this.saleStatus = saleStatus;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishNo() {
        return dishNo;
    }

    public void setDishNo(String dishNo) {
        this.dishNo = dishNo;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public Integer getDishState() {
        return dishState;
    }

    public void setDishState(Integer dishState) {
        this.dishState = dishState;
    }


    public List<ShopDishSku> getDishSkus() {
        return dishSkus;
    }

    public void setDishSkus(List<ShopDishSku> dishSkus) {
        this.dishSkus = dishSkus;
    }

    public Long getDistributionOrderNum() {
        return distributionOrderNum;
    }

    public void setDistributionOrderNum(Long distributionOrderNum) {
        this.distributionOrderNum = distributionOrderNum;
    }


    public ShopDish getShopDish() {
        return shopDish;
    }

    public void setShopDish(ShopDish shopDish) {
        this.shopDish = shopDish;
    }

    public Double getTcdDistributorProportion() {
        return tcdDistributorProportion;
    }

    public void setTcdDistributorProportion(Double tcdDistributorProportion) {
        this.tcdDistributorProportion = tcdDistributorProportion;
    }

    public Boolean getTcd() {
        return tcd;
    }

    public void setTcd(Boolean tcd) {
        this.tcd = tcd;
    }

    public Instant getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Instant checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckUserName() {
        return checkUserName;
    }

    public void setCheckUserName(String checkUserName) {
        this.checkUserName = checkUserName;
    }

    public String getCheckUserNameId() {
        return checkUserNameId;
    }

    public void setCheckUserNameId(String checkUserNameId) {
        this.checkUserNameId = checkUserNameId;
    }

    public Integer getCheckState() {
        return checkState;
    }

    public void setCheckState(Integer checkState) {
        this.checkState = checkState;
    }

    public String getCheckFailReason() {
        return checkFailReason;
    }

    public void setCheckFailReason(String checkFailReason) {
        this.checkFailReason = checkFailReason;
    }

    public Boolean getTcdBack() {
        return tcdBack;
    }

    public void setTcdBack(Boolean tcdBack) {
        this.tcdBack = tcdBack;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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
    public String toString() {
        return "DistributorMerchantShopDTO{" +
            "id=" + id +
            ", brandId=" + brandId +
            ", supplierId=" + supplierId +
            ", merchantId=" + merchantId +
            ", goodsId=" + goodsId +
            ", enableMerchantRule=" + enableMerchantRule +
            ", allowChange=" + allowChange +
            ", shareName='" + shareName + '\'' +
            ", shareImages='" + shareImages + '\'' +
            ", shareBrief='" + shareBrief + '\'' +
            ", posts='" + posts + '\'' +
            ", addDate=" + addDate +
            ", pattern='" + pattern + '\'' +
            ", distributionNum=" + distributionNum +
            ", platformId=" + platformId +
            ", distributorProportion=" + distributorProportion +
            ", oneLevelProportion=" + oneLevelProportion +
            ", twoLevelProportion=" + twoLevelProportion +
            ", saleStatus='" + saleStatus + '\'' +
            ", brandName='" + brandName + '\'' +
            ", price=" + price +
            ", dishName='" + dishName + '\'' +
            ", dishNo=" + dishNo +
            ", merchantName='" + merchantName + '\'' +
            ", dishState=" + dishState +
            ", dishSkus=" + dishSkus +
            ", distributionOrderNum=" + distributionOrderNum +
            ", tcdDistributorProportion=" + tcdDistributorProportion +
            ", shopDish=" + shopDish +
            ", tcd=" + tcd +
            ", checkDate=" + checkDate +
            ", checkUserName='" + checkUserName + '\'' +
            ", checkUserNameId='" + checkUserNameId + '\'' +
            ", checkState=" + checkState +
            ", checkFailReason='" + checkFailReason + '\'' +
            ", tcdBack=" + tcdBack +
            ", imagePath='" + imagePath + '\'' +
            ", saleStartTime=" + saleStartTime +
            ", saleEndTime=" + saleEndTime +
            ", brandAndMerchantType=" + brandAndMerchantType +
            '}';
    }
}
