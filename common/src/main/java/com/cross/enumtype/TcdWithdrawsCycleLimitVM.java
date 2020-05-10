package com.cross.enumtype;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/*************************************************************
 * Description:  平台提现周期限制
 * Author: Dairy
 * CreateTime: 2019/8/23
 ************************************************************/
@ApiModel(value = "平台提现周期限制")
public class TcdWithdrawsCycleLimitVM {
    /**
     * DAY 一天 , HALF_MONTH 半个月 , MONTH 一个月 , HALF_YEAR 半年 , YEAR 一年 ；WEEK 周
     */
    @ApiModelProperty(value = "DAY 一天 , HALF_MONTH 半个月 , MONTH 一个月 , HALF_YEAR 半年 , YEAR 一年")
    private CycleType cycleType;

    @ApiModelProperty(value = "限定次数")
    private Integer limitNumber;

    public CycleType getCycleType() {
        return cycleType;
    }

    public void setCycleType(CycleType cycleType) {
        this.cycleType = cycleType;
    }

    public Integer getLimitNumber() {
        return limitNumber;
    }

    public void setLimitNumber(Integer limitNumber) {
        this.limitNumber = limitNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TcdWithdrawsCycleLimitVM that = (TcdWithdrawsCycleLimitVM) o;

        if (cycleType != that.cycleType) return false;
        return limitNumber != null ? limitNumber.equals(that.limitNumber) : that.limitNumber == null;

    }

    @Override
    public int hashCode() {
        int result = cycleType != null ? cycleType.hashCode() : 0;
        result = 31 * result + (limitNumber != null ? limitNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TcdWithdrawsCycleLimitVM{" +
            "cycleType=" + cycleType +
            ", limitNumber=" + limitNumber +
            '}';
    }
}
