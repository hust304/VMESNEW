package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

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
    private WarehouseInExecuteService warehouseInExecuteService;
    @Autowired
    private ProductService productService;

    /**
     * 入库单执行
     * @author 陈刚
     * @date 2019-09-20
     */
    @PostMapping("/warehouse/warehouseInExecute/listPageWarehouseInExecute")
    public ResultModel listPageWarehouseInExecute() throws Exception {
        logger.info("################/warehouse/warehouseInExecute/listPageWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseInExecuteService.listPageWarehouseInExecute(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseInExecute/listPageWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (入库管理-任务列表)获取入库单执行列表
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInExecute/findListWarehouseInExecuteByEdit")
    public ResultModel findListWarehouseInExecuteByEdit() throws Exception {
        logger.info("################warehouseInExecute/findListWarehouseInExecuteByEdit 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = warehouseInExecuteService.findListWarehouseInExecuteByEdit(pd,pg);
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
    @PostMapping("/warehouse/warehouseInExecute/addWarehouseInExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/addWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInExecuteService.batchAddWarehouseInExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInExecute/addWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 入库单明细执行-简版仓库
     * @author 陈刚
     * @date 2019-09-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInExecute/addWarehouseInExecuteBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseInExecuteBySimple() throws Exception {
        logger.info("################/warehouse/warehouseInExecute/addWarehouseInExecuteBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInExecuteService.addWarehouseInExecuteBySimple(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseInExecute/addWarehouseInExecuteBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (退单)取消入库单明细执行
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInExecute/rebackWarehouseInExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/rebackWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInExecuteService.rebackWarehouseInExecute(pageData);
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
    @PostMapping("/warehouse/warehouseInExecute/updateWarehouseInExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/updateWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInExecuteService.updateWarehouseInExecute(pageData);
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
    @PostMapping("/warehouse/warehouseInExecute/deleteWarehouseInExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/deleteWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInExecuteService.deleteWarehouseInExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInExecute/deleteWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////



    /**
     * (退单)取消入库单执行-(退回整个入库单)
     * @author fang
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInExecute/updateCancelWarehouseInExecute")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateCancelWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/updateCancelWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInExecuteService.updateCancelWarehouseInExecute(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInExecute/updateCancelWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

//    @GetMapping("/warehouseInExecute/updateProductStockCountTest_1")
//    public ResultModel updateProductStockCountTest_1() {
//        ResultModel model = new ResultModel();
//
//        Product product = productService.findProductById("04ea720992d24d61b894cb91357e9c94");
//        BigDecimal prodStockCount = BigDecimal.valueOf(55D);
//        try {
//            System.out.println("in updateProductStockCountTest_1");
//            productService.updateStockCount(product, prodStockCount, "a18260b902434bdcbe4d9bdef9288bb1");
//            System.out.println("end updateProductStockCountTest_1");
//        } catch (Exception e) {
//            System.out.println("*********************");
//        }
//        return model;
//    }

//    @GetMapping("/warehouseInExecute/updateProductStockCountTest_2")
//    public ResultModel updateProductStockCountTest_2() {
//        ResultModel model = new ResultModel();
//
//        Product product = productService.findProductById("04ea720992d24d61b894cb91357e9c94");
//        BigDecimal prodStockCount = BigDecimal.valueOf(55D);
//        try {
//            System.out.println("in updateProductStockCountTest_2");
//            productService.updateStockCount(product, prodStockCount, "a18260b902434bdcbe4d9bdef9288bb1");
//            System.out.println("end updateProductStockCountTest_2");
//        } catch (Exception e) {
//            System.out.println("*********************");
//        }
//        return model;
//    }


}
