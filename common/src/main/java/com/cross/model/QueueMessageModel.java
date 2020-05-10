package com.cross.model;

import java.io.Serializable;

/**
 * Created by DuYuLiang on 2017/6/19.
 */
public class QueueMessageModel<T> implements Serializable {
    private Integer messageType; //1 支付异步通知 2 支付状态查询
    private String message;// 消息主体
    //private Object message;
    //private Gson gson = new Gson();

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

  /*  public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }*/
/*    public T jsonToEntity(String json, Type type){
        return (T) JsonUtil.jsonToBean(json, type);
    }*/

    public String toString(){
        return "{\"messageType\":"+messageType+", \"message\":\""+message+"\"}";
    }
}
