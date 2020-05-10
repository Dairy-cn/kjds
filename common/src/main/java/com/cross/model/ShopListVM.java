package com.cross.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 马晓林
 * @since 2019/9/24 15:22
 */
public class ShopListVM {

    @ApiModelProperty(value = "店铺号")
    private Long merchantId;

    @ApiModelProperty(value = "店铺名")
    private String merchantName;

    @ApiModelProperty(value = "扫码点餐状态 0为关闭 1为打开")
    private Integer status;

    @ApiModelProperty(value = "付款模式 0为餐前 1为餐后")
    private Integer payType;

    @ApiModelProperty(value = "桌台数量")
    private Long tableCount;


    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getTableCount() {
        return tableCount;
    }

    public void setTableCount(Long tableCount) {
        this.tableCount = tableCount;
    }

    @Override
    public String toString() {
        return "ShopListVM{" +
            ", merchantName='" + merchantName + '\'' +
            ", merchantId='" + merchantId + '\'' +
            ", status=" + status +
            ", payType=" + payType +
            ", tableCount=" + tableCount +
            '}';
    }
}
