package com.cross.merchants.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/*************************************************************
 * Description:
 * Author: Dairy
 * CreateTime: 2020/5/23

 ************************************************************/
@ApiModel("上传位置详情")
public class GoodsRecommendBannerPositionDTO {


    /**
     * 图片地址
     */
    @ApiModelProperty(value = "图片地址")
    private String pictureUrl;

    /**
     * 链接类型 （1 商户商铺  2 商户营业类目 3 商户商品 4 商户商品品类 5 仅展示 6 链接地址 ）
     */
    @ApiModelProperty(value = "链接类型 （1 商户商铺  2 商户营业类目 3 商户商品 4 商户商品品类 5 仅展示 6 链接地址 ）")
    private Integer linkType;

    /**
     * 链接地址url
     */
    @ApiModelProperty(value = "链接地址url")
    private String linkAddress;


    /**
     * 业务id  根据链接类型不同  如链接类型为1  businessId 代表商户商铺的id
     */
    @ApiModelProperty(value = "业务id  根据链接类型不同  如链接类型为1  businessId 代表商户商铺的id")
    private Long businessId;


    /**
     * 显示状态
     */
    @ApiModelProperty(value = "显示状态")
    private Boolean showState;


    @ApiModelProperty(value = "链接业务的名称")
    private String businessName;

    @ApiModelProperty(value = "广告状态（是否失效）")
    private Boolean bannerState;


    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Boolean getBannerState() {
        return bannerState;
    }

    public void setBannerState(Boolean bannerState) {
        this.bannerState = bannerState;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Integer getLinkType() {
        return linkType;
    }

    public void setLinkType(Integer linkType) {
        this.linkType = linkType;
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Boolean getShowState() {
        return showState;
    }

    public void setShowState(Boolean showState) {
        this.showState = showState;
    }


}
