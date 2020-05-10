package com.cross.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Merchant.
 */
public class MerchantPlatForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商户ID
     */
    @NotNull
    private Long merchantId;

    private Set<Team> teams = new HashSet<>();

    private Set<Group> groups = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public MerchantPlatForm merchantId(Long merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public MerchantPlatForm teams(Set<Team> teams) {
        this.teams = teams;
        return this;
    }

    public MerchantPlatForm addTeam(Team team) {
        this.teams.add(team);
        team.getMerchants().add(this);
        return this;
    }

    public MerchantPlatForm removeTeam(Team team) {
        this.teams.remove(team);
        team.getMerchants().remove(this);
        return this;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public MerchantPlatForm groups(Set<Group> groups) {
        this.groups = groups;
        return this;
    }

    public MerchantPlatForm addGroup(Group group) {
        this.groups.add(group);
        group.getMerchants().add(this);
        return this;
    }

    public MerchantPlatForm removeGroup(Group group) {
        this.groups.remove(group);
        group.getMerchants().remove(this);
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
        MerchantPlatForm merchant = (MerchantPlatForm) o;
        if (merchant.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), merchant.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Merchant{" +
            "id=" + getId() +
            ", merchantId='" + getMerchantId() + "'" +
            "}";
    }
}
