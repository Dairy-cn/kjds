package com.cross.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A ActivityUseDetails.
 */
@Entity
@Table(name = "activity_use_details")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ActivityUseDetailsModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 活动编号
     */
    @ApiModelProperty(value = "活动编号")
    @Column(name = "activity_id")
    private Long activityId;

    /**
     * 使用者编号
     */
    @ApiModelProperty(value = "使用者编号")
    @Column(name = "use_user_id")
    private Long useUserId;

    /**
     * 使用时间
     */
    @ApiModelProperty(value = "使用时间")
    @Column(name = "use_time")
    private Integer useTime;

    /**
     * 使用的订单号
     */
    @Size(max = 32)
    @ApiModelProperty(value = "使用的订单号")
    @Column(name = "use_order_sn", length = 32)
    private String useOrderSn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActivityId() {
        return activityId;
    }

    public ActivityUseDetailsModel activityId(Long activityId) {
        this.activityId = activityId;
        return this;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getUseUserId() {
        return useUserId;
    }

    public ActivityUseDetailsModel useUserId(Long useUserId) {
        this.useUserId = useUserId;
        return this;
    }

    public void setUseUserId(Long useUserId) {
        this.useUserId = useUserId;
    }

    public Integer getUseTime() {
        return useTime;
    }

    public ActivityUseDetailsModel useTime(Integer useTime) {
        this.useTime = useTime;
        return this;
    }

    public void setUseTime(Integer useTime) {
        this.useTime = useTime;
    }

    public String getUseOrderSn() {
        return useOrderSn;
    }

    public ActivityUseDetailsModel useOrderSn(String useOrderSn) {
        this.useOrderSn = useOrderSn;
        return this;
    }

    public void setUseOrderSn(String useOrderSn) {
        this.useOrderSn = useOrderSn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ActivityUseDetailsModel activityUseDetails = (ActivityUseDetailsModel) o;
        if (activityUseDetails.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), activityUseDetails.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ActivityUseDetails{" +
            "id=" + getId() +
            ", activityId='" + getActivityId() + "'" +
            ", useUserId='" + getUseUserId() + "'" +
            ", useTime='" + getUseTime() + "'" +
            ", useOrderSn='" + getUseOrderSn() + "'" +
            "}";
    }
}
