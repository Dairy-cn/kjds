package com.cross.enumtype;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/*************************************************************
 * Description:  广告弹窗设置
 * Author: Dairy
 * CreateTime: 2019/8/23
 ************************************************************/
@ApiModel(value = "广告弹窗设置")
public class PlatformSystemBannerPopSettingVM implements Serializable {
    /**
     * DAY 一天 , HALF_MONTH 半个月 , MONTH 一个月 , HALF_YEAR 半年 , YEAR 一年 ；WEEK 周
     */
    @ApiModelProperty(value = "DAY 一天 , HALF_MONTH 半个月 , MONTH 一个月 , HALF_YEAR 半年 , YEAR 一年")
    private CycleType cycleType;

    @ApiModelProperty(value = "限定次数")
    private Integer popNumber;

    public CycleType getCycleType() {
        return cycleType;
    }

    public void setCycleType(CycleType cycleType) {
        this.cycleType = cycleType;
    }
    
    public Integer getPopNumber() {
        return popNumber;
    }
    
    public void setPopNumber(Integer popNumber) {
        this.popNumber = popNumber;
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        PlatformSystemBannerPopSettingVM that = (PlatformSystemBannerPopSettingVM) o;
        
        if (cycleType != that.cycleType) return false;
        return popNumber != null ? popNumber.equals(that.popNumber) : that.popNumber == null;
    
    }
    
    @Override
    public int hashCode() {
        int result = cycleType != null ? cycleType.hashCode() : 0;
        result = 31 * result + (popNumber != null ? popNumber.hashCode() : 0);
        return result;
    }
    
    @Override
    public String
    toString() {
        return "PlatformSystemBannerPopSettingVM{" +
            "cycleType=" + cycleType +
            ", popNumber=" + popNumber +
            '}';
    }
}
