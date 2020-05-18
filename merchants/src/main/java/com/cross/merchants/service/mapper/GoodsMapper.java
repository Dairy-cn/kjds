package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.Goods;
import com.cross.merchants.service.dto.GoodsDTO;
import com.cross.utils.CommonUtil;
import com.cross.utils.JsonUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Mapper for the entity {@link Goods} and its DTO {@link GoodsDTO}.
 */
@Service
public class GoodsMapper {

    public GoodsMapper() {
    }

    public Goods toEntity(GoodsDTO dto) {
        if (dto == null) {
            return null;
        } else {
            Goods goods = new Goods();
            goods.setId(dto.getId());
            goods.setStoreId(dto.getStoreId());
            goods.setBrandId(dto.getBrandId());
            goods.setSalesModel(dto.getSalesModel());
            goods.setGoodsName(dto.getGoodsName());
            goods.setGoodsDesc(dto.getGoodsDesc());
            goods.setSpuNo(dto.getSpuNo());
            goods.setCategoryId(dto.getCategoryId());
            goods.setFreight(dto.getFreight());
            goods.setGoodsDetails(dto.getGoodsDetails());
            goods.setProposer(dto.getProposer());
            goods.setApplicationTime(dto.getApplicationTime());
            goods.setCheckStatus(dto.getCheckStatus());
            goods.setCheckFailureReasons(dto.getCheckFailureReasons());
            goods.setCheckTime(dto.getCheckTime());
            if (!CollectionUtils.isEmpty(dto.getGoodsPic())) {
                goods.setGoodsPic(JsonUtil.objectToJson(dto.getGoodsPic()));
            }

            goods.setDeleteFlag(dto.getDeleteFlag());
            goods.setSaleState(dto.getSaleState());
            goods.setCreateTime(dto.getCreateTime());
            goods.setGoodsNo(dto.getGoodsNo());

            return goods;
        }
    }

    public GoodsDTO toDto(Goods entity) {
        if (entity == null) {
            return null;
        } else {
            GoodsDTO goodsDTO = new GoodsDTO();
            goodsDTO.setId(entity.getId());
            goodsDTO.setStoreId(entity.getStoreId());
            goodsDTO.setBrandId(entity.getBrandId());
            goodsDTO.setSalesModel(entity.getSalesModel());
            goodsDTO.setGoodsName(entity.getGoodsName());
            goodsDTO.setGoodsDesc(entity.getGoodsDesc());
            goodsDTO.setSpuNo(entity.getSpuNo());
            goodsDTO.setCategoryId(entity.getCategoryId());
            goodsDTO.setFreight(entity.getFreight());
            goodsDTO.setGoodsDetails(entity.getGoodsDetails());
            goodsDTO.setProposer(entity.getProposer());
            goodsDTO.setApplicationTime(entity.getApplicationTime());
            goodsDTO.setCheckStatus(entity.getCheckStatus());
            goodsDTO.setCheckFailureReasons(entity.getCheckFailureReasons());
            goodsDTO.setCheckTime(entity.getCheckTime());
            if(!StringUtils.isEmpty(entity.getGoodsPic())){
                goodsDTO.setGoodsPic(CommonUtil.jsonStringConvertToList(entity.getGoodsPic(), String[].class));
            }
            goodsDTO.setDeleteFlag(entity.getDeleteFlag());
            goodsDTO.setSaleState(entity.getSaleState());
            goodsDTO.setCreateTime(entity.getCreateTime());
            goodsDTO.setGoodsNo(entity.getGoodsNo());
            return goodsDTO;
        }
    }

    public List<Goods> toEntity(List<GoodsDTO> dtoList) {
        if (dtoList == null) {
            return null;
        } else {
            List<Goods> list = new ArrayList(dtoList.size());
            Iterator var3 = dtoList.iterator();

            while (var3.hasNext()) {
                GoodsDTO goodsDTO = (GoodsDTO) var3.next();
                list.add(this.toEntity(goodsDTO));
            }

            return list;
        }
    }

    public List<GoodsDTO> toDto(List<Goods> entityList) {
        if (entityList == null) {
            return null;
        } else {
            List<GoodsDTO> list = new ArrayList(entityList.size());
            Iterator var3 = entityList.iterator();

            while (var3.hasNext()) {
                Goods goods = (Goods) var3.next();
                list.add(this.toDto(goods));
            }

            return list;
        }
    }
}

