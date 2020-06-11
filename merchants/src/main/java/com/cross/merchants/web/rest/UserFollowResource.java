package com.cross.merchants.web.rest;

import com.cross.merchants.service.UserFollowService;
import com.cross.merchants.service.dto.BrandDTO;
import com.cross.merchants.service.dto.GoodsDTO;
import com.cross.merchants.service.dto.StoreInfoDTO;
import com.cross.utils.CommonUtil;
import com.cross.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*************************************************************
 * Description:
 * Author: Dair
 * CreateTime: 2020/5/25
 ************************************************************/
@RestController
@RequestMapping("/api/follow")
@Api(tags = "用戶店铺关注店铺接口")
public class UserFollowResource {
    private final Logger log = LoggerFactory.getLogger(UserFollowResource.class);


    @Autowired
    private UserFollowService userFollowService;


    @PostMapping("/add/{storeId}")
    @ApiOperation("C端---添加关注店铺")
    public R addBrandFollow(@PathVariable Long storeId) {
        Long id = CommonUtil.getCurrentLoginUser().getId();
        userFollowService.addBrandFollow(id, storeId);
        return R.ok();
    }

    @DeleteMapping("/delete/{storeId}")
    @ApiOperation("C端---刪除关注店铺")
    public R deleteBrandFollow(@PathVariable Long storeId) {
        Long id = CommonUtil.getCurrentLoginUser().getId();
        userFollowService.deleteBrandFollow(id, storeId);
        return R.ok();
    }

    @GetMapping("/get")
    @ApiOperation("C端---获取关注店铺")
    public R<List<StoreInfoDTO>> getList(Pageable pageable) {
        Long id = CommonUtil.getCurrentLoginUser().getId();

        List<StoreInfoDTO> list = userFollowService.getList(id, pageable);
        long count= userFollowService.countByUserId(id);
        return R.ok(list,count);
    }

    @GetMapping("/is-follow-store/{id}")
    @ApiOperation("C端---获取当前用户是否关注该店铺")
    public R<Boolean> isFollowBrand(@PathVariable Long id) {
        Long userId = CommonUtil.getCurrentLoginUser().getId();
        boolean flag = userFollowService.isFollowBrand(userId, id);
        return R.ok(flag);
    }
}
