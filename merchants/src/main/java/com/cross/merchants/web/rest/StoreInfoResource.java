package com.cross.merchants.web.rest;

import com.cross.merchants.domain.MerchantsCheckInInfo;
import com.cross.merchants.domain.StoreOperatingRecord;
import com.cross.merchants.service.*;
import com.cross.merchants.service.dto.*;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;

import com.cross.utils.CommonUtil;
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
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * REST controller for managing {@link com.cross.merchants.domain.StoreInfo}.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "店铺信息相关接口")
public class StoreInfoResource {

    private final Logger log = LoggerFactory.getLogger(StoreInfoResource.class);

    private static final String ENTITY_NAME = "merchantsStoreInfo";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final StoreInfoService storeInfoService;

    @Autowired
    private StoreOperatingRecordService storeOperatingRecordService;


    @Autowired
    private MerchantsCheckInInfoService merchantsCheckInInfoService;

    @Autowired
    private MerchantsCategoryService merchantsCategoryService;


    @Autowired
    private GoodsService goodsService;

    @Autowired
    private EnterpriseInfoService enterpriseInfoService;

    @Autowired
    private WarehouseInfoService warehouseInfoService;


    public StoreInfoResource(StoreInfoService storeInfoService) {
        this.storeInfoService = storeInfoService;
    }

    /**
     * {@code POST  /store-infos} : Create a new storeInfo.
     *
     * @param storeInfoDTO the storeInfoDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new storeInfoDTO, or with status {@code 400 (Bad Request)} if the storeInfo has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/store-infos")
    public ResponseEntity<StoreInfoDTO> createStoreInfo(@RequestBody StoreInfoDTO storeInfoDTO) throws URISyntaxException {
        log.debug("REST request to save StoreInfo : {}", storeInfoDTO);
        if (storeInfoDTO.getId() != null) {
            throw new BadRequestAlertException("A new storeInfo cannot already have an ID", ENTITY_NAME, "idexists");
        }
        StoreInfoDTO result = storeInfoService.save(storeInfoDTO);
        return ResponseEntity.created(new URI("/api/store-infos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /store-infos} : Updates an existing storeInfo.
     *
     * @param storeInfoDTO the storeInfoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated storeInfoDTO,
     * or with status {@code 400 (Bad Request)} if the storeInfoDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the storeInfoDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/store-infos")
    public ResponseEntity<StoreInfoDTO> updateStoreInfo(@RequestBody StoreInfoDTO storeInfoDTO) throws URISyntaxException {
        log.debug("REST request to update StoreInfo : {}", storeInfoDTO);
        if (storeInfoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        StoreInfoDTO result = storeInfoService.save(storeInfoDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, storeInfoDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /store-infos} : get all the storeInfos.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of storeInfos in body.
     */
    @GetMapping("/store-infos")
    public ResponseEntity<List<StoreInfoDTO>> getAllStoreInfos(Pageable pageable) {
        log.debug("REST request to get a page of StoreInfos");
        Page<StoreInfoDTO> page = storeInfoService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /store-infos/:id} : get the "id" storeInfo.
     *
     * @param id the id of the storeInfoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the storeInfoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/store-infos/{id}")
    @ApiOperation("根据id获取店铺详细信息")
    public R<StoreInfoDTO> getStoreInfo(@PathVariable Long id) {
        log.debug("REST request to get StoreInfo : {}", id);
        Optional<StoreInfoDTO> storeInfoDTO = storeInfoService.findOne(id);
        if (!storeInfoDTO.isPresent()) {
            return R.error("你未入驻或入驻申请未通过");
        }
        StoreInfoDTO infoDTO = storeInfoDTO.get();
        MerchantsCheckInInfoDTO one = merchantsCheckInInfoService.findOne(infoDTO.getMerchantsCheckInInfoId());
        if(one!=null){
            EnterpriseInfoDTO enterpriseInfoDTO = enterpriseInfoService.findFristByMerchantId(one.getId());
            one.setEnterpriseInfoDTO(enterpriseInfoDTO);
        }
        Optional<MerchantsCategoryDTO>  merchantsCategoryDTO= merchantsCategoryService.findOne(infoDTO.getCategoryId());
        if(merchantsCategoryDTO.isPresent()){
            infoDTO.setMerchantsCategoryDTO(merchantsCategoryDTO.get());
        }
        infoDTO.setMerchantsCheckInInfoDTO(one);
        return R.ok(infoDTO);
    }

    @GetMapping("/store-infos-by-self")
    @ApiOperation("根据用户获取店铺详细信息")
    public R<StoreInfoDTO> getStoreInfoByUserId() {
        Long id = CommonUtil.getCurrentLoginUser().getId();
        MerchantsCheckInInfoDTO oneWithSelfByCheckState = merchantsCheckInInfoService.findOneWithSelfByCheckState(id, 1);
        if (oneWithSelfByCheckState == null) {
            return R.error("你未入驻或入驻申请未通过");
        }
        StoreInfoDTO storeInfoDTO = storeInfoService.findFirstByMerchantId(oneWithSelfByCheckState.getId());
        if (storeInfoDTO != null && storeInfoDTO.getCategoryId() != null) {
            Optional<MerchantsCategoryDTO> merchantsCategoryServiceOne = merchantsCategoryService.findOne(storeInfoDTO.getCategoryId());
            if (merchantsCategoryServiceOne.isPresent()) {
                storeInfoDTO.setMerchantsCategoryDTO(merchantsCategoryServiceOne.get());
            }
        }
        return R.ok(storeInfoDTO);
    }

    /**
     * {@code DELETE  /store-infos/:id} : delete the "id" storeInfo.
     *
     * @param id the id of the storeInfoDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/store-infos/{id}")
    public ResponseEntity<Void> deleteStoreInfo(@PathVariable Long id) {
        log.debug("REST request to delete StoreInfo : {}", id);
        storeInfoService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }

    @PutMapping("/update-store-infos/{id}")
    @ApiOperation("商户端--更新店铺信息")
    public R<StoreInfoDTO> updateStoreInfo(@ApiParam("记录id") @PathVariable Long id,
                                           @ApiParam("店铺名称") @RequestParam String storeName,
                                           @ApiParam("店铺logo") @RequestParam String storeLogo) {
        log.debug("REST request to delete StoreInfo : {}", id);
        StoreInfoDTO storeInfoDTO = storeInfoService.findOne(id).get();
        if (storeInfoDTO == null) {
            return R.error("记录不存在");
        }
        storeInfoDTO.setStoreName(storeName);
        storeInfoDTO.setStoreLogo(storeLogo);
        storeInfoDTO = storeInfoService.save(storeInfoDTO);
        return R.ok(storeInfoDTO);
    }

    @PutMapping("/update-store-operating-status-infos-with-merchants/{id}")
    @ApiOperation("商户端--更新店铺营业状况")
    public R<StoreInfoDTO> updateStoreOperatingStatusInfo(@ApiParam("记录id") @PathVariable Long id,
                                                          @ApiParam("店铺名称营业状况 1 正常营业 0  休息") @RequestParam Integer operatingStatus) {
        log.debug("REST request to delete StoreInfo : {}", id);
        if (operatingStatus == null) {
            return R.error("营业状况不能为空");
        }
        StoreInfoDTO storeInfoDTO = storeInfoService.findOne(id).get();
        if (storeInfoDTO == null) {
            return R.error("记录不存在");
        }
        storeInfoDTO = storeInfoService.updateStoreOperatingStatusInfoWithMerchants(id, operatingStatus);
        return R.ok(storeInfoDTO);
    }


    @PutMapping("/update-store-operating-status-infos-with-platform/{id}")
    @ApiOperation("大后台--更新店铺营业状况")
    public R<StoreInfoDTO> updateStoreOperatingStatusInfoWithPlatform(@ApiParam("记录id") @PathVariable Long id,
                                                                      @ApiParam("店铺名称营业状况 1 正常营业 0  休息") @RequestParam Integer operatingStatus,
                                                                      @ApiParam(value = "关闭原因", required = false) @RequestParam(required = false) String closeReason) {
        log.debug("REST request to delete StoreInfo : {}", id);
        if (operatingStatus == null) {
            return R.error("营业状况不能为空");
        }
        StoreInfoDTO storeInfoDTO = storeInfoService.findOne(id).get();
        if (storeInfoDTO == null) {
            return R.error("记录不存在");
        }
        storeInfoDTO = storeInfoService.updateStoreOperatingStatusInfoWithPlatform(id, operatingStatus, closeReason);
        return R.ok(storeInfoDTO);
    }

    @GetMapping("/store-operating-record-infos/{storeId}")
    @ApiOperation("获取店铺开关闭记录列表")
    public R<List<StoreOperatingRecordDTO>> getStoreOperatingRecordList(@ApiParam("店铺id") @PathVariable Long storeId,
                                                                        @ApiParam("page") Pageable pageable) {
        log.debug("REST request to delete StoreInfo : {}", storeId);
        Page<StoreOperatingRecordDTO> page = storeOperatingRecordService.findAllAndStoreId(pageable, storeId);
        return R.ok(page.getContent(), page.getTotalElements());
    }


    @GetMapping("/store-infos-list")
    @ApiOperation("根据条件获取审核通过且在运营的店铺列表")
    public R getAllStoreInfosByCondition(@ApiParam(required = false, value = "主营业务id") @RequestParam(required = false) Long categoryId,
                                         @ApiParam(required = false, value = "店铺名称或编号") @RequestParam(required = false) String keyWord) {
        log.debug("REST request to get a page of StoreInfos");
        List<StoreInfoDTO> page = storeInfoService.findAllByOperatingStatus(1, categoryId, keyWord);
        return R.ok(page);
    }

    @GetMapping("/store-infos-page")
    @ApiOperation("大后台---通过条件获取商户店铺列表")
    public R<List<StoreInfoDTO>> getAllStoreInfosByCondition(Pageable pageable,
                                                             @ApiParam("营业状态  1 正常 0 休息中") @RequestParam(required = false) Integer operatingStatus,
                                                             @ApiParam("主营类目") @RequestParam(required = false) Long categoryId,
                                                             @ApiParam("仓库类型 1 自有仓库 2 三方代发") @RequestParam(required = false) Integer warehouseType,
                                                             @ApiParam("创建开始时间 eg 2017-11-27T03:16:03Z") @RequestParam(required = false) Instant startTime,
                                                             @ApiParam("创建结束时间 eg 2017-11-27T03:16:03Z ") @RequestParam(required = false) Instant endTime,
                                                             @ApiParam("关键字查询") @RequestParam(required = false) String keyWord) {
        log.debug("REST request to get a page of StoreInfos");
        Page<StoreInfoDTO> page = storeInfoService.getAllStoreInfosByCondition(pageable, operatingStatus, categoryId, warehouseType, keyWord, startTime, endTime);
        List<StoreInfoDTO> content = page.getContent();
        if (!CollectionUtils.isEmpty(content)) {
            List<Long> categoryIds = content.stream().filter(e -> e.getCategoryId() != null).map(StoreInfoDTO::getCategoryId).distinct().collect(Collectors.toList());
            List<MerchantsCategoryDTO> merchantsCategoryDTOS = merchantsCategoryService.findAllByIdIn(categoryIds);
            Map<Long, MerchantsCategoryDTO> merchantsCategoryDTOMap = merchantsCategoryDTOS.stream().collect(Collectors.toMap(MerchantsCategoryDTO::getId, e -> e));
            content.stream().filter(e -> e.getCategoryId() != null).forEach(e -> {
                e.setMerchantsCategoryDTO(merchantsCategoryDTOMap.get(e.getCategoryId()));
            });
            List<Long> merchantIds = content.stream().filter(e -> e.getMerchantsCheckInInfoId() != null).map(StoreInfoDTO::getMerchantsCheckInInfoId).distinct().collect(Collectors.toList());

            Map<Long, MerchantsCheckInInfoDTO> merchantsCheckInInfoDTOMap = new HashMap<>(16);
            //获取企业信息
            if (!CollectionUtils.isEmpty(merchantIds)) {
                List<MerchantsCheckInInfoDTO> merchantsCheckInInfoDTOS = merchantsCheckInInfoService.findAllByIdIn(merchantIds);
                List<EnterpriseInfoDTO> enterpriseInfoDTOS = enterpriseInfoService.findAllByMerchantIdIn(merchantIds);
                Map<Long, EnterpriseInfoDTO> enterpriseInfoDTOMap = enterpriseInfoDTOS.stream().collect(Collectors.toMap(EnterpriseInfoDTO::getMerchantId, e -> e));
                List<WarehouseInfoDTO> warehouseInfoDTOS = warehouseInfoService.findAllByMerchantIdIn(merchantIds);
                Map<Long, WarehouseInfoDTO> warehouseInfoDTOMap = warehouseInfoDTOS.stream().collect(Collectors.toMap(WarehouseInfoDTO::getMerchantId, e -> e));

                merchantsCheckInInfoDTOS.stream().forEach(e -> {
                    e.setEnterpriseInfoDTO(enterpriseInfoDTOMap.get(e.getId()));
                    e.setWarehouseInfoDTO(warehouseInfoDTOMap.get(e.getId()));
                });
                merchantsCheckInInfoDTOMap = merchantsCheckInInfoDTOS.stream().collect(Collectors.toMap(MerchantsCheckInInfoDTO::getId, e -> e));
            }
            Map<Long, MerchantsCheckInInfoDTO> finalMerchantsCheckInInfoDTOMap = merchantsCheckInInfoDTOMap;
            content.stream().forEach(e->{
                e.setMerchantsCheckInInfoDTO(finalMerchantsCheckInInfoDTOMap.get(e.getMerchantsCheckInInfoId()));
            });
        }
        return R.ok(content, page.getTotalElements());
    }


    @GetMapping("/store-infos-c/{id}")
    @ApiOperation("C端------根据id获取店铺详细信息")
    public R<StoreInfoDTO> getStoreInfoShowC(@PathVariable Long id, Pageable pageable) {
        log.debug("REST request to get StoreInfo : {}", id);
        Optional<StoreInfoDTO> storeInfoDTO = storeInfoService.findOne(id);
        if (!storeInfoDTO.isPresent()) {
            return R.error(null);
        }
        if (storeInfoDTO.get().getOperatingStatus() == null || storeInfoDTO.get().getOperatingStatus() != 1) {
            return R.error("门店休息中...");
        }
        StoreInfoDTO infoDTO = storeInfoDTO.get();
        Page<GoodsDTO> page = goodsService.findAllByStoreId(pageable, infoDTO.getId());
        infoDTO.setGoodsDTOList(page.getContent());
        return R.ok(infoDTO, page.getTotalElements());
    }

}
