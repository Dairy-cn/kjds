//package com.cross.utils;
//
//import com.taobao.api.DefaultTaobaoClient;
//import com.taobao.api.TaobaoClient;
//import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
//import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
///**
// * Created by DuYuLiang on 2017/6/3.
// */
//@Component
//public class SmsUtil {
//    private final Logger log = LoggerFactory.getLogger(SmsUtil.class);
//
//    @Value("${aliDaYu.sms.url}")
//    private String url;
//
//    @Value("${aliDaYu.sms.appKey}")
//    private String appKey;
//
//    @Value("${aliDaYu.sms.secret}")
//    private String secret;
//
//    @Value("${aliDaYu.sms.template}")
//    private String template;
//
//    @Value("${aliDaYu.sms.signName}")
//    private String signName;
//
//    @Value("${aliDaYu.sms.appId}")
//    private Integer appId;
//
//    @Value("${aliDaYu.sms.appName}")
//    private String appName;
//
//    /**
//     * 快捷发送验证码
//     *
//     * @param mobile
//     * @return
//     * @throws Exception
//     */
//    public Long sendValidateCode(String mobile) throws Exception{
//        return sendValidateCode(mobile, appId, appName, signName, template);
//    }
//
//    /**
//     * 快捷发送验证码
//     *
//     * @param mobile
//     * @param appId
//     * @param appName
//     * @return
//     * @throws Exception
//     */
//    public Long sendValidateCode(String mobile, Integer appId, String appName) throws Exception{
//        return sendValidateCode(mobile, appId, appName, signName, template);
//    }
//
//    /**
//     * 使用默认模板发送验证码
//     *
//     * @param mobile
//     * @param appId
//     * @param appName
//     * @param signName
//     * @return
//     * @throws Exception
//     */
//    public Long sendValidateCode(String mobile, Integer appId, String appName, String signName) throws Exception{
//        return sendValidateCode(mobile, appId, appName, signName, template);
//    }
//
//    /**
//     * 自定义发送验证码
//     *
//     * @param mobile
//     * @param appId
//     * @param appName
//     * @param signName
//     * @param template
//     * @return
//     * @throws Exception
//     */
//    public Long sendValidateCode(String mobile, Integer appId, String appName, String signName, String template) throws Exception{
//        Long validateCode = RandomUtil.generateValidateCode();
//        TaobaoClient client = new DefaultTaobaoClient(url, appKey, secret);
//        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
//        req.setExtend(appId.toString());
//        req.setSmsType("normal");
//        req.setSmsFreeSignName(signName);
//        req.setSmsParamString("{\"code\":\""+validateCode.toString()+"\",\"product\":\""+appName+"\"}");
//        req.setRecNum(mobile);
//        req.setSmsTemplateCode(template);
//        AlibabaAliqinFcSmsNumSendResponse rsp = new AlibabaAliqinFcSmsNumSendResponse();//client.execute(req);
//        if(rsp.getErrorCode()!=null && !rsp.getErrorCode().equals("")){
//            log.trace(rsp.getBody());
//            //throw new Exception(rsp.getMsg());
//        }
//        return validateCode;
//    }
//}
