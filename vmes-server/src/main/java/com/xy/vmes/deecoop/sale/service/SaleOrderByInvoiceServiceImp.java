package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.deecoop.sale.dao.SaleOrderByInvoiceMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleOrderByInvoiceService;
import com.xy.vmes.service.SaleOrderDetailByInvoiceService;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = false)
public class SaleOrderByInvoiceServiceImp implements SaleOrderByInvoiceService {
    @Autowired
    private SaleOrderByInvoiceMapper saleOrderByInvoiceMapper;
    @Autowired
    private ColumnService columnService;
    @Autowired
    private SaleOrderDetailByInvoiceService orderDetailByInvoiceService;

    public List<Map> findListPageOrderByInvoice(PageData pd, Pagination pg) throws Exception {
        return saleOrderByInvoiceMapper.findListPageOrderByInvoice(pd, pg);
    }

    @Override
    public ResultModel listPageOrderByInvoice(PageData pd, Pagination pg) throws Exception {
        ResultModel model = new ResultModel();

        Map result = new HashMap();

        //A. 第一级: 获取入库单明细Title列表
        List<Column> columnList = columnService.findColumnList("saleOrderByInvoice");
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
        columnList = columnService.findColumnList("saleOrderDetailByInvoice");
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
        List<Map> varList = this.findListPageOrderByInvoice(pd, pg);
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
                List<Map> secondList = this.findSecondList(map, secondTitleMap);

                if(secondList!=null&&secondList.size()>0){
                    varMap.put("children", secondList);
                    varMapList.add(varMap);
                }
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
        findMap.put("queryStr"," (ifnull(orderDetail.count, 0) - ifnull(invoice0.invoice_count, 0) - ifnull(invoice1.invoice_count, 0)) > 0 ");
        List<Map> secondMapList = new ArrayList();
        List<Map> varList = orderDetailByInvoiceService.findListPageOrderDetailByInvoice(findMap);
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
