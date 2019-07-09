package com.xy.vmes.deecoop.mobile.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.common.util.Common;
import com.xy.vmes.deecoop.mobile.dao.MobileWarehouseCheckMapper;
import com.xy.vmes.entity.WarehouseCheckDetail;
import com.xy.vmes.service.*;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
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
    private WarehouseCheckExecutorService warehouseCheckExecutorService;
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
        ResultModel model = new ResultModel();

        String count = pageData.getString("count");
        String detailId = pageData.getString("detailId");

        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        //state: 状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
        findMap.put("detailState", '2');
        List<Map> checkMapList = warehouseCheckExecutorService.findListWarehouseCheckExecutorByAddExecute(findMap);

        Map checkMap = null;
        if (checkMapList != null && checkMapList.size() > 0) {
            checkMap = checkMapList.get(0);
        }

        //出库执行验证 出库单明细数量 (出库单明已执行数量 + 当前执行数量) --(web端,app端)同时执行情况
        if (checkMap != null) {
            //productCode 货品编码
            String productCode = new String();
            if (checkMap.get("productCode") != null) {
                productCode = checkMap.get("productCode").toString().trim();
            }

            //productName 货品名称
            String productName = new String();
            if (checkMap.get("productName") != null) {
                productName = checkMap.get("productName").toString().trim();
            }
            //pathName 货位名称
            String pathName = new String();
            if (checkMap.get("pathName") != null) {
                pathName = checkMap.get("pathName").toString().trim();
            }

            //code 批次号
            String code = new String();
            if (checkMap.get("code") != null) {
                code = checkMap.get("code").toString().trim();
            }

            String msgTemp = "货品编码({0})货品名称({1}) 货位名称({2}) 批次号({3}) 已经被执行！ 当前盘点数量({4})无需执行！" + Common.SYS_ENDLINE_DEFAULT;
            String msgStr = MessageFormat.format(msgTemp,
                    productCode,
                    productName,
                    pathName,
                    code,
                    count);
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        List<Map<String, Object>> mapList = new ArrayList();
        Map<String, Object> dataMap = new HashMap();
        String cuser = pageData.getString("cuser");
        dataMap.put("count",pageData.getString("count"));
        dataMap.put("detailId",pageData.getString("detailId"));
        dataMap.put("parentId",pageData.getString("parentId"));
        mapList.add(dataMap);
        warehouseCheckExecuteService.addWarehouseCheck(mapList,cuser);
        return model;
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
