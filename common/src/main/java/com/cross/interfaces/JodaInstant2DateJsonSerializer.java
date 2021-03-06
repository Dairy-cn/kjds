package com.cross.interfaces;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;


/*************************************************************
 * Description: 
 * Author: Dair
 * CreateTime: 2020/1/9
 ************************************************************/
public class JodaInstant2DateJsonSerializer extends JsonSerializer<Instant> {
    
    @Override
    public void serialize(Instant value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").withZone(ZoneOffset.UTC);
        String str = formatter.format(value);
        gen.writeString(str);
    }
}
