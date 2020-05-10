package com.cross.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*************************************************************
 * Description: 颜色检查Util
 * Author: Dairy
 * CreateTime: 2019/9/24
 ************************************************************/
public class CheckIsColorUtil {
    
    public static boolean checkColor(String color) {
        String type = "^#[0-9a-fA-F]{6}{1}$";
        Pattern p = Pattern.compile(type);
        Matcher m = p.matcher(color);
        
        if (!m.matches()) {
            String types = "^[rR][gG][Bb][\\(]([\\s]*(2[0-4][0-9]|25[0-5]|[01]?[0-9][0-9]?)[\\s]*,){2}[\\s]*(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)[\\s]*[\\)]{1}$";
            Pattern p2 = Pattern.compile(types);
            Matcher m2 = p2.matcher(color);
            if (!m2.matches()) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}
