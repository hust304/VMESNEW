package com.xy.vmes.deecoop.warehouse.controller;

import com.xy.vmes.entity.WarehouseIn;
import com.xy.vmes.entity.WarehouseInDetail;
import com.xy.vmes.entity.WarehouseInExecute;
import com.xy.vmes.service.WarehouseInDetailService;
import com.xy.vmes.service.WarehouseInExecuteService;
import com.xy.vmes.service.WarehouseInService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 说明：入库派单明细执行
 * @author 陈刚 自动生成
 * @date 2018-10-18
 */
@RestController
@Slf4j
public class WarehouseInExecuteController {
    private Logger logger = LoggerFactory.getLogger(WarehouseInDistributeController.class);

    @Autowired
    private WarehouseInService warehouseInService;
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;
    @Autowired
    private WarehouseInExecuteService warehouseInExecuteService;

    /**
     * 新增入库单明细执行
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouseInExecute/addWarehouseInExecute")
    @Transactional
    public ResultModel addWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/addWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单id为空或空字符串！");
            return model;
        }

        String detailId = pageData.getString("detailId");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细id为空或空字符串！");
            return model;
        }

        String executeJsonStr = pageData.getString("executeJsonStr");
        //测试代码-真实环境无此代码
        //dtlJsonStr = "";

        if (executeJsonStr == null || executeJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少填写一条入库数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(executeJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细执行 Json字符串-转换成List错误！");
            return model;
        }

        String cuser = pageData.getString("cuser");

        //1. 添加入库单明细-入库执行
        List<WarehouseInExecute> executeList = warehouseInExecuteService.mapList2ExecuteList(mapList, null);
        for (WarehouseInExecute execute : executeList) {
            execute.setCuser(cuser);
            execute.setDetailId(detailId);
            warehouseInExecuteService.save(execute);
        }

        //2. 修改修改当前入库单明细状态--同时反写入库单状态
        List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(parentId);
        warehouseInDetailService.updateStateWarehouseInDetail(detailList);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInExecute/addWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (退单)取消入库单明细执行
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouseInExecute/updateCancelDetailWarehouseInExecute")
    @Transactional
    public ResultModel updateCancelDetailWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/updateCancelDetailWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String detailId = pageData.getString("detailId");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细id为空或空字符串！");
            return model;
        }

        String remark = pageData.getString("remark");
        if (remark == null || remark.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退单原因为空或空字符串，退单原因为必填不可为空！");
            return model;
        }

        //根据当前入库单id-获取当前入库单明细id-入库执行数量汇总
        WarehouseInDetail detail = warehouseInDetailService.findWarehouseInDetailById(detailId);
        Map<String, BigDecimal> mapExecute = warehouseInExecuteService.findExecuteCountByParentId(detail.getParentId());
        if (mapExecute != null && mapExecute.get(detailId) != null && mapExecute.get(detailId).doubleValue() != 0D) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库单明细正在执行中(部分货品已经入库)，不可退单操作！");
            return model;
        }

        //1. 修改入库明细状态
        detail.setRemark(remark);
        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)-- 退单状态:0:待派单
        detail.setState("0");
        warehouseInDetailService.update(detail);

//        //2. 反写入库单状态
//        List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(detail.getParentId());
//        //验证(明细)状态: 0:待派单 -- 判断明细中是否全部(0:待派单) -- 忽视状态:-1:已取消
//        if (warehouseInDetailService.checkStateByDetailList("0", "-1", detailList)) {
//            WarehouseIn warehouseIn = new WarehouseIn();
//            warehouseIn.setState("0");
//            warehouseInService.update(warehouseIn);
//        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInExecute/updateCancelDetailWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (退单)取消入库单执行
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouseInExecute/updateCancelWarehouseInExecute")
    @Transactional
    public ResultModel updateCancelWarehouseInExecute() throws Exception {
        logger.info("################/warehouseInExecute/updateCancelWarehouseInExecute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String parentId = pageData.getString("parentId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单id为空或空字符串！");
            return model;
        }

        String remark = pageData.getString("remark");
        if (remark == null || remark.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退单原因为空或空字符串，退单原因为必填不可为空！");
            return model;
        }

        //根据当前入库单id-获取当前入库单明细id-入库执行数量汇总
        Map<String, BigDecimal> mapExecute = warehouseInExecuteService.findExecuteCountByParentId(parentId);
        //判断当前入库单明细-货品是否部分入库
        List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(parentId);
        if (detailList != null && detailList.size() > 0) {
            for (WarehouseInDetail detail : detailList) {
                String dtl_id = detail.getId();
                if (mapExecute != null && mapExecute.get(dtl_id) != null && mapExecute.get(dtl_id).doubleValue() != 0D) {
                    model.putCode(Integer.valueOf(1));
                    model.putMsg("入库单明细货品已经部分入库，该入库单不可整单(退单)，请核对后再次操作！");
                    return model;
                }
            }
        }

        //1. 修改入库单明细状态
        PageData mapData = new PageData();
        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        mapData.put("state", "0");
        mapData.put("parentId", parentId);
        warehouseInDetailService.updateStateByDetail(mapData);

        //2.修改入库单状态
        WarehouseIn warehouseIn = new WarehouseIn();
        //状态(0:未完成 1:已完成 -1:已取消)
        warehouseIn.setState("0");
        warehouseIn.setRemark(remark);
        warehouseInService.update(warehouseIn);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInExecute/updateCancelWarehouseInExecute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
