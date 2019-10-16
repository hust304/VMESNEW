package com.xy.vmes.deecoop.warehouse.controller;

import com.xy.vmes.entity.WarehouseInitial;
import com.xy.vmes.service.WarehouseInitialBySimpleService;
import com.xy.vmes.service.WarehouseInitialService;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 说明：(简版)仓库初始化设定Controller
 * @author 陈刚 自动生成
 * @date 2018-11-20
 */
@RestController
@Slf4j
public class WarehouseInitialBySimpleController {
    private Logger logger = LoggerFactory.getLogger(WarehouseInitialBySimpleController.class);

    @Autowired
    private WarehouseInitialService warehouseInitialService;
    @Autowired
    private WarehouseInitialBySimpleService warehouseInitialBySimpleService;

    //仓库初始化(简版仓库)
    @PostMapping("/warehouse/warehouseInitialBySimple/findWarehouseInitialBySimple")
    public ResultModel findWarehouseInitialBySimple() throws Exception {
        logger.info("################/warehouse/warehouseInitialBySimple/findWarehouseInitialBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        ResultModel model = warehouseInitialBySimpleService.findWarehouseInitialBySimple(pd);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseInitialBySimple/findWarehouseInitialBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/warehouse/warehouseInitialBySimple/deleteWarehouseProductBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseProductBySimple() throws Exception {
        logger.info("################/warehouse/warehouseInitialBySimple/deleteWarehouseProductBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInitialBySimpleService.deleteWarehouseProductBySimple(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseInitialBySimple/deleteWarehouseProductBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    @PostMapping("/warehouse/warehouseInitialBySimple/updateWarehouseProductBySimple")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseProductBySimple() throws Exception {
        logger.info("################/warehouse/warehouseInitialBySimple/updateWarehouseProductBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInitialBySimpleService.updateWarehouseProductBySimple(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseInitialBySimple/updateWarehouseProductBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * (简版仓库)仓库货品Excel导入
     *
     * @author 陈刚
     * @date 2019-09-25
     */
    @PostMapping("/warehouse/warehouseInitialBySimple/importExcelWarehouseInitialBySimple")
    public ResultModel importExcelWarehouseInitialBySimple(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################/warehouse/warehouseInitialBySimple/importExcelWarehouseInitialBySimple 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        HttpServletRequest httpRequest = HttpUtils.currentRequest();

        String userId = httpRequest.getParameter("userId");
        String companyId = httpRequest.getParameter("companyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        //初始化仓库属性
        //warehouse:(简版,复杂版)仓库 spare:备件库
        String warehouseGenre = "warehouse";

        //(企业id)查询 vmes_warehouse_initial
        model = warehouseInitialBySimpleService.importExcelWarehouseInitialBySimple(file);
        if (model != null && model.get("code") != null && 0 == ((Integer)model.get("code")).intValue()) {
            PageData findMap = new PageData();
            findMap.put("companyId", companyId);
            findMap.put("warehouseAttribute", warehouseGenre);
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            WarehouseInitial warehouseInitial = warehouseInitialService.findWarehouseInitial(findMap);

            //是否禁用按钮(0:已禁用 1:启用) (0和1字符串,初始化按钮,导入按钮,禁用初始化按钮)
            //0和1字符串 第一位:初始化按钮 第二位:导入按钮 第三位:禁用初始化按钮
            String isDisableButton = "111";

            if (warehouseInitial == null) {
                WarehouseInitial addObject = new WarehouseInitial();
                addObject.setCuser(userId);
                addObject.setCompanyId(companyId);
                addObject.setIsDisableButton(isDisableButton);
                //warehouseAttribute 仓库属性(warehouse:(简版,复杂版)仓库 spare:备件库)
                addObject.setWarehouseAttribute(warehouseGenre);
                warehouseInitialService.save(addObject);
            } else if (warehouseInitial != null) {
                warehouseInitial.setIsDisableButton(isDisableButton);
                warehouseInitialService.update(warehouseInitial);
            }
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseInitialBySimple/importExcelWarehouseInitialBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }
}
