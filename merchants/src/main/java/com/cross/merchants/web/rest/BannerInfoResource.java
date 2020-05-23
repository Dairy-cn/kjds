package com.cross.merchants.web.rest;

import com.cross.merchants.service.BannerInfoService;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;
import com.cross.merchants.service.dto.BannerInfoDTO;

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
 * REST controller for managing {@link com.cross.merchants.domain.BannerInfo}.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "广告相关接口")
public class BannerInfoResource {

    private final Logger log = LoggerFactory.getLogger(BannerInfoResource.class);

    private static final String ENTITY_NAME = "merchantsBannerInfo";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BannerInfoService bannerInfoService;

    public BannerInfoResource(BannerInfoService bannerInfoService) {
        this.bannerInfoService = bannerInfoService;
    }

    /**
     * {@code POST  /banner-infos} : Create a new bannerInfo.
     *
     * @param bannerInfoDTO the bannerInfoDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new bannerInfoDTO, or with status {@code 400 (Bad Request)} if the bannerInfo has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/banner-infos")
    @ApiOperation("商户端/大后台--添加广告信息")
    public R createBannerInfo(@Valid @RequestBody BannerInfoDTO bannerInfoDTO) throws URISyntaxException {
        log.debug("REST request to save BannerInfo : {}", bannerInfoDTO);
        if (bannerInfoDTO.getId() != null) {
            return R.error("idexists");
        }
        bannerInfoDTO.setShowState(false);
        bannerInfoDTO.setTop(false);
        BannerInfoDTO result = bannerInfoService.save(bannerInfoDTO);
        return R.ok(result);
    }

    @PostMapping("/banner-infos-merchant")
    @ApiOperation("商户端-店铺管理-店铺装修-添加广告信息")
    public R createBannerInfoByMerchant(@Valid @RequestBody BannerInfoDTO bannerInfoDTO) throws URISyntaxException {
        log.debug("REST request to save BannerInfo : {}", bannerInfoDTO);
        if (bannerInfoDTO.getId() != null) {
            return R.error("idexists");
        }
        bannerInfoDTO.setBannerType(1);
        bannerInfoDTO.setShowState(false);
        bannerInfoDTO.setTop(false);
        BannerInfoDTO result = bannerInfoService.save(bannerInfoDTO);
        return R.ok(result);
    }

    /**
     * {@code PUT  /banner-infos} : Updates an existing bannerInfo.
     *
     * @param bannerInfoDTO the bannerInfoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated bannerInfoDTO,
     * or with status {@code 400 (Bad Request)} if the bannerInfoDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the bannerInfoDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/banner-infos")
    @ApiOperation("商户端/大后台--修改广告信息")
    public R updateBannerInfo(@Valid @RequestBody BannerInfoDTO bannerInfoDTO) throws URISyntaxException {
        log.debug("REST request to update BannerInfo : {}", bannerInfoDTO);
        if (bannerInfoDTO.getId() == null) {
            return R.error("idnull");
        }
        BannerInfoDTO result = bannerInfoService.save(bannerInfoDTO);
        return R.ok(result);
    }

    @PutMapping("/banner-infos-show-state/{id}")
    @ApiOperation("大后台--修改广告显示状态")
    public R updateBannerInfoShowState(@PathVariable Long id, @ApiParam("显示状态 true 显示 false 隐藏 ") @RequestParam Boolean showState) throws URISyntaxException {

        BannerInfoDTO one = bannerInfoService.getOne(id);
        if (one == null) {
            return R.errorData();
        }
        if (showState == null) {
            return R.error("显示状态不能为空");
        }
        one.setShowState(showState);
        BannerInfoDTO result = bannerInfoService.save(one);
        return R.ok(result);
    }

    @PutMapping("/banner-infos-top-state-platform/{id}")
    @ApiOperation("大后台--修改广告置顶状态")
    public R updateBannerInfoTopState(@PathVariable Long id) throws URISyntaxException {
        boolean b = bannerInfoService.updateBannerInfoTopStateByPlatform(id);
        if (b) {
            return R.ok();
        } else {
            return R.error();
        }
    }
    @PutMapping("/banner-infos-top-state-merchant/{id}")
    @ApiOperation("商户端--修改广告置顶状态")
    public R updateBannerInfoTopStateByMerchant(@PathVariable Long id) throws URISyntaxException {
        boolean b = bannerInfoService.updateBannerInfoTopStateByMerchant(id);
        if (b) {
            return R.ok();
        } else {
            return R.error();
        }
    }
    /**
     * {@code GET  /banner-infos} : get all the bannerInfos.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of bannerInfos in body.
     */
    @GetMapping("/banner-infos")
    @ApiOperation("大后台--根据条件获取广告list")
    public R getAllBannerInfos(@ApiParam("位置类型 1 顶部轮播 2 弹窗 3 A区广告位") @RequestParam Integer positionType) {
        log.debug("REST request to get a page of BannerInfos");
        List<BannerInfoDTO> list = bannerInfoService.findAllByCondition(positionType);
        return R.ok(list);
    }


    @GetMapping("/banner-infos-type")
    @ApiOperation("大后台--根据广告类型获取广告list")
    public R getAllBannerInfosByType(@ApiParam("类型 1 商户广告 2 大后台广告 3 商户推荐广告  4 商品推荐广告") @RequestParam Integer bannerType) {
        log.debug("REST request to get a page of BannerInfos");
        List<BannerInfoDTO> list = bannerInfoService.findAllByBannerType(bannerType);

        return R.ok(list);
    }
    @GetMapping("/goods-recommend-banner-infos")
    @ApiOperation("大后台--获取商品推荐广告列表(添加推荐商品时用的接口)")
    public R getAllGoodsRecommentBannerInfosByType( ) {
        log.debug("REST request to get a page of BannerInfos");
        List<BannerInfoDTO> list = bannerInfoService.findAllByBannerTypeGroupByPositionCode(4);
        return R.ok(list);
    }

    @GetMapping("/banner-infos-merchant/{storeId}")
    @ApiOperation("大后台--根据条件获取广告list")
    public R getAllBannerInfosByMerchant(@ApiParam("商户id") @PathVariable Long storeId) {
        log.debug("REST request to get a page of BannerInfos");
        List<BannerInfoDTO> list = bannerInfoService.findAllByStoreId(storeId);
        return R.ok(list);
    }
    /**
     * {@code GET  /banner-infos/:id} : get the "id" bannerInfo.
     *
     * @param id the id of the bannerInfoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the bannerInfoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/banner-infos/{id}")
    @ApiOperation("商户端/大后台--根据id获取详情")
    public R getBannerInfo(@PathVariable Long id) {
        log.debug("REST request to get BannerInfo : {}", id);
        BannerInfoDTO bannerInfoDTO = bannerInfoService.getOne(id);
        return R.ok(bannerInfoDTO);
    }

    /**
     * {@code DELETE  /banner-infos/:id} : delete the "id" bannerInfo.
     *
     * @param id the id of the bannerInfoDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/banner-infos/{id}")
    @ApiOperation("商户端/大后台--根据id删除记录")
    public R deleteBannerInfo(@PathVariable Long id) {
        log.debug("REST request to delete BannerInfo : {}", id);
        bannerInfoService.delete(id);
        return R.ok();
    }
}
