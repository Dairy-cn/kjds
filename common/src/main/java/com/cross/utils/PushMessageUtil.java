package com.cross.utils;

import com.cross.model.MessageModel;
import com.cross.model.PushMessageDTO;

/**
 * <类的描述>
 * Created by LY on 2017/10/20.
 */
public class PushMessageUtil {

    private static final Long IOS_KEY = 24752769L;
//    private static final Long IOS_KEY = 24660260L;
    private static final Long ANDROID_KEY = 24655953L;

//    private static final Long IOS_KEY_MERCHANT = 24713944L;
    private static final Long IOS_KEY_MERCHANT = 24745582L;
    private static final Long ANDROID_KEY_MERCHANT = 24714320L;


    /**
     *
     * @param deviceType 1 安卓 2 ios
     * @param target 推送目标：DEVICE:根据设备推送  ACCOUNT:根据账号推送  ALIAS:根据别名推送  TAG:根据标签推送  ALL:推送给全部设备
     * @param targetValue 推送目标值
     * @param type 推送类型 1发消息 2发通知
     * @param messageModel 消息模型
     * @return
     */
    public static PushMessageDTO pushMessageModel(Integer deviceType, String target, String targetValue,Integer type, MessageModel messageModel){
        return getModel(deviceType, target, targetValue, type, messageModel, 1);
    }

    /**
     *
     * @param deviceType 1 安卓 2 ios
     * @param target 推送目标：DEVICE:根据设备推送  ACCOUNT:根据账号推送  ALIAS:根据别名推送  TAG:根据标签推送  ALL:推送给全部设备
     * @param targetValue 推送目标值
     * @param type 推送类型 1发消息 2发通知
     * @param messageModel 消息模型
     * @return
     */
    public static PushMessageDTO pushMessageModelMerchant(Integer deviceType, String target, String targetValue,Integer type, MessageModel messageModel){
        return getModel(deviceType, target, targetValue, type, messageModel, 2);
    }

    /**
     * 生成模型
     * @param deviceType
     * @param target
     * @param targetValue
     * @param type
     * @param messageModel
     * @return
     */
    private static PushMessageDTO getModel(Integer deviceType, String target, String targetValue,Integer type, MessageModel messageModel, Integer appType){
        if(null == deviceType){
            return null;
        }
        PushMessageDTO pushMessageDTO = new PushMessageDTO();
        pushMessageDTO.setDeviceType(deviceType);
        pushMessageDTO.setType(type);
        pushMessageDTO.setTitle(messageModel.getTitle());
        if(appType == 1){
            if(deviceType == 1){
                pushMessageDTO.setAppKey(ANDROID_KEY);
            } else {
                pushMessageDTO.setAppKey(IOS_KEY);
            }
        } else {
            if(deviceType == 1){
                pushMessageDTO.setAppKey(ANDROID_KEY_MERCHANT);
            } else {
                pushMessageDTO.setAppKey(IOS_KEY_MERCHANT);
            }
        }
        //  TODO LY 暂时修改为所有都为通知
        if(deviceType == 2){
            pushMessageDTO.setType(2);
        }
        pushMessageDTO.setTarget(target);
        pushMessageDTO.setTargetValue(targetValue);
        pushMessageDTO.setBody(JsonUtil.objectToJson(messageModel));
        return pushMessageDTO;
    }
}
