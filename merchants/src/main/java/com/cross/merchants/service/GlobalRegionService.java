package com.cross.merchants.service;

import com.cross.merchants.service.dto.GlobalRegionDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.GlobalRegion}.
 */
public interface GlobalRegionService {

    /**
     * Save a globalRegion.
     *
     * @param globalRegionDTO the entity to save.
     * @return the persisted entity.
     */
    GlobalRegionDTO save(GlobalRegionDTO globalRegionDTO);

    /**
     * Get all the globalRegions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<GlobalRegionDTO> findAll(Pageable pageable);

    List<GlobalRegionDTO> findAll();


    /**
     * Get the "id" globalRegion.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<GlobalRegionDTO> findOne(Long id);

    /**
     * Delete the "id" globalRegion.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);


    List<GlobalRegionDTO> getAllByParentId(Long parentId);

    List<GlobalRegionDTO> getAllByLevel(Integer level);

    List<GlobalRegionDTO> findAllByIdIn(List<Long> ids);

}
