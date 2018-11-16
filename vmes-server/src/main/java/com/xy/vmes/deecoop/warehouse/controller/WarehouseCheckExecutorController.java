package com.xy.vmes.deecoop.warehouse.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.xy.vmes.common.util.ColumnUtil;
import com.xy.vmes.common.util.StringUtil;
import com.xy.vmes.entity.Column;
import com.xy.vmes.entity.WarehouseCheckDetail;
import com.xy.vmes.entity.WarehouseCheckExecutor;
import com.xy.vmes.service.ColumnService;
import com.xy.vmes.service.WarehouseCheckDetailService;
import com.xy.vmes.service.WarehouseCheckExecutorService;
import com.yvan.ExcelUtil;
import com.yvan.HttpUtils;
import com.yvan.PageData;
import com.yvan.YvanUtil;
import com.yvan.platform.RestException;
import com.yvan.springmvc.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.*;



/**
* 说明：vmes_warehouse_check_executor:库存盘点明细执行人Controller
* @author 陈刚 自动生成
* @date 2018-11-15
*/
@RestController
@Slf4j
public class WarehouseCheckExecutorController {

    private Logger logger = LoggerFactory.getLogger(WarehouseCheckExecutorController.class);

    @Autowired
    private WarehouseCheckDetailService warehouseCheckDetailService;
    @Autowired
    private WarehouseCheckExecutorService warehouseCheckExecutorService;

    @Autowired
    private ColumnService columnService;

    /**
     * 获取盘点执行列表-(添加盘点执行对话框)
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouseCheckExecutor/findListByWarehouseCheckExecutor")
    public ResultModel findListByWarehouseCheckExecutor() throws Exception {
        logger.info("################warehouseCheckExecutor/findListByWarehouseCheckExecutor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        List<Column> columnList = columnService.findColumnList("warehouseCheckExecutorByAddExecute");
        if (columnList == null || columnList.size() == 0) {
            model.putCode("1");
            model.putMsg("数据库没有生成TabCol，请联系管理员！");
            return model;
        }

        //获取指定栏位字符串-重新调整List<Column>
        PageData pd = HttpUtils.parsePageData();
        String fieldCode = pd.getString("fieldCode");
        if (fieldCode != null && fieldCode.trim().length() > 0) {
            columnList = columnService.modifyColumnByFieldCode(fieldCode, columnList);
        }

        List<LinkedHashMap> titlesList = new ArrayList<LinkedHashMap>();
        List<String> titlesHideList = new ArrayList<String>();
        Map<String, String> varModelMap = new HashMap<String, String>();
        if (columnList != null && columnList.size() > 0) {
            for (Column column : columnList) {
                if (column != null) {
                    if ("0".equals(column.getIshide())) {
                        titlesHideList.add(column.getTitleKey());
                    }
                    LinkedHashMap titlesLinkedMap = new LinkedHashMap();
                    titlesLinkedMap.put(column.getTitleKey(),column.getTitleName());
                    varModelMap.put(column.getTitleKey(),"");
                    titlesList.add(titlesLinkedMap);
                }
            }
        }
        Map result = new HashMap();
        result.put("hideTitles",titlesHideList);
        result.put("titles",titlesList);

        pd.put("orderStr", "executor.cdate asc");
        String orderStr = pd.getString("orderStr");
        if (orderStr != null && orderStr.trim().length() > 0) {
            pd.put("orderStr", orderStr);
        }

        Pagination pg = HttpUtils.parsePagination(pd);
        List<Map> varMapList = new ArrayList();
        List<Map> varList = warehouseCheckExecutorService.findListWarehouseCheckExecutorByAddExecute(pd, pg);
        if (varList != null && varList.size() > 0) {
            for (int i = 0; i < varList.size(); i++) {
                Map map = varList.get(i);
                Map<String, String> varMap = new HashMap<String, String>();
                varMap.putAll(varModelMap);
                for (Map.Entry<String, String> entry : varMap.entrySet()) {
                    varMap.put(entry.getKey(), map.get(entry.getKey()) != null ? map.get(entry.getKey()).toString() : "");
                }
                varMapList.add(varMap);
            }
        }
        result.put("varList",varMapList);
        result.put("pageData", pg);

        model.putResult(result);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseCheckExecutor/findListByWarehouseCheckExecutor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

    /**
     * 添加盘点明细执行人 (盘点派单)
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouseCheckExecutor/addWarehouseCheckExecutor")
    @Transactional
    public ResultModel addWarehouseCheckExecutor() throws Exception {
        logger.info("################/warehouseCheckExecutor/addWarehouseCheckExecutor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String executeId = pageData.getString("executeId");
        if (executeId == null || executeId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("执行人id为空或空字符串！");
            return model;
        }

        String dtlJsonStr = pageData.getString("dtlJsonStr");
        //测试代码-真实环境无此代码
        //dtlJsonStr = "[{\"id\":\"6d1e4503db6f46bcb22249b29abd4e27\"},{\"id\":\"824cdac10bb54c7aa62441e55696597e\"}]";
        if (dtlJsonStr == null || dtlJsonStr.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请至少选择一行数据！");
            return model;
        }

        List<Map<String, String>> mapList = (List<Map<String, String>>) YvanUtil.jsonToList(dtlJsonStr);
        if (mapList == null || mapList.size() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点明细Json字符串-转换成List错误！");
            return model;
        }

        //1. 入库单明细派单
        List<WarehouseCheckDetail> detailList = warehouseCheckDetailService.mapList2DetailList(mapList, null);

        String cuser = pageData.getString("cuser");
        for (WarehouseCheckDetail detail : detailList) {
            detail.setCuser(cuser);

            //盘点明细分配执行人
            warehouseCheckExecutorService.addWarehouseCheckExecutor(detail, executeId);

            //状态(0:待派单 1:执行中 2:审核中 3:已完成 -1:已取消)
            detail.setState("1");
            warehouseCheckDetailService.update(detail);
        }

        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheckExecutor/addWarehouseCheckExecutor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
     * (退单)退回盘点明细执行
     * @author 陈刚
     * @date 2018-10-18
     * @throws Exception
     */
    @PostMapping("/warehouseCheckExecutor/rebackWarehouseCheckExecutor")
    @Transactional
    public ResultModel rebackWarehouseCheckExecutor() throws Exception {
        logger.info("################/warehouseCheckExecutor/rebackWarehouseCheckExecutor 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();

        PageData pageData = HttpUtils.parsePageData();
        String cuser = pageData.getString("cuser");
        String companyId = pageData.getString("currentCompanyId");

        String detailId = pageData.getString("detailId");
        if (detailId == null || detailId.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("盘点明细id为空或空字符串！");
            return model;
        }

        String remark = pageData.getString("remark");
        if (remark == null || remark.trim().length() == 0) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("退单原因为空或空字符串，退单原因为必填不可为空！");
            return model;
        }




        Long endTime = System.currentTimeMillis();
        logger.info("################/warehouseCheckExecutor/rebackWarehouseCheckExecutor 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }


    /**
    * Excel导出
    * @author 陈刚 自动创建，可以修改
    * @date 2018-11-15
    */
    @PostMapping("/warehouseCheckExecutor/exportExcelWarehouseCheckExecutors")
    public void exportExcelWarehouseCheckExecutors() throws Exception {
        logger.info("################warehouseCheckExecutor/exportExcelWarehouseCheckExecutors 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();

        List<Column> columnList = columnService.findColumnList("warehouseCheckExecutor");
        if (columnList == null || columnList.size() == 0) {
            throw new RestException("1","数据库没有生成TabCol，请联系管理员！");
        }

        //根据查询条件获取业务数据List
        PageData pd = HttpUtils.parsePageData();
        String ids = (String)pd.getString("ids");
        String queryStr = "";
        if (ids != null && ids.trim().length() > 0) {
            ids = StringUtil.stringTrimSpace(ids);
            ids = "'" + ids.replace(",", "','") + "'";
            queryStr = "id in (" + ids + ")";
        }
        pd.put("queryStr", queryStr);

        Pagination pg = HttpUtils.parsePagination(pd);
        pg.setSize(100000);
        List<Map> dataList = warehouseCheckExecutorService.getDataListPage(pd, pg);

        //查询数据转换成Excel导出数据
        List<LinkedHashMap<String, String>> dataMapList = ColumnUtil.modifyDataList(columnList, dataList);
        HttpServletResponse response = HttpUtils.currentResponse();

        //查询数据-Excel文件导出
        String fileName = pd.getString("fileName");
        if (fileName == null || fileName.trim().length() == 0) {
            fileName = "ExcelWarehouseCheckExecutor";
        }

        //导出文件名-中文转码
        fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
        ExcelUtil.excelExportByDataList(response, fileName, dataMapList);
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseCheckExecutor/exportExcelWarehouseCheckExecutors 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
    }

    /**
    * Excel导入
    *
    * @author 陈刚 自动创建，可以修改
    * @date 2018-11-15
    */
    @PostMapping("/warehouseCheckExecutor/importExcelWarehouseCheckExecutors")
    public ResultModel importExcelWarehouseCheckExecutors(@RequestParam(value="excelFile") MultipartFile file) throws Exception  {
        logger.info("################warehouseCheckExecutor/importExcelWarehouseCheckExecutors 执行开始 ################# ");
        Long startTime = System.currentTimeMillis();
        ResultModel model = new ResultModel();
        //HttpServletRequest Request = HttpUtils.currentRequest();

        if (file == null) {
            model.putCode(Integer.valueOf(1));
            model.putMsg("请上传Excel文件！");
            return model;
        }

        // 验证文件是否合法
        // 获取上传的文件名(文件名.后缀)
        String fileName = file.getOriginalFilename();
        if (fileName == null
            || !(fileName.matches("^.+\\.(?i)(xlsx)$")
            || fileName.matches("^.+\\.(?i)(xls)$"))
        ) {
            String failMesg = "不是excel格式文件,请重新选择！";
            model.putCode(Integer.valueOf(1));
            model.putMsg(failMesg);
            return model;
        }

        // 判断文件的类型，是2003还是2007
        boolean isExcel2003 = true;
            if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }

        List<List<String>> dataLst = ExcelUtil.readExcel(file.getInputStream(), isExcel2003);
        List<LinkedHashMap<String, String>> dataMapLst = ExcelUtil.reflectMapList(dataLst);

        //1. Excel文件数据dataMapLst -->(转换) ExcelEntity (属性为导入模板字段)
        //2. Excel导入字段(非空,数据有效性验证[数字类型,字典表(大小)类是否匹配])
        //3. Excel导入字段-名称唯一性判断-在Excel文件中
        //4. Excel导入字段-名称唯一性判断-在业务表中判断
        //5. List<ExcelEntity> --> (转换) List<业务表DB>对象
        //6. 遍历List<业务表DB> 对业务表添加或修改
        Long endTime = System.currentTimeMillis();
        logger.info("################warehouseCheckExecutor/importExcelWarehouseCheckExecutors 执行结束 总耗时"+(endTime-startTime)+"ms ################# ");
        return model;
    }

//    private List<Map> findSecondList(Map firstRowMap, Map<String, Object> secondTitleMap, String companyId) throws Exception {
//        String productId = (String)firstRowMap.get("productId");
//        String warehouseId = (String)firstRowMap.get("warehouseId");
//        String detailId = (String)firstRowMap.get("id");
//
//        PageData findMap = new PageData();
//        findMap.put("detailId", detailId);
//        findMap.put("productId", productId);
//        findMap.put("warehouseId", warehouseId);
//        findMap.put("companyId", companyId);
//
//        List<Map> secondMapList = new ArrayList();
//        List<Map> varList = warehouseCheckExecutorService.findListWarehouseCheckExecutorByAddExecute(findMap);
//        if(varList != null && varList.size() > 0) {
//            for(int i = 0; i < varList.size(); i++) {
//                Map map = varList.get(i);
//                Map<String, String> varMap = new HashMap<String, String>();
//                varMap.putAll((Map<String, String>)secondTitleMap.get("varModel"));
//                for (Map.Entry<String, String> entry : varMap.entrySet()) {
//                    varMap.put(entry.getKey(), map.get(entry.getKey()) != null ? map.get(entry.getKey()).toString() : "");
//                }
//                varMap.put("pid",firstRowMap.get("id").toString());
//                secondMapList.add(varMap);
//
//            }
//        }
//
//        return secondMapList;
//    }

}



