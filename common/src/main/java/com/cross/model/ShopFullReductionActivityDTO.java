package com.cross.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the ShopFullReductionActivity entity.
 */
@Data
public class ShopFullReductionActivityDTO implements Serializable {
    
    
    private static final long serialVersionUID = -2533717429685006606L;
    private Long id;
    
    @ApiModelProperty(value = "管理员id")
    private Long userId;
    
    @ApiModelProperty(value = "品牌id，现在是平台模式，品牌id淘汰")
    private Long brandId;
    
    @ApiModelProperty(value = "商户id")
    private Long merchantId;

    @ApiModelProperty(value = "商户名字")
    private String merchantName;

    @ApiModelProperty(value = "品牌名字")
    private String brandName;
    

    
    
    @ApiModelProperty(value = "添加时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant addTime;
    
    @ApiModelProperty(value = "是否与商品优惠活动共享")
    private Boolean offerActivity = Boolean.FALSE;
    
    @ApiModelProperty(value = "是否与分享活动共享")
    private Boolean shareActivity = Boolean.FALSE;
    
    @ApiModelProperty(value = "是否支持分销订单")
    private Boolean distributionOrder = Boolean.FALSE;
    
    /**
     * 满减金额
     */
    @ApiModelProperty(value = "满减金额")
    private List<FullReductionDTO> fullReductionlist;


    /**
     * 业务类型
     */
    @ApiModelProperty(value = "业务类型 为空是外卖业务  为0是堂食业务即扫码点餐")
    private Integer businessType;
    
    
    /**
     * 活动类型
     * ACITIVITY_BONUS("红包", 1),
     * ACITIVITY_FULL_SUB("满减", 2),
     * ACCTIVITY_SPIKE("秒杀",3),
     * ACCTIVITY_SHARE("分享",4),
     * ACCTIVITY_OFFER("优惠",5),
     * COUPON_OFFER("优惠券满减",6);
     */
    @ApiModelProperty(value = "活动类型")
    private Integer activityType;
    
    
    @ApiModelProperty(value = "优惠商品类型 1 原价商品 2优惠商品 4 必选商品 0 关闭时默认传值")
    private Integer activityShopType;
    
    
    @ApiModelProperty(value = "是否开启满减活动")
    private Boolean openActivity;
    
    @ApiModelProperty(value = "平台id")
    private Long platformId;
    
    
    
    
    
    public Integer getActivityShopType() {
        return activityShopType;
    }
    
    
    
    public void setActivityShopType(Integer activityShopType) {
        this.activityShopType = activityShopType;
    }
    

    
    public Long getPlatformId() {
        return platformId;
    }
    
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Boolean getOpenActivity() {
        return openActivity;
    }
    
    public void setOpenActivity(Boolean openActivity) {
        this.openActivity = openActivity;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Integer getActivityType() {
        return activityType;
    }
    
    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }
    
    public Boolean getOfferActivity() {
        return offerActivity;
    }
    
    public Boolean getShareActivity() {
        return shareActivity;
    }
    
    public Boolean getDistributionOrder() {
        return distributionOrder;
    }
    
    public List<FullReductionDTO> getFullReductionlist() {
        return fullReductionlist;
    }
    
    public void setFullReductionlist(List<FullReductionDTO> fullReductionlist) {
        this.fullReductionlist = fullReductionlist;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public Long getBrandId() {
        return brandId;
    }
    
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
    
    public Long getMerchantId() {
        return merchantId;
    }
    
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }
    
    public Instant getAddTime() {
        return addTime;
    }
    
    public void setAddTime(Instant addTime) {
        this.addTime = addTime;
    }
    
    public Boolean isOfferActivity() {
        return offerActivity;
    }
    
    public void setOfferActivity(Boolean offerActivity) {
        this.offerActivity = offerActivity;
    }
    
    public Boolean isShareActivity() {
        return shareActivity;
    }
    
    public void setShareActivity(Boolean shareActivity) {
        this.shareActivity = shareActivity;
    }
    
    public Boolean isDistributionOrder() {
        return distributionOrder;
    }
    
    public void setDistributionOrder(Boolean distributionOrder) {
        this.distributionOrder = distributionOrder;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        ShopFullReductionActivityDTO shopFullReductionActivityDTO = (ShopFullReductionActivityDTO) o;
        if (shopFullReductionActivityDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), shopFullReductionActivityDTO.getId());
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ShopFullReductionActivityDTO{" +
            "id=" + id +
            ", userId=" + userId +
            ", brandId=" + brandId +
            ", merchantId=" + merchantId +
            ", merchantName='" + merchantName + '\'' +
            ", addTime=" + addTime +
            ", offerActivity=" + offerActivity +
            ", shareActivity=" + shareActivity +
            ", distributionOrder=" + distributionOrder +
            ", fullReductionlist=" + fullReductionlist +
            ", businessType=" + businessType +
            ", activityType=" + activityType +
            ", activityShopType=" + activityShopType +
            ", openActivity=" + openActivity +
            ", platformId=" + platformId +
            '}';
    }
}
