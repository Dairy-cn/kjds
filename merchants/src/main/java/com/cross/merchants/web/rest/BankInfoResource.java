package com.cross.merchants.web.rest;

import com.cross.merchants.service.BankInfoService;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;
import com.cross.merchants.service.dto.BankInfoDTO;

import com.cross.utils.R;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.cross.merchants.domain.BankInfo}.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "银行信息相关接口")
public class BankInfoResource {

    private final Logger log = LoggerFactory.getLogger(BankInfoResource.class);

    private static final String ENTITY_NAME = "merchantsBankInfo";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BankInfoService bankInfoService;

    public BankInfoResource(BankInfoService bankInfoService) {
        this.bankInfoService = bankInfoService;
    }

    /**
     * {@code POST  /bank-infos} : Create a new bankInfo.
     *
     * @param bankInfoDTO the bankInfoDTO to create.
     * @return the {@link R} with status {@code 201 (Created)} and with body the new bankInfoDTO, or with status {@code 400 (Bad Request)} if the bankInfo has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/bank-infos")
    public R<BankInfoDTO> createBankInfo(@RequestBody BankInfoDTO bankInfoDTO) throws URISyntaxException {
        log.debug("REST request to save BankInfo : {}", bankInfoDTO);
        if (bankInfoDTO.getId() != null) {
            throw new BadRequestAlertException("A new bankInfo cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BankInfoDTO result = bankInfoService.save(bankInfoDTO);
        return R.ok(result);
    }

    /**
     * {@code PUT  /bank-infos} : Updates an existing bankInfo.
     *
     * @param bankInfoDTO the bankInfoDTO to update.
     * @return the {@link R} with status {@code 200 (OK)} and with body the updated bankInfoDTO,
     * or with status {@code 400 (Bad Request)} if the bankInfoDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the bankInfoDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/bank-infos")
    public R<BankInfoDTO> updateBankInfo(@RequestBody BankInfoDTO bankInfoDTO) throws URISyntaxException {
        log.debug("REST request to update BankInfo : {}", bankInfoDTO);
        if (bankInfoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BankInfoDTO result = bankInfoService.save(bankInfoDTO);
        return R.ok(result);
    }

    /**
     * {@code GET  /bank-infos} : get all the bankInfos.
     *
     * @param pageable the pagination information.
     * @return the {@link R} with status {@code 200 (OK)} and the list of bankInfos in body.
     */
    @GetMapping("/bank-infos")
    @ApiOperation("分页获取---list")
    public R<List<BankInfoDTO>> getAllBankInfosByPage(Pageable pageable) {
        log.debug("REST request to get a page of BankInfos");
        Page<BankInfoDTO> page = bankInfoService.findAll(pageable);
        return R.ok(page.getContent(), page.getTotalElements());
    }

    @GetMapping("/bank-infos-no-page")
    @ApiOperation("获取所有---list")
    public R<List<BankInfoDTO>> getAllBankInfos() {
        log.debug("REST request to get a page of BankInfos");
        List<BankInfoDTO> page = bankInfoService.findAll();
        return R.ok(page);
    }

    /**
     * {@code GET  /bank-infos/:id} : get the "id" bankInfo.
     *
     * @param id the id of the bankInfoDTO to retrieve.
     * @return the {@link R} with status {@code 200 (OK)} and with body the bankInfoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/bank-infos/{id}")
    public R<BankInfoDTO> getBankInfo(@PathVariable Long id) {
        log.debug("REST request to get BankInfo : {}", id);
        Optional<BankInfoDTO> bankInfoDTO = bankInfoService.findOne(id);
        return R.ok(bankInfoDTO.get());
    }

    /**
     * {@code DELETE  /bank-infos/:id} : delete the "id" bankInfo.
     *
     * @param id the id of the bankInfoDTO to delete.
     * @return the {@link R} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/bank-infos/{id}")
    public R deleteBankInfo(@PathVariable Long id) {
        log.debug("REST request to delete BankInfo : {}", id);
        bankInfoService.delete(id);
        return R.ok();
    }
}
