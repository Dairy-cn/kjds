package com.cross.client;

import com.cross.config.AuthorizedFeignClient;
import com.cross.model.RegionModel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Administrator on 2018/4/17.
 */
@Component
@AuthorizedFeignClient(name = "region")
public interface RegionService {
    @GetMapping("api/findOneByRegionId/{region_id}")
    RegionModel findOneByRegionId(@PathVariable("region_id") String region_id);
}
