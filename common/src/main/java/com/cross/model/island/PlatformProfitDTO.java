package com.cross.model.island;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.cross.enumtype.PlatformProfitType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;


@ApiModel(description = "平台收益明细")
public class PlatformProfitDTO implements Serializable {

    private Long id;

    /**
     * 平台id
     */
    @NotNull
    @ApiModelProperty(value = "平台id", required = true)
    private Long platformId;

    /**
     * 订单编号Sn
     */
    @ApiModelProperty(value = "订单Sn")
    private String orderSn;

    /**
     * 交易订单号
     */
    @ApiModelProperty(value = "交易订单号")
    private String paymentOrderCode;

    /**
     * 订单Id
     */
    @ApiModelProperty(value = "订单Id")
    private Long orderId;

    /**
     * 变动金额
     */
    @ApiModelProperty(value = "变动金额")
    private BigDecimal changeAmount;

    /**
     * 变动后金额
     */
    @ApiModelProperty(value = "变动后金额")
    private BigDecimal profit;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;

    /**
     * 变动日期
     */
    @ApiModelProperty(value = "变动日期")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime changeDate;

    /**
     * 变动IP
     */
    @Size(max = 60)
    @ApiModelProperty(value = "变动IP")
    private String changeIp;

    @ApiModelProperty(value = "  PROMOTION_PROFIT 宣发收益, USER_WITHDRAW_PROFIT 用户提现抽成收益,PLATFORM_WITHDRAW_PROFIT 平台提现抽成收益,  UNDISTRIBUTED_PROFIT 分销未分配收益,")
    private PlatformProfitType platformProfitType;

    public String getPaymentOrderCode() {
        return paymentOrderCode;
    }

    public void setPaymentOrderCode(String paymentOrderCode) {
        this.paymentOrderCode = paymentOrderCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public BigDecimal getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(BigDecimal changeAmount) {
        this.changeAmount = changeAmount;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDateTime changeDate) {
        this.changeDate = changeDate;
    }

    public String getChangeIp() {
        return changeIp;
    }

    public void setChangeIp(String changeIp) {
        this.changeIp = changeIp;
    }



    public PlatformProfitType getPlatformProfitType() {
        return platformProfitType;
    }

    public void setPlatformProfitType(PlatformProfitType platformProfitType) {
        this.platformProfitType = platformProfitType;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PlatformProfitDTO platformProfitDTO = (PlatformProfitDTO) o;
        if (platformProfitDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), platformProfitDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PlatformProfitDTO{" +
            "id=" + id +
            ", platformId=" + platformId +
            ", orderSn='" + orderSn + '\'' +
            ", paymentOrderCode='" + paymentOrderCode + '\'' +
            ", orderId=" + orderId +
            ", changeAmount=" + changeAmount +
            ", profit=" + profit +
            ", createTime=" + createTime +
            ", changeDate=" + changeDate +
            ", changeIp='" + changeIp + '\'' +
            ", platformProfitType=" + platformProfitType +
            '}';
    }
}
