package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.*;
import com.cross.merchants.service.dto.StoreInfoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link StoreInfo} and its DTO {@link StoreInfoDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface StoreInfoMapper extends EntityMapper<StoreInfoDTO, StoreInfo> {



    default StoreInfo fromId(Long id) {
        if (id == null) {
            return null;
        }
        StoreInfo storeInfo = new StoreInfo();
        storeInfo.setId(id);
        return storeInfo;
    }
}
