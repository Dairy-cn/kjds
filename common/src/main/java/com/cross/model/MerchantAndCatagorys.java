package com.cross.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("门店所属品牌信息")
public class MerchantAndCatagorys {

    @ApiModelProperty("门店id")
    private Long merchatId;
    @ApiModelProperty("分类名称集合")
    private List<String> catagorys;

    public Long getMerchatId() {
        return merchatId;
    }

    public void setMerchatId(Long merchatId) {
        this.merchatId = merchatId;
    }

    public List<String> getCatagorys() {
        return catagorys;
    }

    public void setCatagorys(List<String> catagorys) {
        this.catagorys = catagorys;
    }
}
