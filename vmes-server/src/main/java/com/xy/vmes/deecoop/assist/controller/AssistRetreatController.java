package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.entity.AssistRetreat;
import com.xy.vmes.entity.AssistRetreatDetail;
import com.xy.vmes.service.AssistRetreatDetailService;
import com.xy.vmes.service.AssistRetreatService;

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
import java.util.*;


/**
* 说明：vmes_assist_retreat:外协退货单Controller
* @author 陈刚 自动生成
* @date 2020-05-07
*/
@RestController
@Slf4j
public class AssistRetreatController {
    private Logger logger = LoggerFactory.getLogger(AssistRetreatController.class);

    @Autowired
    private AssistRetreatService retreatService;
    @Autowired
    private AssistRetreatDetailService retreatDetailService;

    @Autowired
    private CoderuleService coderuleService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-05-07
    */
    @PostMapping("/assist/assistRetreat/listPageAssistRetreat")
    public ResultModel listPageAssistRetreat() throws Exception {
        logger.info("################/assist/assistRetreat/listPageAssistRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = retreatService.listPageAssistRetreat(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistRetreat/listPageAssistRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增外协退料单
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistRetreat/addAssistRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addAssistRetreat() throws Exception {
        logger.info("################/assist/assistRetreat/addAssistRetreat 执行开始 ################# ");
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

        List<AssistRetreatDetail> retreatDtlList = this.mapList2DetailList(mapList, null);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //1. 添加外协退料单表
        AssistRetreat addRetreat = new AssistRetreat();
        addRetreat.setCuser(cuser);
        addRetreat.setCompanyId(companyID);
        addRetreat.setSupplierId(supplierId);

        //外协订单编号
        String code = coderuleService.createCoderCdateOnShortYearByDate(
                companyID,
                "vmes_assist_retreat",
                "R",
                Common.CODE_RULE_LENGTH_3);
        addRetreat.setSysCode(code);

        //状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        addRetreat.setState("0");
        //isAutoCommit true:自动提交 false:手动提交
        String isAutoCommit = pageData.getString("isAutoCommit");
        if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
            addRetreat.setState("1");
        }

        retreatService.save(addRetreat);

        //2. 添加外协退料单明细表
        if (retreatDtlList != null && retreatDtlList.size() > 0) {
            for (AssistRetreatDetail addDetail : retreatDtlList) {
                addDetail.setParentId(addRetreat.getId());
                addDetail.setCuser(addRetreat.getCuser());
                addDetail.setState(addRetreat.getState());
                retreatDetailService.save(addDetail);
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistRetreat/addAssistRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 提交(审核)外协退料单
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistRetreat/submitAssistRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel submitAssistRetreat() throws Exception {
        logger.info("################/assist/assistRetreat/submitAssistRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退料单id为空或空字符串！");
            return model;
        }

        //明细状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        retreatDetailService.updateStateByDetail("1", parentId);

        //修改抬头表状态
        AssistRetreat editRetreat = new AssistRetreat();
        editRetreat.setId(parentId);
        //状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        editRetreat.setState("1");
        editRetreat.setRemark("");
        retreatService.update(editRetreat);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistRetreat/submitAssistRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 撤回(审核)外协退料单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistRetreat/rebackSubmitAssistRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackSubmitAssistRetreat() throws Exception {
        logger.info("################/assist/assistRetreat/rebackSubmitAssistRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购退货单id为空或空字符串！");
            return model;
        }

        //明细状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        retreatDetailService.updateStateByDetail("0", parentId);

        //修改抬头表状态
        AssistRetreat editOrder = new AssistRetreat();
        editOrder.setId(parentId);
        //状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        editOrder.setState("0");
        retreatService.update(editOrder);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistRetreat/rebackSubmitAssistRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消外协退料单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistRetreat/cancelAssistRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelAssistRetreat() throws Exception {
        logger.info("################/assist/assistRetreat/cancelAssistRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购退货单id为空或空字符串！");
            return model;
        }

        //明细状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        retreatDetailService.updateStateByDetail("-1", parentId);

        //修改抬头表状态
        AssistRetreat editOrder = new AssistRetreat();
        editOrder.setId(parentId);
        //状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        editOrder.setState("-1");
        retreatService.update(editOrder);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistRetreat/cancelAssistRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
    /**
     * 恢复(取消)外协退料单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistRetreat/rebackCancelAssistRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackCancelAssistRetreat() throws Exception {
        logger.info("################/assist/assistRetreat/rebackCancelAssistRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购退货单id为空或空字符串！");
            return model;
        }

        //明细状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        retreatDetailService.updateStateByDetail("0", parentId);

        //修改抬头表状态
        AssistRetreat editOrder = new AssistRetreat();
        editOrder.setId(parentId);
        //状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        editOrder.setState("0");
        retreatService.update(editOrder);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistRetreat/rebackCancelAssistRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除外协退料单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistRetreat/deleteAssistRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteAssistRetreat() throws Exception {
        logger.info("################/assist/assistRetreat/deleteAssistRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购退货单id为空或空字符串！");
            return model;
        }

        //删除外协退料单明细表
        Map columnMap = new HashMap();
        columnMap.put("parent_id", parentId);
        retreatDetailService.deleteByColumnMap(columnMap);

        //删除外协退料单表
        retreatService.deleteById(parentId);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistRetreat/deleteAssistRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改外协退料单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistRetreat/updateAssistRetreat")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateAssistRetreat() throws Exception {
        logger.info("################/assist/assistRetreat/updateAssistRetreat 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        //外协退料单id
        String retreatId = pageData.getString("id");
        if (retreatId == null || retreatId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("外协退料单id为空或空字符串！");
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

        List<AssistRetreatDetail> retreatDtlList = this.mapList2DetailList(mapList, null);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //1. 修改外协退料单表
        AssistRetreat editRetreat = new AssistRetreat();
        editRetreat.setId(retreatId);
        editRetreat.setSupplierId(supplierId);

        //状态(0:待提交 1:待审核 2:待退货 3:已完成 -1:已取消)
        editRetreat.setState("0");
        //isAutoCommit true:自动提交 false:手动提交
        String isAutoCommit = pageData.getString("isAutoCommit");
        if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
            editRetreat.setState("1");
        }

        retreatService.update(editRetreat);

        //外协退料明细采用先删除后添加方式
        //删除外协退料明细表
        Map columnMap = new HashMap();
        columnMap.put("parent_id", retreatId);
        retreatDetailService.deleteByColumnMap(columnMap);

        //2. 添加外协退料单明细表
        if (retreatDtlList != null && retreatDtlList.size() > 0) {
            for (AssistRetreatDetail addDetail : retreatDtlList) {
                addDetail.setParentId(editRetreat.getId());
                addDetail.setCuser(editRetreat.getCuser());
                addDetail.setState(editRetreat.getState());
                retreatDetailService.save(addDetail);
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistRetreat/updateAssistRetreat 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private List<AssistRetreatDetail> mapList2DetailList(List<Map<String, String>> mapList, List<AssistRetreatDetail> objectList) {
        if (objectList == null) {objectList = new ArrayList();}
        if (mapList == null || mapList.size() == 0) {return objectList;}

        for (Map<String, String> mapObject : mapList) {
            AssistRetreatDetail detail = (AssistRetreatDetail)HttpUtils.pageData2Entity(mapObject, new AssistRetreatDetail());

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



