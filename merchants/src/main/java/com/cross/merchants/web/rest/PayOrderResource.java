package com.cross.merchants.web.rest;

import com.cross.merchants.service.PayOrderService;
import com.cross.merchants.web.rest.DTO.ConfirmOrderResult;
import com.cross.merchants.web.rest.DTO.OrderDetail;
import com.cross.merchants.web.rest.DTO.OrderParam;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;
import com.cross.merchants.service.dto.PayOrderDTO;

import com.cross.utils.R;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * REST controller for managing {@link com.cross.merchants.domain.PayOrder}.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "订单管理")
public class PayOrderResource {

    private final Logger log = LoggerFactory.getLogger(PayOrderResource.class);

    private static final String ENTITY_NAME = "merchantsPayOrder";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PayOrderService payOrderService;

    public PayOrderResource(PayOrderService payOrderService) {
        this.payOrderService = payOrderService;
    }

    /**
     * {@code POST  /pay-orders} : Create a new payOrder.
     *
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new payOrderDTO, or with status {@code 400 (Bad Request)} if the payOrder has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @ApiOperation("根据购物车信息生成确认单信息")
    @RequestMapping(value = "/generateConfirmOrder", method = RequestMethod.POST)
    @ResponseBody
    public R<ConfirmOrderResult> generateConfirmOrder(@RequestBody List<String> cartIds) {
        ConfirmOrderResult confirmOrderResult = payOrderService.generateConfirmOrder(cartIds);
        return R.ok(confirmOrderResult);
    }

    @ApiOperation("根据购物车信息生成订单 支付订单order 分订单orderItemList")
    @RequestMapping(value = "/generateOrder", method = RequestMethod.POST)
    @ResponseBody
    public R generateOrder(@RequestBody OrderParam orderParam) {
        Map<String, Object> result = payOrderService.generateOrder(orderParam);
        return R.ok(result);
    }

    @ApiOperation("用户支付成功的回调(测试)")
//    @RequestMapping(value = "/paySuccess", method = RequestMethod.POST)
    @ResponseBody
    @Deprecated
    public R paySuccess(@RequestParam Long orderId, @RequestParam Integer payType) {
        Optional<PayOrderDTO> one = payOrderService.findOne(orderId);
        PayOrderDTO payOrderDTO = one.get();
        payOrderDTO.setPayType(payType);
        Integer count = payOrderService.paySuccess(payOrderDTO);
        return R.ok("支付成功");
    }

    @ApiOperation("自动取消超时订单")
    @RequestMapping(value = "/cancelTimeOutOrder", method = RequestMethod.POST)
    @ResponseBody
    public R cancelTimeOutOrder() {
        payOrderService.cancelTimeOutOrder();
        return R.ok(null);
    }

    @ApiOperation("取消单个超时订单")
    @RequestMapping(value = "/cancelOrder", method = RequestMethod.POST)
    @ResponseBody
    public R cancelOrder(Long orderId) {
        payOrderService.sendDelayMessageCancelOrder(orderId);
        return R.ok(null);
    }

    @ApiOperation("按状态分页获取用户订单列表")
    @ApiImplicitParam(name = "status", value = "订单状态：-1->全部；0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭",
        defaultValue = "-1", allowableValues = "-1,0,1,2,3,4", paramType = "query", dataType = "int")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public R<List<OrderDetail>> list(@RequestParam Integer status, @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                  @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<OrderDetail> orderPage = payOrderService.list(status, pageNum, pageSize);
        return R.ok(orderPage.getContent(),orderPage.getTotalElements());
    }

    @ApiOperation("根据ID获取订单详情")
    @RequestMapping(value = "/detail/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public R<OrderDetail> detail(@PathVariable Long orderId) {
        OrderDetail orderDetail = payOrderService.detail(orderId);
        return R.ok(orderDetail);
    }

    @ApiOperation("用户取消订单")
    @RequestMapping(value = "/cancelUserOrder", method = RequestMethod.POST)
    @ResponseBody
    public R cancelUserOrder(Long orderId) {
        payOrderService.cancelOrder(orderId);
        return R.ok(null);
    }



    @ApiOperation("用户删除订单")
    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    @ResponseBody
    public R deleteOrder(Long orderId) {
        payOrderService.deleteOrder(orderId);
        return R.ok(null);
    }
}
