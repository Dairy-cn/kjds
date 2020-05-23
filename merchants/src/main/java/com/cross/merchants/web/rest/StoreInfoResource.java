package com.cross.merchants.web.rest;

import com.cross.merchants.domain.MerchantsCheckInInfo;
import com.cross.merchants.domain.StoreOperatingRecord;
import com.cross.merchants.service.MerchantsCategoryService;
import com.cross.merchants.service.MerchantsCheckInInfoService;
import com.cross.merchants.service.StoreInfoService;
import com.cross.merchants.service.StoreOperatingRecordService;
import com.cross.merchants.service.dto.MerchantsCategoryDTO;
import com.cross.merchants.service.dto.MerchantsCheckInInfoDTO;
import com.cross.merchants.service.dto.StoreOperatingRecordDTO;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;
import com.cross.merchants.service.dto.StoreInfoDTO;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

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
    public R getStoreInfo(@PathVariable Long id) {
        log.debug("REST request to get StoreInfo : {}", id);
        Optional<StoreInfoDTO> storeInfoDTO = storeInfoService.findOne(id);
        return R.ok(storeInfoDTO.get());
    }

    @GetMapping("/store-infos-by-self")
    @ApiOperation("根据用户获取店铺详细信息")
    public R getStoreInfoByUserId() {
        Long id = CommonUtil.getCurrentLoginUser().getId();
        MerchantsCheckInInfoDTO oneWithSelfByCheckState = merchantsCheckInInfoService.findOneWithSelfByCheckState(id, 1);
        if (oneWithSelfByCheckState == null) {
            return R.error("你未入驻或入驻申请未通过");
        }
        StoreInfoDTO storeInfoDTO = storeInfoService.findFirstByMerchantId(oneWithSelfByCheckState.getId());
        if(storeInfoDTO!=null && storeInfoDTO.getCategoryId()!=null){
            Optional<MerchantsCategoryDTO> merchantsCategoryServiceOne = merchantsCategoryService.findOne(storeInfoDTO.getCategoryId());
            if(merchantsCategoryServiceOne.isPresent()){
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
    public R updateStoreInfo(@ApiParam("记录id") @PathVariable Long id,
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
    public R updateStoreOperatingStatusInfo(@ApiParam("记录id") @PathVariable Long id,
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
    public R updateStoreOperatingStatusInfoWithPlatform(@ApiParam("记录id") @PathVariable Long id,
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
    public R getStoreOperatingRecordList(@ApiParam("店铺id") @PathVariable Long storeId,
                                         @ApiParam("page") Pageable pageable) {
        log.debug("REST request to delete StoreInfo : {}", storeId);
        Page<StoreOperatingRecordDTO> page = storeOperatingRecordService.findAllAndStoreId(pageable, storeId);
        return R.ok(page.getContent(), page.getTotalElements());
    }
}
