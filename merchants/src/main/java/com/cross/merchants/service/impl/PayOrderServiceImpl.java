package com.cross.merchants.service.impl;

import com.cross.merchants.domain.*;
import com.cross.merchants.exception.MerchantsException;
import com.cross.merchants.redis.RedisService;
import com.cross.merchants.repository.GoodsRepository;
import com.cross.merchants.repository.GoodsSkuRepository;
import com.cross.merchants.repository.OrderItemRepository;
import com.cross.merchants.service.CartItemService;
import com.cross.merchants.service.PayOrderService;
import com.cross.merchants.repository.PayOrderRepository;
import com.cross.merchants.service.StoreInfoService;
import com.cross.merchants.service.UserAddressService;
import com.cross.merchants.service.dto.*;
import com.cross.merchants.service.mapper.GoodsMapper;
import com.cross.merchants.service.mapper.GoodsSkuMapper;
import com.cross.merchants.service.mapper.OrderItemMapper;
import com.cross.merchants.service.mapper.PayOrderMapper;
import com.cross.merchants.web.rest.DTO.*;
import com.cross.DTO.UserOrderCountAndAmountDTO;
import com.cross.merchants.web.rest.vm.UserOrderCountAndAmountVM;
import com.cross.model.LoginUserModel;
import com.cross.utils.CommonUtil;
import com.cross.utils.JpaSelectCastEntity;
import com.cross.utils.JsonUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link PayOrder}.
 */
@Service
@Transactional
public class PayOrderServiceImpl implements PayOrderService {

    private final Logger log = LoggerFactory.getLogger(PayOrderServiceImpl.class);

    private final PayOrderRepository payOrderRepository;

    private final PayOrderMapper payOrderMapper;

    @Value("${redis.key.orderId}")
    private String REDIS_KEY_ORDER_ID;
    @Value("${redis.database}")
    private String REDIS_DATABASE;

    @Value("${redis.key.subOrderId}")
    private String REDIS_KEY_SUB_ORDER_ID;

    private final UserAddressService userAddressService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private GoodsSkuRepository goodsSkuRepository;


    @Autowired
    private GoodsRepository goodsRepository;


    @Autowired
    private RedisService redisService;


    @Autowired
    private OrderItemRepository orderItemRepository;


    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private StoreInfoService storeInfoService;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsSkuMapper goodsSkuMapper;


    public PayOrderServiceImpl(PayOrderRepository payOrderRepository, PayOrderMapper payOrderMapper, UserAddressService userAddressService) {
        this.payOrderRepository = payOrderRepository;
        this.payOrderMapper = payOrderMapper;
        this.userAddressService = userAddressService;
    }

    /**
     * Save a payOrder.
     *
     * @param payOrderDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public PayOrderDTO save(PayOrderDTO payOrderDTO) {
        log.debug("Request to save PayOrder : {}", payOrderDTO);
        PayOrder payOrder = payOrderMapper.toEntity(payOrderDTO);
        payOrder = payOrderRepository.save(payOrder);
        return payOrderMapper.toDto(payOrder);
    }

    /**
     * Get all the payOrders.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<PayOrderDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PayOrders");
        return payOrderRepository.findAll(pageable)
            .map(payOrderMapper::toDto);
    }

    /**
     * Get one payOrder by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<PayOrderDTO> findOne(Long id) {
        log.debug("Request to get PayOrder : {}", id);
        return payOrderRepository.findById(id)
            .map(payOrderMapper::toDto);
    }

    /**
     * Delete the payOrder by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete PayOrder : {}", id);
        payOrderRepository.deleteById(id);
    }


    @Override
    public ConfirmOrderResult generateConfirmOrder(List<String> cartIds) {
        ConfirmOrderResult result = new ConfirmOrderResult();
        //?????????????????????
        LoginUserModel currentLoginUser = CommonUtil.getCurrentLoginUser();
        if (currentLoginUser == null) {
            return null;
        }
        //??????????????????????????????
        List<UserAddressDTO> userAddressDTOS = userAddressService.findAllByUserId(currentLoginUser.getId());
        result.setUserAddressDTOS(userAddressDTOS);
        List<CartItemDTO> cartItemDTOS = cartItemService.listPromotion(currentLoginUser.getId(), cartIds);
        List<Long> goodsIds = cartItemDTOS.stream().map(CartItemDTO::getProductId).collect(Collectors.toList());
        List<Long> goodsSkuIds = cartItemDTOS.stream().map(CartItemDTO::getProductSkuId).collect(Collectors.toList());

        List<GoodsDTO> goodsList = goodsMapper.toDto(goodsRepository.findAllByIdIn(goodsIds));
        List<GoodsSkuDTO> goodsSkuList = goodsSkuMapper.toDto(goodsSkuRepository.findAllByGoodsIdInAndDeleteFlag(goodsIds, false));
        List<Long> storeIds = goodsList.stream().map(GoodsDTO::getStoreId).distinct().collect(Collectors.toList());
        List<StoreInfoDTO> storeList = storeInfoService.findAllByIdIn(storeIds);
        List<StoreOrderResult> orderResults = new ArrayList<>();
        storeList.stream().forEach(e -> {
            StoreOrderResult storeOrderResult = new StoreOrderResult();
            storeOrderResult.setId(e.getId());
            storeOrderResult.setStoreName(e.getStoreName());
            orderResults.add(storeOrderResult);

        });
        Map<Long, List<GoodsDTO>> storeMap = goodsList.stream().collect(Collectors.groupingBy(GoodsDTO::getStoreId));
//        Map<Long, List<GoodsSkuDTO>> gookdsSkuMap = goodsSkuList.stream().collect(Collectors.groupingBy(GoodsSkuDTO::getGoodsId));
        Map<Long, GoodsSkuDTO> gookdsSkuMap = goodsSkuList.stream().collect(Collectors.toMap(GoodsSkuDTO::getId, e -> e));

        Map<Long, List<CartItemDTO>> cartMap = cartItemDTOS.stream().collect(Collectors.groupingBy(CartItemDTO::getProductId));
        orderResults.stream().forEach(e -> {
            List<GoodsDTO> goods = storeMap.get(e.getId());
            BigDecimal maxFreight = goods.stream().filter(e1 -> e1.getFreight() != null).map(GoodsDTO::getFreight).max((e1, e2) -> e1.compareTo(e2)).get();
            if (maxFreight == null) {
                maxFreight = BigDecimal.ZERO;
            }
            e.setTaxesFees(BigDecimal.ZERO);
            e.setTotalAmount(BigDecimal.ZERO);
            goods.stream().forEach(goods1 -> {
                List<CartItemDTO> cartItemDTOList = cartMap.get(goods1.getId());
                cartItemDTOList.stream().forEach(e2 -> {
                    GoodsSkuDTO goodsSkuDTO = gookdsSkuMap.get(e2.getProductSkuId());
                    e2.setGoodsSkuDTO(goodsSkuDTO);
                    if (goodsSkuDTO.getTaxexAndDues() != null) {
                        e.setTaxesFees(e.getTaxesFees().add(goodsSkuDTO.getTaxexAndDues()));
                        BigDecimal salePrice = goodsSkuDTO.getSalePrice().multiply(new BigDecimal(e2.getQuantity()));
                        e.setTotalAmount(e.getTotalAmount().add(salePrice));
                    }
                });
                goods1.setCartItemDTOS(cartItemDTOList);
            });
            e.setFreight(maxFreight);
            e.setGoodsDTOList(goods);
        });
        ConfirmOrderResult.CalcAmount calcAmount = calcCartAmount(cartItemDTOS);
        BigDecimal taxesFee = orderResults.stream().filter(e -> e.getTaxesFees() != null).map(StoreOrderResult::getTaxesFees).reduce(BigDecimal.ZERO, BigDecimal::add);
        calcAmount.setTaxesFees(taxesFee == null ? BigDecimal.ZERO : taxesFee);
        result.setCalcAmount(calcAmount);
        result.setOrderResults(orderResults);

        return result;
    }

    @Override
    public Map<String, Object> generateOrder(OrderParam orderParam) {
        List<OrderItem> orderItemList = new ArrayList<>();
        //??????????????????????????????

        LoginUserModel currentLoginUser = CommonUtil.getCurrentLoginUser();
        List<CartItemDTO> cartPromotionItemList = cartItemService.listPromotion(currentLoginUser.getId(), orderParam.getCartIds());
        if (CollectionUtils.isEmpty(cartPromotionItemList)) {
            throw new MerchantsException(400, "?????????????????????");
        }
        ConfirmOrderResult orderResult = this.generateConfirmOrder(orderParam.getCartIds());

        List<StoreOrderResult> orderResults = orderResult.getOrderResults();
        Map<Long, StoreNoteDTO> storeNoteDTOMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(orderParam.getStoreNoteDTOS())) {
            storeNoteDTOMap = orderParam.getStoreNoteDTOS().stream().collect(Collectors.toMap(StoreNoteDTO::getStoreId, e -> e));
        }
        if (CollectionUtils.isEmpty(orderResults)) {
            throw new MerchantsException(400, "?????????????????????");
        }
        for (StoreOrderResult result : orderResults) {
            List<GoodsDTO> goodsDTOList = new ArrayList<>();
            if(!CollectionUtils.isEmpty(result.getGoodsDTOList())){
                result.getGoodsDTOList().stream().forEach(e->{
                    List<CartItemDTO> cartItemDTOS = e.getCartItemDTOS();
                    cartItemDTOS.stream().forEach(cartItemDTO -> {
                        GoodsDTO goodsDTO=e;
                        List<CartItemDTO> list=new ArrayList<>();
                        list.add(cartItemDTO);
                        goodsDTO.setCartItemDTOS(list);
                        goodsDTOList.add(goodsDTO);
                    });
                });
            }
            //????????????????????????
            OrderItem orderItem = new OrderItem();
            orderItem.setProductStoreId(result.getId());
            orderItem.setStoreName(result.getStoreName());
            orderItem.setCreateTime(Instant.now());
            orderItem.setProductInfo(JsonUtil.objectToJson(goodsDTOList));
            StoreNoteDTO storeNoteDTO = storeNoteDTOMap.get(result.getId());
            if (storeNoteDTO != null) {
                orderItem.setNote(storeNoteDTO.getNote());
            }
            orderItem.setMemberId(currentLoginUser.getId());
            orderItem.setMemberUsername(currentLoginUser.getUser_name());
            orderItem.setMemberName(currentLoginUser.getUser_name());
            orderItem.setMemberPhone(currentLoginUser.getUser_name());
            orderItem.setFreightAmount(result.getFreight());
            orderItem.setTotalAmount(result.getTotalAmount());
            orderItem.setTaxesFees(result.getTaxesFees());
            orderItem.setPromotionAmount(BigDecimal.ZERO);
            orderItem.setConfirmStatus(0);
            orderItem.setStatus(0);
            orderItem.setDeleteStatus(0);
            orderItem.setDeliveryState(0);
            orderItem.setPayAmount(result.getTotalAmount().add(result.getTaxesFees()));
            orderItemList.add(orderItem);
        }
        //DOTO ??????redis???
        synchronized (PayOrderServiceImpl.class) {
            //??????????????????????????????????????????
            if (!hasStock(cartPromotionItemList)) {
                throw new MerchantsException(400, "????????????,????????????");
            }
            //??????order_item???????????????
//            handleRealAmount(orderItemList);
            //??????????????????
            lockStock(cartPromotionItemList);
        }
        //?????????????????????????????????????????????????????????????????????????????????
        PayOrder order = new PayOrder();
        order.setTotalAmount(calcTotalAmount(orderItemList));
        order.setFreightAmount(orderResult.getCalcAmount().getFreightAmount());
        order.setPromotionAmount(orderResult.getCalcAmount().getPromotionAmount());
        order.setTaxesFeesAmount(orderResult.getCalcAmount().getTaxesFees());
        order.setPayAmount(calcPayAmount(order));
        //???????????????????????????????????????
        order.setMemberId(currentLoginUser.getId());
        order.setCreateTime(Instant.now());
        order.setMemberUsername(currentLoginUser.getUser_name());
        //???????????????0->????????????1->????????????2->??????
        order.setPayType(orderParam.getPayType());
        //???????????????0->PC?????????1->app??????
        order.setSourceType(1);
        //???????????????0->????????????1->????????????2->????????????3->????????????4->????????????5->????????????
        order.setStatus(0);

        //???????????????????????????????????????????????????
        Optional<UserAddressDTO> userAddressDTO = userAddressService.findOne(orderParam.getMemberReceiveAddressId());
        if (!userAddressDTO.isPresent()) {
            throw new MerchantsException(400, "?????????????????????");
        }
        UserAddressDTO address = userAddressDTO.get();
        order.setReceiverName(address.getUserName());
        order.setReceiverPhone(address.getPhone());
        order.setReceiverProvince(address.getProvince());
        order.setReceiverCity(address.getCity());
        order.setReceiverRegion(address.getCounty());
        order.setReceiverDetailAddress(address.getAddress());
        //0->????????????1->?????????
        order.setConfirmStatus(0);
        order.setDeleteStatus(0);

        //???????????????
        order.setOrderSn(generateOrderSn(order));
        //????????????????????????
        order.setAutoConfirmDay(30);
        //??????order??????order_item???
        payOrderRepository.save(order);
        for (OrderItem orderItem : orderItemList) {
            orderItem.setPayOrderId(order.getId());
            orderItem.setOrderSn(order.getOrderSn());

            orderItem.setReceiverName(address.getUserName());
            orderItem.setReceiverPhone(address.getPhone());
            orderItem.setReceiverProvince(address.getProvince());
            orderItem.setReceiverCity(address.getCity());
            orderItem.setReceiverRegion(address.getCounty());
            orderItem.setReceiverDetailAddress(address.getAddress());

        }
        orderItemList = orderItemRepository.saveAll(orderItemList);

        //?????????????????????????????????
        deleteCartItemList(cartPromotionItemList, currentLoginUser.getId());
        //??????????????????????????????
//        sendDelayMessageCancelOrder(order.getId());
        Map<String, Object> result = new HashMap<>();
        result.put("order", order);
        result.put("orderItemList", orderItemList);
        return result;
    }

    @Override
    public Integer paySuccess(PayOrderDTO orderDTO) {
        //????????????????????????


        orderDTO.setStatus(1);
        orderDTO.setPaymentTime(Instant.now());
        PayOrder payOrder = payOrderRepository.save(payOrderMapper.toEntity(orderDTO));
        //????????????????????????????????????????????????????????????
        List<OrderItem> orderItemList = orderItemRepository.findAllByPayOrderId(payOrder.getId());
        if (!CollectionUtils.isEmpty(orderItemList)) {
            orderItemList.stream().forEach(e -> {
                String productInfo = e.getProductInfo();
                StringBuilder stringBuilder = new StringBuilder();
                if (!StringUtils.isBlank(productInfo)) {
                    List<GoodsDTO> goodsDTOS = CommonUtil.jsonStringConvertToList(productInfo, GoodsDTO[].class);
                    if (!CollectionUtils.isEmpty(goodsDTOS)) {

                        goodsDTOS.stream().forEach(goodsDTO -> {

                            List<CartItemDTO> cartItemDTOS = goodsDTO.getCartItemDTOS();
                            if (!CollectionUtils.isEmpty(cartItemDTOS)) {
                                cartItemDTOS.stream().forEach(cartItemDTO -> {
                                    int count = goodsSkuRepository.updateSkuStock(cartItemDTO.getProductSkuId(), cartItemDTO.getQuantity());
                                });
                                BigInteger totalSaleVolume = cartItemDTOS.stream().map(CartItemDTO::getQuantity).map(BigInteger::valueOf).reduce(BigInteger.ZERO, BigInteger::add);
                                goodsRepository.updateGoodsSaleVolume(payOrder.getId(), totalSaleVolume);
                            }
                            stringBuilder.append(goodsDTO.getGoodsName()).append(",");
                        });
                    }
                }
                e.setGoodsName(stringBuilder.substring(0, stringBuilder.lastIndexOf(",")));
                e.setPayOrderPaymentCode(payOrder.getTransactionId());
                e.setPayType(orderDTO.getPayType());
                e.setPaymentTime(Instant.now());
                e.setStatus(1);
            });
            orderItemRepository.saveAll(orderItemList);
        }
        return orderItemList.size();
    }

    @Override
    @Transactional
    public Integer cancelTimeOutOrder() {
        Integer count = 0;
        //????????????????????????????????????????????????
        Instant instant = ZonedDateTime.ofInstant(Instant.now(), TimeZone.getDefault().toZoneId()).plusHours(-2).toInstant();
        log.info("Instant.now().plusMillis(TimeUnit.HOURS.toHours(-2)" + instant);
        List<PayOrder> payOrders = payOrderRepository.findAllByStatusAndCreateTimeLessThan(0, instant);
        if (CollectionUtils.isEmpty(payOrders)) {
            return count;
        }
        //?????????????????????????????????
        List<Long> ids = new ArrayList<>();
        for (PayOrder timeOutOrder : payOrders) {
            timeOutOrder.setStatus(4);
        }
        payOrderRepository.saveAll(payOrders);
        for (PayOrder timeOutOrder : payOrders) {
            //??????????????????????????????
            List<OrderItem> orderItems = orderItemRepository.findAllByPayOrderId(timeOutOrder.getId());
            if (!CollectionUtils.isEmpty(orderItems)) {
                for (OrderItem orderItem : orderItems) {


                    String productInfo = orderItem.getProductInfo();
                    if (!StringUtils.isBlank(productInfo)) {
                        List<GoodsDTO> goodsDTOS = CommonUtil.jsonStringConvertToList(productInfo, GoodsDTO[].class);
                        if (!CollectionUtils.isEmpty(goodsDTOS)) {
                            goodsDTOS.stream().forEach(goodsDTO -> {
                                List<CartItemDTO> cartItemDTOS = goodsDTO.getCartItemDTOS();
                                if (!CollectionUtils.isEmpty(cartItemDTOS)) {
                                    cartItemDTOS.stream().forEach(cartItemDTO -> {
                                        goodsSkuRepository.releaseSkuStockLock(cartItemDTO.getProductSkuId(), cartItemDTO.getQuantity());
                                    });
                                }
                            });
                        }
                    }
                    orderItem.setStatus(4);
                }
                orderItemRepository.saveAll(orderItems);
            }

        }
        return payOrders.size();
    }

    @Override
    public void cancelOrder(Long orderId) {
        //??????????????????????????????

        PayOrder payOrder = payOrderRepository.findAllByIdAndStatusAndDeleteStatus(orderId, 0, 0);
        if (payOrder == null) {
            return;
        } else {
            //???????????????????????????
            payOrder.setStatus(4);
            payOrderRepository.save(payOrder);

            List<OrderItem> orderItemList = orderItemRepository.findAllByPayOrderId(orderId);
            //??????????????????????????????
            if (!CollectionUtils.isEmpty(orderItemList)) {
                orderItemList.stream().forEach(e -> {
                    String productInfo = e.getProductInfo();
                    if (!StringUtils.isBlank(productInfo)) {
                        List<GoodsDTO> goodsDTOS = CommonUtil.jsonStringConvertToList(productInfo, GoodsDTO[].class);
                        if (!CollectionUtils.isEmpty(goodsDTOS)) {
                            goodsDTOS.stream().forEach(goodsDTO -> {
                                List<CartItemDTO> cartItemDTOS = goodsDTO.getCartItemDTOS();
                                if (!CollectionUtils.isEmpty(cartItemDTOS)) {
                                    cartItemDTOS.stream().forEach(cartItemDTO -> {
                                        goodsSkuRepository.releaseSkuStockLock(cartItemDTO.getProductSkuId(), cartItemDTO.getQuantity());
                                    });
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    @Override
    public void sendDelayMessageCancelOrder(Long orderId) {
        this.cancelOrder(orderId);
//        //????????????????????????
//        OmsOrderSetting orderSetting = orderSettingMapper.selectByPrimaryKey(1L);
//        long delayTimes = orderSetting.getNormalOrderOvertime() * 60 * 1000;
//        //??????????????????
//        cancelOrderSender.sendMessage(orderId, delayTimes);
    }


    @Override
    public Page<OrderDetail> list(Integer status, Integer pageNum, Integer pageSize) {
        return null;
    }


    @Override
    public OrderDetail detail(Long orderId) {
        PayOrder payOrder = payOrderRepository.getOne(orderId);

        PayOrderDTO payOrderDTO = payOrderMapper.toDto(payOrder);
        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();
        if (payOrder != null) {
            List<OrderItem> orderItemList = orderItemRepository.findAllByPayOrderId(payOrder.getId());
            orderItemDTOS = orderItemMapper.toDto(orderItemList);
        }
        OrderDetail orderDetail = new OrderDetail();
        BeanUtils.copyProperties(payOrderDTO, orderDetail);
        orderDetail.setOrderItemList(orderItemDTOS);
        return orderDetail;
    }

    @Override
    public void deleteOrder(Long orderId) {
        LoginUserModel currentLoginUser = CommonUtil.getCurrentLoginUser();
        PayOrder one = payOrderRepository.getOne(orderId);
        if (!currentLoginUser.getId().equals(one.getMemberId())) {
            throw new MerchantsException(400, "????????????????????????");
        }
        if (one.getStatus() == 3 || one.getStatus() == 4) {
            one.setDeleteStatus(1);
            payOrderRepository.save(one);
        } else {
            throw new MerchantsException(400, "??????????????????????????????????????????");
        }
    }

    @Override
    public PayOrderDTO findByOrderSn(String orderSn) {
        return payOrderMapper.toDto(payOrderRepository.findFirstByOrderSn(orderSn));
    }

    @Override
    @Transactional
    public void paid(PayOrderDTO orderDTO) {

        //??????????????????
//        if (orderDTO.getPayType() != 0) {
//            log.error("?????????????????????????????????????????????, orderId={}, payType={}", orderDTO.getOrderSn(), orderDTO.getPayType());
//            throw new MerchantsException(400, "?????????????????????");
//        }
        //??????????????????
        if (orderDTO.getStatus() != 0) {
            log.error("???????????????????????????????????????????????????, orderDTO={}", orderDTO);
            throw new MerchantsException(400, "???????????????????????????");
        }
        //??????????????????
        paySuccess(orderDTO);

    }

    @Override
    public Map<Long, UserOrderCountAndAmountDTO> getOrderCountAndAmountByUserIds(List<Long> userIds) {
        Map<Long, UserOrderCountAndAmountDTO> map = new HashMap<>(16);
        List<Object[]> objects = payOrderRepository.countAndTotalPayAmountByUserIdIn(userIds);
        List<UserOrderCountAndAmountVM> userOrderCountAndAmountVMS = new ArrayList<>();
        try {
            userOrderCountAndAmountVMS = JpaSelectCastEntity.castEntity(objects, UserOrderCountAndAmountVM.class);
        } catch (Exception e1) {
            log.error("???????????????" + e1.getMessage());
            e1.printStackTrace();
        }
        if (!CollectionUtils.isEmpty(userOrderCountAndAmountVMS)) {
            userOrderCountAndAmountVMS.stream().forEach(e -> {
                UserOrderCountAndAmountDTO userOrderCountAndAmountDTO = new UserOrderCountAndAmountDTO();
                userOrderCountAndAmountDTO.setMemberId(e.getMemberId().longValue());
                userOrderCountAndAmountDTO.setTotalOrderCount(e.getTotalOrderCount().longValue());
                userOrderCountAndAmountDTO.setTotalPayAmount(e.getTotalPayAmount());
                map.put(userOrderCountAndAmountDTO.getMemberId(), userOrderCountAndAmountDTO);
            });
        }

        return map;
    }

    /**
     * ??????20???????????????:12?????????+2???????????????+6???????????????id
     */
    private String generateOrderSn(PayOrder order) {
        StringBuilder sb = new StringBuilder();
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ORDER_ID + date;
        Long increment = redisService.incrByString(key, 1 + "");
        sb.append(date);
//        sb.append(String.format("%02d", order.getPayType()));
        String incrementStr = increment.toString();
        if (incrementStr.length() <= 6) {
            sb.append(String.format("%06d", increment));
        } else {
            sb.append(incrementStr);
        }
        return sb.toString();
    }

    /**
     * ??????18???????????????:10?????????+2???????????????+6???????????????id
     */
    private String generateOrderSn(OrderItem order) {
        StringBuilder sb = new StringBuilder();
        String date = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        String key = REDIS_DATABASE + ":" + REDIS_KEY_SUB_ORDER_ID + date;
        Long increment = redisService.incrByString(key, 1 + "");
        sb.append(date);
//        sb.append(String.format("%02d", order.getPayType()));
        String incrementStr = increment.toString();
        if (incrementStr.length() <= 6) {
            sb.append(String.format("%06d", increment));
        } else {
            sb.append(incrementStr);
        }
        return sb.toString();
    }

    /**
     * ????????????????????????????????????
     */
    private void deleteCartItemList(List<CartItemDTO> cartPromotionItemList, Long userId) {
        List<String> ids = cartPromotionItemList.stream().map(CartItemDTO::getId).collect(Collectors.toList());
        cartItemService.delete(userId, ids);
    }


//    private void handleRealAmount(List<OrderItem> orderItemList) {
//        for (OrderItem orderItem : orderItemList) {
//            //??????-????????????-???????????????-????????????
//            String productInfo = orderItem.getProductInfo();
//            if (!StringUtils.isBlank(productInfo)) {
//                List<GoodsDTO> goodsDTOS = CommonUtil.jsonStringConvertToList(productInfo, GoodsDTO[].class);
//                if (!CollectionUtils.isEmpty(goodsDTOS)) {
//                    goodsDTOS.stream().forEach(goodsDTO -> {
//                        List<CartItemDTO> cartItemDTOS = goodsDTO.getCartItemDTOS();
//                        if (!CollectionUtils.isEmpty(cartItemDTOS)) {
//                            cartItemDTOS.stream().forEach(cartItemDTO -> {
//                                BigDecimal realAmount = cartItemDTO.getPrice().multiply(BigDecimal.valueOf(cartItemDTO.getQuantity()));
//                                orderItem.setTotalAmount((orderItem.getPayAmount() == null ? BigDecimal.ZERO : orderItem.getPayAmount()).add(realAmount));
//                            });
//                        }
//                    });
//                }
//            }
//
//        }
//    }


    /**
     * ????????????????????????
     */
    private BigDecimal calcPayAmount(PayOrder order) {
        //?????????+??????-????????????-???????????????-????????????
        BigDecimal payAmount = order.getTotalAmount()
            .add(order.getFreightAmount()).add(order.getTaxesFeesAmount())
            .subtract(order.getPromotionAmount());
        return payAmount;
    }


    /**
     * ???????????????
     */
    private BigDecimal calcTotalAmount(List<OrderItem> orderItemList) {
        BigDecimal totalAmount = new BigDecimal("0");
        for (OrderItem item : orderItemList) {
            String productInfo = item.getProductInfo();
            if (!StringUtils.isBlank(productInfo)) {
                List<GoodsDTO> goodsDTOS = CommonUtil.jsonStringConvertToList(productInfo, GoodsDTO[].class);
                if (!CollectionUtils.isEmpty(goodsDTOS)) {
                    for (GoodsDTO goodsDTO : goodsDTOS) {
                        List<CartItemDTO> cartItemDTOS = goodsDTO.getCartItemDTOS();
                        if (!CollectionUtils.isEmpty(cartItemDTOS)) {
                            for (CartItemDTO cartItemDTO : cartItemDTOS) {
                                totalAmount = totalAmount.add(cartItemDTO.getPrice().multiply(new BigDecimal(cartItemDTO.getQuantity())));
                            }
                        }
                    }
                }
            }

        }
        return totalAmount;
    }

    /**
     * ?????????????????????????????????
     */
    private void lockStock(List<CartItemDTO> cartPromotionItemList) {
        for (CartItemDTO cartPromotionItem : cartPromotionItemList) {
            GoodsSku skuStock = goodsSkuRepository.getOne(cartPromotionItem.getProductSkuId());
            skuStock.setLockStock(skuStock.getLockStock() + cartPromotionItem.getQuantity());
            goodsSkuRepository.save(skuStock);
        }
    }

    /**
     * ????????????????????????????????????
     */
    private boolean hasStock(List<CartItemDTO> cartPromotionItemList) {
        List<Long> skuIds = cartPromotionItemList.stream().map(CartItemDTO::getProductSkuId).collect(Collectors.toList());
        List<GoodsSku> goodsSku = goodsSkuRepository.findAllByIdInAndDeleteFlag(skuIds, false);
        Map<Long, GoodsSku> goodsMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(goodsSku)) {
            goodsMap = goodsSku.stream().collect(Collectors.toMap(GoodsSku::getId, e -> e));
        }
        for (CartItemDTO cartPromotionItem : cartPromotionItemList) {
            GoodsSku goodsSku1 = goodsMap.get(cartPromotionItem.getProductSkuId());
            if (goodsSku1 == null || goodsSku1.getStock() == null || goodsSku1.getStock() - cartPromotionItem.getQuantity() < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * ?????????????????????????????????
     */
    private ConfirmOrderResult.CalcAmount calcCartAmount(List<CartItemDTO> cartItemDTOS) {
        ConfirmOrderResult.CalcAmount calcAmount = new ConfirmOrderResult.CalcAmount();
        if (!CollectionUtils.isEmpty(cartItemDTOS)) {
            if (cartItemDTOS.stream().filter(e -> e.getGoodsDeleteState() != null && e.getGoodsDeleteState()).collect(Collectors.toList()).size() > 0) {
                throw new MerchantsException(400, "???????????????????????????");
            }
            List<Long> skuIds = cartItemDTOS.stream().map(CartItemDTO::getProductSkuId).collect(Collectors.toList());
            List<Long> goodsIds = cartItemDTOS.stream().map(CartItemDTO::getProductId).collect(Collectors.toList());
//            List<GoodsSku> goodsSkus = goodsSkuRepository.findAllByIdInAndDeleteFlag(skuIds, false);
            List<Goods> goodsList = goodsRepository.findAllByIdIn(goodsIds);
            Map<Long, List<Goods>> goodsStroeMap = goodsList.stream().collect(Collectors.groupingBy(Goods::getStoreId));
            Map<Long, Goods> goodsMap = goodsList.stream().collect(Collectors.toMap(Goods::getId, e -> e));
//            Map<Long, List<GoodsSku>> goodsSkuMap = goodsSkus.stream().collect(Collectors.groupingBy(GoodsSku::getGoodsId));

            calcAmount.setFreightAmount(BigDecimal.ZERO);
            calcAmount.setTaxesFees(BigDecimal.ZERO);
            goodsStroeMap.entrySet().stream().forEach(e -> {
                List<Goods> goods = e.getValue();
                BigDecimal maxFreight = BigDecimal.ZERO;
                if (!CollectionUtils.isEmpty(goods)) {
                    for (int i = 0; i < goods.size(); i++) {
                        Goods goodsOne = goodsMap.get(goods.get(i).getId());
                        if (goodsOne.getFreight().compareTo(maxFreight) > 0) {
                            maxFreight = goodsOne.getFreight();
                        }
                    }
                }
                calcAmount.setFreightAmount(calcAmount.getFreightAmount().add(maxFreight));
            });

            BigDecimal totalAmount = BigDecimal.ZERO;
            for (CartItemDTO cartPromotionItem : cartItemDTOS) {
                totalAmount = totalAmount.add(cartPromotionItem.getPrice().multiply(new BigDecimal(cartPromotionItem.getQuantity())));
            }
            calcAmount.setTotalAmount(totalAmount);
            calcAmount.setPromotionAmount(BigDecimal.ZERO);
            calcAmount.setPayAmount(totalAmount.add(calcAmount.getFreightAmount()).add(calcAmount.getTaxesFees()).subtract(calcAmount.getPromotionAmount()));
            return calcAmount;
        }
        return calcAmount;
    }
}
