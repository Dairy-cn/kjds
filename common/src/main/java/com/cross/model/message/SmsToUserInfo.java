package com.cross.model.message;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 *短信发送用户信息
 * added by wy at 20191115
 * */
public class SmsToUserInfo  implements Serializable {

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "用户电话")
    private String receiverPhone;

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

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmsToUserInfo that = (SmsToUserInfo) o;
        return Objects.equals(userId, that.userId) &&
            Objects.equals(userName, that.userName) &&
            Objects.equals(receiverPhone, that.receiverPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, receiverPhone);
    }

    @Override
    public String toString() {
        return "SmsToUserInfo{" +
            "userId=" + userId +
            ", userName='" + userName + '\'' +
            ", receiverPhone='" + receiverPhone + '\'' +
            '}';
    }
}
