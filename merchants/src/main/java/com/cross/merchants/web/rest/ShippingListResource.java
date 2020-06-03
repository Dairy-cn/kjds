package com.cross.merchants.web.rest;

import com.cross.merchants.service.ShippingListService;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;
import com.cross.merchants.service.dto.ShippingListDTO;

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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.cross.merchants.domain.ShippingList}.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "快递公司相关接口")
public class ShippingListResource {

    private final Logger log = LoggerFactory.getLogger(ShippingListResource.class);

    private static final String ENTITY_NAME = "merchantsShippingList";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ShippingListService shippingListService;

    public ShippingListResource(ShippingListService shippingListService) {
        this.shippingListService = shippingListService;
    }

    /**
     * {@code POST  /shipping-lists} : Create a new shippingList.
     *
     * @param shippingListDTO the shippingListDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new shippingListDTO, or with status {@code 400 (Bad Request)} if the shippingList has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/shipping-lists")
    public ResponseEntity<ShippingListDTO> createShippingList(@RequestBody ShippingListDTO shippingListDTO) throws URISyntaxException {
        log.debug("REST request to save ShippingList : {}", shippingListDTO);
        if (shippingListDTO.getId() != null) {
            throw new BadRequestAlertException("A new shippingList cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ShippingListDTO result = shippingListService.save(shippingListDTO);
        return ResponseEntity.created(new URI("/api/shipping-lists/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /shipping-lists} : Updates an existing shippingList.
     *
     * @param shippingListDTO the shippingListDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated shippingListDTO,
     * or with status {@code 400 (Bad Request)} if the shippingListDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the shippingListDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/shipping-lists")
    public ResponseEntity<ShippingListDTO> updateShippingList(@RequestBody ShippingListDTO shippingListDTO) throws URISyntaxException {
        log.debug("REST request to update ShippingList : {}", shippingListDTO);
        if (shippingListDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ShippingListDTO result = shippingListService.save(shippingListDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, shippingListDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /shipping-lists} : get all the shippingLists.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of shippingLists in body.
     */
    @GetMapping("/shipping-lists")
    public ResponseEntity<List<ShippingListDTO>> getAllShippingLists(Pageable pageable) {
        log.debug("REST request to get a page of ShippingLists");
        Page<ShippingListDTO> page = shippingListService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /shipping-lists/:id} : get the "id" shippingList.
     *
     * @param id the id of the shippingListDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the shippingListDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/shipping-lists/{id}")
    public ResponseEntity<ShippingListDTO> getShippingList(@PathVariable Long id) {
        log.debug("REST request to get ShippingList : {}", id);
        Optional<ShippingListDTO> shippingListDTO = shippingListService.findOne(id);
        return ResponseUtil.wrapOrNotFound(shippingListDTO);
    }

    /**
     * {@code DELETE  /shipping-lists/:id} : delete the "id" shippingList.
     *
     * @param id the id of the shippingListDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/shipping-lists/{id}")
    public ResponseEntity<Void> deleteShippingList(@PathVariable Long id) {
        log.debug("REST request to delete ShippingList : {}", id);
        shippingListService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }



    @GetMapping("/shipping-lists-all")
    @ApiOperation("获取所有的快递公司列表")
    public R<List<ShippingListDTO>> getAllShippingListsNoPage() {
        log.debug("REST request to get a page of ShippingLists");
        List<ShippingListDTO> page = shippingListService.findAll();
        return R.ok(page);
    }
}
