package com.xy.vmes.deecoop.sale.service;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.EvaluateUtil;
import com.xy.vmes.common.util.StringUtil;
import com.yvan.HttpUtils;
import com.xy.vmes.common.util.rabbitmq.sender.ProductStockcountLockSender;
import com.xy.vmes.deecoop.sale.dao.SaleOrderDetailByLockCountMapper;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.SaleOrderDetail;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.SaleLockDateService;
import com.xy.vmes.service.SaleOrderDetailByLockCountService;
import com.xy.vmes.service.SaleOrderDetailService;
import com.yvan.PageData;
import com.yvan.common.util.Common;
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

    public List<Map> findListOrderDetailByLockCount(PageData pd, Pagination pg) throws Exception {
        List<Map> mapList = new ArrayList();
        if (pd == null) {return mapList;}

        if (pg == null) {
            return saleOrderDetailByLockCountMapper.findListOrderDetailByLockCount(pd);
        } else if (pg != null) {
            return saleOrderDetailByLockCountMapper.findListOrderDetailByLockCount(pd, pg);
        }

        return mapList;
    }

    public ResultModel listPageOrderDetailByLockCount(PageData pd) throws Exception {
        ResultModel model = new ResultModel();
        Pagination pg = HttpUtils.parsePagination(pd);

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
        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);

        //设置查询排序
        pd.put("orderStr", "detail.cdate asc");
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

        List<Map> varList = this.findListOrderDetailByLockCount(pd, pg);
        if (varList != null && varList.size() > 0) {
            for (Map<String, Object> objectMap : varList) {
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

                //lockCount (销售订单)货品锁库数量
                BigDecimal lockCount = BigDecimal.valueOf(0D);
                if (objectMap.get("lockCount") != null) {
                    lockCount = (BigDecimal)objectMap.get("lockCount");
                }

                //(单据单位)货品数量///////////////////////////////////////////////////////////////////////////////////////////
                //orderCount 订购数量
                BigDecimal orderCount = BigDecimal.valueOf(0D);
                if (objectMap.get("orderCount") != null) {
                    orderCount = (BigDecimal)objectMap.get("orderCount");
                }

                //deliverCount 发货完成数量 := 已发货数量 - 已退货数量
                BigDecimal deliverCount = BigDecimal.valueOf(0D);
                if (objectMap.get("deliverCount") != null) {
                    deliverCount = (BigDecimal)objectMap.get("deliverCount");
                }

                //allowStockCount (计量单位)可用库存数量 -- (n2pFormula)计量单位转换计价单位
                allowStockCount = EvaluateUtil.countFormulaN2P(allowStockCount, n2pFormula);
                allowStockCount = StringUtil.scaleDecimal(allowStockCount, n2pIsScale, n2pDecimalCount);
                objectMap.put("allowStockCount", allowStockCount.toString());

                //lockCount (销售订单)货品锁库数量 -- (n2pFormula)计量单位转换计价单位
                lockCount = EvaluateUtil.countFormulaN2P(lockCount, n2pFormula);
                lockCount = StringUtil.scaleDecimal(lockCount, n2pIsScale, n2pDecimalCount);
                objectMap.put("lockCount", lockCount.toString());

                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //最大订单订购数量: 订购数量 - 发货完成数量
                BigDecimal maxOrderCount = BigDecimal.valueOf(0D);
                if ((orderCount.doubleValue() - deliverCount.doubleValue()) >= 0 ) {
                    maxOrderCount = BigDecimal.valueOf(orderCount.doubleValue() - deliverCount.doubleValue());
                }
                //四舍五入到2位小数
                maxOrderCount = maxOrderCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);

                //maxLockCount 可锁数量
                //1. (可用库存数量 >= 最大订单订购数量) 可锁数量:= 最大订单订购数量
                //2. (可用库存数量 < 最大订单订购数量) 可锁数量:= 可用库存数量
                BigDecimal maxLockCount = BigDecimal.valueOf(0D);
                if (allowStockCount.doubleValue() >= maxOrderCount.doubleValue()) {
                    maxLockCount = maxOrderCount;
                } else if (allowStockCount.doubleValue() < maxOrderCount.doubleValue()) {
                    maxLockCount = allowStockCount;
                }
                //四舍五入到2位小数
                maxLockCount = maxLockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                objectMap.put("maxLockCount", maxLockCount.toString());

                //editLockCount 修改锁库(默认值)
                //1. (可锁数量 >= (销售订单)货品锁库数量) 修改锁库(默认值):= (销售订单)货品锁库数量
                //2. (可锁数量 < (销售订单)货品锁库数量) 修改锁库(默认值):= 可锁数量
                BigDecimal editLockCount = BigDecimal.valueOf(0D);
                if (maxLockCount.doubleValue() >= lockCount.doubleValue()) {
                    editLockCount = lockCount;
                } else if (maxLockCount.doubleValue() < lockCount.doubleValue()) {
                    editLockCount = maxLockCount;
                }
                //四舍五入到2位小数
                editLockCount = editLockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                objectMap.put("editLockCount", editLockCount.toString());
            }
        }
        List<Map> varMapList = ColumnUtil.getVarMapList(varList, titleMap);

        result.put("hideTitles",titleMap.get("hideTitles"));
        result.put("titles",titleMap.get("titles"));
        result.put("varList",varMapList);

        model.putResult(result);
        return model;


//        //遍历结果集
//        //(计量单位)(库存数量,库存可用数量) 单位换算公式(n2pFormula) (计价单位)(库存数量,库存可用数量)
//        for (Map mapObject : varMapList) {
//            //n2pFormula (计量单位转换计价单位公式)
//            String n2pFormula = (String)mapObject.get("n2pFormula");
//
////            //stockCount (计量单位)库存数量
////            String stockCount_str = (String)mapObject.get("stockCount");
////            //stockCountByPrice        (计价单位)库存数量
////            if (n2pFormula != null && stockCount_str != null) {
////                Map<String, Object> formulaParmMap = new HashMap<String, Object>();
////                formulaParmMap.put("N", new BigDecimal(stockCount_str));
////
////                BigDecimal valueBig = EvaluateUtil.formulaReckon(formulaParmMap, n2pFormula);
////                mapObject.put("stockCountByPrice", valueBig);
////            }
//
//            //productStockCount (计量单位)库存可用数量
//            BigDecimal productStockCount = BigDecimal.valueOf(0D);
//            String productStockCount_str = (String)mapObject.get("productStockCount");
//            if (productStockCount_str != null && productStockCount_str.trim().length() > 0) {
//                try {
//                    productStockCount = new BigDecimal(productStockCount_str);
//                } catch (NumberFormatException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            //productStockCountByPrice (计价单位)库存可用数量
//            BigDecimal valueBig = EvaluateUtil.countFormulaN2P(productStockCount, n2pFormula);
//            mapObject.put("productStockCountByPrice", valueBig);
//
//            //orderCount 订购数量
//            BigDecimal orderCount = BigDecimal.valueOf(0D);
//            if (mapObject.get("orderCount") != null && mapObject.get("orderCount").toString().trim().length() > 0) {
//                String orderCount_str = (String)mapObject.get("orderCount");
//                try {
//                    orderCount = new BigDecimal(orderCount_str);
//                } catch(NumberFormatException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            //deliverCount 发货完成数量
//            BigDecimal deliverCount = BigDecimal.valueOf(0D);
//            if (mapObject.get("deliverCount") != null && mapObject.get("deliverCount").toString().trim().length() > 0) {
//                String deliverCount_str = (String)mapObject.get("deliverCount");
//                try {
//                    deliverCount = new BigDecimal(deliverCount_str);
//                } catch(NumberFormatException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            //maxLockCount 最大锁定数量 (订购数量 - 发货完成数量)
//            BigDecimal maxLockCount = BigDecimal.valueOf(orderCount.doubleValue() - deliverCount.doubleValue());
//            //四舍五入到2位小数
//            maxLockCount = maxLockCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//            mapObject.put("maxLockCount", maxLockCount);
//
//        }
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
