package com.cross.uaa.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


/**
 * 用户模型
 *
 * @author DuYuLiang on 2017/6/12.
 */
public class QxhUserDetail extends User implements UserDetails {
    private Long userId;
    private Long employeeId;
    //private String username;
    private Long platformId;

    public QxhUserDetail(String username, String password, Long platformId, Collection<? extends GrantedAuthority> authorities, Long userId) {
        super(username, password, true, true, true, true, authorities);
        this.userId = userId;
        this.platformId = platformId;
    }
    public QxhUserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities, Long userId) {
        super(username, password, true, true, true, true, authorities);
        this.userId = userId;
    }
    public QxhUserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities, Long userId, Long employeeId) {
        super(username, password, true, true, true, true, authorities);
        this.userId = userId;
        this.employeeId = employeeId;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
