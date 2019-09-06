package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yvan.common.util.Common;
import com.xy.vmes.common.util.EvaluateUtil;
import com.xy.vmes.common.util.rabbitmq.sender.ProductStockcountLockSender;
import com.xy.vmes.deecoop.sale.dao.SaleOrderDetailByLockCountMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.SaleOrderDetail;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleLockDateService;
import com.xy.vmes.service.SaleOrderDetailByLockCountService;
import com.xy.vmes.service.SaleOrderDetailService;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

@Service
@Transactional(readOnly = false)
public class SaleOrderDetailByLockCountServiceImp implements SaleOrderDetailByLockCountService {
    @Autowired
    private SaleOrderDetailByLockCountMapper saleOrderDetailByLockCountMapper;
    @Autowired
    private SaleOrderDetailService saleOrderDetailService;
    @Autowired
    private SaleLockDateService saleLockDateService;
    @Autowired
    private ColumnService columnService;

    //消息队列
    @Autowired
    private ProductStockcountLockSender firstSender;

    public List<Map> findListOrderDetailByLockCount(PageData pd) throws Exception {
        return saleOrderDetailByLockCountMapper.findListOrderDetailByLockCount(pd);
    }
    public List<Map> findListOrderDetailByLockCount(PageData pd, Pagination pg) throws Exception {
        return saleOrderDetailByLockCountMapper.findListOrderDetailByLockCount(pd, pg);
    }

    public ResultModel listPageOrderDetailByLockCount(PageData pd) throws Exception {
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("saleOrderDetailByLockCount");
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

        String queryStr = pd.getString("queryStr");
        if (queryStr != null && queryStr.trim().length() > 0) {
            pd.put("queryStr", queryStr.trim());
        }

        //设置查询排序
        pd.put("orderStr", "detail.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        List<Map> varMapList = new ArrayList();
        List<Map> varList = this.findListOrderDetailByLockCount(pd);
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

        //遍历结果集
        //(计量单位)(库存数量,库存可用数量) 单位换算公式(n2pFormula) (计价单位)(库存数量,库存可用数量)
        for (Map mapObject : varMapList) {
            //n2pFormula (计量单位转换计价单位公式)
            String n2pFormula = (String)mapObject.get("n2pFormula");

//            //stockCount (计量单位)库存数量
//            String stockCount_str = (String)mapObject.get("stockCount");
//            //stockCountByPrice        (计价单位)库存数量
//            if (n2pFormula != null && stockCount_str != null) {
//                Map<String, Object> formulaParmMap = new HashMap<String, Object>();
//                formulaParmMap.put("N", new BigDecimal(stockCount_str));
//
//                BigDecimal valueBig = EvaluateUtil.formulaReckon(formulaParmMap, n2pFormula);
//                mapObject.put("stockCountByPrice", valueBig);
//            }

            //productStockCount (计量单位)库存可用数量
            BigDecimal productStockCount = BigDecimal.valueOf(0D);
            String productStockCount_str = (String)mapObject.get("productStockCount");
            if (productStockCount_str != null && productStockCount_str.trim().length() > 0) {
                try {
                    productStockCount = new BigDecimal(productStockCount_str);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            //productStockCountByPrice (计价单位)库存可用数量
            BigDecimal valueBig = EvaluateUtil.countFormulaN2P(productStockCount, n2pFormula);
            mapObject.put("productStockCountByPrice", valueBig);

            //orderCount 订购数量
            BigDecimal orderCount = BigDecimal.valueOf(0D);
            if (mapObject.get("orderCount") != null && mapObject.get("orderCount").toString().trim().length() > 0) {
                String orderCount_str = (String)mapObject.get("orderCount");
                try {
                    orderCount = new BigDecimal(orderCount_str);
                } catch(NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            //deliverCount 发货完成数量
            BigDecimal deliverCount = BigDecimal.valueOf(0D);
            if (mapObject.get("deliverCount") != null && mapObject.get("deliverCount").toString().trim().length() > 0) {
                String deliverCount_str = (String)mapObject.get("deliverCount");
                try {
                    deliverCount = new BigDecimal(deliverCount_str);
                } catch(NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            //maxLockCount 最大锁定数量 (订购数量 - 发货完成数量)
            BigDecimal maxLockCount = BigDecimal.valueOf(orderCount.doubleValue() - deliverCount.doubleValue());
            //四舍五入到2位小数
            maxLockCount = maxLockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            mapObject.put("maxLockCount", maxLockCount);

        }
        result.put("varList",varMapList);

        model.putResult(result);
        return model;
    }

    /**
     * 更新锁定库存版本号
     * 1. 根据(企业id)获取订单明细表(vmes_sale_order_detail)
     * 2. 字段 version_lock_count 加一
     *
     * @param companyId  企业id
     */
    public void updateVersionLockCount(String companyId) throws Exception {
        if (companyId == null || companyId.trim().length() == 0) {return;}

        //获取企业id对应的锁定库存时长(毫秒)
        Long lockTime = saleLockDateService.findLockDateMillisecondByCompanyId(companyId);

        PageData findMap = new PageData();
        findMap.put("companyId", companyId);
        findMap.put("queryStr", "lock_count <> 0 ");

        List<SaleOrderDetail> orderDtlList = saleOrderDetailService.findSaleOrderDetailList(findMap);
        if (orderDtlList == null || orderDtlList.size() == 0) {return;}

        for (SaleOrderDetail orderDtl : orderDtlList) {
            SaleOrderDetail orderDtlEdit = new SaleOrderDetail();
            orderDtlEdit.setId(orderDtl.getId());

            Integer versionLockCount = Integer.valueOf(0);
            if (orderDtl.getVersionLockCount() != null) {
                versionLockCount = Integer.valueOf(orderDtl.getVersionLockCount().intValue() + 1);
            }
            orderDtlEdit.setVersionLockCount(versionLockCount);

            //将订单明细id作为消息体放入消息队列中，消息时长(毫秒)-根据企业id查询(vmes_sale_lock_date)
            //信息队列信息:(订单明细id,锁定库存版本号,,)
            String orderDtl_activeMQ_temp = "{0},{1}";
            String orderDtl_activeMQ_msg = MessageFormat.format(orderDtl_activeMQ_temp,
                    orderDtlEdit.getId(),
                    orderDtlEdit.getVersionLockCount());

            if (lockTime != null && lockTime.longValue() > 0) {
                try {
                    firstSender.sendMsg(orderDtl_activeMQ_msg, lockTime.intValue());
                    saleOrderDetailService.update(orderDtlEdit);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
