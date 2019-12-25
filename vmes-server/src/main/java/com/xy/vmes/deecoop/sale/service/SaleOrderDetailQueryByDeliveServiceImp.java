package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.deecoop.sale.dao.SaleOrderDetailQueryByDeliverMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleOrderDetailQueryByDeliveService;
import com.yvan.PageData;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * 说明：订单明细查询汇总实现类
 * 销售-发货管理-生成发货单-(勾选订单明细)-弹出界面查询
 *
 * 创建人：陈刚
 * 创建时间：2018-12-27
 */
@Service
@Transactional(readOnly = false)
public class SaleOrderDetailQueryByDeliveServiceImp implements SaleOrderDetailQueryByDeliveService {
    @Autowired
    private SaleOrderDetailQueryByDeliverMapper orderDetailQueryByDeliverMapper;
    @Autowired
    private ColumnService columnService;

    public List<Map> listOrderDetaiQueryByDeliver(PageData pd) throws Exception{
        return orderDetailQueryByDeliverMapper.listOrderDetaiQueryByDeliver(pd);
    }
    public List<Map> listOrderDetaiQueryByDeliver(PageData pd, Pagination pg) throws Exception{
        return orderDetailQueryByDeliverMapper.listOrderDetaiQueryByDeliver(pd, pg);
    }

    @Override
    public ResultModel listPageOrderDetailQueryByDeliver(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("saleOrderDetailQueryByDeliver");
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

        //订单明细 ids
        String ids = pd.getString("ids");
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            pd.put("orderDtlIds", ids);
        }

//        //设置查询排序
//        pd.put("orderStr", "orderDtl.cdate asc");
//        String orderStr = pd.getString("orderStr");
//        if (orderStr != null && orderStr.trim().length() > 0) {
//            pd.put("orderStr", orderStr);
//        }

        List<Map> varList = this.listOrderDetaiQueryByDeliver(pd);
        if (varList != null && varList.size() > 0) {
            for (Map<String, Object> objectMap : varList) {
                //productStockCount 可发货数量
                BigDecimal productStockCount = BigDecimal.valueOf(0D);
                if (objectMap.get("productStockCount") != null) {
                    productStockCount = (BigDecimal)objectMap.get("productStockCount");
                }

                //notDeliverCount   未发货数量
                BigDecimal notDeliverCount = BigDecimal.valueOf(0D);
                if (objectMap.get("notDeliverCount") != null) {
                    notDeliverCount = (BigDecimal)objectMap.get("notDeliverCount");
                }

                //orderDtlDeliverCount 本次发货数量
                //1. (可发货数量 >= 未发货数量) 本次发货数量:= 未发货数量
                //2. (可发货数量 < 未发货数量) 本次发货数量:= 可发货数量
                BigDecimal orderDtlDeliverCount = BigDecimal.valueOf(0D);
                if (productStockCount.doubleValue() >= notDeliverCount.doubleValue()) {
                    orderDtlDeliverCount = notDeliverCount;
                } else if (productStockCount.doubleValue() < notDeliverCount.doubleValue()) {
                    orderDtlDeliverCount = productStockCount;
                }

                //四舍五入到2位小数
                orderDtlDeliverCount = orderDtlDeliverCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                objectMap.put("orderDtlDeliverCount", orderDtlDeliverCount.toString());

                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //先计价订单：(单价,金额) 页面显示这2列
                //后计价订单：(单价,金额) 页面这两列不显示

                //productPrice 单价
                BigDecimal productPrice = BigDecimal.valueOf(0D);
                if (objectMap.get("productPrice") != null) {
                    productPrice = (BigDecimal)objectMap.get("productPrice");
                }
                //四舍五入到4位小数
                productPrice = productPrice.setScale(Common.SYS_PRICE_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                objectMap.put("productPrice", productPrice.toString());

                //productSum   金额: 单价 * 可发货数量
                BigDecimal productSum = BigDecimal.valueOf(productPrice.doubleValue() * orderDtlDeliverCount.doubleValue());
                //四舍五入到2位小数
                productSum = productSum.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                objectMap.put("productSum", productSum.toString());
            }
        }
        List<Map> varMapList = ColumnUtil.getVarMapList(varList, titleMap);

        Map result = new HashMap();
        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);

//        List<LinkedHashMap> titlesList = new ArrayList<LinkedHashMap>();
//        List<String> titlesHideList = new ArrayList<String>();
//        Map<String, String> varModelMap = new HashMap<String, String>();
//        if(columnList!=null&&columnList.size()>0){
//            for (Column column : columnList) {
//                if(column!=null){
//                    if("0".equals(column.getIshide())){
//                        titlesHideList.add(column.getTitleKey());
//                    }
//                    LinkedHashMap titlesLinkedMap = new LinkedHashMap();
//                    titlesLinkedMap.put(column.getTitleKey(),column.getTitleName());
//                    varModelMap.put(column.getTitleKey(),"");
//                    titlesList.add(titlesLinkedMap);
//                }
//            }
//        }
//        Map result = new HashMap();
//        result.put("hideTitles",titlesHideList);
//        result.put("titles",titlesList);
//
//        //订单明细 ids
//        String ids = pd.getString("ids");
//        if (ids != null && ids.trim().length() > 0) {
//            ids = StringUtil.stringTrimSpace(ids);
//            ids = "'" + ids.replace(",", "','") + "'";
//            pd.put("orderDtlIds", ids);
//        }
//
//        //设置查询排序
//        pd.put("orderStr", "orderDtl.cdate asc");
//        String orderStr = pd.getString("orderStr");
//        if (orderStr != null && orderStr.trim().length() > 0) {
//            pd.put("orderStr", orderStr);
//        }
//
//        List<Map> varMapList = new ArrayList();
//        List<Map> varList = this.listOrderDetaiQueryByDeliver(pd);
//        if(varList!=null&&varList.size()>0){
//            for(int i=0;i<varList.size();i++){
//                Map map = varList.get(i);
//                Map<String, String> varMap = new HashMap<String, String>();
//                varMap.putAll(varModelMap);
//                for (Map.Entry<String, String> entry : varMap.entrySet()) {
//                    varMap.put(entry.getKey(),map.get(entry.getKey())!=null?map.get(entry.getKey()).toString():"");
//                }
//                varMapList.add(varMap);
//            }
//        }
//        result.put("varList",varMapList);

        model.putResult(result);
        return model;
    }
}
