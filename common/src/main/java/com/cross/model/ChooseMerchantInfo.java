package com.cross.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author hcy
 * @descrption TODO
 * @date 2019-9-5.
 */
public class ChooseMerchantInfo {


    @ApiModelProperty(value = "门店id")
    private Long merchantId;

    @ApiModelProperty(value = "门店名称")
    private String merchantName;

    @ApiModelProperty(value = "门店编码")
    private Long merchantNo;

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Long getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(Long merchantNo) {
        this.merchantNo = merchantNo;
    }
}
