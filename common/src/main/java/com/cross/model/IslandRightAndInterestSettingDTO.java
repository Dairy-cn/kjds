package com.cross.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.island.domain} entity.
 */
@ApiModel(description = "权益设置")
public class IslandRightAndInterestSettingDTO implements Serializable {

    private Long id;

    /**
     * 平台id
     */
    @ApiModelProperty(value = "平台id", required = true)
    private Long platformId;

    /**
     * 权益图表
     */
    @ApiModelProperty(value = "权益图表")
    private String logo;

    /**
     * 权益项 ;
     */
    @ApiModelProperty(value = "权益项")
    private String name;



    /**
     * 统一价
     */
    @ApiModelProperty(value = "统一价")
    private BigDecimal unificationPrice;



    @ApiModelProperty(value = "奖品描述")
    private String prizeDesc;

    @ApiModelProperty(value = "使用指南")
    private String userGuide;

    @ApiModelProperty(value = "操作人")
    private String operator;

    @ApiModelProperty(value = "有效期(年)")
    private Integer limitYear;

    @ApiModelProperty(value = "原价")
    private BigDecimal price;



    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }





    public String getPrizeDesc() {
        return prizeDesc;
    }

    public void setPrizeDesc(String prizeDesc) {
        this.prizeDesc = prizeDesc;
    }

    public String getUserGuide() {
        return userGuide;
    }

    public void setUserGuide(String userGuide) {
        this.userGuide = userGuide;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getLimitYear() {
        return limitYear;
    }

    public void setLimitYear(Integer limitYear) {
        this.limitYear = limitYear;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IslandRightAndInterestSettingDTO islandRightAndInterestSettingDTO = (IslandRightAndInterestSettingDTO) o;
        if (islandRightAndInterestSettingDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), islandRightAndInterestSettingDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "IslandRightAndInterestSettingDTO{" +
            "id=" + id +
            ", platformId=" + platformId +
            ", logo='" + logo + '\'' +
            ", name='" + name + '\'' +
            ", unificationPrice=" + unificationPrice +
            ", prizeDesc='" + prizeDesc + '\'' +
            ", userGuide='" + userGuide + '\'' +
            ", operator='" + operator + '\'' +
            ", limitYear=" + limitYear +
            ", price=" + price +
            '}';
    }
}
