package com.cross.merchants.web.rest;

import com.cross.merchants.service.BrandService;
import com.cross.merchants.service.GlobalRegionService;
import com.cross.merchants.service.MerchantsCheckInInfoService;
import com.cross.merchants.service.StoreInfoService;
import com.cross.merchants.service.dto.GlobalRegionDTO;
import com.cross.merchants.service.dto.MerchantsCheckInInfoDTO;
import com.cross.merchants.service.dto.StoreInfoDTO;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;
import com.cross.merchants.service.dto.BrandDTO;

import com.cross.utils.CommonUtil;
import com.cross.utils.R;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
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

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for managing {@link com.cross.merchants.domain.Brand}.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "品牌相关接口")
public class BrandResource {

    private final Logger log = LoggerFactory.getLogger(BrandResource.class);

    private static final String ENTITY_NAME = "merchantsBrand";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BrandService brandService;


    @Autowired
    private StoreInfoService storeInfoService;

    private final GlobalRegionService globalRegionService;

    private final MerchantsCheckInInfoService merchantsCheckInInfoService;

    public BrandResource(BrandService brandService, GlobalRegionService globalRegionService, MerchantsCheckInInfoService merchantsCheckInInfoService) {
        this.brandService = brandService;
        this.globalRegionService = globalRegionService;
        this.merchantsCheckInInfoService = merchantsCheckInInfoService;
    }

    /**
     * {@code POST  /brands} : Create a new brand.
     *
     * @param brandDTO the brandDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new brandDTO, or with status {@code 400 (Bad Request)} if the brand has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/brands")
    @ApiOperation("添加品牌信息")
    public R createBrand(@RequestBody BrandDTO brandDTO) throws URISyntaxException {
        log.debug("REST request to save Brand : {}", brandDTO);
        if (brandDTO.getId() != null) {
            return R.error("idexists");
        }
        brandDTO.setApplicationTime(Instant.now());
        brandDTO.setCheckStatus(-1);
        brandDTO.setProposer(CommonUtil.getCurrentLoginUser().getId());
        BrandDTO result = brandService.save(brandDTO);
        return R.ok(result);
    }

    @PutMapping("/re-upload-brand-check-in-infos")
    @ApiOperation("重新编辑品牌信息")
    public R reUploadCompanyInfo(@RequestBody BrandDTO brandDTO) throws URISyntaxException {
        log.debug("REST request to update MerchantsCheckInInfo : {}", brandDTO);
        if (brandDTO.getId() == null) {
            return R.error("idnull");
        }

        BrandDTO dbOne = brandService.findOne(brandDTO.getId());
        if (dbOne == null) {
            return R.error("记录错误,找不到记录");
        }
        if (1 == dbOne.getCheckStatus()) {
            return R.error("您的记录已经审核通过");
        }
        brandDTO.setApplicationTime(Instant.now());
        brandDTO.setCheckStatus(-1);
        BrandDTO result = brandService.save(brandDTO);
        return R.ok(result);
    }


    /**
     * {@code PUT  /brands} : Updates an existing brand.
     *
     * @param brandDTO the brandDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated brandDTO,
     * or with status {@code 400 (Bad Request)} if the brandDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the brandDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/brands")
    public R updateBrand(@RequestBody BrandDTO brandDTO) throws URISyntaxException {
        log.debug("REST request to update Brand : {}", brandDTO);
        if (brandDTO.getId() == null) {
            return R.error("idnull");
        }
        BrandDTO result = brandService.save(brandDTO);
        return R.ok(result);
    }

    /**
     * {@code GET  /brands} : get all the brands.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of brands in body.
     */
    @GetMapping("/brands")
    public R getAllBrands(Pageable pageable) {
        log.debug("REST request to get a page of Brands");
        Page<BrandDTO> page = brandService.findAll(pageable);
        return R.ok(page.getContent(),page.getTotalElements());
    }

    /**
     * {@code GET  /brands/:id} : get the "id" brand.
     *
     * @param id the id of the brandDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the brandDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/brands/{id}")
    @ApiOperation("根据记录id获取信息")
    public R getBrand(@PathVariable Long id) {
        log.debug("REST request to get Brand : {}", id);
        BrandDTO brandDTO = brandService.findOne(id);
        if (brandDTO != null) {
            List<Long> regionIds = new ArrayList<>();
            if (brandDTO.getBrandCountryId() != null) {
                regionIds.add(brandDTO.getBrandCountryId());
            }
            if (!CollectionUtils.isEmpty(regionIds)) {
                List<GlobalRegionDTO> globalRegionDTOS = globalRegionService.findAllByIdIn(regionIds);
                Map<Long, String> map = globalRegionDTOS.stream().collect(Collectors.toMap(GlobalRegionDTO::getId, GlobalRegionDTO::getName));
                if (brandDTO.getBrandCountryId() != null) {
                    brandDTO.setBrandCountry(map.get(brandDTO.getBrandCountryId()));
                }
            }
        }
        return R.ok(brandDTO);
    }

    /**
     * {@code DELETE  /brands/:id} : delete the "id" brand.
     *
     * @param id the id of the brandDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/brands/{id}")
    public R deleteBrand(@PathVariable Long id) {
        log.debug("REST request to delete Brand : {}", id);
        brandService.delete(id);
        return R.ok();
    }


    @PostMapping("/check-brand-check-in-infos/{id}")
    @ApiOperation("大后台--品牌审核")
    public R brandCheckInInfo(@ApiParam("记录id") @PathVariable Long id,
                              @ApiParam(value = "审核状态 true 通过 false 失败", required = true) @RequestParam(required = true) Boolean status,
                              @ApiParam("失败原因") @RequestParam String checkFailureReasons) {
        log.debug("REST request to delete brandDTO : {}", id);
        BrandDTO brandDTO = brandService.findOne(id);
        if (brandDTO == null) {
            return R.error("记录不存在");
        }
        if (1 == brandDTO.getCheckStatus() || 0 == brandDTO.getCheckStatus()) {
            return R.error("记录已经审核过了，不能重复审核");
        }
        if (status == null) {
            return R.error("审核状态不能为空");
        }
        brandDTO.setCheckStatus(status ? 1 : 0);
        brandDTO.setCheckTime(Instant.now());
        brandDTO.setCheckFailureReasons(checkFailureReasons);
        brandDTO = brandService.brandCheckInInfo(brandDTO);
        return R.ok(brandDTO);
    }


    @GetMapping("/brand-check-in-infos-wait-check-in-list-info")
    @ApiOperation("大后台--获取品牌未审核记录")
    public R getAllBrandCheckInInfosWithWaitCheckInInfo(Pageable pageable) {
        log.debug("REST request to get a page of MerchantsCheckInInfos");
        Page<BrandDTO> page = brandService.findAllWithWaitCheckIn(pageable);
        if (!CollectionUtils.isEmpty(page.getContent())) {
            List<Long> regionIds = new ArrayList<>();
            regionIds = page.getContent().stream().filter(e -> e.getBrandCountryId() != null).map(e -> e.getBrandCountryId()).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(regionIds)) {
                List<GlobalRegionDTO> globalRegionDTOS = globalRegionService.findAllByIdIn(regionIds);
                Map<Long, String> map = globalRegionDTOS.stream().collect(Collectors.toMap(GlobalRegionDTO::getId, GlobalRegionDTO::getName));
                page.getContent().stream().filter(e -> e.getBrandCountryId() != null).forEach(e->{
                    e.setBrandCountry(map.get(e.getBrandCountryId()));
                });
            }
        }
        return R.ok(page.getContent(), page.getTotalElements());
    }

    @GetMapping("/get-brand-with-self-submit-info")
    @ApiOperation("商户端--获取自己提交的品牌审核记录")
    public R getSelfSubmitInfo(Pageable pageable,
                               @ApiParam(required = false, value = "审核状态 1 审核通过 -1 未审核 0  审核失败 null 为全部") @RequestParam(required = false) Integer checkStatus) {

        Long id = CommonUtil.getCurrentLoginUser().getId();
        StoreInfoDTO storeInfoDTO = storeInfoService.findByCreateUserId(id);
        if (storeInfoDTO == null) {
            return R.ok();
        }
        Page<BrandDTO> page = brandService.findAllByStatusAndStoreId(pageable, checkStatus, storeInfoDTO.getId());
        if (!CollectionUtils.isEmpty(page.getContent())) {
            List<Long> regionIds = new ArrayList<>();
            regionIds = page.getContent().stream().filter(e -> e.getBrandCountryId() != null).map(e -> e.getBrandCountryId()).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(regionIds)) {
                List<GlobalRegionDTO> globalRegionDTOS = globalRegionService.findAllByIdIn(regionIds);
                Map<Long, String> map = globalRegionDTOS.stream().collect(Collectors.toMap(GlobalRegionDTO::getId, GlobalRegionDTO::getName));
                page.getContent().stream().filter(e -> e.getBrandCountryId() != null).forEach(e->{
                    e.setBrandCountry(map.get(e.getBrandCountryId()));
                });
            }
        }
        return R.ok(page.getContent(), page.getTotalElements());
    }

    @GetMapping("/get-check-success-brand-with-self-submit-info")
    @ApiOperation("商户端--(未分页)获取自己审核已通过的品牌信息")
    public R getSelfSubmitInfoAndCheckSuccess() {

        Long id = CommonUtil.getCurrentLoginUser().getId();
        StoreInfoDTO storeInfoDTO = storeInfoService.findByCreateUserId(id);
        if (storeInfoDTO == null) {
            return R.ok();
        }
        List<BrandDTO> list = brandService.findAllByStatusAndStoreId(1, storeInfoDTO.getId());
        if (!CollectionUtils.isEmpty(list)) {
            List<Long> regionIds = new ArrayList<>();
            regionIds = list.stream().filter(e -> e.getBrandCountryId() != null).map(e -> e.getBrandCountryId()).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(regionIds)) {
                List<GlobalRegionDTO> globalRegionDTOS = globalRegionService.findAllByIdIn(regionIds);
                Map<Long, String> map = globalRegionDTOS.stream().collect(Collectors.toMap(GlobalRegionDTO::getId, GlobalRegionDTO::getName));
                list.stream().filter(e -> e.getBrandCountryId() != null).forEach(e->{
                    e.setBrandCountry(map.get(e.getBrandCountryId()));
                });
            }
        }
        return R.ok(list);
    }

}
