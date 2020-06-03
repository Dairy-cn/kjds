package com.cross.merchants.web.rest;

import com.cross.merchants.service.UserFollowService;
import com.cross.merchants.service.dto.BrandDTO;
import com.cross.merchants.service.dto.GoodsDTO;
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
@Api(tags = "用戶品牌关注品牌接口")
public class UserFollowResource {
    private final Logger log = LoggerFactory.getLogger(UserFollowResource.class);


    @Autowired
    private UserFollowService userFollowService;


    @PostMapping("/add/{brandId}")
    @ApiOperation("C端---添加收藏品牌")
    public R addBrandFollow(@PathVariable Long brandId) {
        Long id = CommonUtil.getCurrentLoginUser().getId();
        userFollowService.addBrandFollow(id, brandId);
        return R.ok();
    }

    @DeleteMapping("/delete/{brandId}")
    @ApiOperation("C端---刪除收藏品牌")
    public R deleteBrandFollow(@PathVariable Long brandId) {
        Long id = CommonUtil.getCurrentLoginUser().getId();
        userFollowService.deleteBrandFollow(id, brandId);
        return R.ok();
    }

    @GetMapping("/get")
    @ApiOperation("C端---获取收藏品牌")
    public R<List<BrandDTO>> getList(Pageable pageable) {
        Long id = CommonUtil.getCurrentLoginUser().getId();

        List<BrandDTO> list = userFollowService.getList(id, pageable);
        long count= userFollowService.countByUserId(id);
        return R.ok(list,count);
    }

    @GetMapping("/is-follow-brand/{id}")
    @ApiOperation("C端---获取当前用户是否关注该品牌")
    public R<Boolean> isFollowBrand(@PathVariable Long id) {
        Long userId = CommonUtil.getCurrentLoginUser().getId();
        boolean flag = userFollowService.isFollowBrand(userId, id);
        return R.ok(flag);
    }
}
