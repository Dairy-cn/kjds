package com.cross.merchants.web.rest;

import com.cross.merchants.domain.Goods;
import com.cross.merchants.service.GoodsRecommendService;
import com.cross.merchants.service.GoodsService;
import com.cross.merchants.service.dto.GoodsDTO;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;
import com.cross.merchants.service.dto.GoodsRecommendDTO;

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
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for managing {@link com.cross.merchants.domain.GoodsRecommend}.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "商品推荐相关接口")
public class GoodsRecommendResource {

    private final Logger log = LoggerFactory.getLogger(GoodsRecommendResource.class);

    private static final String ENTITY_NAME = "merchantsGoodsRecommend";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final GoodsRecommendService goodsRecommendService;

    private final GoodsService goodsService;


    public GoodsRecommendResource(GoodsRecommendService goodsRecommendService, GoodsService goodsService) {
        this.goodsRecommendService = goodsRecommendService;
        this.goodsService = goodsService;
    }

    /**
     * {@code POST  /goods-recommends} : Create a new goodsRecommend.
     *
     * @param goodsRecommendDTO the goodsRecommendDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new goodsRecommendDTO, or with status {@code 400 (Bad Request)} if the goodsRecommend has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/goods-recommends")
    @ApiOperation("大后台---添加推荐商品")
    public R createGoodsRecommend(@Valid @RequestBody GoodsRecommendDTO goodsRecommendDTO) throws URISyntaxException {
        log.debug("REST request to save GoodsRecommend : {}", goodsRecommendDTO);
        if (goodsRecommendDTO.getId() != null) {
            return R.ok("idexists");
        }
        goodsRecommendDTO.setCreateTime(Instant.now());
        GoodsRecommendDTO result = goodsRecommendService.save(goodsRecommendDTO);
        return R.ok(result);
    }

    /**
     * {@code PUT  /goods-recommends} : Updates an existing goodsRecommend.
     *
     * @param goodsRecommendDTO the goodsRecommendDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated goodsRecommendDTO,
     * or with status {@code 400 (Bad Request)} if the goodsRecommendDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the goodsRecommendDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/goods-recommends")
    @ApiOperation("大后台---编辑推荐商品")
    public R updateGoodsRecommend(@Valid @RequestBody GoodsRecommendDTO goodsRecommendDTO) throws URISyntaxException {
        log.debug("REST request to update GoodsRecommend : {}", goodsRecommendDTO);
        if (goodsRecommendDTO.getId() == null) {
            return R.error("idnull");
        }
        goodsRecommendDTO.setUpdateTime(Instant.now());
        GoodsRecommendDTO result = goodsRecommendService.save(goodsRecommendDTO);
        return R.ok(result);
    }

    /**
     * {@code GET  /goods-recommends} : get all the goodsRecommends.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of goodsRecommends in body.
     */
    @GetMapping("/goods-recommends")
    @ApiOperation("大后台---推荐商品List")
    public R getAllGoodsRecommends(Pageable pageable) {
        log.debug("REST request to get a page of GoodsRecommends");
        Page<GoodsRecommendDTO> page = goodsRecommendService.findAll(pageable);
        List<GoodsRecommendDTO> list = setParam(page.getContent());
        return R.ok(list, page.getTotalElements());
    }

    /**
     * {@code GET  /goods-recommends/:id} : get the "id" goodsRecommend.
     *
     * @param id the id of the goodsRecommendDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the goodsRecommendDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/goods-recommends/{id}")
    @ApiOperation("大后台---根据id获取推荐商品信息")
    public R getGoodsRecommend(@PathVariable Long id) {
        log.debug("REST request to get GoodsRecommend : {}", id);
        Optional<GoodsRecommendDTO> goodsRecommendDTO = goodsRecommendService.findOne(id);
        if (!goodsRecommendDTO.isPresent()) {
            return R.errorData();
        }
        GoodsRecommendDTO recommendDTO = goodsRecommendDTO.get();
        List<GoodsRecommendDTO> list = new ArrayList<>();
        list.add(recommendDTO);
        list = setParam(list);
        return R.ok(list.get(0));
    }

    /**
     * {@code DELETE  /goods-recommends/:id} : delete the "id" goodsRecommend.
     *
     * @param id the id of the goodsRecommendDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/goods-recommends/{id}")
    @ApiOperation("大后台---根据id删除推荐商品信息")
    public R deleteGoodsRecommend(@PathVariable Long id) {
        log.debug("REST request to delete GoodsRecommend : {}", id);
        goodsRecommendService.delete(id);
        return R.ok();
    }

    @PutMapping("/goods-recommends-top-state/{id}")
    @ApiOperation("大后台---根据id置顶推荐商品信息")
    public R topStateGoodsRecommend(@PathVariable Long id) {
        log.debug("REST request to delete GoodsRecommend : {}", id);
        goodsRecommendService.topGoodsRecommend(id);
        return R.ok();
    }


    private List<GoodsRecommendDTO> setParam(List<GoodsRecommendDTO> goodsRecommendDTOS) {
        if (!CollectionUtils.isEmpty(goodsRecommendDTOS)) {
            List<Long> goodsIds = goodsRecommendDTOS.stream().map(GoodsRecommendDTO::getGoodsId).collect(Collectors.toList());
            Map<Long, GoodsDTO> goodsDTOMap = goodsService.finAllMapInfo(goodsIds);
            goodsRecommendDTOS.stream().forEach(e -> {
                e.setGoodsDTO(goodsDTOMap.get(e.getGoodsId()));
            });
        }
        return goodsRecommendDTOS;
    }
}