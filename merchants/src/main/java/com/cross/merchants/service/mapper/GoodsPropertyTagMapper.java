package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.*;
import com.cross.merchants.service.dto.GoodsPropertyTagDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link GoodsPropertyTag} and its DTO {@link GoodsPropertyTagDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface GoodsPropertyTagMapper extends EntityMapper<GoodsPropertyTagDTO, GoodsPropertyTag> {



    default GoodsPropertyTag fromId(Long id) {
        if (id == null) {
            return null;
        }
        GoodsPropertyTag goodsPropertyTag = new GoodsPropertyTag();
        goodsPropertyTag.setId(id);
        return goodsPropertyTag;
    }
}
