package com.cross.merchants.service.impl;

import com.cross.merchants.domain.MerchantsCheckInInfo;
import com.cross.merchants.domain.StoreInfo;
import com.cross.merchants.exception.MerchantsException;
import com.cross.merchants.service.BrandService;
import com.cross.merchants.domain.Brand;
import com.cross.merchants.repository.BrandRepository;
import com.cross.merchants.service.dto.BrandDTO;
import com.cross.merchants.service.dto.GoodsDTO;
import com.cross.merchants.service.dto.MerchantsCheckInInfoDTO;
import com.cross.merchants.service.mapper.BrandMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.Predicate;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Brand}.
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService {

    private final Logger log = LoggerFactory.getLogger(BrandServiceImpl.class);

    private final BrandRepository brandRepository;

    private final BrandMapper brandMapper;

    @Lazy
    @Autowired
    private GoodsServiceImpl goodsService;

    public BrandServiceImpl(BrandRepository brandRepository, BrandMapper brandMapper) {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }

    /**
     * Save a brand.
     *
     * @param brandDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public BrandDTO save(BrandDTO brandDTO) {
        log.debug("Request to save Brand : {}", brandDTO);

        this.checkParam(brandDTO);
        if (brandDTO.getId() == null) {
            brandDTO.setCreatTime(Instant.now());
        }
        Brand brand = brandMapper.toEntity(brandDTO);
        brand = brandRepository.save(brand);
        return brandMapper.toDto(brand);
    }

    private boolean checkParam(BrandDTO brandDTO) {


        if (brandDTO.getBrandAuthType() == null) {
            throw new MerchantsException(400, "供应商代理等级不能为空");
        }
        if (1 == brandDTO.getBrandAuthType() && brandDTO.getOwerOfAttorneyPicLevelOne() == null) {
            throw new MerchantsException(400, "一级授权书信息不能为空");
        }
        if (2 == brandDTO.getBrandAuthType()) {
            if (brandDTO.getOwerOfAttorneyPicLevelOne() == null) {
                throw new MerchantsException(400, "一级授权书信息不能为空");
            }
            if (brandDTO.getOwerOfAttorneyPicLevelTwo() == null) {
                throw new MerchantsException(400, "二级授权书信息不能为空");
            }
        }
        if (3 == brandDTO.getBrandAuthType()) {
            if (brandDTO.getOwerOfAttorneyPicLevelOne() == null) {
                throw new MerchantsException(400, "一级授权书信息不能为空");
            }
            if (brandDTO.getOwerOfAttorneyPicLevelTwo() == null) {
                throw new MerchantsException(400, "二级授权书信息不能为空");
            }
            if (brandDTO.getOwerOfAttorneyPicLevelThree() == null) {
                throw new MerchantsException(400, "三级授权书信息不能为空");
            }
        }
        Brand brand = brandRepository.findFirstByStoreIdAndBrandName(brandDTO.getStoreId(), brandDTO.getBrandName());
        if (brandDTO.getId() == null) {
            if (brand != null) {
                throw new MerchantsException(400, "该企业下已存在相关的品牌名称");
            }
        } else {
            if (brand != null && brand.getId() != brandDTO.getId()) {
                throw new MerchantsException(400, "该企业下已存在相关的品牌名称");

            }
        }

        return true;
    }

    /**
     * Get all the brands.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BrandDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Brands");
        return brandRepository.findAll(pageable)
            .map(brandMapper::toDto);
    }

    /**
     * Get one brand by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public BrandDTO findOne(Long id) {
        log.debug("Request to get Brand : {}", id);
        Optional<Brand> brand = brandRepository.findById(id);
        if (!brand.isPresent()) {
            throw new MerchantsException(400, "记录不存在");
        }
        return brandMapper.toDto(brand.get());
    }

    /**
     * Delete the brand by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Brand : {}", id);
        brandRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BrandDTO> findAllWithWaitCheckIn(Pageable pageable) {
        log.debug("Request to get all MerchantsCheckInInfos");
        return brandRepository.findAllByCheckStatus(pageable, -1)
            .map(brandMapper::toDto);
    }

    @Override
    public Page<BrandDTO> findAllByStatusAndStoreId(Pageable pageable, Integer status, Long storeId) {
        if (status != null) {
            return brandRepository.findAllByCheckStatusAndStoreId(pageable, status, storeId).map(brandMapper::toDto);
        } else {
            return brandRepository.findAllByStoreId(pageable, storeId).map(brandMapper::toDto);

        }
    }

    @Override
    public List<BrandDTO> findAllByStatusAndStoreId(Integer status, Long storeId) {
        if (status != null) {
            return brandMapper.toDto(brandRepository.findAllByCheckStatusAndStoreId(status, storeId));
        } else {
            return brandMapper.toDto(brandRepository.findAllByStoreId(storeId));

        }
    }

    @Override
    public Page<BrandDTO> getAllBrandsByCondition(Pageable pageable, Integer brandAuthType, Integer checkState, Instant startTime, Instant endTime, Instant startCheckTime, Instant endCheckTime, String keyWord) {
        Page<Brand> page = brandRepository.findAll((r, q, b) -> {
            List<Predicate> listPredicates = new ArrayList<>();
            if (brandAuthType != null) {
                listPredicates.add(b.equal(r.get("brandAuthType").as(Integer.class), brandAuthType));
            }

            if (checkState != null) {
                listPredicates.add(b.equal(r.get("checkStatus").as(Integer.class), checkState));
            }
            if (!StringUtils.isBlank(keyWord)) {
                List<Predicate> listPermission = new ArrayList<>();
//                listPermission.add(b.like(r.get("goodsNo").as(String.class), "%" + keyWord.trim() + "%"));
                listPermission.add(b.like(r.get("brandName").as(String.class), "%" + keyWord.trim() + "%"));
                Predicate[] predicatesPermissionArr = new Predicate[listPermission.size()];
                listPredicates.add(b.or(listPermission.toArray(predicatesPermissionArr)));
            }
            if (startTime != null) {
                listPredicates.add(b.greaterThanOrEqualTo(r.get("applicationTime").as(Instant.class), startTime));
            }
            if (endTime != null) {
                listPredicates.add(b.lessThanOrEqualTo(r.get("applicationTime").as(Instant.class), endTime));
            }
            if (startCheckTime != null) {
                listPredicates.add(b.greaterThanOrEqualTo(r.get("checkTime").as(Instant.class), startCheckTime));
            }
            if (endCheckTime != null) {
                listPredicates.add(b.lessThanOrEqualTo(r.get("checkTime").as(Instant.class), endCheckTime));
            }

            Predicate[] arrayPredicates = new Predicate[listPredicates.size()];
            return b.and(listPredicates.toArray(arrayPredicates));
        }, pageable);
        return page.map(brandMapper::toDto);
    }

    @Override
    public List<BrandDTO> findAllByIdInAndCheckState(List<Long> ids, Integer checkState) {
        return brandMapper.toDto(brandRepository.findAllByIdInAndCheckStatus(ids, checkState));
    }

    @Override
    public Page<BrandDTO> getAllBrandListByConditionByC(Pageable pageable, Long oneCategoryId, Long twoCategoryId, Long thirdCategoryId) {
        List<GoodsDTO> allGoodsByConditionNoPage = goodsService.getAllGoodsByConditionNoPage(null, null, 1, null, null, null, null, null, oneCategoryId, twoCategoryId, thirdCategoryId);
        List<Long> longList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(allGoodsByConditionNoPage)) {
            longList = allGoodsByConditionNoPage.stream().map(GoodsDTO::getBrandId).distinct().collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(longList)) {
                Page<Brand> brands = brandRepository.findAllByCheckStatusAndIdIn(pageable, 1, longList);
                return brands.map(brandMapper::toDto);
            }
        }
        return new PageImpl<BrandDTO>(new ArrayList<BrandDTO>(), pageable, 0);
    }


    @Override
    @Transactional
    public BrandDTO brandCheckInInfo(BrandDTO brandDTO) {
        BrandDTO save = this.save(brandDTO);
        return save;
    }
}
