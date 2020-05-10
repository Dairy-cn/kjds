package com.cross.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchant.domain.ItemSku} entity.
 */
public class ItemSkuDTO implements Serializable {

    private Long id;

    /**
     * mdm主键
     */
    @ApiModelProperty(value = "mdm主键")
    private String guid;

    /**
     * 我方主键
     */
    @ApiModelProperty(value = "我方主键")
    private String thirdNo;

    /**
     * 门店guid
     */
    @ApiModelProperty(value = "门店guid")
    private String storeGuid;

    /**
     * 品牌guid
     */
    @ApiModelProperty(value = "品牌guid")
    private String brandGuid;

    /**
     * 商品标识(商品表中 thirdNo)
     */
    @ApiModelProperty(value = "商品标识(商品表中 thirdNo)")
    private String itemGuid;

    /**
     * 规格来源（0：门店，1：品牌）
     */
    @ApiModelProperty(value = "规格来源（0：门店，1：品牌）")
    private Integer skuFrom;

    /**
     * upc商品条码,可为空
     */
    @ApiModelProperty(value = "upc商品条码,可为空")
    private String upc;

    /**
     * 规格名称(单品规格名称为空字符串)
     */
    @ApiModelProperty(value = "规格名称(单品规格名称为空字符串)")
    private String name;

    /**
     * 编号,可为空
     */
    @ApiModelProperty(value = "编号,可为空")
    private String code;

    /**
     * 售卖价格（参考价）
     */
    @ApiModelProperty(value = "售卖价格（参考价）")
    private BigDecimal salePrice;

    /**
     * 商品规格单位
     */
    @ApiModelProperty(value = "商品规格单位")
    private String unit;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getThirdNo() {
        return thirdNo;
    }

    public void setThirdNo(String thirdNo) {
        this.thirdNo = thirdNo;
    }

    public String getStoreGuid() {
        return storeGuid;
    }

    public void setStoreGuid(String storeGuid) {
        this.storeGuid = storeGuid;
    }

    public String getBrandGuid() {
        return brandGuid;
    }

    public void setBrandGuid(String brandGuid) {
        this.brandGuid = brandGuid;
    }

    public String getItemGuid() {
        return itemGuid;
    }

    public void setItemGuid(String itemGuid) {
        this.itemGuid = itemGuid;
    }

    public Integer getSkuFrom() {
        return skuFrom;
    }

    public void setSkuFrom(Integer skuFrom) {
        this.skuFrom = skuFrom;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ItemSkuDTO itemSkuDTO = (ItemSkuDTO) o;
        if (itemSkuDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), itemSkuDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ItemSkuDTO{" +
            "id=" + id +
            ", guid='" + guid + '\'' +
            ", thirdNo=" + thirdNo +
            ", storeGuid='" + storeGuid + '\'' +
            ", brandGuid='" + brandGuid + '\'' +
            ", itemGuid='" + itemGuid + '\'' +
            ", skuFrom=" + skuFrom +
            ", upc='" + upc + '\'' +
            ", name='" + name + '\'' +
            ", code='" + code + '\'' +
            ", salePrice='" + salePrice + '\'' +
            ", unit='" + unit + '\'' +
            '}';
    }
}
