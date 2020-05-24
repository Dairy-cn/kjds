package com.cross.merchants.service;

import com.cross.merchants.service.dto.PayOrderDTO;

import com.cross.merchants.web.rest.DTO.ConfirmOrderResult;
import com.cross.merchants.web.rest.DTO.OrderDetail;
import com.cross.merchants.web.rest.DTO.OrderParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.PayOrder}.
 */
public interface PayOrderService {

    /**
     * Save a payOrder.
     *
     * @param payOrderDTO the entity to save.
     * @return the persisted entity.
     */
    PayOrderDTO save(PayOrderDTO payOrderDTO);

    /**
     * Get all the payOrders.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PayOrderDTO> findAll(Pageable pageable);

    /**
     * Get the "id" payOrder.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PayOrderDTO> findOne(Long id);

    /**
     * Delete the "id" payOrder.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * 根据用户购物车信息生成确认单信息
     * @param cartIds
     */
    ConfirmOrderResult generateConfirmOrder(List<String> cartIds);

    /**
     * 根据提交信息生成订单
     */
    @Transactional
    Map<String, Object> generateOrder(OrderParam orderParam);

    /**
     * 支付成功后的回调
     */
    @Transactional
    Integer paySuccess(Long orderId, Integer payType);

    /**
     * 自动取消超时订单
     */
    @Transactional
    Integer cancelTimeOutOrder();

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);

    /**
     * 发送延迟消息取消订单
     */
    void sendDelayMessageCancelOrder(Long orderId);

    /**
     * 确认收货
     */
    void confirmReceiveOrder(Long orderId);

    /**
     * 分页获取用户订单
     */
    Page<OrderDetail> list(Integer status, Integer pageNum, Integer pageSize);

    /**
     * 根据订单ID获取订单详情
     */
    OrderDetail detail(Long orderId);

    /**
     * 用户根据订单ID删除订单
     */
    void deleteOrder(Long orderId);
}
