package com.cross.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;

/*************************************************************
 * Description: 
 * Author: Dairy
 * CreateTime: 2019/12/19
 * Copyright © 成都通吃岛信息技术有限公司 All right reserved
 ************************************************************/
public class InstantJacksonDeserialize extends JsonDeserializer<Instant> {
    @Override
    public Instant deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String text = jsonParser.getText();
        Long aLong = Long.valueOf(text);
        Instant res = Instant.ofEpochMilli(aLong);
        return res;
    }
}
