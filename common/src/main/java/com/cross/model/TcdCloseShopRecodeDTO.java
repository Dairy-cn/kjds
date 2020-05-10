package com.cross.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cross.interfaces.JodaInstantJsonDeserializer;
import com.cross.interfaces.JodaInstantJsonSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the TcdCloseShopRecode entity.
 */
public class TcdCloseShopRecodeDTO implements Serializable {

    private Long id;

    @ApiModelProperty(value = "入驻的平台id")
    private Long platformId;

    @ApiModelProperty(value = "添加时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant addTime;

    @ApiModelProperty(value = "关闭营业天数")
    private Integer closeDay;

    @ApiModelProperty(value = "关闭营业开始时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant closeStartDate;

    @ApiModelProperty(value = "关闭营业结束时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant closeEndDate;

    @ApiModelProperty(value = "被关闭的门店或者品牌id")
    private Long closeId;

    @ApiModelProperty(value = "关闭原因")
    private String closeReason;

    @ApiModelProperty(value = "开启时间")
       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonDeserialize(using = JodaInstantJsonDeserializer.class)
    @JsonSerialize(using = JodaInstantJsonSerializer.class)

    private Instant openDate;

    @ApiModelProperty(value = "记录类型")
    private RecodeType recodeType;

    @ApiModelProperty(value = "开启门店的模式 0 未开启 1 手动  2自动")
    private Integer openModel;

    public Integer getOpenModel() {
        return openModel;
    }

    public void setOpenModel(Integer openModel) {
        this.openModel = openModel;
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

    public Instant getAddTime() {
        return addTime;
    }

    public void setAddTime(Instant addTime) {
        this.addTime = addTime;
    }

    public Integer getCloseDay() {
        return closeDay;
    }

    public void setCloseDay(Integer closeDay) {
        this.closeDay = closeDay;
    }

    public Instant getCloseStartDate() {
        return closeStartDate;
    }

    public void setCloseStartDate(Instant closeStartDate) {
        this.closeStartDate = closeStartDate;
    }

    public Instant getCloseEndDate() {
        return closeEndDate;
    }

    public void setCloseEndDate(Instant closeEndDate) {
        this.closeEndDate = closeEndDate;
    }

    public Long getCloseId() {
        return closeId;
    }

    public void setCloseId(Long closeId) {
        this.closeId = closeId;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    public Instant getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Instant openDate) {
        this.openDate = openDate;
    }

    public RecodeType getRecodeType() {
        return recodeType;
    }

    public void setRecodeType(RecodeType recodeType) {
        this.recodeType = recodeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TcdCloseShopRecodeDTO tcdCloseShopRecodeDTO = (TcdCloseShopRecodeDTO) o;
        if(tcdCloseShopRecodeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tcdCloseShopRecodeDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TcdCloseShopRecodeDTO{" +
            "id=" + getId() +
            ", platformId=" + getPlatformId() +
            ", addTime='" + getAddTime() + "'" +
            ", closeDay=" + getCloseDay() +
            ", closeStartDate='" + getCloseStartDate() + "'" +
            ", closeEndDate='" + getCloseEndDate() + "'" +
            ", closeId=" + getCloseId() +
            ", closeReason='" + getCloseReason() + "'" +
            ", openDate='" + getOpenDate() + "'" +
            ", recodeType='" + getRecodeType() + "'" +
            "}";
    }
}
