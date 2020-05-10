package com.cross.model;

import com.cross.model.enumeration.BillingRoules;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Team.
 */
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 团队名称
     */
    @NotNull
    private String teamName;

    /**
     * 电话
     */
    @NotNull
    private String phone;

    /**
     * 密码
     */
    @NotNull
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
    private String county;

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
     * 微信号
     */
    private String weChat;

    /**
     * 状态
     */
    @NotNull
    private String status;

    /**
     * 推荐人
     */
    private String recPerson;

    /**
     * 授权截止时间
     */
    private Integer deadline;

    /**
     * 计费规则
     */
    private BillingRoules billingRoles;

    /**
     * 创建者
     */
    @NotNull
    private String createdBy;

    /**
     * 创建时间
     */
    private Integer createdDate;

    /**
     * 最后修改者
     */
    private String lastModifiedBy;

    /**
     * 最后修改时间
     */
    private Integer lastModifiedDate;

    /**
     * 最后登录时间
     */
    private Integer lastLoginDate;

    private Set<Group> groups = new HashSet<>();

    private Set<MerchantPlatForm> merchants = new HashSet<>();

    private Set<DeliveryPerson> deliveryPeople = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public Team teamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPhone() {
        return phone;
    }

    public Team phone(String phone) {
        this.phone = phone;
        return this;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public Team password(String password) {
        this.password = password;
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProvince() {
        return province;
    }

    public Team province(String province) {
        this.province = province;
        return this;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public Team city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public Team county(String county) {
        this.county = county;
        return this;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAddress() {
        return address;
    }

    public Team address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public Team coordinate(String coordinate) {
        this.coordinate = coordinate;
        return this;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Team imageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWeChat() {
        return weChat;
    }

    public Team weChat(String weChat) {
        this.weChat = weChat;
        return this;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getStatus() {
        return status;
    }

    public Team status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRecPerson() {
        return recPerson;
    }

    public Team recPerson(String recPerson) {
        this.recPerson = recPerson;
        return this;
    }

    public void setRecPerson(String recPerson) {
        this.recPerson = recPerson;
    }

    public Integer getDeadline() {
        return deadline;
    }

    public Team deadline(Integer deadline) {
        this.deadline = deadline;
        return this;
    }

    public void setDeadline(Integer deadline) {
        this.deadline = deadline;
    }

    public BillingRoules getBillingRoles() {
        return billingRoles;
    }

    public Team billingRoles(BillingRoules billingRoles) {
        this.billingRoles = billingRoles;
        return this;
    }

    public void setBillingRoles(BillingRoules billingRoles) {
        this.billingRoles = billingRoles;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Team createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getCreatedDate() {
        return createdDate;
    }

    public Team createdDate(Integer createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(Integer createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public Team lastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Integer getLastModifiedDate() {
        return lastModifiedDate;
    }

    public Team lastModifiedDate(Integer lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
    }

    public void setLastModifiedDate(Integer lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getLastLoginDate() {
        return lastLoginDate;
    }

    public Team lastLoginDate(Integer lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
        return this;
    }

    public void setLastLoginDate(Integer lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public Team groups(Set<Group> groups) {
        this.groups = groups;
        return this;
    }

    public Team addGroup(Group group) {
        this.groups.add(group);
        group.setTeam(this);
        return this;
    }

    public Team removeGroup(Group group) {
        this.groups.remove(group);
        group.setTeam(null);
        return this;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<MerchantPlatForm> getMerchants() {
        return merchants;
    }

    public Team merchants(Set<MerchantPlatForm> merchants) {
        this.merchants = merchants;
        return this;
    }

    public Team addMerchant(MerchantPlatForm merchant) {
        this.merchants.add(merchant);
        merchant.getTeams().add(this);
        return this;
    }

    public Team removeMerchant(MerchantPlatForm merchant) {
        this.merchants.remove(merchant);
        merchant.getTeams().remove(this);
        return this;
    }

    public void setMerchants(Set<MerchantPlatForm> merchants) {
        this.merchants = merchants;
    }

    public Set<DeliveryPerson> getDeliveryPeople() {
        return deliveryPeople;
    }

    public Team deliveryPeople(Set<DeliveryPerson> deliveryPeople) {
        this.deliveryPeople = deliveryPeople;
        return this;
    }

    public Team addDeliveryPerson(DeliveryPerson deliveryPerson) {
        this.deliveryPeople.add(deliveryPerson);
        deliveryPerson.getTeams().add(this);
        return this;
    }

    public Team removeDeliveryPerson(DeliveryPerson deliveryPerson) {
        this.deliveryPeople.remove(deliveryPerson);
        deliveryPerson.getTeams().remove(this);
        return this;
    }

    public void setDeliveryPeople(Set<DeliveryPerson> deliveryPeople) {
        this.deliveryPeople = deliveryPeople;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Team team = (Team) o;
        if (team.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), team.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + getId() +
                ", teamName='" + getTeamName() + "'" +
                ", phone='" + getPhone() + "'" +
                ", password='" + getPassword() + "'" +
                ", province='" + getProvince() + "'" +
                ", city='" + getCity() + "'" +
                ", county='" + getCounty() + "'" +
                ", address='" + getAddress() + "'" +
                ", coordinate='" + getCoordinate() + "'" +
                ", imageUrl='" + getImageUrl() + "'" +
                ", weChat='" + getWeChat() + "'" +
                ", status='" + getStatus() + "'" +
                ", recPerson='" + getRecPerson() + "'" +
                ", deadline='" + getDeadline() + "'" +
                ", billingRoles='" + getBillingRoles() + "'" +
                ", createdBy='" + getCreatedBy() + "'" +
                ", createdDate='" + getCreatedDate() + "'" +
                ", lastModifiedBy='" + getLastModifiedBy() + "'" +
                ", lastModifiedDate='" + getLastModifiedDate() + "'" +
                ", lastLoginDate='" + getLastLoginDate() + "'" +
                "}";
    }
}
