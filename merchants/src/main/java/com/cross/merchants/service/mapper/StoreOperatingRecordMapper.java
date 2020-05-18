package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.*;
import com.cross.merchants.service.dto.StoreOperatingRecordDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link StoreOperatingRecord} and its DTO {@link StoreOperatingRecordDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface StoreOperatingRecordMapper extends EntityMapper<StoreOperatingRecordDTO, StoreOperatingRecord> {



    default StoreOperatingRecord fromId(Long id) {
        if (id == null) {
            return null;
        }
        StoreOperatingRecord storeOperatingRecord = new StoreOperatingRecord();
        storeOperatingRecord.setId(id);
        return storeOperatingRecord;
    }
}
