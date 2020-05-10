package com.cross.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("价格和配送范围对应关系")
public class PriceAndRangeDto {

    @ApiModelProperty("范围序号")
    private Integer num;

    @ApiModelProperty("范围坐标组")
    private String range;

    @ApiModelProperty("范围配送价格")
    private Double sendPrice;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public Double getSendPrice() {
        return sendPrice;
    }

    public void setSendPrice(Double sendPrice) {
        this.sendPrice = sendPrice;
    }

    public PriceAndRangeDto() {
    }

    public PriceAndRangeDto(Integer num, String range, Double sendPrice) {
        this.num = num;
        this.range = range;
        this.sendPrice = sendPrice;
    }

    @Override
    public String toString() {
        return "PriceAndRangeDto{" +
            "num=" + num +
            ", range='" + range + '\'' +
            ", sendPrice=" + sendPrice +
            '}';
    }
}
