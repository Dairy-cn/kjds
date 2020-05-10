package com.cross.model;


import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Group.
 */
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 抢单群名称
     */
    @NotNull
    private String name;

    private Boolean isDelete = false;

    private Team team;

    private Set<DeliveryPerson> deliveryPeople = new HashSet<>();

    private Set<MerchantPlatForm> merchants = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Group name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isDelete() {
        return isDelete;
    }

    public Group isDelete(Boolean isDelete) {
        this.isDelete = isDelete;
        return this;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public Team getTeam() {
        return team;
    }

    public Group team(Team team) {
        this.team = team;
        return this;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Set<DeliveryPerson> getDeliveryPeople() {
        return deliveryPeople;
    }

    public Group deliveryPeople(Set<DeliveryPerson> deliveryPeople) {
        this.deliveryPeople = deliveryPeople;
        return this;
    }

    public Group addDeliveryPerson(DeliveryPerson deliveryPerson) {
        this.deliveryPeople.add(deliveryPerson);
        deliveryPerson.getGroups().add(this);
        return this;
    }

    public Group removeDeliveryPerson(DeliveryPerson deliveryPerson) {
        this.deliveryPeople.remove(deliveryPerson);
        deliveryPerson.getGroups().remove(this);
        return this;
    }

    public void setDeliveryPeople(Set<DeliveryPerson> deliveryPeople) {
        this.deliveryPeople = deliveryPeople;
    }

    public Set<MerchantPlatForm> getMerchants() {
        return merchants;
    }

    public Group merchants(Set<MerchantPlatForm> merchants) {
        this.merchants = merchants;
        return this;
    }

    public Group addMerchant(MerchantPlatForm merchant) {
        this.merchants.add(merchant);
        merchant.getGroups().add(this);
        return this;
    }

    public Group removeMerchant(MerchantPlatForm merchant) {
        this.merchants.remove(merchant);
        merchant.getGroups().remove(this);
        return this;
    }

    public void setMerchants(Set<MerchantPlatForm> merchants) {
        this.merchants = merchants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Group group = (Group) o;
        if (group.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), group.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + getId() +
                ", name='" + getName() + "'" +
                "}";
    }
}
