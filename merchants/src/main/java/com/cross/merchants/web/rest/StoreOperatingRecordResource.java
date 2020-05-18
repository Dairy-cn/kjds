package com.cross.merchants.web.rest;

import com.cross.merchants.service.StoreOperatingRecordService;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;
import com.cross.merchants.service.dto.StoreOperatingRecordDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
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
 * REST controller for managing {@link com.cross.merchants.domain.StoreOperatingRecord}.
 */
@RestController
@RequestMapping("/api")
public class StoreOperatingRecordResource {

    private final Logger log = LoggerFactory.getLogger(StoreOperatingRecordResource.class);

    private static final String ENTITY_NAME = "merchantsStoreOperatingRecord";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final StoreOperatingRecordService storeOperatingRecordService;

    public StoreOperatingRecordResource(StoreOperatingRecordService storeOperatingRecordService) {
        this.storeOperatingRecordService = storeOperatingRecordService;
    }

    /**
     * {@code POST  /store-operating-records} : Create a new storeOperatingRecord.
     *
     * @param storeOperatingRecordDTO the storeOperatingRecordDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new storeOperatingRecordDTO, or with status {@code 400 (Bad Request)} if the storeOperatingRecord has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/store-operating-records")
    public ResponseEntity<StoreOperatingRecordDTO> createStoreOperatingRecord(@RequestBody StoreOperatingRecordDTO storeOperatingRecordDTO) throws URISyntaxException {
        log.debug("REST request to save StoreOperatingRecord : {}", storeOperatingRecordDTO);
        if (storeOperatingRecordDTO.getId() != null) {
            throw new BadRequestAlertException("A new storeOperatingRecord cannot already have an ID", ENTITY_NAME, "idexists");
        }
        StoreOperatingRecordDTO result = storeOperatingRecordService.save(storeOperatingRecordDTO);
        return ResponseEntity.created(new URI("/api/store-operating-records/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /store-operating-records} : Updates an existing storeOperatingRecord.
     *
     * @param storeOperatingRecordDTO the storeOperatingRecordDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated storeOperatingRecordDTO,
     * or with status {@code 400 (Bad Request)} if the storeOperatingRecordDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the storeOperatingRecordDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/store-operating-records")
    public ResponseEntity<StoreOperatingRecordDTO> updateStoreOperatingRecord(@RequestBody StoreOperatingRecordDTO storeOperatingRecordDTO) throws URISyntaxException {
        log.debug("REST request to update StoreOperatingRecord : {}", storeOperatingRecordDTO);
        if (storeOperatingRecordDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        StoreOperatingRecordDTO result = storeOperatingRecordService.save(storeOperatingRecordDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, storeOperatingRecordDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /store-operating-records} : get all the storeOperatingRecords.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of storeOperatingRecords in body.
     */
    @GetMapping("/store-operating-records")
    public ResponseEntity<List<StoreOperatingRecordDTO>> getAllStoreOperatingRecords(Pageable pageable) {
        log.debug("REST request to get a page of StoreOperatingRecords");
        Page<StoreOperatingRecordDTO> page = storeOperatingRecordService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /store-operating-records/:id} : get the "id" storeOperatingRecord.
     *
     * @param id the id of the storeOperatingRecordDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the storeOperatingRecordDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/store-operating-records/{id}")
    public ResponseEntity<StoreOperatingRecordDTO> getStoreOperatingRecord(@PathVariable Long id) {
        log.debug("REST request to get StoreOperatingRecord : {}", id);
        Optional<StoreOperatingRecordDTO> storeOperatingRecordDTO = storeOperatingRecordService.findOne(id);
        return ResponseUtil.wrapOrNotFound(storeOperatingRecordDTO);
    }

    /**
     * {@code DELETE  /store-operating-records/:id} : delete the "id" storeOperatingRecord.
     *
     * @param id the id of the storeOperatingRecordDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/store-operating-records/{id}")
    public ResponseEntity<Void> deleteStoreOperatingRecord(@PathVariable Long id) {
        log.debug("REST request to delete StoreOperatingRecord : {}", id);
        storeOperatingRecordService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
