package com.xy.vmes.deecoop.mobile.controller;

import com.xy.vmes.entity.TreeEntity;
import com.xy.vmes.entity.Warehouse;
import com.xy.vmes.service.WarehouseService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 说明：(手机端)vmes_warehouse:仓库货位表Controller
 */
@RestController
@Slf4j
public class MobileWarehouseController {
    private Logger logger = LoggerFactory.getLogger(MobileWarehouseController.class);

    @Autowired
    private WarehouseService warehouseService;

    /**
     * (手机端)获取仓库货位下拉框
     * 获取第一层下拉List(界面第一层)
     * pid(实体库,虚拟库)-下面所有List
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/mobile/warehouseBase/findWarehouseNode")
    public ResultModel findWarehouseNode() throws Exception {
        logger.info("################/mobile/warehouseBase/findWarehouseNode 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("企业id为空或空字符串");
            return model;
        }

        String pid = pageData.getString("pid");
        if (pid == null || pid.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("pid为空或空字符串");
            return model;
        }

        int layer_int = 0;
        String layer = pageData.getString("layer");
        if (layer == null || layer.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("layer为空或空字符串");
            return model;
        } else {
            try {
                layer_int = Integer.valueOf(layer).intValue();
            } catch (NumberFormatException numberExc) {
                model.putCode(Integer.valueOf(1));
                model.putMsg("layer(" + layer + ")错误，layer必须是正整数！");
                return model;
            }
        }

        PageData findMap = new PageData();
        findMap.put("companyId", companyId);
        findMap.put("pid", pid);
        //是否启用(0:已禁用 1:启用)
        findMap.put("isdisable", "1");
        findMap.put("mapSize", Integer.valueOf(findMap.size()));
        findMap.put("orderStr", "serial_number asc");

        List<Warehouse> objectList = warehouseService.findWarehouseList(findMap);
        List<TreeEntity> treeList = warehouseService.warehouseList2TreeList(objectList, null);

        TreeEntity nodeObject = new TreeEntity();
        nodeObject.setName(Integer.valueOf(layer_int-1).toString() + "级货位");
        nodeObject.setChildren(treeList);

        String nodeJsonStr = YvanUtil.toJson(nodeObject);
        System.out.println("nodeJsonStr: " + nodeJsonStr);

        model.putResult(nodeObject);

        Long endTime = System.currentTimeMillis();
        logger.info("################/mobile/warehouseBase/findWarehouseNode 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}
