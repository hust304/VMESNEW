package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.EvaluateUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.sale.dao.SaleOrderDetailByProducePlanMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleOrderDetailByProducePlanService;
import com.yvan.HttpUtils;
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

/**
 * 说明：销售订单明细查询 实现类
 * 生产-生产计划管理-弹出界面查询
 * 创建人：陈刚
 * 创建时间：2020-02-29
 */
@Service
@Transactional(readOnly = false)
public class SaleOrderDetailByProducePlanServiceImp implements SaleOrderDetailByProducePlanService {
    @Autowired
    private SaleOrderDetailByProducePlanMapper orderDetailByProducePlanMapper;

    @Autowired
    private ColumnService columnService;

    public List<Map> listOrderDetaiByProducePlan(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return orderDetailByProducePlanMapper.listOrderDetaiByProducePlan(pd);
        } else if (pg != null) {
            return orderDetailByProducePlanMapper.listOrderDetaiByProducePlan(pd, pg);
        }

        return mapList;
    }

    public ResultModel listPageOrderDetaiByProducePlan(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("saleOrderDetailByProducePlan");
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

        //inOrderDtlState Sql查询 in 连接(明细状态) 销售订单明细状态(0:待提交 1:待审核 2:待生产 3:待出库 4:待发货 5:已完成(发货) -1:已取消)
        String inOrderDtlState = pd.getString("inOrderDtlState");
        if (inOrderDtlState != null && inOrderDtlState.trim().length() > 0) {
            inOrderDtlState = inOrderDtlState.trim();

            inOrderDtlState = StringUtil.stringTrimSpace(inOrderDtlState);
            inOrderDtlState = "'" + inOrderDtlState.replace(",", "','") + "'";
            pd.put("inOrderDtlState", inOrderDtlState);
        }

        //设置查询排序方式
        //pd.put("orderStr", "a.cdate asc");
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

        List<Map> varList = this.listOrderDetaiByProducePlan(pd, pg);
        if (varList != null && varList.size() > 0) {
            for(int i=0; i < varList.size(); i++){
                Map<String, Object> objectMap = varList.get(i);
                //(p2n:计价转换计量)///////////////////////////////////////////////////////////////////////////////////////////
                String p2nFormula = (String)objectMap.get("p2nFormula");

                //p2nIsScale 是否需要四舍五入(Y:需要四舍五入 N:无需四舍五入)
                String p2nIsScale = new String();
                if (objectMap.get("p2nIsScale") != null) {
                    p2nIsScale = objectMap.get("p2nIsScale").toString().trim();
                }

                //p2nDecimalCount 小数位数 (最小:0位 最大:4位)
                Integer p2nDecimalCount = Integer.valueOf(2);
                if (objectMap.get("p2nDecimalCount") != null) {
                    p2nDecimalCount = (Integer)objectMap.get("p2nDecimalCount");
                }

                //(计量单位)货品数量///////////////////////////////////////////////////////////////////////////////////////////
                //allowStockCount (计量单位)可用库存数量: 库存数量 - 货品锁库数量 + (销售订单)货品锁库数量
                BigDecimal allowStockCount = BigDecimal.valueOf(0D);
                if (objectMap.get("allowStockCount") != null) {
                    allowStockCount = (BigDecimal)objectMap.get("allowStockCount");
                }

                //safetyCount 安全库存
                BigDecimal safetyCount = BigDecimal.valueOf(0D);
                if (objectMap.get("safetyCount") != null) {
                    safetyCount = (BigDecimal)objectMap.get("safetyCount");
                }

                //(单据单位-计价单位)货品数量///////////////////////////////////////////////////////////////////////////////////////////
                //orderCount 订购数量
                BigDecimal orderCount = BigDecimal.valueOf(0D);
                if (objectMap.get("orderCount") != null) {
                    orderCount = (BigDecimal)objectMap.get("orderCount");
                }

                //orderCount (单据单位-计价单位)订购数量 -- (p2nFormula)计价单位转换计量单位
                orderCount = EvaluateUtil.countFormulaP2N(orderCount, p2nFormula);
                orderCount = StringUtil.scaleDecimal(orderCount, p2nIsScale, p2nDecimalCount);
                objectMap.put("orderCount", orderCount.toString());

                //endDeliverCount 已发货数量
                BigDecimal endDeliverCount = BigDecimal.valueOf(0D);
                if (objectMap.get("endDeliverCount") != null) {
                    endDeliverCount = (BigDecimal)objectMap.get("endDeliverCount");
                }

                //endDeliverCount (单据单位-计价单位)已发货数量 -- (p2nFormula)计价单位转换计量单位
                endDeliverCount = EvaluateUtil.countFormulaP2N(endDeliverCount, p2nFormula);
                endDeliverCount = StringUtil.scaleDecimal(endDeliverCount, p2nIsScale, p2nDecimalCount);
                objectMap.put("endDeliverCount", endDeliverCount.toString());

            }
        }

        List<Map> varMapList = ColumnUtil.getVarMapList(varList, titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);
        model.putResult(result);
        return model;
    }
}
