package com.cross.merchants.service.mapper;


import com.cross.enumtype.PlatformSystemBannerPopSettingVM;
import com.cross.merchants.domain.*;
import com.cross.merchants.service.dto.BannerInfoDTO;

import com.cross.utils.JsonStringCovertUtil;
import com.cross.utils.JsonUtil;
import org.mapstruct.*;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Mapper for the entity {@link BannerInfo} and its DTO {@link BannerInfoDTO}.
 */
@Service
public class BannerInfoMapper  {

    public BannerInfoMapper() {
    }

    public BannerInfo toEntity(BannerInfoDTO dto) {
        if (dto == null) {
            return null;
        } else {
            BannerInfo bannerInfo = new BannerInfo();
            bannerInfo.setId(dto.getId());
            bannerInfo.setBannerType(dto.getBannerType());
            bannerInfo.setStoreId(dto.getStoreId());
            bannerInfo.setBrandId(dto.getBrandId());
            bannerInfo.setPositionType(dto.getPositionType());
            bannerInfo.setPositionCode(dto.getPositionCode());
            bannerInfo.setPictureName(dto.getPictureName());
            bannerInfo.setPictureUrl(dto.getPictureUrl());
            bannerInfo.setLinkType(dto.getLinkType());
            bannerInfo.setLinkAddress(dto.getLinkAddress());
            if (!CollectionUtils.isEmpty(dto.getBannerPopSetting())) {
                bannerInfo.setBannerPopSetting(JsonUtil.objectToJson(dto.getBannerPopSetting()));
            }
            bannerInfo.setShowState(dto.isShowState());
            bannerInfo.setTop(dto.isTop());
            bannerInfo.setBusinessId(dto.getBusinessId());
            bannerInfo.setSubPictureName(dto.getSubPictureName());
            return bannerInfo;
        }
    }

    public BannerInfoDTO toDto(BannerInfo entity) {
        if (entity == null) {
            return null;
        } else {
            BannerInfoDTO bannerInfoDTO = new BannerInfoDTO();
            bannerInfoDTO.setId(entity.getId());
            bannerInfoDTO.setBannerType(entity.getBannerType());
            bannerInfoDTO.setStoreId(entity.getStoreId());
            bannerInfoDTO.setBrandId(entity.getBrandId());
            bannerInfoDTO.setPositionType(entity.getPositionType());
            bannerInfoDTO.setPositionCode(entity.getPositionCode());
            bannerInfoDTO.setPictureName(entity.getPictureName());
            bannerInfoDTO.setPictureUrl(entity.getPictureUrl());
            bannerInfoDTO.setLinkType(entity.getLinkType());
            bannerInfoDTO.setLinkAddress(entity.getLinkAddress());
            if (!StringUtils.isEmpty(entity.getBannerPopSetting())) {
                bannerInfoDTO.setBannerPopSetting(JsonStringCovertUtil.jsonStringConvertToList(entity.getBannerPopSetting(), PlatformSystemBannerPopSettingVM[].class));
            }
            bannerInfoDTO.setShowState(entity.isShowState());
            bannerInfoDTO.setTop(entity.isTop());
            bannerInfoDTO.setBusinessId(entity.getBusinessId());
            bannerInfoDTO.setSubPictureName(entity.getSubPictureName());

            return bannerInfoDTO;
        }
    }

    public List<BannerInfo> toEntity(List<BannerInfoDTO> dtoList) {
        if (dtoList == null) {
            return null;
        } else {
            List<BannerInfo> list = new ArrayList(dtoList.size());
            Iterator var3 = dtoList.iterator();

            while(var3.hasNext()) {
                BannerInfoDTO bannerInfoDTO = (BannerInfoDTO)var3.next();
                list.add(this.toEntity(bannerInfoDTO));
            }

            return list;
        }
    }

    public List<BannerInfoDTO> toDto(List<BannerInfo> entityList) {
        if (entityList == null) {
            return null;
        } else {
            List<BannerInfoDTO> list = new ArrayList(entityList.size());
            Iterator var3 = entityList.iterator();

            while(var3.hasNext()) {
                BannerInfo bannerInfo = (BannerInfo)var3.next();
                list.add(this.toDto(bannerInfo));
            }

            return list;
        }
    }
}
