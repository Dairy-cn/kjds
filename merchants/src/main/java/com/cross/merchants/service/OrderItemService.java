package com.cross.merchants.service;

import com.cross.merchants.service.dto.OrderItemDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.Instant;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.OrderItem}.
 */
public interface OrderItemService {

    /**
     * Save a orderItem.
     *
     * @param orderItemDTO the entity to save.
     * @return the persisted entity.
     */
    OrderItemDTO save(OrderItemDTO orderItemDTO);

    /**
     * Get all the orderItems.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<OrderItemDTO> findAll(Pageable pageable);

    /**
     * Get the "id" orderItem.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<OrderItemDTO> findOne(Long id);

    /**
     * Delete the "id" orderItem.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    Page<OrderItemDTO> findAllCondition(Pageable pageable, Integer orderStatus, Long storeId, Instant startTime, Instant endTime, String keyWord, Integer deliveryState, String goodsName);

    Page<OrderItemDTO> getMyOrder(Pageable pageable, Integer orderStatus, Long userId, Instant startTime, Instant endTime, String keyWord, Integer deliveryState);



    /**
     * 确认收货
     */
    void confirmReceiveOrder(Long orderId);

}
