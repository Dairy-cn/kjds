package com.cross.merchants.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.math.BigDecimal;

/**
 * 商品规格
 */
@Entity
@Table(name = "goods_sku")
public class GoodsSku implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * 商品id
     */
    @NotNull
    @Column(name = "goods_id",  nullable = false)
    private Long goodsId;



    /**
     * 规格名称
     */
    @NotNull
    @Size(max = 10)
    @Column(name = "name", length = 10, nullable = false)
    private String name;

    /**
     * 规格图片
     */
    @Column(name = "sku_pic")
    private String skuPic;

    /**
     * 销售价
     */
    @Column(name = "sale_price", precision = 21, scale = 2)
    private BigDecimal salePrice;

    /**
     * 税费(元)
     */
    @Column(name = "taxex_and_dues", precision = 21, scale = 2)
    private BigDecimal taxexAndDues;

    /**
     * 市场价(元)
     */
    @Column(name = "market_price", precision = 21, scale = 2)
    private BigDecimal marketPrice;

    /**
     * 成本价(元)
     */
    @Column(name = "cost_price", precision = 21, scale = 2)
    private BigDecimal costPrice;

    /**
     * 库存
     */
    @Column(name = "stock")
    private Integer stock;

    /**
     * 重量（kg）
     */
    @Column(name = "weight")
    private Double weight;

    /**
     * 体积(m³）
     */
    @Column(name = "volume")
    private Double volume;

    /**
     * 是否删除
     */
    @Column(name = "delete_flag")
    private Boolean deleteFlag;

    @Column(name = "sale_volume")
    private Integer saleVolume;

    @Column(name = "lock_stock")
    private  Integer lockStock;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove


    public Integer getLockStock() {
        return lockStock;
    }
    public GoodsSku lockStock(Integer lockStock) {
        this.lockStock = lockStock;
        return this;
    }
    public void setLockStock(Integer lockStock) {
        this.lockStock = lockStock;
    }

    public Integer getSaleVolume() {
        return saleVolume;
    }
    public GoodsSku saleVolume(Integer saleVolume) {
        this.saleVolume = saleVolume;
        return this;
    }
    public void setSaleVolume(Integer saleVolume) {
        this.saleVolume = saleVolume;
    }

    public Long getGoodsId() {
        return goodsId;
    }
    public GoodsSku goodsId(Long goodsId) {
        this.goodsId = goodsId;
        return this;
    }
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
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

    public GoodsSku name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkuPic() {
        return skuPic;
    }

    public GoodsSku skuPic(String skuPic) {
        this.skuPic = skuPic;
        return this;
    }

    public void setSkuPic(String skuPic) {
        this.skuPic = skuPic;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public GoodsSku salePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
        return this;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getTaxexAndDues() {
        return taxexAndDues;
    }

    public GoodsSku taxexAndDues(BigDecimal taxexAndDues) {
        this.taxexAndDues = taxexAndDues;
        return this;
    }

    public void setTaxexAndDues(BigDecimal taxexAndDues) {
        this.taxexAndDues = taxexAndDues;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public GoodsSku marketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
        return this;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public GoodsSku costPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
        return this;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public GoodsSku stock(Integer stock) {
        this.stock = stock;
        return this;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getWeight() {
        return weight;
    }

    public GoodsSku weight(Double weight) {
        this.weight = weight;
        return this;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getVolume() {
        return volume;
    }

    public GoodsSku volume(Double volume) {
        this.volume = volume;
        return this;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Boolean isDeleteFlag() {
        return deleteFlag;
    }

    public GoodsSku deleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
        return this;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GoodsSku)) {
            return false;
        }
        return id != null && id.equals(((GoodsSku) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "GoodsSku{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", skuPic='" + getSkuPic() + "'" +
            ", salePrice=" + getSalePrice() +
            ", taxexAndDues=" + getTaxexAndDues() +
            ", marketPrice=" + getMarketPrice() +
            ", costPrice=" + getCostPrice() +
            ", stock=" + getStock() +
            ", weight=" + getWeight() +
            ", volume=" + getVolume() +
            ", deleteFlag='" + isDeleteFlag() + "'" +
            "}";
    }
}
