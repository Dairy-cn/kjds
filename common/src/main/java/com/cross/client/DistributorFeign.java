package com.cross.client;

import com.cross.config.AuthorizedFeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 分销接口
 *
 * @author yk
 * @since 2019/4/25$ 16:26$
 */
@Component
@AuthorizedFeignClient(name = "merchant")
public interface DistributorFeign {

    /**
     * 计算订单的合伙人佣金
     *
     * @param orderId 订单id
     * @return 合伙人佣金
     */
    @GetMapping("/api/calculation/partner_commission/{orderId}")
    Double calculationPartnerCommissionByOrderId(@PathVariable(name = "orderId") Long orderId);

}
