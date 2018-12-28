package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleOrderDetailByQueryService;
import com.xy.vmes.service.SaleOrderByQueryService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class SaleOrderQueryController {
    private Logger logger = LoggerFactory.getLogger(SaleOrderQueryController.class);

    @Autowired
    private SaleOrderByQueryService saleOrderByQueryService;
    @Autowired
    private SaleOrderDetailByQueryService orderDetailByQueryService;
    @Autowired
    private ColumnService columnService;

    @PostMapping("/saleOrderQuery/listPageSaleOrderQuery")
    public ResultModel listPageSaleOrderQuery() throws Exception {
        logger.info("################saleOrderQuery/listPageSaleOrderQuery 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Map result = new HashMap();

        //A. 第一级: 获取入库单明细Title列表
        List<Column> columnList = columnService.findColumnList("saleOrderByQuery");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        String firstFieldCode = pd.getString("firstFieldCode");
        if (firstFieldCode != null && firstFieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(firstFieldCode, columnList);
        }

        Map<String, Object> firstTitleMap = ColumnUtil.findTitleMapByColumnList(columnList);
        result.put("hideTitles",firstTitleMap.get("hideTitles"));
        result.put("titles",firstTitleMap.get("titles"));

        //B. 第二级: 获取订单明细汇总查询
        columnList = columnService.findColumnList("saleOrderDetailByQuery");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }
        String secondFieldCode = pd.getString("secondFieldCode");
        if (secondFieldCode != null && secondFieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(secondFieldCode, columnList);
        }
        Map<String, Object> secondTitleMap = ColumnUtil.findTitleMapByColumnList(columnList);

        //C. 查询第一层数据
        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varMapList = new ArrayList();
        List<Map> varList = saleOrderByQueryService.findListPageOrderByQuery(pd, pg);
        if (varList != null && varList.size() > 0) {
            for(int i = 0; i < varList.size(); i++) {
                Map map = varList.get(i);
                Map<String, Object> varMap = new HashMap<String, Object>();
                varMap.putAll((Map<String, String>)firstTitleMap.get("varModel"));
                for (Map.Entry<String, Object> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(), map.get(entry.getKey()) != null ? map.get(entry.getKey()).toString() : "");
                }
                varMap.put("hideTitles", secondTitleMap.get("hideTitles"));
                varMap.put("titles", secondTitleMap.get("titles"));
                varMap.put("pid", null);
                //查询第二层数据
                varMap.put("children", this.findSecondList(map, secondTitleMap));
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################saleOrderQuery/listPageSaleOrderQuery 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    private List<Map> findSecondList(Map firstRowMap, Map<String, Object> secondTitleMap) throws Exception {
        String parentId = (String)firstRowMap.get("parentId");

        PageData findMap = new PageData();
        findMap.put("parentId", parentId);

        List<Map> secondMapList = new ArrayList();
        List<Map> varList = orderDetailByQueryService.findListPageOrderDetaiByQuery(findMap);
        if(varList != null && varList.size() > 0) {
            for(int i = 0; i < varList.size(); i++) {
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll((Map<String, String>)secondTitleMap.get("varModel"));
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(), map.get(entry.getKey()) != null ? map.get(entry.getKey()).toString() : "");
                }
                varMap.put("pid",firstRowMap.get("id").toString());
                secondMapList.add(varMap);

            }
        }

        return secondMapList;
    }
}
