package com.xy.vmes.deecoop.warehouse.service;

import com.xy.vmes.entity.WarehouseOut;
import com.xy.vmes.entity.WarehouseOutDetail;
import com.xy.vmes.entity.WarehouseOutExecute;
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
     * @param warehouseId     仓库id
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
    public void createWarehouseOutByComplex(String deptId,
                                            String deptName,
                                            String warehouseId,
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
            throw new ApplicationException(msgStr.toString());
        }

        //创建出库单
        WarehouseOut warehouseOut = warehouseOutService.createWarehouseOut(deptId,
                deptName,
                cuser,
                companyId,
                outType);

        warehouseOut.setWarehouseId(warehouseId);
        //warehouseAttribute 仓库属性(warehouse:(简版,复杂版)仓库 spare:备件库)
        warehouseOut.setWarehouseAttribute("warehouse");
        warehouseOutService.save(warehouseOut);

        List<WarehouseOutDetail> outDtlList = this.productMap2OutDetailList(productByOutMap, null);
        warehouseOutDetailService.addWarehouseOutDetail(warehouseOut, outDtlList);

        for (WarehouseOutDetail detail : outDtlList) {
            String productId = detail.getProductId();
            String outDtlId = detail.getId();

            Map<String, Object> productMap = productByOutMap.get(productId);
            productMap.put("outDtlId", outDtlId);
        }

    }
    /**
     * 创建出库单(复杂版仓库)
     *
     * @param deptId           (部门,供应商,客户)id
     * @param deptName         (部门,供应商,客户)名称
     * @param warehouseId      仓库id
     * @param cuser            用户id
     * @param companyId        企业id
     * @param outType          出库类型id
     * @param businessByOutMap 业务货品出库Map<货品id, 货品Map>
     *
     * 业务货品出库Map<业务单id, 货品Map<String, Object>> 业务单id-业务明细id (订单明细id,发货单明细id)
     * 货品Map<String, Object>
     *     productId: 货品id
     *     outDtlId:  出库明细id
     *     outCount:  出库数量
     */
    public void createWarehouseOutBusinessByComplex(String deptId,
                                                    String deptName,
                                                    String warehouseId,
                                                    String cuser,
                                                    String companyId,
                                                    String outType,
                                                    Map<String, Map<String, Object>> businessByOutMap) throws Exception {
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
            throw new ApplicationException(msgStr.toString());
        }

        //创建出库单
        WarehouseOut warehouseOut = warehouseOutService.createWarehouseOut(deptId,
                deptName,
                cuser,
                companyId,
                outType);

        warehouseOut.setWarehouseId(warehouseId);
        //warehouseAttribute 仓库属性(warehouse:(简版,复杂版)仓库 spare:备件库)
        warehouseOut.setWarehouseAttribute("warehouse");
        warehouseOutService.save(warehouseOut);

        List<WarehouseOutDetail> outDtlList = this.businessMap2OutDetailList(businessByOutMap, null);
        warehouseOutDetailService.addWarehouseOutDetail(warehouseOut, outDtlList);

        for (WarehouseOutDetail detail : outDtlList) {
            String businessId = detail.getBusinessId();
            String outDtlId = detail.getId();

            Map<String, Object> productMap = businessByOutMap.get(businessId);
            productMap.put("outDtlId", outDtlId);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 创建出库单(简版仓库)
     *
     * @param deptId          (部门,供应商,客户)id
     * @param deptName        (部门,供应商,客户)名称
     * @param warehouseId     仓库id
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
    public void createWarehouseOutBySimple(String deptId,
                                           String deptName,
                                           String warehouseId,
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
            throw new ApplicationException(msgStr.toString());
        }

        //1.添加出库单
        WarehouseOut warehouseOut = warehouseOutService.createWarehouseOut(deptId,
                deptName,
                cuser,
                companyId,
                outType);

        //isSimple 是否简版仓库 Y:是简版 N:非简版 is null:非简版
        //warehouseOut.setIsSimple("Y");
        warehouseOut.setWarehouseId(warehouseId);
        //warehouseAttribute 仓库属性(warehouse:(简版,复杂版)仓库 spare:备件库)
        warehouseOut.setWarehouseAttribute("warehouse");
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

            //按(货品id,企业id) 查询(vmes_warehouse_product)
            List<Map<String, Object>> outMapList = warehouseProductToolService.findWarehouseProductOutMapList(productId,
                    companyId,
                    null,
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
    }
    /**
     * 创建出库单(简版仓库)
     *
     * @param deptId          (部门,供应商,客户)id
     * @param deptName        (部门,供应商,客户)名称
     * @param warehouseId     仓库id
     * @param cuser           用户id
     * @param companyId       企业id
     * @param outType         出库类型id
     * @param businessByOutMap 业务货品出库Map<货品id, 货品Map>
     *
     * 业务货品出库Map<业务单id, 货品Map<String, Object>> 业务单id-业务明细id (订单明细id,发货单明细id)
     * 货品Map<String, Object>
     *     productId: 货品id
     *     outDtlId:  出库明细id
     *     outCount:  出库数量
     */
    public void createWarehouseOutBusinessBySimple(String deptId,
                                                   String deptName,
                                                   String warehouseId,
                                                   String cuser,
                                                   String companyId,
                                                   String outType,
                                                   Map<String, Map<String, Object>> businessByOutMap) throws Exception {
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
            throw new ApplicationException(msgStr.toString());
        }

        //1.添加出库单
        WarehouseOut warehouseOut = warehouseOutService.createWarehouseOut(deptId,
                deptName,
                cuser,
                companyId,
                outType);

        //isSimple 是否简版仓库 Y:是简版 N:非简版 is null:非简版
        //warehouseOut.setIsSimple("Y");
        warehouseOut.setWarehouseId(warehouseId);
        //warehouseAttribute 仓库属性(warehouse:(简版,复杂版)仓库 spare:备件库)
        warehouseOut.setWarehouseAttribute("warehouse");
        warehouseOutService.save(warehouseOut);

        //2.添加出库单明细
        List<WarehouseOutDetail> outDtlList = this.businessMap2OutDetailList(businessByOutMap, null);
        warehouseOutDetailService.addWarehouseOutDetailBySimple(warehouseOut, outDtlList);

        //3.添加出库单派单表
        warehouseOutExecutorService.addWarehouseOutExecutorBySimple(outDtlList);

        //4.添加出库单执行表
        List<WarehouseOutExecute> executeList = new ArrayList<WarehouseOutExecute>();
        for (WarehouseOutDetail outDetail : outDtlList) {
            String productId = outDetail.getProductId();
            BigDecimal count = outDetail.getCount();

            //按(货品id,企业id) 查询(vmes_warehouse_product)
            List<Map<String, Object>> outMapList = warehouseProductToolService.findWarehouseProductOutMapList(productId,
                    companyId,
                    null,
                    count);
            if (outMapList != null && outMapList.size() > 0) {
                executeList = warehouseOutExecuteService.outMapList2ExecuteList(outDetail, outMapList, executeList);
            }
        }
        warehouseOutExecuteService.addWarehouseOutExecuteBySimple(executeList);

        for (WarehouseOutDetail detail : outDtlList) {
            String businessId = detail.getBusinessId();
            String outDtlId = detail.getId();

            Map<String, Object> productMap = businessByOutMap.get(businessId);
            productMap.put("outDtlId", outDtlId);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 创建出库单(备件库)
     *
     * @param deptId          (部门,供应商,客户)id
     * @param deptName        (部门,供应商,客户)名称
     * @param warehouseId     仓库id(备件库id)
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
    public void createWarehouseOutByBySpare(String deptId,
                                            String deptName,
                                            String warehouseId,
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
            throw new ApplicationException(msgStr.toString());
        }

        //1.添加出库单
        WarehouseOut warehouseOut = warehouseOutService.createWarehouseOut(deptId,
                deptName,
                cuser,
                companyId,
                outType);

        //warehouseAttribute 仓库属性(warehouse:(简版,复杂版)仓库 spare:备件库)
        warehouseOut.setWarehouseAttribute("spare");
        warehouseOut.setWarehouseId(warehouseId);
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

            //按(备件库id,货品id,企业id) 查询(vmes_warehouse_product)
            List<Map<String, Object>> outMapList = warehouseProductToolService.findWarehouseProductOutMapList(productId,
                    companyId,
                    //仓库id(备件库id)
                    warehouseId,
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
    }
    /**
     * 创建出库单(备件库)
     *
     * @param deptId          (部门,供应商,客户)id
     * @param deptName        (部门,供应商,客户)名称
     * @param warehouseId     仓库id(备件库id)
     * @param cuser           用户id
     * @param companyId       企业id
     * @param outType         出库类型id
     * @param businessByOutMap 业务货品出库Map<货品id, 货品Map>
     *
     * 业务货品出库Map<业务单id, 货品Map<String, Object>> 业务单id-业务明细id (订单明细id,发货单明细id)
     * 货品Map<String, Object>
     *     productId: 货品id
     *     outDtlId:  出库明细id
     *     outCount:  出库数量
     */
    public void createWarehouseOutBusinessByBySpare(String deptId,
                                                    String deptName,
                                                    String warehouseId,
                                                    String cuser,
                                                    String companyId,
                                                    String outType,
                                                    Map<String, Map<String, Object>> businessByOutMap) throws Exception {
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
            throw new ApplicationException(msgStr.toString());
        }

        //1.添加出库单
        WarehouseOut warehouseOut = warehouseOutService.createWarehouseOut(deptId,
                deptName,
                cuser,
                companyId,
                outType);

        //warehouseAttribute 仓库属性(warehouse:(简版,复杂版)仓库 spare:备件库)
        warehouseOut.setWarehouseAttribute("spare");
        warehouseOut.setWarehouseId(warehouseId);
        warehouseOutService.save(warehouseOut);

        //2.添加出库单明细
        List<WarehouseOutDetail> outDtlList = this.businessMap2OutDetailList(businessByOutMap, null);
        warehouseOutDetailService.addWarehouseOutDetailBySimple(warehouseOut, outDtlList);

        //3.添加出库单派单表
        warehouseOutExecutorService.addWarehouseOutExecutorBySimple(outDtlList);

        //4.添加出库单执行表
        List<WarehouseOutExecute> executeList = new ArrayList<WarehouseOutExecute>();
        for (WarehouseOutDetail outDetail : outDtlList) {
            String productId = outDetail.getProductId();
            BigDecimal count = outDetail.getCount();

            //按(备件库id,货品id,企业id) 查询(vmes_warehouse_product)
            List<Map<String, Object>> outMapList = warehouseProductToolService.findWarehouseProductOutMapList(productId,
                    companyId,
                    //仓库id(备件库id)
                    warehouseId,
                    count);
            if (outMapList != null && outMapList.size() > 0) {
                executeList = warehouseOutExecuteService.outMapList2ExecuteList(outDetail, outMapList, executeList);
            }
        }
        warehouseOutExecuteService.addWarehouseOutExecuteBySimple(executeList);

        for (WarehouseOutDetail detail : outDtlList) {
            String businessId = detail.getBusinessId();
            String outDtlId = detail.getId();

            Map<String, Object> productMap = businessByOutMap.get(businessId);
            productMap.put("outDtlId", outDtlId);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 创建出库单(虚拟库)-与简版出库单类似
     *
     * @param deptId          (部门,供应商,客户)id
     * @param deptName        (部门,供应商,客户)名称
     * @param deptPlaceKey    部门库位key
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
    public void createWarehouseOutByVirtual(String deptId,
                                            String deptName,
                                            String deptPlaceKey,
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
        if (deptPlaceKey == null || deptPlaceKey.trim().length() == 0) {
            msgStr.append("部门库位名称id为空或空字符串" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (msgStr.toString().trim().length() > 0) {
            throw new ApplicationException(msgStr.toString());
        }

        //1.添加出库单
        WarehouseOut warehouseOut = warehouseOutService.createWarehouseOut(deptId,
                deptName,
                cuser,
                companyId,
                outType);

        //虚拟库:warehouseVirtual:56f5e83dcb9911e884ad00163e105f05
        warehouseOut.setWarehouseId(Common.DICTIONARY_MAP.get("warehouseVirtual"));
        //warehouseAttribute 仓库属性(warehouse:(简版,复杂版)仓库 spare:备件库)
        warehouseOut.setWarehouseAttribute("warehouse");
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

            //仓库版本 (warehouseByVirtual:虚拟库)
            List<Map<String, Object>> outMapList = warehouseProductToolService.findWarehouseProductOutMapListByVirtual(productId,
                    companyId,
                    deptId,
                    deptPlaceKey,
                    count);
            if (outMapList != null && outMapList.size() > 0) {
                executeList = warehouseOutExecuteService.outMapList2ExecuteList(outDetail, outMapList, executeList);
            }
        }
        warehouseOutExecuteService.addWarehouseOutExecuteBySimple(executeList);
        //5.出库单执行
        warehouseOutExecuteService.executeWarehouseOutExecuteBySimple(warehouseOut);

        for (WarehouseOutDetail detail : outDtlList) {
            String productId = detail.getProductId();
            String outDtlId = detail.getId();

            Map<String, Object> productMap = productByOutMap.get(productId);
            productMap.put("outDtlId", outDtlId);
        }
    }
    /**
     * 创建出库单(虚拟库)-与简版出库单类似
     *
     * @param deptId           (部门,供应商,客户)id
     * @param deptName         (部门,供应商,客户)名称
     * @param deptPlaceKey     部门库位key
     * @param cuser            用户id
     * @param companyId        企业id
     * @param outType          出库类型id
     * @param businessByOutMap 业务货品出库Map<货品id, 货品Map>
     *
     * 业务货品出库Map<业务单id, 货品Map<String, Object>> 业务单id-业务明细id (订单明细id,发货单明细id)
     * 货品Map<String, Object>
     *     productId: 货品id
     *     outDtlId:  出库明细id
     *     outCount:  出库数量
     */
    public void createWarehouseOutBusinessByVirtual(String deptId,
                                                    String deptName,
                                                    String deptPlaceKey,
                                                    String cuser,
                                                    String companyId, String outType,
                                                    Map<String, Map<String, Object>> businessByOutMap) throws Exception {
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
        if (deptPlaceKey == null || deptPlaceKey.trim().length() == 0) {
            msgStr.append("部门库位名称id为空或空字符串" + Common.SYS_ENDLINE_DEFAULT);
        }
        if (msgStr.toString().trim().length() > 0) {
            throw new ApplicationException(msgStr.toString());
        }

        //1.添加出库单
        WarehouseOut warehouseOut = warehouseOutService.createWarehouseOut(deptId,
                deptName,
                cuser,
                companyId,
                outType);

        //虚拟库:warehouseVirtual:56f5e83dcb9911e884ad00163e105f05
        warehouseOut.setWarehouseId(Common.DICTIONARY_MAP.get("warehouseVirtual"));
        //warehouseAttribute 仓库属性(warehouse:(简版,复杂版)仓库 spare:备件库)
        warehouseOut.setWarehouseAttribute("warehouse");
        warehouseOutService.save(warehouseOut);

        //2.添加出库单明细
        List<WarehouseOutDetail> outDtlList = this.businessMap2OutDetailList(businessByOutMap, null);
        warehouseOutDetailService.addWarehouseOutDetailBySimple(warehouseOut, outDtlList);

        //3.添加出库单派单表
        warehouseOutExecutorService.addWarehouseOutExecutorBySimple(outDtlList);

        //4.添加出库单执行表
        List<WarehouseOutExecute> executeList = new ArrayList<WarehouseOutExecute>();
        for (WarehouseOutDetail outDetail : outDtlList) {
            String productId = outDetail.getProductId();
            BigDecimal count = outDetail.getCount();

            //仓库版本 (warehouseByVirtual:虚拟库)
            List<Map<String, Object>> outMapList = warehouseProductToolService.findWarehouseProductOutMapListByVirtual(productId,
                    companyId,
                    deptId,
                    deptPlaceKey,
                    count);
            if (outMapList != null && outMapList.size() > 0) {
                executeList = warehouseOutExecuteService.outMapList2ExecuteList(outDetail, outMapList, executeList);
            }
        }
        warehouseOutExecuteService.addWarehouseOutExecuteBySimple(executeList);
        //5.出库单执行
        warehouseOutExecuteService.executeWarehouseOutExecuteBySimple(warehouseOut);

        for (WarehouseOutDetail detail : outDtlList) {
            String businessId = detail.getBusinessId();
            String outDtlId = detail.getId();

            Map<String, Object> productMap = businessByOutMap.get(businessId);
            productMap.put("outDtlId", outDtlId);
        }
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

    private List<WarehouseOutDetail> businessMap2OutDetailList(Map<String, Map<String, Object>> businessByOutMap, List<WarehouseOutDetail> detailList) {
        if (detailList == null) {detailList = new ArrayList<WarehouseOutDetail>();}
        if (businessByOutMap == null || businessByOutMap.size() == 0) {return detailList;}

        for (Iterator iterator = businessByOutMap.keySet().iterator(); iterator.hasNext();) {
            WarehouseOutDetail detail = new WarehouseOutDetail();

            String mapKey = (String) iterator.next();
            detail.setBusinessId(mapKey);

            Map<String, Object> productMap = businessByOutMap.get(mapKey);

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
