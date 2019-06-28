package com.xy.vmes.deecoop.equipment.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.EquipmentWarehouseLoginfoBySpareService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_warehouse_loginfo:(备件库)货品库存数量变更日志表 Controller
 * @author 陈刚
 * @date 2019-06-27
 */
@RestController
@Slf4j
public class EquipmentWarehouseLoginfoBySpareController {
    private Logger logger = LoggerFactory.getLogger(EquipmentWarehouseLoginfoBySpareController.class);

    @Autowired
    private EquipmentWarehouseLoginfoBySpareService warehouseLoginfoBySpareService;
    @Autowired
    private ColumnService columnService;

    @PostMapping("/equipment/warehouseLoginfoBySpare/findListWarehouseLoginfoBySpare")
    public ResultModel findListWarehouseLoginfoBySpare() throws Exception {
        logger.info("################/equipment/warehouseLoginfoBySpare/findListWarehouseLoginfoBySpare 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("warehouseLoginfoBySpare");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);

        String companyId = new String();
        if (pd.getString("currentCompanyId") != null) {
            companyId = pd.getString("currentCompanyId").trim();
        }
        pd.put("companyId", companyId);

        //设置查询排序方式
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        //是否需要分页 true:需要分页 false:不需要分页
        Map result = new HashMap();
        String isNeedPage = pd.getString("isNeedPage");
        if ("false".equals(isNeedPage)) {
            pg = null;
        } else {
            result.put("pageData", pg);
        }

        List<Map> varList = warehouseLoginfoBySpareService.findListWarehouseLoginfoBySpare(pd, pg);
        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);

        Long endTime = System.currentTimeMillis();
        logger.info("################/equipment/warehouseLoginfoBySpare/findListWarehouseLoginfoBySpare 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
