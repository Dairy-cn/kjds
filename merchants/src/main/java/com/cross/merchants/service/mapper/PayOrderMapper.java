package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.*;
import com.cross.merchants.service.dto.PayOrderDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link PayOrder} and its DTO {@link PayOrderDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PayOrderMapper extends EntityMapper<PayOrderDTO, PayOrder> {



    default PayOrder fromId(Long id) {
        if (id == null) {
            return null;
        }
        PayOrder payOrder = new PayOrder();
        payOrder.setId(id);
        return payOrder;
    }
}
