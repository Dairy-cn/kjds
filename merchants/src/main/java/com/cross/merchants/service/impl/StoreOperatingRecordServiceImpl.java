package com.cross.merchants.service.impl;

import com.cross.merchants.service.StoreOperatingRecordService;
import com.cross.merchants.domain.StoreOperatingRecord;
import com.cross.merchants.repository.StoreOperatingRecordRepository;
import com.cross.merchants.service.dto.StoreOperatingRecordDTO;
import com.cross.merchants.service.mapper.StoreOperatingRecordMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link StoreOperatingRecord}.
 */
@Service
@Transactional
public class StoreOperatingRecordServiceImpl implements StoreOperatingRecordService {

    private final Logger log = LoggerFactory.getLogger(StoreOperatingRecordServiceImpl.class);

    private final StoreOperatingRecordRepository storeOperatingRecordRepository;

    private final StoreOperatingRecordMapper storeOperatingRecordMapper;

    public StoreOperatingRecordServiceImpl(StoreOperatingRecordRepository storeOperatingRecordRepository, StoreOperatingRecordMapper storeOperatingRecordMapper) {
        this.storeOperatingRecordRepository = storeOperatingRecordRepository;
        this.storeOperatingRecordMapper = storeOperatingRecordMapper;
    }

    /**
     * Save a storeOperatingRecord.
     *
     * @param storeOperatingRecordDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public StoreOperatingRecordDTO save(StoreOperatingRecordDTO storeOperatingRecordDTO) {
        log.debug("Request to save StoreOperatingRecord : {}", storeOperatingRecordDTO);
        StoreOperatingRecord storeOperatingRecord = storeOperatingRecordMapper.toEntity(storeOperatingRecordDTO);
        storeOperatingRecord = storeOperatingRecordRepository.save(storeOperatingRecord);
        return storeOperatingRecordMapper.toDto(storeOperatingRecord);
    }

    /**
     * Get all the storeOperatingRecords.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<StoreOperatingRecordDTO> findAll(Pageable pageable) {
        log.debug("Request to get all StoreOperatingRecords");
        return storeOperatingRecordRepository.findAll(pageable)
            .map(storeOperatingRecordMapper::toDto);
    }

    /**
     * Get one storeOperatingRecord by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<StoreOperatingRecordDTO> findOne(Long id) {
        log.debug("Request to get StoreOperatingRecord : {}", id);
        return storeOperatingRecordRepository.findById(id)
            .map(storeOperatingRecordMapper::toDto);
    }

    /**
     * Delete the storeOperatingRecord by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete StoreOperatingRecord : {}", id);
        storeOperatingRecordRepository.deleteById(id);
    }

    @Override
    public Page<StoreOperatingRecordDTO> findAllAndStoreId(Pageable pageable, Long storeId) {
        return storeOperatingRecordRepository.findAllByStoreId(pageable,storeId)
            .map(storeOperatingRecordMapper::toDto);
    }
}
