package com.cross.merchants.web.rest;

import com.cross.merchants.service.ShippingListService;
import com.cross.merchants.service.StoreCommonShippingListService;
import com.cross.merchants.service.dto.ShippingListDTO;
import com.cross.merchants.service.dto.StoreCommonShippingListDTO;
import com.cross.merchants.web.rest.errors.BadRequestAlertException;
import com.cross.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for managing {@link com.cross.merchants.domain.StoreCommonShippingList}.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "物流配置---商户常用快递公司相关接口")
public class StoreCommonShippingListResource {

    private final Logger log = LoggerFactory.getLogger(StoreCommonShippingListResource.class);

    private static final String ENTITY_NAME = "merchantsStoreCommonShippingList";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final StoreCommonShippingListService storeCommonShippingListService;

    @Autowired
    private ShippingListService shippingListService;

    public StoreCommonShippingListResource(StoreCommonShippingListService storeCommonShippingListService) {
        this.storeCommonShippingListService = storeCommonShippingListService;
    }

    /**
     * {@code POST  /store-common-shipping-lists} : Create a new storeCommonShippingList.
     *
     * @param storeCommonShippingListDTO the storeCommonShippingListDTO to create.
     * @return the {@link R} with status {@code 201 (Created)} and with body the new storeCommonShippingListDTO, or with status {@code 400 (Bad Request)} if the storeCommonShippingList has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/store-common-shipping-lists")
    @ApiOperation("商户端---添加常用的快递公司")
    public R<StoreCommonShippingListDTO> createStoreCommonShippingList(@RequestBody StoreCommonShippingListDTO storeCommonShippingListDTO) throws URISyntaxException {
        log.debug("REST request to save StoreCommonShippingList : {}", storeCommonShippingListDTO);
        if (storeCommonShippingListDTO.getId() != null) {
            throw new BadRequestAlertException("A new storeCommonShippingList cannot already have an ID", ENTITY_NAME, "idexists");
        }
        StoreCommonShippingListDTO result = storeCommonShippingListService.save(storeCommonShippingListDTO);
        return R.ok(result);
    }

    @PostMapping("/store-common-shipping-lists-batch-add/{storeId}")
    @ApiOperation("商户端---批量添加常用的快递公司")
    public R<List<StoreCommonShippingListDTO>> createStoreCommonShippingListAdd(@ApiParam("商户Id") @PathVariable Long storeId, @RequestParam List<Long> shippingId) throws URISyntaxException {

        List<StoreCommonShippingListDTO> shippingListDTOS = storeCommonShippingListService.batchSave(storeId, shippingId);
        return R.ok(shippingListDTOS);
    }

    /**
     * {@code PUT  /store-common-shipping-lists} : Updates an existing storeCommonShippingList.
     *
     * @param storeCommonShippingListDTO the storeCommonShippingListDTO to update.
     * @return the {@link R} with status {@code 200 (OK)} and with body the updated storeCommonShippingListDTO,
     * or with status {@code 400 (Bad Request)} if the storeCommonShippingListDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the storeCommonShippingListDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/store-common-shipping-lists")
    @ApiOperation("商户端---更新常用的快递公司")
    public R<StoreCommonShippingListDTO> updateStoreCommonShippingList(@RequestBody StoreCommonShippingListDTO storeCommonShippingListDTO) throws URISyntaxException {
        log.debug("REST request to update StoreCommonShippingList : {}", storeCommonShippingListDTO);
        if (storeCommonShippingListDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        StoreCommonShippingListDTO result = storeCommonShippingListService.save(storeCommonShippingListDTO);
        return R.ok(result);
    }

    /**
     * {@code GET  /store-common-shipping-lists} : get all the storeCommonShippingLists.
     *
     * @param pageable the pagination information.
     * @return the {@link R} with status {@code 200 (OK)} and the list of storeCommonShippingLists in body.
     */

    /**
     * {@code GET  /store-common-shipping-lists/:id} : get the "id" storeCommonShippingList.
     *
     * @param id the id of the storeCommonShippingListDTO to retrieve.
     * @return the {@link R} with status {@code 200 (OK)} and with body the storeCommonShippingListDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/store-common-shipping-lists/{id}")
    @ApiOperation("商户端---根据id获取记录信息")
    public R<StoreCommonShippingListDTO> getStoreCommonShippingList(@PathVariable Long id) {
        log.debug("REST request to get StoreCommonShippingList : {}", id);
        Optional<StoreCommonShippingListDTO> storeCommonShippingListDTO = storeCommonShippingListService.findOne(id);
        return R.ok(storeCommonShippingListDTO.get());
    }

    /**
     * {@code DELETE  /store-common-shipping-lists/:id} : delete the "id" storeCommonShippingList.
     *
     * @param id the id of the storeCommonShippingListDTO to delete.
     * @return the {@link R} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/store-common-shipping-lists/{id}")
    @ApiOperation("商户端---根据id删除记录")
    public R deleteStoreCommonShippingList(@PathVariable Long id) {
        log.debug("REST request to delete StoreCommonShippingList : {}", id);
        storeCommonShippingListService.delete(id);
        return R.ok();
    }


    @GetMapping("/get-list-store-common-shipping-lists/{storeId}")
    @ApiOperation("商户端---根据商户id获取常用快递公司列表，如果没有 则去快递公司列表中查询")
    public R<List<StoreCommonShippingListDTO>> getStoreCommonShippingAllList(@PathVariable Long storeId) {
        List<StoreCommonShippingListDTO> list = storeCommonShippingListService.getStoreCommonShippingAllList(storeId);
        if (!CollectionUtils.isEmpty(list)) {
            Map<Long, ShippingListDTO> listDTOMap = new HashMap<>();
            List<Long> shippingIds = list.stream().map(StoreCommonShippingListDTO::getShippingId).distinct().collect(Collectors.toList());
            List<ShippingListDTO> shippingListDTOList = shippingListService.findAllByIdIn(shippingIds);
            listDTOMap = shippingListDTOList.stream().collect(Collectors.toMap(ShippingListDTO::getId, e -> e));
            Map<Long, ShippingListDTO> finalListDTOMap = listDTOMap;
            list.stream().forEach(e -> {
                ShippingListDTO shippingListDTO = finalListDTOMap.get(e.getShippingId());
                if (shippingListDTO != null) {
                    e.setName(shippingListDTO.getName());
                }
            });
        }
        return R.ok(list);
    }
}
