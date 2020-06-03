package com.cross.merchants.service;

import com.alipay.api.AlipayApiException;

import javax.servlet.http.HttpServletRequest;

/*************************************************************
 * Description:
 * Author: Dair
 * CreateTime: 2020/5/25
 ************************************************************/
public interface TranscationService {

    String weixinQrcodePay(Long orderId, HttpServletRequest request) throws Exception;

    String aliQrcodePay(Long orderId) throws AlipayApiException;


    String aliPay(String orderId);

    String weixinPay(String orderId,String transactionId);
}
