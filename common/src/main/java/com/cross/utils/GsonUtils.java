package com.cross.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * gson工具
 *
 * @author yk
 * @since 2019/4/24$ 14:47$
 */
public class GsonUtils<T> {

    private static Gson instance = new Gson();

    private static GsonUtils gsonUtils = new GsonUtils();

    private GsonUtils() {
    }

    public static String toJson(Object object) {
        return instance.toJson(object);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        return instance.fromJson(json, classOfT);
    }

    public static Gson getInstance() {
        return instance;
    }

    public static GsonUtils instance() {
        return gsonUtils;
    }

    public T parseJson(String json) {
        Gson gson = GsonUtil.getInstance();
        Type type = new TypeToken<T>() {
        }.getType();
        return gson.fromJson(json, type);
    }

    public T parseListJson(String json) {
        Gson gson = GsonUtil.getInstance();
        Type type = new TypeToken<T>() {
        }.getType();
        return gson.fromJson(json, type);
    }
}
