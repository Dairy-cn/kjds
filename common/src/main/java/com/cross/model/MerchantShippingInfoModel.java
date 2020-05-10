package com.cross.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class MerchantShippingInfoModel implements Serializable {

    private Long id;

    @ApiModelProperty(value = "门店编号")
    private Long merchantNo;

    @ApiModelProperty(value = "是否开启美团配送")
    private Boolean useMtShipping;

    @ApiModelProperty(value = "美团门店id")
    private String mtShopId;

    @ApiModelProperty(value = "分发配送类型 1：自动  2：手动")
    private Integer sendType;

    @ApiModelProperty(value = "接单后多少分钟发配送")
    private Integer noticeTime;

    @ApiModelProperty(value = "配送类型1:美团")
    private Integer shippingType;

    @ApiModelProperty(value = "配送范围")
    private List<List<String>> shippingRange;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(Long merchantNo) {
        this.merchantNo = merchantNo;
    }

    public Boolean getUseMtShipping() {
        return useMtShipping;
    }

    public void setUseMtShipping(Boolean useMtShipping) {
        this.useMtShipping = useMtShipping;
    }

    public String getMtShopId() {
        return mtShopId;
    }

    public void setMtShopId(String mtShopId) {
        this.mtShopId = mtShopId;
    }

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    public Integer getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Integer noticeTime) {
        this.noticeTime = noticeTime;
    }

    public Integer getShippingType() {
        return shippingType;
    }

    public void setShippingType(Integer shippingType) {
        this.shippingType = shippingType;
    }

    public List<List<String>> getShippingRange() {
        return shippingRange;
    }

    public void setShippingRange(List<List<String>> shippingRange) {
        this.shippingRange = shippingRange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MerchantShippingInfoModel that = (MerchantShippingInfoModel) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MerchantShippingInfoModel{" +
            "id=" + id +
            ", merchantNo=" + merchantNo +
            ", useMtShipping=" + useMtShipping +
            ", mtShopId='" + mtShopId + '\'' +
            ", sendType=" + sendType +
            ", noticeTime=" + noticeTime +
            ", shippingType=" + shippingType +
            ", shippingRange=" + shippingRange +
            '}';
    }
}
