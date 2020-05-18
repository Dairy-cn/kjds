package com.cross.merchants.web.rest;

import com.cross.merchants.service.GoodsSkuService;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;
import com.cross.merchants.service.dto.GoodsSkuDTO;

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
 * REST controller for managing {@link com.cross.merchants.domain.GoodsSku}.
 */
@RestController
@RequestMapping("/api")
public class GoodsSkuResource {

    private final Logger log = LoggerFactory.getLogger(GoodsSkuResource.class);

    private static final String ENTITY_NAME = "merchantsGoodsSku";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final GoodsSkuService goodsSkuService;

    public GoodsSkuResource(GoodsSkuService goodsSkuService) {
        this.goodsSkuService = goodsSkuService;
    }

    /**
     * {@code POST  /goods-skus} : Create a new goodsSku.
     *
     * @param goodsSkuDTO the goodsSkuDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new goodsSkuDTO, or with status {@code 400 (Bad Request)} if the goodsSku has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/goods-skus")
    public ResponseEntity<GoodsSkuDTO> createGoodsSku(@Valid @RequestBody GoodsSkuDTO goodsSkuDTO) throws URISyntaxException {
        log.debug("REST request to save GoodsSku : {}", goodsSkuDTO);
        if (goodsSkuDTO.getId() != null) {
            throw new BadRequestAlertException("A new goodsSku cannot already have an ID", ENTITY_NAME, "idexists");
        }
        GoodsSkuDTO result = goodsSkuService.save(goodsSkuDTO);
        return ResponseEntity.created(new URI("/api/goods-skus/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /goods-skus} : Updates an existing goodsSku.
     *
     * @param goodsSkuDTO the goodsSkuDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated goodsSkuDTO,
     * or with status {@code 400 (Bad Request)} if the goodsSkuDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the goodsSkuDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/goods-skus")
    public ResponseEntity<GoodsSkuDTO> updateGoodsSku(@Valid @RequestBody GoodsSkuDTO goodsSkuDTO) throws URISyntaxException {
        log.debug("REST request to update GoodsSku : {}", goodsSkuDTO);
        if (goodsSkuDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        GoodsSkuDTO result = goodsSkuService.save(goodsSkuDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, goodsSkuDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /goods-skus} : get all the goodsSkus.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of goodsSkus in body.
     */
    @GetMapping("/goods-skus")
    public ResponseEntity<List<GoodsSkuDTO>> getAllGoodsSkus(Pageable pageable) {
        log.debug("REST request to get a page of GoodsSkus");
        Page<GoodsSkuDTO> page = goodsSkuService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /goods-skus/:id} : get the "id" goodsSku.
     *
     * @param id the id of the goodsSkuDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the goodsSkuDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/goods-skus/{id}")
    public ResponseEntity<GoodsSkuDTO> getGoodsSku(@PathVariable Long id) {
        log.debug("REST request to get GoodsSku : {}", id);
        Optional<GoodsSkuDTO> goodsSkuDTO = goodsSkuService.findOne(id);
        return ResponseUtil.wrapOrNotFound(goodsSkuDTO);
    }

    /**
     * {@code DELETE  /goods-skus/:id} : delete the "id" goodsSku.
     *
     * @param id the id of the goodsSkuDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/goods-skus/{id}")
    public ResponseEntity<Void> deleteGoodsSku(@PathVariable Long id) {
        log.debug("REST request to delete GoodsSku : {}", id);
        goodsSkuService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
