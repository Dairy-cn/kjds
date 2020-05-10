package com.cross.interfaces;

import java.lang.annotation.*;

/*************************************************************
 * Description:  自定义注解 redis缓存
 * Author: Dairy
 * CreateTime: 2019/12/11
 * Copyright © 成都通吃岛信息技术有限公司 All right reserved
 ************************************************************/

@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisCache {

}
