package com.cross.model.island.rewardspool;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.cross.enumtype.IslandTask;
import com.cross.model.enumeration.CouponType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@ApiModel(description = "优惠券领用及使用记录")
public class IslandCouponUseHistoryDTO implements Serializable {

    private Long id;
    /**
     * 领取优惠券的用户ID
     */
    @ApiModelProperty(value = "领取优惠券的用户ID")
    private Long userId;


    /**
     * 领取优惠券的小程序表ID
     */
    @ApiModelProperty(value = "领取优惠券的小程序表ID")
    private Long weappUserId;

    /**
     * 优惠券记录表ID
     */
    @ApiModelProperty(value = "优惠券记录表ID")
    private Long cpId;

    /**
     * 优惠券ID
     */
    @ApiModelProperty(value = "优惠券ID")
    private String couponId;

    /**
     * 优惠券名称
     */
    @ApiModelProperty(value = "优惠券名称")
    private String couponName;

    /**
     * 优惠券获取后有效天数
     */
    @ApiModelProperty(value = "优惠券获取后有效天数")
    private Integer days;
    /**
     * 优惠券领用时间
     */
    @ApiModelProperty(value = "优惠券领用时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime insertDate;
    /**
     * 优惠券使用截止时间
     */
    @ApiModelProperty(value = "优惠券使用截止时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime endDate;

    /**
     * 使用优惠券订单ID
     */
    @ApiModelProperty(value = "使用优惠券订单ID")
    private String orderSn;

    /**
     * 优惠券使用时间
     */
    @ApiModelProperty(value = "优惠券使用时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime useDate;

    /**
     * 优惠券使用类型
     */
    @ApiModelProperty(value = "优惠券使用类型")
    private String useType;

    /**
     * 优惠券面额
     */
    @ApiModelProperty(value = "优惠券面额")
    private Float amountOfCoupon;

    /**
     * 满需金额
     */
    @ApiModelProperty(value = "满需金额")
    private Float demandPrice;

    /**
     * 券面类型  PLATFORM_USE:平台通用 TO_THE_SHOP:到店消费 WU_LIU:物流到家 TAKE_OUT:外卖专用
     */
    @ApiModelProperty(value = "PLATFORM_USE:平台通用 TO_THE_SHOP:到店消费 WU_LIU:物流到家 TAKE_OUT:外卖专用")
    private CouponType couponType;

    /**
     * 使用须知
     */
    @ApiModelProperty(value = "使用须知")
    private String details;

    /**
     * 优惠券使用状态 0：未使用 1：已使用
     */
    @ApiModelProperty(value = "优惠券使用状态 0：未使用 1：已使用")
    private Integer status;


    @ApiModelProperty(value = "来源  UPGRADE 升级, OPEN_USER_MEMBER 开通会员,  PERFECT_INFORMATION 完善信息；AUTH_SUCCESS_EXPERT 认证成功1个渠道达人,AUTH_SUCCESS_UPGRADE_EXPERT 认证成功升级1个渠道达人 ,OPNE_DISTRIBUTER 开通合伙人权益,UPGRADE_EXPERT_DISTRIBUTER 升级成为高级合伙人,FINISH_ONE_PROMOTION_TASK 完成1个推广任务, BUY_PLATFORM_PRODUCTS 完成1次平台商品自购买消费,SUCCESS_DISTRIBUTER_SELF_PRODUCTS 成功分销1次自营商品")
    private IslandTask obtainType;

    /**
     * 平台编号
     */
    @ApiModelProperty(value = "平台编号")
    private Long platFormId;

    /**
     * 发放优惠券总数
     */
    @ApiModelProperty(value = "发放优惠券总数")
    private Long totalNum;

    /**
     * 使用优惠券总数
     */
    @ApiModelProperty(value = "使用优惠券总数")
    private Long usedNum;

    public IslandCouponUseHistoryDTO() {
    }

    public IslandCouponUseHistoryDTO(Long totalNum, Long usedNum) {
        this.totalNum = totalNum;
        this.usedNum = usedNum;
    }

    public Long getWeappUserId() {
        return weappUserId;
    }

    public void setWeappUserId(Long weappUserId) {
        this.weappUserId = weappUserId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public LocalDateTime getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDateTime insertDate) {
        this.insertDate = insertDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getUseDate() {
        return useDate;
    }

    public void setUseDate(LocalDateTime useDate) {
        this.useDate = useDate;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    public Float getAmountOfCoupon() {
        return amountOfCoupon;
    }

    public void setAmountOfCoupon(Float amountOfCoupon) {
        this.amountOfCoupon = amountOfCoupon;
    }

    public Float getDemandPrice() {
        return demandPrice;
    }

    public void setDemandPrice(Float demandPrice) {
        this.demandPrice = demandPrice;
    }

    public CouponType getCouponType() {
        return couponType;
    }

    public void setCouponType(CouponType couponType) {
        this.couponType = couponType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public IslandTask getObtainType() {
        return obtainType;
    }

    public void setObtainType(IslandTask obtainType) {
        this.obtainType = obtainType;
    }

    public Long getPlatFormId() {
        return platFormId;
    }

    public void setPlatFormId(Long platFormId) {
        this.platFormId = platFormId;
    }

    public Long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }

    public Long getUsedNum() {
        return usedNum;
    }

    public void setUsedNum(Long usedNum) {
        this.usedNum = usedNum;
    }

    public Long getCpId() {
        return cpId;
    }

    public void setCpId(Long cpId) {
        this.cpId = cpId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IslandCouponUseHistoryDTO islandCouponUseHistoryDTO = (IslandCouponUseHistoryDTO) o;
        if (islandCouponUseHistoryDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), islandCouponUseHistoryDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "IslandCouponUseHistoryDTO{" +
            "id=" + id +
            ", userId=" + userId +
            ", cpId=" + cpId +
            ", weappUserId=" + weappUserId +
            ", couponId='" + couponId + '\'' +
            ", couponName='" + couponName + '\'' +
            ", days=" + days +
            ", insertDate=" + insertDate +
            ", endDate=" + endDate +
            ", orderSn='" + orderSn + '\'' +
            ", useDate=" + useDate +
            ", useType='" + useType + '\'' +
            ", amountOfCoupon=" + amountOfCoupon +
            ", demandPrice=" + demandPrice +
            ", couponType=" + couponType +
            ", details='" + details + '\'' +
            ", status=" + status +
            ", obtainType=" + obtainType +
            ", platFormId=" + platFormId +
            ", totalNum=" + totalNum +
            ", usedNum=" + usedNum +
            '}';
    }
}
