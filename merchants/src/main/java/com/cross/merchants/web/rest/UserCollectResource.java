package com.cross.merchants.web.rest;

import com.cross.merchants.service.UserCollectService;
import com.cross.merchants.service.dto.GoodsDTO;
import com.cross.merchants.service.dto.UserAddressDTO;
import com.cross.utils.CommonUtil;
import com.cross.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

/*************************************************************
 * Description:
 * Author: Dair
 * CreateTime: 2020/5/25
 ************************************************************/
@RestController
@RequestMapping("/api/collect")
@Api(tags = "用戶收藏商品接口")
public class UserCollectResource {
    private final Logger log = LoggerFactory.getLogger(UserCollectResource.class);


    @Autowired
    private UserCollectService userCollectService;


    @PostMapping("/add/{goodsId}")
    @ApiOperation("C端---添加收藏商品")
    public R addCollect(@PathVariable Long goodsId) {
        Long id = CommonUtil.getCurrentLoginUser().getId();
        userCollectService.addCollect(id, goodsId);
        return R.ok();
    }

    @DeleteMapping("/delete/{goodsId}")
    @ApiOperation("C端---刪除收藏商品")
    public R deleteCollect(@PathVariable Long goodsId) {
        Long id = CommonUtil.getCurrentLoginUser().getId();
        userCollectService.deleteCollect(id, goodsId);
        return R.ok();
    }

    @GetMapping("/get")
    @ApiOperation("C端---获取收藏商品列表")
    public R<List<GoodsDTO>> getList(Pageable pageable) {
        Long id = CommonUtil.getCurrentLoginUser().getId();

        List<GoodsDTO> list = userCollectService.getList(id, pageable);
        long count = userCollectService.countByUserId(id);
        return R.ok(list, count);
    }

    @GetMapping("/is-collect-goods/{id}")
    @ApiOperation("C端---获取当前用户是否收藏该商品")
    public R<Boolean> isCollectGoods(@PathVariable Long id) {
        Long userId = CommonUtil.getCurrentLoginUser().getId();
        boolean flag = userCollectService.isCollectGoods(userId, id);
        return R.ok(flag);
    }

}
