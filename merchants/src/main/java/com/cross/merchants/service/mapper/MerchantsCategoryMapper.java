package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.*;
import com.cross.merchants.service.dto.MerchantsCategoryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link MerchantsCategory} and its DTO {@link MerchantsCategoryDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MerchantsCategoryMapper extends EntityMapper<MerchantsCategoryDTO, MerchantsCategory> {



    default MerchantsCategory fromId(Long id) {
        if (id == null) {
            return null;
        }
        MerchantsCategory merchantsCategory = new MerchantsCategory();
        merchantsCategory.setId(id);
        return merchantsCategory;
    }
}
