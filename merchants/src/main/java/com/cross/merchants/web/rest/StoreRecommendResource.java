package com.cross.merchants.web.rest;


import com.cross.merchants.domain.MerchantsCheckInInfo;
import com.cross.merchants.domain.StoreInfo;
import com.cross.merchants.service.MerchantsCheckInInfoService;
import com.cross.merchants.service.StoreInfoService;
import com.cross.merchants.service.StoreRecommendService;
import com.cross.merchants.service.dto.StoreInfoDTO;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;
import com.cross.merchants.service.dto.StoreRecommendDTO;

import com.cross.utils.R;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * REST controller for managing {@link com.cross.merchants.domain.StoreRecommend}.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "商户推荐相关接口")
public class StoreRecommendResource {

    private final Logger log = LoggerFactory.getLogger(StoreRecommendResource.class);

    private static final String ENTITY_NAME = "merchantsStoreRecommend";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final StoreRecommendService storeRecommendService;

    private final StoreInfoService storeInfoService;

    @Autowired
    private MerchantsCheckInInfoService merchantsCheckInInfoService;

    public StoreRecommendResource(StoreRecommendService storeRecommendService, StoreInfoService storeInfoService) {
        this.storeRecommendService = storeRecommendService;
        this.storeInfoService = storeInfoService;
    }

    /**
     * {@code POST  /store-recommends} : Create a new storeRecommend.
     *
     * @param storeRecommendDTO the storeRecommendDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new storeRecommendDTO, or with status {@code 400 (Bad Request)} if the storeRecommend has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/store-recommends")
    @ApiOperation("添加商户推荐信息")
    public R<StoreRecommendDTO> createStoreRecommend(@Valid @RequestBody StoreRecommendDTO storeRecommendDTO) throws URISyntaxException {
        log.debug("REST request to save StoreRecommend : {}", storeRecommendDTO);
        if (storeRecommendDTO.getId() != null) {
            return R.error("idexists");
        }
        StoreRecommendDTO result = storeRecommendService.save(storeRecommendDTO);
        return R.ok(result);
    }

    /**
     * {@code PUT  /store-recommends} : Updates an existing storeRecommend.
     *
     * @param storeRecommendDTO the storeRecommendDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated storeRecommendDTO,
     * or with status {@code 400 (Bad Request)} if the storeRecommendDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the storeRecommendDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/store-recommends")
    @ApiOperation("修改商户推荐信息")
    public R<StoreRecommendDTO> updateStoreRecommend(@Valid @RequestBody StoreRecommendDTO storeRecommendDTO) throws URISyntaxException {
        log.debug("REST request to update StoreRecommend : {}", storeRecommendDTO);
        if (storeRecommendDTO.getId() == null) {
            return R.error("idnull");
        }
        StoreRecommendDTO result = storeRecommendService.save(storeRecommendDTO);
        return R.ok(result);
    }

    /**
     * {@code GET  /store-recommends} : get all the storeRecommends.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of storeRecommends in body.
     */
    @GetMapping("/store-recommends")
    public R<List<StoreRecommendDTO>> getAllStoreRecommends(Pageable pageable) {
        log.debug("REST request to get a page of StoreRecommends");
        Page<StoreRecommendDTO> page = storeRecommendService.findAll(pageable);
        return R.ok(page.getContent(), page.getTotalElements());
    }

    @GetMapping("/store-recommends-list")
    @ApiOperation("c端-获取商户推荐list")
    public R<List<StoreRecommendDTO>> getAllStoreRecommendsList() {
        log.debug("REST request to get a page of StoreRecommends");
        List<StoreRecommendDTO> list = storeRecommendService.findAllList();
        if (!CollectionUtils.isEmpty(list)) {
            List<Long> storeIds = list.stream().map(StoreRecommendDTO::getStoreId).collect(Collectors.toList());
            List<StoreInfoDTO> storeInfoDTOS = storeInfoService.findAllByIdIn(storeIds);
            Map<Long, StoreInfoDTO> storeInfoDTOMap = storeInfoDTOS.stream().collect(Collectors.toMap(StoreInfoDTO::getId, e -> e));
            list.stream().forEach(e -> {
                e.setStoreInfoDTO(storeInfoDTOMap.get(e.getStoreId()));
            });
        }
        return R.ok(list);
    }

    /**
     * {@code GET  /store-recommends/:id} : get the "id" storeRecommend.
     *
     * @param id the id of the storeRecommendDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the storeRecommendDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/store-recommends/{id}")
    @ApiOperation("根据id获取详细信息")
    public R<StoreRecommendDTO> getStoreRecommend(@PathVariable Long id) {
        log.debug("REST request to get StoreRecommend : {}", id);
        Optional<StoreRecommendDTO> optionalStoreRecommendDTO = storeRecommendService.findOne(id);
        if (!optionalStoreRecommendDTO.isPresent()) {
            return R.errorData();
        }
        StoreRecommendDTO storeRecommendDTO = optionalStoreRecommendDTO.get();
        if (storeRecommendDTO != null) {
            StoreInfoDTO one = storeInfoService.getOne(storeRecommendDTO.getStoreId());
            storeRecommendDTO.setStoreInfoDTO(one);
        }
        return R.ok(storeRecommendDTO);
    }

    /**
     * {@code DELETE  /store-recommends/:id} : delete the "id" storeRecommend.
     *
     * @param id the id of the storeRecommendDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/store-recommends/{id}")
    @ApiOperation("删除商户推荐记录")
    public R deleteStoreRecommend(@PathVariable Long id) {
        log.debug("REST request to delete StoreRecommend : {}", id);
        storeRecommendService.delete(id);
        return R.ok();
    }

    @PutMapping("/store-recommends-top/{id}")
    @ApiOperation("商户推荐记录置顶")
    public R topStoreRecommend(@PathVariable Long id) {
        log.debug("REST request to delete StoreRecommend : {}", id);
        storeRecommendService.topStoreRecommend(id);
        return R.ok();
    }
}
