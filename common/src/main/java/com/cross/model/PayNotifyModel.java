package com.cross.model;

import java.io.Serializable;

/**
 * Created by DuYuLiang on 2017/6/17.
 */
public class PayNotifyModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer channel;
    private String  version;	//版本号	是	(8)	版本号，version默认值是2.0。
    private String  charset;	//字符集	是	(8)	可选值 UTF-8 ，默认为 UTF-8。
    private String  sign_type;	//签名方式	是	(8)	签名类型，取值：MD5默认：MD5
    private String  status;	//返回状态码	是	(16)	0表示成功非0表示失败此字段是通信标识，非交易标识，交易是否成功需要查看 result_code 来判断
    private String  message;	//返回信息	否	(128)	返回信息，如非空，为错误原因签名失败参数格式校验错误
    private String  result_code;	//业务结果	是	(16)	0表示成功非0表示失败
    private String  mch_id;	//商户号	是	(32)	商户号，由平台分配
    private String  device_info;	//设备号	否	(32)	终端设备号
    private String  nonce_str;	//随机字符串	是	(32)	随机字符串，不长于 32 位
    private String  err_code;	//错误代码	否	(32)	参考错误码
    private String  err_msg;	//错误代码描述	否	 (128)	结果信息描述
    private String  sign;	//签名	是	(32)	MD5签名结果，详见“安全规范”
    private String  openid;	//用户标识	是	(128)	用户在服务商 appid 下的唯一标识
    private String  trade_type;	//交易类型	是	(32)	pay.weixin.native
    private String  is_subscribe;	//是否关注公众账号	是	(1)	用户是否关注服务商公众账号，Y-关注，N-未关注
    private Integer pay_result;	//支付结果	是	Int	支付结果：0—成功；其它—失败
    private String  pay_info;	//支付结果信息	否	(64)	支付结果信息，支付成功时为空
    private String  transaction_id;	//平台订单号	是	(32)	平台交易单号
    private String  out_transaction_id;	//第三方订单号	是	(32)	第三方订单号
    private String  sub_is_subscribe;	//是否关注商户公众号	否	(1)	用户是否关注子公众账号，Y-关注，N-未关注，
    private String  sub_appid;	//商户appid	否		商户公众号appid
    private String  sub_openid;	//用户openid	否	(128)	用户在商户公众号appid 下的唯一标识
    private String  out_trade_no;	//商户订单号	是	(32)	商户系统内部的定单号，32个字符内、可包含字母
    private Integer total_fee;	//总金额	是	Int	总金额，以分为单位，不允许包含任何字、符号
    private Integer coupon_fee;	//现金券金额	否	Int	现金券支付金额<=订单总金额， 订单总金额-现金券金额为现金支付金额
    private String  fee_type;	//货币种类	是	(8)	货币类型，符合 ISO 4217 标准的三位字母代码，默认人民币：CNY
    private String  attach;	//附加信息	否	(127)	商家数据包，原样返回
    private String  bank_type;	//付款银行	是	(16)	银行类型
    private String  bank_billno;	//银行订单号	否	(32)	银行订单号，若为微信支付则为空
    private String  time_end;	//支付完成时间	是	(14)	支付完成时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。时区为GMT+8

    private Integer add_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_msg() {
        return err_msg;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getIs_subscribe() {
        return is_subscribe;
    }

    public void setIs_subscribe(String is_subscribe) {
        this.is_subscribe = is_subscribe;
    }

    public Integer getPay_result() {
        return pay_result;
    }

    public void setPay_result(Integer pay_result) {
        this.pay_result = pay_result;
    }

    public String getPay_info() {
        return pay_info;
    }

    public void setPay_info(String pay_info) {
        this.pay_info = pay_info;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOut_transaction_id() {
        return out_transaction_id;
    }

    public void setOut_transaction_id(String out_transaction_id) {
        this.out_transaction_id = out_transaction_id;
    }

    public String getSub_is_subscribe() {
        return sub_is_subscribe;
    }

    public void setSub_is_subscribe(String sub_is_subscribe) {
        this.sub_is_subscribe = sub_is_subscribe;
    }

    public String getSub_appid() {
        return sub_appid;
    }

    public void setSub_appid(String sub_appid) {
        this.sub_appid = sub_appid;
    }

    public String getSub_openid() {
        return sub_openid;
    }

    public void setSub_openid(String sub_openid) {
        this.sub_openid = sub_openid;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public Integer getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
    }

    public Integer getCoupon_fee() {
        return coupon_fee;
    }

    public void setCoupon_fee(Integer coupon_fee) {
        this.coupon_fee = coupon_fee;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getBank_type() {
        return bank_type;
    }

    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }

    public String getBank_billno() {
        return bank_billno;
    }

    public void setBank_billno(String bank_billno) {
        this.bank_billno = bank_billno;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    public Integer getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Integer add_time) {
        this.add_time = add_time;
    }
}
