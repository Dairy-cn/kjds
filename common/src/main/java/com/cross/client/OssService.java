package com.cross.client;

import com.cross.config.AuthorizedFeignClient;
import com.cross.model.OssModel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by DuYuLiang on 2017/6/23.
 */
@Component
@AuthorizedFeignClient(name = "merchant") //, configuration = FeignMultipartSupportConfig.class
public interface OssService {
    @PostMapping("/api/osses/upload/{appId}/{userId}")
    String uploadFile(
        @RequestPart("file") MultipartFile file,
        @PathVariable("appId") String appId,
        @PathVariable("userId") Long userId);

    @PostMapping("/api/osses/upload-bytes/{appId}/{userId}")
    String uploadOssByBytes(@RequestParam("bytes") byte[] bytes,
                            @RequestParam("remoteFileName") String remoteFileName,
                            @PathVariable("appId") String appId,
                            @PathVariable("userId") Long userId,
                            @RequestParam("addIp") String addIp);

    @GetMapping("/api/osses/generateQrCode/{appId}/{userId}")
    OssModel generateQrCode(
        @PathVariable("appId") Integer appId,
        @RequestParam("qrContent") String qrContent,
        @PathVariable("userId") Long userId
    );

    @PostMapping("/api/osses/operate")
    String uploadOssByOperate(@RequestParam("result") Boolean result, @RequestParam("appId") Integer appId, @RequestParam("extName") String extName,
                            @RequestParam("fileSize") Long fileSize, @RequestParam("remoteFileName") String remoteFileName,
                            @RequestParam("newOssName") String newOssName, @RequestParam("userId") Long userId, @RequestParam("ip") String ip);
}
