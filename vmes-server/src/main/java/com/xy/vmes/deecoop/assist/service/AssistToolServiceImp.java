package com.xy.vmes.deecoop.assist.service;

import com.xy.vmes.entity.*;
import com.xy.vmes.service.*;
import com.yvan.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 说明：外协件模块根据类
 * 创建人：陈刚
 * 创建时间：2020-05-18
 */
@Service
@Transactional(readOnly = false)
public class AssistToolServiceImp implements AssistToolService {
    @Autowired
    private AssistProductService assistProductService;

    @Autowired
    private AssistSupplierService assistSupplierService;
    @Autowired
    private AssistPlanDetailService assistPlanDetailService;
    @Autowired
    private AssistOrderDetailService assistOrderDetailService;
    @Autowired
    private AssistDeliverDetailService assistDeliverDetailService;
    @Autowired
    private AssistSignDetailService assistSignDetailService;
    @Autowired
    private AssistRetreatDetailService assistRetreatDetailService;

    /**
     * 验证(外协件id) 是否允许删除
     * @param assistProductId  外协件id
     * @return
     */
    public String checkDeleteAssistProduct(String assistProductId) throws Exception {
        if (assistProductId == null || assistProductId.trim().length() == 0) {return new String();}

        String msgTemp = "外协件({0}) 正在使用中禁止删除！";
        String msgStr = new String();
        AssistProduct productObj = assistProductService.findAssistProductById(assistProductId);
        if (productObj != null && productObj.getProductName() != null) {
            msgStr = MessageFormat.format(msgTemp, productObj.getProductName());
        }

        PageData findMap = new PageData();
        findMap.put("assistProductId", assistProductId);

        //vmes_assist_supplier:外协供应商
        List<AssistSupplier> objectList = assistSupplierService.findAssistSupplierList(findMap);
        if (objectList != null && objectList.size() > 0) {
            return msgStr;
        }

        //vmes_assist_plan_detail:外协计划明细
        List<AssistPlanDetail> planList = assistPlanDetailService.findAssistPlanDetailList(findMap);
        if (planList != null && planList.size() > 0) {
            return msgStr;
        }

        //vmes_assist_order_detail:外协订单明细
        List<AssistOrderDetail> orderList = assistOrderDetailService.findAssistOrderDetailList(findMap);
        if (orderList != null && orderList.size() > 0) {
            return msgStr;
        }

        //vmes_assist_deliver_detail:外协发货明细
        List<AssistDeliverDetail> deliverList = assistDeliverDetailService.findDeliverDetailList(findMap);
        if (deliverList != null && deliverList.size() > 0) {
            return msgStr;
        }

        //vmes_assist_sign_detail:外协签收单明细
        List<AssistSignDetail> signList = assistSignDetailService.findAssistSignDetailList(findMap);
        if (signList != null && signList.size() > 0) {
            return msgStr;
        }

        //vmes_assist_retreat_detail:外协退货明细子表:
        List<AssistRetreatDetail> retreatList = assistRetreatDetailService.findAssistRetreatDetailList(findMap);
        if (retreatList != null && retreatList.size() > 0) {
            return msgStr;
        }

        return new String();
    }
}
