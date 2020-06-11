package com.cross.merchants.service.impl;

import com.cross.merchants.domain.Goods;
import com.cross.merchants.domain.PayOrder;
import com.cross.merchants.exception.MerchantsException;
import com.cross.merchants.service.OrderItemService;
import com.cross.merchants.domain.OrderItem;
import com.cross.merchants.repository.OrderItemRepository;
import com.cross.merchants.service.dto.OrderItemDTO;
import com.cross.merchants.service.mapper.OrderItemMapper;
import com.cross.model.LoginUserModel;
import com.cross.utils.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link OrderItem}.
 */
@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {

    private final Logger log = LoggerFactory.getLogger(OrderItemServiceImpl.class);

    private final OrderItemRepository orderItemRepository;

    private final OrderItemMapper orderItemMapper;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository, OrderItemMapper orderItemMapper) {
        this.orderItemRepository = orderItemRepository;
        this.orderItemMapper = orderItemMapper;
    }

    /**
     * Save a orderItem.
     *
     * @param orderItemDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public OrderItemDTO save(OrderItemDTO orderItemDTO) {
        log.debug("Request to save OrderItem : {}", orderItemDTO);
        OrderItem orderItem = orderItemMapper.toEntity(orderItemDTO);
        orderItem = orderItemRepository.save(orderItem);
        return orderItemMapper.toDto(orderItem);
    }

    /**
     * Get all the orderItems.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<OrderItemDTO> findAll(Pageable pageable) {
        log.debug("Request to get all OrderItems");
        return orderItemRepository.findAll(pageable)
            .map(orderItemMapper::toDto);
    }

    /**
     * Get one orderItem by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<OrderItemDTO> findOne(Long id) {
        log.debug("Request to get OrderItem : {}", id);
        return orderItemRepository.findById(id)
            .map(orderItemMapper::toDto);
    }

    /**
     * Delete the orderItem by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete OrderItem : {}", id);
        orderItemRepository.deleteById(id);
    }

    @Override
    public Page<OrderItemDTO> findAllCondition(Pageable pageable, Integer orderStatus, Long storeId, Instant startTime, Instant endTime, String keyWord, Integer deliveryState,String goodsName) {

        Page<OrderItem> page = orderItemRepository.findAll((r, q, b) -> {
            List<Predicate> listPredicates = new ArrayList<>();
            if (storeId != null) {
                listPredicates.add(b.equal(r.get("productStoreId").as(Long.class), storeId));
            }
            if (orderStatus != null) {
                listPredicates.add(b.equal(r.get("status").as(Integer.class), orderStatus));
            }
            listPredicates.add(b.notEqual(r.get("deleteStatus").as(Integer.class), 1));
            if (deliveryState != null) {
                listPredicates.add(b.equal(r.get("deliveryState").as(Integer.class),deliveryState));
            }
            if(!StringUtils.isBlank(goodsName)){
                listPredicates.add(b.like(r.get("goodsName").as(String.class), "%" + keyWord.trim() + "%"));
            }
            if (!StringUtils.isBlank(keyWord)) {
                List<Predicate> listPermission = new ArrayList<>();
                listPermission.add(b.like(r.get("orderSn").as(String.class), "%" + keyWord.trim() + "%"));
                listPermission.add(b.like(r.get("memberPhone").as(String.class), "%" + keyWord.trim() + "%"));
                listPermission.add(b.like(r.get("deliverySn").as(String.class), "%" + keyWord.trim() + "%"));
                Predicate[] predicatesPermissionArr = new Predicate[listPermission.size()];
                listPredicates.add(b.or(listPermission.toArray(predicatesPermissionArr)));
            }
            if (startTime != null) {
                listPredicates.add(b.greaterThanOrEqualTo(r.get("paymentTime").as(Instant.class), startTime));
            }
            if (endTime != null) {
                listPredicates.add(b.lessThanOrEqualTo(r.get("paymentTime").as(Instant.class), endTime));
            }

            Predicate[] arrayPredicates = new Predicate[listPredicates.size()];
            return b.and(listPredicates.toArray(arrayPredicates));
        }, pageable);
        return page.map(orderItemMapper::toDto);
    }

    @Override
    public Page<OrderItemDTO> getMyOrder(Pageable pageable, Integer orderStatus, Long userId, Instant startTime, Instant endTime, String keyWord, Integer deliveryState) {
        Page<OrderItem> page = orderItemRepository.findAll((r, q, b) -> {
            List<Predicate> listPredicates = new ArrayList<>();
            if (userId != null) {
                listPredicates.add(b.equal(r.get("memberId").as(Long.class), userId));
            }
            if (orderStatus != null) {
                listPredicates.add(b.equal(r.get("status").as(Integer.class), orderStatus));
            }
            listPredicates.add(b.notEqual(r.get("deleteStatus").as(Integer.class), 1));
            if (deliveryState != null) {
                listPredicates.add(b.equal(r.get("deliveryState").as(Integer.class),deliveryState));
            }
            if (!StringUtils.isBlank(keyWord)) {
                List<Predicate> listPermission = new ArrayList<>();
                listPermission.add(b.like(r.get("orderSn").as(String.class), "%" + keyWord.trim() + "%"));
                listPermission.add(b.like(r.get("goodsName").as(String.class), "%" + keyWord.trim() + "%"));
//                listPermission.add(b.like(r.get("deliverySn").as(String.class), "%" + keyWord.trim() + "%"));
                Predicate[] predicatesPermissionArr = new Predicate[listPermission.size()];
                listPredicates.add(b.or(listPermission.toArray(predicatesPermissionArr)));
            }
            if (startTime != null) {
                listPredicates.add(b.greaterThanOrEqualTo(r.get("paymentTime").as(Instant.class), startTime));
            }
            if (endTime != null) {
                listPredicates.add(b.lessThanOrEqualTo(r.get("paymentTime").as(Instant.class), endTime));
            }

            Predicate[] arrayPredicates = new Predicate[listPredicates.size()];
            return b.and(listPredicates.toArray(arrayPredicates));
        }, pageable);
        return page.map(orderItemMapper::toDto);
    }

    @Override
    public void confirmReceiveOrder(Long orderId) {
        LoginUserModel loginUser = CommonUtil.getCurrentLoginUser();
        OrderItem one = orderItemRepository.getOne(orderId);
        if (!loginUser.getId().equals(one.getMemberId())) {
            throw new MerchantsException(400, "不能确认他人订单");
        }
        if (one.getStatus() != 2) {
            throw new MerchantsException(400, "该订单还未发货");
        }
        one.setStatus(3);
        one.setConfirmStatus(1);
        one.setReceiveTime(Instant.now());
        orderItemRepository.save(one);
    }


    @Override
    public void deleteOrder(Long orderId) {
        LoginUserModel currentLoginUser = CommonUtil.getCurrentLoginUser();
        OrderItem repositoryOne = orderItemRepository.getOne(orderId);
        if (!currentLoginUser.getId().equals(repositoryOne.getMemberId())) {
            throw new MerchantsException(400, "不能删除他人订单");
        }
        if (repositoryOne.getStatus() == 3 || repositoryOne.getStatus() == 4) {
            repositoryOne.setDeleteStatus(1);
            orderItemRepository.save(repositoryOne);
        } else {
            throw new MerchantsException(400, "只能删除已完成或已关闭的订单");
        }
    }
}
