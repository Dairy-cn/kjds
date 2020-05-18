package com.cross.merchants.service.impl;

import com.cross.merchants.domain.StoreOperatingRecord;
import com.cross.merchants.repository.StoreOperatingRecordRepository;
import com.cross.merchants.service.StoreInfoService;
import com.cross.merchants.domain.StoreInfo;
import com.cross.merchants.repository.StoreInfoRepository;
import com.cross.merchants.service.dto.StoreInfoDTO;
import com.cross.merchants.service.mapper.StoreInfoMapper;
import com.cross.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link StoreInfo}.
 */
@Service
@Transactional
public class StoreInfoServiceImpl implements StoreInfoService {

    private final Logger log = LoggerFactory.getLogger(StoreInfoServiceImpl.class);

    private final StoreInfoRepository storeInfoRepository;

    private final StoreInfoMapper storeInfoMapper;

    private final StoreOperatingRecordRepository storeOperatingRecordRepository;

    public StoreInfoServiceImpl(StoreInfoRepository storeInfoRepository, StoreInfoMapper storeInfoMapper, StoreOperatingRecordRepository storeOperatingRecordRepository) {
        this.storeInfoRepository = storeInfoRepository;
        this.storeInfoMapper = storeInfoMapper;
        this.storeOperatingRecordRepository = storeOperatingRecordRepository;
    }

    /**
     * Save a storeInfo.
     *
     * @param storeInfoDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public StoreInfoDTO save(StoreInfoDTO storeInfoDTO) {
        log.debug("Request to save StoreInfo : {}", storeInfoDTO);
        StoreInfo storeInfo = storeInfoMapper.toEntity(storeInfoDTO);
        storeInfo = storeInfoRepository.save(storeInfo);
        return storeInfoMapper.toDto(storeInfo);
    }

    /**
     * Get all the storeInfos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<StoreInfoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all StoreInfos");
        return storeInfoRepository.findAll(pageable)
            .map(storeInfoMapper::toDto);
    }

    /**
     * Get one storeInfo by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<StoreInfoDTO> findOne(Long id) {
        log.debug("Request to get StoreInfo : {}", id);
        return storeInfoRepository.findById(id)
            .map(storeInfoMapper::toDto);
    }

    /**
     * Delete the storeInfo by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete StoreInfo : {}", id);
        storeInfoRepository.deleteById(id);
    }

    @Override
    public List<StoreInfoDTO> findAllByCategoryId(Long categoryId) {
        List<StoreInfo> storeInfoList = storeInfoRepository.findAllByCategoryId(categoryId);
        return storeInfoMapper.toDto(storeInfoList);
    }

    @Override
    @Transactional
    public StoreInfoDTO updateStoreOperatingStatusInfoWithMerchants(Long id, Integer status) {
        StoreInfo storeInfo = storeInfoRepository.getOne(id);
        if (storeInfo != null) {
            storeInfo.setOperatingStatus(status);
            storeInfo = storeInfoRepository.save(storeInfo);
            StoreOperatingRecord storeOperatingRecord = new StoreOperatingRecord();
            if (0 == status) {
                storeOperatingRecord.setCloseOfParty(1);
                storeOperatingRecord.setCloseOfWho(CommonUtil.getCurrentLoginUser().getId());
                storeOperatingRecord.setCloseReason(null);
                storeOperatingRecord.setCloseTime(Instant.now());
            } else {
                storeOperatingRecord.openOfWho(CommonUtil.getCurrentLoginUser().getId());
                storeOperatingRecord.setOpenTime(Instant.now());
            }
            storeOperatingRecord.setStoreId(storeInfo.getId());
            storeOperatingRecord.setOperatingStatus(status);
            StoreOperatingRecord save = storeOperatingRecordRepository.save(storeOperatingRecord);

            return storeInfoMapper.toDto(storeInfo);
        }

        return null;
    }

    @Override
    public StoreInfoDTO updateStoreOperatingStatusInfoWithPlatform(Long id, Integer status,String closeReason) {
        StoreInfo storeInfo = storeInfoRepository.getOne(id);
        if (storeInfo != null) {
            storeInfo.setOperatingStatus(status);
            storeInfo = storeInfoRepository.save(storeInfo);
            StoreOperatingRecord storeOperatingRecord = new StoreOperatingRecord();
            if (0 == status) {
                storeOperatingRecord.setCloseOfParty(2);
                storeOperatingRecord.setCloseOfWho(CommonUtil.getCurrentLoginUser().getId());
                storeOperatingRecord.setCloseReason(closeReason);
                storeOperatingRecord.setCloseTime(Instant.now());
            } else {
                storeOperatingRecord.openOfWho(CommonUtil.getCurrentLoginUser().getId());
                storeOperatingRecord.setOpenTime(Instant.now());
            }
            storeOperatingRecord.setStoreId(storeInfo.getId());
            storeOperatingRecord.setOperatingStatus(status);
            StoreOperatingRecord save = storeOperatingRecordRepository.save(storeOperatingRecord);

            return storeInfoMapper.toDto(storeInfo);
        }

        return null;
    }

    @Override
    public StoreInfoDTO findByCreateUserId(Long userId) {
        return storeInfoMapper.toDto(storeInfoRepository.findFirstByCreateUserId(userId));
    }
}
