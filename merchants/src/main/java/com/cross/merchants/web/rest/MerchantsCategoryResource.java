package com.cross.merchants.web.rest;

import com.cross.merchants.domain.StoreInfo;
import com.cross.merchants.service.MerchantsCategoryService;
import com.cross.merchants.service.MerchantsCheckInInfoService;
import com.cross.merchants.service.StoreInfoService;
import com.cross.merchants.service.dto.MerchantsCheckInInfoDTO;
import com.cross.merchants.service.dto.StoreInfoDTO;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;
import com.cross.merchants.service.dto.MerchantsCategoryDTO;

import com.cross.utils.R;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * REST controller for managing {@link com.cross.merchants.domain.MerchantsCategory}.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "商户类目相关接口")
public class MerchantsCategoryResource {

    private final Logger log = LoggerFactory.getLogger(MerchantsCategoryResource.class);

    private static final String ENTITY_NAME = "merchantsMerchantsCategory";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MerchantsCategoryService merchantsCategoryService;

    @Autowired
    private MerchantsCheckInInfoService merchantsCheckInInfoService;

    @Autowired
    private StoreInfoService storeInfoService;

    public MerchantsCategoryResource(MerchantsCategoryService merchantsCategoryService) {
        this.merchantsCategoryService = merchantsCategoryService;
    }

    /**
     * {@code POST  /merchants-categories} : Create a new merchantsCategory.
     *
     * @param merchantsCategoryDTO the merchantsCategoryDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new merchantsCategoryDTO, or with status {@code 400 (Bad Request)} if the merchantsCategory has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/merchants-categories")
    @ApiOperation("大后台--类目管理--添加类目")
    public R createMerchantsCategory(@RequestBody MerchantsCategoryDTO merchantsCategoryDTO) throws URISyntaxException {
        log.debug("REST request to save MerchantsCategory : {}", merchantsCategoryDTO);
        if (merchantsCategoryDTO.getId() != null) {
            R.error("id必须为null");
        }
        MerchantsCategoryDTO result = merchantsCategoryService.save(merchantsCategoryDTO);
        return R.ok(result);
    }

    /**
     * {@code PUT  /merchants-categories} : Updates an existing merchantsCategory.
     *
     * @param merchantsCategoryDTO the merchantsCategoryDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated merchantsCategoryDTO,
     * or with status {@code 400 (Bad Request)} if the merchantsCategoryDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the merchantsCategoryDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/merchants-categories")
    @ApiOperation("大后台--类目管理--修改类目")
    public R updateMerchantsCategory(@RequestBody MerchantsCategoryDTO merchantsCategoryDTO) throws URISyntaxException {
        log.debug("REST request to update MerchantsCategory : {}", merchantsCategoryDTO);
        if (merchantsCategoryDTO.getId() == null) {
            R.error("id不能为null");
        }
        MerchantsCategoryDTO result = merchantsCategoryService.save(merchantsCategoryDTO);
        return R.ok(result);
    }

    /**
     * {@code GET  /merchants-categories} : get all the merchantsCategories.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of merchantsCategories in body.
     */
    @GetMapping("/merchants-categories")
    @ApiOperation("大后台--类目管理--获取类目信息列表")
    public R getAllMerchantsCategories(@ApiParam("分页信息") Pageable pageable,
                                       @ApiParam("是否根据商户数量排序") @RequestParam(required = false) Boolean isOrderWithMerchantOrder,
                                       @ApiParam("排序方式 (只关联商户数量)") @RequestParam(required = false) Boolean isDesc) {
        log.debug("REST request to get a page of MerchantsCategories");
        List<MerchantsCategoryDTO> list = new ArrayList<>();
        long count = 0;
        if (isOrderWithMerchantOrder == null) {
            Page<MerchantsCategoryDTO> page = merchantsCategoryService.findAll(pageable);
            list = page.getContent();
            count = page.getTotalElements();
        } else {
            list = merchantsCategoryService.findAllWithOrder(pageable, isDesc);
            count = merchantsCategoryService.count();
        }
        if (!CollectionUtils.isEmpty(list)) {
            List<Long> categoryIds = list.stream().map(MerchantsCategoryDTO::getId).collect(Collectors.toList());
            Map<Long, Integer> map = merchantsCheckInInfoService.countMerchantsWithCategoryIds(categoryIds);
            list.stream().forEach(e -> {
                Integer integer = map.get(e.getId());
                if (integer == null) {
                    integer = 0;
                }
                e.setCount(integer);
            });
        }
        return R.ok(list, count);
    }

    /**
     * {@code GET  /merchants-categories/:id} : get the "id" merchantsCategory.
     *
     * @param id the id of the merchantsCategoryDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the merchantsCategoryDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/merchants-categories/{id}")
    @ApiOperation("大后台--类目管理--获取类目信息详情")
    public R getMerchantsCategory(@PathVariable Long id) {
        log.debug("REST request to get MerchantsCategory : {}", id);
        //TODO 商户列表信息写入
        MerchantsCategoryDTO merchantsCategoryDTO = merchantsCategoryService.findOne(id).get();
        if (merchantsCategoryDTO != null) {
            Map<Long, List<StoreInfoDTO>> storeInfoDTOMap = new HashMap<>(16);

            List<StoreInfoDTO> storeInfoDTOS = storeInfoService.findAllByCategoryId(merchantsCategoryDTO.getId());
            if (!CollectionUtils.isEmpty(storeInfoDTOS)) {
                Map<Long, MerchantsCheckInInfoDTO> merchantsCheckInInfoDTOMap = new HashMap<>(16);

                List<Long> merchantsIds = storeInfoDTOS.stream().map(StoreInfoDTO::getMerchantsCheckInInfoId).collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(merchantsIds)) {
                    List<MerchantsCheckInInfoDTO> merchantsCheckInInfoDTOList = merchantsCheckInInfoService.findAllByIdIn(merchantsIds);
                    merchantsCheckInInfoDTOList.stream().forEach(e -> {
                        merchantsCheckInInfoDTOMap.put(e.getId(), e);
                    });
                }
                storeInfoDTOS.stream().forEach(e -> {
                    e.setMerchantsCheckInInfoDTO(merchantsCheckInInfoDTOMap.get(e.getMerchantsCheckInInfoId()));
                });
                storeInfoDTOMap = storeInfoDTOS.stream().collect(Collectors.groupingBy(StoreInfoDTO::getCategoryId));
            }
            merchantsCategoryDTO.setStoreInfoDTO(storeInfoDTOMap.get(merchantsCategoryDTO.getId()));
        }

        return R.ok(merchantsCategoryDTO);
    }

    /**
     * {@code DELETE  /merchants-categories/:id} : delete the "id" merchantsCategory.
     *
     * @param id the id of the merchantsCategoryDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/merchants-categories/{id}")
    public R deleteMerchantsCategory(@PathVariable Long id) {
        log.debug("REST request to delete MerchantsCategory : {}", id);
        long count = merchantsCheckInInfoService.countByCategoryId(id);
        if (count > 0) {
            return R.error("该类目下有商户,不能删除");
        }
        merchantsCategoryService.delete(id);
        return R.ok();
    }

    @GetMapping("/merchants-categories-list")
    @ApiOperation("商户端--获取类目信息列表")
    public R getAllMerchantsCategories() {
        List<MerchantsCategoryDTO> list = merchantsCategoryService.findAll();
        return R.ok(list);
    }
}
