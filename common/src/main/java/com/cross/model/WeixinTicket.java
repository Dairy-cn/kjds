package com.cross.model;

/**
 * @Author DuYuLiang on 2017/10/21.
 */
public class WeixinTicket {
    /**
     * 错误编码
     */
    private Integer errcode;
    /**
     * 错误消息
     */
    private String errmsg;
    /**
     * JS嘀嗒
     */
    private String ticket;
    /**
     * 过期时间
     */
    private Integer expires_in;

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }
}
