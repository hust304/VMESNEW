package com.xy.vmes.deecoop.mobile.service;

import com.xy.vmes.deecoop.mobile.dao.MobileWarehouseInMapper;
import com.xy.vmes.deecoop.mobile.dao.MobileWarehouseMoveMapper;
import com.xy.vmes.service.MobileWarehouseInService;
import com.xy.vmes.service.MobileWarehouseMoveService;
import com.xy.vmes.service.WarehouseMoveDetailService;
import com.xy.vmes.service.WarehouseMoveExecuteService;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 手机端移库
 */
@Service
@Transactional(readOnly = false)
public class MobileWarehouseMoveServiceImp implements MobileWarehouseMoveService {

    @Autowired
    private MobileWarehouseMoveMapper mobileWarehouseMoveMapper;

    @Autowired
    private WarehouseMoveExecuteService warehouseMoveExecuteService;

    @Autowired
    private WarehouseMoveDetailService warehouseMoveDetailService;

    public ResultModel findWarehouseMove(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Map> varList = mobileWarehouseMoveMapper.findWarehouseMove(pd);
        if(varList!=null&&varList.size()>0){
            model.putResult(varList.get(0));
        }else {
            model.putCode("1");
            model.putMsg("未查到任何数据！");
        }
        return model;
    }

    @Override
    public ResultModel addWarehouseMoveExecute(PageData pageData) throws Exception {
        String detailId = pageData.getString("detailId");
        String targetWarehouseId = pageData.getString("targetWarehouseId");
        String warehouseProductId = pageData.getString("warehouseProductId");
        String countStr = pageData.getString("count");
        BigDecimal count = StringUtils.isEmpty(countStr)? BigDecimal.ZERO:BigDecimal.valueOf(Double.parseDouble(countStr));
        String currentUserId = pageData.getString("currentUserId");
        String currentCompanyId = pageData.getString("currentCompanyId");
        ResultModel model = warehouseMoveExecuteService.addWarehouseMoveExecute(detailId,targetWarehouseId,warehouseProductId,count,currentUserId,currentCompanyId);
        return model;
    }

    @Override
    public ResultModel rebackWarehouseMoveDetail(PageData pageData) throws Exception {
        pageData.put("id",pageData.getString("detailId"));
        return warehouseMoveDetailService.rebackWarehouseMoveDetail(pageData);
    }

}
