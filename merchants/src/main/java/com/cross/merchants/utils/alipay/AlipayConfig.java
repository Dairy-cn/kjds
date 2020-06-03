package com.cross.merchants.utils.alipay;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import lombok.Data;

@Data
public class AlipayConfig {

    //=====================正式============================
    //支付宝公钥，注意不是应用公钥，app中的公钥都是支付宝公钥，而不是应用公钥
    private String AlipayPublicKey;

    //应用私钥，就是 应用私钥2048.txt 文件中的内容
    private String AppPrivteKey;

    //AppId
    private String AppId;

    //支付宝的支付网关  固定，请勿修改
    public static final String AlipayGateWay = "https://openapi.alipay.com/gateway.do";

    //sellerId，也就是商户的Pid
    public static final String PId = "2088331134544033";

    //==========================沙箱===================

    //支付宝公钥，注意不是应用公钥，app中的公钥都是支付宝公钥，而不是应用公钥
/*
    public static final String AlipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsBgGPfWl7uXU2LIE3+NxEF+O0TmcL+YYiblAhrKfbE5KpXZwmc6mEjVQCwMH/Ta4ul0Y1FBfsFqcCHrIM4PWW9x50VTazTiGPC/ThDW0rTgXVPopBo8oRUMuYnt5wljxn1K6jWla12/+7AOmhCz62BU9CisPxcF3vw54n+SpvCaaO2fMWsA7+l1HgVHc/9BoP2SV+WMvqpWePAfL4VyfYHTZbzT3fgSemmLOkSUmpLIwf6Zhjo76KeLIygSKNBQQZo3rofDZpNg84Ma2tKw5glBK0K9SPxPtSedFDlfBoiFWbs5gm5qL+VE8jRyPlE3OVnEFAkZxy4LkR2Q7XqZPCQIDAQAB";

    //应用私钥，就是 应用私钥2048.txt 文件中的内容
    public static final String AppPrivteKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC0RtEBCoYPOucunGXxuZw0ejRfD7bztZw/jlQuc7P4Y4i16GOTsnP4pgQWBrt1co4DTD/UJOyTpcephQL+qGcDQtuXWeca/klekk7YqXx7PpFb/X3ws5QIuUDFMLx65T3NTJ81IDFgCPxfOM++6OPYhm9CK73/bRQP2d+rvAZ+klEqMyNQJZFvpotBFRZ4G4iCAD78NhqEFKIV5RfdbXfNTXkGa1L2SSyyBjyCd/NEtVXR3AONGquTO9krGPiTdWpyhhn9l8WTy4IRLpVPanyKYx2IOW8urd2RNC/pzNrjBr4P3z26M05jt/3Ehs9lO7rLXACtGjU52y/Es0J7agqvAgMBAAECggEAckWpWiWXkLPfstYEcNMcxs7nv5IwgA8QeeD4T3GcFMjS8ava4tZtWKGzWVrvHKV+i2yb0ReOtpCRHU1o9o88rP6GP0wHiD7DtyS6we+9LkoczdjDKf5KybTT76rS7nu9TxNQn9ZGNf+8KYfTd8ocEzYz9BfSGcTEwL90XmGTJEr9WV12+HzHXL7Fb3aSczBqYIJRm9qLFoX6mjoBJ7i6qB73zvyagoy6CoJfcHDPA4sbqE2vXRlmJr2ZRLOpUA/TAL0NoFji733uwHbTM+AvAGdGqHd4JkIroelDWhGc/wjGMXQbJ7q2bKOgmrdIWruD3QAjFCptGnH96eCBXuVigQKBgQDtjzFzO5wPfLZc5MRvf98q0qJGwEjRGbQTiOPpZufN1tbqsfwNJC11XC8xyb/s/uiku24b2GsxrlfwRDjPq8FnjfjJwkVK7sJrc4N7z5HOJKtXhrTcPt/YnEOXrjr4l9ky0ZzkqFOcWlO38R0EmxUjs08aikrX4BRbZ50bX7R+IQKBgQDCRUtdJXxCYVTQBkmQ4o0PQZKiFQdV9KfclAz67zIZUzjxwT+abITeTIg8qC1lzPQTHGky9Ofa0OnGv24nk2G2J5YvYJbmHYF9EfTHnvVLUGTk+tyVBXUlNeLrKJiOtvXaQa8DOmLxLlditpYIJ7WtqFmbxzPHqOIgfsSRFMpOzwKBgCjxN+WTTXdB2DA0YUKSOEUqHjuxYhtfobCINDeCu8q3Dz1NxZICPS9v3tZm3gQbfr79aqGz7+2VDaTkLSJliKSvTESBje23LpzUQMHy6T8tBLbGCZ+32l57uA6JQbKcgRuIEtE5zYcx7iHSlVy42bDYc3awhOulu/xw5BvWp8XhAoGBAI0LPD0jQwT6n1XsyqprIRirdedBNzM7zkeCIa5pzUi/uD8lG6VlFk5C6EKJo3QeijH51ZLOZiritGe8giAvi6hxM0Owb74gO+vvBnWLvfFxK99nFpEHBlb+uYIb1i7/PJ26RHMmh8Es8PrVLzY6hlfPO0ezJ6/UuF/5SYM/weXXAoGBAM3DZBpMHj8CNot8CYQYFGE/9ldY2qux4aFl+l6KXxdwiAltpibk7nrLCaN+maaXuhObddKny1k5li3RiIpfBcxs+xiHO2VN3Dpo/yL6uZBqy8wWwd3Vm5AtUS7fwU0xB2jJJMr0BzzlF+vbgh3x+6twJKn6Ucl02R3RSAOkbZF1";

    //AppId
    public static final String AppId = "2016092000557388";

    //支付宝的支付网关  固定，请勿修改
    public static final String AlipayGateWay = "https://openapi.alipaydev.com/gateway.do";

    //sellerId，也就是商户的Pid
    public static final String PId = "2088102176519754";
*/


    //JSON格式只支持JSON格式 固定，请勿修改
    public static final String Format = "JSON";

    //utf8编码
    public static final String Charset = "utf-8";

    //加密类型RSA2 固定，请勿修改
    public static final String SignType = "RSA2";

    //网页支付产品码 固定，请勿修改
    public static final String PagePayProductCode = "FAST_INSTANT_TRADE_PAY";

    //App支付产品码 固定，请勿修改
    public static final String AppPayProductCode = "QUICK_MSECURITY_PAY";


    ///*该笔订单允许的最晚付款时间，逾期将关闭交易。
    //		取值范围：1m～15d。
    //		m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。
    //		该参数数值不接受小数点， 如 1.5h，可转换为 90m。
    //      注：若为空，则默认为15d。*/
    public static final String TimeOutExpress = "30m";

    /*商品主类型：0—虚拟类商品，1—实物类商品
     注：虚拟类商品不支持使用花呗渠道*/
    public static final String GoodsType = "1";


    public AlipayClient getClient() {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayGateWay, AppId, AppPrivteKey, Format, Charset, AlipayPublicKey, SignType);
        return alipayClient;
    }

    public AlipayConfig(String alipayPublicKey, String appPrivteKey, String appId) {
        this.AlipayPublicKey = alipayPublicKey;
        this.AppPrivteKey = appPrivteKey;
        this.AppId = appId;
    }

    public String getAlipayPublicKey() {
        return AlipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        AlipayPublicKey = alipayPublicKey;
    }

    public String getAppPrivteKey() {
        return AppPrivteKey;
    }

    public void setAppPrivteKey(String appPrivteKey) {
        AppPrivteKey = appPrivteKey;
    }

    public String getAppId() {
        return AppId;
    }

    public void setAppId(String appId) {
        AppId = appId;
    }
}
