package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.*;
import com.cross.merchants.service.dto.GlobalRegionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link GlobalRegion} and its DTO {@link GlobalRegionDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface GlobalRegionMapper extends EntityMapper<GlobalRegionDTO, GlobalRegion> {



    default GlobalRegion fromId(Long id) {
        if (id == null) {
            return null;
        }
        GlobalRegion globalRegion = new GlobalRegion();
        globalRegion.setId(id);
        return globalRegion;
    }
}
