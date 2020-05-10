package com.cross.model;

/**
 * Created by DuYuLiang on 2017/7/13.
 */
public class UserLoginLogModel {
    private Long userId;
    private Long platAccountId;
    private Integer loginTime;
    private String LoginIp;
    private String LoginPosition;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPlatAccountId() {
        return platAccountId;
    }

    public void setPlatAccountId(Long platAccountId) {
        this.platAccountId = platAccountId;
    }

    public Integer getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Integer loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return LoginIp;
    }

    public void setLoginIp(String loginIp) {
        LoginIp = loginIp;
    }

    public String getLoginPosition() {
        return LoginPosition;
    }

    public void setLoginPosition(String loginPosition) {
        LoginPosition = loginPosition;
    }
}
