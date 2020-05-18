package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchants.domain.GoodsSku} entity.
 */
@ApiModel(description = "商品规格")
public class GoodsSkuDTO implements Serializable {

    private Long id;

    /**
     * 商品id
     */
    @NotNull
    @ApiModelProperty(value = "商品id", required = true)
    private Long goodsId;


    /**
     * 规格名称
     */
    @NotNull
    @Size(max = 10)
    @ApiModelProperty(value = "规格名称", required = true)
    private String name;

    /**
     * 规格图片
     */
    @ApiModelProperty(value = "规格图片")
    private String skuPic;

    /**
     * 销售价
     */
    @ApiModelProperty(value = "销售价")
    private BigDecimal salePrice;

    /**
     * 税费(元)
     */
    @ApiModelProperty(value = "税费(元)")
    private BigDecimal taxexAndDues;

    /**
     * 市场价(元)
     */
    @ApiModelProperty(value = "市场价(元)")
    private BigDecimal marketPrice;

    /**
     * 成本价(元)
     */
    @ApiModelProperty(value = "成本价(元)")
    private BigDecimal costPrice;

    /**
     * 库存
     */
    @ApiModelProperty(value = "库存")
    private Integer stock;

    /**
     * 重量（kg）
     */
    @ApiModelProperty(value = "重量（kg）")
    private Double weight;

    /**
     * 体积(m³）
     */
    @ApiModelProperty(value = "体积(m³）")
    private Double volume;

    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Boolean deleteFlag;


    public Long getGoodsId() {
        return goodsId;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getSkuPic() {
        return skuPic;
    }

    public void setSkuPic(String skuPic) {
        this.skuPic = skuPic;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getTaxexAndDues() {
        return taxexAndDues;
    }

    public void setTaxexAndDues(BigDecimal taxexAndDues) {
        this.taxexAndDues = taxexAndDues;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GoodsSkuDTO goodsSkuDTO = (GoodsSkuDTO) o;
        if (goodsSkuDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), goodsSkuDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "GoodsSkuDTO{" +
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
