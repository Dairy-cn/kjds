package com.cross.enumtype;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

/*************************************************************
 * Description: 
 * Author: Dairy
 * CreateTime: 2019/8/23
 ************************************************************/
@ApiModel("平台提现配置")
public class IslandWithdrawSettingVm {

    @ApiModelProperty(value = "平台Id")
    @NotNull(message = "平台id不能为空")
    private Long platformId;

    @ApiModelProperty(value = "用户提现限制金额")
    @Size(min = 1, message = "提现门槛不能低于1元")
    private BigDecimal limitWithdraws;


    @ApiModelProperty(value = "提款限制金额  NO_LIMIT 无限制, CYCLE_LIMIT 周期限制")
    private WithdrawsNumberLimitType withdrawsNumberLimitType;


    @ApiModelProperty(value = "周期限制条件信息")
    private List<TcdWithdrawsCycleLimitVM> tcdWithdrawsCycleLimitVM;
    
    
    @ApiModelProperty(value = "商户提款限制金额")
    @Size(min = 1, message = "提现门槛不能低于1元")
    private BigDecimal merchantLimitWithdraws;
    
    @ApiModelProperty(value = "商户提款限制金额  NO_LIMIT 无限制, CYCLE_LIMIT 周期限制")
    private WithdrawsNumberLimitType merchantWithdrawsNumberLimitType;
    
    @ApiModelProperty(value = "商户周期限制提款金额详情")
    private List<TcdWithdrawsCycleLimitVM> tcdMerchantWithdrawsCycleLimitVM;


    @ApiModelProperty(value = "用户提现平台抽成比")
    @Size(min = 0, message = "用户提现平台抽成比不能低于0")
    private Double tcdCutRatio;
    
    @ApiModelProperty(value = "商户提现平台抽成比")
    @Size(min = 0, message = "商户提现平台抽成比不能低于0")
    private Double tcdMercahntCutRatio;
    
    
    public Double getTcdMercahntCutRatio() {
        return tcdMercahntCutRatio;
    }
    
    public void setTcdMercahntCutRatio(Double tcdMercahntCutRatio) {
        this.tcdMercahntCutRatio = tcdMercahntCutRatio;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IslandWithdrawSettingVm that = (IslandWithdrawSettingVm) o;

        if (platformId != null ? !platformId.equals(that.platformId) : that.platformId != null) return false;
        if (limitWithdraws != null ? !limitWithdraws.equals(that.limitWithdraws) : that.limitWithdraws != null)
            return false;
        if (withdrawsNumberLimitType != that.withdrawsNumberLimitType) return false;
        if (tcdWithdrawsCycleLimitVM != null ? !tcdWithdrawsCycleLimitVM.equals(that.tcdWithdrawsCycleLimitVM) : that.tcdWithdrawsCycleLimitVM != null)
            return false;
        return tcdCutRatio != null ? tcdCutRatio.equals(that.tcdCutRatio) : that.tcdCutRatio == null;

    }

    @Override
    public int hashCode() {
        int result = platformId != null ? platformId.hashCode() : 0;
        result = 31 * result + (limitWithdraws != null ? limitWithdraws.hashCode() : 0);
        result = 31 * result + (withdrawsNumberLimitType != null ? withdrawsNumberLimitType.hashCode() : 0);
        result = 31 * result + (tcdWithdrawsCycleLimitVM != null ? tcdWithdrawsCycleLimitVM.hashCode() : 0);
        result = 31 * result + (tcdCutRatio != null ? tcdCutRatio.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "IslandWithdrawSettingVm{" +
            "platformId=" + platformId +
            ", limitWithdraws=" + limitWithdraws +
            ", withdrawsNumberLimitType=" + withdrawsNumberLimitType +
            ", tcdWithdrawsCycleLimitVM=" + tcdWithdrawsCycleLimitVM +
            ", merchantLimitWithdraws=" + merchantLimitWithdraws +
            ", merchantWithdrawsNumberLimitType=" + merchantWithdrawsNumberLimitType +
            ", tcdMerchantWithdrawsCycleLimitVM=" + tcdMerchantWithdrawsCycleLimitVM +
            ", tcdCutRatio=" + tcdCutRatio +
            '}';
    }
}
