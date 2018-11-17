package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.WarehouseCheckDetail;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.WarehouseCheckDetailService;
import com.xy.vmes.service.WarehouseCheckExecutorService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.*;


/**
* 说明：vmes_warehouse_check_executor:库存盘点明细执行人Controller
* @author 陈刚 自动生成
* @date 2018-11-15
*/
@RestController
@Slf4j
public class WarehouseCheckExecutorController {

    private Logger logger = LoggerFactory.getLogger(WarehouseCheckExecutorController.class);

    @Autowired
    private WarehouseCheckDetailService warehouseCheckDetailService;
    @Autowired
    private WarehouseCheckExecutorService warehouseCheckExecutorService;

    @Autowired
    private ColumnService columnService;

    /**
     * 获取盘点执行列表-(添加盘点执行对话框)
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouseCheckExecutor/findListByWarehouseCheckExecutor")
    public ResultModel findListByWarehouseCheckExecutor() throws Exception {
        logger.info("################warehouseCheckExecutor/findListByWarehouseCheckExecutor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouseCheckExecutorByAddExecute");
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
                if (column != null) {
                    if ("0".equals(column.getIshide())) {
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

        pd.put("orderStr", "executor.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varMapList = new ArrayList();
        List<Map> varList = warehouseCheckExecutorService.findListWarehouseCheckExecutorByAddExecute(pd, pg);
        if (varList != null && varList.size() > 0) {
            for (int i = 0; i < varList.size(); i++) {
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll(varModelMap);
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(), map.get(entry.getKey()) != null ? map.get(entry.getKey()).toString() : "");
                }
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseCheckExecutor/findListByWarehouseCheckExecutor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 添加盘点明细执行人 (盘点派单)
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouseCheckExecutor/addWarehouseCheckExecutor")
    @Transactional
    public ResultModel addWarehouseCheckExecutor() throws Exception {
        logger.info("################/warehouseCheckExecutor/addWarehouseCheckExecutor 执行开始 ################# ");
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
        //dtlJsonStr = "[{\"id\":\"6d1e4503db6f46bcb22249b29abd4e27\"},{\"id\":\"824cdac10bb54c7aa62441e55696597e\"}]";
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一行数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点明细Json字符串-转换成List错误！");
            return model;
        }

        //1. 入库单明细派单
        List<WarehouseCheckDetail> detailList = warehouseCheckDetailService.mapList2DetailList(mapList, null);

        String cuser = pageData.getString("cuser");
        for (WarehouseCheckDetail detail : detailList) {
            detail.setCuser(cuser);

            //盘点明细分配执行人
            warehouseCheckExecutorService.addWarehouseCheckExecutor(detail, executeId);

            //状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
            detail.setState("1");
            warehouseCheckDetailService.update(detail);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheckExecutor/addWarehouseCheckExecutor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


}



