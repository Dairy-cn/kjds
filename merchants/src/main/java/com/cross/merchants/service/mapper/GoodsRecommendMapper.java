package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.*;
import com.cross.merchants.service.dto.GoodsRecommendDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link GoodsRecommend} and its DTO {@link GoodsRecommendDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface GoodsRecommendMapper extends EntityMapper<GoodsRecommendDTO, GoodsRecommend> {



    default GoodsRecommend fromId(Long id) {
        if (id == null) {
            return null;
        }
        GoodsRecommend goodsRecommend = new GoodsRecommend();
        goodsRecommend.setId(id);
        return goodsRecommend;
    }
}
