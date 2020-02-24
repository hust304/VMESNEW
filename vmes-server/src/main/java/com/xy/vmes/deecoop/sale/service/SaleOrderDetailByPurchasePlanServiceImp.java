package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.EvaluateUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.sale.dao.SaleOrderDetailByPurchasePlanMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleOrderDetailByPurchasePlanService;
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
 * 采购-采购计划管理-弹出界面查询
 * 创建人：陈刚
 * 创建时间：2020-01-20
 */
@Service
@Transactional(readOnly = false)
public class SaleOrderDetailByPurchasePlanServiceImp implements SaleOrderDetailByPurchasePlanService {
    @Autowired
    private SaleOrderDetailByPurchasePlanMapper orderDetailByPurchasePlanMapper;

    @Autowired
    private ColumnService columnService;

    public List<Map> listOrderDetaiByPurchasePlan(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList<Map>();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return orderDetailByPurchasePlanMapper.listOrderDetaiByPurchasePlan(pd);
        } else if (pg != null) {
            return orderDetailByPurchasePlanMapper.listOrderDetaiByPurchasePlan(pd,pg);
        }

        return mapList;
    }

    public ResultModel listPageOrderDetaiByPurchasePlan(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

        List<Column> columnList = columnService.findColumnList("saleOrderDetailByPurchasePlan");
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

        if (pd.getString("orderDtlIds") != null) {
            String orderDtlIds = pd.getString("orderDtlIds").toString().trim();
            if (orderDtlIds != null && orderDtlIds.trim().length() > 0) {
                orderDtlIds = StringUtil.stringTrimSpace(orderDtlIds);
                orderDtlIds = "'" + orderDtlIds.replace(",", "','") + "'";
                pd.put("orderDtlIds", orderDtlIds);
            }
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

        List<Map> varList = this.listOrderDetaiByPurchasePlan(pd, pg);
        if (varList != null && varList.size() > 0) {
            for(int i=0; i < varList.size(); i++){
                Map<String, Object> objectMap = varList.get(i);
                //(n2p:计量转换计价)///////////////////////////////////////////////////////////////////////////////////////////
                String n2pFormula = (String)objectMap.get("npFormula");

                //n2pIsScale 是否需要四舍五入(Y:需要四舍五入 N:无需四舍五入)
                String n2pIsScale = new String();
                if (objectMap.get("n2pIsScale") != null) {
                    n2pIsScale = objectMap.get("n2pIsScale").toString().trim();
                }

                //n2pDecimalCount 小数位数 (最小:0位 最大:4位)
                Integer n2pDecimalCount = Integer.valueOf(2);
                if (objectMap.get("n2pDecimalCount") != null) {
                    n2pDecimalCount = (Integer)objectMap.get("n2pDecimalCount");
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

                //(单据单位)货品数量///////////////////////////////////////////////////////////////////////////////////////////
                //orderCount 订购数量
                BigDecimal orderCount = BigDecimal.valueOf(0D);
                if (objectMap.get("orderCount") != null) {
                    orderCount = (BigDecimal)objectMap.get("orderCount");
                }

                //allowStockCount (计量单位)可用库存数量 -- (n2pFormula)计量单位转换计价单位
                allowStockCount = EvaluateUtil.countFormulaN2P(allowStockCount, n2pFormula);
                allowStockCount = StringUtil.scaleDecimal(allowStockCount, n2pIsScale, n2pDecimalCount);
                objectMap.put("allowStockCount", allowStockCount.toString());

                //safetyCount 安全库存 -- (n2pFormula)计量单位转换计价单位
                safetyCount = EvaluateUtil.countFormulaN2P(safetyCount, n2pFormula);
                safetyCount = StringUtil.scaleDecimal(safetyCount, n2pIsScale, n2pDecimalCount);
                objectMap.put("safetyCount", safetyCount.toString());

                //purchasePlanCount 计划数量///////////////////////////////////////////////////////////////////////////////////////////
                BigDecimal purchasePlanCount = BigDecimal.valueOf(0D);

                //safetyCount 安全库存(0)
                if (safetyCount.doubleValue() == 0D) {
                    //purchasePlanCount 计划数量 := 可用库存数量 - 订购数量
                    BigDecimal bigTemp = BigDecimal.valueOf(allowStockCount.doubleValue() - orderCount.doubleValue());
                    if (bigTemp.doubleValue() < 0) {
                        purchasePlanCount = BigDecimal.valueOf(bigTemp.doubleValue() * -1);
                    } else if (bigTemp.doubleValue() >= 0) {
                        purchasePlanCount = orderCount;
                    }
                } else if (safetyCount.doubleValue() > 0D) {
                    //purchasePlanCount 计划数量 := (可用库存数量 - 订购数量) - 安全库存
                    BigDecimal bigTemp = BigDecimal.valueOf(allowStockCount.doubleValue() - orderCount.doubleValue() - safetyCount.doubleValue());
                    if (bigTemp.doubleValue() < 0) {
                        purchasePlanCount = BigDecimal.valueOf(bigTemp.doubleValue() * -1);
                    } else if (bigTemp.doubleValue() >= 0) {
                        purchasePlanCount = orderCount;
                    }
                }

                purchasePlanCount = StringUtil.scaleDecimal(purchasePlanCount, n2pIsScale, n2pDecimalCount);
                objectMap.put("purchasePlanCount", purchasePlanCount.toString());

                //isNeedPurchase 是否需要采购(0:不需要 1:需要)
                String isNeedPurchase = new String("0");
                if (objectMap.get("isNeedPurchase") != null
                    && "0,1".indexOf(objectMap.get("isNeedPurchase").toString().trim()) != 0
                ) {
                    isNeedPurchase = objectMap.get("isNeedPurchase").toString().trim();
                }
                objectMap.put("isNeedPurchase", isNeedPurchase);
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
