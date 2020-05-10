package com.cross.model;

import java.io.Serializable;
import java.util.Objects;

public class DistributorOrderCommissionModel implements Serializable{

    private Long id;

    private Long brandId;

    private Long merchantId;

    private String orderSn;

    private Double commission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DistributorOrderCommissionModel distributorOrderCommissionDTO = (DistributorOrderCommissionModel) o;
        if(distributorOrderCommissionDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), distributorOrderCommissionDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DistributorOrderCommissionDTO{" +
            "id=" + getId() +
            ", brandId=" + getBrandId() +
            ", merchantId=" + getMerchantId() +
            ", orderSn='" + getOrderSn() + "'" +
            ", commission=" + getCommission() +
            "}";
    }

}
