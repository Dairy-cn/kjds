package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.*;
import com.cross.merchants.service.dto.BankInfoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link BankInfo} and its DTO {@link BankInfoDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BankInfoMapper extends EntityMapper<BankInfoDTO, BankInfo> {



    default BankInfo fromId(Long id) {
        if (id == null) {
            return null;
        }
        BankInfo bankInfo = new BankInfo();
        bankInfo.setId(id);
        return bankInfo;
    }
}
