package com.cross.merchants.web.rest;

import com.cross.merchants.service.GoodsCategoryService;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;
import com.cross.merchants.service.dto.GoodsCategoryDTO;

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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * REST controller for managing {@link com.cross.merchants.domain.GoodsCategory}.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "商品分类相关接口")
public class GoodsCategoryResource {

    private final Logger log = LoggerFactory.getLogger(GoodsCategoryResource.class);

    private static final String ENTITY_NAME = "merchantsGoodsCategory";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final GoodsCategoryService goodsCategoryService;

    public GoodsCategoryResource(GoodsCategoryService goodsCategoryService) {
        this.goodsCategoryService = goodsCategoryService;
    }

    /**
     * {@code POST  /goods-categories} : Create a new goodsCategory.
     *
     * @param goodsCategoryDTO the goodsCategoryDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new goodsCategoryDTO, or with status {@code 400 (Bad Request)} if the goodsCategory has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/goods-categories")
    @ApiOperation("创建商品品类分类")
    public R createGoodsCategory(@RequestBody GoodsCategoryDTO goodsCategoryDTO) throws URISyntaxException {
        log.debug("REST request to save GoodsCategory : {}", goodsCategoryDTO);
        if (goodsCategoryDTO.getId() != null) {
            throw new BadRequestAlertException("A new goodsCategory cannot already have an ID", ENTITY_NAME, "idexists");
        }
        GoodsCategoryDTO result = goodsCategoryService.save(goodsCategoryDTO);
        return R.ok(result);
    }

    /**
     * {@code PUT  /goods-categories} : Updates an existing goodsCategory.
     *
     * @param goodsCategoryDTO the goodsCategoryDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated goodsCategoryDTO,
     * or with status {@code 400 (Bad Request)} if the goodsCategoryDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the goodsCategoryDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/goods-categories")
    @ApiOperation("修改商品品类分类")
    public R updateGoodsCategory(@RequestBody GoodsCategoryDTO goodsCategoryDTO) throws URISyntaxException {
        log.debug("REST request to update GoodsCategory : {}", goodsCategoryDTO);
        if (goodsCategoryDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        GoodsCategoryDTO result = goodsCategoryService.save(goodsCategoryDTO);
        return R.ok(result);
    }

    /**
     * {@code GET  /goods-categories} : get all the goodsCategories.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of goodsCategories in body.
     */
    @GetMapping("/goods-categories")
    @ApiOperation("大后台--获取商品分类列表")
    public R getAllGoodsCategories() {
        List<GoodsCategoryDTO> list = goodsCategoryService.findAllByLevel(1);
        if (!CollectionUtils.isEmpty(list)) {
            Map<Long, List<GoodsCategoryDTO>> childMap = new HashMap<>();
            List<Long> ids = list.stream().map(GoodsCategoryDTO::getId).collect(Collectors.toList());
            List<GoodsCategoryDTO> listChild = goodsCategoryService.findAllByPidIn(ids);
            childMap = listChild.stream().collect(Collectors.groupingBy(GoodsCategoryDTO::getPid));
            Map<Long, List<GoodsCategoryDTO>> finalChildMap = childMap;
            list.stream().forEach(e -> {
                List<GoodsCategoryDTO> categoryDTOList = finalChildMap.get(e.getId());
                Map<Long, List<GoodsCategoryDTO>> grandChildMap = new HashMap<>();
                if (!CollectionUtils.isEmpty(categoryDTOList)) {
                    List<Long> childIds = categoryDTOList.stream().map(GoodsCategoryDTO::getId).collect(Collectors.toList());
                    List<GoodsCategoryDTO> grandCildcategory = goodsCategoryService.findAllByPidIn(childIds);
                    grandChildMap = grandCildcategory.stream().collect(Collectors.groupingBy(GoodsCategoryDTO::getPid));
                }
                Map<Long, List<GoodsCategoryDTO>> finalGrandChildMap = grandChildMap;
                categoryDTOList.stream().forEach(e2 -> {
                    e2.setChildNode(finalGrandChildMap.get(e2.getId()));
                });
                e.setChildNode(categoryDTOList);
            });
        }
        return R.ok(list);
    }

    /**
     * {@code GET  /goods-categories/:id} : get the "id" goodsCategory.
     *
     * @param id the id of the goodsCategoryDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the goodsCategoryDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/goods-categories/{id}")
    @ApiOperation("获取商品分类详情信息")
    public R getGoodsCategory(@PathVariable Long id) {
        log.debug("REST request to get GoodsCategory : {}", id);
        Optional<GoodsCategoryDTO> goodsCategoryDTO = goodsCategoryService.findOne(id);
        if (goodsCategoryDTO.isPresent()) {
            return R.ok(goodsCategoryDTO.get());
        } else {
            return R.error("找不到你要的数据");
        }
    }
    @GetMapping("/goods-categories-by-level/{level}")
    @ApiOperation("根据分类级别获取商品分类信息")
    public R getGoodsCategoryByLevel(@PathVariable Integer level) {
        log.debug("REST request to get GoodsCategory : {}", level);
        List<GoodsCategoryDTO> goodsCategoryDTO = goodsCategoryService.findAllByLevel(level);
        return R.ok(goodsCategoryDTO);
    }

    @GetMapping("/goods-categories-by-pid/{pid}")
    @ApiOperation("根据分id获取商品分类信息")
    public R getGoodsCategoryByPid(@PathVariable Long pid) {
        log.debug("REST request to get GoodsCategory : {}", pid);
        List<GoodsCategoryDTO> goodsCategoryDTO = goodsCategoryService.findAllByPid(pid);
        return R.ok(goodsCategoryDTO);
    }
    /**
     * {@code DELETE  /goods-categories/:id} : delete the "id" goodsCategory.
     *
     * @param id the id of the goodsCategoryDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/goods-categories/{id}")
    @ApiOperation("删除商品分类信息")
    public R deleteGoodsCategory(@PathVariable Long id) {
        log.debug("REST request to delete GoodsCategory : {}", id);
        //TODO 和商品数量关联删除
        goodsCategoryService.delete(id);
        return R.ok();
    }


    @PutMapping("/update-stick-status-goods-categories/{id}")
    @ApiOperation("置顶数据")
    public R stickGoodsCategory(@PathVariable Long id) {
        log.debug("REST request to stickGoodsCategory GoodsCategory : {}", id);
        goodsCategoryService.stickGoodsCategory(id);
        return R.ok();
    }
}
