package com.cross.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author hcy
 * @descrption TODO
 * @date 2019-5-7.
 * 平台门店信息
 */
public class PlatformMerchantInfo {

    @ApiModelProperty(value = "门店id")
    private Long merchantId;

    @ApiModelProperty(value = "门店名称")
    private String merchantName;

    @ApiModelProperty(value = "门店编码")
    private Long merchantNo;

    /**
     * 第一个是经度  第二个是纬度,若门店位置进行修改，必须进行更新
     */
    @ApiModelProperty(value = "门店位置")
    private String merchantPosition;

    public PlatformMerchantInfo() {
    }


    public PlatformMerchantInfo(Long merchantId, String merchantName, Long merchantNo, String merchantPosition) {
        this.merchantId = merchantId;
        this.merchantName = merchantName;
        this.merchantNo = merchantNo;
        this.merchantPosition = merchantPosition;
    }

    public String getMerchantPosition() {
        return merchantPosition;
    }

    public void setMerchantPosition(String merchantPosition) {
        this.merchantPosition = merchantPosition;
    }

    public Long getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(Long merchantNo) {
        this.merchantNo = merchantNo;
    }

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
}
