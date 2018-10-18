package com.xy.vmes.deecoop.warehouse.controller;

import com.xy.vmes.entity.WarehouseIn;
import com.xy.vmes.entity.WarehouseInDetail;
import com.xy.vmes.service.WarehouseInDetailService;
import com.xy.vmes.service.WarehouseInService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class WarehouseInDetailController {
    private Logger logger = LoggerFactory.getLogger(WarehouseInDetailController.class);

    @Autowired
    private WarehouseInService warehouseInService;
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;

    /**
     * 取消入库单明细
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouseInDetail/updateDisableWarehouseInDetail")
    @Transactional
    public ResultModel updateDisableWarehouseInDetail() throws Exception {
        logger.info("################/warehouseInDetail/deleteWarehouseInDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细id为空或空字符串！");
            return model;
        }

        WarehouseInDetail detail = warehouseInDetailService.findWarehouseInDetailById(detailId);
        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if (detail.getState() != null && "1,2".indexOf(detail.getState().trim()) > -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库明细不可取消，该入库单明细状态(1:执行中 2:已完成)！");
            return model;
        }

        WarehouseIn warehouseIn = warehouseInService.findWarehouseInById(detail.getParentId());
        //状态(0:未完成 1:已完成 -1:已取消)
        if (warehouseIn != null && warehouseIn.getState() != null && "1".equals(warehouseIn.getState().trim())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库明细不可取消，该入库单已经(已完成)！");
            return model;
        }

        //1. 修改明细状态
        //明细状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        detail.setState("-1");
        warehouseInDetailService.update(detail);

        //2.返写入库单状态
        if (warehouseIn != null) {
            List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(detail.getParentId());

            //验证状态(0:待派单 1:执行中 2:已完成 -1:已取消)
            //判断明细是否(-1:已取消)--(验证是否允许取消)--忽视状态:-1:已取消
            if (warehouseInDetailService.checkStateByDetailList("-1", "-1", detailList)) {
                //状态(0:未完成 1:已完成 -1:已取消)
                warehouseIn.setState("-1");
            }

            warehouseInService.update(warehouseIn);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInDetail/deleteWarehouseInDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除入库单明细
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouseInDetail/deleteWarehouseInDetail")
    @Transactional
    public ResultModel deleteWarehouseInDetail() throws Exception {
        logger.info("################/warehouseInDetail/deleteWarehouseInDetail 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String detailId = pageData.getString("id");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细id为空或空字符串！");
            return model;
        }

        WarehouseInDetail detail = warehouseInDetailService.findWarehouseInDetailById(detailId);
        //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
        if (detail.getState() != null && "1,2".indexOf(detail.getState().trim()) > -1) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库明细不可删除，该入库单明细状态(1:执行中 2:已完成)！");
            return model;
        }

        WarehouseIn warehouseIn = warehouseInService.findWarehouseInById(detail.getParentId());
        //状态(0:未完成 1:已完成 -1:已取消)
        if (warehouseIn != null && warehouseIn.getState() != null && "1".equals(warehouseIn.getState().trim())) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("当前入库明细不可删除，该入库单已经(已完成)！");
            return model;
        }

        //1. 删除入库明细
        warehouseInDetailService.deleteById(detailId);

//        //2.返写入库单状态
//        if (warehouseIn != null) {
//            List<WarehouseInDetail> detailList = warehouseInDetailService.findWarehouseInDetailListByParentId(detail.getParentId());
//
//            //验证状态(0:待派单 1:执行中 2:已完成 -1:已取消)
//            //判断明细是否(2:已完成) -- 忽视状态(-1:已取消)
//            if (warehouseInDetailService.checkStateByDetailList("2", "-1", detailList)) {
//                //状态(0:未完成 1:已完成 -1:已取消)
//                warehouseIn.setState("1");
//            }
//
//            warehouseInService.update(warehouseIn);
//        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInDetail/deleteWarehouseInDetail 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
