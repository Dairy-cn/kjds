package com.cross.merchants.service.impl;

import com.cross.merchants.exception.MerchantsException;
import com.cross.merchants.repository.GoodsRepository;
import com.cross.merchants.service.GoodsCategoryService;
import com.cross.merchants.domain.GoodsCategory;
import com.cross.merchants.repository.GoodsCategoryRepository;
import com.cross.merchants.service.dto.GoodsCategoryDTO;
import com.cross.merchants.service.mapper.GoodsCategoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link GoodsCategory}.
 */
@Service
@Transactional
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

    private final Logger log = LoggerFactory.getLogger(GoodsCategoryServiceImpl.class);

    private final GoodsCategoryRepository goodsCategoryRepository;

    private final GoodsCategoryMapper goodsCategoryMapper;

    @Autowired
    private GoodsRepository goodsRepository;

    public GoodsCategoryServiceImpl(GoodsCategoryRepository goodsCategoryRepository, GoodsCategoryMapper goodsCategoryMapper) {
        this.goodsCategoryRepository = goodsCategoryRepository;
        this.goodsCategoryMapper = goodsCategoryMapper;
    }

    /**
     * Save a goodsCategory.
     *
     * @param goodsCategoryDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    @Transactional
    public GoodsCategoryDTO save(GoodsCategoryDTO goodsCategoryDTO) {
        log.debug("Request to save GoodsCategory : {}", goodsCategoryDTO);
        checkParam(goodsCategoryDTO);

        GoodsCategory goodsCategory = goodsCategoryMapper.toEntity(goodsCategoryDTO);
        goodsCategory = goodsCategoryRepository.save(goodsCategory);
        if (goodsCategoryDTO.getId() == null) {
            if (!CollectionUtils.isEmpty(goodsCategoryDTO.getChildNode())) {
                GoodsCategory finalGoodsCategory = goodsCategory;
                goodsCategoryDTO.getChildNode().stream().forEach(e -> {
                    e.setPid(finalGoodsCategory.getId());
                });
                goodsCategoryDTO.getChildNode().stream().forEach(e -> {
                    GoodsCategoryDTO save = this.save(e);
                });
            }
        } else {
            //编辑
            if (!CollectionUtils.isEmpty(goodsCategoryDTO.getChildNode())) {
                //更新的数据
                List<Long> updateIdList = goodsCategoryDTO.getChildNode().stream().filter(e -> e.getId() != null).map(GoodsCategoryDTO::getId).collect(Collectors.toList());
                goodsCategoryDTO.getChildNode().stream().forEach(e -> {
                    List<Long> childIdList = e.getChildNode().stream().filter(e2 -> e2.getId() != null).map(GoodsCategoryDTO::getId).collect(Collectors.toList());
                    if (!CollectionUtils.isEmpty(childIdList)) {
                        updateIdList.addAll(childIdList);
                    }
                });

                //删除
                List<Long> pidIds = new ArrayList<>();
//                pidIds.add(goodsCategory.getId());
                List<GoodsCategory> list = goodsCategoryRepository.findAllByPid(goodsCategory.getId());
                if (!CollectionUtils.isEmpty(list)) {
                    pidIds.addAll(list.stream().map(GoodsCategory::getId).collect(Collectors.toList()));
                    List<Long> finalPidIds = pidIds;
                    list.stream().forEach(e -> {
                        List<GoodsCategory> childList = goodsCategoryRepository.findAllByPid(e.getId());
                        finalPidIds.addAll(childList.stream().map(GoodsCategory::getId).collect(Collectors.toList()));
                    });
                    pidIds = finalPidIds;
                }
                pidIds = pidIds.stream().filter(e -> !updateIdList.contains(e)).collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(pidIds)) {
                    //TODO
                    //需要判断该分类下是否存在商品
                    goodsCategoryRepository.deleteByIdIn(pidIds);
                }
                GoodsCategory finalGoodsCategory = goodsCategory;
                goodsCategoryDTO.getChildNode().stream().forEach(e -> {
                    e.setPid(finalGoodsCategory.getId());
                });
                goodsCategoryDTO.getChildNode().stream().forEach(e -> {
                    GoodsCategoryDTO save = this.save(e);
                });
            }
        }
        return goodsCategoryMapper.toDto(goodsCategory);
    }


    private boolean checkParam(GoodsCategoryDTO dto) {
        if (dto.getLevel() == null) {
            throw new MerchantsException(400, "分类等级不能为空");
        }
        if (1 == dto.getLevel()) {
            dto.setPid(0L);
        }
        dto.setStick(false);
        if (dto.getId() == null) {
            dto.setCreateTime(Instant.now());

            int level = dto.getLevel();
            int count = goodsCategoryRepository.countAllByLevel(level);
            switch (level) {
                case 1:
                    if (count >= 12) {
                        throw new MerchantsException(400, "一级分类最多可创建12个");
                    }
                    if (dto.getName().length() > 10) {
                        throw new MerchantsException(400, "一级分类名称不能超过十个字");
                    }
                    break;
                case 2:
                    if (count >= 100) {
                        throw new MerchantsException(400, "二级分类最多可创建100个");
                    }
                    break;
                case 3:
                    if (count >= 100) {
                        throw new MerchantsException(400, "三级分类最多可创建100个");
                    }
                    break;
                default:
                    break;
            }

        }
        GoodsCategory firstByPidAndName = goodsCategoryRepository.findFirstByPidAndName(dto.getPid(), dto.getName());
        if (firstByPidAndName != null) {
            if (dto.getId() == null || !dto.getId().equals(firstByPidAndName.getId())) {
                throw new MerchantsException(400, "该商品分类等级下已存在分类名称");
            }
        }
        return true;
    }

    /**
     * Get all the goodsCategories.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<GoodsCategoryDTO> findAll(Pageable pageable) {
        log.debug("Request to get all GoodsCategories");
        return goodsCategoryRepository.findAll(pageable)
            .map(goodsCategoryMapper::toDto);
    }

    @Override
    public List<GoodsCategoryDTO> findAll() {
        return goodsCategoryMapper.toDto(goodsCategoryRepository.findAll());
    }

    @Override
    public List<GoodsCategoryDTO> findAllByLevel(Integer level) {
        return goodsCategoryMapper.toDto(goodsCategoryRepository.findAllByLevelOrderByStickDescIdDesc(level));

    }

    @Override
    public List<GoodsCategoryDTO> findAllByPidIn(List<Long> pids) {
        return goodsCategoryMapper.toDto(goodsCategoryRepository.findAllByPidIn(pids));

    }

    @Override
    public List<GoodsCategoryDTO> findAllByPid(Long pid) {
        return goodsCategoryMapper.toDto(goodsCategoryRepository.findAllByPid(pid));
    }

    /**
     * Get one goodsCategory by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<GoodsCategoryDTO> findOne(Long id) {
        log.debug("Request to get GoodsCategory : {}", id);
        return goodsCategoryRepository.findById(id)
            .map(goodsCategoryMapper::toDto);
    }

    /**
     * Delete the goodsCategory by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete GoodsCategory : {}", id);
        //获取下级菜单
        List<Long> ids = new ArrayList<>();
        ids.add(id);
        List<GoodsCategory> childList = goodsCategoryRepository.findAllByPid(id);
        if (!CollectionUtils.isEmpty(childList)) {
            List<Long> childIds = childList.stream().map(GoodsCategory::getId).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(childIds)) {
                ids.addAll(childIds);
                List<GoodsCategory> grandChildList = goodsCategoryRepository.findAllByPidIn(childIds);
                List<Long> grandChildIds = grandChildList.stream().map(GoodsCategory::getId).collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(grandChildIds)) {
                    ids.addAll(grandChildIds);
                }
            }
        }
        ids = ids.stream().distinct().collect(Collectors.toList());
        int count = goodsRepository.countAllByCategoryIdInAndDeleteFlag(ids, false);
        if (count > 0) {
            throw new MerchantsException(400, "该分类下存在商品,不能删除");
        }
        goodsCategoryRepository.deleteById(id);
    }

    @Override
    public boolean stickGoodsCategory(Long id) {
        //先删除置顶数据
        goodsCategoryRepository.setStickStatusFalse();
        int count = goodsCategoryRepository.updateStickStatus(id, true);
        return count > 0 ? true : false;
    }

    @Override
    public Map<Long, GoodsCategoryDTO> findAllByInInWithParentInfo(List<Long> ids) {
        Map<Long, GoodsCategoryDTO> map = new HashMap<>();
        if (!CollectionUtils.isEmpty(ids)) {
            List<GoodsCategoryDTO> fristList = goodsCategoryMapper.toDto(goodsCategoryRepository.findByIdIn(ids));
            if (!CollectionUtils.isEmpty(fristList)) {
                List<Long> parentIds = fristList.stream().filter(e -> 0 != e.getPid()).map(GoodsCategoryDTO::getPid).collect(Collectors.toList());
                List<GoodsCategoryDTO> parentList = goodsCategoryMapper.toDto(goodsCategoryRepository.findByIdIn(parentIds));
                parentList.stream().forEach(e -> {
                    map.put(e.getId(), e);
                });
                if (!CollectionUtils.isEmpty(parentList)) {
                    List<Long> grandpaIds = parentList.stream().filter(e -> 0 != e.getPid()).map(GoodsCategoryDTO::getPid).collect(Collectors.toList());
                    List<GoodsCategoryDTO> grandpaList = goodsCategoryMapper.toDto(goodsCategoryRepository.findByIdIn(grandpaIds));
                    grandpaList.stream().forEach(e -> {
                        map.put(e.getId(), e);
                    });
                }
            }
            fristList.stream().filter(e -> e.getPid() != null).forEach(e -> {
                e.setParentNode(map.get(e.getPid()));
            });
            fristList.stream().filter(e -> e.getParentNode() != null).forEach(e -> {
                GoodsCategoryDTO parentNode = e.getParentNode();
                parentNode.setParentNode(map.get(parentNode.getPid()));
                e.setParentNode(parentNode);
            });
            return fristList.stream().collect(Collectors.toMap(GoodsCategoryDTO::getId, e -> e));
        }
        return map;
    }

    @Override
    public GoodsCategoryDTO findAllInfoByIdWithParentInfo(Long id) {
        GoodsCategoryDTO goodsCategoryDTO = goodsCategoryMapper.toDto(goodsCategoryRepository.getOne(id));
        if (goodsCategoryDTO != null && 0 != goodsCategoryDTO.getPid()) {
            GoodsCategoryDTO parentDto = goodsCategoryMapper.toDto(goodsCategoryRepository.getOne(goodsCategoryDTO.getPid()));

            if (parentDto != null && 0 != parentDto.getPid()) {
                GoodsCategoryDTO gandParentDto = goodsCategoryMapper.toDto(goodsCategoryRepository.getOne(parentDto.getPid()));
                parentDto.setParentNode(gandParentDto);
            }
            goodsCategoryDTO.setParentNode(parentDto);
        }
        return goodsCategoryDTO;
    }
}
