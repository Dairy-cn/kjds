package com.cross.merchants.web.rest;

import com.cross.merchants.domain.GoodsProperty;
import com.cross.merchants.service.*;
import com.cross.merchants.service.dto.*;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;

import com.cross.utils.CommonUtil;
import com.cross.utils.PinyinUtil;
import com.cross.utils.R;
import com.cross.utils.RandomUtil;
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
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
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

    private final StoreInfoService storeInfoService;


    private final BrandService brandService;


    public GoodsResource(GoodsService goodsService, GoodsSkuService goodsSkuService, GoodsCategoryService goodsCategoryService, GoodsPropertyService goodsPropertyService, StoreInfoService storeInfoService, BrandService brandService) {
        this.goodsService = goodsService;
        this.goodsSkuService = goodsSkuService;
        this.goodsCategoryService = goodsCategoryService;
        this.goodsPropertyService = goodsPropertyService;
        this.storeInfoService = storeInfoService;
        this.brandService = brandService;
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
    public R<GoodsDTO> createGoods(@Valid @RequestBody GoodsDTO goodsDTO) throws URISyntaxException {
        log.debug("REST request to save Goods : {}", goodsDTO);
        if (goodsDTO.getId() != null) {
            return R.error("idexists");
        }
        goodsDTO.setApplicationTime(Instant.now());
        goodsDTO.setCheckStatus(-1);
        goodsDTO.setDeleteFlag(false);
        goodsDTO.setSaleState(false);
        goodsDTO.setCreateTime(Instant.now());
        goodsDTO.setProposer(CommonUtil.getCurrentLoginUser().getId());
        GoodsDTO result = goodsService.save(goodsDTO);
        return R.ok(result);
    }

    @PutMapping("/re-upload-goods")
    @ApiOperation("重新提交审核商品")
    public R<GoodsDTO> reCheckGoods(@Valid @RequestBody GoodsDTO goodsDTO) throws URISyntaxException {
        log.debug("REST request to update Goods : {}", goodsDTO);
        log.debug("REST request to save Goods : {}", goodsDTO);
        if (goodsDTO.getId() == null) {
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
            GoodsDTO result = goodsService.reCheckGoods(goodsDTO);
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
    public R<GoodsDTO> updateGoods(@Valid @RequestBody GoodsDTO goodsDTO) throws URISyntaxException {
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
    public R<GoodsDTO> updateGoodsSaleState(@PathVariable Long id, @RequestParam Boolean saleState) throws URISyntaxException {
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
        GoodsDTO result = goodsService.saveOnly(dbGoodsDto);
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
    public R<List<GoodsDTO>> getAllGoods(Pageable pageable) {
        log.debug("REST request to get a page of Goods");
        Page<GoodsDTO> page = goodsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return R.ok(page.getContent(), page.getTotalElements());
    }

    @GetMapping("/goods-sale-list-by-store")
    @ApiOperation("商户端(数据添加查询接口)--获取所有的已上架的商品列表")
    public R<List<GoodsDTO>> getAllGoodsSaleListByStore(@ApiParam("商户di") @RequestParam(required = true) Long storeId, @ApiParam("商品分类id") @RequestParam(required = false) Long categoryId,
                                                        @ApiParam("商品名称或编号查询") @RequestParam(required = false) String keyWord) {
        log.debug("REST request to get a page of Goods");
        List<GoodsDTO> list = goodsService.findAllByCategoryIdAndKeywordAndCheckStateAndSaleState(storeId, categoryId, keyWord, true, 1);
        if (!CollectionUtils.isEmpty(list)) {
            List<Long> categoryIds = list.stream().filter(e -> e.getCategoryId() != null).map(GoodsDTO::getCategoryId).collect(Collectors.toList());
            List<Long> storeIds = list.stream().filter(e -> e.getStoreId() != null).map(GoodsDTO::getStoreId).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(categoryIds)) {
                Map<Long, GoodsCategoryDTO> parentInfoMap = goodsCategoryService.findAllByInInWithParentInfo(categoryIds);
                list.stream().filter(e -> e.getCategoryId() != null).forEach(e -> {
                    e.setGoodsCategoryDTO(parentInfoMap.get(e.getCategoryId()));
                });
            }
            if (!CollectionUtils.isEmpty(storeIds)) {
                List<StoreInfoDTO> storeInfoDTOS = storeInfoService.findAllByIdIn(storeIds);
                Map<Long, StoreInfoDTO> storeInfoDTOMap = storeInfoDTOS.stream().collect(Collectors.toMap(StoreInfoDTO::getId, e -> e));
                list.stream().filter(e -> e.getStoreId() != null).forEach(e -> {
                    e.setStoreInfoDTO(storeInfoDTOMap.get(e.getStoreId()));
                });
            }
        }
        return R.ok(list);
    }

    @GetMapping("/goods-sale-list")
    @ApiOperation("(数据添加查询接口)--获取所有的已上架的商品列表")
    public R<List<GoodsDTO>> getAllGoodsSaleList(@ApiParam("商品分类id") @RequestParam(required = false) Long categoryId,
                                                 @ApiParam("商品名称或编号查询") @RequestParam(required = false) String keyWord) {
        log.debug("REST request to get a page of Goods");
        List<GoodsDTO> list = goodsService.findAllByCategoryIdAndKeywordAndCheckStateAndSaleState(null, categoryId, keyWord, true, 1);
        if (!CollectionUtils.isEmpty(list)) {
            List<Long> categoryIds = list.stream().filter(e -> e.getCategoryId() != null).map(GoodsDTO::getCategoryId).collect(Collectors.toList());
            List<Long> storeIds = list.stream().filter(e -> e.getStoreId() != null).map(GoodsDTO::getStoreId).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(categoryIds)) {
                Map<Long, GoodsCategoryDTO> parentInfoMap = goodsCategoryService.findAllByInInWithParentInfo(categoryIds);
                list.stream().filter(e -> e.getCategoryId() != null).forEach(e -> {
                    e.setGoodsCategoryDTO(parentInfoMap.get(e.getCategoryId()));
                });
            }
            if (!CollectionUtils.isEmpty(storeIds)) {
                List<StoreInfoDTO> storeInfoDTOS = storeInfoService.findAllByIdIn(storeIds);
                Map<Long, StoreInfoDTO> storeInfoDTOMap = storeInfoDTOS.stream().collect(Collectors.toMap(StoreInfoDTO::getId, e -> e));
                list.stream().filter(e -> e.getStoreId() != null).forEach(e -> {
                    e.setStoreInfoDTO(storeInfoDTOMap.get(e.getStoreId()));
                });
            }
        }
        return R.ok(list);
    }

    @GetMapping("/goods-by-condition")
    @ApiOperation("商户端--店铺商品列表")
    public R<List<GoodsDTO>> getAllGoodsByCondition(@ApiParam("分页信息") Pageable pageable,
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
                page.getContent().stream().filter(e -> e.getCategoryId() != null).forEach(e -> {
                    e.setGoodsCategoryDTO(parentInfoMap.get(e.getCategoryId()));
                });
            }

            List<Long> goodsIds = page.getContent().stream().map(GoodsDTO::getId).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(goodsIds)) {
                Map<Long, List<GoodsSkuDTO>> skuMap = goodsSkuService.findAllByIdGoodsInGroupById(goodsIds);
                page.getContent().stream().forEach(e -> {
                    e.setGoodsSkuDTOS(skuMap.get(e.getId()));
                });

                Map<Long, List<GoodsPropertyDTO>> propertyMap = goodsPropertyService.findAllByIdGoodsInGroupById(goodsIds);
                page.getContent().stream().forEach(e -> {
                    e.setGoodsPropertyDTOS(propertyMap.get(e.getId()));
                });
            }
        }
        return R.ok(page.getContent(), page.getTotalElements());
    }


    @GetMapping("/goods-by-condition-by-c")
    @ApiOperation("C端--店铺商品列表")
    public R<List<GoodsDTO>> getAllGoodsByConditionByC(Pageable pageable,
                                                       @ApiParam(value = "店铺id", required = true) @RequestParam(required = false) Long storeId,
                                                       @ApiParam("品牌id") @RequestParam(required = false) Long brandId,
                                                       @ApiParam("关键字查询 请输入商品名称/SPU编码") @RequestParam(required = false) String keyWord
    ) {
        log.debug("REST request to get a page of Goods");
        Page<GoodsDTO> page = goodsService.getAllGoodsByCondition(pageable, storeId, brandId, 1, null, null, keyWord, null, null, null, null, null);
        if (!CollectionUtils.isEmpty(page.getContent())) {
            List<Long> categoryIds = page.getContent().stream().filter(e -> e.getCategoryId() != null).map(GoodsDTO::getCategoryId).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(categoryIds)) {
                Map<Long, GoodsCategoryDTO> parentInfoMap = goodsCategoryService.findAllByInInWithParentInfo(categoryIds);
                page.getContent().stream().filter(e -> e.getCategoryId() != null).forEach(e -> {
                    e.setGoodsCategoryDTO(parentInfoMap.get(e.getCategoryId()));
                });
            }

            List<Long> goodsIds = page.getContent().stream().map(GoodsDTO::getId).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(goodsIds)) {
                Map<Long, List<GoodsSkuDTO>> skuMap = goodsSkuService.findAllByIdGoodsInGroupById(goodsIds);
                page.getContent().stream().forEach(e -> {
                    e.setGoodsSkuDTOS(skuMap.get(e.getId()));
                });

                Map<Long, List<GoodsPropertyDTO>> propertyMap = goodsPropertyService.findAllByIdGoodsInGroupById(goodsIds);
                page.getContent().stream().forEach(e -> {
                    e.setGoodsPropertyDTOS(propertyMap.get(e.getId()));
                });
            }
        }
        return R.ok(page.getContent(), page.getTotalElements());
    }

    @GetMapping("/goods-by-condition-by-platform")
    @ApiOperation("大后台--店铺商品列表/商户商品列表")
    public R<List<GoodsDTO>> getAllGoodsByConditionByPlatform(@ApiParam("分页信息") Pageable pageable,
                                                              @ApiParam(value = "店铺id", required = false) @RequestParam(required = false) Long storeId,
                                                              @ApiParam("品牌id") @RequestParam(required = false) Long brandId,
                                                              @ApiParam("一级商品品类id") @RequestParam(required = false) Long oneCategoryId,
                                                              @ApiParam("二级商品品类id") @RequestParam(required = false) Long twoCategoryId,
                                                              @ApiParam("三商品品类id") @RequestParam(required = false) Long thirdCategoryId,
                                                              @ApiParam("审核状态 null 为全部 1 通过 -1 未审核 0 审核失败") @RequestParam(required = false) Integer checkState,
                                                              @ApiParam("提交开始时间 eg 2017-11-27T03:16:03Z") @RequestParam(required = false) Instant startTime,
                                                              @ApiParam("提交结束时间 eg 2017-11-27T03:16:03Z ") @RequestParam(required = false) Instant endTime,
                                                              @ApiParam("审核开始时间 eg 2017-11-27T03:16:03Z") @RequestParam(required = false) Instant startCheckTime,
                                                              @ApiParam("审核结束时间 eg 2017-11-27T03:16:03Z ") @RequestParam(required = false) Instant endCheckTime,
                                                              @ApiParam("关键字查询 请输入商品名称/SPU编码") @RequestParam(required = false) String keyWord
    ) {
        log.debug("REST request to get a page of Goods");
        Page<GoodsDTO> page = goodsService.getAllGoodsByCondition(pageable, storeId, brandId, checkState, startTime, endTime, keyWord, startCheckTime, endCheckTime, oneCategoryId, twoCategoryId, thirdCategoryId);
        if (!CollectionUtils.isEmpty(page.getContent())) {
            List<Long> categoryIds = page.getContent().stream().filter(e -> e.getCategoryId() != null).map(GoodsDTO::getCategoryId).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(categoryIds)) {
                Map<Long, GoodsCategoryDTO> parentInfoMap = goodsCategoryService.findAllByInInWithParentInfo(categoryIds);
                page.getContent().stream().filter(e -> e.getCategoryId() != null).forEach(e -> {
                    e.setGoodsCategoryDTO(parentInfoMap.get(e.getCategoryId()));
                });
            }

            List<Long> goodsIds = page.getContent().stream().map(GoodsDTO::getId).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(goodsIds)) {
                Map<Long, List<GoodsSkuDTO>> skuMap = goodsSkuService.findAllByIdGoodsInGroupById(goodsIds);
                page.getContent().stream().forEach(e -> {
                    e.setGoodsSkuDTOS(skuMap.get(e.getId()));
                });

                Map<Long, List<GoodsPropertyDTO>> propertyMap = goodsPropertyService.findAllByIdGoodsInGroupById(goodsIds);
                page.getContent().stream().forEach(e -> {
                    e.setGoodsPropertyDTOS(propertyMap.get(e.getId()));
                });
            }
            List<Long> storeIds = page.getContent().stream().map(GoodsDTO::getStoreId).distinct().collect(Collectors.toList());
            Map<Long, StoreInfoDTO> storeMap = new HashMap<>();
            if (!CollectionUtils.isEmpty(storeIds)) {
                List<StoreInfoDTO> storeList = storeInfoService.findAllByIdIn(storeIds);
                storeMap = storeList.stream().collect(Collectors.toMap(StoreInfoDTO::getId, e -> e));
            }
            Map<Long, StoreInfoDTO> finalStoreMap = storeMap;
            page.getContent().stream().forEach(e -> {
                e.setStoreInfoDTO(finalStoreMap.get(e.getStoreId()));
            });
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
    @ApiOperation("获取商品详情（包括sku-属性--分类信息）")
    public R<GoodsDTO> getGoods(@PathVariable Long id) {
        log.debug("REST request to get Goods : {}", id);
        Optional<GoodsDTO> one = goodsService.findOne(id);
        if (!one.isPresent()) {
            return R.errorData();
        }
        GoodsDTO goodsDTO = one.get();


        if (goodsDTO.getCategoryId() != null) {
            GoodsCategoryDTO categoryDTO = goodsCategoryService.findAllInfoByIdWithParentInfo(goodsDTO.getCategoryId());
            goodsDTO.setGoodsCategoryDTO(categoryDTO);
        }
        List<GoodsSkuDTO> skuList = goodsSkuService.findAllByGoodsId(goodsDTO.getId());
        goodsDTO.setGoodsSkuDTOS(skuList);
        List<GoodsPropertyDTO> goodsPropertyDTOList = goodsPropertyService.findAllByIdGoods(goodsDTO.getId());
        goodsDTO.setGoodsPropertyDTOS(goodsPropertyDTOList);
        StoreInfoDTO serviceOne = storeInfoService.getOne(goodsDTO.getStoreId());
        goodsDTO.setStoreInfoDTO(serviceOne);
        BrandDTO brandDto = brandService.findOne(goodsDTO.getBrandId());
        goodsDTO.setBrandDTO(brandDto);
        return R.ok(goodsDTO);
    }

    /**
     * {@code DELETE  /goods/:id} : delete the "id" goods.
     *
     * @param id the id of the goodsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/goods/{id}")
    @ApiOperation("删除商品信息")
    public R deleteGoods(@PathVariable Long id) {
        log.debug("REST request to delete Goods : {}", id);
        Optional<GoodsDTO> one = goodsService.findOne(id);
        if (!one.isPresent()) {
            return R.errorData();
        }
        GoodsDTO goodsDTO = one.get();
        goodsDTO.setDeleteFlag(true);
        GoodsDTO result = goodsService.saveOnly(goodsDTO);
        return R.ok();
    }

    @PutMapping("/goods-check/{id}")
    @ApiOperation("商品审核")
    public R<GoodsDTO> checkGoods(@ApiParam("记录id") @PathVariable Long id,
                                  @ApiParam("审核状态 true 通过 false 失败") @RequestParam Boolean status,
                                  @ApiParam(value = "失败原因", required = false) @RequestParam(required = false) String checkFailureReasons) throws URISyntaxException {

        if (status == null) {
            return R.error("审核状态不能为空");
        }
        Optional<GoodsDTO> one = goodsService.findOne(id);
        if (!one.isPresent()) {
            return R.errorData();
        }
        GoodsDTO dbGoodsDto = one.get();
//        if (-1 != dbGoodsDto.getCheckStatus()) {
//            return R.error("审核过的商品不能修改再次审核");
//        }

        dbGoodsDto.setCheckStatus(status ? 1 : 0);
        dbGoodsDto.setCheckTime(Instant.now());
        dbGoodsDto.setCheckFailureReasons(checkFailureReasons);
        if (status) {
            String brandHeadPinYin = PinyinUtil.getPinYinHeadChar(dbGoodsDto.getGoodsName().trim());
            Long code = RandomUtil.generateValidateCode();
            dbGoodsDto.setGoodsNo(brandHeadPinYin + code);
        }
        GoodsDTO result = goodsService.saveOnly(dbGoodsDto);
        return R.ok(result);
    }


    @GetMapping("/goods/keyword-query")
    @ApiOperation("c端-----根据关键字查询商品信息")
    public R<List<GoodsDTO>> queryGoodsList(@RequestParam String keyword, @RequestParam(required = false) Long storeId) {

        List<GoodsDTO> result = goodsService.queryGoodsList(keyword, storeId);
        if (!CollectionUtils.isEmpty(result)) {
            List<Long> storeIds = result.stream().map(GoodsDTO::getStoreId).distinct().collect(Collectors.toList());
            List<StoreInfoDTO> storeInfoDTOS = storeInfoService.findAllByIdIn(storeIds);
            Map<Long, StoreInfoDTO> storeMap = storeInfoDTOS.stream().collect(Collectors.toMap(StoreInfoDTO::getId, e -> e));
            result.stream().forEach(e -> {
                e.setStoreInfoDTO(storeMap.get(e.getStoreId()));
            });
        }
        return R.ok(result);
    }

    @GetMapping("/goods/guess-you-like")
    @ApiOperation("c端-----猜你喜欢,随机获取十五条,并获取价格最低的规格")
    public R<List<GoodsDTO>> guessYouWillLike() {

        List<GoodsDTO> result = goodsService.guessYouWillLike();
        if (!CollectionUtils.isEmpty(result)) {
            List<Long> storeIds = result.stream().map(GoodsDTO::getStoreId).distinct().collect(Collectors.toList());
            List<StoreInfoDTO> storeInfoDTOS = storeInfoService.findAllByIdIn(storeIds);
            Map<Long, StoreInfoDTO> storeMap = storeInfoDTOS.stream().collect(Collectors.toMap(StoreInfoDTO::getId, e -> e));
            result.stream().forEach(e -> {
                e.setStoreInfoDTO(storeMap.get(e.getStoreId()));
            });
        }
        return R.ok(result);
    }

    @GetMapping("/find-list-goods-by-condition-by-c")
    @ApiOperation("C端--根据分类获取商品信息,(特殊说明，由于该接口相对特殊，所有排序方式需要单独传，见参数说明)")
    public R<List<GoodsDTO>> getAllGoodsListByConditionByC(Pageable pageable,
                                                           @ApiParam("一级商品品类id") @RequestParam(required = false) Long oneCategoryId,
                                                           @ApiParam("二级商品品类id") @RequestParam(required = false) Long twoCategoryId,
                                                           @ApiParam("三商品品类id") @RequestParam(required = false) Long thirdCategoryId,
                                                           @ApiParam("排序字段 1 综合 2 销量 3 新品 4 价格") @RequestParam(required = false) Integer sortType,
                                                           @ApiParam("排序方式 1 正序 2 倒序") @RequestParam(required = false) Integer order,
                                                           @ApiParam("最小价格") @RequestParam(required = false) BigDecimal minPrice,
                                                           @ApiParam("最大价格") @RequestParam(required = false) BigDecimal maxPrice


    ) {
        log.debug("REST request to get a page of Goods");
        if (oneCategoryId == null && thirdCategoryId != null) {
            oneCategoryId = thirdCategoryId;
        }
        if (twoCategoryId == null && thirdCategoryId != null) {
            twoCategoryId = thirdCategoryId;
        }
        Page<GoodsDTO> page = goodsService.getAllGoodsByConditionByC(pageable, oneCategoryId, twoCategoryId, thirdCategoryId, minPrice, maxPrice, sortType, order);
        if (!CollectionUtils.isEmpty(page.getContent())) {
            List<Long> categoryIds = page.getContent().stream().filter(e -> e.getCategoryId() != null).map(GoodsDTO::getCategoryId).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(categoryIds)) {
                Map<Long, GoodsCategoryDTO> parentInfoMap = goodsCategoryService.findAllByInInWithParentInfo(categoryIds);
                page.getContent().stream().filter(e -> e.getCategoryId() != null).forEach(e -> {
                    e.setGoodsCategoryDTO(parentInfoMap.get(e.getCategoryId()));
                });
            }

            List<Long> goodsIds = page.getContent().stream().map(GoodsDTO::getId).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(goodsIds)) {
//                Map<Long, List<GoodsSkuDTO>> skuMap = goodsSkuService.findAllByIdGoodsInGroupById(goodsIds);
//                page.getContent().stream().forEach(e -> {
//                    e.setGoodsSkuDTOS(skuMap.get(e.getId()));
//                });

                Map<Long, List<GoodsPropertyDTO>> propertyMap = goodsPropertyService.findAllByIdGoodsInGroupById(goodsIds);
                page.getContent().stream().forEach(e -> {
                    e.setGoodsPropertyDTOS(propertyMap.get(e.getId()));
                });
            }
            List<Long> storeIds = page.getContent().stream().map(GoodsDTO::getStoreId).distinct().collect(Collectors.toList());
            Map<Long, StoreInfoDTO> storeMap = new HashMap<>();
            if (!CollectionUtils.isEmpty(storeIds)) {
                List<StoreInfoDTO> storeList = storeInfoService.findAllByIdIn(storeIds);
                storeMap = storeList.stream().collect(Collectors.toMap(StoreInfoDTO::getId, e -> e));
            }
            Map<Long, StoreInfoDTO> finalStoreMap = storeMap;
            page.getContent().stream().forEach(e -> {
                e.setStoreInfoDTO(finalStoreMap.get(e.getStoreId()));
            });
        }
        return R.ok(page.getContent(), page.getTotalElements());
    }

}
