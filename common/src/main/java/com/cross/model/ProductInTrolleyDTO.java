package com.cross.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @author 马晓林
 * @since 2019/9/26 14:14
 */
public class ProductInTrolleyDTO  implements Serializable {

    /**
     * 商品分类
     */
    @ApiModelProperty("1是原价商品，2是优惠商品，3是必选商品")
    @NotNull
    private Integer cat;

    /**
     * 商品规格描述
     */
    @ApiModelProperty("商品规格描述")
    private String  spec;

    @ApiModelProperty(value = "必选条件 1：根据用餐人数 2：至少1分")
    private Integer mustCondition;

    @ApiModelProperty(value = "每人多少份")
    private Integer oneNum;


    /**
     * 商品属性描述
     */
    @ApiModelProperty("商品属性描述 属性名 属性值")
    private HashMap<String,String> attribute;

    /**
     * 商品id
     */
    @ApiModelProperty("商品id")
    private Long productId;
    /**
     * 商品价格
     */
    @ApiModelProperty("商品价格")
    @NotNull
    private BigDecimal price;

    /**
     * 商品价格
     */
    @ApiModelProperty("商品原价 当商品有优惠价格时出现")
    @NotNull
    private BigDecimal originalPrice;

    /**
     * 商品名
     */
    @ApiModelProperty("商品名")
    @NotNull
    private String dishName;
    /**
     * 数量
     */
    @ApiModelProperty("数量")
    private Integer number;


    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
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

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public HashMap<String, String> getAttribute() {
        return attribute;
    }

    public void setAttribute(HashMap<String, String> attribute) {
        this.attribute = attribute;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getCat() {
        return cat;
    }

    public void setCat(Integer cat) {
        this.cat = cat;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ProductInTrolleyDTO{" +
            "cat=" + cat +
            ", spec='" + spec + '\'' +
            ", mustCondition=" + mustCondition +
            ", oneNum=" + oneNum +
            ", attribute=" + attribute +
            ", productId=" + productId +
            ", price=" + price +
            ", originalPrice=" + originalPrice +
            ", dishName='" + dishName + '\'' +
            ", number=" + number +
            '}';
    }
}
