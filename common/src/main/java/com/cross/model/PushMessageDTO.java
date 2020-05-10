package com.cross.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author DuYuLiang on 2017/10/19.
 */
public class PushMessageDTO {
    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("终端类型 1 安卓 2 ios")
    private Integer deviceType;

    @ApiModelProperty("推送目标：\n" +
        "     DEVICE:根据设备推送\n" +
        "     ACCOUNT:根据账号推送\n" +
        "     ALIAS:根据别名推送\n" +
        "     TAG:根据标签推送\n" +
        "     ALL:推送给全部设备")
    private String target;

    @ApiModelProperty("根据Target来设定，多个值使用逗号分隔，最多支持100个。\n" +
        "     Target=DEVICE，值如deviceid111,deviceid1111\n" +
        "     Target=ACCOUNT，值如account111,account222\n" +
        "     Target=ALIAS，值如alias111,alias222\n" +
        "     Target=TAG，支持单Tag和多Tag，格式请参考 标签格式\n" +
        "     Target=ALL，值为all")
    private String targetValue;

    @ApiModelProperty("应用key")
    private Long appKey;

    @ApiModelProperty("内容")
    private String body;

    @ApiModelProperty("推送类型 1发消息 2发通知")
    private Integer type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Long getAppKey() {
        return appKey;
    }

    public void setAppKey(Long appKey) {
        this.appKey = appKey;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(String targetValue) {
        this.targetValue = targetValue;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PushMessageDTO{" +
                "title='" + title + '\'' +
                ", deviceType=" + deviceType +
                ", target='" + target + '\'' +
                ", targetValue='" + targetValue + '\'' +
                ", appKey=" + appKey +
                ", body='" + body + '\'' +
                ", type=" + type +
                '}';
    }
}
