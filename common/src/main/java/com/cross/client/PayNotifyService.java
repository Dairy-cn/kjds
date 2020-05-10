package com.cross.client;

import com.cross.config.AuthorizedFeignClient;

/**
 * Created by DuYuLiang on 2017/7/10.
 */
@AuthorizedFeignClient(name = "transcation")
public interface PayNotifyService {

}
