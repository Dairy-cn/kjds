package com.cross.merchants.web.rest;

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
 * REST controller for managing {@link com.cross.merchants.domain.EnterpriseInfo}.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "企业账户信息相关接口")
public class EnterpriseInfoResource {

    private final Logger log = LoggerFactory.getLogger(EnterpriseInfoResource.class);

    private static final String ENTITY_NAME = "merchantsEnterpriseInfo";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EnterpriseInfoService enterpriseInfoService;


    private final MerchantsCheckInInfoService merchantsCheckInInfoService;

    private final GlobalRegionService globalRegionService;


    private final BankInfoService bankInfoService;

    @Autowired
    private StoreInfoService storeInfoService;

    public EnterpriseInfoResource(EnterpriseInfoService enterpriseInfoService, MerchantsCheckInInfoService merchantsCheckInInfoService, GlobalRegionService globalRegionService, BankInfoService bankInfoService) {
        this.enterpriseInfoService = enterpriseInfoService;
        this.merchantsCheckInInfoService = merchantsCheckInInfoService;
        this.globalRegionService = globalRegionService;
        this.bankInfoService = bankInfoService;
    }

    /**
     * {@code POST  /enterprise-infos} : Create a new enterpriseInfo.
     *
     * @param enterpriseInfoDTO the enterpriseInfoDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new enterpriseInfoDTO, or with status {@code 400 (Bad Request)} if the enterpriseInfo has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/enterprise-infos")
    @ApiOperation("商户端--创建企业信息")
    public R createEnterpriseInfo(@RequestBody EnterpriseInfoDTO enterpriseInfoDTO) throws URISyntaxException {
        log.debug("REST request to save EnterpriseInfo : {}", enterpriseInfoDTO);
        if (enterpriseInfoDTO.getId() != null) {
            return R.error("idexists");
        }
        Long id = CommonUtil.getCurrentLoginUser().getId();
        MerchantsCheckInInfoDTO oneWithSelfByCheckState = merchantsCheckInInfoService.findOneWithSelfByCheckState(id, 1);
        if (oneWithSelfByCheckState == null) {
            return R.error("您还未入驻");
        }
        if (oneWithSelfByCheckState.getId() != enterpriseInfoDTO.getMerchantId()) {
            return R.accessError();
        }
        EnterpriseInfoDTO result = enterpriseInfoService.save(enterpriseInfoDTO);
        return R.ok(result);
    }

    /**
     * {@code PUT  /enterprise-infos} : Updates an existing enterpriseInfo.
     *
     * @param enterpriseInfoDTO the enterpriseInfoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated enterpriseInfoDTO,
     * or with status {@code 400 (Bad Request)} if the enterpriseInfoDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the enterpriseInfoDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/enterprise-infos")
    @ApiOperation("商户端--修改企业信息")
    public R updateEnterpriseInfo(@RequestBody EnterpriseInfoDTO enterpriseInfoDTO) throws URISyntaxException {
        log.debug("REST request to update EnterpriseInfo : {}", enterpriseInfoDTO);
        if (enterpriseInfoDTO.getId() == null) {
            return R.error("idnull");
        }
        Long id = CommonUtil.getCurrentLoginUser().getId();
        MerchantsCheckInInfoDTO oneWithSelfByCheckState = merchantsCheckInInfoService.findOneWithSelfByCheckState(id, 1);
        if (oneWithSelfByCheckState == null) {
            return R.error("您还未入驻");
        }
        if (oneWithSelfByCheckState.getId() != enterpriseInfoDTO.getMerchantId()) {
            return R.accessError();
        }
        EnterpriseInfoDTO result = enterpriseInfoService.save(enterpriseInfoDTO);
        return R.ok(result);
    }

    /**
     * {@code GET  /enterprise-infos} : get all the enterpriseInfos.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of enterpriseInfos in body.
     */
    @GetMapping("/enterprise-infos")
    public ResponseEntity<List<EnterpriseInfoDTO>> getAllEnterpriseInfos(Pageable pageable) {
        log.debug("REST request to get a page of EnterpriseInfos");
        Page<EnterpriseInfoDTO> page = enterpriseInfoService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /enterprise-infos/:id} : get the "id" enterpriseInfo.
     *
     * @param id the id of the enterpriseInfoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the enterpriseInfoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/enterprise-infos/{id}")
    @ApiOperation("根据记录id获取企业账户信息")
    public R getEnterpriseInfo(@PathVariable Long id) {
        log.debug("REST request to get EnterpriseInfo : {}", id);
        Optional<EnterpriseInfoDTO> enterpriseInfoDTO = enterpriseInfoService.findOne(id);
        return R.ok(enterpriseInfoDTO.get());
    }

    @GetMapping("/enterprise-infos-by-user")
    @ApiOperation("根据登录者获取企业账户信息")
    public R getEnterpriseInfoByUser() {
        Long id = CommonUtil.getCurrentLoginUser().getId();
        MerchantsCheckInInfoDTO oneWithSelfByCheckState = merchantsCheckInInfoService.findOneWithSelfByCheckState(id, 1);
        if (oneWithSelfByCheckState == null) {
            return R.error("您还未入驻");
        }
        EnterpriseInfoDTO enterpriseInfoDTO = enterpriseInfoService.findFristByMerchantId(oneWithSelfByCheckState.getId());
        enterpriseInfoDTO = getAddressInfo(enterpriseInfoDTO);
        if (enterpriseInfoDTO != null && enterpriseInfoDTO.getBankId() != null) {
            Optional<BankInfoDTO> one = bankInfoService.findOne(enterpriseInfoDTO.getId());
            if (one.isPresent()) {
                enterpriseInfoDTO.setBankName(one.get().getName());
            }
        }
        return R.ok(enterpriseInfoDTO);
    }


    /**
     * {@code DELETE  /enterprise-infos/:id} : delete the "id" enterpriseInfo.
     *
     * @param id the id of the enterpriseInfoDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/enterprise-infos/{id}")
    public R deleteEnterpriseInfo(@PathVariable Long id) {
        log.debug("REST request to delete EnterpriseInfo : {}", id);
        enterpriseInfoService.delete(id);
        return R.ok();
    }


    /**
     * 获取地址信息
     *
     * @param enterpriseInfoDTO
     * @return
     */

    private EnterpriseInfoDTO getAddressInfo(EnterpriseInfoDTO enterpriseInfoDTO) {
        if (enterpriseInfoDTO != null) {
            List<Long> regionIds = new ArrayList<>();
            if (enterpriseInfoDTO.getCountryId() != null) {
                regionIds.add(enterpriseInfoDTO.getCountryId());
            }
            if (enterpriseInfoDTO.getProvinceId() != null) {
                regionIds.add(enterpriseInfoDTO.getProvinceId());
            }
            if (enterpriseInfoDTO.getCityId() != null) {
                regionIds.add(enterpriseInfoDTO.getCityId());
            }
            if (!CollectionUtils.isEmpty(regionIds)) {
                List<GlobalRegionDTO> globalRegionDTOS = globalRegionService.findAllByIdIn(regionIds);
                Map<Long, String> map = globalRegionDTOS.stream().collect(Collectors.toMap(GlobalRegionDTO::getId, GlobalRegionDTO::getName));
                if (enterpriseInfoDTO.getCountryId() != null) {
                    enterpriseInfoDTO.setCountry(map.get(enterpriseInfoDTO.getCountryId()));
                }
                if (enterpriseInfoDTO.getProvinceId() != null) {
                    enterpriseInfoDTO.setProvince(map.get(enterpriseInfoDTO.getProvinceId()));
                }
                if (enterpriseInfoDTO.getCityId() != null) {
                    enterpriseInfoDTO.setCity(map.get(enterpriseInfoDTO.getCityId()));
                }
            }
        }
        return enterpriseInfoDTO;
    }


    @GetMapping("/enterprise-infos-page")
    @ApiOperation("大后台--商户账户列表")
    public R<List<EnterpriseInfoDTO>> getAllEnterpriseInfosNoPage(Pageable pageable) {
        log.debug("REST request to get a page of EnterpriseInfos");
        Page<EnterpriseInfoDTO> page = enterpriseInfoService.findAll(pageable);
        List<EnterpriseInfoDTO> content = page.getContent();
        if(!CollectionUtils.isEmpty(content)){
            List<Long> brandIds = content.stream().filter(e -> e.getBankId() != null).map(EnterpriseInfoDTO::getBankId).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(brandIds)){
                List<BankInfoDTO> bankInfoDTOS = bankInfoService.findAllByIdIn(brandIds);
                if(!CollectionUtils.isEmpty(bankInfoDTOS)){
                    Map<Long, BankInfoDTO> BankInfoDTOMap = bankInfoDTOS.stream().collect(Collectors.toMap(BankInfoDTO::getId, e -> e));
                    content.stream().filter(e->e.getBankId()!=null).forEach(e->{
                        BankInfoDTO bankInfoDTO = BankInfoDTOMap.get(e.getBankId());
                        if(bankInfoDTO!=null){
                            e.setBankName(bankInfoDTO.getName());
                        }
                    });
                }
            }
            List<Long> merchantIds = content.stream().filter(e -> e.getMerchantId() != null).map(EnterpriseInfoDTO::getMerchantId).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(merchantIds)){
                List<StoreInfoDTO> storeInfoDTOS = storeInfoService.findAllByMerchantIds(merchantIds);
                Map<Long, StoreInfoDTO> storeInfoDTOMap = storeInfoDTOS.stream().collect(Collectors.toMap(StoreInfoDTO::getMerchantsCheckInInfoId, e -> e));
                content.stream().forEach(e->{
                    e.setStoreInfoDTO(storeInfoDTOMap.get(e.getMerchantId()));
                });

            }
        }
        return R.ok(content, page.getTotalElements());
    }

    @GetMapping("/enterprise-infos-by-merchantId/{storeId}")
    @ApiOperation("根据商户id获取企业/商户账户信息")
    public R<StoreInfoDTO> getEnterpriseInfoByMerchantId(@PathVariable Long storeId) {
        Optional<StoreInfoDTO> optionalStoreInfoDTO = storeInfoService.findOne(storeId);
        if (!optionalStoreInfoDTO.isPresent()) {
            return R.error();
        }
        StoreInfoDTO storeInfoDTO = optionalStoreInfoDTO.get();
        MerchantsCheckInInfoDTO checkInInfoServiceOne = merchantsCheckInInfoService.findOne(storeInfoDTO.getMerchantsCheckInInfoId());
        if (checkInInfoServiceOne != null) {
            EnterpriseInfoDTO enterpriseInfoDTO = enterpriseInfoService.findFristByMerchantId(storeInfoDTO.getMerchantsCheckInInfoId());
            enterpriseInfoDTO = getAddressInfo(enterpriseInfoDTO);
            if (enterpriseInfoDTO != null && enterpriseInfoDTO.getBankId() != null) {
                Optional<BankInfoDTO> one = bankInfoService.findOne(enterpriseInfoDTO.getId());
                if (one.isPresent()) {
                    enterpriseInfoDTO.setBankName(one.get().getName());
                }
            }
            checkInInfoServiceOne.setEnterpriseInfoDTO(enterpriseInfoDTO);
        }
        storeInfoDTO.setMerchantsCheckInInfoDTO(checkInInfoServiceOne);
        return R.ok(storeInfoDTO);
    }
}
