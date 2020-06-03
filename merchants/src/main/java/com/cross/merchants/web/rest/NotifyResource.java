package com.cross.merchants.web.rest;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.aliyuncs.utils.StringUtils;
import com.cross.merchants.exception.MerchantsException;
import com.cross.merchants.service.PayOrderService;
import com.cross.merchants.service.SystemInfoService;
import com.cross.merchants.service.TranscationService;
import com.cross.merchants.service.dto.PayOrderDTO;
import com.cross.merchants.service.dto.SystemInfoDTO;
import com.cross.merchants.utils.alipay.AlipayConfig;
import com.cross.merchants.utils.alipay.AlipayNotifyParam;
import com.cross.merchants.utils.alipay.AlipayTradeStatus;
import com.cross.merchants.utils.weixin.config.MyWeiXinConfig;
import com.cross.merchants.utils.weixin.sdk.WXPayUtil;
import io.netty.util.internal.MathUtil;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*************************************************************
 * Description:
 * Author: Dair
 * CreateTime: 2020/5/27
 ************************************************************/
@RestController
@RequestMapping("/api/notify")
@Api(tags = "支付结果接口")
public class NotifyResource {
    private final Logger log = LoggerFactory.getLogger(NotifyResource.class);

    @Autowired
    private TranscationService transcationService;

    @Autowired
    private PayOrderService payOrderService;

    private ExecutorService executorService = Executors.newFixedThreadPool(20);

    private static final Double MONEY_RANGE = 0.01;


    @Autowired
    private SystemInfoService systemInfoService;

    @PostMapping(value = "/alipay/pay")
    @ResponseBody
    public String alipayNotify(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String payStatus = "";
        // 将异步通知中收到的待验证所有参数都存放到map中
        Map<String, String> params = convertRequestParamsToMap(request);
        try {
            String paramsJson = JSON.toJSONString(params);
            log.info("支付宝回调，{}", paramsJson);
            try {
                // 支付宝配置
                // 调用SDK验证签名
                Optional<SystemInfoDTO> one = systemInfoService.findOne(1l);
                if (!one.isPresent()) {
                    return "failure";
                }
                SystemInfoDTO systemInfoDTO = one.get();
                boolean signVerified = AlipaySignature.rsaCheckV1(params, systemInfoDTO.getAliAppPublicKey(),
                    AlipayConfig.Charset, AlipayConfig.SignType);
                if (signVerified) {
                    log.info("支付宝回调签名认证成功");
                    // 按照支付结果异步通知中的描述，对支付结果中的业务内容进行1\2\3\4二次校验，校验成功后在response中返回success，校验失败返回failure
                    this.check(params, systemInfoDTO);
                    // 另起线程处理业务
                    try {
                        executorService.execute(new Runnable() {
                            @Override
                            public void run() {
//                                AlipayNotifyParam param = buildAlipayNotifyParam(params);
//                                log.info("param"+param.toString());
                                String tradeStatus = params.get("trade_status");
                                log.info("tradeStatus" + tradeStatus);
                                // 支付成功
                                if (tradeStatus.equals(AlipayTradeStatus.FINISHED.getMsg())
                                    || tradeStatus.equals(AlipayTradeStatus.SUCCESS.getMsg())) {
                                    // 处理支付成功逻辑
                                    try {

                                        // 处理业务逻辑
                                        //2. 支付的状态
                                        //3. 支付金额
                                        //4. 支付人(下单人 == 支付人)
                                        String outTradeNo = params.get("out_trade_no");

                                        String tradeNo = params.get("trade_no");

                                        //查询订单
                                        PayOrderDTO order = payOrderService.findByOrderSn(outTradeNo);

                                        //判断订单是否存在
                                        if (order == null) {
                                            log.error("【支付宝支付】异步通知, 订单不存在, orderId={}", outTradeNo);
                                            throw new MerchantsException(400, "订单不存在");
                                        }
                                        //修改订单的支付状态
                                        Object object = new Object();
                                        synchronized (object) {
                                            try {
                                                order.setPayType(1);
                                                order.setTransactionId(tradeNo);
                                                payOrderService.paid(order);
                                            } catch (Exception e) {
                                                log.error("支付宝回调业务处理报错,订单处理失败,params:" + order, e);
                                            }
                                        }

                                    } catch (Exception e) {
                                        log.error("支付宝回调业务处理报错,params:" + paramsJson, e);
                                    }
                                } else {
                                    log.error("没有处理支付宝回调业务，支付宝交易状态：{},params:{}", tradeStatus, paramsJson);
                                }
                            }
                        });
                    } catch (Exception e) {
                        log.error("没有处理支付宝回调业务;处理过程抛出异常" + paramsJson + e.getMessage());
                        return "failure";
                    }
                    // 如果签名验证正确，立即返回success，后续业务另起线程单独处理
                    // 业务处理失败，可查看日志进行补偿，跟支付宝已经没多大关系。
                    return "success";
                } else {
                    log.info("支付宝回调签名认证失败，signVerified=false, paramsJson:{}", paramsJson);
                    return "failure";
                }
            } catch (AlipayApiException e) {
                log.error("支付宝回调签名认证失败,paramsJson:{},errorMsg:{}", paramsJson, e.getMessage());
                return "failure";
            }
        } catch (Exception e) {
            log.error("支付异步通知失败");
            return "failure";
        }
    }

    @PostMapping(value = "/weixin/pay")
    public void weixinNotify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //返回给微信的处理结果
        String result;
        String inputLine;
        String notityXml = "";
        response.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter writer = response.getWriter();
        //微信给返回的东西
        try {
            while ((inputLine = request.getReader().readLine()) != null) {
                notityXml += inputLine;
            }
            request.getReader().close();
        } catch (Exception e) {
            log.error("解析xml文件失败" + e.getMessage());
            String noticeStr = setXml("fail", "xml获取失败");
            writer.write(noticeStr);
            writer.flush();

        }
        if (StringUtils.isEmpty(notityXml)) {
            log.error("xml获取失败" + notityXml);
            String noticeStr = setXml("fail", "xml为空");
            writer.write(noticeStr);
            writer.flush();
        }

        try {
            result = weixinPay(notityXml);
        } catch (Exception e) {
            log.error("支付异步通知失败");
            throw new MerchantsException(400, "微信异步通知失败" + e.getMessage());
        }
        log.info("微信异步通知成功，返回微信信息" + result);
        writer.write(result);
        writer.flush();

    }


    private String weixinPay(String xmlStr) throws Exception {
        // 4、验证app_id是否为该商户本身。
        Optional<SystemInfoDTO> one = systemInfoService.findOne(1l);
        if (!one.isPresent()) {
            return "failure";
        }
        SystemInfoDTO systemInfoDTO = one.get();
        //签名验证
        if (!WXPayUtil.isSignatureValid(xmlStr, one.get().getMerchantApiKey())) {
            log.info("【微信支付】异步通知, payResponse={}签名验证失败" + xmlStr);
            return setXml("fail", "签名不一致！");
        }
        Map<String, String> map = WXPayUtil.xmlToMap(xmlStr);
        // 解析各种数据
        String appid = (String) map.get("appid");//应用ID
        String attach = (String) map.get("attach");//商家数据包
        String bank_type = (String) map.get("bank_type");//付款银行
        String cash_fee = (String) map.get("cash_fee");//现金支付金额
        String fee_type = (String) map.get("fee_type");//货币种类
        String is_subscribe = (String) map.get("is_subscribe");//是否关注公众账号
        String mch_id = (String) map.get("mch_id");//商户号
        String nonce_str = (String) map.get("nonce_str");//随机字符串
        String openid = (String) map.get("openid");//用户标识
        String out_trade_no = (String) map.get("out_trade_no");// 获取商户订单号
        String result_code = (String) map.get("result_code");// 业务结果
        String return_code = (String) map.get("return_code");// SUCCESS/FAIL
        String sign = (String) map.get("sign");// 获取签名
        String time_end = (String) map.get("time_end");//支付完成时间
        String total_fee = (String) map.get("total_fee");// 获取订单金额
        String trade_type = (String) map.get("trade_type");//交易类型
        String transaction_id = (String) map.get("transaction_id");//微信支付订单号

        SortedMap<String, String> parameters = new TreeMap<String, String>();
        // 数据加密
        parameters.put("appid", appid);//应用ID
        parameters.put("attach", attach);//商家数据包
        parameters.put("bank_type", bank_type);//付款银行
        parameters.put("cash_fee", cash_fee);//现金支付金额
        parameters.put("fee_type", fee_type);//货币种类
        parameters.put("is_subscribe", is_subscribe);//是否关注公众账号
        parameters.put("mch_id", mch_id);//商户号
        parameters.put("nonce_str", nonce_str);//随机字符串
        parameters.put("openid", openid);//用户标识
        parameters.put("out_trade_no", out_trade_no);// 商户订单号
        parameters.put("result_code", result_code);// 业务结果
        parameters.put("return_code", return_code);// SUCCESS/FAIL
        parameters.put("time_end", time_end);// 支付完成时间
        parameters.put("total_fee", total_fee);// 获取订单金额
        parameters.put("trade_type", trade_type);//交易类型
        parameters.put("transaction_id", transaction_id);//微信支付订单号

        PayOrderDTO payOrderDTO = payOrderService.findByOrderSn(out_trade_no);
        if (payOrderDTO == null) {
            throw new AlipayApiException("out_trade_no错误");
        }
        // 2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
        if (!this.equals(Double.valueOf(total_fee), payOrderDTO.getPayAmount().multiply(new BigDecimal(100)).doubleValue())) {
            throw new AlipayApiException("error total_amount");
        }
//        // 4、验证app_id是否为该商户本身。
//        Optional<SystemInfoDTO> one = systemInfoService.findOne(1l);


        if (!appid.equals(systemInfoDTO.getPlatAppId())) {
            throw new AlipayApiException("app_id不一致");
        }
        if (return_code.equals("SUCCESS")) {
            //修改订单的支付状态
            Object object = new Object();
            synchronized (object) {
                try {
                    payOrderDTO.setPayType(2);
                    payOrderDTO.setTransactionId(transaction_id);
                    payOrderService.paid(payOrderDTO);
                    log.info("【微信支付】异步通知成功" + payOrderDTO);
                } catch (Exception e) {
                    log.error("微信支付通知处理成功，订单状态信息修改失败" + ";" + e);
                    return "";
                }
                return setXml("SUCCESS", "OK");
            }

        }
        return "";

    }


    // 将request中的参数转换成Map
    private static Map<String, String> convertRequestParamsToMap(HttpServletRequest request) {
        Map<String, String> retMap = new HashMap<String, String>();

        Set<Map.Entry<String, String[]>> entrySet = request.getParameterMap().entrySet();

        for (Map.Entry<String, String[]> entry : entrySet) {
            String name = entry.getKey();
            String[] values = entry.getValue();
            int valLen = values.length;

            if (valLen == 1) {
                retMap.put(name, values[0]);
            } else if (valLen > 1) {
                StringBuilder sb = new StringBuilder();
                for (String val : values) {
                    sb.append(",").append(val);
                }
                retMap.put(name, sb.toString().substring(1));
            } else {
                retMap.put(name, "");
            }
        }

        return retMap;
    }


    //通过xml 发给微信消息
    public static String setXml(String return_code, String return_msg) {
        SortedMap<String, String> parameters = new TreeMap<String, String>();
        parameters.put("return_code", return_code);
        parameters.put("return_msg", return_msg);
        return "<xml><return_code><![CDATA[" + return_code + "]]>" +
            "</return_code><return_msg><![CDATA[" + return_msg + "]]></return_msg></xml>";
    }

//    private AlipayNotifyParam buildAlipayNotifyParam(Map<String, String> params) {
//        String json = JSON.toJSONString(params);
//        return JSON.parseObject(json, AlipayNotifyParam.class);
//    }

    /**
     * 1、商户需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
     * 2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
     * 3、校验通知中的seller_id（或者seller_email)是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email），
     * 4、验证app_id是否为该商户本身。上述1、2、3、4有任何一个验证不通过，则表明本次通知是异常通知，务必忽略。
     * 在上述验证通过后商户必须根据支付宝不同类型的业务通知，正确的进行不同的业务处理，并且过滤重复的通知结果数据。
     * 在支付宝的业务通知中，只有交易通知状态为TRADE_SUCCESS或TRADE_FINISHED时，支付宝才会认定为买家付款成功。
     *
     * @param params
     * @throws AlipayApiException
     */
    private void check(Map<String, String> params, SystemInfoDTO systemInfoDTO) throws AlipayApiException {
        String outTradeNo = params.get("out_trade_no");

        // 1、商户需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
        PayOrderDTO order = payOrderService.findByOrderSn(outTradeNo); // 这个方法自己实现
        if (order == null) {
            throw new AlipayApiException("out_trade_no错误");
        }

        // 2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
        if (!this.equals(Double.valueOf(params.get("total_amount")), order.getPayAmount().doubleValue())) {
            throw new AlipayApiException("error total_amount");
        }

        // 3、校验通知中的seller_id（或者seller_email)是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email），
        // 第三步可根据实际情况省略

        // 4、验证app_id是否为该商户本身。
        if (!params.get("app_id").equals(systemInfoDTO.getAliAppId())) {
            throw new AlipayApiException("app_id不一致");
        }
    }

    /**
     * 比较2个金额是否相等
     *
     * @param d1
     * @param d2
     * @return
     */
    public static Boolean equals(Double d1, Double d2) {
        Double result = Math.abs(d1 - d2);
        if (result < MONEY_RANGE) {
            return true;
        } else {
            return false;
        }
    }
}
