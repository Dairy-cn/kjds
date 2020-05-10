package com.cross.enumtype;

/**
 * Created by DuYuLiang on 2017/6/17.
 */
public enum TranscationPayTypeEnum {
    /*
    支付类型
1:支付宝服务窗
2:支付宝APP
4:支付宝扫码
8:微信公众号
16:微信扫码
32:微信APP

pay.weixin.micropay——微信刷卡支付
pay.alipay.micropay——支付宝刷卡支付
pay.jdpay.micropay——京东刷卡支付
pay.qq.micropay——QQ钱包刷卡支付
pay.shiming.micropay——会员卡支付
pay.unionpay.proxy.micropay——银联支付
pay.bestpay.micropay-- 翼支付
     */
    PAY_TYPE_ALIPAY_JSPAY("pay.alipay.jspay", 100),
    PAY_TYPE_ALIPAY_NATIVE("pay.alipay.native", 101),
    PAY_TYPE_ALIPAY_MICROPAY("pay.alipay.micropay", 102),
    PAY_TYPE_WEI_XIN_JSPAY("pay.weixin.jspay", 200),
    PAY_TYPE_WEI_XIN_NATIVE("pay.weixin.native", 201),
    PAY_TYPE_WEI_XIN_MICROPAY("pay.weixin.micropay", 202),
    PAY_TYPE_JD_PAY_MICROPAY("pay.jdpay.micropay", 300),
    PAY_TYPE_QQ_PAY_MICROPAY("pay.qq.micropay", 400),
    PAY_TYPE_SHIMING_PAY_MICROPAY("pay.shiming.micropay", 500),
    PAY_TYPE_UNION_PAY_MICROPAY("pay.unionpay.micropay", 600),
    PAY_TYPE_BEST_PAY_MICROPAY("pay.bestpay.micropay", 700)
    ;

    private String name;
    private Integer value;

    TranscationPayTypeEnum(String name, Integer value){
        this.name = name;
        this.value = value;
    }

    public static Integer getValueByName(String name){
        Integer res = 0;
        switch (name){
            case "pay.alipay.jspay":
                res = PAY_TYPE_ALIPAY_JSPAY.getValue();
                break;
            case "pay.alipay.native":
                res = PAY_TYPE_ALIPAY_NATIVE.getValue();
                break;
            case "pay.alipay.micropay":
                res = PAY_TYPE_ALIPAY_MICROPAY.getValue();
                break;
            case "pay.weixin.jspay":
                res = PAY_TYPE_WEI_XIN_JSPAY.getValue();
                break;
            case "pay.weixin.native":
                res = PAY_TYPE_WEI_XIN_NATIVE.getValue();
                break;
            case "pay.weixin.micropay":
                res = PAY_TYPE_WEI_XIN_MICROPAY.getValue();
                break;
        }
        return res;
    }

    public static String getNameByValue(Integer value){
        String res = "";
        switch (value){
            case 100:
                res = PAY_TYPE_ALIPAY_JSPAY.getName();
                break;
            case 101:
                res = PAY_TYPE_ALIPAY_NATIVE.getName();
                break;
            case 102:
                res = PAY_TYPE_ALIPAY_MICROPAY.getName();
                break;
            case 200:
                res = PAY_TYPE_WEI_XIN_JSPAY.getName();
                break;
            case 201:
                res = PAY_TYPE_WEI_XIN_NATIVE.getName();
                break;
            case 202:
                res = PAY_TYPE_WEI_XIN_MICROPAY.getName();
                break;
        }
        return res;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
