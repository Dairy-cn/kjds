package com.cross.model.message;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *消息模板详细内容
 * added by wy at 20190828
 * */
public class MsgContentVM implements Serializable {

    @ApiModelProperty(value = "消息模板id")
    private Long messageConfigId;

    @ApiModelProperty(value = "平台id")
    private Long platformId;

    @ApiModelProperty(value = "数据对应的字段")
    private List<MsgContentDataVM> msgContentDataVMS;

    @ApiModelProperty(value = "详细字段")
    private String msgContent;

    /**
     * 订单类型
     */
    @ApiModelProperty(value = "订单类型")
    private String orderType;

    @ApiModelProperty(value = "示例")
    private String example;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 消息类别
     */
    @ApiModelProperty(value = "消息类别")
    private SmsType smsType;

    /**
     * 发送事件
     */
    @ApiModelProperty(value = "发送事件")
    private String event;

    /**
     * 短信发送用户信息
     */
    @ApiModelProperty(value = "短信发送用户信息")
    private List<SmsToUserInfo> smsToUserInfos;


    public List<MsgContentDataVM> getMsgContentDataVMS() {
        return msgContentDataVMS;
    }

    public void setMsgContentDataVMS(List<MsgContentDataVM> msgContentDataVMS) {
        this.msgContentDataVMS = msgContentDataVMS;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMessageConfigId() {
        return messageConfigId;
    }

    public void setMessageConfigId(Long messageConfigId) {
        this.messageConfigId = messageConfigId;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public SmsType getSmsType() {
        return smsType;
    }

    public void setSmsType(SmsType smsType) {
        this.smsType = smsType;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public List<SmsToUserInfo> getSmsToUserInfos() {
        return smsToUserInfos;
    }

    public void setSmsToUserInfos(List<SmsToUserInfo> smsToUserInfos) {
        this.smsToUserInfos = smsToUserInfos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsgContentVM that = (MsgContentVM) o;
        return Objects.equals(messageConfigId, that.messageConfigId) &&
            Objects.equals(platformId, that.platformId) &&
            Objects.equals(msgContentDataVMS, that.msgContentDataVMS) &&
            Objects.equals(msgContent, that.msgContent) &&
            Objects.equals(example, that.example) &&
            Objects.equals(userId, that.userId) &&
            smsType == that.smsType &&
            Objects.equals(event, that.event) &&
            Objects.equals(smsToUserInfos, that.smsToUserInfos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageConfigId, platformId, msgContentDataVMS, msgContent, example, userId, smsType, event, smsToUserInfos);
    }

    @Override
    public String toString() {
        return "MsgContentVM{" +
            "messageConfigId=" + messageConfigId +
            ", platformId=" + platformId +
            ", msgContentDataVMS=" + msgContentDataVMS +
            ", msgContent='" + msgContent + '\'' +
            ", example='" + example + '\'' +
            ", userId=" + userId +
            ", smsType=" + smsType +
            ", event='" + event + '\'' +
            ", smsToUserInfos=" + smsToUserInfos +
            '}';
    }
}
