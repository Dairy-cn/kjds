package com.cross.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.cross.enumtype.IslandFreeLunchStatusType;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.cross.model.enumeration.IslandFreeLunchCondition;
import com.cross.model.enumeration.IslandFreeLunchUserIdentity;
import com.cross.model.island.freelunch.IslandFreeLunchWinRatioConfigVM;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * 霸王餐活动
 */
@ApiModel(description = "霸王餐活动")
public class IslandFreeLunchDTO implements Serializable {
        private Long id;

        /**
         * 平台编号
         */
        @ApiModelProperty(value = "平台编号")
        private Long platFormId;

        /**
         * 霸王餐活动名称
         */
        @ApiModelProperty(value = "霸王餐活动名称")
        private String name;

        /**
         * 霸王餐活动商家id
         */
        @ApiModelProperty(value = "霸王餐活动商家id")
        private Long merchantId;

        /**
         * 霸王餐活动商家名称
         */
        @ApiModelProperty(value = "霸王餐活动商家名称")
        private String merchantName;

        /**
         * 霸王餐活动商家（品牌ID）
         */
        @ApiModelProperty(value = "霸王餐活动商家（品牌ID）")
        private Long brandId;

        /**
         * 霸王餐活动商家（品牌名称）
         */
        @ApiModelProperty(value = "霸王餐活动商家（品牌名称）")
        private String brandName;
        /**
         * 霸王餐活动商品id
         */
        @ApiModelProperty(value = "霸王餐活动商品id")
        private Long productId;

        /**
         * 霸王餐活动商品名称
         */
        @ApiModelProperty(value = "霸王餐活动商品名称")
        private String productName;
        /**
         * 霸王餐活动商品规格
         */
        @ApiModelProperty(value = "霸王餐活动商品规格")
        private Long skuId;

        /**
         * 霸王餐活动商品单价
         */
        @ApiModelProperty(value = "霸王餐活动商品单价")
        private Float productPrice;

        /**
         * 霸王餐活动商品总数
         */
        @ApiModelProperty(value = "霸王餐活动商品总数")
        private Integer productNum;

        /**
         * 霸王餐活动报名开始时间
         */
        @ApiModelProperty(value = "霸王餐活动报名开始时间")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        private LocalDateTime startTime;

        /**
         * 霸王餐活动报名结束时间
         */
        @ApiModelProperty(value = "霸王餐活动报名结束时间")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        private LocalDateTime endTime;

        /**
         * 商品类型 1快递(物流)到家 2外卖配送 4到店消费 8外卖自提 16外卖套餐 32.线上兑换
         */
        @ApiModelProperty(value = "商品类型 1快递(物流)到家 2外卖配送 4到店消费 8外卖自提 16外卖套餐 32.线上兑换 ")
        private Integer productType;

        /**
         * 霸王餐活动开奖时间
         */
        @ApiModelProperty(value = "霸王餐活动开奖时间")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        private LocalDateTime lotteryTime;

        /**
         * 中奖概率配置信息
         */
        @ApiModelProperty(value = "中奖概率配置信息")
        private List<IslandFreeLunchWinRatioConfigVM> winRatioConfig;


        /**
         * 霸王餐活动访问量(UV/PV) UV
         */
        @ApiModelProperty(value = "霸王餐活动访问量(UV/PV) PV")
        private Integer pagViewNum;

        /**
         * 霸王餐活动访问量(UV/PV) PV
         */
        @ApiModelProperty(value = "霸王餐活动访问量(UV/PV) UV")
        private Integer uniqueVisitorNum;

        /**
         * 报名人数
         */
        @ApiModelProperty(value = "报名人数")
        private Integer joinNum;

        /**
         * 中奖人数
         */
        @ApiModelProperty(value = "中奖人数")
        private Long winNum;

        /**
         * 霸王餐活动状态
         */
        @ApiModelProperty(value = "霸王餐活动状态")
        private IslandFreeLunchStatusType status;

        /**
         * 霸王餐活动创建者id
         */
        @ApiModelProperty(value = "霸王餐活动创建者id")
        private String createUserId;

        /**
         * 霸王餐活动创建时间
         */
        @ApiModelProperty(value = "霸王餐活动创建时间")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        private LocalDateTime createTime;

        /**
         * 霸王餐活动最新修改时间
         */
        @ApiModelProperty(value = "霸王餐活动最新修改时间")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        private LocalDateTime updateTime;

        /**商品有效期 */
        @ApiModelProperty(value = "商品有效期")
        private Long productEffectiveDays;

        /**确认有效期 */
        @ApiModelProperty(value = "确认有效期")
        private Long effectiveDays;

        /**商品有效日期 */
        @ApiModelProperty(value = "商品有效日期")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        private LocalDateTime productEffectiveTime;

        /**
         *活动门槛
         * */
        @ApiModelProperty(value = "活动门槛 用户身份:USER_IDENTITY,用户等级:USER_LEVEL")
        private IslandFreeLunchCondition islandFreeLunchCondition;

        /**
         *用户身份
         * */
        @ApiModelProperty(value = "用户身份 认证达人:ISLAND_FREE_LUNCH_PROMOTIONEXPERTAUTH,通吃卡会员:ISLAND_FREE_LUNCH_USERMEMBER")
        private List<IslandFreeLunchUserIdentity> islandFreeLunchUserIdentity;

        /**
         * 参与等级 列表展示
         * */
        @ApiModelProperty(value = "参与等级 列表展示")
        private String joinConditions;


        /**
         * 配置说明
         */
        @ApiModelProperty(value = "配置说明")
        private String description;

        /**
         * 到店消费使用开始时间
         */
        @ApiModelProperty(value = "到店消费使用开始时间")
           @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant useStartTime;

        /**
         * 到店消费使用结束时间
         */
        @ApiModelProperty(value = "到店消费使用结束时间")
           @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant useEndTime;

        /**
         * 是否为中台创建
         */
        @ApiModelProperty(value = "是否为中台创建")
        private Boolean ifMiddleCreate;

        /**
         * 霸王餐活动操作 撤回：CANCEL 撤销：REVOKE 取消撤销：CANCEL_REVOKE 撤销失败：CANCEL_FAIL
         */
        @ApiModelProperty(value = "霸王餐活动操作 撤回：CANCEL 撤销：REVOKE 取消撤销：CANCEL_REVOKE 撤销失败：CANCEL_FAIL")
        private IslandFreeLunchStatusType operate;

        /**
         * 霸王餐审核后，下一环节名称
         */
        @ApiModelProperty(value = "霸王餐审核后，下一环节名称")
        private IslandFreeLunchStatusType nextTask;

        /**
         * 审核驳回原因、备注等信息
         */
        @ApiModelProperty(value = "审核驳回原因、备注等信息")
        private String remark;

        /**  霸王餐优化添加字段 20191009 end   */

        public Long getId() {
        return id;
    }

        public void setId(Long id) {
        this.id = id;
    }

        public Long getPlatFormId() {
        return platFormId;
    }

        public void setPlatFormId(Long platFormId) {
        this.platFormId = platFormId;
    }

        public String getName() {
        return name;
    }

        public void setName(String name) {
        this.name = name;
    }

        public Long getProductId() {
        return productId;
    }

        public void setProductId(Long productId) {
        this.productId = productId;
    }

        public String getProductName() {
        return productName;
    }

        public void setProductName(String productName) {
        this.productName = productName;
    }

        public Long getSkuId() {
        return skuId;
    }

        public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

        public Integer getProductNum() {
        return productNum;
    }

        public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

        public Float getProductPrice() {
        return productPrice;
    }

        public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

        public LocalDateTime getStartTime() {
        return startTime;
    }

        public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

        public LocalDateTime getEndTime() {
        return endTime;
    }

        public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

        public Integer getPagViewNum() {
        return pagViewNum;
    }

        public void setPagViewNum(Integer pagViewNum) {
        this.pagViewNum = pagViewNum;
    }

        public Integer getUniqueVisitorNum() {
        return uniqueVisitorNum;
    }

        public void setUniqueVisitorNum(Integer uniqueVisitorNum) {
        this.uniqueVisitorNum = uniqueVisitorNum;
    }

        public Integer getJoinNum() {
        return joinNum;
    }

        public void setJoinNum(Integer joinNum) {
        this.joinNum = joinNum;
    }

        public Long getWinNum() {
        return winNum;
    }

        public void setWinNum(Long winNum) {
        this.winNum = winNum;
    }

        public IslandFreeLunchStatusType getStatus() {
        return status;
    }

        public void setStatus(IslandFreeLunchStatusType status) {
        this.status = status;
    }

        public String getCreateUserId() {
        return createUserId;
    }

        public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

        public LocalDateTime getCreateTime() {
        return createTime;
    }

        public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

        public LocalDateTime getUpdateTime() {
        return updateTime;
    }

        public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

        public List<IslandFreeLunchWinRatioConfigVM> getWinRatioConfig() {
        return winRatioConfig;
    }

        public void setWinRatioConfig(List<IslandFreeLunchWinRatioConfigVM> winRatioConfig) {
        this.winRatioConfig = winRatioConfig;
    }

        public LocalDateTime getLotteryTime() {
        return lotteryTime;
    }

        public void setLotteryTime(LocalDateTime lotteryTime) {
        this.lotteryTime = lotteryTime;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Long getProductEffectiveDays() {
        return productEffectiveDays;
    }

    public void setProductEffectiveDays(Long productEffectiveDays) {
        this.productEffectiveDays = productEffectiveDays;
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

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public LocalDateTime getProductEffectiveTime() {
        return productEffectiveTime;
    }

    public void setProductEffectiveTime(LocalDateTime productEffectiveTime) {
        this.productEffectiveTime = productEffectiveTime;
    }

    public IslandFreeLunchCondition getIslandFreeLunchCondition() {
        return islandFreeLunchCondition;
    }

    public void setIslandFreeLunchCondition(IslandFreeLunchCondition islandFreeLunchCondition) {
        this.islandFreeLunchCondition = islandFreeLunchCondition;
    }

    public List<IslandFreeLunchUserIdentity> getIslandFreeLunchUserIdentity() {
        return islandFreeLunchUserIdentity;
    }

    public void setIslandFreeLunchUserIdentity(List<IslandFreeLunchUserIdentity> islandFreeLunchUserIdentity) {
        this.islandFreeLunchUserIdentity = islandFreeLunchUserIdentity;
    }


    public String getJoinConditions() {
        return joinConditions;
    }

    public void setJoinConditions(String joinConditions) {
        this.joinConditions = joinConditions;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getUseStartTime() {
        return useStartTime;
    }

    public void setUseStartTime(Instant useStartTime) {
        this.useStartTime = useStartTime;
    }

    public Instant getUseEndTime() {
        return useEndTime;
    }

    public void setUseEndTime(Instant useEndTime) {
        this.useEndTime = useEndTime;
    }

    public Boolean getIfMiddleCreate() {
        return ifMiddleCreate;
    }

    public void setIfMiddleCreate(Boolean ifMiddleCreate) {
        this.ifMiddleCreate = ifMiddleCreate;
    }

    public IslandFreeLunchStatusType getNextTask() {
        return nextTask;
    }

    public void setNextTask(IslandFreeLunchStatusType nextTask) {
        this.nextTask = nextTask;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public IslandFreeLunchStatusType getOperate() {
        return operate;
    }

    public void setOperate(IslandFreeLunchStatusType operate) {
        this.operate = operate;
    }

    public Long getEffectiveDays() {
        return effectiveDays;
    }

    public void setEffectiveDays(Long effectiveDays) {
        this.effectiveDays = effectiveDays;
    }

    @Override
        public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IslandFreeLunchDTO islandFreeLunchDTO = (IslandFreeLunchDTO) o;
        if (islandFreeLunchDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), islandFreeLunchDTO.getId());
    }

        @Override
        public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "IslandFreeLunchDTO{" +
            "id=" + id +
            ", platFormId=" + platFormId +
            ", name='" + name + '\'' +
            ", merchantId=" + merchantId +
            ", merchantName='" + merchantName + '\'' +
            ", brandId=" + brandId +
            ", brandName='" + brandName + '\'' +
            ", productId=" + productId +
            ", productName='" + productName + '\'' +
            ", skuId=" + skuId +
            ", productPrice=" + productPrice +
            ", productNum=" + productNum +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            ", productType=" + productType +
            ", lotteryTime=" + lotteryTime +
            ", winRatioConfig=" + winRatioConfig +
            ", pagViewNum=" + pagViewNum +
            ", uniqueVisitorNum=" + uniqueVisitorNum +
            ", joinNum=" + joinNum +
            ", winNum=" + winNum +
            ", status=" + status +
            ", createUserId='" + createUserId + '\'' +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", productEffectiveDays=" + productEffectiveDays +
            ", effectiveDays=" + effectiveDays +
            ", productEffectiveTime=" + productEffectiveTime +
            ", islandFreeLunchCondition=" + islandFreeLunchCondition +
            ", islandFreeLunchUserIdentity=" + islandFreeLunchUserIdentity +
            ", joinConditions='" + joinConditions + '\'' +
            ", description='" + description + '\'' +
            ", useStartTime=" + useStartTime +
            ", useEndTime=" + useEndTime +
            ", ifMiddleCreate=" + ifMiddleCreate +
            ", operate=" + operate +
            ", nextTask=" + nextTask +
            ", remark='" + remark + '\'' +
            '}';
    }
}
