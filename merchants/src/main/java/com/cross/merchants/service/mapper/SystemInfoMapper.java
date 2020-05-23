package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.*;
import com.cross.merchants.service.dto.SystemInfoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link SystemInfo} and its DTO {@link SystemInfoDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SystemInfoMapper extends EntityMapper<SystemInfoDTO, SystemInfo> {



    default SystemInfo fromId(Long id) {
        if (id == null) {
            return null;
        }
        SystemInfo systemInfo = new SystemInfo();
        systemInfo.setId(id);
        return systemInfo;
    }
}
