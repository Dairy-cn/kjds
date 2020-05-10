package com.cross.utils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 对数字的操作
 * Created by LY on 2017/9/9.
 */
public class NumberUtil {

    /**
     * 设置两位小数点
     *
     * @param num
     * @return
     */
    public static Double setDoubleTwo(Object num) {
        if(null == num){
            return 0d;
        }
        DecimalFormat df = new DecimalFormat(".##");
        return Double.valueOf(df.format(num));
    }

    /**
     * 设置一位小数点
     *
     * @param num
     * @return
     */
    public static Double setDoubleOne(Object num) {
        if(null == num){
            return 0d;
        }
        DecimalFormat df = new DecimalFormat("");
        return Double.valueOf(df.format(num));
    }

    /**
     * 获取随机生成的配送单号
     *
     * @return
     */
    public static String getDeliveryNum() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyMMddHHmmss");
        String time = format.format(date);
        return time + randomNumber();
    }

    public static int randomNumber() {
        return (int) ((Math.random() * 9 + 1) * 100000);
    }
}
