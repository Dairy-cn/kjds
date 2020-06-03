package com.cross.interfaces;

import java.lang.annotation.*;

/*************************************************************
 * Description:  是否是自己
 * Author: Dairy
 * CreateTime: 2019/12/11
 ************************************************************/

@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsSelf {

}
