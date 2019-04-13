package com.xy.vmes.deecoop.mobile.controller;


import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.service.MobileWarehouseTaskService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class MobileWarehouseTaskController {
    private Logger logger = LoggerFactory.getLogger(MobileWarehouseTaskController.class);

    @Autowired
    private MobileWarehouseTaskService mobileWarehouseTaskService;

    @PostMapping("/mobile/mobileWarehouseTask/listPageWarehouseTaskList")
    //@GetMapping("/MobileWarehouseTask/listPageWarehouseTaskList")
    public ResultModel listPageWarehouseTaskList()  throws Exception {
        logger.info("################/mobile/mobileWarehouseTask/listPageWarehouseTaskList 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        ResultModel model = mobileWarehouseTaskService.findListPageWarehouseTaskList(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseTask/listPageWarehouseTaskList 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }

    @PostMapping("/mobile/mobileWarehouseTask/getTaskNum")
    public ResultModel getTaskNum()  throws Exception {
        logger.info("################/mobile/mobileWarehouseTask/getTaskNum 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        pd.put("dtlState","1");
        ResultModel model = mobileWarehouseTaskService.getTaskNum(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileWarehouseTask/getTaskNum 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }
}

