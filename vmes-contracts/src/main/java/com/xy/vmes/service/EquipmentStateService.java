package com.xy.vmes.service;

import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;

public interface EquipmentStateService {
    //获取设备信息状态综合查询
    ResultModel findEquipmentState(PageData pd) throws Exception;

    ResultModel getOutputAndDate(PageData pd) throws Exception;

    ResultModel get24HoursData(PageData pd) throws Exception;

    ResultModel get24HoursDataDetail(PageData pd) throws Exception;

}
