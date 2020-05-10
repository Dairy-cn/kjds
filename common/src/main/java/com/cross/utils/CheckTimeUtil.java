package com.cross.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 检查当前时间是否在某时间段
 * Created by LY on 2017/11/9.
 */
public class CheckTimeUtil {

    private static final Logger log = LoggerFactory.getLogger(CheckTimeUtil.class);

    /**
     * 检查当前时间是否在某时间段
     *
     * @param businessHours 时间段
     * @return
     */
    public static Boolean checkTime(String businessHours) {
//        log.debug("CheckTimeUtil checkTime");
        try {
            if (null == businessHours || businessHours.trim().isEmpty()) {
                return false;
            }
            // 获取当天时间
            Calendar nowTime = Calendar.getInstance();
            int year = nowTime.get(Calendar.YEAR);
            int month = nowTime.get(Calendar.MONTH) + 1;
            int day = nowTime.get(Calendar.DAY_OF_MONTH);

            // 转换成当天0时0分到23时59分
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            // 判断是否在时间内
            String[] businessHoursArr = businessHours.split(",");
            for (String timeStr : businessHoursArr) {
                String[] timeStrArr = timeStr.split("-");

                if (timeStrArr.length != 2) {
                    return false;
                }

                String[] startArr = timeStrArr[0].split(":");
                String[] endArr = timeStrArr[1].split(":");

                if (startArr.length != 2 || endArr.length != 2) {
                    return false;
                }

                int startHours = Integer.parseInt(startArr[0]);
                int startMinute = Integer.parseInt(startArr[1]);

                int endHours = Integer.parseInt(endArr[0]);
                int endMinute = Integer.parseInt(endArr[1]);

                // 小时 时间段在其中时
                Date startTime = format.parse(year + "-" + month + "-" + day + " " + startHours + ":" + startMinute + ":00");
                Date endTime = format.parse(year + "-" + month + "-" + day + " " + endHours + ":" + endMinute + ":00");

                if (startTime.getTime() <= nowTime.getTime().getTime() && endTime.getTime() >= nowTime.getTime().getTime()) {
                    return true;
                }
            }
        } catch (Exception e) {
            log.error("boolean checkTime: {}", e);
        }
        return false;
    }

    /**
     * 监测营业时间段是否重复
     *
     * @param businessHours
     * @return
     */
    public static Boolean checkTimeRepeats(String businessHours) {
        // 判断设置的营业时间是否重复
        try {
            if (null == businessHours || businessHours.trim().isEmpty()) {
                return false;
            }

            Calendar nowTime = Calendar.getInstance();
            int year = nowTime.get(Calendar.YEAR);
            int month = nowTime.get(Calendar.MONTH) + 1;
            int day = nowTime.get(Calendar.DAY_OF_MONTH);

            // 转换成当天0时0分到23时59分
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            List<Map<String, Long>> businessHoursList = new ArrayList<>();

            String[] businessHoursArr = businessHours.split(",");
            for (String timeStr : businessHoursArr) {
                String[] timeStrArr = timeStr.split("-");

                if (timeStrArr.length != 2) {
                    return false;
                }

                String[] startArr = timeStrArr[0].split(":");
                String[] endArr = timeStrArr[1].split(":");

                if (startArr.length != 2 || endArr.length != 2) {
                    return false;
                }

                int startHours = Integer.parseInt(startArr[0]);
                int startMinute = Integer.parseInt(startArr[1]);

                int endHours = Integer.parseInt(endArr[0]);
                int endMinute = Integer.parseInt(endArr[1]);

                // 小时 时间段在其中时
                Long startTime = format.parse(year + "-" + month + "-" + day + " " + startHours + ":" + startMinute + ":00").getTime();
                Long endTime = format.parse(year + "-" + month + "-" + day + " " + endHours + ":" + endMinute + ":00").getTime();

                // 判断开始时间是否大于或等于截止时间
                if (startTime >= endTime) {
                    return false;
                }
                Map<String, Long> timeMap = new HashMap<>();
                timeMap.put("startTime", startTime);
                timeMap.put("endTime", endTime);

                businessHoursList.add(timeMap);
            }

            // 判断时间是否穿插
            if (businessHoursList.size() > 1) {
                for (int i = 0; i < businessHoursList.size() - 1; i++) {
                    Map<String, Long> firstMap = businessHoursList.get(i);
                    for (int j = i + 1; j < businessHoursList.size(); j++) {
                        Map<String, Long> secondMap = businessHoursList.get(j);
                        if (!((firstMap.get("startTime") > secondMap.get("startTime") && firstMap.get("startTime") > secondMap.get("endTime") &&
                            firstMap.get("endTime") > secondMap.get("startTime") && firstMap.get("endTime") > secondMap.get("endTime")) ||
                            (firstMap.get("startTime") < secondMap.get("startTime") && firstMap.get("startTime") < secondMap.get("endTime") &&
                                firstMap.get("endTime") < secondMap.get("startTime") && firstMap.get("endTime") < secondMap.get("endTime")))) {
                            return false;
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("Boolean checkTimeRepeats: {}", e);
            return false;
        }
        return true;
    }
}
