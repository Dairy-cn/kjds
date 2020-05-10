package com.cross.client;

import com.cross.config.AuthorizedFeignClient;
import com.cross.model.dish.ShopDishProductCat;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author LY 2018-03-23
 */
@Component
@AuthorizedFeignClient(name = "shop")
public interface ShopDishService {

    @PostMapping("/api/shop-dish-product-cats/batch")
    void createShopDishProductCatBatch(List<ShopDishProductCat> shopDishProductCatList);
}
