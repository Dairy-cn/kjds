package com.cross.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * 平台会员信息DTO
 *
 * @author wangjuzheng
 * @since 2019-05-07
 */
public class PlatformMemberInfoDTO implements Serializable {

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    private String userPhone;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public PlatformMemberInfoDTO(Long userId, String userName, String userPhone) {
        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
    }

    public PlatformMemberInfoDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlatformMemberInfoDTO that = (PlatformMemberInfoDTO) o;
        return Objects.equals(userId, that.userId) &&
            Objects.equals(userName, that.userName) &&
            Objects.equals(userPhone, that.userPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userPhone);
    }

    @Override
    public String toString() {
        return "PlatformMemberInfoDTO{" +
            "userId=" + userId +
            ", userName='" + userName + '\'' +
            ", userPhone='" + userPhone + '\'' +
            '}';
    }
}
