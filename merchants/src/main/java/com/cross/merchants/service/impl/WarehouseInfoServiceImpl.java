package com.cross.merchants.service.impl;

import com.cross.merchants.service.WarehouseInfoService;
import com.cross.merchants.domain.WarehouseInfo;
import com.cross.merchants.repository.WarehouseInfoRepository;
import com.cross.merchants.service.dto.WarehouseInfoDTO;
import com.cross.merchants.service.mapper.WarehouseInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link WarehouseInfo}.
 */
@Service
@Transactional
public class WarehouseInfoServiceImpl implements WarehouseInfoService {

    private final Logger log = LoggerFactory.getLogger(WarehouseInfoServiceImpl.class);

    private final WarehouseInfoRepository warehouseInfoRepository;

    private final WarehouseInfoMapper warehouseInfoMapper;

    public WarehouseInfoServiceImpl(WarehouseInfoRepository warehouseInfoRepository, WarehouseInfoMapper warehouseInfoMapper) {
        this.warehouseInfoRepository = warehouseInfoRepository;
        this.warehouseInfoMapper = warehouseInfoMapper;
    }

    /**
     * Save a warehouseInfo.
     *
     * @param warehouseInfoDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public WarehouseInfoDTO save(WarehouseInfoDTO warehouseInfoDTO) {
        log.debug("Request to save WarehouseInfo : {}", warehouseInfoDTO);
        WarehouseInfo warehouseInfo = warehouseInfoMapper.toEntity(warehouseInfoDTO);
        warehouseInfo = warehouseInfoRepository.save(warehouseInfo);
        return warehouseInfoMapper.toDto(warehouseInfo);
    }

    /**
     * Get all the warehouseInfos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<WarehouseInfoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all WarehouseInfos");
        return warehouseInfoRepository.findAll(pageable)
            .map(warehouseInfoMapper::toDto);
    }

    /**
     * Get one warehouseInfo by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<WarehouseInfoDTO> findOne(Long id) {
        log.debug("Request to get WarehouseInfo : {}", id);
        return warehouseInfoRepository.findById(id)
            .map(warehouseInfoMapper::toDto);
    }

    /**
     * Delete the warehouseInfo by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete WarehouseInfo : {}", id);
        warehouseInfoRepository.deleteById(id);
    }

    @Override
    public WarehouseInfoDTO findFristByMerchantId(Long merchantId) {
        return warehouseInfoMapper.toDto(warehouseInfoRepository.findFirstByMerchantId(merchantId));
    }

    @Override
    public List<WarehouseInfoDTO> findAllByMerchantIdIn(List<Long> merchantIds) {
        return warehouseInfoMapper.toDto(warehouseInfoRepository.findAllByMerchantIdIn(merchantIds));
    }
}
