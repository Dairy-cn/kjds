package com.cross.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A ActivityMain.
 */
@Entity
@Table(name = "activity_main")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ActivityMainModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 活动类型
     */
    @ApiModelProperty(value = "活动类型")
    @Column(name = "jhi_type")
    private Integer type;

    /**
     * 活动名称
     */
    @Size(min = 3, max = 255)
    @ApiModelProperty(value = "活动名称")
    @Column(name = "name", length = 255)
    private String name;

    /**
     * 创建者编号
     */
    @ApiModelProperty(value = "创建者编号")
    @Column(name = "user_id")
    private Long userId;

    /**
     * 价值
     */
    @ApiModelProperty(value = "价值")
    @Column(name = "worth")
    private Double worth;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    @Column(name = "start_time")
    private String startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    @Column(name = "end_time")
    private String endTime;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time")
    private Integer createTime;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @Column(name = "state")
    private Integer state;

    /**
     * 条件
     */
    @Size(max = 5000)
    @ApiModelProperty(value = "条件")
    @Column(name = "jhi_condition", length = 5000)
    private String condition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public ActivityMainModel type(Integer type) {
        this.type = type;
        return this;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public ActivityMainModel name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public ActivityMainModel userId(Long userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getWorth() {
        return worth;
    }

    public ActivityMainModel worth(Double worth) {
        this.worth = worth;
        return this;
    }

    public void setWorth(Double worth) {
        this.worth = worth;
    }

    public String getStartTime() {
        return startTime;
    }

    public ActivityMainModel startTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public ActivityMainModel endTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public ActivityMainModel createTime(Integer createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public ActivityMainModel state(Integer state) {
        this.state = state;
        return this;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCondition() {
        return condition;
    }

    public ActivityMainModel condition(String condition) {
        this.condition = condition;
        return this;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ActivityMainModel activityMain = (ActivityMainModel) o;
        if (activityMain.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), activityMain.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ActivityMain{" +
            "id=" + getId() +
            ", type='" + getType() + "'" +
            ", name='" + getName() + "'" +
            ", userId='" + getUserId() + "'" +
            ", worth='" + getWorth() + "'" +
            ", startTime='" + getStartTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", state='" + getState() + "'" +
            ", condition='" + getCondition() + "'" +
            "}";
    }
}
