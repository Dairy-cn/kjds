package com.cross.merchants.web.rest;

import com.alipay.api.AlipayApiException;
import com.cross.merchants.service.TranscationService;
import com.cross.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*************************************************************
 * Description:
 * Author: Dair
 * CreateTime: 2020/5/25
 ************************************************************/
@RestController
@RequestMapping("/api")
@Api(tags = "用户支付相关接口")
public class TransactionResource {

    private final Logger log = LoggerFactory.getLogger(TransactionResource.class);

    @Autowired
    private TranscationService transcationService;

    @Autowired
    private FastDfsResource fastDfsResource;

    @GetMapping("/pay/qrcode/{orderId}")
    @ApiOperation("根据订单id和支付方式生成支付二维码")
    public R qrcodePay(@ApiParam("订单id") @PathVariable Long orderId,
                       @ApiParam("支付方式 1 支付宝 2 微信") @RequestParam Integer payType, HttpServletRequest request) throws Exception {

        if (payType == null) {
            return R.error("支付方式不能为空");
        }
        String payUrl = "";
        if (payType == 1) {
            payUrl = transcationService.aliQrcodePay(orderId);
        } else if (payType == 2) {
            payUrl = transcationService.weixinQrcodePay(orderId, request);
        }
        if (!StringUtils.isEmpty(payUrl)) {
            R r = fastDfsResource.generateQrCode(1, payUrl, request);
            if (r.isFlag()) {
                String data = (String) r.getData();
                return R.ok(data);
            } else {
                return r;
            }
        }
        return R.error("创建支付二维码失败");
    }
}
