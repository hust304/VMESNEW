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
     *      nextMaintainDate: 下一保养日期(yyyy-MM-dd)
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
        beginPlan = DateFormat.dateString2Date(beginPlanStr, DateFormat.DEFAULT_DATE_FORMAT);

        //endPlan 计划结束日期
        Date endPlan = plan.getEndPlan();
        String endPlanStr = DateFormat.date2String(endPlan, DateFormat.DEFAULT_DATE_FORMAT);
        endPlan = DateFormat.dateString2Date(endPlanStr, DateFormat.DEFAULT_DATE_FORMAT);
        long endPlanLong = endPlan.getTime();

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

            //下一保养日期(yyyy-MM-dd)
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(nowDate);
            calendar.add(Calendar.DATE, 1);
            Date nextDate = calendar.getTime();

            //本周期结束日期 与 计划结束日期 比较
            if (nextDate.getTime() <= endPlanLong) {
                //下一保养日期(yyyy-MM-dd)
                dateTiemMap.put("nextMaintainDate", nextDate);
            }

            valueMap.put("everDay", dateTiemMap);
        } else if ("dayOfWeek".equals(sysPeriodType)) {
            //dayOfWeek:每周星期几
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
            if (endDateLong <= endPlanLong) {
                String endTimeStr = endDateStr + " 23:59:59";
                Date endDateTime = DateFormat.dateString2Date(endTimeStr, DateFormat.DEFAULT_DATETIME_FORMAT);
                dateTiemMap.put("endDateTime", endDateTime);

                //下一保养日期(yyyy-MM-dd)
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(endDate);
                calendar.add(Calendar.DATE, 1);
                dateTiemMap.put("nextMaintainDate", calendar.getTime());

            } else if (endDateLong > endPlanLong) {
                String endTimeStr = endPlanStr + " 23:59:59";
                Date endDateTime = DateFormat.dateString2Date(endTimeStr, DateFormat.DEFAULT_DATETIME_FORMAT);
                dateTiemMap.put("endDateTime", endDateTime);
            }

            valueMap.put("dayOfWeek", dateTiemMap);
        } else if ("weekOfMonth".equals(sysPeriodType)) {
            //weekOfMonth:每月第几个星期几
            Map<String, Date> dateTiemMap = this.findWeekOfMonthMap(nowDate, beginPlan, beginPlan, endPlan);
            if (dateTiemMap != null) {
                valueMap.put("weekOfMonth", dateTiemMap);
            }
        } else if ("dayOfYear".equals(sysPeriodType)) {
            //dayOfYear:每年某月某日
            Map<String, Date> dateTiemMap = this.findDayOfYearMap(nowDate, beginPlan, endPlan);
            if (dateTiemMap != null) {
                valueMap.put("dayOfYear", dateTiemMap);
            }
        } else if ("workDay".equals(sysPeriodType)) {
            //workDay:工作日[周1-周5]
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(nowDate);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            if (dayOfWeek == Integer.valueOf(Calendar.MONDAY)
                || dayOfWeek == Integer.valueOf(Calendar.TUESDAY)
                || dayOfWeek == Integer.valueOf(Calendar.WEDNESDAY)
                || dayOfWeek == Integer.valueOf(Calendar.THURSDAY)
                || dayOfWeek == Integer.valueOf(Calendar.FRIDAY)
            ) {
                Map<String, Date> dateTiemMap = new HashMap<String, Date>();

                String beginTimeStr = nowDateStr + " 00:00:00";
                Date beginDateTime = DateFormat.dateString2Date(beginTimeStr, DateFormat.DEFAULT_DATETIME_FORMAT);
                dateTiemMap.put("beginDateTime", beginDateTime);

                String endTimeStr = nowDateStr + " 23:59:59";
                Date endDateTime = DateFormat.dateString2Date(endTimeStr, DateFormat.DEFAULT_DATETIME_FORMAT);
                dateTiemMap.put("endDateTime", endDateTime);

                //下一保养日期(yyyy-MM-dd)
                if (dayOfWeek == Integer.valueOf(Calendar.MONDAY)
                    || dayOfWeek == Integer.valueOf(Calendar.TUESDAY)
                    || dayOfWeek == Integer.valueOf(Calendar.WEDNESDAY)
                    || dayOfWeek == Integer.valueOf(Calendar.THURSDAY)
                ) {
                    calendar.add(Calendar.DATE, 1);
                    //dateTiemMap.put("nextMaintainDate", calendar.getTime());
                } else if (dayOfWeek == Integer.valueOf(Calendar.FRIDAY)) {
                    calendar.add(Calendar.DATE, 3);
                    //dateTiemMap.put("nextMaintainDate", calendar.getTime());
                }

                //本周期结束日期 与 计划结束日期 比较
                Date nextDate = calendar.getTime();
                if (nextDate.getTime() <= endPlanLong) {
                    //下一保养日期(yyyy-MM-dd)
                    dateTiemMap.put("nextMaintainDate", nextDate);
                }

                valueMap.put("workDay", dateTiemMap);
            } else if (dayOfWeek == Integer.valueOf(Calendar.SATURDAY) || dayOfWeek == Integer.valueOf(Calendar.SUNDAY)) {
                valueMap.put("workDay", null);
            }
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //1. 自定义周期 sysPeriodType
        //sysPeriodType (everDay:每天 dayOfWeek:每周星期几 weekOfMonth:每月第几个星期几 dayOfYear:每年某月某日 workDay:工作日[周1-周5] customPeriod:自定义周期)
        if ("customPeriod".equals(sysPeriodType)) {
            //periodType 重复频率类型(day:天 week:周 month:月)
            String periodType = plan.getPeriodType();

            //periodCount 重复频率数字(间隔数字)
            Integer periodCount = plan.getPeriodCount();

            if ("week".equals(periodType)) {
                //periodDayofweek 重复时间(周)-(SUNDAY:周日 MONDAY:周1 TUESDAY:周2 WEDNESDAY:周3 THURSDAY:周4 FRIDAY:周5 SATURDAY:周6)
                String periodDayofweekStr = plan.getPeriodDayofweek();
                int periodDayofweek = Common.SYS_WEEK_DAYOFWEEK.get(periodDayofweekStr);

                //获取第一个星期几(dayOfWeek) - 计划(起始日期, 结束日期)
                Date firstDate = this.findFirstDateByWeekCustom(periodDayofweek, beginPlan, endPlan);

                Map<String, Date> dateTiemMap = this.findWeekMapByCustom(nowDate, firstDate, endPlan, periodCount.intValue());
                if (dateTiemMap != null) {
                    valueMap.put("customPeriod", dateTiemMap);
                }

            } else if ("month".equals(periodType)) {
                //periodDayofmonth 重复时间(月)-(01-31)
                String periodDayofmonth = plan.getPeriodDayofmonth();
                Date firstDate = findDateByMonthCustom(periodDayofmonth, beginPlan);

                Map<String, Date> dateTiemMap = this.findMonthMapByCustom(nowDate, firstDate, endPlan, periodCount.intValue(), periodDayofmonth);
                if (dateTiemMap != null) {
                    valueMap.put("customPeriod", dateTiemMap);
                }
            }
        }

        return valueMap;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 获取第一个星期几(dayOfWeek) - 计划(起始日期, 结束日期)
     * @param dayOfWeek  一个星期中的某天
     * @param beginPlan  计划起始日期
     * @param endPlan    计划结束日期
     * @return
     */
    private Date findFirstDateByWeekCustom(int dayOfWeek, Date beginPlan, Date endPlan) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginPlan);

        Date valueDate = beginPlan;
        //获取(起始日期, 结束日期) 之间的天数
        int days = DateFormat.getDays(beginPlan, endPlan);
        for (int i = 0; i <= days; i++) {
            calendar.add(Calendar.DATE, i);
            if (dayOfWeek == calendar.get(Calendar.DAY_OF_WEEK)) {
                valueDate = calendar.getTime();
                break;
            }
        }

        return valueDate;
    }

    /**
     * 获取日期(一个月中的某天,给定的日期)
     * 闰2月 大月31天 小月30天
     *
     * @param dayOfMonthStr 一个月中的某天
     * @param date          给定的日期
     * @return
     */
    private Date findDateByMonthCustom(String dayOfMonthStr, Date date) {
        int dayOfMonth = Integer.valueOf(dayOfMonthStr).intValue();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR);
        //自然月份 取值范围[1,12] (注意jdk JANUARY:一月:0)
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        //获取当前自然月的最后一天
        //处理(闰2月,大月31天,小月30天)
        Date dateTemp = DateFormat.findLastDayByMonth(year, month, DateFormat.DEFAULT_DATE_FORMAT);
        calendar.setTime(dateTemp);
        int maxDay = calendar.get(Calendar.DAY_OF_MONTH);
        if (dayOfMonth <= maxDay) {
            day = dayOfMonth;
        } else if (dayOfMonth > maxDay) {
            day = maxDay;
        }

        calendar.set(year, month, day);
        return calendar.getTime();
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
     * 本方法为递归调用
     * 递归结束条件: 当前系统时间 <= 本周期结束日期
     *
     *  周期起止日期时间Map:
     *  Map<String, Date>>
     *      beginDateTime: 周期起始日期时间(yyyy-MM-dd HH:mm:ss)
     *      endDateTime:   周期结束日期时间(yyyy-MM-dd HH:mm:ss)
     *      nextMaintainDate: 下一保养日期(yyyy-MM-dd)
     *
     * @param nowDate    当前系统时间
     * @param beginDate  起始日期
     * @param beginPlan  计划开始日期
     * @param endPlan    计划结束日期
     * @return
     */
    private Map<String, Date> findWeekOfMonthMap(Date nowDate, Date beginDate, Date beginPlan, Date endPlan) {
        Calendar calendar = Calendar.getInstance();

        //计划开始日期-第几个星期几
        calendar.setTime(beginPlan);
        //计划开始日期-当前月第几周
        int beginPlan_weekInMonth = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        //计划开始日期-当前日期星期几
        int beginPlan_dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        //本次调用-起始日期-当前月的第一天
        calendar.setTime(beginDate);
        int beginYear = calendar.get(Calendar.YEAR);
        //自然月份 取值范围[1,12] (注意jdk JANUARY:一月:0)
        int beginMonth = calendar.get(Calendar.MONTH) + 1;
        calendar.set(beginYear, (beginMonth-1), 1);
        Date beginMonthFirstDay = calendar.getTime();

        //本次调用-起始日期-下一个月第一天
        calendar.setTime(beginMonthFirstDay);
        calendar.add(Calendar.MONTH, 1);
        Date beginNextMonthDate = calendar.getTime();

        //下一个月第一天-第几个星期几
        calendar.setTime(beginNextMonthDate);
        //当前月第几周
        int nextMonthFirstDay_weekInMonth = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        //当前日期星期几
        int nextMonthFirstDay_dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        //自然月份 取值范围[1,12] (注意jdk JANUARY:一月:0)
        int nextMonth = calendar.get(Calendar.MONTH) + 1;

        //4. 获取下一个周期的起始日期
        int addDay = 0;
        if (beginPlan_weekInMonth == 1 && (nextMonthFirstDay_dayOfWeek <= beginPlan_weekInMonth) ) {
            addDay = beginPlan_dayOfWeek - nextMonthFirstDay_dayOfWeek;
        } else if (beginPlan_weekInMonth > 1) {
            int day1 = DateFormat.findDayByWeekMin(beginPlan_dayOfWeek);
            int day2 = DateFormat.findDayByWeekMax(nextMonthFirstDay_dayOfWeek);
            addDay = ((beginPlan_weekInMonth - 1) - nextMonthFirstDay_weekInMonth) * 7 + (day1 + day2 + 1);

            calendar.add(Calendar.DATE, addDay);
            //自然月份 取值范围[1,12] (注意jdk JANUARY:一月:0)
            int nextPeriodMonth = calendar.get(Calendar.MONTH) + 1;

            if (nextMonth < nextPeriodMonth) {
                addDay = ((beginPlan_weekInMonth - 1) - nextMonthFirstDay_weekInMonth - 1) * 7 + (day1 + day2 + 1);
            }
        }

        //下一个月第一天
        calendar.setTime(beginNextMonthDate);
        calendar.add(Calendar.DATE, addDay);
        Date nextBeginDate = calendar.getTime();

        calendar.setTime(beginNextMonthDate);
        calendar.add(Calendar.DATE, (addDay-1));
        Date endDate = calendar.getTime();
        String endDateStr = DateFormat.date2String(endDate, DateFormat.DEFAULT_DATE_FORMAT);

        String beginDateStr = DateFormat.date2String(beginDate, DateFormat.DEFAULT_DATE_FORMAT);
        String endPlanStr = DateFormat.date2String(endPlan, DateFormat.DEFAULT_DATE_FORMAT);

        //本周期结束日期 与 当前日期比较
        if (endDate.getTime() >= nowDate.getTime()) {
            Map<String, Date> dateTiemMap = new HashMap<String, Date>();

            String beginTimeStr = beginDateStr + " 00:00:00";
            Date beginDateTime = DateFormat.dateString2Date(beginTimeStr, DateFormat.DEFAULT_DATETIME_FORMAT);
            dateTiemMap.put("beginDateTime", beginDateTime);

            if (endDate.getTime() <= endPlan.getTime()) {
                String endTimeStr = endDateStr + " 23:59:59";
                Date endDateTime = DateFormat.dateString2Date(endTimeStr, DateFormat.DEFAULT_DATETIME_FORMAT);
                dateTiemMap.put("endDateTime", endDateTime);

                //下一保养日期(yyyy-MM-dd)
                calendar.setTime(endDate);
                calendar.add(Calendar.DATE, 1);
                dateTiemMap.put("nextMaintainDate", calendar.getTime());

            } else if (endDate.getTime() > endPlan.getTime()) {
                String endTimeStr = endPlanStr + " 23:59:59";
                Date endDateTime = DateFormat.dateString2Date(endTimeStr, DateFormat.DEFAULT_DATETIME_FORMAT);
                dateTiemMap.put("endDateTime", endDateTime);
            }

            return dateTiemMap;
        } else if (endDate.getTime() < nowDate.getTime()) {
            return this.findWeekOfMonthMap(nowDate, nextBeginDate, beginPlan, endPlan);
        }

        return null;
    }

    /**
     * 获取本周期内的起止日期时间-(dayOfYear:每年某月某日)
     * (计划起始日期)为第一次调用--获取本周期的(起始日期时间, 结束日期时间)
     *
     * 本方法为递归调用
     * 递归结束条件: 当前系统时间 <= 本周期结束日期
     *
     *  周期起止日期时间Map:
     *  Map<String, Date>>
     *      beginDateTime: 周期起始日期时间(yyyy-MM-dd HH:mm:ss)
     *      endDateTime:   周期结束日期时间(yyyy-MM-dd HH:mm:ss)
     *      nextMaintainDate: 下一保养日期(yyyy-MM-dd)
     *
     * @param nowDate    当前系统时间
     * @param beginDate  起始日期
     * @param endPlan    计划结束日期
     * @return
     */
    private Map<String, Date> findDayOfYearMap(Date nowDate, Date beginDate, Date endPlan) {
        String beginDateStr = DateFormat.date2String(beginDate, DateFormat.DEFAULT_DATE_FORMAT);
        String endPlanStr = DateFormat.date2String(endPlan, DateFormat.DEFAULT_DATE_FORMAT);

        //获取本周期起始日期 (计划开始日期)
        Calendar calendar_1 = Calendar.getInstance();
        calendar_1.setTime(beginDate);

        int year = calendar_1.get(Calendar.YEAR);
        //自然月份 取值范围[1,12] (注意jdk JANUARY:一月:0)
        int month = calendar_1.get(Calendar.MONTH) + 1;
        int day = calendar_1.get(Calendar.DAY_OF_MONTH);

        //获取下一个周期的起始日期
        Calendar calendar_2 = Calendar.getInstance();
        int nextYear = year + 1;
        //自然月份 取值范围[1,12] (注意jdk JANUARY:一月:0)
        int nextMonth = month;
        int nextDay = 1;

        //处理(闰2月,大月31天,小月30天)
        Date dateTemp = DateFormat.findLastDayByMonth(nextYear, nextMonth, DateFormat.DEFAULT_DATE_FORMAT);
        calendar_2.setTime(dateTemp);
        int maxDay = calendar_2.get(Calendar.DAY_OF_MONTH);
        if (day <= maxDay) {
            nextDay = day;
        } else if (day > maxDay) {
            nextDay = maxDay;
        }

        //自然月份 取值范围[1,12] (注意jdk JANUARY:一月:0)
        calendar_2.set(nextYear, (nextMonth-1), nextDay);
        Date nextBeginDate = calendar_2.getTime();

        //自然月份 取值范围[1,12] (注意jdk JANUARY:一月:0)
        calendar_2.set(nextYear, (nextMonth-1), (nextDay-1));
        Date endDate = calendar_2.getTime();
        String endDateStr = DateFormat.date2String(endDate, DateFormat.DEFAULT_DATE_FORMAT);

        //本周期结束日期 与 当前日期比较
        if (endDate.getTime() >= nowDate.getTime()) {
            Map<String, Date> dateTiemMap = new HashMap<String, Date>();

            String beginTimeStr = beginDateStr + " 00:00:00";
            Date beginDateTime = DateFormat.dateString2Date(beginTimeStr, DateFormat.DEFAULT_DATETIME_FORMAT);
            dateTiemMap.put("beginDateTime", beginDateTime);

            if (endDate.getTime() <= endPlan.getTime()) {
                String endTimeStr = endDateStr + " 23:59:59";
                Date endDateTime = DateFormat.dateString2Date(endTimeStr, DateFormat.DEFAULT_DATETIME_FORMAT);
                dateTiemMap.put("endDateTime", endDateTime);

                //下一保养日期(yyyy-MM-dd)
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(endDate);
                calendar.add(Calendar.DATE, 1);
                dateTiemMap.put("nextMaintainDate", calendar.getTime());
            } else if (endDate.getTime() > endPlan.getTime()) {
                String endTimeStr = endPlanStr + " 23:59:59";
                Date endDateTime = DateFormat.dateString2Date(endTimeStr, DateFormat.DEFAULT_DATETIME_FORMAT);
                dateTiemMap.put("endDateTime", endDateTime);
            }

            return dateTiemMap;
        } else if (endDate.getTime() < nowDate.getTime()) {
            return this.findDayOfYearMap(nowDate, nextBeginDate, endPlan);
        }

        return null;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 获取本周期内的起止日期时间-(week 自定义周期)
     * (计划起始日期)为第一次调用--获取本周期的(起始日期时间, 结束日期时间)
     *
     * 本方法为递归调用
     * 递归结束条件: 当前系统时间 <= 本周期结束日期
     *
     *  周期起止日期时间Map:
     *  Map<String, Date>>
     *      beginDateTime: 周期起始日期时间(yyyy-MM-dd HH:mm:ss)
     *      endDateTime:   周期结束日期时间(yyyy-MM-dd HH:mm:ss)
     *      nextMaintainDate: 下一保养日期(yyyy-MM-dd)
     *
     * @param nowDate    当前系统时间
     * @param beginDate  起始日期
     * @param endPlan    计划结束日期
     * @param spaceCount 间隔周数
     * @return
     */
    private Map<String, Date> findWeekMapByCustom(Date nowDate, Date beginDate, Date endPlan, int spaceCount) {
        String beginDateStr = DateFormat.date2String(beginDate, DateFormat.DEFAULT_DATE_FORMAT);
        String endPlanStr = DateFormat.date2String(endPlan, DateFormat.DEFAULT_DATE_FORMAT);

        Calendar calendar_2 = Calendar.getInstance();
        calendar_2.setTime(beginDate);

        //获取下一个周期的起始日期
        int addDay = spaceCount * 7;
        calendar_2.add(Calendar.DATE, addDay);
        Date nextBeginDate = calendar_2.getTime();

        calendar_2.add(Calendar.DATE, -1);
        Date endDate = calendar_2.getTime();
        String endDateStr = DateFormat.date2String(endDate, DateFormat.DEFAULT_DATE_FORMAT);

        //本周期结束日期 与 当前日期比较
        if (endDate.getTime() >= nowDate.getTime()) {
            Map<String, Date> dateTiemMap = new HashMap<String, Date>();

            String beginTimeStr = beginDateStr + " 00:00:00";
            Date beginDateTime = DateFormat.dateString2Date(beginTimeStr, DateFormat.DEFAULT_DATETIME_FORMAT);
            dateTiemMap.put("beginDateTime", beginDateTime);

            if (endDate.getTime() <= endPlan.getTime()) {
                String endTimeStr = endDateStr + " 23:59:59";
                Date endDateTime = DateFormat.dateString2Date(endTimeStr, DateFormat.DEFAULT_DATETIME_FORMAT);
                dateTiemMap.put("endDateTime", endDateTime);

                //下一保养日期(yyyy-MM-dd)
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(endDate);
                calendar.add(Calendar.DATE, 1);
                dateTiemMap.put("nextMaintainDate", calendar.getTime());
            } else if (endDate.getTime() > endPlan.getTime()) {
                String endTimeStr = endPlanStr + " 23:59:59";
                Date endDateTime = DateFormat.dateString2Date(endTimeStr, DateFormat.DEFAULT_DATETIME_FORMAT);
                dateTiemMap.put("endDateTime", endDateTime);
            }

            return dateTiemMap;
        } else if (endDate.getTime() < nowDate.getTime()) {
            return this.findWeekMapByCustom(nowDate, nextBeginDate, endPlan, spaceCount);
        }

        return null;
    }

    /**
     * 获取本周期内的起止日期时间-(month 自定义周期)
     * (计划起始日期)为第一次调用--获取本周期的(起始日期时间, 结束日期时间)
     *
     * 本方法为递归调用
     * 递归结束条件: 当前系统时间 <= 本周期结束日期
     *
     *  周期起止日期时间Map:
     *  Map<String, Date>>
     *      beginDateTime: 周期起始日期时间(yyyy-MM-dd HH:mm:ss)
     *      endDateTime:   周期结束日期时间(yyyy-MM-dd HH:mm:ss)
     *      nextMaintainDate: 下一保养日期(yyyy-MM-dd)
     *
     * @param nowDate       当前系统时间
     * @param beginDate     起始日期
     * @param endPlan       计划结束日期
     * @param spaceCount    间隔月数
     * @param dayOfMonthStr 一个月中的某天
     * @return
     */
    private Map<String, Date> findMonthMapByCustom(Date nowDate, Date beginDate, Date endPlan, int spaceCount, String dayOfMonthStr) {
        int dayOfMonth = Integer.valueOf(dayOfMonthStr).intValue();
        String beginDateStr = DateFormat.date2String(beginDate, DateFormat.DEFAULT_DATE_FORMAT);
        String endPlanStr = DateFormat.date2String(endPlan, DateFormat.DEFAULT_DATE_FORMAT);

        Calendar calendar_2 = Calendar.getInstance();
        calendar_2.setTime(beginDate);
        //获取下一个周期的起始日期
        calendar_2.add(Calendar.MONTH, spaceCount);

        int nextYear = calendar_2.get(Calendar.YEAR);
        //自然月份 取值范围[1,12] (注意jdk JANUARY:一月:0)
        int nextMonth = calendar_2.get(Calendar.MONTH) + 1;
        int nextDay = calendar_2.get(Calendar.DAY_OF_MONTH);

        //处理(闰2月,大月31天,小月30天)
        Date dateTemp = DateFormat.findLastDayByMonth(nextYear, nextMonth, DateFormat.DEFAULT_DATE_FORMAT);
        calendar_2.setTime(dateTemp);
        int maxDay = calendar_2.get(Calendar.DAY_OF_MONTH);
        if (dayOfMonth <= maxDay) {
            nextDay = dayOfMonth;
        } else if (dayOfMonth > maxDay) {
            nextDay = maxDay;
        }
        calendar_2.set(nextYear, (nextMonth-1), nextDay);
        Date nextBeginDate = calendar_2.getTime();

        calendar_2.add(Calendar.DATE, -1);
        Date endDate = calendar_2.getTime();
        String endDateStr = DateFormat.date2String(endDate, DateFormat.DEFAULT_DATE_FORMAT);

        //本周期结束日期 与 当前日期比较
        if (endDate.getTime() >= nowDate.getTime()) {
            Map<String, Date> dateTiemMap = new HashMap<String, Date>();

            String beginTimeStr = beginDateStr + " 00:00:00";
            Date beginDateTime = DateFormat.dateString2Date(beginTimeStr, DateFormat.DEFAULT_DATETIME_FORMAT);
            dateTiemMap.put("beginDateTime", beginDateTime);

            if (endDate.getTime() <= endPlan.getTime()) {
                String endTimeStr = endDateStr + " 23:59:59";
                Date endDateTime = DateFormat.dateString2Date(endTimeStr, DateFormat.DEFAULT_DATETIME_FORMAT);
                dateTiemMap.put("endDateTime", endDateTime);

                //下一保养日期(yyyy-MM-dd)
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(endDate);
                calendar.add(Calendar.DATE, 1);
                dateTiemMap.put("nextMaintainDate", calendar.getTime());
            } else if (endDate.getTime() > endPlan.getTime()) {
                String endTimeStr = endPlanStr + " 23:59:59";
                Date endDateTime = DateFormat.dateString2Date(endTimeStr, DateFormat.DEFAULT_DATETIME_FORMAT);
                dateTiemMap.put("endDateTime", endDateTime);
            }

            return dateTiemMap;
        } else if (endDate.getTime() < nowDate.getTime()) {
            return this.findMonthMapByCustom(nowDate, nextBeginDate, endPlan, spaceCount, dayOfMonthStr);
        }
        return null;
    }


}
