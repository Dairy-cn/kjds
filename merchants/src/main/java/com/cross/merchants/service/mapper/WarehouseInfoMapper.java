package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.*;
import com.cross.merchants.service.dto.WarehouseInfoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link WarehouseInfo} and its DTO {@link WarehouseInfoDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface WarehouseInfoMapper extends EntityMapper<WarehouseInfoDTO, WarehouseInfo> {



    default WarehouseInfo fromId(Long id) {
        if (id == null) {
            return null;
        }
        WarehouseInfo warehouseInfo = new WarehouseInfo();
        warehouseInfo.setId(id);
        return warehouseInfo;
    }
}
