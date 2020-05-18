package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/*************************************************************
 * Description:
 * Author: Dair
 * CreateTime: 2020/5/14
 * Copyright © 成都通吃岛信息技术有限公司 All right reserved
 ************************************************************/
@ApiModel(description = "授权书信息")
public class OwerOfAttorneyDTO  implements Serializable {

    @ApiModelProperty(value = "供应商代理等级 1 一级 2 二级 3 三级")
    private Integer brandAuthLevel;

    @ApiModelProperty(value = "授权书信息")
    private List<String> owerOfAttorneyPic;

    @ApiModelProperty(value = "有效期开始时间 yyyy-mm-dd")
    private String validStartTime;

    @ApiModelProperty(value = "有效期结束时间 yyyy-mm-dd")
    private String validEndTime;



    public Integer getBrandAuthLevel() {
        return brandAuthLevel;
    }

    public void setBrandAuthLevel(Integer brandAuthLevel) {
        this.brandAuthLevel = brandAuthLevel;
    }

    public List<String> getOwerOfAttorneyPic() {
        return owerOfAttorneyPic;
    }

    public void setOwerOfAttorneyPic(List<String> owerOfAttorneyPic) {
        this.owerOfAttorneyPic = owerOfAttorneyPic;
    }

    public String getValidStartTime() {
        return validStartTime;
    }

    public void setValidStartTime(String validStartTime) {
        this.validStartTime = validStartTime;
    }

    public String getValidEndTime() {
        return validEndTime;
    }

    public void setValidEndTime(String validEndTime) {
        this.validEndTime = validEndTime;
    }
}
