package com.cross.merchants.service.impl;

import com.cross.merchants.service.BankInfoService;
import com.cross.merchants.domain.BankInfo;
import com.cross.merchants.repository.BankInfoRepository;
import com.cross.merchants.service.dto.BankInfoDTO;
import com.cross.merchants.service.mapper.BankInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link BankInfo}.
 */
@Service
@Transactional
public class BankInfoServiceImpl implements BankInfoService {

    private final Logger log = LoggerFactory.getLogger(BankInfoServiceImpl.class);

    private final BankInfoRepository bankInfoRepository;

    private final BankInfoMapper bankInfoMapper;

    public BankInfoServiceImpl(BankInfoRepository bankInfoRepository, BankInfoMapper bankInfoMapper) {
        this.bankInfoRepository = bankInfoRepository;
        this.bankInfoMapper = bankInfoMapper;
    }

    /**
     * Save a bankInfo.
     *
     * @param bankInfoDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public BankInfoDTO save(BankInfoDTO bankInfoDTO) {
        log.debug("Request to save BankInfo : {}", bankInfoDTO);
        BankInfo bankInfo = bankInfoMapper.toEntity(bankInfoDTO);
        bankInfo = bankInfoRepository.save(bankInfo);
        return bankInfoMapper.toDto(bankInfo);
    }

    /**
     * Get all the bankInfos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BankInfoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all BankInfos");
        return bankInfoRepository.findAll(pageable)
            .map(bankInfoMapper::toDto);
    }

    /**
     * Get one bankInfo by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BankInfoDTO> findOne(Long id) {
        log.debug("Request to get BankInfo : {}", id);
        return bankInfoRepository.findById(id)
            .map(bankInfoMapper::toDto);
    }

    /**
     * Delete the bankInfo by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BankInfo : {}", id);
        bankInfoRepository.deleteById(id);
    }

    @Override
    public List<BankInfoDTO> findAll() {
        return bankInfoMapper.toDto(bankInfoRepository.findAll());
    }

    @Override
    public List<BankInfoDTO> findAllByIdIn(List<Long> ids) {
        return bankInfoMapper.toDto(bankInfoRepository.findAllByIdIn(ids));
    }
}
