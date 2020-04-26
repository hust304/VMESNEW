package com.xy.vmes.deecoop.assist.controller;

import com.baomidou.mybatisplus.annotations.TableField;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.AssistOrder;
import com.xy.vmes.entity.AssistOrderDetail;
import com.xy.vmes.entity.AssistOrderDetailChild;
import com.xy.vmes.entity.AssistProductDetail;
import com.xy.vmes.service.*;

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

    @Autowired
    private AssistProductDetailService assistProductDetailService;

    @Autowired
    private CoderuleService coderuleService;

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

        String cuser = pageData.getString("cuser");
        String makeId = pageData.getString("makeId");
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

        List<AssistOrderDetail> orderDtlList = orderDtlService.mapList2DetailList(mapList, null);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //1. 添加外协订单表
        AssistOrder addOrder = new AssistOrder();
        addOrder.setCuser(cuser);
        addOrder.setCompanyId(companyID);
        addOrder.setOrderDate(new Date());

        addOrder.setMakeId(cuser);
        if (makeId != null && makeId.trim().length() > 0) {
            addOrder.setMakeId(makeId.trim());
        }

        //amount:金额(外协订单)
        BigDecimal amount = orderDtlService.findTotalAmount(orderDtlList);
        addOrder.setAmount(amount);

        //外协订单编号
        String code = coderuleService.createCoderCdateOnShortYearByDate(
                companyID,
                "vmes_assist_order",
                "O",
                Common.CODE_RULE_LENGTH_3);
        addOrder.setSysCode(code);

        //状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
        addOrder.setState("0");
        //isAutoCommit true:自动提交 false:手动提交
        String isAutoCommit = pageData.getString("isAutoCommit");
        if (isAutoCommit != null && "true".equals(isAutoCommit.trim())) {
            addOrder.setState("1");
        }

        orderService.save(addOrder);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //2. 遍历外协订单明细表-获取全部外协件id
        StringBuffer assistProductIds = new StringBuffer();
        if (orderDtlList != null && orderDtlList.size() > 0) {
            for (AssistOrderDetail addDetail : orderDtlList) {
                String assistProductId = addDetail.getAssistProductId();
                if (assistProductId != null && assistProductId.trim().length() > 0) {
                    assistProductIds.append(assistProductId.trim()).append(",");
                }
            }
        }

        //获取全部外协件原材料集合
        Map<String, List<AssistProductDetail>> assistProductMap = new LinkedHashMap<>();
        if (assistProductIds != null && assistProductIds.toString().trim().length() > 0) {
            String assistProductIds_sql = assistProductIds.toString().trim();
            assistProductIds_sql = StringUtil.stringTrimSpace(assistProductIds_sql);
            assistProductIds_sql = "'" + assistProductIds_sql.replace(",", "','") + "'";

            PageData findMap = new PageData();
            findMap.put("inParentIds", assistProductIds_sql);
            findMap.put("orderStr", "parentId asc,cdate asc");
            List<AssistProductDetail> assistProductDtlList = assistProductDetailService.findAssistProductDetailList(findMap);

            if (assistProductDtlList != null && assistProductDtlList.size() > 0) {
                for (AssistProductDetail productDetail : assistProductDtlList) {
                    //外协件id parentId
                    String parentId = productDetail.getParentId();
                    if (assistProductMap.get(parentId) == null) {
                        List<AssistProductDetail> tempList = new ArrayList<>();
                        tempList.add(productDetail);
                        assistProductMap.put(parentId, tempList);
                    } else if (assistProductMap.get(parentId) != null) {
                        List<AssistProductDetail> tempList = assistProductMap.get(parentId);
                        tempList.add(productDetail);
                        assistProductMap.put(parentId, tempList);
                    }
                }
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //3. 添加外协订单明细表
        List<AssistOrderDetailChild> detailChildList = new ArrayList<>();
        if (orderDtlList != null && orderDtlList.size() > 0) {
            for (AssistOrderDetail addDetail : orderDtlList) {
                addDetail.setParentId(addOrder.getId());
                addDetail.setCuser(addOrder.getCuser());
                addDetail.setState(addOrder.getState());
                orderDtlService.save(addDetail);

                //外协件数量(订单订购数量) orderCount
                BigDecimal orderCount = BigDecimal.valueOf(0D);
                if (addDetail.getOrderCount() != null) {
                    orderCount = addDetail.getOrderCount();
                }

                //外协件id assistProductId
                String assistProductId = addDetail.getAssistProductId();
                List<AssistProductDetail> productList =  assistProductMap.get(assistProductId);
                if (productList != null && productList.size() > 0) {
                    for (AssistProductDetail productDetail : productList) {
                        Object object = assistProductDetailService.assistProductDetail2Target(productDetail, AssistOrderDetailChild.class);
                        if (object != null) {
                            AssistOrderDetailChild orderDetailChild = (AssistOrderDetailChild)object;
                            orderDetailChild.setOrderId(addDetail.getParentId());
                            orderDetailChild.setOrderDtlId(addDetail.getId());
                            orderDetailChild.setCuser(addDetail.getCuser());
                            detailChildList.add(orderDetailChild);

                            //用料比例 ratio
                            BigDecimal ratio = BigDecimal.valueOf(0D);
                            if (orderDetailChild.getRatio() != null) {
                                ratio = orderDetailChild.getRatio();
                            }

                            //count 原材料数量(单据单位) = 外协件数量(订单订购数量) * 用料比例
                            BigDecimal count = BigDecimal.valueOf(orderCount.doubleValue() * ratio.doubleValue());
                            //四舍五入到2位小数
                            count = count.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                            orderDetailChild.setCount(count);

                            detailChildList.add(orderDetailChild);
                        }
                    }
                }
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //3. 添加外协订单明细子表
        if (detailChildList != null && detailChildList.size() > 0) {
            for (AssistOrderDetailChild orderDetailChild : detailChildList) {
                orderDetailChildService.save(orderDetailChild);
            }
        }

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



