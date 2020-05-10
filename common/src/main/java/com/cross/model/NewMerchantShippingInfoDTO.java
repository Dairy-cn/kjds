package com.cross.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the NewMerchantShippingInfo entity.
 */
@ApiModel(description = "门店配送信息(新)")
public class NewMerchantShippingInfoDTO implements Serializable {

    private Long id;

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
     * 是否开启配送
     */
    @ApiModelProperty(value = "是否开启配送")
    private Boolean useMtShipping;

    /**
     * 美团门店id
     */
    @ApiModelProperty(value = "美团门店id")
    private String mtShopId;

    /**
     * 分发配送类型 1：自动  2：手动
     */
    @ApiModelProperty(value = "分发配送类型 1：自动  2：手动")
    private Integer sendType;

    /**
     * 接单后多少分钟发配送
     */
    @ApiModelProperty(value = "接单后多少分钟发配送")
    private Integer noticeTime;

    /**
     * 配送范围
     */
    @ApiModelProperty(value = "配送范围")
    private String shippingRange;

    /**
     * 配送类型1:美团 2.自配送
     */
    @ApiModelProperty(value = "配送类型1:美团 2.自配送")
    private Integer shippingType;

    /**
     * 起送价格
     */
    @NotNull(message = "起送价格不能为空")
    @ApiModelProperty(value = "起送价格")
    private Double sendingPrice;

    /**
     * 坐标范围1-10
     */
    @ApiModelProperty(value = "坐标范围1-10")
    private String rangeOne;

    private String rangeTwo;

    private String rangeThree;

    private String rangeFour;

    private String rangeFive;

    private String rangeSix;

    private String rangeSeven;

    private String rangeEight;

    private String rangeNine;

    private String rangeTen;

    /**
     * 配送价格范围1-10
     */
    @ApiModelProperty(value = "配送价格范围1-10")
    private Double priceOne;

    private Double priceTwo;

    private Double priceThree;

    private Double priceFour;

    private Double priceFive;

    private Double priceSix;

    private Double priceSeven;

    private Double priceEight;

    private Double priceNine;

    private Double priceTen;

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Boolean getUseMtShipping() {
        return useMtShipping;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(Long merchantNo) {
        this.merchantNo = merchantNo;
    }

    public Boolean isUseMtShipping() {
        return useMtShipping;
    }

    public void setUseMtShipping(Boolean useMtShipping) {
        this.useMtShipping = useMtShipping;
    }

    public String getMtShopId() {
        return mtShopId;
    }

    public void setMtShopId(String mtShopId) {
        this.mtShopId = mtShopId;
    }

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    public Integer getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Integer noticeTime) {
        this.noticeTime = noticeTime;
    }

    public String getShippingRange() {
        return shippingRange;
    }

    public void setShippingRange(String shippingRange) {
        this.shippingRange = shippingRange;
    }

    public Integer getShippingType() {
        return shippingType;
    }

    public void setShippingType(Integer shippingType) {
        this.shippingType = shippingType;
    }

    public Double getSendingPrice() {
        return sendingPrice;
    }

    public void setSendingPrice(Double sendingPrice) {
        this.sendingPrice = sendingPrice;
    }

    public String getRangeOne() {
        return rangeOne;
    }

    public void setRangeOne(String rangeOne) {
        this.rangeOne = rangeOne;
    }

    public String getRangeTwo() {
        return rangeTwo;
    }

    public void setRangeTwo(String rangeTwo) {
        this.rangeTwo = rangeTwo;
    }

    public String getRangeThree() {
        return rangeThree;
    }

    public void setRangeThree(String rangeThree) {
        this.rangeThree = rangeThree;
    }

    public String getRangeFour() {
        return rangeFour;
    }

    public void setRangeFour(String rangeFour) {
        this.rangeFour = rangeFour;
    }

    public String getRangeFive() {
        return rangeFive;
    }

    public void setRangeFive(String rangeFive) {
        this.rangeFive = rangeFive;
    }

    public String getRangeSix() {
        return rangeSix;
    }

    public void setRangeSix(String rangeSix) {
        this.rangeSix = rangeSix;
    }

    public String getRangeSeven() {
        return rangeSeven;
    }

    public void setRangeSeven(String rangeSeven) {
        this.rangeSeven = rangeSeven;
    }

    public String getRangeEight() {
        return rangeEight;
    }

    public void setRangeEight(String rangeEight) {
        this.rangeEight = rangeEight;
    }

    public String getRangeNine() {
        return rangeNine;
    }

    public void setRangeNine(String rangeNine) {
        this.rangeNine = rangeNine;
    }

    public String getRangeTen() {
        return rangeTen;
    }

    public void setRangeTen(String rangeTen) {
        this.rangeTen = rangeTen;
    }

    public Double getPriceOne() {
        return priceOne;
    }

    public void setPriceOne(Double priceOne) {
        this.priceOne = priceOne;
    }

    public Double getPriceTwo() {
        return priceTwo;
    }

    public void setPriceTwo(Double priceTwo) {
        this.priceTwo = priceTwo;
    }

    public Double getPriceThree() {
        return priceThree;
    }

    public void setPriceThree(Double priceThree) {
        this.priceThree = priceThree;
    }

    public Double getPriceFour() {
        return priceFour;
    }

    public void setPriceFour(Double priceFour) {
        this.priceFour = priceFour;
    }

    public Double getPriceFive() {
        return priceFive;
    }

    public void setPriceFive(Double priceFive) {
        this.priceFive = priceFive;
    }

    public Double getPriceSix() {
        return priceSix;
    }

    public void setPriceSix(Double priceSix) {
        this.priceSix = priceSix;
    }

    public Double getPriceSeven() {
        return priceSeven;
    }

    public void setPriceSeven(Double priceSeven) {
        this.priceSeven = priceSeven;
    }

    public Double getPriceEight() {
        return priceEight;
    }

    public void setPriceEight(Double priceEight) {
        this.priceEight = priceEight;
    }

    public Double getPriceNine() {
        return priceNine;
    }

    public void setPriceNine(Double priceNine) {
        this.priceNine = priceNine;
    }

    public Double getPriceTen() {
        return priceTen;
    }

    public void setPriceTen(Double priceTen) {
        this.priceTen = priceTen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        NewMerchantShippingInfoDTO newMerchantShippingInfoDTO = (NewMerchantShippingInfoDTO) o;
        if (newMerchantShippingInfoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), newMerchantShippingInfoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "NewMerchantShippingInfoDTO{" +
            "id=" + getId() +
            ", merchantNo=" + getMerchantNo() +
            ", useMtShipping='" + isUseMtShipping() + "'" +
            ", mtShopId='" + getMtShopId() + "'" +
            ", sendType=" + getSendType() +
            ", noticeTime=" + getNoticeTime() +
            ", shippingRange='" + getShippingRange() + "'" +
            ", shippingType=" + getShippingType() +
            ", sendingPrice=" + getSendingPrice() +
            ", rangeOne='" + getRangeOne() + "'" +
            ", rangeTwo='" + getRangeTwo() + "'" +
            ", rangeThree='" + getRangeThree() + "'" +
            ", rangeFour='" + getRangeFour() + "'" +
            ", rangeFive='" + getRangeFive() + "'" +
            ", rangeSix='" + getRangeSix() + "'" +
            ", rangeSeven='" + getRangeSeven() + "'" +
            ", rangeEight='" + getRangeEight() + "'" +
            ", rangeNine='" + getRangeNine() + "'" +
            ", rangeTen='" + getRangeTen() + "'" +
            ", priceOne=" + getPriceOne() +
            ", priceTwo=" + getPriceTwo() +
            ", priceThree=" + getPriceThree() +
            ", priceFour=" + getPriceFour() +
            ", priceFive=" + getPriceFive() +
            ", priceSix=" + getPriceSix() +
            ", priceSeven=" + getPriceSeven() +
            ", priceEight=" + getPriceEight() +
            ", priceNine=" + getPriceNine() +
            ", priceTen=" + getPriceTen() +
            "}";
    }
}
