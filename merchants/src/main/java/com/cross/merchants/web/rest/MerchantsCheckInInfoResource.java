package com.cross.merchants.web.rest;

import com.cross.merchants.service.GlobalRegionService;
import com.cross.merchants.service.MerchantsCheckInInfoService;
import com.cross.merchants.service.dto.GlobalRegionDTO;
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
    public R createMerchantsCheckInInfo(@RequestBody MerchantsCheckInInfoDTO merchantsCheckInInfoDTO) throws URISyntaxException {
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
    public R uploadCompanyInfo(@RequestBody MerchantsCheckInInfoDTO merchantsCheckInInfoDTO) throws URISyntaxException {
        log.debug("REST request to update MerchantsCheckInInfo : {}", merchantsCheckInInfoDTO);
        if (merchantsCheckInInfoDTO.getId() == null) {
            return R.error("idnull");
        }
        MerchantsCheckInInfoDTO result = merchantsCheckInInfoService.save(merchantsCheckInInfoDTO);
        return R.ok(result);
    }

    @PutMapping("/re-upload-merchants-check-in-infos")
    @ApiOperation("重新提交入驻资料")
    public R reUploadCompanyInfo(@RequestBody MerchantsCheckInInfoDTO merchantsCheckInInfoDTO) throws URISyntaxException {
        log.debug("REST request to update MerchantsCheckInInfo : {}", merchantsCheckInInfoDTO);
        if (merchantsCheckInInfoDTO.getId() == null) {
            return R.error("idnull");
        }

        MerchantsCheckInInfoDTO dbOne = merchantsCheckInInfoService.findOne(merchantsCheckInInfoDTO.getId()).get();
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
    public ResponseEntity<List<MerchantsCheckInInfoDTO>> getAllMerchantsCheckInInfos(Pageable pageable) {
        log.debug("REST request to get a page of MerchantsCheckInInfos");
        Page<MerchantsCheckInInfoDTO> page = merchantsCheckInInfoService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /merchants-check-in-infos/:id} : get the "id" merchantsCheckInInfo.
     *
     * @param id the id of the merchantsCheckInInfoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the merchantsCheckInInfoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/merchants-check-in-infos/{id}")
    @ApiOperation("根据id获取提交记录信息")
    public R getMerchantsCheckInInfo(@PathVariable Long id) {
        log.debug("REST request to get MerchantsCheckInInfo : {}", id);
        Optional<MerchantsCheckInInfoDTO> one = merchantsCheckInInfoService.findOne(id);
        if (!one.isPresent()) {
            return R.error("记录不存在");
        }
        MerchantsCheckInInfoDTO merchantsCheckInInfoDTO = one.get();
        this.getAddressInfo(merchantsCheckInInfoDTO);
        return R.ok(merchantsCheckInInfoDTO);
    }

    @GetMapping("/merchants-check-in-infos-with-self-submit")
    @ApiOperation("商户端--获取自己提交记录")
    public R getMerchantsCheckInInfo() {
        Long id = CommonUtil.getCurrentLoginUser().getId();
        if (id == null || -1L == id) {
            return R.accessError();
        }
        MerchantsCheckInInfoDTO merchantsCheckInInfoDTO = merchantsCheckInInfoService.findOneWithSelf(id);
        return R.ok(merchantsCheckInInfoDTO);
    }

    @GetMapping("/merchants-info-with-check-success-self")
    @ApiOperation("商户端--企业管理--企业信息")
    public R getMerchantsInfoWithCheckSuccessBySelf() {
        Long id = CommonUtil.getCurrentLoginUser().getId();
        if (id == null || -1L == id) {
            return R.accessError();
        }
        MerchantsCheckInInfoDTO merchantsCheckInInfoDTO = merchantsCheckInInfoService.findOneWithSelfByCheckState(id, 1);

        return R.ok(merchantsCheckInInfoDTO);
    }

    /**
     * {@code DELETE  /merchants-check-in-infos/:id} : delete the "id" merchantsCheckInInfo.
     *
     * @param id the id of the merchantsCheckInInfoDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/merchants-check-in-infos/{id}")
    public ResponseEntity<Void> deleteMerchantsCheckInInfo(@PathVariable Long id) {
        log.debug("REST request to delete MerchantsCheckInInfo : {}", id);
        merchantsCheckInInfoService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }

    @PostMapping("/check-merchants-check-in-infos/{id}")
    @ApiOperation("大后台--商家入住审核")
    public R merchantsCheckInInfo(@ApiParam("记录id") @PathVariable Long id,
                                  @ApiParam("审核状态 true 通过 false 失败") @RequestParam Boolean status,
                                  @ApiParam("失败原因") @RequestParam String checkFailureReasons) {
        log.debug("REST request to delete MerchantsCheckInInfo : {}", id);
        MerchantsCheckInInfoDTO merchantsCheckInInfoDTO = merchantsCheckInInfoService.findOne(id).get();
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
    public R getAllMerchantsCheckInInfosWithWaitCheckInInfo(Pageable pageable) {
        log.debug("REST request to get a page of MerchantsCheckInInfos");
        Page<MerchantsCheckInInfoDTO> page = merchantsCheckInInfoService.findAllWithWaitCheckIn(pageable);
        return R.ok(page.getContent(), page.getTotalElements());
    }


    @GetMapping("/merchants-update-enterprise-info/{id}")
    @ApiOperation("大后台--修改审核成功后的企业信息")
    public R updateMerchantsEnterpriseInfo(@ApiParam("记录id") @PathVariable Long id,
                                           @ApiParam("国家id") @RequestParam(required = true) Long countryId,
                                           @ApiParam("省id") @RequestParam(required = true) Long provinceId,
                                           @ApiParam("城市id") @RequestParam(required = true) Long cityId,
                                           @ApiParam("详细地址") @RequestParam(required = true) String address,
                                           @ApiParam("官网地址") @RequestParam(required = true) String webAdd,
                                           @ApiParam("联系人") @RequestParam(required = true) String linkMan,
                                           @ApiParam("职位") @RequestParam(required = true) String position,
                                           @ApiParam("邮箱") @RequestParam(required = true) String email,
                                           @ApiParam("电话号码") @RequestParam(required = true) String telPhone
    ) {
        log.debug("REST request to get a page of MerchantsCheckInInfos");
        Optional<MerchantsCheckInInfoDTO> one = merchantsCheckInInfoService.findOne(id);
        if (!one.isPresent()) {
            return R.errorData();
        }
        MerchantsCheckInInfoDTO merchantsCheckInInfoDTO = one.get();
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
}
