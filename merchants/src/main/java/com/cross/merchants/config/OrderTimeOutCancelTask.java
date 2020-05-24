package com.cross.merchants.config;

import com.cross.merchants.service.PayOrderService;
import com.cross.merchants.web.rest.StoreRecommendResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/*************************************************************
 * Description:
 * Author: Dairy
 * CreateTime: 2020/5/24
 ************************************************************/
@Component
public class OrderTimeOutCancelTask {

    private final Logger log = LoggerFactory.getLogger(StoreRecommendResource.class);

    @Autowired
    private PayOrderService portalOrderService;

    /**
     * cron表达式：Seconds Minutes Hours DayofMonth Month DayofWeek [Year]
     * 每10分钟扫描一次，扫描设定超时时间之前下的订单，如果没支付则取消该订单
     */
    @Scheduled(cron = "0 0/10 * ? * ?")
    private void cancelTimeOutOrder(){
        Integer count = portalOrderService.cancelTimeOutOrder();
        log.info("取消订单，并根据sku编号释放锁定库存，取消订单数量：{}",count);
    }
}
