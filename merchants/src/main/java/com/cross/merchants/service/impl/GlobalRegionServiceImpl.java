package com.cross.merchants.service.impl;

import com.cross.merchants.service.GlobalRegionService;
import com.cross.merchants.domain.GlobalRegion;
import com.cross.merchants.repository.GlobalRegionRepository;
import com.cross.merchants.service.dto.GlobalRegionDTO;
import com.cross.merchants.service.mapper.GlobalRegionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link GlobalRegion}.
 */
@Service
@Transactional
public class GlobalRegionServiceImpl implements GlobalRegionService {

    private final Logger log = LoggerFactory.getLogger(GlobalRegionServiceImpl.class);

    private final GlobalRegionRepository globalRegionRepository;

    private final GlobalRegionMapper globalRegionMapper;

    public GlobalRegionServiceImpl(GlobalRegionRepository globalRegionRepository, GlobalRegionMapper globalRegionMapper) {
        this.globalRegionRepository = globalRegionRepository;
        this.globalRegionMapper = globalRegionMapper;
    }

    /**
     * Save a globalRegion.
     *
     * @param globalRegionDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public GlobalRegionDTO save(GlobalRegionDTO globalRegionDTO) {
        log.debug("Request to save GlobalRegion : {}", globalRegionDTO);
        GlobalRegion globalRegion = globalRegionMapper.toEntity(globalRegionDTO);
        globalRegion = globalRegionRepository.save(globalRegion);
        return globalRegionMapper.toDto(globalRegion);
    }

    /**
     * Get all the globalRegions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<GlobalRegionDTO> findAll(Pageable pageable) {
        log.debug("Request to get all GlobalRegions");
        return globalRegionRepository.findAll(pageable)
            .map(globalRegionMapper::toDto);
    }

    /**
     * Get one globalRegion by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<GlobalRegionDTO> findOne(Long id) {
        log.debug("Request to get GlobalRegion : {}", id);
        return globalRegionRepository.findById(id)
            .map(globalRegionMapper::toDto);
    }

    /**
     * Delete the globalRegion by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete GlobalRegion : {}", id);
        globalRegionRepository.deleteById(id);
    }

    @Override
    public List<GlobalRegionDTO> getAllByParentId(Long parentId) {
        return globalRegionMapper.toDto(globalRegionRepository.getAllByPid(parentId));
    }

    @Override
    public List<GlobalRegionDTO> getAllByLevel(Integer level) {
        return globalRegionMapper.toDto(globalRegionRepository.getAllByLevel(level));

    }

    @Override
    public List<GlobalRegionDTO> findAllByIdIn(List<Long> ids) {
        return globalRegionMapper.toDto(globalRegionRepository.findAllByIdIn(ids));
    }
}
