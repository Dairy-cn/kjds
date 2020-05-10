package com.cross.model;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author maxiaolin
 * @date 2019/12/4
 */
public class TableFee {
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
    /**
     * 总桌台收费金额(附加费)
     */
    @ApiModelProperty(value = "金额")
    private BigDecimal TotalFee = new BigDecimal(0);

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

    public BigDecimal getTotalFee() {
        return TotalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        TotalFee = totalFee;
    }
}
