package com.cross.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the SystemSetting entity.
 */
public class SystemSettingDTO implements Serializable {

    private Long id;

    /**
     * 心跳频率
     */
    @ApiModelProperty(value = "心跳频率")
    private Double heartbeat;

    /**
     * 域名
     */
    @ApiModelProperty(value = "域名")
    private String domain;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 默认首页
     */
    @ApiModelProperty(value = "默认首页")
    private String defaultPage;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 关键字
     */
    @ApiModelProperty(value = "关键字")
    private String keywords;

    /**
     * 公告
     */
    @ApiModelProperty(value = "公告")
    private String announcement;

    /**
     * 客服电话
     */
    @ApiModelProperty(value = "客服电话")
    private String consumerHotline;

    /**
     * 省
     */
    @ApiModelProperty(value = "省")
    private String province;

    /**
     * 市
     */
    @ApiModelProperty(value = "市")
    private String city;

    /**
     * 区
     */
    @ApiModelProperty(value = "区")
    private String county;

    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
    private String address;

    /**
     * logo
     */
    @ApiModelProperty(value = "logo")
    private String logo;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String avatar;

    /**
     * 精彩推荐名称
     */
    @ApiModelProperty(value = "精彩推荐名称")
    private String recommendName;

    /**
     * 营业时间
     */
    @ApiModelProperty(value = "营业时间")
    private String businessHours;

    /**
     * 全站打烊
     */
    @ApiModelProperty(value = "全站打烊")
    private Boolean wholeClose = false;

    /**
     * 是否自动停业
     */
    @ApiModelProperty(value = "是否自动停业")
    private Boolean automaticClosure = false;

    /**
     * 自动停业数量
     */
    @ApiModelProperty(value = "自动停业数量")
    private Integer closedNumber;

    private Integer openNumber;

    private Long platFormUserId;

    /**
     * 首页形态  0: 平台形态  1：特惠形态 2: 品牌形态  3：单店模式
     */
    private Integer homeModel;

    /**
     * 分享话术
     */
    @ApiModelProperty(value = "分享话术")
    private String shareContent;

    public String getShareContent() {
        return shareContent;
    }

    public void setShareContent(String shareContent) {
        this.shareContent = shareContent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getHeartbeat() {
        return heartbeat;
    }

    public void setHeartbeat(Double heartbeat) {
        this.heartbeat = heartbeat;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefaultPage() {
        return defaultPage;
    }

    public void setDefaultPage(String defaultPage) {
        this.defaultPage = defaultPage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getConsumerHotline() {
        return consumerHotline;
    }

    public void setConsumerHotline(String consumerHotline) {
        this.consumerHotline = consumerHotline;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRecommendName() {
        return recommendName;
    }

    public void setRecommendName(String recommendName) {
        this.recommendName = recommendName;
    }

    public Long getPlatFormUserId() {
        return platFormUserId;
    }

    public void setPlatFormUserId(Long platFormUserId) {
        this.platFormUserId = platFormUserId;
    }

    public String getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours;
    }

    public Boolean isAutomaticClosure() {
        return automaticClosure;
    }

    public void setAutomaticClosure(Boolean automaticClosure) {
        this.automaticClosure = automaticClosure;
    }

    public Integer getClosedNumber() {
        return closedNumber;
    }

    public void setClosedNumber(Integer closedNumber) {
        this.closedNumber = closedNumber;
    }

    public Boolean isWholeClose() {
        return wholeClose;
    }

    public void setWholeClose(Boolean wholeClose) {
        this.wholeClose = wholeClose;
    }

    public Integer getOpenNumber() {
        return openNumber;
    }

    public void setOpenNumber(Integer openNumber) {
        this.openNumber = openNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SystemSettingDTO systemSettingDTO = (SystemSettingDTO) o;
        if(systemSettingDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), systemSettingDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SystemSettingDTO{" +
            "id=" + getId() +
            ", heartbeat='" + getHeartbeat() + "'" +
            ", domain='" + getDomain() + "'" +
            ", name='" + getName() + "'" +
            ", defaultPage='" + getDefaultPage() + "'" +
            ", description='" + getDescription() + "'" +
            ", keywords='" + getKeywords() + "'" +
            ", announcement='" + getAnnouncement() + "'" +
            ", consumerHotline='" + getConsumerHotline() + "'" +
            ", province='" + getProvince() + "'" +
            ", city='" + getCity() + "'" +
            ", county='" + getCounty() + "'" +
            ", address='" + getAddress() + "'" +
            ", logo='" + getLogo() + "'" +
            ", avatar='" + getAvatar() + "'" +
            "}";
    }

    public Integer getHomeModel() {
        return homeModel;
    }

    public void setHomeModel(Integer homeModel) {
        this.homeModel = homeModel;
    }
}
