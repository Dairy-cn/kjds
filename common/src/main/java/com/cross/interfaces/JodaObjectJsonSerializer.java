package com.cross.interfaces;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.time.DateTime;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

/*************************************************************
 * Description: 
 * Author: Dair
 * CreateTime: 2020/1/9
 * Copyright © 成都通吃岛信息技术有限公司 All right reserved
 ************************************************************/
public class JodaObjectJsonSerializer extends JsonSerializer<Object> {
    
    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value instanceof Instant) {
            Date tmpDate = Date.from((Instant) value);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            String str = formatter.format(tmpDate);
            gen.writeString(str);
        } else if (value instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) value;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            String str = formatter.format(localDateTime);
            gen.writeString(str);
        } else if (value instanceof DateTime) {
            DateTime dateTime = (DateTime) value;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String str = formatter.format(dateTime);
            gen.writeString(str);
        }
        
    }
}
