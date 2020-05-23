package com.cross.merchants.domain;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * 广告设置
 */
@Entity
@Table(name = "banner_info")
public class BannerInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 广告类型 1 商户广告 2 大后台广告 3 商户推荐广告  4 商品推荐广告
     */
    @NotNull
    @Column(name = "banner_type", nullable = false)
    private Integer bannerType;

    /**
     * 店铺id
     */
    @Column(name = "store_id")
    private Long storeId;

    /**
     * 品牌id
     */
    @Column(name = "brand_id")
    private Long brandId;

    /**
     * 位置类型 1 顶部轮播 2 弹窗 3 A区广告位
     */
    @NotNull
    @Column(name = "position_type", nullable = false)
    private Integer positionType;

    /**
     * 广告位置 1  顶部轮播   2 弹窗 3 A1 4 A2 5 A3
     */
    @NotNull
    @Column(name = "position_code", nullable = false)
    private Integer positionCode;

    /**
     * 图片名称
     */
    @NotNull
    @Column(name = "picture_name", nullable = false)
    private String pictureName;



    /**
     * 副图片名称
     */
    @Column(name = "sub_picture_name")
    private String subPictureName;

    /**
     * 图片地址
     */
    @NotNull
    @Column(name = "picture_url", nullable = false)
    private String pictureUrl;

    /**
     * 链接类型 （1 商户商铺  2 商户营业类目 3 商户商品 4 商户商品品类 5 仅展示 6 链接地址 ）
     */
    @NotNull
    @Column(name = "link_type", nullable = false)
    private Integer linkType;

    /**
     * 链接地址url
     */
    @Column(name = "link_address")
    private String linkAddress;

    /**
     * 展示频率
     */
    @Column(name = "banner_pop_setting")
    private String bannerPopSetting;

    /**
     * 显示状态
     */
    @Column(name = "show_state")
    private Boolean showState;

    /**
     * 是否置顶
     */
    @Column(name = "top")
    private Boolean top;

    /**
     * 业务id  根据链接类型不同  如链接类型为1  businessId 代表商户商铺的id
     */
    @Column(name = "business_id")
    private Long businessId;



    /**
     * 广告上传位置   1
     */
    @ApiModelProperty(value = "1 2 3 eg 如果是商品推荐广告 positionCode=7 则代表上传位置是C1-1 ")
    @Column(name = "sub_position_code")
    private Integer subPositionCode;

    @ApiModelProperty(value = "专区名称")
    @Column(name = "division_name")
    private String divisionName;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove


    public Integer getSubPositionCode() {
        return subPositionCode;
    }

    public void setSubPositionCode(Integer subPositionCode) {
        this.subPositionCode = subPositionCode;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public String getSubPictureName() {
        return subPictureName;
    }

    public void setSubPictureName(String subPictureName) {
        this.subPictureName = subPictureName;
    }

    public Boolean getShowState() {
        return showState;
    }

    public Boolean getTop() {
        return top;
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

    public BannerInfo bannerType(Integer bannerType) {
        this.bannerType = bannerType;
        return this;
    }

    public void setBannerType(Integer bannerType) {
        this.bannerType = bannerType;
    }

    public Long getStoreId() {
        return storeId;
    }

    public BannerInfo storeId(Long storeId) {
        this.storeId = storeId;
        return this;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public BannerInfo brandId(Long brandId) {
        this.brandId = brandId;
        return this;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Integer getPositionType() {
        return positionType;
    }

    public BannerInfo positionType(Integer positionType) {
        this.positionType = positionType;
        return this;
    }

    public void setPositionType(Integer positionType) {
        this.positionType = positionType;
    }

    public Integer getPositionCode() {
        return positionCode;
    }

    public BannerInfo positionCode(Integer positionCode) {
        this.positionCode = positionCode;
        return this;
    }

    public void setPositionCode(Integer positionCode) {
        this.positionCode = positionCode;
    }

    public String getPictureName() {
        return pictureName;
    }

    public BannerInfo pictureName(String pictureName) {
        this.pictureName = pictureName;
        return this;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public BannerInfo pictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Integer getLinkType() {
        return linkType;
    }

    public BannerInfo linkType(Integer linkType) {
        this.linkType = linkType;
        return this;
    }

    public void setLinkType(Integer linkType) {
        this.linkType = linkType;
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public BannerInfo linkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
        return this;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }

    public String getBannerPopSetting() {
        return bannerPopSetting;
    }

    public BannerInfo bannerPopSetting(String bannerPopSetting) {
        this.bannerPopSetting = bannerPopSetting;
        return this;
    }

    public void setBannerPopSetting(String bannerPopSetting) {
        this.bannerPopSetting = bannerPopSetting;
    }

    public Boolean isShowState() {
        return showState;
    }

    public BannerInfo showState(Boolean showState) {
        this.showState = showState;
        return this;
    }

    public void setShowState(Boolean showState) {
        this.showState = showState;
    }

    public Boolean isTop() {
        return top;
    }

    public BannerInfo top(Boolean top) {
        this.top = top;
        return this;
    }

    public void setTop(Boolean top) {
        this.top = top;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public BannerInfo businessId(Long businessId) {
        this.businessId = businessId;
        return this;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BannerInfo)) {
            return false;
        }
        return id != null && id.equals(((BannerInfo) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "BannerInfo{" +
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
