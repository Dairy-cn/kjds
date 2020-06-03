package com.cross.merchants.web.rest;

import com.cross.merchants.service.GlobalRegionService;
import com.cross.merchants.service.MerchantsCheckInInfoService;
import com.cross.merchants.service.StoreInfoService;
import com.cross.merchants.service.WarehouseInfoService;
import com.cross.merchants.service.dto.*;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;

import com.cross.utils.CommonUtil;
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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for managing {@link com.cross.merchants.domain.WarehouseInfo}.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "企业仓库信息相关接口")
public class WarehouseInfoResource {

    private final Logger log = LoggerFactory.getLogger(WarehouseInfoResource.class);

    private static final String ENTITY_NAME = "merchantsWarehouseInfo";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final WarehouseInfoService warehouseInfoService;


    private final MerchantsCheckInInfoService merchantsCheckInInfoService;

    private final GlobalRegionService globalRegionService;

    @Autowired
    private StoreInfoService storeInfoService;

    public WarehouseInfoResource(WarehouseInfoService warehouseInfoService, MerchantsCheckInInfoService merchantsCheckInInfoService, GlobalRegionService globalRegionService) {
        this.warehouseInfoService = warehouseInfoService;
        this.merchantsCheckInInfoService = merchantsCheckInInfoService;
        this.globalRegionService = globalRegionService;
    }

    /**
     * {@code POST  /warehouse-infos} : Create a new warehouseInfo.
     *
     * @param warehouseInfoDTO the warehouseInfoDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new warehouseInfoDTO, or with status {@code 400 (Bad Request)} if the warehouseInfo has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/warehouse-infos")
    @ApiOperation("商户端--添加仓库信息")
    public R<WarehouseInfoDTO> createWarehouseInfo(@RequestBody WarehouseInfoDTO warehouseInfoDTO) throws URISyntaxException {
        log.debug("REST request to save WarehouseInfo : {}", warehouseInfoDTO);
        if (warehouseInfoDTO.getId() != null) {
            return R.error("idexists");
        }
        Long id = CommonUtil.getCurrentLoginUser().getId();
        MerchantsCheckInInfoDTO oneWithSelfByCheckState = merchantsCheckInInfoService.findOneWithSelfByCheckState(id, 1);
        if (oneWithSelfByCheckState == null) {
            return R.error("您还未入驻");
        }
        if (oneWithSelfByCheckState.getId() != warehouseInfoDTO.getMerchantId()) {
            return R.accessError();
        }
        if (warehouseInfoDTO.getShipmentsAndReturnsInfoNoDifference() != null && warehouseInfoDTO.getShipmentsAndReturnsInfoNoDifference()) {
            warehouseInfoDTO.setReturnWarehouseCityId(warehouseInfoDTO.getCityId());
            warehouseInfoDTO.setReturnWarehouseCountryID(warehouseInfoDTO.getCountryID());
            warehouseInfoDTO.setReturnWarehouseProvinceId(warehouseInfoDTO.getProvinceId());
            warehouseInfoDTO.setReturnWarehouseContact(warehouseInfoDTO.getContacts());
            warehouseInfoDTO.setReturnWarehousePhone(warehouseInfoDTO.getTelephone());
            warehouseInfoDTO.setReturnWarehouseAddress(warehouseInfoDTO.getAddress());


        }
        WarehouseInfoDTO result = warehouseInfoService.save(warehouseInfoDTO);
        return R.ok(result);
    }

    /**
     * {@code PUT  /warehouse-infos} : Updates an existing warehouseInfo.
     *
     * @param warehouseInfoDTO the warehouseInfoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated warehouseInfoDTO,
     * or with status {@code 400 (Bad Request)} if the warehouseInfoDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the warehouseInfoDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/warehouse-infos")
    @ApiOperation("商户端--修改企业仓库信息")
    public R<WarehouseInfoDTO> updateWarehouseInfo(@RequestBody WarehouseInfoDTO warehouseInfoDTO) throws URISyntaxException {
        log.debug("REST request to update WarehouseInfo : {}", warehouseInfoDTO);
        if (warehouseInfoDTO.getId() == null) {
            return R.error("idnull");
        }
        Long id = CommonUtil.getCurrentLoginUser().getId();
        MerchantsCheckInInfoDTO oneWithSelfByCheckState = merchantsCheckInInfoService.findOneWithSelfByCheckState(id, 1);
        if (oneWithSelfByCheckState == null) {
            return R.error("您还未入驻");
        }
        if (oneWithSelfByCheckState.getId() != warehouseInfoDTO.getMerchantId()) {
            return R.accessError();
        }
        WarehouseInfoDTO result = warehouseInfoService.save(warehouseInfoDTO);
        return R.ok(result);
    }

    /**
     * {@code GET  /warehouse-infos} : get all the warehouseInfos.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of warehouseInfos in body.
     */
    @GetMapping("/warehouse-infos")
    public R<List<WarehouseInfoDTO>> getAllWarehouseInfos(Pageable pageable) {
        log.debug("REST request to get a page of WarehouseInfos");
        Page<WarehouseInfoDTO> page = warehouseInfoService.findAll(pageable);
        return R.ok(page.getContent(),page.getTotalElements());
    }

    /**
     * {@code GET  /warehouse-infos/:id} : get the "id" warehouseInfo.
     *
     * @param id the id of the warehouseInfoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the warehouseInfoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/warehouse-infos/{id}")
    @ApiOperation("根据记录id获取企业仓库信息")
    public R<WarehouseInfoDTO> getWarehouseInfo(@PathVariable Long id) {
        log.debug("REST request to get WarehouseInfo : {}", id);
        Optional<WarehouseInfoDTO> warehouseInfoDTO = warehouseInfoService.findOne(id);
        return R.ok(warehouseInfoDTO.get());
    }

    @GetMapping("/warehouse-infos-by-user")
    @ApiOperation("根据登录者获取企业仓库信息")
    public R<WarehouseInfoDTO> getEnterpriseInfoByUser() {
        Long id = CommonUtil.getCurrentLoginUser().getId();
        MerchantsCheckInInfoDTO oneWithSelfByCheckState = merchantsCheckInInfoService.findOneWithSelfByCheckState(id, 1);
        if (oneWithSelfByCheckState == null) {
            return R.error("您还未入驻");
        }
        WarehouseInfoDTO warehouseInfoDTO = warehouseInfoService.findFristByMerchantId(oneWithSelfByCheckState.getId());
        warehouseInfoDTO = getAddressInfo(warehouseInfoDTO);
        return R.ok(warehouseInfoDTO);
    }

    @GetMapping("/warehouse-infos-by-store-id/{storeId}")
    @ApiOperation("根据商户id获取企业仓库信息")
    public R<WarehouseInfoDTO> getEnterpriseInfoByStoreId(@PathVariable Long storeId) {
        Optional<StoreInfoDTO> infoDTO = storeInfoService.findOne(storeId);
        if(!infoDTO.isPresent()){
            return R.error();
        }
        WarehouseInfoDTO warehouseInfoDTO = warehouseInfoService.findFristByMerchantId(infoDTO.get().getMerchantsCheckInInfoId());
        warehouseInfoDTO = getAddressInfo(warehouseInfoDTO);
        return R.ok(warehouseInfoDTO);
    }


    /**
     * {@code DELETE  /warehouse-infos/:id} : delete the "id" warehouseInfo.
     *
     * @param id the id of the warehouseInfoDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/warehouse-infos/{id}")
    public R deleteWarehouseInfo(@PathVariable Long id) {
        log.debug("REST request to delete WarehouseInfo : {}", id);
        warehouseInfoService.delete(id);
        return R.ok();
    }


    /**
     * 获取地址信息
     *
     * @param warehouseInfoDTO
     * @return
     */

    private WarehouseInfoDTO getAddressInfo(WarehouseInfoDTO warehouseInfoDTO) {
        if (warehouseInfoDTO != null) {
            List<Long> regionIds = new ArrayList<>();
            if (warehouseInfoDTO.getCountryID() != null) {
                regionIds.add(warehouseInfoDTO.getCountryID());
            }
            if (warehouseInfoDTO.getProvinceId() != null) {
                regionIds.add(warehouseInfoDTO.getProvinceId());
            }
            if (warehouseInfoDTO.getCityId() != null) {
                regionIds.add(warehouseInfoDTO.getCityId());
            }

            if (warehouseInfoDTO.getReturnWarehouseCountryID() != null) {
                regionIds.add(warehouseInfoDTO.getReturnWarehouseCountryID());
            }
            if (warehouseInfoDTO.getReturnWarehouseProvinceId() != null) {
                regionIds.add(warehouseInfoDTO.getReturnWarehouseProvinceId());
            }
            if (warehouseInfoDTO.getReturnWarehouseCityId() != null) {
                regionIds.add(warehouseInfoDTO.getReturnWarehouseCityId());
            }
            if (!CollectionUtils.isEmpty(regionIds)) {
                regionIds = regionIds.stream().distinct().collect(Collectors.toList());
                List<GlobalRegionDTO> globalRegionDTOS = globalRegionService.findAllByIdIn(regionIds);
                Map<Long, String> map = globalRegionDTOS.stream().collect(Collectors.toMap(GlobalRegionDTO::getId, GlobalRegionDTO::getName));
                if (warehouseInfoDTO.getCountryID() != null) {
                    warehouseInfoDTO.setCountry(map.get(warehouseInfoDTO.getCountryID()));
                }
                if (warehouseInfoDTO.getProvinceId() != null) {
                    warehouseInfoDTO.setProvince(map.get(warehouseInfoDTO.getProvinceId()));
                }
                if (warehouseInfoDTO.getCityId() != null) {
                    warehouseInfoDTO.setCity(map.get(warehouseInfoDTO.getCityId()));
                }

                if (warehouseInfoDTO.getReturnWarehouseCountryID() != null) {
                    warehouseInfoDTO.setCountry(map.get(warehouseInfoDTO.getReturnWarehouseCountryID()));
                }
                if (warehouseInfoDTO.getReturnWarehouseProvinceId() != null) {
                    warehouseInfoDTO.setReturnWarehouseProvince(map.get(warehouseInfoDTO.getReturnWarehouseProvinceId()));
                }
                if (warehouseInfoDTO.getReturnWarehouseCityId() != null) {
                    warehouseInfoDTO.setReturnWarehouseCity(map.get(warehouseInfoDTO.getReturnWarehouseCityId()));
                }
            }
        }
        return warehouseInfoDTO;
    }
}
