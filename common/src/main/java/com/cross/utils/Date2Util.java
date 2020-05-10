package com.cross.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Component
public class Date2Util {

    /**
     * 1 昨日  2 本周 3 本月  4 本年  5 近7天  6  近30天
     */
    public static Map<String, Date> getDateByNum(String number) throws Exception {

        Map<String, Date> dateMap = new HashMap<>();
        Date startTime;
        Date endTime;
        Calendar nowTime = Calendar.getInstance();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if ("1".equals(number)) {
            nowTime.add(Calendar.DAY_OF_MONTH, -1);
            int year = nowTime.get(Calendar.YEAR);
            int month = nowTime.get(Calendar.MONTH) + 1;
            int day = nowTime.get(Calendar.DAY_OF_MONTH);
            startTime = sf.parse(year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day) + " " + "00:00:00");
            endTime = sf.parse(year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day) + " " + "23:59:59");
            dateMap.put("startTime", startTime);
            dateMap.put("endTime", endTime);
            return dateMap;
        } else if ("2".equals(number)) {
            nowTime.setFirstDayOfWeek(Calendar.MONDAY);
            int dayOfWeek = nowTime.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == 1) {
                dayOfWeek = 8;
            }
            nowTime.set(Calendar.HOUR_OF_DAY, 0);
            nowTime.set(Calendar.MINUTE, 0);
            nowTime.set(Calendar.SECOND, 0);
            nowTime.add(Calendar.DATE, nowTime.getFirstDayOfWeek() - dayOfWeek);
            dateMap.put("startTime", nowTime.getTime());
            dateMap.put("endTime", new Date());
            return dateMap;
        } else if ("3".equals(number)) {
            //设置为1号,当前日期既为本月第一天
            nowTime.set(Calendar.DAY_OF_MONTH, 1);
            nowTime.set(Calendar.HOUR_OF_DAY, 0);
            nowTime.set(Calendar.MINUTE, 0);
            nowTime.set(Calendar.SECOND, 0);

            dateMap.put("startTime", nowTime.getTime());
            dateMap.put("endTime", new Date());
            return dateMap;
        } else if ("4".equals(number)) {
            nowTime.set(Calendar.MONTH, 0);
            //设置为1号,当前日期既为本月第一天
            nowTime.set(Calendar.DAY_OF_MONTH, 1);
            nowTime.set(Calendar.HOUR_OF_DAY, 0);
            nowTime.set(Calendar.MINUTE, 0);
            nowTime.set(Calendar.SECOND, 0);
            dateMap.put("startTime", nowTime.getTime());
            dateMap.put("endTime", new Date());
            return dateMap;
        } else if ("5".equals(number)) {
            //往前推7天：前七天的开始时间
            nowTime.add(Calendar.DAY_OF_MONTH, -6);
            int year = nowTime.get(Calendar.YEAR);
            int month = nowTime.get(Calendar.MONTH) + 1;
            int day = nowTime.get(Calendar.DAY_OF_MONTH);
            startTime = sf.parse(year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day) + " " + "00:00:00");
            //当前时间往前推一天：前七天的结束时间
            Calendar time = Calendar.getInstance();
            time.add(Calendar.DAY_OF_MONTH, 0);
            int yearTime = time.get(Calendar.YEAR);
            int monthTime = time.get(Calendar.MONTH) + 1;
            int dayTime = time.get(Calendar.DAY_OF_MONTH);
            endTime = sf.parse(yearTime + "-" + (monthTime < 10 ? "0" + monthTime : monthTime) + "-" + (dayTime < 10 ? "0" + dayTime : dayTime) + " " + "23:59:59");

            dateMap.put("startTime", startTime);
            dateMap.put("endTime", endTime);
            return dateMap;
        } else if ("6".equals(number)) {
            //往前推30天：前30天的开始时间
            nowTime.add(Calendar.DAY_OF_MONTH, -29);
            int year = nowTime.get(Calendar.YEAR);
            int month = nowTime.get(Calendar.MONTH) + 1;
            int day = nowTime.get(Calendar.DAY_OF_MONTH);
            startTime = sf.parse(year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day) + " " + "00:00:00");
            //当前时间往前推一天：前七天的结束时间
            Calendar time = Calendar.getInstance();
            time.add(Calendar.DAY_OF_MONTH, 0);
            int yearTime = time.get(Calendar.YEAR);
            int monthTime = time.get(Calendar.MONTH) + 1;
            int dayTime = time.get(Calendar.DAY_OF_MONTH);
            endTime = sf.parse(yearTime + "-" + (monthTime < 10 ? "0" + monthTime : monthTime) + "-" + (dayTime < 10 ? "0" + dayTime : dayTime) + " " + "23:59:59");

            dateMap.put("startTime", startTime);
            dateMap.put("endTime", endTime);
            return dateMap;
        }
        return null;
    }

    /**
     * 通过日历获取时间戳
     *
     * @param beforeDay  当前时间往前推多少天
     * @param useLocal   使用地方 1：用于订单营业额和销量（要求昨日的结束时间和今日时间的时分秒相同） 2：结束时间的时分秒为23:59:59
     * @param startOrEnd 1：开始时间（默认为零时零分零秒）   2：结束时间（时分秒为当前时分秒）
     * @return
     * @throws Exception
     */
    public static Integer getIntegerDateByCalendar(Integer beforeDay, Integer startOrEnd, Integer useLocal) throws Exception {

        Date timeDate;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -beforeDay);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        if (startOrEnd == 1) {
            timeDate = sf.parse(year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day) + " " + "00:00:00");
        } else {
            if (useLocal == 1) {
                //时 24小时制
                int hours = calendar.get(Calendar.HOUR_OF_DAY);
                //分
                int minute = calendar.get(Calendar.MINUTE);
                //秒
                int second = calendar.get(Calendar.SECOND);

                timeDate = sf.parse(year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day) + " "
                    + (hours < 10 ? "0" + hours : hours) + ":" + (minute < 10 ? "0" + minute : minute) + ":" + (second < 10 ? "0" + second : second));
            } else {
                timeDate = sf.parse(year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day) + " " + "23:59:59");
            }
        }
        return getInterTime(timeDate);
    }

    public static Integer getInterTime(Date date) {
        Long longTime = date.getTime() / 1000;
        return longTime.intValue();
    }

    /**
     * 获取两个日期相差月数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getMonthSpace(Date date1, Date date2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(date1);
        c2.setTime(date2);

        int year = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        int month = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

        return year * 12 + month;
    }

    /**
     * 将时间戳（10位数字）转换成instant格式的时间
     *
     * @param time
     * @return
     * @throws Exception
     */
    public static Instant stampToInstant(Integer time) {
        Long timeLong = time.longValue();
        Date date = new Date(timeLong * 1000);
        return date.toInstant();
    }

    /**
     * 获取当前时间的字符串
     *
     * @return
     */
    public static List<String> todayTimeStr() throws Exception {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        Instant startTime = sf.parse(year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day) + " " + "00:00:00").toInstant();
        Instant endTime = sf.parse(year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day) + " " + "23:59:59").toInstant();
        ZoneId zone = ZoneId.systemDefault();

        LocalDateTime start = LocalDateTime.ofInstant(startTime, zone);
        LocalDateTime end = LocalDateTime.ofInstant(endTime, zone);
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<String> dateStrList = new ArrayList<>();
        dateStrList.add(dtf2.format(start));
        dateStrList.add(dtf2.format(end));
        return dateStrList;
    }

    /**
     * 获取当月时间的字符串
     *
     * @return
     */
    public static List<String> monthTimeStr() throws Exception {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        Instant startTime = sf.parse(year + "-" + (month < 10 ? "0" + month : month) + "-" + "01" + " " + "00:00:00").toInstant();
        Instant endTime = sf.parse(year + "-" + (month < 10 ? "0" + month : month) + "-" + (day < 10 ? "0" + day : day) + " " + "23:59:59").toInstant();
        ZoneId zone = ZoneId.systemDefault();

        LocalDateTime start = LocalDateTime.ofInstant(startTime, zone);
        LocalDateTime end = LocalDateTime.ofInstant(endTime, zone);
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<String> dateStrList = new ArrayList<>();
        dateStrList.add(dtf2.format(start));
        dateStrList.add(dtf2.format(end));
        return dateStrList;
    }

    /**
     * 获取当期时间的字符串
     *
     * @return
     */
    public static String nowTimeStr() {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dtf2.format(ldt);
    }
    
    /**
     * 转换为时间（天,时:分:秒.毫秒）
     * @param
     * @return
     */
    public static String formatDateTime(LocalDateTime startTime,LocalDateTime endTime){
        Duration duration=Duration.between(endTime,startTime);
        long day = duration.toDays();
        long hour = duration.toHours();
        long min = duration.toMinutes();
        long s = duration.toMillis();
 
        return (day>0?day+",":"")+hour+":"+min+":"+s/1000+"."+s;
    }

}
