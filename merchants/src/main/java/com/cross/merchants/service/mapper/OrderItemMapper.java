package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.*;
import com.cross.merchants.service.dto.GoodsDTO;
import com.cross.merchants.service.dto.OrderItemDTO;

import com.cross.utils.CommonUtil;
import com.cross.utils.JsonUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper for the entity {@link OrderItem} and its DTO {@link OrderItemDTO}.
 */
@Service
public class OrderItemMapper {


    public OrderItem toEntity(OrderItemDTO dto) {
        if ( dto == null ) {
            return null;
        }

        OrderItem orderItem = new OrderItem();

        orderItem.setId( dto.getId() );
        orderItem.setMemberId( dto.getMemberId() );
        orderItem.setMemberName( dto.getMemberName() );
        orderItem.setMemberPhone( dto.getMemberPhone() );
        orderItem.setPayOrderId( dto.getPayOrderId() );
        orderItem.setPayOrderPaymentCode( dto.getPayOrderPaymentCode() );
        orderItem.setOrderSn( dto.getOrderSn() );
        orderItem.setCreateTime( dto.getCreateTime() );
        orderItem.setMemberUsername( dto.getMemberUsername() );
        orderItem.setTotalAmount( dto.getTotalAmount() );
        orderItem.setPayAmount( dto.getPayAmount() );
        orderItem.setFreightAmount( dto.getFreightAmount() );
        orderItem.setPayType( dto.getPayType() );
        orderItem.setStatus( dto.getStatus() );
        orderItem.setOrderType( dto.getOrderType() );
        orderItem.setDeliveryCompany( dto.getDeliveryCompany() );
        orderItem.setDeliverySn( dto.getDeliverySn() );
        orderItem.setAutoConfirmDay( dto.getAutoConfirmDay() );
        orderItem.setReceiverName( dto.getReceiverName() );
        orderItem.setReceiverPhone( dto.getReceiverPhone() );
        orderItem.setReceiverPostCode( dto.getReceiverPostCode() );
        orderItem.setReceiverProvince( dto.getReceiverProvince() );
        orderItem.setReceiverCity( dto.getReceiverCity() );
        orderItem.setReceiverRegion( dto.getReceiverRegion() );
        orderItem.setReceiverDetailAddress( dto.getReceiverDetailAddress() );
        orderItem.setNote( dto.getNote() );
        orderItem.setConfirmStatus( dto.getConfirmStatus() );
        orderItem.setDeleteStatus( dto.getDeleteStatus() );
        orderItem.setPaymentTime( dto.getPaymentTime() );
        orderItem.setDeliveryTime( dto.getDeliveryTime() );
        orderItem.setReceiveTime( dto.getReceiveTime() );
        orderItem.setCommentTime( dto.getCommentTime() );
        orderItem.setProcessingTime( dto.getProcessingTime() );
        orderItem.setModifyTime( dto.getModifyTime() );
        orderItem.setProductStoreId( dto.getProductStoreId() );
        orderItem.setStoreName( dto.getStoreName() );
        orderItem.setStoreNo( dto.getStoreNo() );
        if(!CollectionUtils.isEmpty(dto.getProductInfo())){
            orderItem.setProductInfo(JsonUtil.objectToJson(dto.getProductInfo()));
        }
        orderItem.setPromotionAmount( dto.getPromotionAmount() );
        orderItem.setTaxesFees( dto.getTaxesFees() );
        orderItem.setDeliveryCode(dto.getDeliveryCode());
        orderItem.setDeliveryState(dto.getDeliveryState());
        orderItem.setGoodsName(dto.getGoodsName());
        return orderItem;
    }

    public OrderItemDTO toDto(OrderItem entity) {
        if ( entity == null ) {
            return null;
        }

        OrderItemDTO orderItemDTO = new OrderItemDTO();

        orderItemDTO.setId( entity.getId() );
        orderItemDTO.setMemberId( entity.getMemberId() );
        orderItemDTO.setMemberName( entity.getMemberName() );
        orderItemDTO.setMemberPhone( entity.getMemberPhone() );
        orderItemDTO.setPayOrderId( entity.getPayOrderId() );
        orderItemDTO.setPayOrderPaymentCode( entity.getPayOrderPaymentCode() );
        orderItemDTO.setOrderSn( entity.getOrderSn() );
        orderItemDTO.setCreateTime( entity.getCreateTime() );
        orderItemDTO.setMemberUsername( entity.getMemberUsername() );
        orderItemDTO.setTotalAmount( entity.getTotalAmount() );
        orderItemDTO.setPayAmount( entity.getPayAmount() );
        orderItemDTO.setFreightAmount( entity.getFreightAmount() );
        orderItemDTO.setPayType( entity.getPayType() );
        orderItemDTO.setStatus( entity.getStatus() );
        orderItemDTO.setOrderType( entity.getOrderType() );
        orderItemDTO.setDeliveryCompany( entity.getDeliveryCompany() );
        orderItemDTO.setDeliverySn( entity.getDeliverySn() );
        orderItemDTO.setAutoConfirmDay( entity.getAutoConfirmDay() );
        orderItemDTO.setReceiverName( entity.getReceiverName() );
        orderItemDTO.setReceiverPhone( entity.getReceiverPhone() );
        orderItemDTO.setReceiverPostCode( entity.getReceiverPostCode() );
        orderItemDTO.setReceiverProvince( entity.getReceiverProvince() );
        orderItemDTO.setReceiverCity( entity.getReceiverCity() );
        orderItemDTO.setReceiverRegion( entity.getReceiverRegion() );
        orderItemDTO.setReceiverDetailAddress( entity.getReceiverDetailAddress() );
        orderItemDTO.setNote( entity.getNote() );
        orderItemDTO.setConfirmStatus( entity.getConfirmStatus() );
        orderItemDTO.setDeleteStatus( entity.getDeleteStatus() );
        orderItemDTO.setPaymentTime( entity.getPaymentTime() );
        orderItemDTO.setDeliveryTime( entity.getDeliveryTime() );
        orderItemDTO.setReceiveTime( entity.getReceiveTime() );
        orderItemDTO.setCommentTime( entity.getCommentTime() );
        orderItemDTO.setProcessingTime( entity.getProcessingTime() );
        orderItemDTO.setModifyTime( entity.getModifyTime() );
        orderItemDTO.setProductStoreId( entity.getProductStoreId() );
        orderItemDTO.setStoreName( entity.getStoreName() );
        orderItemDTO.setStoreNo( entity.getStoreNo() );
        if(!StringUtils.isBlank(entity.getProductInfo())){
            orderItemDTO.setProductInfo(CommonUtil.jsonStringConvertToList(entity.getProductInfo(), GoodsDTO[].class));
        }
        orderItemDTO.setPromotionAmount( entity.getPromotionAmount() );
        orderItemDTO.setTaxesFees( entity.getTaxesFees() );
        orderItemDTO.setDeliveryCode(entity.getDeliveryCode());
        orderItemDTO.setDeliveryState(entity.getDeliveryState());
        orderItemDTO.setGoodsName(entity.getGoodsName());
        return orderItemDTO;
    }

    public List<OrderItem> toEntity(List<OrderItemDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<OrderItem> list = new ArrayList<OrderItem>( dtoList.size() );
        for ( OrderItemDTO orderItemDTO : dtoList ) {
            list.add( toEntity( orderItemDTO ) );
        }

        return list;
    }

    public List<OrderItemDTO> toDto(List<OrderItem> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<OrderItemDTO> list = new ArrayList<OrderItemDTO>( entityList.size() );
        for ( OrderItem orderItem : entityList ) {
            list.add( toDto( orderItem ) );
        }

        return list;
    }
}
