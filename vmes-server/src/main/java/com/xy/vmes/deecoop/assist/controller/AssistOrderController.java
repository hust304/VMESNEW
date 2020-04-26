package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.entity.AssistOrder;
import com.xy.vmes.service.AssistOrderDetailChildService;
import com.xy.vmes.service.AssistOrderDetailService;
import com.xy.vmes.service.AssistOrderService;

import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
* 说明：vmes_assist_order:外协订单表Controller
* @author 陈刚 自动生成
* @date 2020-04-24
*/
@RestController
@Slf4j
public class AssistOrderController {
    private Logger logger = LoggerFactory.getLogger(AssistOrderController.class);

    @Autowired
    private AssistOrderService orderService;
    @Autowired
    private AssistOrderDetailService orderDtlService;
    @Autowired
    private AssistOrderDetailChildService orderDetailChildService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-04-24
    */
    @PostMapping("/assist/assistOrder/listPageAssistOrder")
    public ResultModel listPageAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/listPageAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = orderService.listPageAssistOrder(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/listPageAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增外协订单
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistOrder/addAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/addAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/addAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 提交(审核)外协订单
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistOrder/submitAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel submitAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/submitAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购退货单id为空或空字符串！");
            return model;
        }

        //明细状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        orderDtlService.updateStateByDetail("1", parentId);

        //修改抬头表状态
        AssistOrder editOrder = new AssistOrder();
        editOrder.setId(parentId);
        //状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        editOrder.setState("1");
        orderService.update(editOrder);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/submitAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 撤回(审核)外协订单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistOrder/rebackSubmitAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackSubmitAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/rebackSubmitAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购退货单id为空或空字符串！");
            return model;
        }

        //明细状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        orderDtlService.updateStateByDetail("0", parentId);

        //修改抬头表状态
        AssistOrder editOrder = new AssistOrder();
        editOrder.setId(parentId);
        //状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        editOrder.setState("0");
        orderService.update(editOrder);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/rebackSubmitAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 取消外协订单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistOrder/cancelAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/cancelAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购退货单id为空或空字符串！");
            return model;
        }

        //明细状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        orderDtlService.updateStateByDetail("-1", parentId);

        //修改抬头表状态
        AssistOrder editOrder = new AssistOrder();
        editOrder.setId(parentId);
        //状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        editOrder.setState("-1");
        orderService.update(editOrder);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/cancelAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
    /**
     * 恢复(取消)外协订单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistOrder/rebackCancelAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackCancelAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/rebackCancelAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购退货单id为空或空字符串！");
            return model;
        }

        //明细状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        orderDtlService.updateStateByDetail("0", parentId);

        //修改抬头表状态
        AssistOrder editOrder = new AssistOrder();
        editOrder.setId(parentId);
        //状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        editOrder.setState("0");
        orderService.update(editOrder);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/rebackCancelAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除外协订单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistOrder/deleteAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/deleteAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("采购退货单id为空或空字符串！");
            return model;
        }

        //删除外协订单明细表
        Map columnMap = new HashMap();
        columnMap.put("parent_id", parentId);
        orderDtlService.deleteByColumnMap(columnMap);

        //删除外协订单明细子表
        columnMap = new HashMap();
        columnMap.put("order_id", parentId);
        orderDetailChildService.deleteByColumnMap(columnMap);

        //删除外协订单表
        orderService.deleteById(parentId);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/deleteAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改外协订单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistOrder/updateAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/updateAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/updateAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 审核通过:外协订单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistOrder/auditPassAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditPassAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/auditPassAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/auditPassAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 审核不通过:外协订单
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/assist/assistOrder/auditDisagreeAssistOrder")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel auditDisagreeAssistOrder() throws Exception {
        logger.info("################/assist/assistOrder/auditDisagreeAssistOrder 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistOrder/auditDisagreeAssistOrder 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}



