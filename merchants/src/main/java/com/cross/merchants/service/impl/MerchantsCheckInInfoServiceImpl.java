package com.cross.merchants.service.impl;

import com.cross.merchants.domain.StoreInfo;
import com.cross.merchants.repository.StoreInfoRepository;
import com.cross.merchants.service.MerchantsCheckInInfoService;
import com.cross.merchants.domain.MerchantsCheckInInfo;
import com.cross.merchants.repository.MerchantsCheckInInfoRepository;
import com.cross.merchants.service.dto.MerchantsCheckInInfoDTO;
import com.cross.merchants.service.mapper.MerchantsCheckInInfoMapper;
import com.cross.merchants.web.rest.vm.MerchantsCategoryCountVM;
import com.cross.utils.JpaSelectCastEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Service Implementation for managing {@link MerchantsCheckInInfo}.
 */
@Service
@Transactional
public class MerchantsCheckInInfoServiceImpl implements MerchantsCheckInInfoService {

    private final Logger log = LoggerFactory.getLogger(MerchantsCheckInInfoServiceImpl.class);

    private final MerchantsCheckInInfoRepository merchantsCheckInInfoRepository;

    private final MerchantsCheckInInfoMapper merchantsCheckInInfoMapper;

    private final StoreInfoRepository storeInfoRepository;




    public MerchantsCheckInInfoServiceImpl(MerchantsCheckInInfoRepository merchantsCheckInInfoRepository, MerchantsCheckInInfoMapper merchantsCheckInInfoMapper, StoreInfoRepository storeInfoRepository) {
        this.merchantsCheckInInfoRepository = merchantsCheckInInfoRepository;
        this.merchantsCheckInInfoMapper = merchantsCheckInInfoMapper;
        this.storeInfoRepository = storeInfoRepository;
    }

    /**
     * Save a merchantsCheckInInfo.
     *
     * @param merchantsCheckInInfoDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public MerchantsCheckInInfoDTO save(MerchantsCheckInInfoDTO merchantsCheckInInfoDTO) {
        log.debug("Request to save MerchantsCheckInInfo : {}", merchantsCheckInInfoDTO);
        MerchantsCheckInInfo merchantsCheckInInfo = merchantsCheckInInfoMapper.toEntity(merchantsCheckInInfoDTO);
        merchantsCheckInInfo = merchantsCheckInInfoRepository.save(merchantsCheckInInfo);
        return merchantsCheckInInfoMapper.toDto(merchantsCheckInInfo);
    }

    /**
     * Get all the merchantsCheckInInfos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<MerchantsCheckInInfoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all MerchantsCheckInInfos");
        return merchantsCheckInInfoRepository.findAll(pageable)
            .map(merchantsCheckInInfoMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<MerchantsCheckInInfoDTO> findAllWithWaitCheckIn(Pageable pageable) {
        log.debug("Request to get all MerchantsCheckInInfos");
        return merchantsCheckInInfoRepository.findAllByCheckStatus(pageable, -1)
            .map(merchantsCheckInInfoMapper::toDto);
    }

    /**
     * Get one merchantsCheckInInfo by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<MerchantsCheckInInfoDTO> findOne(Long id) {
        log.debug("Request to get MerchantsCheckInInfo : {}", id);
        return merchantsCheckInInfoRepository.findById(id)
            .map(merchantsCheckInInfoMapper::toDto);
    }

    /**
     * Delete the merchantsCheckInInfo by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete MerchantsCheckInInfo : {}", id);
        merchantsCheckInInfoRepository.deleteById(id);
    }

    @Override
    public Map<Long, Integer> countMerchantsWithCategoryIds(List<Long> categoryIds) {
        List<Object[]> list = storeInfoRepository.countMerchantsWithCategoryIds(categoryIds);
        List<MerchantsCategoryCountVM> merchantsCategoryCount = new ArrayList<>();
        try {
            merchantsCategoryCount = JpaSelectCastEntity.castEntity(list, MerchantsCategoryCountVM.class);
        } catch (Exception e1) {
            log.error("类转化失败" + e1.getMessage());
            e1.printStackTrace();
        }
        Map<Long, Integer> map = new HashMap<>(16);
        merchantsCategoryCount.stream().forEach(e -> {
            map.put(e.getCategoryId().longValue(), e.getCount().intValue());
        });
        return map;
    }

    @Override
    public MerchantsCheckInInfoDTO findOneWithSelf(Long submitId) {
        MerchantsCheckInInfo firstByProposer = merchantsCheckInInfoRepository.findFirstByProposer(submitId);
        return merchantsCheckInInfoMapper.toDto(firstByProposer);
    }

    @Override
    public MerchantsCheckInInfoDTO findOneWithSelfByCheckState(Long submitId,Integer state) {
        MerchantsCheckInInfo firstByProposer = merchantsCheckInInfoRepository.findFirstByProposerAndCheckStatus(submitId,state);
        return merchantsCheckInInfoMapper.toDto(firstByProposer);
    }

    @Override
    @Transactional
    public MerchantsCheckInInfoDTO merchantsCheckInInfo(MerchantsCheckInInfoDTO merchantsCheckInInfoDTO) {
        MerchantsCheckInInfoDTO save = this.save(merchantsCheckInInfoDTO);
        //审核成功 添加店铺信息
        if(1==save.getCheckStatus()){
            StoreInfo storeInfo = new StoreInfo();
            storeInfo.setCategoryId(merchantsCheckInInfoDTO.getCategoryId());
            storeInfo.setMerchantsCheckInInfoId(save.getId());
            storeInfo.setCreateUserId(save.getProposer());
            storeInfo.setCompanyName(save.getCompanyName());
            storeInfoRepository.save(storeInfo);
        }
        return save;
    }

    @Override
    public List<MerchantsCheckInInfoDTO> findAllByIdIn(List<Long> ids) {
        return merchantsCheckInInfoMapper.toDto(merchantsCheckInInfoRepository.findAllByIdIn(ids));
    }

    @Override
    public long countByCategoryId(Long categoryId) {
        return merchantsCheckInInfoRepository.countAllByCategoryId(categoryId);
    }
}
