package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.*;
import com.cross.merchants.service.dto.EnterpriseInfoDTO;

import com.cross.utils.CommonUtil;
import com.cross.utils.JsonUtil;
import org.mapstruct.*;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Mapper for the entity {@link EnterpriseInfo} and its DTO {@link EnterpriseInfoDTO}.
 */
@Service
public class EnterpriseInfoMapper {

    public EnterpriseInfoMapper() {
    }

    public EnterpriseInfo toEntity(EnterpriseInfoDTO dto) {
        if (dto == null) {
            return null;
        } else {
            EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
            enterpriseInfo.setId(dto.getId());
            enterpriseInfo.setMerchantId(dto.getMerchantId());
            enterpriseInfo.setOpenBankName(dto.getOpenBankName());
            if(!CollectionUtils.isEmpty(dto.getOpenAccountPic())){
                enterpriseInfo.setOpenAccountPic(JsonUtil.objectToJson(dto.getOpenAccountPic()));
            }
            enterpriseInfo.setBankId(dto.getBankId());
            enterpriseInfo.setForCorporateBankAccountNumber(dto.getForCorporateBankAccountNumber());
            enterpriseInfo.setBankBranch(dto.getBankBranch());
            enterpriseInfo.setProvinceId(dto.getProvinceId());
            enterpriseInfo.setCityId(dto.getCityId());
            enterpriseInfo.setCountryId(dto.getCountryId());
            enterpriseInfo.setProvince(dto.getProvince());
            enterpriseInfo.setCity(dto.getCity());
            enterpriseInfo.setCountry(dto.getCountry());
            enterpriseInfo.setAddress(dto.getAddress());
            enterpriseInfo.setInvoiceType(dto.getInvoiceType());
            enterpriseInfo.setFinancialContactNumber(dto.getFinancialContactNumber());
            return enterpriseInfo;
        }
    }

    public EnterpriseInfoDTO toDto(EnterpriseInfo entity) {
        if (entity == null) {
            return null;
        } else {
            EnterpriseInfoDTO enterpriseInfoDTO = new EnterpriseInfoDTO();
            enterpriseInfoDTO.setId(entity.getId());
            enterpriseInfoDTO.setMerchantId(entity.getMerchantId());
            enterpriseInfoDTO.setOpenBankName(entity.getOpenBankName());
            if(!StringUtils.isEmpty(entity.getOpenAccountPic())){
                enterpriseInfoDTO.setOpenAccountPic(CommonUtil.jsonStringConvertToList(entity.getOpenAccountPic(), String[].class));
            }
            enterpriseInfoDTO.setBankId(entity.getBankId());
            enterpriseInfoDTO.setForCorporateBankAccountNumber(entity.getForCorporateBankAccountNumber());
            enterpriseInfoDTO.setBankBranch(entity.getBankBranch());
            enterpriseInfoDTO.setProvinceId(entity.getProvinceId());
            enterpriseInfoDTO.setCityId(entity.getCityId());
            enterpriseInfoDTO.setCountryId(entity.getCountryId());
            enterpriseInfoDTO.setProvince(entity.getProvince());
            enterpriseInfoDTO.setCity(entity.getCity());
            enterpriseInfoDTO.setCountry(entity.getCountry());
            enterpriseInfoDTO.setAddress(entity.getAddress());
            enterpriseInfoDTO.setInvoiceType(entity.getInvoiceType());
            enterpriseInfoDTO.setFinancialContactNumber(entity.getFinancialContactNumber());
            return enterpriseInfoDTO;
        }
    }

    public List<EnterpriseInfo> toEntity(List<EnterpriseInfoDTO> dtoList) {
        if (dtoList == null) {
            return null;
        } else {
            List<EnterpriseInfo> list = new ArrayList(dtoList.size());
            Iterator var3 = dtoList.iterator();

            while(var3.hasNext()) {
                EnterpriseInfoDTO enterpriseInfoDTO = (EnterpriseInfoDTO)var3.next();
                list.add(this.toEntity(enterpriseInfoDTO));
            }

            return list;
        }
    }

    public List<EnterpriseInfoDTO> toDto(List<EnterpriseInfo> entityList) {
        if (entityList == null) {
            return null;
        } else {
            List<EnterpriseInfoDTO> list = new ArrayList(entityList.size());
            Iterator var3 = entityList.iterator();

            while(var3.hasNext()) {
                EnterpriseInfo enterpriseInfo = (EnterpriseInfo)var3.next();
                list.add(this.toDto(enterpriseInfo));
            }

            return list;
        }
    }
}
