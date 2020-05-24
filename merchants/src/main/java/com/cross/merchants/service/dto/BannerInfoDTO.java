package com.cross.merchants.service.dto;

import com.cross.enumtype.PlatformSystemBannerPopSettingVM;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.merchants.domain.BannerInfo} entity.
 */
@ApiModel(description = "广告设置")
public class BannerInfoDTO implements Serializable {

    private Long id;

    /**
     * 广告类型 1 商户广告 2 大后台广告 3 商户推荐广告
     */
    @NotNull
    @ApiModelProperty(value = "广告类型 1 商户广告 2 大后台广告 3 商户推荐广告 ", required = true)
    private Integer bannerType;

    /**
     * 店铺id
     */
    @ApiModelProperty(value = "店铺id")
    private Long storeId;

    /**
     * 品牌id
     */
    @ApiModelProperty(value = "品牌id")
    private Long brandId;

    /**
     * 位置类型 1 顶部轮播 2 弹窗 3 A区广告位
     */
    @NotNull
    @ApiModelProperty(value = "位置类型 1 顶部轮播 2 弹窗 3 A区广告位 4 B区广告位  ", required = true)
    private Integer positionType;

    /**
     * 广告位置 1  顶部轮播   2 弹窗 3 A1 4 A2 5 A3
     */
    @NotNull
    @ApiModelProperty(value = "广告位置 1  顶部轮播   2 弹窗 3 A1 4 A2 5 A3  6 B1 ", required = true)
    private Integer positionCode;



    /**
     * 图片名称
     */
    @NotNull
    @ApiModelProperty(value = "图片名称", required = true)
    private String pictureName;

    /**
     * 图片地址
     */
    @NotNull
    @ApiModelProperty(value = "图片地址", required = true)
    private String pictureUrl;

    /**
     * 链接类型 （1 商户商铺  2 商户营业类目 3 商户商品 4 商户商品品类 5 仅展示 6 链接地址 ）
     */
    @NotNull
    @ApiModelProperty(value = "链接类型 （1 商户商铺  2 商户营业类目 3 商户商品 4 商户商品品类 5 仅展示 6 链接地址 ）", required = true)
    private Integer linkType;

    /**
     * 链接地址url
     */
    @ApiModelProperty(value = "链接地址url")
    private String linkAddress;

    /**
     * 展示频率
     */
    @ApiModelProperty(value = "展示频率")
    private List<PlatformSystemBannerPopSettingVM> bannerPopSetting;

    /**
     * 显示状态
     */
    @ApiModelProperty(value = "显示状态")
    private Boolean showState;

    /**
     * 是否置顶
     */
    @ApiModelProperty(value = "是否置顶")
    private Boolean top;

    /**
     * 业务id  根据链接类型不同  如链接类型为1  businessId 代表商户商铺的id
     */
    @ApiModelProperty(value = "业务id  根据链接类型不同  如链接类型为1  businessId 代表商户商铺的id")
    private Long businessId;


    /**
     * 副图片名称
     */
    @ApiModelProperty(value = "副图片名称")
    private String subPictureName;

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

    public String getSubPictureName() {
        return subPictureName;
    }

    public void setSubPictureName(String subPictureName) {
        this.subPictureName = subPictureName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBannerType() {
        return bannerType;
    }

    public void setBannerType(Integer bannerType) {
        this.bannerType = bannerType;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Integer getPositionType() {
        return positionType;
    }

    public void setPositionType(Integer positionType) {
        this.positionType = positionType;
    }

    public Integer getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(Integer positionCode) {
        this.positionCode = positionCode;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
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

    public List<PlatformSystemBannerPopSettingVM> getBannerPopSetting() {
        return bannerPopSetting;
    }

    public void setBannerPopSetting(List<PlatformSystemBannerPopSettingVM> bannerPopSetting) {
        this.bannerPopSetting = bannerPopSetting;
    }

    public Boolean getShowState() {
        return showState;
    }

    public Boolean getTop() {
        return top;
    }

    public Boolean isShowState() {
        return showState;
    }

    public void setShowState(Boolean showState) {
        this.showState = showState;
    }

    public Boolean isTop() {
        return top;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BannerInfoDTO bannerInfoDTO = (BannerInfoDTO) o;
        if (bannerInfoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), bannerInfoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BannerInfoDTO{" +
            "id=" + getId() +
            ", bannerType=" + getBannerType() +
            ", storeId=" + getStoreId() +
            ", brandId=" + getBrandId() +
            ", positionType=" + getPositionType() +
            ", positionCode=" + getPositionCode() +
            ", pictureName='" + getPictureName() + "'" +
            ", pictureUrl='" + getPictureUrl() + "'" +
            ", linkType=" + getLinkType() +
            ", linkAddress='" + getLinkAddress() + "'" +
            ", bannerPopSetting='" + getBannerPopSetting() + "'" +
            ", showState='" + isShowState() + "'" +
            ", top='" + isTop() + "'" +
            ", businessId=" + getBusinessId() +
            "}";
    }
}
