package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.*;
import com.cross.merchants.service.dto.GoodsPropertyDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link GoodsProperty} and its DTO {@link GoodsPropertyDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface GoodsPropertyMapper extends EntityMapper<GoodsPropertyDTO, GoodsProperty> {



    default GoodsProperty fromId(Long id) {
        if (id == null) {
            return null;
        }
        GoodsProperty goodsProperty = new GoodsProperty();
        goodsProperty.setId(id);
        return goodsProperty;
    }
}
