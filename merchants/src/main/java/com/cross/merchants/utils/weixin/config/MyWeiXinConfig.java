package com.cross.merchants.utils.weixin.config;


import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.cross.merchants.utils.weixin.sdk.IWXPayDomain;
import com.cross.merchants.utils.weixin.sdk.WXPayConfig;
import com.cross.merchants.utils.weixin.sdk.WXPayConstants;

import java.io.*;

public class MyWeiXinConfig extends WXPayConfig {

    private String AppId;

    private String AppSecret;

    private String MchID;

    public String Key ; //沙箱key 901bd52605c969af378fb6d8d57c2bd0

//    //微信第三方登陆通过授权码code获取访问令牌的url
//    public static final String GetAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+AppId+"&secret="+AppSecret+"&code={code}&grant_type=authorization_code";
//
//    //微信第三方登陆通过访问令牌获取用户信息的url
//    public static final String GetUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo?scope={scope}&access_token={access_token}&openid={openid}";
//
//    //微信第三方登陆，通过刷新令牌(Refresh_token)获取访问令牌(Access_Token)
//    public static final String GetAccessTokenByRefreshTokenUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid="+AppId+"&grant_type=refresh_token&refresh_token={refreshToken}";
//
//    public static final String AuthAccessToken = "https://api.weixin.qq.com/sns/auth?access_token={accessToken}&openid={openId}";

    private byte[] certData;

    private String certPath; //E://apiclient_cert.p12  /cert/weixin/apiclient_cert.p12

    //private static final String certPath = "E://apiclient_cert.p12";

    public MyWeiXinConfig(String appId, String appSecret, String mchID,String key, String certPath) {
        this.AppId = appId;
        this.AppSecret = appSecret;
        this.MchID = mchID;
        this.Key=key;
        this.certPath = certPath;
    }

    public MyWeiXinConfig(String appId, String appSecret, String mchID,String key) {
        this.AppId = appId;
        this.AppSecret = appSecret;
        this.MchID = mchID;
        this.Key=key;
    }

    public static final int HttpConnectTimeoutMs = 8000; //毫秒

    public static final int HttpReadTimeoutMs = 10000; //毫秒




//    public static final MyWeiXinConfig myConfig = new MyWeiXinConfig();


    private MyWeiXinConfig() {
        if(certPath!=null){
            File file = new File(certPath);
            InputStream certStream = null;

            try {
                certStream = new FileInputStream(file);
                this.certData = new byte[(int) file.length()];
                certStream.read(this.certData);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (certStream != null) {
                    try {
                        certStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getAppID() {
        return AppId;
    }

    public String getMchID() {
        return MchID;
    }


    public String getKey() {
        return Key;
    }

    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    public int getHttpConnectTimeoutMs() {
        return HttpConnectTimeoutMs;
    }

    public int getHttpReadTimeoutMs() {
        return HttpReadTimeoutMs;
    }


    @Override
    public IWXPayDomain getWXPayDomain() {
        return new IWXPayDomain() {
            @Override
            public void report(String domain, long elapsedTimeMillis, Exception ex) {
                System.out.println(domain + "-----" + elapsedTimeMillis);
            }

            @Override
            public DomainInfo getDomain(WXPayConfig config) {
                return new IWXPayDomain.DomainInfo(WXPayConstants.DOMAIN_API, true);
            }
        };

    }

    public String getAppId() {
        return AppId;
    }

    public void setAppId(String appId) {
        AppId = appId;
    }

    public String getAppSecret() {
        return AppSecret;
    }

    public void setAppSecret(String appSecret) {
        AppSecret = appSecret;
    }

    public void setMchID(String mchID) {
        MchID = mchID;
    }

    public byte[] getCertData() {
        return certData;
    }

    public void setCertData(byte[] certData) {
        this.certData = certData;
    }

    public String getCertPath() {
        return certPath;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }
}
