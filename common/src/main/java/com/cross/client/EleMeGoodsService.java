package com.cross.client;

import com.cross.config.AuthorizedFeignClient;
import com.cross.model.EleMeGoodsDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author DuYuLiang on 2018/3/26.
 */
@Component
@AuthorizedFeignClient(name = "operation")
public interface EleMeGoodsService {
    @GetMapping("/pull-ele-me-goods-by-category/{merchantId}/{categoryId}")
    List<EleMeGoodsDTO> pullEleMeGoods(@PathVariable("merchantId") Long merchantId, @PathVariable("categoryId") Long categoryId);
}
