package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.Common;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.TableVersionException;
import com.xy.vmes.service.*;
import com.yvan.Conv;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 说明：入库派单明细执行
 * @author 陈刚 自动生成
 * @date 2018-10-18
 */
@RestController
@Slf4j
public class WarehouseInExecuteController {
    private Logger logger = LoggerFactory.getLogger(WarehouseInDispatchController.class);

    @Autowired
    private WarehouseInService warehouseInService;
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;
    @Autowired
    WarehouseInExecutorService warehouseInExecutorService;
    @Autowired
    private WarehouseInExecuteService warehouseInExecuteService;
    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private ProductService productService;

    @Autowired
    private ColumnService columnService;

    /**
     * (入库管理-任务列表)获取入库单执行列表
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouseInExecute/findListWarehouseInExecuteByEdit")
    public ResultModel findListWarehouseInExecuteByEdit() throws Exception {
        logger.info("################warehouseInExecute/findListWarehouseInExecuteByEdit 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Map result = new HashMap();

        //A. 第一级: 获取入库单明细Title列表
        List<Column> columnList = columnService.findColumnList("warehouseInDetail");
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

        //B. 第二级: 获取入库单明细执行人Title列表
        columnList = columnService.findColumnList("warehouseInExecuteByEdit");
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
        String companyId = pd.getString("currentCompanyId");
        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varMapList = new ArrayList();
        List<Map> varList = warehouseInDetailService.getDataListPage(pd, pg);
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
                varMap.put("children", this.findSecondList(map, secondTitleMap ,companyId));
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseInExecute/findListWarehouseInExecuteByEdit 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增入库单明细执行
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouseInExecute/addWarehouseInExecute")
    @Transactional
    public ResultModel addWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/addWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");

        String executeJsonStr = pageData.getString("executeJsonStr");
        if (executeJsonStr == null || executeJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少填写一条入库数据！");
            return model;
        }

        List<Map<String, Object>> mapList = (List<Map<String, Object>>) YvanUtil.jsonToList(executeJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细执行 Json字符串-转换成List错误！");
            return model;
        }

        StringBuffer msgBuf = new StringBuffer();
        try {
            for (Map<String, Object> warehouseInDetailMap : mapList) {
                Object executeObj = warehouseInDetailMap.get("children");
                if (executeObj == null) {continue;}

                List executeList = (List)executeObj;
                if (executeList == null || executeList.size() == 0) {continue;}

                //入库单明细 warehouseInDetailMap
                //界面上 model_code := 'warehouseInDetail' 中获得
                String parentId = (String)warehouseInDetailMap.get("parentId");
                String productId = (String)warehouseInDetailMap.get("productId");
                String detailId = (String)warehouseInDetailMap.get("id");
                //批次号
                String code = (String)warehouseInDetailMap.get("code");

                //入库执行明细 executeMap
                // 界面上 model_code := 'warehouseInExecutorByAddExecute' 中获得
                for (int i = 0; i < executeList.size(); i++) {
                    Map<String, Object> executeMap = (Map<String, Object>)executeList.get(i);
                    //入库货位id warehouseId
                    String warehouseId = (String)executeMap.get("warehouseId");
                    //入库数量 count
                    String count = (String)executeMap.get("count");

                    BigDecimal count_Big = BigDecimal.valueOf(0D);
                    if (count != null && count.trim().length() > 0) {
                        try {
                            count_Big = new BigDecimal(count);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }

                    //入库操作
                    WarehouseProduct inObject = new WarehouseProduct();
                    //货位批次号
                    inObject.setCode(code);
                    //产品ID
                    inObject.setProductId(productId);
                    //(实际)货位ID
                    inObject.setWarehouseId(warehouseId);

                    //库存变更日志
                    String executeId = Conv.createUuid();

                    WarehouseLoginfo loginfo = new WarehouseLoginfo();
                    loginfo.setParentId(parentId);
                    loginfo.setDetailId(detailId);
                    loginfo.setExecuteId(executeId);
                    loginfo.setCompanyId(companyId);
                    loginfo.setCuser(cuser);
                    //operation 操作类型(add:添加 modify:修改 delete:删除:)
                    loginfo.setOperation("add");

                    //beforeCount 操作变更前数量(业务相关)
                    loginfo.setBeforeCount(BigDecimal.valueOf(0D));
                    //afterCount 操作变更后数量(业务相关)
                    loginfo.setAfterCount(count_Big);

                    String msgStr = warehouseProductService.inStockCount(inObject, count_Big, loginfo);
                    if (msgStr != null && msgStr.trim().length() > 0) {
                        msgBuf.append("第 " + (i+1) + " 条: " + "入库操作失败:" + msgStr);
                    } else {
                        WarehouseInExecute execute = new WarehouseInExecute();
                        execute.setId(executeId);
                        execute.setExecutorId(executeId);
                        execute.setDetailId(detailId);
                        execute.setWarehouseId(warehouseId);
                        execute.setExecutorId(cuser);
                        execute.setCount(count_Big);
                        execute.setCuser(cuser);
                        warehouseInExecuteService.save(execute);

                        Product product = productService.findProductById(productId);
                        BigDecimal prodCount = BigDecimal.valueOf(0D);
                        if (product.getStockCount() != null) {
                            prodCount = product.getStockCount();
                        }

                        BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + count_Big.doubleValue());
                        productService.updateStockCount(product, prodStockCount, cuser);
                    }
                }

                //2. 修改修改当前入库单明细状态--同时反写入库单状态
                List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(parentId);
                warehouseInDetailService.updateStateWarehouseInDetail(detailList);
            }

        } catch (TableVersionException tabExc) {
            //库存变更 version 锁
            if (Common.SYS_STOCKCOUNT_ERRORCODE.equals(tabExc.getErrorCode())) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(tabExc.getMessage());
                return model;
            }
        }

        if (msgBuf.toString().trim().length() > 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg(msgBuf.toString());
            return model;
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInExecute/addWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (退单)取消入库单明细执行
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouseInExecute/rebackWarehouseInExecute")
    @Transactional
    public ResultModel rebackWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/rebackWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");

        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细id为空或空字符串！");
            return model;
        }

        String remark = pageData.getString("remark");
        if (remark == null || remark.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退单原因为空或空字符串，退单原因为必填不可为空！");
            return model;
        }

        WarehouseInDetail detail = warehouseInDetailService.findWarehouseInDetailById(detailId);

        //根据入库单明细id-获取该入库单明细中-所有入库执行List
        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        findMap.put("executorId", cuser);
        //是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));

        List<WarehouseInExecute> executeList = warehouseInExecuteService.findWarehouseInExecuteList(findMap);
        List<WarehouseInExecutor> executorList = warehouseInExecutorService.findWarehouseInExecutorList(findMap);

        if (executeList == null || executeList.size() == 0) {return model;}

        StringBuffer msgBuf = new StringBuffer();
        try {
            //A. 入库执行明细-库存数量退回
            for (int i = 0; i < executeList.size(); i++) {
                WarehouseInExecute execute = executeList.get(i);

                //入库数量 count
                if (execute.getCount() == null) {continue;}

                //入库操作
                WarehouseProduct inObject = new WarehouseProduct();
                //货位批次号
                inObject.setCode(detail.getCode());
                //产品ID
                inObject.setProductId(detail.getProductId());
                //(实际)货位ID
                inObject.setWarehouseId(execute.getWarehouseId());

                //入库数量(大于零或小于零)--小于零)反向操作(撤销入库)
                double count = -1 * execute.getCount().doubleValue();

                //库存变更日志
                WarehouseLoginfo loginfo = new WarehouseLoginfo();
                loginfo.setParentId(detail.getParentId());
                loginfo.setDetailId(detail.getId());
                loginfo.setExecuteId(execute.getId());

                loginfo.setCompanyId(companyId);
                loginfo.setCuser(cuser);
                //operation 操作类型(add:添加 modify:修改 delete:删除 reback:退单)
                loginfo.setOperation("reback");

                //beforeCount 操作变更前数量(业务相关)
                loginfo.setBeforeCount(execute.getCount());
                //afterCount 操作变更后数量(业务相关)
                loginfo.setAfterCount(BigDecimal.valueOf(execute.getCount().doubleValue() + count));

                //(修改库存数量)退回已经入库数量
                String msgStr = warehouseProductService.inStockCount(inObject, BigDecimal.valueOf(count), loginfo);
                if (msgStr != null && msgStr.trim().length() > 0) {
                    msgBuf.append("第 " + (i+1) + " 条: " + "入库操作失败:" + msgStr);
                }
            }

            if (msgBuf.toString().trim().length() > 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(msgBuf.toString());
                return model;
            } else {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String strTemp = " 退单原因:{0} 操作时间：{1} ";
                String remarkStr = MessageFormat.format(remark, dateFormat.format(new Date()));

                //B. 修改入库执行表 vmes_warehouse_in_execute
                for (WarehouseInExecute execute : executeList) {
                    //isdisable: 是否启用(0:已禁用 1:启用)
                    execute.setIsdisable("0");


                    if (execute.getRemark() == null) {
                        execute.setRemark(remarkStr);
                    } else {
                        execute.setRemark(execute.getRemark() + remarkStr);
                    }
                    warehouseInExecuteService.update(execute);

                    //产品ID
                    String productId = detail.getProductId();
                    //入库数量(大于零或小于零)--小于零)反向操作(撤销入库)
                    double count = -1 * execute.getCount().doubleValue();

                    Product product = productService.findProductById(productId);
                    BigDecimal prodCount = BigDecimal.valueOf(0D);
                    if (product.getStockCount() != null) {
                        prodCount = product.getStockCount();
                    }

                    BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + count);
                    productService.updateStockCount(product, prodStockCount, cuser);
                }

                //C. 入库明细执行人 vmes_warehouse_in_executor
                if (executorList != null && executorList.size() > 0) {
                    for (WarehouseInExecutor executor : executorList) {
                        //isdisable: 是否启用(0:已禁用 1:启用)
                        executor.setIsdisable("0");

                        if (executor.getRemark() == null) {
                            executor.setRemark(remarkStr);
                        } else {
                            executor.setRemark(executor.getRemark() + remarkStr);
                        }

                        warehouseInExecutorService.update(executor);
                    }
                }

                //D. 修改入库单明细状态
                findMap = new PageData();
                findMap.put("detailId", detailId);
                //是否启用(0:已禁用 1:启用)
                findMap.put("isdisable", "1");
                findMap.put("mapSize", Integer.valueOf(findMap.size()));
                executorList = warehouseInExecutorService.findWarehouseInExecutorList(findMap);
                if (executorList != null && executorList.size() > 0) {
                    //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
                    detail.setState("1");
                }else {
                    detail.setState("0");
                }
                if (detail.getRemark() == null) {
                    detail.setRemark(remarkStr);
                } else {
                    detail.setRemark(detail.getRemark() + remarkStr);
                }
                warehouseInDetailService.update(detail);

                //E. 修改修改当前入库单明细状态--同时反写入库单状态
                WarehouseIn parent = new WarehouseIn();
                parent.setId(detail.getParentId());
                //入库单明细状态(0:待派单 1:执行中 2:已完成 -1:已取消) --忽视明细状态(-1:已取消)
                warehouseInDetailService.updateParentStateByDetailList(parent, null, null);
            }
        } catch (TableVersionException tabExc) {
            //库存变更 version 锁
            if (Common.SYS_STOCKCOUNT_ERRORCODE.equals(tabExc.getErrorCode())) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(tabExc.getMessage());
                return model;
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInExecute/rebackWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改入库执行(入库数量)
     * @author 陈刚
     * @date 2018-11-09
     * @throws Exception
     */
    @PostMapping("/warehouseInExecute/updateWarehouseInExecute")
    @Transactional
    public ResultModel updateWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/updateWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");

        String id = pageData.getString("id");
        String beforeCount = pageData.getString("beforeCount");
        String afterCount = pageData.getString("afterCount");

        if (beforeCount == null || beforeCount.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("调整前入库数量为空或空字符串");
            return model;
        }

        if (afterCount == null || afterCount.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("调整后入库数量为空或空字符串");
            return model;
        } else {
            try {
                new BigDecimal(afterCount);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                model.putCode(Integer.valueOf(1));
                model.putMsg("数据输入错误:调整后入库数量("+afterCount+") 请输入大于0的整数或(1,2)位小数！");
                return model;
            }
        }

        WarehouseInExecute execute = warehouseInExecuteService.findWarehouseInExecuteById(id);
        WarehouseInDetail detail = warehouseInDetailService.findWarehouseInDetailById(execute.getDetailId());

        try {
            //A. 修改库存数量
            BigDecimal before = BigDecimal.valueOf(Double.parseDouble(beforeCount));
            BigDecimal after = BigDecimal.valueOf(Double.parseDouble(afterCount));

            WarehouseProduct warehouseProduct = new WarehouseProduct();
            warehouseProduct.setProductId(detail.getProductId());
            warehouseProduct.setCode(detail.getCode());
            warehouseProduct.setWarehouseId(execute.getWarehouseId());

            BigDecimal count = BigDecimal.valueOf(after.doubleValue() - before.doubleValue());

            //库存变更日志
            WarehouseLoginfo loginfo = new WarehouseLoginfo();
            loginfo.setParentId(detail.getParentId());
            loginfo.setDetailId(detail.getId());
            loginfo.setExecuteId(execute.getId());

            loginfo.setCompanyId(companyId);
            loginfo.setCuser(cuser);
            //operation 操作类型(add:添加 modify:修改 delete:删除 reback:退单)
            loginfo.setOperation("modify");

            //beforeCount 操作变更前数量(业务相关)
            loginfo.setBeforeCount(before);
            //afterCount 操作变更后数量(业务相关)
            loginfo.setAfterCount(after);

            String msgStr = warehouseProductService.inStockCount(warehouseProduct, count, loginfo);
            if (msgStr != null && msgStr.trim().length() > 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(msgStr);
                return model;
            }

            //产品ID
            String productId = detail.getProductId();
            Product product = productService.findProductById(productId);

            BigDecimal prodCount = BigDecimal.valueOf(0D);
            if (product.getStockCount() != null) {
                prodCount = product.getStockCount();
            }

            BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + count.doubleValue());
            productService.updateStockCount(product, prodStockCount, cuser);

            //B. 修改入库执行明细
            execute.setCount(after);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            if (execute.getRemark() == null) {
                execute.setRemark("操作记录：修改前（"+beforeCount+"） 修改后 （"+afterCount+"） 操作时间："+ dateFormat.format(new Date()));
            } else {
                execute.setRemark(execute.getRemark()+"  操作记录：修改前（"+beforeCount+"） 修改后 （"+afterCount+"） 操作时间："+ dateFormat.format(new Date()));
            }
            warehouseInExecuteService.update(execute);

            //C. 修改修改当前入库单明细状态--同时反写入库单状态
            List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(detail.getParentId());
            warehouseInDetailService.updateStateWarehouseInDetail(detailList);

        } catch (TableVersionException tabExc) {
            if (Common.SYS_STOCKCOUNT_ERRORCODE.equals(tabExc.getErrorCode())) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(tabExc.getMessage());
                return model;
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInExecute/updateWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除入库执行
     * @author 陈刚
     * @date 2018-11-09
     * @throws Exception
     */
    @PostMapping("/warehouseInExecute/deleteWarehouseInExecute")
    @Transactional
    public ResultModel deleteWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/deleteWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");
        String id = pageData.getString("id");

        WarehouseInExecute execute = warehouseInExecuteService.findWarehouseInExecuteById(id);
        WarehouseInDetail detail = warehouseInDetailService.findWarehouseInDetailById(execute.getDetailId());

        try {
            //A. 修改库存数量
            BigDecimal executeCountount = execute.getCount();

            WarehouseProduct warehouseProduct = new WarehouseProduct();
            warehouseProduct.setProductId(detail.getProductId());
            warehouseProduct.setCode(detail.getCode());
            warehouseProduct.setWarehouseId(execute.getWarehouseId());

            BigDecimal count = BigDecimal.valueOf(-1 * executeCountount.doubleValue());

            //库存变更日志
            WarehouseLoginfo loginfo = new WarehouseLoginfo();
            loginfo.setParentId(detail.getParentId());
            loginfo.setDetailId(detail.getId());
            loginfo.setExecuteId(execute.getId());

            loginfo.setCompanyId(companyId);
            loginfo.setCuser(cuser);
            //operation 操作类型(add:添加 modify:修改 delete:删除 reback:退单)
            loginfo.setOperation("delete");

            //beforeCount 操作变更前数量(业务相关)
            loginfo.setBeforeCount(executeCountount);
            //afterCount 操作变更后数量(业务相关)
            loginfo.setAfterCount(BigDecimal.valueOf(executeCountount.doubleValue() + count.doubleValue()));

            String msgStr = warehouseProductService.inStockCount(warehouseProduct, count, loginfo);
            if (msgStr != null && msgStr.trim().length() > 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(msgStr);
                return model;
            }

            //产品ID
            String productId = detail.getProductId();
            Product product = productService.findProductById(productId);

            BigDecimal prodCount = BigDecimal.valueOf(0D);
            if (product.getStockCount() != null) {
                prodCount = product.getStockCount();
            }

            BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + count.doubleValue());
            productService.updateStockCount(product, prodStockCount, cuser);

            //B. 修改入库执行明细
            //是否启用(0:已禁用 1:启用)
            execute.setIsdisable("0");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            if (execute.getRemark() == null) {
                execute.setRemark("操作记录：删除  操作时间："+ dateFormat.format(new Date()));
            } else {
                execute.setRemark(execute.getRemark()+"  操作记录：删除  操作时间："+ dateFormat.format(new Date()));
            }
            warehouseInExecuteService.update(execute);

            //C. 修改修改当前入库单明细状态--同时反写入库单状态
            List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(detail.getParentId());
            warehouseInDetailService.updateStateWarehouseInDetail(detailList);

        } catch (TableVersionException tabExc) {
            if (Common.SYS_STOCKCOUNT_ERRORCODE.equals(tabExc.getErrorCode())) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(tabExc.getMessage());
                return model;
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInExecute/deleteWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    private List<Map> findSecondList(Map firstRowMap, Map<String, Object> secondTitleMap, String companyId) throws Exception {
        String productId = (String)firstRowMap.get("productId");
        String detailId = (String)firstRowMap.get("id");

        PageData findMap = new PageData();
        findMap.put("detailId", detailId);
        findMap.put("productId", productId);
        findMap.put("companyId", companyId);

        List<Map> secondMapList = new ArrayList();
        List<Map> varList = warehouseInExecuteService.findListWarehouseInExecuteByEdit(findMap);
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

    /**
     * (退单)取消入库单执行-(退回整个入库单)
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
//    @PostMapping("/warehouseInExecute/updateCancelWarehouseInExecute")
//    @Transactional
//    public ResultModel updateCancelWarehouseInExecute() throws Exception {
//        logger.info("################/warehouseInExecute/updateCancelWarehouseInExecute 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        ResultModel model = new ResultModel();
//
//        PageData pageData = HttpUtils.parsePageData();
//        String parentId = pageData.getString("parentId");
//        if (parentId == null || parentId.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("入库单id为空或空字符串！");
//            return model;
//        }
//
//        String remark = pageData.getString("remark");
//        if (remark == null || remark.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("退单原因为空或空字符串，退单原因为必填不可为空！");
//            return model;
//        }
//
//        //根据当前入库单id-获取当前入库单明细id-入库执行数量汇总
//        Map<String, BigDecimal> mapExecute = warehouseInExecuteService.findExecuteCountByParentId(parentId);
//        //判断当前入库单明细-货品是否部分入库
//        List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(parentId);
//        if (detailList != null && detailList.size() > 0) {
//            for (WarehouseInDetail detail : detailList) {
//                String dtl_id = detail.getId();
//                if (mapExecute != null && mapExecute.get(dtl_id) != null && mapExecute.get(dtl_id).doubleValue() != 0D) {
//                    model.putCode(Integer.valueOf(1));
//                    model.putMsg("入库单明细货品已经部分入库，该入库单不可整单(退单)，请核对后再次操作！");
//                    return model;
//                }
//            }
//        }
//
//        //1. 修改入库单明细状态
//        PageData mapData = new PageData();
//        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
//        mapData.put("state", "0");
//        mapData.put("parentId", parentId);
//        warehouseInDetailService.updateStateByDetail(mapData);
//
//        //2.修改入库单状态
//        WarehouseIn warehouseIn = new WarehouseIn();
//        //状态(0:未完成 1:已完成 -1:已取消)
//        warehouseIn.setState("0");
//        warehouseIn.setRemark(remark);
//        warehouseInService.update(warehouseIn);
//
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/warehouseInExecute/updateCancelWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }
}
