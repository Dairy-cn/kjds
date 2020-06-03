package com.cross.merchants.web.rest;

import com.cross.merchants.service.GoodsPropertyTagService;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;
import com.cross.merchants.service.dto.GoodsPropertyTagDTO;

import com.cross.utils.R;
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

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.cross.merchants.domain.GoodsPropertyTag}.
 */
@RestController
@RequestMapping("/api")
public class GoodsPropertyTagResource {

    private final Logger log = LoggerFactory.getLogger(GoodsPropertyTagResource.class);

    private static final String ENTITY_NAME = "merchantsGoodsPropertyTag";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final GoodsPropertyTagService goodsPropertyTagService;

    public GoodsPropertyTagResource(GoodsPropertyTagService goodsPropertyTagService) {
        this.goodsPropertyTagService = goodsPropertyTagService;
    }

    /**
     * {@code POST  /goods-property-tags} : Create a new goodsPropertyTag.
     *
     * @param goodsPropertyTagDTO the goodsPropertyTagDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new goodsPropertyTagDTO, or with status {@code 400 (Bad Request)} if the goodsPropertyTag has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/goods-property-tags")
    public R<GoodsPropertyTagDTO> createGoodsPropertyTag(@Valid @RequestBody GoodsPropertyTagDTO goodsPropertyTagDTO) throws URISyntaxException {
        log.debug("REST request to save GoodsPropertyTag : {}", goodsPropertyTagDTO);
        if (goodsPropertyTagDTO.getId() != null) {
            throw new BadRequestAlertException("A new goodsPropertyTag cannot already have an ID", ENTITY_NAME, "idexists");
        }
        GoodsPropertyTagDTO result = goodsPropertyTagService.save(goodsPropertyTagDTO);
        return R.ok(result);
    }

    /**
     * {@code PUT  /goods-property-tags} : Updates an existing goodsPropertyTag.
     *
     * @param goodsPropertyTagDTO the goodsPropertyTagDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated goodsPropertyTagDTO,
     * or with status {@code 400 (Bad Request)} if the goodsPropertyTagDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the goodsPropertyTagDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/goods-property-tags")
    public ResponseEntity<GoodsPropertyTagDTO> updateGoodsPropertyTag(@Valid @RequestBody GoodsPropertyTagDTO goodsPropertyTagDTO) throws URISyntaxException {
        log.debug("REST request to update GoodsPropertyTag : {}", goodsPropertyTagDTO);
        if (goodsPropertyTagDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        GoodsPropertyTagDTO result = goodsPropertyTagService.save(goodsPropertyTagDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, goodsPropertyTagDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /goods-property-tags} : get all the goodsPropertyTags.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of goodsPropertyTags in body.
     */
    @GetMapping("/goods-property-tags")
    public ResponseEntity<List<GoodsPropertyTagDTO>> getAllGoodsPropertyTags(Pageable pageable) {
        log.debug("REST request to get a page of GoodsPropertyTags");
        Page<GoodsPropertyTagDTO> page = goodsPropertyTagService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /goods-property-tags/:id} : get the "id" goodsPropertyTag.
     *
     * @param id the id of the goodsPropertyTagDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the goodsPropertyTagDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/goods-property-tags/{id}")
    public ResponseEntity<GoodsPropertyTagDTO> getGoodsPropertyTag(@PathVariable Long id) {
        log.debug("REST request to get GoodsPropertyTag : {}", id);
        Optional<GoodsPropertyTagDTO> goodsPropertyTagDTO = goodsPropertyTagService.findOne(id);
        return ResponseUtil.wrapOrNotFound(goodsPropertyTagDTO);
    }

    /**
     * {@code DELETE  /goods-property-tags/:id} : delete the "id" goodsPropertyTag.
     *
     * @param id the id of the goodsPropertyTagDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/goods-property-tags/{id}")
    public ResponseEntity<Void> deleteGoodsPropertyTag(@PathVariable Long id) {
        log.debug("REST request to delete GoodsPropertyTag : {}", id);
        goodsPropertyTagService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
