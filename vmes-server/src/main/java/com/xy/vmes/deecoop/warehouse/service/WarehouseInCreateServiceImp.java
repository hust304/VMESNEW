package com.xy.vmes.deecoop.warehouse.service;

import com.xy.vmes.entity.Warehouse;
import com.xy.vmes.entity.WarehouseIn;
import com.xy.vmes.entity.WarehouseInDetail;
import com.xy.vmes.exception.ApplicationException;
import com.xy.vmes.service.*;
import com.yvan.common.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 说明：创建入库单 (vmes_warehouse_in:仓库入库单)
 * 1. 创建复杂版仓库(入库单)
 * 2. 创建简版仓库(入库单)
 *
 * 创建人：陈刚
 * 创建时间：2019-07-03
 */
@Service
@Transactional(readOnly = false)
public class WarehouseInCreateServiceImp implements WarehouseInCreateService {
    @Autowired
    private WarehouseInService warehouseInService;
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;

    @Autowired
    private WarehouseToolService warehouseToolService;

    /**
     * 创建入库单(复杂版仓库)
     *
     * @param deptId          (部门,供应商,客户)id
     * @param deptName        (部门,供应商,客户)名称
     * @param warehouseId     仓库id
     * @param cuser           用户id
     * @param companyId       企业id
     * @param inType          入库类型id
     * @param productByInMap  货品入库Map<货品id, 货品Map>
     *
     * 货品入库Map<货品id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     */
    public void createWarehouseInByComplex(String deptId,
                                           String deptName,
                                           String warehouseId,
                                           String cuser,
                                           String companyId,
                                           String inType,
                                           Map<String, Map<String, Object>> productByInMap) throws Exception {
        StringBuffer msgStr = new StringBuffer();
        if (deptId == null || deptId.trim().length() == 0) {
            msgStr.append("部门id为空或空字符串" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (companyId == null || companyId.trim().length() == 0) {
            msgStr.append("企业id为空或空字符串" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (inType == null || inType.trim().length() == 0) {
            msgStr.append("入库类型id为空或空字符串" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (msgStr.toString().trim().length() > 0) {
            throw new ApplicationException(msgStr.toString());
        }

        //创建入库单
        WarehouseIn warehouseIn = warehouseInService.createWarehouseIn(deptId,
                deptName,
                cuser,
                companyId,
                inType);
        warehouseIn.setWarehouseId(warehouseId);
        warehouseInService.save(warehouseIn);

        //创建入库单明细
        List<WarehouseInDetail> inDtlList = this.productMap2InDetailList(productByInMap, null);
        warehouseInDetailService.addWarehouseInDetail(warehouseIn, inDtlList);

        for (WarehouseInDetail detail : inDtlList) {
            String productId = detail.getProductId();
            String inDtlId = detail.getId();

            Map<String, Object> productMap = productByInMap.get(productId);
            productMap.put("inDtlId", inDtlId);
        }
    }

    /**
     * 创建入库单(简版仓库)
     *
     * @param deptId          (部门,供应商,客户)id
     * @param deptName        (部门,供应商,客户)名称
     * @param warehouseId     仓库id
     * @param cuser           用户id
     * @param companyId       企业id
     * @param inType          入库类型id
     * @param productByInMap  货品入库Map<货品id, 货品Map>
     *
     * 货品入库Map<货品id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     */
    public void createWarehouseInBySimple(String deptId,
                                          String deptName,
                                          String warehouseId,
                                          String cuser,
                                          String companyId,
                                          String inType,
                                          Map<String, Map<String, Object>> productByInMap) throws Exception {
        StringBuffer msgStr = new StringBuffer();
        if (deptId == null || deptId.trim().length() == 0) {
            msgStr.append("部门id为空或空字符串" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (companyId == null || companyId.trim().length() == 0) {
            msgStr.append("企业id为空或空字符串" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (inType == null || inType.trim().length() == 0) {
            msgStr.append("入库类型id为空或空字符串" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (msgStr.toString().trim().length() > 0) {
            throw new ApplicationException(msgStr.toString());
        }

        //创建入库单
        WarehouseIn warehouseIn = warehouseInService.createWarehouseIn(deptId,
                deptName,
                cuser,
                companyId,
                inType);

        //isSimple 是否简版仓库 Y:是简版 N:非简版 is null:非简版
        warehouseIn.setIsSimple("Y");
        warehouseIn.setWarehouseId(warehouseId);
        warehouseInService.save(warehouseIn);

        //创建入库单明细
        List<WarehouseInDetail> inDtlList = this.productMap2InDetailList(productByInMap, null);
        warehouseInDetailService.addWarehouseInDetailBySimple(warehouseIn, inDtlList);

        for (WarehouseInDetail detail : inDtlList) {
            String productId = detail.getProductId();
            String inDtlId = detail.getId();

            Map<String, Object> productMap = productByInMap.get(productId);
            productMap.put("inDtlId", inDtlId);
        }
    }

    /**
     * 创建入库单(虚拟库)-与简版入库单类似
     *
     * @param deptId          (部门,供应商,客户)id
     * @param deptName        (部门,供应商,客户)名称
     * @param deptPlaceKey    部门库位key
     * @param deptPlaceName   部门库位名称
     * @param cuser           用户id
     * @param companyId       企业id
     * @param inType          入库类型id
     * @param productByInMap  货品入库Map<货品id, 货品Map>
     *
     * 货品入库Map<货品id, 货品Map<String, Object>>
     * 货品Map<String, Object>
     *     productId: 货品id
     *     inDtlId:   入库明细id
     *     inCount:   入库数量
     */
    public void createWarehouseInByVirtual(String deptId,
                                           String deptName,
                                           String deptPlaceKey,
                                           String deptPlaceName,
                                           String cuser,
                                           String companyId,
                                           String inType,
                                           Map<String, Map<String, Object>> productByInMap) throws Exception {
        StringBuffer msgStr = new StringBuffer();
        if (deptId == null || deptId.trim().length() == 0) {
            msgStr.append("部门id为空或空字符串" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (companyId == null || companyId.trim().length() == 0) {
            msgStr.append("企业id为空或空字符串" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (inType == null || inType.trim().length() == 0) {
            msgStr.append("入库类型id为空或空字符串" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (deptPlaceKey == null || deptPlaceKey.trim().length() == 0) {
            msgStr.append("部门库位名称id为空或空字符串" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (msgStr.toString().trim().length() > 0) {
            throw new ApplicationException(msgStr.toString());
        }

        //虚拟库位-(虚拟库-部门名称-部门货位名称)
        Warehouse warehouse = warehouseToolService.findWarehouseByVirtual(companyId,
                deptId,
                deptName,
                deptPlaceKey,
                deptPlaceName);

        //创建入库单
        WarehouseIn warehouseIn = warehouseInService.createWarehouseIn(deptId,
                deptName,
                cuser,
                companyId,
                inType);

        //虚拟库:warehouseVirtual:56f5e83dcb9911e884ad00163e105f05
        warehouseIn.setWarehouseId(Common.DICTIONARY_MAP.get("warehouseVirtual"));
        warehouseInService.save(warehouseIn);

        //创建入库单明细
        List<WarehouseInDetail> inDtlList = this.productMap2InDetailList(productByInMap, null, warehouse.getId());
        warehouseInDetailService.addWarehouseInDetailBySimple(warehouseIn, inDtlList);
        //入库单明细-入库执行
        warehouseInDetailService.executeWarehouseInDetailBySimple(warehouseIn, inDtlList);

        for (WarehouseInDetail detail : inDtlList) {
            String productId = detail.getProductId();
            String inDtlId = detail.getId();

            Map<String, Object> productMap = productByInMap.get(productId);
            productMap.put("inDtlId", inDtlId);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private List<WarehouseInDetail> productMap2InDetailList(Map<String, Map<String, Object>> productByInMap, List<WarehouseInDetail> detailList) {
        if (detailList == null) {detailList = new ArrayList<WarehouseInDetail>();}
        if (productByInMap == null || productByInMap.size() == 0) {return detailList;}

        for (Iterator iterator = productByInMap.keySet().iterator(); iterator.hasNext();) {
            WarehouseInDetail detail = new WarehouseInDetail();

            String mapKey = (String) iterator.next();
            Map<String, Object> productMap = productByInMap.get(mapKey);

            //productId: 货品id
            String productId = (String)productMap.get("productId");
            detail.setProductId(productId);

            //inCount:   入库数量
            BigDecimal inCount = BigDecimal.valueOf(0D);
            if (productMap.get("inCount") != null) {
                inCount = (BigDecimal)productMap.get("inCount");
            }
            //四舍五入到2位小数
            inCount = inCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            detail.setCount(inCount);

            detailList.add(detail);
        }

        return detailList;
    }

    private List<WarehouseInDetail> productMap2InDetailList(Map<String, Map<String, Object>> productByInMap, List<WarehouseInDetail> detailList, String warehouseId) {
        if (detailList == null) {detailList = new ArrayList<WarehouseInDetail>();}
        if (productByInMap == null || productByInMap.size() == 0) {return detailList;}

        for (Iterator iterator = productByInMap.keySet().iterator(); iterator.hasNext();) {
            WarehouseInDetail detail = new WarehouseInDetail();

            String mapKey = (String) iterator.next();
            Map<String, Object> productMap = productByInMap.get(mapKey);

            //productId: 货品id
            String productId = (String)productMap.get("productId");
            detail.setProductId(productId);

            //inCount:   入库数量
            BigDecimal inCount = BigDecimal.valueOf(0D);
            if (productMap.get("inCount") != null) {
                inCount = (BigDecimal)productMap.get("inCount");
            }
            //四舍五入到2位小数
            inCount = inCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            detail.setCount(inCount);

            //(推荐)货位ID warehouseId
            detail.setWarehouseId(warehouseId);

            detailList.add(detail);
        }

        return detailList;
    }

}
