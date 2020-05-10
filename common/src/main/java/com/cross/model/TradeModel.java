package com.cross.model;

/**
 * Created by DuYuLiang on 2017/6/12.
 */
public class TradeModel {
    private Integer amount; //交易金额

    //private Long user_id; //用户ID

    private String trade_body; //交易内容

    private Integer time; //创建时间

    private Integer use_channel; //使用通道 默认为1 威富通

    private String notify_url; // 交易通知地址

    private Long merchant_no; // 商户编号

    //private String ip; // 发起交易IP

    private String pay_type; // 支付类型

    //private String identityId; //支付宝buyerId或者微信openId

    //private String appId; //微信appId

    private String callback_url; //支付完成后回跳地址

    //private String platMerchantId;//商户收款帐号

    //private String platMerchantSecret;//商户收款密钥

    private String order_sn;// 第三方订单号

    private String sign;// 签名串


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getTrade_body() {
        return trade_body;
    }

    public void setTrade_body(String trade_body) {
        this.trade_body = trade_body;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getUse_channel() {
        return use_channel;
    }

    public void setUse_channel(Integer use_channel) {
        this.use_channel = use_channel;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public Long getMerchant_no() {
        return merchant_no;
    }

    public void setMerchant_no(Long merchant_no) {
        this.merchant_no = merchant_no;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getCallback_url() {
        return callback_url;
    }

    public void setCallback_url(String callback_url) {
        this.callback_url = callback_url;
    }

    public String getOrder_sn() {
        return order_sn;
    }

    public void setOrder_sn(String order_sn) {
        this.order_sn = order_sn;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
