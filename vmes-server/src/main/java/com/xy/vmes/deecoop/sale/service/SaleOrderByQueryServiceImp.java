package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.EvaluateUtil;
import com.xy.vmes.deecoop.sale.dao.SaleOrderByQueryMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleOrderByQueryService;
import com.xy.vmes.service.SaleOrderDetailByQueryService;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = false)
public class SaleOrderByQueryServiceImp implements SaleOrderByQueryService {
    @Autowired
    private SaleOrderByQueryMapper orderByQueryMapper;
    @Autowired
    private SaleOrderDetailByQueryService orderDetailByQueryService;
    @Autowired
    private ColumnService columnService;

    public List<Map> findListPageOrderByQuery(PageData pd, Pagination pg) throws Exception{
        return orderByQueryMapper.findListPageOrderByQuery(pd, pg);
    }

    @Override
    public ResultModel listPageSaleOrderQuery(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();

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
        List<Map> varMapList = new ArrayList();
        List<Map> varList = this.findListPageOrderByQuery(pd, pg);
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

        for (Map<String, String> mapObject : secondMapList) {
            //计量转换计价单位 数量转换公式 n2pFormula
            String n2pFormula = "";
            if (mapObject.get("n2pFormula") != null && mapObject.get("n2pFormula").toString().trim().length() > 0) {
                n2pFormula = mapObject.get("n2pFormula").toString().trim();
            }

            //锁定货品数量 lockCount
            BigDecimal lockCount = BigDecimal.valueOf(0D);
            String lockCount_str = (String)mapObject.get("lockCount");
            if (lockCount_str != null && lockCount_str.trim().length() > 0) {
                try {
                    lockCount = new BigDecimal(lockCount_str);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            BigDecimal lockCount_out = EvaluateUtil.countFormulaN2P(lockCount, n2pFormula);
            if (lockCount_out == null) {
                mapObject.put("lockCount", "0.00");
            } else {
                mapObject.put("lockCount", lockCount_out.toString());
            }

        }

        return secondMapList;
    }
}
