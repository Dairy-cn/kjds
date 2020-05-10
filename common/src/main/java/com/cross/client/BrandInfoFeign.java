package com.cross.client;

import com.cross.config.AuthorizedFeignClient;
import com.cross.model.BrandDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用于在模块间查询品牌相关信息
 *
 * @author yk
 * @since 2019/4/23$ 9:34$
 */
@Component
@AuthorizedFeignClient(name = "merchant")
public interface BrandInfoFeign {


    /**
     * 根据品牌标识获取品牌信息
     *
     * @param id 品牌标识
     * @return 品牌信息
     */
    @GetMapping("/api/brands/{id}")
    BrandDTO getBrand(@PathVariable(name = "id") Long id);

}
