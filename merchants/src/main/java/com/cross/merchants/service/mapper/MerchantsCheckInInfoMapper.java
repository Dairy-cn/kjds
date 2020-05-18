package com.cross.merchants.service.mapper;


import com.cross.merchants.domain.*;
import com.cross.merchants.service.dto.*;

import com.cross.utils.CommonUtil;
import com.cross.utils.JsonUtil;
import org.mapstruct.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Mapper for the entity {@link MerchantsCheckInInfo} and its DTO {@link MerchantsCheckInInfoDTO}.
 */
@Service
public class MerchantsCheckInInfoMapper {


    public MerchantsCheckInInfoMapper() {
    }

    public MerchantsCheckInInfo toEntity(MerchantsCheckInInfoDTO dto) {
        if (dto == null) {
            return null;
        } else {
            MerchantsCheckInInfo merchantsCheckInInfo = new MerchantsCheckInInfo();
            BeanUtils.copyProperties(dto,merchantsCheckInInfo);
            if(!CollectionUtils.isEmpty(dto.getBusinessLicense())) {
                merchantsCheckInInfo.setBusinessLicense(JsonUtil.objectToJson(dto.getBusinessLicense()));
            }
            if(!ObjectUtils.isEmpty(dto.getDomesticEntrustedEnterpriseInfo())) {
                merchantsCheckInInfo.setDomesticEntrustedEnterpriseInfo(JsonUtil.objectToJson(dto.getDomesticEntrustedEnterpriseInfo()));
            }
            if(!ObjectUtils.isEmpty(dto.getCustomsRegistrationAndImportAndExportRecordReceipt())) {
                merchantsCheckInInfo.setCustomsRegistrationAndImportAndExportRecordReceipt(JsonUtil.objectToJson(dto.getCustomsRegistrationAndImportAndExportRecordReceipt()));
            } if(!ObjectUtils.isEmpty(dto.getCommitmentLetterOfDomesticEnterprise())) {
                merchantsCheckInInfo.setCommitmentLetterOfDomesticEnterprise(JsonUtil.objectToJson(dto.getCommitmentLetterOfDomesticEnterprise()));
            }
            return merchantsCheckInInfo;
        }
    }

    public MerchantsCheckInInfoDTO toDto(MerchantsCheckInInfo entity) {
        if (entity == null) {
            return null;
        } else {
            MerchantsCheckInInfoDTO merchantsCheckInInfoDTO = new MerchantsCheckInInfoDTO();
            BeanUtils.copyProperties(entity,merchantsCheckInInfoDTO);
            if(!StringUtils.isEmpty(entity.getBusinessLicense())){
                merchantsCheckInInfoDTO.setBusinessLicense(CommonUtil.jsonStringConvertToList(entity.getBusinessLicense(), String[].class));
            }
            if(!StringUtils.isEmpty(entity.getCommitmentLetterOfDomesticEnterprise())){
                merchantsCheckInInfoDTO.setCommitmentLetterOfDomesticEnterprise((CommitmentLetterOfDomesticEnterprise) JsonUtil.jsonToBean(entity.getCommitmentLetterOfDomesticEnterprise(), CommitmentLetterOfDomesticEnterprise.class));
            }
            if(!StringUtils.isEmpty(entity.getCustomsRegistrationAndImportAndExportRecordReceipt())){
                merchantsCheckInInfoDTO.setCustomsRegistrationAndImportAndExportRecordReceipt((CustomsRegistrationAndImportAndExportRecordReceipt) JsonUtil.jsonToBean(entity.getCustomsRegistrationAndImportAndExportRecordReceipt(), CustomsRegistrationAndImportAndExportRecordReceipt.class));
            }
            if(!StringUtils.isEmpty(entity.getDomesticEntrustedEnterpriseInfo())){
                merchantsCheckInInfoDTO.setDomesticEntrustedEnterpriseInfo((DomesticEntrustedEnterpriseInfo) JsonUtil.jsonToBean(entity.getDomesticEntrustedEnterpriseInfo(), DomesticEntrustedEnterpriseInfo.class));
            }
            return merchantsCheckInInfoDTO;
        }
    }

    public List<MerchantsCheckInInfo> toEntity(List<MerchantsCheckInInfoDTO> dtoList) {
        if (dtoList == null) {
            return null;
        } else {
            List<MerchantsCheckInInfo> list = new ArrayList(dtoList.size());
            Iterator var3 = dtoList.iterator();

            while(var3.hasNext()) {
                MerchantsCheckInInfoDTO dto = (MerchantsCheckInInfoDTO) var3.next();
                list.add(this.toEntity(dto));
            }

            return list;
        }
    }

    public List<MerchantsCheckInInfoDTO> toDto(List<MerchantsCheckInInfo> entityList) {
        if (entityList == null) {
            return null;
        } else {
            List<MerchantsCheckInInfoDTO> list = new ArrayList(entityList.size());
            Iterator var3 = entityList.iterator();

            while(var3.hasNext()) {
                MerchantsCheckInInfo entity = (MerchantsCheckInInfo)var3.next();
                list.add(this.toDto(entity));
            }
            return list;
        }
    }
}
