package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.cross.platform.domain.PlatformMerchatRecommend} entity.
 */
@ApiModel(description = "平台商户推荐")
public class PlatformMerchatRecommendModel implements Serializable {

    private Long id;

    /**
     * 平台id
     */
    @ApiModelProperty(value = "平台id", required = true)
    private Long platformId;

    /**
     * 商户id
     */
    @ApiModelProperty(value = "商户id", required = true)
    private Long merchantId;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer order;

    /**
     * 图片展示 1 菜品 2 门店
     */
    @ApiModelProperty(value = "图片展示 1 菜品 2 门店")
    private Integer picShowType;

    /**
     * 商品推荐类型{@link com.cross.platform.enums.PlatFormMerchatRecommendTypeEnum}
     */
    @ApiModelProperty(value = "1 首页 2 闲时约饭 3  外卖到家 4  到店特惠")
    private Integer type;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant updateTime;
    /**
     * 门店模式
     */
    @ApiModelProperty(value = "门店模式  1堂吃 2外卖 4:物流")
    private String outerOrderMod;
    /**
     * 门店名称
     */
    @ApiModelProperty(value = "门店名称")
    private String merchantName;
    /**
     * 品牌id
     */
    @ApiModelProperty(value = "品牌id")
    private Long brandId;
    /**
     * 品牌名
     */
    @ApiModelProperty(value = "品牌名")
    private String brandName;
    /**
     * 门店类型
     */
    @ApiModelProperty(value = "门店类型")
    private String merchantType;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态  0休息 1营业 2打烊 3忙碌 ")
    private Integer state;

    /**
     * 图片
     */
    @ApiModelProperty(value = "图片")
    private String picUrl;
    
    
    
    /**
     * 置顶时间
     */
    @ApiModelProperty(value = "置顶时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant topTime;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getPlatformId() {
        return platformId;
    }
    
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }
    
    public Long getMerchantId() {
        return merchantId;
    }
    
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }
    
    public Integer getOrder() {
        return order;
    }
    
    public void setOrder(Integer order) {
        this.order = order;
    }
    
    public Integer getPicShowType() {
        return picShowType;
    }
    
    public void setPicShowType(Integer picShowType) {
        this.picShowType = picShowType;
    }
    
    public Integer getType() {
        return type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }
    
    public Instant getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }
    
    public Instant getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(Instant updateTime) {
        this.updateTime = updateTime;
    }
    
    public String getOuterOrderMod() {
        return outerOrderMod;
    }
    
    public void setOuterOrderMod(String outerOrderMod) {
        this.outerOrderMod = outerOrderMod;
    }
    
    public String getMerchantName() {
        return merchantName;
    }
    
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
    
    
    public Long getBrandId() {
        return brandId;
    }
    
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
    
    public String getBrandName() {
        return brandName;
    }
    
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    
    public String getMerchantType() {
        return merchantType;
    }
    
    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType;
    }
    
    public Integer getState() {
        return state;
    }
    
    public void setState(Integer state) {
        this.state = state;
    }
    
    public String getPicUrl() {
        return picUrl;
    }
    
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
    
    public Instant getTopTime() {
        return topTime;
    }
    
    public void setTopTime(Instant topTime) {
        this.topTime = topTime;
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        PlatformMerchatRecommendModel that = (PlatformMerchatRecommendModel) o;
        
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (platformId != null ? !platformId.equals(that.platformId) : that.platformId != null) return false;
        if (merchantId != null ? !merchantId.equals(that.merchantId) : that.merchantId != null) return false;
        if (order != null ? !order.equals(that.order) : that.order != null) return false;
        if (picShowType != null ? !picShowType.equals(that.picShowType) : that.picShowType != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (outerOrderMod != null ? !outerOrderMod.equals(that.outerOrderMod) : that.outerOrderMod != null)
            return false;
        if (merchantName != null ? !merchantName.equals(that.merchantName) : that.merchantName != null) return false;
        if (brandId != null ? !brandId.equals(that.brandId) : that.brandId != null) return false;
        if (brandName != null ? !brandName.equals(that.brandName) : that.brandName != null) return false;
        if (merchantType != null ? !merchantType.equals(that.merchantType) : that.merchantType != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (picUrl != null ? !picUrl.equals(that.picUrl) : that.picUrl != null) return false;
        return topTime != null ? topTime.equals(that.topTime) : that.topTime == null;
    
    }
    
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (platformId != null ? platformId.hashCode() : 0);
        result = 31 * result + (merchantId != null ? merchantId.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (picShowType != null ? picShowType.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (outerOrderMod != null ? outerOrderMod.hashCode() : 0);
        result = 31 * result + (merchantName != null ? merchantName.hashCode() : 0);
        result = 31 * result + (brandId != null ? brandId.hashCode() : 0);
        result = 31 * result + (brandName != null ? brandName.hashCode() : 0);
        result = 31 * result + (merchantType != null ? merchantType.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (picUrl != null ? picUrl.hashCode() : 0);
        result = 31 * result + (topTime != null ? topTime.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "PlatformMerchatRecommendDTO{" +
            "id=" + id +
            ", platformId=" + platformId +
            ", merchantId=" + merchantId +
            ", order=" + order +
            ", picShowType=" + picShowType +
            ", type=" + type +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", outerOrderMod='" + outerOrderMod + '\'' +
            ", merchantName='" + merchantName + '\'' +
            ", brandId=" + brandId +
            ", brandName='" + brandName + '\'' +
            ", merchantType='" + merchantType + '\'' +
            ", state=" + state +
            ", picUrl='" + picUrl + '\'' +
            ", topTime=" + topTime +
            '}';
    }
}
