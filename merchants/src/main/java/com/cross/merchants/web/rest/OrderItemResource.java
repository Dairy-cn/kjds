package com.cross.merchants.web.rest;

import com.cross.merchants.service.OrderItemService;
import com.cross.merchants.service.ShippingListService;
import com.cross.merchants.service.dto.ShippingListDTO;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;
import com.cross.merchants.service.dto.OrderItemDTO;

import com.cross.utils.CommonUtil;
import com.cross.utils.R;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.cross.merchants.domain.OrderItem}.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "子订单相关接口")
public class OrderItemResource {

    private final Logger log = LoggerFactory.getLogger(OrderItemResource.class);

    private static final String ENTITY_NAME = "merchantsOrderItem";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final OrderItemService orderItemService;

    @Autowired
    private ShippingListService shippingListService;

    public OrderItemResource(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    /**
     * {@code POST  /order-items} : Create a new orderItem.
     *
     * @param orderItemDTO the orderItemDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new orderItemDTO, or with status {@code 400 (Bad Request)} if the orderItem has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
//    @PostMapping("/order-items")
    public ResponseEntity<OrderItemDTO> createOrderItem(@RequestBody OrderItemDTO orderItemDTO) throws URISyntaxException {
        log.debug("REST request to save OrderItem : {}", orderItemDTO);
        if (orderItemDTO.getId() != null) {
            throw new BadRequestAlertException("A new orderItem cannot already have an ID", ENTITY_NAME, "idexists");
        }
        OrderItemDTO result = orderItemService.save(orderItemDTO);
        return ResponseEntity.created(new URI("/api/order-items/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /order-items} : Updates an existing orderItem.
     *
     * @param orderItemDTO the orderItemDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated orderItemDTO,
     * or with status {@code 400 (Bad Request)} if the orderItemDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the orderItemDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
//    @PutMapping("/order-items")
    public ResponseEntity<OrderItemDTO> updateOrderItem(@RequestBody OrderItemDTO orderItemDTO) throws URISyntaxException {
        log.debug("REST request to update OrderItem : {}", orderItemDTO);
        if (orderItemDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        OrderItemDTO result = orderItemService.save(orderItemDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, orderItemDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /order-items} : get all the orderItems.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of orderItems in body.
     */
//    @GetMapping("/order-items")
    public ResponseEntity<List<OrderItemDTO>> getAllOrderItems(Pageable pageable) {
        log.debug("REST request to get a page of OrderItems");
        Page<OrderItemDTO> page = orderItemService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /order-items/:id} : get the "id" orderItem.
     *
     * @param id the id of the orderItemDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the orderItemDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/order-items/{id}")
    @ApiOperation("根据分订单Id获取详情")
    public R<OrderItemDTO> getOrderItem(@PathVariable Long id) {
        log.debug("REST request to get OrderItem : {}", id);
        Optional<OrderItemDTO> orderItemDTO = orderItemService.findOne(id);
        if (!orderItemDTO.isPresent()) {
            return R.error("订单找不到");
        }
        if (!orderItemDTO.get().getMemberId().equals(CommonUtil.getCurrentLoginUser().getMasterId())) {
            return R.error("你无权操作");
        }
        return R.ok(orderItemDTO.get());
    }

    /**
     * {@code DELETE  /order-items/:id} : delete the "id" orderItem.
     *
     * @param id the id of the orderItemDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
//    @DeleteMapping("/order-items/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        log.debug("REST request to delete OrderItem : {}", id);
        orderItemService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }


    @GetMapping("/order-items-condition-platform")
    @ApiOperation("大后台---订单管理---全部订单/发货订单")
    public R<List<OrderItemDTO>> getAllOrderItemsByPlatform(Pageable pageable,
                                                            @ApiParam(" 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单") @RequestParam(required = false) Integer orderStatus,
                                                            @ApiParam("商户") @RequestParam(required = false) Long storeId,
                                                            @ApiParam("下单开始时间 eg 2017-11-27T03:16:03Z") @RequestParam(required = false) Instant startTime,
                                                            @ApiParam("下单结束时间 eg 2017-11-27T03:16:03Z ") @RequestParam(required = false) Instant endTime,
                                                            @ApiParam("订单关键字查询") @RequestParam(required = false) String keyWord,
                                                            @ApiParam("发货状态 0 未发货 1 已发货") @RequestParam(required = false) Integer deliveryState
    ) {
        log.debug("REST request to get a page of OrderItems");
        Page<OrderItemDTO> page = orderItemService.findAllCondition(pageable, orderStatus, storeId, startTime, endTime, keyWord, deliveryState, null);
        return R.ok(page.getContent(), page.getTotalElements());
    }

    @GetMapping("/order-items-condition-merchant")
    @ApiOperation("商户订单---订单管理---订单查询/发货订单")
    public R<List<OrderItemDTO>> getAllOrderItemsByMerchant(Pageable pageable,
                                                            @ApiParam(" 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单") @RequestParam(required = false) Integer orderStatus,
                                                            @ApiParam(value = "商户", required = true) @RequestParam(required = true) Long storeId,
                                                            @ApiParam("下单开始时间 eg 2017-11-27T03:16:03Z") @RequestParam(required = false) Instant startTime,
                                                            @ApiParam("下单结束时间 eg 2017-11-27T03:16:03Z ") @RequestParam(required = false) Instant endTime,
                                                            @ApiParam("订单关键字查询") @RequestParam(required = false) String keyWord,
                                                            @ApiParam("产品名称") @RequestParam(required = false) String goodsName,
                                                            @ApiParam("发货状态 0 未发货 1 已发货") @RequestParam(required = false) Integer deliveryState
    ) {
        log.debug("REST request to get a page of OrderItems");
        Page<OrderItemDTO> page = orderItemService.findAllCondition(pageable, orderStatus, storeId, startTime, endTime, keyWord, deliveryState, goodsName);
        return R.ok(page.getContent(), page.getTotalElements());
    }

    @GetMapping("/order-items-delivery-state/{orderId}")
    @ApiOperation("商户订单---发货订单--发货")
    public R updateOrderItem(@PathVariable Long orderId,
                             @RequestParam Long shippingId,
                             @RequestParam String deliverySn) throws URISyntaxException {
        Optional<OrderItemDTO> one = orderItemService.findOne(orderId);
        if (!one.isPresent()) {
            return R.error("订单不存在");
        }
        OrderItemDTO orderItemDTO = one.get();
        if (orderItemDTO.getStatus() == 0) {
            return R.error("订单未支付");
        }
        if (orderItemDTO.getStatus() != 1) {
            return R.error("订单状态不对");
        }
        Optional<ShippingListDTO> shippingListDTO = shippingListService.findOne(shippingId);
        if (!shippingListDTO.isPresent()) {
            return R.error("快递公司信息不存在");
        }
        ShippingListDTO dto = shippingListDTO.get();
        orderItemDTO.setStatus(2);
        orderItemDTO.setDeliveryCode(dto.getCode());
        orderItemDTO.setDeliveryCompany(dto.getName());
        orderItemDTO.setDeliverySn(deliverySn);
        orderItemDTO.setDeliveryTime(Instant.now());
        orderItemDTO.setDeliveryState(1);
        OrderItemDTO result = orderItemService.save(orderItemDTO);
        return R.ok(result);
    }

    @ApiOperation("用户确认收货")
    @RequestMapping(value = "/confirmReceiveOrder", method = RequestMethod.POST)
    @ResponseBody
    public R confirmReceiveOrder(Long orderId) {
        orderItemService.confirmReceiveOrder(orderId);
        return R.ok(null);
    }

    @GetMapping("/my-order")
    @ApiOperation("c端---我的订单")
    @ResponseBody
    public R<List<OrderItemDTO>> getMyOrder(Pageable pageable,
                                            @ApiParam(" 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单") @RequestParam(required = false) Integer orderStatus,
//                                                            @ApiParam(value = "商户",required = true) @RequestParam(required = true) Long storeId,
//                                                            @ApiParam("下单开始时间 eg 2017-11-27T03:16:03Z") @RequestParam(required = false) Instant startTime,
//                                                            @ApiParam("下单结束时间 eg 2017-11-27T03:16:03Z ") @RequestParam(required = false) Instant endTime,
                                            @ApiParam("订单关键字查询") @RequestParam(required = false) String keyWord,
                                            @ApiParam("发货状态 0 未发货 1 已发货") @RequestParam(required = false) Integer deliveryState
    ) {
        log.debug("REST request to get a page of OrderItems");
        Long id = CommonUtil.getCurrentLoginUser().getId();
        Page<OrderItemDTO> page = orderItemService.getMyOrder(pageable, orderStatus, id, null, null, keyWord, deliveryState);
        return R.ok(page.getContent(), page.getTotalElements());
    }


    @ApiOperation("用户删除订单")
    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    @ResponseBody
    public R deleteOrder(Long orderId) {
        orderItemService.deleteOrder(orderId);
        return R.ok(null);
    }
}
