package com.cross.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the OfferToPay entity.
 */
@ApiModel(description = "优惠买单")
public class OfferToPayDTO implements Serializable {

    private Long id;

    /**
     * 门店名称
     */
    @ApiModelProperty(value = "门店名称")
    private String merchantName;

    /**
     * 门店id
     */
    @ApiModelProperty(value = "门店id")
    private Long merchantId;

    /**
     * 门店编号
     */
    @ApiModelProperty(value = "门店编号")
    private Long merchantNo;

    /**
     * 所属品牌
     */
    @ApiModelProperty(value = "所属品牌")
    private Long brand;

    /**
     * 折扣
     */
    @ApiModelProperty(value = "折扣")
    private Double discount;

    /**
     * 是否开启优惠买单
     */
    @ApiModelProperty(value = "是否开启优惠买单")
    private Boolean openState;

    /**
     * 是否参与分销
     */
    @ApiModelProperty(value = "是否参与分销")
    private Boolean inDistribution;

    /**
     * 虚拟销量
     */
    @ApiModelProperty(value = "虚拟销量")
    private Integer virtualSales;

    /**
     * 是否叠加优惠
     */
    @ApiModelProperty(value = "是否叠加优惠")
    private Boolean overlayDiscounts=false;

    /**
     * 可叠加优惠集合
     */
    @ApiModelProperty(value = "可叠加优惠集合")
    private List<Integer> activitys;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(Long merchantNo) {
        this.merchantNo = merchantNo;
    }

    public Long getBrand() {
        return brand;
    }

    public void setBrand(Long brand) {
        this.brand = brand;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Boolean isOpenState() {
        return openState;
    }

    public void setOpenState(Boolean openState) {
        this.openState = openState;
    }

    public Boolean isInDistribution() {
        return inDistribution;
    }

    public void setInDistribution(Boolean inDistribution) {
        this.inDistribution = inDistribution;
    }

    public Integer getVirtualSales() {
        return virtualSales;
    }

    public void setVirtualSales(Integer virtualSales) {
        this.virtualSales = virtualSales;
    }

    public Boolean getOverlayDiscounts() {
        return overlayDiscounts;
    }

    public void setOverlayDiscounts(Boolean overlayDiscounts) {
        this.overlayDiscounts = overlayDiscounts;
    }

    public List<Integer> getActivitys() {
        return activitys;
    }

    public void setActivitys(List<Integer> activitys) {
        this.activitys = activitys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OfferToPayDTO offerToPayDTO = (OfferToPayDTO) o;
        if (offerToPayDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), offerToPayDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "OfferToPayDTO{" +
            "id=" + getId() +
            ", merchantName='" + getMerchantName() + "'" +
            ", merchantId=" + getMerchantId() +
            ", merchantNo=" + getMerchantNo() +
            ", brand=" + getBrand() +
            ", discount=" + getDiscount() +
            ", openState='" + isOpenState() + "'" +
            ", inDistribution='" + isInDistribution() + "'" +
            ", virtualSales=" + getVirtualSales() +
            "}";
    }
}
