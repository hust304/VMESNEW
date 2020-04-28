package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.service.AssistDeliverService;

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
* 说明：vmes_assist_deliver:外协发货表Controller
* @author 陈刚 自动生成
* @date 2020-04-27
*/
@RestController
@Slf4j
public class AssistDeliverController {
    private Logger logger = LoggerFactory.getLogger(AssistDeliverController.class);

    @Autowired
    private AssistDeliverService assistDeliverService;

     /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-04-27
    */
    @PostMapping("/assist/assistDeliver/listPageAssistDeliver")
    public ResultModel listPageAssistDeliver()  throws Exception {
        logger.info("################/assist/assistDeliver/listPageAssistDeliver 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = assistDeliverService.listPageAssistDeliver(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistDeliver/listPageAssistDeliver 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增外协发货单
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistDeliver/addAssistDeliver")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addAssistDeliver() throws Exception {
        logger.info("################/assist/assistDeliver/addAssistDeliver 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String cuser = pageData.getString("cuser");
        String companyID = pageData.getString("currentCompanyId");
        if (companyID == null || companyID.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }
        String orderId = pageData.getString("orderId");
        if (orderId == null || orderId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("发货单id为空或空字符串！");
            return model;
        }

        String deliverDetailJsonStr = pageData.getString("deliverDetail");
        if (deliverDetailJsonStr == null || deliverDetailJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("发货单明细JsonStr为空或空字符串！！");
            return model;
        }

        String deliverDetailChildJsonStr = pageData.getString("deliverDetailChild");
        if (deliverDetailChildJsonStr == null || deliverDetailChildJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("发货单明细原材料JsonStr为空或空字符串！");
            return model;
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistDeliver/addAssistDeliver 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



