package com.xy.vmes.deecoop.mobile.controller;

import com.xy.vmes.common.util.Common;
import com.xy.vmes.entity.*;
import com.xy.vmes.exception.TableVersionException;
import com.xy.vmes.service.*;
import com.yvan.Conv;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class MobileWarehouseInController {

    private Logger logger = LoggerFactory.getLogger(MobileWarehouseInController.class);
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
    @Autowired
    private MobileWarehouseInService mobileWarehouseInService;

    //获得入库任务详细信息
    @PostMapping("/mobileWarehouseIn/findWarehouseInByDetailId")
    //@GetMapping("/mobileWarehouseIn/findWarehouseInByDetailId")
    public ResultModel findWarehouseInByDetailId()  throws Exception {
        logger.info("################/mobileWarehouseIn/findWarehouseInByDetailId  执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        List<Map> varList = mobileWarehouseInService.findWarehouseIn(pd);

        if(varList!=null&&varList.size()>0){
            model.putResult(varList.get(0));
        }else {
            model.putCode("1");
            model.putMsg("未查到任何数据！");
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/mobileWarehouseIn/findWarehouseInByDetailId  执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }


    /**
     * 手机端
     * 新增入库单明细执行
     * @author fang
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/mobileWarehouseIn/moblileAddWarehouseInExecute")
    @Transactional
    public ResultModel moblileAddWarehouseInExecute() throws Exception {
        logger.info("################/mobileWarehouseIn/moblileAddWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");

        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单id为空或空字符串");
            return model;
        }
        String detailId = pageData.getString("detailId");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细id为空或空字符串");
            return model;
        }

        String productId = pageData.getString("productId");
        if (productId == null || productId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("货品id为空或空字符串");
            return model;
        }
        String warehouseId = pageData.getString("warehouseId");
        if (warehouseId == null || warehouseId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("货位id为空或空字符串");
            return model;
        }
        String code = pageData.getString("code");
        if (code == null || code.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("批次号为空或空字符串");
            return model;
        }

        //入库数量 count
        String count = pageData.getString("count");
        BigDecimal countBig = BigDecimal.valueOf(0D);
        if (count == null || count.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库数量为空或空字符串！");
            return model;
        } else {
            try {
                BigDecimal doubleBig = new BigDecimal(count);
                if (doubleBig.doubleValue() < 0) {
                    model.putCode(Integer.valueOf(1));
                    model.putMsg("入库数量(" + count + ")输入错误，请输入大于零的整数或2为小数");
                    return model;
                }
                countBig = doubleBig;
            } catch (NumberFormatException numberExc) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("入库数量(" + count + ")输入错误，请输入大于零的整数或2为小数");
                return model;
            }
        }


        StringBuffer msgBuf = new StringBuffer();
        try {
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
            loginfo.setAfterCount(countBig);

            String msgStr = warehouseProductService.inStockCount(inObject, countBig, loginfo);
            if (msgStr != null && msgStr.trim().length() > 0) {
                msgBuf.append( "入库操作失败:" + msgStr);
            } else {
                WarehouseInExecute execute = new WarehouseInExecute();
                execute.setId(executeId);
                execute.setDetailId(detailId);
                execute.setWarehouseId(warehouseId);
                execute.setExecutorId(cuser);
                execute.setCount(countBig);
                execute.setCuser(cuser);
                warehouseInExecuteService.save(execute);

                Product product = productService.findProductById(productId);
                BigDecimal prodCount = BigDecimal.valueOf(0D);
                if (product.getStockCount() != null) {
                    prodCount = product.getStockCount();
                }

                BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + countBig.doubleValue());
                productService.updateStockCount(product, prodStockCount, cuser);

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
        logger.info("################/mobileWarehouseIn/moblileAddWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (退单)取消入库单明细执行___手机端复用
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/mobileWarehouseIn/rebackWarehouseInExecute")
    @Transactional
    public ResultModel rebackWarehouseInExecute() throws Exception {
        logger.info("################/mobileWarehouseIn/rebackWarehouseInExecute执行开始 ################# ");
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

        String remark = pageData.getString("rebackRemark");
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

        if (executorList == null || executorList.size() == 0) {return model;}

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
        logger.info("################/mobileWarehouseIn/rebackWarehouseInExecute执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



}
