package com.cross.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link com.cross.island.domain.IslandUserMember} entity.
 */
@ApiModel(description = "用户会员信息")
public class IslandUserMemberDTO implements Serializable {

    private Long id;


    /**
     * 平台id
     */
    @ApiModelProperty(value = "平台id", required = true)
    @NotNull
    private Long platformId;
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 有效时间
     */
    @ApiModelProperty(value = "有效时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime memberStartTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime memberEndTime;

    /**
     * 购买时间
     */
    @ApiModelProperty(value = "购买时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime buyTime;

    /**
     * 会员卡编号
     */
    @ApiModelProperty(value = "会员卡编号")
    private String memberCardNo;

    /**
     * 会员卡价格
     */
    @ApiModelProperty(value = "会员卡价格")
    private BigDecimal price;


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

    public LocalDateTime getMemberStartTime() {
        return memberStartTime;
    }

    public void setMemberStartTime(LocalDateTime memberStartTime) {
        this.memberStartTime = memberStartTime;
    }

    public LocalDateTime getMemberEndTime() {
        return memberEndTime;
    }

    public void setMemberEndTime(LocalDateTime memberEndTime) {
        this.memberEndTime = memberEndTime;
    }

    public LocalDateTime getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(LocalDateTime buyTime) {
        this.buyTime = buyTime;
    }

    public String getMemberCardNo() {
        return memberCardNo;
    }

    public void setMemberCardNo(String memberCardNo) {
        this.memberCardNo = memberCardNo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IslandUserMemberDTO islandUserMemberDTO = (IslandUserMemberDTO) o;
        if (islandUserMemberDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), islandUserMemberDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "IslandUserMemberDTO{" +
            "id=" + id +
            ", platformId=" + platformId +
            ", userId=" + userId +
            ", memberStartTime=" + memberStartTime +
            ", memberEndTime=" + memberEndTime +
            ", buyTime=" + buyTime +
            ", memberCardNo='" + memberCardNo + '\'' +
            ", price=" + price +
            '}';
    }
}
