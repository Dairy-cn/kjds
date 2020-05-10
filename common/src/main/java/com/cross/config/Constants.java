package com.cross.config;

/**
 * Application constants.
 */
public final class Constants {
    
    //Regex for acceptable logins
    public static final String LOGIN_REGEX = "^[_'.@A-Za-z0-9-]*$";
    
    public static final String SYSTEM_ACCOUNT = "system";
    public static final String ANONYMOUS_USER = "anonymoususer";
    
    public static final Integer QUEUE_MESSAGE_TYPE_ORDER = 11;
    /**
     * 通吃岛平台id
     */
    public static final Long ISLANDPLATFORMID = 49L;
    
    /**
     * 设置缓存key
     */
    public static final String REDIS_CACHE_EXPIRES_TIME_KEY = "ISLAND:REDIS_CACHE_EXPIRES_TIME_KEY";
    
    
    /**
     * 设置缓存key
     */
    public static final String ISLAND_REDISCACHE_KEY = "RedisCache";
    
    
    
    private Constants() {
    }
}
