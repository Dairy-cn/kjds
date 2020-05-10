package com.cross.interfaces;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

/*************************************************************
 * Description: 
 * Author: Dair
 * CreateTime: 2020/1/9
 * Copyright © 成都通吃岛信息技术有限公司 All right reserved
 ************************************************************/
public class JodaInstantJsonDeserializer extends JsonDeserializer<Instant> {
    @Override
    public Instant deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        if (p == null) {
            return null;
        }
        //将对应序列化的时间转换为字符串
        String date = p.readValueAs(String.class);
    
        if (StringUtils.isBlank(date)) {
            return null;
        }
        //时间格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date1 = null;
        try {
            date1 = formatter.parse(date);
        } catch (ParseException e) {
//            e.printStackTrace();
        }
        
        if (date1 == null) {
            //时间格式
            formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            try {
                date1 = formatter.parse(date);
            } catch (ParseException e) {
//                e.printStackTrace();
            }
        }
        if (date1 != null) {
            return Instant.ofEpochMilli(date1.getTime());
        }
        return null;
    }
}
