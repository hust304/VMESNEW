package com.xy.vmes.deecoop.mobile.service;

import com.xy.vmes.deecoop.mobile.dao.MobileWarehouseCheckMapper;
import com.xy.vmes.deecoop.mobile.dao.MobileWarehouseInMapper;
import com.xy.vmes.service.MobileWarehouseCheckService;
import com.xy.vmes.service.MobileWarehouseInService;
import com.xy.vmes.service.WarehouseInExecuteService;
import com.xy.vmes.service.WarehouseService;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 手机端入库
 */
@Service
@Transactional(readOnly = false)
public class MobileWarehouseInServiceImp implements MobileWarehouseInService {

    @Autowired
    private MobileWarehouseInMapper mobileWarehouseInMapper;

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private WarehouseInExecuteService warehouseInExecuteService;
    ///////////////////////////////////////////////////////////////////////////////
    public ResultModel findWarehouseIn(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Map> varList = mobileWarehouseInMapper.findWarehouseIn(pd);
        if(varList!=null&&varList.size()>0){
            model.putResult(varList.get(0));
        }else {
            model.putCode("1");
            model.putMsg("未查到任何数据！");
        }
        return model;
    }

    @Override
    public ResultModel addWarehouseInExecute(PageData pageData) throws Exception {
        return warehouseInExecuteService.addWarehouseInExecute(pageData);
    }

    @Override
    public ResultModel rebackWarehouseInExecute(PageData pageData) throws Exception {
        return warehouseInExecuteService.rebackWarehouseInExecute(pageData);
    }

    @Override
    public ResultModel listWarehouseNodeByPid(PageData pd) throws Exception {
        return warehouseService.listWarehouseNodeByPid(pd);
    }

}
