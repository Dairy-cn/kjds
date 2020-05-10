package com.cross.client;

import com.cross.config.AuthorizedFeignClient;
import com.cross.model.MerchantModel;
import com.cross.model.ws.ActivityDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author DuYuLiang on 2018/8/30.
 */
@Component
@AuthorizedFeignClient(name = "oa")
public interface OaService {
    @PostMapping("api/send/public-ws")
    MerchantModel sendPublicWebSocketMessage(@RequestBody ActivityDTO activityDTO);

    @PostMapping("api/send/ws")
    MerchantModel sendWebSocketMessage(@RequestBody ActivityDTO activityDTO);
}
