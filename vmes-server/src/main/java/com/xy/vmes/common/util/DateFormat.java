package com.xy.vmes.common.util;

import com.yvan.common.util.Common;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateFormat {
    /**缺省日期格式*/
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    /**缺省长日期格式,精确到秒*/
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DEFAULT_YEAR = "YEAR";
    public static final String DEFAULT_MONTH = "MONTH";
    public static final String DEFAULT_DATE = "DAY";

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

    /**
     * 功能：对于给定的时间增加天数/月数/年数后的日期,按指定格式输出
     *
     * @param date String 要改变的日期
     * @param field int 日期改变的字段，YEAR,MONTH,DAY
     * @param amount int 改变量
     * @param strFormat 日期返回格式
     * @return
     * @throws ParseException
     * @author caohongbin
     */
    public static String getAddDay(String date, String field, int amount, String strFormat) throws ParseException {
        //当前日期和前一天
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(strFormat);

        Calendar rightNow = Calendar.getInstance();
        Date tempdate = dateFormat.parse(date);
        rightNow.setTime(tempdate);

        int intField = 0;
        String tmpField = field.toUpperCase();

        intField = Calendar.DATE;
        if (tmpField.equals(DEFAULT_YEAR)) {
            intField = Calendar.YEAR;
        } else if (tmpField.equals(DEFAULT_MONTH)) {
            intField = Calendar.MONTH;
        } else if (tmpField.equals(DEFAULT_DATE)) {
            intField = Calendar.DATE;
        }

        rightNow.add(intField, amount);
        String day = dateFormat.format(rightNow.getTime());
        return day;
    }

    //获得两个时间之间的天数,考虑隔年的情况
    public static int getDays(Date fDate, Date oDate) {
        Calendar d1 = Calendar.getInstance();
        Calendar d2 = Calendar.getInstance();
        d1.setTime(fDate);
        d2.setTime(oDate);

        if (d1.after(d2)) {
            java.util.Calendar swap = d1;
            d1 = d2;
            d2 = swap;
        }
        int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
        int y2 = d2.get(Calendar.YEAR);
        if (d1.get(Calendar.YEAR) != y2) {
            d1 = (Calendar) d1.clone();
            do {
                days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);
                d1.add(java.util.Calendar.YEAR, 1);
            } while (d1.get(java.util.Calendar.YEAR) != y2);
        }
        return days;
    }

    /**
     * 获取两个日期的差值(secondDate - firstDate)
     * @param firstDate
     * @param secondDate
     * @return
     */
    public static int findDayOfYear (Date firstDate, Date secondDate) {
        Calendar firstCalendar = Calendar.getInstance();
        firstCalendar.setTime(firstDate);

        Calendar secondCalendar = Calendar.getInstance();
        secondCalendar.setTime(secondDate);

        int days = secondCalendar.get(Calendar.DAY_OF_YEAR) - firstCalendar.get(Calendar.DAY_OF_YEAR);
        return days;
    }

    public static int findDayByWeekMin(int dayOfWeek) {
        int toWeekMin = 0;
        List<Integer> dayList = Common.SYS_DAYOFWEEK_LIST;
        if (dayList == null || dayList.size() == 0) {return toWeekMin;}

        for (Integer intObject : dayList) {
            if (intObject != null && intObject.intValue() == dayOfWeek) {
                toWeekMin = dayList.indexOf(intObject);
            }
        }

        return toWeekMin;
    }

    public static int findDayByWeekMax(int dayOfWeek) {
        int toWeekMax = 0;
        List<Integer> dayList = Common.SYS_DAYOFWEEK_LIST;
        if (dayList == null || dayList.size() == 0) {return toWeekMax;}

        int index = DateFormat.findDayByWeekMin(dayOfWeek);
        int indexMax = dayList.size() - 1;

        toWeekMax = indexMax - index;
        return toWeekMax;
    }

    /**
     * 计算给定月最后一天
     *
     * @param year       年份
     * @param month      自然月份 取值范围[1,12] (注意jdk JANUARY:一月:0)
     * @param strFormat  日期格式
     * @return
     */
    public static Date findLastDayByMonth(int year, int month, String strFormat) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month-1, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DATE,-1);

        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
            date = sdf.parse(sdf.format(calendar.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }



    /**
     * 获取当前年月日
     * @return yyyy-MM-dd
     */
    public static String getCurrentYearMonthDay() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentYearMonthDay = sdf.format(new Date());
        return currentYearMonthDay;
    }


    /**
     * 获取给定年月的下一个年月日
     * @param yearMonthDay      yyyy-MM-dd
     * @return yyyy-MM
     */
    public static String getNextYearMonthDay(String yearMonthDay) {
        String yearStr = yearMonthDay.substring(0,4);
        String monthStr = yearMonthDay.substring(5,7);
        String dayStr = yearMonthDay.substring(8,10);
        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);
        int day = Integer.parseInt(dayStr);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month-1, day);
        calendar.add(Calendar.DATE, 1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nextYearMonthDay = sdf.format(calendar.getTime());

        return nextYearMonthDay;
    }


    /**
     * 获取给定年月的上一个年月日
     * @param yearMonthDay      yyyy-MM-dd
     * @return yyyy-MM
     */
    public static String getLastYearMonthDay(String yearMonthDay) {
        String yearStr = yearMonthDay.substring(0,4);
        String monthStr = yearMonthDay.substring(5,7);
        String dayStr = yearMonthDay.substring(8,10);
        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);
        int day = Integer.parseInt(dayStr);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month-1, day);
        calendar.add(Calendar.DATE, -1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastYearMonthDay = sdf.format(calendar.getTime());

        return lastYearMonthDay;
    }


    /**
     * 获取给定年月日的上一个月相同的年月日
     * @param yearMonthDay      yyyy-MM-dd
     * @return yyyy-MM
     */
    public static String getLastMonthSameDay(String yearMonthDay) {
        String yearStr = yearMonthDay.substring(0,4);
        String monthStr = yearMonthDay.substring(5,7);
        String dayStr = yearMonthDay.substring(8,10);
        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);
        int day = Integer.parseInt(dayStr);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month-1, day);
        calendar.add(Calendar.MONTH, -1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastMonthSameDay = sdf.format(calendar.getTime());

        return lastMonthSameDay;
    }



    /**
     * 获取给定年月的上一个年月
     * @param yearMonth      yyyy-MM
     * @return yyyy-MM
     */
    public static String getLastYearMonth(String yearMonth) {
        String yearStr = yearMonth.substring(0,4);
        String monthStr = yearMonth.substring(5,7);
        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month-1, 1);
        calendar.add(Calendar.MONTH, -1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String lastYearMonth = sdf.format(calendar.getTime());

        return lastYearMonth;
    }





    /**
     * 获取给定年月的下一个年月
     * @param yearMonth      yyyy-MM
     * @return yyyy-MM
     */
    public static String getNextYearMonth(String yearMonth) {
        String yearStr = yearMonth.substring(0,4);
        String monthStr = yearMonth.substring(5,7);
        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month-1, 1);
        calendar.add(Calendar.MONTH, 1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String nextYearMonth = sdf.format(calendar.getTime());

        return nextYearMonth;
    }


    /**
     * 获取当前年月
     * @return yyyy-MM
     */
    public static String getCurrentYearMonth() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String currentYearMonth = sdf.format(new Date());
        return currentYearMonth;
    }


    /**
     * 获取当前年月的同比年月
     * @param yearMonth      yyyy-MM
     * @return yyyy-MM
     */
    public static String getStartYearMonth_YearOnYear(String yearMonth) {
        String yearStr = yearMonth.substring(0,4);
        String monthStr = yearMonth.substring(5,7);
        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month-1, 1);
        calendar.add(Calendar.YEAR, -1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String startYearMonth_YearOnYear = sdf.format(calendar.getTime());
        return startYearMonth_YearOnYear;
    }

    /**
     * 获取当前年月的同比年月
     * @param yearMonth      yyyy-MM
     * @return yyyy-MM
     */
    public static String getEndYearMonth_YearOnYear(String yearMonth) {
        String yearStr = yearMonth.substring(0,4);
        String monthStr = yearMonth.substring(5,7);
        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month-1, 1);
        calendar.add(Calendar.YEAR, -1);
        calendar.add(Calendar.MONTH, 1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String endYearMonth_YearOnYear = sdf.format(calendar.getTime());
        return endYearMonth_YearOnYear;
    }

    /**
     * 获取当前年
     * @return yyyy
     */
    public static String getCurrentYear() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String currentYearMonth = sdf.format(new Date());
        return currentYearMonth;
    }

    /**
     * 获取给定年的下一个年
     * @param year     yyyy
     * @return yyyy
     */
    public static String getNextYear(String year) {
        int nextYear = Integer.parseInt(year)+1;
        return nextYear+"";
    }


    /**
     * 获取给定年的上一个年
     * @param year     yyyy
     * @return yyyy
     */
    public static String getLastYear(String year) {
        int lastYear = Integer.parseInt(year)-1;
        return lastYear+"";
    }

    /**
     * 获取给定年的下一个年
     * @param year     yyyy
     * @return yyyy
     */
    public static String getLastTenYear(String year) {
        int nextYear = Integer.parseInt(year)-10;
        return nextYear+"";
    }


    /**
     * 获取期间内的所有年月
     * @param startYearMonth      yyyy-MM
     * @param endYearMonth      yyyy-MM
     * @return yyyy-MM
     */
    public static List<String> getAllYearMonth(String startYearMonth, String endYearMonth) throws Exception {
        return getAllYearMonthDay(startYearMonth,endYearMonth,"yyyy-MM");
    }

    /**
     * 获取期间内的所有年月
     * @param startYear      yyyy
     * @param endYear     yyyy
     * @return yyyy-MM
     */
    public static List<String> getAllYear(String startYear, String endYear) throws Exception {
        return getAllYearMonthDay(startYear,endYear,"yyyy");
    }

    /**
     * 获取期间内的所有年月日
     * @param startYearMonthDay      yyyy-MM-dd
     * @param endYearMonthDay      yyyy-MM-dd
     * @return yyyy-MM
     */
    public static List<String> getAllYearMonthDay(String startYearMonthDay, String endYearMonthDay) throws Exception {
        return getAllYearMonthDay(startYearMonthDay,endYearMonthDay,"yyyy-MM-dd");
    }

    /**
     * 获取期间内的所有年月日
     * @param startDate      yyyy-MM-dd
     * @param endDate      yyyy-MM-dd
     * @return yyyy-MM
     */
    public static List<String> getAllYearMonthDay(String startDate, String endDate,String format) throws Exception {
        int calendarType = Calendar.MONTH;
        if("yyyy-MM-dd".equals(format)){
            calendarType = Calendar.DATE;
        }else if("yyyy".equals(format)){
            calendarType = Calendar.YEAR;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        List<String> retrunList = new ArrayList<String>();
        Date start = sdf.parse(startDate);
        Date end = sdf.parse(endDate);
        Date elem = start;
        while (elem.before(end)){
            retrunList.add(sdf.format(elem));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(elem);
            calendar.add(calendarType, 1);
            elem = calendar.getTime();
        }

        return retrunList;
    }



    public static void main(String args[]) throws Exception {
//        //Date date = DateFormat.dateString2Date("201902", "yyyyMM");
//
//        String dateStr = DateFormat.getAddDay("201901", DateFormat.DEFAULT_MONTH, -1, "yyyyMM");
//
//        //String dateStr = date2String(date, "yyyy-MM-dd");
//        System.out.println("dateStr: " + dateStr);

        /////////////////////////////////////////////////////////////////////////////
//        String day_1 = "2020-03-10";
//        Date day_1_Date = DateFormat.dateString2Date(day_1, DateFormat.DEFAULT_DATE_FORMAT);
//
//        String day_2 = "2020-03-12";
//        Date day_2_Date = DateFormat.dateString2Date(day_2, DateFormat.DEFAULT_DATE_FORMAT);
//
//        int days = DateFormat.findDayOfYear(day_2_Date , day_1_Date);

//        String yearStr = "2020-04".substring(0,4);
//        String monthStr = "2020-04".substring(5,7);
//        System.out.println("yearStr: " + yearStr);
//        System.out.println("monthStr: " + monthStr);
//        String currentYearMonth = getCurrentYearMonth();
//        currentYearMonth = "2020-12";
//        System.out.println("currentYearMonth: " + currentYearMonth);
//        String nextYearMonth = getNextYearMonth(currentYearMonth);
//        System.out.println("nextYearMonth: " + nextYearMonth);
//        String lastYearMonth = getLastYearMonth(currentYearMonth);
//        System.out.println("lastYearMonth: " + lastYearMonth);
//
//        String startYearMonth_YearOnYear = getStartYearMonth_YearOnYear(currentYearMonth);
//        System.out.println("startYearMonth_YearOnYear: " + startYearMonth_YearOnYear);
//        String endYearMonth_YearOnYear = getEndYearMonth_YearOnYear(currentYearMonth);
//        System.out.println("endYearMonth_YearOnYear: " + endYearMonth_YearOnYear);
//        List<String> allYearMonthList = getAllYearMonthDay("2010","2020","yyyy");
//        for(String ele : allYearMonthList){
//            System.out.println(ele);
//        }

//        List<String> allYearList = getAllYear("2010","2020");
//        for(String ele : allYearList){
//            System.out.println(ele);
//        }
//
//        List<String> allYearMonthList = getAllYearMonth("2019-01","2020-05");
//        for(String ele : allYearMonthList){
//            System.out.println(ele);
//        }
//
//        List<String> allYearMonthDayList = getAllYearMonthDay("2020-01-01","2020-03-01");
//        for(String ele : allYearMonthDayList){
//            System.out.println(ele);
//        }



//        String currentYearMonth = DateFormat.getCurrentYearMonth();
//        String startYearMonth_YearOnYear = DateFormat.getStartYearMonth_YearOnYear(currentYearMonth);
//        List<String> yearMonthList = DateFormat.getAllYearMonth(startYearMonth_YearOnYear,currentYearMonth);
//        List<String> yearMonthListNew = new ArrayList();
//        String periods = null;
//        if(yearMonthList!=null&&yearMonthList.size()>0){
//            for(int i=yearMonthList.size()-1;i>=0;i-- ){
//                String yearMonth = yearMonthList.get(i);
//                yearMonth = yearMonth.replace("-","");
//                yearMonthListNew.add(yearMonth);
//                if(periods==null){
//                    periods = "'" + yearMonth + "'";
//                }else{
//                    periods = periods + ",'" + yearMonth + "'";
//                }
//            }
//
//        }
//
//        for(String ele : yearMonthListNew){
//            System.out.println(ele);
//        }
//
//        System.out.println(periods);

    }
}
