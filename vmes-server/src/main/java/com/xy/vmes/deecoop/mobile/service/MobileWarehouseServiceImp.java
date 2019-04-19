package com.xy.vmes.deecoop.mobile.service;

import com.xy.vmes.service.EmployeeService;
import com.xy.vmes.service.MobileWarehouseService;
import com.xy.vmes.service.UserService;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by 46368 on 2019/3/27.
 */
@Service
@Transactional(readOnly = false)
public class MobileWarehouseServiceImp implements MobileWarehouseService {

    @Autowired
    private EmployeeService employeeService;

//    @Autowired
//    private UserService userService;

    @Override
    public ResultModel findEmployeeInfo(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Map> employeeList = employeeService.getDataList(pd);
        if(employeeList!=null&&employeeList.size()>0){
            model.putResult(employeeList.get(0));
        }else {
            model.putCode("1");
            model.putMsg("当前登录账号未绑定员工信息，请于管理员联系！");
        }

//        List<Map> userList = userService.getDataList(pd);
//        if(userList != null && userList.size() > 0) {
//            model.putResult(userList.get(0));
//        }else {
//            model.putCode("1");
//            model.putMsg("查询当前登录账号信息失败！");
//        }

        return model;
    }
}
