package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import com.cross.model.enumeration.JoinCondition;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class PartnerLevelModel implements Serializable{
    /**
     * 主键
     */
    private Long id;

    /**
     * 平台id
     */
    @ApiModelProperty(value = "平台id", required = true)
    @NotNull(message = "平台id不能为空")
    private Long platformId;

    //TODO 20190427 新等级设置只和平台有关和品牌无关  待数据库设计跟新后删除该字段
    @ApiModelProperty(value = "品牌id")
    private Long brandId = -1L;

    /**
     * 创建者标识
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 等级名称
     */
    @ApiModelProperty(value = "等级名称")
    private String levelName;

    /**
     * 等级图片url
     */
    @ApiModelProperty(value = "等级图片url")
    private String imageUrl;

    /**
     * 加入条件
     */
    @ApiModelProperty(value = "加入条件")
    private JoinCondition joinCondition;

    /**
     * 有门槛的条件（满足其中一个即可）1：目标达标   2：购买套餐 3：开通通吃岛
     */
    @ApiModelProperty(value = "有门槛的条件（满足其中一个即可）1：目标达标   2：购买套餐 4：开通通吃岛")
    private Integer thresholdCondition;

    /**
     * 目标达标条件(通过状态码判断) 1(0001):销售额目标 2(0010)：招募合伙人数
     */
    @ApiModelProperty(value = "目标达标条件(通过状态码判断) 1(0001):销售额目标 2(0010)：招募合伙人数;")
    private Integer goalCondition;

    /**
     * 销售额目标金额
     */
    @ApiModelProperty(value = "销售额目标金额")
    private Double saleGoal;

    /**
     * 招募合伙人数
     */
    @ApiModelProperty(value = "招募合伙人数")
    private Integer partnerNum;

    /**
     * 等级功能(通过状态码判断) 1(0001):分销单品  2(0010):分销平台 4(0100):招募合伙人
     */
    @ApiModelProperty(value = "等级功能(通过状态码判断) 1(0001):分销单品  2(0010):分销平台 4(0100):招募合伙人")
    private Integer levelFunction;

    /**
     * 等级权益(通过状态码判断) 1:获一级下线抽佣  2:获二级下线抽佣
     * 4:提成比例按平台/单品实际抽佣比例   8:提成抽佣比例额外增加
     * 16:全部物流商品免邮
     * 32 通吃卡返现
     * 64 奖金池瓜分
     */
    @ApiModelProperty(value = "等级权益(通过状态码判断)1:获一级下线抽佣  2:获二级下线抽佣 4:提成比例按平台/单品实际抽佣比例   8:提成抽佣比例额外增加 16:全部物流商品免邮 32： 通吃卡分销返现 64：奖金池瓜分")
    private Integer hierarchy;

    /**
     * 额外比例
     */
    @ApiModelProperty(value = "额外比例")
    private Double extraRatio;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant createDate;

    /**
     * 等级级数
     */
    @ApiModelProperty(value = "等级级数")
    private Integer level;

    /**
     * 满额提现
     */
    @ApiModelProperty(value = "满额提现")
    private Double fullWithdrawal;

    /**
     * 需要购买的商品信息
     */
    @ApiModelProperty(value = "套餐信息")
    private List<PackageInfoVM> packageInfoList;

    /**
     * 通吃卡返现金额
     */
    @ApiModelProperty(value = "通吃卡返现")
    private BigDecimal tcCardCashBack;


    @ApiModelProperty(value = "是否是通吃岛")
    private Boolean tcd;

    public Integer getThresholdCondition() {
        return thresholdCondition;
    }

    public void setThresholdCondition(Integer thresholdCondition) {
        this.thresholdCondition = thresholdCondition;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

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

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public JoinCondition getJoinCondition() {
        return joinCondition;
    }

    public void setJoinCondition(JoinCondition joinCondition) {
        this.joinCondition = joinCondition;
    }

    public Integer getGoalCondition() {
        return goalCondition;
    }

    public void setGoalCondition(Integer goalCondition) {
        this.goalCondition = goalCondition;
    }

    public Double getSaleGoal() {
        return saleGoal;
    }

    public void setSaleGoal(Double saleGoal) {
        this.saleGoal = saleGoal;
    }

    public Integer getPartnerNum() {
        return partnerNum;
    }

    public void setPartnerNum(Integer partnerNum) {
        this.partnerNum = partnerNum;
    }

    public Integer getLevelFunction() {
        return levelFunction;
    }

    public void setLevelFunction(Integer levelFunction) {
        this.levelFunction = levelFunction;
    }

    public Integer getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(Integer hierarchy) {
        this.hierarchy = hierarchy;
    }

    public Double getExtraRatio() {
        return extraRatio;
    }

    public void setExtraRatio(Double extraRatio) {
        this.extraRatio = extraRatio;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Double getFullWithdrawal() {
        return fullWithdrawal;
    }

    public void setFullWithdrawal(Double fullWithdrawal) {
        this.fullWithdrawal = fullWithdrawal;
    }

    public List<PackageInfoVM> getPackageInfoList() {
        return packageInfoList;
    }

    public void setPackageInfoList(List<PackageInfoVM> packageInfoList) {
        this.packageInfoList = packageInfoList;
    }


    public BigDecimal getTcCardCashBack() {
        return tcCardCashBack;
    }

    public void setTcCardCashBack(BigDecimal tcCardCashBack) {
        this.tcCardCashBack = tcCardCashBack;
    }

    public Boolean isTcd() {
        return tcd;
    }

    public void setTcd(Boolean tcd) {
        this.tcd = tcd;
    }

    public Boolean getTcd() {
        return tcd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PartnerLevelModel partnerLevelDTO = (PartnerLevelModel) o;
        if (partnerLevelDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), partnerLevelDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PartnerLevelDTO{" +
            "id=" + id +
            ", platformId=" + platformId +
            ", brandId=" + brandId +
            ", userId=" + userId +
            ", levelName='" + levelName + '\'' +
            ", imageUrl='" + imageUrl + '\'' +
            ", joinCondition=" + joinCondition +
            ", thresholdCondition=" + thresholdCondition +
            ", goalCondition=" + goalCondition +
            ", saleGoal=" + saleGoal +
            ", partnerNum=" + partnerNum +
            ", levelFunction=" + levelFunction +
            ", hierarchy=" + hierarchy +
            ", extraRatio=" + extraRatio +
            ", createDate=" + createDate +
            ", level=" + level +
            ", fullWithdrawal=" + fullWithdrawal +
            ", packageInfoList=" + packageInfoList +
            ", tcCardCashBack=" + tcCardCashBack +
            ", tcd=" + tcd +
            '}';
    }
}
