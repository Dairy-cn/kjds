package com.cross.merchants.web.rest;

import com.cross.merchants.domain.GoodsProperty;
import com.cross.merchants.service.GoodsCategoryService;
import com.cross.merchants.service.GoodsPropertyService;
import com.cross.merchants.service.GoodsService;
import com.cross.merchants.service.GoodsSkuService;
import com.cross.merchants.service.dto.GoodsCategoryDTO;
import com.cross.merchants.service.dto.GoodsPropertyDTO;
import com.cross.merchants.service.dto.GoodsSkuDTO;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;
import com.cross.merchants.service.dto.GoodsDTO;

import com.cross.utils.CommonUtil;
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
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for managing {@link com.cross.merchants.domain.Goods}.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "商品相关接口")
public class GoodsResource {

    private final Logger log = LoggerFactory.getLogger(GoodsResource.class);

    private static final String ENTITY_NAME = "merchantsGoods";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final GoodsService goodsService;

    private final GoodsSkuService goodsSkuService;

    private final GoodsCategoryService goodsCategoryService;

    private final GoodsPropertyService goodsPropertyService;

    public GoodsResource(GoodsService goodsService, GoodsSkuService goodsSkuService, GoodsCategoryService goodsCategoryService, GoodsPropertyService goodsPropertyService) {
        this.goodsService = goodsService;
        this.goodsSkuService = goodsSkuService;
        this.goodsCategoryService = goodsCategoryService;
        this.goodsPropertyService = goodsPropertyService;
    }

    /**
     * {@code POST  /goods} : Create a new goods.
     *
     * @param goodsDTO the goodsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new goodsDTO, or with status {@code 400 (Bad Request)} if the goods has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/goods")
    @ApiOperation("新建商品-提交商品审核")
    public R createGoods(@Valid @RequestBody GoodsDTO goodsDTO) throws URISyntaxException {
        log.debug("REST request to save Goods : {}", goodsDTO);
        if (goodsDTO.getId() != null) {
            return R.error("idexists");
        }
        goodsDTO.setApplicationTime(Instant.now());
        goodsDTO.setCheckStatus(-1);
        goodsDTO.setDeleteFlag(false);
        goodsDTO.setSaleState(false);
        goodsDTO.setProposer(CommonUtil.getCurrentLoginUser().getId());
        GoodsDTO result = goodsService.save(goodsDTO);
        return R.ok(result);
    }

    @PutMapping("/re-upload-goods")
    @ApiOperation("重新提交审核商品")
    public R reCheckGoods(@Valid @RequestBody GoodsDTO goodsDTO) throws URISyntaxException {
        log.debug("REST request to update Goods : {}", goodsDTO);
        log.debug("REST request to save Goods : {}", goodsDTO);
        if (goodsDTO.getId() != null) {
            return R.error("idexists");
        }
        Optional<GoodsDTO> one = goodsService.findOne(goodsDTO.getId());
        if (!one.isPresent()) {
            return R.errorData();
        }
        GoodsDTO dbGoodsDto = one.get();
        if (0 != dbGoodsDto.getCheckStatus()) {
            if (1 == dbGoodsDto.getCheckStatus()) {
                return R.error("审核成功的商品不能重复提交审核");
            } else if (-1 == dbGoodsDto.getCheckStatus()) {
                return R.error("正在审核的商品不能重复提交审核");
            }
            return R.error("商品状态错误,请联系管理员");
        } else {
            goodsDTO.setApplicationTime(Instant.now());
            goodsDTO.setCheckStatus(-1);
            goodsDTO.setDeleteFlag(false);
            goodsDTO.setSaleState(false);
            goodsDTO.setProposer(CommonUtil.getCurrentLoginUser().getId());
            GoodsDTO result = goodsService.save(goodsDTO);
            return R.ok(result);
        }

    }

    /**
     * {@code PUT  /goods} : Updates an existing goods.
     *
     * @param goodsDTO the goodsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated goodsDTO,
     * or with status {@code 400 (Bad Request)} if the goodsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the goodsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/goods")
    @ApiOperation("编辑商品")
    public R updateGoods(@Valid @RequestBody GoodsDTO goodsDTO) throws URISyntaxException {
        log.debug("REST request to update Goods : {}", goodsDTO);
        if (goodsDTO.getId() == null) {
            return R.error("idnull");
        }
        Optional<GoodsDTO> one = goodsService.findOne(goodsDTO.getId());
        if (!one.isPresent()) {
            return R.errorData();
        }
        GoodsDTO dbGoodsDto = one.get();
        if (-1 == dbGoodsDto.getCheckStatus()) {
            return R.error("审核中的商品不能编辑");
        } else if (0 == dbGoodsDto.getCheckStatus()) {
            return R.error("审核未通过的商品请通过重新审核的接口提交");
        }
        GoodsDTO result = goodsService.save(goodsDTO);
        return R.ok(result);
    }

    @PutMapping("/goods-update-sale-state/{id}")
    @ApiOperation("上下架商品")
    public R updateGoodsSaleState(@PathVariable Long id, @RequestParam Boolean saleState) throws URISyntaxException {
        if (saleState == null) {
            return R.error();
        }
        Optional<GoodsDTO> one = goodsService.findOne(id);
        if (!one.isPresent()) {
            return R.errorData();
        }
        GoodsDTO dbGoodsDto = one.get();
        if (1 != dbGoodsDto.getCheckStatus()) {
            return R.error("审核未通过的商品不能修改上下架状态");
        }
        dbGoodsDto.setSaleState(saleState);
        GoodsDTO result = goodsService.save(dbGoodsDto);
        return R.ok(result);
    }

    /**
     * {@code GET  /goods} : get all the goods.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of goods in body.
     */
    @GetMapping("/goods")
    @ApiOperation("获取所有的商品信息")
    public ResponseEntity<List<GoodsDTO>> getAllGoods(Pageable pageable) {
        log.debug("REST request to get a page of Goods");
        Page<GoodsDTO> page = goodsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }


    @GetMapping("/goods-by-condition")
    @ApiOperation("商户端--店铺商品列表")
    public R getAllGoodsByCondition(@ApiParam("分页信息") Pageable pageable,
                                    @ApiParam(value = "店铺id", required = true) @RequestParam Long storeId,
                                    @ApiParam("品牌id") @RequestParam(required = false) Long brandId,
                                    @ApiParam("上下架状态") @RequestParam(required = false) Boolean saleState,
                                    @ApiParam("审核状态 null 为全部 1 通过 -1 未审核 0 审核失败") @RequestParam(required = false) Integer checkState,
                                    @ApiParam("提交开始时间 eg 2017-11-27T03:16:03Z") @RequestParam(required = false) Instant startTime,
                                    @ApiParam("提交结束时间 eg 2017-11-27T03:16:03Z ") @RequestParam(required = false) Instant endTime,
                                    @ApiParam("关键字查询") @RequestParam(required = false) String keyWord,
                                    @ApiParam(value = "商品类型 1 售卖商品 2 审核商品", required = true) @RequestParam(required = true) Integer goodsType
    ) {
        log.debug("REST request to get a page of Goods");
        Page<GoodsDTO> page = goodsService.getAllGoodsByCondition(pageable, storeId, brandId, saleState, checkState, startTime, endTime, keyWord, goodsType);
        if (!CollectionUtils.isEmpty(page.getContent())) {
            List<Long> categoryIds = page.getContent().stream().filter(e -> e.getCategoryId() != null).map(GoodsDTO::getCategoryId).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(categoryIds)) {
                Map<Long, GoodsCategoryDTO> parentInfoMap = goodsCategoryService.findAllByInInWithParentInfo(categoryIds);
                page.getContent().stream().filter(e->e.getCategoryId()!=null).forEach(e->{
                    e.setGoodsCategoryDTO(parentInfoMap.get(e.getCategoryId()));
                });
            }

            List<Long> goodsIds=page.getContent().stream().map(GoodsDTO::getId).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(goodsIds)){
                Map<Long, List<GoodsSkuDTO>> skuMap = goodsSkuService.findAllByIdGoodsInGroupById(goodsIds);
                page.getContent().stream().forEach(e->{
                    e.setGoodsSkuDTOS(skuMap.get(e.getId()));
                });

                Map<Long, List<GoodsPropertyDTO>> propertyMap = goodsPropertyService.findAllByIdGoodsInGroupById(goodsIds);
                page.getContent().stream().forEach(e->{
                    e.setGoodsPropertyDTOS(propertyMap.get(e.getId()));
                });
            }
        }
        return R.ok(page.getContent(), page.getTotalElements());
    }

    /**
     * {@code GET  /goods/:id} : get the "id" goods.
     *
     * @param id the id of the goodsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the goodsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/goods/{id}")
    public ResponseEntity<GoodsDTO> getGoods(@PathVariable Long id) {
        log.debug("REST request to get Goods : {}", id);
        Optional<GoodsDTO> goodsDTO = goodsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(goodsDTO);
    }

    /**
     * {@code DELETE  /goods/:id} : delete the "id" goods.
     *
     * @param id the id of the goodsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/goods/{id}")
    public ResponseEntity<Void> deleteGoods(@PathVariable Long id) {
        log.debug("REST request to delete Goods : {}", id);
        goodsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
