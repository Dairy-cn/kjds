package com.cross.client;

/**
 * Created by DuYuLiang on 2017/7/14.
 */

import com.cross.config.AuthorizedFeignClient;
import com.cross.model.OssModel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@AuthorizedFeignClient(name = "user")
public interface OssAuthenticationService {
    @GetMapping("/api/osses/generateQrCode/{appId}/{userId}")
    OssModel generateQrCode(@PathVariable("appId") Integer appId, @RequestParam("qrContent") String qrContent, @PathVariable("userId") Long userId);
}
