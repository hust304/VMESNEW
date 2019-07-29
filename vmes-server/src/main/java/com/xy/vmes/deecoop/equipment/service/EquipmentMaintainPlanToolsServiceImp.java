package com.xy.vmes.deecoop.equipment.service;

import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.entity.EquipmentMaintainPlan;
import com.xy.vmes.service.EquipmentMaintainPlanToolsService;
import com.yvan.common.util.Common;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

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
}
