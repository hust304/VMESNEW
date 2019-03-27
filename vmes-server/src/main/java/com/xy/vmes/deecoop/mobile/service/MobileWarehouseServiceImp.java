package com.xy.vmes.deecoop.mobile.service;

import com.xy.vmes.service.EmployeeService;
import com.xy.vmes.service.MobileWarehouseService;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by 46368 on 2019/3/27.
 */
public class MobileWarehouseServiceImp implements MobileWarehouseService {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public ResultModel findEmployeeInfo(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Map> employeeList = employeeService.getDataList(pd);
        if(employeeList!=null&&employeeList.size()>0){
            model.putResult(employeeList.get(0));
        }else {
            model.putCode("1");
            model.putMsg("查询当前员工信息失败！");
        }
        return model;
    }
}
