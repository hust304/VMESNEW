package com.xy.vmes.common.util;

import com.yvan.Numbers;

public class StringUtil {
    /**
     * ','分隔字符串去掉空格
     * 创建人：陈刚
     * 创建时间：2018-07-19
     */
    public static String stringTrimSpace(String str) {
        if (str == null) {return new String();}
        if (str.trim().length() == 0) {return str;}

        StringBuffer strBuf = new StringBuffer();
        String[] strArry = str.split(",");
        for (int i = 0; i < strArry.length; i++) {
            String temp = strArry[i];
            if (temp.trim().length() > 0) {
                strBuf.append(temp.trim());
                strBuf.append(",");
            }
        }

        String strTemp = strBuf.toString();
        if (strTemp.trim().length() > 0 && strTemp.lastIndexOf(",") != -1) {
            strTemp = strTemp.substring(0, strTemp.lastIndexOf(","));
            return strTemp;
        }

        return str;
    }

    public static long char2Number(String str) {
        if (str == null || str.trim().length() == 0) {return -1L;}

        try {
            return Numbers.toNumber(str, Numbers.MAX_RADIX);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1L;
    }

}
