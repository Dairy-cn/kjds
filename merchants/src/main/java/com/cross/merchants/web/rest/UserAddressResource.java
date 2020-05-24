package com.cross.merchants.web.rest;

import com.cross.merchants.service.UserAddressService;
import com.cross.merchants.service.dto.UserAddressDTO;
import com.cross.utils.CommonUtil;
import com.cross.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.Optional;

/**
 * REST controller for managing {@link com.cross.merchants.domain.UserAddress}.
 */
@RestController
@RequestMapping("/api")
@Api(tags = "用户收货地址相关接口")
public class UserAddressResource {

    private final Logger log = LoggerFactory.getLogger(UserAddressResource.class);

    private static final String ENTITY_NAME = "userAddress";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final UserAddressService userAddressService;

    public UserAddressResource(UserAddressService userAddressService) {
        this.userAddressService = userAddressService;
    }

    /**
     * {@code POST  /user-addresses} : Create a new userAddress.
     *
     * @param userAddressDTO the userAddressDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new userAddressDTO, or with status {@code 400 (Bad Request)} if the userAddress has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/user-addresses")
    @ApiOperation("C端---添加用户收货地址")
    public R createUserAddress(@Valid @RequestBody UserAddressDTO userAddressDTO) throws URISyntaxException {
        log.debug("REST request to save UserAddress : {}", userAddressDTO);
        if (userAddressDTO.getId() != null) {
            return R.error("idexists");
        }
        Long userId = CommonUtil.getCurrentLoginUser().getId();
        userAddressDTO.setUserId(userId);
        UserAddressDTO result = userAddressService.save(userAddressDTO);
        return R.ok(result);
    }

    /**
     * {@code PUT  /user-addresses} : Updates an existing userAddress.
     *
     * @param userAddressDTO the userAddressDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated userAddressDTO,
     * or with status {@code 400 (Bad Request)} if the userAddressDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the userAddressDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/user-addresses")
    public R updateUserAddress(@Valid @RequestBody UserAddressDTO userAddressDTO) throws URISyntaxException {
        log.debug("REST request to update UserAddress : {}", userAddressDTO);
        if (userAddressDTO.getId() == null) {
            return R.error("idnull");
        }
        UserAddressDTO result = userAddressService.save(userAddressDTO);
        return R.ok(result);
    }

    /**
     * {@code GET  /user-addresses} : get all the userAddresses.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of userAddresses in body.
     */
    @GetMapping("/user-addresses")
    @ApiOperation("C-获取自己的收货地址分页信息")
    public R getAllUserAddresses(Pageable pageable) {
        log.debug("REST request to get a page of UserAddresses");

        Page<UserAddressDTO> page = userAddressService.findAll(pageable, CommonUtil.getCurrentLoginUser().getId());
        return R.ok(page.getContent(), page.getTotalElements());
    }

    /**
     * {@code GET  /user-addresses/:id} : get the "id" userAddress.
     *
     * @param id the id of the userAddressDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the userAddressDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/user-addresses/{id}")
    @ApiOperation("根据记录id获取详情")
    public R getUserAddress(@PathVariable Long id) {
        log.debug("REST request to get UserAddress : {}", id);
        Optional<UserAddressDTO> userAddressDTO = userAddressService.findOne(id);
        if (userAddressDTO.get().getDeleteFlag()) {
            return R.ok();
        }
        return R.ok(userAddressDTO.get());
    }

    /**
     * {@code DELETE  /user-addresses/:id} : delete the "id" userAddress.
     *
     * @param id the id of the userAddressDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/user-addresses/{id}")
    @ApiOperation("根据记录id删除记录")
    public R deleteUserAddress(@PathVariable Long id) {
        log.debug("REST request to delete UserAddress : {}", id);
        Optional<UserAddressDTO> userAddressDTO = userAddressService.findOne(id);
        if (!userAddressDTO.isPresent()) {
            return R.errorData();
        }
        UserAddressDTO userAddressDTO1 = userAddressDTO.get();
        userAddressDTO1.setDeleteFlag(true);
        userAddressService.save(userAddressDTO1);
        return R.ok();
    }


    @PutMapping("/update-default-user-addresses/{id}")
    @ApiOperation("根据记录id设置为默认地址")
    public R updateDefaultUserAddress(@PathVariable Long id) {

        userAddressService.updateDefaultUserAddress(id);
        return R.ok();
    }
}
