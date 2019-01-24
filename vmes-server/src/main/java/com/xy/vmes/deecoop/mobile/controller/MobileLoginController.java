package com.xy.vmes.deecoop.mobile.controller;


import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.service.MobileLoginService;
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

@RestController
@Slf4j
public class MobileLoginController {
    private Logger logger = LoggerFactory.getLogger(MobileLoginController.class);

    @Autowired
    private MobileLoginService mobileLoginService;

    @PostMapping("/mobile/mobileLogin/loginIn")
    public ResultModel loginIn()  throws Exception {
        logger.info("################/mobile/mobileLogin/loginIn 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = mobileLoginService.loginIn(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/mobileLogin/loginIn 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;

    }
}

