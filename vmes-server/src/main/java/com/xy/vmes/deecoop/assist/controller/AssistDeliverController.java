package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.entity.AssistDeliver;
import com.xy.vmes.entity.AssistDeliverDetail;
import com.xy.vmes.entity.AssistDeliverDetailChild;
import com.xy.vmes.service.AssistDeliverDetailChildService;
import com.xy.vmes.service.AssistDeliverDetailService;
import com.xy.vmes.service.AssistDeliverService;

import com.xy.vmes.service.CoderuleService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.common.util.Common;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    private AssistDeliverService deliverService;
    @Autowired
    private AssistDeliverDetailService deliverDetailService;
    @Autowired
    private AssistDeliverDetailChildService deliverDetailChildService;

    @Autowired
    private CoderuleService coderuleService;

     /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-04-27
    */
    @PostMapping("/assist/assistDeliver/listPageAssistDeliver")
    public ResultModel listPageAssistDeliver()  throws Exception {
        logger.info("################/assist/assistDeliver/listPageAssistDeliver 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = deliverService.listPageAssistDeliver(pd);
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
        String supplierId = pageData.getString("supplierId");
        if (supplierId == null || supplierId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("供应商id为空或空字符串！");
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

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //1. 添加外协发货单表
        AssistDeliver addDeliver = new AssistDeliver();
        addDeliver.setCuser(cuser);
        addDeliver.setMakeId(cuser);
        addDeliver.setCompanyId(companyID);
        addDeliver.setOrderId(orderId);
        addDeliver.setSupplierId(supplierId);

        //外协发货编号
        String code = coderuleService.createCoderCdateOnShortYearByDate(
                companyID,
                "vmes_assist_deliver",
                "D",
                Common.CODE_RULE_LENGTH_3);
        addDeliver.setSysCode(code);

        //state:状态(0:待发货 1:已发货 -1:已取消)
        addDeliver.setState("0");
        deliverService.save(addDeliver);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //2. 添加外协发货明细表
        Map<String, String> deliverDetailMap = (Map<String, String>) YvanUtil.jsonToMap(deliverDetailJsonStr);
        AssistDeliverDetail deliverDetail = (AssistDeliverDetail)HttpUtils.pageData2Entity(deliverDetailMap, new AssistDeliverDetail());
        deliverDetail.setParentId(addDeliver.getId());
        deliverDetail.setState(addDeliver.getState());
        deliverDetail.setCuser(addDeliver.getCuser());
        deliverDetailService.save(deliverDetail);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //3. 添加外协发货明细子表(原材料)
        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(deliverDetailChildJsonStr);
        for (Map<String, String> mapObject : mapList) {
            AssistDeliverDetailChild detailChild = (AssistDeliverDetailChild)HttpUtils.pageData2Entity(mapObject, new AssistDeliverDetailChild());
            detailChild.setDeliverId(deliverDetail.getParentId());
            detailChild.setDeliverDtlId(deliverDetail.getId());
            detailChild.setCuser(deliverDetail.getCuser());
            deliverDetailChildService.save(detailChild);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistDeliver/addAssistDeliver 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



