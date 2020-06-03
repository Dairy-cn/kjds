package com.cross.merchants.service.dto;

import com.cross.merchants.domain.Goods;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/*************************************************************
 * Description:
 * Author: Dairy
 * CreateTime: 2020/5/24
 ************************************************************/
@ApiModel(description = "下单时店铺信息")
public class StoreOrderResult implements Serializable {

    @ApiModelProperty("店铺id")
    private Long id;

    @ApiModelProperty("店铺")
    private String storeName;

    @ApiModelProperty("运费")
    private BigDecimal freight;

    @ApiModelProperty("店铺合计")
    private BigDecimal totalAmount;

    @ApiModelProperty("商品list")
    private List<GoodsDTO> goodsDTOList;

    /**
     * 税费
     */
    @ApiModelProperty("税费")
    private BigDecimal taxesFees;

    public BigDecimal getTaxesFees() {
        return taxesFees;
    }

    public void setTaxesFees(BigDecimal taxesFees) {
        this.taxesFees = taxesFees;
    }

    public List<GoodsDTO> getGoodsDTOList() {
        return goodsDTOList;
    }

    public void setGoodsDTOList(List<GoodsDTO> goodsDTOList) {
        this.goodsDTOList = goodsDTOList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
