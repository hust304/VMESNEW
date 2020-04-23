package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.service.AssistSupplierService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 说明：vmes_assist_supplier:外协供应商Controller
* @author 陈刚 自动生成
* @date 2020-04-23
*/
@RestController
@Slf4j
public class AssistSupplierController {
    private Logger logger = LoggerFactory.getLogger(AssistSupplierController.class);

    @Autowired
    private AssistSupplierService assistSupplierService;

    /*****************************************************以上为自动生成代码禁止修改，请在下面添加业务代码**************************************************/
    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-04-23
    */
    @PostMapping("/assist/assistSupplier/listPageAssistSupplier")
    public ResultModel listPageAssistSupplier() throws Exception {
        logger.info("################/assist/assistSupplier/listPageAssistSupplier 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistSupplierService.listPageAssistSupplier(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistSupplier/listPageAssistSupplier 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }



}



