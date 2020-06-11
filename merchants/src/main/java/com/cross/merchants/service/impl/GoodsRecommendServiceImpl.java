package com.cross.merchants.service.impl;

import com.cross.merchants.domain.Goods;
import com.cross.merchants.domain.GoodsRecommendBanner;
import com.cross.merchants.exception.MerchantsException;
import com.cross.merchants.repository.GoodsRepository;
import com.cross.merchants.service.GoodsRecommendService;
import com.cross.merchants.domain.GoodsRecommend;
import com.cross.merchants.repository.GoodsRecommendRepository;
import com.cross.merchants.service.dto.GoodsRecommendDTO;
import com.cross.merchants.service.mapper.GoodsRecommendMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Service Implementation for managing {@link GoodsRecommend}.
 */
@Service
@Transactional
public class GoodsRecommendServiceImpl implements GoodsRecommendService {

    private final Logger log = LoggerFactory.getLogger(GoodsRecommendServiceImpl.class);

    private final GoodsRecommendRepository goodsRecommendRepository;

    private final GoodsRecommendMapper goodsRecommendMapper;

    private final GoodsRepository goodsRepository;

    public GoodsRecommendServiceImpl(GoodsRecommendRepository goodsRecommendRepository, GoodsRecommendMapper goodsRecommendMapper, GoodsRepository goodsRepository) {
        this.goodsRecommendRepository = goodsRecommendRepository;
        this.goodsRecommendMapper = goodsRecommendMapper;
        this.goodsRepository = goodsRepository;
    }

    /**
     * Save a goodsRecommend.
     *
     * @param goodsRecommendDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public GoodsRecommendDTO save(GoodsRecommendDTO goodsRecommendDTO) {
        log.debug("Request to save GoodsRecommend : {}", goodsRecommendDTO);
        checkParam(goodsRecommendDTO);
        if (goodsRecommendDTO.getId() != null) {
            GoodsRecommend one = goodsRecommendRepository.getOne(goodsRecommendDTO.getId());
            goodsRecommendDTO.setTop(one.getTop());
            goodsRecommendDTO.setUpdateTime(Instant.now());
            goodsRecommendDTO.setCreateTime(one.getCreateTime());
        } else {
            goodsRecommendDTO.setCreateTime(Instant.now());
        }
        GoodsRecommend goodsRecommend = goodsRecommendMapper.toEntity(goodsRecommendDTO);
        goodsRecommend = goodsRecommendRepository.save(goodsRecommend);
        return goodsRecommendMapper.toDto(goodsRecommend);
    }

    private boolean checkParam(GoodsRecommendDTO goodsRecommendDTO) {

        if (goodsRecommendDTO.getId() == null) {
            int countByType = goodsRecommendRepository.countAllByGoodsRecommendType(goodsRecommendDTO.getGoodsRecommendType());
            if (goodsRecommendDTO.getGoodsRecommendType() == 1 && countByType >= 9) {
                throw new MerchantsException(400, "单品推荐最多可推荐9个");
            } else if (goodsRecommendDTO.getGoodsRecommendType() == 2) {
                if (goodsRecommendDTO.getGoodsRecommendBannerId() == null) {
                    throw new MerchantsException(400, "请选择推荐专区");
                }
                int countByTypeAndPosition = goodsRecommendRepository.countAllByGoodsRecommendTypeAndGoodsRecommendBannerId(goodsRecommendDTO.getGoodsRecommendType(), goodsRecommendDTO.getGoodsRecommendBannerId());
                if (countByTypeAndPosition >= 4) {
                    throw new MerchantsException(400, "一个推荐专区最多可推荐4个");
                }
            }


        }

        Goods one = goodsRepository.getOne(goodsRecommendDTO.getGoodsId());
        if (one == null) {
            throw new MerchantsException(400, "商品不存在");
        }
        if (one.getSaleState() == null || !one.getSaleState()) {
            throw new MerchantsException(400, "该商品并未上架,请先上架后再操作");
        }
        return true;
    }

    /**
     * Get all the goodsRecommends.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<GoodsRecommendDTO> findAll(Pageable pageable) {
        log.debug("Request to get all GoodsRecommends");
        return goodsRecommendRepository.findAll(pageable)
            .map(goodsRecommendMapper::toDto);
    }

    /**
     * Get one goodsRecommend by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<GoodsRecommendDTO> findOne(Long id) {
        log.debug("Request to get GoodsRecommend : {}", id);
        return goodsRecommendRepository.findById(id)
            .map(goodsRecommendMapper::toDto);
    }

    /**
     * Delete the goodsRecommend by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete GoodsRecommend : {}", id);
        goodsRecommendRepository.deleteById(id);
    }


    @Override
    public boolean topGoodsRecommend(Long id) {
        goodsRecommendRepository.updateTopStateFalse();
        goodsRecommendRepository.updateTopStateTrueById(id);
        return true;
    }

    @Override
    public GoodsRecommendDTO getOne(Long id) {
        return goodsRecommendMapper.toDto(goodsRecommendRepository.getOne(id));
    }

    @Override
    public Page<GoodsRecommendDTO> findAllByType(Pageable pageable, Integer type) {
        return goodsRecommendRepository.findAllByGoodsRecommendTypeOrderByTopDescIdDesc(pageable, type).map(goodsRecommendMapper::toDto);
    }

    @Override
    public List<GoodsRecommendDTO>getAllGoodsRecommendsByC(Integer type) {
        // 商品推荐类型 1 单品推荐 2 专区商品推荐
        List<GoodsRecommendDTO> recommendDTOS = goodsRecommendMapper.toDto(goodsRecommendRepository.findAllByGoodsRecommendTypeOrderByTopDescIdDesc(type));
        return recommendDTOS;
    }


}
