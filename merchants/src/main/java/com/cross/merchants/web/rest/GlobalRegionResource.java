package com.cross.merchants.web.rest;

import com.cross.merchants.service.GlobalRegionService;
import com.cross.merchants.service.dto.RegionDTO;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;
import com.cross.merchants.service.dto.GlobalRegionDTO;

import com.cross.utils.R;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.Api;
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
 * REST controller for managing {@link com.cross.merchants.domain.GlobalRegion}.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "全球地区信息相关接口")
public class GlobalRegionResource {

    private final Logger log = LoggerFactory.getLogger(GlobalRegionResource.class);

    private static final String ENTITY_NAME = "merchantsGlobalRegion";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final GlobalRegionService globalRegionService;

    public GlobalRegionResource(GlobalRegionService globalRegionService) {
        this.globalRegionService = globalRegionService;
    }

    /**
     * {@code POST  /global-regions} : Create a new globalRegion.
     *
     * @param globalRegionDTO the globalRegionDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new globalRegionDTO, or with status {@code 400 (Bad Request)} if the globalRegion has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/global-regions")
    public ResponseEntity<GlobalRegionDTO> createGlobalRegion(@RequestBody GlobalRegionDTO globalRegionDTO) throws URISyntaxException {
        log.debug("REST request to save GlobalRegion : {}", globalRegionDTO);
        if (globalRegionDTO.getId() != null) {
            throw new BadRequestAlertException("A new globalRegion cannot already have an ID", ENTITY_NAME, "idexists");
        }
        GlobalRegionDTO result = globalRegionService.save(globalRegionDTO);
        return ResponseEntity.created(new URI("/api/global-regions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /global-regions} : Updates an existing globalRegion.
     *
     * @param globalRegionDTO the globalRegionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated globalRegionDTO,
     * or with status {@code 400 (Bad Request)} if the globalRegionDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the globalRegionDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/global-regions")
    public ResponseEntity<GlobalRegionDTO> updateGlobalRegion(@RequestBody GlobalRegionDTO globalRegionDTO) throws URISyntaxException {
        log.debug("REST request to update GlobalRegion : {}", globalRegionDTO);
        if (globalRegionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        GlobalRegionDTO result = globalRegionService.save(globalRegionDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, globalRegionDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /global-regions} : get all the globalRegions.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of globalRegions in body.
     */
    @GetMapping("/global-regions")
    public ResponseEntity<List<GlobalRegionDTO>> getAllGlobalRegions(Pageable pageable) {
        log.debug("REST request to get a page of GlobalRegions");
        Page<GlobalRegionDTO> page = globalRegionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /global-regions/:id} : get the "id" globalRegion.
     *
     * @param id the id of the globalRegionDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the globalRegionDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/global-regions/{id}")
    @ApiOperation("根据记录id获取数据")
    public R getGlobalRegion(@PathVariable Long id) {
        log.debug("REST request to get GlobalRegion : {}", id);
        GlobalRegionDTO globalRegionDTO = globalRegionService.findOne(id).get();
        return R.ok(globalRegionDTO);
    }

    /**
     * {@code DELETE  /global-regions/:id} : delete the "id" globalRegion.
     *
     * @param id the id of the globalRegionDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/global-regions/{id}")
    public ResponseEntity<Void> deleteGlobalRegion(@PathVariable Long id) {
        log.debug("REST request to delete GlobalRegion : {}", id);
        globalRegionService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }

    /**
     * 根据父级ID获取全部地区
     *
     * @param parentId
     * @return
     */
    @GetMapping("/global-regions-parent-id/{parentId}")
    @ApiOperation("根据父级ID获取全部地区")
    public R getGlobalRegionsByParentId(@PathVariable Long parentId){
        log.debug("REST request to get regionsByParentId : {}", parentId);
        List<GlobalRegionDTO> regions = globalRegionService.getAllByParentId(parentId);
        return R.ok(regions);
    }

    @GetMapping("/global-regions-with-level")
    @ApiOperation("根据区域等级list")
    public R getGlobalRegionsByLevel(@ApiParam("区域等级 1 大洲 2 国家 3  省  4  市") @RequestParam Integer level){
        log.debug("REST request to get regionsByParentId : {}", level);
        List<GlobalRegionDTO> regions = globalRegionService.getAllByLevel(level);
        return R.ok(regions);
    }
}
