package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.entity.AssistDiscard;
import com.xy.vmes.entity.AssistDiscardDetail;
import com.xy.vmes.service.AssistDiscardDetailService;
import com.xy.vmes.service.AssistDiscardService;

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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 说明：vmes_assist_discard:外协报废单Controller
* @author 陈刚 自动生成
* @date 2020-05-07
*/
@RestController
@Slf4j
public class AssistDiscardController {
    private Logger logger = LoggerFactory.getLogger(AssistDiscardController.class);

    @Autowired
    private AssistDiscardService discardService;
    @Autowired
    private AssistDiscardDetailService discardDetailService;
    @Autowired
    private CoderuleService coderuleService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-05-07
    */
    @PostMapping("/assist/assistDiscard/listPageAssistDiscard")
    public ResultModel listPageAssistDiscard() throws Exception {
        logger.info("################/assist/assistDiscard/listPageAssistDiscard 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = discardService.listPageAssistDiscard(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistDiscard/listPageAssistDiscard 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增外协报废单
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistDiscard/addAssistDiscard")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addAssistDiscard() throws Exception {
        logger.info("################/assist/assistDiscard/addAssistDiscard 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String cuser = pageData.getString("cuser");
        //供应商ID
        String supplierId = pageData.getString("supplierId");
        if (supplierId == null || supplierId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("供应商id为空或空字符串！");
            return model;
        }
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
            model.putMsg("订单明细Json字符串-转换成List错误！");
            return model;
        }

        List<AssistDiscardDetail> retreatDtlList = this.mapList2DetailList(mapList, null);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //1. 添加外协报废单表
        AssistDiscard addDiscard = new AssistDiscard();
        addDiscard.setCuser(cuser);
        addDiscard.setCompanyId(companyID);
        addDiscard.setSupplierId(supplierId);

        //type 退货类型(1:外协件 2:外协原材料)
        String type = pageData.getString("type");
        if (type != null && type.trim().length() > 0) {
            addDiscard.setType(type);
        }

        //amount:金额(外协订单)
        BigDecimal amount = discardDetailService.findTotalAmount(retreatDtlList);
        if (amount != null && amount.doubleValue() != 0) {
            addDiscard.setAmount(amount);
        }

        //外协订单编号
        String code = coderuleService.createCoderCdateOnShortYearByDate(
                companyID,
                "vmes_assist_discard",
                "D",
                Common.CODE_RULE_LENGTH_3);
        addDiscard.setSysCode(code);

        //状态(0:待提交 1:待审核 2:待报废 3:已完成 -1:已取消)
        addDiscard.setState("0");
        //isAutoCommit true:自动提交 false:手动提交
        String isAutoCommit = pageData.getString("isAutoCommit");
        if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
            addDiscard.setState("1");
        }

        discardService.save(addDiscard);

        //2. 添加外协报废单明细表
        if (retreatDtlList != null && retreatDtlList.size() > 0) {
            for (AssistDiscardDetail addDetail : retreatDtlList) {
                addDetail.setParentId(addDiscard.getId());
                addDetail.setCuser(addDiscard.getCuser());
                addDetail.setState(addDiscard.getState());
                discardDetailService.save(addDetail);
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistDiscard/addAssistDiscard 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 提交(审核)外协报废单
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistDiscard/submitAssistDiscard")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel submitAssistDiscard() throws Exception {
        logger.info("################/assist/assistDiscard/submitAssistDiscard 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("报废单id为空或空字符串！");
            return model;
        }

        //明细状态(0:待提交 1:待审核 2:待报废 3:已完成 -1:已取消)
        discardDetailService.updateStateByDetail("1", parentId);

        //修改抬头表状态
        AssistDiscard editRetreat = new AssistDiscard();
        editRetreat.setId(parentId);
        //状态(0:待提交 1:待审核 2:待报废 3:已完成 -1:已取消)
        editRetreat.setState("1");
        editRetreat.setRemark("");
        discardService.update(editRetreat);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistDiscard/submitAssistDiscard 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 撤回(审核)外协报废单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistDiscard/rebackSubmitAssistDiscard")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackSubmitAssistDiscard() throws Exception {
        logger.info("################/assist/assistDiscard/rebackSubmitAssistDiscard 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购退货单id为空或空字符串！");
            return model;
        }

        //明细状态(0:待提交 1:待审核 2:待报废 3:已完成 -1:已取消)
        discardDetailService.updateStateByDetail("0", parentId);

        //修改抬头表状态
        AssistDiscard editOrder = new AssistDiscard();
        editOrder.setId(parentId);
        //状态(0:待提交 1:待审核 2:待报废 3:已完成 -1:已取消)
        editOrder.setState("0");
        discardService.update(editOrder);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistDiscard/rebackSubmitAssistDiscard 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消外协报废单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistDiscard/cancelAssistDiscard")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelAssistDiscard() throws Exception {
        logger.info("################/assist/assistDiscard/cancelAssistDiscard 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购退货单id为空或空字符串！");
            return model;
        }

        //明细状态(0:待提交 1:待审核 2:待报废 3:已完成 -1:已取消)
        discardDetailService.updateStateByDetail("-1", parentId);

        //修改抬头表状态
        AssistDiscard editOrder = new AssistDiscard();
        editOrder.setId(parentId);
        //状态(0:待提交 1:待审核 2:待报废 3:已完成 -1:已取消)
        editOrder.setState("-1");
        discardService.update(editOrder);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistDiscard/cancelAssistDiscard 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
    /**
     * 恢复(取消)外协报废单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistDiscard/rebackCancelAssistDiscard")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackCancelAssistDiscard() throws Exception {
        logger.info("################/assist/assistDiscard/rebackCancelAssistDiscard 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购退货单id为空或空字符串！");
            return model;
        }

        //明细状态(0:待提交 1:待审核 2:待报废 3:已完成 -1:已取消)
        discardDetailService.updateStateByDetail("0", parentId);

        //修改抬头表状态
        AssistDiscard editOrder = new AssistDiscard();
        editOrder.setId(parentId);
        //状态(0:待提交 1:待审核 2:待报废 3:已完成 -1:已取消)
        editOrder.setState("0");
        discardService.update(editOrder);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistDiscard/rebackCancelAssistDiscard 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除外协报废单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistDiscard/deleteAssistDiscard")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteAssistDiscard() throws Exception {
        logger.info("################/assist/assistDiscard/deleteAssistDiscard 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购退货单id为空或空字符串！");
            return model;
        }

        //删除外协报废单明细表
        Map columnMap = new HashMap();
        columnMap.put("parent_id", parentId);
        discardDetailService.deleteByColumnMap(columnMap);

        //删除外协报废单表
        discardService.deleteById(parentId);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistDiscard/deleteAssistDiscard 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改外协报废单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistDiscard/updateAssistDiscard")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateAssistDiscard() throws Exception {
        logger.info("################/assist/assistDiscard/updateAssistDiscard 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //外协报废单id
        String retreatId = pageData.getString("id");
        if (retreatId == null || retreatId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("外协报废单id为空或空字符串！");
            return model;
        }
        //供应商ID
        String supplierId = pageData.getString("supplierId");
        if (supplierId == null || supplierId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("供应商id为空或空字符串！");
            return model;
        }
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
            model.putMsg("订单明细Json字符串-转换成List错误！");
            return model;
        }

        List<AssistDiscardDetail> retreatDtlList = this.mapList2DetailList(mapList, null);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //1. 修改外协报废单表
        AssistDiscard editDiscard = new AssistDiscard();
        editDiscard.setId(retreatId);
        editDiscard.setSupplierId(supplierId);

        //amount:金额(外协订单)
        BigDecimal amount = discardDetailService.findTotalAmount(retreatDtlList);
        if (amount != null && amount.doubleValue() != 0) {
            editDiscard.setAmount(amount);
        }

        //状态(0:待提交 1:待审核 2:待报废 3:已完成 -1:已取消)
        editDiscard.setState("0");
        //isAutoCommit true:自动提交 false:手动提交
        String isAutoCommit = pageData.getString("isAutoCommit");
        if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
            editDiscard.setState("1");
        }

        discardService.update(editDiscard);

        //外协报废明细采用先删除后添加方式
        //删除外协报废明细表
        Map columnMap = new HashMap();
        columnMap.put("parent_id", retreatId);
        discardDetailService.deleteByColumnMap(columnMap);

        //2. 添加外协报废单明细表
        if (retreatDtlList != null && retreatDtlList.size() > 0) {
            for (AssistDiscardDetail addDetail : retreatDtlList) {
                addDetail.setParentId(editDiscard.getId());
                addDetail.setCuser(editDiscard.getCuser());
                addDetail.setState(editDiscard.getState());
                discardDetailService.save(addDetail);
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistDiscard/updateAssistDiscard 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private List<AssistDiscardDetail> mapList2DetailList(List<Map<String, String>> mapList, List<AssistDiscardDetail> objectList) {
        if (objectList == null) {objectList = new ArrayList();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            AssistDiscardDetail detail = (AssistDiscardDetail)HttpUtils.pageData2Entity(mapObject, new AssistDiscardDetail());

            //退货数量(订单单位)
            BigDecimal orderCount = BigDecimal.valueOf(0D);
            if (detail.getOrderCount() != null) {
                orderCount = detail.getOrderCount();
            }
            //四舍五入到2位小数
            orderCount = orderCount.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            detail.setOrderCount(orderCount);

            objectList.add(detail);
        }

        return objectList;
    }

}



