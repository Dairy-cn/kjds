package com.cross.merchants.web.rest;

import com.cross.merchants.service.GlobalRegionService;
import com.cross.merchants.service.MerchantsCategoryService;
import com.cross.merchants.service.MerchantsCheckInInfoService;
import com.cross.merchants.service.dto.GlobalRegionDTO;
import com.cross.merchants.service.dto.MerchantsCategoryDTO;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;
import com.cross.merchants.service.dto.MerchantsCheckInInfoDTO;

import com.cross.utils.CommonUtil;
import com.cross.utils.R;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
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
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * REST controller for managing {@link com.cross.merchants.domain.MerchantsCheckInInfo}.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "商户审核相关接口")
public class MerchantsCheckInInfoResource {

    private final Logger log = LoggerFactory.getLogger(MerchantsCheckInInfoResource.class);

    private static final String ENTITY_NAME = "merchantsMerchantsCheckInInfo";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MerchantsCheckInInfoService merchantsCheckInInfoService;

    private final GlobalRegionService globalRegionService;


    @Autowired
    private MerchantsCategoryService merchantsCategoryService;

    public MerchantsCheckInInfoResource(MerchantsCheckInInfoService merchantsCheckInInfoService, GlobalRegionService globalRegionService) {
        this.merchantsCheckInInfoService = merchantsCheckInInfoService;
        this.globalRegionService = globalRegionService;
    }

    /**
     * {@code POST  /merchants-check-in-infos} : Create a new merchantsCheckInInfo.
     *
     * @param merchantsCheckInInfoDTO the merchantsCheckInInfoDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new merchantsCheckInInfoDTO, or with status {@code 400 (Bad Request)} if the merchantsCheckInInfo has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/upload-merchants-check-in-infos")
    @ApiOperation("提交入驻资料")
    public R<MerchantsCheckInInfoDTO> createMerchantsCheckInInfo(@RequestBody MerchantsCheckInInfoDTO merchantsCheckInInfoDTO) throws URISyntaxException {
        log.debug("REST request to save MerchantsCheckInInfo : {}", merchantsCheckInInfoDTO);
        if (merchantsCheckInInfoDTO.getId() != null) {
            R.error("idexists");
        }
        Long id = CommonUtil.getCurrentLoginUser().getId();
        MerchantsCheckInInfoDTO oneWithSelf = merchantsCheckInInfoService.findOneWithSelf(id);
        if (oneWithSelf != null) {
            if (1 == oneWithSelf.getCheckStatus()) {
                return R.error("你提交的审核信息已通过,请勿重复提交");
            } else if (-1 == oneWithSelf.getCheckStatus()) {
                return R.error("你已提交审核记录,请勿重复提交");
            } else if (0 == oneWithSelf.getCheckStatus()) {
                return R.error("你已提交审核,请等待管理员审核");
            }
        }
        merchantsCheckInInfoDTO.setProposer(id);
        merchantsCheckInInfoDTO.setApplicationTime(Instant.now());
        merchantsCheckInInfoDTO.setCheckStatus(-1);
        String user_name = CommonUtil.getCurrentLoginUser().getUser_name();
        merchantsCheckInInfoDTO.setRegisterUserName(user_name);
        MerchantsCheckInInfoDTO result = merchantsCheckInInfoService.save(merchantsCheckInInfoDTO);
        return R.ok(result);
    }

    /**
     * {@code PUT  /merchants-check-in-infos} : Updates an existing merchantsCheckInInfo.
     *
     * @param merchantsCheckInInfoDTO the merchantsCheckInInfoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated merchantsCheckInInfoDTO,
     * or with status {@code 400 (Bad Request)} if the merchantsCheckInInfoDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the merchantsCheckInInfoDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
//    @PutMapping("/merchants-check-in-infos/upload-company-info")
    public R<MerchantsCheckInInfoDTO> uploadCompanyInfo(@RequestBody MerchantsCheckInInfoDTO merchantsCheckInInfoDTO) throws URISyntaxException {
        log.debug("REST request to update MerchantsCheckInInfo : {}", merchantsCheckInInfoDTO);
        if (merchantsCheckInInfoDTO.getId() == null) {
            return R.error("idnull");
        }
        MerchantsCheckInInfoDTO result = merchantsCheckInInfoService.save(merchantsCheckInInfoDTO);
        return R.ok(result);
    }

    @PutMapping("/re-upload-merchants-check-in-infos")
    @ApiOperation("重新提交入驻资料")
    public R<MerchantsCheckInInfoDTO> reUploadCompanyInfo(@RequestBody MerchantsCheckInInfoDTO merchantsCheckInInfoDTO) throws URISyntaxException {
        log.debug("REST request to update MerchantsCheckInInfo : {}", merchantsCheckInInfoDTO);
        if (merchantsCheckInInfoDTO.getId() == null) {
            return R.error("idnull");
        }

        MerchantsCheckInInfoDTO dbOne = merchantsCheckInInfoService.findOne(merchantsCheckInInfoDTO.getId());
        if (dbOne == null) {
            return R.error("记录错误,找不到记录");
        }
        if (1 == dbOne.getCheckStatus()) {
            return R.error("您的记录已经审核通过");
        }
        merchantsCheckInInfoDTO.setApplicationTime(Instant.now());
        merchantsCheckInInfoDTO.setCheckStatus(-1);
        MerchantsCheckInInfoDTO result = merchantsCheckInInfoService.save(merchantsCheckInInfoDTO);
        return R.ok(result);
    }

    /**
     * {@code GET  /merchants-check-in-infos} : get all the merchantsCheckInInfos.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of merchantsCheckInInfos in body.
     */
    @GetMapping("/merchants-check-in-infos")
    public R<List<MerchantsCheckInInfoDTO>> getAllMerchantsCheckInInfos(Pageable pageable) {
        log.debug("REST request to get a page of MerchantsCheckInInfos");
        Page<MerchantsCheckInInfoDTO> page = merchantsCheckInInfoService.findAll(pageable);
        return R.ok(page.getContent(), page.getTotalElements());
    }

    /**
     * {@code GET  /merchants-check-in-infos/:id} : get the "id" merchantsCheckInInfo.
     *
     * @param id the id of the merchantsCheckInInfoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the merchantsCheckInInfoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/merchants-check-in-infos/{id}")
    @ApiOperation("根据id获取提交记录信息")
    public R<MerchantsCheckInInfoDTO> getMerchantsCheckInInfo(@PathVariable Long id) {
        log.debug("REST request to get MerchantsCheckInInfo : {}", id);
        MerchantsCheckInInfoDTO merchantsCheckInInfoDTO = merchantsCheckInInfoService.findOne(id);
        if (merchantsCheckInInfoDTO == null) {
            return R.error("记录不存在");
        }
        this.getAddressInfo(merchantsCheckInInfoDTO);
        return R.ok(merchantsCheckInInfoDTO);
    }

    @GetMapping("/merchants-check-in-infos-with-self-submit")
    @ApiOperation("商户端--获取自己提交记录")
    public R<MerchantsCheckInInfoDTO> getMerchantsCheckInInfo() {
        Long id = CommonUtil.getCurrentLoginUser().getId();
        if (id == null || -1L == id) {
            return R.accessError();
        }
        MerchantsCheckInInfoDTO merchantsCheckInInfoDTO = merchantsCheckInInfoService.findOneWithSelf(id);
        return R.ok(merchantsCheckInInfoDTO);
    }

    @GetMapping("/merchants-info-with-check-success-self")
    @ApiOperation("商户端--企业管理--企业信息")
    public R<MerchantsCheckInInfoDTO> getMerchantsInfoWithCheckSuccessBySelf() {
        Long id = CommonUtil.getCurrentLoginUser().getId();
        if (id == null || -1L == id) {
            return R.accessError();
        }
        MerchantsCheckInInfoDTO merchantsCheckInInfoDTO = merchantsCheckInInfoService.findOneWithSelfByCheckState(id, 1);
        if (merchantsCheckInInfoDTO != null) {
            this.getAddressInfo(merchantsCheckInInfoDTO);
        }
        return R.ok(merchantsCheckInInfoDTO);
    }

    /**
     * {@code DELETE  /merchants-check-in-infos/:id} : delete the "id" merchantsCheckInInfo.
     *
     * @param id the id of the merchantsCheckInInfoDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/merchants-check-in-infos/{id}")
    public R deleteMerchantsCheckInInfo(@PathVariable Long id) {
        log.debug("REST request to delete MerchantsCheckInInfo : {}", id);
        merchantsCheckInInfoService.delete(id);
        return R.ok();
    }

    @PostMapping("/check-merchants-check-in-infos/{id}")
    @ApiOperation("大后台--商家入住审核")
    public R<MerchantsCheckInInfoDTO> merchantsCheckInInfo(@ApiParam("记录id") @PathVariable Long id,
                                                           @ApiParam("审核状态 true 通过 false 失败") @RequestParam Boolean status,
                                                           @ApiParam(value = "失败原因", required = false) @RequestParam(required = false) String checkFailureReasons) {
        log.debug("REST request to delete MerchantsCheckInInfo : {}", id);
        MerchantsCheckInInfoDTO merchantsCheckInInfoDTO = merchantsCheckInInfoService.findOne(id);
        if (merchantsCheckInInfoDTO == null) {
            return R.error("记录不存在");
        }
        if (1 == merchantsCheckInInfoDTO.getCheckStatus() || 0 == merchantsCheckInInfoDTO.getCheckStatus()) {
            return R.error("记录已经审核过了，不能重复审核");
        }
        if (status == null) {
            return R.error("审核状态不能为空");
        }
        merchantsCheckInInfoDTO.setCheckStatus(status ? 1 : 0);
        merchantsCheckInInfoDTO.setCheckTime(Instant.now());
        merchantsCheckInInfoDTO.setCheckFailureReasons(checkFailureReasons);
        merchantsCheckInInfoDTO = merchantsCheckInInfoService.merchantsCheckInInfo(merchantsCheckInInfoDTO);
        return R.ok(merchantsCheckInInfoDTO);
    }


    @GetMapping("/merchants-check-in-infos-wait-check-in-list-info")
    @ApiOperation("大后台--获取未审核记录")
    public R<List<MerchantsCheckInInfoDTO>> getAllMerchantsCheckInInfosWithWaitCheckInInfo(Pageable pageable) {
        log.debug("REST request to get a page of MerchantsCheckInInfos");
        Page<MerchantsCheckInInfoDTO> page = merchantsCheckInInfoService.findAllWithWaitCheckIn(pageable);
        return R.ok(page.getContent(), page.getTotalElements());
    }


    @GetMapping("/merchants-update-enterprise-info/{id}")
    @ApiOperation("大后台--修改审核成功后的企业信息")
    public R<MerchantsCheckInInfoDTO> updateMerchantsEnterpriseInfo(@ApiParam("记录id") @PathVariable Long id,
                                                                    @ApiParam("国家id") @RequestParam(required = true) Long countryId,
                                                                    @ApiParam(value = "省id", required = false) @RequestParam(required = false) Long provinceId,
                                                                    @ApiParam(value = "城市id", required = false) @RequestParam(required = false) Long cityId,
                                                                    @ApiParam("详细地址") @RequestParam(required = true) String address,
                                                                    @ApiParam("官网地址") @RequestParam(required = true) String webAdd,
                                                                    @ApiParam("联系人") @RequestParam(required = true) String linkMan,
                                                                    @ApiParam("职位") @RequestParam(required = true) String position,
                                                                    @ApiParam("邮箱") @RequestParam(required = true) String email,
                                                                    @ApiParam("电话号码") @RequestParam(required = true) String telPhone
    ) {
        log.debug("REST request to get a page of MerchantsCheckInInfos");
        MerchantsCheckInInfoDTO merchantsCheckInInfoDTO = merchantsCheckInInfoService.findOne(id);
        if (merchantsCheckInInfoDTO == null) {
            return R.errorData();
        }
        merchantsCheckInInfoDTO.setCityId(cityId);
        merchantsCheckInInfoDTO.setProvinceId(provinceId);
        merchantsCheckInInfoDTO.setCountryId(countryId);
        merchantsCheckInInfoDTO.setAddress(address);
        merchantsCheckInInfoDTO.setWebAdd(webAdd);
        merchantsCheckInInfoDTO.setLinkMan(linkMan);
        merchantsCheckInInfoDTO.setPosition(position);
        merchantsCheckInInfoDTO.setEmail(email);
        merchantsCheckInInfoDTO.setTelPhone(telPhone);
        merchantsCheckInInfoDTO = merchantsCheckInInfoService.save(merchantsCheckInInfoDTO);
        this.getAddressInfo(merchantsCheckInInfoDTO);
        return R.ok(merchantsCheckInInfoDTO);
    }


    /**
     * 获取地址信息
     *
     * @param merchantsCheckInInfoDTO
     * @return
     */

    private MerchantsCheckInInfoDTO getAddressInfo(MerchantsCheckInInfoDTO merchantsCheckInInfoDTO) {
        if (merchantsCheckInInfoDTO != null) {
            List<Long> regionIds = new ArrayList<>();
            if (merchantsCheckInInfoDTO.getCountryId() != null) {
                regionIds.add(merchantsCheckInInfoDTO.getCountryId());
            }
            if (merchantsCheckInInfoDTO.getProvinceId() != null) {
                regionIds.add(merchantsCheckInInfoDTO.getProvinceId());
            }
            if (merchantsCheckInInfoDTO.getCityId() != null) {
                regionIds.add(merchantsCheckInInfoDTO.getCityId());
            }
            if (!CollectionUtils.isEmpty(regionIds)) {
                List<GlobalRegionDTO> globalRegionDTOS = globalRegionService.findAllByIdIn(regionIds);
                Map<Long, String> map = globalRegionDTOS.stream().collect(Collectors.toMap(GlobalRegionDTO::getId, GlobalRegionDTO::getName));
                if (merchantsCheckInInfoDTO.getCountryId() != null) {
                    merchantsCheckInInfoDTO.setCountry(map.get(merchantsCheckInInfoDTO.getCountryId()));
                }
                if (merchantsCheckInInfoDTO.getProvinceId() != null) {
                    merchantsCheckInInfoDTO.setProvince(map.get(merchantsCheckInInfoDTO.getProvinceId()));
                }
                if (merchantsCheckInInfoDTO.getCityId() != null) {
                    merchantsCheckInInfoDTO.setCity(map.get(merchantsCheckInInfoDTO.getCityId()));
                }
            }
        }
        return merchantsCheckInInfoDTO;
    }

    @GetMapping("/merchants-check-in-infos-page")
    @ApiOperation("大后台--根据条件获取入住审核列表")
    public R<List<MerchantsCheckInInfoDTO>> getAllMerchantsCheckInInfosByCondition(Pageable pageable,
                                                                                   @ApiParam("店铺贸易模式(1 一般贸易 2 跨境贸易") @RequestParam(required = false) Integer tradeMode,
                                                                                   @ApiParam("审核状态 null 为全部 1 通过 -1 未审核 0 审核失败") @RequestParam(required = false) Integer checkState,
                                                                                   @ApiParam("申请开始时间 eg 2017-11-27T03:16:03Z") @RequestParam(required = false) Instant startTime,
                                                                                   @ApiParam("申请结束时间 eg 2017-11-27T03:16:03Z ") @RequestParam(required = false) Instant endTime,
                                                                                   @ApiParam("审核开始时间 eg 2017-11-27T03:16:03Z") @RequestParam(required = false) Instant startCheckTime,
                                                                                   @ApiParam("审核结束时间 eg 2017-11-27T03:16:03Z ") @RequestParam(required = false) Instant endCheckTime,
                                                                                   @ApiParam("关键字查询") @RequestParam(required = false) String keyWord) {
        log.debug("REST request to get a page of MerchantsCheckInInfos");
        Page<MerchantsCheckInInfoDTO> page = merchantsCheckInInfoService.findAllByCondition(pageable, tradeMode, checkState, startTime, endTime, startCheckTime, endCheckTime, keyWord);
        List<MerchantsCheckInInfoDTO> content = page.getContent();
        if (!CollectionUtils.isEmpty(content)) {
            List<Long> categoryIds = content.stream().map(MerchantsCheckInInfoDTO::getCategoryId).distinct().collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(categoryIds)) {
                List<MerchantsCategoryDTO> allByIdIn = merchantsCategoryService.findAllByIdIn(categoryIds);
                Map<Long, MerchantsCategoryDTO> map = allByIdIn.stream().collect(Collectors.toMap(MerchantsCategoryDTO::getId, e -> e));
                content.stream().forEach(e -> {
                    e.setMerchantsCategoryDTO(map.get(e.getCategoryId()));
                });
            }
        }
        return R.ok(content, page.getTotalElements());
    }
}
