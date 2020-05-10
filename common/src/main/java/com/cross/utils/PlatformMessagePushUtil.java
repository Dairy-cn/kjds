package com.cross.utils;

import com.cross.client.*;
import com.cross.enumtype.PlatformMessageRemindTypeEnum;
import com.cross.enumtype.OrderMessageTypeEnum;
import com.cross.enumtype.PlatformPendingEventFromTcdTypeEnum;
import com.cross.enumtype.PlatformPendingEventTypeEnum;
import com.cross.model.MerchantModel;
import com.cross.model.PlatFormUserDTO;
import com.cross.model.UserModel;
import com.cross.model.enumeration.BrandAndMerchantType;
import com.cross.model.ws.ActivityDTO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author hcy
 * @descrption 消息推送
 * @date 2019-7-2.
 */
public class PlatformMessagePushUtil {

    public PlatformMessagePushUtil(){}

    /**
     * 平台消息提醒的key
     */
    private final String platformMessageRemindKey = "platform:message-remind:platform-id:%s";

    /**
     * 平台待处理事件的key
     */
    private final String platformPendingEventKey = "platform:pending-event:platform-id:%s";

    /**
     * 来自通吃岛平台的待处理事件的key
     */
    private final String platformPendingEventFromTcdKey = "platform:pending-event-from-tcd:platform-id:%s";

    @Autowired
    private PlatformService platformService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private OaService oaService;

    @Autowired
    private UserService userService;
    /**
     * 创建平台消息记录
     * @param platformId  平台id
     * @param eventId     具体消息的事件id
     * @param messageRemindType  消息类型
     * @param orderMessageType   订单消息类型
     */
    public void createPlatformMessageRemind(Long platformId, Long eventId,PlatformMessageRemindTypeEnum messageRemindType,
                                            OrderMessageTypeEnum orderMessageType){
        //保存消息提醒类型
        platformService.createPlatformMessageByType(platformId,eventId,messageRemindType,orderMessageType);
        //设置缓存中消息提醒的数量
        setInfoRemindKey(messageRemindType,platformId);
    }

    /**
     * 设置和增加平台缓存中待处理的事件数量
     * @param platformPendingEventTypeEnum
     * @param platformId
     */
    public void setPlatformPendingEventKey(PlatformPendingEventTypeEnum platformPendingEventTypeEnum, Long platformId){

        String hashKey = String.format(platformPendingEventKey,platformId);
        PlatFormUserDTO dto = platformService.getPlatformUserByPlatId(platformId);
        //将所有待办任务的key放入缓存中
        for (PlatformPendingEventTypeEnum item : PlatformPendingEventTypeEnum.values()){
            //key不存在才放入
            if (!redisTemplate.opsForHash().hasKey(hashKey,item.toString())){
                //查找之前待办任务的数量
                Long count = getCountByType(platformPendingEventTypeEnum,platformId);
                //如果key和传入的类型相同，则缓存中的数量减一，因为之后会加1
                if (item.equals(platformPendingEventTypeEnum)){
                    if (count >0){
                        redisTemplate.opsForHash().put(hashKey,item.toString(),String.valueOf(count -1));
                        continue;
                    }
                }
                redisTemplate.opsForHash().put(hashKey,item.toString(),String.valueOf(0));
            }
        }
        //若果缓存中的数量为负数，则设置为0
        String count = (String)redisTemplate.opsForHash().get(hashKey,platformPendingEventTypeEnum.toString());
        if (Long.parseLong(count) < 0){
            redisTemplate.opsForHash().put(hashKey,platformPendingEventTypeEnum.toString(),String.valueOf(0));
        }
        //将缓存中的数量加1
        redisTemplate.opsForHash().increment(hashKey,platformPendingEventTypeEnum.toString(),1);
        //推送待办任务数量
        sendInfoRemind(dto);

    }

    /**
     * 设置和增加平台缓存中待处理的事件数量
     * @param platformPendingEventTypeEnum
     * @param platformId
     */
    public void setPlatformPendingEventAndTcdKey(PlatformPendingEventTypeEnum platformPendingEventTypeEnum, Long platformId,Long merchantId){

        PlatFormUserDTO dto = platformService.getPlatformUserByPlatId(platformId);

        if (Objects.nonNull(dto.getPlatformSource()) && dto.getPlatformSource().equals(3)){
            //如果该平台是通吃岛平台，且该消息类型为业务订单和售后订单，而且门店不是自营门店，则向该门店绑定的其他平台推送消息
            if (platformPendingEventTypeEnum.equals(PlatformPendingEventTypeEnum.BUSINESS_ORDER_COUNT) || platformPendingEventTypeEnum.equals(PlatformPendingEventTypeEnum.AFTER_SALE_ORDER_COUNT) ){
                MerchantModel merchantModel = merchantService.getMerchantByMerchantId(merchantId);
                if (Objects.isNull(merchantModel.getBrandAndMerchantType()) || merchantModel.getBrandAndMerchantType().equals(BrandAndMerchantType.MERCHANT)){
                    PlatformPendingEventFromTcdTypeEnum platformPendingEventFromTcdTypeEnum;
                    if (platformPendingEventTypeEnum.equals(PlatformPendingEventTypeEnum.BUSINESS_ORDER_COUNT)){
                        platformPendingEventFromTcdTypeEnum = PlatformPendingEventFromTcdTypeEnum.BUSINESS_ORDER_COUNT_FROM_TCD;
                    }else {
                        platformPendingEventFromTcdTypeEnum = PlatformPendingEventFromTcdTypeEnum.AFTER_SALE_ORDER_COUNT_FROM_TCD;
                    }
                    //向绑定平台推送消息
                    tcdPlatformSendMessage(platformId,merchantId,platformPendingEventFromTcdTypeEnum);
                }
            }
        }else {
            String hashKey = String.format(platformPendingEventKey,platformId);

            //将所有待办任务的key放入缓存中
            for (PlatformPendingEventTypeEnum item : PlatformPendingEventTypeEnum.values()){
                //key不存在才放入
                if (!redisTemplate.opsForHash().hasKey(hashKey,item.toString())){
                    //查找之前待办任务的数量
                    Long count = getCountByType(platformPendingEventTypeEnum,platformId);
                    //如果key和传入的类型相同，则缓存中的数量减一，因为之后会加1
                    if (item.equals(platformPendingEventTypeEnum)){
                        if (count >0){
                            redisTemplate.opsForHash().put(hashKey,item.toString(),String.valueOf(count -1));
                            continue;
                        }
                    }
                    redisTemplate.opsForHash().put(hashKey,item.toString(),String.valueOf(0));
                }
            }
            //若果缓存中的数量为负数，则设置为0
            String count = (String)redisTemplate.opsForHash().get(hashKey,platformPendingEventTypeEnum.toString());
            if (Long.parseLong(count) < 0){
                redisTemplate.opsForHash().put(hashKey,platformPendingEventTypeEnum.toString(),String.valueOf(0));
            }
            //将缓存中的数量加1
            redisTemplate.opsForHash().increment(hashKey,platformPendingEventTypeEnum.toString(),1);
            //推送待办任务数量
            sendInfoRemind(dto);
        }
    }

    /**
     * 减少平台缓存中待处理事件的数量
     * @param platformPendingEventTypeEnum 待处理事件类型
     */
    public void lessPlatformPendingCount(PlatformPendingEventTypeEnum platformPendingEventTypeEnum, Long platformId){
        PlatFormUserDTO dto = platformService.getPlatformUserByPlatId(platformId);
        //查看缓存是否存在
        if (redisTemplate.opsForHash().hasKey(String.format(platformPendingEventKey,platformId),platformPendingEventTypeEnum.toString())){
            //获取缓存中数量
            String count = (redisTemplate.opsForHash().get(String.format(platformPendingEventKey,platformId),platformPendingEventTypeEnum.toString())).toString();
            //大于0减1，否者设置为0
            if (Long.parseLong(count) > 0){
                redisTemplate.opsForHash().increment(String.format(platformPendingEventKey,platformId),platformPendingEventTypeEnum.toString(),-1);
            }else if (Long.parseLong(count) < 0){
                redisTemplate.opsForHash().put(String.format(platformPendingEventKey,platformId),platformPendingEventTypeEnum.toString(),String.valueOf(0));
            }
        }
        //推送待办任务数量
        sendInfoRemind(dto);

    }

    /**
     * 减少平台缓存中待处理事件的数量
     * @param platformPendingEventTypeEnum 待处理事件类型
     */
    public void lessPlatformPendingAndTcdCount(PlatformPendingEventTypeEnum platformPendingEventTypeEnum, Long platformId,Long merchantId){
        PlatFormUserDTO dto = platformService.getPlatformUserByPlatId(platformId);
        if (Objects.nonNull(dto.getPlatformSource()) && dto.getPlatformSource().equals(3)){
            //如果该平台是通吃岛平台，且该消息类型为业务订单和售后订单，而且门店不是自营门店，则减少该门店绑定的其他平台的待处理数量
            if (platformPendingEventTypeEnum.equals(PlatformPendingEventTypeEnum.BUSINESS_ORDER_COUNT) || platformPendingEventTypeEnum.equals(PlatformPendingEventTypeEnum.AFTER_SALE_ORDER_COUNT) ){
                MerchantModel merchantModel = merchantService.getMerchantByMerchantId(merchantId);
                if (Objects.isNull(merchantModel.getBrandAndMerchantType()) || merchantModel.getBrandAndMerchantType().equals(BrandAndMerchantType.MERCHANT)){
                    PlatformPendingEventFromTcdTypeEnum platformPendingEventFromTcdTypeEnum;
                    if (platformPendingEventTypeEnum.equals(PlatformPendingEventTypeEnum.BUSINESS_ORDER_COUNT)){
                        platformPendingEventFromTcdTypeEnum = PlatformPendingEventFromTcdTypeEnum.BUSINESS_ORDER_COUNT_FROM_TCD;
                    }else {
                        platformPendingEventFromTcdTypeEnum = PlatformPendingEventFromTcdTypeEnum.AFTER_SALE_ORDER_COUNT_FROM_TCD;
                    }
                    //减少绑定平台待处理事件
                    tcdPlatformLessMessage(platformId,merchantId,platformPendingEventFromTcdTypeEnum);
                }
            }
        }else {
            //查看缓存是否存在
            if (redisTemplate.opsForHash().hasKey(String.format(platformPendingEventKey,platformId),platformPendingEventTypeEnum.toString())){
                //获取缓存中数量
                String count = (redisTemplate.opsForHash().get(String.format(platformPendingEventKey,platformId),platformPendingEventTypeEnum.toString())).toString();
                //大于0减1，否者设置为0
                if (Long.parseLong(count) > 0){
                    redisTemplate.opsForHash().increment(String.format(platformPendingEventKey,platformId),platformPendingEventTypeEnum.toString(),-1);
                }else if (Long.parseLong(count) < 0){
                    redisTemplate.opsForHash().put(String.format(platformPendingEventKey,platformId),platformPendingEventTypeEnum.toString(),String.valueOf(0));
                }
            }
            //推送待办任务数量
            sendInfoRemind(dto);
        }
    }

    /**
     * 删除平台下缓存中的待处理事件的key
     */
    public void deletePendingEvenKey(Long platformId){
        //平台本身产生的
        String hashKey = String.format(platformPendingEventKey,platformId);
        for (PlatformPendingEventTypeEnum item : PlatformPendingEventTypeEnum.values()) {
            if (redisTemplate.opsForHash().hasKey(hashKey, item.toString())){
                redisTemplate.opsForHash().delete(hashKey,item.toString());
            }
        }
        //申请入驻通吃岛平台产生的
        deletePendingEvenFromTcdKey(platformId);
    }


    /**
     * 当平台与店进行解绑的时候，删除平台下来自于通吃岛平台缓存中的待处理事件的key
     */
    public void deletePendingEvenFromTcdKey(Long platformId){
        //申请入驻通吃岛平台产生的
        String hashKeyFromTcd = String.format(platformPendingEventFromTcdKey,platformId);
        for (PlatformPendingEventFromTcdTypeEnum item : PlatformPendingEventFromTcdTypeEnum.values()) {
            if (redisTemplate.opsForHash().hasKey(hashKeyFromTcd, item.toString())){
                redisTemplate.opsForHash().delete(hashKeyFromTcd,item.toString());
            }
        }
    }

    /**
     * 通过类型查找之前待审核的记录数
     * @param platformPendingEventTypeEnum 待处理事件类型
     * @param platformId
     * @return
     */
    private Long getCountByType(PlatformPendingEventTypeEnum platformPendingEventTypeEnum, Long platformId){
        Long count = 0L;
        if (platformPendingEventTypeEnum.equals(PlatformPendingEventTypeEnum.BUSINESS_ORDER_COUNT)){
            count = shopService.getBusinessOrderCountByPending(platformId);
        }else if (platformPendingEventTypeEnum.equals(PlatformPendingEventTypeEnum.AFTER_SALE_ORDER_COUNT)){
            count = shopService.getAfterSaleOrderCountByPending(platformId);
        }else if (platformPendingEventTypeEnum.equals(PlatformPendingEventTypeEnum.FINANCE_COUNT)){
            count = merchantService.countWaitPayDistributorByPlatformId(platformId).longValue();
        }else if (platformPendingEventTypeEnum.equals(PlatformPendingEventTypeEnum.WITHDRAW_COUNT)){
            count = merchantService.countWaitVerifyDistributorByPlatformId(platformId).longValue();
        }
        return count;
    }

    /**
     * 得到当前平台缓存中的待处理的事件的数量
     * @return
     */
    public Map<Object,Object> getPlatformPendingCount(Long platformId){
        //先将所有待办任务类型的key放入缓存中,登录时先拿去数据，若不存在则创建
        String hashKey = String.format(platformPendingEventKey,platformId);
        for (PlatformPendingEventTypeEnum item : PlatformPendingEventTypeEnum.values()) {
            if (!redisTemplate.opsForHash().hasKey(hashKey, item.toString())){
                Long count = getCountByType(item,platformId);
                redisTemplate.opsForHash().put(hashKey, item.toString(),String.valueOf(count));
            }
        }
        return redisTemplate.opsForHash().entries(hashKey);
    }

    /**
     * 设置和增加消息提醒中的数量
     */
    public void setInfoRemindKey(PlatformMessageRemindTypeEnum platformMessageRemindTypeEnum, Long platformId){
        PlatFormUserDTO dto = platformService.getPlatformUserByPlatId(platformId);
        String hashKey = String.format(platformMessageRemindKey,platformId);
        //先将所有任务类型的key放入缓存中
        for (PlatformMessageRemindTypeEnum item : PlatformMessageRemindTypeEnum.values()) {
            if (!redisTemplate.opsForHash().hasKey(hashKey, item.toString())){
                redisTemplate.opsForHash().put(hashKey, item.toString(),String.valueOf(0));
            }
        }
        redisTemplate.opsForHash().increment(hashKey,platformMessageRemindTypeEnum.toString(),1);
        //发送消息
        sendInfoRemind(dto);
    }


    /**
     * 减少平台缓存消息提醒的数量
     * @param platformMessageRemindTypeEnum 消息提醒类型
     */
    public void lessPlatformMessageCount(PlatformMessageRemindTypeEnum platformMessageRemindTypeEnum, Long platformId){
        PlatFormUserDTO dto = platformService.getPlatformUserByPlatId(platformId);
        //查看缓存是否存在
        if (redisTemplate.opsForHash().hasKey(String.format(platformMessageRemindKey,platformId),platformMessageRemindTypeEnum.toString())){
            //获取缓存中数量
            String count = (redisTemplate.opsForHash().get(String.format(platformMessageRemindKey,platformId),platformMessageRemindTypeEnum.toString())).toString();
            //大于0减1，否者设置为0
            if (Long.parseLong(count) > 0){
                redisTemplate.opsForHash().increment(String.format(platformMessageRemindKey,platformId),platformMessageRemindTypeEnum.toString(),-1);
            }else{
                redisTemplate.opsForHash().put(String.format(platformMessageRemindKey,platformId),platformMessageRemindTypeEnum.toString(),String.valueOf(0));
            }
        }
        //推送待办任务数量
        sendInfoRemind(dto);
    }


    /**
     *   清空消息提醒中的数量 --- 该类型所有的消息数量都进行清空
     */
    public void emptyInfoRemind(PlatformMessageRemindTypeEnum platformMessageRemindTypeEnum, Long platformId){
        //当前类型的总数从总的中减掉
        if(redisTemplate.opsForHash().hasKey(String.format(platformMessageRemindKey,platformId),platformMessageRemindTypeEnum.toString())){
            //将缓存中的数量变为0
            redisTemplate.opsForHash().put(String.format(platformMessageRemindKey,platformId),platformMessageRemindTypeEnum.toString(),String.valueOf(0));
        }
        PlatFormUserDTO dto = platformService.getPlatformUserByPlatId(platformId);
        //发送消息
        sendInfoRemind(dto);
    }
    /**
     * 得到当前登陆者缓存中的消息的数量
     * @return
     */
    public Map<Object,Object> getPlatformRemindInfoCount(Long platformId){
        String hashKey = String.format(platformMessageRemindKey,platformId);
        //先将所有任务类型的key放入缓存中，登录时，拿取数据，若不存在则创建
        for (PlatformMessageRemindTypeEnum item : PlatformMessageRemindTypeEnum.values()) {
            if (!redisTemplate.opsForHash().hasKey(hashKey, item.toString())){
                redisTemplate.opsForHash().put(hashKey, item.toString(),String.valueOf(0));
            }
        }
        return redisTemplate.opsForHash().entries(hashKey);
    }

    /**
     * 消息推送
     */
    private void sendInfoRemind( PlatFormUserDTO platFormUserDTO){
        UserModel userModel = userService.getUserById(platFormUserDTO.getCreatedBy());
        ActivityDTO activityDTO = new ActivityDTO();
        activityDTO.setUserLogin(userModel.getLogin());
        activityDTO.setTime(Instant.now());
        Map<Object,Object> infoRemindMap  = getPlatformRemindInfoCount(platFormUserDTO.getId());
        Map<Object,Object> pendingEventMap = getPlatformPendingCount(platFormUserDTO.getId());
        Map<Object,Object> map = new HashMap<>(16);
        map.putAll(infoRemindMap);
        map.putAll(pendingEventMap);
        activityDTO.setMap(map);
        //私有通道
        oaService.sendWebSocketMessage(activityDTO);
    }


    /**
     * 入驻通吃岛的商户产生的订单相关待处理事件的设置方法
     * @param tcdPlatformId
     * @param merchantId
     * @param platformPendingEventFromTcdTypeEnum
     */
    private void tcdPlatformSendMessage(Long tcdPlatformId,Long merchantId, PlatformPendingEventFromTcdTypeEnum platformPendingEventFromTcdTypeEnum){

        List<Long> bindPlatformIdList = platformService.findAllPlatformIdByMerchantId(merchantId);
        if (CollectionUtils.isNotEmpty(bindPlatformIdList)){
            bindPlatformIdList.forEach(e->{
                if (!e.equals(tcdPlatformId)){
                    setPlatformPendingEventFromTcdKey(platformPendingEventFromTcdTypeEnum,e);
                }
            });
        }
    }

    /**
     * 减少入驻通吃岛的商户绑定的平台的待处理事件数量
     * @param tcdPlatformId
     * @param merchantId
     * @param platformPendingEventFromTcdTypeEnum
     */
    private void tcdPlatformLessMessage(Long tcdPlatformId,Long merchantId, PlatformPendingEventFromTcdTypeEnum platformPendingEventFromTcdTypeEnum){
        List<Long> bindPlatformIdList = platformService.findAllPlatformIdByMerchantId(merchantId);
        if (CollectionUtils.isNotEmpty(bindPlatformIdList)){
            bindPlatformIdList.forEach(e->{
                if (!e.equals(tcdPlatformId)){
                    lessPlatformPendingFromTcdCount(platformPendingEventFromTcdTypeEnum,e);
                }
            });
        }
    }

    /**
     * 设置和增加平台缓存中待处理的事件数量:当前平台商户入驻通吃岛平台之后，在通吃岛平台产生的订单相关的待处理数量
     * @param platformPendingEventFromTcdTypeEnum
     * @param platformId 门店绑定的平台id
     */
    public void setPlatformPendingEventFromTcdKey(PlatformPendingEventFromTcdTypeEnum platformPendingEventFromTcdTypeEnum,Long platformId){

        String hashKey = String.format(platformPendingEventFromTcdKey,platformId);
        //将所有待办任务的key放入缓存中
        for (PlatformPendingEventFromTcdTypeEnum item : PlatformPendingEventFromTcdTypeEnum.values()){
            //key不存在才放入
            if (!redisTemplate.opsForHash().hasKey(hashKey,item.toString())){
                //查找之前待办任务的数量
                Long count = getCountFromTcdByType(platformPendingEventFromTcdTypeEnum,platformId);
                //如果key和传入的类型相同，则缓存中的数量减一，因为之后会加1
                if (item.equals(platformPendingEventFromTcdTypeEnum)){
                    if (count >0){
                        redisTemplate.opsForHash().put(hashKey,item.toString(),String.valueOf(count -1));
                        continue;
                    }
                }
                redisTemplate.opsForHash().put(hashKey,item.toString(),String.valueOf(0));
            }
        }
        //若果缓存中的数量为负数，则设置为0
        String count = (String)redisTemplate.opsForHash().get(hashKey,platformPendingEventFromTcdTypeEnum.toString());
        if (Long.parseLong(count) < 0){
            redisTemplate.opsForHash().put(hashKey,platformPendingEventFromTcdTypeEnum.toString(),String.valueOf(0));
        }
        //将缓存中的数量加1
        redisTemplate.opsForHash().increment(hashKey,platformPendingEventFromTcdTypeEnum.toString(),1);
        //推送待办任务数量
        PlatFormUserDTO dto = platformService.getPlatformUserByPlatId(platformId);
        sendInfoRemind(dto);
    }

    /**
     * 通过类型查找之前待审核的记录数
     * @param platformPendingEventFromTcdTypeEnum 待处理事件类型
     * @param platformId 平台id
     * @return
     */
    private Long getCountFromTcdByType(PlatformPendingEventFromTcdTypeEnum platformPendingEventFromTcdTypeEnum,Long platformId){
        Long count = 0L;
        //获取该平台下绑定的所有门店id
        List<Long> merchantIds = platformService.getTcdMerchantIdByTcdPlatformId(platformId);
        if (CollectionUtils.isNotEmpty(merchantIds)){
            if (platformPendingEventFromTcdTypeEnum.equals(PlatformPendingEventFromTcdTypeEnum.BUSINESS_ORDER_COUNT_FROM_TCD)){
                count = shopService.getBusinessOrderCountByPendingAndMerchantId(merchantIds);
            }else if (platformPendingEventFromTcdTypeEnum.equals(PlatformPendingEventFromTcdTypeEnum.AFTER_SALE_ORDER_COUNT_FROM_TCD)){
                count = shopService.getAfterSaleOrderCountByPendingAndMerchantId(merchantIds);
            }
        }
        return count;
    }

    /**
     * 减少平台缓存中待处理事件的数量
     * @param platformPendingEventFromTcdTypeEnum 待处理事件类型
     */
    private void lessPlatformPendingFromTcdCount(PlatformPendingEventFromTcdTypeEnum platformPendingEventFromTcdTypeEnum, Long platformId){
        PlatFormUserDTO dto = platformService.getPlatformUserByPlatId(platformId);
        //查看缓存是否存在
        if (redisTemplate.opsForHash().hasKey(String.format(platformPendingEventFromTcdKey,platformId),platformPendingEventFromTcdTypeEnum.toString())){
            //获取缓存中数量
            String count = (redisTemplate.opsForHash().get(String.format(platformPendingEventFromTcdKey,platformId),platformPendingEventFromTcdTypeEnum.toString())).toString();
            //大于0减1，否者设置为0
            if (Long.parseLong(count) > 0){
                redisTemplate.opsForHash().increment(String.format(platformPendingEventFromTcdKey,platformId),platformPendingEventFromTcdTypeEnum.toString(),-1);
            }else if (Long.parseLong(count) < 0){
                redisTemplate.opsForHash().put(String.format(platformPendingEventFromTcdKey,platformId),platformPendingEventFromTcdTypeEnum.toString(),String.valueOf(0));
            }
        }
        //推送待办任务数量
        sendInfoRemind(dto);
    }

}
