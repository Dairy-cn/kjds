package com.cross.model;


import java.io.Serializable;
import java.util.Objects;

/**
 * A UserWeixinAccessToken.
 */
public class UserWeixinAccessToken implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String access_token;

    private Integer expires_in;

    private String refresh_token;

    private String openid;

    private String scope;

    private Integer add_time;

    private String add_ip;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public UserWeixinAccessToken access_token(String access_token) {
        this.access_token = access_token;
        return this;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public UserWeixinAccessToken expires_in(Integer expires_in) {
        this.expires_in = expires_in;
        return this;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public UserWeixinAccessToken refresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
        return this;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getOpenid() {
        return openid;
    }

    public UserWeixinAccessToken openid(String openid) {
        this.openid = openid;
        return this;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public UserWeixinAccessToken scope(String scope) {
        this.scope = scope;
        return this;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Integer getAdd_time() {
        return add_time;
    }

    public UserWeixinAccessToken add_time(Integer add_time) {
        this.add_time = add_time;
        return this;
    }

    public void setAdd_time(Integer add_time) {
        this.add_time = add_time;
    }

    public String getAdd_ip() {
        return add_ip;
    }

    public UserWeixinAccessToken add_ip(String add_ip) {
        this.add_ip = add_ip;
        return this;
    }

    public void setAdd_ip(String add_ip) {
        this.add_ip = add_ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserWeixinAccessToken userWeixinAccessToken = (UserWeixinAccessToken) o;
        if (userWeixinAccessToken.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), userWeixinAccessToken.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UserWeixinAccessToken{" +
            "id=" + getId() +
            ", access_token='" + getAccess_token() + "'" +
            ", expires_in='" + getExpires_in() + "'" +
            ", refresh_token='" + getRefresh_token() + "'" +
            ", openid='" + getOpenid() + "'" +
            ", scope='" + getScope() + "'" +
            ", add_time='" + getAdd_time() + "'" +
            ", add_ip='" + getAdd_ip() + "'" +
            "}";
    }
}
