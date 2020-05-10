package com.cross.bean;

import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudQueue;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.model.*;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.cross.model.QueueMessageModel;
import com.cross.utils.JsonUtil;
import com.cross.utils.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 阿里云工具类
 *
 * @author DuYuLiang on 2017/6/19.
 */
@Component
public class AliYunUtil {
    private final Logger log = LoggerFactory.getLogger(AliYunUtil.class);

    private MNSClient client = null;
    /**
     * 主队列
     */
    private String _queueNameMaster; //QUEUE_NAME_MASTER
    /**
     * 备份队列
     */
    private String _queueNameBak; //QUEUE_NAME_BAK
    /**
     * 失败队列
     */
    private String _queueNameFail; //QUEUE_NAME_FAIL

    /**
     * 分发订单主队列   //QUEUE_NAME_MASTER
     */
    private String _sendOrderQueueName;
    /**
     * 分发订单备份队列  //QUEUE_NAME_BAK
     */
    private String _sendOrderQueueNameBak;
    /**
     * 分发订单失败队列  //QUEUE_NAME_FAIL
     */
    private String _sendOrderQueueNameFail;

    /**
     * 失败延迟时间
     */
    @Value("${aliYun.mns.failDelayTime}")
    private Integer failDelayTime;
    /**
     * 失败尝试次数
     */
    @Value("${aliYun.mns.failTryCount}")
    private Integer failTryCount;
    /**
     * 专题名称
     */
    @Value("${aliYun.sms.topicName}")
    private String topicName;
    /**
     * 钱小豪验证码模版
     */
    @Value("${aliYun.sms.qianXiaoHaoValidationTemplateCode}")
    private String validationTemplateCode;
    /**
     * 钱小豪签名名称
     */
    @Value("${aliYun.sms.qianXiaoHaoSignName}")
    private String signName;
    /**
     * 阿里云ACCESSKeyid
     */
    @Value("${aliYun.accessKeyId}")
    private String accessKeyId;
    /**
     * 阿里云密钥
     */
    @Value("${aliYun.accessKeySecret}")
    private String accessKeySecret;
    /**
     * 阿里云endPoint
     */
    @Value("${aliYun.accountEndPoint}")
    private String accountEndPoint;
    /**
     * 主队列名称
     */
    @Value("${aliYun.mns.queueNameMaster}")
    private String queueNameMaster;

    @Value("${aliYun.mns.sendOrderQueueName}")
    private String sendOrderQueueName;

    @Bean(value = "initAliYunUtilBean")
    public AliYunUtil init() {
        if(client == null){
            this._queueNameMaster = queueNameMaster;
            this._queueNameBak = String.format("%sBAK", _queueNameMaster);
            this._queueNameFail = String.format("%sFAIL", _queueNameMaster);

            this._sendOrderQueueName = sendOrderQueueName;
            this._sendOrderQueueNameBak = String.format("%sBAK", _sendOrderQueueNameBak);
            this._sendOrderQueueNameFail = String.format("%sFAIL", _sendOrderQueueNameFail);

            CloudAccount account = new CloudAccount(
                accessKeyId,
                accessKeySecret,
                accountEndPoint);
            client = account.getMNSClient();
        }

        return this;
    }

    /**
     * 推送消息到主队列
     *
     * @param messageBody
     * @return
     */
    public Boolean pushQueue(QueueMessageModel messageBody) {
        Message putMsg = new Message();
        try {
            // 创建队列
            CloudQueue queue = client.getQueueRef(this._queueNameMaster);

            // 发送消息
            putMsg = pushMessage(queue, messageBody);

            log.info("push queue end: ", putMsg.toString());
        } catch (Exception e) {
            log.error("push queue exception: ", e);
        }
        if (putMsg.getErrorMessage() != null){
            log.error("push queue have error:", putMsg.getErrorMessage());
        }
        return putMsg.getErrorMessage() == null || putMsg.getErrorMessage().getErrorCode().isEmpty();
    }
    /**
     *  发送延时队列
     */
    public Boolean pushDelayQueue(QueueMessageModel messageBody,Integer delaySeconds) {
        Message putMsg = new Message();
        try {
            // 创建队列
            CloudQueue queue = client.getQueueRef(this._sendOrderQueueName);

            // 发送消息
            putMsg = pushDelayMessage(queue, messageBody,delaySeconds);

            log.info("push queue end: ", putMsg.toString());
        } catch (Exception e) {
            log.error("push queue exception: ", e);
        }
        if (putMsg.getErrorMessage() != null){
            log.error("push queue have error:", putMsg.getErrorMessage());
        }
        return putMsg.getErrorMessage() == null || putMsg.getErrorMessage().getErrorCode().isEmpty();
    }


    /**
     * 推送消息到失败队列
     *
     * @param messageBody
     * @return
     */
    public Boolean pushMessageToFailQueue(QueueMessageModel messageBody) {
        Message putMsg = new Message();
        try {
            // 创建队列
            CloudQueue queue = client.getQueueRef(_queueNameFail);

            // 发送消息
            putMsg = pushMessage(queue, messageBody);

            log.info("push message to fail queue end: ", putMsg.toString());
        } catch (Exception e) {
            log.error("push message to fail queue exception: ", e);
        }
        return putMsg.getErrorMessage() == null || putMsg.getErrorMessage().getErrorCode().isEmpty();
    }

    /**
     * 弹出主队列
     *
     * @return
     */
    public Message popMasterQueue() {
        log.debug("pop queue start: ");
        Message message = this.popQueue(_queueNameMaster);
        log.trace("pop queue end: ", message);
        return message;
    }

    /**
     * 弹出备份队列
     *
     * @return
     */
    public Message popBakQueue() {
        log.info("pop queue start: ");
        Message message = this.popQueue(_queueNameBak);
        log.info("pop queue end: ", message);
        return message;
    }

    /**
     * 弹出队列
     *
     * @param queueName
     * @return Message
     */
    private Message popQueue(String queueName) {
        CloudQueue queue = client.getQueueRef(queueName);
        return queue.popMessage();
    }

    /**
     * 延长下次消费时间
     *
     * @param message
     */
    public void delayRequestTime(Message message) {
        CloudQueue queue = client.getQueueRef(_queueNameMaster);
        if (message == null) {
            return;
        }
        try{
            Integer delayTime = message.getDequeueCount() <= 5 ? 15 : failDelayTime * message.getDequeueCount();// 每获取一次 消息延迟 1分钟
            if (message.getDequeueCount() > failTryCount) {
                CloudQueue queueFail = client.getQueueRef(_queueNameFail);
                Message putMsg = queueFail.putMessage(message);
                if (putMsg.getErrorMessage() == null || putMsg.getErrorMessage().getErrorCode().isEmpty()) {
                    queue.deleteMessage(message.getReceiptHandle());//进入失败后直接移除主队列
                }
            }
            else{
                queue.changeMessageVisibilityTimeout(message.getReceiptHandle(), delayTime);
            }
        }
        catch (Exception e){
            log.error("delay queue consume time fail", e);
        }
    }

    /**
     * 删除队列消息
     *
     * @param message
     * @return
     */
    public Message delQueue(Message message) {
        CloudQueue queue = client.getQueueRef(_queueNameMaster);
        log.info(String.format("delete queue by: %s", _queueNameMaster));
        queue.deleteMessage(message.getReceiptHandle());
        return message;
    }

    /**
     * 推送消息
     *
     * @param queue
     * @param messageBody
     */
    private Message pushMessage(CloudQueue queue, QueueMessageModel messageBody){
        Message message = new Message();
        message.setMessageBody(JsonUtil.objectToJson(messageBody));
        message = queue.putMessage(message);
        if (message.getErrorMessage() != null && !message.getErrorMessage().getErrorCode().isEmpty()) {
            //消息发送失败 发往备用队列
            CloudQueue queueBak = client.getQueueRef(_queueNameBak);
            message = queueBak.putMessage(message);
        }
        return message;
    }

    /**
     * 推送消息，发送延迟消息
     *
     * @param queue
     * @param messageBody
     */
    private Message pushDelayMessage(CloudQueue queue, QueueMessageModel messageBody,Integer delaySeconds ){
        Message message = new Message();
        message.setMessageBody(JsonUtil.objectToJson(messageBody));
        message.setDelaySeconds(delaySeconds);
        message = queue.putMessage(message);
        if (message.getErrorMessage() != null && !message.getErrorMessage().getErrorCode().isEmpty()) {
            //消息发送失败 发往备用队列
            CloudQueue queueBak = client.getQueueRef(_sendOrderQueueNameBak);
            message = queueBak.putMessage(message);
        }
        return message;
    }

    /**
     * 发送短信方法 支持多个接受者
     *
     * @param topicName
     * @param signName
     * @param templateCode
     * @param templateParam
     * @param receiverPhones
     * @return
     */
    private Boolean sendSMS(String topicName, String signName, String templateCode, Map<String, String> templateParam, List<String> receiverPhones) {
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化ascClient需要的几个参数
        final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
        final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
//替换成你的AK
        final String accessKeyId = this.accessKeyId;//你的accessKeyId,参考本文档步骤2
        final String accessKeySecret = this.accessKeySecret;//你的accessKeySecret，参考本文档步骤2
//初始化ascClient,暂时不支持多region（请勿修改）

        try{
            //可自助调整超时时间

            //初始化acsClient,暂不支持region化
            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
            IAcsClient acsClient = new DefaultAcsClient(profile);

            //组装请求对象-具体描述见控制台-文档部分内容
            SendSmsRequest request = new SendSmsRequest();
            //必填:待发送手机号
            request.setPhoneNumbers(String.join(",", receiverPhones));
            //必填:短信签名-可在短信控制台中找到
            request.setSignName(signName);
            //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode(templateCode);
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            request.setTemplateParam(JsonUtil.objectToJson(templateParam));

            //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
            //request.setSmsUpExtendCode("90997");

            //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
            //request.setOutId("yourOutId");

            //hint 此处可能会抛出异常，注意catch
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            log.info("send sms finish: {}", JsonUtil.objectToJson(sendSmsResponse));
            if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
//请求成功
                return true;
            }
        }
        catch (Exception e){
            log.error("send sms fail: ", e);
        }
        return false;
    }

    /**
     * 发送短信验证码
     *
     * @param receiverPhone
     * @return
     */
    public String sendValidationCodeSMS(String receiverPhone){
        List<String> receiverPhones = new ArrayList<>();
        receiverPhones.add(receiverPhone);

        String validationCode = RandomUtil.generateValidateCode().toString();

        Map<String, String> map = new HashMap<>();
        map.put("code", validationCode);

        sendSMS(topicName, signName, validationTemplateCode, map, receiverPhones);
        return validationCode;
    }

    /**
     * 关闭资源连接
     */
    public void closeClient(){
        client.close();
    }

    /**
     * 根据参数发送短信信息
     *
     * @param paramMap
     * @return
     */
    public Boolean sendValidationCodeSMS(String signName,String validationTemplateCode,Map<String, String> paramMap,List<String> receiverPhones){
        Boolean flag = Boolean.FALSE;
        String topicName = "";
        flag = sendSMS(topicName, signName, validationTemplateCode, paramMap, receiverPhones);
        return flag;
    }
}
