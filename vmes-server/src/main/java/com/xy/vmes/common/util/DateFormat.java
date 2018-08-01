package com.xy.vmes.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    /**缺省日期格式*/
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    /**缺省长日期格式,精确到秒*/
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static Date dateString2Date(String dateStr, String formatStr) {
        if (dateStr == null || dateStr.trim().length() == 0) {return null;}
        if (formatStr == null || formatStr.trim().length() == 0) {return null;}

        java.util.Date date = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat(formatStr);
            date = format.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return date;
    }

    public static String date2String(Date date, String formatStr) {
        if (date == null) {return null;}
        if (formatStr == null || formatStr.trim().length() == 0) {return null;}

        try{
            SimpleDateFormat format = new SimpleDateFormat(formatStr);
            return format.format(date);
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
