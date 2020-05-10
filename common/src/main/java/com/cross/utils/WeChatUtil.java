package com.cross.utils;

import com.google.gson.Gson;
import com.cross.model.UserWeixinAccessToken;
import com.cross.model.UserWeixinModel;
import com.cross.model.WeixinTicket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author DuYuLiang on 2017/6/10.
 */
@Component
public class WeChatUtil {
    /**
     * 微信缓存表
     */
    private static final String WE_CHAT_KEY = "weChatMap:";

    /**
     * 微信accessToken缓存key
     */
    private static final String WE_CHAT_ACCESS_TOKEN_KEY = "weChatAccessTokenKey:%s";

    /**
     * 微信accessToken缓存key
     */
    private static final String WE_CHAT_TICKET_REDIS_KEY = "weChatTicketKey:%s";

    /**
     * 微信嘀嗒缓存key
     */
    private static final String WE_CHAT_TICKET_KEY = "weChatTicketKey";
    /**
     * 使用字符集
     */
    private static final String CHAR_SET = "utf-8";
    private final Logger log = LoggerFactory.getLogger(WeChatUtil.class);

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 微信ACCESS URL
     */
    @Value("${tx.weChat.accessTokenUrl}")
    private String accessTokenUrl;
    /**
     * 微信公众号APP ID
     */
    @Value("${tx.weChat.appId}")
    private String appId;
    /**
     * 微信公众号APP密钥
     */
    @Value("${tx.weChat.appSecret}")
    private String appSecret;
    /**
     * 用户scope地址
     */
    @Value("${tx.weChat.userScopeUrl}")
    private String userScopeUrl;
    /**
     * 用户scope回调地址
     */
    @Value("${tx.weChat.userScopeUrlCallback}")
    private String userScopeUrlCallback;
    /**
     * 用户accessToken地址
     */
    @Value("${tx.weChat.userAccessTokenUrl}")
    private String userAccessTokenUrl;
    /**
     * 微信access TTL
     */
    private Integer weChatAccessTokenTTL = 7000;
    @Value("${qxh.domain}")
    private String domain;


//    public static final String WEBADDRESS = "http://8y86gm.natappfree.cc/";

    /**
     * 获取微信基础ACCESS TOKEN
     *
     * @return
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    
    public String getWeChatAccessToken() {
        //Map<String, String> map = hazelcastInstance.getMap(WE_CHAT_KEY);
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String accessToken = valueOperations.get(String.format(WE_CHAT_ACCESS_TOKEN_KEY, appId));

        if (accessToken == null || accessToken.isEmpty()) {
            //从腾讯拉取
            try {
                String result = HttpRequestUtil.sendGet(String.format(accessTokenUrl, appId, appSecret), new HashMap<>(), CHAR_SET);
                log.info("get we chat access token:{} ", result);
                GsonJsonParser gsonJsonParser = new GsonJsonParser();
                Map<String, Object> accessTokenMap = gsonJsonParser.parseMap(result);
                accessToken = accessTokenMap.get("access_token").toString();
                valueOperations.set(String.format(WE_CHAT_ACCESS_TOKEN_KEY, appId), accessToken, 55, TimeUnit.MINUTES);
                //setWeChatAccessToken(accessToken);
            } catch (Exception e) {
                log.error("get weiChat access token fail:", e);
            }
        }
        return accessToken;
    }

    /**
     * 设置微信基础ACCESS token值
     *
     * @param accessToken
     * @return
     */
//    public String setWeChatAccessToken(String accessToken) {
//        //这里后期需要上锁或者定时刷新
//        IMap<String, String> map = hazelcastInstance.getMap(WE_CHAT_KEY);
//        return map.put(WE_CHAT_ACCESS_TOKEN_KEY, accessToken, weChatAccessTokenTTL, TimeUnit.SECONDS);
//    }

    /**
     * 设置微信JSTicket值
     *
     * @param ticket
     * @return
     */
    public void setWeChatTicket(String ticket) {
        //这里后期需要上锁或者定时刷新
        stringRedisTemplate.opsForValue().set(WE_CHAT_TICKET_KEY,ticket,weChatAccessTokenTTL, TimeUnit.SECONDS);
    }

    /**
     * 获取用户scope
     *
     * @param state
     * @param request
     * @param response
     * @throws Exception
     */
    public void goGetUserScopeCode(String state, HttpServletRequest request,
                                   HttpServletResponse response) throws
        IOException {
        response.sendRedirect(String.format(
            userScopeUrl,
            appId,
            domain + userScopeUrlCallback,
//            WEBADDRESS + userScopeUrlCallback,
            state // state CommonUtil.baseDomain(request)
        ));
    }

    public void goGetUserScopeCodeOther(String state, HttpServletRequest request, HttpServletResponse response) throws
        IOException {
        response.sendRedirect(String.format(
            userScopeUrl,
            appId,
            state,
            1
        ));
    }

    /**
     * 获取微信用户scope
     *
     * @param state
     * @param request
     * @param response
     * @param userScopeUrlCallback
     * @throws IOException
     */
    public void goGetUserScopeCode(String state, HttpServletRequest request,
                                   HttpServletResponse response, String userScopeUrlCallback)
        throws
        IOException {
        response.sendRedirect(String.format(userScopeUrl, appId, userScopeUrlCallback, state));
//        response.sendRedirect(String.format(userScopeUrl, appId, WEBADDRESS + userScopeUrlCallback, state));
    }

    /**
     * 获取用户accessToken
     *
     * @param code
     * @param appId
     * @param appSecret
     * @return
     */
    public UserWeixinAccessToken getUserAccessTokenByCode(String code, String appId, String appSecret) {
        return getWeiXinAccessToken(userAccessTokenUrl, appId, appSecret, code);
    }

    /**
     * 获取用户accessToken
     *
     * @param code
     * @return
     */
    public UserWeixinAccessToken getUserAccessTokenByCode(String code) {
        return getWeiXinAccessToken(userAccessTokenUrl, appId, appSecret, code);
    }

    /**
     * 获取用户基础信息
     *
     * @param openId
     * @return
     */
    public UserWeixinModel getUserWeixin(String openId) {
        String apiUrl = String.format("https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN", this.getWeChatAccessToken(), openId);
        String result = HttpRequestUtil.sendGet(apiUrl, new HashMap<>(), CHAR_SET);
        Gson gson = new Gson();
        UserWeixinModel weixinModel = gson.fromJson(result, UserWeixinModel.class);

        if (weixinModel.getOpenid() == null) {
            log.error("get we chat user info fail", result);
        }

        return weixinModel;
    }

    public WeixinTicket getWeixinTicket() {
        String accessToken = this.getWeChatAccessToken();
        WeixinTicket weixinTicket = new WeixinTicket();
        Object map = redisTemplate.opsForValue().get(WE_CHAT_TICKET_KEY);
        String ticket = map.toString();
        weixinTicket.setTicket(ticket);
        if (weixinTicket.getTicket() == null || weixinTicket.getTicket().isEmpty()) {
            //从腾讯拉取
            try {
                String apiUrl = String.format("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi", this.getWeChatAccessToken(), accessToken);
                String result = HttpRequestUtil.sendGet(apiUrl, new HashMap<>(), CHAR_SET);
                weixinTicket = (WeixinTicket) JsonUtil.jsonToBean(result, WeixinTicket.class);
                setWeChatTicket(weixinTicket.getTicket());
            } catch (Exception e) {
                log.error("get weiChat ticket fail:", e);
            }
        }
        return weixinTicket;
    }

    /**
     * 设置密钥
     *
     * @param secret
     */
    public void setAppSecret(String secret) {
        this.appSecret = secret;
    }

    public String getAppId() {
        return this.appId;
    }

    /**
     * 设置APP ID
     *
     * @param appId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    private UserWeixinAccessToken getWeiXinAccessToken(String userAccessTokenUrl,
                                                       String appId,
                                                       String appSecret,
                                                       String code) {
        String result = HttpRequestUtil.sendGet(String.format(userAccessTokenUrl, appId, appSecret, code), new HashMap<>(), CHAR_SET);
        Gson gson = new Gson();
        log.info("we chat get data:" + result);
        UserWeixinAccessToken userWeixinAccessToken = gson.fromJson(result, UserWeixinAccessToken.class);

        if (null == userWeixinAccessToken || null == userWeixinAccessToken.getOpenid()) {
            log.error("get we chat open id fail", result);
        }

        return userWeixinAccessToken;
    }


    public WeixinTicket getWeixinTicket(String appId, String appSecret) {
        String accessToken = this.getWeChatAccessToken(appId, appSecret);
        WeixinTicket weixinTicket = new WeixinTicket();

        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String ticket = valueOperations.get(String.format(WE_CHAT_TICKET_REDIS_KEY, appId));

        if (null == ticket || ticket.isEmpty()) {
            //从腾讯拉取
            try {
                String apiUrl = String.format("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi", accessToken);
                String result = HttpRequestUtil.sendGet(apiUrl, new HashMap<>(), CHAR_SET);
                weixinTicket = (WeixinTicket) JsonUtil.jsonToBean(result, WeixinTicket.class);
                valueOperations.set(String.format(WE_CHAT_TICKET_REDIS_KEY, appId), weixinTicket.getTicket(), 115, TimeUnit.MINUTES);
            } catch (Exception e) {
                log.error("get weiChat ticket fail:", e);
            }
        }
        return weixinTicket;
    }

    /**
     * 根据appId 和 app密钥获取accessToken
     *
     * @param appId
     * @param appSecret
     * @return
     */
    public String getWeChatAccessToken(String appId, String appSecret) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String accessToken = valueOperations.get(String.format(WE_CHAT_ACCESS_TOKEN_KEY, appId));

        if (accessToken == null || accessToken.isEmpty()) {
            //从腾讯拉取
            try {
                String result = HttpRequestUtil.sendGet(String.format(accessTokenUrl, appId, appSecret), new HashMap<>(), CHAR_SET);
                GsonJsonParser gsonJsonParser = new GsonJsonParser();
                Map<String, Object> accessTokenMap = gsonJsonParser.parseMap(result);
                accessToken = accessTokenMap.get("access_token").toString();
                valueOperations.set(String.format(WE_CHAT_ACCESS_TOKEN_KEY, appId), accessToken, 115, TimeUnit.MINUTES);
            } catch (Exception e) {
                log.error("get weiChat access token fail:", e);
            }
        }
        return accessToken;
    }/**
     * 根据appId 和 app密钥获取accessToken
     *
     * @param appId
     * @param appSecret
     * @return
     */
    public String getWeChatAccessTokenNew(String appId, String appSecret) {
//        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String accessToken = null;
        try {
            accessToken= redisTemplate.opsForValue().get(String.format(WE_CHAT_ACCESS_TOKEN_KEY, appId)).toString();
        }catch (Exception e){
            log.error("getWeChatAccessTokenNew error" +e.getMessage());
        }
        if (accessToken == null || accessToken.isEmpty()) {
            //从腾讯拉取
            try {
                String result = HttpRequestUtil.sendGet(String.format(accessTokenUrl, appId, appSecret), new HashMap<>(), CHAR_SET);
                log.info("token记录获取:"+result);
                GsonJsonParser gsonJsonParser = new GsonJsonParser();
                Map<String, Object> accessTokenMap = gsonJsonParser.parseMap(result);
                accessToken = accessTokenMap.get("access_token").toString();
                redisTemplate.opsForValue().set(String.format(WE_CHAT_ACCESS_TOKEN_KEY, appId), accessToken, 5, TimeUnit.MINUTES);
            } catch (Exception e) {
                log.error("get weiChat access token fail:", e);
            }
        }
        return accessToken;
    }
}
