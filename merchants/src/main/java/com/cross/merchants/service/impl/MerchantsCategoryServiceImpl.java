package com.cross.merchants.service.impl;

import com.cross.merchants.service.MerchantsCategoryService;
import com.cross.merchants.domain.MerchantsCategory;
import com.cross.merchants.repository.MerchantsCategoryRepository;
import com.cross.merchants.service.dto.MerchantsCategoryDTO;
import com.cross.merchants.service.mapper.MerchantsCategoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link MerchantsCategory}.
 */
@Service
@Transactional
public class MerchantsCategoryServiceImpl implements MerchantsCategoryService {

    private final Logger log = LoggerFactory.getLogger(MerchantsCategoryServiceImpl.class);

    private final MerchantsCategoryRepository merchantsCategoryRepository;

    private final MerchantsCategoryMapper merchantsCategoryMapper;

    public MerchantsCategoryServiceImpl(MerchantsCategoryRepository merchantsCategoryRepository, MerchantsCategoryMapper merchantsCategoryMapper) {
        this.merchantsCategoryRepository = merchantsCategoryRepository;
        this.merchantsCategoryMapper = merchantsCategoryMapper;
    }

    /**
     * Save a merchantsCategory.
     *
     * @param merchantsCategoryDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public MerchantsCategoryDTO save(MerchantsCategoryDTO merchantsCategoryDTO) {
        log.debug("Request to save MerchantsCategory : {}", merchantsCategoryDTO);
        MerchantsCategory merchantsCategory = merchantsCategoryMapper.toEntity(merchantsCategoryDTO);
        merchantsCategory = merchantsCategoryRepository.save(merchantsCategory);
        return merchantsCategoryMapper.toDto(merchantsCategory);
    }

    /**
     * Get all the merchantsCategories.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<MerchantsCategoryDTO> findAll(Pageable pageable) {
        log.debug("Request to get all MerchantsCategories");
        return merchantsCategoryRepository.findAll(pageable)
            .map(merchantsCategoryMapper::toDto);
    }

    @Override
    public List<MerchantsCategoryDTO> findAllWithOrder(Pageable pageable, Boolean isDesc) {
        if (isDesc != null && isDesc) {
            return merchantsCategoryMapper.toDto(merchantsCategoryRepository.findAllInfoWithOrderDesc(pageable.getPageNumber() * pageable.getPageSize(), pageable.getPageSize()));
        } else {
            return merchantsCategoryMapper.toDto(merchantsCategoryRepository.findAllInfoWithOrderAsc(pageable.getPageNumber() * pageable.getPageSize(), pageable.getPageSize()));
        }

    }

    @Override
    public List<MerchantsCategoryDTO> findAll() {
        return merchantsCategoryMapper.toDto(merchantsCategoryRepository.findAll());
    }

    @Override
    public List<MerchantsCategoryDTO> findAllByIdIn(List<Long> ids) {
        return merchantsCategoryMapper.toDto(merchantsCategoryRepository.findAllByIdIn(ids));

    }

    /**
     * Get one merchantsCategory by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<MerchantsCategoryDTO> findOne(Long id) {
        log.debug("Request to get MerchantsCategory : {}", id);
        return merchantsCategoryRepository.findById(id)
            .map(merchantsCategoryMapper::toDto);
    }

    /**
     * Delete the merchantsCategory by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete MerchantsCategory : {}", id);
        merchantsCategoryRepository.deleteById(id);
    }

    @Override
    public long count() {
        return merchantsCategoryRepository.count();
    }
}
