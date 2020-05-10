package com.cross.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Coupon.
 */
@Entity
@Table(name = "coupon")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CouponModel implements Serializable {

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
     * 代金券序号
     */
    @Size(min = 12, max = 12)
    @ApiModelProperty(value = "代金券序号")
    @Column(name = "sn", length = 12)
    private String sn;

    /**
     * 价值
     */
    @ApiModelProperty(value = "价值")
    @Column(name = "worth")
    private Double worth;

    /**
     * 创建者编号
     */
    @ApiModelProperty(value = "创建者编号")
    @Column(name = "create_user_id")
    private Long createUserId;

    /**
     * 获取者编号
     */
    @ApiModelProperty(value = "获取者编号")
    @Column(name = "get_user_id")
    private Long getUserId;

    /**
     * 使用时间
     */
    @ApiModelProperty(value = "使用时间")
    @Column(name = "use_time")
    private Integer useTime;

    /**
     * 0 未使用 1已使用
     */
    @ApiModelProperty(value = "0 未使用 1已使用")
    @Column(name = "state")
    private Integer state;

    /**
     * 使用订单编号
     *
     */
    @Column(name = "use_order_id")
    private Long useOrderId;


    /**
     * 活动名称
     */
    @Size(min = 3, max = 255)
    @ApiModelProperty(value = "活动名称")
    @Column(name = "name", length = 255)
    private String name;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    @Column(name = "start_time")
    private Integer startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    @Column(name = "end_time")
    private Integer endTime;

    /**
     * 条件
     */
    @Size(max = 5000)
    @ApiModelProperty(value = "条件")
    @Column(name = "jhi_condition", length = 5000)
    private String condition;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActivityId() {
        return activityId;
    }

    public CouponModel activityId(Long activityId) {
        this.activityId = activityId;
        return this;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getSn() {
        return sn;
    }

    public CouponModel sn(String sn) {
        this.sn = sn;
        return this;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Double getWorth() {
        return worth;
    }

    public CouponModel worth(Double worth) {
        this.worth = worth;
        return this;
    }

    public void setWorth(Double worth) {
        this.worth = worth;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public CouponModel createUserId(Long createUserId) {
        this.createUserId = createUserId;
        return this;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getGetUserId() {
        return getUserId;
    }

    public CouponModel getUserId(Long getUserId) {
        this.getUserId = getUserId;
        return this;
    }

    public void setGetUserId(Long getUserId) {
        this.getUserId = getUserId;
    }

    public Integer getUseTime() {
        return useTime;
    }

    public CouponModel useTime(Integer useTime) {
        this.useTime = useTime;
        return this;
    }

    public void setUseTime(Integer useTime) {
        this.useTime = useTime;
    }

    public Integer getState() {
        return state;
    }

    public CouponModel state(Integer state) {
        this.state = state;
        return this;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CouponModel coupon = (CouponModel) o;
        if (coupon.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), coupon.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Coupon{" +
            "id=" + getId() +
            ", activityId='" + getActivityId() + "'" +
            ", sn='" + getSn() + "'" +
            ", worth='" + getWorth() + "'" +
            ", createUserId='" + getCreateUserId() + "'" +
            ", getUserId='" + getGetUserId() + "'" +
            ", useTime='" + getUseTime() + "'" +
            ", state='" + getState() + "'" +
            "}";
    }

    public Long getUseOrderId() {
        return useOrderId;
    }

    public void setUseOrderId(Long useOrderId) {
        this.useOrderId = useOrderId;
    }
}
