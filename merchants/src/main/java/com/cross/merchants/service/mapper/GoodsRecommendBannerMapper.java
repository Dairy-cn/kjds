package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.*;
import com.cross.merchants.service.dto.GoodsRecommendBannerDTO;
import com.cross.merchants.service.dto.GoodsRecommendBannerPositionDTO;

import com.cross.utils.JsonUtil;
import org.mapstruct.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Mapper for the entity {@link GoodsRecommendBrand} and its DTO {@link GoodsRecommendBrandDTO}.
 */
@Service
public class GoodsRecommendBannerMapper {


    public GoodsRecommendBannerMapper() {
    }

    public GoodsRecommendBanner toEntity(GoodsRecommendBannerDTO dto) {
        if (dto == null) {
            return null;
        } else {
            GoodsRecommendBanner goodsRecommendBanner = new GoodsRecommendBanner();
            goodsRecommendBanner.setId(dto.getId());

            goodsRecommendBanner.setPositionOne(JsonUtil.objectToJson(dto.getPositionOne()));
            goodsRecommendBanner.setPositionTwo(JsonUtil.objectToJson(dto.getPositionTwo()));
            goodsRecommendBanner.setPositionThree(JsonUtil.objectToJson(dto.getPositionThree()));
            goodsRecommendBanner.setDivisionName(dto.getDivisionName());
            goodsRecommendBanner.setTop(dto.getTop());
            return goodsRecommendBanner;
        }
    }

    public GoodsRecommendBannerDTO toDto(GoodsRecommendBanner entity) {
        if (entity == null) {
            return null;
        } else {
            GoodsRecommendBannerDTO goodsRecommendBannerDTO = new GoodsRecommendBannerDTO();
            goodsRecommendBannerDTO.setId(entity.getId());
            goodsRecommendBannerDTO.setPositionOne((GoodsRecommendBannerPositionDTO) JsonUtil.jsonToBean(entity.getPositionOne(), GoodsRecommendBannerPositionDTO.class));
            goodsRecommendBannerDTO.setPositionTwo((GoodsRecommendBannerPositionDTO) JsonUtil.jsonToBean(entity.getPositionTwo(), GoodsRecommendBannerPositionDTO.class));
            goodsRecommendBannerDTO.setPositionThree((GoodsRecommendBannerPositionDTO) JsonUtil.jsonToBean(entity.getPositionThree(), GoodsRecommendBannerPositionDTO.class));
            goodsRecommendBannerDTO.setDivisionName(entity.getDivisionName());
            goodsRecommendBannerDTO.setTop(entity.isTop());
            return goodsRecommendBannerDTO;
        }
    }

    public List<GoodsRecommendBanner> toEntity(List<GoodsRecommendBannerDTO> dtoList) {
        if (dtoList == null) {
            return null;
        } else {
            List<GoodsRecommendBanner> list = new ArrayList(dtoList.size());
            Iterator var3 = dtoList.iterator();

            while(var3.hasNext()) {
                GoodsRecommendBannerDTO goodsRecommendBannerDTO = (GoodsRecommendBannerDTO)var3.next();
                list.add(this.toEntity(goodsRecommendBannerDTO));
            }

            return list;
        }
    }

    public List<GoodsRecommendBannerDTO> toDto(List<GoodsRecommendBanner> entityList) {
        if (entityList == null) {
            return null;
        } else {
            List<GoodsRecommendBannerDTO> list = new ArrayList(entityList.size());
            Iterator var3 = entityList.iterator();

            while(var3.hasNext()) {
                GoodsRecommendBanner goodsRecommendBanner = (GoodsRecommendBanner)var3.next();
                list.add(this.toDto(goodsRecommendBanner));
            }

            return list;
        }
    }
}
