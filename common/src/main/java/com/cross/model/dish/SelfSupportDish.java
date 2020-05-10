package com.cross.model.dish;

import com.cross.enumtype.TaoQuanProductType;
import com.cross.model.enumeration.ShopLimitType;
import com.cross.model.enumeration.ThirdPartyType;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class SelfSupportDish implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 餐盒数量
     */
    @ApiModelProperty(value = "餐盒数量")
    private Integer boxNum;

    /**
     * 打包盒单价
     */
    @ApiModelProperty(value = "打包盒单价")
    private Float boxPrice;

    /**
     * 菜品分类名
     */
    @ApiModelProperty(value = "菜品分类名")
    private String categoryName;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 菜品名
     */
    @ApiModelProperty(value = "菜品名")
    private String dishName;

    /**
     * 是否售完	0-未售完，1-售完，创建时请设置为0，否则C端不显示。当isSoldOut=0,而且库存>0时,菜品才可以售卖。
     */
    @ApiModelProperty(value = "是否售完	0-未售完，1-售完，创建时请设置为0，否则C端不显示。当isSoldOut=0,而且库存>0时,菜品才可以售卖。")
    private Integer isSoldOut;

    /**
     * 最小购买数量
     */
    @ApiModelProperty(value = "最小购买数量")
    private Integer minOrderCount;

    /**
     * 图片id或地址 -非必须
     */
    @ApiModelProperty(value = "图片id或地址 -非必须")
    private String picture;

    /**
     * 排序 -非必须
     */
    @ApiModelProperty(value = "排序 -非必须")
    private Integer sequence;

    /**
     * 价格
     */
    @ApiModelProperty(value = "价格")
    private Float price;

    /**
     * 分类编号
     */
    @ApiModelProperty(value = "分类编号")
    private Long catId;

    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Boolean deleteFlag = Boolean.FALSE;

    /**
     * 商户ID
     */
    @ApiModelProperty(value = "商户ID")
    private Long merchantId;

    /**
     * 平台ID
     */
    @ApiModelProperty(value = "平台ID")
    private Long brandId;

    @ApiModelProperty(value = "用户(商户)id")
    private Long userId;

    @ApiModelProperty(value = "自定义分享内容")
    private String shareContent;

    List<SelfSupportDishProperty> propertyList;

    List<SelfSupportDishSku> skuBasesList;


    /**
     * 限购份数
     */
    @ApiModelProperty(value = "限购份数")
    private Integer limitBuyNum;

    @ApiModelProperty(value = "产品限购方针：1限购；2不限购")
    private Integer numLimitType;

    @ApiModelProperty(value = "商品限购类型：用户限购，订单限购，每日限购")
    private ShopLimitType shopLimitType;

    /**使用须知 */
    @ApiModelProperty(value = "使用须知")
    private String productDetail;

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

    /**
     * 第三方类型
     * */
    @ApiModelProperty(value = "第三方类型")
    private ThirdPartyType thirdPartyType;

    @ApiModelProperty(value = "若是使用掌控者系统由此值 表示再对方系统中的id值")
    private String  thirdNo;
    
    /**
     * 运费(单位：元)
     */
    @ApiModelProperty(value = "运费(单位：元)")
    private BigDecimal deliverFee;
    
    public BigDecimal getDeliverFee() {
        return deliverFee;
    }
    
    public void setDeliverFee(BigDecimal deliverFee) {
        this.deliverFee = deliverFee;
    }
    
    public String getThirdNo() {
        return thirdNo;
    }

    public void setThirdNo(String thirdNo) {
        this.thirdNo = thirdNo;
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

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<SelfSupportDishProperty> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<SelfSupportDishProperty> propertyList) {
        this.propertyList = propertyList;
    }

    public List<SelfSupportDishSku> getSkuBasesList() {
        return skuBasesList;
    }

    public void setSkuBasesList(List<SelfSupportDishSku> skuBasesList) {
        this.skuBasesList = skuBasesList;
    }

    public String getShareContent() {
        return shareContent;
    }

    public void setShareContent(String shareContent) {
        this.shareContent = shareContent;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
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

}
