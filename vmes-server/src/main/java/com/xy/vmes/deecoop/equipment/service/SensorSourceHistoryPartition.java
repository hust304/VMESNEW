package com.xy.vmes.deecoop.equipment.service;

import com.xy.vmes.common.util.DateFormat;

import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * 创建表 vmes_sensor_source_history 分区表
 * 10年内的按月分区
 * ALTER TABLE vmes_sensor_source_history PARTITION BY RANGE (to_days(cdate)) (
 *   PARTITION p201909 VALUES LESS THAN (to_days('2019-10-01')),
 *   PARTITION p201910 VALUES LESS THAN (to_days('2019-11-01'))
 * )
 */
public class SensorSourceHistoryPartition {
    private static Integer yearCount = Integer.valueOf(10);
    private static Integer monthCount = Integer.valueOf(12);

    private static String beginYear = "2019";
    private static String sql_temp = "PARTITION {0} VALUES LESS THAN (to_days(''{1}'')),";

    public static void main(String args[]) throws ParseException {

        for (int i = 0; i < yearCount; i++) {
            //获取当前年份
            String nowYear = Integer.valueOf(Integer.valueOf(beginYear).intValue() + i).toString();
            //System.out.println("nowYear: " + nowYear);

            for (int j = 1; j <= monthCount; j++) {
                Integer month = Integer.valueOf(j);
                String monthStr = month.toString();
                if (monthStr.length() == 1) {
                    monthStr = "0" + monthStr;
                }

                //获取当前日期 (yyyy-MM-dd)
                String nowDateStr = nowYear + "-" + monthStr + "-01";
                Date nowDate = DateFormat.dateString2Date(nowDateStr, DateFormat.DEFAULT_DATE_FORMAT);
                //System.out.println("nowDateStr: " + nowDateStr);

                //获取当前日期(yyyy-MM-dd)- 下一个月
                String nextOneMonthDateStr = DateFormat.getAddDay(nowDateStr, DateFormat.DEFAULT_MONTH, 1, DateFormat.DEFAULT_DATE_FORMAT);
                //Date nextOneMonthDate = DateFormat.dateString2Date(nextOneMonthDateStr, DateFormat.DEFAULT_DATE_FORMAT);
                //System.out.println("nextOneMonthDateStr: " + nextOneMonthDateStr);

                //分区表:分区名称

                String partitionName = "p" + DateFormat.date2String(nowDate, "yyyyMM");

                //to_days 参数
                String to_days = nextOneMonthDateStr;

                String sql_partition = MessageFormat.format(sql_temp,
                        partitionName,
                        to_days);

                System.out.println(sql_partition);
            }
            System.out.println();
        }
    }
}
