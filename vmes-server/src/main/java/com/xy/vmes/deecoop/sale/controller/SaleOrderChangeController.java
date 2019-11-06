package com.xy.vmes.deecoop.sale.controller;

import com.xy.vmes.service.SaleOrderChangeService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_saleOrde_change:订单变更记录表Controller
* @author 陈刚 自动生成
* @date 2019-11-05
*/
@RestController
@Slf4j
public class SaleOrderChangeController {
    private Logger logger = LoggerFactory.getLogger(SaleOrderChangeController.class);

    @Autowired
    private SaleOrderChangeService saleOrdeChangeService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2019-11-05
    */
    @PostMapping("/sale/saleOrderChange/listPageSaleOrderChange")
    public ResultModel listPageSaleOrderChange() throws Exception {
        logger.info("################/sale/saleOrderChange/listPageSaleOrderChange 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = saleOrdeChangeService.listPageSaleOrderChange(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderChange/listPageSaleOrderChange 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 添加订单变更记录
     * @author 陈刚
     * @date 2019-11-05
     * @throws Exception
     */
    @PostMapping("/sale/saleOrderChange/addSaleOrderChange")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addSaleOrderChange() throws Exception {
        logger.info("################/sale/saleOrderChange/addSaleOrderChange 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = saleOrdeChangeService.addSaleOrderChange(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/sale/saleOrderChange/addSaleOrderChange 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



