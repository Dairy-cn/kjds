package com.cross.interfaces.rocketMqUtil;


import com.alibaba.fastjson.JSONObject;
import com.cross.model.island.IslandOperatingRecordDTO;
import io.github.jhipster.config.JHipsterConstants;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;


/*************************************************************
 * Description: mq
 * CreateTime: 2020/3/21
 ***********************************************************
 * @author drr*/

@Component
public class ProducerSortUtil {
    private final Logger loger = LoggerFactory.getLogger(ProducerSortUtil.class);
    
    @Value("${rocketMq.service}")
    private String URL;
    
    
    private volatile  static DefaultMQProducer producer;
    
    private static String  profiles="dev";
    
    @Autowired
    private Environment env;
    
    
    public ProducerSortUtil() {
    
    }
    
    private  DefaultMQProducer getInstance() throws MQClientException {
        if (producer == null) {
            synchronized (ProducerSortUtil.class) {
                if (producer == null) {
                    if(env.getActiveProfiles()!=null && env.getActiveProfiles().length>0){
                        Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
                        if(activeProfiles.contains(JHipsterConstants.SPRING_PROFILE_PRODUCTION)){
                            profiles="prod";
                            producer = new DefaultMQProducer("prod-group-logs");
                        }else if(activeProfiles.contains(JHipsterConstants.SPRING_PROFILE_TEST)){
                            producer = new DefaultMQProducer("test-group-logs");
                            profiles="test";
                        }else {
                            producer = new DefaultMQProducer("group-logs");
                        }
                    }else {
                        producer = new DefaultMQProducer("group-logs");
                    }
                    producer.setVipChannelEnabled(false);
                    producer.setNamesrvAddr(URL);
                    producer.start();
                  
                }
            }
        }
        return producer;
    }
    
    public void dealMessage(IslandOperatingRecordDTO log) throws MQClientException {
        getInstance();
        try {
            // topic // tag // key // body
            Message msg = new Message(profiles+"logs", "Tag-" + "log", JSONObject.toJSONString(log).getBytes());

            producer.send(msg, new SendCallback() {
                /**
                 * 发送成功回调函数
                 * @param sendResult
                 */
                @Override
                public void onSuccess(SendResult sendResult) {
                    
                
                }
                
                /**
                 * 发送失败回调函数
                 * @param e
                 */
                @Override
                public void onException(Throwable e) {
                    loger.error("发送异常：" + e);
                }
            });
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
}
