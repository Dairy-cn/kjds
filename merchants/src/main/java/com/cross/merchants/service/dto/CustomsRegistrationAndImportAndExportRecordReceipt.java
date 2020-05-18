package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/*************************************************************
 * Description:海关登记书/进出口备案回执
 * Author: Dair
 * CreateTime: 2020/5/15
 ************************************************************/
@ApiModel(description = "海关登记书/进出口备案回执")
public class CustomsRegistrationAndImportAndExportRecordReceipt implements Serializable {

    @ApiModelProperty("1 海关报关单位注册登记证书  2海关进出口货物收发货人备案回执")
    private Integer cardType;

    @ApiModelProperty("海关报关单位注册登记证书")
    private List<String> registrationCertificate;

    @ApiModelProperty("海关注册编码")
    private  String registerNo;

    /**
     * 有效期(为空则永久)
     */
    @ApiModelProperty(value = "有效期(为空则永久) yyyy-mm-dd")
    private String validTime;


    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public List<String> getRegistrationCertificate() {
        return registrationCertificate;
    }

    public void setRegistrationCertificate(List<String> registrationCertificate) {
        this.registrationCertificate = registrationCertificate;
    }

    public String getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
    }

    public String getValidTime() {
        return validTime;
    }

    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }
}
