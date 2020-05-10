package com.cross.interfaces;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import java.io.IOException;

/*************************************************************
 * Description: 
 * Author: Dairy
 * CreateTime: 2020/1/9
 * Copyright © 成都通吃岛信息技术有限公司 All right reserved
 ************************************************************/
public  class JodaLocalDateTimeJsonSerializer extends JsonSerializer<LocalDateTime> {
    
    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.toString("yyyy-MM-dd'T'HH:mm:ss"));
    }
}
