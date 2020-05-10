package com.cross.client;

import com.cross.config.AuthorizedFeignClient;
import com.cross.model.ThirdAppDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author DuYuLiang on 2018/12/17.
 */
@Component
@AuthorizedFeignClient(name = "gateway")
public interface GatewayService {
    @GetMapping("api/third-apps-by-app-id/{appId}")
    ThirdAppDTO getThirdAppDTOById(@PathVariable("appId") String appId);
}
