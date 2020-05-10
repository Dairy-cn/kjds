package com.cross.interfaces;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用该序列化器之前，相应枚举必须先实现BaseEnum接口（@JsonSerialize(using = JsonEnumSerializer.class)）
 * 给前端返回code，msg和name的枚举对象
 */
public class JsonEnumSerializer extends JsonSerializer<BaseEnum> {
    @Override
    public void serialize(BaseEnum baseEnum, JsonGenerator jsonGenerator, SerializerProvider serializerProvider){
        try{
            String name = baseEnum.getName();
            Object code = baseEnum.getCode();
            String msg = baseEnum.getMsg();

            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("name", name);
            jsonMap.put("code", code);
            jsonMap.put("msg", msg);

            serializerProvider.defaultSerializeValue(jsonMap,jsonGenerator);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
