package com.cross.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.Instant;

/*************************************************************
 * Description: 
 * Author: Dairy
 * CreateTime: 2019/12/19

 ************************************************************/
public class InstantJacksonSerializer extends JsonSerializer<Instant> {
    
    @Override
    public void serialize(Instant instant, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(instant.toEpochMilli());
    }
}
