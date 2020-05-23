package com.cross.merchants.web.rest;

import com.cross.merchants.service.ArticleInfoService;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;
import com.cross.merchants.service.dto.ArticleInfoDTO;

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
 * REST controller for managing {@link com.cross.merchants.domain.ArticleInfo}.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "文章管理相关接口")
public class ArticleInfoResource {

    private final Logger log = LoggerFactory.getLogger(ArticleInfoResource.class);

    private static final String ENTITY_NAME = "merchantsArticleInfo";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ArticleInfoService articleInfoService;

    public ArticleInfoResource(ArticleInfoService articleInfoService) {
        this.articleInfoService = articleInfoService;
    }

    /**
     * {@code POST  /article-infos} : Create a new articleInfo.
     *
     * @param articleInfoDTO the articleInfoDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new articleInfoDTO, or with status {@code 400 (Bad Request)} if the articleInfo has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/article-infos")
    @ApiOperation("创建文章")
    public R createArticleInfo(@Valid @RequestBody ArticleInfoDTO articleInfoDTO) throws URISyntaxException {
        log.debug("REST request to save ArticleInfo : {}", articleInfoDTO);
        if (articleInfoDTO.getId() != null) {
            return R.error("idexists");
        }
        ArticleInfoDTO result = articleInfoService.save(articleInfoDTO);
        return R.ok(result);
    }

    /**
     * {@code PUT  /article-infos} : Updates an existing articleInfo.
     *
     * @param articleInfoDTO the articleInfoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated articleInfoDTO,
     * or with status {@code 400 (Bad Request)} if the articleInfoDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the articleInfoDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/article-infos")
    @ApiOperation("更新文章")
    public R updateArticleInfo(@Valid @RequestBody ArticleInfoDTO articleInfoDTO) throws URISyntaxException {
        log.debug("REST request to update ArticleInfo : {}", articleInfoDTO);
        if (articleInfoDTO.getId() == null) {
            return R.error("idnull");
        }
        ArticleInfoDTO result = articleInfoService.save(articleInfoDTO);
        return R.ok(result);
    }

    /**
     * {@code GET  /article-infos} : get all the articleInfos.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of articleInfos in body.
     */
    @GetMapping("/article-infos")
    @ApiOperation("根据条件获取文件分页列表")
    public R getAllArticleInfos(Pageable pageable, @ApiParam("关键字查询 文章编号") @RequestParam String keyWord,
                                @ApiParam("上架状态  不传为全部") @RequestParam Boolean showState) {
        log.debug("REST request to get a page of ArticleInfos");
        Page<ArticleInfoDTO> page = articleInfoService.findAllByCondition(pageable, keyWord, showState);
        return R.ok(page.getContent(), page.getTotalElements());
    }

    /**
     * {@code GET  /article-infos/:id} : get the "id" articleInfo.
     *
     * @param id the id of the articleInfoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the articleInfoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/article-infos/{id}")
    @ApiOperation("根据id获取文章详情")
    public R getArticleInfo(@PathVariable Long id) {
        log.debug("REST request to get ArticleInfo : {}", id);
        Optional<ArticleInfoDTO> articleInfoDTO = articleInfoService.findOne(id);
        if (!articleInfoDTO.isPresent()) {
            return R.errorData();
        }
        return R.ok(articleInfoDTO.get());

    }

    /**
     * {@code DELETE  /article-infos/:id} : delete the "id" articleInfo.
     *
     * @param id the id of the articleInfoDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/article-infos/{id}")
    @ApiOperation("根据id删除文章")
    public R deleteArticleInfo(@PathVariable Long id) {
        log.debug("REST request to delete ArticleInfo : {}", id);
        articleInfoService.delete(id);
        return R.ok();
    }

    @DeleteMapping("/top-article-infos/{id}")
    @ApiOperation("根据id置顶文章")
    public R topArticleInfo(@PathVariable Long id) {
        log.debug("REST request to delete ArticleInfo : {}", id);
        articleInfoService.topArticleInfo(id);
        return R.ok();
    }

    @DeleteMapping("/show-state-article-infos/{id}")
    @ApiOperation("根据id修改文章上架状态")
    public R updateShowStateArticleInfo(@ApiParam("文章id") @PathVariable Long id,
                                        @ApiParam("上下架状态 true 上架 false 下架") @RequestParam Boolean showState) {
        log.debug("REST request to delete ArticleInfo : {}", id);
        articleInfoService.updateShowState(id,showState);
        return R.ok();
    }
}
