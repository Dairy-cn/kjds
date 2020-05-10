package com.cross.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * 推送的消息
 * Created by LY on 2017/10/20.
 */
public class MessageModel {

    /**
     * 消息类型 1 转单给节点 2 派单 3 转单拒绝通知 4 转单给个人 5 转单同意通知
     * 6 接单请求 7 接单接受通知 8 接单拒绝通知 9 接单取消
     *
     * 21 商户新订单 22 平台管理商户申请
     */
    @ApiModelProperty(value = "消息类型 1 转单给节点 2 派单 3 转单拒绝通知 4 转单给个人 5 转单同意通知 6 接单请求 7 接单接受通知 8 接单拒绝通知 9 接单取消 ")
    private Integer type;

    /**
     * 消息值
     */
    private String value;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息内容
     */
    private String message;

    /**
     * 订单处理数据
     */
    private String orders;

    /**
     * 订单区别key
     */
    private String key;

    /**
     * 商户处理数据
     */
    private String merchants;

    public String getMerchants() {
        return merchants;
    }

    public void setMerchants(String merchants) {
        this.merchants = merchants;
    }

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public MessageModel(){

    }

    public MessageModel(Integer type, String value, String title, String message, String orders, String key, String merchants){
        this.type = type;
        this.value = value;
        this.title = title;
        this.orders = orders;
        this.message = message;
        this.key = key;
        this.merchants = merchants;
    }

    @Override
    public String toString() {
        return "MessageModel{" +
                "type=" + type +
                ", value='" + value + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", orders='" + orders + '\'' +
                '}';
    }
}
