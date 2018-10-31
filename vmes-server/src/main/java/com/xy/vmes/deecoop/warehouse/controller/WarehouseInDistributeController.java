package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.Product;
import com.xy.vmes.entity.ProductProperty;
import com.xy.vmes.entity.WarehouseInDetail;
import com.xy.vmes.service.*;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

/**
 * 说明：入库派单
 * @author 陈刚 自动生成
 * @date 2018-10-18
 */
@RestController
@Slf4j
public class WarehouseInDistributeController {
    private Logger logger = LoggerFactory.getLogger(WarehouseInDistributeController.class);

    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;
    @Autowired
    private WarehouseInExecutorService warehouseInExecutorService;
    @Autowired
    private WarehouseProductService warehouseProductService;

    @Autowired
    private ColumnService columnService;

    /**
     * @author 陈刚 自动创建，可以修改
     * @date 2018-10-16
     */
    @PostMapping("/warehouseInDistribute/listPageWarehouseInDetail")
    public ResultModel listPageWarehouseInDetail() throws Exception {
        logger.info("################/warehouseInDistribute/listPageWarehouseInDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouseInDetail");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //获取指定栏位字符串-重新调整List<Column>
        PageData pd = HttpUtils.parsePageData();
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }

        List<LinkedHashMap> titlesList = new ArrayList<LinkedHashMap>();
        List<String> titlesHideList = new ArrayList<String>();
        Map<String, String> varModelMap = new HashMap<String, String>();
        if (columnList != null && columnList.size() > 0) {
            for (Column column : columnList) {
                if(column!=null){
                    if("0".equals(column.getIshide())){
                        titlesHideList.add(column.getTitleKey());
                    }
                    LinkedHashMap titlesLinkedMap = new LinkedHashMap();
                    titlesLinkedMap.put(column.getTitleKey(),column.getTitleName());
                    varModelMap.put(column.getTitleKey(),"");
                    titlesList.add(titlesLinkedMap);
                }
            }
        }
        Map result = new HashMap();
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);

        pd.put("orderStr", "a.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varMapList = new ArrayList();
        List<Map> varList = warehouseInDetailService.getDataListPage(pd, pg);
        if(varList!=null&&varList.size()>0){
            //获取当前企业全部<货位id, 货位名称>
            String companyId = pd.getString("currentCompanyId");
            warehouseService.implementBusinessMapByCompanyId(companyId);
            Map<String, String> keyNameMap = warehouseService.getKeyNameMap();


            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll(varModelMap);

                //warehouseId 仓库货位id
                String warehouseId = "";
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    String mapKey = entry.getKey();
                    Object mapValue = map.get(mapKey);

                    //warehouseName 推荐库位
                    if ("warehouseName".equals(mapKey)) {
                        Product product = new Product();
                        product.setId((String)map.get("productId"));
                        product.setType((String)map.get("productType"));
                        String warehouseId_sys = warehouseProductService.findDefaultWarehousePosition(companyId, product);
                        String warehouseName = new String();
                        if (warehouseId_sys == null || warehouseId_sys.trim().length() == 0) {
                            warehouseName = "无推荐货位，系统历史中无存放当前货品记录，系统中没有空货位！";
                        } else {
                            warehouseName = keyNameMap.get(warehouseId_sys);
                            if (warehouseName == null || warehouseName.trim().length() == 0) {
                                warehouseName = "推荐货位id:" + warehouseId_sys + " 该货位以取消或系统中不存在！";
                            } else {
                                warehouseId = warehouseId_sys;
                            }
                        }

                        varMap.put(mapKey, warehouseName);
                    } else {
                        varMap.put(mapKey, mapValue != null ? mapValue.toString() : "");
                    }
                }
                varMap.put("warehouseId", warehouseId);
                varMapList.add(varMap);
            }
        }

        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInDistribute/listPageWarehouseInDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 入库派单
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouseInDistribute/updateWarehouseInDistribute")
    @Transactional
    public ResultModel updateWarehouseInDistribute() throws Exception {
        logger.info("################/warehouseInDistribute/updateWarehouseInDistribute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String executeId = pageData.getString("executeId");
        if (executeId == null || executeId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("执行人id为空或空字符串！");
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        //测试代码-真实环境无此代码
        //dtlJsonStr = "[{\"id\":\"6d1e4503db6f46bcb22249b29abd4e27\",\"warehouseId\":\"0f1ca6d8e3614c9895edfc655433914c\"},{\"id\":\"824cdac10bb54c7aa62441e55696597e\",\"warehouseId\":\"45f58566a8534c77a63a0a8882d76def\"}]";

        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细Json字符串-转换成List错误！");
            return model;
        }

        //1. 入库单明细派单
        List<WarehouseInDetail> detailList = warehouseInDetailService.mapList2DetailList(mapList, null);
        String msgStr = warehouseInDetailService.checkDistributeDetailList(detailList);
        if (msgStr != null && msgStr.trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgStr);
            return model;
        }

        String cuser = pageData.getString("cuser");
        for (WarehouseInDetail detail : detailList) {
            detail.setCuser(cuser);

            //入库明细分配执行人
            warehouseInExecutorService.addWarehouseInExecutor(detail, executeId);

            //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            detail.setState("1");
            //detail.setExecuteId(executeId);
            warehouseInDetailService.update(detail);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInDistribute/updateWarehouseInDistribute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
