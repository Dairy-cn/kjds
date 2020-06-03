package com.cross.interfaces;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

/*************************************************************
 * Description: 
 * Author: Dairy
 * CreateTime: 2020/1/9

 ************************************************************/
public class JodaLocalDateTimeJsonDeserializer extends JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String date=p.readValueAs(String.class); //将对应序列化的时间转换为字符串
        DateTimeFormatter formatter= DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss"); //时间格式
        return LocalDateTime.parse(date,formatter);
    }
}
