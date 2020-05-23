package com.cross.merchants.service.impl;

import com.cross.merchants.service.SystemInfoService;
import com.cross.merchants.domain.SystemInfo;
import com.cross.merchants.repository.SystemInfoRepository;
import com.cross.merchants.service.dto.SystemInfoDTO;
import com.cross.merchants.service.mapper.SystemInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link SystemInfo}.
 */
@Service
@Transactional
public class SystemInfoServiceImpl implements SystemInfoService {

    private final Logger log = LoggerFactory.getLogger(SystemInfoServiceImpl.class);

    private final SystemInfoRepository systemInfoRepository;

    private final SystemInfoMapper systemInfoMapper;

    public SystemInfoServiceImpl(SystemInfoRepository systemInfoRepository, SystemInfoMapper systemInfoMapper) {
        this.systemInfoRepository = systemInfoRepository;
        this.systemInfoMapper = systemInfoMapper;
    }

    /**
     * Save a systemInfo.
     *
     * @param systemInfoDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public SystemInfoDTO save(SystemInfoDTO systemInfoDTO) {
        log.debug("Request to save SystemInfo : {}", systemInfoDTO);
        SystemInfo systemInfo = systemInfoMapper.toEntity(systemInfoDTO);
        systemInfo = systemInfoRepository.save(systemInfo);
        return systemInfoMapper.toDto(systemInfo);
    }

    /**
     * Get all the systemInfos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SystemInfoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all SystemInfos");
        return systemInfoRepository.findAll(pageable)
            .map(systemInfoMapper::toDto);
    }

    /**
     * Get one systemInfo by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<SystemInfoDTO> findOne(Long id) {
        log.debug("Request to get SystemInfo : {}", id);
        return systemInfoRepository.findById(id)
            .map(systemInfoMapper::toDto);
    }

    /**
     * Delete the systemInfo by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SystemInfo : {}", id);
        systemInfoRepository.deleteById(id);
    }
}
