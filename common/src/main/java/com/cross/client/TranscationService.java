package com.cross.client;

import com.cross.config.AuthorizedFeignClient;
import com.cross.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by DuYuLiang on 2017/7/3.
 */
@AuthorizedFeignClient(name = "transcation")
public interface TranscationService {
    /**
     * 根据交易号获取单笔交易
     *
     * @param tradeNo
     * @return
     */
    @GetMapping("api/transcationsByTradeNo/{tradeNo}")
    TranscationModel getTranscationByTradeNo(@PathVariable("tradeNo") String tradeNo);

    /**
     * 根据交易号和交易状态获取单笔交易
     *
     * @param tradeNo
     * @param state
     * @return
     */
    @GetMapping("api/transcationsByTradeNo/{tradeNo}/{state}")
    List<TranscationModel> getTranscationByOrderSn(@PathVariable("tradeNo") String tradeNo,
                                                   @PathVariable("state") Integer state);

    /**
     * 根据交易号获取单笔交易
     *
     * @param tradeNo
     * @return
     */
    @GetMapping("api/transactionsByOuterTradeNo/{tradeNo}")
    List<TranscationModel> getTransactionByOuterOrderSn(@PathVariable("tradeNo") String tradeNo);

    /**
     * 创建预支付单
     *
     * @param transcationVM
     * @return
     */
    @PostMapping("api/transcations")
    TranscationModel createTranscation(@RequestBody TranscationModel transcationVM);

    /**
     * 更新预支付单
     *
     * @param transcationVM
     * @return
     */
    @PutMapping("api/transcations")
    TranscationModel saveTranscation(@RequestBody TranscationModel transcationVM);

    /**
     * 获取用户收款账户
     *
     * @param receiveAccountId
     * @return
     */
    @GetMapping("api/user-receive-accounts/{receiveAccountId}")
    UserReceiveAccountModel getUserReceiveAccountByReceiveAccountId(@PathVariable("receiveAccountId") Long receiveAccountId);

    /**
     * 改变预支付单状态
     *
     * @param trancationId
     * @param payType
     * @param timestamp
     * @param sign
     * @return
     */
    @GetMapping("api/changePayState/{trancationId}/{payType}/{timestamp}/{sign}")
    TranscationModel changeTranscationState(
            @PathVariable("trancationId") Long trancationId,
            @PathVariable("payType") String payType,
            @PathVariable("timestamp") Integer timestamp,
            @PathVariable("sign") String sign);

    /**
     * 异步支付通知
     *
     * @param payNotifyModel
     * @return
     */
    @PostMapping("api/pay-notifies")
    PayNotifyModel addPayNotifyModel(@RequestBody PayNotifyModel payNotifyModel);

    /**
     * 发送验证码
     *
     * @param mobile
     * @return
     */
    @GetMapping("api/sendValidationCode/{mobile}")
    String sendValidationCode(@PathVariable("mobile") String mobile);

    /**
     * 根据交易单号获取退款单
     *
     * @param tradeNo
     * @return
     */
    @GetMapping("api/refunds-by-trade-no/{tradeNo}")
    RefundModel getRefundByTradeNo(@PathVariable("tradeNo") String tradeNo);

    /**
     * 创建退款单
     *
     * @param refundModel
     * @return
     */
    @PostMapping("api/refunds")
    RefundModel createRefund(@RequestBody RefundModel refundModel);

    /**
     * 通过交易号查找支付平台生成的交易号
     * @param transNo
     * @return
     */
    @GetMapping("api/find-trade-id/{transNo}")
    String findPayTradeIdByTransNo(@PathVariable("transNo") String transNo);

    @PostMapping("api/check-tcdpay-setting-info/{platformId}")
    UserReceiveAccount checkTcdPaySettingInfo(@PathVariable("platformId") Long platformId,
                                              @RequestParam("type") Integer type);

    @PostMapping("api/mdmpay-order")
    Boolean mdmPayOrder(@RequestBody MdmPayDTO mdmPayDTO,
                        @RequestParam("platformId") Long platformId,
                        @RequestParam("weappuserId") Long weappuserId,
                        @RequestParam("orderSource") Integer orderSource);
}
