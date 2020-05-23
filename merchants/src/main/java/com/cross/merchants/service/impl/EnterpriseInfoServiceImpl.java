package com.cross.merchants.service.impl;

import com.cross.merchants.service.EnterpriseInfoService;
import com.cross.merchants.domain.EnterpriseInfo;
import com.cross.merchants.repository.EnterpriseInfoRepository;
import com.cross.merchants.service.dto.EnterpriseInfoDTO;
import com.cross.merchants.service.mapper.EnterpriseInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link EnterpriseInfo}.
 */
@Service
@Transactional
public class EnterpriseInfoServiceImpl implements EnterpriseInfoService {

    private final Logger log = LoggerFactory.getLogger(EnterpriseInfoServiceImpl.class);

    private final EnterpriseInfoRepository enterpriseInfoRepository;

    private final EnterpriseInfoMapper enterpriseInfoMapper;

    public EnterpriseInfoServiceImpl(EnterpriseInfoRepository enterpriseInfoRepository, EnterpriseInfoMapper enterpriseInfoMapper) {
        this.enterpriseInfoRepository = enterpriseInfoRepository;
        this.enterpriseInfoMapper = enterpriseInfoMapper;
    }

    /**
     * Save a enterpriseInfo.
     *
     * @param enterpriseInfoDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public EnterpriseInfoDTO save(EnterpriseInfoDTO enterpriseInfoDTO) {
        log.debug("Request to save EnterpriseInfo : {}", enterpriseInfoDTO);
        EnterpriseInfo enterpriseInfo = enterpriseInfoMapper.toEntity(enterpriseInfoDTO);
        enterpriseInfo = enterpriseInfoRepository.save(enterpriseInfo);
        return enterpriseInfoMapper.toDto(enterpriseInfo);
    }

    /**
     * Get all the enterpriseInfos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<EnterpriseInfoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all EnterpriseInfos");
        return enterpriseInfoRepository.findAll(pageable)
            .map(enterpriseInfoMapper::toDto);
    }

    /**
     * Get one enterpriseInfo by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<EnterpriseInfoDTO> findOne(Long id) {
        log.debug("Request to get EnterpriseInfo : {}", id);
        return enterpriseInfoRepository.findById(id)
            .map(enterpriseInfoMapper::toDto);
    }

    /**
     * Delete the enterpriseInfo by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete EnterpriseInfo : {}", id);
        enterpriseInfoRepository.deleteById(id);
    }

    @Override
    public EnterpriseInfoDTO findFristByMerchantId(Long merchantId) {
        return enterpriseInfoMapper.toDto(enterpriseInfoRepository.findFirstByMerchantId(merchantId));
    }
}
