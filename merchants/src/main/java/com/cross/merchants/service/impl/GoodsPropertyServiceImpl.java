package com.cross.merchants.service.impl;

import com.cross.merchants.domain.GoodsPropertyTag;
import com.cross.merchants.repository.GoodsPropertyTagRepository;
import com.cross.merchants.service.GoodsPropertyService;
import com.cross.merchants.domain.GoodsProperty;
import com.cross.merchants.repository.GoodsPropertyRepository;
import com.cross.merchants.service.dto.GoodsPropertyDTO;
import com.cross.merchants.service.dto.GoodsPropertyTagDTO;
import com.cross.merchants.service.mapper.GoodsPropertyMapper;
import com.cross.merchants.service.mapper.GoodsPropertyTagMapper;
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
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link GoodsProperty}.
 */
@Service
@Transactional
public class GoodsPropertyServiceImpl implements GoodsPropertyService {

    private final Logger log = LoggerFactory.getLogger(GoodsPropertyServiceImpl.class);

    private final GoodsPropertyRepository goodsPropertyRepository;

    private final GoodsPropertyMapper goodsPropertyMapper;

    private final GoodsPropertyTagRepository goodsPropertyTagRepository;

    private final GoodsPropertyTagMapper goodsPropertyTagMapper;

    public GoodsPropertyServiceImpl(GoodsPropertyRepository goodsPropertyRepository, GoodsPropertyMapper goodsPropertyMapper, GoodsPropertyTagRepository goodsPropertyTagRepository, GoodsPropertyTagMapper goodsPropertyTagMapper) {
        this.goodsPropertyRepository = goodsPropertyRepository;
        this.goodsPropertyMapper = goodsPropertyMapper;
        this.goodsPropertyTagRepository = goodsPropertyTagRepository;
        this.goodsPropertyTagMapper = goodsPropertyTagMapper;
    }

    /**
     * Save a goodsProperty.
     *
     * @param goodsPropertyDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    @Transactional
    public GoodsPropertyDTO save(GoodsPropertyDTO goodsPropertyDTO) {
        log.debug("Request to save GoodsProperty : {}", goodsPropertyDTO);
        GoodsProperty goodsProperty = goodsPropertyMapper.toEntity(goodsPropertyDTO);
        goodsProperty = goodsPropertyRepository.save(goodsProperty);

        if (goodsPropertyDTO.getId() == null) {
            if (!CollectionUtils.isEmpty(goodsPropertyDTO.getGoodsPropertyTagDTOS())) {
                GoodsProperty finalGoodsProperty = goodsProperty;
                goodsPropertyDTO.getGoodsPropertyTagDTOS().stream().forEach(e -> {
                    e.setDeleteFlag(false);
                    e.setGoodsPropertyId(finalGoodsProperty.getId());
                });
                goodsPropertyTagRepository.saveAll(goodsPropertyTagMapper.toEntity(goodsPropertyDTO.getGoodsPropertyTagDTOS()));
            }
        } else {

            List<GoodsPropertyTag> dbList = goodsPropertyTagRepository.findAllByGoodsPropertyIdAndDeleteFlag(goodsPropertyDTO.getId(), false);
            List<Long> ids = dbList.stream().map(GoodsPropertyTag::getId).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(goodsPropertyDTO.getGoodsPropertyTagDTOS())) {
                List<Long> updateIds = goodsPropertyDTO.getGoodsPropertyTagDTOS().stream().filter(e -> e.getId() != null).map(GoodsPropertyTagDTO::getId).collect(Collectors.toList());
                ids = ids.stream().filter(e -> !updateIds.contains(e)).collect(Collectors.toList());
            }
            if (!CollectionUtils.isEmpty(ids)) {
                goodsPropertyTagRepository.deleteByIdIn(ids);
            }

            if (!CollectionUtils.isEmpty(goodsPropertyDTO.getGoodsPropertyTagDTOS())) {
                GoodsProperty finalGoodsProperty1 = goodsProperty;
                goodsPropertyDTO.getGoodsPropertyTagDTOS().stream().forEach(e -> {
                    e.setDeleteFlag(false);
                    e.setGoodsPropertyId(finalGoodsProperty1.getId());
                });
                goodsPropertyTagRepository.saveAll(goodsPropertyTagMapper.toEntity(goodsPropertyDTO.getGoodsPropertyTagDTOS()));
            }
        }
        return goodsPropertyMapper.toDto(goodsProperty);
    }

    /**
     * Get all the goodsProperties.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<GoodsPropertyDTO> findAll(Pageable pageable) {
        log.debug("Request to get all GoodsProperties");
        return goodsPropertyRepository.findAll(pageable)
            .map(goodsPropertyMapper::toDto);
    }

    /**
     * Get one goodsProperty by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<GoodsPropertyDTO> findOne(Long id) {
        log.debug("Request to get GoodsProperty : {}", id);
        return goodsPropertyRepository.findById(id)
            .map(goodsPropertyMapper::toDto);
    }

    /**
     * Delete the goodsProperty by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete GoodsProperty : {}", id);
        goodsPropertyRepository.deleteById(id);
    }

    @Override
    @Transactional
    public boolean saveAll(List<GoodsPropertyDTO> dtos) {
        if (!CollectionUtils.isEmpty(dtos)) {
            dtos.stream().forEach(e -> {
                save(e);
            });
        }
        return true;
    }

    @Override
    public Map<Long, List<GoodsPropertyDTO>> findAllByIdGoodsInGroupById(List<Long> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            List<GoodsProperty> propertyList = goodsPropertyRepository.findAllByGoodsIdInAndDeleteFlag(ids, false);
            List<GoodsPropertyDTO> propertyDTOS = goodsPropertyMapper.toDto(propertyList);
            List<Long> propertyIds = propertyList.stream().map(GoodsProperty::getId).collect(Collectors.toList());
            Map<Long, List<GoodsPropertyTag>> map = new HashMap<>();
            if (!CollectionUtils.isEmpty(propertyIds)) {
                List<GoodsPropertyTag> allByGoodsPropertyIdInAndDeleteFlag = goodsPropertyTagRepository.findAllByGoodsPropertyIdInAndDeleteFlag(propertyIds, false);
                map = allByGoodsPropertyIdInAndDeleteFlag.stream().collect(Collectors.groupingBy(GoodsPropertyTag::getGoodsPropertyId));
            }
            Map<Long, List<GoodsPropertyTag>> finalMap = map;
            propertyDTOS.stream().forEach(e -> {
                e.setGoodsPropertyTagDTOS(goodsPropertyTagMapper.toDto(finalMap.get(e.getId())));
            });
            return propertyDTOS.stream().collect(Collectors.groupingBy(GoodsPropertyDTO::getGoodsId));
        }

        return new HashMap<>();
    }

    @Override
    public List<GoodsPropertyDTO> findAllByIdGoods(Long id) {
        List<GoodsProperty> propertyList = goodsPropertyRepository.findAllByGoodsIdAndDeleteFlag(id, false);
        List<GoodsPropertyDTO> propertyDTOS = goodsPropertyMapper.toDto(propertyList);
        List<Long> propertyIds = propertyList.stream().map(GoodsProperty::getId).collect(Collectors.toList());
        Map<Long, List<GoodsPropertyTag>> map = new HashMap<>();
        if (!CollectionUtils.isEmpty(propertyIds)) {
            List<GoodsPropertyTag> allByGoodsPropertyIdInAndDeleteFlag = goodsPropertyTagRepository.findAllByGoodsPropertyIdInAndDeleteFlag(propertyIds, false);
            map = allByGoodsPropertyIdInAndDeleteFlag.stream().collect(Collectors.groupingBy(GoodsPropertyTag::getGoodsPropertyId));
        }
        Map<Long, List<GoodsPropertyTag>> finalMap = map;
        propertyDTOS.stream().forEach(e -> {
            e.setGoodsPropertyTagDTOS(goodsPropertyTagMapper.toDto(finalMap.get(e.getId())));
        });
        return propertyDTOS;
    }
}
