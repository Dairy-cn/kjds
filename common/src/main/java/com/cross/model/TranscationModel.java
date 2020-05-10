package com.cross.model;

/**
 * A Transcation.
 */
public class TranscationModel {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String trade_no;

    private Integer amount;

    private Long user_id;

    private String trade_body;

    private Integer state;

    private Integer create_time;

    private Integer pay_time;

    private Integer use_channel;

    private String notify_url;

    private Integer daily_seq;

    private Integer seq;

    private Long merchantNo;

    private String add_ip;

    private Integer pay_type;

    private String identityId; //支付宝buyerId或者微信openId

    private String appId; //微信appId

    private String callbackUrl; //支付完成后回跳地址

    private String platMerchantId;//商户收款帐号

    private String platMasterMerchantId;//商户收款帐号父级ID

    private String platMasterMerchantSecret;//商户收款帐号父级密钥

    private String platMerchantSecret;//商户收款密钥

    private String outerTradeNo;

    private String authCode;//用户扫码支付（商户主扫）

    private Long merchantUserId;

    private Integer enableCreditCardPay;//启用信用卡支付

    private String outerRefundNo;//退款单号

    private Integer refundFee;//退款金额

    private Long userReceiveAccountId; //收款账户编号
    
    /**
     * 支付平台生成的交易号
     */
    private String payTradeId;
    
    public String getPayTradeId() {
        return payTradeId;
    }
    
    public void setPayTradeId(String payTradeId) {
        this.payTradeId = payTradeId;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getTrade_body() {
        return trade_body;
    }

    public void setTrade_body(String trade_body) {
        this.trade_body = trade_body;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Integer create_time) {
        this.create_time = create_time;
    }

    public Integer getPay_time() {
        return pay_time;
    }

    public void setPay_time(Integer pay_time) {
        this.pay_time = pay_time;
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

    public Integer getDaily_seq() {
        return daily_seq;
    }

    public void setDaily_seq(Integer daily_seq) {
        this.daily_seq = daily_seq;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getAdd_ip() {
        return add_ip;
    }

    public void setAdd_ip(String add_ip) {
        this.add_ip = add_ip;
    }

    public Integer getPay_type() {
        return pay_type;
    }

    public void setPay_type(Integer pay_type) {
        this.pay_type = pay_type;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getPlatMerchantId() {
        return platMerchantId;
    }

    public void setPlatMerchantId(String platMerchantId) {
        this.platMerchantId = platMerchantId;
    }

    public String getPlatMerchantSecret() {
        return platMerchantSecret;
    }

    public void setPlatMerchantSecret(String platMerchantSecret) {
        this.platMerchantSecret = platMerchantSecret;
    }

    public String getOuterTradeNo() {
        return outerTradeNo;
    }

    public void setOuterTradeNo(String outerTradeNo) {
        this.outerTradeNo = outerTradeNo;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public Long getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(Long merchantNo) {
        this.merchantNo = merchantNo;
    }

    public Long getMerchantUserId() {
        return merchantUserId;
    }

    public void setMerchantUserId(Long merchantUserId) {
        this.merchantUserId = merchantUserId;
    }

    public String getPlatMasterMerchantId() {
        return platMasterMerchantId;
    }

    public void setPlatMasterMerchantId(String platMasterMerchantId) {
        this.platMasterMerchantId = platMasterMerchantId;
    }

    public String getPlatMasterMerchantSecret() {
        return platMasterMerchantSecret;
    }

    public void setPlatMasterMerchantSecret(String platMasterMerchantSecret) {
        this.platMasterMerchantSecret = platMasterMerchantSecret;
    }

    public Integer getEnableCreditCardPay() {
        return enableCreditCardPay;
    }

    public void setEnableCreditCardPay(Integer enableCreditCardPay) {
        this.enableCreditCardPay = enableCreditCardPay;
    }

    public String getOuterRefundNo() {
        return outerRefundNo;
    }

    public void setOuterRefundNo(String outerRefundNo) {
        this.outerRefundNo = outerRefundNo;
    }

    public Integer getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Integer refundFee) {
        this.refundFee = refundFee;
    }

    public Long getUserReceiveAccountId() {
        return userReceiveAccountId;
    }

    public void setUserReceiveAccountId(Long userReceiveAccountId) {
        this.userReceiveAccountId = userReceiveAccountId;
    }
}
