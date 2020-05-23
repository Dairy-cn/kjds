package com.cross.merchants.service.impl;

import com.cross.merchants.domain.Goods;
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
        GoodsRecommend goodsRecommend = goodsRecommendMapper.toEntity(goodsRecommendDTO);
        goodsRecommend = goodsRecommendRepository.save(goodsRecommend);
        return goodsRecommendMapper.toDto(goodsRecommend);
    }

    private boolean checkParam(GoodsRecommendDTO goodsRecommendDTO) {
        int countByBanner = goodsRecommendRepository.countAllByBanner(goodsRecommendDTO.getBanner());
        if (goodsRecommendDTO.getId() == null && countByBanner > 4) {
            throw new MerchantsException(400, "每个专区可推荐4个商品");
        }
        int countAllByGoodsId = goodsRecommendRepository.countAllByGoodsId(goodsRecommendDTO.getGoodsId());
        if (countAllByGoodsId > 0) {
            throw new MerchantsException(400, "该商品已添加,请勿重复添加");
        }
        Goods one = goodsRepository.getOne(goodsRecommendDTO.getGoodsId());
        if(one==null){
            throw new MerchantsException(400, "商品不存在");
        }
        if(one.getSaleState()==null || !one.getSaleState()){
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


}
