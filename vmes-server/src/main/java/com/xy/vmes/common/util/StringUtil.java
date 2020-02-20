package com.xy.vmes.common.util;

import com.yvan.Numbers;
import com.yvan.common.util.Common;

import java.math.BigDecimal;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    /**
     * BigDecimal 类型数据转换-是否需要四舍五入-保留小数位数
     *
     * isScale: 是否需要四舍五入(Y:需要四舍五入(默认值) N:无需四舍五入) is null 需要四舍五入
     * decimalCount: 保留小数位数 (最小:0位 最大:4位) 默认值(小数2位)
     *
     * 例子: 3.567
     * Y:需要四舍五入-保留2位小数 3.57
     * N:无需四舍五入-保留2位小数 3.56
     *
     * @param bigValue
     * @param isScale       (允许为空)是否需要四舍五入(Y:需要四舍五入 N:无需四舍五入)
     * @param decimalCount  (允许为空)保留小数位数
     * @return
     */
    public static BigDecimal scaleDecimal(BigDecimal bigValue, String isScale, Integer decimalCount) {
        if (bigValue == null) {bigValue = BigDecimal.valueOf(0D);}

        // 当(isScale is null 或 isScale is not in (Y,N) )设定 系统设定为需要四舍五入
        if (isScale == null || isScale.trim().length() == 0) {
            isScale = Common.SYS_ISSCALE_TRUE;
        } else if ("Y,N".indexOf(isScale) == -1) {
            isScale = Common.SYS_ISSCALE_TRUE;
        }

        //系统设定默认保留小数位数 默认保留小数2位
        if (decimalCount == null) {
            decimalCount = Integer.valueOf(Common.SYS_NUMBER_FORMAT_2);
        }

        //系统是否需要四舍五入 Y:需要四舍五入 指定小数位
        if (Common.SYS_ISSCALE_TRUE.equals(isScale)) {
            bigValue = bigValue.setScale(decimalCount.intValue(), BigDecimal.ROUND_HALF_UP);

            //系统是否需要四舍五入 N:无需四舍五入 (无四舍五入)指定小数位
        } else if (Common.SYS_ISSCALE_FALSE.equals(isScale)) {
            bigValue = bigValue.setScale(decimalCount.intValue(), BigDecimal.ROUND_DOWN);
        }

        return bigValue;
    }

    /**
     * 检验字符串中是否含有中文
     * @param str  检验字符串
     * @return
     * false: 无中文
     * true:  含有中文
     */
    public static boolean isExistChinese(String str) {
        if (str == null || str.trim().length() == 0) {
            return false;
        }

        char arr[] = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            // 中文字符
            if ((c >= 0x0391 && c <= 0xFFE5)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检验是否是账号字符串
     * 字符串中每一个字符是否满足[a-z,A-Z,_,0-9]
     * @param str  检验字符串
     * @return
     * false: 错误
     * true:  正常
     */
    public static boolean isWord(String str) {
        if (str == null || str.trim().length() == 0) {
            return false;
        }

        char arr[] = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            String regEx = "[\\w]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher("" + c);
            if (!m.matches()) {
                return false;
            }
        }

        return true;
    }

    /**
     * 获取验证码
     * @param length 验证码长度
     * @return
     */
    public static String findSecurityCode(int length) {
        String strTemp = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
        Random r = new Random();

        String code = "";
        for (int i = 0; i < length; i++) {
            code = code + strTemp.charAt(r.nextInt(strTemp.length()));
        }

        return code;
    }

    public static void main(String args[]) throws Exception {
        //String str = "123abc_";
        //boolean flag = StringUtil.isExistChinese(str);

        String str = StringUtil.findSecurityCode(4);
        System.out.println("str:" + str);

    }

}
