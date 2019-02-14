package com.xy.vmes.deecoop.mobile.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.deecoop.mobile.dao.MobileProductMapper;
import com.xy.vmes.deecoop.mobile.dao.MobileWarehouseCheckMapper;
import com.xy.vmes.entity.WarehouseCheckDetail;
import com.xy.vmes.service.MobileProductService;
import com.xy.vmes.service.MobileWarehouseCheckService;
import com.xy.vmes.service.WarehouseCheckDetailService;
import com.xy.vmes.service.WarehouseCheckExecuteService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 手机端盘点
 */
@Service
@Transactional(readOnly = false)
public class MobileWarehouseCheckServiceImp implements MobileWarehouseCheckService {

    @Autowired
    private MobileWarehouseCheckMapper mobileWarehouseCheckMapper;
    @Autowired
    private WarehouseCheckExecuteService warehouseCheckExecuteService;
    @Autowired
    private WarehouseCheckDetailService warehouseCheckDetailService;
    ////获得盘点任务详细信息
    @Override
    public ResultModel findWarehouseCheck(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Map> varList =  mobileWarehouseCheckMapper.findWarehouseCheck(pd);
        if(varList!=null&&varList.size()>0){
            model.putResult(varList.get(0));
        }else {
            model.putCode("1");
            model.putMsg("未查到任何数据！");
        }

        return model;
    }


    @Override
    public ResultModel addWarehouseCheckExecute(PageData pageData) throws Exception {
        return warehouseCheckExecuteService.addWarehouseCheckExecute(pageData);
    }

    @Override
    public ResultModel rebackWarehouseCheckByDetail(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");
        String detailId = pageData.getString("detailId");
        String rebackBillReason = pageData.getString("rebackBillReason");
        if (rebackBillReason == null || rebackBillReason.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退单原因为空或空字符串，退单原因为必填不可为空！");
            return model;
        }
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点单明细ID不能为空！");
            return model;
        }
        WarehouseCheckDetail warehouseCheckDetail = warehouseCheckDetailService.selectById(detailId);
        List<WarehouseCheckDetail> detailList = new ArrayList<WarehouseCheckDetail>();
        if(warehouseCheckDetail!=null){
            detailList.add(warehouseCheckDetail);
        }
        warehouseCheckExecuteService.rebackWarehouseCheck(detailList,rebackBillReason,cuser);
        return model;
    }


    @Override
    public ResultModel auditDisagreeWarehouseCheck(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");
        String remark = pageData.getString("remark");
        if (remark == null || remark.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("审核意见为空或空字符串，审核意见为必填不可为空！");
            return model;
        }
        List<Map<String, Object>> mapList = new ArrayList<>();
        Map<String, Object> mapValue = new HashMap();
        mapValue.put("id",pageData.getString("id"));
        mapValue.put("parentId",pageData.getString("parentId"));
        mapValue.put("detailId",pageData.getString("detailId"));
        mapList.add(mapValue);
        warehouseCheckExecuteService.auditDisagreeWarehouseCheck(mapList,cuser,remark);
        return model;
    }

    @Override
    public ResultModel auditPassWarehouseCheck(PageData pageData) throws Exception {
        ResultModel model = new ResultModel();
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");
        List<Map<String, Object>> mapList =  new ArrayList<>();
        Map<String, Object> mapValue = new HashMap();
        mapValue.put("id",pageData.getString("id"));
        mapValue.put("parentId",pageData.getString("parentId"));
        mapValue.put("detailId",pageData.getString("detailId"));
        mapValue.put("code",pageData.getString("code"));
        mapValue.put("productId",pageData.getString("productId"));
        mapValue.put("warehouseId",pageData.getString("warehouseId"));
        mapValue.put("stockCount",pageData.getString("stockCount"));
        mapValue.put("count",pageData.getString("checkCount"));
        mapList.add(mapValue);
        warehouseCheckExecuteService.auditPassWarehouseCheck(mapList,cuser,companyId);
        return model;
    }

    @Override
    public ResultModel listWarehouseCheckByAduited(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();
        List<Map> varList = mobileWarehouseCheckMapper.listWarehouseCheckByAduited(pd,pg);
        Map result = new HashMap();
        result.put("varList", varList);
        result.put("pageData", pg);
        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel listWarehouseCheckByAduiting(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();
        List<Map> varList = mobileWarehouseCheckMapper.listWarehouseCheckByAduiting(pd,pg);
        Map result = new HashMap();
        result.put("varList", varList);
        result.put("pageData", pg);
        model.putResult(result);
        return model;
    }

    @Override
    public ResultModel findWarehouseCheckById(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        List<Map> varList =  mobileWarehouseCheckMapper.findWarehouseCheckById(pd);
        if(varList!=null&&varList.size()>0){
            model.putResult(varList.get(0));
        }else {
            model.putCode("1");
            model.putMsg("未查到任何数据！");
        }
        return model;
    }
}
