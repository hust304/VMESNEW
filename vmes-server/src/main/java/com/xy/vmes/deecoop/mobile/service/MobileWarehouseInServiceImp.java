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

        String inDtlId = pd.getString("detailId");
        if (inDtlId == null || inDtlId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("入库明细id为空或空字符串！");
            return model;
        }

        //入库明细id-获取该入库明细id详情
        PageData findMap = new PageData();
        findMap.put("detailId", inDtlId);
        List<Map> varList = mobileWarehouseInMapper.findWarehouseIn(findMap);
        if (varList == null || varList.size() == 0) {
            model.putCode("1");
            model.putMsg("未查到任何数据！");
            return model;
        }
        model.putResult(varList.get(0));

        //入库明细id-获取该入库执行列表
        findMap = new PageData();
        findMap.put("detailId", inDtlId);
        List<Map> executeCountList = mobileWarehouseInMapper.listWarehouseInExecuteCount(findMap);
        model.put("executeCountList",executeCountList);

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
