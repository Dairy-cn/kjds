package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/*************************************************************
 * Description: 境内企业承诺书
 * Author: Dair
 * CreateTime: 2020/5/15
 ************************************************************/
@ApiModel(description = "境内企业承诺书")
public class CommitmentLetterOfDomesticEnterprise implements Serializable {


    @ApiModelProperty("境内企业承诺书地址")
    private List<String> picAddress;



    /**
     * 有效期(为空则永久)
     */
    @ApiModelProperty(value = "有效期(为空则永久) yyyy-mm-dd")
    private String validTime;

    public List<String> getPicAddress() {
        return picAddress;
    }

    public void setPicAddress(List<String> picAddress) {
        this.picAddress = picAddress;
    }

    public String getValidTime() {
        return validTime;
    }

    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }
}
