package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.*;
import com.cross.merchants.service.dto.ShippingListDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ShippingList} and its DTO {@link ShippingListDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ShippingListMapper extends EntityMapper<ShippingListDTO, ShippingList> {



    default ShippingList fromId(Long id) {
        if (id == null) {
            return null;
        }
        ShippingList shippingList = new ShippingList();
        shippingList.setId(id);
        return shippingList;
    }
}
