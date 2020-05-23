package com.cross.merchants.web.rest;

import com.cross.merchants.service.SystemInfoService;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;
import com.cross.merchants.service.dto.SystemInfoDTO;

import com.cross.utils.R;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * REST controller for managing {@link com.cross.merchants.domain.SystemInfo}.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "系统设置相关接口")
public class SystemInfoResource {

    private final Logger log = LoggerFactory.getLogger(SystemInfoResource.class);

    private static final String ENTITY_NAME = "merchantsSystemInfo";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SystemInfoService systemInfoService;

    public SystemInfoResource(SystemInfoService systemInfoService) {
        this.systemInfoService = systemInfoService;
    }

    /**
     * {@code POST  /system-infos} : Create a new systemInfo.
     *
     * @param systemInfoDTO the systemInfoDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new systemInfoDTO, or with status {@code 400 (Bad Request)} if the systemInfo has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
//    @PostMapping("/system-infos")
    public ResponseEntity<SystemInfoDTO> createSystemInfo(@RequestBody SystemInfoDTO systemInfoDTO) throws URISyntaxException {
        log.debug("REST request to save SystemInfo : {}", systemInfoDTO);
        if (systemInfoDTO.getId() != null) {
            throw new BadRequestAlertException("A new systemInfo cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SystemInfoDTO result = systemInfoService.save(systemInfoDTO);
        return ResponseEntity.created(new URI("/api/system-infos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /system-infos} : Updates an existing systemInfo.
     *
     * @param systemInfoDTO the systemInfoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated systemInfoDTO,
     * or with status {@code 400 (Bad Request)} if the systemInfoDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the systemInfoDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
//    @PutMapping("/system-infos")
    public ResponseEntity<SystemInfoDTO> updateSystemInfo(@RequestBody SystemInfoDTO systemInfoDTO) throws URISyntaxException {
        log.debug("REST request to update SystemInfo : {}", systemInfoDTO);
        if (systemInfoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SystemInfoDTO result = systemInfoService.save(systemInfoDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, systemInfoDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /system-infos} : get all the systemInfos.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of systemInfos in body.
     */
//    @GetMapping("/system-infos")
    public ResponseEntity<List<SystemInfoDTO>> getAllSystemInfos(Pageable pageable) {
        log.debug("REST request to get a page of SystemInfos");
        Page<SystemInfoDTO> page = systemInfoService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /system-infos/:id} : get the "id" systemInfo.
     *
     * @param id the id of the systemInfoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the systemInfoDTO, or with status {@code 404 (Not Found)}.
     */
//    @GetMapping("/system-infos/{id}")
    public ResponseEntity<SystemInfoDTO> getSystemInfo(@PathVariable Long id) {
        log.debug("REST request to get SystemInfo : {}", id);
        Optional<SystemInfoDTO> systemInfoDTO = systemInfoService.findOne(1L);
        return ResponseUtil.wrapOrNotFound(systemInfoDTO);
    }


    @GetMapping("/system-infos/")
    @ApiOperation("获取平台基本信息（包括支付账号信息）")
    public R getSystemInfoOne() {
        Optional<SystemInfoDTO> systemInfoDTO = systemInfoService.findOne(1L);
        if (!systemInfoDTO.isPresent()) {
            return R.accessError();
        }
        return R.ok(systemInfoDTO.get());
    }

    /**
     * {@code DELETE  /system-infos/:id} : delete the "id" systemInfo.
     *
     * @param id the id of the systemInfoDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
//    @DeleteMapping("/system-infos/{id}")
    public ResponseEntity<Void> deleteSystemInfo(@PathVariable Long id) {
        log.debug("REST request to delete SystemInfo : {}", id);
        systemInfoService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }

    @PutMapping("/system-infos/{id}")
    @ApiOperation("修改系统设置信息")
    public R updateSystemInfoBasicInfo(@ApiParam("记录id") @PathVariable Long id,
                                       @ApiParam("平台名称") @RequestParam String platformName,
                                       @ApiParam("平台logo") @RequestParam String platformLogo) throws URISyntaxException {

        Optional<SystemInfoDTO> one = systemInfoService.findOne(id);
        if (!one.isPresent()) {
            return R.errorData();
        }
        SystemInfoDTO systemInfoDTO = one.get();
        systemInfoDTO.setPlatformName(platformName);
        systemInfoDTO.setPlatformLogo(platformLogo);
        SystemInfoDTO save = systemInfoService.save(systemInfoDTO);
        return R.ok(save);
    }



    @PutMapping("/system-pay-infos/{id}")
    @ApiOperation("修改系统支付信息")
    public R updateSystemInfoPayInfo(@ApiParam("记录id") @PathVariable Long id,
                                       @ApiParam("公众账号Id") @RequestParam String platformAppId,
                                       @ApiParam("商户号") @RequestParam String platformAppNo,
                                       @ApiParam("商户号密钥") @RequestParam String platformAppSecret,
                                       @ApiParam("支付宝APPId") @RequestParam String aliAppId,
                                       @ApiParam("应用公钥") @RequestParam String aliAppPublicKey,
                                       @ApiParam("应用私钥") @RequestParam String aliAppPrivteKey) throws URISyntaxException {

        Optional<SystemInfoDTO> one = systemInfoService.findOne(id);
        if (!one.isPresent()) {
            return R.errorData();
        }
        SystemInfoDTO systemInfoDTO = one.get();
        systemInfoDTO.setPlatAppId(platformAppId);
        systemInfoDTO.setPlatAppSecret(platformAppSecret);
        systemInfoDTO.setPlatAppNo(platformAppNo);
        systemInfoDTO.setAliAppPrivteKey(aliAppPrivteKey);
        systemInfoDTO.setAliAppId(aliAppId);
        systemInfoDTO.setAliAppPublicKey(aliAppPublicKey);
        SystemInfoDTO save = systemInfoService.save(systemInfoDTO);
        return R.ok(save);
    }
}
