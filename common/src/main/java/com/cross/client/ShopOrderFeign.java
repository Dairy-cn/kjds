package com.cross.client;

import com.cross.config.AuthorizedFeignClient;
import com.cross.model.ShopOrderDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 订单查询
 *
 * @author yk
 * @since 2019/5/8$ 18:29$
 */
@Component
@AuthorizedFeignClient(name = "shop")
public interface ShopOrderFeign {

    @GetMapping("/api/order-info")
    ShopOrderDTO findOne(@RequestParam("orderSn") String orderSn);

}
