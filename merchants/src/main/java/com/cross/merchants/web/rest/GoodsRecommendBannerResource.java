package com.cross.merchants.web.rest;

import com.cross.merchants.service.GoodsRecommendBannerService;
import com.cross.merchants.service.dto.BannerInfoDTO;
import com.cross.merchants.service.dto.GoodsRecommendBannerPositionDTO;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;
import com.cross.merchants.service.dto.GoodsRecommendBannerDTO;

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

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.cross.merchants.domain.GoodsRecommendBanner}.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "商品推荐--广告相关接口")
public class GoodsRecommendBannerResource {

    private final Logger log = LoggerFactory.getLogger(GoodsRecommendBannerResource.class);

    private static final String ENTITY_NAME = "merchantsGoodsRecommendBanner";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final GoodsRecommendBannerService goodsRecommendBannerService;

    public GoodsRecommendBannerResource(GoodsRecommendBannerService goodsRecommendBannerService) {
        this.goodsRecommendBannerService = goodsRecommendBannerService;
    }

    /**
     * {@code POST  /goods-recommend-banners} : Create a new goodsRecommendBanner.
     *
     * @param goodsRecommendBannerDTO the goodsRecommendBannerDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new goodsRecommendBannerDTO, or with status {@code 400 (Bad Request)} if the goodsRecommendBanner has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/goods-recommend-banners")
    @ApiOperation("大后台---商品推荐--广告管理--添加专区广告")
    public R<GoodsRecommendBannerDTO> createGoodsRecommendBanner(@Valid @RequestBody GoodsRecommendBannerDTO goodsRecommendBannerDTO) throws URISyntaxException {
        log.debug("REST request to save GoodsRecommendBanner : {}", goodsRecommendBannerDTO);
        if (goodsRecommendBannerDTO.getId() != null) {
            return R.error("idexists");
        }
        GoodsRecommendBannerDTO result = goodsRecommendBannerService.save(goodsRecommendBannerDTO);
        return R.ok(result);
    }

    /**
     * {@code PUT  /goods-recommend-banners} : Updates an existing goodsRecommendBanner.
     *
     * @param goodsRecommendBannerDTO the goodsRecommendBannerDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated goodsRecommendBannerDTO,
     * or with status {@code 400 (Bad Request)} if the goodsRecommendBannerDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the goodsRecommendBannerDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/goods-recommend-banners")
    @ApiOperation("大后台---商品推荐--广告管理--修改专区广告")
    public R<GoodsRecommendBannerDTO> updateGoodsRecommendBanner(@Valid @RequestBody GoodsRecommendBannerDTO goodsRecommendBannerDTO) throws URISyntaxException {
        log.debug("REST request to update GoodsRecommendBanner : {}", goodsRecommendBannerDTO);
        if (goodsRecommendBannerDTO.getId() == null) {
            return R.error("idnull");
        }
        GoodsRecommendBannerDTO result = goodsRecommendBannerService.save(goodsRecommendBannerDTO);
        return R.ok(result);
    }

    /**
     * {@code GET  /goods-recommend-banners} : get all the goodsRecommendBanners.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of goodsRecommendBanners in body.
     */
    @GetMapping("/goods-recommend-banners")
    @ApiOperation("大后台---商品推荐--广告管理--获取专区广告列表")
    public R<List<GoodsRecommendBannerDTO>> getAllGoodsRecommendBanners(Pageable pageable) {
        log.debug("REST request to get a page of GoodsRecommendBanners");
        Page<GoodsRecommendBannerDTO> page = goodsRecommendBannerService.findAll(pageable);
        return R.ok(page.getContent(), page.getTotalElements());
    }

    @GetMapping("/goods-recommend-banners-list")
    @ApiOperation("大后台---商品推荐--广告管理--获取所有的专区列表(没有装载数据接口)")
    public R<List<GoodsRecommendBannerDTO>> getAllGoodsRecommendBannersList() {
        log.debug("REST request to get a page of GoodsRecommendBanners");
        List<GoodsRecommendBannerDTO> list = goodsRecommendBannerService.findAll();
        return R.ok(list);
    }

    /**
     * {@code GET  /goods-recommend-banners/:id} : get the "id" goodsRecommendBanner.
     *
     * @param id the id of the goodsRecommendBannerDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the goodsRecommendBannerDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/goods-recommend-banners/{id}")
    @ApiOperation("根据id获取广告信息")
    public R<GoodsRecommendBannerDTO> getGoodsRecommendBanner(@PathVariable Long id) {
        log.debug("REST request to get GoodsRecommendBanner : {}", id);
        Optional<GoodsRecommendBannerDTO> goodsRecommendBannerDTO = goodsRecommendBannerService.findOne(id);
        return R.ok(goodsRecommendBannerDTO.get());
    }

    /**
     * {@code DELETE  /goods-recommend-banners/:id} : delete the "id" goodsRecommendBanner.
     *
     * @param id the id of the goodsRecommendBannerDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/goods-recommend-banners/{id}")
    @ApiOperation("根据id删除广告信息")
    public R deleteGoodsRecommendBanner(@PathVariable Long id) {
        log.debug("REST request to delete GoodsRecommendBanner : {}", id);
        goodsRecommendBannerService.delete(id);
        return R.ok();
    }


    @PutMapping("/goods-recommend-banners-infos-show-state/{id}")
    @ApiOperation("大后台--修改商品广告显示状态")
    public R<GoodsRecommendBannerDTO> updateGoodsBannerInfoShowState(@PathVariable Long id,
                                            @ApiParam("上传位置 1 第一块 2 第二块  3 第三块 ") @RequestParam Integer position,
                                            @ApiParam("显示状态 true 显示 false 隐藏 ") @RequestParam Boolean showState) throws URISyntaxException {

        GoodsRecommendBannerDTO one = goodsRecommendBannerService.getOne(id);
        if (one == null) {
            return R.errorData();
        }
        if (showState == null) {
            return R.error("显示状态不能为空");
        }
        if (position == null) {
            return R.error("上传位置不能为空");
        }
        GoodsRecommendBannerPositionDTO positionDTO;
        if (1 == position) {
            positionDTO = one.getPositionOne();
            if (positionDTO != null) {
                positionDTO.setShowState(showState);
                one.setPositionOne(positionDTO);
            }
        } else if (2 == position) {
            positionDTO = one.getPositionTwo();
            if (positionDTO != null) {
                positionDTO.setShowState(showState);
                one.setPositionTwo(positionDTO);
            }

        } else if (3 == position) {
            positionDTO = one.getPositionThree();
            if (positionDTO != null) {
                positionDTO.setShowState(showState);
                one.setPositionThree(positionDTO);
            }

        }
        one = goodsRecommendBannerService.save(one);
        return R.ok(one);
    }

    @PutMapping("/goods-recommend-banners-top-state-platform/{id}")
    @ApiOperation("大后台--修改商品广告置顶状态")
    public R updateGoodsBannerInfoTopState(@PathVariable Long id) throws URISyntaxException {
        boolean b = goodsRecommendBannerService.updateGoodsBannerInfoTopState(id);
        if (b) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @GetMapping("/c-goods-recommend-banners")
    @ApiOperation("c端--获取商品推荐专区广告列表")
    public R<List<GoodsRecommendBannerDTO>> getAllGoodsRecommendBannersByC(Pageable pageable) {
        log.debug("REST request to get a page of GoodsRecommendBanners");
        Page<GoodsRecommendBannerDTO> page = goodsRecommendBannerService.findAllByC(pageable);
        return R.ok(page.getContent(), page.getTotalElements());
    }
}
