package com.xy.vmes.deecoop.warehouse.service;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.entity.WarehouseOut;
import com.xy.vmes.entity.WarehouseOutDetail;
import com.xy.vmes.entity.WarehouseOutExecute;
import com.xy.vmes.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 说明：创建出库单 (vmes_warehouse_out:仓库出库单)
 * 1. 创建复杂版仓库(出库单)
 * 2. 创建简版仓库(出库单)
 *
 * 创建人：陈刚
 * 创建时间：2019-07-03
 */
@Service
@Transactional(readOnly = false)
public class WarehouseOutCreateServiceImp implements WarehouseOutCreateService {
    @Autowired
    private WarehouseOutService warehouseOutService;
    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;
    @Autowired
    private WarehouseOutExecutorService warehouseOutExecutorService;
    @Autowired
    private WarehouseOutExecuteService warehouseOutExecuteService;

    @Autowired
    private WarehouseProductToolService warehouseProductToolService;

    /**
     * 创建出库单(复杂版仓库)
     *
     * @param deptId          (部门,供应商,客户)id
     * @param deptName        (部门,供应商,客户)名称
     * @param cuser           用户id
     * @param companyId       企业id
     * @param outType         出库类型id
     * @param productByOutMap 货品出库Map<货品id, 货品Map>
     *
     * 货品出库Map<货品id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     outDtlId:  出库明细id
     *     outCount:  出库数量
     */
    public String createWarehouseOutByComplex(String deptId,
                                              String deptName,
                                              String cuser,
                                              String companyId,
                                              String outType,
                                              Map<String, Map<String, Object>> productByOutMap) throws Exception {
        StringBuffer msgStr = new StringBuffer();
        if (deptId == null || deptId.trim().length() == 0) {
            msgStr.append("部门id为空或空字符串" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (companyId == null || companyId.trim().length() == 0) {
            msgStr.append("企业id为空或空字符串" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (outType == null || outType.trim().length() == 0) {
            msgStr.append("出库类型id为空或空字符串" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (msgStr.toString().trim().length() > 0) {
            return msgStr.toString();
        }

        //创建出库单
        WarehouseOut warehouseOut = warehouseOutService.createWarehouseOut(deptId,
                deptName,
                cuser,
                companyId,
                outType);

        //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
        warehouseOut.setWarehouseId(Common.DICTIONARY_MAP.get("warehouseEntity"));
        warehouseOutService.save(warehouseOut);

        List<WarehouseOutDetail> outDtlList = this.productMap2OutDetailList(productByOutMap, null);
        warehouseOutDetailService.addWarehouseOutDetail(warehouseOut, outDtlList);

        for (WarehouseOutDetail detail : outDtlList) {
            String productId = detail.getProductId();
            String outDtlId = detail.getId();

            Map<String, Object> productMap = productByOutMap.get(productId);
            productMap.put("outDtlId", outDtlId);
        }

        return msgStr.toString();
    }

    /**
     * 创建出库单(简版仓库)
     *
     * @param deptId          (部门,供应商,客户)id
     * @param deptName        (部门,供应商,客户)名称
     * @param cuser           用户id
     * @param companyId       企业id
     * @param outType         出库类型id
     * @param productByOutMap 货品出库Map<货品id, 货品Map>
     *
     * 货品出库Map<货品id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     outDtlId:  出库明细id
     *     outCount:  出库数量
     */
    public String createWarehouseOutBySimple(String deptId,
                                             String deptName,
                                             String cuser,
                                             String companyId,
                                             String outType,
                                           Map<String, Map<String, Object>> productByOutMap) throws Exception {
        StringBuffer msgStr = new StringBuffer();
        if (deptId == null || deptId.trim().length() == 0) {
            msgStr.append("部门id为空或空字符串" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (companyId == null || companyId.trim().length() == 0) {
            msgStr.append("企业id为空或空字符串" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (outType == null || outType.trim().length() == 0) {
            msgStr.append("出库类型id为空或空字符串" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (msgStr.toString().trim().length() > 0) {
            return msgStr.toString();
        }

        //1.添加出库单
        WarehouseOut warehouseOut = warehouseOutService.createWarehouseOut(deptId,
                deptName,
                cuser,
                companyId,
                outType);

        //isSimple 是否简版仓库 Y:是简版 N:非简版 is null:非简版
        warehouseOut.setIsSimple("Y");

        //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
        warehouseOut.setWarehouseId(Common.DICTIONARY_MAP.get("warehouseEntity"));
        warehouseOutService.save(warehouseOut);

        //2.添加出库单明细
        List<WarehouseOutDetail> outDtlList = this.productMap2OutDetailList(productByOutMap, null);
        warehouseOutDetailService.addWarehouseOutDetailBySimple(warehouseOut, outDtlList);

        //3.添加出库单派单表
        warehouseOutExecutorService.addWarehouseOutExecutorBySimple(outDtlList);

        //4.添加出库单执行表
        List<WarehouseOutExecute> executeList = new ArrayList<WarehouseOutExecute>();
        for (WarehouseOutDetail outDetail : outDtlList) {
            String productId = outDetail.getProductId();
            BigDecimal count = outDetail.getCount();

            //仓库版本 (warehouseByComplex:复杂版仓库 warehouseBySimple:简版仓库)
            List<Map<String, Object>> outMapList = warehouseProductToolService.findWarehouseProductOutMapList(productId,
                    companyId,
                    Common.SYS_WAREHOUSE_SIMPLE,
                    count);
            if (outMapList != null && outMapList.size() > 0) {
                executeList = warehouseOutExecuteService.outMapList2ExecuteList(outDetail, outMapList, executeList);
            }
        }
        warehouseOutExecuteService.addWarehouseOutExecuteBySimple(executeList);

        for (WarehouseOutDetail detail : outDtlList) {
            String productId = detail.getProductId();
            String outDtlId = detail.getId();

            Map<String, Object> productMap = productByOutMap.get(productId);
            productMap.put("outDtlId", outDtlId);
        }

        return msgStr.toString();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private List<WarehouseOutDetail> productMap2OutDetailList(Map<String, Map<String, Object>> productByOutMap, List<WarehouseOutDetail> detailList) {
        if (detailList == null) {detailList = new ArrayList<WarehouseOutDetail>();}
        if (productByOutMap == null || productByOutMap.size() == 0) {return detailList;}

        for (Iterator iterator = productByOutMap.keySet().iterator(); iterator.hasNext();) {
            WarehouseOutDetail detail = new WarehouseOutDetail();

            String mapKey = (String) iterator.next();
            Map<String, Object> productMap = productByOutMap.get(mapKey);

            //productId: 货品id
            String productId = (String)productMap.get("productId");
            detail.setProductId(productId);

            //outCount:  出库数量
            BigDecimal outCount = BigDecimal.valueOf(0D);
            if (productMap.get("outCount") != null) {
                outCount = (BigDecimal)productMap.get("outCount");
            }
            //四舍五入到2位小数
            outCount = outCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            detail.setCount(outCount);

            detailList.add(detail);
        }

        return detailList;
    }
}
