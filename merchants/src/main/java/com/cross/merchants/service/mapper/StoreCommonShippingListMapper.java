package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.*;
import com.cross.merchants.service.dto.StoreCommonShippingListDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link StoreCommonShippingList} and its DTO {@link StoreCommonShippingListDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface StoreCommonShippingListMapper extends EntityMapper<StoreCommonShippingListDTO, StoreCommonShippingList> {



    default StoreCommonShippingList fromId(Long id) {
        if (id == null) {
            return null;
        }
        StoreCommonShippingList storeCommonShippingList = new StoreCommonShippingList();
        storeCommonShippingList.setId(id);
        return storeCommonShippingList;
    }
}
