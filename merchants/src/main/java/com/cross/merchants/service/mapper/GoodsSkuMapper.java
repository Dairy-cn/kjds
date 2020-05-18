package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.*;
import com.cross.merchants.service.dto.GoodsSkuDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link GoodsSku} and its DTO {@link GoodsSkuDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface GoodsSkuMapper extends EntityMapper<GoodsSkuDTO, GoodsSku> {



    default GoodsSku fromId(Long id) {
        if (id == null) {
            return null;
        }
        GoodsSku goodsSku = new GoodsSku();
        goodsSku.setId(id);
        return goodsSku;
    }
}
