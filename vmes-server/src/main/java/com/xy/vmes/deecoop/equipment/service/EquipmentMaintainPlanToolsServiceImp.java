package com.xy.vmes.deecoop.equipment.service;

import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.entity.EquipmentMaintainPlan;
import com.xy.vmes.service.EquipmentMaintainPlanToolsService;
import com.yvan.common.util.Common;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 说明：vmes_equipment_maintain_plan:设备保养计划工具实现类
 * 创建人：陈刚
 * 创建时间：2019-07-25
 */
@Service
@Transactional(readOnly = false)
public class EquipmentMaintainPlanToolsServiceImp implements EquipmentMaintainPlanToolsService {

//    private static final Map<String, String> SYS_PERIODTYPE_KEYNAME_MAP = new HashMap<String, String>() {{
//        put("day", "天");
//        put("week", "周");
//        put("month", "月");
//    }};

    /**
     * 调整保养计划对象(周期计划)
     * 本方法按值引用(方法调用后参数对象发生改变)
     *
     * @param planObject
     */
    public void adjustMaintainPlanByPeriod(EquipmentMaintainPlan planObject) {
        if (planObject == null) {return;}

        //计划开始日期 beginPlan
        Date beginPlan = planObject.getBeginPlan();

        //1. 系统匹配周期 sysPeriodType
        String sysPeriodType = planObject.getSysPeriodType();

        //sysPeriodType (everDay:每天 dayOfWeek:每周星期几 weekOfMonth:每月第几个星期几 dayOfYear:每年某月某日 workDay:工作日[周1-周5] customPeriod:自定义周期)
        //设定 重复类型名称 sysPeriodTypeName
        if ("everDay".equals(sysPeriodType)) {
            //everDay:每天
            planObject.setSysPeriodTypeName("每天");

        } else if ("dayOfWeek".equals(sysPeriodType)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(beginPlan);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            String dayOfWeekStr = Common.SYS_DAYOFWEEK_TO_WEEKNAME.get(Integer.valueOf(dayOfWeek));
            planObject.setSysPeriodTypeName("每周"+dayOfWeekStr);

        } else if ("weekOfMonth".equals(sysPeriodType)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(beginPlan);

            //当前月第几周
            int weekInMonth = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
            //当前日期星期几
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            String tempStr = "每月{0}个{1}";
            String sysPeriodTypeName = MessageFormat.format(tempStr,
                    Common.SYS_WEEK_WEEKINMONTH.get(Integer.valueOf(weekInMonth)),
                    Common.SYS_DAYOFWEEK_TO_WEEKNAME.get(Integer.valueOf(dayOfWeek)));
            planObject.setSysPeriodTypeName(sysPeriodTypeName);
        } else if ("dayOfYear".equals(sysPeriodType)) {
            String dayOfYearStr = DateFormat.date2String(beginPlan, "MM月dd日");
            planObject.setSysPeriodTypeName("每年" + dayOfYearStr);
        } else if ("workDay".equals(sysPeriodType)) {
            //workDay:工作日[周1-周5]
            planObject.setSysPeriodTypeName("工作日[周1-周5]");
        }

        //2. customPeriod:自定义周期
        //每3个月13日
        //每3周星期一
        String tempStr = "每{0}{1}{2}";
        if ("customPeriod".equals(sysPeriodType)) {
            //periodCount 重复频率数字(间隔数字)
            String periodCount = planObject.getPeriodCount().toString();

            //periodType 重复频率类型(day:天 week:周 month:月)
            String periodType = planObject.getPeriodType();
            String periodTypeName = new String();
            if ("week".equals(periodType)) {
                periodTypeName = "周";

                //periodDayofweek 重复时间(周)-(SUNDAY:周日 MONDAY:周1 TUESDAY:周2 WEDNESDAY:周3 THURSDAY:周4 FRIDAY:周5 SATURDAY:周6)
                String periodDayofweek = planObject.getPeriodDayofweek();

                //每3周星期一
                String sysPeriodTypeName = MessageFormat.format(tempStr,
                        periodCount,
                        periodTypeName,
                        Common.SYS_WEEKNAME.get(periodDayofweek));
                planObject.setSysPeriodTypeName(sysPeriodTypeName);

            } else if ("month".equals(periodType)) {
                periodTypeName = "个月";

                //periodDayofmonth 重复时间(月)-(01-31)
                String periodDayofmonth = planObject.getPeriodDayofmonth();

                //每3个月13日
                String sysPeriodTypeName = MessageFormat.format(tempStr,
                        periodCount,
                        periodTypeName,
                        periodDayofmonth + "日");

                planObject.setSysPeriodTypeName(sysPeriodTypeName);
            }
        }
    }

    /**
     * 获取计划周期的起止日期
     * 重复类型(everDay:每天 dayOfWeek:每周星期几 weekOfMonth:每月第几个星期几 dayOfYear:每年某月某日 workDay:工作日[周1-周5] customPeriod:自定义周期)
     *
     * @param nowDate 系统当前时间
     * @param plan    设备保养计划对象(周期计划)
     *
     * 返回值参数说明
     * Map<重复类型Key, 周期起止日期时间Map>
     * 重复类型Key:
     *   everDay:每天
     *   dayOfWeek:每周星期几
     *   weekOfMonth:每月第几个星期几
     *   dayOfYear:每年某月某日
     *   workDay:工作日[周1-周5]
     *   customPeriod:自定义周期
     *
     *  周期起止日期时间Map:
     *  Map<String, Date>>
     *      beginDateTime: 周期起始日期时间(yyyy-MM-dd HH:mm:ss)
     *      endDateTime:   周期结束日期时间(yyyy-MM-dd HH:mm:ss)
     */
    public Map<String, Map<String, Date>> findPlanPeriod(Date nowDate, EquipmentMaintainPlan plan) {
        Map<String, Map<String, Date>> valueMap = new HashMap<String, Map<String, Date>>();

        if (nowDate == null) {nowDate = new Date();}
        if (plan == null) {return valueMap;}

        //获取当前日期(yyyy-MM-dd)
        String nowDateStr = DateFormat.date2String(nowDate, DateFormat.DEFAULT_DATE_FORMAT);
        nowDate = DateFormat.dateString2Date(nowDateStr, DateFormat.DEFAULT_DATE_FORMAT);

        //beginPlan 计划开始日期
        Date beginPlan = plan.getBeginPlan();
        String beginPlanStr = DateFormat.date2String(beginPlan, DateFormat.DEFAULT_DATE_FORMAT);

        //endPlan 计划结束日期
        Date endPlan = plan.getEndPlan();
        String endPlanStr = DateFormat.date2String(endPlan, DateFormat.DEFAULT_DATE_FORMAT);
        long endPlanLong = DateFormat.dateString2Date(endPlanStr, DateFormat.DEFAULT_DATE_FORMAT).getTime();

        //1. 系统匹配周期 sysPeriodType
        //sysPeriodType (everDay:每天 dayOfWeek:每周星期几 weekOfMonth:每月第几个星期几 dayOfYear:每年某月某日 workDay:工作日[周1-周5] customPeriod:自定义周期)
        String sysPeriodType = plan.getSysPeriodType();
        if ("everDay".equals(sysPeriodType)) {
            Map<String, Date> dateTiemMap = new HashMap<String, Date>();

            String beginTimeStr = nowDateStr + " 00:00:00";
            Date beginDateTime = DateFormat.dateString2Date(beginTimeStr, DateFormat.DEFAULT_DATETIME_FORMAT);
            dateTiemMap.put("beginDateTime", beginDateTime);

            String endTimeStr = nowDateStr + " 23:59:59";
            Date endDateTime = DateFormat.dateString2Date(endTimeStr, DateFormat.DEFAULT_DATETIME_FORMAT);
            dateTiemMap.put("endDateTime", endDateTime);

            valueMap.put("everDay", dateTiemMap);
        } else if ("dayOfWeek".equals(sysPeriodType)) {
            /**
             * 1. (当前日期,计划开始日期)之间的天数
             * 2. (当前日期,计划开始日期)之间的天数与(数字7)--（取整,取余）运算
             *   取整: 当前日期在第几个周期范围内
             * 本周期开始日期: 计划开始日期 + (几个周期) * 7
             * 本周期结束日期: 计划开始日期 + (几个周期) * 7 - 1
             */
            Map<String, Date> dateTiemMap = new HashMap<String, Date>();

            //(当前日期,计划开始日期) 之间的天数
            int beginPlan2nowDateCount  = DateFormat.getDays(beginPlan, nowDate) + 1;
            int day = beginPlan2nowDateCount % 7;

            int week = -1;
            if (day != 0) {
                week = beginPlan2nowDateCount/7;
            } else if (day == 0) {
                week = beginPlan2nowDateCount/7 - 1;
            }

            //获取本周期-开始日期(yyyy-MM-dd)
            int addDayByBegin = week * 7;
            String beginDateStr = beginPlanStr;
            try {
                beginDateStr = DateFormat.getAddDay(beginPlanStr, DateFormat.DEFAULT_DATE, addDayByBegin, DateFormat.DEFAULT_DATE_FORMAT);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String beginTimeStr = beginDateStr + " 00:00:00";
            Date beginDateTime = DateFormat.dateString2Date(beginTimeStr, DateFormat.DEFAULT_DATETIME_FORMAT);
            dateTiemMap.put("beginDateTime", beginDateTime);

            //获取本周期-结束日期(yyyy-MM-dd)
            int addDayByEnd = (week+1) * 7 - 1;
            String endDateStr = endPlanStr;
            try {
                endDateStr = DateFormat.getAddDay(beginPlanStr, DateFormat.DEFAULT_DATE, addDayByEnd, DateFormat.DEFAULT_DATE_FORMAT);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Date endDate = DateFormat.dateString2Date(endDateStr, DateFormat.DEFAULT_DATE_FORMAT);
            long endDateLong = endDate.getTime();

            //本周期结束日期 与 计划结束日期 比较
            if (endDateLong < endPlanLong) {
                String endTimeStr = endDateStr + " 23:59:59";
                Date endDateTime = DateFormat.dateString2Date(endTimeStr, DateFormat.DEFAULT_DATETIME_FORMAT);
                dateTiemMap.put("endDateTime", endDateTime);

            } else if (endDateLong >= endPlanLong) {
                String endTimeStr = endPlanStr + " 23:59:59";
                Date endDateTime = DateFormat.dateString2Date(endTimeStr, DateFormat.DEFAULT_DATETIME_FORMAT);
                dateTiemMap.put("endDateTime", endDateTime);
            }

            valueMap.put("dayOfWeek", dateTiemMap);
        } else if ("weekOfMonth".equals(sysPeriodType)) {
            Map<String, Date> dateTiemMap = this.findWeekOfMonthMap(nowDate, beginPlan);
            if (dateTiemMap != null) {
                valueMap.put("weekOfMonth", dateTiemMap);
            }
        }

        return valueMap;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 获取本周期内的起止日期时间-(weekOfMonth:每月第几个星期几)
     * (计划起始日期)为第一次调用--获取本周期的(起始日期时间, 结束日期时间)
     *     获取本周期起始日期-第几个星期几
     *     获取本周期起始日期-下一个月第一天-第几个星期几
     * 例如:
     *   2019-07-30 第五个星期二
     *   2019-08-01 第一个星期四 (下个月第一天)
     *
     *   本周期起始日期时间:2019-07-30 00:00:00
     *   本周期结束日期时间:2019-08-26 23:59:59
     *
     *   下一周期起始日期:2019-08-27 (2019年08月 第五个星期二)-(2019-08-01) + addDay
     *      公式 = (4-1) * 7 + (day1 + day2 + 1);
     *      公式意义: (2019-08-01 第一个星期四) 向前推到 第四个星期四 [(4-1) * 7]
     *               星期四到本周最后一天 + 星期二到本周第一天 + 1 [day1 + day2 + 1]
     *
     *
     *
     * 本方法为递归调用
     * 递归结束条件: 当前系统时间 <= 本周期结束日期
     *
     *  周期起止日期时间Map:
     *  Map<String, Date>>
     *      beginDateTime: 周期起始日期时间(yyyy-MM-dd HH:mm:ss)
     *      endDateTime:   周期结束日期时间(yyyy-MM-dd HH:mm:ss)
     *
     * @param nowDate    当前系统时间
     * @param beginDate  起始日期
     * @return
     */
    private Map<String, Date> findWeekOfMonthMap(Date nowDate, Date beginDate) {
        String beginDateStr = DateFormat.date2String(beginDate, DateFormat.DEFAULT_DATE_FORMAT);

        //1. 获取本周期起始日期-第几个星期几
        Calendar calendar_1 = Calendar.getInstance();
        calendar_1.setTime(beginDate);

        //当前月第几周
        int weekInMonth_1 = calendar_1.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        //当前日期星期几
        int dayOfWeek_1 = calendar_1.get(Calendar.DAY_OF_WEEK);

        //2. 获取本周期起始日期-本月第一天
        String beginMonthStr = DateFormat.date2String(beginDate, "yyyy-MM") + "-01";
        //获取本周期起始日期-下一个月第一天
        String beginNextMonthStr = beginMonthStr;
        try {
            beginNextMonthStr = DateFormat.getAddDay(beginMonthStr, DateFormat.DEFAULT_MONTH, 1, DateFormat.DEFAULT_DATE_FORMAT);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date beginNextMonthDate = DateFormat.dateString2Date(beginNextMonthStr, DateFormat.DEFAULT_DATE_FORMAT);

        //3. 下一个月第一天-第几个星期几
        Calendar calendar_2 = Calendar.getInstance();
        calendar_2.setTime(beginNextMonthDate);

        //当前月第几周
        int weekInMonth_2 = calendar_2.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        //当前日期星期几
        int dayOfWeek_2 = calendar_2.get(Calendar.DAY_OF_WEEK);

        //4. 获取下一个周期的起始日期
        int addDay = 0;
        if (weekInMonth_1 == 1 && (dayOfWeek_2 <= dayOfWeek_1) ) {
            addDay = dayOfWeek_1 - dayOfWeek_2;
        } else if (weekInMonth_1 > 1) {
            int day1 = DateFormat.findDayByWeekMin(dayOfWeek_1);
            int day2 = DateFormat.findDayByWeekMax(dayOfWeek_2);
            addDay = ((weekInMonth_1 - 1) - weekInMonth_2) * 7 + (day1 + day2 + 1);
        }

        String nextBeginDateStr = beginNextMonthStr;
        try {
            nextBeginDateStr = DateFormat.getAddDay(beginNextMonthStr, DateFormat.DEFAULT_DATE, addDay, DateFormat.DEFAULT_DATE_FORMAT);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date nextBeginDate = DateFormat.dateString2Date(nextBeginDateStr, DateFormat.DEFAULT_DATE_FORMAT);

        String endDateStr = beginNextMonthStr;
        try {
            endDateStr = DateFormat.getAddDay(beginNextMonthStr, DateFormat.DEFAULT_DATE, (addDay-1), DateFormat.DEFAULT_DATE_FORMAT);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date endDate = DateFormat.dateString2Date(endDateStr, DateFormat.DEFAULT_DATE_FORMAT);

        //本周期结束日期 与 当前日期比较
        if (endDate.getTime() >= nowDate.getTime()) {
            Map<String, Date> dateTiemMap = new HashMap<String, Date>();

            String beginTimeStr = beginDateStr + " 00:00:00";
            Date beginDateTime = DateFormat.dateString2Date(beginTimeStr, DateFormat.DEFAULT_DATETIME_FORMAT);
            dateTiemMap.put("beginDateTime", beginDateTime);

            String endTimeStr = endDateStr + " 23:59:59";
            Date endDateTime = DateFormat.dateString2Date(endTimeStr, DateFormat.DEFAULT_DATETIME_FORMAT);
            dateTiemMap.put("endDateTime", endDateTime);

            return dateTiemMap;
        } else if (endDate.getTime() < nowDate.getTime()) {
            return this.findWeekOfMonthMap(nowDate, nextBeginDate);
        }

        return null;
    }



}
