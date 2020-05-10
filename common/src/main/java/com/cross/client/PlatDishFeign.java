package com.cross.client;

import com.cross.config.AuthorizedFeignClient;
import com.cross.model.PlatDishDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 查询商品信息接口
 *
 * @author yk
 * @since 2019/5/8$ 11:32$
 */
@Component
@AuthorizedFeignClient(name = "platform")
public interface PlatDishFeign {

    /**
     * 查询商品详情
     *
     * @param platformId 平台id
     * @param goodsId    商品id
     * @return 商品详情
     */
    @GetMapping("/api/get-special-offer-platform-dish-info")
    PlatDishDTO findOne(@RequestParam("platformId") Long platformId, @RequestParam("dishId") Long goodsId);

}
