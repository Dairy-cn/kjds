package com.cross.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the OfferDiscountDetails entity.
 */
@ApiModel(description = "订单优惠买单详情")
public class OfferDiscountDetailsDTO implements Serializable {

    private Long id;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String orderSn;

    /**
     * 优惠买单折扣
     */
    @ApiModelProperty(value = "优惠买单折扣")
    private Double discount;

    /**
     * 折扣优惠金额
     */
    @ApiModelProperty(value = "折扣优惠金额")
    private Double disCountFee;

    //优惠买单新增数据
    @ApiModelProperty(value = "总优惠金额")
    private BigDecimal totalDisMoney;

    @ApiModelProperty("其他优惠活动详情列表")
    private List<FavorableDTO> otherDisCount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getDisCountFee() {
        return disCountFee;
    }

    public void setDisCountFee(Double disCountFee) {
        this.disCountFee = disCountFee;
    }

    public BigDecimal getTotalDisMoney() {
        return totalDisMoney;
    }

    public void setTotalDisMoney(BigDecimal totalDisMoney) {
        this.totalDisMoney = totalDisMoney;
    }

    public List<FavorableDTO> getOtherDisCount() {
        return otherDisCount;
    }

    public void setOtherDisCount(List<FavorableDTO> otherDisCount) {
        this.otherDisCount = otherDisCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OfferDiscountDetailsDTO offerDiscountDetailsDTO = (OfferDiscountDetailsDTO) o;
        if (offerDiscountDetailsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), offerDiscountDetailsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "OfferDiscountDetailsDTO{" +
            "id=" + id +
            ", orderSn='" + orderSn + '\'' +
            ", discount=" + discount +
            ", disCountFee=" + disCountFee +
            ", totalDisMoney=" + totalDisMoney +
            ", otherDisCount=" + otherDisCount +
            '}';
    }
}
