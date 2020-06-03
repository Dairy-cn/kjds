package com.cross.merchants.web.rest;

import com.cross.merchants.domain.Goods;
import com.cross.merchants.service.GoodsRecommendBannerService;
import com.cross.merchants.service.GoodsRecommendService;
import com.cross.merchants.service.GoodsService;
import com.cross.merchants.service.dto.GoodsDTO;
import com.cross.merchants.service.dto.GoodsRecommendBannerDTO;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;
import com.cross.merchants.service.dto.GoodsRecommendDTO;

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
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.*;
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

    private final GoodsRecommendBannerService goodsRecommendBannerService;

    public GoodsRecommendResource(GoodsRecommendService goodsRecommendService, GoodsService goodsService, GoodsRecommendBannerService goodsRecommendBannerService) {
        this.goodsRecommendService = goodsRecommendService;
        this.goodsService = goodsService;
        this.goodsRecommendBannerService = goodsRecommendBannerService;
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
    public R<GoodsRecommendDTO> createGoodsRecommend(@Valid @RequestBody GoodsRecommendDTO goodsRecommendDTO) throws URISyntaxException {
        log.debug("REST request to save GoodsRecommend : {}", goodsRecommendDTO);
        if (goodsRecommendDTO.getId() != null) {
            return R.error("idexists");
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
    public R<GoodsRecommendDTO> updateGoodsRecommend(@Valid @RequestBody GoodsRecommendDTO goodsRecommendDTO) throws URISyntaxException {
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
    public R<List<GoodsRecommendDTO>> getAllGoodsRecommends(Pageable pageable,@ApiParam("推荐商品类型 1 单品推荐 2 专区推荐") @RequestParam(required = true) Integer goodsRecommendType) {
        log.debug("REST request to get a page of GoodsRecommends");
        Page<GoodsRecommendDTO> page = goodsRecommendService.findAllByType(pageable,goodsRecommendType);
        List<GoodsRecommendDTO> list = setParam(page.getContent());
        return R.ok(list, page.getTotalElements());
    }

    @GetMapping("/c-goods-recommends")
    @ApiOperation("c端---根据推荐商品类型获取推荐商品List")
    public R<List<GoodsRecommendDTO>> getAllGoodsRecommendsByC(Pageable pageable,@ApiParam("推荐商品类型 1 单品推荐 2 专区推荐") @RequestParam(required = true) Integer goodsRecommendType) {
        log.debug("REST request to get a page of GoodsRecommends");
        Page<GoodsRecommendDTO> page = goodsRecommendService.findAllByType(pageable,goodsRecommendType);
        List<GoodsRecommendDTO> list = setParam(page.getContent());
        return R.ok(list, page.getTotalElements());
    }

    @GetMapping("/goods-recommends-special-area")
    @ApiOperation("大后台---推荐专区商品推荐List")
    public R<List<GoodsRecommendBannerDTO>> getAllGoodsRecommends(Pageable pageable) {
        log.debug("REST request to get a page of GoodsRecommends");
        Page<GoodsRecommendDTO> page = goodsRecommendService.findAllByType(pageable,2);
        List<GoodsRecommendBannerDTO> recommendBannerDTOS = setParamBannerDto(page.getContent());
        return R.ok(recommendBannerDTOS, page.getTotalElements());
    }
    /**
     * {@code GET  /goods-recommends/:id} : get the "id" goodsRecommend.
     *
     * @param id the id of the goodsRecommendDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the goodsRecommendDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/goods-recommends/{id}")
    @ApiOperation("大后台---根据id获取推荐商品信息")
    public R<GoodsRecommendDTO> getGoodsRecommend(@PathVariable Long id) {
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
            List<Long> goodsBannerIds = goodsRecommendDTOS.stream().filter(e->e.getGoodsRecommendType()==2).map(GoodsRecommendDTO::getGoodsRecommendBannerId).collect(Collectors.toList());

            Map<Long, GoodsDTO> goodsDTOMap = goodsService.finAllMapInfo(goodsIds);
            goodsRecommendDTOS.stream().forEach(e -> {
                e.setGoodsDTO(goodsDTOMap.get(e.getGoodsId()));
            });
            if(!CollectionUtils.isEmpty(goodsBannerIds)){
                Map<Long, GoodsRecommendBannerDTO> goodsRecommendBannerDTOMap = goodsRecommendBannerService.finAllMapInfo(goodsBannerIds);
                goodsRecommendDTOS.stream().filter(e->e.getGoodsRecommendType()==2).forEach(e->{
                    e.setGoodsRecommendBannerDTO(goodsRecommendBannerDTOMap.get(e.getGoodsRecommendBannerId()));
                });
            }
        }
        return goodsRecommendDTOS;
    }
    private List<GoodsRecommendBannerDTO> setParamBannerDto(List<GoodsRecommendDTO> goodsRecommendDTOS) {
        List<GoodsRecommendBannerDTO> goodsRecommendBannerDTOS=new ArrayList<>();
        if (!CollectionUtils.isEmpty(goodsRecommendDTOS)) {
            List<Long> goodsIds = goodsRecommendDTOS.stream().map(GoodsRecommendDTO::getGoodsId).collect(Collectors.toList());
            List<Long> goodsBannerIds = goodsRecommendDTOS.stream().filter(e->e.getGoodsRecommendType()==2).map(GoodsRecommendDTO::getGoodsRecommendBannerId).collect(Collectors.toList());

            Map<Long, GoodsDTO> goodsDTOMap = goodsService.finAllMapInfo(goodsIds);
            goodsRecommendDTOS.stream().forEach(e -> {
                e.setGoodsDTO(goodsDTOMap.get(e.getGoodsId()));
            });
            if(!CollectionUtils.isEmpty(goodsBannerIds)){
                goodsRecommendBannerDTOS = goodsRecommendBannerService.finAllListInfo(goodsBannerIds);
                Map<Long, List<GoodsRecommendDTO>> longListMap = goodsRecommendDTOS.stream().filter(e -> e.getGoodsRecommendType() == 2).collect(Collectors.groupingBy(GoodsRecommendDTO::getGoodsRecommendBannerId));
                goodsRecommendBannerDTOS.stream().forEach(e->{
                    e.setGoodsRecommendDTOS(longListMap.get(e.getId()));
                });
            }
        }
        return goodsRecommendBannerDTOS;
    }

}
