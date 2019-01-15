package com.xy.vmes.deecoop.sale.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.EvaluateUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleOrderDetailByInvoiceService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

/**
 * 说明：查询订单明细(开票管理-勾选订单)
 * @author 陈刚
 * @date 2019-01-13
 */
@RestController
@Slf4j
public class SaleOrderDetailByInvoiceController {
    private Logger logger = LoggerFactory.getLogger(SaleOrderDetailByInvoiceController.class);

    @Autowired
    private SaleOrderDetailByInvoiceService orderDetailByInvoiceService;

    @Autowired
    private ColumnService columnService;

    /**
     * 订单明细列表(开票管理-勾选订单)
     * @author 陈刚
     * @date 2019-01-13
     */
    @PostMapping("/saleOrderDetail/listPageOrderDetailByInvoice")
    public ResultModel listPageOrderDetailByInvoice() throws Exception {
        logger.info("################saleOrderDetail/listPageOrderDetailByInvoice 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("saleOrderDetailByInvoice");
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
        if(columnList!=null&&columnList.size()>0){
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

        //获取订单ID参数
        String parentId = pd.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            pd.put("queryStr", "1=2");
        }

        //设置查询排序
        pd.put("orderStr", "orderDetail.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varMapList = new ArrayList();
        List<Map> varList = orderDetailByInvoiceService.findListPageOrderDetailByInvoice(pd, pg);
        if(varList!=null&&varList.size()>0){
            for(int i=0;i<varList.size();i++){
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll(varModelMap);
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
                }
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);
        model.putResult(result);

        Long endTime = System.currentTimeMillis();
        logger.info("################saleOrderDetail/listPageOrderDetailByInvoice 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
