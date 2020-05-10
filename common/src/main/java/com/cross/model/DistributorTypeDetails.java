package com.cross.model;

import com.cross.enumtype.DistributorOrderType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分销类别设置详情")
public class DistributorTypeDetails {
    
    
    @ApiModelProperty("分销订单类型")
    DistributorOrderType distributorOrderType;
    
    @ApiModelProperty("分销比例")
    Double ratio;
    
    @ApiModelProperty("分享海报")
    String distributorPoster;
    
    @ApiModelProperty("分享话术")
    String distributorWords;
    
    @ApiModelProperty("显示金额")
    Double displayMoney;
    
    public DistributorOrderType getDistributorOrderType() {
        return distributorOrderType;
    }
    
    public void setDistributorOrderType(DistributorOrderType distributorOrderType) {
        this.distributorOrderType = distributorOrderType;
    }
    
    public Double getRatio() {
        return ratio;
    }
    
    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }
    
    public String getDistributorPoster() {
        return distributorPoster;
    }
    
    public void setDistributorPoster(String distributorPoster) {
        this.distributorPoster = distributorPoster;
    }
    
    public String getDistributorWords() {
        return distributorWords;
    }
    
    public void setDistributorWords(String distributorWords) {
        this.distributorWords = distributorWords;
    }
    
    public Double getDisplayMoney() {
        return displayMoney;
    }
    
    public void setDisplayMoney(Double displayMoney) {
        this.displayMoney = displayMoney;
    }
    
    @Override
    public String toString() {
        return "DistributorTypeDetails{" +
            "distributorOrderType=" + distributorOrderType +
            ", ratio=" + ratio +
            ", distributorPoster='" + distributorPoster + '\'' +
            ", distributorWords='" + distributorWords + '\'' +
            ", displayMoney=" + displayMoney +
            '}';
    }
}
