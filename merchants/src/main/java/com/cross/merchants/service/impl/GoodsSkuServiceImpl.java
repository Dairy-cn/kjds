package com.cross.merchants.service.impl;

import com.cross.merchants.service.GoodsSkuService;
import com.cross.merchants.domain.GoodsSku;
import com.cross.merchants.repository.GoodsSkuRepository;
import com.cross.merchants.service.dto.GoodsSkuDTO;
import com.cross.merchants.service.mapper.GoodsSkuMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link GoodsSku}.
 */
@Service
@Transactional
public class GoodsSkuServiceImpl implements GoodsSkuService {

    private final Logger log = LoggerFactory.getLogger(GoodsSkuServiceImpl.class);

    private final GoodsSkuRepository goodsSkuRepository;

    private final GoodsSkuMapper goodsSkuMapper;

    public GoodsSkuServiceImpl(GoodsSkuRepository goodsSkuRepository, GoodsSkuMapper goodsSkuMapper) {
        this.goodsSkuRepository = goodsSkuRepository;
        this.goodsSkuMapper = goodsSkuMapper;
    }

    /**
     * Save a goodsSku.
     *
     * @param goodsSkuDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public GoodsSkuDTO save(GoodsSkuDTO goodsSkuDTO) {
        log.debug("Request to save GoodsSku : {}", goodsSkuDTO);
        GoodsSku goodsSku = goodsSkuMapper.toEntity(goodsSkuDTO);
        goodsSku = goodsSkuRepository.save(goodsSku);
        return goodsSkuMapper.toDto(goodsSku);
    }

    /**
     * Get all the goodsSkus.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<GoodsSkuDTO> findAll(Pageable pageable) {
        log.debug("Request to get all GoodsSkus");
        return goodsSkuRepository.findAll(pageable)
            .map(goodsSkuMapper::toDto);
    }

    /**
     * Get one goodsSku by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<GoodsSkuDTO> findOne(Long id) {
        log.debug("Request to get GoodsSku : {}", id);
        return goodsSkuRepository.findById(id)
            .map(goodsSkuMapper::toDto);
    }

    /**
     * Delete the goodsSku by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete GoodsSku : {}", id);
        goodsSkuRepository.deleteById(id);
    }

    @Override
    public Map<Long, List<GoodsSkuDTO>> findAllByIdGoodsInGroupById(List<Long> goodsIds) {
        Map<Long, List<GoodsSkuDTO>> map = new HashMap<>();
        if (!CollectionUtils.isEmpty(goodsIds)) {
            List<GoodsSkuDTO> skuDTOList = goodsSkuMapper.toDto(goodsSkuRepository.findAllByGoodsIdInAndDeleteFlag(goodsIds, false));
            return skuDTOList.stream().collect(Collectors.groupingBy(GoodsSkuDTO::getGoodsId));
        }
        return map;
    }

    @Override
    public List<GoodsSkuDTO> findAllByGoodsId(Long goodsId) {
        List<GoodsSkuDTO> skuDTOList = goodsSkuMapper.toDto(goodsSkuRepository.findAllByGoodsIdAndDeleteFlag(goodsId, false));
        return skuDTOList;
    }

    @Override
    @Transactional
    public List<GoodsSku> saveAll(List<GoodsSkuDTO> goodsSkuDTOs) {
        if (!CollectionUtils.isEmpty(goodsSkuDTOs)) {
            List<Long> ids = goodsSkuDTOs.stream().filter(e -> e.getId() != null).map(GoodsSkuDTO::getId).collect(Collectors.toList());
            List<GoodsSku> goodsSku = goodsSkuRepository.findAllByIdInAndDeleteFlag(ids, false);
            Map<Long, GoodsSku> goodsSkuMap = new HashMap<>();
            if (!CollectionUtils.isEmpty(goodsSku)) {
                goodsSkuMap = goodsSku.stream().collect(Collectors.toMap(GoodsSku::getId, e -> e));
            }
            Map<Long, GoodsSku> finalGoodsSkuMap = goodsSkuMap;
            goodsSkuDTOs.stream().forEach(e -> {
                if (e.getId() != null) {
                    GoodsSku db = finalGoodsSkuMap.get(e.getId());
                    if (db != null) {
                        e.setLockStock(db.getLockStock());
                        e.setSaleVolume(db.getSaleVolume());
                    } else {
                        e.setId(null);
                        e.setLockStock(0);
                        e.setSaleVolume(0);
                    }
                } else {
                    e.setLockStock(0);
                    e.setSaleVolume(0);
                }

            });
        }
        return goodsSkuRepository.saveAll(goodsSkuMapper.toEntity(goodsSkuDTOs));
    }

}

