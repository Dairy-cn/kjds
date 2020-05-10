package com.cross.utils;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * 前端传入时间处理工具
 */
public class TimeUtil {

    /**
     * yyyy-MM,yyyy-MM-dd格式化为yyyy-MM-dd
     */
    public static Map<String,String> toStandardDate(String startDate,String endDate){
        Map<String,String> map = new HashMap<>();
        //yyyy-MM格式
        if(startDate.length()==7&&endDate.length()==7){
            YearMonth startMonth = YearMonth.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM"));
            YearMonth endMonth = YearMonth.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM"));
            LocalDate start = LocalDate.of(startMonth.getYear(), startMonth.getMonth(), 1);
            LocalDate end = endMonth.atEndOfMonth();
            map.put("start",start.toString());
            map.put("end",end.toString());
        }else if(startDate.length()==10&&endDate.length()==10){
            map.put("start",startDate);
            map.put("end",endDate);
        }
        return map;
    }
}
