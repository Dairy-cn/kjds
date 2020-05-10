package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.cross.enumtype.UserProfitType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.island.domain.UserProfit} entity.
 */
@ApiModel(description = "达人收益明细")
public class UserProfitDTO implements Serializable {

    private Long id;

    /**
     * 平台id
     */
    @NotNull
    @ApiModelProperty(value = "平台id", required = true)
    private Long platformId;

    /**
     * 达人id
     */
    @ApiModelProperty(value = "达人id")
    private Long userId;


    /**
     * 小程序用户id
     */
    @ApiModelProperty(value = "小程序用户id")
    private Long weappUserId;

    /**
     * 订单Sn
     */
    @ApiModelProperty(value = "订单Sn")
    private String orderSn;

    /**
     * 订单Sn
     */
    @ApiModelProperty(value = "订单Id")
    private Long orderId;

    /**
     * 变动金额
     */
    @ApiModelProperty(value = "变动金额")
    private BigDecimal changeAmount;

    /**
     * 变动后金额
     */
    @ApiModelProperty(value = "变动后金额")
    private BigDecimal profit;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;

    /**
     * 变动日期
     */
    @ApiModelProperty(value = "变动日期")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime changeDate;

    /**
     * 变动IP
     */
    @Size(max = 60)
    @ApiModelProperty(value = "变动IP")
    private String changeIp;

    @ApiModelProperty(value = "用户收益类型 DISTRIBUTOR_CARD_REWARDS_POOL_PROFIT 分销通吃卡瓜分赏金池 PROMOTION_PROFIT 宣发收益, DISTRIBUTOR_GOODS_PROFIT 分销商品收益，  DISTRIBUTOR_CARD_PROFIT 分销通吃卡收益")
    private UserProfitType userProfitType;

    @ApiModelProperty(value = "宣发收益渠道id")
    private Long placeId;

    @ApiModelProperty(value = "宣发收益渠道")
    private String placeName;


    @ApiModelProperty(value = "分销类型 1 自购 2 下级购买")
    private Integer distributorType;



    @ApiModelProperty(value = "宣发收益门店名")
    private String promotionMerchantName;


    @ApiModelProperty(value = "宣发收益门店头像")
    private String promotionMerchantHeadPic;


    @ApiModelProperty(value = " 分销商品名")
    private String distributorShopName;

    @ApiModelProperty(value = "通吃卡返现收益利益提供者  开通者")
    private Long tcCardOpenWeappUserId;
    
    
    /**
     * 交易金额
     */
    @ApiModelProperty(value = "交易金额(订单交易金额)")
    private BigDecimal transactionAmount;
    
    /**
     * 交易单号
     */
    @ApiModelProperty(value = "交易单号")
    private String paymentOrderCode;


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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public BigDecimal getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(BigDecimal changeAmount) {
        this.changeAmount = changeAmount;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDateTime changeDate) {
        this.changeDate = changeDate;
    }

    public String getChangeIp() {
        return changeIp;
    }

    public void setChangeIp(String changeIp) {
        this.changeIp = changeIp;
    }

    public UserProfitType getUserProfitType() {
        return userProfitType;
    }

    public void setUserProfitType(UserProfitType userProfitType) {
        this.userProfitType = userProfitType;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Integer getDistributorType() {
        return distributorType;
    }

    public void setDistributorType(Integer distributorType) {
        this.distributorType = distributorType;
    }



    public String getPromotionMerchantName() {
        return promotionMerchantName;
    }

    public void setPromotionMerchantName(String promotionMerchantName) {
        this.promotionMerchantName = promotionMerchantName;
    }

    public String getPromotionMerchantHeadPic() {
        return promotionMerchantHeadPic;
    }

    public void setPromotionMerchantHeadPic(String promotionMerchantHeadPic) {
        this.promotionMerchantHeadPic = promotionMerchantHeadPic;
    }

    public String getDistributorShopName() {
        return distributorShopName;
    }

    public void setDistributorShopName(String distributorShopName) {
        this.distributorShopName = distributorShopName;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Long getWeappUserId() {
        return weappUserId;
    }

    public void setWeappUserId(Long weappUserId) {
        this.weappUserId = weappUserId;
    }

    public Long getTcCardOpenWeappUserId() {
        return tcCardOpenWeappUserId;
    }

    public void setTcCardOpenWeappUserId(Long tcCardOpenWeappUserId) {
        this.tcCardOpenWeappUserId = tcCardOpenWeappUserId;
    }
    
    
    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }
    
    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
    
    public String getPaymentOrderCode() {
        return paymentOrderCode;
    }
    
    public void setPaymentOrderCode(String paymentOrderCode) {
        this.paymentOrderCode = paymentOrderCode;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserProfitDTO expertProfitDTO = (UserProfitDTO) o;
        if (expertProfitDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), expertProfitDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
    
    
    @Override
    public String toString() {
        return "UserProfitDTO{" +
            "id=" + id +
            ", platformId=" + platformId +
            ", userId=" + userId +
            ", weappUserId=" + weappUserId +
            ", orderSn='" + orderSn + '\'' +
            ", orderId=" + orderId +
            ", changeAmount=" + changeAmount +
            ", profit=" + profit +
            ", createTime=" + createTime +
            ", changeDate=" + changeDate +
            ", changeIp='" + changeIp + '\'' +
            ", userProfitType=" + userProfitType +
            ", placeId=" + placeId +
            ", placeName='" + placeName + '\'' +
            ", distributorType=" + distributorType +
            ", promotionMerchantName='" + promotionMerchantName + '\'' +
            ", promotionMerchantHeadPic='" + promotionMerchantHeadPic + '\'' +
            ", distributorShopName='" + distributorShopName + '\'' +
            ", tcCardOpenWeappUserId=" + tcCardOpenWeappUserId +
            ", transactionAmount=" + transactionAmount +
            ", paymentOrderCode='" + paymentOrderCode + '\'' +
            '}';
    }
}
