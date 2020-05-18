package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.*;
import com.cross.merchants.service.dto.GoodsCategoryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link GoodsCategory} and its DTO {@link GoodsCategoryDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface GoodsCategoryMapper extends EntityMapper<GoodsCategoryDTO, GoodsCategory> {



    default GoodsCategory fromId(Long id) {
        if (id == null) {
            return null;
        }
        GoodsCategory goodsCategory = new GoodsCategory();
        goodsCategory.setId(id);
        return goodsCategory;
    }
}
