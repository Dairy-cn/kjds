package com.cross.merchants.redis;


public interface KeyPrefix {
    /**
     * 有效期
     * @return
     */
    public int expireSeconds();

    /**
     * key前缀，防止其他的人使用redis时覆盖
     * @return
     */
    public String getPrefix();
}
