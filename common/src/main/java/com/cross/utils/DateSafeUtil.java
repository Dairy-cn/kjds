package com.cross.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author maxiaolin
 * @date 2019/12/4
 */
public class DateSafeUtil {

    private static final String date_format = "yyyy-MM-dd HH:mm:ss";

    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>();

    public static DateFormat getDateFormat() {

        DateFormat df = threadLocal.get();

        if (df == null) {

            df = new SimpleDateFormat(date_format);

            threadLocal.set(df);

        }

        return df;

    }

    public static String formatDate(Date date) {

        return getDateFormat().format(date);

    }

    public static Date parse(String strDate) {
        try {
            return getDateFormat().parse(strDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Date();
    }

}
