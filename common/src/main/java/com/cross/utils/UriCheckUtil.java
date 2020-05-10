package com.cross.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证uri
 *
 * @author yk
 * @since 2019/3/5 15:37
 */
public class UriCheckUtil {
    private UriCheckUtil() {
    }

    /**
     * 验证URL是否合法
     *
     * @param url url
     * @return 是否合法
     */
    public static boolean checkUrlFormat(String url) {
        //String regExp = "[a-zA-z]+://[^s]*";
        String regExp = "(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(url);
        return m.matches();
    }
}
