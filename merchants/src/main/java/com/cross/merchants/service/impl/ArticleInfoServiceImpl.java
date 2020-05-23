package com.cross.merchants.service.impl;

import com.cross.merchants.domain.Goods;
import com.cross.merchants.service.ArticleInfoService;
import com.cross.merchants.domain.ArticleInfo;
import com.cross.merchants.repository.ArticleInfoRepository;
import com.cross.merchants.service.dto.ArticleInfoDTO;
import com.cross.merchants.service.mapper.ArticleInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link ArticleInfo}.
 */
@Service
@Transactional
public class ArticleInfoServiceImpl implements ArticleInfoService {

    private final Logger log = LoggerFactory.getLogger(ArticleInfoServiceImpl.class);

    private final ArticleInfoRepository articleInfoRepository;

    private final ArticleInfoMapper articleInfoMapper;

    public ArticleInfoServiceImpl(ArticleInfoRepository articleInfoRepository, ArticleInfoMapper articleInfoMapper) {
        this.articleInfoRepository = articleInfoRepository;
        this.articleInfoMapper = articleInfoMapper;
    }

    /**
     * Save a articleInfo.
     *
     * @param articleInfoDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ArticleInfoDTO save(ArticleInfoDTO articleInfoDTO) {
        log.debug("Request to save ArticleInfo : {}", articleInfoDTO);
        if (articleInfoDTO.getId() == null) {
            articleInfoDTO.setCreateTime(Instant.now());
        } else {
            articleInfoDTO.setUpdateTime(Instant.now());
        }
        ArticleInfo articleInfo = articleInfoMapper.toEntity(articleInfoDTO);
        articleInfo = articleInfoRepository.save(articleInfo);
        return articleInfoMapper.toDto(articleInfo);
    }

    /**
     * Get all the articleInfos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ArticleInfoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ArticleInfos");
        return articleInfoRepository.findAll(pageable)
            .map(articleInfoMapper::toDto);
    }

    @Override
    public Page<ArticleInfoDTO> findAllByCondition(Pageable pageable, String keyWord, Boolean showState) {
        Page<ArticleInfo> page = articleInfoRepository.findAll((r, q, b) -> {
            List<Predicate> listPredicates = new ArrayList<>();
            if (showState != null) {
                listPredicates.add(b.equal(r.get("showState").as(Boolean.class), showState));
            }

            if (!StringUtils.isBlank(keyWord)) {
                List<Predicate> listPermission = new ArrayList<>();
                listPermission.add(b.like(r.get("titleNo").as(String.class), "%" + keyWord.trim() + "%"));
//                listPermission.add(b.like(r.get("goodsName").as(String.class), "%" + keyWord.trim() + "%"));
                Predicate[] predicatesPermissionArr = new Predicate[listPermission.size()];
                listPredicates.add(b.or(listPermission.toArray(predicatesPermissionArr)));
            }

            Predicate[] arrayPredicates = new Predicate[listPredicates.size()];
            return b.and(listPredicates.toArray(arrayPredicates));
        }, pageable);
        return page.map(articleInfoMapper::toDto);
    }

    /**
     * Get one articleInfo by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ArticleInfoDTO> findOne(Long id) {
        log.debug("Request to get ArticleInfo : {}", id);
        return articleInfoRepository.findById(id)
            .map(articleInfoMapper::toDto);
    }

    /**
     * Delete the articleInfo by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ArticleInfo : {}", id);
        articleInfoRepository.deleteById(id);
    }

    @Override
    public void topArticleInfo(Long id) {
        articleInfoRepository.setTopStatusFalse();

        articleInfoRepository.updateTopStatus(id, true);
    }

    @Override
    public void updateShowState(Long id, Boolean state) {
        if (state == null) {
            return;
        }
        articleInfoRepository.updateShowState(id, state);
    }
}
