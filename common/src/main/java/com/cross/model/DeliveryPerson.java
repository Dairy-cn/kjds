package com.cross.model;

import com.cross.model.enumeration.Gender;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A DeliveryPerson.
 */
public class DeliveryPerson implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String country;

    /**
     * 地址
     */
    private String address;

    /**
     * 坐标
     */
    private String coordinate;

    /**
     * 头像路径
     */
    private String imageUrl;

    /**
     * 身份证号码
     */
    private String identityNumber;

    /**
     * 手持身份证正面
     */
    private String identityAgoHand;

    /**
     * 身份证正面
     */
    private String identityAgo;

    /**
     * 身份证背面
     */
    private String identityAfter;

    /**
     * 审核状态  0未审核  1 审核通过 2 审核未通过
     */
    private Integer auditStatus = 0;

    /**
     * 微信号
     */
    private String weChat;

    /**
     * 状态
     */
    private String status;

    /**
     * 性别
     */
    @Column(name = "sex", nullable = false)
    private Gender sex = Gender.MEN;

    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者", required = true)
    @Column(name = "created_by", nullable = false)
    private String createdBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @Column(name = "created_date")
    private Integer createdDate;

    /**
     * 最后修改者
     */
    @ApiModelProperty(value = "最后修改者")
    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    /**
     * 最后修改时间
     */
    @ApiModelProperty(value = "最后修改时间")
    @Column(name = "last_modified_date")
    private Integer lastModifiedDate;

    /**
     * 最后登录时间
     */
    @ApiModelProperty(value = "最后登录时间")
    @Column(name = "last_login_date")
    private Integer lastLoginDate;

    /**
     * 接单状态
     */
    @ApiModelProperty(value = "接单状态")
    @Column(name = "accept_status")
    private Boolean acceptStatus = true;

    /**
     * 上传坐标状态
     */
    @ApiModelProperty(value = "上传坐标状态")
    @Column(name = "coordinate_status")
    private Boolean coordinateStatus = true;

    /**
     * 语言提醒状态
     */
    @ApiModelProperty(value = "语言提醒状态")
    @Column(name = "voice_status")
    private Boolean voiceStatus = true;

    /**
     * 新消息提醒状态
     */
    @ApiModelProperty(value = "新消息提醒状态")
    @Column(name = "new_news_status")
    private Boolean newNewsStatus = true;

    /**
     * 转入订单消息提醒 1 无条件接受 2 待用户确认 3 无条件拒绝
     */
    @ApiModelProperty(value = "转入订单消息提醒 1 无条件接受 2 待用户确认 3 无条件拒绝")
    @Column(name = "in_status")
    private Integer inStatus = 2;

    /**
     * 转出订单消息提醒 1 无条件接受 2 待用户确认 3 无条件拒绝
     */
    @ApiModelProperty(value = "转出订单消息提醒 1 无条件接受 2 待用户确认 3 无条件拒绝")
    @Column(name = "out_status")
    private Integer outStatus = 2;

    /**
     * 设备类型 安卓或ios
     */
    @ApiModelProperty(value = "设备类型")
    @Column(name = "device_type")
    private Integer deviceType;

    /**
     * 设备号
     */
    @ApiModelProperty(value = "设备号")
    @Column(name = "device_no")
    private String deviceNo;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "delivery_person_team",
               joinColumns = @JoinColumn(name="delivery_people_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="teams_id", referencedColumnName="id"))
    private Set<Team> teams = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "delivery_person_group",
               joinColumns = @JoinColumn(name="delivery_people_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="groups_id", referencedColumnName="id"))
    private Set<Group> groups = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public DeliveryPerson name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public DeliveryPerson phone(String phone) {
        this.phone = phone;
        return this;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public DeliveryPerson password(String password) {
        this.password = password;
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProvince() {
        return province;
    }

    public DeliveryPerson province(String province) {
        this.province = province;
        return this;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public DeliveryPerson city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public DeliveryPerson country(String country) {
        this.country = country;
        return this;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public DeliveryPerson address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public DeliveryPerson coordinate(String coordinate) {
        this.coordinate = coordinate;
        return this;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public DeliveryPerson imageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIdentityAgo() {
        return identityAgo;
    }

    public DeliveryPerson identityAgo(String identityAgo) {
        this.identityAgo = identityAgo;
        return this;
    }

    public void setIdentityAgo(String identityAgo) {
        this.identityAgo = identityAgo;
    }

    public String getIdentityAgoHand() {
        return identityAgoHand;
    }

    public DeliveryPerson identityAgoHand(String identityAgoHand) {
        this.identityAgoHand = identityAgoHand;
        return this;
    }

    public void setIdentityAgoHand(String identityAgoHand) {
        this.identityAgoHand = identityAgoHand;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public DeliveryPerson identityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
        return this;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getIdentityAfter() {
        return identityAfter;
    }

    public DeliveryPerson identityAfter(String identityAfter) {
        this.identityAfter = identityAfter;
        return this;
    }

    public void setIdentityAfter(String identityAfter) {
        this.identityAfter = identityAfter;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public DeliveryPerson auditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
        return this;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getWeChat() {
        return weChat;
    }

    public DeliveryPerson weChat(String weChat) {
        this.weChat = weChat;
        return this;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getStatus() {
        return status;
    }

    public DeliveryPerson status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Gender getSex() {
        return sex;
    }

    public DeliveryPerson sex(Gender sex) {
        this.sex = sex;
        return this;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public DeliveryPerson createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getCreatedDate() {
        return createdDate;
    }

    public DeliveryPerson createdDate(Integer createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(Integer createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public DeliveryPerson lastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Integer getLastModifiedDate() {
        return lastModifiedDate;
    }

    public DeliveryPerson lastModifiedDate(Integer lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
    }

    public void setLastModifiedDate(Integer lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getLastLoginDate() {
        return lastLoginDate;
    }

    public DeliveryPerson lastLoginDate(Integer lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
        return this;
    }

    public void setLastLoginDate(Integer lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Boolean isAcceptStatus() {
        return acceptStatus;
    }

    public DeliveryPerson acceptStatus(Boolean acceptStatus) {
        this.acceptStatus = acceptStatus;
        return this;
    }

    public void setAcceptStatus(Boolean acceptStatus) {
        this.acceptStatus = acceptStatus;
    }

    public Boolean isCoordinateStatus() {
        return coordinateStatus;
    }

    public DeliveryPerson coordinateStatus(Boolean coordinateStatus) {
        this.coordinateStatus = coordinateStatus;
        return this;
    }

    public void setCoordinateStatus(Boolean coordinateStatus) {
        this.coordinateStatus = coordinateStatus;
    }

    public Boolean isVoiceStatus() {
        return voiceStatus;
    }

    public DeliveryPerson voiceStatus(Boolean voiceStatus) {
        this.voiceStatus = voiceStatus;
        return this;
    }

    public void setVoiceStatus(Boolean voiceStatus) {
        this.voiceStatus = voiceStatus;
    }

    public Boolean isNewNewsStatus() {
        return newNewsStatus;
    }

    public DeliveryPerson newNewsStatus(Boolean newNewsStatus) {
        this.newNewsStatus = newNewsStatus;
        return this;
    }

    public void setNewNewsStatus(Boolean newNewsStatus) {
        this.newNewsStatus = newNewsStatus;
    }

    public Integer getInStatus() {
        return inStatus;
    }

    public DeliveryPerson inStatus(Integer inStatus) {
        this.inStatus = inStatus;
        return this;
    }

    public void setInStatus(Integer inStatus) {
        this.inStatus = inStatus;
    }

    public Integer getOutStatus() {
        return outStatus;
    }

    public DeliveryPerson outStatus(Integer outStatus) {
        this.outStatus = outStatus;
        return this;
    }

    public void setOutStatus(Integer outStatus) {
        this.outStatus = outStatus;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public DeliveryPerson deviceType(Integer deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public DeliveryPerson deviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
        return this;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public DeliveryPerson teams(Set<Team> teams) {
        this.teams = teams;
        return this;
    }

    public DeliveryPerson addTeam(Team team) {
        this.teams.add(team);
        team.getDeliveryPeople().add(this);
        return this;
    }

    public DeliveryPerson removeTeam(Team team) {
        this.teams.remove(team);
        team.getDeliveryPeople().remove(this);
        return this;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public DeliveryPerson groups(Set<Group> groups) {
        this.groups = groups;
        return this;
    }

    public DeliveryPerson addGroup(Group group) {
        this.groups.add(group);
        group.getDeliveryPeople().add(this);
        return this;
    }

    public DeliveryPerson removeGroup(Group group) {
        this.groups.remove(group);
        group.getDeliveryPeople().remove(this);
        return this;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeliveryPerson deliveryPerson = (DeliveryPerson) o;
        if (deliveryPerson.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), deliveryPerson.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DeliveryPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", coordinate='" + coordinate + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", identityAgo='" + identityAgo + '\'' +
                ", identityAfter='" + identityAfter + '\'' +
                ", auditStatus=" + auditStatus +
                ", weChat='" + weChat + '\'' +
                ", status='" + status + '\'' +
                ", sex=" + sex +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", lastModifiedDate=" + lastModifiedDate +
                ", lastLoginDate=" + lastLoginDate +
                '}';
    }
}
