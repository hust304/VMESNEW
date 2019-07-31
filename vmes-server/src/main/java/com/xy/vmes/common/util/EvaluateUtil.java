package com.xy.vmes.common.util;

import com.yvan.common.util.Common;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.*;

/**
 * Created by 46368 on 2018/11/14.
 */
public class EvaluateUtil {

    /**
     * 公式计算方法
     * @param parmMap  公式中的参数map
     * @param formula  公式字符串
     * @return
     */
    public static BigDecimal formulaReckon(Map<String, Object> parmMap, String formula) {
        if (parmMap == null || parmMap.size() == 0) {return null;}
        if (formula == null || formula.trim().length() == 0) {return null;}

        Binding binding = new Binding();
        for (Iterator iterator = parmMap.keySet().iterator(); iterator.hasNext();) {
            String mapkey = (String)iterator.next();
            String value = parmMap.get(mapkey).toString();
            binding.setVariable(mapkey, new BigDecimal(value));
        }

        GroovyShell shell = new GroovyShell(binding);
        Object valueObject = shell.evaluate(formula);

        if (valueObject != null) {
            BigDecimal valueBig = new BigDecimal(valueObject.toString());

            //四舍五入到2位小数
            return valueBig.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
        }

        return null;
    }

    /**
     * 计量单位数量-公式转换-计价单位数量
     * @param count    数量(计量单位)
     * @param formula  单位换算公式  P=8*N  N(计量单位数量) P(计价单位数量)
     * @return
     */
    public static BigDecimal countFormulaN2P(BigDecimal count, String formula) {
        if (count == null) {return null;}
        if (formula == null || formula.trim().length() == 0) {return null;}

        Map<String, Object> parmMap = new HashMap<String, Object>();
        parmMap.put("N", count);

        return EvaluateUtil.formulaReckon(parmMap, formula);
    }

    /**
     * 计价单位数量-公式转换-计量单位数量
     * @param count    数量(计价单位)
     * @param formula  单位换算公式  N=8*P  N(计量单位数量) P(计价单位数量)
     * @return
     */
    public static BigDecimal countFormulaP2N(BigDecimal count, String formula) {
        if (count == null) {return null;}
        if (formula == null || formula.trim().length() == 0) {return null;}

        Map<String, Object> parmMap = new HashMap<String, Object>();
        parmMap.put("P", count);

        return EvaluateUtil.formulaReckon(parmMap, formula);
    }

    public static void main(String args[]) throws ParseException {

//        Binding binding = new Binding();
//
//        binding.setVariable("F",2.5);
//        binding.setVariable("T",30);
//        binding.setVariable("A",100);
//        binding.setVariable("P0",100);
//
//        //binding.setVariable("language", "Groovy");
//
//        GroovyShell shell = new GroovyShell(binding);
//
//        Object F1 =shell.evaluate("P1=(1+0.1 * (F/100) * T)*P0");
//
//        //Object F2 =shell.evaluate("P1=P0*(0.055*0.20+1.0011)+A; return P1 ");
//
//        System.out.println(F1.toString());
//        //System.out.println(F2);

//        Map<String, Object> parmMap = new HashMap<String, Object>();
//        //parmMap.put("P", "10");
//
//        parmMap.put("F", "2.5");
//        parmMap.put("T", Integer.valueOf(30));
//        parmMap.put("A", "100");
//        parmMap.put("P0", "100");
//
//        //BigDecimal valueBig = EvaluateUtil.formulaReckon(parmMap, "N=8*P");
//        BigDecimal valueBig = EvaluateUtil.formulaReckon(parmMap, "P1=(1+0.1 * (F/100) * T)*P0");
//
//        System.out.println("valueBig: " + valueBig.toString());

        //2019-07-30 第五个星期二
        //2019-08-01 第一个星期四

        String beginPlanStr = "2019-07-05";
        Date beginPlan = DateFormat.dateString2Date(beginPlanStr, DateFormat.DEFAULT_DATE_FORMAT);
        //System.out.println("timeLong: " + beginPlan.getTime());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginPlan);

//        int temp = calendar.get(Calendar.DAY_OF_WEEK);
//        String tempStr = Common.SYS_DAYOFWEEK_TO_WEEKNAME.get(Integer.valueOf(temp));
//        System.out.println("tempStr: " + tempStr);

//        //当前月第几周
//        int weekInMonth = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
//        //System.out.println("当前月第 " + weekInMonth + " 周");
//        //当前日期星期几
//        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
//
//        String tempStr = "每月{0}个{1}";
//        String sysPeriodTypeName = MessageFormat.format(tempStr,
//                Common.SYS_WEEK_WEEKINMONTH.get(Integer.valueOf(weekInMonth)),
//                Common.SYS_DAYOFWEEK_TO_WEEKNAME.get(Integer.valueOf(dayOfWeek)));
//        System.out.println("sysPeriodTypeName: " + sysPeriodTypeName);

//        String endPlanStr = "2019-07-07";
//        Date endPlan = DateFormat.dateString2Date(endPlanStr, DateFormat.DEFAULT_DATE_FORMAT);
//        int count = DateFormat.getDays(beginPlan, endPlan);
//        //int count = CalendarUtil.getDaysNoAfter(beginPlan, endPlan);
//        System.out.println("count: " + count);


//        String dayOfYearStr = DateFormat.date2String(beginPlan, "MM月dd日");
//        System.out.println("每年" + dayOfYearStr);


        //2019-07-30 第五个星期二
        //2019-08-01 第一个星期四

        //当前月第几周
        //int weekInMonth = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        //System.out.println("当前月第 " + weekInMonth + " 周");
        //当前日期星期几
//        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
//
//        int day1 = DateFormat.findDayByWeekMin(Calendar.TUESDAY);
//        int day2 = DateFormat.findDayByWeekMax(dayOfWeek);
//
//        int addDay = (4-1) * 7 + (day1 + day2 + 1);
//        String newDateStr = DateFormat.getAddDay(beginPlanStr, DateFormat.DEFAULT_DATE, addDay, DateFormat.DEFAULT_DATE_FORMAT);
//        System.out.println("newDateStr:" + newDateStr);

        //int Month = calendar.get(Calendar.MONTH);
        //System.out.println("Month:" + Month);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH );
        System.out.println("year:" + year + " month:" + month + " day:" + day);

//        Date dayOfMonthDate = DateFormat.findLastDayByMonth(year, month, DateFormat.DEFAULT_DATE_FORMAT);
//        String dayStr = DateFormat.date2String(dayOfMonthDate, DateFormat.DEFAULT_DATE_FORMAT);
//        System.out.println("dayStr:" + dayStr);

        calendar.add(Calendar.DATE, 7);
        Date newDate = calendar.getTime();
        String newDateStr = DateFormat.date2String(newDate, DateFormat.DEFAULT_DATE_FORMAT);
        System.out.println("newDateStr:" + newDateStr);
    }
}
