package com.xy.vmes.deecoop.warehouse.controller;

import com.xy.vmes.service.*;
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

import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_warehouse_check 简版仓库盘点Controller
 * @author 陈刚
 * @date 2018-05-23
 */
@RestController
@Slf4j
public class WarehouseCheckBySimpleController {
    private Logger logger = LoggerFactory.getLogger(WarehouseCheckBySimpleController.class);

    @Autowired
    private WarehouseCheckService warehouseCheckService;
    @Autowired
    private WarehouseCheckDetailService warehouseCheckDetailService;

    @Autowired
    private WarehouseProductService warehouseProductService;
    @Autowired
    private ProductService productService;

    @Autowired
    private CoderuleService coderuleService;

    /**
     * 新增盘点单(简版仓库盘点)
     * @author 陈刚
     * @date 2018-05-23
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseCheckBySimple/addWarehouseCheckBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addWarehouseCheckBySimple() throws Exception {
        logger.info("################/warehouse/warehouseCheckBySimple/addWarehouseCheckBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String companyID = pageData.getString("currentCompanyId");
        if (companyID == null || companyID.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点单明细Json字符串-转换成List错误！");
            return model;
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseCheckBySimple/addWarehouseCheckBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
