package com.cross.interfaces;

import com.cross.config.Constants;
import com.cross.utils.CommonUtil;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/*************************************************************
 * Description: 切面缓存
 * Author: Dairy
 * CreateTime: 2019/12/11
 * Copyright © 成都通吃岛信息技术有限公司 All right reserved
 ************************************************************/
@Aspect
@Service
@Component
public class RedisCacheAop {
    
    private static final Logger logger = Logger.getLogger(RedisCacheAop.class);
    
    /**
     * redis 存活时长 分钟
     */
    private static final Integer TIME_OUT = 15;
    
    
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    /**
     * 专题名称
     */
    @Value("${spring.application.name}")
    private String applicationName;
    
    
    @Value("${spring.profiles.active}")
    public String prifilesActive;
    
    
    @Value("${redis.cache.status}")
    public int redisCaheStatus;
    
    /**
     * @return void
     * @Title: queryCachePointcut
     * @Description: 定义切点为缓存注解
     **/
    @Pointcut("@annotation(com.cross.interfaces.RedisCache)")
    public void queryCachePointcut() {
    }
    
    @Around("queryCachePointcut()")
    public Object Interceptor(ProceedingJoinPoint joinPoint) throws Throwable {
        if(redisCaheStatus==1){
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            //类路径名
            String classPathName = joinPoint.getTarget().getClass().getName();
            //类名
            String className = classPathName.substring(classPathName.lastIndexOf(".") + 1, classPathName.length());
            //获取方法名
            String methodName = signature.getMethod().getName();
            String[] strings = signature.getParameterNames();
            Method targetMethod = signature.getMethod();
    
            Method realMethod = joinPoint.getTarget().getClass().getDeclaredMethod(signature.getName(), targetMethod.getParameterTypes());

//        Class clazz = realMethod.getClass();
            //这里获取到所有的参数值的数组
            Object[] args = joinPoint.getArgs();
            String token = null;
            Long platformId = null;
            Long userId = null;
            try {
                platformId = CommonUtil.getCurrentLoginUser().getPlatformId();
                if(realMethod.isAnnotationPresent(IsSelf.class)){
                    userId = CommonUtil.getCurrentLoginUser().getId();
                }
            } catch (Exception e) {
                logger.info("get user auth info error" + e.getMessage());
            }
    
            String key = "";
            String header = prifilesActive + ":" + Constants.ISLAND_REDISCACHE_KEY + ":"+applicationName + ":" + className + ":";
            String keyHeader = ""+header;
    
            if (platformId != null) {
                keyHeader = keyHeader + "platform_" + platformId + ":";
            }
            if (userId != null && !userId.equals(-1)) {
                keyHeader = keyHeader + "userId_" + userId + ":";
            }
    
            key = keyHeader + methodName + ":" + Arrays.toString(strings) + ":" + Arrays.toString(args);

//        String keyValue=key+
            if ((methodName.indexOf("find") != -1 && methodName.substring(0, 4).equalsIgnoreCase("find")) || (methodName.indexOf("select") != -1 && methodName.substring(0, 6).equalsIgnoreCase("select")) || (methodName.indexOf("query") != -1 && methodName.substring(0, 5).equalsIgnoreCase("query")) || (methodName.indexOf("get") != -1 && methodName.substring(0, 3).equalsIgnoreCase("get"))) {
                LinkedHashMap<String, Object> data = getObject(joinPoint, key);
                if (data != null) {
                    LinkedHashMap<Object, Object> linkedHashMap = (LinkedHashMap<Object, Object>) data.get("headers");
                    HttpHeaders httpHeaders = new HttpHeaders();
                    ArrayList arrayList = (ArrayList) linkedHashMap.get("X-Total-Count");
                    if (!CollectionUtils.isEmpty(arrayList)) {
                        httpHeaders.add("X-Total-Count", arrayList.get(0).toString());
                    }
                    ArrayList linkList = (ArrayList) linkedHashMap.get("Link");
                    if (!CollectionUtils.isEmpty(linkList)) {
                        httpHeaders.add(HttpHeaders.LINK, linkList.get(0).toString());
                    }
                    Object statusCode = data.get("statusCode");
                    HttpStatus httpStatus = HttpStatus.valueOf((String) statusCode);
                    return new ResponseEntity(data.get("body"), httpHeaders, httpStatus);
                }
                return joinPoint.proceed();
            } else if ((methodName.indexOf("create") != -1 && methodName.substring(0, 6).equalsIgnoreCase("create")) || (methodName.indexOf("delete") != -1 && methodName.substring(0, 6).equalsIgnoreCase("delete")) || (methodName.indexOf("add") != -1 && methodName.substring(0, 3).equalsIgnoreCase("add")) || (methodName.indexOf("insert") != -1 && methodName.substring(0, 6).equalsIgnoreCase("insert")) || (methodName.indexOf("update") != -1 && methodName.substring(0, 6).equalsIgnoreCase("update"))) {
                try {
                    Set<String> keys = redisTemplate.keys(header + "*");
                    if (!keys.isEmpty()) {
                        //序列化为String
                            redisTemplate.delete(keys);
                        logger.info("执行方法 : [ " + methodName + " ] : 清除 key 包含 [ " + className + " ] 的缓存数据");
                    }
                } catch (Exception e) {
                    logger.error("redis cache clear error");
                }
        
            }
            // 调用原始方法
            return joinPoint.proceed();
        }
        // 调用原始方法
        return joinPoint.proceed();
       
    }
    
    /**
     * @param joinPoint : 切面对象
     * @param key       : 获取hazelcast数据的key值
     * @return java.lang.Object
     * @Title: getObject
     * @Description: 使用key获取数据 不存在则查询添加
     **/
    
    private LinkedHashMap<String, Object> getObject( ProceedingJoinPoint joinPoint, String key) throws Throwable {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        boolean hasKey = redisTemplate.hasKey(key);
        LinkedHashMap<String, Object> object = null;
        if (hasKey) {
            // 缓存中获取到数据，直接返回。
            object = (LinkedHashMap<String, Object>) operations.get(key);
            logger.info("redis--------缓存-----命中");
        }
        if (object == null) {
            // 缓存中没有数据，调用原始方法查询数据库
            Integer expiresTime = null;
            try {
                expiresTime = Integer.valueOf(redisTemplate.opsForValue().get(prifilesActive + ":" + Constants.REDIS_CACHE_EXPIRES_TIME_KEY).toString());
            } catch (Exception e) {
                logger.error("获取缓存超时时间失败");
            }
            if (expiresTime == null) {
                expiresTime = TIME_OUT;
            }
            ResponseEntity responseEntity = (ResponseEntity) joinPoint.proceed();
            operations.set(key, responseEntity, expiresTime, TimeUnit.MINUTES);
        }
        return object;
    }
    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        //序列化为Json
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        this.redisTemplate = redisTemplate;
    }


    
}
