package com.cross.model;

import java.util.Arrays;

/**
 * @Author DuYuLiang on 2017/11/20.
 */
public class LoginUserModel {
    private String user_name;
    private String[] scope;
    private Long id;
    private Integer exp;
    private String[] authorities;
    private String jti;
    private Long masterId;
    private Long employeeId;
    private Long platformId;
    
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String[] getScope() {
        return scope;
    }

    public void setScope(String[] scope) {
        this.scope = scope;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public String[] getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String[] authorities) {
        this.authorities = authorities;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }

    public Long getMasterId() {
        return masterId!=null?masterId:id;
    }

    public void setMasterId(Long masterId) {
        this.masterId = masterId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
    
    public Long getPlatformId() {
        return platformId;
    }
    
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }
    
    @Override
    public String toString() {
        return "LoginUserModel{" +
            "user_name='" + user_name + '\'' +
            ", scope=" + Arrays.toString(scope) +
            ", id=" + id +
            ", exp=" + exp +
            ", authorities=" + Arrays.toString(authorities) +
            ", jti='" + jti + '\'' +
            ", masterId=" + masterId +
            ", employeeId=" + employeeId +
            ", platformId=" + platformId +
            '}';
    }
}
