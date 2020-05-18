package com.cross.merchants.web.rest;

import com.cross.merchants.service.GoodsPropertyService;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;
import com.cross.merchants.service.dto.GoodsPropertyDTO;

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
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.cross.merchants.domain.GoodsProperty}.
 */
@RestController
@RequestMapping("/api")
public class GoodsPropertyResource {

    private final Logger log = LoggerFactory.getLogger(GoodsPropertyResource.class);

    private static final String ENTITY_NAME = "merchantsGoodsProperty";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final GoodsPropertyService goodsPropertyService;

    public GoodsPropertyResource(GoodsPropertyService goodsPropertyService) {
        this.goodsPropertyService = goodsPropertyService;
    }

    /**
     * {@code POST  /goods-properties} : Create a new goodsProperty.
     *
     * @param goodsPropertyDTO the goodsPropertyDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new goodsPropertyDTO, or with status {@code 400 (Bad Request)} if the goodsProperty has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/goods-properties")
    public ResponseEntity<GoodsPropertyDTO> createGoodsProperty(@Valid @RequestBody GoodsPropertyDTO goodsPropertyDTO) throws URISyntaxException {
        log.debug("REST request to save GoodsProperty : {}", goodsPropertyDTO);
        if (goodsPropertyDTO.getId() != null) {
            throw new BadRequestAlertException("A new goodsProperty cannot already have an ID", ENTITY_NAME, "idexists");
        }
        GoodsPropertyDTO result = goodsPropertyService.save(goodsPropertyDTO);
        return ResponseEntity.created(new URI("/api/goods-properties/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /goods-properties} : Updates an existing goodsProperty.
     *
     * @param goodsPropertyDTO the goodsPropertyDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated goodsPropertyDTO,
     * or with status {@code 400 (Bad Request)} if the goodsPropertyDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the goodsPropertyDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/goods-properties")
    public ResponseEntity<GoodsPropertyDTO> updateGoodsProperty(@Valid @RequestBody GoodsPropertyDTO goodsPropertyDTO) throws URISyntaxException {
        log.debug("REST request to update GoodsProperty : {}", goodsPropertyDTO);
        if (goodsPropertyDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        GoodsPropertyDTO result = goodsPropertyService.save(goodsPropertyDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, goodsPropertyDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /goods-properties} : get all the goodsProperties.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of goodsProperties in body.
     */
    @GetMapping("/goods-properties")
    public ResponseEntity<List<GoodsPropertyDTO>> getAllGoodsProperties(Pageable pageable) {
        log.debug("REST request to get a page of GoodsProperties");
        Page<GoodsPropertyDTO> page = goodsPropertyService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /goods-properties/:id} : get the "id" goodsProperty.
     *
     * @param id the id of the goodsPropertyDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the goodsPropertyDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/goods-properties/{id}")
    public ResponseEntity<GoodsPropertyDTO> getGoodsProperty(@PathVariable Long id) {
        log.debug("REST request to get GoodsProperty : {}", id);
        Optional<GoodsPropertyDTO> goodsPropertyDTO = goodsPropertyService.findOne(id);
        return ResponseUtil.wrapOrNotFound(goodsPropertyDTO);
    }

    /**
     * {@code DELETE  /goods-properties/:id} : delete the "id" goodsProperty.
     *
     * @param id the id of the goodsPropertyDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/goods-properties/{id}")
    public ResponseEntity<Void> deleteGoodsProperty(@PathVariable Long id) {
        log.debug("REST request to delete GoodsProperty : {}", id);
        goodsPropertyService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
