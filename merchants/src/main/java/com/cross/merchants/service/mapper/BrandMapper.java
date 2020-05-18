package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.*;
import com.cross.merchants.service.dto.BrandDTO;

import com.cross.merchants.service.dto.OwerOfAttorneyDTO;
import com.cross.utils.CommonUtil;
import com.cross.utils.JsonUtil;
import org.mapstruct.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Mapper for the entity {@link Brand} and its DTO {@link BrandDTO}.
 */
@Service
public class BrandMapper  {



    public BrandMapper() {
    }

    public Brand toEntity(BrandDTO dto) {
        if (dto == null) {
            return null;
        } else {
            Brand brand = new Brand();
            BeanUtils.copyProperties(dto,brand);
            if(!CollectionUtils.isEmpty(dto.getOwerOfAttorney())) {
                brand.setOwerOfAttorney(JsonUtil.objectToJson(dto.getOwerOfAttorney()));
            }
            if(!CollectionUtils.isEmpty(dto.getTradeMarkRegistrationPic())) {
                brand.setTradeMarkRegistrationPic(JsonUtil.objectToJson(dto.getTradeMarkRegistrationPic()));
            }
            return brand;
        }
    }

    public BrandDTO toDto(Brand entity) {
        if (entity == null) {
            return null;
        } else {
            BrandDTO brandDTO = new BrandDTO();
           BeanUtils.copyProperties(entity,brandDTO);
            if(!StringUtils.isEmpty(entity.getOwerOfAttorney())){
                brandDTO.setOwerOfAttorney(CommonUtil.jsonStringConvertToList(entity.getOwerOfAttorney(), OwerOfAttorneyDTO[].class));
            }
            if(!StringUtils.isEmpty(entity.getTradeMarkRegistrationPic())){
                brandDTO.setTradeMarkRegistrationPic(CommonUtil.jsonStringConvertToList(entity.getTradeMarkRegistrationPic(), String[].class));
            }
            return brandDTO;
        }
    }

    public List<Brand> toEntity(List<BrandDTO> dtoList) {
        if (dtoList == null) {
            return null;
        } else {
            List<Brand> list = new ArrayList(dtoList.size());
            Iterator var3 = dtoList.iterator();

            while(var3.hasNext()) {
                BrandDTO brandDTO = (BrandDTO)var3.next();
                list.add(this.toEntity(brandDTO));
            }

            return list;
        }
    }

    public List<BrandDTO> toDto(List<Brand> entityList) {
        if (entityList == null) {
            return null;
        } else {
            List<BrandDTO> list = new ArrayList(entityList.size());
            Iterator var3 = entityList.iterator();

            while(var3.hasNext()) {
                Brand brand = (Brand)var3.next();
                list.add(this.toDto(brand));
            }
            return list;
        }
    }
}
