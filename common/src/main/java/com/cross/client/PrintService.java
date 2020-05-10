package com.cross.client;

import com.cross.config.AuthorizedFeignClient;
import com.cross.model.PrintModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author DuYuLiang on 2017/11/10.
 */
@AuthorizedFeignClient(name = "print")
public interface PrintService {
    @PostMapping("api/print")
    ResponseEntity print(@RequestBody PrintModel printModel);
}
