package com.xy.vmes.deecoop.assist.controller;

import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.entity.*;
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

//    @Autowired
//    private AssistOrderService orderService;
    @Autowired
    private AssistOrderDetailService orderDtlService;

    @Autowired
    private WarehouseOutCreateService warehouseOutCreateService;
    @Autowired
    private RoleMenuService roleMenuService;
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

        String supplierName = pageData.getString("supplierName");
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

        String roleId = pageData.getString("roleId");
        if (roleId == null || roleId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前用户角色id为空或空字符串！");
            return model;
        }

        //根据(用户角色id)获取仓库属性(复杂版仓库,简版仓库)
        String warehouse = roleMenuService.findWarehouseAttribute(roleId);
        if (warehouse == null || warehouse.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前用户角色无(复杂版仓库，简版仓库)菜单，请与管理员联系！");
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
        List<AssistDeliverDetailChild> deliverDetailChildList = new ArrayList<>();
        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(deliverDetailChildJsonStr);
        for (Map<String, String> mapObject : mapList) {
            AssistDeliverDetailChild detailChild = (AssistDeliverDetailChild)HttpUtils.pageData2Entity(mapObject, new AssistDeliverDetailChild());

            //原材料数量(单据单位) count
            BigDecimal count = detailChild.getCount();
            if (count != null && count.doubleValue() > 0) {
                //四舍五入到2位小数
                count = count.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                detailChild.setCount(count);

                detailChild.setDeliverId(deliverDetail.getParentId());
                detailChild.setDeliverDtlId(deliverDetail.getId());
                detailChild.setCuser(deliverDetail.getCuser());
                deliverDetailChildService.save(detailChild);
                deliverDetailChildList.add(detailChild);
            }
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //系统推送(外协件-原材料)出库单
        if (deliverDetailChildList != null && deliverDetailChildList.size() > 0) {
            Map<String, Map<String, Object>> businessByOutMap = deliverDetailChildService.findProductBusinessMapByOut(deliverDetailChildList);
            if (Common.SYS_WAREHOUSE_COMPLEX.equals(warehouse)) {
                //复杂版仓库:warehouseByComplex:Common.SYS_WAREHOUSE_COMPLEX
                warehouseOutCreateService.createWarehouseOutBusinessByComplex(supplierId,
                        supplierName,
                        //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                        Common.DICTIONARY_MAP.get("warehouseEntity"),
                        cuser,
                        companyID,
                        //外协出库 2ed8e86f7db149ffabc95b6428947cba:assistOut
                        Common.DICTIONARY_MAP.get("assistOut"),
                        addDeliver.getSysCode(),
                        businessByOutMap);
            } else if (Common.SYS_WAREHOUSE_SIMPLE.equals(warehouse)) {
                //简版仓库:warehouseBySimple:Common.SYS_WAREHOUSE_SIMPLE
                warehouseOutCreateService.createWarehouseOutBusinessBySimple(supplierId,
                        supplierName,
                        //实体库:warehouseEntity:2d75e49bcb9911e884ad00163e105f05
                        Common.DICTIONARY_MAP.get("warehouseEntity"),
                        cuser,
                        companyID,
                        //外协出库 2ed8e86f7db149ffabc95b6428947cba:assistOut
                        Common.DICTIONARY_MAP.get("assistOut"),
                        addDeliver.getSysCode(),
                        businessByOutMap);
            }

            //反写业务出库单id
            if (businessByOutMap != null) {
                for (Iterator iterator = businessByOutMap.keySet().iterator(); iterator.hasNext();) {
                    String businessId = iterator.next().toString().trim();
                    Map<String, Object> objectMap = businessByOutMap.get(businessId);
                    if (objectMap != null && objectMap.get("outDtlId") != null && objectMap.get("outDtlId").toString().trim().length() > 0) {
                        String outDtlId = objectMap.get("outDtlId").toString().trim();

                        AssistDeliverDetailChild editDetailChild = new AssistDeliverDetailChild();
                        editDetailChild.setId(businessId);
                        editDetailChild.setOutDtlId(outDtlId);
                        deliverDetailChildService.update(editDetailChild);
                    }
                }
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistDeliver/addAssistDeliver 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改外协发货单(发货类型)-发货完成
     *
     * @author 陈刚
     * @date 2020-04-27
     * @throws Exception
     */
    @PostMapping("/assist/assistDeliver/updateAssistDeliverType")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateAssistDeliverType() throws Exception {
        logger.info("################/assist/assistDeliver/updateAssistDeliverType 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String deliverId = pageData.getString("deliverId");
        if (deliverId == null || deliverId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("发货单id为空或空字符串！");
            return model;
        }

        String orderId = pageData.getString("orderId");
        if (orderId == null || orderId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("外协订单id为空或空字符串！");
            return model;
        }

        String deliverJsonStr = pageData.getString("deliverJsonStr");
        if (deliverJsonStr == null || deliverJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("发货单JsonStr为空或空字符串！！");
            return model;
        }

        //1. 修改发货单状态
        //获取系统当前日期(yyyy-MM-dd)
        String sysDateStr = DateFormat.date2String(new Date(), DateFormat.DEFAULT_DATE_FORMAT);
        Map<String, String> deliverMap = (Map<String, String>) YvanUtil.jsonToMap(deliverJsonStr);
        AssistDeliver editDeliver = (AssistDeliver)HttpUtils.pageData2Entity(deliverMap, new AssistDeliver());
        editDeliver.setId(deliverId);

        //deliverDate 发货时间(yyyy-MM-dd)
        Date deliverDate = DateFormat.dateString2Date(sysDateStr, DateFormat.DEFAULT_DATE_FORMAT);
        if (editDeliver.getDeliverDate() != null) {
            String deliverDateStr = DateFormat.date2String(editDeliver.getDeliverDate(), DateFormat.DEFAULT_DATE_FORMAT);
            deliverDate = DateFormat.dateString2Date(deliverDateStr, DateFormat.DEFAULT_DATE_FORMAT);
        }
        editDeliver.setDeliverDate(deliverDate);

        //发货状态(0:待发货 1:已发货 -1:已取消)
        editDeliver.setState("1");

        deliverService.update(editDeliver);
        deliverDetailService.updateStateByDetail("1", deliverId);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //2. 变更订单状态
        List<AssistDeliverDetail> deliverDtlList = deliverDetailService.findDeliverDetailListByParentId(deliverId);
        String orderDtlIds = deliverDetailService.findOrderDtlIdsByDeliverDtlList(deliverDtlList);
        //获取外协订单(原材料)Map结构体
        //Map<外协订单明细id, List<Map<String, Object>>>
        //Sql查询语句: AssistOrderDetailChildByAssistDeliverMapper.checkAssistOrderDetailChildByDeliver
        Map<String, List<Map<String, Object>>> valueMap = deliverDetailService.findOrderDetailChildMap(orderDtlIds);
        for (Iterator iterator = valueMap.keySet().iterator(); iterator.hasNext();) {
            String mapKey_orderDtlId = iterator.next().toString().trim();
            boolean isAllDeliver = deliverDetailService.isAllDeliverByOrderDetail(mapKey_orderDtlId, valueMap);
            if (isAllDeliver) {
                AssistOrderDetail editOrderDtl = new AssistOrderDetail();
                editOrderDtl.setId(mapKey_orderDtlId);
                //状态(0:待提交 1:待审核 2:待发货 3:外协中 4:已完成 -1:已取消)
                editOrderDtl.setState("3");
                orderDtlService.update(editOrderDtl);
            }
        }

        AssistOrder editOrder = new AssistOrder();
        editOrder.setId(orderId);
        orderDtlService.updateParentStateByDetailList(editOrder, null);

        Long endTime = System.currentTimeMillis();
        logger.info("################/assist/assistDeliver/updateAssistDeliverType 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}

