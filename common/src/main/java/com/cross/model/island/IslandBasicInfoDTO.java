package com.cross.model.island;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.cross.enumtype.TcdWithdrawsCycleLimitVM;
import com.cross.enumtype.WithdrawsNumberLimitType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


@ApiModel(description = "通吃岛基础信息设置")
public class IslandBasicInfoDTO implements Serializable {

    private Long id;

    private Long platformId;

    /**
     * 通吃岛虚拟赏金池金额
     */
    @ApiModelProperty(value = "通吃岛虚拟赏金池金额")
    private BigDecimal virtualBountyPool;

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


    @ApiModelProperty(value = "提款限制金额")
    private BigDecimal limitWithdraws;

    @ApiModelProperty(value = "提款限制金额  NO_LIMIT 无限制, CYCLE_LIMIT 周期限制")
    private WithdrawsNumberLimitType withdrawsNumberLimitType;

    @ApiModelProperty(value = "周期限制提款金额详情")
    private List<TcdWithdrawsCycleLimitVM> tcdWithdrawsCycleLimitVM;


    @ApiModelProperty(value = "通吃岛平台抽成比例")
    private Double tcdCutRatio;
    
    @ApiModelProperty(value = "商户提款限制金额")
    private BigDecimal merchantLimitWithdraws;
    
    @ApiModelProperty(value = "商户提款限制金额  NO_LIMIT 无限制, CYCLE_LIMIT 周期限制")
    private WithdrawsNumberLimitType merchantWithdrawsNumberLimitType;
    
    @ApiModelProperty(value = "商户周期限制提款金额详情")
    private List<TcdWithdrawsCycleLimitVM> tcdMerchantWithdrawsCycleLimitVM;
    
    
    @ApiModelProperty(value = "商户提现平台抽成比")
    private Double tcdMercahntCutRatio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Double getTcdMercahntCutRatio() {
        return tcdMercahntCutRatio;
    }
    
    public void setTcdMercahntCutRatio(Double tcdMercahntCutRatio) {
        this.tcdMercahntCutRatio = tcdMercahntCutRatio;
    }
    
    public BigDecimal getVirtualBountyPool() {
        return virtualBountyPool;
    }

    public void setVirtualBountyPool(BigDecimal virtualBountyPool) {
        this.virtualBountyPool = virtualBountyPool;
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

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }


    public BigDecimal getLimitWithdraws() {
        return limitWithdraws;
    }

    public void setLimitWithdraws(BigDecimal limitWithdraws) {
        this.limitWithdraws = limitWithdraws;
    }

    public WithdrawsNumberLimitType getWithdrawsNumberLimitType() {
        return withdrawsNumberLimitType;
    }

    public void setWithdrawsNumberLimitType(WithdrawsNumberLimitType withdrawsNumberLimitType) {
        this.withdrawsNumberLimitType = withdrawsNumberLimitType;
    }

    public List<TcdWithdrawsCycleLimitVM> getTcdWithdrawsCycleLimitVM() {
        return tcdWithdrawsCycleLimitVM;
    }

    public void setTcdWithdrawsCycleLimitVM(List<TcdWithdrawsCycleLimitVM> tcdWithdrawsCycleLimitVM) {
        this.tcdWithdrawsCycleLimitVM = tcdWithdrawsCycleLimitVM;
    }

    public Double getTcdCutRatio() {
        return tcdCutRatio;
    }

    public void setTcdCutRatio(Double tcdCutRatio) {
        this.tcdCutRatio = tcdCutRatio;
    }
    
    public BigDecimal getMerchantLimitWithdraws() {
        return merchantLimitWithdraws;
    }
    
    public void setMerchantLimitWithdraws(BigDecimal merchantLimitWithdraws) {
        this.merchantLimitWithdraws = merchantLimitWithdraws;
    }
    
    public WithdrawsNumberLimitType getMerchantWithdrawsNumberLimitType() {
        return merchantWithdrawsNumberLimitType;
    }
    
    public void setMerchantWithdrawsNumberLimitType(WithdrawsNumberLimitType merchantWithdrawsNumberLimitType) {
        this.merchantWithdrawsNumberLimitType = merchantWithdrawsNumberLimitType;
    }
    
    public List<TcdWithdrawsCycleLimitVM> getTcdMerchantWithdrawsCycleLimitVM() {
        return tcdMerchantWithdrawsCycleLimitVM;
    }
    
    public void setTcdMerchantWithdrawsCycleLimitVM(List<TcdWithdrawsCycleLimitVM> tcdMerchantWithdrawsCycleLimitVM) {
        this.tcdMerchantWithdrawsCycleLimitVM = tcdMerchantWithdrawsCycleLimitVM;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IslandBasicInfoDTO islandBasicInfoDTO = (IslandBasicInfoDTO) o;
        if (islandBasicInfoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), islandBasicInfoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
    
    @Override
    public String toString() {
        return "IslandBasicInfoDTO{" +
            "id=" + id +
            ", platformId=" + platformId +
            ", virtualBountyPool=" + virtualBountyPool +
            ", createTime=" + createTime +
            ", changeDate=" + changeDate +
            ", limitWithdraws=" + limitWithdraws +
            ", withdrawsNumberLimitType=" + withdrawsNumberLimitType +
            ", tcdWithdrawsCycleLimitVM=" + tcdWithdrawsCycleLimitVM +
            ", tcdCutRatio=" + tcdCutRatio +
            ", merchantLimitWithdraws=" + merchantLimitWithdraws +
            ", merchantWithdrawsNumberLimitType=" + merchantWithdrawsNumberLimitType +
            ", tcdMerchantWithdrawsCycleLimitVM=" + tcdMerchantWithdrawsCycleLimitVM +
            ", tcdMercahntCutRatio=" + tcdMercahntCutRatio +
            '}';
    }
}
