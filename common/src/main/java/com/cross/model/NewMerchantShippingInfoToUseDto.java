package com.cross.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("门店配送配置信息")
public class NewMerchantShippingInfoToUseDto {
    private Long id;

    /**
     * 门店id
     */
    @ApiModelProperty(value = "门店id")
    private Long merchantId;

    /**
     * 门店编号
     */
    @ApiModelProperty(value = "门店编号")
    private Long merchantNo;

    /**
     * 是否开启美团配送
     */
    @ApiModelProperty(value = "是否开启美团配送")
    private Boolean useMtShipping;

    /**
     * 美团门店id
     */
    @ApiModelProperty(value = "美团门店id")
    private String mtShopId;

    /**
     * 分发配送类型 1：自动  2：手动
     */
    @ApiModelProperty(value = "分发配送类型 1：自动  2：手动")
    private Integer sendType;

    /**
     * 接单后多少分钟发配送
     */
    @ApiModelProperty(value = "接单后多少分钟发配送")
    private Integer noticeTime;

    /**
     * 配送范围
     */
    @ApiModelProperty(value = "配送范围")
    private String shippingRange;

    /**
     * 配送类型1:美团 2.自配送
     */
    @ApiModelProperty(value = "配送类型1:美团 2.自配送")
    private Integer shippingType;

    /**
     * 起送价格
     */
    @ApiModelProperty(value = "起送价格")
    private Double sendingPrice;

    @ApiModelProperty(value = "价格和配送范围对应关系集合")
    private List<PriceAndRangeDto> priceAndRangeDtoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
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

    public String getShippingRange() {
        return shippingRange;
    }

    public void setShippingRange(String shippingRange) {
        this.shippingRange = shippingRange;
    }

    public Integer getShippingType() {
        return shippingType;
    }

    public void setShippingType(Integer shippingType) {
        this.shippingType = shippingType;
    }

    public Double getSendingPrice() {
        return sendingPrice;
    }

    public void setSendingPrice(Double sendingPrice) {
        this.sendingPrice = sendingPrice;
    }

    public List<PriceAndRangeDto> getPriceAndRangeDtoList() {
        return priceAndRangeDtoList;
    }

    public void setPriceAndRangeDtoList(List<PriceAndRangeDto> priceAndRangeDtoList) {
        this.priceAndRangeDtoList = priceAndRangeDtoList;
    }
}
