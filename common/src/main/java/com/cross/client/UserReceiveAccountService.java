package com.cross.client;

import com.cross.config.FeignMultipartSupportConfig;
import com.cross.config.AuthorizedFeignClient;
import com.cross.model.UserReceiveAccountModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by DuYuLiang on 2017/7/3.
 */
@AuthorizedFeignClient(name = "user", configuration = FeignMultipartSupportConfig.class)
public interface UserReceiveAccountService {
    /**
     * 获取用户收款账户信息
     *
     * @param userId
     * @return
     */
    @GetMapping("api/userReceiveAccountsByUserId/{userId}")
    UserReceiveAccountModel getUserReceiveAccountByUserId(@PathVariable("userId") Long userId);
}
