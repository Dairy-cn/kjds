package com.cross.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchant.domain.QRCodeOrder} entity.
 */
public class QRCodeOrderDTO implements Serializable {

    private Long id;

    /**
     * 店铺号
     */
    @NotNull
    @ApiModelProperty(value = "店铺号", required = true)
    private Long merchantId;

    /**
     * 开关 1是开启 0是关闭
     */
    @NotNull
    @ApiModelProperty(value = "开关 1是开启 0是关闭", required = true)
    private Integer status;

    /**
     * 付款模式 0为餐前 1位餐后
     */
    @NotNull
    @ApiModelProperty(value = "付款模式 0为餐前 1为餐后", required = true)
    private Integer payType;


    /**
     * 自动接单 0关 1开
     */
    @NotNull
    @ApiModelProperty(value = "自动接单 0关 1开", required = true)
    private Integer autoReceiveOrder;

    /**
     * 自动打印订单 0关 1开
     */
    @ApiModelProperty(value = "自动打印订单 0关 1开")
    private Integer autoPrintOrder;

    /**
     * 支持拼桌 0关 1开
     */
    @ApiModelProperty(value = "支持拼桌 0关 1开")
    private Integer shareTable;

    /**
     * 桌台收费状态 0是关闭 1按桌收费 2按人收费
     */
    @ApiModelProperty(value = "桌台收费状态 0是关闭 1按桌收费 2按人收费")
    private Integer feeStatus;

    /**
     * 金额
     */
    @ApiModelProperty(value = "金额")
    private BigDecimal fee;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getAutoReceiveOrder() {
        return autoReceiveOrder;
    }

    public void setAutoReceiveOrder(Integer autoReceiveOrder) {
        this.autoReceiveOrder = autoReceiveOrder;
    }

    public Integer getAutoPrintOrder() {
        return autoPrintOrder;
    }

    public void setAutoPrintOrder(Integer autoPrintOrder) {
        this.autoPrintOrder = autoPrintOrder;
    }

    public Integer getShareTable() {
        return shareTable;
    }

    public void setShareTable(Integer shareTable) {
        this.shareTable = shareTable;
    }

    public Integer getFeeStatus() {
        return feeStatus;
    }

    public void setFeeStatus(Integer feeStatus) {
        this.feeStatus = feeStatus;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        QRCodeOrderDTO qRCodeOrderDTO = (QRCodeOrderDTO) o;
        if (qRCodeOrderDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), qRCodeOrderDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "QRCodeOrderDTO{" +
            "id=" + getId() +
            ", merchantTableId=" + getMerchantId() +
            ", status=" + getStatus() +
            ", payType=" + getPayType() +
            ", autoReceiveOrder=" + getAutoReceiveOrder() +
            ", autoPrintOrder=" + getAutoPrintOrder() +
            ", shareTable=" + getShareTable() +
            ", feeStatus=" + getFeeStatus() +
            ", fee=" + getFee() +
            "}";
    }
}
