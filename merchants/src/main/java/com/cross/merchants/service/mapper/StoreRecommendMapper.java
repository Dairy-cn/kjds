package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.*;
import com.cross.merchants.service.dto.StoreRecommendDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link StoreRecommend} and its DTO {@link StoreRecommendDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface StoreRecommendMapper extends EntityMapper<StoreRecommendDTO, StoreRecommend> {



    default StoreRecommend fromId(Long id) {
        if (id == null) {
            return null;
        }
        StoreRecommend storeRecommend = new StoreRecommend();
        storeRecommend.setId(id);
        return storeRecommend;
    }
}
