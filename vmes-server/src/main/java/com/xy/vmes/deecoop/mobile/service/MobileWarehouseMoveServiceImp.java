package com.xy.vmes.deecoop.mobile.service;

import com.yvan.common.util.Common;
import com.xy.vmes.deecoop.mobile.dao.MobileWarehouseMoveMapper;
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
import java.text.MessageFormat;
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
        ResultModel model = new ResultModel();

        String detailId = pageData.getString("detailId");
        String targetWarehouseId = pageData.getString("targetWarehouseId");
        String warehouseProductId = pageData.getString("warehouseProductId");
        String countStr = pageData.getString("count");
        BigDecimal count = StringUtils.isEmpty(countStr)? BigDecimal.ZERO:BigDecimal.valueOf(Double.parseDouble(countStr));
        String currentUserId = pageData.getString("currentUserId");
        String currentCompanyId = pageData.getString("currentCompanyId");

        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        List<Map> moveMapList = warehouseMoveDetailService.getDataListPage(findMap,null);

        Map moveMap = null;
        if (moveMapList != null && moveMapList.size() > 0) {
            moveMap = moveMapList.get(0);
        }

        //移库执行验证 移库单明细数量 (移库单明已执行数量 + 当前执行数量) --(web端,app端)同时执行情况
        if (moveMap != null) {
            //productCode 货品编码
            String productCode = new String();
            if (moveMap.get("productCode") != null) {
                productCode = moveMap.get("productCode").toString().trim();
            }

            //productName 货品名称
            String productName = new String();
            if (moveMap.get("productName") != null) {
                productName = moveMap.get("productName").toString().trim();
            }

            //executeCount 已完成数量
            BigDecimal executeCount = BigDecimal.valueOf(0D);
            if (moveMap.get("executeCount") != null) {
                executeCount = (BigDecimal)moveMap.get("executeCount");
            }

            //移库明细:移库数量
            BigDecimal dtl_count = BigDecimal.valueOf(0D);
            if (moveMap.get("count") != null) {
                dtl_count = (BigDecimal)moveMap.get("count");
            }

            String msgTemp = "货品编码({0})货品名称({1}) 移库执行冲突，移库数量({2}) 已执行({3}) 不可大于移库数量！" + Common.SYS_ENDLINE_DEFAULT;
            if (dtl_count.doubleValue() < (executeCount.doubleValue() + count.doubleValue())) {
                String msgStr = MessageFormat.format(msgTemp,
                        productCode,
                        productName,
                        dtl_count.toString(),
                        executeCount.toString());

                model.putCode(Integer.valueOf(1));
                model.putMsg(msgStr);
                return model;
            }
        }

        model = warehouseMoveExecuteService.addWarehouseMoveExecute(detailId,targetWarehouseId,warehouseProductId,count,currentUserId,currentCompanyId);
        return model;
    }

    @Override
    public ResultModel rebackWarehouseMoveDetail(PageData pageData) throws Exception {
        pageData.put("id",pageData.getString("detailId"));
        return warehouseMoveDetailService.rebackWarehouseMoveDetail(pageData);
    }

}
