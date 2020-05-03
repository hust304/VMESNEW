package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;


/**
* 说明：出库执行Controller
* @author 刘威 自动生成
* @date 2018-11-01
*/
@RestController
@Slf4j
public class WarehouseOutExecuteController {
    private Logger logger = LoggerFactory.getLogger(WarehouseOutExecuteController.class);

    @Autowired
    private WarehouseOutService warehouseOutService;
    @Autowired
    private WarehouseOutDetailService warehouseOutDetailService;

    @Autowired
    private WarehouseOutExecutorService warehouseOutExecutorService;
    @Autowired
    private WarehouseOutExecuteService warehouseOutExecuteService;
    @Autowired
    private WarehouseOutDetailExecuteService warehouseOutDetailExecuteService;

    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private ProductService productService;

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @GetMapping("/warehouse/warehouseOutExecute/selectById/{id}")
    public ResultModel selectById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseOutExecute/selectById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        WarehouseOutExecute warehouseOutExecute = warehouseOutExecuteService.selectById(id);
        model.putResult(warehouseOutExecute);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecute/selectById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouse/warehouseOutExecute/save")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel save()  throws Exception {

        logger.info("################warehouseOutExecute/save 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseOutExecute warehouseOutExecute = (WarehouseOutExecute)HttpUtils.pageData2Entity(pd, new WarehouseOutExecute());
        warehouseOutExecuteService.save(warehouseOutExecute);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecute/save 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouse/warehouseOutExecute/update")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel update()  throws Exception {

        logger.info("################warehouseOutExecute/update 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        WarehouseOutExecute warehouseOutExecute = (WarehouseOutExecute)HttpUtils.pageData2Entity(pd, new WarehouseOutExecute());
        warehouseOutExecuteService.update(warehouseOutExecute);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecute/update 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @GetMapping("/warehouse/warehouseOutExecute/deleteById/{id}")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteById(@PathVariable("id") String id)  throws Exception {

        logger.info("################warehouseOutExecute/deleteById 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        warehouseOutExecuteService.deleteById(id);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecute/deleteById 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouse/warehouseOutExecute/deleteByIds")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteByIds()  throws Exception {

        logger.info("################warehouseOutExecute/deleteByIds 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = new ResultModel();
        String ids = pd.getString("ids");
        if(StringUtils.isEmpty(ids)){
            model.putCode("1");
            model.putMsg("未勾选删除记录，请重新选择！");
            return model;
        }
        String id_str = StringUtil.stringTrimSpace(ids);
        String[] id_arry = id_str.split(",");
        if(id_arry.length>0){
            warehouseOutExecuteService.deleteByIds(id_arry);
        }
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecute/deleteByIds 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouse/warehouseOutExecute/dataListPage")
    public ResultModel dataListPage()  throws Exception {

        logger.info("################warehouseOutExecute/dataListPage 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        List<WarehouseOutExecute> warehouseOutExecuteList = warehouseOutExecuteService.dataListPage(pd,pg);
        Map result = new HashMap();
        result.put("varList",warehouseOutExecuteList);
        result.put("pageData", pg);
        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecute/dataListPage 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，禁止修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouse/warehouseOutExecute/dataList")
    public ResultModel dataList()  throws Exception {

        logger.info("################warehouseOutExecute/dataList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();
        List<WarehouseOutExecute> warehouseOutExecuteList = warehouseOutExecuteService.dataList(pd);
        model.putResult(warehouseOutExecuteList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecute/dataList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
     * 出库编辑
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutExecute/updateWarehouseOutExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseOutExecute() throws Exception {
        logger.info("################/warehouseOutExecute/updateWarehouseOutExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseOutExecuteService.updateWarehouseOutExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOutExecute/updateWarehouseOutExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 出库删除
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutExecute/deleteWarehouseOutExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseOutExecute() throws Exception {
        logger.info("################/warehouseOutExecute/deleteWarehouseOutExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseOutExecuteService.deleteWarehouseOutExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOutExecute/deleteWarehouseOutExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 出库执行
     * @author 刘威
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutExecute/executeWarehouseOutExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel executeWarehouseOutExecute() throws Exception {
        logger.info("################/warehouseOutExecute/executeWarehouseOutExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseOutExecuteService.executeWarehouseOutExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseOutExecute/executeWarehouseOutExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
    * @author 刘威 自动创建，可以修改
    * @date 2018-11-01
    */
    @PostMapping("/warehouse/warehouseOutExecute/listPageWarehouseOutExecutes")
    public ResultModel listPageWarehouseOutExecutes() throws Exception {
        logger.info("################warehouseOutExecute/listPageWarehouseOutExecutes 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseOutExecuteService.listPageWarehouseOutExecutes(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseOutExecute/listPageWarehouseOutExecutes 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (简版)出库单-出库执行-退单
     * @author 陈刚
     * @date 2019-10-22
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseOutExecute/rebackWarehouseOutExecuteBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackWarehouseOutExecuteBySimple() throws Exception {
        logger.info("################/warehouse/warehouseOutExecute/rebackWarehouseOutExecuteBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pd = HttpUtils.parsePageData();

        String remarkTemp = "退单原因:{0}";
        String dateTimeStr = DateFormat.date2String(new Date(), DateFormat.DEFAULT_DATETIME_FORMAT);
        String remark = pd.getString("remark");
        if (remark == null || remark.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退单原因为必填项不可为空！");
            return model;
        }
        String remarkStr = MessageFormat.format(remarkTemp, remark);

        String outExecuteId = pd.getString("outExecuteId");
        if (outExecuteId == null || outExecuteId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("出库执行id为空或空字符串！");
            return model;
        }

        String productId = pd.getString("productId");
        if (productId == null || productId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("货品id为空或空字符串！");
            return model;
        }

        String cuser = pd.getString("cuser");
        String companyId = pd.getString("currentCompanyId");

        WarehouseOutExecute outExecute = warehouseOutExecuteService.selectById(outExecuteId);
        if (outExecute == null) {return model;}

        //detailId 出库单明细id
        String detailId = outExecute.getDetailId();
        //执行人ID executorId
        String executorId = outExecute.getExecutorId();
        //仓库货品id
        String warehouseProductId = outExecute.getWarehouseProductId();
        //当前出库数量 count
        BigDecimal count = BigDecimal.valueOf(0D);
        if (outExecute.getCount() != null) {
            count = outExecute.getCount();
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Map columnMap = new HashMap();
        //出库明细id
        columnMap.put("detail_id", detailId);
        //出库执行人id
        columnMap.put("executor_id", executorId);
        columnMap.put("isdisable","1");

        //(出库明细id,出库执行人id) 查询(vmes_warehouse_out_executor)
        List<WarehouseOutExecutor> warehouseOutExecutorList = warehouseOutExecutorService.selectByColumnMap(columnMap);
        if (warehouseOutExecutorList != null && warehouseOutExecutorList.size() > 0) {
            for (WarehouseOutExecutor executor : warehouseOutExecutorList) {
                WarehouseOutExecutor editOutExecutor = new WarehouseOutExecutor();

                editOutExecutor.setId(executor.getId());
                editOutExecutor.setRemark(remarkStr);
                editOutExecutor.setIsdisable("0");
                warehouseOutExecutorService.update(editOutExecutor);
            }
        }

        //修改当前出库执行
        WarehouseOutExecute editOutExecute = new WarehouseOutExecute();
        editOutExecute.setId(outExecuteId);
        editOutExecute.setIsdisable("0");
        editOutExecute.setRemark(remarkStr);
        warehouseOutExecuteService.update(editOutExecute);

        //修改仓库数量-仓库货品表变更
        WarehouseProduct warehouseProduct = warehouseProductService.selectById(warehouseProductId);
        if (warehouseProduct != null && count.doubleValue() != 0D) {
            //库存变更日志
            WarehouseLoginfo loginfo = new WarehouseLoginfo();
            loginfo.setCompanyId(companyId);
            loginfo.setCuser(cuser);
            //operation 操作类型(add:添加 modify:修改 delete:删除 reback:退单)
            loginfo.setOperation("reback");

            //beforeCount 操作变更前数量(业务相关)
            loginfo.setBeforeCount(count);
            //afterCount 操作变更后数量(业务相关)
            loginfo.setAfterCount(BigDecimal.ZERO);

            loginfo.setExecuteId(outExecuteId);
            loginfo.setDetailId(detailId);

            String msgStr = warehouseProductService.outStockCount(warehouseProduct, count.negate(), loginfo);
            if (msgStr != null && msgStr.trim().length() > 0) {
                model.putCode(Integer.valueOf(1));
                model.putMsg(msgStr);
                return model;
            }

            Product product = productService.findProductById(productId);
            BigDecimal prodCount = BigDecimal.valueOf(0D);
            if (product.getStockCount() != null) {
                prodCount = product.getStockCount();
            }

            BigDecimal prodStockCount = BigDecimal.valueOf(prodCount.doubleValue() + count.doubleValue());
            productService.updateStockCount(product, prodStockCount, outExecuteId, "out");
        }

        // 返回出库单明细Map结构体
        // <出库单明细id, 出库单明细执行Map>
        //     出库单明细执行Map
        //     outParentId:       出库单id
        //     outDtlId:          出库单明细id
        //     outDtlCount:       出库单明细出库数量
        //     outDtlExecuteCount 出库单明细出库执行数量
        Map<String, Map<String, Object>> outDetailExecuteMap = warehouseOutDetailExecuteService.findOutDetailExecuteMapByOutDtlIds(detailId);
        if (outDetailExecuteMap != null && outDetailExecuteMap.get(detailId) != null) {
            Map<String, Object> outDetailExecuteValue = outDetailExecuteMap.get(detailId);
            //outDtlCount:       出库单明细出库数量
            BigDecimal outDtlCount = BigDecimal.valueOf(0D);
            if (outDetailExecuteValue.get("outDtlCount") != null) {
                outDtlCount = (BigDecimal)outDetailExecuteValue.get("outDtlCount");
            }

            //outDtlExecuteCount 出库单明细出库执行数量
            BigDecimal outDtlExecuteCount = BigDecimal.valueOf(0D);
            if (outDetailExecuteValue.get("outDtlExecuteCount") != null) {
                outDtlExecuteCount = (BigDecimal)outDetailExecuteValue.get("outDtlExecuteCount");
            }

            //outParentId:       出库单id
            String outParentId = new String();
            if (outDetailExecuteValue.get("outParentId") != null) {
                outParentId = (String)outDetailExecuteValue.get("outParentId");
            }

            //获取出库单明细状态
            //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
            String delState = new String();
            if (outDtlExecuteCount.doubleValue() == 0) {
                delState = "1";
            } else if (outDtlExecuteCount.doubleValue() != 0
                && (outDtlExecuteCount.doubleValue() < outDtlCount.doubleValue())
            ) {
                delState = "1";
            } else if  (outDtlExecuteCount.doubleValue() != 0
                && (outDtlCount.doubleValue() <= outDtlExecuteCount.doubleValue())
            ) {
                delState = "2";
            }

            if (delState != null && delState.length() > 0) {
                WarehouseOutDetail editDetail = new WarehouseOutDetail();
                editDetail.setId(detailId);
                editDetail.setState(delState);
                editDetail.setRemark(remarkStr);
                warehouseOutDetailService.update(editDetail);

                if (outParentId != null && outParentId.trim().length() > 0) {
                    warehouseOutService.updateState(outParentId);
                }
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseOutExecute/rebackWarehouseOutExecuteBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



