package com.cross.merchants.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.cross.merchants.domain.PayOrder;
import com.cross.merchants.domain.SystemInfo;
import com.cross.merchants.exception.MerchantsException;
import com.cross.merchants.repository.PayOrderRepository;
import com.cross.merchants.repository.SystemInfoRepository;
import com.cross.merchants.service.TranscationService;
import com.cross.merchants.utils.IPUtils;
import com.cross.merchants.utils.alipay.AlipayConfig;
import com.cross.merchants.utils.weixin.config.MyWeiXinConfig;
import com.cross.merchants.utils.weixin.sdk.WXPay;
import com.cross.merchants.utils.weixin.sdk.WXPayConstants;
import com.cross.merchants.utils.weixin.sdk.WXPayUtil;
import com.cross.utils.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/*************************************************************
 * Description:
 * Author: Dair
 * CreateTime: 2020/5/25
 ************************************************************/
@Service
@Transactional
public class TranscationServiceImpl implements TranscationService {

    @Autowired
    private PayOrderRepository payOrderRepository;


    @Value("${pay.weixin.notifyUrl}")
    private String weixinNotifyUrl;

    @Value("${pay.alipay.notifyUrl}")
    private String aliNotifyUrl;

    @Autowired
    private SystemInfoRepository systemInfoRepository;

    @Override
    public String weixinQrcodePay(Long orderId, HttpServletRequest request) throws Exception {
        //先查询订单
        PayOrder orderMaster = payOrderRepository.getOne(orderId);
        if (orderMaster == null) {
            throw new MerchantsException(400, "订单不存在");
        }
        if (orderMaster.getStatus() == null || orderMaster.getStatus() != 0) {
            throw new MerchantsException(400, "订单状态异常");
        }
//        //发起支付
        SystemInfo systemInfo = systemInfoRepository.getOne(1l);
        System.out.println("systemInfo" + systemInfo);
        MyWeiXinConfig myWeiXinConfig = new MyWeiXinConfig(systemInfo.getPlatAppId(), systemInfo.getPlatAppSecret(), systemInfo.getPlatAppNo(), systemInfo.getMerchantApiKey());
        WXPay wxPay = new WXPay(myWeiXinConfig, null, true, false);
        Map<String, String> data = new HashMap<>(8);
        SystemInfo one = systemInfoRepository.getOne(1L);
        data.put("body", one.getPlatformName());
        data.put("out_trade_no", orderMaster.getOrderSn());
        data.put("fee_type", "CNY");
        BigDecimal dbAmount = orderMaster.getPayAmount().multiply(new BigDecimal(100));
        data.put("total_fee", dbAmount.stripTrailingZeros().toPlainString());
        data.put("sign_type", WXPayConstants.MD5);
        String ip = IPUtils.getIpAddr(request);
        data.put("spbill_create_ip", ip);
        data.put("notify_url", weixinNotifyUrl);//测试的时候注意改成你自己的异步通知url，异步地址通知支持域名和ip的方式

//        data.put("notify_url", urlConfig.getGlgas() + "/glgas/notify/weixin/pay");//测试的时候注意改成你自己的异步通知url，异步地址通知支持域名和ip的方式
        //JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付，统一下单接口trade_type的传参可参考这里
        //MICROPAY--刷卡支付，刷卡支付有单独的支付接口，不调用统一下单接口
        data.put("trade_type", "NATIVE");
        Map<String, String> resp = wxPay.unifiedOrder(data);
        if (resp.get("return_code").trim().equals("SUCCESS")) {
            return resp.get("code_url");

        }
        return null;
    }

    @Override
    public String aliQrcodePay(Long orderId) throws AlipayApiException {
        //先查询订单
        PayOrder orderMaster = payOrderRepository.getOne(orderId);
        if (orderMaster == null) {
            throw new MerchantsException(400, "订单不存在");
        }
        if (orderMaster.getStatus() == null || orderMaster.getStatus() != 0) {
            throw new MerchantsException(400, "订单状态异常");
        }
        SystemInfo one = systemInfoRepository.getOne(1L);
        //发起支付
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();//创建API对应的request类
        AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
        model.setBody(one.getPlatformName());
        model.setOutTradeNo(orderMaster.getOrderSn()); //订单号
        model.setSubject("付款给" + one.getPlatformName());
        model.setTimeoutExpress("30m");
        model.setQrCodeTimeoutExpress("30m");
        model.setTotalAmount(orderMaster.getPayAmount().toString());
        request.setBizModel(model);
//        request.setReturnUrl(urlConfig.getGlgas() + "/glgas/user/payGas");
        request.setNotifyUrl(aliNotifyUrl);
        AlipayTradePrecreateResponse response1 = new AlipayConfig(one.getAliAppPublicKey(), one.getAliAppPrivteKey(), one.getAliAppId()).getClient().execute(request);
        String c = response1.getBody();
        Map m = JSONObject.parseObject(c, Map.class);
        c = m.get("alipay_trade_precreate_response").toString();
        m = JSONObject.parseObject(c, Map.class);
        return m.get("qr_code") == null ? "" : m.get("qr_code").toString();
    }

    @Override
    public String aliPay(String orderId) {
        try {
            SystemInfo one = systemInfoRepository.getOne(1L);

            //实例化客户端（参数：网关地址、商户appid、商户私钥、格式、编码、支付宝公钥、加密类型）
            AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.AlipayGateWay, one.getAliAppId(),
                one.getAliAppPrivteKey(), AlipayConfig.Format, AlipayConfig.Charset,
                one.getAliAppPublicKey(), AlipayConfig.SignType);
            AlipayTradeQueryRequest alipayTradeQueryRequest = new AlipayTradeQueryRequest();
            alipayTradeQueryRequest.setBizContent("{" +
                "\"out_trade_no\":\"" + orderId + "\"" +
                "}");
            AlipayTradeQueryResponse alipayTradeQueryResponse = alipayClient.execute(alipayTradeQueryRequest);
            if (alipayTradeQueryResponse.isSuccess()) {
                if ("TRADE_SUCCESS".equals(alipayTradeQueryResponse.getTradeStatus())) {
                    return "SUCCESS";
                } else if ("WAIT_BUYER_PAY".equals(alipayTradeQueryResponse.getTradeStatus())) {
                    return "WAITPAY";
                } else {
                    return "";
                }
            } else {
                return "FAIL";
            }
        } catch (AlipayApiException e) {
            // TODO Auto-generated catch block
            return null;
        }
    }

    @Override
    public String weixinPay(String orderId, String transactionId) {
        Map<String, String> request = new HashMap<String, String>();
        SystemInfo one = systemInfoRepository.getOne(1L);

        request.put("appid", one.getPlatAppId());
        request.put("mch_id", one.getPlatAppNo());
        request.put("nonce_str", System.currentTimeMillis() / 1000 + "");
        request.put("out_trade_no", orderId);

        WXPay wxPay = null;
        try {
            wxPay = new WXPay(new MyWeiXinConfig(one.getAliAppId(), one.getPlatAppSecret(), one.getPlatAppNo(), one.getMerchantApiKey()), null, true, false);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MerchantsException(400, "微信配置文件错误");
        }

        if (!StringUtils.isBlank(transactionId)) {
            request.put("transaction_id", transactionId);
        }
        String sign = "";
        try {
            sign = WXPayUtil.generateSignedXml(request, "sign");
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.put("sign", sign);
        Map<String, String> response = null;
        try {
            response = wxPay.orderQuery(request);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new MerchantsException(400, "订单查询失败");
        }
        if (response != null) {
            String return_code = response.get("return_code");
            String result_code = response.get("result_code");

            if ("SUCCESS".equals(return_code) && "SUCCESS".equals(result_code)) {
                if ("SUCCESS".equals(response.get("trade_state"))) {
                    return "SUCCESS";
                }

            } else if ("REVOKED".equals(response.get("trade_state"))) {
                return "FAIL";
            } else if ("NOTPAY".equals(response.get("trade_state"))) {
                return "NOTPAY";
            } else {
                //
            }

        } else {
            return "FAIL";
        }

        return "";
    }

}
