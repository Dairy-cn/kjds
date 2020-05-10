package com.cross.interfaces.log;

import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.cross.model.IslandUserDTO;
import com.cross.model.island.IslandOperatingRecordDTO;
import com.cross.utils.CommonUtil;
import com.cross.utils.Date2Util;
import com.cross.utils.IpUtil;
import com.cross.utils.SnowflakeKeyGeneratorUtil;
import com.cross.interfaces.rocketMqUtil.ProducerSortUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.rocketmq.client.exception.MQClientException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 系统日志切点类
 *
 * @author dair
 */
@Aspect
@Component
public class SystemLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);
    
    private static final ThreadLocal<LocalDateTime> beginTimeThreadLocal =
        new NamedThreadLocal<LocalDateTime>("ThreadLocal beginTime");
    private static final ThreadLocal<IslandOperatingRecordDTO> logThreadLocal =
        new NamedThreadLocal<IslandOperatingRecordDTO>("ThreadLocal log");
    
    private static final ThreadLocal<IslandUserDTO> currentUser = new NamedThreadLocal<>("ThreadLocal user");
    
    @Autowired(required = false)
    private HttpServletRequest request;
    
    
    @Autowired
    private ProducerSortUtil producerSortUtil;
    
    ThreadFactory threadFactory = new ThreadFactoryBuilder()
        .setNameFormat("log-pool-%d")
        .build();
    /**
     * 参数含义：
     * corePoolSize : 线程池中常驻的线程数量。核心线程数，默认情况下核心线程会一直存活，即使处于闲置状态也不会受存keepAliveTime限制。除非将allowCoreThreadTimeOut设置为true。
     * maximumPoolSize : 线程池所能容纳的最大线程数。超过这个数的线程将被阻塞。当任务队列为没有设置大小的LinkedBlockingDeque时，这个值无效。
     * keepAliveTime : 当线程数量多于 corePoolSize 时，空闲线程的存活时长，超过这个时间就会被回收
     * unit : keepAliveTime 的时间单位
     * workQueue : 存放待处理任务的队列，该队列只接收 Runnable 接口
     * threadFactory : 线程创建工厂
     * handler : 当线程池中的资源已经全部耗尽，添加新线程被拒绝时，会调用RejectedExecutionHandler的rejectedExecution方法，参考 ThreadPoolExecutor 类中的内部策略类
     */
    private final ThreadPoolExecutor executorService = new ThreadPoolExecutor(8, Integer.MAX_VALUE, 0L,
        TimeUnit.MILLISECONDS,
        new LinkedBlockingQueue<>(1024),
        threadFactory,
        new ThreadPoolExecutor.DiscardOldestPolicy());
    
    
    /**
     * Controller层切点 注解拦截
     */
    @Pointcut("@annotation(com.cross.interfaces.log.SystemControllerLog)")
    public void controllerAspect() {
    }
    
    /**
     * 方法规则拦截
     */
    @Pointcut("execution(* com.cross.*.web.rest.*.*(..))")
    public void controllerPointerCut() {
    }
    
    /**
     * 前置通知 用于拦截Controller层记录用户的操作的开始时间
     *
     * @param joinPoint 切点
     * @throws InterruptedException
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) throws InterruptedException {
        LocalDateTime beginTime = LocalDateTime.now();
        beginTimeThreadLocal.set(beginTime);
        Long platformId = null;
        Long userId = null;
        try {
            platformId = CommonUtil.getCurrentLoginUser().getPlatformId();
            userId = CommonUtil.getCurrentLoginUser().getId();
        } catch (Exception e) {
            
        }
        IslandUserDTO islandUserDTO = null;
        if (userId != null) {
            //读取session中的用户
            islandUserDTO = new IslandUserDTO();
            islandUserDTO.setWeappUserId(userId);
            islandUserDTO.setPlatformId(platformId);
        }
        
        currentUser.set(islandUserDTO);
    }
    
    /**
     * 后置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     */
    @SuppressWarnings("unchecked")
    @After("controllerAspect()")
    public void doAfter(JoinPoint joinPoint) {
        IslandUserDTO user = currentUser.get();
        if (user == null) {
            return;
        }
        
        String title = "";
        //日志类型(info:入库,error:错误)
        String type = "info";
        //请求的IP
        String remoteAddr = IpUtil.getIpAdrress(request);
        //请求的Uri
        String requestUri = request.getRequestURI();
        //请求的方法类型(post/get)
        String method = request.getMethod();
        //请求提交的参数
        Map<String, String[]> params = request.getParameterMap();
        
        //获取requestBody 参数信息,过滤掉 ServletRequest 和 ServletResponse 类型的参数
        List<Object> object = Arrays.stream(joinPoint.getArgs()).filter(t -> !(t instanceof ServletRequest) && !(t instanceof ServletResponse)).collect(Collectors.toList());
        String requestBody = "";
        if (!CollectionUtils.isEmpty(object)) {
            requestBody= JSONObject.toJSONString(object.get(0));
        }
        
        try {
            title = getControllerMethodDescription2(joinPoint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // debu模式下打印JVM信息。
        //得到线程绑定的局部变量（开始时间）
        LocalDateTime beginTime = beginTimeThreadLocal.get();
        //2、结束时间
        LocalDateTime endTime = LocalDateTime.now();
        IslandOperatingRecordDTO log = new IslandOperatingRecordDTO();
        SnowflakeKeyGeneratorUtil snowflakeKeyGeneratorUtil = new SnowflakeKeyGeneratorUtil();
        log.setId(snowflakeKeyGeneratorUtil.generateKey());
        log.setTitle(title);
        log.setOperateName(title);
        log.setType(type);
        log.setRemoteAddr(remoteAddr);
        log.setRequestUri(requestUri);
        log.setMethod(method);
        log.setMapToParams(params);
        log.setParams(log.getParams() + "--" + requestBody);
        log.setPlatformId(user.getPlatformId());
        log.setDetail(log.getTitle() + "--" + log.getParams());
        log.setResult(1);
        log.setDelete(false);
        log.setOperatorId(user.getWeappUserId());
        LocalDateTime operateDate = beginTimeThreadLocal.get();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localTime = df.format(operateDate);
        log.setOperateTime(localTime);
        log.setTimeout(Date2Util.formatDateTime(endTime, beginTime));
        
        
        executorService.execute(new SaveLogThread(log, producerSortUtil));
        logThreadLocal.set(log);
        
        
    }
    
    /**
     * 异常通知
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "controllerAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        IslandOperatingRecordDTO log = logThreadLocal.get();
        if (log != null) {
            log.setType("error");
            log.setResult(0);
            log.setException(e.toString() + "---" + e.getMessage());
            new UpdateLogThread(log, producerSortUtil).start();
        }
    }
    
    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     */
    public static String getControllerMethodDescription2(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SystemControllerLog controllerLog = method
            .getAnnotation(SystemControllerLog.class);
        String discription = controllerLog.description();
        return discription;
    }
    
    /**
     * 保存日志线程
     *
     * @author dr
     */
    private static class SaveLogThread implements Runnable {
        private IslandOperatingRecordDTO log;
        private ProducerSortUtil producerSortUtil;
        
        public SaveLogThread(IslandOperatingRecordDTO log, ProducerSortUtil producerSortUtil) {
            this.log = log;
            this.producerSortUtil = producerSortUtil;
        }
        
        @Override
        public void run() {
            try {
                producerSortUtil.dealMessage(log);
            } catch (MQClientException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * 日志更新线程
     *
     * @author dr
     */
    private static class UpdateLogThread extends Thread {
        private IslandOperatingRecordDTO log;
        private ProducerSortUtil producerSortUtil;
        
        public UpdateLogThread(IslandOperatingRecordDTO log, ProducerSortUtil producerSortUtil) {
            super(UpdateLogThread.class.getSimpleName());
            this.log = log;
            this.producerSortUtil = producerSortUtil;
        }
        
        @Override
        public void run() {
            try {
                this.producerSortUtil.dealMessage(log);
            } catch (MQClientException e) {
                e.printStackTrace();
            }
        }
    }
    
    
}
