package com.cross.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by DuYuLiang on 2017/6/13.
 */
@Component
public class TranscationUtil {
    
    @Autowired
    private  SnowflakeKeyGeneratorUtil snowflakeKeyGeneratorUtil;
    
    
    private static final String seqLockTemplate = "seqLock:%s";
    
    //32位
    public static String makeTradeNo() {
//        return String.format("%s%s", new SimpleDateFormat("yyMMddHHmmss").format(new Date()), RandomUtil.generateValidateCode());
        return String.format("%s%s", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), RandomUtil.generateRandomValue(18));
    }
    
    //20位
    public static String makeHongBaoNo() {
//        return String.format("%s%s", new SimpleDateFormat("yyMMddHHmmss").format(new Date()), RandomUtil.generateValidateCode());
        return String.format("%s%s", new SimpleDateFormat("yyMMddHHmmss").format(new Date()), RandomUtil.generateValidateCode());
    }
    
    /**
     * 生成十四位单号
     *
     * @return
     */
    public static String makeCwOrderNo() {
        return String.format("%s%s", new SimpleDateFormat("yyMMddHHmmss").format(new Date()), RandomUtil.generateTwoValidateCode());
        // return String.format("%s%s", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), RandomUtil.generateRandomValue(18));
    }
    
    /**
     * 生成14 +10位的交易单号
     *
     * @return
     */
    public static String makePayOrderCodeNo() {
//        return String.format("%s%s", new SimpleDateFormat("yyMMddHHmmss").format(new Date()), RandomUtil.generateValidateCode());
        return String.format("%s%s", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), RandomUtil.tenValidateCode());
    }
    
    /**
     * 18位
     *
     * @return
     */
    public static String makeOrderNo() {
        return String.format("%s%s", new SimpleDateFormat("yyMMddHHmmss").format(new Date()), RandomUtil.generateValidateCode());
        // return String.format("%s%s", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), RandomUtil.generateRandomValue(18));
    }
    
    /**
     * 18位
     *
     * @return
     */
    public static Long shippingNo() {
        return Long.parseLong(String.format("%s%s", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), RandomUtil.shippingValidateCode()));
//        return snowflakeKeyGeneratorUtil.generateKey();
        
    }
    
    
}
