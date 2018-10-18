package com.xy.vmes.deecoop.warehouse.controller;

import com.xy.vmes.entity.WarehouseInDetail;
import com.xy.vmes.service.WarehouseInDetailService;
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

import java.util.List;
import java.util.Map;

/**
 * 说明：入库派单
 * @author 陈刚 自动生成
 * @date 2018-10-18
 */
@RestController
@Slf4j
public class WarehouseInDistributeController {
    private Logger logger = LoggerFactory.getLogger(WarehouseInDistributeController.class);

    //@Autowired
    //private WarehouseInService warehouseInService;
    @Autowired
    private WarehouseInDetailService warehouseInDetailService;

    /**
     * 入库派单
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouseInDistribute/warehouseInDistribute")
    @Transactional
    public ResultModel warehouseInDistribute() throws Exception {
        logger.info("################/warehouseInDistribute/warehouseInDistribute 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String parentId = pageData.getString("id");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单id为空或空字符串！");
            return model;
        }

        String executeId = pageData.getString("executeId");
        if (parentId == null || parentId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("执行人id为空或空字符串！");
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        //测试代码-真实环境无此代码
        //dtlJsonStr = "";

        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少添加选择一条货品数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("入库单明细Json字符串-转换成List错误！");
            return model;
        }

        //1. 入库单明细派单
        List<WarehouseInDetail> detailList = warehouseInDetailService.mapList2DetailList(mapList, null);
        if (detailList != null && detailList.size() > 0) {
            for (WarehouseInDetail detail : detailList) {
                //状态(0:待派单 1:执行中 2:已完成 -1.已取消)
                detail.setState("1");
                detail.setExecuteId(executeId);
                warehouseInDetailService.update(detail);
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInDistribute/warehouseInDistribute 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
