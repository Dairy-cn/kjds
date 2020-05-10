package com.cross.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

/**
 * gson工具
 * 建议使用GsonUtils获取Gson实体
 *
 * @author yk
 * @since 2019/4/24$ 14:48$
 */
public final class GsonUtil {

    private static Gson gson = new GsonBuilder().create();

    private static Gson gsonNull = new GsonBuilder().serializeNulls().create();

    private static Gson gsonDisEsca = new GsonBuilder().disableHtmlEscaping().create();

    private GsonUtil() {

    }

    public static Gson getInstance() {
        return gson;
    }

    public static Gson getInstanceSeriNulls() {
        return gsonNull;
    }

    public static Gson getDisEsca() {
        return gsonDisEsca;
    }

    public static String toJson(Object o) {
        return gson.toJson(o);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        return gson.fromJson(json, classOfT);
    }
}
