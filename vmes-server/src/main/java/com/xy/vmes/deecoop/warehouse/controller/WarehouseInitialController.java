package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.WarehouseInitial;
import com.xy.vmes.service.*;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：vmes_warehouse_initial:仓库初始化设定Controller
 * @author 陈刚 自动生成
 * @date 2018-11-20
 */
@RestController
@Slf4j
public class WarehouseInitialController {
    private Logger logger = LoggerFactory.getLogger(WarehouseInitialController.class);

    @Autowired
    private WarehouseInitialService warehouseInitialService;
    @Autowired
    private WarehouseToWarehouseProductService warehouseToWarehouseProductService;

    @Autowired
    private ColumnService columnService;

    /**
    * @author 陈刚 自动创建，可以修改
    * @date 2018-11-20
    */
    @PostMapping("/warehouse/warehouseInitial/listPageWarehouseInitial")
    public ResultModel listPageWarehouseInitial()  throws Exception {
        logger.info("################warehouseInitial/listPageWarehouseInitial 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);

        ResultModel model = warehouseInitialService.listPageWarehouseInitial(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseInitial/listPageWarehouseInitial 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 获取是否禁用按钮(0:已禁用 1:启用)
     * 0和1字符串 第一位:初始化按钮 第二位:导入按钮 第三位:禁用初始化按钮
     *
     * @author 陈刚
     * @date 2019-08-09
     */
    @PostMapping("/warehouse/warehouseInitial/findIsDisableButton")
    public ResultModel findIsDisableButton() throws Exception {
        logger.info("################/warehouse/warehouseInitial/findIsDisableButton 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();
        String companyId = pageData.getString("companyId");

        //默认值(011) := 初始化按钮(禁用),导入按钮(启用),禁用初始化按钮(启用)
        String isDisableButton = new String("011");
        WarehouseInitial warehouseInitial = null;
        try {
            PageData findMap = new PageData();
            findMap.put("companyId", companyId);
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            warehouseInitial = warehouseInitialService.findWarehouseInitial(findMap);
            if (warehouseInitial != null
                && warehouseInitial.getIsDisableButton() != null
                && warehouseInitial.getIsDisableButton().trim().length() > 0
            ) {
                isDisableButton = warehouseInitial.getIsDisableButton().trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.put("isDisableButton", isDisableButton);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseInitial/findIsDisableButton 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

//    //仓库初始化(简版仓库)
//    @PostMapping("/warehouse/warehouseInitial/findWarehouseInitialBySimple")
//    public ResultModel findWarehouseInitialBySimple() throws Exception {
//        logger.info("################/warehouse/warehouseInitial/findWarehouseInitialBySimple 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//
//        ResultModel model = new ResultModel();
//        PageData pd = HttpUtils.parsePageData();
//
//        List<Column> columnList = columnService.findColumnList("warehouseInitialBySimple");
//        if (columnList == null || columnList.size() == 0) {
//            model.putCode("1");
//            model.putMsg("数据库没有生成TabCol，请联系管理员！");
//            return model;
//        }
//
//        //获取指定栏位字符串-重新调整List<Column>
//        String fieldCode = pd.getString("fieldCode");
//        if (fieldCode != null && fieldCode.trim().length() > 0) {
//            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
//        }
//
//        String productIds = new String();
//        if (pd.getString("productIds") != null && pd.getString("productIds").trim().length() > 0) {
//            productIds = pd.getString("productIds").trim();
//            productIds = StringUtil.stringTrimSpace(productIds);
//            productIds = "'" + productIds.replace(",", "','") + "'";
//        }
//        pd.put("productIds", productIds);
//
//        //是否需要分页 true:需要分页 false:不需要分页
//        Map result = new HashMap();
//        String isNeedPage = pd.getString("isNeedPage");
//        if ("true".equals(isNeedPage)) {
//            result.put("pageData", HttpUtils.parsePagination(pd));
//        }
//
//        List<Map> varList = warehouseInitialService.findWarehouseInitialBySimple(pd);
//        Map<String, Object> titleMap = ColumnUtil.findTitleMapByColumnList(columnList);
//        List<Map> varMapList = ColumnUtil.getVarMapList(varList,titleMap);
//
//        result.put("hideTitles", titleMap.get("hideTitles"));
//        result.put("titles",titleMap.get("titles"));
//        result.put("varList", varMapList);
//
//        model.putResult(result);
//
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/warehouse/warehouseInitial/findWarehouseInitialBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

    /**
     * 初始化仓库
     *
     * @author 陈刚
     * @date 2018-11-20
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInitial/initialWarehouse")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel initialWarehouse() throws Exception {
        logger.info("################/warehouseInitial/initialWarehouse 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInitialService.initialWarehouse(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInitial/initialWarehouse 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 禁用初始化按钮
     *
     * @author 陈刚
     * @date 2018-08-09
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInitial/disableWarehouseInitial")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel disableWarehouseInitial() throws Exception {
        logger.info("################/warehouse/warehouseInitial/disableWarehouseInitial 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        ResultModel model = new ResultModel();
        PageData pageData = HttpUtils.parsePageData();

        String companyId = pageData.getString("currentCompanyId");
        if (companyId == null || companyId.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("企业id为空或空字符串！");
            return model;
        }

        //初始化仓库属性
        //warehouse:(简版,复杂版)仓库 spare:备件库
        String warehouseGenre = pageData.getString("warehouseGenre");
        if (warehouseGenre == null || warehouseGenre.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("初始化仓库属性为空或空字符串！");
            return model;
        }

        String userId = pageData.getString("cuser");

        //(企业id)查询 vmes_warehouse_initial
        WarehouseInitial warehouseInitial = null;
        try {
            PageData findMap = new PageData();
            findMap.put("companyId", companyId);
            findMap.put("warehouseAttribute", warehouseGenre);
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            warehouseInitial = warehouseInitialService.findWarehouseInitial(findMap);

            //是否禁用按钮(0:已禁用 1:启用) (0和1字符串,初始化按钮,导入按钮,禁用初始化按钮)
            //0和1字符串 第一位:初始化按钮 第二位:导入按钮 第三位:禁用初始化按钮
            String isDisableButton = "000";

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

        } catch (Exception e) {
            e.printStackTrace();
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseInitial/disableWarehouseInitial 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 修改仓库货品(库存数量)
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInitial/updateWarehouseProduct")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel updateWarehouseProduct() throws Exception {
        logger.info("################/warehouseInitial/updateWarehouseProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInitialService.updateWarehouseProduct(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInitial/updateWarehouseProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 删除仓库货品(删除库存记录)
     * @author 陈刚
     * @date 2018-10-16
     * @throws Exception
     */
    @PostMapping("/warehouse/warehouseInitial/deleteWarehouseProduct")
    @Transactional(rollbackFor=Exception.class)
    public ResultModel deleteWarehouseProduct() throws Exception {
        logger.info("################/warehouseInitial/deleteWarehouseProduct 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pageData = HttpUtils.parsePageData();
        ResultModel model = warehouseInitialService.deleteWarehouseProduct(pageData);
        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseInitial/deleteWarehouseProduct 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

//    @PostMapping("/warehouse/warehouseInitial/deleteWarehouseProductBySimple")
//    @Transactional(rollbackFor=Exception.class)
//    public ResultModel deleteWarehouseProductBySimple() throws Exception {
//        logger.info("################/warehouse/warehouseInitial/deleteWarehouseProductBySimple 执行开始 ################# ");
//        Long startTime = System.currentTimeMillis();
//        PageData pageData = HttpUtils.parsePageData();
//        ResultModel model = warehouseInitialService.deleteWarehouseProductBySimple(pageData);
//        Long endTime = System.currentTimeMillis();
//        logger.info("################/warehouse/warehouseInitial/deleteWarehouseProductBySimple 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
//        return model;
//    }

    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2018-11-20
    */
    @PostMapping("/warehouse/warehouseInitial/exportExcelWarehouseInitial")
    public void exportExcelWarehouseInitial() throws Exception {
        logger.info("################warehouseInitial/exportExcelWarehouseInitial 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();
        Pagination pg = HttpUtils.parsePagination(pd);
        warehouseInitialService.exportExcelWarehouseInitial(pd,pg);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseInitial/exportExcelWarehouseInitial 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    @PostMapping("/warehouse/warehouseInitial/exportExcelTemplateWarehouseInitial")
    public void exportExcelTemplateWarehouseInitial() throws Exception {
        logger.info("################/warehouse/warehouseInitial/exportExcelTemplateWarehouseInitial 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        PageData pd = HttpUtils.parsePageData();

        List<Column> columnList = columnService.findColumnList("warehouseToWarehouseProduct");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //获取指定栏位字符串-重新调整List<Column>
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }

        if (pd.getString("currentCompanyId") != null) {
            pd.put("companyId", pd.getString("currentCompanyId").trim());
        }

        List<Map> dataList = new ArrayList<Map>();
        try {
            dataList = warehouseToWarehouseProductService.findMapListWarehouseToWarehouseProduct(pd);
            if (dataList != null && dataList.size() > 0) {
                for (Map<String, Object> mapObject : dataList) {
                    mapObject.put("productCode", "");
                    mapObject.put("productName", "");
                    mapObject.put("productSpec", "");
                    mapObject.put("productGenreName", "");
                    mapObject.put("productUnitName", "");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelWarehouseInitial";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouse/warehouseInitial/exportExcelTemplateWarehouseInitial 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2018-11-20
    */
    @PostMapping("/warehouse/warehouseInitial/importExcelWarehouseInitial")
    public ResultModel importExcelWarehouseInitial(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################warehouseInitial/importExcelWarehouseInitial 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        HttpServletRequest httpRequest = HttpUtils.currentRequest();
        String companyId = (String)httpRequest.getParameter("companyId");
        String userId = (String)httpRequest.getParameter("userId");

        //初始化仓库属性
        //warehouse:(简版,复杂版)仓库 spare:备件库
        String warehouseGenre = (String)httpRequest.getParameter("warehouseGenre");
        if (warehouseGenre == null || warehouseGenre.trim().length() == 0) {
            model.putCode("1");
            model.putMsg("初始化仓库属性为空或空字符串！");
            return model;
        }

        //(企业id)查询 vmes_warehouse_initial
        WarehouseInitial warehouseInitial = null;
        try {
            model = warehouseInitialService.importExcelWarehouseInitial(file);

            PageData findMap = new PageData();
            findMap.put("companyId", companyId);
            findMap.put("mapSize", Integer.valueOf(findMap.size()));
            warehouseInitial = warehouseInitialService.findWarehouseInitial(findMap);

            //是否禁用按钮(0:已禁用 1:启用) (0和1字符串,初始化按钮,导入按钮,禁用初始化按钮)
            //0和1字符串 第一位:初始化按钮 第二位:导入按钮 第三位:禁用初始化按钮
            String isDisableButton = "101";

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

        } catch (Exception e) {
            e.printStackTrace();
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseInitial/importExcelWarehouseInitial 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

}



