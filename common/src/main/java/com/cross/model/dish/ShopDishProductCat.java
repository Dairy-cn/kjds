package com.cross.model.dish;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.cross.enumtype.CatSourceType;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

/**
 * 商品分类
 */
public class ShopDishProductCat implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long id;
    
    /**
     * 分类名称
     */
    private String name;
    
    /**
     * 商户ID
     */
    private Long merchantId;
    
    /**
     * 品牌ID
     */
    private Long brandId;
    
    /**
     * 排序
     */
    private Integer sequence;
    
    /**
     * 描述
     */
    private String description;
    
    /**
     * 饿了么分类编号
     */
    private Long eleMeCatId;
    
    /**
     * 美团分类编号
     */
    private Long meiTuanCatId;
    
    /**
     * 所属类型 1、品牌 2、商户
     */
    private Integer type;
    
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
    private Instant addDate = Instant.now();
    
    /**
     * 源编号
     */
    private Long oldCatId;
    
    private List<ShopDish> shopDishProductCats = new ArrayList<>();
    
    private ShopDishProduct shopDishProduct;
    
    private Long userId;
    
    @ApiModelProperty(value = "是否在C端显示")
    private Boolean display = Boolean.TRUE;
    
    @ApiModelProperty(value = "分类类型 1：必选  2：营销类别  3：普通类别 4：商家推荐")
    private Integer catType;
    
    @ApiModelProperty(value = "营销类别：1：热销 2：优惠")
    private Integer saleType;
    
    @ApiModelProperty(value = "商品总数量")
    private Integer count;
    
    @ApiModelProperty(value = "分类来源")
    @Enumerated(EnumType.STRING)
    private CatSourceType catSourceType;
    
    private String thirdNo;
    
    public String getThirdNo() {
        return thirdNo;
    }
    
    public void setThirdNo(String thirdNo) {
        this.thirdNo = thirdNo;
    }
    
    public CatSourceType getCatSourceType() {
        return catSourceType;
    }
    
    public void setCatSourceType(CatSourceType catSourceType) {
        this.catSourceType = catSourceType;
    }
    
    public Boolean getDisplay() {
        return display;
    }
    
    public void setDisplay(Boolean display) {
        this.display = display;
    }
    
    public Integer getCount() {
        return count;
    }
    
    public void setCount(Integer count) {
        this.count = count;
    }
    
    public Integer getCatType() {
        return catType;
    }
    
    public void setCatType(Integer catType) {
        this.catType = catType;
    }
    
    public Integer getSaleType() {
        return saleType;
    }
    
    public void setSaleType(Integer saleType) {
        this.saleType = saleType;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public ShopDishProductCat name(String name) {
        this.name = name;
        return this;
    }
    
    public Long getMerchantId() {
        return merchantId;
    }
    
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }
    
    public ShopDishProductCat merchantId(Long merchantId) {
        this.merchantId = merchantId;
        return this;
    }
    
    public Long getBrandId() {
        return brandId;
    }
    
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
    
    public ShopDishProductCat brandId(Long brandId) {
        this.brandId = brandId;
        return this;
    }
    
    public Integer getSequence() {
        return sequence;
    }
    
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
    
    public ShopDishProductCat sequence(Integer sequence) {
        this.sequence = sequence;
        return this;
    }
    
    public Integer getType() {
        return type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }
    
    public ShopDishProductCat type(Integer type) {
        this.type = type;
        return this;
    }

    /*public Set<ShopDish> getShopDishProductCats() {
        return shopDishProductCats;
    }

    public void setShopDishProductCats(Set<ShopDish> shopDishes) {
        this.shopDishProductCats = shopDishes;
    }

    public ShopDishProductCat shopDishProductCats(Set<ShopDish> shopDishes) {
        this.shopDishProductCats = shopDishes;
        return this;
    }*/
    
    public List<ShopDish> getShopDishProductCats() {
        return shopDishProductCats;
    }
    
    public void setShopDishProductCats(List<ShopDish> shopDishProductCats) {
        this.shopDishProductCats = shopDishProductCats;
    }
    
    public ShopDishProductCat addShopDishProductCat(ShopDish shopDish) {
        this.shopDishProductCats.add(shopDish);
        shopDish.setShopDishProductCat(this);
        return this;
    }
    
    public ShopDishProductCat removeShopDishProductCat(ShopDish shopDish) {
        this.shopDishProductCats.remove(shopDish);
        shopDish.setShopDishProductCat(null);
        return this;
    }
    
    public ShopDishProduct getShopDishProduct() {
        return shopDishProduct;
    }
    
    public void setShopDishProduct(ShopDishProduct shopDishProduct) {
        this.shopDishProduct = shopDishProduct;
    }
    
    public ShopDishProductCat shopDishProduct(ShopDishProduct shopDishProduct) {
        this.shopDishProduct = shopDishProduct;
        return this;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShopDishProductCat shopDishProductCat = (ShopDishProductCat) o;
        if (shopDishProductCat.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), shopDishProductCat.getId());
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
    
    @Override
    public String toString() {
        return "ShopDishProductCat{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", merchantId=" + merchantId +
            ", brandId=" + brandId +
            ", sequence=" + sequence +
            ", type=" + type +
            ", shopDishProductCats=" + shopDishProductCats +
            ", shopDishProduct=" + shopDishProduct +
            '}';
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Long getEleMeCatId() {
        return eleMeCatId;
    }
    
    public void setEleMeCatId(Long eleMeCatId) {
        this.eleMeCatId = eleMeCatId;
    }
    
    public Long getMeiTuanCatId() {
        return meiTuanCatId;
    }
    
    public void setMeiTuanCatId(Long meiTuanCatId) {
        this.meiTuanCatId = meiTuanCatId;
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
    
    public Long getOldCatId() {
        return oldCatId;
    }
    
    public void setOldCatId(Long oldCatId) {
        this.oldCatId = oldCatId;
    }
}
