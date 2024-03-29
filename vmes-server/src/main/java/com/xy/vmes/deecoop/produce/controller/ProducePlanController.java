package com.xy.vmes.deecoop.produce.controller;

import com.xy.vmes.common.util.DateFormat;
import com.xy.vmes.entity.ProducePlan;
import com.xy.vmes.entity.ProducePlanDetail;
import com.xy.vmes.entity.ProducePlanDetailChild;
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
* 说明：vmes_produce_plan:生产计划Controller
* @author 陈刚 自动生成
* @date 2020-02-26
*/
@RestController
@Slf4j
public class ProducePlanController {
    private Logger logger = LoggerFactory.getLogger(ProducePlanController.class);

    @Autowired
    private ProducePlanService producePlanService;
    @Autowired
    private ProducePlanDetailService producePlanDetailService;
    @Autowired
    private ProducePlanDetailChildService producePlanDetailChildService;

    @Autowired
    private CoderuleService coderuleService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2020-02-26
    */
    @PostMapping("/produce/producePlan/listPageProducePlan")
    public ResultModel listPageProducePlan() throws Exception {
        logger.info("################/produce/producePlan/listPageProducePlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = producePlanService.listPageProducePlan(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/produce/producePlan/listPageProducePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 新增生产计划
     * @author 陈刚
     * @date 2020-02-26
     * @throws Exception
     */
    @PostMapping("/produce/producePlan/addProducePlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel addProducePlan() throws Exception {
        logger.info("################/produce/producePlan/addProducePlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String companyID = pageData.getString("currentCompanyId");
        if (companyID == null || companyID.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串！");
            return model;
        }
        String cuser = pageData.getString("cuser");

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }

        List<Map<String, String>> jsonMapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (jsonMapList == null || jsonMapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        //1. 添加生产计划
        ProducePlan addPlan = new ProducePlan();
        addPlan.setCuser(cuser);
        addPlan.setCompanyId(companyID);
        String code = coderuleService.createCoderCdateOnShortYearByDate(companyID,
                "vmes_produce_plan",
                "P",
                Common.CODE_RULE_LENGTH_SHORTYEAR);
        addPlan.setSysCode(code);

        String sysDateStr = DateFormat.date2String(new Date(), DateFormat.DEFAULT_DATE_FORMAT);
        Date sysDate = DateFormat.dateString2Date(sysDateStr, DateFormat.DEFAULT_DATE_FORMAT);

        //遍历jsonMapList 获取(计划开始日期, 计划结束日期)
        Map<String, Date> valueMap = producePlanDetailService.findBeginEndDate(jsonMapList);
        //beginDate 计划开始日期
        Date beginDate = valueMap.get("beginDate");
        addPlan.setBeginDate(beginDate);

        //endDate 计划结束日期
        Date endDate = valueMap.get("endDate");
        addPlan.setEndDate(endDate);

        //produceType 生产类型
        String produceType = pageData.getString("produceType");
        addPlan.setProduceType(produceType);

        //makeId 制单人id
        String makeId = pageData.getString("makeId");
        addPlan.setMakeId(makeId);

        //状态 (1:未完成 2:已完成 -1:已取消)
        addPlan.setState("1");

        producePlanService.save(addPlan);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //添加生产计划明细
        List<ProducePlanDetailChild> dtlChildList = new ArrayList<>();

        //遍历 jsonMapList 添加生产计划明细
        if (jsonMapList != null && jsonMapList.size() > 0) {
            for (Map<String, String> mapObject : jsonMapList) {
                ProducePlanDetail addPlanDtl = new ProducePlanDetail();
                addPlanDtl.setParentId(addPlan.getId());
                addPlanDtl.setCuser(addPlan.getCuser());
                //状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
                addPlanDtl.setState("0");

                Date beginDate_dtl = sysDate;
                String beginDate_dtl_Str = mapObject.get("beginDate");
                if (beginDate_dtl_Str != null && beginDate_dtl_Str.trim().length() > 0) {
                    beginDate_dtl = DateFormat.dateString2Date(beginDate_dtl_Str, DateFormat.DEFAULT_DATE_FORMAT);
                }
                addPlanDtl.setBeginDate(beginDate_dtl);

                //计划结束日期 默认(计划开始日期)
                Date endDate_dtl = beginDate_dtl;
                String endDate_dtl_Str = mapObject.get("endDate");
                if (endDate_dtl_Str != null && endDate_dtl_Str.trim().length() > 0) {
                    endDate_dtl = DateFormat.dateString2Date(endDate_dtl_Str, DateFormat.DEFAULT_DATE_FORMAT);
                }
                addPlanDtl.setEndDate(endDate_dtl);

                String productId = mapObject.get("productId");
                addPlanDtl.setProductId(productId);
                String unitId = mapObject.get("unitId");
                addPlanDtl.setUnitId(unitId);

                BigDecimal count = BigDecimal.valueOf(0D);
                String countStr = mapObject.get("count");
                if (countStr != null && countStr.trim().length() > 0) {
                    try {
                        count = new BigDecimal(countStr);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                //四舍五入到2位小数
                count = count.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
                addPlanDtl.setCount(count);

                //生产明细-产品计划号
                String pd_code = coderuleService.createCoderCdateOnShortYearByDate(companyID,
                        "vmes_produce_plan_detail",
                        "PD",
                        Common.CODE_RULE_LENGTH_SHORTYEAR);
                addPlanDtl.setCode(pd_code);
                producePlanDetailService.save(addPlanDtl);

                //生产计划明细子表对象
                String jsonStr = mapObject.get("jsonStr");
                if (jsonStr == null || jsonStr.trim().length() == 0) {
                    //界面没有点击(按货品合并)按钮
                    String orderDtlId = mapObject.get("orderDtlId");

                    ProducePlanDetailChild addDtlChile = new ProducePlanDetailChild();
                    addDtlChile.setCuser(addPlan.getCuser());
                    addDtlChile.setPlanId(addPlan.getId());
                    addDtlChile.setPlanDtlId(addPlanDtl.getId());

                    addDtlChile.setProductId(addPlanDtl.getProductId());
                    addDtlChile.setUnitId(addPlanDtl.getUnitId());
                    //addDtlChile.setCount(addPlanDtl.getCount());

                    if (orderDtlId != null && orderDtlId.trim().length() > 0) {
                        addDtlChile.setSaleOrderDtlId(orderDtlId);
                    }

                    dtlChildList.add(addDtlChile);
                } else if (jsonStr != null && jsonStr.trim().length() > 0) {
                    //界面点击(按货品合并)按钮
                    List<Map<String, String>> childMapList = (List<Map<String, String>>) YvanUtil.jsonToList(jsonStr);
                    if (childMapList != null && childMapList.size() > 0) {
                        for (Map<String, String> childMap : childMapList) {
                            ProducePlanDetailChild addDtlChile = new ProducePlanDetailChild();
                            addDtlChile.setCuser(addPlan.getCuser());
                            addDtlChile.setPlanId(addPlan.getId());
                            addDtlChile.setPlanDtlId(addPlanDtl.getId());

                            addDtlChile.setProductId(addPlanDtl.getProductId());
                            addDtlChile.setUnitId(addPlanDtl.getUnitId());

                            //orderDtlId 销售订单明细id
                            String orderDtlId = childMap.get("orderDtlId");
                            addDtlChile.setSaleOrderDtlId(orderDtlId);

//                            //count 计划数量
//                            BigDecimal count_child = BigDecimal.valueOf(0D);
//                            String count_child_str = childMap.get("count");
//                            if (count_child_str != null && count_child_str.trim().length() > 0) {
//                                try {
//                                    count_child = new BigDecimal(count_child_str);
//                                } catch (NumberFormatException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                            //四舍五入到2位小数
//                            count_child = count_child.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//                            addDtlChile.setCount(count_child);

                            dtlChildList.add(addDtlChile);
                        }
                    }
                }
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //添加生产计划明细子表 List<ProducePlanDetailChild> dtlChildList
        if (dtlChildList != null && dtlChildList.size() > 0) {
            for (ProducePlanDetailChild detailChild : dtlChildList) {
                producePlanDetailChildService.save(detailChild);
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/produce/producePlan/addProducePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

//    /**
//     * 提交生产计划
//     * @author 陈刚
//     * @date 2020-02-26
//     * @throws Exception
//     */
//    @PostMapping("/produce/producePlan/submitProducePlan")
//    @Transactional(rollbackFor=Exception.class)
//    public ResultModel submitProducePlan() throws Exception {
//        logger.info("################/produce/producePlan/submitProducePlan 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//
//        ResultModel model = new ResultModel();
//        PageData pageData = HttpUtils.parsePageData();
//
//        String parentId = pageData.getString("id");
//        if (parentId == null || parentId.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("生产计划id为空或空字符串！");
//            return model;
//        }
//
//        //修改明细状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
//        producePlanDetailService.updateStateByDetail("1", parentId);
//
//        //修改抬头表状态
//        ProducePlan editPlan = new ProducePlan();
//        editPlan.setId(parentId);
//        //状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
//        editPlan.setState("1");
//        producePlanService.update(editPlan);
//
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/produce/producePlan/submitProducePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

//    /**
//     * 撤回提交
//     * @author 陈刚
//     * @date 2020-02-26
//     * @throws Exception
//     */
//    @PostMapping("/produce/producePlan/rebackSubmitProducePlan")
//    @Transactional(rollbackFor=Exception.class)
//    public ResultModel rebackSubmitProducePlan() throws Exception {
//        logger.info("################/produce/producePlan/rebackSubmitProducePlan 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//
//        ResultModel model = new ResultModel();
//        PageData pageData = HttpUtils.parsePageData();
//
//        String parentId = pageData.getString("id");
//        if (parentId == null || parentId.trim().length() == 0) {
//            model.putCode(Integer.valueOf(1));
//            model.putMsg("生产计划id为空或空字符串！");
//            return model;
//        }
//
//        //修改明细状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
//        producePlanDetailService.updateStateByDetail("0", parentId);
//
//        //修改抬头表状态
//        ProducePlan editPlan = new ProducePlan();
//        editPlan.setId(parentId);
//        //状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
//        editPlan.setState("0");
//        producePlanService.update(editPlan);
//
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/produce/producePlan/rebackSubmitProducePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

    /**
     * 取消生产计划
     * @author 陈刚
     * @date 2020-02-26
     * @throws Exception
     */
    @PostMapping("/produce/producePlan/cancelProducePlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel cancelProducePlan() throws Exception {
        logger.info("################/produce/producePlan/cancelProducePlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("生产计划id为空或空字符串！");
            return model;
        }

        //根据(生产计划id)获取生产计划明细List
        List<ProducePlanDetail> dtlList = producePlanDetailService.findProducePlanDetailListByParentId(parentId);
        //判断生产计划明细是否允许删除
        // 明细状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
        // false: 不允许删除: 生产计划明细中含有(1:生产中 2:已完成)
        // true:  允许删除
        if (!producePlanDetailService.isAllowDeleteByDetail(dtlList)) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("该生产计划明细中含有(生产中, 已完成)状态，不可取消操作！");
            return model;
        }

        //修改明细状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
        producePlanDetailService.updateStateByDetail("-1", parentId);

        //修改抬头表状态
        ProducePlan editPlan = new ProducePlan();
        editPlan.setId(parentId);
        //状态 (1:未完成 2:已完成 -1:已取消)
        editPlan.setState("-1");
        producePlanService.update(editPlan);

        Long endTime = System.currentTimeMillis();
        logger.info("################/produce/producePlan/cancelProducePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
    /**
     * 恢复(取消)生产计划
     * @author 陈刚
     * @date 2020-02-26
     * @throws Exception
     */
    @PostMapping("/produce/producePlan/rebackCancelProducePlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel rebackCancelProducePlan() throws Exception {
        logger.info("################/produce/producePlan/rebackCancelProducePlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("生产计划id为空或空字符串！");
            return model;
        }

        //修改明细状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
        producePlanDetailService.updateStateByDetail("0", parentId);

        //修改抬头表状态
        ProducePlan editPlan = new ProducePlan();
        editPlan.setId(parentId);
        //状态 (1:未完成 2:已完成 -1:已取消)
        editPlan.setState("1");
        producePlanService.update(editPlan);

        Long endTime = System.currentTimeMillis();
        logger.info("################/produce/producePlan/rebackCancelProducePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除生产计划
     * @author 陈刚
     * @date 2020-02-26
     * @throws Exception
     */
    @PostMapping("/produce/producePlan/deleteProducePlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteProducePlan() throws Exception {
        logger.info("################/produce/producePlan/deleteProducePlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("生产计划id为空或空字符串！");
            return model;
        }

        //删除生产计划明细子表
        Map columnMap = new HashMap();
        columnMap.put("plan_id", parentId);
        producePlanDetailChildService.deleteByColumnMap(columnMap);

        //删除生产计划明细表
        columnMap = new HashMap();
        columnMap.put("parent_id", parentId);
        producePlanDetailService.deleteByColumnMap(columnMap);

        //删除生产计划表
        producePlanService.deleteById(parentId);

        Long endTime = System.currentTimeMillis();
        logger.info("################/produce/producePlan/deleteProducePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改生产计划
     * @author 陈刚
     * @date 2020-02-26
     * @throws Exception
     */
    @PostMapping("/produce/producePlan/updateProducePlan")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateProducePlan() throws Exception {
        logger.info("################/produce/producePlan/updateProducePlan 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String cuser = pageData.getString("cuser");
        String planId = pageData.getString("planId");
        if (planId == null || planId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("生产计划id为空或空字符串！");
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

        List<Map<String, String>> jsonMapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (jsonMapList == null || jsonMapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("Json字符串-转换成List错误！");
            return model;
        }

        //1. 修改生产计划
        ProducePlan editPlan = new ProducePlan();
        editPlan.setId(planId);

        String sysDateStr = DateFormat.date2String(new Date(), DateFormat.DEFAULT_DATE_FORMAT);
        Date sysDate = DateFormat.dateString2Date(sysDateStr, DateFormat.DEFAULT_DATE_FORMAT);

        //遍历jsonMapList 获取(计划开始日期, 计划结束日期)
        Map<String, Date> valueDateMap = producePlanDetailService.findBeginEndDate(jsonMapList);
        //beginDate 计划开始日期
        Date beginDate = valueDateMap.get("beginDate");
        editPlan.setBeginDate(beginDate);

        //endDate 计划结束日期
        Date endDate = valueDateMap.get("endDate");
        editPlan.setEndDate(endDate);

        //produceType 生产类型
        String produceType = pageData.getString("produceType");
        editPlan.setProduceType(produceType);

        //makeId 制单人id
        String makeId = pageData.getString("makeId");
        editPlan.setMakeId(makeId);

        producePlanService.update(editPlan);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //生产计划明细修改: 先删除后添加方式

        //(plan_id:采购计划ID) 删除 vmes_produce_plan_detail_child:生产计划明细子表
        Map columnMap = new HashMap();
        columnMap.put("plan_id", planId);
        producePlanDetailChildService.deleteByColumnMap(columnMap);

        //(parent_id:采购计划ID) 删除 vmes_produce_plan_detail:生产计划明细
        columnMap.clear();
        columnMap.put("parent_id", planId);
        producePlanDetailService.deleteByColumnMap(columnMap);

        //界面添加行数据
        for (Map<String, String> mapObject : jsonMapList) {
            ProducePlanDetail addPlanDtl = new ProducePlanDetail();
            addPlanDtl.setParentId(editPlan.getId());
            addPlanDtl.setCuser(cuser);
            //状态 (0:待生产 1:生产中 2:已完成 -1:已取消)
            addPlanDtl.setState("0");

            Date beginDate_dtl = sysDate;
            String beginDate_dtl_Str = mapObject.get("beginDate");
            if (beginDate_dtl_Str != null && beginDate_dtl_Str.trim().length() > 0) {
                beginDate_dtl = DateFormat.dateString2Date(beginDate_dtl_Str, DateFormat.DEFAULT_DATE_FORMAT);
            }
            addPlanDtl.setBeginDate(beginDate_dtl);

            Date endDate_dtl = sysDate;
            String endDate_dtl_Str = mapObject.get("endDate");
            if (endDate_dtl_Str != null && endDate_dtl_Str.trim().length() > 0) {
                endDate_dtl = DateFormat.dateString2Date(endDate_dtl_Str, DateFormat.DEFAULT_DATE_FORMAT);
            }
            addPlanDtl.setEndDate(endDate_dtl);

            String productId = mapObject.get("productId");
            addPlanDtl.setProductId(productId);
            String unitId = mapObject.get("unitId");
            addPlanDtl.setUnitId(unitId);

            BigDecimal count = BigDecimal.valueOf(0D);
            String countStr = mapObject.get("count");
            if (countStr != null && countStr.trim().length() > 0) {
                try {
                    count = new BigDecimal(countStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            //四舍五入到2位小数
            count = count.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
            addPlanDtl.setCount(count);

            //生产明细-产品计划号
            String pd_code = coderuleService.createCoderCdateOnShortYearByDate(companyID,
                    "vmes_produce_plan_detail",
                    "PD",
                    Common.CODE_RULE_LENGTH_SHORTYEAR);
            addPlanDtl.setCode(pd_code);
            producePlanDetailService.save(addPlanDtl);

            //生产计划明细子表对象
            String jsonStr = mapObject.get("jsonStr");
            if (jsonStr == null || jsonStr.trim().length() == 0) {
                //界面没有点击(按货品合并)按钮

                ProducePlanDetailChild addDtlChile = new ProducePlanDetailChild();
                addDtlChile.setCuser(cuser);
                addDtlChile.setPlanId(editPlan.getId());
                addDtlChile.setPlanDtlId(addPlanDtl.getId());

                addDtlChile.setProductId(addPlanDtl.getProductId());
                addDtlChile.setUnitId(addPlanDtl.getUnitId());

                String orderDtlId = mapObject.get("orderDtlId");
                if (orderDtlId != null && orderDtlId.trim().length() > 0) {
                    addDtlChile.setSaleOrderDtlId(orderDtlId);
                }

                producePlanDetailChildService.save(addDtlChile);
            } else if (jsonStr != null && jsonStr.trim().length() > 0) {
                //界面点击(按货品合并)按钮
                List<Map<String, String>> childMapList = (List<Map<String, String>>) YvanUtil.jsonToList(jsonStr);
                if (childMapList != null && childMapList.size() > 0) {
                    for (Map<String, String> childMap : childMapList) {
                        ProducePlanDetailChild addDtlChile = new ProducePlanDetailChild();
                        addDtlChile.setCuser(cuser);
                        addDtlChile.setPlanId(editPlan.getId());
                        addDtlChile.setPlanDtlId(addPlanDtl.getId());

                        addDtlChile.setProductId(addPlanDtl.getProductId());
                        addDtlChile.setUnitId(addPlanDtl.getUnitId());

                        //orderDtlId 销售订单明细id
                        String orderDtlId = childMap.get("orderDtlId");
                        addDtlChile.setSaleOrderDtlId(orderDtlId);

                        producePlanDetailChildService.save(addDtlChile);
                    }
                }
            }
        }

//        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //界面修改行数据
//        List<Map<String, String>> editMapList = valueMap.get("editList");
//        for (Map<String, String> mapObject : editMapList) {
//            //planDtlId 生产计划明细id
//            String planDtlId = mapObject.get("planDtlId");
//
//            BigDecimal count = BigDecimal.valueOf(0D);
//            String countStr = mapObject.get("count");
//            if (countStr != null && countStr.trim().length() > 0) {
//                try {
//                    count = new BigDecimal(countStr);
//                } catch (NumberFormatException e) {
//                    e.printStackTrace();
//                }
//            }
//            //四舍五入到2位小数
//            count = count.setScale(Common.SYS_NUMBER_FORMAT_DEFAULT, BigDecimal.ROUND_HALF_UP);
//
//            ProducePlanDetail editPlanDtl = new ProducePlanDetail();
//            editPlanDtl.setId(planDtlId);
//            editPlanDtl.setCount(count);
//
//            Date beginDate_dtl = sysDate;
//            String beginDate_dtl_Str = mapObject.get("beginDate");
//            if (beginDate_dtl_Str != null && beginDate_dtl_Str.trim().length() > 0) {
//                beginDate_dtl = DateFormat.dateString2Date(beginDate_dtl_Str, DateFormat.DEFAULT_DATE_FORMAT);
//            }
//            editPlanDtl.setBeginDate(beginDate_dtl);
//
//            Date endDate_dtl = sysDate;
//            String endDate_dtl_Str = mapObject.get("endDate");
//            if (endDate_dtl_Str != null && endDate_dtl_Str.trim().length() > 0) {
//                endDate_dtl = DateFormat.dateString2Date(endDate_dtl_Str, DateFormat.DEFAULT_DATE_FORMAT);
//            }
//            editPlanDtl.setEndDate(endDate_dtl);
//
//            producePlanDetailService.update(editPlanDtl);
//
//            //生产计划明细子表对象
//            String jsonStr = mapObject.get("jsonStr");
//            if (jsonStr != null && jsonStr.trim().length() > 0) {
//                Map columnMap = new HashMap();
//                columnMap.put("plan_dtl_id", planDtlId);
//                producePlanDetailChildService.deleteByColumnMap(columnMap);
//
//                //界面点击(按货品合并)按钮
//                List<Map<String, String>> childMapList = (List<Map<String, String>>) YvanUtil.jsonToList(jsonStr);
//                if (childMapList != null && childMapList.size() > 0) {
//                    for (Map<String, String> childMap : childMapList) {
//                        ProducePlanDetailChild addDtlChile = new ProducePlanDetailChild();
//                        addDtlChile.setCuser(cuser);
//                        addDtlChile.setPlanId(editPlan.getId());
//                        addDtlChile.setPlanDtlId(editPlanDtl.getId());
//
//                        addDtlChile.setProductId(editPlanDtl.getProductId());
//                        addDtlChile.setUnitId(editPlanDtl.getUnitId());
//
//                        //orderDtlId 销售订单明细id
//                        String orderDtlId = childMap.get("orderDtlId");
//                        addDtlChile.setSaleOrderDtlId(orderDtlId);
//
//                        producePlanDetailChildService.save(addDtlChile);
//                    }
//                }
//            }
//        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/produce/producePlan/updateProducePlan 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    private Map<String, List<Map<String, String>>> findAddEditMap(List<Map<String, String>> jsonMapList) {
//        Map<String, List<Map<String, String>>> valueMap = new HashMap<>();
//
//        List<Map<String, String>> addMapList = new ArrayList<>();
//        List<Map<String, String>> editMapList = new ArrayList<>();
//        //遍历 jsonMapList 添加生产计划明细
//        if (jsonMapList != null && jsonMapList.size() > 0) {
//            for (Map<String, String> mapObject : jsonMapList) {
//                //operType 操作类型(add:添加, edit:修改)
//                String operType = mapObject.get("operType");
//
//                if ("add".equals(operType)) {
//                    addMapList.add(mapObject);
//                } else if ("edit".equals(operType)) {
//                    editMapList.add(mapObject);
//                }
//            }
//        }
//
//        valueMap.put("addList", addMapList);
//        valueMap.put("editList", editMapList);
//        return valueMap;
//    }
}

