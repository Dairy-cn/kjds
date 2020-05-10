package com.cross.interfaces;

/**
 * 枚举序列化统一实现接口
 */
public interface BaseEnum<E extends Enum<?>,T> {

    //获取code方法
    T getCode();

    //获取msg
    String getMsg();

    //获取名称
    String getName();
}
