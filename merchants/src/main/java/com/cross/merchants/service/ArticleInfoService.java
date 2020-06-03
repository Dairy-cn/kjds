package com.cross.merchants.service;

import com.cross.merchants.service.dto.ArticleInfoDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.cross.merchants.domain.ArticleInfo}.
 */
public interface ArticleInfoService {

    /**
     * Save a articleInfo.
     *
     * @param articleInfoDTO the entity to save.
     * @return the persisted entity.
     */
    ArticleInfoDTO save(ArticleInfoDTO articleInfoDTO);

    /**
     * Get all the articleInfos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ArticleInfoDTO> findAll(Pageable pageable);

    Page<ArticleInfoDTO> findAllByCondition(Pageable pageable, String keyWord, Boolean showState);


    /**
     * Get the "id" articleInfo.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ArticleInfoDTO> findOne(Long id);

    /**
     * Delete the "id" articleInfo.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    void topArticleInfo(Long id);

    void updateShowState(Long id, Boolean state);

    int updateReaderCountArticleInfo(Long id);
}
