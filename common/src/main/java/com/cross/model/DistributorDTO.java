package com.cross.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the Distributor entity.
 */
public class DistributorDTO implements Serializable {

    private Long id;

    private Long supplierId;

    @NotNull
    private Long brandId;

    private Long distributorUserId;

    private Long parentId;

    private Long parentParentId;

    @Size(max = 64)
    private String parentName;

    private Double profit;

    private Double withdraw;

    private Integer oneSubordinate;

    /**
     * 二级下线数量
     */
    private Integer twoSubordinate;

    private Integer level;
    
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)
    private Instant joinDate;

    private Long code;

    /**
     * 分享海报
     */
    private String sharePost;

    /**
     * 等级Id
     */
    @ApiModelProperty(value = "等级")
    private Long rank;

    @ApiModelProperty(value = "累计分享订单数")
    private Integer orderCount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getDistributorUserId() {
        return distributorUserId;
    }

    public void setDistributorUserId(Long distributorUserId) {
        this.distributorUserId = distributorUserId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getParentParentId() {
        return parentParentId;
    }

    public void setParentParentId(Long parentParentId) {
        this.parentParentId = parentParentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(Double withdraw) {
        this.withdraw = withdraw;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Instant getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Instant joinDate) {
        this.joinDate = joinDate;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DistributorDTO distributorDTO = (DistributorDTO) o;
        if(distributorDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), distributorDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DistributorDTO{" +
            "id=" + id +
            ", supplierId=" + supplierId +
            ", brandId=" + brandId +
            ", distributorUserId=" + distributorUserId +
            ", parentId=" + parentId +
            ", parentParentId=" + parentParentId +
            ", parentName='" + parentName + '\'' +
            ", profit=" + profit +
            ", withdraw=" + withdraw +
            ", oneSubordinate=" + oneSubordinate +
            ", twoSubordinate=" + twoSubordinate +
            ", level=" + level +
            ", joinDate=" + joinDate +
            ", code=" + code +
            ", sharePost='" + sharePost + '\'' +
            ", rank=" + rank +
            '}';
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Integer getTwoSubordinate() {
        return twoSubordinate;
    }

    public void setTwoSubordinate(Integer twoSubordinate) {
        this.twoSubordinate = twoSubordinate;
    }

    public Integer getOneSubordinate() {
        return oneSubordinate;
    }

    public void setOneSubordinate(Integer oneSubordinate) {
        this.oneSubordinate = oneSubordinate;
    }

    public String getSharePost() {
        return sharePost;
    }

    public void setSharePost(String sharePost) {
        this.sharePost = sharePost;
    }
}
