package com.cross.utils;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

/*************************************************************
 * Description: 
 * Author: Dairy
 * CreateTime: 2019/8/8
 ************************************************************/
public class JsonStringCovertUtil {

    public static <T> List<T> jsonStringConvertToList(String string, Class<T[]> cls) {
        Gson gson = new Gson();
        T[] array = gson.fromJson(string, cls);
        return Arrays.asList(array);
    }

}
