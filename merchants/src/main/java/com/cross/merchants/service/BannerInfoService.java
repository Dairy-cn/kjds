package com.cross.merchants.service;

import com.cross.merchants.domain.BannerInfo;
import com.cross.merchants.service.dto.BannerInfoDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.BannerInfo}.
 */
public interface BannerInfoService {

    /**
     * Save a bannerInfo.
     *
     * @param bannerInfoDTO the entity to save.
     * @return the persisted entity.
     */
    BannerInfoDTO save(BannerInfoDTO bannerInfoDTO);

    /**
     * Get all the bannerInfos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<BannerInfoDTO> findAll(Pageable pageable);

    /**
     * Get the "id" bannerInfo.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BannerInfoDTO> findOne(Long id);

    /**
     * Delete the "id" bannerInfo.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);


    List<BannerInfoDTO> findAllByCondition(Integer positionType);

    List<BannerInfoDTO> findAllByBannerType(Integer bannerType);



    List<BannerInfoDTO> findAllByStoreId(Long storeId);

    BannerInfoDTO getOne(Long id);


    boolean updateBannerInfoTopStateByPlatform(Long id);


    boolean updateBannerInfoTopStateByMerchant(Long id);
}
